package org.apache.commons.math.stat.inference;

import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.distribution.TDistribution;
import org.apache.commons.math.distribution.TDistributionImpl;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math.stat.descriptive.StatisticalSummary;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class TTestImpl implements TTest {

    @Deprecated
    private TDistribution distribution;

    public TTestImpl() {
        this(new TDistributionImpl(1.0d));
    }

    @Deprecated
    public TTestImpl(TDistribution t) {
        setDistribution(t);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double pairedT(double[] sample1, double[] sample2) throws IllegalArgumentException, MathException {
        checkSampleData(sample1);
        checkSampleData(sample2);
        double meanDifference = StatUtils.meanDifference(sample1, sample2);
        return t(meanDifference, 0.0d, StatUtils.varianceDifference(sample1, sample2, meanDifference), sample1.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double pairedTTest(double[] sample1, double[] sample2) throws IllegalArgumentException, MathException {
        double meanDifference = StatUtils.meanDifference(sample1, sample2);
        return tTest(meanDifference, 0.0d, StatUtils.varianceDifference(sample1, sample2, meanDifference), sample1.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public boolean pairedTTest(double[] sample1, double[] sample2, double alpha) throws IllegalArgumentException, MathException {
        checkSignificanceLevel(alpha);
        if (pairedTTest(sample1, sample2) >= alpha) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double t(double mu, double[] observed) throws IllegalArgumentException {
        checkSampleData(observed);
        return t(StatUtils.mean(observed), mu, StatUtils.variance(observed), observed.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double t(double mu, StatisticalSummary sampleStats) throws IllegalArgumentException {
        checkSampleData(sampleStats);
        return t(sampleStats.getMean(), mu, sampleStats.getVariance(), sampleStats.getN());
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double homoscedasticT(double[] sample1, double[] sample2) throws IllegalArgumentException {
        checkSampleData(sample1);
        checkSampleData(sample2);
        return homoscedasticT(StatUtils.mean(sample1), StatUtils.mean(sample2), StatUtils.variance(sample1), StatUtils.variance(sample2), sample1.length, sample2.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double t(double[] sample1, double[] sample2) throws IllegalArgumentException {
        checkSampleData(sample1);
        checkSampleData(sample2);
        return t(StatUtils.mean(sample1), StatUtils.mean(sample2), StatUtils.variance(sample1), StatUtils.variance(sample2), sample1.length, sample2.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double t(StatisticalSummary sampleStats1, StatisticalSummary sampleStats2) throws IllegalArgumentException {
        checkSampleData(sampleStats1);
        checkSampleData(sampleStats2);
        return t(sampleStats1.getMean(), sampleStats2.getMean(), sampleStats1.getVariance(), sampleStats2.getVariance(), sampleStats1.getN(), sampleStats2.getN());
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double homoscedasticT(StatisticalSummary sampleStats1, StatisticalSummary sampleStats2) throws IllegalArgumentException {
        checkSampleData(sampleStats1);
        checkSampleData(sampleStats2);
        return homoscedasticT(sampleStats1.getMean(), sampleStats2.getMean(), sampleStats1.getVariance(), sampleStats2.getVariance(), sampleStats1.getN(), sampleStats2.getN());
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double tTest(double mu, double[] sample) throws IllegalArgumentException, MathException {
        checkSampleData(sample);
        return tTest(StatUtils.mean(sample), mu, StatUtils.variance(sample), sample.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public boolean tTest(double mu, double[] sample, double alpha) throws IllegalArgumentException, MathException {
        checkSignificanceLevel(alpha);
        if (tTest(mu, sample) >= alpha) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double tTest(double mu, StatisticalSummary sampleStats) throws IllegalArgumentException, MathException {
        checkSampleData(sampleStats);
        return tTest(sampleStats.getMean(), mu, sampleStats.getVariance(), sampleStats.getN());
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public boolean tTest(double mu, StatisticalSummary sampleStats, double alpha) throws IllegalArgumentException, MathException {
        checkSignificanceLevel(alpha);
        if (tTest(mu, sampleStats) >= alpha) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double tTest(double[] sample1, double[] sample2) throws IllegalArgumentException, MathException {
        checkSampleData(sample1);
        checkSampleData(sample2);
        return tTest(StatUtils.mean(sample1), StatUtils.mean(sample2), StatUtils.variance(sample1), StatUtils.variance(sample2), sample1.length, sample2.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double homoscedasticTTest(double[] sample1, double[] sample2) throws IllegalArgumentException, MathException {
        checkSampleData(sample1);
        checkSampleData(sample2);
        return homoscedasticTTest(StatUtils.mean(sample1), StatUtils.mean(sample2), StatUtils.variance(sample1), StatUtils.variance(sample2), sample1.length, sample2.length);
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public boolean tTest(double[] sample1, double[] sample2, double alpha) throws IllegalArgumentException, MathException {
        checkSignificanceLevel(alpha);
        if (tTest(sample1, sample2) >= alpha) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public boolean homoscedasticTTest(double[] sample1, double[] sample2, double alpha) throws IllegalArgumentException, MathException {
        checkSignificanceLevel(alpha);
        if (homoscedasticTTest(sample1, sample2) >= alpha) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double tTest(StatisticalSummary sampleStats1, StatisticalSummary sampleStats2) throws IllegalArgumentException, MathException {
        checkSampleData(sampleStats1);
        checkSampleData(sampleStats2);
        return tTest(sampleStats1.getMean(), sampleStats2.getMean(), sampleStats1.getVariance(), sampleStats2.getVariance(), sampleStats1.getN(), sampleStats2.getN());
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public double homoscedasticTTest(StatisticalSummary sampleStats1, StatisticalSummary sampleStats2) throws IllegalArgumentException, MathException {
        checkSampleData(sampleStats1);
        checkSampleData(sampleStats2);
        return homoscedasticTTest(sampleStats1.getMean(), sampleStats2.getMean(), sampleStats1.getVariance(), sampleStats2.getVariance(), sampleStats1.getN(), sampleStats2.getN());
    }

    @Override // org.apache.commons.math.stat.inference.TTest
    public boolean tTest(StatisticalSummary sampleStats1, StatisticalSummary sampleStats2, double alpha) throws IllegalArgumentException, MathException {
        checkSignificanceLevel(alpha);
        if (tTest(sampleStats1, sampleStats2) >= alpha) goto L5;
        return true;
    L5:
        return false;
    }

    protected double df(double v1, double v2, double n1, double n2) {
        return (((v1 / n1) + (v2 / n2)) * ((v1 / n1) + (v2 / n2))) / (((v1 * v1) / ((n1 * n1) * (n1 - 1.0d))) + ((v2 * v2) / ((n2 * n2) * (n2 - 1.0d))));
    }

    protected double t(double m, double mu, double v, double n) {
        return (m - mu) / FastMath.sqrt(v / n);
    }

    protected double t(double m1, double m2, double v1, double v2, double n1, double n2) {
        return (m1 - m2) / FastMath.sqrt((v1 / n1) + (v2 / n2));
    }

    protected double homoscedasticT(double m1, double m2, double v1, double v2, double n1, double n2) {
        double pooledVariance = (((n1 - 1.0d) * v1) + ((n2 - 1.0d) * v2)) / ((n1 + n2) - 2.0d);
        return (m1 - m2) / FastMath.sqrt(((1.0d / n1) + (1.0d / n2)) * pooledVariance);
    }

    protected double tTest(double m, double mu, double v, double n) throws MathException {
        double t = FastMath.abs(t(m, mu, v, n));
        this.distribution.setDegreesOfFreedom(n - 1.0d);
        return this.distribution.cumulativeProbability(-t) * 2.0d;
    }

    protected double tTest(double m1, double m2, double v1, double v2, double n1, double n2) throws MathException {
        double t = FastMath.abs(t(m1, m2, v1, v2, n1, n2));
        double degreesOfFreedom = df(v1, v2, n1, n2);
        this.distribution.setDegreesOfFreedom(degreesOfFreedom);
        return this.distribution.cumulativeProbability(-t) * 2.0d;
    }

    protected double homoscedasticTTest(double m1, double m2, double v1, double v2, double n1, double n2) throws MathException {
        double t = FastMath.abs(homoscedasticT(m1, m2, v1, v2, n1, n2));
        double degreesOfFreedom = (n1 + n2) - 2.0d;
        this.distribution.setDegreesOfFreedom(degreesOfFreedom);
        return this.distribution.cumulativeProbability(-t) * 2.0d;
    }

    @Deprecated
    public void setDistribution(TDistribution value) {
        this.distribution = value;
    }

    private void checkSignificanceLevel(double alpha) throws IllegalArgumentException {
        if (alpha <= 0.0d) goto L8;
        if (alpha > 0.5d) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, new Object[]{Double.valueOf(alpha), Double.valueOf(0.0d), Double.valueOf(0.5d)});
    }

    private void checkSampleData(double[] data) throws IllegalArgumentException {
        if (data != null) goto L4;
    L7:
        LocalizedFormats r0 = LocalizedFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC;
        if (data != null) goto L10;
        int r1 = 0;
    L12:
        throw MathRuntimeException.createIllegalArgumentException(r0, new Object[]{Integer.valueOf(r1)});
    L10:
        r1 = data.length;
        goto L12
    L4:
        if (data.length < 2) goto L7;
    }

    private void checkSampleData(StatisticalSummary stat) throws IllegalArgumentException {
        if (stat != null) goto L4;
    L7:
        LocalizedFormats r0 = LocalizedFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC;
        if (stat != null) goto L10;
        long r1 = 0;
    L12:
        throw MathRuntimeException.createIllegalArgumentException(r0, new Object[]{Long.valueOf(r1)});
    L10:
        r1 = stat.getN();
        goto L12
    L4:
        if (stat.getN() < 2) goto L7;
    }
}
