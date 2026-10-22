package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface FDistribution extends ContinuousDistribution {
    double getDenominatorDegreesOfFreedom();

    double getNumeratorDegreesOfFreedom();

    @Deprecated
    void setDenominatorDegreesOfFreedom(double r1);

    @Deprecated
    void setNumeratorDegreesOfFreedom(double r1);
}
