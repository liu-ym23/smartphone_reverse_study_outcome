package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class OnePointCrossover<T> implements CrossoverPolicy {
    public OnePointCrossover() {
    }

    @Override // org.apache.commons.math.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome first, Chromosome second) {
        if ((first instanceof AbstractListChromosome) == false) goto L9;
        if ((second instanceof AbstractListChromosome) == false) goto L9;
        return crossover((AbstractListChromosome) first, (AbstractListChromosome) second);
    L9:
        throw new IllegalArgumentException("One point crossover works on FixedLengthChromosomes only.");
    }

    private ChromosomePair crossover(AbstractListChromosome<T> first, AbstractListChromosome<T> second) {
        int length = first.getLength();
        if (length != second.getLength()) goto L13;
        List<T> parent1Rep = first.getRepresentation();
        List<T> parent2Rep = second.getRepresentation();
        ArrayList<T> child1Rep = new ArrayList(first.getLength());
        ArrayList<T> child2Rep = new ArrayList(second.getLength());
        int crossoverIndex = GeneticAlgorithm.getRandomGenerator().nextInt(length - 2) + 1;
        int i = 0;
    L5:
        if (i >= crossoverIndex) goto L7;
        child1Rep.add(parent1Rep.get(i));
        child2Rep.add(parent2Rep.get(i));
        i = i + 1;
        goto L5
    L7:
        int i2 = crossoverIndex;
    L8:
        if (i2 >= length) goto L11;
        child1Rep.add(parent2Rep.get(i2));
        child2Rep.add(parent1Rep.get(i2));
        i2 = i2 + 1;
        goto L8
    L11:
        return new ChromosomePair(first.newFixedLengthChromosome(child1Rep), second.newFixedLengthChromosome(child2Rep));
    L13:
        throw new IllegalArgumentException("Both chromosomes must have same lengths.");
    }
}
