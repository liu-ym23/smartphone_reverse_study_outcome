package org.apache.commons.math.stat.descriptive;

/* JADX INFO: loaded from: classes3.dex */
public class SynchronizedDescriptiveStatistics extends DescriptiveStatistics {
    private static final long serialVersionUID = 1;

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public /* bridge */ /* synthetic */ DescriptiveStatistics copy() {
        return copy();
    }

    public SynchronizedDescriptiveStatistics() {
        this(-1);
    }

    public SynchronizedDescriptiveStatistics(int window) {
        super(window);
    }

    public SynchronizedDescriptiveStatistics(SynchronizedDescriptiveStatistics original) {
        copy(original, this);
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized void addValue(double v) {
        monitor-enter(this);
        super.addValue(v);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized double apply(UnivariateStatistic stat) {
        monitor-enter(this);
        double r0 = super.apply(stat);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized double getElement(int index) {
        monitor-enter(this);
        double r0 = super.getElement(index);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized long getN() {
        monitor-enter(this);
        long r0 = super.getN();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics, org.apache.commons.math.stat.descriptive.StatisticalSummary
    public synchronized double getStandardDeviation() {
        monitor-enter(this);
        double r0 = super.getStandardDeviation();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized double[] getValues() {
        monitor-enter(this);
        double[] r0 = super.getValues();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized int getWindowSize() {
        monitor-enter(this);
        int r0 = super.getWindowSize();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized void setWindowSize(int windowSize) {
        monitor-enter(this);
        super.setWindowSize(windowSize);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.DescriptiveStatistics
    public synchronized SynchronizedDescriptiveStatistics copy() {
        monitor-enter(this);
        SynchronizedDescriptiveStatistics result = new SynchronizedDescriptiveStatistics();     // Catch: Throwable -> L6
        copy(this, result);     // Catch: Throwable -> L6
        monitor-exit(this);
        return result;
    L6:
        th = move-exception;
        throw th;
    }

    public static void copy(SynchronizedDescriptiveStatistics source, SynchronizedDescriptiveStatistics dest) {
        monitor-enter(source);
        monitor-enter(dest);     // Catch: Throwable -> L8
        DescriptiveStatistics.copy(source, dest);     // Catch: Throwable -> L10
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
