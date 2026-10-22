package org.apache.commons.math.stat.descriptive;

import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.linear.RealMatrix;

/* JADX INFO: loaded from: classes3.dex */
public class SynchronizedMultivariateSummaryStatistics extends MultivariateSummaryStatistics {
    private static final long serialVersionUID = 7099834153347155363L;

    public SynchronizedMultivariateSummaryStatistics(int k, boolean isCovarianceBiasCorrected) {
        super(k, isCovarianceBiasCorrected);
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void addValue(double[] value) throws DimensionMismatchException {
        monitor-enter(this);
        super.addValue(value);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized int getDimension() {
        monitor-enter(this);
        int r0 = super.getDimension();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized long getN() {
        monitor-enter(this);
        long r0 = super.getN();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getSum() {
        monitor-enter(this);
        double[] r0 = super.getSum();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getSumSq() {
        monitor-enter(this);
        double[] r0 = super.getSumSq();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getSumLog() {
        monitor-enter(this);
        double[] r0 = super.getSumLog();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getMean() {
        monitor-enter(this);
        double[] r0 = super.getMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getStandardDeviation() {
        monitor-enter(this);
        double[] r0 = super.getStandardDeviation();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized RealMatrix getCovariance() {
        monitor-enter(this);
        RealMatrix r0 = super.getCovariance();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getMax() {
        monitor-enter(this);
        double[] r0 = super.getMax();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getMin() {
        monitor-enter(this);
        double[] r0 = super.getMin();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getGeometricMean() {
        monitor-enter(this);
        double[] r0 = super.getGeometricMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized boolean equals(Object object) {
        monitor-enter(this);
        boolean r0 = super.equals(object);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized int hashCode() {
        monitor-enter(this);
        int r0 = super.hashCode();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getSumImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumImpl(StorelessUnivariateStatistic[] sumImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setSumImpl(sumImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumsqImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getSumsqImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic[] sumsqImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setSumsqImpl(sumsqImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMinImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getMinImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMinImpl(StorelessUnivariateStatistic[] minImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setMinImpl(minImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMaxImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getMaxImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMaxImpl(StorelessUnivariateStatistic[] maxImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setMaxImpl(maxImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumLogImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getSumLogImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic[] sumLogImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setSumLogImpl(sumLogImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getGeoMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getGeoMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic[] geoMeanImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setGeoMeanImpl(geoMeanImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMeanImpl(StorelessUnivariateStatistic[] meanImpl) throws DimensionMismatchException {
        monitor-enter(this);
        super.setMeanImpl(meanImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
