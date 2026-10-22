package org.apache.commons.math.stat.descriptive;

import org.apache.commons.math.linear.RealMatrix;

/* JADX INFO: loaded from: classes3.dex */
public interface StatisticalMultivariateSummary {
    RealMatrix getCovariance();

    int getDimension();

    double[] getGeometricMean();

    double[] getMax();

    double[] getMean();

    double[] getMin();

    long getN();

    double[] getStandardDeviation();

    double[] getSum();

    double[] getSumLog();

    double[] getSumSq();
}
