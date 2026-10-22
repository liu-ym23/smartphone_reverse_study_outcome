package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class CauchyDistributionImpl extends AbstractContinuousDistribution implements CauchyDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 8589540077390120676L;
    private double median;
    private double scale;
    private final double solverAbsoluteAccuracy;

    public CauchyDistributionImpl() {
        this(0.0d, 1.0d);
    }

    public CauchyDistributionImpl(double median, double s) {
        this(median, s, 1.0E-9d);
    }

    public CauchyDistributionImpl(double median, double s, double inverseCumAccuracy) {
        this.median = 0.0d;
        this.scale = 1.0d;
        setMedianInternal(median);
        setScaleInternal(s);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) {
        return (FastMath.atan((x - this.median) / this.scale) / 3.141592653589793d) + 0.5d;
    }

    @Override // org.apache.commons.math.distribution.CauchyDistribution
    public double getMedian() {
        return this.median;
    }

    @Override // org.apache.commons.math.distribution.CauchyDistribution
    public double getScale() {
        return this.scale;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        double dev = x - this.median;
        return (this.scale / ((dev * dev) + (this.scale * this.scale))) * 0.3183098861837907d;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution, org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(double p) {
        if (p < 0.0d) goto L15;
        if (p > 1.0d) goto L15;
        if (p != 0.0d) goto L10;
        return Double.NEGATIVE_INFINITY;
    L10:
        if (p != 1.0d) goto L12;
        return Double.POSITIVE_INFINITY;
    L12:
        double ret = this.median;
        return ret + (this.scale * FastMath.tan((p - 0.5d) * 3.141592653589793d));
    L15:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(p), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    @Override // org.apache.commons.math.distribution.CauchyDistribution
    @Deprecated
    public void setMedian(double median) {
        setMedianInternal(median);
    }

    private void setMedianInternal(double newMedian) {
        this.median = newMedian;
    }

    @Override // org.apache.commons.math.distribution.CauchyDistribution
    @Deprecated
    public void setScale(double s) {
        setScaleInternal(s);
    }

    private void setScaleInternal(double s) {
        if (s <= 0.0d) goto L7;
        this.scale = s;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_SCALE, new Object[]{Double.valueOf(s)});
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainLowerBound(double p) {
        if (p >= 0.5d) goto L5;
        return -1.7976931348623157E308d;
    L5:
        double ret = this.median;
        return ret;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getDomainUpperBound(double p) {
        if (p >= 0.5d) goto L5;
        double ret = this.median;
        return ret;
    L5:
        return Double.MAX_VALUE;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    protected double getInitialDomain(double p) {
        if (p >= 0.5d) goto L6;
        double ret = this.median - this.scale;
        return ret;
    L6:
        if (p <= 0.5d) goto L8;
        double ret2 = this.median + this.scale;
        return ret2;
    L8:
        double ret3 = this.median;
        return ret3;
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
        return Double.NaN;
    }

    public double getNumericalVariance() {
        return Double.NaN;
    }
}
