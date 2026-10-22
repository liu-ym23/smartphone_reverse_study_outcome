package org.apache.commons.math.transform;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class FastHadamardTransformer implements RealTransformer {
    public FastHadamardTransformer() {
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] transform(double[] f) throws IllegalArgumentException {
        return fht(f);
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] transform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        return fht(FastFourierTransformer.sample(f, min, max, n));
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] inversetransform(double[] f) throws IllegalArgumentException {
        return FastFourierTransformer.scaleArray(fht(f), 1.0d / ((double) f.length));
    }

    @Override // org.apache.commons.math.transform.RealTransformer
    public double[] inversetransform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] unscaled = fht(FastFourierTransformer.sample(f, min, max, n));
        return FastFourierTransformer.scaleArray(unscaled, 1.0d / ((double) n));
    }

    public int[] transform(int[] f) throws IllegalArgumentException {
        return fht(f);
    }

    protected double[] fht(double[] x) throws IllegalArgumentException {
        int n = x.length;
        int halfN = n / 2;
        if (FastFourierTransformer.isPowerOf2(n) == false) goto L16;
        double[] yPrevious = new double[n];
        double[] yCurrent = (double[]) x.clone();
        int j = 1;
    L5:
        if (j >= n) goto L14;
        double[] yTmp = yCurrent;
        yCurrent = yPrevious;
        yPrevious = yTmp;
        int i = 0;
    L7:
        if (i >= halfN) goto L9;
        int twoI = i * 2;
        yCurrent[i] = yPrevious[twoI] + yPrevious[twoI + 1];
        i = i + 1;
        goto L7
    L9:
        int i2 = halfN;
    L10:
        if (i2 >= n) goto L12;
        int twoI2 = i2 * 2;
        yCurrent[i2] = yPrevious[twoI2 - n] - yPrevious[(twoI2 - n) + 1];
        i2 = i2 + 1;
        goto L10
    L12:
        j = j << 1;
        goto L5
    L14:
        return yCurrent;
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, new Object[]{Integer.valueOf(n)});
    }

    protected int[] fht(int[] x) throws IllegalArgumentException {
        int n = x.length;
        int halfN = n / 2;
        if (FastFourierTransformer.isPowerOf2(n) == false) goto L16;
        int[] yPrevious = new int[n];
        int[] yCurrent = (int[]) x.clone();
        int j = 1;
    L5:
        if (j >= n) goto L14;
        int[] yTmp = yCurrent;
        yCurrent = yPrevious;
        yPrevious = yTmp;
        int i = 0;
    L7:
        if (i >= halfN) goto L9;
        int twoI = i * 2;
        yCurrent[i] = yPrevious[twoI] + yPrevious[twoI + 1];
        i = i + 1;
        goto L7
    L9:
        int i2 = halfN;
    L10:
        if (i2 >= n) goto L12;
        int twoI2 = i2 * 2;
        yCurrent[i2] = yPrevious[twoI2 - n] - yPrevious[(twoI2 - n) + 1];
        i2 = i2 + 1;
        goto L10
    L12:
        j = j << 1;
        goto L5
    L14:
        return yCurrent;
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, new Object[]{Integer.valueOf(n)});
    }
}
