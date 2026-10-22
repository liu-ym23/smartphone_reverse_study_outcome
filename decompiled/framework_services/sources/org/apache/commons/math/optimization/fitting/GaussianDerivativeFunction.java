package org.apache.commons.math.optimization.fitting;

import java.io.Serializable;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.ZeroException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class GaussianDerivativeFunction implements UnivariateRealFunction, Serializable {
    private static final long serialVersionUID = -6500229089670174766L;
    private final double b;
    private final double c;
    private final double d2;

    public GaussianDerivativeFunction(double b, double c, double d) {
        if (d == 0.0d) goto L7;
        this.b = b;
        this.c = c;
        this.d2 = d * d;
        return;
    L7:
        throw new ZeroException();
    }

    public GaussianDerivativeFunction(double[] parameters) {
        if (parameters == null) goto L15;
        if (parameters.length != 3) goto L13;
        if (parameters[2] == 0.0d) goto L11;
        this.b = parameters[0];
        this.c = parameters[1];
        this.d2 = parameters[2] * parameters[2];
        return;
    L11:
        throw new ZeroException();
    L13:
        throw new DimensionMismatchException(3, parameters.length);
    L15:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double x) {
        double xMc = x - this.c;
        return (((-this.b) / this.d2) * xMc) * Math.exp((-(xMc * xMc)) / (this.d2 * 2.0d));
    }
}
