package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Gamma;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class PoissonDistributionImpl extends AbstractIntegerDistribution implements PoissonDistribution, Serializable {
    public static final double DEFAULT_EPSILON = 1.0E-12d;
    public static final int DEFAULT_MAX_ITERATIONS = 10000000;
    private static final long serialVersionUID = -3349935121172596109L;
    private double epsilon;
    private int maxIterations;
    private double mean;
    private NormalDistribution normal;

    public PoissonDistributionImpl(double p) {
        this(p, new NormalDistributionImpl());
    }

    public PoissonDistributionImpl(double p, double epsilon, int maxIterations) {
        this.maxIterations = DEFAULT_MAX_ITERATIONS;
        this.epsilon = 1.0E-12d;
        setMean(p);
        this.epsilon = epsilon;
        this.maxIterations = maxIterations;
    }

    public PoissonDistributionImpl(double p, double epsilon) {
        this.maxIterations = DEFAULT_MAX_ITERATIONS;
        this.epsilon = 1.0E-12d;
        setMean(p);
        this.epsilon = epsilon;
    }

    public PoissonDistributionImpl(double p, int maxIterations) {
        this.maxIterations = DEFAULT_MAX_ITERATIONS;
        this.epsilon = 1.0E-12d;
        setMean(p);
        this.maxIterations = maxIterations;
    }

    @Deprecated
    public PoissonDistributionImpl(double p, NormalDistribution z) {
        this.maxIterations = DEFAULT_MAX_ITERATIONS;
        this.epsilon = 1.0E-12d;
        setNormalAndMeanInternal(z, p);
    }

    @Override // org.apache.commons.math.distribution.PoissonDistribution
    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math.distribution.PoissonDistribution
    @Deprecated
    public void setMean(double p) {
        setNormalAndMeanInternal(this.normal, p);
    }

    private void setNormalAndMeanInternal(NormalDistribution z, double p) {
        if (p <= 0.0d) goto L7;
        this.mean = p;
        this.normal = z;
        this.normal.setMean(p);
        this.normal.setStandardDeviation(FastMath.sqrt(p));
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_POISSON_MEAN, new Object[]{Double.valueOf(p)});
    }

    @Override // org.apache.commons.math.distribution.IntegerDistribution
    public double probability(int x) {
        if (x >= 0) goto L4;
    L9:
        return 0.0d;
    L4:
        if (x == Integer.MAX_VALUE) goto L9;
        if (x != 0) goto L8;
        double ret = FastMath.exp(-this.mean);
        return ret;
    L8:
        double ret2 = x;
        return FastMath.exp((-SaddlePointExpansion.getStirlingError(ret2)) - SaddlePointExpansion.getDeviancePart(x, this.mean)) / FastMath.sqrt(((double) x) * 6.283185307179586d);
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution, org.apache.commons.math.distribution.IntegerDistribution
    public double cumulativeProbability(int x) throws MathException {
        if (x >= 0) goto L6;
        return 0.0d;
    L6:
        if (x != Integer.MAX_VALUE) goto L9;
        return 1.0d;
    L9:
        return Gamma.regularizedGammaQ(((double) x) + 1.0d, this.mean, this.epsilon, this.maxIterations);
    }

    @Override // org.apache.commons.math.distribution.PoissonDistribution
    public double normalApproximateProbability(int x) throws MathException {
        return this.normal.cumulativeProbability(((double) x) + 0.5d);
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    public int sample() throws MathException {
        return (int) FastMath.min(this.randomData.nextPoisson(this.mean), 2147483647L);
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainLowerBound(double p) {
        return 0;
    }

    @Override // org.apache.commons.math.distribution.AbstractIntegerDistribution
    protected int getDomainUpperBound(double p) {
        return Integer.MAX_VALUE;
    }

    @Deprecated
    public void setNormal(NormalDistribution value) {
        setNormalAndMeanInternal(value, this.mean);
    }

    public int getSupportLowerBound() {
        return 0;
    }

    public int getSupportUpperBound() {
        return Integer.MAX_VALUE;
    }

    public double getNumericalVariance() {
        return getMean();
    }
}
