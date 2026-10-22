package org.apache.commons.math.stat.descriptive;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.apache.commons.math.stat.descriptive.moment.VectorialCovariance;
import org.apache.commons.math.stat.descriptive.rank.Max;
import org.apache.commons.math.stat.descriptive.rank.Min;
import org.apache.commons.math.stat.descriptive.summary.Sum;
import org.apache.commons.math.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MultivariateSummaryStatistics implements StatisticalMultivariateSummary, Serializable {
    private static final long serialVersionUID = 2271900808994826718L;
    private VectorialCovariance covarianceImpl;
    private StorelessUnivariateStatistic[] geoMeanImpl;
    private int k;
    private StorelessUnivariateStatistic[] maxImpl;
    private StorelessUnivariateStatistic[] meanImpl;
    private StorelessUnivariateStatistic[] minImpl;
    private long n;
    private StorelessUnivariateStatistic[] sumImpl;
    private StorelessUnivariateStatistic[] sumLogImpl;
    private StorelessUnivariateStatistic[] sumSqImpl;

    public MultivariateSummaryStatistics(int k, boolean isCovarianceBiasCorrected) {
        this.n = 0;
        this.k = k;
        this.sumImpl = new StorelessUnivariateStatistic[k];
        this.sumSqImpl = new StorelessUnivariateStatistic[k];
        this.minImpl = new StorelessUnivariateStatistic[k];
        this.maxImpl = new StorelessUnivariateStatistic[k];
        this.sumLogImpl = new StorelessUnivariateStatistic[k];
        this.geoMeanImpl = new StorelessUnivariateStatistic[k];
        this.meanImpl = new StorelessUnivariateStatistic[k];
        int i = 0;
    L3:
        if (i >= k) goto L5;
        this.sumImpl[i] = new Sum();
        this.sumSqImpl[i] = new SumOfSquares();
        this.minImpl[i] = new Min();
        this.maxImpl[i] = new Max();
        this.sumLogImpl[i] = new SumOfLogs();
        this.geoMeanImpl[i] = new GeometricMean();
        this.meanImpl[i] = new Mean();
        i = i + 1;
        goto L3
    L5:
        this.covarianceImpl = new VectorialCovariance(k, isCovarianceBiasCorrected);
    }

    public void addValue(double[] value) throws DimensionMismatchException {
        checkDimension(value.length);
        int i = 0;
    L4:
        if (i >= this.k) goto L6;
        double v = value[i];
        this.sumImpl[i].increment(v);
        this.sumSqImpl[i].increment(v);
        this.minImpl[i].increment(v);
        this.maxImpl[i].increment(v);
        this.sumLogImpl[i].increment(v);
        this.geoMeanImpl[i].increment(v);
        this.meanImpl[i].increment(v);
        i = i + 1;
        goto L4
    L6:
        this.covarianceImpl.increment(value);
        this.n++;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public int getDimension() {
        return this.k;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public long getN() {
        return this.n;
    }

    private double[] getResults(StorelessUnivariateStatistic[] stats) {
        double[] results = new double[stats.length];
        int i = 0;
    L4:
        if (i >= results.length) goto L7;
        results[i] = stats[i].getResult();
        i = i + 1;
        goto L4
    L7:
        return results;
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSum() {
        return getResults(this.sumImpl);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSumSq() {
        return getResults(this.sumSqImpl);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSumLog() {
        return getResults(this.sumLogImpl);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMean() {
        return getResults(this.meanImpl);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getStandardDeviation() {
        double[] stdDev = new double[this.k];
        if (getN() >= 1) goto L6;
        Arrays.fill(stdDev, Double.NaN);
    L12:
        return stdDev;
    L6:
        if (getN() >= 2) goto L8;
        Arrays.fill(stdDev, 0.0d);
        goto L12
    L8:
        RealMatrix matrix = this.covarianceImpl.getResult();
        int i = 0;
    L10:
        if (i >= this.k) goto L12;
        stdDev[i] = FastMath.sqrt(matrix.getEntry(i, i));
        i = i + 1;
        goto L10
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public RealMatrix getCovariance() {
        return this.covarianceImpl.getResult();
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMax() {
        return getResults(this.maxImpl);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMin() {
        return getResults(this.minImpl);
    }

    @Override // org.apache.commons.math.stat.descriptive.StatisticalMultivariateSummary
    public double[] getGeometricMean() {
        return getResults(this.geoMeanImpl);
    }

    public String toString() {
        String suffix = System.getProperty("line.separator");
        StringBuilder outBuffer = new StringBuilder();
        outBuffer.append("MultivariateSummaryStatistics:" + suffix);
        outBuffer.append("n: " + getN() + suffix);
        append(outBuffer, getMin(), "min: ", ", ", suffix);
        append(outBuffer, getMax(), "max: ", ", ", suffix);
        append(outBuffer, getMean(), "mean: ", ", ", suffix);
        append(outBuffer, getGeometricMean(), "geometric mean: ", ", ", suffix);
        append(outBuffer, getSumSq(), "sum of squares: ", ", ", suffix);
        append(outBuffer, getSumLog(), "sum of logarithms: ", ", ", suffix);
        append(outBuffer, getStandardDeviation(), "standard deviation: ", ", ", suffix);
        outBuffer.append("covariance: " + getCovariance().toString() + suffix);
        return outBuffer.toString();
    }

    private void append(StringBuilder buffer, double[] data, String prefix, String separator, String suffix) {
        buffer.append(prefix);
        int i = 0;
    L4:
        if (i >= data.length) goto L8;
        if (i <= 0) goto L7;
        buffer.append(separator);
    L7:
        buffer.append(data[i]);
        i = i + 1;
        goto L4
    L8:
        buffer.append(suffix);
    }

    public void clear() {
        this.n = 0;
        int i = 0;
    L4:
        if (i >= this.k) goto L6;
        this.minImpl[i].clear();
        this.maxImpl[i].clear();
        this.sumImpl[i].clear();
        this.sumLogImpl[i].clear();
        this.sumSqImpl[i].clear();
        this.geoMeanImpl[i].clear();
        this.meanImpl[i].clear();
        i = i + 1;
        goto L4
    L6:
        this.covarianceImpl.clear();
    }

    public boolean equals(Object object) {
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof MultivariateSummaryStatistics) == true) goto L8;
        return false;
    L8:
        MultivariateSummaryStatistics stat = (MultivariateSummaryStatistics) object;
        if (MathUtils.equalsIncludingNaN(stat.getGeometricMean(), getGeometricMean()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getMax(), getMax()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getMean(), getMean()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getMin(), getMin()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getN(), getN()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getSum(), getSum()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getSumSq(), getSumSq()) == false) goto L28;
        if (MathUtils.equalsIncludingNaN(stat.getSumLog(), getSumLog()) == false) goto L28;
        if (stat.getCovariance().equals(getCovariance()) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        int result = MathUtils.hash(getGeometricMean()) + 31;
        return (((((((((((((((((result * 31) + MathUtils.hash(getGeometricMean())) * 31) + MathUtils.hash(getMax())) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getSumSq())) * 31) + MathUtils.hash(getSumLog())) * 31) + getCovariance().hashCode();
    }

    private void setImpl(StorelessUnivariateStatistic[] newImpl, StorelessUnivariateStatistic[] oldImpl) throws DimensionMismatchException, IllegalStateException {
        checkEmpty();
        checkDimension(newImpl.length);
        System.arraycopy(newImpl, 0, oldImpl, 0, newImpl.length);
    }

    public StorelessUnivariateStatistic[] getSumImpl() {
        return (StorelessUnivariateStatistic[]) this.sumImpl.clone();
    }

    public void setSumImpl(StorelessUnivariateStatistic[] sumImpl) throws DimensionMismatchException {
        setImpl(sumImpl, this.sumImpl);
    }

    public StorelessUnivariateStatistic[] getSumsqImpl() {
        return (StorelessUnivariateStatistic[]) this.sumSqImpl.clone();
    }

    public void setSumsqImpl(StorelessUnivariateStatistic[] sumsqImpl) throws DimensionMismatchException {
        setImpl(sumsqImpl, this.sumSqImpl);
    }

    public StorelessUnivariateStatistic[] getMinImpl() {
        return (StorelessUnivariateStatistic[]) this.minImpl.clone();
    }

    public void setMinImpl(StorelessUnivariateStatistic[] minImpl) throws DimensionMismatchException {
        setImpl(minImpl, this.minImpl);
    }

    public StorelessUnivariateStatistic[] getMaxImpl() {
        return (StorelessUnivariateStatistic[]) this.maxImpl.clone();
    }

    public void setMaxImpl(StorelessUnivariateStatistic[] maxImpl) throws DimensionMismatchException {
        setImpl(maxImpl, this.maxImpl);
    }

    public StorelessUnivariateStatistic[] getSumLogImpl() {
        return (StorelessUnivariateStatistic[]) this.sumLogImpl.clone();
    }

    public void setSumLogImpl(StorelessUnivariateStatistic[] sumLogImpl) throws DimensionMismatchException {
        setImpl(sumLogImpl, this.sumLogImpl);
    }

    public StorelessUnivariateStatistic[] getGeoMeanImpl() {
        return (StorelessUnivariateStatistic[]) this.geoMeanImpl.clone();
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic[] geoMeanImpl) throws DimensionMismatchException {
        setImpl(geoMeanImpl, this.geoMeanImpl);
    }

    public StorelessUnivariateStatistic[] getMeanImpl() {
        return (StorelessUnivariateStatistic[]) this.meanImpl.clone();
    }

    public void setMeanImpl(StorelessUnivariateStatistic[] meanImpl) throws DimensionMismatchException {
        setImpl(meanImpl, this.meanImpl);
    }

    private void checkEmpty() {
        if (this.n > 0) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, new Object[]{Long.valueOf(this.n)});
    }

    private void checkDimension(int dimension) throws DimensionMismatchException {
        if (dimension != this.k) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(dimension, this.k);
    }
}
