package org.apache.commons.math.linear;

import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class CholeskyDecompositionImpl implements CholeskyDecomposition {
    public static final double DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD = 1.0E-10d;
    public static final double DEFAULT_RELATIVE_SYMMETRY_THRESHOLD = 1.0E-15d;
    private RealMatrix cachedL;
    private RealMatrix cachedLT;
    private double[][] lTData;

    /* JADX INFO: renamed from: org.apache.commons.math.linear.CholeskyDecompositionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] lTData;

        /* synthetic */ Solver(double[][] x0, AnonymousClass1 x1) {
            this(x0);
        }

        private Solver(double[][] lTData) {
            this.lTData = lTData;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public boolean isNonSingular() {
            return true;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public double[] solve(double[] b) throws IllegalArgumentException, InvalidMatrixException {
            int m = this.lTData.length;
            if (b.length != m) goto L19;
            double[] x = (double[]) b.clone();
            int j = 0;
        L5:
            if (j >= m) goto L10;
            double[] lJ = this.lTData[j];
            x[j] = x[j] / lJ[j];
            double xJ = x[j];
            int i = j + 1;
        L7:
            if (i >= m) goto L9;
            x[i] = x[i] - (lJ[i] * xJ);
            i = i + 1;
            goto L7
        L9:
            j = j + 1;
            goto L5
        L10:
            int j2 = m - 1;
        L11:
            if (j2 < 0) goto L17;
            x[j2] = x[j2] / this.lTData[j2][j2];
            double xJ2 = x[j2];
            int i2 = 0;
        L13:
            if (i2 >= j2) goto L15;
            x[i2] = x[i2] - (this.lTData[i2][j2] * xJ2);
            i2 = i2 + 1;
            goto L13
        L15:
            j2 = j2 - 1;
            goto L11
        L17:
            return x;
        L19:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.length), Integer.valueOf(m)});
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealVector solve(RealVector b) throws IllegalArgumentException, InvalidMatrixException {
            return solve((ArrayRealVector) b);
        L5:
            int m = this.lTData.length;
            if (b.getDimension() != m) goto L22;
            double[] x = b.getData();
            int j = 0;
        L8:
            if (j >= m) goto L13;
            double[] lJ = this.lTData[j];
            x[j] = x[j] / lJ[j];
            double xJ = x[j];
            int i = j + 1;
        L10:
            if (i >= m) goto L12;
            x[i] = x[i] - (lJ[i] * xJ);
            i = i + 1;
            goto L10
        L12:
            j = j + 1;
            goto L8
        L13:
            int j2 = m - 1;
        L14:
            if (j2 < 0) goto L20;
            x[j2] = x[j2] / this.lTData[j2][j2];
            double xJ2 = x[j2];
            int i2 = 0;
        L16:
            if (i2 >= j2) goto L18;
            x[i2] = x[i2] - (this.lTData[i2][j2] * xJ2);
            i2 = i2 + 1;
            goto L16
        L18:
            j2 = j2 - 1;
            goto L14
        L20:
            return new ArrayRealVector(x, false);
        L22:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.getDimension()), Integer.valueOf(m)});
        }

        public ArrayRealVector solve(ArrayRealVector b) throws IllegalArgumentException, InvalidMatrixException {
            return new ArrayRealVector(solve(b.getDataRef()), false);
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix b) throws IllegalArgumentException, InvalidMatrixException {
            int m = this.lTData.length;
            if (b.getRowDimension() != m) goto L31;
            int nColB = b.getColumnDimension();
            double[][] x = b.getData();
            int j = 0;
        L5:
            if (j >= m) goto L16;
            double[] lJ = this.lTData[j];
            double lJJ = lJ[j];
            double[] xJ = x[j];
            int k = 0;
        L7:
            if (k >= nColB) goto L9;
            xJ[k] = xJ[k] / lJJ;
            k = k + 1;
            goto L7
        L9:
            int i = j + 1;
        L10:
            if (i >= m) goto L15;
            double[] xI = x[i];
            double lJI = lJ[i];
            int k2 = 0;
        L12:
            if (k2 >= nColB) goto L14;
            xI[k2] = xI[k2] - (xJ[k2] * lJI);
            k2 = k2 + 1;
            goto L12
        L14:
            i = i + 1;
            goto L10
        L15:
            j = j + 1;
            goto L5
        L16:
            int j2 = m - 1;
        L17:
            if (j2 < 0) goto L29;
            double lJJ2 = this.lTData[j2][j2];
            double[] xJ2 = x[j2];
            int k3 = 0;
        L19:
            if (k3 >= nColB) goto L21;
            xJ2[k3] = xJ2[k3] / lJJ2;
            k3 = k3 + 1;
            goto L19
        L21:
            int i2 = 0;
        L22:
            if (i2 >= j2) goto L27;
            double[] xI2 = x[i2];
            double lIJ = this.lTData[i2][j2];
            int k4 = 0;
        L24:
            if (k4 >= nColB) goto L26;
            xI2[k4] = xI2[k4] - (xJ2[k4] * lIJ);
            k4 = k4 + 1;
            goto L24
        L26:
            i2 = i2 + 1;
            goto L22
        L27:
            j2 = j2 - 1;
            goto L17
        L29:
            return new Array2DRowRealMatrix(x, false);
        L31:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n"});
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix getInverse() throws InvalidMatrixException {
            return solve(MatrixUtils.createRealIdentityMatrix(this.lTData.length));
        }
    }

    public CholeskyDecompositionImpl(RealMatrix matrix) throws NonSquareMatrixException, NotSymmetricMatrixException, NotPositiveDefiniteMatrixException {
        this(matrix, 1.0E-15d, 1.0E-10d);
    }

    public CholeskyDecompositionImpl(RealMatrix matrix, double relativeSymmetryThreshold, double absolutePositivityThreshold) throws NonSquareMatrixException, NotSymmetricMatrixException, NotPositiveDefiniteMatrixException {
        if (matrix.isSquare() == false) goto L30;
        int order = matrix.getRowDimension();
        this.lTData = matrix.getData();
        this.cachedL = null;
        this.cachedLT = null;
        int i = 0;
    L5:
        if (i >= order) goto L14;
        double[] lI = this.lTData[i];
        int j = i + 1;
    L7:
        if (j >= order) goto L13;
        double[] lJ = this.lTData[j];
        double lIJ = lI[j];
        double lJI = lJ[i];
        double maxDelta = FastMath.max(FastMath.abs(lIJ), FastMath.abs(lJI)) * relativeSymmetryThreshold;
        if (FastMath.abs(lIJ - lJI) > maxDelta) goto L12;
        lJ[i] = 0.0d;
        j = j + 1;
        goto L7
    L12:
        throw new NotSymmetricMatrixException();
    L13:
        i = i + 1;
        goto L5
    L14:
        int i2 = 0;
    L15:
        if (i2 >= order) goto L28;
        double[] ltI = this.lTData[i2];
        if (ltI[i2] < absolutePositivityThreshold) goto L26;
        ltI[i2] = FastMath.sqrt(ltI[i2]);
        double inverse = 1.0d / ltI[i2];
        int q = order - 1;
    L19:
        if (q <= i2) goto L24;
        ltI[q] = ltI[q] * inverse;
        double[] ltQ = this.lTData[q];
        int p = q;
    L21:
        if (p >= order) goto L23;
        ltQ[p] = ltQ[p] - (ltI[q] * ltI[p]);
        p = p + 1;
        goto L21
    L23:
        q = q - 1;
        goto L19
    L24:
        i2 = i2 + 1;
        goto L15
    L26:
        throw new NotPositiveDefiniteMatrixException();
    L28:
        return;
    L30:
        throw new NonSquareMatrixException(matrix.getRowDimension(), matrix.getColumnDimension());
    }

    @Override // org.apache.commons.math.linear.CholeskyDecomposition
    public RealMatrix getL() {
        if (this.cachedL != null) goto L6;
        this.cachedL = getLT().transpose();
    L6:
        return this.cachedL;
    }

    @Override // org.apache.commons.math.linear.CholeskyDecomposition
    public RealMatrix getLT() {
        if (this.cachedLT != null) goto L6;
        this.cachedLT = MatrixUtils.createRealMatrix(this.lTData);
    L6:
        return this.cachedLT;
    }

    @Override // org.apache.commons.math.linear.CholeskyDecomposition
    public double getDeterminant() {
        double determinant = 1.0d;
        int i = 0;
    L4:
        if (i >= this.lTData.length) goto L7;
        double lTii = this.lTData[i][i];
        determinant = determinant * (lTii * lTii);
        i = i + 1;
        goto L4
    L7:
        return determinant;
    }

    @Override // org.apache.commons.math.linear.CholeskyDecomposition
    public DecompositionSolver getSolver() {
        return new Solver(this.lTData, null);
    }
}
