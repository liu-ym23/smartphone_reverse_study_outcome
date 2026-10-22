package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface TDistribution extends ContinuousDistribution {
    double getDegreesOfFreedom();

    @Deprecated
    void setDegreesOfFreedom(double r1);
}
