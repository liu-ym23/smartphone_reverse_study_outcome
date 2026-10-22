package org.apache.commons.math.transform;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class FastSineTransformer implements RealTransformer {
    public FastSineTransformer() {
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] transform(double[] f) throws IllegalArgumentException {
        return fst(f);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] transform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = FastFourierTransformer.sample(f, min, max, n);
        data[0] = 0.0d;
        return fst(data);
    }

    public double[] transform2(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = FastMath.sqrt(2.0d / ((double) f.length));
        return FastFourierTransformer.scaleArray(fst(f), scaling_coefficient);
    }

    public double[] transform2(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = FastFourierTransformer.sample(f, min, max, n);
        data[0] = 0.0d;
        double scaling_coefficient = FastMath.sqrt(2.0d / ((double) n));
        return FastFourierTransformer.scaleArray(fst(data), scaling_coefficient);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] inversetransform(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = 2.0d / ((double) f.length);
        return FastFourierTransformer.scaleArray(fst(f), scaling_coefficient);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] inversetransform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = FastFourierTransformer.sample(f, min, max, n);
        data[0] = 0.0d;
        double scaling_coefficient = 2.0d / ((double) n);
        return FastFourierTransformer.scaleArray(fst(data), scaling_coefficient);
    }

    public double[] inversetransform2(double[] f) throws IllegalArgumentException {
        return transform2(f);
    }

    public double[] inversetransform2(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        return transform2(f, min, max, n);
    }

    protected double[] fst(double[] f) throws IllegalArgumentException {
        double[] transformed = new double[f.length];
        FastFourierTransformer.verifyDataSet(f);
        if (f[0] != 0.0d) goto L19;
        int n = f.length;
        if (n != 1) goto L8;
        transformed[0] = 0.0d;
        return transformed;
    L8:
        double[] x = new double[n];
        x[0] = 0.0d;
        x[n >> 1] = f[n >> 1] * 2.0d;
        int i = 1;
    L10:
        if (i >= (n >> 1)) goto L12;
        double a = FastMath.sin((((double) i) * 3.141592653589793d) / ((double) n)) * (f[i] + f[n - i]);
        double b = (f[i] - f[n - i]) * 0.5d;
        x[i] = a + b;
        x[n - i] = a - b;
        i = i + 1;
        goto L10
    L12:
        FastFourierTransformer transformer = new FastFourierTransformer();
        Complex[] y = transformer.transform(x);
        transformed[0] = 0.0d;
        transformed[1] = y[0].getReal() * 0.5d;
        int i2 = 1;
    L14:
        if (i2 >= (n >> 1)) goto L17;
        transformed[i2 * 2] = -y[i2].getImaginary();
        transformed[(i2 * 2) + 1] = y[i2].getReal() + transformed[(i2 * 2) - 1];
        i2 = i2 + 1;
        goto L14
    L17:
        return transformed;
    L19:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.FIRST_ELEMENT_NOT_ZERO, new Object[]{Double.valueOf(f[0])});
    }
}
