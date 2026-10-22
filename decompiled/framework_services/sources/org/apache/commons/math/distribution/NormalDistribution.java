package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface NormalDistribution extends ContinuousDistribution, HasDensity<Double> {
    /* JADX INFO: renamed from: density, reason: avoid collision after fix types in other method */
    double density2(Double r1);

    double getMean();

    double getStandardDeviation();

    @Deprecated
    void setMean(double r1);

    @Deprecated
    void setStandardDeviation(double r1);

    @Override // org.apache.commons.math.distribution.HasDensity
    /* bridge */ /* synthetic */ default double density(Double r3) throws MathException {
        return density2(r3);
    }
}
