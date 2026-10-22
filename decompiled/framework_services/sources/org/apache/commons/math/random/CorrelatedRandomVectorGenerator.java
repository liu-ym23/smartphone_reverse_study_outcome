package org.apache.commons.math.random;

import java.lang.reflect.Array;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.NotPositiveDefiniteMatrixException;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class CorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;
    private final double[] mean;
    private final double[] normalized;
    private int rank;
    private RealMatrix root;

    public CorrelatedRandomVectorGenerator(double[] mean, RealMatrix covariance, double small, NormalizedRandomGenerator generator) throws NotPositiveDefiniteMatrixException, DimensionMismatchException {
        int order = covariance.getRowDimension();
        if (mean.length != order) goto L7;
        this.mean = (double[]) mean.clone();
        decompose(covariance, small);
        this.generator = generator;
        this.normalized = new double[this.rank];
        return;
    L7:
        throw new DimensionMismatchException(mean.length, order);
    }

    public CorrelatedRandomVectorGenerator(RealMatrix covariance, double small, NormalizedRandomGenerator generator) throws NotPositiveDefiniteMatrixException {
        int order = covariance.getRowDimension();
        this.mean = new double[order];
        int i = 0;
    L3:
        if (i >= order) goto L5;
        this.mean[i] = 0.0d;
        i = i + 1;
        goto L3
    L5:
        decompose(covariance, small);
        this.generator = generator;
        this.normalized = new double[this.rank];
    }

    public NormalizedRandomGenerator getGenerator() {
        return this.generator;
    }

    public RealMatrix getRootMatrix() {
        return this.root;
    }

    public int getRank() {
        return this.rank;
    }

    private void decompose(RealMatrix covariance, double small) throws NotPositiveDefiniteMatrixException {
        int order = covariance.getRowDimension();
        double[][] c = covariance.getData();
        int r6 = 1;
        double[][] b = (double[][]) Array.newInstance(Double.TYPE, new int[]{order, order});
        int[] swap = new int[order];
        int[] index = new int[order];
        int i = 0;
    L3:
        if (i >= order) goto L5;
        index[i] = i;
        i = i + 1;
        goto L3
    L5:
        this.rank = 0;
        int r10 = 1;
    L6:
        if (r10 == 0) goto L42;
        swap[this.rank] = this.rank;
        int i2 = this.rank + r6;
    L8:
        if (i2 >= order) goto L13;
        int ii = index[i2];
        int isi = index[swap[i2]];
        if (c[ii][ii] <= c[isi][isi]) goto L12;
        swap[this.rank] = i2;
    L12:
        i2 = i2 + 1;
        goto L8
    L13:
        int i3 = this.rank;
        if (swap[i3] == this.rank) goto L16;
        int tmp = index[this.rank];
        index[this.rank] = index[swap[this.rank]];
        index[swap[this.rank]] = tmp;
    L16:
        int tmp2 = this.rank;
        int ir = index[tmp2];
        if (c[ir][ir] < small) goto L19;
        int r15 = r6;
        double sqrt = FastMath.sqrt(c[ir][ir]);
        b[this.rank][this.rank] = sqrt;
        double inverse = 1.0d / sqrt;
        int i4 = this.rank + r15;
    L31:
        if (i4 >= order) goto L36;
        int ii2 = index[i4];
        double e = c[ii2][ir] * inverse;
        int r21 = r15;
        b[i4][this.rank] = e;
        double[] r16 = c[ii2];
        r16[ii2] = r16[ii2] - (e * e);
        int j = this.rank + 1;
    L33:
        if (j >= i4) goto L35;
        int ij = index[j];
        double f = c[ii2][ij] - (b[j][this.rank] * e);
        c[ii2][ij] = f;
        c[ij][ii2] = f;
        j = j + 1;
        goto L33
    L35:
        i4 = i4 + 1;
        r15 = r21;
        goto L31
    L36:
        int r22 = r15;
        int r1 = this.rank + 1;
        this.rank = r1;
        if (r1 >= order) goto L39;
        int r2 = r22;
    L40:
        r10 = r2;
    L41:
        r6 = r22;
        goto L6
    L39:
        r2 = 0;
        goto L40
    L19:
        if (this.rank == 0) goto L29;
        int i5 = this.rank;
    L21:
        if (i5 >= order) goto L27;
        int r17 = r6;
        if (c[index[i5]][index[i5]] < (-small)) goto L26;
        i5 = i5 + 1;
        r6 = r17;
        goto L21
    L26:
        throw new NotPositiveDefiniteMatrixException();
    L27:
        int r18 = r6;
        this.rank += r18;
        r10 = 0;
        r22 = r18;
        goto L41
    L29:
        throw new NotPositiveDefiniteMatrixException();
    L42:
        this.root = MatrixUtils.createRealMatrix(order, this.rank);
        int i6 = 0;
    L43:
        if (i6 >= order) goto L50;
        int j2 = 0;
    L46:
        if (j2 >= this.rank) goto L48;
        this.root.setEntry(index[i6], j2, b[i6][j2]);
        j2 = j2 + 1;
        goto L46
    L48:
        i6 = i6 + 1;
        goto L43
    }

    @Override // org.apache.commons.math.random.RandomVectorGenerator
    public double[] nextVector() {
        int i = 0;
    L4:
        if (i >= this.rank) goto L6;
        this.normalized[i] = this.generator.nextNormalizedDouble();
        i = i + 1;
        goto L4
    L6:
        double[] correlated = new double[this.mean.length];
        int i2 = 0;
    L8:
        if (i2 >= correlated.length) goto L15;
        correlated[i2] = this.mean[i2];
        int j = 0;
    L11:
        if (j >= this.rank) goto L13;
        correlated[i2] = correlated[i2] + (this.root.getEntry(i2, j) * this.normalized[j]);
        j = j + 1;
        goto L11
    L13:
        i2 = i2 + 1;
        goto L8
    L15:
        return correlated;
    }
}
