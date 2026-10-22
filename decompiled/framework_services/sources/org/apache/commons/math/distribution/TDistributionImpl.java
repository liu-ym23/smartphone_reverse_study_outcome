package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Beta;
import org.apache.commons.math.special.Gamma;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class TDistributionImpl extends AbstractContinuousDistribution implements TDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -5852615386664158222L;
    private double degreesOfFreedom;
    private final double solverAbsoluteAccuracy;

    public TDistributionImpl(double degreesOfFreedom, double inverseCumAccuracy) {
        setDegreesOfFreedomInternal(degreesOfFreedom);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    public TDistributionImpl(double degreesOfFreedom) {
        this(degreesOfFreedom, 1.0E-9d);
    }

    @Override // org.apache.commons.math.distribution.TDistribution
    @Deprecated
    public void setDegreesOfFreedom(double degreesOfFreedom) {
        setDegreesOfFreedomInternal(degreesOfFreedom);
    }

    private void setDegreesOfFreedomInternal(double newDegreesOfFreedom) {
        if (newDegreesOfFreedom <= 0.0d) goto L7;
        this.degreesOfFreedom = newDegreesOfFreedom;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_DEGREES_OF_FREEDOM, new Object[]{Double.valueOf(newDegreesOfFreedom)});
    }

    @Override // org.apache.commons.math.distribution.TDistribution
    public double getDegreesOfFreedom() {
        return this.degreesOfFreedom;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        double n = this.degreesOfFreedom;
        double nPlus1Over2 = (n + 1.0d) / 2.0d;
        return FastMath.exp(((Gamma.logGamma(nPlus1Over2) - ((FastMath.log(3.141592653589793d) + FastMath.log(n)) * 0.5d)) - Gamma.logGamma(n / 2.0d)) - (FastMath.log(((x * x) / n) + 1.0d) * nPlus1Over2));
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        if (x != 0.0d) goto L5;
        return 0.5d;
    L5:
        double t = Beta.regularizedBeta(this.degreesOfFreedom / (this.degreesOfFreedom + (x * x)), this.degreesOfFreedom * 0.5d, 0.5d);
        if (x >= 0.0d) goto L8;
        double ret = t * 0.5d;
        return ret;
    L8:
        double ret2 = 1.0d - (0.5d * t);
        return ret2;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution, org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(double p) throws MathException {
        if (p != 0.0d) goto L7;
        return Double.NEGATIVE_INFINITY;
    L7:
        if (p != 1.0d) goto L11;
        return Double.POSITIVE_INFINITY;
    L11:
        return super.inverseCumulativeProbability(p);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        return -1.7976931348623157E308d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        return Double.MAX_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        return 0.0d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
    }

    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    public double getNumericalMean() {
        double df = getDegreesOfFreedom();
        if (df <= 1.0d) goto L6;
        return 0.0d;
    L6:
        return Double.NaN;
    }

    public double getNumericalVariance() {
        double df = getDegreesOfFreedom();
        if (df <= 2.0d) goto L7;
        return df / (df - 2.0d);
    L7:
        if (df > 1.0d) goto L9;
        return Double.NaN;
    L9:
        if (df > 2.0d) goto L14;
        return Double.POSITIVE_INFINITY;
    L14:
        return Double.NaN;
    }
}
