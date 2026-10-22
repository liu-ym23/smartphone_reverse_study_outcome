package org.apache.commons.math.linear;

import java.lang.reflect.Array;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.BigReal;

/* JADX INFO: loaded from: classes3.dex */
public class FieldLUDecompositionImpl<T extends FieldElement<T>> implements FieldLUDecomposition<T> {
    private FieldMatrix<T> cachedL;
    private FieldMatrix<T> cachedP;
    private FieldMatrix<T> cachedU;
    private boolean even;
    private final Field<T> field;
    private T[][] lu;
    private int[] pivot;
    private boolean singular;

    /* JADX INFO: renamed from: org.apache.commons.math.linear.FieldLUDecompositionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver<T extends FieldElement<T>> implements FieldDecompositionSolver<T> {
        private static final long serialVersionUID = -6353105415121373022L;
        private final Field<T> field;
        private final T[][] lu;
        private final int[] pivot;
        private final boolean singular;

        /* synthetic */ Solver(Field x0, FieldElement[][] x1, int[] x2, boolean x3, AnonymousClass1 x4) {
            this(x0, x1, x2, x3);
        }

        private Solver(Field<T> field, T[][] lu, int[] pivot, boolean singular) {
            this.field = field;
            this.lu = lu;
            this.pivot = pivot;
            this.singular = singular;
        }

