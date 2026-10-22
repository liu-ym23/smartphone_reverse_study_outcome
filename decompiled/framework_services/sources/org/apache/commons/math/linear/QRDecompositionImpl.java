package org.apache.commons.math.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class QRDecompositionImpl implements QRDecomposition {
    private RealMatrix cachedH;
    private RealMatrix cachedQ;
    private RealMatrix cachedQT;
    private RealMatrix cachedR;
    private double[][] qrt;
    private double[] rDiag;

    /* JADX INFO: renamed from: org.apache.commons.math.linear.QRDecompositionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] qrt;
        private final double[] rDiag;

        /* synthetic */ Solver(double[][] x0, double[] x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        private Solver(double[][] qrt, double[] rDiag) {
            this.qrt = qrt;
            this.rDiag = rDiag;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public boolean isNonSingular() {
            double[] r0 = this.rDiag;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L8;
            double diag = r0[r3];
            if (diag == 0.0d) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public double[] solve(double[] b) throws IllegalArgumentException, InvalidMatrixException {
            int n = this.qrt.length;
            int m = this.qrt[0].length;
            if (b.length != m) goto L27;
            if (isNonSingular() == false) goto L25;
            double[] x = new double[n];
            double[] y = (double[]) b.clone();
            int minor = 0;
        L8:
            if (minor >= FastMath.min(m, n)) goto L16;
            double[] qrtMinor = this.qrt[minor];
            double dotProduct = 0.0d;
            int row = minor;
        L10:
            if (row >= m) goto L12;
            dotProduct = dotProduct + (y[row] * qrtMinor[row]);
            row = row + 1;
            goto L10
        L12:
            double dotProduct2 = dotProduct / (this.rDiag[minor] * qrtMinor[minor]);
            int row2 = minor;
        L13:
            if (row2 >= m) goto L15;
            y[row2] = y[row2] + (qrtMinor[row2] * dotProduct2);
            row2 = row2 + 1;
            goto L13
        L15:
            minor = minor + 1;
            goto L8
        L16:
            int row3 = this.rDiag.length - 1;
        L17:
            if (row3 < 0) goto L23;
            y[row3] = y[row3] / this.rDiag[row3];
            double yRow = y[row3];
            double[] qrtRow = this.qrt[row3];
            x[row3] = yRow;
            int i = 0;
        L19:
            if (i >= row3) goto L21;
            y[i] = y[i] - (qrtRow[i] * yRow);
            i = i + 1;
            goto L19
        L21:
            row3 = row3 - 1;
            goto L17
        L23:
            return x;
        L25:
            throw new SingularMatrixException();
        L27:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.length), Integer.valueOf(m)});
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealVector solve(RealVector b) throws IllegalArgumentException, InvalidMatrixException {
            return solve((ArrayRealVector) b);
        L6:
            return new ArrayRealVector(solve(b.getData()), false);
        }

        public ArrayRealVector solve(ArrayRealVector b) throws IllegalArgumentException, InvalidMatrixException {
            return new ArrayRealVector(solve(b.getDataRef()), false);
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix b) throws IllegalArgumentException, InvalidMatrixException {
            Solver r0 = this;
            int n = r0.qrt.length;
            int r3 = 0;
            int m = r0.qrt[0].length;
            if (b.getRowDimension() != m) goto L45;
            if (r0.isNonSingular() == false) goto L43;
            int columns = b.getColumnDimension();
            int blockSize = 52;
            boolean r7 = true;
            int cBlocks = ((columns + 52) - 1) / 52;
            double[][] xBlocks = BlockRealMatrix.createBlocksLayout(n, columns);
            double[][] y = (double[][]) Array.newInstance(Double.TYPE, new int[]{b.getRowDimension(), 52});
            double[] alpha = new double[52];
            int kBlock = 0;
        L7:
            if (kBlock >= cBlocks) goto L41;
            int kStart = kBlock * 52;
            int kEnd = FastMath.min(kStart + 52, columns);
            int kWidth = kEnd - kStart;
            boolean r18 = r7;
            b.copySubMatrix(0, m - 1, kStart, kEnd - 1, y);
            int minor = 0;
        L10:
            if (minor >= FastMath.min(m, n)) goto L27;
            double[] qrtMinor = r0.qrt[minor];
            double factor = 1.0d / (r0.rDiag[minor] * qrtMinor[minor]);
            int blockSize2 = blockSize;
            int cBlocks2 = cBlocks;
            Arrays.fill(alpha, r3, kWidth, 0.0d);
            int row = minor;
        L12:
            if (row >= m) goto L17;
            double d = qrtMinor[row];
            double[] yRow = y[row];
            int k = 0;
        L14:
            if (k >= kWidth) goto L16;
            alpha[k] = alpha[k] + (yRow[k] * d);
            k = k + 1;
            goto L14
        L16:
            row = row + 1;
            goto L12
        L17:
            int k2 = 0;
        L18:
            if (k2 >= kWidth) goto L20;
            alpha[k2] = alpha[k2] * factor;
            k2 = k2 + 1;
            goto L18
        L20:
            int row2 = minor;
        L21:
            if (row2 >= m) goto L26;
            double d2 = qrtMinor[row2];
            double[] yRow2 = y[row2];
            int m2 = m;
            int m3 = 0;
        L23:
            if (m3 >= kWidth) goto L25;
            yRow2[m3] = yRow2[m3] + (alpha[m3] * d2);
            m3 = m3 + 1;
            goto L23
        L25:
            row2 = row2 + 1;
            m = m2;
            goto L21
        L26:
            minor = minor + 1;
            blockSize = blockSize2;
            cBlocks = cBlocks2;
            r3 = 0;
            goto L10
        L27:
            int m4 = m;
            int blockSize3 = blockSize;
            int cBlocks3 = cBlocks;
            int j = r0.rDiag.length - 1;
        L28:
            if (j < 0) goto L39;
            int jBlock = j / 52;
            int jStart = jBlock * 52;
            double factor2 = 1.0d / r0.rDiag[j];
            double[] yJ = y[j];
            double[] xBlock = xBlocks[(jBlock * cBlocks3) + kBlock];
            int index = (j - jStart) * kWidth;
            int jBlock2 = 0;
        L30:
            if (jBlock2 >= kWidth) goto L32;
            yJ[jBlock2] = yJ[jBlock2] * factor2;
            xBlock[index] = yJ[jBlock2];
            jBlock2 = jBlock2 + 1;
            index = index + 1;
            goto L30
        L32:
            double[] qrtJ = r0.qrt[j];
            int k3 = 0;
        L33:
            if (k3 >= j) goto L38;
            double rIJ = qrtJ[k3];
            double[] yI = y[k3];
            int i = k3;
            int i2 = 0;
        L35:
            if (i2 >= kWidth) goto L37;
            yI[i2] = yI[i2] - (yJ[i2] * rIJ);
            i2 = i2 + 1;
            goto L35
        L37:
            k3 = i + 1;
            goto L33
        L38:
            j = j - 1;
            r0 = this;
            goto L28
        L39:
            kBlock = kBlock + 1;
            r0 = this;
            blockSize = blockSize3;
            cBlocks = cBlocks3;
            r7 = r18;
            m = m4;
            r3 = 0;
            goto L7
        L41:
            return new BlockRealMatrix(n, columns, xBlocks, false);
        L43:
            throw new SingularMatrixException();
        L45:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n"});
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix getInverse() throws InvalidMatrixException {
            return solve(MatrixUtils.createRealIdentityMatrix(this.rDiag.length));
        }
    }

    public QRDecompositionImpl(RealMatrix matrix) {
        int m = matrix.getRowDimension();
        int n = matrix.getColumnDimension();
        this.qrt = matrix.transpose().getData();
        this.rDiag = new double[FastMath.min(m, n)];
        this.cachedQ = null;
        this.cachedQT = null;
        this.cachedR = null;
        this.cachedH = null;
        int minor = 0;
    L4:
        if (minor >= FastMath.min(m, n)) goto L25;
        double[] qrtMinor = this.qrt[minor];
        double xNormSqr = 0.0d;
        int row = minor;
    L6:
        if (row >= m) goto L9;
        double c = qrtMinor[row];
        xNormSqr = xNormSqr + (c * c);
        row = row + 1;
        goto L6
    L9:
        if (qrtMinor[minor] <= 0.0d) goto L11;
        double a = -FastMath.sqrt(xNormSqr);
    L12:
        this.rDiag[minor] = a;
        if (a == 0.0d) goto L23;
        qrtMinor[minor] = qrtMinor[minor] - a;
        int col = minor + 1;
    L15:
        if (col >= n) goto L23;
        double[] qrtCol = this.qrt[col];
        double alpha = 0.0d;
        int row2 = minor;
    L17:
        if (row2 >= m) goto L19;
        alpha = alpha - (qrtCol[row2] * qrtMinor[row2]);
        row2 = row2 + 1;
        goto L17
    L19:
        double alpha2 = alpha / (qrtMinor[minor] * a);
        int row3 = minor;
    L20:
        if (row3 >= m) goto L22;
        qrtCol[row3] = qrtCol[row3] - (qrtMinor[row3] * alpha2);
        row3 = row3 + 1;
        goto L20
    L22:
        col = col + 1;
    L23:
        minor = minor + 1;
        goto L4
    L11:
        a = FastMath.sqrt(xNormSqr);
        goto L12
    }

    @Override // org.apache.commons.math.linear.QRDecomposition
    public RealMatrix getR() {
        if (this.cachedR != null) goto L11;
        int n = this.qrt.length;
        int m = this.qrt[0].length;
        this.cachedR = MatrixUtils.createRealMatrix(m, n);
        int row = FastMath.min(m, n) - 1;
    L5:
        if (row < 0) goto L11;
        this.cachedR.setEntry(row, row, this.rDiag[row]);
        int col = row + 1;
    L7:
        if (col >= n) goto L9;
        this.cachedR.setEntry(row, col, this.qrt[col][row]);
        col = col + 1;
        goto L7
    L9:
        row = row - 1;
    L11:
        return this.cachedR;
    }

    @Override // org.apache.commons.math.linear.QRDecomposition
    public RealMatrix getQ() {
        if (this.cachedQ != null) goto L6;
        this.cachedQ = getQT().transpose();
    L6:
        return this.cachedQ;
    }

    @Override // org.apache.commons.math.linear.QRDecomposition
    public RealMatrix getQT() {
        if (this.cachedQT != null) goto L23;
        int n = this.qrt.length;
        int m = this.qrt[0].length;
        this.cachedQT = MatrixUtils.createRealMatrix(m, m);
        int minor = m - 1;
    L6:
        if (minor < FastMath.min(m, n)) goto L8;
        this.cachedQT.setEntry(minor, minor, 1.0d);
        minor = minor - 1;
        goto L6
    L8:
        int minor2 = FastMath.min(m, n);
        int minor3 = minor2 - 1;
    L9:
        if (minor3 < 0) goto L23;
        double[] qrtMinor = this.qrt[minor3];
        this.cachedQT.setEntry(minor3, minor3, 1.0d);
        if (qrtMinor[minor3] == 0.0d) goto L21;
        int col = minor3;
    L13:
        if (col >= m) goto L21;
        double alpha = 0.0d;
        int row = minor3;
    L15:
        if (row >= m) goto L17;
        alpha = alpha - (this.cachedQT.getEntry(col, row) * qrtMinor[row]);
        row = row + 1;
        goto L15
    L17:
        double alpha2 = alpha / (this.rDiag[minor3] * qrtMinor[minor3]);
        int row2 = minor3;
    L18:
        if (row2 >= m) goto L20;
        this.cachedQT.addToEntry(col, row2, (-alpha2) * qrtMinor[row2]);
        row2 = row2 + 1;
        goto L18
    L20:
        col = col + 1;
    L21:
        minor3 = minor3 - 1;
    L23:
        return this.cachedQT;
    }

    @Override // org.apache.commons.math.linear.QRDecomposition
    public RealMatrix getH() {
        if (this.cachedH != null) goto L12;
        int n = this.qrt.length;
        int m = this.qrt[0].length;
        this.cachedH = MatrixUtils.createRealMatrix(m, n);
        int i = 0;
    L5:
        if (i >= m) goto L12;
        int j = 0;
    L8:
        if (j >= FastMath.min(i + 1, n)) goto L10;
        this.cachedH.setEntry(i, j, this.qrt[j][i] / (-this.rDiag[j]));
        j = j + 1;
        goto L8
    L10:
        i = i + 1;
    L12:
        return this.cachedH;
    }

    @Override // org.apache.commons.math.linear.QRDecomposition
    public DecompositionSolver getSolver() {
        return new Solver(this.qrt, this.rDiag, null);
    }
}
