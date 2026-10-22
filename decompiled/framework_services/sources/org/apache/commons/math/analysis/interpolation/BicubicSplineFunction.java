package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.analysis.BivariateRealFunction;
import org.apache.commons.math.exception.OutOfRangeException;

/* JADX INFO: compiled from: BicubicSplineInterpolatingFunction.java */
/* JADX INFO: loaded from: classes3.dex */
class BicubicSplineFunction implements BivariateRealFunction {
    private static final short N = 4;
    private final double[][] a;
    private BivariateRealFunction partialDerivativeX;
    private BivariateRealFunction partialDerivativeXX;
    private BivariateRealFunction partialDerivativeXY;
    private BivariateRealFunction partialDerivativeY;
    private BivariateRealFunction partialDerivativeYY;

    static /* synthetic */ double access$000(BicubicSplineFunction x0, double[] x1, double[] x2, double[][] x3) {
        return x0.apply(x1, x2, x3);
    }

    public BicubicSplineFunction(double[] a) {
        this.a = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        int i = 0;
    L3:
        if (i >= 4) goto L9;
        int j = 0;
    L5:
        if (j >= 4) goto L7;
        this.a[i][j] = a[(j * 4) + i];
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    }

    @Override // org.apache.commons.math.analysis.BivariateRealFunction
    public double value(double x, double y) {
        if (x < 0.0d) goto L15;
        if (x > 1.0d) goto L15;
        if (y < 0.0d) goto L13;
        if (y > 1.0d) goto L13;
        double x2 = x * x;
        double x3 = x2 * x;
        double[] pX = {1.0d, x, x2, x3};
        double y2 = y * y;
        double y3 = y2 * y;
        double[] pY = {1.0d, y, y2, y3};
        return apply(pX, pY, this.a);
    L13:
        throw new OutOfRangeException(Double.valueOf(y), 0, 1);
    L15:
        throw new OutOfRangeException(Double.valueOf(x), 0, 1);
    }

    private double apply(double[] pX, double[] pY, double[][] coeff) {
        double result = 0.0d;
        int i = 0;
    L4:
        if (i >= 4) goto L10;
        int j = 0;
    L6:
        if (j >= 4) goto L8;
        result = result + ((coeff[i][j] * pX[i]) * pY[j]);
        j = j + 1;
        goto L6
    L8:
        i = i + 1;
        goto L4
    L10:
        return result;
    }

    public BivariateRealFunction partialDerivativeX() {
        if (this.partialDerivativeX != null) goto L6;
        computePartialDerivatives();
    L6:
        return this.partialDerivativeX;
    }

    public BivariateRealFunction partialDerivativeY() {
        if (this.partialDerivativeY != null) goto L6;
        computePartialDerivatives();
    L6:
        return this.partialDerivativeY;
    }

    public BivariateRealFunction partialDerivativeXX() {
        if (this.partialDerivativeXX != null) goto L6;
        computePartialDerivatives();
    L6:
        return this.partialDerivativeXX;
    }

    public BivariateRealFunction partialDerivativeYY() {
        if (this.partialDerivativeYY != null) goto L6;
        computePartialDerivatives();
    L6:
        return this.partialDerivativeYY;
    }

    public BivariateRealFunction partialDerivativeXY() {
        if (this.partialDerivativeXY != null) goto L6;
        computePartialDerivatives();
    L6:
        return this.partialDerivativeXY;
    }

    private void computePartialDerivatives() {
        final double[][] aX = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] aY = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] aXX = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] aYY = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] aXY = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        int i = 0;
    L3:
        if (i >= 4) goto L8;
        int j = 0;
    L5:
        if (j >= 4) goto L7;
        double c = this.a[i][j];
        aX[i][j] = ((double) i) * c;
        aY[i][j] = ((double) j) * c;
        aXX[i][j] = ((double) (i - 1)) * aX[i][j];
        aYY[i][j] = ((double) (j - 1)) * aY[i][j];
        aXY[i][j] = ((double) j) * aX[i][j];
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L8:
        this.partialDerivativeX = new AnonymousClass1(this, aX);
        this.partialDerivativeY = new AnonymousClass2(this, aY);
        this.partialDerivativeXX = new AnonymousClass3(this, aXX);
        this.partialDerivativeYY = new AnonymousClass4(this, aYY);
        this.partialDerivativeXY = new AnonymousClass5(this, aXY);
    }
}
