package org.apache.commons.math.stat.descriptive;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class AggregateSummaryStatistics implements StatisticalSummary, Serializable {
    private static final long serialVersionUID = -8207112444016386906L;
    private final SummaryStatistics statistics;
    private final SummaryStatistics statisticsPrototype;

    private static class AggregatingSummaryStatistics extends SummaryStatistics {
        private static final long serialVersionUID = 1;
        private final SummaryStatistics aggregateStatistics;

        public AggregatingSummaryStatistics(SummaryStatistics aggregateStatistics) {
            this.aggregateStatistics = aggregateStatistics;
        }

        @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
        public void addValue(double value) {
            super.addValue(value);
            SummaryStatistics r0 = this.aggregateStatistics;
            monitor-enter(r0);
            this.aggregateStatistics.addValue(value);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
        public boolean equals(Object object) {
            if (object != this) goto L6;
            return true;
        L6:
            if ((object instanceof AggregatingSummaryStatistics) == true) goto L8;
            return false;
        L8:
            AggregatingSummaryStatistics stat = (AggregatingSummaryStatistics) object;
            if (super.equals(stat) == false) goto L14;
            if (this.aggregateStatistics.equals(stat.aggregateStatistics) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // org.apache.commons.math.stat.descriptive.SummaryStatistics
        public int hashCode() {
            return (super.hashCode() + 123) + this.aggregateStatistics.hashCode();
        }
    }

    public AggregateSummaryStatistics() {
        this(new SummaryStatistics());
    }

    public AggregateSummaryStatistics(SummaryStatistics prototypeStatistics) {
        if (prototypeStatistics != null) goto L4;
        SummaryStatistics r0 = null;
    L5:
        this(prototypeStatistics, r0);
        return;
    L4:
        r0 = new SummaryStatistics(prototypeStatistics);
        goto L5
    }

    public AggregateSummaryStatistics(SummaryStatistics prototypeStatistics, SummaryStatistics initialStatistics) {
        if (prototypeStatistics != null) goto L5;
        SummaryStatistics r0 = new SummaryStatistics();
    L6:
        this.statisticsPrototype = r0;
        if (initialStatistics != null) goto L9;
        SummaryStatistics r1 = new SummaryStatistics();
    L10:
        this.statistics = r1;
        return;
    L9:
        r1 = initialStatistics;
        goto L10
    L5:
        r0 = prototypeStatistics;
        goto L6
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMax() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMax();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMean() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMean();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMin() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMin();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public long getN() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        long r1 = this.statistics.getN();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getStandardDeviation();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getSum() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSum();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getVariance() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getVariance();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSumOfLogs() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSumOfLogs();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getGeometricMean() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getGeometricMean();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSumsq() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSumsq();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSecondMoment() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSecondMoment();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public StatisticalSummary getSummary() {
        SummaryStatistics r1 = this.statistics;
        monitor-enter(r1);
        StatisticalSummaryValues r2 = new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public SummaryStatistics createContributingStatistics() {
        SummaryStatistics contributingStatistics = new AggregatingSummaryStatistics(this.statistics);
        SummaryStatistics.copy(this.statisticsPrototype, contributingStatistics);
        return contributingStatistics;
    }

    public static StatisticalSummaryValues aggregate(Collection<SummaryStatistics> statistics) {
        if (statistics != null) goto L5;
        return null;
    L5:
        Iterator<SummaryStatistics> iterator = statistics.iterator();
        if (iterator.hasNext() == true) goto L8;
        return null;
    L8:
        SummaryStatistics current = iterator.next();
        long n = current.getN();
        double min = current.getMin();
        double sum = current.getSum();
        double max = current.getMax();
        double m2 = current.getSecondMoment();
        double m3 = m2;
        double max2 = max;
        long n2 = n;
        double min2 = min;
        double sum2 = sum;
        double mean = current.getMean();
    L10:
        if (iterator.hasNext() == false) goto L23;
        SummaryStatistics current2 = iterator.next();
        if (current2.getMin() >= min2) goto L14;
    L15:
        min2 = current2.getMin();
    L17:
        if (current2.getMax() <= max2) goto L19;
    L20:
        max2 = current2.getMax();
    L21:
        sum2 = sum2 + current2.getSum();
        double oldN = n2;
        double curN = current2.getN();
        n2 = (long) (n2 + curN);
        double meanDiff = current2.getMean() - mean;
        mean = sum2 / n2;
        m3 = (current2.getSecondMoment() + m3) + ((((meanDiff * meanDiff) * oldN) * curN) / n2);
        iterator = iterator;
        goto L10
    L19:
        if (Double.isNaN(max2) == false) goto L21;
    L14:
        if (Double.isNaN(min2) == false) goto L17;
    L23:
        if (n2 != 0) goto L26;
        double variance = Double.NaN;
    L30:
        return new StatisticalSummaryValues(mean, variance, n2, max2, min2, sum2);
    L26:
        if (n2 != 1) goto L28;
        variance = 0.0d;
        goto L30
    L28:
        variance = m3 / (n2 - 1);
        goto L30
    }
}
