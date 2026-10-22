package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class HypergeometricDistributionImpl extends AbstractIntegerDistribution implements HypergeometricDistribution, Serializable {
    private static final long serialVersionUID = -436928820673516179L;
    private int numberOfSuccesses;
    private int populationSize;
    private int sampleSize;

    public HypergeometricDistributionImpl(int populationSize, int numberOfSuccesses, int sampleSize) {
        if (numberOfSuccesses > populationSize) goto L10;
        if (sampleSize > populationSize) goto L8;
        setPopulationSizeInternal(populationSize);
        setSampleSizeInternal(sampleSize);
        setNumberOfSuccessesInternal(numberOfSuccesses);
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE, new Object[]{Integer.valueOf(sampleSize), Integer.valueOf(populationSize)});
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, new Object[]{Integer.valueOf(numberOfSuccesses), Integer.valueOf(populationSize)});
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public double cumulativeProbability(int x) {
        int[] domain = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (x >= domain[0]) goto L6;
        return 0.0d;
    L6:
        if (x >= domain[1]) goto L11;
        double ret = innerCumulativeProbability(domain[0], x, 1, this.populationSize, this.numberOfSuccesses, this.sampleSize);
        return ret;
    L11:
        return 1.0d;
    }

    private int[] getDomain(int n, int m, int k) {
        return new int[]{getLowerDomain(n, m, k), getUpperDomain(m, k)};
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainLowerBound(double p) {
        return getLowerDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainUpperBound(double p) {
        return getUpperDomain(this.sampleSize, this.numberOfSuccesses);
    }

    private int getLowerDomain(int n, int m, int k) {
        return FastMath.max(0, m - (n - k));
    }

    @Override // org.apache.commons.math.distribution.HypergeometricDistribution
    public int getNumberOfSuccesses() {
        return this.numberOfSuccesses;
    }

    @Override // org.apache.commons.math.distribution.HypergeometricDistribution
    public int getPopulationSize() {
        return this.populationSize;
    }

    @Override // org.apache.commons.math.distribution.HypergeometricDistribution
    public int getSampleSize() {
        return this.sampleSize;
    }

    private int getUpperDomain(int m, int k) {
        return FastMath.min(k, m);
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public double probability(int x) {
        int[] domain = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (x >= domain[0]) goto L5;
    L8:
        return 0.0d;
    L5:
        if (x > domain[1]) goto L8;
        double p = ((double) this.sampleSize) / ((double) this.populationSize);
        double q = ((double) (this.populationSize - this.sampleSize)) / ((double) this.populationSize);
        double p1 = SaddlePointExpansion.logBinomialProbability(x, this.numberOfSuccesses, p, q);
        double p2 = SaddlePointExpansion.logBinomialProbability(this.sampleSize - x, this.populationSize - this.numberOfSuccesses, p, q);
        double p3 = SaddlePointExpansion.logBinomialProbability(this.sampleSize, this.populationSize, p, q);
        double ret = FastMath.exp((p1 + p2) - p3);
        return ret;
    }

    private double probability(int n, int m, int k, int x) {
        return FastMath.exp((MathUtils.binomialCoefficientLog(m, x) + MathUtils.binomialCoefficientLog(n - m, k - x)) - MathUtils.binomialCoefficientLog(n, k));
    }

    @Override // org.apache.commons.math.distribution.HypergeometricDistribution
    @Deprecated
    public void setNumberOfSuccesses(int num) {
        setNumberOfSuccessesInternal(num);
    }

    private void setNumberOfSuccessesInternal(int num) {
        if (num < 0) goto L6;
        this.numberOfSuccesses = num;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_NUMBER_OF_SUCCESSES, new Object[]{Integer.valueOf(num)});
    }

    @Override // org.apache.commons.math.distribution.HypergeometricDistribution
    @Deprecated
    public void setPopulationSize(int size) {
        setPopulationSizeInternal(size);
    }

    private void setPopulationSizeInternal(int size) {
        if (size <= 0) goto L6;
        this.populationSize = size;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_POPULATION_SIZE, new Object[]{Integer.valueOf(size)});
    }

    @Override // org.apache.commons.math.distribution.HypergeometricDistribution
    @Deprecated
    public void setSampleSize(int size) {
        setSampleSizeInternal(size);
    }

    private void setSampleSizeInternal(int size) {
        if (size < 0) goto L6;
        this.sampleSize = size;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_SAMPLE_SIZE, new Object[]{Integer.valueOf(size)});
    }

    public double upperCumulativeProbability(int x) {
        int[] domain = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (x >= domain[0]) goto L6;
        return 1.0d;
    L6:
        if (x > domain[1]) goto L11;
        double ret = innerCumulativeProbability(domain[1], x, -1, this.populationSize, this.numberOfSuccesses, this.sampleSize);
        return ret;
    L11:
        return 0.0d;
    }

    private double innerCumulativeProbability(int x0, int x1, int dx, int n, int m, int k) {
        double ret = probability(n, m, k, x0);
    L3:
        if (x0 == x1) goto L5;
        x0 = x0 + dx;
        ret = ret + probability(n, m, k, x0);
        goto L3
    L5:
        return ret;
    }

    public int getSupportLowerBound() {
        return FastMath.max(0, (getSampleSize() + getNumberOfSuccesses()) - getPopulationSize());
    }

    public int getSupportUpperBound() {
        return FastMath.min(getNumberOfSuccesses(), getSampleSize());
    }

    protected double getNumericalMean() {
        return ((double) (getSampleSize() * getNumberOfSuccesses())) / ((double) getPopulationSize());
    }

    public double getNumericalVariance() {
        double N = getPopulationSize();
        double m = getNumberOfSuccesses();
        double n = getSampleSize();
        return (((n * m) * (N - n)) * (N - m)) / ((N * N) * (N - 1.0d));
    }
}
