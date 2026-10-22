package org.apache.commons.math.linear;

import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRealMatrix implements RealMatrix {

    @Deprecated
    private DecompositionSolver lu;

    @Override // org.apache.commons.math.linear.RealMatrix
    public abstract void addToEntry(int r1, int r2, double r3) throws MatrixIndexException;

    @Override // org.apache.commons.math.linear.RealMatrix
    public abstract RealMatrix copy();

    @Override // org.apache.commons.math.linear.RealMatrix
    public abstract RealMatrix createMatrix(int r1, int r2) throws IllegalArgumentException;

    @Override // org.apache.commons.math.linear.AnyMatrix
    public abstract int getColumnDimension();

    @Override // org.apache.commons.math.linear.RealMatrix
    public abstract double getEntry(int r1, int r2) throws MatrixIndexException;

    @Override // org.apache.commons.math.linear.AnyMatrix
    public abstract int getRowDimension();

    @Override // org.apache.commons.math.linear.RealMatrix
    public abstract void multiplyEntry(int r1, int r2, double r3) throws MatrixIndexException;

    @Override // org.apache.commons.math.linear.RealMatrix
    public abstract void setEntry(int r1, int r2, double r3) throws MatrixIndexException;

    protected AbstractRealMatrix() {
        this.lu = null;
    }

    protected AbstractRealMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        if (rowDimension < 1) goto L10;
        if (columnDimension <= 0) goto L8;
        this.lu = null;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(columnDimension), 1});
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(rowDimension), 1});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix add(RealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkAdditionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        RealMatrix out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, getEntry(row, col) + m.getEntry(row, col));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix subtract(RealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkSubtractionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        RealMatrix out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, getEntry(row, col) - m.getEntry(row, col));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix scalarAdd(double d) {
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        RealMatrix out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, getEntry(row, col) + d);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix scalarMultiply(double d) {
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        RealMatrix out = createMatrix(rowCount, columnCount);
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        out.setEntry(row, col, getEntry(row, col) * d);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix multiply(RealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkMultiplicationCompatible(this, m);
        int nRows = getRowDimension();
        int nCols = m.getColumnDimension();
        int nSum = getColumnDimension();
        RealMatrix out = createMatrix(nRows, nCols);
        int row = 0;
    L3:
        if (row >= nRows) goto L12;
        int col = 0;
    L5:
        if (col >= nCols) goto L10;
        double sum = 0.0d;
        int i = 0;
    L7:
        if (i >= nSum) goto L9;
        sum = sum + (getEntry(row, i) * m.getEntry(i, col));
        i = i + 1;
        goto L7
    L9:
        out.setEntry(row, col, sum);
        col = col + 1;
        goto L5
    L10:
        row = row + 1;
        goto L3
    L12:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix preMultiply(RealMatrix m) throws IllegalArgumentException {
        return m.multiply(this);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double[][] getData() {
        double[][] data = (double[][]) Array.newInstance(Double.TYPE, new int[]{getRowDimension(), getColumnDimension()});
        int i = 0;
    L4:
        if (i >= data.length) goto L11;
        double[] dataI = data[i];
        int j = 0;
    L7:
        if (j >= dataI.length) goto L9;
        dataI[j] = getEntry(i, j);
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return data;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double getNorm() {
        return walkInColumnOrder(new AnonymousClass1(this));
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double getFrobeniusNorm() {
        return walkInOptimizedOrder(new AnonymousClass2(this));
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        RealMatrix subMatrix = createMatrix((endRow - startRow) + 1, (endColumn - startColumn) + 1);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix getSubMatrix(final int[] selectedRows, final int[] selectedColumns) throws MatrixIndexException {
        MatrixUtils.checkSubMatrixIndex(this, selectedRows, selectedColumns);
        RealMatrix subMatrix = createMatrix(selectedRows.length, selectedColumns.length);
        subMatrix.walkInOptimizedOrder(new AnonymousClass3(this, selectedRows, selectedColumns));
        return subMatrix;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void copySubMatrix(int startRow, int endRow, int startColumn, int endColumn, final double[][] destination) throws MatrixIndexException, IllegalArgumentException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        int rowsCount = (endRow + 1) - startRow;
        int columnsCount = (endColumn + 1) - startColumn;
        if (destination.length < rowsCount) goto L9;
        if (destination[0].length < columnsCount) goto L9;
        walkInOptimizedOrder(new AnonymousClass4(this, destination), startRow, endRow, startColumn, endColumn);
        return;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(destination.length), Integer.valueOf(destination[0].length), Integer.valueOf(rowsCount), Integer.valueOf(columnsCount)});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void copySubMatrix(int[] selectedRows, int[] selectedColumns, double[][] destination) throws MatrixIndexException, IllegalArgumentException {
        MatrixUtils.checkSubMatrixIndex(this, selectedRows, selectedColumns);
        if (destination.length < selectedRows.length) goto L17;
        if (destination[0].length < selectedColumns.length) goto L17;
        int i = 0;
    L8:
        if (i >= selectedRows.length) goto L15;
        double[] destinationI = destination[i];
        int j = 0;
    L11:
        if (j >= selectedColumns.length) goto L13;
        destinationI[j] = getEntry(selectedRows[i], selectedColumns[j]);
        j = j + 1;
        goto L11
    L13:
        i = i + 1;
        goto L8
    L15:
        return;
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(destination.length), Integer.valueOf(destination[0].length), Integer.valueOf(selectedRows.length), Integer.valueOf(selectedColumns.length)});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setSubMatrix(double[][] subMatrix, int row, int column) throws MatrixIndexException {
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
        MatrixUtils.checkRowIndex(this, row);
        MatrixUtils.checkColumnIndex(this, column);
        MatrixUtils.checkRowIndex(this, (nRows + row) - 1);
        MatrixUtils.checkColumnIndex(this, (nCols + column) - 1);
        int i = 0;
    L14:
        if (i >= nRows) goto L19;
        int j = 0;
    L16:
        if (j >= nCols) goto L18;
        setEntry(row + i, column + j, subMatrix[i][j]);
        j = j + 1;
        goto L16
    L18:
        i = i + 1;
        goto L14
    L19:
        this.lu = null;
        return;
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L24:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix getRowMatrix(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        int nCols = getColumnDimension();
        RealMatrix out = createMatrix(1, nCols);
        int i = 0;
    L3:
        if (i >= nCols) goto L6;
        out.setEntry(0, i, getEntry(row, i));
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setRowMatrix(int row, RealMatrix matrix) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkRowIndex(this, row);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix getColumnMatrix(int column) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, column);
        int nRows = getRowDimension();
        RealMatrix out = createMatrix(nRows, 1);
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        out.setEntry(i, 0, getEntry(i, column));
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setColumnMatrix(int column, RealMatrix matrix) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkColumnIndex(this, column);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealVector getRowVector(int row) throws MatrixIndexException {
        return new ArrayRealVector(getRow(row), false);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setRowVector(int row, RealVector vector) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkRowIndex(this, row);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealVector getColumnVector(int column) throws MatrixIndexException {
        return new ArrayRealVector(getColumn(column), false);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setColumnVector(int column, RealVector vector) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkColumnIndex(this, column);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public double[] getRow(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        int nCols = getColumnDimension();
        double[] out = new double[nCols];
        int i = 0;
    L3:
        if (i >= nCols) goto L6;
        out[i] = getEntry(row, i);
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setRow(int row, double[] array) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkRowIndex(this, row);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public double[] getColumn(int column) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, column);
        int nRows = getRowDimension();
        double[] out = new double[nRows];
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        out[i] = getEntry(i, column);
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public void setColumn(int column, double[] array) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkColumnIndex(this, column);
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

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealMatrix transpose() {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        final RealMatrix out = createMatrix(nCols, nRows);
        walkInOptimizedOrder(new AnonymousClass5(this, out));
        return out;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    @Deprecated
    public RealMatrix inverse() throws InvalidMatrixException {
        if (this.lu != null) goto L6;
        this.lu = new LUDecompositionImpl(this, Double.MIN_NORMAL).getSolver();
    L6:
        return this.lu.getInverse();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    @Deprecated
    public double getDeterminant() throws InvalidMatrixException {
        return new LUDecompositionImpl(this, Double.MIN_NORMAL).getDeterminant();
    }

    @Override // org.apache.commons.math.linear.AnyMatrix
    public boolean isSquare() {
        if (getColumnDimension() != getRowDimension()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    @Deprecated
    public boolean isSingular() {
        if (this.lu != null) goto L6;
        this.lu = new LUDecompositionImpl(this, Double.MIN_NORMAL).getSolver();
    L6:
        return !this.lu.isNonSingular();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double getTrace() throws NonSquareMatrixException {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (nRows != nCols) goto L10;
        double trace = 0.0d;
        int i = 0;
    L5:
        if (i >= nRows) goto L8;
        trace = trace + getEntry(i, i);
        i = i + 1;
        goto L5
    L8:
        return trace;
    L10:
        throw new NonSquareMatrixException(nRows, nCols);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double[] operate(double[] v) throws IllegalArgumentException {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.length != nCols) goto L13;
        double[] out = new double[nRows];
        int row = 0;
    L5:
        if (row >= nRows) goto L11;
        double sum = 0.0d;
        int i = 0;
    L7:
        if (i >= nCols) goto L9;
        sum = sum + (getEntry(row, i) * v[i]);
        i = i + 1;
        goto L7
    L9:
        out[row] = sum;
        row = row + 1;
        goto L5
    L11:
        return out;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.length), Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealVector operate(RealVector v) throws IllegalArgumentException {
        return new ArrayRealVector(operate(((ArrayRealVector) v).getDataRef()), false);
    L6:
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.getDimension() != nCols) goto L17;
        double[] out = new double[nRows];
        int row = 0;
    L9:
        if (row >= nRows) goto L15;
        double sum = 0.0d;
        int i = 0;
    L11:
        if (i >= nCols) goto L13;
        sum = sum + (getEntry(row, i) * v.getEntry(i));
        i = i + 1;
        goto L11
    L13:
        out[row] = sum;
        row = row + 1;
        goto L9
    L15:
        return new ArrayRealVector(out, false);
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.getDimension()), Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double[] preMultiply(double[] v) throws IllegalArgumentException {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.length != nRows) goto L13;
        double[] out = new double[nCols];
        int col = 0;
    L5:
        if (col >= nCols) goto L11;
        double sum = 0.0d;
        int i = 0;
    L7:
        if (i >= nRows) goto L9;
        sum = sum + (getEntry(i, col) * v[i]);
        i = i + 1;
        goto L7
    L9:
        out[col] = sum;
        col = col + 1;
        goto L5
    L11:
        return out;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.length), Integer.valueOf(nRows)});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public RealVector preMultiply(RealVector v) throws IllegalArgumentException {
        return new ArrayRealVector(preMultiply(((ArrayRealVector) v).getDataRef()), false);
    L5:
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.getDimension() != nRows) goto L16;
        double[] out = new double[nCols];
        int col = 0;
    L8:
        if (col >= nCols) goto L14;
        double sum = 0.0d;
        int i = 0;
    L10:
        if (i >= nRows) goto L12;
        sum = sum + (getEntry(i, col) * v.getEntry(i));
        i = i + 1;
        goto L10
    L12:
        out[col] = sum;
        col = col + 1;
        goto L8
    L14:
        return new ArrayRealVector(out);
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.getDimension()), Integer.valueOf(nRows)});
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int row = 0;
    L3:
        if (row >= rows) goto L8;
        int column = 0;
    L5:
        if (column >= columns) goto L7;
        double oldValue = getEntry(row, column);
        double newValue = visitor.visit(row, column, oldValue);
        setEntry(row, column, newValue);
        column = column + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L8:
        this.lu = null;
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int row = 0;
    L3:
        if (row >= rows) goto L9;
        int column = 0;
    L5:
        if (column >= columns) goto L7;
        visitor.visit(row, column, getEntry(row, column));
        column = column + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int row = startRow;
    L3:
        if (row > endRow) goto L8;
        int column = startColumn;
    L5:
        if (column > endColumn) goto L7;
        double oldValue = getEntry(row, column);
        double newValue = visitor.visit(row, column, oldValue);
        setEntry(row, column, newValue);
        column = column + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L8:
        this.lu = null;
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int row = startRow;
    L3:
        if (row > endRow) goto L9;
        int column = startColumn;
    L5:
        if (column > endColumn) goto L7;
        visitor.visit(row, column, getEntry(row, column));
        column = column + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int column = 0;
    L3:
        if (column >= columns) goto L8;
        int row = 0;
    L5:
        if (row >= rows) goto L7;
        double oldValue = getEntry(row, column);
        double newValue = visitor.visit(row, column, oldValue);
        setEntry(row, column, newValue);
        row = row + 1;
        goto L5
    L7:
        column = column + 1;
        goto L3
    L8:
        this.lu = null;
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int column = 0;
    L3:
        if (column >= columns) goto L9;
        int row = 0;
    L5:
        if (row >= rows) goto L7;
        visitor.visit(row, column, getEntry(row, column));
        row = row + 1;
        goto L5
    L7:
        column = column + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int column = startColumn;
    L3:
        if (column > endColumn) goto L8;
        int row = startRow;
    L5:
        if (row > endRow) goto L7;
        double oldValue = getEntry(row, column);
        double newValue = visitor.visit(row, column, oldValue);
        setEntry(row, column, newValue);
        row = row + 1;
        goto L5
    L7:
        column = column + 1;
        goto L3
    L8:
        this.lu = null;
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int column = startColumn;
    L3:
        if (column > endColumn) goto L9;
        int row = startRow;
    L5:
        if (row > endRow) goto L7;
        visitor.visit(row, column, getEntry(row, column));
        row = row + 1;
        goto L5
    L7:
        column = column + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        return walkInRowOrder(visitor);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        return walkInRowOrder(visitor);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        return walkInRowOrder(visitor, startRow, endRow, startColumn, endColumn);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        return walkInRowOrder(visitor, startRow, endRow, startColumn, endColumn);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    @Deprecated
    public double[] solve(double[] b) throws IllegalArgumentException, InvalidMatrixException {
        if (this.lu != null) goto L6;
        this.lu = new LUDecompositionImpl(this, Double.MIN_NORMAL).getSolver();
    L6:
        return this.lu.solve(b);
    }

    @Override // org.apache.commons.math.linear.RealMatrix
    @Deprecated
    public RealMatrix solve(RealMatrix b) throws IllegalArgumentException, InvalidMatrixException {
        if (this.lu != null) goto L6;
        this.lu = new LUDecompositionImpl(this, Double.MIN_NORMAL).getSolver();
    L6:
        return this.lu.solve(b);
    }

    @Deprecated
    public void luDecompose() throws InvalidMatrixException {
        if (this.lu != null) goto L6;
        this.lu = new LUDecompositionImpl(this, Double.MIN_NORMAL).getSolver();
        return;
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
        if ((object instanceof RealMatrix) == true) goto L8;
        return false;
    L8:
        RealMatrix m = (RealMatrix) object;
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
        if (getEntry(row, col) != m.getEntry(row, col)) goto L19;
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
        int ret = (7 * 31) + nRows;
        int ret2 = (ret * 31) + nCols;
        int row = 0;
    L3:
        if (row >= nRows) goto L9;
        int col = 0;
    L5:
        if (col >= nCols) goto L7;
        ret2 = (ret2 * 31) + ((((row + 1) * 11) + ((col + 1) * 17)) * MathUtils.hash(getEntry(row, col)));
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return ret2;
    }
}
