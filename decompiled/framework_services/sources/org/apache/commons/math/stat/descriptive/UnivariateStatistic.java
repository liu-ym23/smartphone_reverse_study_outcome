package org.apache.commons.math.stat.descriptive;

/* JADX INFO: loaded from: classes3.dex */
public interface UnivariateStatistic {
    UnivariateStatistic copy();

    double evaluate(double[] r1);

    double evaluate(double[] r1, int r2, int r3);
}
