package org.apache.commons.math.analysis.polynomials;

import java.util.Arrays;
import org.apache.commons.math.ArgumentOutsideDomainException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class PolynomialSplineFunction implements DifferentiableUnivariateRealFunction {
    private final double[] knots;
    private final int n;
    private final PolynomialFunction[] polynomials;

    public PolynomialSplineFunction(double[] knots, PolynomialFunction[] polynomials) {
        if (knots.length < 2) goto L15;
        if ((knots.length - 1) != polynomials.length) goto L13;
        if (isStrictlyIncreasing(knots) == false) goto L11;
        this.n = knots.length - 1;
        this.knots = new double[this.n + 1];
        System.arraycopy(knots, 0, this.knots, 0, this.n + 1);
        this.polynomials = new PolynomialFunction[this.n];
        System.arraycopy(polynomials, 0, this.polynomials, 0, this.n);
        return;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_STRICTLY_INCREASING_KNOT_VALUES, new Object[0]);
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POLYNOMIAL_INTERPOLANTS_MISMATCH_SEGMENTS, new Object[]{Integer.valueOf(polynomials.length), Integer.valueOf(knots.length)});
    L15:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION, new Object[]{2, Integer.valueOf(knots.length)});
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double v) throws ArgumentOutsideDomainException {
        if (v < this.knots[0]) goto L15;
        if (v > this.knots[this.n]) goto L15;
        int i = Arrays.binarySearch(this.knots, v);
        if (i >= 0) goto L10;
        i = (-i) - 2;
    L10:
        if (i < this.polynomials.length) goto L13;
        i = i - 1;
    L13:
        return this.polynomials[i].value(v - this.knots[i]);
    L15:
        throw new ArgumentOutsideDomainException(v, this.knots[0], this.knots[this.n]);
    }

    @Override // org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction
    public UnivariateRealFunction derivative() {
        return polynomialSplineDerivative();
    }

    public PolynomialSplineFunction polynomialSplineDerivative() {
        PolynomialFunction[] derivativePolynomials = new PolynomialFunction[this.n];
        int i = 0;
    L4:
        if (i >= this.n) goto L7;
        derivativePolynomials[i] = this.polynomials[i].polynomialDerivative();
        i = i + 1;
        goto L4
    L7:
        return new PolynomialSplineFunction(this.knots, derivativePolynomials);
    }

    public int getN() {
        return this.n;
    }

    public PolynomialFunction[] getPolynomials() {
        PolynomialFunction[] p = new PolynomialFunction[this.n];
        System.arraycopy(this.polynomials, 0, p, 0, this.n);
        return p;
    }

    public double[] getKnots() {
        double[] out = new double[this.n + 1];
        System.arraycopy(this.knots, 0, out, 0, this.n + 1);
        return out;
    }

    private static boolean isStrictlyIncreasing(double[] x) {
        int i = 1;
    L4:
        if (i >= x.length) goto L10;
        if (x[i - 1] >= x[i]) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }
}
