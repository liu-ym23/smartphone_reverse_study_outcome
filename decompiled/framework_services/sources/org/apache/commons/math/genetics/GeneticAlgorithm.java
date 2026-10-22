package org.apache.commons.math.genetics;

import org.apache.commons.math.random.JDKRandomGenerator;
import org.apache.commons.math.random.RandomGenerator;

/* JADX INFO: loaded from: classes3.dex */
public class GeneticAlgorithm {
    private static RandomGenerator randomGenerator;
    private final CrossoverPolicy crossoverPolicy;
    private final double crossoverRate;
    private int generationsEvolved;
    private final MutationPolicy mutationPolicy;
    private final double mutationRate;
    private final SelectionPolicy selectionPolicy;

    static {
        randomGenerator = new JDKRandomGenerator();
    }

    public GeneticAlgorithm(CrossoverPolicy crossoverPolicy, double crossoverRate, MutationPolicy mutationPolicy, double mutationRate, SelectionPolicy selectionPolicy) {
        this.generationsEvolved = 0;
        if (crossoverRate < 0.0d) goto L15;
        if (crossoverRate > 1.0d) goto L15;
        if (mutationRate < 0.0d) goto L13;
        if (mutationRate > 1.0d) goto L13;
        this.crossoverPolicy = crossoverPolicy;
        this.crossoverRate = crossoverRate;
        this.mutationPolicy = mutationPolicy;
        this.mutationRate = mutationRate;
        this.selectionPolicy = selectionPolicy;
        return;
    L13:
        throw new IllegalArgumentException("mutationRate must be between 0 and 1");
    L15:
        throw new IllegalArgumentException("crossoverRate must be between 0 and 1");
    }

    public static synchronized void setRandomGenerator(RandomGenerator random) {
        monitor-enter(GeneticAlgorithm.class);
        randomGenerator = random;     // Catch: Throwable -> L7
        monitor-exit(GeneticAlgorithm.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized RandomGenerator getRandomGenerator() {
        monitor-enter(GeneticAlgorithm.class);
        RandomGenerator r1 = randomGenerator;     // Catch: Throwable -> L7
        monitor-exit(GeneticAlgorithm.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Population evolve(Population initial, StoppingCondition condition) {
        Population current = initial;
        this.generationsEvolved = 0;
    L4:
        if (condition.isSatisfied(current) == true) goto L6;
        current = nextGeneration(current);
        this.generationsEvolved++;
        goto L4
    L6:
        return current;
    }

    public Population nextGeneration(Population current) {
        Population nextGeneration = current.nextGeneration();
        RandomGenerator randGen = getRandomGenerator();
    L4:
        if (nextGeneration.getPopulationSize() >= nextGeneration.getPopulationLimit()) goto L15;
        ChromosomePair pair = getSelectionPolicy().select(current);
        if (randGen.nextDouble() >= getCrossoverRate()) goto L9;
        pair = getCrossoverPolicy().crossover(pair.getFirst(), pair.getSecond());
    L9:
        if (randGen.nextDouble() >= getMutationRate()) goto L11;
        pair = new ChromosomePair(getMutationPolicy().mutate(pair.getFirst()), getMutationPolicy().mutate(pair.getSecond()));
    L11:
        nextGeneration.addChromosome(pair.getFirst());
        if (nextGeneration.getPopulationSize() >= nextGeneration.getPopulationLimit()) goto L4;
        nextGeneration.addChromosome(pair.getSecond());
        goto L4
    L15:
        return nextGeneration;
    }

    public CrossoverPolicy getCrossoverPolicy() {
        return this.crossoverPolicy;
    }

    public double getCrossoverRate() {
        return this.crossoverRate;
    }

    public MutationPolicy getMutationPolicy() {
        return this.mutationPolicy;
    }

    public double getMutationRate() {
        return this.mutationRate;
    }

    public SelectionPolicy getSelectionPolicy() {
        return this.selectionPolicy;
    }

    public int getGenerationsEvolved() {
        return this.generationsEvolved;
    }
}
