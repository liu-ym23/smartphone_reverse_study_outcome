package org.apache.commons.math.analysis.interpolation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NumberIsTooSmallException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SplineInterpolator implements UnivariateRealInterpolator {
    public SplineInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public /* bridge */ /* synthetic */ UnivariateRealFunction interpolate(double[] r1, double[] r2) throws MathException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public PolynomialSplineFunction interpolate(double[] x, double[] y) {
        if (x.length != y.length) goto L24;
        if (x.length < 3) goto L22;
        int n = x.length - 1;
        MathUtils.checkOrder(x);
        double[] h = new double[n];
        int i = 0;
    L7:
        if (i >= n) goto L9;
        h[i] = x[i + 1] - x[i];
        i = i + 1;
        goto L7
    L9:
        double[] mu = new double[n];
        double[] z = new double[n + 1];
        mu[0] = 0.0d;
        z[0] = 0.0d;
        int i2 = 1;
    L11:
        if (i2 >= n) goto L13;
        double g = ((x[i2 + 1] - x[i2 - 1]) * 2.0d) - (h[i2 - 1] * mu[i2 - 1]);
        mu[i2] = h[i2] / g;
        z[i2] = ((((((y[i2 + 1] * h[i2 - 1]) - (y[i2] * (x[i2 + 1] - x[i2 - 1]))) + (y[i2 - 1] * h[i2])) * 3.0d) / (h[i2 - 1] * h[i2])) - (h[i2 - 1] * z[i2 - 1])) / g;
        i2 = i2 + 1;
        goto L11
    L13:
        double[] b = new double[n];
        double[] c = new double[n + 1];
        double[] d = new double[n];
        z[n] = 0.0d;
        c[n] = 0.0d;
        int j = n - 1;
    L14:
        if (j < 0) goto L16;
        c[j] = z[j] - (mu[j] * c[j + 1]);
        b[j] = ((y[j + 1] - y[j]) / h[j]) - ((h[j] * (c[j + 1] + (c[j] * 2.0d))) / 3.0d);
        d[j] = (c[j + 1] - c[j]) / (h[j] * 3.0d);
        j = j - 1;
        goto L14
    L16:
        PolynomialFunction[] polynomials = new PolynomialFunction[n];
        double[] coefficients = new double[4];
        int i3 = 0;
    L17:
        if (i3 >= n) goto L20;
        coefficients[0] = y[i3];
        coefficients[1] = b[i3];
        coefficients[2] = c[i3];
        coefficients[3] = d[i3];
        polynomials[i3] = new PolynomialFunction(coefficients);
        i3 = i3 + 1;
        goto L17
    L20:
        return new PolynomialSplineFunction(x, polynomials);
    L22:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(x.length), 3, true);
    L24:
        throw new DimensionMismatchException(x.length, y.length);
    }
}
