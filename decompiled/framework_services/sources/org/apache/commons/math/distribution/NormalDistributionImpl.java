package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Erf;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class NormalDistributionImpl extends AbstractContinuousDistribution implements NormalDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final double SQRT2PI = 0.0d;
    private static final long serialVersionUID = 8589540077390120676L;
    private double mean;
    private final double solverAbsoluteAccuracy;
    private double standardDeviation;

    @Override // org.apache.commons.math.distribution.NormalDistribution, org.apache.commons.math.distribution.HasDensity
    @Deprecated
    public /* bridge */ /* synthetic */ double density(Double r3) throws MathException {
        return density(r3);
    }

    static {
        SQRT2PI = FastMath.sqrt(6.283185307179586d);
    }

    public NormalDistributionImpl(double mean, double sd) {
        this(mean, sd, 1.0E-9d);
    }

    public NormalDistributionImpl(double mean, double sd, double inverseCumAccuracy) {
        this.mean = 0.0d;
        this.standardDeviation = 1.0d;
        setMeanInternal(mean);
        setStandardDeviationInternal(sd);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    public NormalDistributionImpl() {
        this(0.0d, 1.0d);
    }

    @Override // org.apache.commons.math.distribution.NormalDistribution
    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math.distribution.NormalDistribution
    @Deprecated
    public void setMean(double mean) {
        setMeanInternal(mean);
    }

    private void setMeanInternal(double newMean) {
        this.mean = newMean;
    }

    @Override // org.apache.commons.math.distribution.NormalDistribution
    public double getStandardDeviation() {
        return this.standardDeviation;
    }

    @Override // org.apache.commons.math.distribution.NormalDistribution
    @Deprecated
    public void setStandardDeviation(double sd) {
        setStandardDeviationInternal(sd);
    }

    private void setStandardDeviationInternal(double sd) {
        if (sd <= 0.0d) goto L7;
        this.standardDeviation = sd;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_STANDARD_DEVIATION, new Object[]{Double.valueOf(sd)});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.math.distribution.NormalDistribution
    @Deprecated
    public double density(Double x) {
        return density(x.doubleValue());
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        double x0 = x - this.mean;
        return FastMath.exp(((-x0) * x0) / ((this.standardDeviation * 2.0d) * this.standardDeviation)) / (this.standardDeviation * SQRT2PI);
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) throws MathException {
        double dev = x - this.mean;
        if (FastMath.abs(dev) <= (this.standardDeviation * 40.0d)) goto L9;
        if (dev < 0.0d) goto L7;
        return 1.0d;
    L7:
        return 0.0d;
    L9:
        return (Erf.erf(dev / (this.standardDeviation * FastMath.sqrt(2.0d))) + 1.0d) * 0.5d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
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
    public double sample() throws MathException {
        return this.randomData.nextGaussian(this.mean, this.standardDeviation);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        if (p >= 0.5d) goto L5;
        return -1.7976931348623157E308d;
    L5:
        double ret = this.mean;
        return ret;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        if (p >= 0.5d) goto L5;
        double ret = this.mean;
        return ret;
    L5:
        return Double.MAX_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        if (p >= 0.5d) goto L6;
        double ret = this.mean - this.standardDeviation;
        return ret;
    L6:
        if (p <= 0.5d) goto L8;
        double ret2 = this.mean + this.standardDeviation;
        return ret2;
    L8:
        double ret3 = this.mean;
        return ret3;
    }

    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
    }

    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    public double getNumericalVariance() {
        double s = getStandardDeviation();
        return s * s;
    }
}
