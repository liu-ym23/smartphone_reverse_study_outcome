package org.apache.commons.math.distribution;

import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Beta;
import org.apache.commons.math.special.Gamma;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BetaDistributionImpl extends AbstractContinuousDistribution implements BetaDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -1221965979403477668L;
    private double alpha;
    private double beta;
    private final double solverAbsoluteAccuracy;
    private double z;

    @Override // org.apache.commons.math.distribution.BetaDistribution, org.apache.commons.math.distribution.HasDensity
    @Deprecated
    public /* bridge */ /* synthetic */ double density(Double r3) throws MathException {
        return density(r3);
    }

    public BetaDistributionImpl(double alpha, double beta, double inverseCumAccuracy) {
        this.alpha = alpha;
        this.beta = beta;
        this.z = Double.NaN;
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    public BetaDistributionImpl(double alpha, double beta) {
        this(alpha, beta, 1.0E-9d);
    }

    @Override // org.apache.commons.math.distribution.BetaDistribution
    @Deprecated
    public void setAlpha(double alpha) {
        this.alpha = alpha;
        this.z = Double.NaN;
    }

    @Override // org.apache.commons.math.distribution.BetaDistribution
    public double getAlpha() {
        return this.alpha;
    }

    @Override // org.apache.commons.math.distribution.BetaDistribution
    @Deprecated
    public void setBeta(double beta) {
        this.beta = beta;
        this.z = Double.NaN;
    }

    @Override // org.apache.commons.math.distribution.BetaDistribution
    public double getBeta() {
        return this.beta;
    }

    private void recomputeZ() {
        if (Double.isNaN(this.z) == false) goto L6;
        this.z = (Gamma.logGamma(this.alpha) + Gamma.logGamma(this.beta)) - Gamma.logGamma(this.alpha + this.beta);
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.math.distribution.BetaDistribution
    @Deprecated
    public double density(Double x) {
        return density(x.doubleValue());
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        recomputeZ();
        if (x >= 0.0d) goto L5;
    L23:
        return 0.0d;
    L5:
        if (x > 1.0d) goto L23;
        if (x != 0.0d) goto L15;
        if (this.alpha < 1.0d) goto L13;
        return 0.0d;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA, new Object[]{Double.valueOf(this.alpha)});
    L15:
        if (x == 1.0d) goto L17;
        double logX = FastMath.log(x);
        double log1mX = FastMath.log1p(-x);
        return FastMath.exp((((this.alpha - 1.0d) * logX) + ((this.beta - 1.0d) * log1mX)) - this.z);
    L17:
        if (this.beta < 1.0d) goto L20;
        return 0.0d;
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA, new Object[]{Double.valueOf(this.beta)});
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution, org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(double p) throws MathException {
        if (p != 0.0d) goto L6;
        return 0.0d;
    L6:
        if (p != 1.0d) goto L9;
        return 1.0d;
    L9:
        return super.inverseCumulativeProbability(p);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        return p;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        return 0.0d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        return 1.0d;
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        if (x > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (x < 1.0d) goto L9;
        return 1.0d;
    L9:
        return Beta.regularizedBeta(x, this.alpha, this.beta);
    }

    @Override // org.apache.commons.math.distribution.AbstractDistribution, org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x0, double x1) throws MathException {
        return cumulativeProbability(x1) - cumulativeProbability(x0);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    public double getSupportLowerBound() {
        return 0.0d;
    }

    public double getSupportUpperBound() {
        return 1.0d;
    }

    public double getNumericalMean() {
        double a = getAlpha();
        return a / (getBeta() + a);
    }

    public double getNumericalVariance() {
        double a = getAlpha();
        double b = getBeta();
        double alphabetasum = a + b;
        return (a * b) / ((alphabetasum * alphabetasum) * (1.0d + alphabetasum));
    }
}
