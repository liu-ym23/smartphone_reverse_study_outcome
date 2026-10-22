package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Gamma;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class GammaDistributionImpl extends AbstractContinuousDistribution implements GammaDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -3239549463135430361L;
    private double alpha;
    private double beta;
    private final double solverAbsoluteAccuracy;

    @Override // org.apache.commons.math.distribution.GammaDistribution, org.apache.commons.math.distribution.HasDensity
    @Deprecated
    public /* bridge */ /* synthetic */ double density(Double r3) throws MathException {
        return density(r3);
    }

    public GammaDistributionImpl(double alpha, double beta) {
        this(alpha, beta, 1.0E-9d);
    }

    public GammaDistributionImpl(double alpha, double beta, double inverseCumAccuracy) {
        setAlphaInternal(alpha);
        setBetaInternal(beta);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        if (x > 0.0d) goto L5;
        return 0.0d;
    L5:
        double ret = this.alpha;
        return Gamma.regularizedGammaP(ret, x / this.beta);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution, org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(double p) throws MathException {
        if (p != 0.0d) goto L6;
        return 0.0d;
    L6:
        if (p != 1.0d) goto L10;
        return Double.POSITIVE_INFINITY;
    L10:
        return super.inverseCumulativeProbability(p);
    }

    @Override // org.apache.commons.math.distribution.GammaDistribution
    @Deprecated
    public void setAlpha(double alpha) {
        setAlphaInternal(alpha);
    }

    private void setAlphaInternal(double newAlpha) {
        if (newAlpha <= 0.0d) goto L7;
        this.alpha = newAlpha;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_ALPHA, new Object[]{Double.valueOf(newAlpha)});
    }

    @Override // org.apache.commons.math.distribution.GammaDistribution
    public double getAlpha() {
        return this.alpha;
    }

    @Override // org.apache.commons.math.distribution.GammaDistribution
    @Deprecated
    public void setBeta(double newBeta) {
        setBetaInternal(newBeta);
    }

    private void setBetaInternal(double newBeta) {
        if (newBeta <= 0.0d) goto L7;
        this.beta = newBeta;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_BETA, new Object[]{Double.valueOf(newBeta)});
    }

    @Override // org.apache.commons.math.distribution.GammaDistribution
    public double getBeta() {
        return this.beta;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        if (x >= 0.0d) goto L6;
        return 0.0d;
    L6:
        return ((FastMath.pow(x / this.beta, this.alpha - 1.0d) / this.beta) * FastMath.exp((-x) / this.beta)) / FastMath.exp(Gamma.logGamma(this.alpha));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.math.distribution.GammaDistribution
    @Deprecated
    public double density(Double x) {
        return density(x.doubleValue());
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        return Double.MIN_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        if (p >= 0.5d) goto L5;
        double ret = this.alpha * this.beta;
        return ret;
    L5:
        return Double.MAX_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        if (p >= 0.5d) goto L5;
        double ret = (this.alpha * this.beta) * 0.5d;
        return ret;
    L5:
        double r0 = this.alpha;
        double ret2 = this.beta * r0;
        return ret2;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    public double getSupportLowerBound() {
        return 0.0d;
    }

    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    public double getNumericalMean() {
        return getAlpha() * getBeta();
    }

    public double getNumericalVariance() {
        double b = getBeta();
        return (getAlpha() * b) * b;
    }
}
