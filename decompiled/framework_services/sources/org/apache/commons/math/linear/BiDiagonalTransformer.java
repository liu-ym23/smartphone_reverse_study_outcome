package org.apache.commons.math.linear;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
class BiDiagonalTransformer {
    private RealMatrix cachedB;
    private RealMatrix cachedU;
    private RealMatrix cachedV;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    public BiDiagonalTransformer(RealMatrix matrix) {
        int m = matrix.getRowDimension();
        int n = matrix.getColumnDimension();
        int p = FastMath.min(m, n);
        this.householderVectors = matrix.getData();
        this.main = new double[p];
        this.secondary = new double[p - 1];
        this.cachedU = null;
        this.cachedB = null;
        this.cachedV = null;
        if (m < n) goto L5;
        transformToUpperBiDiagonal();
        return;
    L5:
        transformToLowerBiDiagonal();
    }

    public RealMatrix getU() {
        if (this.cachedU != null) goto L33;
        int m = this.householderVectors.length;
        int n = this.householderVectors[0].length;
        int p = this.main.length;
        if (m < n) goto L7;
        int diagOffset = 0;
    L8:
        if (m < n) goto L10;
        double[] diagonal = this.main;
    L11:
        this.cachedU = MatrixUtils.createRealMatrix(m, m);
        int k = m - 1;
    L12:
        double r8 = 1.0d;
        if (k < p) goto L15;
        this.cachedU.setEntry(k, k, 1.0d);
        k = k - 1;
        goto L12
    L15:
        int k2 = p - 1;
    L16:
        if (k2 < diagOffset) goto L30;
        double[] hK = this.householderVectors[k2];
        this.cachedU.setEntry(k2, k2, r8);
        if (hK[k2 - diagOffset] == 0.0d) goto L28;
        int j = k2;
    L20:
        if (j >= m) goto L28;
        double alpha = 0.0d;
        int i = k2;
    L22:
        if (i >= m) goto L24;
        alpha = alpha - (this.cachedU.getEntry(i, j) * this.householderVectors[i][k2 - diagOffset]);
        i = i + 1;
        goto L22
    L24:
        double alpha2 = alpha / (diagonal[k2 - diagOffset] * hK[k2 - diagOffset]);
        int i2 = k2;
    L25:
        if (i2 >= m) goto L27;
        this.cachedU.addToEntry(i2, j, (-alpha2) * this.householderVectors[i2][k2 - diagOffset]);
        i2 = i2 + 1;
        goto L25
    L27:
        j = j + 1;
    L28:
        k2 = k2 - 1;
        r8 = 1.0d;
        goto L16
    L30:
        if (diagOffset <= 0) goto L33;
        this.cachedU.setEntry(0, 0, 1.0d);
        goto L33
    L10:
        diagonal = this.secondary;
        goto L11
    L7:
        diagOffset = 1;
    L33:
        return this.cachedU;
    }

    public RealMatrix getB() {
        if (this.cachedB != null) goto L16;
        int m = this.householderVectors.length;
        int n = this.householderVectors[0].length;
        this.cachedB = MatrixUtils.createRealMatrix(m, n);
        int i = 0;
    L6:
        if (i >= this.main.length) goto L16;
        this.cachedB.setEntry(i, i, this.main[i]);
        if (m >= n) goto L12;
        if (i <= 0) goto L14;
        this.cachedB.setEntry(i, i - 1, this.secondary[i - 1]);
    L14:
        i = i + 1;
        goto L6
    L12:
        if (i >= (this.main.length - 1)) goto L14;
        this.cachedB.setEntry(i, i + 1, this.secondary[i]);
    L16:
        return this.cachedB;
    }

