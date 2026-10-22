package org.apache.commons.math.genetics;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Chromosome implements Comparable<Chromosome>, Fitness {
    private double fitness;

    public Chromosome() {
        this.fitness = Double.MIN_VALUE;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Chromosome r1) {
        return compareTo2(r1);
    }

    public double getFitness() {
        if (this.fitness != Double.MIN_VALUE) goto L6;
        this.fitness = fitness();
    L6:
        return this.fitness;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Chromosome another) {
        return Double.valueOf(getFitness()).compareTo(Double.valueOf(another.getFitness()));
    }

    protected boolean isSame(Chromosome another) {
        return false;
    }

    protected Chromosome findSameChromosome(Population population) {
        Iterator<Chromosome> r0 = population.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Chromosome anotherChr = r0.next();
        if (isSame(anotherChr) == false) goto L4;
        return anotherChr;
    L9:
        return null;
    }

    public void searchForFitnessUpdate(Population population) {
        Chromosome sameChromosome = findSameChromosome(population);
        if (sameChromosome == null) goto L6;
        this.fitness = sameChromosome.getFitness();
        return;
    }
}
