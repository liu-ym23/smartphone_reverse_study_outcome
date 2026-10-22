package org.apache.commons.math.stat.descriptive;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.apache.commons.math.stat.descriptive.moment.SecondMoment;
import org.apache.commons.math.stat.descriptive.moment.Variance;
import org.apache.commons.math.stat.descriptive.rank.Max;
import org.apache.commons.math.stat.descriptive.rank.Min;
import org.apache.commons.math.stat.descriptive.summary.Sum;
import org.apache.commons.math.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SummaryStatistics implements StatisticalSummary, Serializable {
    private static final long serialVersionUID = -2021321786743555871L;
    protected GeometricMean geoMean;
    private StorelessUnivariateStatistic geoMeanImpl;
    protected Max max;
    private StorelessUnivariateStatistic maxImpl;
    protected Mean mean;
    private StorelessUnivariateStatistic meanImpl;
    protected Min min;
    private StorelessUnivariateStatistic minImpl;
    protected long n;
    protected SecondMoment secondMoment;
    protected Sum sum;
    private StorelessUnivariateStatistic sumImpl;
    protected SumOfLogs sumLog;
    private StorelessUnivariateStatistic sumLogImpl;
    protected SumOfSquares sumsq;
    private StorelessUnivariateStatistic sumsqImpl;
    protected Variance variance;
    private StorelessUnivariateStatistic varianceImpl;

    public SummaryStatistics() {
        this.n = 0;
        this.secondMoment = new SecondMoment();
        this.sum = new Sum();
        this.sumsq = new SumOfSquares();
        this.min = new Min();
        this.max = new Max();
        this.sumLog = new SumOfLogs();
        this.geoMean = new GeometricMean(this.sumLog);
        this.mean = new Mean();
        this.variance = new Variance();
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = this.variance;
    }

    public SummaryStatistics(SummaryStatistics original) {
        this.n = 0;
        this.secondMoment = new SecondMoment();
        this.sum = new Sum();
        this.sumsq = new SumOfSquares();
        this.min = new Min();
        this.max = new Max();
        this.sumLog = new SumOfLogs();
        this.geoMean = new GeometricMean(this.sumLog);
        this.mean = new Mean();
        this.variance = new Variance();
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = this.variance;
        copy(original, this);
    }

    public StatisticalSummary getSummary() {
        return new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());
    }

    public void addValue(double value) {
        this.sumImpl.increment(value);
        this.sumsqImpl.increment(value);
        this.minImpl.increment(value);
        this.maxImpl.increment(value);
        this.sumLogImpl.increment(value);
        this.secondMoment.increment(value);
        if ((this.meanImpl instanceof Mean) == true) goto L6;
        this.meanImpl.increment(value);
    L6:
        if ((this.varianceImpl instanceof Variance) == true) goto L9;
        this.varianceImpl.increment(value);
    L9:
        if ((this.geoMeanImpl instanceof GeometricMean) == true) goto L11;
        this.geoMeanImpl.increment(value);
    L11:
        this.n++;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.n;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getSum() {
        return this.sumImpl.getResult();
    }

    public double getSumsq() {
        return this.sumsqImpl.getResult();
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMean() {
        if (this.mean != this.meanImpl) goto L7;
        return new Mean(this.secondMoment).getResult();
    L7:
        return this.meanImpl.getResult();
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        if (getN() > 0) goto L5;
        return Double.NaN;
    L5:
        if (getN() <= 1) goto L7;
        double stdDev = FastMath.sqrt(getVariance());
        return stdDev;
    L7:
        return 0.0d;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getVariance() {
        if (this.varianceImpl != this.variance) goto L7;
        return new Variance(this.secondMoment).getResult();
    L7:
        return this.varianceImpl.getResult();
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.maxImpl.getResult();
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.minImpl.getResult();
    }

    public double getGeometricMean() {
        return this.geoMeanImpl.getResult();
    }

    public double getSumOfLogs() {
        return this.sumLogImpl.getResult();
    }

    public double getSecondMoment() {
        return this.secondMoment.getResult();
    }

    public String toString() {
        return "SummaryStatistics:\nn: " + getN() + "\nmin: " + getMin() + "\nmax: " + getMax() + "\nmean: " + getMean() + "\ngeometric mean: " + getGeometricMean() + "\nvariance: " + getVariance() + "\nsum of squares: " + getSumsq() + "\nstandard deviation: " + getStandardDeviation() + "\nsum of logs: " + getSumOfLogs() + "\n";
    }

    public void clear() {
        this.n = 0;
        this.minImpl.clear();
        this.maxImpl.clear();
        this.sumImpl.clear();
        this.sumLogImpl.clear();
        this.sumsqImpl.clear();
        this.geoMeanImpl.clear();
        this.secondMoment.clear();
        if (this.meanImpl == this.mean) goto L6;
        this.meanImpl.clear();
    L6:
        if (this.varianceImpl == this.variance) goto L9;
        this.varianceImpl.clear();
        return;
    }

    public boolean equals(Object object) {
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof SummaryStatistics) == true) goto L8;
        return false;
    L8:
        SummaryStatistics stat = (SummaryStatistics) object;
        if (MathUtils.equalsIncludingNaN(stat.getGeometricMean(), getGeometricMean()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getMax(), getMax()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getMean(), getMean()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getMin(), getMin()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getN(), getN()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getSum(), getSum()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getSumsq(), getSumsq()) == false) goto L26;
        if (MathUtils.equalsIncludingNaN(stat.getVariance(), getVariance()) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int result = MathUtils.hash(getGeometricMean()) + 31;
        return (((((((((((((((result * 31) + MathUtils.hash(getGeometricMean())) * 31) + MathUtils.hash(getMax())) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getSumsq())) * 31) + MathUtils.hash(getVariance());
    }

    public StorelessUnivariateStatistic getSumImpl() {
        return this.sumImpl;
    }

    public void setSumImpl(StorelessUnivariateStatistic sumImpl) {
        checkEmpty();
        this.sumImpl = sumImpl;
    }

    public StorelessUnivariateStatistic getSumsqImpl() {
        return this.sumsqImpl;
    }

    public void setSumsqImpl(StorelessUnivariateStatistic sumsqImpl) {
        checkEmpty();
        this.sumsqImpl = sumsqImpl;
    }

    public StorelessUnivariateStatistic getMinImpl() {
        return this.minImpl;
    }

    public void setMinImpl(StorelessUnivariateStatistic minImpl) {
        checkEmpty();
        this.minImpl = minImpl;
    }

    public StorelessUnivariateStatistic getMaxImpl() {
        return this.maxImpl;
    }

    public void setMaxImpl(StorelessUnivariateStatistic maxImpl) {
        checkEmpty();
        this.maxImpl = maxImpl;
    }

    public StorelessUnivariateStatistic getSumLogImpl() {
        return this.sumLogImpl;
    }

    public void setSumLogImpl(StorelessUnivariateStatistic sumLogImpl) {
        checkEmpty();
        this.sumLogImpl = sumLogImpl;
        this.geoMean.setSumLogImpl(sumLogImpl);
    }

    public StorelessUnivariateStatistic getGeoMeanImpl() {
        return this.geoMeanImpl;
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic geoMeanImpl) {
        checkEmpty();
        this.geoMeanImpl = geoMeanImpl;
    }

    public StorelessUnivariateStatistic getMeanImpl() {
        return this.meanImpl;
    }

    public void setMeanImpl(StorelessUnivariateStatistic meanImpl) {
        checkEmpty();
        this.meanImpl = meanImpl;
    }

    public StorelessUnivariateStatistic getVarianceImpl() {
        return this.varianceImpl;
    }

    public void setVarianceImpl(StorelessUnivariateStatistic varianceImpl) {
        checkEmpty();
        this.varianceImpl = varianceImpl;
    }

    private void checkEmpty() {
        if (this.n > 0) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, new Object[]{Long.valueOf(this.n)});
    }

    public SummaryStatistics copy() {
        SummaryStatistics result = new SummaryStatistics();
        copy(this, result);
        return result;
    }

    public static void copy(SummaryStatistics source, SummaryStatistics dest) {
        dest.maxImpl = source.maxImpl.copy();
        dest.meanImpl = source.meanImpl.copy();
        dest.minImpl = source.minImpl.copy();
        dest.sumImpl = source.sumImpl.copy();
        dest.varianceImpl = source.varianceImpl.copy();
        dest.sumLogImpl = source.sumLogImpl.copy();
        dest.sumsqImpl = source.sumsqImpl.copy();
        if ((source.getGeoMeanImpl() instanceof GeometricMean) == false) goto L5;
        dest.geoMeanImpl = new GeometricMean((SumOfLogs) dest.sumLogImpl);
    L6:
        SecondMoment.copy(source.secondMoment, dest.secondMoment);
        dest.n = source.n;
        if (source.geoMean != source.geoMeanImpl) goto L9;
        dest.geoMean = (GeometricMean) dest.geoMeanImpl;
    L11:
        if (source.max != source.maxImpl) goto L13;
        dest.max = (Max) dest.maxImpl;
    L15:
        if (source.mean != source.meanImpl) goto L17;
        dest.mean = (Mean) dest.meanImpl;
    L19:
        if (source.min != source.minImpl) goto L21;
        dest.min = (Min) dest.minImpl;
    L23:
        if (source.sum != source.sumImpl) goto L25;
        dest.sum = (Sum) dest.sumImpl;
    L27:
        if (source.variance != source.varianceImpl) goto L29;
        dest.variance = (Variance) dest.varianceImpl;
    L31:
        if (source.sumLog != source.sumLogImpl) goto L33;
        dest.sumLog = (SumOfLogs) dest.sumLogImpl;
    L35:
        if (source.sumsq != source.sumsqImpl) goto L37;
        dest.sumsq = (SumOfSquares) dest.sumsqImpl;
        return;
    L37:
        SumOfSquares.copy(source.sumsq, dest.sumsq);
        return;
    L33:
        SumOfLogs.copy(source.sumLog, dest.sumLog);
        goto L35
    L29:
        Variance.copy(source.variance, dest.variance);
        goto L31
    L25:
        Sum.copy(source.sum, dest.sum);
        goto L27
    L21:
        Min.copy(source.min, dest.min);
        goto L23
    L17:
        Mean.copy(source.mean, dest.mean);
        goto L19
    L13:
        Max.copy(source.max, dest.max);
        goto L15
    L9:
        GeometricMean.copy(source.geoMean, dest.geoMean);
        goto L11
    L5:
        dest.geoMeanImpl = source.geoMeanImpl.copy();
        goto L6
    }
}
