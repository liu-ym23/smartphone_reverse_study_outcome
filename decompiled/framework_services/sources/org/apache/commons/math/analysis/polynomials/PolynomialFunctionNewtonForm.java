package org.apache.commons.math.analysis.polynomials;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class PolynomialFunctionNewtonForm implements UnivariateRealFunction {
    private final double[] a;
    private final double[] c;
    private double[] coefficients;
    private boolean coefficientsComputed;

    public PolynomialFunctionNewtonForm(double[] a, double[] c) throws IllegalArgumentException {
        verifyInputArray(a, c);
        this.a = new double[a.length];
        this.c = new double[c.length];
        System.arraycopy(a, 0, this.a, 0, a.length);
        System.arraycopy(c, 0, this.c, 0, c.length);
        this.coefficientsComputed = false;
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double z) throws FunctionEvaluationException {
        return evaluate(this.a, this.c, z);
    }

    public int degree() {
        return this.c.length;
    }

    public double[] getNewtonCoefficients() {
        double[] out = new double[this.a.length];
        System.arraycopy(this.a, 0, out, 0, this.a.length);
        return out;
    }

    public double[] getCenters() {
        double[] out = new double[this.c.length];
        System.arraycopy(this.c, 0, out, 0, this.c.length);
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

    public static double evaluate(double[] a, double[] c, double z) throws FunctionEvaluationException, IllegalArgumentException {
        verifyInputArray(a, c);
        int n = c.length;
        double value = a[n];
        int i = n - 1;
    L3:
        if (i < 0) goto L6;
        value = a[i] + ((z - c[i]) * value);
        i = i - 1;
        goto L3
    L6:
        return value;
    }

    protected void computeCoefficients() {
        int n = degree();
        this.coefficients = new double[n + 1];
        int i = 0;
    L3:
        if (i > n) goto L5;
        this.coefficients[i] = 0.0d;
        i = i + 1;
        goto L3
    L5:
        this.coefficients[0] = this.a[n];
        int i2 = n - 1;
    L6:
        if (i2 < 0) goto L11;
        int j = n - i2;
    L8:
        if (j <= 0) goto L10;
        this.coefficients[j] = this.coefficients[j - 1] - (this.c[i2] * this.coefficients[j]);
        j = j - 1;
        goto L8
    L10:
        this.coefficients[0] = this.a[i2] - (this.c[i2] * this.coefficients[0]);
        i2 = i2 - 1;
        goto L6
    L11:
        this.coefficientsComputed = true;
    }

    protected static void verifyInputArray(double[] a, double[] c) throws IllegalArgumentException {
        if (a.length < 1) goto L12;
        if (c.length < 1) goto L12;
        if (a.length != (c.length + 1)) goto L10;
        return;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1, new Object[]{Integer.valueOf(a.length), Integer.valueOf(c.length)});
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY, new Object[0]);
    }
}
