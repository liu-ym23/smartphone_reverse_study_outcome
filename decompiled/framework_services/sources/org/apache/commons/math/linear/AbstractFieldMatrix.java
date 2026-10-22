package org.apache.commons.math.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractFieldMatrix<T extends FieldElement<T>> implements FieldMatrix<T> {
    private final Field<T> field;

    @Override // org.apache.commons.math.linear.FieldMatrix
    public abstract void addToEntry(int r1, int r2, T r3) throws MatrixIndexException;

    @Override // org.apache.commons.math.linear.FieldMatrix
    public abstract FieldMatrix<T> copy();

    @Override // org.apache.commons.math.linear.FieldMatrix
    public abstract FieldMatrix<T> createMatrix(int r1, int r2) throws IllegalArgumentException;

    @Override // org.apache.commons.math.linear.AnyMatrix
    public abstract int getColumnDimension();

    @Override // org.apache.commons.math.linear.FieldMatrix
    public abstract T getEntry(int r1, int r2) throws MatrixIndexException;

    @Override // org.apache.commons.math.linear.AnyMatrix
    public abstract int getRowDimension();

    @Override // org.apache.commons.math.linear.FieldMatrix
    public abstract void multiplyEntry(int r1, int r2, T r3) throws MatrixIndexException;

    @Override // org.apache.commons.math.linear.FieldMatrix
    public abstract void setEntry(int r1, int r2, T r3) throws MatrixIndexException;

    protected AbstractFieldMatrix() {
        this.field = null;
    }

    protected AbstractFieldMatrix(Field<T> field) {
        this.field = field;
    }

    protected AbstractFieldMatrix(Field<T> field, int rowDimension, int columnDimension) throws IllegalArgumentException {
        if (rowDimension < 1) goto L10;
        if (columnDimension < 1) goto L8;
        this.field = field;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(columnDimension), 1});
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(rowDimension), 1});
    }

    protected static <T extends FieldElement<T>> Field<T> extractField(T[][] d) throws IllegalArgumentException {
        if (d.length == 0) goto L11;
        if (d[0].length == 0) goto L9;
        return d[0][0].getField();
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    protected static <T extends FieldElement<T>> Field<T> extractField(T[] d) throws IllegalArgumentException {
        if (d.length == 0) goto L7;
        return d[0].getField();
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    protected static <T extends FieldElement<T>> T[][] buildArray(Field<T> r4, int r5, int r6) {
        if (r6 < 0) goto L4;
        T[][] r0 = (T[][]) ((FieldElement[][]) Array.newInstance(r4.getZero().getClass(), new int[]{r5, r6}));
        int r1 = 0;
    L7:
        if (r1 >= r0.length) goto L10;
        Arrays.fill(r0[r1], r4.getZero());
        r1 = r1 + 1;
        goto L7
    L10:
        return r0;
    L4:
        return (T[][]) ((FieldElement[][]) Array.newInstance(((FieldElement[]) Array.newInstance(r4.getZero().getClass(), 0)).getClass(), r5));
    }

    protected static <T extends FieldElement<T>> T[] buildArray(Field<T> r2, int r3) {
        T[] r0 = (T[]) ((FieldElement[]) Array.newInstance(r2.getZero().getClass(), r3));
        Arrays.fill(r0, r2.getZero());
        return r0;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> m) throws IllegalArgumentException {
        checkAdditionCompatible(m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        FieldMatrix<T> out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, (FieldElement) getEntry(row, col).add(m.getEntry(row, col)));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> m) throws IllegalArgumentException {
        checkSubtractionCompatible(m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        FieldMatrix<T> out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, (FieldElement) getEntry(row, col).subtract(m.getEntry(row, col)));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> scalarAdd(T d) {
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        FieldMatrix<T> out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, (FieldElement) getEntry(row, col).add(d));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> scalarMultiply(T d) {
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        FieldMatrix<T> out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, (FieldElement) getEntry(row, col).multiply(d));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> m) throws IllegalArgumentException {
        checkMultiplicationCompatible(m);
        int nRows = getRowDimension();
        int nCols = m.getColumnDimension();
        int nSum = getColumnDimension();
        FieldMatrix<T> out = createMatrix(nRows, nCols);
        int row = 0;
    L3:
        if (row >= nRows) goto L12;
        int col = 0;
    L5:
        if (col >= nCols) goto L10;
        T r6 = this.field.getZero();
        int i = 0;
    L7:
        if (i >= nSum) goto L9;
        r6 = (FieldElement) r6.add((FieldElement) getEntry(row, i).multiply(m.getEntry(i, col)));
        i = i + 1;
        goto L7
    L9:
        out.setEntry(row, col, r6);
        col = col + 1;
        goto L5
    L10:
        row = row + 1;
        goto L3
    L12:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> preMultiply(FieldMatrix<T> m) throws IllegalArgumentException {
        return m.multiply(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.FieldMatrix
    public T[][] getData() {
        T[][] r0 = (T[][]) buildArray(this.field, getRowDimension(), getColumnDimension());
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L11;
        FieldElement[] r2 = r0[r1];
        int r3 = 0;
    L7:
        if (r3 >= r2.length) goto L9;
        r2[r3] = getEntry(r1, r3);
        r3 = r3 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException {
        checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
        FieldMatrix<T> subMatrix = createMatrix((endRow - startRow) + 1, (endColumn - startColumn) + 1);
        int i = startRow;
    L3:
        if (i > endRow) goto L9;
        int j = startColumn;
    L5:
        if (j > endColumn) goto L7;
        subMatrix.setEntry(i - startRow, j - startColumn, getEntry(i, j));
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return subMatrix;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(final int[] selectedRows, final int[] selectedColumns) throws MatrixIndexException {
        checkSubMatrixIndex(selectedRows, selectedColumns);
        FieldMatrix<T> subMatrix = createMatrix(selectedRows.length, selectedColumns.length);
        final T r2 = this.field.getZero();
        subMatrix.walkInOptimizedOrder(new AnonymousClass1(this, r2, selectedRows, selectedColumns));
        return subMatrix;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void copySubMatrix(int startRow, int endRow, int startColumn, int endColumn, final T[][] destination) throws MatrixIndexException, IllegalArgumentException {
        checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
        int rowsCount = (endRow + 1) - startRow;
        int columnsCount = (endColumn + 1) - startColumn;
        if (destination.length < rowsCount) goto L9;
        if (destination[0].length < columnsCount) goto L9;
        final T r2 = this.field.getZero();
        walkInOptimizedOrder(new AnonymousClass2(this, r2, destination), startRow, endRow, startColumn, endColumn);
        return;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(destination.length), Integer.valueOf(destination[0].length), Integer.valueOf(rowsCount), Integer.valueOf(columnsCount)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.FieldMatrix
    public void copySubMatrix(int[] selectedRows, int[] selectedColumns, T[][] r8) throws MatrixIndexException, IllegalArgumentException {
        checkSubMatrixIndex(selectedRows, selectedColumns);
        if (r8.length < selectedRows.length) goto L17;
        if (r8[0].length < selectedColumns.length) goto L17;
        int i = 0;
    L8:
        if (i >= selectedRows.length) goto L15;
        FieldElement[] r1 = r8[i];
        int j = 0;
    L11:
        if (j >= selectedColumns.length) goto L13;
        r1[j] = getEntry(selectedRows[i], selectedColumns[j]);
        j = j + 1;
        goto L11
    L13:
        i = i + 1;
        goto L8
    L15:
        return;
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(r8.length), Integer.valueOf(r8[0].length), Integer.valueOf(selectedRows.length), Integer.valueOf(selectedColumns.length)});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setSubMatrix(T[][] subMatrix, int row, int column) throws MatrixIndexException {
        int nRows = subMatrix.length;
        if (nRows == 0) goto L24;
        int nCols = subMatrix[0].length;
        if (nCols == 0) goto L22;
        int r = 1;
    L7:
        if (r >= nRows) goto L13;
        if (subMatrix[r].length != nCols) goto L12;
        r = r + 1;
        goto L7
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(nCols), Integer.valueOf(subMatrix[r].length)});
    L13:
        checkRowIndex(row);
        checkColumnIndex(column);
        checkRowIndex((nRows + row) - 1);
        checkColumnIndex((nCols + column) - 1);
        int i = 0;
    L14:
        if (i >= nRows) goto L20;
        int j = 0;
    L16:
        if (j >= nCols) goto L18;
        setEntry(row + i, column + j, subMatrix[i][j]);
        j = j + 1;
        goto L16
    L18:
        i = i + 1;
        goto L14
    L20:
        return;
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L24:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getRowMatrix(int row) throws MatrixIndexException {
        checkRowIndex(row);
        int nCols = getColumnDimension();
        FieldMatrix<T> out = createMatrix(1, nCols);
        int i = 0;
    L3:
        if (i >= nCols) goto L6;
        out.setEntry(0, i, getEntry(row, i));
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setRowMatrix(int row, FieldMatrix<T> matrix) throws MatrixIndexException, InvalidMatrixException {
        checkRowIndex(row);
        int nCols = getColumnDimension();
        if (matrix.getRowDimension() != 1) goto L12;
        if (matrix.getColumnDimension() != nCols) goto L12;
        int i = 0;
    L7:
        if (i >= nCols) goto L10;
        setEntry(row, i, matrix.getEntry(0, i));
        i = i + 1;
        goto L7
    L10:
        return;
    L12:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(matrix.getRowDimension()), Integer.valueOf(matrix.getColumnDimension()), 1, Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getColumnMatrix(int column) throws MatrixIndexException {
        checkColumnIndex(column);
        int nRows = getRowDimension();
        FieldMatrix<T> out = createMatrix(nRows, 1);
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        out.setEntry(i, 0, getEntry(i, column));
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setColumnMatrix(int column, FieldMatrix<T> matrix) throws MatrixIndexException, InvalidMatrixException {
        checkColumnIndex(column);
        int nRows = getRowDimension();
        if (matrix.getRowDimension() != nRows) goto L12;
        if (matrix.getColumnDimension() != 1) goto L12;
        int i = 0;
    L7:
        if (i >= nRows) goto L10;
        setEntry(i, column, matrix.getEntry(i, 0));
        i = i + 1;
        goto L7
    L10:
        return;
    L12:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(matrix.getRowDimension()), Integer.valueOf(matrix.getColumnDimension()), Integer.valueOf(nRows), 1});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldVector<T> getRowVector(int row) throws MatrixIndexException {
        return new ArrayFieldVector(getRow(row), false);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setRowVector(int row, FieldVector<T> vector) throws MatrixIndexException, InvalidMatrixException {
        checkRowIndex(row);
        int nCols = getColumnDimension();
        if (vector.getDimension() != nCols) goto L10;
        int i = 0;
    L5:
        if (i >= nCols) goto L8;
        setEntry(row, i, vector.getEntry(i));
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{1, Integer.valueOf(vector.getDimension()), 1, Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldVector<T> getColumnVector(int column) throws MatrixIndexException {
        return new ArrayFieldVector(getColumn(column), false);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setColumnVector(int column, FieldVector<T> vector) throws MatrixIndexException, InvalidMatrixException {
        checkColumnIndex(column);
        int nRows = getRowDimension();
        if (vector.getDimension() != nRows) goto L10;
        int i = 0;
    L5:
        if (i >= nRows) goto L8;
        setEntry(i, column, vector.getEntry(i));
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(vector.getDimension()), 1, Integer.valueOf(nRows), 1});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.FieldMatrix
    public T[] getRow(int r5) throws MatrixIndexException {
        checkRowIndex(r5);
        int r0 = getColumnDimension();
        T[] r1 = (T[]) buildArray(this.field, r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = getEntry(r5, r2);
        r2 = r2 + 1;
        goto L3
    L6:
        return r1;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setRow(int row, T[] array) throws MatrixIndexException, InvalidMatrixException {
        checkRowIndex(row);
        int nCols = getColumnDimension();
        if (array.length != nCols) goto L10;
        int i = 0;
    L5:
        if (i >= nCols) goto L8;
        setEntry(row, i, array[i]);
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{1, Integer.valueOf(array.length), 1, Integer.valueOf(nCols)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.FieldMatrix
    public T[] getColumn(int r5) throws MatrixIndexException {
        checkColumnIndex(r5);
        int r0 = getRowDimension();
        T[] r1 = (T[]) buildArray(this.field, r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = getEntry(r2, r5);
        r2 = r2 + 1;
        goto L3
    L6:
        return r1;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public void setColumn(int column, T[] array) throws MatrixIndexException, InvalidMatrixException {
        checkColumnIndex(column);
        int nRows = getRowDimension();
        if (array.length != nRows) goto L10;
        int i = 0;
    L5:
        if (i >= nRows) goto L8;
        setEntry(i, column, array[i]);
        i = i + 1;
        goto L5
    L8:
        return;
    L10:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(array.length), 1, Integer.valueOf(nRows), 1});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> transpose() {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        final FieldMatrix<T> out = createMatrix(nCols, nRows);
        final T r4 = this.field.getZero();
        walkInOptimizedOrder(new AnonymousClass3(this, r4, out));
        return out;
    }

    @Override // org.apache.commons.math.linear.AnyMatrix
    public boolean isSquare() {
        if (getColumnDimension() != getRowDimension()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T getTrace() throws NonSquareMatrixException {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (nRows != nCols) goto L10;
        T r2 = this.field.getZero();
        int i = 0;
    L5:
        if (i >= nRows) goto L8;
        r2 = (T) r2.add(getEntry(i, i));
        i = i + 1;
        goto L5
    L8:
        return r2;
    L10:
        throw new NonSquareMatrixException(nRows, nCols);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T[] operate(T[] r9) throws IllegalArgumentException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r9.length != r1) goto L13;
        T[] r2 = (T[]) buildArray(this.field, r0);
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L11;
        T r4 = this.field.getZero();
        int r5 = 0;
    L7:
        if (r5 >= r1) goto L9;
        r4 = (T) r4.add((FieldElement) getEntry(r3, r5).multiply(r9[r5]));
        r5 = r5 + 1;
        goto L7
    L9:
        r2[r3] = r4;
        r3 = r3 + 1;
        goto L5
    L11:
        return r2;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(r9.length), Integer.valueOf(r1)});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldVector<T> operate(FieldVector<T> v) throws IllegalArgumentException {
        return new ArrayFieldVector(operate(((ArrayFieldVector) v).getDataRef()), false);
    L6:
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.getDimension() != nCols) goto L17;
        FieldElement[] r4 = buildArray(this.field, nRows);
        int row = 0;
    L9:
        if (row >= nRows) goto L15;
        T r6 = this.field.getZero();
        int i = 0;
    L11:
        if (i >= nCols) goto L13;
        r6 = (FieldElement) r6.add((FieldElement) getEntry(row, i).multiply(v.getEntry(i)));
        i = i + 1;
        goto L11
    L13:
        r4[row] = r6;
        row = row + 1;
        goto L9
    L15:
        return new ArrayFieldVector(r4, false);
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.getDimension()), Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T[] preMultiply(T[] r9) throws IllegalArgumentException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r9.length != r0) goto L13;
        T[] r2 = (T[]) buildArray(this.field, r1);
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L11;
        T r4 = this.field.getZero();
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L9;
        r4 = (T) r4.add((FieldElement) getEntry(r5, r3).multiply(r9[r5]));
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

    @Override // org.apache.commons.math.linear.FieldMatrix
    public FieldVector<T> preMultiply(FieldVector<T> v) throws IllegalArgumentException {
        return new ArrayFieldVector(preMultiply(((ArrayFieldVector) v).getDataRef()), false);
    L5:
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.getDimension() != nRows) goto L16;
        FieldElement[] r3 = buildArray(this.field, nCols);
        int col = 0;
    L8:
        if (col >= nCols) goto L14;
        T r5 = this.field.getZero();
        int i = 0;
    L10:
        if (i >= nRows) goto L12;
        r5 = (FieldElement) r5.add((FieldElement) getEntry(i, col).multiply(v.getEntry(i)));
        i = i + 1;
        goto L10
    L12:
        r3[col] = r5;
        col = col + 1;
        goto L8
    L14:
        return new ArrayFieldVector(r3);
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.getDimension()), Integer.valueOf(nRows)});
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8) throws MatrixVisitorException {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        r8.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r9 = 0;
    L3:
        if (r9 >= r1) goto L9;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        setEntry(r9, r3, r8.visit(r9, r3, getEntry(r9, r3)));
        r3 = r3 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8) throws MatrixVisitorException {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        r8.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r9 = 0;
    L3:
        if (r9 >= r1) goto L9;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        r8.visit(r9, r3, getEntry(r9, r3));
        r3 = r3 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r9;
    L3:
        if (r13 > r10) goto L9;
        int r14 = r11;
    L5:
        if (r14 > r12) goto L7;
        setEntry(r13, r14, r8.visit(r13, r14, getEntry(r13, r14)));
        r14 = r14 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r9;
    L3:
        if (r13 > r10) goto L9;
        int r14 = r11;
    L5:
        if (r14 > r12) goto L7;
        r8.visit(r13, r14, getEntry(r13, r14));
        r14 = r14 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
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
        setEntry(r3, r9, r8.visit(r3, r9, getEntry(r3, r9)));
        r3 = r3 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
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
        r8.visit(r3, r9, getEntry(r3, r9));
        r3 = r3 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r11;
    L3:
        if (r13 > r12) goto L9;
        int r14 = r9;
    L5:
        if (r14 > r10) goto L7;
        setEntry(r14, r13, r8.visit(r14, r13, getEntry(r14, r13)));
        r14 = r14 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) throws MatrixIndexException, MatrixVisitorException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
        int r13 = r11;
    L3:
        if (r13 > r12) goto L9;
        int r14 = r9;
    L5:
        if (r14 > r10) goto L7;
        r8.visit(r14, r13, getEntry(r14, r13));
        r14 = r14 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r2) throws MatrixVisitorException {
        return (T) walkInRowOrder(r2);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r2) throws MatrixVisitorException {
        return (T) walkInRowOrder(r2);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r2, int r3, int r4, int r5, int r6) throws MatrixIndexException, MatrixVisitorException {
        return (T) walkInRowOrder(r2, r3, r4, r5, r6);
    }

    @Override // org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r2, int r3, int r4, int r5, int r6) throws MatrixIndexException, MatrixVisitorException {
        return (T) walkInRowOrder(r2, r3, r4, r5, r6);
    }

    public String toString() {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        StringBuilder res = new StringBuilder();
        String fullClassName = getClass().getName();
        String shortClassName = fullClassName.substring(fullClassName.lastIndexOf(46) + 1);
        res.append(shortClassName);
        res.append("{");
        int i = 0;
    L4:
        if (i >= nRows) goto L14;
        if (i <= 0) goto L8;
        res.append(",");
    L8:
        res.append("{");
        int j = 0;
    L9:
        if (j >= nCols) goto L13;
        if (j <= 0) goto L12;
        res.append(",");
    L12:
        res.append(getEntry(i, j));
        j = j + 1;
        goto L9
    L13:
        res.append("}");
        i = i + 1;
        goto L4
    L14:
        res.append("}");
        return res.toString();
    }

    public boolean equals(Object object) {
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof FieldMatrix) == true) goto L8;
        return false;
    L8:
        FieldMatrix<?> m = (FieldMatrix) object;
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (m.getColumnDimension() == nCols) goto L11;
    L24:
        return false;
    L11:
        if (m.getRowDimension() != nRows) goto L24;
        int row = 0;
    L14:
        if (row >= nRows) goto L23;
        int col = 0;
    L16:
        if (col >= nCols) goto L21;
        if (getEntry(row, col).equals(m.getEntry(row, col)) == false) goto L19;
        col = col + 1;
        goto L16
    L19:
        return false;
    L21:
        row = row + 1;
        goto L14
    L23:
        return true;
    }

    public int hashCode() {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        int ret = (322562 * 31) + nRows;
        int ret2 = (ret * 31) + nCols;
        int row = 0;
    L3:
        if (row >= nRows) goto L9;
        int col = 0;
    L5:
        if (col >= nCols) goto L7;
        ret2 = (ret2 * 31) + ((((row + 1) * 11) + ((col + 1) * 17)) * getEntry(row, col).hashCode());
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return ret2;
    }

    protected void checkRowIndex(int row) {
        if (row < 0) goto L7;
        if (row >= getRowDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.ROW_INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(row), 0, Integer.valueOf(getRowDimension() - 1)});
    }

    protected void checkColumnIndex(int column) throws MatrixIndexException {
        if (column < 0) goto L7;
        if (column >= getColumnDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.COLUMN_INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(column), 0, Integer.valueOf(getColumnDimension() - 1)});
    }

    protected void checkSubMatrixIndex(int startRow, int endRow, int startColumn, int endColumn) {
        checkRowIndex(startRow);
        checkRowIndex(endRow);
        if (startRow > endRow) goto L10;
        checkColumnIndex(startColumn);
        checkColumnIndex(endColumn);
        if (startColumn > endColumn) goto L8;
        return;
    L8:
        throw new MatrixIndexException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, new Object[]{Integer.valueOf(startColumn), Integer.valueOf(endColumn)});
    L10:
        throw new MatrixIndexException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, new Object[]{Integer.valueOf(startRow), Integer.valueOf(endRow)});
    }

    protected void checkSubMatrixIndex(int[] selectedRows, int[] selectedColumns) {
        int r1 = 0;
        if ((selectedRows.length * selectedColumns.length) == 0) goto L5;
        int r0 = selectedRows.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L13;
        int row = selectedRows[r2];
        checkRowIndex(row);
        r2 = r2 + 1;
        goto L11
    L13:
        int r3 = selectedColumns.length;
    L14:
        if (r1 >= r3) goto L16;
        int column = selectedColumns[r1];
        checkColumnIndex(column);
        r1 = r1 + 1;
        goto L14
    L16:
        return;
    L5:
        if (selectedRows.length != 0) goto L9;
        throw new MatrixIndexException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY, new Object[0]);
    L9:
        throw new MatrixIndexException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY, new Object[0]);
    }

    protected void checkAdditionCompatible(FieldMatrix<T> m) {
        if (getRowDimension() != m.getRowDimension()) goto L8;
        if (getColumnDimension() != m.getColumnDimension()) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_ADDITION_COMPATIBLE_MATRICES, new Object[]{Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()), Integer.valueOf(m.getRowDimension()), Integer.valueOf(m.getColumnDimension())});
    }

    protected void checkSubtractionCompatible(FieldMatrix<T> m) {
        if (getRowDimension() != m.getRowDimension()) goto L8;
        if (getColumnDimension() != m.getColumnDimension()) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_SUBTRACTION_COMPATIBLE_MATRICES, new Object[]{Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()), Integer.valueOf(m.getRowDimension()), Integer.valueOf(m.getColumnDimension())});
    }

    protected void checkMultiplicationCompatible(FieldMatrix<T> m) {
        if (getColumnDimension() != m.getRowDimension()) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_MULTIPLICATION_COMPATIBLE_MATRICES, new Object[]{Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()), Integer.valueOf(m.getRowDimension()), Integer.valueOf(m.getColumnDimension())});
    }
}
