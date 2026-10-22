package org.apache.commons.math.stat.descriptive;

/* JADX INFO: loaded from: classes3.dex */
public interface StorelessUnivariateStatistic extends UnivariateStatistic {
    void clear();

    StorelessUnivariateStatistic copy();

    long getN();

    double getResult();

    void increment(double r1);

    void incrementAll(double[] r1);

    void incrementAll(double[] r1, int r2, int r3);

    @Override // org.apache.commons.math.stat.descriptive.UnivariateStatistic, org.apache.commons.math.stat.descriptive.StorelessUnivariateStatistic
    /* bridge */ /* synthetic */ default UnivariateStatistic copy() {
        return copy();
    }
}
