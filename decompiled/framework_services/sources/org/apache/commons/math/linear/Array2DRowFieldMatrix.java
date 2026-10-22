package org.apache.commons.math.linear;

import java.io.Serializable;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class Array2DRowFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    private static final long serialVersionUID = 7260756672015356458L;
    protected T[][] data;

    public Array2DRowFieldMatrix(Field<T> field) {
        super(field);
    }

    public Array2DRowFieldMatrix(Field<T> r2, int r3, int r4) throws IllegalArgumentException {
        super(r2, r3, r4);
        this.data = (T[][]) AbstractFieldMatrix.buildArray(r2, r3, r4);
    }

    public Array2DRowFieldMatrix(T[][] d) throws IllegalArgumentException, NullPointerException {
        super(AbstractFieldMatrix.extractField(d));
        copyIn(d);
    }

    public Array2DRowFieldMatrix(T[][] d, boolean copyArray) throws IllegalArgumentException, NullPointerException {
        super(AbstractFieldMatrix.extractField(d));
        if (copyArray == false) goto L5;
        copyIn(d);
        return;
    L5:
        if (d == null) goto L24;
        int nRows = d.length;
        if (nRows == 0) goto L22;
        int nCols = d[0].length;
        if (nCols == 0) goto L20;
        int r = 1;
    L11:
        if (r >= nRows) goto L17;
        if (d[r].length != nCols) goto L16;
        r = r + 1;
        goto L11
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(nCols), Integer.valueOf(d[r].length)});
    L17:
        this.data = d;
        return;
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    L24:
        throw new NullPointerException();
    }

    public Array2DRowFieldMatrix(T[] r6) {
        super(AbstractFieldMatrix.extractField(r6));
        int r0 = r6.length;
        this.data = (T[][]) AbstractFieldMatrix.buildArray(getField(), r0, 1);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        this.data[r1][0] = r6[r1];
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        return new Array2DRowFieldMatrix(getField(), rowDimension, columnDimension);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        return new Array2DRowFieldMatrix(copyOut(), false);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> m) throws IllegalArgumentException {
        return add((Array2DRowFieldMatrix) m);
    L6:
        return super.add(m);
    }

    public Array2DRowFieldMatrix<T> add(Array2DRowFieldMatrix<T> m) throws IllegalArgumentException {
        checkAdditionCompatible(m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        FieldElement[][] r2 = AbstractFieldMatrix.buildArray(getField(), rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        T[] dataRow = this.data[row];
        T[] mRow = m.data[row];
        FieldElement[] r6 = r2[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        r6[col] = (FieldElement) dataRow[col].add(mRow[col]);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new Array2DRowFieldMatrix(r2, false);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> m) throws IllegalArgumentException {
        return subtract((Array2DRowFieldMatrix) m);
    L6:
        return super.subtract(m);
    }

    public Array2DRowFieldMatrix<T> subtract(Array2DRowFieldMatrix<T> m) throws IllegalArgumentException {
        checkSubtractionCompatible(m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        FieldElement[][] r2 = AbstractFieldMatrix.buildArray(getField(), rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        T[] dataRow = this.data[row];
        T[] mRow = m.data[row];
        FieldElement[] r6 = r2[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        r6[col] = (FieldElement) dataRow[col].subtract(mRow[col]);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new Array2DRowFieldMatrix(r2, false);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> m) throws IllegalArgumentException {
        return multiply((Array2DRowFieldMatrix) m);
    L6:
        return super.multiply(m);
    }

    public Array2DRowFieldMatrix<T> multiply(Array2DRowFieldMatrix<T> m) throws IllegalArgumentException {
        checkMultiplicationCompatible(m);
        int nRows = getRowDimension();
        int nCols = m.getColumnDimension();
        int nSum = getColumnDimension();
        FieldElement[][] r3 = AbstractFieldMatrix.buildArray(getField(), nRows, nCols);
        int row = 0;
    L3:
        if (row >= nRows) goto L12;
        T[] dataRow = this.data[row];
        FieldElement[] r6 = r3[row];
        int col = 0;
    L5:
        if (col >= nCols) goto L10;
        T r8 = getField().getZero();
        int i = 0;
    L7:
        if (i >= nSum) goto L9;
        r8 = (FieldElement) r8.add((FieldElement) dataRow[i].multiply(m.data[i][col]));
        i = i + 1;
        goto L7
    L9:
        r6[col] = r8;
        col = col + 1;
        goto L5
    L10:
        row = row + 1;
        goto L3
    L12:
        return new Array2DRowFieldMatrix(r3, false);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[][] getData() {
        return (T[][]) copyOut();
    }

    public T[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setSubMatrix(T[][] r8, int r9, int r10) throws MatrixIndexException {
        if (this.data != null) goto L27;
        if (r9 > 0) goto L26;
        if (r10 > 0) goto L24;
        if (r8.length == 0) goto L22;
        int r2 = r8[0].length;
        if (r2 == 0) goto L20;
        this.data = (T[][]) AbstractFieldMatrix.buildArray(getField(), r8.length, r2);
        int r3 = 0;
    L12:
        if (r3 >= this.data.length) goto L31;
        if (r8[r3].length != r2) goto L17;
        System.arraycopy(r8[r3], 0, this.data[r3 + r9], r10, r2);
        r3 = r3 + 1;
        goto L12
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(r2), Integer.valueOf(r8[r3].length)});
    L31:
        return;
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    L24:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(r10)});
    L26:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(r9)});
    L27:
        super.setSubMatrix(r8, r9, r10);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T getEntry(int row, int column) throws MatrixIndexException {
        return this.data[row][column];
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setEntry(int row, int column, T value) throws MatrixIndexException {
        this.data[row][column] = value;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void addToEntry(int r8, int r9, T r10) throws MatrixIndexException {
        ((T[][]) this.data)[r8][r9] = (FieldElement) this.data[r8][r9].add(r10);     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void multiplyEntry(int r8, int r9, T r10) throws MatrixIndexException {
        ((T[][]) this.data)[r8][r9] = (FieldElement) this.data[r8][r9].multiply(r10);     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        if (this.data != null) goto L6;
        return 0;
    L6:
        return this.data.length;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        if (this.data != null) goto L5;
        return 0;
    L5:
        if (this.data[0] != null) goto L8;
        return 0;
    L8:
        return this.data[0].length;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[] operate(T[] r10) throws IllegalArgumentException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r10.length != r1) goto L13;
        T[] r2 = (T[]) AbstractFieldMatrix.buildArray(getField(), r0);
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L11;
        T[] r4 = this.data[r3];
        T r5 = getField().getZero();
        int r6 = 0;
    L7:
        if (r6 >= r1) goto L9;
        r5 = (T) r5.add((FieldElement) r4[r6].multiply(r10[r6]));
        r6 = r6 + 1;
        goto L7
    L9:
        r2[r3] = r5;
        r3 = r3 + 1;
        goto L5
    L11:
        return r2;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r1)});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[] preMultiply(T[] r9) throws IllegalArgumentException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r9.length != r0) goto L13;
        T[] r2 = (T[]) AbstractFieldMatrix.buildArray(getField(), r1);
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L11;
        T r4 = getField().getZero();
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L9;
        r4 = (T) r4.add((FieldElement) this.data[r5][r3].multiply(r9[r5]));
        r5 = r5 + 1;
        goto L7
    L9:
        r2[r3] = r4;
        r3 = r3 + 1;
        goto L5
    L11:
        return r2;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(r9.length), Integer.valueOf(r0)});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8) throws MatrixVisitorException {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        r8.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r9 = 0;
    L3:
        if (r9 >= r1) goto L9;
        Object[] r3 = this.data[r9];
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L7;
        r3[r4] = r8.visit(r9, r4, r3[r4]);
        r4 = r4 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8) throws MatrixVisitorException {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        r8.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r9 = 0;
    L3:
        if (r9 >= r1) goto L9;
        T[] r3 = this.data[r9];
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L7;
        r8.visit(r9, r4, r3[r4]);
        r4 = r4 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r9;
    L3:
        if (r13 > r10) goto L9;
        Object[] r14 = this.data[r13];
        int r15 = r11;
    L5:
        if (r15 > r12) goto L7;
        r14[r15] = r8.visit(r13, r15, r14[r15]);
        r15 = r15 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r9;
    L3:
        if (r13 > r10) goto L9;
        T[] r14 = this.data[r13];
        int r15 = r11;
    L5:
        if (r15 > r12) goto L7;
        r8.visit(r13, r15, r14[r15]);
        r15 = r15 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r8) throws MatrixVisitorException {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        r8.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r9 = 0;
    L3:
        if (r9 >= r2) goto L9;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        Object[] r4 = this.data[r3];
        r4[r9] = r8.visit(r3, r9, r4[r9]);
        r3 = r3 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r8) throws MatrixVisitorException {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        r8.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r9 = 0;
    L3:
        if (r9 >= r2) goto L9;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        r8.visit(r3, r9, this.data[r3][r9]);
        r3 = r3 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r11;
    L3:
        if (r13 > r12) goto L9;
        int r14 = r9;
    L5:
        if (r14 > r10) goto L7;
        Object[] r15 = this.data[r14];
        r15[r13] = r8.visit(r14, r13, r15[r13]);
        r14 = r14 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r11;
    L3:
        if (r13 > r12) goto L9;
        int r14 = r9;
    L5:
        if (r14 > r10) goto L7;
        r8.visit(r14, r13, this.data[r14][r13]);
        r14 = r14 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    private T[][] copyOut() {
        int r0 = getRowDimension();
        T[][] r1 = (T[][]) AbstractFieldMatrix.buildArray(getField(), r0, getColumnDimension());
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        System.arraycopy(this.data[r2], 0, r1[r2], 0, this.data[r2].length);
        r2 = r2 + 1;
        goto L3
    L6:
        return r1;
    }

    private void copyIn(T[][] in) {
        setSubMatrix(in, 0, 0);
    }
}
