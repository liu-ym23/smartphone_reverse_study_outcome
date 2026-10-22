package org.apache.commons.math.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class RealMatrixImpl extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = -1067294169172445528L;
    protected double[][] data;

    public RealMatrixImpl() {
    }

    public RealMatrixImpl(int rowDimension, int columnDimension) throws IllegalArgumentException {
        super(rowDimension, columnDimension);
        this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{rowDimension, columnDimension});
    }

    public RealMatrixImpl(double[][] d) throws IllegalArgumentException, NullPointerException {
        copyIn(d);
    }

    public RealMatrixImpl(double[][] d, boolean copyArray) throws IllegalArgumentException, NullPointerException {
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

    public RealMatrixImpl(double[] v) {
        int nRows = v.length;
        this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRows, 1});
        int row = 0;
    L3:
        if (row >= nRows) goto L6;
        this.data[row][0] = v[row];
        row = row + 1;
        goto L3
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix createMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        return new RealMatrixImpl(rowDimension, columnDimension);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix copy() {
        return new RealMatrixImpl(copyOut(), false);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix add(RealMatrix m) throws IllegalArgumentException {
        return add((RealMatrixImpl) m);
    L6:
        return super.add(m);
    }

    public RealMatrixImpl add(RealMatrixImpl m) throws IllegalArgumentException {
        MatrixUtils.checkAdditionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        double[][] outData = (double[][]) Array.newInstance(Double.TYPE, new int[]{rowCount, columnCount});
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        double[] dataRow = this.data[row];
        double[] mRow = m.data[row];
        double[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        outDataRow[col] = dataRow[col] + mRow[col];
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new RealMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix subtract(RealMatrix m) throws IllegalArgumentException {
        return subtract((RealMatrixImpl) m);
    L6:
        return super.subtract(m);
    }

    public RealMatrixImpl subtract(RealMatrixImpl m) throws IllegalArgumentException {
        MatrixUtils.checkSubtractionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        double[][] outData = (double[][]) Array.newInstance(Double.TYPE, new int[]{rowCount, columnCount});
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        double[] dataRow = this.data[row];
        double[] mRow = m.data[row];
        double[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        outDataRow[col] = dataRow[col] - mRow[col];
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new RealMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix multiply(RealMatrix m) throws IllegalArgumentException {
        return multiply((RealMatrixImpl) m);
    L6:
        return super.multiply(m);
    }

    public RealMatrixImpl multiply(RealMatrixImpl m) throws IllegalArgumentException {
        MatrixUtils.checkMultiplicationCompatible(this, m);
        int nRows = getRowDimension();
        int nCols = m.getColumnDimension();
        int nSum = getColumnDimension();
        double[][] outData = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRows, nCols});
        int row = 0;
    L3:
        if (row >= nRows) goto L12;
        double[] dataRow = this.data[row];
        double[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= nCols) goto L10;
        double sum = 0.0d;
        int i = 0;
    L7:
        if (i >= nSum) goto L9;
        sum = sum + (dataRow[i] * m.data[i][col]);
        i = i + 1;
        goto L7
    L9:
        outDataRow[col] = sum;
        col = col + 1;
        goto L5
    L10:
        row = row + 1;
        goto L3
    L12:
        return new RealMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[][] getData() {
        return copyOut();
    }

    public double[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setSubMatrix(double[][] subMatrix, int row, int column) throws MatrixIndexException {
        if (this.data != null) goto L27;
        if (row > 0) goto L26;
        if (column > 0) goto L24;
        int nRows = subMatrix.length;
        if (nRows == 0) goto L22;
        int nCols = subMatrix[0].length;
        if (nCols == 0) goto L20;
        this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{subMatrix.length, nCols});
        int i = 0;
    L12:
        if (i >= this.data.length) goto L31;
        if (subMatrix[i].length != nCols) goto L17;
        System.arraycopy(subMatrix[i], 0, this.data[i + row], column, nCols);
        i = i + 1;
        goto L12
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(nCols), Integer.valueOf(subMatrix[i].length)});
    L31:
        return;
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    L24:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(column)});
    L26:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(row)});
    L27:
        super.setSubMatrix(subMatrix, row, column);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double getEntry(int row, int column) throws MatrixIndexException {
        return this.data[row][column];
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setEntry(int row, int column, double value) throws MatrixIndexException {
        this.data[row][column] = value;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void addToEntry(int row, int column, double increment) throws MatrixIndexException {
        double[] r0 = this.data[row];     // Catch: ArrayIndexOutOfBoundsException -> L4
        r0[column] = r0[column] + increment;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void multiplyEntry(int row, int column, double factor) throws MatrixIndexException {
        double[] r0 = this.data[row];     // Catch: ArrayIndexOutOfBoundsException -> L4
        r0[column] = r0[column] * factor;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        if (this.data != null) goto L6;
        return 0;
    L6:
        return this.data.length;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        if (this.data != null) goto L5;
        return 0;
    L5:
        if (this.data[0] != null) goto L8;
        return 0;
    L8:
        return this.data[0].length;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[] operate(double[] v) throws IllegalArgumentException {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (v.length != nCols) goto L13;
        double[] out = new double[nRows];
        int row = 0;
    L5:
        if (row >= nRows) goto L11;
        double[] dataRow = this.data[row];
        double sum = 0.0d;
        int i = 0;
    L7:
        if (i >= nCols) goto L9;
        sum = sum + (dataRow[i] * v[i]);
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

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
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
        sum = sum + (this.data[i][col] * v[i]);
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

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int i = 0;
    L3:
        if (i >= rows) goto L9;
        double[] rowI = this.data[i];
        int j = 0;
    L5:
        if (j >= columns) goto L7;
        rowI[j] = visitor.visit(i, j, rowI[j]);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int i = 0;
    L3:
        if (i >= rows) goto L9;
        double[] rowI = this.data[i];
        int j = 0;
    L5:
        if (j >= columns) goto L7;
        visitor.visit(i, j, rowI[j]);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int i = startRow;
    L3:
        if (i > endRow) goto L9;
        double[] rowI = this.data[i];
        int j = startColumn;
    L5:
        if (j > endColumn) goto L7;
        rowI[j] = visitor.visit(i, j, rowI[j]);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int i = startRow;
    L3:
        if (i > endRow) goto L9;
        double[] rowI = this.data[i];
        int j = startColumn;
    L5:
        if (j > endColumn) goto L7;
        visitor.visit(i, j, rowI[j]);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int j = 0;
    L3:
        if (j >= columns) goto L9;
        int i = 0;
    L5:
        if (i >= rows) goto L7;
        double[] rowI = this.data[i];
        rowI[j] = visitor.visit(i, j, rowI[j]);
        i = i + 1;
        goto L5
    L7:
        j = j + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        int rows = getRowDimension();
        int columns = getColumnDimension();
        visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
        int j = 0;
    L3:
        if (j >= columns) goto L9;
        int i = 0;
    L5:
        if (i >= rows) goto L7;
        visitor.visit(i, j, this.data[i][j]);
        i = i + 1;
        goto L5
    L7:
        j = j + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int j = startColumn;
    L3:
        if (j > endColumn) goto L9;
        int i = startRow;
    L5:
        if (i > endRow) goto L7;
        double[] rowI = this.data[i];
        rowI[j] = visitor.visit(i, j, rowI[j]);
        i = i + 1;
        goto L5
    L7:
        j = j + 1;
        goto L3
    L9:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
        int j = startColumn;
    L3:
        if (j > endColumn) goto L9;
        int i = startRow;
    L5:
        if (i > endRow) goto L7;
        visitor.visit(i, j, this.data[i][j]);
        i = i + 1;
        goto L5
    L7:
        j = j + 1;
        goto L3
    L9:
        return visitor.end();
    }

    private double[][] copyOut() {
        int nRows = getRowDimension();
        double[][] out = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRows, getColumnDimension()});
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        System.arraycopy(this.data[i], 0, out[i], 0, this.data[i].length);
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    private void copyIn(double[][] in) {
        setSubMatrix(in, 0, 0);
    }
}
