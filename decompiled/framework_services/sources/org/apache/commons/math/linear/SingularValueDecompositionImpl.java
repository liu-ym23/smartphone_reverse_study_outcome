package org.apache.commons.math.linear;

import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SingularValueDecompositionImpl implements SingularValueDecomposition {
    private RealMatrix cachedS;
    private RealMatrix cachedU;
    private RealMatrix cachedUt;
    private RealMatrix cachedV;
    private RealMatrix cachedVt;
    private EigenDecomposition eigenDecomposition;
    private int m;
    private int n;
    private double[] singularValues;

    private static class Solver implements DecompositionSolver {
        private boolean nonSingular;
        private final RealMatrix pseudoInverse;

        /* synthetic */ Solver(double[] x0, RealMatrix x1, RealMatrix x2, boolean x3, AnonymousClass1 x4) {
            this(x0, x1, x2, x3);
        }

        private Solver(double[] singularValues, RealMatrix uT, RealMatrix v, boolean nonSingular) {
            double[][] suT = uT.getData();
            int i = 0;
        L4:
            if (i >= singularValues.length) goto L14;
            if (singularValues[i] <= 0.0d) goto L8;
            double a = 1.0d / singularValues[i];
        L9:
            double[] suTi = suT[i];
            int j = 0;
        L11:
            if (j >= suTi.length) goto L13;
            suTi[j] = suTi[j] * a;
            j = j + 1;
            goto L11
        L13:
            i = i + 1;
            goto L4
        L8:
            a = 0.0d;
            goto L9
        L14:
            this.pseudoInverse = v.multiply(new Array2DRowRealMatrix(suT, false));
            this.nonSingular = nonSingular;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public double[] solve(double[] b) throws IllegalArgumentException {
            return this.pseudoInverse.operate(b);
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealVector solve(RealVector b) throws IllegalArgumentException {
            return this.pseudoInverse.operate(b);
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix b) throws IllegalArgumentException {
            return this.pseudoInverse.multiply(b);
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public boolean isNonSingular() {
            return this.nonSingular;
        }

        @Override // org.apache.commons.math.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return this.pseudoInverse;
        }
    }

    static /* synthetic */ double[] access$000(SingularValueDecompositionImpl x0) {
        return x0.singularValues;
    }

    public SingularValueDecompositionImpl(RealMatrix matrix) throws InvalidMatrixException {
        this.m = matrix.getRowDimension();
        this.n = matrix.getColumnDimension();
        this.cachedU = null;
        this.cachedS = null;
        this.cachedV = null;
        this.cachedVt = null;
        double[][] localcopy = matrix.getData();
        double[][] matATA = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.n, this.n});
        int i = 0;
    L4:
        if (i >= this.n) goto L14;
        int j = i;
    L7:
        if (j >= this.n) goto L13;
        matATA[i][j] = 0.0d;
        int k = 0;
    L10:
        if (k >= this.m) goto L12;
        double[] r11 = matATA[i];
        r11[j] = r11[j] + (localcopy[k][i] * localcopy[k][j]);
        k = k + 1;
        goto L10
    L12:
        matATA[j][i] = matATA[i][j];
        j = j + 1;
        goto L7
    L13:
        i = i + 1;
        goto L4
    L14:
        int i2 = this.m;
        double[][] matAAT = (double[][]) Array.newInstance(Double.TYPE, new int[]{i2, this.m});
        int i3 = 0;
    L16:
        if (i3 >= this.m) goto L26;
        int j2 = i3;
    L19:
        if (j2 >= this.m) goto L25;
        matAAT[i3][j2] = 0.0d;
        int k2 = 0;
    L22:
        if (k2 >= this.n) goto L24;
        double[] r12 = matAAT[i3];
        r12[j2] = r12[j2] + (localcopy[i3][k2] * localcopy[j2][k2]);
        k2 = k2 + 1;
        goto L22
    L24:
        matAAT[j2][i3] = matAAT[i3][j2];
        j2 = j2 + 1;
        goto L19
    L25:
        i3 = i3 + 1;
        goto L16
    L26:
        int i4 = this.m;
        if (i4 < this.n) goto L29;
        int p = this.n;
        this.eigenDecomposition = new EigenDecompositionImpl(new Array2DRowRealMatrix(matATA), 1.0d);
        this.singularValues = this.eigenDecomposition.getRealEigenvalues();
        this.cachedV = this.eigenDecomposition.getV();
        this.eigenDecomposition = new EigenDecompositionImpl(new Array2DRowRealMatrix(matAAT), 1.0d);
        this.cachedU = this.eigenDecomposition.getV().getSubMatrix(0, this.m - 1, 0, p - 1);
    L30:
        int i5 = 0;
    L31:
        if (i5 >= p) goto L33;
        this.singularValues[i5] = FastMath.sqrt(FastMath.abs(this.singularValues[i5]));
        i5 = i5 + 1;
        goto L31
    L33:
        int i6 = 0;
    L34:
        if (i6 >= p) goto L40;
        RealVector tmp = this.cachedU.getColumnVector(i6);
        double product = matrix.operate(this.cachedV.getColumnVector(i6)).dotProduct(tmp);
        if (product >= 0.0d) goto L38;
        this.cachedU.setColumnVector(i6, tmp.mapMultiply(-1.0d));
    L38:
        i6 = i6 + 1;
        goto L34
    L40:
        return;
    L29:
        p = this.m;
        this.eigenDecomposition = new EigenDecompositionImpl(new Array2DRowRealMatrix(matAAT), 1.0d);
        this.singularValues = this.eigenDecomposition.getRealEigenvalues();
        this.cachedU = this.eigenDecomposition.getV();
        this.eigenDecomposition = new EigenDecompositionImpl(new Array2DRowRealMatrix(matATA), 1.0d);
        this.cachedV = this.eigenDecomposition.getV().getSubMatrix(0, this.n - 1, 0, p - 1);
        goto L30
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public RealMatrix getU() throws InvalidMatrixException {
        return this.cachedU;
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public RealMatrix getUT() throws InvalidMatrixException {
        if (this.cachedUt != null) goto L6;
        this.cachedUt = getU().transpose();
    L6:
        return this.cachedUt;
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public RealMatrix getS() throws InvalidMatrixException {
        if (this.cachedS != null) goto L6;
        this.cachedS = MatrixUtils.createRealDiagonalMatrix(this.singularValues);
    L6:
        return this.cachedS;
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public double[] getSingularValues() throws InvalidMatrixException {
        return (double[]) this.singularValues.clone();
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public RealMatrix getV() throws InvalidMatrixException {
        return this.cachedV;
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public RealMatrix getVT() throws InvalidMatrixException {
        if (this.cachedVt != null) goto L6;
        this.cachedVt = getV().transpose();
    L6:
        return this.cachedVt;
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public RealMatrix getCovariance(double minSingularValue) {
        int p = this.singularValues.length;
        int dimension = 0;
    L3:
        if (dimension >= p) goto L8;
        if (this.singularValues[dimension] < minSingularValue) goto L8;
        dimension = dimension + 1;
    L8:
        if (dimension == 0) goto L12;
        final double[][] data = (double[][]) Array.newInstance(Double.TYPE, new int[]{dimension, p});
        getVT().walkInOptimizedOrder(new AnonymousClass1(this, data), 0, dimension - 1, 0, p - 1);
        RealMatrix jv = new Array2DRowRealMatrix(data, false);
        return jv.transpose().multiply(jv);
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.TOO_LARGE_CUTOFF_SINGULAR_VALUE, new Object[]{Double.valueOf(minSingularValue), Double.valueOf(this.singularValues[0])});
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public double getNorm() throws InvalidMatrixException {
        return this.singularValues[0];
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public double getConditionNumber() throws InvalidMatrixException {
        return this.singularValues[0] / this.singularValues[this.singularValues.length - 1];
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public int getRank() throws IllegalStateException {
        double threshold = ((double) FastMath.max(this.m, this.n)) * FastMath.ulp(this.singularValues[0]);
        int i = this.singularValues.length - 1;
    L3:
        if (i < 0) goto L10;
        if (this.singularValues[i] > threshold) goto L7;
        i = i - 1;
        goto L3
    L7:
        return i + 1;
    L10:
        return 0;
    }

    @Override // org.apache.commons.math.linear.SingularValueDecomposition
    public DecompositionSolver getSolver() {
        double[] r1 = this.singularValues;
        RealMatrix r2 = getUT();
        RealMatrix r3 = getV();
        if (getRank() != Math.max(this.m, this.n)) goto L5;
        boolean r4 = true;
    L7:
        return new Solver(r1, r2, r3, r4, null);
    L5:
        r4 = false;
        goto L7
    }
}