    public RealMatrix getV() {
        if (this.cachedV != null) goto L35;
        int m = this.householderVectors.length;
        int n = this.householderVectors[0].length;
        int p = this.main.length;
        if (m < n) goto L7;
        int diagOffset = 1;
    L8:
        if (m < n) goto L10;
        double[] diagonal = this.secondary;
    L11:
        this.cachedV = MatrixUtils.createRealMatrix(n, n);
        int k = n - 1;
    L13:
        if (k < p) goto L15;
        this.cachedV.setEntry(k, k, 1.0d);
        k = k - 1;
        goto L13
    L15:
        int k2 = p - 1;
    L16:
        if (k2 < diagOffset) goto L32;
        double[] hK = this.householderVectors[k2 - diagOffset];
        this.cachedV.setEntry(k2, k2, 1.0d);
        if (hK[k2] == 0.0d) goto L30;
        int j = k2;
    L20:
        if (j >= n) goto L30;
        double beta = 0.0d;
        int i = k2;
    L22:
        if (i >= n) goto L24;
        beta = beta - (this.cachedV.getEntry(i, j) * hK[i]);
        i = i + 1;
        goto L22
    L24:
        int i2 = k2 - diagOffset;
        double beta2 = beta / (diagonal[i2] * hK[k2]);
        int i3 = k2;
    L25:
        if (i3 >= n) goto L27;
        this.cachedV.addToEntry(i3, j, (-beta2) * hK[i3]);
        i3 = i3 + 1;
        p = p;
        goto L25
    L27:
        j = j + 1;
    L30:
        k2 = k2 - 1;
        p = p;
        goto L16
    L32:
        if (diagOffset <= 0) goto L35;
        this.cachedV.setEntry(0, 0, 1.0d);
        goto L35
    L10:
        diagonal = this.main;
        goto L11
    L7:
        diagOffset = 0;
    L35:
        return this.cachedV;
    }

    double[][] getHouseholderVectorsRef() {
        return this.householderVectors;
    }

    double[] getMainDiagonalRef() {
        return this.main;
    }

    double[] getSecondaryDiagonalRef() {
        return this.secondary;
    }

    boolean isUpperBiDiagonal() {
        if (this.householderVectors.length < this.householderVectors[0].length) goto L6;
        return true;
    L6:
        return false;
    }

    private void transformToUpperBiDiagonal() {
        int m = this.householderVectors.length;
        int n = this.householderVectors[0].length;
        int k = 0;
    L3:
        if (k >= n) goto L44;
        double xNormSqr = 0.0d;
        int i = k;
    L5:
        if (i >= m) goto L7;
        double c = this.householderVectors[i][k];
        xNormSqr = xNormSqr + (c * c);
        i = i + 1;
        goto L5
    L7:
        double[] hK = this.householderVectors[k];
        if (hK[k] <= 0.0d) goto L10;
        double a = -FastMath.sqrt(xNormSqr);
    L11:
        this.main[k] = a;
        if (a == 0.0d) goto L22;
        hK[k] = hK[k] - a;
        int j = k + 1;
    L14:
        if (j >= n) goto L22;
        double alpha = 0.0d;
        int i2 = k;
    L16:
        if (i2 >= m) goto L18;
        double[] hI = this.householderVectors[i2];
        alpha = alpha - (hI[j] * hI[k]);
        i2 = i2 + 1;
        goto L16
    L18:
        double alpha2 = alpha / (this.householderVectors[k][k] * a);
        int i3 = k;
    L19:
        if (i3 >= m) goto L21;
        double[] hI2 = this.householderVectors[i3];
        hI2[j] = hI2[j] - (hI2[k] * alpha2);
        i3 = i3 + 1;
        goto L19
    L21:
        j = j + 1;
    L22:
        int j2 = n - 1;
        if (k >= j2) goto L42;
        double xNormSqr2 = 0.0d;
        int j3 = k + 1;
    L25:
        if (j3 >= n) goto L27;
        double c2 = hK[j3];
        xNormSqr2 = xNormSqr2 + (c2 * c2);
        j3 = j3 + 1;
        goto L25
    L27:
        int j4 = k + 1;
        if (hK[j4] <= 0.0d) goto L30;
        double b = -FastMath.sqrt(xNormSqr2);
    L31:
        this.secondary[k] = b;
        if (b == 0.0d) goto L42;
        int r9 = k + 1;
        hK[r9] = hK[r9] - b;
        int i4 = k + 1;
    L34:
        if (i4 >= m) goto L42;
        double[] hI3 = this.householderVectors[i4];
        double beta = 0.0d;
        int j5 = k + 1;
    L36:
        if (j5 >= n) goto L38;
        beta = beta - (hI3[j5] * hK[j5]);
        j5 = j5 + 1;
        goto L36
    L38:
        int j6 = k + 1;
        double beta2 = beta / (hK[j6] * b);
        int j7 = k + 1;
    L39:
        if (j7 >= n) goto L41;
        hI3[j7] = hI3[j7] - (hK[j7] * beta2);
        j7 = j7 + 1;
        goto L39
    L41:
        i4 = i4 + 1;
        goto L34
    L30:
        b = FastMath.sqrt(xNormSqr2);
    L42:
        k = k + 1;
        goto L3
    L10:
        a = FastMath.sqrt(xNormSqr);
        goto L11
    }

