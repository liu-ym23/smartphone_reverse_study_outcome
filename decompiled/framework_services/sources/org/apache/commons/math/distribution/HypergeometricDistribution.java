package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface HypergeometricDistribution extends IntegerDistribution {
    int getNumberOfSuccesses();

    int getPopulationSize();

    int getSampleSize();

    @Deprecated
    void setNumberOfSuccesses(int r1);

    @Deprecated
    void setPopulationSize(int r1);

    @Deprecated
    void setSampleSize(int r1);
}
