package org.apache.commons.math.transform;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class FastFourierTransformer implements Serializable {
    static final long serialVersionUID = 5138259215438106000L;
    private RootsOfUnity roots;

    private static class MultiDimensionalComplexMatrix implements Cloneable {
        protected int[] dimensionSize;
        protected Object multiDimensionalComplexArray;

        public MultiDimensionalComplexMatrix(Object multiDimensionalComplexArray) {
            this.multiDimensionalComplexArray = multiDimensionalComplexArray;
            int numOfDimensions = 0;
            Object lastDimension = multiDimensionalComplexArray;
        L4:
            if ((lastDimension instanceof Object[]) == false) goto L6;
            numOfDimensions = numOfDimensions + 1;
            lastDimension = ((Object[]) lastDimension)[0];
            goto L4
        L6:
            this.dimensionSize = new int[numOfDimensions];
            int numOfDimensions2 = 0;
            Object lastDimension2 = multiDimensionalComplexArray;
        L8:
            if ((lastDimension2 instanceof Object[]) == false) goto L11;
            Object[] array = (Object[]) lastDimension2;
            this.dimensionSize[numOfDimensions2] = array.length;
            lastDimension2 = array[0];
            numOfDimensions2 = numOfDimensions2 + 1;
            goto L8
        }

        public Complex get(int... vector) throws IllegalArgumentException {
            if (vector != null) goto L10;
            if (this.dimensionSize.length > 0) goto L8;
            return null;
        L8:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{0, Integer.valueOf(this.dimensionSize.length)});
        L10:
            if (vector.length != this.dimensionSize.length) goto L18;
            Object lastDimension = this.multiDimensionalComplexArray;
            int i = 0;
        L13:
            if (i >= this.dimensionSize.length) goto L16;
            lastDimension = ((Object[]) lastDimension)[vector[i]];
            i = i + 1;
            goto L13
        L16:
            return (Complex) lastDimension;
        L18:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(vector.length), Integer.valueOf(this.dimensionSize.length)});
        }

        public Complex set(Complex magnitude, int... vector) throws IllegalArgumentException {
            if (vector != null) goto L10;
            if (this.dimensionSize.length > 0) goto L8;
            return null;
        L8:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{0, Integer.valueOf(this.dimensionSize.length)});
        L10:
            if (vector.length != this.dimensionSize.length) goto L18;
            Object[] lastDimension = (Object[]) this.multiDimensionalComplexArray;
            int i = 0;
        L13:
            if (i >= (this.dimensionSize.length - 1)) goto L15;
            lastDimension = (Object[]) lastDimension[vector[i]];
            i = i + 1;
            goto L13
        L15:
            Complex lastValue = (Complex) lastDimension[vector[this.dimensionSize.length - 1]];
            lastDimension[vector[this.dimensionSize.length - 1]] = magnitude;
            return lastValue;
        L18:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(vector.length), Integer.valueOf(this.dimensionSize.length)});
        }

        public int[] getDimensionSizes() {
            return (int[]) this.dimensionSize.clone();
        }

        public Object getArray() {
            return this.multiDimensionalComplexArray;
        }

        public Object clone() {
            MultiDimensionalComplexMatrix mdcm = new MultiDimensionalComplexMatrix(Array.newInstance(Complex.class, this.dimensionSize));
            clone(mdcm);
            return mdcm;
        }

        private void clone(MultiDimensionalComplexMatrix mdcm) {
            int[] vector = new int[this.dimensionSize.length];
            int size = 1;
            int i = 0;
        L4:
            if (i >= this.dimensionSize.length) goto L6;
            size = size * this.dimensionSize[i];
            i = i + 1;
            goto L4
        L6:
            int r2 = 0;
            int[][] vectorList = (int[][]) Array.newInstance(Integer.TYPE, new int[]{size, this.dimensionSize.length});
            int r5 = vectorList.length;
            int r6 = 0;
        L7:
            if (r6 >= r5) goto L16;
            System.arraycopy(vector, 0, vectorList[r6], 0, this.dimensionSize.length);
            int i2 = 0;
        L10:
            if (i2 >= this.dimensionSize.length) goto L15;
            vector[i2] = vector[i2] + 1;
            if (vector[i2] < this.dimensionSize[i2]) goto L15;
            vector[i2] = 0;
            i2 = i2 + 1;
        L15:
            r6 = r6 + 1;
            goto L7
        L16:
            int r4 = vectorList.length;
        L17:
            if (r2 >= r4) goto L19;
            int[] nextVector = vectorList[r2];
            mdcm.set(get(nextVector), nextVector);
            r2 = r2 + 1;
            goto L17
        }
    }

    private static class RootsOfUnity implements Serializable {
        private static final long serialVersionUID = 6404784357747329667L;
        private boolean isForward;
        private int omegaCount;
        private double[] omegaImaginaryForward;
        private double[] omegaImaginaryInverse;
        private double[] omegaReal;

        public RootsOfUnity() {
            this.omegaCount = 0;
            this.omegaReal = null;
            this.omegaImaginaryForward = null;
            this.omegaImaginaryInverse = null;
            this.isForward = true;
        }

        public synchronized boolean isForward() throws IllegalStateException {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.omegaCount == 0) goto L11;
            boolean r0 = this.isForward;     // Catch: Throwable -> L8
            monitor-exit(this);
            return r0;
        L11:
            throw MathRuntimeException.createIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);     // Catch: Throwable -> L8
        }

        public synchronized void computeOmega(int n) throws IllegalArgumentException {
            monitor-enter(this);
            if (n == 0) goto L22;
            if (n <= 0) goto L7;
            boolean r1 = true;
        L8:
            this.isForward = r1;     // Catch: Throwable -> L16
            int absN = FastMath.abs(n);     // Catch: Throwable -> L16
            if (absN != this.omegaCount) goto L12;
            monitor-exit(this);
            return;
        L12:
            double t = 6.283185307179586d / ((double) absN);
            double cosT = FastMath.cos(t);     // Catch: Throwable -> L16
            double sinT = FastMath.sin(t);     // Catch: Throwable -> L16
            this.omegaReal = new double[absN];     // Catch: Throwable -> L16
            this.omegaImaginaryForward = new double[absN];     // Catch: Throwable -> L16
            this.omegaImaginaryInverse = new double[absN];     // Catch: Throwable -> L16
            this.omegaReal[0] = 1.0d;     // Catch: Throwable -> L16
            this.omegaImaginaryForward[0] = 0.0d;     // Catch: Throwable -> L16
            this.omegaImaginaryInverse[0] = 0.0d;     // Catch: Throwable -> L16
            int i = 1;
        L14:
            if (i >= absN) goto L18;
            this.omegaReal[i] = (this.omegaReal[i - 1] * cosT) + (this.omegaImaginaryForward[i - 1] * sinT);     // Catch: Throwable -> L16
            this.omegaImaginaryForward[i] = (this.omegaImaginaryForward[i - 1] * cosT) - (this.omegaReal[i - 1] * sinT);     // Catch: Throwable -> L16
            this.omegaImaginaryInverse[i] = -this.omegaImaginaryForward[i];     // Catch: Throwable -> L16
            i = i + 1;     // Catch: Throwable -> L16
            goto L14
        L18:
            this.omegaCount = absN;     // Catch: Throwable -> L16
            monitor-exit(this);
            return;
        L7:
            r1 = false;
            goto L8
        L22:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_COMPUTE_0TH_ROOT_OF_UNITY, new Object[0]);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        public synchronized double getOmegaReal(int k) throws IllegalStateException, IllegalArgumentException {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.omegaCount == 0) goto L16;
            if (k < 0) goto L14;
            if (k >= this.omegaCount) goto L14;
            double r0 = this.omegaReal[k];     // Catch: Throwable -> L11
            monitor-exit(this);
            return r0;
        L14:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, new Object[]{Integer.valueOf(k), 0, Integer.valueOf(this.omegaCount - 1)});     // Catch: Throwable -> L11
        L16:
            throw MathRuntimeException.createIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);     // Catch: Throwable -> L11
        }

        public synchronized double getOmegaImaginary(int k) throws IllegalStateException, IllegalArgumentException {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.omegaCount == 0) goto L19;
            if (k < 0) goto L17;
            if (k >= this.omegaCount) goto L17;
            if (this.isForward == false) goto L13;
            double r0 = this.omegaImaginaryForward[k];     // Catch: Throwable -> L11
        L14:
            monitor-exit(this);
            return r0;
        L13:
            r0 = this.omegaImaginaryInverse[k];     // Catch: Throwable -> L11
        L17:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, new Object[]{Integer.valueOf(k), 0, Integer.valueOf(this.omegaCount - 1)});     // Catch: Throwable -> L11
        L19:
            throw MathRuntimeException.createIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);     // Catch: Throwable -> L11
        }
    }

    public FastFourierTransformer() {
        this.roots = new RootsOfUnity();
    }

    public Complex[] transform(double[] f) throws IllegalArgumentException {
        return fft(f, false);
    }

    public Complex[] transform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = sample(f, min, max, n);
        return fft(data, false);
    }

    public Complex[] transform(Complex[] f) throws IllegalArgumentException {
        this.roots.computeOmega(f.length);
        return fft(f);
    }

    public Complex[] transform2(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = 1.0d / FastMath.sqrt(f.length);
        return scaleArray(fft(f, false), scaling_coefficient);
    }

    public Complex[] transform2(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = sample(f, min, max, n);
        double scaling_coefficient = 1.0d / FastMath.sqrt(n);
        return scaleArray(fft(data, false), scaling_coefficient);
    }

    public Complex[] transform2(Complex[] f) throws IllegalArgumentException {
        this.roots.computeOmega(f.length);
        double scaling_coefficient = 1.0d / FastMath.sqrt(f.length);
        return scaleArray(fft(f), scaling_coefficient);
    }

    public Complex[] inversetransform(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = 1.0d / ((double) f.length);
        return scaleArray(fft(f, true), scaling_coefficient);
    }

    public Complex[] inversetransform(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = sample(f, min, max, n);
        double scaling_coefficient = 1.0d / ((double) n);
        return scaleArray(fft(data, true), scaling_coefficient);
    }

    public Complex[] inversetransform(Complex[] f) throws IllegalArgumentException {
        this.roots.computeOmega(-f.length);
        double scaling_coefficient = 1.0d / ((double) f.length);
        return scaleArray(fft(f), scaling_coefficient);
    }

    public Complex[] inversetransform2(double[] f) throws IllegalArgumentException {
        double scaling_coefficient = 1.0d / FastMath.sqrt(f.length);
        return scaleArray(fft(f, true), scaling_coefficient);
    }

    public Complex[] inversetransform2(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        double[] data = sample(f, min, max, n);
        double scaling_coefficient = 1.0d / FastMath.sqrt(n);
        return scaleArray(fft(data, true), scaling_coefficient);
    }

    public Complex[] inversetransform2(Complex[] f) throws IllegalArgumentException {
        this.roots.computeOmega(-f.length);
        double scaling_coefficient = 1.0d / FastMath.sqrt(f.length);
        return scaleArray(fft(f), scaling_coefficient);
    }

    protected Complex[] fft(double[] f, boolean isInverse) throws IllegalArgumentException {
        verifyDataSet(f);
        Complex[] F = new Complex[f.length];
        if (f.length != 1) goto L6;
        F[0] = new Complex(f[0], 0.0d);
        return F;
    L6:
        int N = f.length >> 1;
        Complex[] c = new Complex[N];
        int i = 0;
    L7:
        if (i >= N) goto L9;
        c[i] = new Complex(f[i * 2], f[(i * 2) + 1]);
        i = i + 1;
        goto L7
    L9:
        RootsOfUnity r7 = this.roots;
        if (isInverse == false) goto L12;
        int r9 = -N;
    L13:
        r7.computeOmega(r9);
        Complex[] z = fft(c);
        RootsOfUnity r10 = this.roots;
        if (isInverse == false) goto L16;
        int r11 = N * (-2);
    L17:
        r10.computeOmega(r11);
        F[0] = new Complex((z[0].getReal() + z[0].getImaginary()) * 2.0d, 0.0d);
        F[N] = new Complex((z[0].getReal() - z[0].getImaginary()) * 2.0d, 0.0d);
        int i2 = 1;
    L18:
        if (i2 >= N) goto L21;
        Complex A = z[N - i2].conjugate();
        Complex B = z[i2].add2(A);
        Complex C = z[i2].subtract2(A);
        Complex D = new Complex(-this.roots.getOmegaImaginary(i2), this.roots.getOmegaReal(i2));
        F[i2] = B.subtract2(C.multiply2(D));
        F[(N * 2) - i2] = F[i2].conjugate();
        i2 = i2 + 1;
        goto L18
    L21:
        return scaleArray(F, 0.5d);
    L16:
        r11 = N * 2;
        goto L17
    L12:
        r9 = N;
        goto L13
    }

    protected Complex[] fft(Complex[] data) throws IllegalArgumentException {
        FastFourierTransformer r0 = this;
        int n = data.length;
        Complex[] f = new Complex[n];
        verifyDataSet(data);
        if (n != 1) goto L7;
        f[0] = data[0];
        return f;
    L7:
        if (n != 2) goto L10;
        f[0] = data[0].add2(data[1]);
        f[1] = data[0].subtract2(data[1]);
        return f;
    L10:
        int ii = 0;
        int i = 0;
    L11:
        if (i >= n) goto L17;
        f[i] = data[ii];
        int k = n >> 1;
    L13:
        if (ii < k) goto L16;
        if (k <= 0) goto L16;
        ii = ii - k;
        k = k >> 1;
    L16:
        ii = ii + k;
        i = i + 1;
        goto L11
    L17:
        int i2 = 0;
    L18:
        if (i2 >= n) goto L28;
        Complex a = f[i2].add2(f[i2 + 1]);
        Complex b = f[i2 + 2].add2(f[i2 + 3]);
        Complex c = f[i2].subtract2(f[i2 + 1]);
        Complex d = f[i2 + 2].subtract2(f[i2 + 3]);
        Complex e1 = c.add2(d.multiply2(Complex.I));
        Complex e2 = c.subtract2(d.multiply2(Complex.I));
        f[i2] = a.add2(b);
        f[i2 + 2] = a.subtract2(b);
        int r12 = i2 + 1;
        if (r0.roots.isForward() == false) goto L22;
        Complex r13 = e2;
    L23:
        f[r12] = r13;
        int r14 = i2 + 3;
        if (r0.roots.isForward() == false) goto L26;
        Complex r15 = e1;
    L27:
        f[r14] = r15;
        i2 = i2 + 4;
        goto L18
    L26:
        r15 = e2;
        goto L27
    L22:
        r13 = e1;
        goto L23
    L28:
        int i3 = 4;
    L29:
        if (i3 >= n) goto L38;
        int m = n / (i3 << 1);
        int j = 0;
    L31:
        if (j >= n) goto L36;
        int k2 = 0;
    L33:
        if (k2 >= i3) goto L35;
        int k_times_m = k2 * m;
        double omega_k_times_m_real = r0.roots.getOmegaReal(k_times_m);
        double omega_k_times_m_imaginary = r0.roots.getOmegaImaginary(k_times_m);
        int n2 = n;
        Complex[] f2 = f;
        Complex z = new Complex((f[(i3 + j) + k2].getReal() * omega_k_times_m_real) - (f[(i3 + j) + k2].getImaginary() * omega_k_times_m_imaginary), (f[(i3 + j) + k2].getReal() * omega_k_times_m_imaginary) + (f[(i3 + j) + k2].getImaginary() * omega_k_times_m_real));
        f2[(i3 + j) + k2] = f2[j + k2].subtract2(z);
        f2[j + k2] = f2[j + k2].add2(z);
        k2 = k2 + 1;
        r0 = this;
        n = n2;
        f = f2;
        goto L33
    L35:
        j = j + (i3 << 1);
        r0 = this;
        goto L31
    L36:
        i3 = i3 << 1;
        r0 = this;
        goto L29
    L38:
        return f;
    }

    public static double[] sample(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException, IllegalArgumentException {
        if (n <= 0) goto L9;
        verifyInterval(min, max);
        double[] s = new double[n];
        double h = (max - min) / ((double) n);
        int i = 0;
    L4:
        if (i >= n) goto L7;
        s[i] = f.value((((double) i) * h) + min);
        i = i + 1;
        goto L4
    L7:
        return s;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, new Object[]{Integer.valueOf(n)});
    }

    public static double[] scaleArray(double[] f, double d) {
        int i = 0;
    L4:
        if (i >= f.length) goto L7;
        f[i] = f[i] * d;
        i = i + 1;
        goto L4
    L7:
        return f;
    }

    public static Complex[] scaleArray(Complex[] f, double d) {
        int i = 0;
    L4:
        if (i >= f.length) goto L7;
        f[i] = new Complex(f[i].getReal() * d, f[i].getImaginary() * d);
        i = i + 1;
        goto L4
    L7:
        return f;
    }

    public static boolean isPowerOf2(long n) {
        if (n > 0) goto L5;
    L7:
        return false;
    L5:
        if (((n - 1) & n) != 0) goto L7;
        return true;
    }

    public static void verifyDataSet(double[] d) throws IllegalArgumentException {
        if (isPowerOf2(d.length) == false) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, new Object[]{Integer.valueOf(d.length)});
    }

    public static void verifyDataSet(Object[] o) throws IllegalArgumentException {
        if (isPowerOf2(o.length) == false) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, new Object[]{Integer.valueOf(o.length)});
    }

    public static void verifyInterval(double lower, double upper) throws IllegalArgumentException {
        if (lower >= upper) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, new Object[]{Double.valueOf(lower), Double.valueOf(upper)});
    }

    public Object mdfft(Object mdca, boolean forward) throws IllegalArgumentException {
        MultiDimensionalComplexMatrix mdcm = (MultiDimensionalComplexMatrix) new MultiDimensionalComplexMatrix(mdca).clone();
        int[] dimensionSize = mdcm.getDimensionSizes();
        int i = 0;
    L4:
        if (i >= dimensionSize.length) goto L7;
        mdfft(mdcm, forward, i, new int[0]);
        i = i + 1;
        goto L4
    L7:
        return mdcm.getArray();
    }

    private void mdfft(MultiDimensionalComplexMatrix mdcm, boolean forward, int d, int[] subVector) throws IllegalArgumentException {
        int[] dimensionSize = mdcm.getDimensionSizes();
        if (subVector.length != dimensionSize.length) goto L17;
        Complex[] temp = new Complex[dimensionSize[d]];
        int i = 0;
    L6:
        if (i >= dimensionSize[d]) goto L9;
        subVector[d] = i;
        temp[i] = mdcm.get(subVector);
        i = i + 1;
        goto L6
    L9:
        if (forward == false) goto L11;
        Complex[] temp2 = transform2(temp);
    L12:
        int i2 = 0;
    L14:
        if (i2 >= dimensionSize[d]) goto L28;
        subVector[d] = i2;
        mdcm.set(temp2[i2], subVector);
        i2 = i2 + 1;
        goto L14
    L28:
        return;
    L11:
        temp2 = inversetransform2(temp);
        goto L12
    L17:
        int[] vector = new int[subVector.length + 1];
        System.arraycopy(subVector, 0, vector, 0, subVector.length);
        if (subVector.length != d) goto L20;
        vector[d] = 0;
        mdfft(mdcm, forward, d, vector);
        return;
    L20:
        int i3 = 0;
    L22:
        if (i3 >= dimensionSize[subVector.length]) goto L29;
        vector[subVector.length] = i3;
        mdfft(mdcm, forward, d, vector);
        i3 = i3 + 1;
        goto L22
    }
}
