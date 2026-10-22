package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.analysis.BivariateRealFunction;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.exception.OutOfRangeException;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BicubicSplineInterpolatingFunction implements BivariateRealFunction {
    private static final double[][] AINV = null;
    private BivariateRealFunction[][][] partialDerivatives;
    private final BicubicSplineFunction[][] splines;
    private final double[] xval;
    private final double[] yval;

    static {
        AINV = new double[][]{new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d}, new double[]{9.0d, -9.0d, -9.0d, 9.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 4.0d, 2.0d, 2.0d, 1.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -3.0d, -3.0d, 3.0d, 3.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, -2.0d, -1.0d, -1.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -2.0d, 4.0d, 2.0d, -3.0d, 3.0d, -3.0d, 3.0d, -2.0d, -1.0d, -2.0d, -1.0d}, new double[]{4.0d, -4.0d, -4.0d, 4.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 1.0d, 1.0d, 1.0d, 1.0d}};
    }

    public BicubicSplineInterpolatingFunction(double[] x, double[] y, double[][] f, double[][] dFdX, double[][] dFdY, double[][] d2FdXdY) throws DimensionMismatchException {
        char r5 = 2;
        char r6 = 0;
        char r7 = 1;
        this.partialDerivatives = null;
        int xLen = x.length;
        int yLen = y.length;
        if (xLen == 0) goto L50;
        if (yLen == 0) goto L50;
        if (f.length == 0) goto L50;
        if (f[0].length == 0) goto L50;
        if (xLen != f.length) goto L48;
        if (xLen != dFdX.length) goto L46;
        if (xLen != dFdY.length) goto L44;
        if (xLen != d2FdXdY.length) goto L42;
        MathUtils.checkOrder(x);
        MathUtils.checkOrder(y);
        this.xval = (double[]) x.clone();
        this.yval = (double[]) y.clone();
        int lastI = xLen - 1;
        int lastJ = yLen - 1;
        this.splines = (BicubicSplineFunction[][]) Array.newInstance(BicubicSplineFunction.class, new int[]{lastI, lastJ});
        int i = 0;
    L18:
        if (i >= lastI) goto L40;
        if (f[i].length != yLen) goto L38;
        if (dFdX[i].length != yLen) goto L36;
        if (dFdY[i].length != yLen) goto L34;
        if (d2FdXdY[i].length != yLen) goto L32;
        int ip1 = i + 1;
        char r17 = r5;
        int j = 0;
    L28:
        if (j >= lastJ) goto L30;
        int jp1 = j + 1;
        double r18 = f[i][j];
        double r20 = f[ip1][j];
        double r22 = f[i][jp1];
        double r24 = f[ip1][jp1];
        double r26 = dFdX[i][j];
        double r28 = dFdX[ip1][j];
        double r30 = dFdX[i][jp1];
        double r32 = dFdX[ip1][jp1];
        double r34 = dFdY[i][j];
        double r36 = dFdY[ip1][j];
        double r38 = dFdY[i][jp1];
        double r40 = dFdY[ip1][jp1];
        double r42 = d2FdXdY[i][j];
        double r44 = d2FdXdY[ip1][j];
        double r46 = d2FdXdY[i][jp1];
        double r48 = d2FdXdY[ip1][jp1];
        char r50 = r6;
        double[] beta = new double[16];
        beta[r50] = r18;
        beta[r7] = r20;
        beta[r17] = r22;
        beta[3] = r24;
        beta[4] = r26;
        beta[5] = r28;
        beta[6] = r30;
        beta[7] = r32;
        beta[8] = r34;
        beta[9] = r36;
        beta[10] = r38;
        beta[11] = r40;
        beta[12] = r42;
        beta[13] = r44;
        beta[14] = r46;
        beta[15] = r48;
        int j2 = j;
        this.splines[i][j2] = new BicubicSplineFunction(computeSplineCoefficients(beta));
        j = j2 + 1;
        r7 = r7;
        r6 = r50;
        goto L28
    L30:
        i = i + 1;
        r5 = r17;
        goto L18
    L32:
        throw new DimensionMismatchException(d2FdXdY[i].length, yLen);
    L34:
        throw new DimensionMismatchException(dFdY[i].length, yLen);
    L36:
        throw new DimensionMismatchException(dFdX[i].length, yLen);
    L38:
        throw new DimensionMismatchException(f[i].length, yLen);
    L40:
        return;
    L42:
        throw new DimensionMismatchException(xLen, d2FdXdY.length);
    L44:
        throw new DimensionMismatchException(xLen, dFdY.length);
    L46:
        throw new DimensionMismatchException(xLen, dFdX.length);
    L48:
        throw new DimensionMismatchException(xLen, f.length);
    L50:
        throw new NoDataException();
    }

    @Override // org.apache.commons.math.analysis.BivariateRealFunction
    public double value(double x, double y) {
        int i = searchIndex(x, this.xval);
        if (i == (-1)) goto L11;
        int j = searchIndex(y, this.yval);
        if (j == (-1)) goto L9;
        double xN = (x - this.xval[i]) / (this.xval[i + 1] - this.xval[i]);
        double yN = (y - this.yval[j]) / (this.yval[j + 1] - this.yval[j]);
        return this.splines[i][j].value(xN, yN);
    L9:
        throw new OutOfRangeException(Double.valueOf(y), Double.valueOf(this.yval[0]), Double.valueOf(this.yval[this.yval.length - 1]));
    L11:
        throw new OutOfRangeException(Double.valueOf(x), Double.valueOf(this.xval[0]), Double.valueOf(this.xval[this.xval.length - 1]));
    }

    public double partialDerivativeX(double x, double y) {
        return partialDerivative(0, x, y);
    }

    public double partialDerivativeY(double x, double y) {
        return partialDerivative(1, x, y);
    }

    public double partialDerivativeXX(double x, double y) {
        return partialDerivative(2, x, y);
    }

    public double partialDerivativeYY(double x, double y) {
        return partialDerivative(3, x, y);
    }

    public double partialDerivativeXY(double x, double y) {
        return partialDerivative(4, x, y);
    }

    private double partialDerivative(int which, double x, double y) {
        if (this.partialDerivatives != null) goto L5;
        computePartialDerivatives();
    L5:
        int i = searchIndex(x, this.xval);
        if (i == (-1)) goto L18;
        int j = searchIndex(y, this.yval);
        if (j == (-1)) goto L16;
        double xN = (x - this.xval[i]) / (this.xval[i + 1] - this.xval[i]);
        double yN = (y - this.yval[j]) / (this.yval[j + 1] - this.yval[j]);
        return this.partialDerivatives[which][i][j].value(xN, yN);
    L12:
        fee = move-exception;
        throw new RuntimeException(fee);
    L16:
        throw new OutOfRangeException(Double.valueOf(y), Double.valueOf(this.yval[0]), Double.valueOf(this.yval[this.yval.length - 1]));
    L18:
        throw new OutOfRangeException(Double.valueOf(x), Double.valueOf(this.xval[0]), Double.valueOf(this.xval[this.xval.length - 1]));
    }

    private void computePartialDerivatives() {
        int lastI = this.xval.length - 1;
        int lastJ = this.yval.length - 1;
        this.partialDerivatives = (BivariateRealFunction[][][]) Array.newInstance(BivariateRealFunction.class, new int[]{5, lastI, lastJ});
        int i = 0;
    L3:
        if (i >= lastI) goto L9;
        int j = 0;
    L5:
        if (j >= lastJ) goto L7;
        BicubicSplineFunction f = this.splines[i][j];
        this.partialDerivatives[0][i][j] = f.partialDerivativeX();
        this.partialDerivatives[1][i][j] = f.partialDerivativeY();
        this.partialDerivatives[2][i][j] = f.partialDerivativeXX();
        this.partialDerivatives[3][i][j] = f.partialDerivativeYY();
        this.partialDerivatives[4][i][j] = f.partialDerivativeXY();
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    }

    private int searchIndex(double c, double[] val) {
        if (c >= val[0]) goto L5;
        return -1;
    L5:
        int max = val.length;
        int i = 1;
    L6:
        if (i >= max) goto L13;
        if (c <= val[i]) goto L10;
        i = i + 1;
        goto L6
    L10:
        return i - 1;
    L13:
        return -1;
    }

    private double[] computeSplineCoefficients(double[] beta) {
        double[] a = new double[16];
        int i = 0;
    L3:
        if (i >= 16) goto L9;
        double result = 0.0d;
        double[] row = AINV[i];
        int j = 0;
    L5:
        if (j >= 16) goto L7;
        result = result + (row[j] * beta[j]);
        j = j + 1;
        goto L5
    L7:
        a[i] = result;
        i = i + 1;
        goto L3
    L9:
        return a;
    }
}
