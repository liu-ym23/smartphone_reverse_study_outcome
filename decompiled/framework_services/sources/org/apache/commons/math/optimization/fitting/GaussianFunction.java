package org.apache.commons.math.optimization.fitting;

import java.io.Serializable;
import org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.ZeroException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class GaussianFunction implements DifferentiableUnivariateRealFunction, Serializable {
    private static final long serialVersionUID = -3195385616125629512L;
    private final double a;
    private final double b;
    private final double c;
    private final double d;

    public GaussianFunction(double a, double b, double c, double d) {
        if (d == 0.0d) goto L7;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        return;
    L7:
        throw new ZeroException();
    }

    public GaussianFunction(double[] parameters) {
        if (parameters == null) goto L15;
        if (parameters.length != 4) goto L13;
        if (parameters[3] == 0.0d) goto L11;
        this.a = parameters[0];
        this.b = parameters[1];
        this.c = parameters[2];
        this.d = parameters[3];
        return;
    L11:
        throw new ZeroException();
    L13:
        throw new DimensionMismatchException(4, parameters.length);
    L15:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    @Override // org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction
    public UnivariateRealFunction derivative() {
        return new GaussianDerivativeFunction(this.b, this.c, this.d);
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double x) {
        double xMc = x - this.c;
        return this.a + (this.b * Math.exp(((-xMc) * xMc) / ((this.d * this.d) * 2.0d)));
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getD() {
        return this.d;
    }
}
