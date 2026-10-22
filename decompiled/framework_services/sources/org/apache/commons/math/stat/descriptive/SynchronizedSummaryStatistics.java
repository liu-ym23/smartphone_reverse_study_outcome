package org.apache.commons.math.stat.descriptive;

/* JADX INFO: loaded from: classes3.dex */
public class SynchronizedSummaryStatistics extends SummaryStatistics {
    private static final long serialVersionUID = 1909861009042253704L;

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public /* bridge */ /* synthetic */ SummaryStatistics copy() {
        return copy();
    }

    public SynchronizedSummaryStatistics() {
    }

    public SynchronizedSummaryStatistics(SynchronizedSummaryStatistics original) {
        copy(original, this);
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StatisticalSummary getSummary() {
        monitor-enter(this);
        StatisticalSummary r0 = super.getSummary();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void addValue(double value) {
        monitor-enter(this);
        super.addValue(value);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized long getN() {
        monitor-enter(this);
        long r0 = super.getN();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getSum() {
        monitor-enter(this);
        double r0 = super.getSum();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized double getSumsq() {
        monitor-enter(this);
        double r0 = super.getSumsq();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getMean() {
        monitor-enter(this);
        double r0 = super.getMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getStandardDeviation() {
        monitor-enter(this);
        double r0 = super.getStandardDeviation();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getVariance() {
        monitor-enter(this);
        double r0 = super.getVariance();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getMax() {
        monitor-enter(this);
        double r0 = super.getMax();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getMin() {
        monitor-enter(this);
        double r0 = super.getMin();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized double getGeometricMean() {
        monitor-enter(this);
        double r0 = super.getGeometricMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized boolean equals(Object object) {
        monitor-enter(this);
        boolean r0 = super.equals(object);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized int hashCode() {
        monitor-enter(this);
        int r0 = super.hashCode();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getSumImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getSumImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setSumImpl(StorelessUnivariateStatistic sumImpl) {
        monitor-enter(this);
        super.setSumImpl(sumImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getSumsqImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getSumsqImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic sumsqImpl) {
        monitor-enter(this);
        super.setSumsqImpl(sumsqImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getMinImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getMinImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setMinImpl(StorelessUnivariateStatistic minImpl) {
        monitor-enter(this);
        super.setMinImpl(minImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getMaxImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getMaxImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setMaxImpl(StorelessUnivariateStatistic maxImpl) {
        monitor-enter(this);
        super.setMaxImpl(maxImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getSumLogImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getSumLogImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic sumLogImpl) {
        monitor-enter(this);
        super.setSumLogImpl(sumLogImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getGeoMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getGeoMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic geoMeanImpl) {
        monitor-enter(this);
        super.setGeoMeanImpl(geoMeanImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setMeanImpl(StorelessUnivariateStatistic meanImpl) {
        monitor-enter(this);
        super.setMeanImpl(meanImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized StorelessUnivariateStatistic getVarianceImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic r0 = super.getVarianceImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized void setVarianceImpl(StorelessUnivariateStatistic varianceImpl) {
        monitor-enter(this);
        super.setVarianceImpl(varianceImpl);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
    public synchronized SynchronizedSummaryStatistics copy() {
        monitor-enter(this);
        SynchronizedSummaryStatistics result = new SynchronizedSummaryStatistics();     // Catch: Throwable -> L6
        copy(this, result);     // Catch: Throwable -> L6
        monitor-exit(this);
        return result;
    L6:
        th = move-exception;
        throw th;
    }

    public static void copy(SynchronizedSummaryStatistics source, SynchronizedSummaryStatistics dest) {
        monitor-enter(source);
        monitor-enter(dest);     // Catch: Throwable -> L8
        SummaryStatistics.copy(source, dest);     // Catch: Throwable -> L10
        monitor-exit(dest);     // Catch: Throwable -> L10
        monitor-exit(source);     // Catch: Throwable -> L8
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
