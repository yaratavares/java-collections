package main.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!this.itemList.isEmpty()) {

            for (Item i : this.itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }

            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double soma = 0d;

        for (Item i : this.itemList) {
            soma += i.getPreco() * i.getQuant();
        }

        return soma;
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Lápis");

        carrinhoDeCompras.exibirItens();

        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
