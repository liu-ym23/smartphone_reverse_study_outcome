package org.apache.commons.math.analysis.polynomials;

import org.apache.commons.math.DuplicateSampleAbscissaException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class PolynomialFunctionLagrangeForm implements UnivariateRealFunction {
    private double[] coefficients;
    private boolean coefficientsComputed;
    private final double[] x;
    private final double[] y;

    public PolynomialFunctionLagrangeForm(double[] x, double[] y) throws IllegalArgumentException {
        verifyInterpolationArray(x, y);
        this.x = new double[x.length];
        this.y = new double[y.length];
        System.arraycopy(x, 0, this.x, 0, x.length);
        System.arraycopy(y, 0, this.y, 0, y.length);
        this.coefficientsComputed = false;
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double z) throws FunctionEvaluationException {
        return evaluate(this.x, this.y, z);
    L4:
        e = move-exception;
        throw new FunctionEvaluationException(z, e.getSpecificPattern(), new Object[]{e.getGeneralPattern(), e.getArguments()});
    }

    public int degree() {
        return this.x.length - 1;
    }

    public double[] getInterpolatingPoints() {
        double[] out = new double[this.x.length];
        System.arraycopy(this.x, 0, out, 0, this.x.length);
        return out;
    }

    public double[] getInterpolatingValues() {
        double[] out = new double[this.y.length];
        System.arraycopy(this.y, 0, out, 0, this.y.length);
        return out;
    }

    public double[] getCoefficients() {
        if (this.coefficientsComputed == true) goto L5;
        computeCoefficients();
    L5:
        double[] out = new double[this.coefficients.length];
        System.arraycopy(this.coefficients, 0, out, 0, this.coefficients.length);
        return out;
    }

    public static double evaluate(double[] x, double[] y, double z) throws DuplicateSampleAbscissaException, IllegalArgumentException {
        double[] r0 = x;
        verifyInterpolationArray(x, y);
        int nearest = 0;
        int n = r0.length;
        double[] c = new double[n];
        double[] d = new double[n];
        double min_dist = Double.POSITIVE_INFINITY;
        int i = 0;
    L3:
        if (i >= n) goto L8;
        c[i] = y[i];
        d[i] = y[i];
        double dist = FastMath.abs(z - r0[i]);
        if (dist >= min_dist) goto L7;
        nearest = i;
        min_dist = dist;
    L7:
        i = i + 1;
        goto L3
    L8:
        double value = y[nearest];
        int i2 = 1;
    L9:
        if (i2 >= n) goto L24;
        int j = 0;
    L12:
        if (j >= (n - i2)) goto L18;
        double tc = r0[j] - z;
        double td = r0[i2 + j] - z;
        double divider = r0[j] - r0[i2 + j];
        if (divider == 0.0d) goto L17;
        double w = (c[j + 1] - d[j]) / divider;
        c[j] = tc * w;
        d[j] = td * w;
        j = j + 1;
        goto L12
    L17:
        throw new DuplicateSampleAbscissaException(x[i2], i2, i2 + j);
    L18:
        int n2 = n;
        double[] c2 = c;
        double[] d2 = d;
        if (nearest >= (((double) ((n2 - i2) + 1)) * 0.5d)) goto L21;
        double r2 = c2[nearest];
    L22:
        value = value + r2;
        i2 = i2 + 1;
        r0 = x;
        n = n2;
        c = c2;
        d = d2;
        goto L9
    L21:
        nearest = nearest - 1;
        r2 = d2[nearest];
        goto L22
    L24:
        return value;
    }

    protected void computeCoefficients() throws ArithmeticException {
        int n = degree() + 1;
        this.coefficients = new double[n];
        int i = 0;
    L3:
        double r4 = 0.0d;
        if (i >= n) goto L6;
        this.coefficients[i] = 0.0d;
        i = i + 1;
        goto L3
    L6:
        int i2 = n + 1;
        double[] c = new double[i2];
        c[0] = 1.0d;
        int i3 = 0;
    L7:
        if (i3 >= n) goto L12;
        int j = i3;
    L9:
        if (j <= 0) goto L11;
        c[j] = c[j - 1] - (c[j] * this.x[i3]);
        j = j - 1;
        goto L9
    L11:
        c[0] = c[0] * (-this.x[i3]);
        c[i3 + 1] = 1.0d;
        i3 = i3 + 1;
        goto L7
    L12:
        double[] tc = new double[n];
        int i4 = 0;
    L13:
        if (i4 >= n) goto L34;
        double d = 1.0d;
        int j2 = 0;
    L15:
        if (j2 >= n) goto L20;
        if (i4 == j2) goto L18;
        d = d * (this.x[i4] - this.x[j2]);
    L18:
        j2 = j2 + 1;
        goto L15
    L20:
        if (d != r4) goto L30;
        int k = 0;
    L22:
        if (k >= n) goto L30;
        if (i4 == k) goto L29;
        if (this.x[i4] != this.x[k]) goto L29;
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.IDENTICAL_ABSCISSAS_DIVISION_BY_ZERO, new Object[]{Integer.valueOf(i4), Integer.valueOf(k), Double.valueOf(this.x[i4])});
    L29:
        k = k + 1;
    L30:
        double t = this.y[i4] / d;
        tc[n - 1] = c[n];
        double[] r12 = this.coefficients;
        int r13 = n - 1;
        r12[r13] = r12[r13] + (tc[n - 1] * t);
        int j3 = n - 2;
    L31:
        if (j3 < 0) goto L33;
        tc[j3] = c[j3 + 1] + (tc[j3 + 1] * this.x[i4]);
        double[] r5 = this.coefficients;
        r5[j3] = r5[j3] + (tc[j3] * t);
        j3 = j3 - 1;
        goto L31
    L33:
        i4 = i4 + 1;
        r4 = 0.0d;
        goto L13
    L34:
        this.coefficientsComputed = true;
    }

    public static void verifyInterpolationArray(double[] x, double[] y) throws IllegalArgumentException {
        if (x.length != y.length) goto L10;
        if (x.length < 2) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, new Object[]{2, Integer.valueOf(x.length)});
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(x.length), Integer.valueOf(y.length)});
    }
}
