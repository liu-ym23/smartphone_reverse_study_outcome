package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface PascalDistribution extends IntegerDistribution {
    int getNumberOfSuccesses();

    double getProbabilityOfSuccess();

    @Deprecated
    void setNumberOfSuccesses(int r1);

    @Deprecated
    void setProbabilityOfSuccess(double r1);
}
