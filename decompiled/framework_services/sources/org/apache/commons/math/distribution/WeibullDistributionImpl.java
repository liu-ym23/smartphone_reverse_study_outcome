package org.apache.commons.math.distribution;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.special.Gamma;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class WeibullDistributionImpl extends AbstractContinuousDistribution implements WeibullDistribution, Serializable {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 8589540077390120676L;
    private double numericalMean;
    private boolean numericalMeanIsCalculated;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private double scale;
    private double shape;
    private final double solverAbsoluteAccuracy;

    public WeibullDistributionImpl(double alpha, double beta) {
        this(alpha, beta, 1.0E-9d);
    }

    public WeibullDistributionImpl(double alpha, double beta, double inverseCumAccuracy) {
        this.numericalMean = Double.NaN;
        this.numericalMeanIsCalculated = false;
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        setShapeInternal(alpha);
        setScaleInternal(beta);
        this.solverAbsoluteAccuracy = inverseCumAccuracy;
    }

    @Override // org.apache.commons.math.distribution.Distribution
    public double cumulativeProbability(double x) {
        if (x > 0.0d) goto L5;
        return 0.0d;
    L5:
        double ret = this.scale;
        return 1.0d - FastMath.exp(-FastMath.pow(x / ret, this.shape));
    }

    @Override // org.apache.commons.math.distribution.WeibullDistribution
    public double getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.math.distribution.WeibullDistribution
    public double getScale() {
        return this.scale;
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution
    public double density(double x) {
        if (x >= 0.0d) goto L5;
        return 0.0d;
    L5:
        double xscale = x / this.scale;
        double xscalepow = FastMath.pow(xscale, this.shape - 1.0d);
        double xscalepowshape = xscalepow * xscale;
        return ((this.shape / this.scale) * xscalepow) * FastMath.exp(-xscalepowshape);
    }

    @Override // org.apache.commons.math.distribution.AbstractContinuousDistribution, org.apache.commons.math.distribution.ContinuousDistribution
    public double inverseCumulativeProbability(double p) {
        if (p < 0.0d) goto L15;
        if (p > 1.0d) goto L15;
        if (p != 0.0d) goto L10;
        return 0.0d;
    L10:
        if (p != 1.0d) goto L12;
        return Double.POSITIVE_INFINITY;
    L12:
        double ret = this.scale;
        return ret * FastMath.pow(-FastMath.log(1.0d - p), 1.0d / this.shape);
    L15:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(p), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    @Override // org.apache.commons.math.distribution.WeibullDistribution
    @Deprecated
    public void setShape(double alpha) {
        setShapeInternal(alpha);
        invalidateParameterDependentMoments();
    }

    private void setShapeInternal(double alpha) {
        if (alpha <= 0.0d) goto L7;
        this.shape = alpha;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_SHAPE, new Object[]{Double.valueOf(alpha)});
    }

    @Override // org.apache.commons.math.distribution.WeibullDistribution
    @Deprecated
    public void setScale(double beta) {
        setScaleInternal(beta);
        invalidateParameterDependentMoments();
    }

    private void setScaleInternal(double beta) {
        if (beta <= 0.0d) goto L7;
        this.scale = beta;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_SCALE, new Object[]{Double.valueOf(beta)});
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
        return FastMath.pow(this.scale * FastMath.log(2.0d), 1.0d / this.shape);
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

    protected double calculateNumericalMean() {
        double sh = getShape();
        double sc = getScale();
        return FastMath.exp(Gamma.logGamma((1.0d / sh) + 1.0d)) * sc;
    }

    private double calculateNumericalVariance() {
        double sh = getShape();
        double sc = getScale();
        double mn = getNumericalMean();
        return ((sc * sc) * FastMath.exp(Gamma.logGamma((2.0d / sh) + 1.0d))) - (mn * mn);
    }

    public double getNumericalMean() {
        if (this.numericalMeanIsCalculated == true) goto L6;
        this.numericalMean = calculateNumericalMean();
        this.numericalMeanIsCalculated = true;
    L6:
        return this.numericalMean;
    }

    public double getNumericalVariance() {
        if (this.numericalVarianceIsCalculated == true) goto L6;
        this.numericalVariance = calculateNumericalVariance();
        this.numericalVarianceIsCalculated = true;
    L6:
        return this.numericalVariance;
    }

    private void invalidateParameterDependentMoments() {
        this.numericalMeanIsCalculated = false;
        this.numericalVarianceIsCalculated = false;
    }
}
