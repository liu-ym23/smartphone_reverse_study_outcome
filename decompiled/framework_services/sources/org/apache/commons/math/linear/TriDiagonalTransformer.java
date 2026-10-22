package org.apache.commons.math.linear;

import java.util.Arrays;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
class TriDiagonalTransformer {
    private RealMatrix cachedQ;
    private RealMatrix cachedQt;
    private RealMatrix cachedT;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    public TriDiagonalTransformer(RealMatrix matrix) throws InvalidMatrixException {
        if (matrix.isSquare() == false) goto L7;
        int m = matrix.getRowDimension();
        this.householderVectors = matrix.getData();
        this.main = new double[m];
        this.secondary = new double[m - 1];
        this.cachedQ = null;
        this.cachedQt = null;
        this.cachedT = null;
        transform();
        return;
    L7:
        throw new NonSquareMatrixException(matrix.getRowDimension(), matrix.getColumnDimension());
    }

    public RealMatrix getQ() {
        if (this.cachedQ != null) goto L6;
        this.cachedQ = getQT().transpose();
    L6:
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        if (this.cachedQt != null) goto L24;
        int m = this.householderVectors.length;
        this.cachedQt = MatrixUtils.createRealMatrix(m, m);
        int k = m - 1;
    L6:
        if (k < 1) goto L22;
        double[] hK = this.householderVectors[k - 1];
        double inv = 1.0d / (this.secondary[k - 1] * hK[k]);
        this.cachedQt.setEntry(k, k, 1.0d);
        if (hK[k] == 0.0d) goto L21;
        double beta = 1.0d / this.secondary[k - 1];
        this.cachedQt.setEntry(k, k, (hK[k] * beta) + 1.0d);
        int i = k + 1;
    L10:
        if (i >= m) goto L12;
        this.cachedQt.setEntry(k, i, hK[i] * beta);
        i = i + 1;
        goto L10
    L12:
        int j = k + 1;
    L13:
        if (j >= m) goto L21;
        double beta2 = 0.0d;
        int i2 = k + 1;
    L15:
        if (i2 >= m) goto L17;
        beta2 = beta2 + (this.cachedQt.getEntry(j, i2) * hK[i2]);
        i2 = i2 + 1;
        goto L15
    L17:
        double beta3 = beta2 * inv;
        this.cachedQt.setEntry(j, k, hK[k] * beta3);
        int i3 = k + 1;
    L18:
        if (i3 >= m) goto L20;
        this.cachedQt.addToEntry(j, i3, hK[i3] * beta3);
        i3 = i3 + 1;
        goto L18
    L20:
        j = j + 1;
    L21:
        k = k - 1;
        goto L6
    L22:
        this.cachedQt.setEntry(0, 0, 1.0d);
    L24:
        return this.cachedQt;
    }

    public RealMatrix getT() {
        if (this.cachedT != null) goto L14;
        int m = this.main.length;
        this.cachedT = MatrixUtils.createRealMatrix(m, m);
        int i = 0;
    L5:
        if (i >= m) goto L14;
        this.cachedT.setEntry(i, i, this.main[i]);
        if (i <= 0) goto L10;
        this.cachedT.setEntry(i, i - 1, this.secondary[i - 1]);
    L10:
        if (i >= (this.main.length - 1)) goto L12;
        this.cachedT.setEntry(i, i + 1, this.secondary[i]);
    L12:
        i = i + 1;
    L14:
        return this.cachedT;
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

    private void transform() {
        int m = this.householderVectors.length;
        double[] z = new double[m];
        int k = 0;
    L4:
        if (k >= (m - 1)) goto L34;
        double[] hK = this.householderVectors[k];
        this.main[k] = hK[k];
        double xNormSqr = 0.0d;
        int j = k + 1;
    L6:
        if (j >= m) goto L8;
        double c = hK[j];
        xNormSqr = xNormSqr + (c * c);
        j = j + 1;
        goto L6
    L8:
        int j2 = k + 1;
        if (hK[j2] <= 0.0d) goto L11;
        double a = -FastMath.sqrt(xNormSqr);
    L12:
        this.secondary[k] = a;
        if (a == 0.0d) goto L32;
        int r11 = k + 1;
        hK[r11] = hK[r11] - a;
        double beta = (-1.0d) / (hK[k + 1] * a);
        Arrays.fill(z, k + 1, m, 0.0d);
        int i = k + 1;
    L15:
        if (i >= m) goto L20;
        double[] hI = this.householderVectors[i];
        double hKI = hK[i];
        double zI = hI[i] * hKI;
        double[] z2 = z;
        int j3 = i + 1;
    L17:
        if (j3 >= m) goto L19;
        double hIJ = hI[j3];
        zI = zI + (hK[j3] * hIJ);
        z2[j3] = z2[j3] + (hIJ * hKI);
        j3 = j3 + 1;
        goto L17
    L19:
        z2[i] = (z2[i] + zI) * beta;
        i = i + 1;
        z = z2;
        goto L15
    L20:
        double[] z3 = z;
        double gamma = 0.0d;
        int i2 = k + 1;
    L21:
        if (i2 >= m) goto L23;
        gamma = gamma + (z3[i2] * hK[i2]);
        i2 = i2 + 1;
        goto L21
    L23:
        double gamma2 = gamma * (beta / 2.0d);
        int i3 = k + 1;
    L24:
        if (i3 >= m) goto L26;
        z3[i3] = z3[i3] - (hK[i3] * gamma2);
        i3 = i3 + 1;
        goto L24
    L26:
        int i4 = k + 1;
    L27:
        if (i4 >= m) goto L33;
        double[] hI2 = this.householderVectors[i4];
        int j4 = i4;
    L29:
        if (j4 >= m) goto L31;
        hI2[j4] = hI2[j4] - ((hK[i4] * z3[j4]) + (z3[i4] * hK[j4]));
        j4 = j4 + 1;
        goto L29
    L31:
        i4 = i4 + 1;
    L33:
        k = k + 1;
        z = z3;
        goto L4
    L32:
        z3 = z;
        goto L33
    L11:
        a = FastMath.sqrt(xNormSqr);
        goto L12
    L34:
        double[] z4 = this.main;
        z4[m - 1] = this.householderVectors[m - 1][m - 1];
    }
}