        @Override // org.apache.commons.math.linear.FieldDecompositionSolver
        public boolean isNonSingular() {
            return !this.singular;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.math.linear.FieldDecompositionSolver
        public T[] solve(T[] r8) throws IllegalArgumentException, InvalidMatrixException {
            int r0 = this.pivot.length;
            if (r8.length != r0) goto L26;
            if (this.singular == true) goto L24;
            T[] r1 = (T[]) ((FieldElement[]) Array.newInstance(this.field.getZero().getClass(), r0));
            int r2 = 0;
        L7:
            if (r2 >= r0) goto L9;
            r1[r2] = r8[this.pivot[r2]];
            r2 = r2 + 1;
            goto L7
        L9:
            int r3 = 0;
        L10:
            if (r3 >= r0) goto L15;
            BigReal r4 = r1[r3];
            int r5 = r3 + 1;
        L12:
            if (r5 >= r0) goto L14;
            r1[r5] = (FieldElement) r1[r5].subtract((FieldElement) r4.multiply(this.lu[r5][r3]));
            r5 = r5 + 1;
            goto L12
        L14:
            r3 = r3 + 1;
            goto L10
        L15:
            int r6 = r0 - 1;
        L16:
            if (r6 < 0) goto L22;
            r1[r6] = (FieldElement) r1[r6].divide(this.lu[r6][r6]);
            BigReal r7 = r1[r6];
            int r9 = 0;
        L18:
            if (r9 >= r6) goto L20;
            r1[r9] = (FieldElement) r1[r9].subtract((FieldElement) r7.multiply(this.lu[r9][r6]));
            r9 = r9 + 1;
            goto L18
        L20:
            r6 = r6 - 1;
            goto L16
        L22:
            return r1;
        L24:
            throw new SingularMatrixException();
        L26:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(r8.length), Integer.valueOf(r0)});
        }

        @Override // org.apache.commons.math.linear.FieldDecompositionSolver
        public FieldVector<T> solve(FieldVector<T> b) throws IllegalArgumentException, InvalidMatrixException {
            return solve((ArrayFieldVector) b);
        L5:
            int m = this.pivot.length;
            if (b.getDimension() != m) goto L29;
            if (this.singular == true) goto L27;
            FieldElement[] r2 = (FieldElement[]) Array.newInstance(this.field.getZero().getClass(), m);
            int row = 0;
        L10:
            if (row >= m) goto L12;
            r2[row] = b.getEntry(this.pivot[row]);
            row = row + 1;
            goto L10
        L12:
            int col = 0;
        L13:
            if (col >= m) goto L18;
            FieldElement r4 = r2[col];
            int i = col + 1;
        L15:
            if (i >= m) goto L17;
            r2[i] = (FieldElement) r2[i].subtract((FieldElement) r4.multiply(this.lu[i][col]));
            i = i + 1;
            goto L15
        L17:
            col = col + 1;
            goto L13
        L18:
            int col2 = m - 1;
        L19:
            if (col2 < 0) goto L25;
            r2[col2] = (FieldElement) r2[col2].divide(this.lu[col2][col2]);
            FieldElement r5 = r2[col2];
            int i2 = 0;
        L21:
            if (i2 >= col2) goto L23;
            r2[i2] = (FieldElement) r2[i2].subtract((FieldElement) r5.multiply(this.lu[i2][col2]));
            i2 = i2 + 1;
            goto L21
        L23:
            col2 = col2 - 1;
            goto L19
        L25:
            return new ArrayFieldVector(r2, false);
        L27:
            throw new SingularMatrixException();
        L29:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.getDimension()), Integer.valueOf(m)});
        }

        public ArrayFieldVector<T> solve(ArrayFieldVector<T> b) throws IllegalArgumentException, InvalidMatrixException {
            return new ArrayFieldVector(solve(b.getDataRef()), false);
        }

        @Override // org.apache.commons.math.linear.FieldDecompositionSolver
        public FieldMatrix<T> solve(FieldMatrix<T> b) throws IllegalArgumentException, InvalidMatrixException {
            int m = this.pivot.length;
            if (b.getRowDimension() != m) goto L38;
            if (this.singular == true) goto L36;
            int nColB = b.getColumnDimension();
            FieldElement[][] r2 = (FieldElement[][]) Array.newInstance(this.field.getZero().getClass(), new int[]{m, nColB});
            int row = 0;
        L7:
            if (row >= m) goto L12;
            FieldElement[] r4 = r2[row];
            int pRow = this.pivot[row];
            int col = 0;
        L9:
            if (col >= nColB) goto L11;
            r4[col] = b.getEntry(pRow, col);
            col = col + 1;
            goto L9
        L11:
            row = row + 1;
            goto L7
        L12:
            int col2 = 0;
        L13:
            if (col2 >= m) goto L21;
            FieldElement[] r5 = r2[col2];
            int i = col2 + 1;
        L15:
            if (i >= m) goto L20;
            FieldElement[] r6 = r2[i];
            T luICol = this.lu[i][col2];
            int j = 0;
        L17:
            if (j >= nColB) goto L19;
            r6[j] = (FieldElement) r6[j].subtract((FieldElement) r5[j].multiply(luICol));
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
            FieldElement[] r7 = r2[col3];
            T luDiag = this.lu[col3][col3];
            int j2 = 0;
        L24:
            if (j2 >= nColB) goto L26;
            r7[j2] = (FieldElement) r7[j2].divide(luDiag);
            j2 = j2 + 1;
            goto L24
        L26:
            int i2 = 0;
        L27:
            if (i2 >= col3) goto L32;
            FieldElement[] r8 = r2[i2];
            T luICol2 = this.lu[i2][col3];
            int j3 = 0;
        L29:
            if (j3 >= nColB) goto L31;
            r8[j3] = (FieldElement) r8[j3].subtract((FieldElement) r7[j3].multiply(luICol2));
            j3 = j3 + 1;
            goto L29
        L31:
            i2 = i2 + 1;
            goto L27
        L32:
            col3 = col3 - 1;
            goto L22
        L34:
            return new Array2DRowFieldMatrix(r2, false);
        L36:
            throw new SingularMatrixException();
        L38:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n"});
        }

        @Override // org.apache.commons.math.linear.FieldDecompositionSolver
        public FieldMatrix<T> getInverse() throws InvalidMatrixException {
            int m = this.pivot.length;
            T one = this.field.getOne();
            FieldMatrix<T> identity = new Array2DRowFieldMatrix(this.field, m, m);
            int i = 0;
        L3:
            if (i >= m) goto L6;
            identity.setEntry(i, i, one);
            i = i + 1;
            goto L3
        L6:
            return solve(identity);
        }
    }

    public FieldLUDecompositionImpl(FieldMatrix<T> r11) throws NonSquareMatrixException {
        if (r11.isSquare() == false) goto L40;
        int r0 = r11.getColumnDimension();
        this.field = r11.getField();
        this.lu = (T[][]) r11.getData();
        this.pivot = new int[r0];
        this.cachedL = null;
        this.cachedU = null;
        this.cachedP = null;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.pivot[r1] = r1;
        r1 = r1 + 1;
        goto L5
    L7:
        this.even = true;
        this.singular = false;
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L38;
        T r3 = this.field.getZero();
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L15;
        FieldElement[] r5 = this.lu[r4];
        FieldElement r6 = r5[r2];
        int r7 = 0;
    L12:
        if (r7 >= r4) goto L14;
        r6 = (FieldElement) r6.subtract((FieldElement) r5[r7].multiply(this.lu[r7][r2]));
        r7 = r7 + 1;
        goto L12
    L14:
        r5[r2] = r6;
        r4 = r4 + 1;
        goto L10
    L15:
        int r8 = r2;
        int r9 = r2;
    L16:
        if (r9 >= r0) goto L25;
        FieldElement[] r10 = this.lu[r9];
        FieldElement r12 = r10[r2];
        int r13 = 0;
    L18:
        if (r13 >= r2) goto L20;
        r12 = (FieldElement) r12.subtract((FieldElement) r10[r13].multiply(this.lu[r13][r2]));
        r13 = r13 + 1;
        goto L18
    L20:
        r10[r2] = r12;
        if (this.lu[r8][r2].equals(this.field.getZero()) == false) goto L23;
        r8 = r8 + 1;
    L23:
        r9 = r9 + 1;
        goto L16
    L25:
        if (r8 >= r0) goto L26;
        if (r8 == r2) goto L33;
        T r14 = this.field.getZero();
        int r15 = 0;
    L30:
        if (r15 >= r0) goto L32;
        T r16 = this.lu[r8][r15];
        this.lu[r8][r15] = this.lu[r2][r15];
        this.lu[r2][r15] = r16;
        r15 = r15 + 1;
        goto L30
    L32:
        int r17 = this.pivot[r8];
        this.pivot[r8] = this.pivot[r2];
        this.pivot[r2] = r17;
        this.even = !this.even;
    L33:
        T r18 = this.lu[r2][r2];
        int r19 = r2 + 1;
    L34:
        if (r19 >= r0) goto L36;
        FieldElement[] r20 = this.lu[r19];
        r20[r2] = (FieldElement) r20[r2].divide(r18);
        r19 = r19 + 1;
        goto L34
    L36:
        r2 = r2 + 1;
        goto L8
    L26:
        this.singular = true;
        return;
    L38:
        return;
    L40:
        throw new NonSquareMatrixException(r11.getRowDimension(), r11.getColumnDimension());
    }

    @Override // org.apache.commons.math.linear.FieldLUDecomposition
    public FieldMatrix<T> getL() {
        if (this.cachedL != null) goto L13;
        if (this.singular == true) goto L13;
        int m = this.pivot.length;
        this.cachedL = new Array2DRowFieldMatrix(this.field, m, m);
        int i = 0;
    L7:
        if (i >= m) goto L13;
        T[] luI = this.lu[i];
        int j = 0;
    L9:
        if (j >= i) goto L11;
        this.cachedL.setEntry(i, j, luI[j]);
        j = j + 1;
        goto L9
    L11:
        this.cachedL.setEntry(i, i, this.field.getOne());
        i = i + 1;
    L13:
        return this.cachedL;
    }

    @Override // org.apache.commons.math.linear.FieldLUDecomposition
    public FieldMatrix<T> getU() {
        if (this.cachedU != null) goto L13;
        if (this.singular == true) goto L13;
        int m = this.pivot.length;
        this.cachedU = new Array2DRowFieldMatrix(this.field, m, m);
        int i = 0;
    L7:
        if (i >= m) goto L13;
        T[] luI = this.lu[i];
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

    @Override // org.apache.commons.math.linear.FieldLUDecomposition
    public FieldMatrix<T> getP() {
        if (this.cachedP != null) goto L10;
        if (this.singular == true) goto L10;
        int m = this.pivot.length;
        this.cachedP = new Array2DRowFieldMatrix(this.field, m, m);
        int i = 0;
    L7:
        if (i >= m) goto L10;
        this.cachedP.setEntry(i, this.pivot[i], this.field.getOne());
        i = i + 1;
    L10:
        return this.cachedP;
    }

    @Override // org.apache.commons.math.linear.FieldLUDecomposition
    public int[] getPivot() {
        return (int[]) this.pivot.clone();
    }

    @Override // org.apache.commons.math.linear.FieldLUDecomposition
    public T getDeterminant() {
        if (this.singular == true) goto L5;
        int m = this.pivot.length;
        if (this.even == false) goto L10;
        Object r1 = this.field.getOne();
    L9:
        T r2 = (T) r1;
        int i = 0;
    L12:
        if (i >= m) goto L15;
        r2 = (T) r2.multiply(this.lu[i][i]);
        i = i + 1;
        goto L12
    L15:
        return r2;
    L10:
        r1 = this.field.getZero().subtract(this.field.getOne());
        goto L9
    L5:
        return this.field.getZero();
    }

    @Override // org.apache.commons.math.linear.FieldLUDecomposition
    public FieldDecompositionSolver<T> getSolver() {
        return new Solver(this.field, this.lu, this.pivot, this.singular, null);
    }
}
