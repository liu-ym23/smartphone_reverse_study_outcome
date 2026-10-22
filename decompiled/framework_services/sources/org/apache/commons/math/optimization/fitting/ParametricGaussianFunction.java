package org.apache.commons.math.optimization.fitting;

import java.io.Serializable;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.ZeroException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class ParametricGaussianFunction implements ParametricRealFunction, Serializable {
    private static final long serialVersionUID = -3875578602503903233L;

    public ParametricGaussianFunction() {
    }

    @Override // org.apache.commons.math.optimization.fitting.ParametricRealFunction
    public double value(double x, double[] parameters) throws ZeroException {
        validateParameters(parameters);
        double a = parameters[0];
        double b = parameters[1];
        double c = parameters[2];
        double d = parameters[3];
        double xMc = x - c;
        return (Math.exp(((-xMc) * xMc) / ((d * d) * 2.0d)) * b) + a;
    }

    @Override // org.apache.commons.math.optimization.fitting.ParametricRealFunction
    public double[] gradient(double x, double[] parameters) throws ZeroException {
        validateParameters(parameters);
        double b = parameters[1];
        double c = parameters[2];
        double d = parameters[3];
        double xMc = x - c;
        double d2 = d * d;
        double exp = Math.exp(((-xMc) * xMc) / (2.0d * d2));
        double f = ((b * exp) * xMc) / d2;
        return new double[]{1.0d, exp, f, (f * xMc) / d};
    }

    private void validateParameters(double[] parameters) throws ZeroException {
        if (parameters == null) goto L13;
        if (parameters.length != 4) goto L11;
        if (parameters[3] == 0.0d) goto L9;
        return;
    L9:
        throw new ZeroException();
    L11:
        throw new DimensionMismatchException(4, parameters.length);
    L13:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }
}
