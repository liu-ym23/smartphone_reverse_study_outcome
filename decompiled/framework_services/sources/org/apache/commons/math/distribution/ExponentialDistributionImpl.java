package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class ExponentialDistributionImpl extends AbstractContinuousDistribution implements ExponentialDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 2401296428283614780L;
    private double mean;
    private final double solverAbsoluteAccuracy;

    @Override // org.apache.commons.math.distribution.ExponentialDistribution, org.apache.commons.math.distribution.HasDensity
    @Deprecated
    public /* bridge */ /* synthetic */ double density(Double r3) throws MathException {
        return density(r3);
    }

    public ExponentialDistributionImpl(double mean) {
        this(mean, 1.0E-9d);
    }

    public ExponentialDistributionImpl(double mean, double inverseCumAccuracy) {
        setMeanInternal(mean);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    @Override // org.apache.commons.math.distribution.ExponentialDistribution
    @Deprecated
    public void setMean(double mean) {
        setMeanInternal(mean);
    }

    private void setMeanInternal(double newMean) {
        if (newMean <= 0.0d) goto L7;
        this.mean = newMean;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_MEAN, new Object[]{Double.valueOf(newMean)});
    }

    @Override // org.apache.commons.math.distribution.ExponentialDistribution
    public double getMean() {
        return this.mean;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.math.distribution.ExponentialDistribution
    @Deprecated
    public double density(Double x) {
        return density(x.doubleValue());
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        if (x >= 0.0d) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp((-x) / this.mean) / this.mean;
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        if (x > 0.0d) goto L5;
        return 0.0d;
    L5:
        double ret = -x;
        return 1.0d - FastMath.exp(ret / this.mean);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution, org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(double p) throws MathException {
        if (p < 0.0d) goto L12;
        if (p > 1.0d) goto L12;
        if (p != 1.0d) goto L9;
        return Double.POSITIVE_INFINITY;
    L9:
        double ret = this.mean;
        return (-ret) * FastMath.log(1.0d - p);
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(p), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double sample() throws MathException {
        return this.randomData.nextExponential(this.mean);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        return 0.0d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        if (p < 0.5d) goto L5;
        return Double.MAX_VALUE;
    L5:
        return this.mean;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        if (p >= 0.5d) goto L7;
        return this.mean * 0.5d;
    L7:
        return this.mean;
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
        return getMean();
    }

    public double getNumericalVariance() {
        double m = getMean();
        return m * m;
    }
}
