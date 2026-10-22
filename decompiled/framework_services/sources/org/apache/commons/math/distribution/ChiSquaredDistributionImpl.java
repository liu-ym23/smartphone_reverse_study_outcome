package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public class ChiSquaredDistributionImpl extends AbstractContinuousDistribution implements ChiSquaredDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -8352658048349159782L;
    private GammaDistribution gamma;
    private final double solverAbsoluteAccuracy;

    @Override // org.apache.commons.math.distribution.ChiSquaredDistribution, org.apache.commons.math.distribution.HasDensity
    @Deprecated
    public /* bridge */ /* synthetic */ double density(Double r3) throws MathException {
        return density(r3);
    }

    public ChiSquaredDistributionImpl(double df) {
        this(df, new GammaDistributionImpl(df / 2.0d, 2.0d));
    }

    @Deprecated
    public ChiSquaredDistributionImpl(double df, GammaDistribution g) {
        setGammaInternal(g);
        setDegreesOfFreedomInternal(df);
        this.solverAbsoluteAccuracy = 1.0E-9d;
    }

    public ChiSquaredDistributionImpl(double df, double inverseCumAccuracy) {
        this.gamma = new GammaDistributionImpl(df / 2.0d, 2.0d);
        setDegreesOfFreedomInternal(df);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    @Override // org.apache.commons.math.distribution.ChiSquaredDistribution
    @Deprecated
    public void setDegreesOfFreedom(double degreesOfFreedom) {
        setDegreesOfFreedomInternal(degreesOfFreedom);
    }

    private void setDegreesOfFreedomInternal(double degreesOfFreedom) {
        this.gamma.setAlpha(degreesOfFreedom / 2.0d);
    }

    @Override // org.apache.commons.math.distribution.ChiSquaredDistribution
    public double getDegreesOfFreedom() {
        return this.gamma.getAlpha() * 2.0d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.math.distribution.ChiSquaredDistribution
    @Deprecated
    public double density(Double x) {
        return density(x.doubleValue());
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        return this.gamma.density2(Double.valueOf(x));
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        return this.gamma.cumulativeProbability(x);
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

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        return this.gamma.getBeta() * Double.MIN_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        if (p >= 0.5d) goto L5;
        double ret = getDegreesOfFreedom();
        return ret;
    L5:
        return Double.MAX_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        if (p >= 0.5d) goto L5;
        double ret = getDegreesOfFreedom() * 0.5d;
        return ret;
    L5:
        double ret2 = getDegreesOfFreedom();
        return ret2;
    }

    @Deprecated
    public void setGamma(GammaDistribution g) {
        setGammaInternal(g);
    }

    private void setGammaInternal(GammaDistribution g) {
        this.gamma = g;
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
        return getDegreesOfFreedom();
    }

    public double getNumericalVariance() {
        return getDegreesOfFreedom() * 2.0d;
    }
}
