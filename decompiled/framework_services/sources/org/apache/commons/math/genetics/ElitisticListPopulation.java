package org.apache.commons.math.genetics;

import java.util.Collections;
import java.util.List;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class ElitisticListPopulation extends ListPopulation {
    private double elitismRate;

    public ElitisticListPopulation(List<Chromosome> chromosomes, int populationLimit, double elitismRate) {
        super(chromosomes, populationLimit);
        this.elitismRate = 0.9d;
        this.elitismRate = elitismRate;
    }

    public ElitisticListPopulation(int populationLimit, double elitismRate) {
        super(populationLimit);
        this.elitismRate = 0.9d;
        this.elitismRate = elitismRate;
    }

    @Override // org.apache.commons.math.genetics.Population
    public Population nextGeneration() {
        ElitisticListPopulation nextGeneration = new ElitisticListPopulation(getPopulationLimit(), getElitismRate());
        List<Chromosome> oldChromosomes = getChromosomes();
        Collections.sort(oldChromosomes);
        int boundIndex = (int) FastMath.ceil((1.0d - getElitismRate()) * ((double) oldChromosomes.size()));
        int i = boundIndex;
    L4:
        if (i >= oldChromosomes.size()) goto L7;
        nextGeneration.addChromosome(oldChromosomes.get(i));
        i = i + 1;
        goto L4
    L7:
        return nextGeneration;
    }

    public void setElitismRate(double elitismRate) {
        if (elitismRate < 0.0d) goto L9;
        if (elitismRate > 1.0d) goto L9;
        this.elitismRate = elitismRate;
        return;
    L9:
        throw new IllegalArgumentException("Elitism rate has to be in [0,1]");
    }

    public double getElitismRate() {
        return this.elitismRate;
    }
}
