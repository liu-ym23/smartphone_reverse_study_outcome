package org.apache.commons.math.linear;

import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class LUDecompositionImpl implements LUDecomposition {
    private static final double DEFAULT_TOO_SMALL = 1.0E-11d;
    private RealMatrix cachedL;
    private RealMatrix cachedP;
    private RealMatrix cachedU;
    private boolean even;
    private double[][] lu;
    private int[] pivot;
    private boolean singular;

    /* JADX INFO: renamed from: org.apache.commons.math.linear.LUDecompositionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] lu;
        private final int[] pivot;
        private final boolean singular;

        /* synthetic */ Solver(double[][] x0, int[] x1, boolean x2, AnonymousClass1 x3) {
            this(x0, x1, x2);
        }

        private Solver(double[][] lu, int[] pivot, boolean singular) {
            this.lu = lu;
            this.pivot = pivot;
            this.singular = singular;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public boolean isNonSingular() {
            return !this.singular;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public double[] solve(double[] b) throws IllegalArgumentException, InvalidMatrixException {
            int m = this.pivot.length;
            if (b.length != m) goto L26;
            if (this.singular == true) goto L24;
            double[] bp = new double[m];
            int row = 0;
        L7:
            if (row >= m) goto L9;
            bp[row] = b[this.pivot[row]];
            row = row + 1;
            goto L7
        L9:
            int col = 0;
        L10:
            if (col >= m) goto L15;
            double bpCol = bp[col];
            int i = col + 1;
        L12:
            if (i >= m) goto L14;
            bp[i] = bp[i] - (this.lu[i][col] * bpCol);
            i = i + 1;
            goto L12
        L14:
            col = col + 1;
            goto L10
        L15:
            int col2 = m - 1;
        L16:
            if (col2 < 0) goto L22;
            bp[col2] = bp[col2] / this.lu[col2][col2];
            double bpCol2 = bp[col2];
            int i2 = 0;
        L18:
            if (i2 >= col2) goto L20;
            bp[i2] = bp[i2] - (this.lu[i2][col2] * bpCol2);
            i2 = i2 + 1;
            goto L18
        L20:
            col2 = col2 - 1;
            goto L16
        L22:
            return bp;
        L24:
            throw new SingularMatrixException();
        L26:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.length), Integer.valueOf(m)});
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealVector solve(RealVector b) throws IllegalArgumentException, InvalidMatrixException {
            return solve((ArrayRealVector) b);
        L5:
            int m = this.pivot.length;
            if (b.getDimension() != m) goto L29;
            if (this.singular == true) goto L27;
            double[] bp = new double[m];
            int row = 0;
        L10:
            if (row >= m) goto L12;
            bp[row] = b.getEntry(this.pivot[row]);
            row = row + 1;
            goto L10
        L12:
            int col = 0;
        L13:
            if (col >= m) goto L18;
            double bpCol = bp[col];
            int i = col + 1;
        L15:
            if (i >= m) goto L17;
            bp[i] = bp[i] - (this.lu[i][col] * bpCol);
            i = i + 1;
            goto L15
        L17:
            col = col + 1;
            goto L13
        L18:
            int col2 = m - 1;
        L19:
            if (col2 < 0) goto L25;
            bp[col2] = bp[col2] / this.lu[col2][col2];
            double bpCol2 = bp[col2];
            int i2 = 0;
        L21:
            if (i2 >= col2) goto L23;
            bp[i2] = bp[i2] - (this.lu[i2][col2] * bpCol2);
            i2 = i2 + 1;
            goto L21
        L23:
            col2 = col2 - 1;
            goto L19
        L25:
            return new ArrayRealVector(bp, false);
        L27:
            throw new SingularMatrixException();
        L29:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.getDimension()), Integer.valueOf(m)});
        }

        public ArrayRealVector solve(ArrayRealVector b) throws IllegalArgumentException, InvalidMatrixException {
            return new ArrayRealVector(solve(b.getDataRef()), false);
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix b) throws IllegalArgumentException, InvalidMatrixException {
            int m = this.pivot.length;
            if (b.getRowDimension() != m) goto L38;
            if (this.singular == true) goto L36;
            int nColB = b.getColumnDimension();
            double[][] bp = (double[][]) Array.newInstance(Double.TYPE, new int[]{m, nColB});
            int row = 0;
        L7:
            if (row >= m) goto L12;
            double[] bpRow = bp[row];
            int pRow = this.pivot[row];
            int col = 0;
        L9:
            if (col >= nColB) goto L11;
            bpRow[col] = b.getEntry(pRow, col);
            col = col + 1;
            goto L9
        L11:
            row = row + 1;
            goto L7
        L12:
            int col2 = 0;
        L13:
            if (col2 >= m) goto L21;
            double[] bpCol = bp[col2];
            int i = col2 + 1;
        L15:
            if (i >= m) goto L20;
            double[] bpI = bp[i];
            double luICol = this.lu[i][col2];
            int j = 0;
        L17:
            if (j >= nColB) goto L19;
            bpI[j] = bpI[j] - (bpCol[j] * luICol);
            j = j + 1;
            goto L17
        L19:
            i = i + 1;
            goto L15
        L20:
            col2 = col2 + 1;
            goto L13
        L21:
            int col3 = m - 1;
        L22:
            if (col3 < 0) goto L34;
            double[] bpCol2 = bp[col3];
            double luDiag = this.lu[col3][col3];
            int j2 = 0;
        L24:
            if (j2 >= nColB) goto L26;
            bpCol2[j2] = bpCol2[j2] / luDiag;
            j2 = j2 + 1;
            goto L24
        L26:
            int i2 = 0;
        L27:
            if (i2 >= col3) goto L32;
            double[] bpI2 = bp[i2];
            double luICol2 = this.lu[i2][col3];
            int j3 = 0;
        L29:
            if (j3 >= nColB) goto L31;
            bpI2[j3] = bpI2[j3] - (bpCol2[j3] * luICol2);
            j3 = j3 + 1;
            goto L29
        L31:
            i2 = i2 + 1;
            goto L27
        L32:
            col3 = col3 - 1;
            goto L22
        L34:
            return new Array2DRowRealMatrix(bp, false);
        L36:
            throw new SingularMatrixException();
        L38:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n"});
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix getInverse() throws InvalidMatrixException {
            return solve(MatrixUtils.createRealIdentityMatrix(this.pivot.length));
        }
    }

    public LUDecompositionImpl(RealMatrix matrix) throws InvalidMatrixException {
        this(matrix, 1.0E-11d);
    }

    public LUDecompositionImpl(RealMatrix matrix, double singularityThreshold) throws NonSquareMatrixException {
        if (matrix.isSquare() == false) goto L40;
        int m = matrix.getColumnDimension();
        this.lu = matrix.getData();
        this.pivot = new int[m];
        this.cachedL = null;
        this.cachedU = null;
        this.cachedP = null;
        int row = 0;
    L5:
        if (row >= m) goto L7;
        this.pivot[row] = row;
        row = row + 1;
        goto L5
    L7:
        this.even = true;
        this.singular = false;
        int col = 0;
    L8:
        if (col >= m) goto L38;
        int row2 = 0;
    L10:
        if (row2 >= col) goto L15;
        double[] luRow = this.lu[row2];
        double sum = luRow[col];
        int i = 0;
    L12:
        if (i >= row2) goto L14;
        sum = sum - (luRow[i] * this.lu[i][col]);
        i = i + 1;
        goto L12
    L14:
        luRow[col] = sum;
        row2 = row2 + 1;
        goto L10
    L15:
        int max = col;
        double largest = Double.NEGATIVE_INFINITY;
        int row3 = col;
    L16:
        if (row3 >= m) goto L25;
        double[] luRow2 = this.lu[row3];
        double sum2 = luRow2[col];
        int i2 = 0;
    L18:
        if (i2 >= col) goto L20;
        sum2 = sum2 - (luRow2[i2] * this.lu[i2][col]);
        i2 = i2 + 1;
        goto L18
    L20:
        luRow2[col] = sum2;
        if (FastMath.abs(sum2) <= largest) goto L23;
        largest = FastMath.abs(sum2);
        max = row3;
    L23:
        row3 = row3 + 1;
        goto L16
    L25:
        if (FastMath.abs(this.lu[max][col]) < singularityThreshold) goto L26;
        if (max == col) goto L33;
        double[] luMax = this.lu[max];
        double[] luCol = this.lu[col];
        int i3 = 0;
    L30:
        if (i3 >= m) goto L32;
        double tmp = luMax[i3];
        luMax[i3] = luCol[i3];
        luCol[i3] = tmp;
        i3 = i3 + 1;
        goto L30
    L32:
        int temp = this.pivot[max];
        this.pivot[max] = this.pivot[col];
        this.pivot[col] = temp;
        this.even = !this.even;
    L33:
        double luDiag = this.lu[col][col];
        int row4 = col + 1;
    L34:
        if (row4 >= m) goto L36;
        double[] r12 = this.lu[row4];
        r12[col] = r12[col] / luDiag;
        row4 = row4 + 1;
        goto L34
    L36:
        col = col + 1;
        goto L8
    L26:
        this.singular = true;
        return;
    L38:
        return;
    L40:
        throw new NonSquareMatrixException(matrix.getRowDimension(), matrix.getColumnDimension());
    }

    @Override // org.apache.commons.math.linear.LUDecomposition
    public RealMatrix getL() {
        if (this.cachedL != null) goto L13;
        if (this.singular == true) goto L13;
        int m = this.pivot.length;
        this.cachedL = MatrixUtils.createRealMatrix(m, m);
        int i = 0;
    L7:
        if (i >= m) goto L13;
        double[] luI = this.lu[i];
        int j = 0;
    L9:
        if (j >= i) goto L11;
        this.cachedL.setEntry(i, j, luI[j]);
        j = j + 1;
        goto L9
    L11:
        this.cachedL.setEntry(i, i, 1.0d);
        i = i + 1;
    L13:
        return this.cachedL;
    }

    @Override // org.apache.commons.math.linear.LUDecomposition
    public RealMatrix getU() {
        if (this.cachedU != null) goto L13;
        if (this.singular == true) goto L13;
        int m = this.pivot.length;
        this.cachedU = MatrixUtils.createRealMatrix(m, m);
        int i = 0;
    L7:
        if (i >= m) goto L13;
        double[] luI = this.lu[i];
        int j = i;
    L9:
        if (j >= m) goto L11;
        this.cachedU.setEntry(i, j, luI[j]);
        j = j + 1;
        goto L9
    L11:
        i = i + 1;
    L13:
        return this.cachedU;
    }

    @Override // org.apache.commons.math.linear.LUDecomposition
    public RealMatrix getP() {
        if (this.cachedP != null) goto L10;
        if (this.singular == true) goto L10;
        int m = this.pivot.length;
        this.cachedP = MatrixUtils.createRealMatrix(m, m);
        int i = 0;
    L7:
        if (i >= m) goto L10;
        this.cachedP.setEntry(i, this.pivot[i], 1.0d);
        i = i + 1;
    L10:
        return this.cachedP;
    }

    @Override // org.apache.commons.math.linear.LUDecomposition
    public int[] getPivot() {
        return (int[]) this.pivot.clone();
    }

    @Override // org.apache.commons.math.linear.LUDecomposition
    public double getDeterminant() {
        if (this.singular == false) goto L6;
        return 0.0d;
    L6:
        int m = this.pivot.length;
        if (this.even == false) goto L9;
        double determinant = 1.0d;
    L10:
        int i = 0;
    L11:
        if (i >= m) goto L14;
        determinant = determinant * this.lu[i][i];
        i = i + 1;
        goto L11
    L14:
        return determinant;
    L9:
        determinant = -1.0d;
        goto L10
    }

    @Override // org.apache.commons.math.linear.LUDecomposition
    public DecompositionSolver getSolver() {
        return new Solver(this.lu, this.pivot, this.singular, null);
    }
}