    private void transformToLowerBiDiagonal() {
        int m = this.householderVectors.length;
        int n = this.householderVectors[0].length;
        int k = 0;
    L3:
        if (k >= m) goto L47;
        double[] hK = this.householderVectors[k];
        double xNormSqr = 0.0d;
        int j = k;
    L5:
        if (j >= n) goto L8;
        double c = hK[j];
        xNormSqr = xNormSqr + (c * c);
        j = j + 1;
        goto L5
    L8:
        if (hK[k] <= 0.0d) goto L10;
        double a = -FastMath.sqrt(xNormSqr);
    L11:
        this.main[k] = a;
        if (a == 0.0d) goto L22;
        hK[k] = hK[k] - a;
        int i = k + 1;
    L14:
        if (i >= m) goto L22;
        double[] hI = this.householderVectors[i];
        double alpha = 0.0d;
        int j2 = k;
    L16:
        if (j2 >= n) goto L18;
        alpha = alpha - (hI[j2] * hK[j2]);
        j2 = j2 + 1;
        goto L16
    L18:
        double alpha2 = alpha / (this.householderVectors[k][k] * a);
        int j3 = k;
    L19:
        if (j3 >= n) goto L21;
        hI[j3] = hI[j3] - (hK[j3] * alpha2);
        j3 = j3 + 1;
        goto L19
    L21:
        i = i + 1;
    L22:
        int i2 = m - 1;
        if (k >= i2) goto L45;
        double[] hKp1 = this.householderVectors[k + 1];
        double xNormSqr2 = 0.0d;
        int i3 = k + 1;
    L25:
        if (i3 >= m) goto L28;
        double c2 = this.householderVectors[i3][k];
        xNormSqr2 = xNormSqr2 + (c2 * c2);
        i3 = i3 + 1;
        goto L25
    L28:
        if (hKp1[k] <= 0.0d) goto L30;
        double b = -FastMath.sqrt(xNormSqr2);
    L31:
        this.secondary[k] = b;
        if (b == 0.0d) goto L45;
        hKp1[k] = hKp1[k] - b;
        int j4 = k + 1;
    L34:
        if (j4 >= n) goto L45;
        double beta = 0.0d;
        int i4 = k + 1;
    L36:
        if (i4 >= m) goto L38;
        int n2 = n;
        double[] hI2 = this.householderVectors[i4];
        beta = beta - (hI2[j4] * hI2[k]);
        i4 = i4 + 1;
        n = n2;
        goto L36
    L38:
        int n3 = n;
        double beta2 = beta / (hKp1[k] * b);
        int i5 = k + 1;
    L39:
        if (i5 >= m) goto L41;
        double[] hI3 = this.householderVectors[i5];
        hI3[j4] = hI3[j4] - (hI3[k] * beta2);
        i5 = i5 + 1;
        goto L39
    L41:
        j4 = j4 + 1;
        n = n3;
        goto L34
    L30:
        b = FastMath.sqrt(xNormSqr2);
    L45:
        k = k + 1;
        n = n;
        goto L3
    L10:
        a = FastMath.sqrt(xNormSqr);
        goto L11
    }
}
