package org.apache.commons.math.genetics;

/* JADX INFO: loaded from: classes3.dex */
public class FixedGenerationCount implements StoppingCondition {
    private final int maxGenerations;
    private int numGenerations;

    public FixedGenerationCount(int maxGenerations) {
        this.numGenerations = 0;
        if (maxGenerations <= 0) goto L7;
        this.maxGenerations = maxGenerations;
        return;
    L7:
        throw new IllegalArgumentException("The number of generations has to be >= 0");
    }

    @Override // org.apache.commons.math.genetics.StoppingCondition
    public boolean isSatisfied(Population population) {
        if (this.numGenerations >= this.maxGenerations) goto L6;
        this.numGenerations++;
        return false;
    L6:
        return true;
    }

    public int getNumGenerations() {
        return this.numGenerations;
    }
}
