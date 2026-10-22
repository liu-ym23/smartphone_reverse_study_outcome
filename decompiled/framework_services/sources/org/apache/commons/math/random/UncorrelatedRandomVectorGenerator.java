package org.apache.commons.math.random;

import java.util.Arrays;
import org.apache.commons.math.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes3.dex */
public class UncorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;
    private final double[] mean;
    private final double[] standardDeviation;

    public UncorrelatedRandomVectorGenerator(double[] mean, double[] standardDeviation, NormalizedRandomGenerator generator) {
        if (mean.length != standardDeviation.length) goto L7;
        this.mean = (double[]) mean.clone();
        this.standardDeviation = (double[]) standardDeviation.clone();
        this.generator = generator;
        return;
    L7:
        throw new DimensionMismatchException(mean.length, standardDeviation.length);
    }

    public UncorrelatedRandomVectorGenerator(int dimension, NormalizedRandomGenerator generator) {
        this.mean = new double[dimension];
        this.standardDeviation = new double[dimension];
        Arrays.fill(this.standardDeviation, 1.0d);
        this.generator = generator;
    }

    @Override // org.apache.commons.math.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] random = new double[this.mean.length];
        int i = 0;
    L4:
        if (i >= random.length) goto L7;
        random[i] = this.mean[i] + (this.standardDeviation[i] * this.generator.nextNormalizedDouble());
        i = i + 1;
        goto L4
    L7:
        return random;
    }
}
