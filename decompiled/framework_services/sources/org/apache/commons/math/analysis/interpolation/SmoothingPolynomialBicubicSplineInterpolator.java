package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.BivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.optimization.fitting.PolynomialFitter;
import org.apache.commons.math.optimization.general.GaussNewtonOptimizer;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SmoothingPolynomialBicubicSplineInterpolator extends BicubicSplineInterpolator {
    private final PolynomialFitter xFitter;
    private final PolynomialFitter yFitter;

    @Override // org.apache.commons.math.analysis.interpolation.BicubicSplineInterpolator, org.apache.commons.math.analysis.interpolation.BivariateRealGridInterpolator
    public /* bridge */ /* synthetic */ BivariateRealFunction interpolate(double[] r1, double[] r2, double[][] r3) throws MathException {
        return interpolate(r1, r2, r3);
    }

    public SmoothingPolynomialBicubicSplineInterpolator() {
        this(3);
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int degree) {
        this(degree, degree);
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int xDegree, int yDegree) {
        this.xFitter = new PolynomialFitter(xDegree, new GaussNewtonOptimizer(false));
        this.yFitter = new PolynomialFitter(yDegree, new GaussNewtonOptimizer(false));
    }

    @Override // org.apache.commons.math.analysis.interpolation.BicubicSplineInterpolator, org.apache.commons.math.analysis.interpolation.BivariateRealGridInterpolator
    public BicubicSplineInterpolatingFunction interpolate(double[] r25, double[] r26, double[][] r27) throws MathException {
        if (r25.length == 0) goto L46;
        if (r26.length == 0) goto L46;
        if (r27.length == 0) goto L46;
        if (r25.length != r27.length) goto L44;
        int r4 = r25.length;
        int r5 = r26.length;
        int r6 = 0;
    L11:
        if (r6 >= r4) goto L17;
        if (r27[r6].length != r5) goto L16;
        r6 = r6 + 1;
        goto L11
    L16:
        throw new DimensionMismatchException(r27[r6].length, r5);
    L17:
        MathUtils.checkOrder(r25);
        MathUtils.checkOrder(r26);
        PolynomialFunction[] r7 = new PolynomialFunction[r5];
        int r8 = 0;
    L18:
        if (r8 >= r5) goto L23;
        this.xFitter.clearObservations();
        int r9 = 0;
    L20:
        if (r9 >= r4) goto L22;
        this.xFitter.addObservedPoint(1.0d, r25[r9], r27[r9][r8]);
        r9 = r9 + 1;
        goto L20
    L22:
        r7[r8] = this.xFitter.fit();
        r8 = r8 + 1;
        goto L18
    L23:
        boolean r10 = true;
        boolean r11 = false;
        double[][] r12 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, r5});
        int r13 = 0;
    L24:
        if (r13 >= r5) goto L29;
        PolynomialFunction r14 = r7[r13];
        int r15 = 0;
    L26:
        if (r15 >= r4) goto L28;
        r12[r15][r13] = r14.value(r25[r15]);
        r15 = r15 + 1;
        r10 = r10;
        r11 = r11;
        goto L26
    L28:
        r13 = r13 + 1;
        goto L24
    L29:
        boolean r16 = r10;
        boolean r17 = r11;
        PolynomialFunction[] r18 = new PolynomialFunction[r4];
        int r19 = 0;
    L30:
        if (r19 >= r4) goto L35;
        this.yFitter.clearObservations();
        int r110 = 0;
    L32:
        if (r110 >= r5) goto L34;
        this.yFitter.addObservedPoint(1.0d, r26[r110], r12[r19][r110]);
        r110 = r110 + 1;
        goto L32
    L34:
        r18[r19] = this.yFitter.fit();
        r19 = r19 + 1;
        goto L30
    L35:
        int[] r20 = new int[2];
        r20[r16 ? 1 : 0] = r5;
        r20[r17 ? 1 : 0] = r4;
        double[][] r21 = (double[][]) Array.newInstance(Double.TYPE, r20);
        int r111 = 0;
    L36:
        if (r111 >= r4) goto L42;
        PolynomialFunction r112 = r18[r111];
        int r113 = 0;
    L38:
        if (r113 >= r5) goto L40;
        r21[r111][r113] = r112.value(r26[r113]);
        r113 = r113 + 1;
        goto L38
    L40:
        r111 = r111 + 1;
        goto L36
    L42:
        return super.interpolate(r25, r26, r21);
    L44:
        throw new DimensionMismatchException(r25.length, r27.length);
    L46:
        throw new NoDataException();
    }
}
