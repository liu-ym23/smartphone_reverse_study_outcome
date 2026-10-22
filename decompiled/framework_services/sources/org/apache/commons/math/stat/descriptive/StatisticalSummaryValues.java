package org.apache.commons.math.stat.descriptive;

import java.io.Serializable;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class StatisticalSummaryValues implements Serializable, StatisticalSummary {
    private static final long serialVersionUID = -5108854841843722536L;
    private final double max;
    private final double mean;
    private final double min;
    private final long n;
    private final double sum;
    private final double variance;

    public StatisticalSummaryValues(double mean, double variance, long n, double max, double min, double sum) {
        this.mean = mean;
        this.variance = variance;
        this.n = n;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.max;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.min;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.n;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getSum() {
        return this.sum;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        return FastMath.sqrt(this.variance);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return this.variance;
    }

    public boolean equals(Object object) {
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof StatisticalSummaryValues) == true) goto L8;
        return false;
    L8:
        StatisticalSummaryValues stat = (StatisticalSummaryValues) object;
        if (MathUtils.equalsIncludingNaN(stat.getMax(), getMax()) == false) goto L22;
        if (MathUtils.equalsIncludingNaN(stat.getMean(), getMean()) == false) goto L22;
        if (MathUtils.equalsIncludingNaN(stat.getMin(), getMin()) == false) goto L22;
        if (MathUtils.equalsIncludingNaN(stat.getN(), getN()) == false) goto L22;
        if (MathUtils.equalsIncludingNaN(stat.getSum(), getSum()) == false) goto L22;
        if (MathUtils.equalsIncludingNaN(stat.getVariance(), getVariance()) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int result = MathUtils.hash(getMax()) + 31;
        return (((((((((result * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getVariance());
    }

    public String toString() {
        return "StatisticalSummaryValues:\nn: " + getN() + "\nmin: " + getMin() + "\nmax: " + getMax() + "\nmean: " + getMean() + "\nstd dev: " + getStandardDeviation() + "\nvariance: " + getVariance() + "\nsum: " + getSum() + "\n";
    }
}
