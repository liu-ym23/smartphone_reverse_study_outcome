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
public class LinearInterpolator implements UnivariateRealInterpolator {
    public LinearInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public /* bridge */ /* synthetic */ UnivariateRealFunction interpolate(double[] r1, double[] r2) throws MathException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public PolynomialSplineFunction interpolate(double[] x, double[] y) {
        if (x.length != y.length) goto L17;
        if (x.length < 2) goto L15;
        int n = x.length - 1;
        MathUtils.checkOrder(x);
        double[] m = new double[n];
        int i = 0;
    L7:
        if (i >= n) goto L9;
        m[i] = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
        i = i + 1;
        goto L7
    L9:
        PolynomialFunction[] polynomials = new PolynomialFunction[n];
        double[] coefficients = new double[2];
        int i2 = 0;
    L10:
        if (i2 >= n) goto L13;
        coefficients[0] = y[i2];
        coefficients[1] = m[i2];
        polynomials[i2] = new PolynomialFunction(coefficients);
        i2 = i2 + 1;
        goto L10
    L13:
        return new PolynomialSplineFunction(x, polynomials);
    L15:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(x.length), 2, true);
    L17:
        throw new DimensionMismatchException(x.length, y.length);
    }
}
