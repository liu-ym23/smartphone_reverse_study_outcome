package org.apache.commons.math.distribution;

/* JADX INFO: loaded from: classes3.dex */
public interface BinomialDistribution extends IntegerDistribution {
    int getNumberOfTrials();

    double getProbabilityOfSuccess();

    @Deprecated
    void setNumberOfTrials(int r1);

    @Deprecated
    void setProbabilityOfSuccess(double r1);
}
