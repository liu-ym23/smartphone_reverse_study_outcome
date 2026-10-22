package org.apache.commons.math.analysis.interpolation;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class LoessInterpolator implements UnivariateRealInterpolator, Serializable {
    public static final double DEFAULT_ACCURACY = 1.0E-12d;
    public static final double DEFAULT_BANDWIDTH = 0.3d;
    public static final int DEFAULT_ROBUSTNESS_ITERS = 2;
    private static final long serialVersionUID = 5204927143605193821L;
    private final double accuracy;
    private final double bandwidth;
    private final int robustnessIters;

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public /* bridge */ /* synthetic */ UnivariateRealFunction interpolate(double[] r1, double[] r2) throws MathException {
        return interpolate(r1, r2);
    }

    public LoessInterpolator() {
        this.bandwidth = 0.3d;
        this.robustnessIters = 2;
        this.accuracy = 1.0E-12d;
    }

    public LoessInterpolator(double bandwidth, int robustnessIters) throws MathException {
        this(bandwidth, robustnessIters, 1.0E-12d);
    }

    public LoessInterpolator(double bandwidth, int robustnessIters, double accuracy) throws MathException {
        if (bandwidth < 0.0d) goto L13;
        if (bandwidth > 1.0d) goto L13;
        this.bandwidth = bandwidth;
        if (robustnessIters < 0) goto L11;
        this.robustnessIters = robustnessIters;
        this.accuracy = accuracy;
        return;
    L11:
        throw new MathException(LocalizedFormats.NEGATIVE_ROBUSTNESS_ITERATIONS, new Object[]{Integer.valueOf(robustnessIters)});
    L13:
        throw new MathException(LocalizedFormats.BANDWIDTH_OUT_OF_INTERVAL, new Object[]{Double.valueOf(bandwidth)});
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public final PolynomialSplineFunction interpolate(double[] xval, double[] yval) throws MathException {
        return new SplineInterpolator().interpolate(xval, smooth(xval, yval));
    }

    public final double[] smooth(double[] xval, double[] yval, double[] weights) throws MathException {
        double[] r3 = weights;
        char r4 = 2;
        int r5 = 0;
        char r6 = 1;
        if (xval.length != yval.length) goto L59;
        int n = xval.length;
        if (n == 0) goto L57;
        checkAllFiniteReal(xval, LocalizedFormats.NON_REAL_FINITE_ABSCISSA);
        checkAllFiniteReal(yval, LocalizedFormats.NON_REAL_FINITE_ORDINATE);
        checkAllFiniteReal(r3, LocalizedFormats.NON_REAL_FINITE_WEIGHT);
        checkStrictlyIncreasing(xval);
        if (n == 1) goto L9;
        if (n == 2) goto L12;
        int bandwidthInPoints = (int) (this.bandwidth * ((double) n));
        if (bandwidthInPoints < 2) goto L55;
        double[] res = new double[n];
        double[] residuals = new double[n];
        double[] sortedResiduals = new double[n];
        double[] robustnessWeights = new double[n];
        double r13 = 1.0d;
        Arrays.fill(robustnessWeights, 1.0d);
        int iter = 0;
    L16:
        char r16 = r4;
        if (iter > this.robustnessIters) goto L53;
        int[] bandwidthInterval = {r5, bandwidthInPoints - 1};
        char r18 = r6;
        int i = 0;
    L19:
        if (i >= n) goto L39;
        double x = xval[i];
        if (i <= 0) goto L23;
        updateBandwidthInterval(xval, r3, i, bandwidthInterval);
    L23:
        int ileft = bandwidthInterval[r5];
        double r21 = r13;
        int iright = bandwidthInterval[r18];
        if ((xval[i] - xval[ileft]) <= (xval[iright] - xval[i])) goto L26;
        int edge = ileft;
    L27:
        double sumWeights = 0.0d;
        double sumX = 0.0d;
        double sumXSquared = 0.0d;
        double sumY = 0.0d;
        double sumXY = 0.0d;
        double denom = FastMath.abs(r21 / (xval[edge] - x));
        int k = ileft;
    L28:
        if (k > iright) goto L34;
        double xk = xval[k];
        double yk = yval[k];
        if (k >= i) goto L32;
        double dist = x - xk;
    L33:
        double w = (tricube(dist * denom) * robustnessWeights[k]) * r3[k];
        double xkw = xk * w;
        sumWeights = sumWeights + w;
        sumX = sumX + xkw;
        sumXSquared = sumXSquared + (xk * xkw);
        sumY = sumY + (yk * w);
        sumXY = sumXY + (yk * xkw);
        k = k + 1;
        goto L28
    L32:
        dist = xk - x;
        goto L33
    L34:
        double meanX = sumX / sumWeights;
        double meanY = sumY / sumWeights;
        double meanXY = sumXY / sumWeights;
        double meanXSquared = sumXSquared / sumWeights;
        int[] bandwidthInterval2 = bandwidthInterval;
        if (FastMath.sqrt(FastMath.abs(meanXSquared - (meanX * meanX))) >= this.accuracy) goto L37;
        double beta = 0.0d;
    L38:
        double alpha = meanY - (beta * meanX);
        res[i] = (beta * x) + alpha;
        residuals[i] = FastMath.abs(yval[i] - res[i]);
        i = i + 1;
        r3 = weights;
        bandwidthInterval = bandwidthInterval2;
        r13 = r21;
        r5 = 0;
        goto L19
    L37:
        double beta2 = meanX * meanY;
        beta = (meanXY - beta2) / (meanXSquared - (meanX * meanX));
        goto L38
    L26:
        edge = iright;
        goto L27
    L39:
        double r22 = r13;
        if (iter == this.robustnessIters) goto L53;
        System.arraycopy(residuals, 0, sortedResiduals, 0, n);
        Arrays.sort(sortedResiduals);
        double medianResidual = sortedResiduals[n / 2];
        if (FastMath.abs(medianResidual) < this.accuracy) goto L53;
        int i2 = 0;
    L46:
        if (i2 >= n) goto L52;
        double arg = residuals[i2] / (6.0d * medianResidual);
        if (arg < r22) goto L50;
        robustnessWeights[i2] = 0.0d;
    L51:
        i2 = i2 + 1;
        goto L46
    L50:
        double w2 = r22 - (arg * arg);
        robustnessWeights[i2] = w2 * w2;
        goto L51
    L52:
        iter = iter + 1;
        r3 = weights;
        r4 = r16;
        r6 = r18;
        r13 = r22;
        r5 = 0;
    L53:
        return res;
    L55:
        throw new MathException(LocalizedFormats.TOO_SMALL_BANDWIDTH, new Object[]{Integer.valueOf(n), Double.valueOf(2.0d / ((double) n)), Double.valueOf(this.bandwidth)});
    L12:
        return new double[]{yval[0], yval[1]};
    L9:
        return new double[]{yval[0]};
    L57:
        throw new MathException(LocalizedFormats.LOESS_EXPECTS_AT_LEAST_ONE_POINT, new Object[0]);
    L59:
        throw new MathException(LocalizedFormats.MISMATCHED_LOESS_ABSCISSA_ORDINATE_ARRAYS, new Object[]{Integer.valueOf(xval.length), Integer.valueOf(yval.length)});
    }

    public final double[] smooth(double[] xval, double[] yval) throws MathException {
        if (xval.length != yval.length) goto L7;
        double[] unitWeights = new double[xval.length];
        Arrays.fill(unitWeights, 1.0d);
        return smooth(xval, yval, unitWeights);
    L7:
        throw new MathException(LocalizedFormats.MISMATCHED_LOESS_ABSCISSA_ORDINATE_ARRAYS, new Object[]{Integer.valueOf(xval.length), Integer.valueOf(yval.length)});
    }

    private static void updateBandwidthInterval(double[] xval, double[] weights, int i, int[] bandwidthInterval) {
        int left = bandwidthInterval[0];
        int right = bandwidthInterval[1];
        int nextRight = nextNonzero(weights, right);
        if (nextRight < xval.length) goto L5;
        return;
    L5:
        if ((xval[nextRight] - xval[i]) >= (xval[i] - xval[left])) goto L9;
        int nextLeft = nextNonzero(weights, bandwidthInterval[0]);
        bandwidthInterval[0] = nextLeft;
        bandwidthInterval[1] = nextRight;
        return;
    }

    private static int nextNonzero(double[] weights, int i) {
        int j = i + 1;
    L4:
        if (j >= weights.length) goto L8;
        if (weights[j] != 0.0d) goto L8;
        j = j + 1;
    L8:
        return j;
    }

    private static double tricube(double x) {
        double tmp = 1.0d - ((x * x) * x);
        return (tmp * tmp) * tmp;
    }

    private static void checkAllFiniteReal(double[] values, Localizable pattern) throws MathException {
        int i = 0;
    L4:
        if (i >= values.length) goto L13;
        double x = values[i];
        if (Double.isInfinite(x) == true) goto L11;
        if (Double.isNaN(x) == true) goto L11;
        i = i + 1;
    L11:
        throw new MathException(pattern, new Object[]{Integer.valueOf(i), Double.valueOf(x)});
    }

    private static void checkStrictlyIncreasing(double[] xval) throws MathException {
        int i = 0;
    L4:
        if (i >= xval.length) goto L14;
        if (i < 1) goto L12;
        if (xval[i - 1] < xval[i]) goto L12;
        throw new MathException(LocalizedFormats.OUT_OF_ORDER_ABSCISSA_ARRAY, new Object[]{Integer.valueOf(i - 1), Double.valueOf(xval[i - 1]), Integer.valueOf(i), Double.valueOf(xval[i])});
    L12:
        i = i + 1;
        goto L4
    }
}
