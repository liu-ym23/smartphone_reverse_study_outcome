package org.apache.commons.math.analysis.interpolation;

import java.io.Serializable;
import org.apache.commons.math.DuplicateSampleAbscissaException;
import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math.analysis.polynomials.PolynomialFunctionNewtonForm;

/* JADX INFO: loaded from: classes3.dex */
public class DividedDifferenceInterpolator implements UnivariateRealInterpolator, Serializable {
    private static final long serialVersionUID = 107049519551235069L;

    public DividedDifferenceInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public /* bridge */ /* synthetic */ UnivariateRealFunction interpolate(double[] r1, double[] r2) throws MathException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public PolynomialFunctionNewtonForm interpolate(double[] x, double[] y) throws DuplicateSampleAbscissaException {
        PolynomialFunctionLagrangeForm.verifyInterpolationArray(x, y);
        double[] c = new double[x.length - 1];
        System.arraycopy(x, 0, c, 0, c.length);
        double[] a = computeDividedDifference(x, y);
        return new PolynomialFunctionNewtonForm(a, c);
    }

    protected static double[] computeDividedDifference(double[] x, double[] y) throws DuplicateSampleAbscissaException {
        PolynomialFunctionLagrangeForm.verifyInterpolationArray(x, y);
        double[] divdiff = (double[]) y.clone();
        int n = x.length;
        double[] a = new double[n];
        a[0] = divdiff[0];
        int i = 1;
    L3:
        if (i >= n) goto L14;
        int j = 0;
    L6:
        if (j >= (n - i)) goto L12;
        double denominator = x[j + i] - x[j];
        if (denominator == 0.0d) goto L11;
        divdiff[j] = (divdiff[j + 1] - divdiff[j]) / denominator;
        j = j + 1;
        goto L6
    L11:
        throw new DuplicateSampleAbscissaException(x[j], j, j + i);
    L12:
        a[i] = divdiff[0];
        i = i + 1;
        goto L3
    L14:
        return a;
    }
}
