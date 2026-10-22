package org.apache.commons.math.analysis.interpolation;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialFunctionLagrangeForm;

/* JADX INFO: loaded from: classes3.dex */
public class NevilleInterpolator implements UnivariateRealInterpolator, Serializable {
    static final long serialVersionUID = 3003707660147873733L;

    public NevilleInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public /* bridge */ /* synthetic */ UnivariateRealFunction interpolate(double[] r1, double[] r2) throws MathException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math.analysis.interpolation.UnivariateRealInterpolator
    public PolynomialFunctionLagrangeForm interpolate(double[] x, double[] y) throws MathException {
        return new PolynomialFunctionLagrangeForm(x, y);
    }
}
