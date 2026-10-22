package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Beta;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class FDistributionImpl extends AbstractContinuousDistribution implements FDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -8516354193418641566L;
    private double denominatorDegreesOfFreedom;
    private double numeratorDegreesOfFreedom;
    private final double solverAbsoluteAccuracy;

    public FDistributionImpl(double numeratorDegreesOfFreedom, double denominatorDegreesOfFreedom) {
        this(numeratorDegreesOfFreedom, denominatorDegreesOfFreedom, 1.0E-9d);
    }

    public FDistributionImpl(double numeratorDegreesOfFreedom, double denominatorDegreesOfFreedom, double inverseCumAccuracy) {
        setNumeratorDegreesOfFreedomInternal(numeratorDegreesOfFreedom);
        setDenominatorDegreesOfFreedomInternal(denominatorDegreesOfFreedom);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        double nhalf = this.numeratorDegreesOfFreedom / 2.0d;
        double mhalf = this.denominatorDegreesOfFreedom / 2.0d;
        double logx = FastMath.log(x);
        double logn = FastMath.log(this.numeratorDegreesOfFreedom);
        double logm = FastMath.log(this.denominatorDegreesOfFreedom);
        double lognxm = FastMath.log((this.numeratorDegreesOfFreedom * x) + this.denominatorDegreesOfFreedom);
        return FastMath.exp(((((((nhalf * logn) + (nhalf * logx)) - logx) + (mhalf * logm)) - (nhalf * lognxm)) - (mhalf * lognxm)) - Beta.logBeta(nhalf, mhalf));
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        if (x > 0.0d) goto L5;
        return 0.0d;
    L5:
        double ret = this.numeratorDegreesOfFreedom;
        double m = this.denominatorDegreesOfFreedom;
        return Beta.regularizedBeta((ret * x) / ((ret * x) + m), ret * 0.5d, m * 0.5d);
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
        return 0.0d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        return Double.MAX_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        double d = this.denominatorDegreesOfFreedom;
        if (d <= 2.0d) goto L6;
        double ret = d / (d - 2.0d);
        return ret;
    L6:
        return 1.0d;
    }

    @Override // org.apache.commons.math.distribution.FDistribution
    @Deprecated
    public void setNumeratorDegreesOfFreedom(double degreesOfFreedom) {
        setNumeratorDegreesOfFreedomInternal(degreesOfFreedom);
    }

    private void setNumeratorDegreesOfFreedomInternal(double degreesOfFreedom) {
        if (degreesOfFreedom <= 0.0d) goto L7;
        this.numeratorDegreesOfFreedom = degreesOfFreedom;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_DEGREES_OF_FREEDOM, new Object[]{Double.valueOf(degreesOfFreedom)});
    }

    @Override // org.apache.commons.math.distribution.FDistribution
    public double getNumeratorDegreesOfFreedom() {
        return this.numeratorDegreesOfFreedom;
    }

    @Override // org.apache.commons.math.distribution.FDistribution
    @Deprecated
    public void setDenominatorDegreesOfFreedom(double degreesOfFreedom) {
        setDenominatorDegreesOfFreedomInternal(degreesOfFreedom);
    }

    private void setDenominatorDegreesOfFreedomInternal(double degreesOfFreedom) {
        if (degreesOfFreedom <= 0.0d) goto L7;
        this.denominatorDegreesOfFreedom = degreesOfFreedom;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_DEGREES_OF_FREEDOM, new Object[]{Double.valueOf(degreesOfFreedom)});
    }

    @Override // org.apache.commons.math.distribution.FDistribution
    public double getDenominatorDegreesOfFreedom() {
        return this.denominatorDegreesOfFreedom;
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
        double denominatorDF = getDenominatorDegreesOfFreedom();
        if (denominatorDF > 2.0d) goto L5;
        return Double.NaN;
    L5:
        return denominatorDF / (denominatorDF - 2.0d);
    }

    public double getNumericalVariance() {
        double denominatorDF = getDenominatorDegreesOfFreedom();
        if (denominatorDF <= 4.0d) goto L6;
        double numeratorDF = getNumeratorDegreesOfFreedom();
        double denomDFMinusTwo = denominatorDF - 2.0d;
        return (((denominatorDF * denominatorDF) * 2.0d) * ((numeratorDF + denominatorDF) - 2.0d)) / (((denomDFMinusTwo * denomDFMinusTwo) * numeratorDF) * (denominatorDF - 4.0d));
    L6:
        return Double.NaN;
    }
}
