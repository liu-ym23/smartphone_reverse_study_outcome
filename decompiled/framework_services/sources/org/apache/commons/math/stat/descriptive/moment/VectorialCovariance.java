package org.apache.commons.math.stat.descriptive.moment;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;

/* JADX INFO: loaded from: classes3.dex */
public class VectorialCovariance implements Serializable {
    private static final long serialVersionUID = 4118372414238930270L;
    private final boolean isBiasCorrected;
    private long n;
    private final double[] productsSums;
    private final double[] sums;

    public VectorialCovariance(int dimension, boolean isBiasCorrected) {
        this.sums = new double[dimension];
        this.productsSums = new double[((dimension + 1) * dimension) / 2];
        this.n = 0;
        this.isBiasCorrected = isBiasCorrected;
    }

    public void increment(double[] v) throws DimensionMismatchException {
        if (v.length != this.sums.length) goto L14;
        int k = 0;
        int i = 0;
    L6:
        if (i >= v.length) goto L11;
        double[] r2 = this.sums;
        r2[i] = r2[i] + v[i];
        int j = 0;
    L8:
        if (j > i) goto L10;
        double[] r3 = this.productsSums;
        r3[k] = r3[k] + (v[i] * v[j]);
        j = j + 1;
        k = k + 1;
        goto L8
    L10:
        i = i + 1;
        goto L6
    L11:
        this.n++;
        return;
    L14:
        throw new DimensionMismatchException(v.length, this.sums.length);
    }

    public RealMatrix getResult() {
        int dimension = this.sums.length;
        RealMatrix result = MatrixUtils.createRealMatrix(dimension, dimension);
        if (this.n <= 1) goto L14;
        long r2 = this.n;
        if (this.isBiasCorrected == false) goto L7;
        long r6 = this.n - 1;
    L8:
        double c = 1.0d / (r2 * r6);
        int k = 0;
        int i = 0;
    L9:
        if (i >= dimension) goto L14;
        int j = 0;
    L11:
        if (j > i) goto L13;
        double e = ((this.n * this.productsSums[k]) - (this.sums[i] * this.sums[j])) * c;
        result.setEntry(i, j, e);
        result.setEntry(j, i, e);
        j = j + 1;
        k = k + 1;
        goto L11
    L13:
        i = i + 1;
        goto L9
    L7:
        r6 = this.n;
    L14:
        return result;
    }

    public long getN() {
        return this.n;
    }

    public void clear() {
        this.n = 0;
        Arrays.fill(this.sums, 0.0d);
        Arrays.fill(this.productsSums, 0.0d);
    }

    public int hashCode() {
        int r2 = 1 * 31;
        if (this.isBiasCorrected == false) goto L5;
        int r3 = 1231;
    L6:
        int result = r2 + r3;
        return (((((result * 31) + ((int) (this.n ^ (this.n >>> 32)))) * 31) + Arrays.hashCode(this.productsSums)) * 31) + Arrays.hashCode(this.sums);
    L5:
        r3 = 1237;
        goto L6
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof VectorialCovariance) == true) goto L8;
        return false;
    L8:
        VectorialCovariance other = (VectorialCovariance) obj;
        if (this.isBiasCorrected == other.isBiasCorrected) goto L12;
        return false;
    L12:
        if (this.n == other.n) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.productsSums, other.productsSums) == true) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.sums, other.sums) == true) goto L20;
        return false;
    L20:
        return true;
    }
}
