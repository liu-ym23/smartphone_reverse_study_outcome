package org.apache.commons.math.linear;

import android.hardware.tv.mediaquality.ParameterName;
import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class EigenDecompositionImpl implements EigenDecomposition {
    private RealMatrix cachedD;
    private RealMatrix cachedV;
    private RealMatrix cachedVt;
    private ArrayRealVector[] eigenvectors;
    private double[] imagEigenvalues;
    private double[] main;
    private byte maxIter;
    private double[] realEigenvalues;
    private double[] secondary;
    private TriDiagonalTransformer transformer;

    /* JADX INFO: renamed from: org.apache.commons.math.linear.EigenDecompositionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final ArrayRealVector[] eigenvectors;
        private double[] imagEigenvalues;
        private double[] realEigenvalues;

        /* synthetic */ Solver(double[] x0, double[] x1, ArrayRealVector[] x2, AnonymousClass1 x3) {
            this(x0, x1, x2);
        }

        private Solver(double[] realEigenvalues, double[] imagEigenvalues, ArrayRealVector[] eigenvectors) {
            this.realEigenvalues = realEigenvalues;
            this.imagEigenvalues = imagEigenvalues;
            this.eigenvectors = eigenvectors;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public double[] solve(double[] b) throws IllegalArgumentException, InvalidMatrixException {
            if (isNonSingular() == false) goto L17;
            int m = this.realEigenvalues.length;
            if (b.length != m) goto L15;
            double[] bp = new double[m];
            int i = 0;
        L7:
            if (i >= m) goto L13;
            ArrayRealVector v = this.eigenvectors[i];
            double[] vData = v.getDataRef();
            double s = v.dotProduct(b) / this.realEigenvalues[i];
            int j = 0;
        L9:
            if (j >= m) goto L11;
            bp[j] = bp[j] + (vData[j] * s);
            j = j + 1;
            goto L9
        L11:
            i = i + 1;
            goto L7
        L13:
            return bp;
        L15:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.length), Integer.valueOf(m)});
        L17:
            throw new SingularMatrixException();
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealVector solve(RealVector b) throws IllegalArgumentException, InvalidMatrixException {
            if (isNonSingular() == false) goto L17;
            int m = this.realEigenvalues.length;
            if (b.getDimension() != m) goto L15;
            double[] bp = new double[m];
            int i = 0;
        L7:
            if (i >= m) goto L13;
            ArrayRealVector v = this.eigenvectors[i];
            double[] vData = v.getDataRef();
            double s = v.dotProduct(b) / this.realEigenvalues[i];
            int j = 0;
        L9:
            if (j >= m) goto L11;
            bp[j] = bp[j] + (vData[j] * s);
            j = j + 1;
            goto L9
        L11:
            i = i + 1;
            goto L7
        L13:
            return new ArrayRealVector(bp, false);
        L15:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.getDimension()), Integer.valueOf(m)});
        L17:
            throw new SingularMatrixException();
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix b) throws IllegalArgumentException, InvalidMatrixException {
            if (isNonSingular() == false) goto L23;
            int m = this.realEigenvalues.length;
            if (b.getRowDimension() != m) goto L21;
            int nColB = b.getColumnDimension();
            double[][] bp = (double[][]) Array.newInstance(Double.TYPE, new int[]{m, nColB});
            int k = 0;
        L7:
            if (k >= nColB) goto L19;
            int i = 0;
        L9:
            if (i >= m) goto L17;
            ArrayRealVector v = this.eigenvectors[i];
            double[] vData = v.getDataRef();
            double s = 0.0d;
            int j = 0;
        L11:
            if (j >= m) goto L13;
            s = s + (v.getEntry(j) * b.getEntry(j, k));
            j = j + 1;
            goto L11
        L13:
            double s2 = s / this.realEigenvalues[i];
            int j2 = 0;
        L14:
            if (j2 >= m) goto L16;
            double[] r11 = bp[j2];
            r11[k] = r11[k] + (vData[j2] * s2);
            j2 = j2 + 1;
            goto L14
        L16:
            i = i + 1;
            goto L9
        L17:
            k = k + 1;
            goto L7
        L19:
            return MatrixUtils.createRealMatrix(bp);
        L21:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n"});
        L23:
            throw new SingularMatrixException();
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public boolean isNonSingular() {
            int i = 0;
        L4:
            if (i >= this.realEigenvalues.length) goto L12;
            if (this.realEigenvalues[i] != 0.0d) goto L11;
            if (this.imagEigenvalues[i] != 0.0d) goto L11;
            return false;
        L11:
            i = i + 1;
            goto L4
        L12:
            return true;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix getInverse() throws InvalidMatrixException {
            if (isNonSingular() == false) goto L16;
            int m = this.realEigenvalues.length;
            double[][] invData = (double[][]) Array.newInstance(Double.TYPE, new int[]{m, m});
            int i = 0;
        L5:
            if (i >= m) goto L14;
            double[] invI = invData[i];
            int j = 0;
        L7:
            if (j >= m) goto L12;
            double invIJ = 0.0d;
            int k = 0;
        L9:
            if (k >= m) goto L11;
            double[] vK = this.eigenvectors[k].getDataRef();
            invIJ = invIJ + ((vK[i] * vK[j]) / this.realEigenvalues[k]);
            k = k + 1;
            goto L9
        L11:
            invI[j] = invIJ;
            j = j + 1;
            goto L7
        L12:
            i = i + 1;
            goto L5
        L14:
            return MatrixUtils.createRealMatrix(invData);
        L16:
            throw new SingularMatrixException();
        }
    }

    public EigenDecompositionImpl(RealMatrix matrix, double splitTolerance) throws InvalidMatrixException {
        this.maxIter = ParameterName.LOW_LATENCY;
        if (isSymmetric(matrix) == false) goto L7;
        transformToTridiagonal(matrix);
        findEigenVectors(this.transformer.getQ().getData());
        return;
    L7:
        throw new InvalidMatrixException(LocalizedFormats.ASSYMETRIC_EIGEN_NOT_SUPPORTED, new Object[0]);
    }

    public EigenDecompositionImpl(double[] main, double[] secondary, double splitTolerance) throws InvalidMatrixException {
        this.maxIter = ParameterName.LOW_LATENCY;
        this.main = (double[]) main.clone();
        this.secondary = (double[]) secondary.clone();
        this.transformer = null;
        int size = main.length;
        double[][] z = (double[][]) Array.newInstance(Double.TYPE, new int[]{size, size});
        int i = 0;
    L3:
        if (i >= size) goto L5;
        z[i][i] = 1.0d;
        i = i + 1;
        goto L3
    L5:
        findEigenVectors(z);
    }

    private boolean isSymmetric(RealMatrix matrix) {
        RealMatrix r0 = matrix;
        int rows = r0.getRowDimension();
        int columns = r0.getColumnDimension();
        double eps = ((double) ((rows * 10) * columns)) * 1.1102230246251565E-16d;
        int i = 0;
    L3:
        if (i >= rows) goto L12;
        int j = i + 1;
    L5:
        if (j >= columns) goto L11;
        double mij = r0.getEntry(i, j);
        double mji = r0.getEntry(j, i);
        int rows2 = rows;
        if (FastMath.abs(mij - mji) > (FastMath.max(FastMath.abs(mij), FastMath.abs(mji)) * eps)) goto L8;
        j = j + 1;
        r0 = matrix;
        rows = rows2;
        goto L5
    L8:
        return false;
    L11:
        i = i + 1;
        r0 = matrix;
        goto L3
    L12:
        return true;
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public RealMatrix getV() throws InvalidMatrixException {
        if (this.cachedV != null) goto L8;
        int m = this.eigenvectors.length;
        this.cachedV = MatrixUtils.createRealMatrix(m, m);
        int k = 0;
    L5:
        if (k >= m) goto L8;
        this.cachedV.setColumnVector(k, this.eigenvectors[k]);
        k = k + 1;
    L8:
        return this.cachedV;
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public RealMatrix getD() throws InvalidMatrixException {
        if (this.cachedD != null) goto L6;
        this.cachedD = MatrixUtils.createRealDiagonalMatrix(this.realEigenvalues);
    L6:
        return this.cachedD;
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public RealMatrix getVT() throws InvalidMatrixException {
        if (this.cachedVt != null) goto L8;
        int m = this.eigenvectors.length;
        this.cachedVt = MatrixUtils.createRealMatrix(m, m);
        int k = 0;
    L5:
        if (k >= m) goto L8;
        this.cachedVt.setRowVector(k, this.eigenvectors[k]);
        k = k + 1;
    L8:
        return this.cachedVt;
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public double[] getRealEigenvalues() throws InvalidMatrixException {
        return (double[]) this.realEigenvalues.clone();
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public double getRealEigenvalue(int i) throws InvalidMatrixException, ArrayIndexOutOfBoundsException {
        return this.realEigenvalues[i];
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public double[] getImagEigenvalues() throws InvalidMatrixException {
        return (double[]) this.imagEigenvalues.clone();
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public double getImagEigenvalue(int i) throws InvalidMatrixException, ArrayIndexOutOfBoundsException {
        return this.imagEigenvalues[i];
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public RealVector getEigenvector(int i) throws InvalidMatrixException, ArrayIndexOutOfBoundsException {
        return this.eigenvectors[i].copy();
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public double getDeterminant() {
        double determinant = 1.0d;
        double[] r2 = this.realEigenvalues;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        double lambda = r2[r4];
        determinant = determinant * lambda;
        r4 = r4 + 1;
        goto L3
    L5:
        return determinant;
    }

    @Override // org.apache.commons.math.linear.EigenDecomposition
    public DecompositionSolver getSolver() {
        return new Solver(this.realEigenvalues, this.imagEigenvalues, this.eigenvectors, null);
    }

    private void transformToTridiagonal(RealMatrix matrix) {
        this.transformer = new TriDiagonalTransformer(matrix);
        this.main = this.transformer.getMainDiagonalRef();
        this.secondary = this.transformer.getSecondaryDiagonalRef();
    }

    private void findEigenVectors(double[][] householderMatrix) {
        double[][] z = (double[][]) householderMatrix.clone();
        int n = this.main.length;
        this.realEigenvalues = new double[n];
        this.imagEigenvalues = new double[n];
        double[] e = new double[n];
        int i = 0;
    L4:
        if (i >= (n - 1)) goto L6;
        this.realEigenvalues[i] = this.main[i];
        e[i] = this.secondary[i];
        i = i + 1;
        goto L4
    L6:
        this.realEigenvalues[n - 1] = this.main[n - 1];
        double r5 = 0.0d;
        e[n - 1] = 0.0d;
        double maxAbsoluteValue = 0.0d;
        int i2 = 0;
    L7:
        if (i2 >= n) goto L15;
        if (FastMath.abs(this.realEigenvalues[i2]) <= maxAbsoluteValue) goto L12;
        maxAbsoluteValue = FastMath.abs(this.realEigenvalues[i2]);
    L12:
        if (FastMath.abs(e[i2]) <= maxAbsoluteValue) goto L14;
        maxAbsoluteValue = FastMath.abs(e[i2]);
    L14:
        i2 = i2 + 1;
        goto L7
    L15:
        double r9 = 1.1102230246251565E-16d;
        if (maxAbsoluteValue == 0.0d) goto L26;
        int i3 = 0;
    L18:
        if (i3 >= n) goto L26;
        if (FastMath.abs(this.realEigenvalues[i3]) > (maxAbsoluteValue * 1.1102230246251565E-16d)) goto L23;
        this.realEigenvalues[i3] = 0.0d;
    L23:
        if (FastMath.abs(e[i3]) > (maxAbsoluteValue * 1.1102230246251565E-16d)) goto L25;
        e[i3] = 0.0d;
    L25:
        i3 = i3 + 1;
    L26:
        int j = 0;
    L27:
        if (j >= n) goto L69;
        int its = 0;
    L29:
        int m = j;
    L31:
        if (m >= (n - 1)) goto L36;
        double delta = FastMath.abs(this.realEigenvalues[m]) + FastMath.abs(this.realEigenvalues[m + 1]);
        if ((FastMath.abs(e[m]) + delta) == delta) goto L36;
        m = m + 1;
    L36:
        if (m != j) goto L38;
        double[][] z2 = z;
        double[] e2 = e;
        r5 = r5;
        r9 = r9;
    L66:
        if (m == j) goto L67;
        r5 = r5;
        r9 = r9;
        z = z2;
        e = e2;
        goto L29
    L67:
        j = j + 1;
        r5 = r5;
        r9 = r9;
        z = z2;
        e = e2;
        goto L27
    L38:
        if (its == this.maxIter) goto L63;
        its = its + 1;
        double q = (this.realEigenvalues[j + 1] - this.realEigenvalues[j]) / (e[j] * 2.0d);
        double t = FastMath.sqrt((q * q) + 1.0d);
        if (q >= r5) goto L42;
        double q2 = (this.realEigenvalues[m] - this.realEigenvalues[j]) + (e[j] / (q - t));
    L43:
        double u = 0.0d;
        double s = 1.0d;
        double c = 1.0d;
        z2 = z;
        int i4 = m - 1;
    L44:
        if (i4 < j) goto L56;
        double p = e[i4] * s;
        double h = e[i4] * c;
        if (FastMath.abs(p) < FastMath.abs(q2)) goto L48;
        double c2 = q2 / p;
        t = FastMath.sqrt((c2 * c2) + 1.0d);
        e[i4 + 1] = p * t;
        s = 1.0d / t;
        c = c2 * s;
    L50:
        if (e[i4 + 1] == r5) goto L51;
        double[] e3 = e;
        double q3 = this.realEigenvalues[i4 + 1] - u;
        t = ((this.realEigenvalues[i4] - q3) * s) + ((c * 2.0d) * h);
        u = s * t;
        this.realEigenvalues[i4 + 1] = q3 + u;
        q2 = (c * t) - h;
        int ia = 0;
    L53:
        if (ia >= n) goto L55;
        double p2 = z2[ia][i4 + 1];
        z2[ia][i4 + 1] = (z2[ia][i4] * s) + (c * p2);
        z2[ia][i4] = (z2[ia][i4] * c) - (s * p2);
        ia = ia + 1;
        goto L53
    L55:
        i4 = i4 - 1;
        e = e3;
        goto L44
    L51:
        e2 = e;
        double[] e4 = this.realEigenvalues;
        int r17 = i4 + 1;
        e4[r17] = e4[r17] - u;
        e2[m] = r5;
    L58:
        if (t != r5) goto L61;
        if (i4 >= j) goto L66;
    L61:
        double[] r3 = this.realEigenvalues;
        r3[j] = r3[j] - u;
        e2[j] = q2;
        e2[m] = r5;
        goto L66
    L48:
        double s2 = p / q2;
        t = FastMath.sqrt((s2 * s2) + 1.0d);
        e[i4 + 1] = q2 * t;
        c = 1.0d / t;
        s = s2 * c;
        goto L50
    L56:
        e2 = e;
        goto L58
    L42:
        q2 = (this.realEigenvalues[m] - this.realEigenvalues[j]) + (e[j] / (q + t));
        goto L43
    L63:
        throw new InvalidMatrixException(new MaxIterationsExceededException(this.maxIter));
    L69:
        double[][] z3 = z;
        double r21 = r5;
        double r23 = r9;
        int i5 = 0;
    L70:
        if (i5 >= n) goto L83;
        int k = i5;
        double p3 = this.realEigenvalues[i5];
        int j2 = i5 + 1;
    L72:
        if (j2 >= n) goto L78;
        if (this.realEigenvalues[j2] <= p3) goto L76;
        k = j2;
        p3 = this.realEigenvalues[j2];
    L76:
        j2 = j2 + 1;
        goto L72
    L78:
        if (k == i5) goto L82;
        this.realEigenvalues[k] = this.realEigenvalues[i5];
        this.realEigenvalues[i5] = p3;
        int j3 = 0;
    L80:
        if (j3 >= n) goto L82;
        double p4 = z3[j3][i5];
        z3[j3][i5] = z3[j3][k];
        z3[j3][k] = p4;
        j3 = j3 + 1;
    L82:
        i5 = i5 + 1;
        goto L70
    L83:
        double maxAbsoluteValue2 = 0.0d;
        int i6 = 0;
    L84:
        if (i6 >= n) goto L90;
        if (FastMath.abs(this.realEigenvalues[i6]) <= maxAbsoluteValue2) goto L88;
        maxAbsoluteValue2 = FastMath.abs(this.realEigenvalues[i6]);
    L88:
        i6 = i6 + 1;
        goto L84
    L90:
        if (maxAbsoluteValue2 == r21) goto L97;
        int i7 = 0;
    L92:
        if (i7 >= n) goto L97;
        if (FastMath.abs(this.realEigenvalues[i7]) >= (maxAbsoluteValue2 * r23)) goto L96;
        this.realEigenvalues[i7] = r21;
    L96:
        i7 = i7 + 1;
    L97:
        this.eigenvectors = new ArrayRealVector[n];
        double[] tmp = new double[n];
        int i8 = 0;
    L98:
        if (i8 >= n) goto L104;
        int j4 = 0;
    L100:
        if (j4 >= n) goto L102;
        tmp[j4] = z3[j4][i8];
        j4 = j4 + 1;
        goto L100
    L102:
        this.eigenvectors[i8] = new ArrayRealVector(tmp);
        i8 = i8 + 1;
        goto L98
    }
}
