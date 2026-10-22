package org.apache.commons.math.transform;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class FastCosineTransformer implements RealTransformer {
    public FastCosineTransformer() {
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] transform(double[] f) throws IllegalArgumentException {
        return fct(f);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] transform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = FastFourierTransformer.sample(f, min, max, n);
        return fct(data);
    }

    public double[] transform2(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = FastMath.sqrt(2.0d / ((double) (f.length - 1)));
        return FastFourierTransformer.scaleArray(fct(f), scaling_coefficient);
    }

    public double[] transform2(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = FastFourierTransformer.sample(f, min, max, n);
        double scaling_coefficient = FastMath.sqrt(2.0d / ((double) (n - 1)));
        return FastFourierTransformer.scaleArray(fct(data), scaling_coefficient);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] inversetransform(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = 2.0d / ((double) (f.length - 1));
        return FastFourierTransformer.scaleArray(fct(f), scaling_coefficient);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] inversetransform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = FastFourierTransformer.sample(f, min, max, n);
        double scaling_coefficient = 2.0d / ((double) (n - 1));
        return FastFourierTransformer.scaleArray(fct(data), scaling_coefficient);
    }

    public double[] inversetransform2(double[] f) throws IllegalArgumentException {
        return transform2(f);
    }

    public double[] inversetransform2(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        return transform2(f, min, max, n);
    }

    protected double[] fct(double[] r21) throws IllegalArgumentException {
        double[] r1 = new double[r21.length];
        boolean r3 = true;
        int r2 = r21.length - 1;
        if (FastFourierTransformer.isPowerOf2(r2) == false) goto L19;
        double r4 = 0.5d;
        boolean r6 = false;
        if (r2 != 1) goto L8;
        r1[0] = (r21[0] + r21[1]) * 0.5d;
        r1[1] = (r21[0] - r21[1]) * 0.5d;
        return r1;
    L8:
        double[] r7 = new double[r2];
        r7[0] = (r21[0] + r21[r2]) * 0.5d;
        r7[r2 >> 1] = r21[r2 >> 1];
        double r8 = (r21[0] - r21[r2]) * 0.5d;
        int r10 = 1;
    L10:
        if (r10 >= (r2 >> 1)) goto L12;
        double r11 = (r21[r10] + r21[r2 - r10]) * r4;
        boolean r17 = r3;
        double r5 = FastMath.sin((((double) r10) * 3.141592653589793d) / ((double) r2)) * (r21[r10] - r21[r2 - r10]);
        boolean r9 = r6;
        double[] r15 = r7;
        double r12 = FastMath.cos((((double) r10) * 3.141592653589793d) / ((double) r2)) * (r21[r10] - r21[r2 - r10]);
        r15[r10] = r11 - r5;
        r15[r2 - r10] = r11 + r5;
        r8 = r8 + r12;
        r10 = r10 + 1;
        r6 = r9;
        r7 = r15;
        r3 = r17;
        r4 = 0.5d;
        goto L10
    L12:
        boolean r18 = r3;
        boolean r13 = r6;
        Complex[] r14 = new FastFourierTransformer().transform(r7);
        r1[r13 ? 1 : 0] = r14[r13 ? 1 : 0].getReal();
        r1[r18 ? 1 : 0] = r8;
        int r16 = 1;
    L14:
        if (r16 >= (r2 >> 1)) goto L16;
        r1[r16 * 2] = r14[r16].getReal();
        r1[(r16 * 2) + 1] = r1[(r16 * 2) - 1] - r14[r16].getImaginary();
        r16 = r16 + 1;
        goto L14
    L16:
        r1[r2] = r14[r2 >> 1].getReal();
        return r1;
    L19:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_PLUS_ONE, new Object[]{Integer.valueOf(r21.length)});
    }
}
