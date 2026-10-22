package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface PoissonDistribution extends IntegerDistribution {
    double getMean();

    double normalApproximateProbability(int r1) throws MathException;

    @Deprecated
    void setMean(double r1);
}
