package org.apache.commons.math.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class BigMatrixImpl implements BigMatrix, Serializable {
    static final BigDecimal ONE = null;
    private static final BigDecimal TOO_SMALL = null;
    static final BigDecimal ZERO = null;
    private static final long serialVersionUID = -1011428905656140431L;
    protected BigDecimal[][] data;
    protected BigDecimal[][] lu;
    protected int parity;
    protected int[] permutation;
    private int roundingMode;
    private int scale;

    static {
        ZERO = new BigDecimal(0);
        ONE = new BigDecimal(1);
        TOO_SMALL = new BigDecimal(1.0E-11d);
    }

    public BigMatrixImpl() {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
    }

    public BigMatrixImpl(int rowDimension, int columnDimension) {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
        if (rowDimension < 1) goto L10;
        if (columnDimension < 1) goto L8;
        this.data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowDimension, columnDimension});
        this.lu = null;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(columnDimension), 1});
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(rowDimension), 1});
    }

    public BigMatrixImpl(BigDecimal[][] d) {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
        copyIn(d);
        this.lu = null;
    }

    public BigMatrixImpl(BigDecimal[][] d, boolean copyArray) {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
        if (copyArray == false) goto L5;
        copyIn(d);
    L18:
        this.lu = null;
        return;
    L5:
        if (d == null) goto L25;
        int nRows = d.length;
        if (nRows == 0) goto L23;
        int nCols = d[0].length;
        if (nCols == 0) goto L21;
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
        goto L18
    L21:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    L25:
        throw new NullPointerException();
    }

    public BigMatrixImpl(double[][] d) {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
        int nRows = d.length;
        if (nRows == 0) goto L18;
        int nCols = d[0].length;
        if (nCols == 0) goto L16;
        int row = 1;
    L7:
        if (row >= nRows) goto L13;
        if (d[row].length != nCols) goto L12;
        row = row + 1;
        goto L7
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(nCols), Integer.valueOf(d[row].length)});
    L13:
        copyIn(d);
        this.lu = null;
        return;
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L18:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    public BigMatrixImpl(String[][] d) {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
        int nRows = d.length;
        if (nRows == 0) goto L18;
        int nCols = d[0].length;
        if (nCols == 0) goto L16;
        int row = 1;
    L7:
        if (row >= nRows) goto L13;
        if (d[row].length != nCols) goto L12;
        row = row + 1;
        goto L7
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(nCols), Integer.valueOf(d[row].length)});
    L13:
        copyIn(d);
        this.lu = null;
        return;
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L18:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    public BigMatrixImpl(BigDecimal[] v) {
        this.data = null;
        this.lu = null;
        this.permutation = null;
        this.parity = 1;
        this.roundingMode = 4;
        this.scale = 64;
        int nRows = v.length;
        this.data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, 1});
        int row = 0;
    L3:
        if (row >= nRows) goto L6;
        this.data[row][0] = v[row];
        row = row + 1;
        goto L3
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix copy() {
        return new BigMatrixImpl(copyOut(), false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix add(BigMatrix m) throws IllegalArgumentException {
        return add((BigMatrixImpl) m);
    L5:
        MatrixUtils.checkAdditionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowCount, columnCount});
        int row = 0;
    L6:
        if (row >= rowCount) goto L12;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L8:
        if (col >= columnCount) goto L10;
        outDataRow[col] = dataRow[col].add(m.getEntry(row, col));
        col = col + 1;
        goto L8
    L10:
        row = row + 1;
        goto L6
    L12:
        return new BigMatrixImpl(outData, false);
    }

    public BigMatrixImpl add(BigMatrixImpl m) throws IllegalArgumentException {
        MatrixUtils.checkAdditionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowCount, columnCount});
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] mRow = m.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        outDataRow[col] = dataRow[col].add(mRow[col]);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new BigMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix subtract(BigMatrix m) throws IllegalArgumentException {
        return subtract((BigMatrixImpl) m);
    L5:
        MatrixUtils.checkSubtractionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowCount, columnCount});
        int row = 0;
    L6:
        if (row >= rowCount) goto L12;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L8:
        if (col >= columnCount) goto L10;
        outDataRow[col] = dataRow[col].subtract(getEntry(row, col));
        col = col + 1;
        goto L8
    L10:
        row = row + 1;
        goto L6
    L12:
        return new BigMatrixImpl(outData, false);
    }

    public BigMatrixImpl subtract(BigMatrixImpl m) throws IllegalArgumentException {
        MatrixUtils.checkSubtractionCompatible(this, m);
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowCount, columnCount});
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] mRow = m.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        outDataRow[col] = dataRow[col].subtract(mRow[col]);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new BigMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix scalarAdd(BigDecimal d) {
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowCount, columnCount});
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        outDataRow[col] = dataRow[col].add(d);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new BigMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix scalarMultiply(BigDecimal d) {
        int rowCount = getRowDimension();
        int columnCount = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{rowCount, columnCount});
        int row = 0;
    L3:
        if (row >= rowCount) goto L9;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= columnCount) goto L7;
        outDataRow[col] = dataRow[col].multiply(d);
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new BigMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix multiply(BigMatrix m) throws IllegalArgumentException {
        return multiply((BigMatrixImpl) m);
    L5:
        MatrixUtils.checkMultiplicationCompatible(this, m);
        int nRows = getRowDimension();
        int nCols = m.getColumnDimension();
        int nSum = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, nCols});
        int row = 0;
    L6:
        if (row >= nRows) goto L15;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L8:
        if (col >= nCols) goto L13;
        BigDecimal sum = ZERO;
        int i = 0;
    L10:
        if (i >= nSum) goto L12;
        sum = sum.add(dataRow[i].multiply(m.getEntry(i, col)));
        i = i + 1;
        goto L10
    L12:
        outDataRow[col] = sum;
        col = col + 1;
        goto L8
    L13:
        row = row + 1;
        goto L6
    L15:
        return new BigMatrixImpl(outData, false);
    }

    public BigMatrixImpl multiply(BigMatrixImpl m) throws IllegalArgumentException {
        MatrixUtils.checkMultiplicationCompatible(this, m);
        int nRows = getRowDimension();
        int nCols = m.getColumnDimension();
        int nSum = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, nCols});
        int row = 0;
    L3:
        if (row >= nRows) goto L12;
        BigDecimal[] dataRow = this.data[row];
        BigDecimal[] outDataRow = outData[row];
        int col = 0;
    L5:
        if (col >= nCols) goto L10;
        BigDecimal sum = ZERO;
        int i = 0;
    L7:
        if (i >= nSum) goto L9;
        sum = sum.add(dataRow[i].multiply(m.data[i][col]));
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
        return new BigMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix preMultiply(BigMatrix m) throws IllegalArgumentException {
        return m.multiply(this);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal[][] getData() {
        return copyOut();
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public double[][] getDataAsDoubleArray() {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        double[][] d = (double[][]) Array.newInstance(Double.TYPE, new int[]{nRows, nCols});
        int i = 0;
    L3:
        if (i >= nRows) goto L9;
        int j = 0;
    L5:
        if (j >= nCols) goto L7;
        d[i][j] = this.data[i][j].doubleValue();
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return d;
    }

    public BigDecimal[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public int getRoundingMode() {
        return this.roundingMode;
    }

    public void setRoundingMode(int roundingMode) {
        this.roundingMode = roundingMode;
    }

    public int getScale() {
        return this.scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal getNorm() {
        BigDecimal maxColSum = ZERO;
        int col = 0;
    L4:
        if (col >= getColumnDimension()) goto L11;
        BigDecimal sum = ZERO;
        int row = 0;
    L7:
        if (row >= getRowDimension()) goto L9;
        sum = sum.add(this.data[row][col].abs());
        row = row + 1;
        goto L7
    L9:
        maxColSum = maxColSum.max(sum);
        col = col + 1;
        goto L4
    L11:
        return maxColSum;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, startRow);
        MatrixUtils.checkRowIndex(this, endRow);
        if (startRow > endRow) goto L14;
        MatrixUtils.checkColumnIndex(this, startColumn);
        MatrixUtils.checkColumnIndex(this, endColumn);
        if (startColumn > endColumn) goto L12;
        BigDecimal[][] subMatrixData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{(endRow - startRow) + 1, (endColumn - startColumn) + 1});
        int i = startRow;
    L7:
        if (i > endRow) goto L10;
        System.arraycopy(this.data[i], startColumn, subMatrixData[i - startRow], 0, (endColumn - startColumn) + 1);
        i = i + 1;
        goto L7
    L10:
        return new BigMatrixImpl(subMatrixData, false);
    L12:
        throw new MatrixIndexException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, new Object[]{Integer.valueOf(startColumn), Integer.valueOf(endColumn)});
    L14:
        throw new MatrixIndexException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, new Object[]{Integer.valueOf(startRow), Integer.valueOf(endRow)});
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix getSubMatrix(int[] selectedRows, int[] selectedColumns) throws MatrixIndexException {
        if ((selectedRows.length * selectedColumns.length) == 0) goto L5;
        BigDecimal[][] subMatrixData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{selectedRows.length, selectedColumns.length});
        int i = 0;
    L31:
        if (i >= selectedRows.length) goto L30;
        BigDecimal[] subI = subMatrixData[i];     // Catch: ArrayIndexOutOfBoundsException -> L18
        BigDecimal[] dataSelectedI = this.data[selectedRows[i]];     // Catch: ArrayIndexOutOfBoundsException -> L18
        int j = 0;
    L15:
        if (j >= selectedColumns.length) goto L20;
        subI[j] = dataSelectedI[selectedColumns[j]];     // Catch: ArrayIndexOutOfBoundsException -> L18
        j = j + 1;
        goto L15
    L20:
        i = i + 1;
    L30:
        return new BigMatrixImpl(subMatrixData, false);
    L22:
        int r3 = selectedRows.length;
        int r4 = 0;
    L23:
        if (r4 >= r3) goto L25;
        int row = selectedRows[r4];
        MatrixUtils.checkRowIndex(this, row);
        r4 = r4 + 1;
        goto L23
    L25:
        int r5 = selectedColumns.length;
        int r6 = 0;
    L27:
        if (r6 >= r5) goto L30;
        int column = selectedColumns[r6];
        MatrixUtils.checkColumnIndex(this, column);
        r6 = r6 + 1;
        goto L27
    L5:
        if (selectedRows.length != 0) goto L9;
        throw new MatrixIndexException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY, new Object[0]);
    L9:
        throw new MatrixIndexException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY, new Object[0]);
    }

    public void setSubMatrix(BigDecimal[][] subMatrix, int row, int column) throws MatrixIndexException {
        int nRows = subMatrix.length;
        if (nRows == 0) goto L31;
        int nCols = subMatrix[0].length;
        if (nCols == 0) goto L29;
        int r = 1;
    L7:
        if (r >= nRows) goto L14;
        if (subMatrix[r].length != nCols) goto L12;
        r = r + 1;
        goto L7
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(nCols), Integer.valueOf(subMatrix[r].length)});
    L14:
        if (this.data != null) goto L22;
        if (row > 0) goto L21;
        if (column > 0) goto L19;
        this.data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, nCols});
        System.arraycopy(subMatrix, 0, this.data, 0, subMatrix.length);
    L23:
        int i = 0;
    L24:
        if (i >= nRows) goto L26;
        System.arraycopy(subMatrix[i], 0, this.data[row + i], column, nCols);
        i = i + 1;
        goto L24
    L26:
        this.lu = null;
        return;
    L19:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(column)});
    L21:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(row)});
    L22:
        MatrixUtils.checkRowIndex(this, row);
        MatrixUtils.checkColumnIndex(this, column);
        MatrixUtils.checkRowIndex(this, (nRows + row) - 1);
        MatrixUtils.checkColumnIndex(this, (nCols + column) - 1);
        goto L23
    L29:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    L31:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix getRowMatrix(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        int ncols = getColumnDimension();
        BigDecimal[][] out = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{1, ncols});
        System.arraycopy(this.data[row], 0, out[0], 0, ncols);
        return new BigMatrixImpl(out, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix getColumnMatrix(int column) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, column);
        int nRows = getRowDimension();
        BigDecimal[][] out = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, 1});
        int row = 0;
    L3:
        if (row >= nRows) goto L6;
        out[row][0] = this.data[row][column];
        row = row + 1;
        goto L3
    L6:
        return new BigMatrixImpl(out, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal[] getRow(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        int ncols = getColumnDimension();
        BigDecimal[] out = new BigDecimal[ncols];
        System.arraycopy(this.data[row], 0, out, 0, ncols);
        return out;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public double[] getRowAsDoubleArray(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        int ncols = getColumnDimension();
        double[] out = new double[ncols];
        int i = 0;
    L3:
        if (i >= ncols) goto L6;
        out[i] = this.data[row][i].doubleValue();
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal[] getColumn(int col) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, col);
        int nRows = getRowDimension();
        BigDecimal[] out = new BigDecimal[nRows];
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        out[i] = this.data[i][col];
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public double[] getColumnAsDoubleArray(int col) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, col);
        int nrows = getRowDimension();
        double[] out = new double[nrows];
        int i = 0;
    L3:
        if (i >= nrows) goto L6;
        out[i] = this.data[i][col].doubleValue();
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal getEntry(int row, int column) throws MatrixIndexException {
        return this.data[row][column];
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public double getEntryAsDouble(int row, int column) throws MatrixIndexException {
        return getEntry(row, column).doubleValue();
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix transpose() {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        BigDecimal[][] outData = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nCols, nRows});
        int row = 0;
    L3:
        if (row >= nRows) goto L9;
        BigDecimal[] dataRow = this.data[row];
        int col = 0;
    L5:
        if (col >= nCols) goto L7;
        outData[col][row] = dataRow[col];
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return new BigMatrixImpl(outData, false);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix inverse() throws InvalidMatrixException {
        return solve(MatrixUtils.createBigIdentityMatrix(getRowDimension()));
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal getDeterminant() throws InvalidMatrixException {
        if (isSquare() == false) goto L19;
        if (isSingular() == false) goto L9;
        return ZERO;
    L9:
        if (this.parity != 1) goto L11;
        BigDecimal det = ONE;
    L12:
        int i = 0;
    L14:
        if (i >= getRowDimension()) goto L17;
        det = det.multiply(this.lu[i][i]);
        i = i + 1;
        goto L14
    L17:
        return det;
    L11:
        det = ONE.negate();
        goto L12
    L19:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    }

    @Override // org.apache.commons.math.linear.AnyMatrix
    public boolean isSquare() {
        if (getColumnDimension() != getRowDimension()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSingular() {
        if (this.lu == null) goto L10;
        return false;
    L10:
        luDecompose();     // Catch: InvalidMatrixException -> L6
        return false;
    L7:
        return true;
    }

    @Override // org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        return this.data[0].length;
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal getTrace() throws IllegalArgumentException {
        if (isSquare() == false) goto L11;
        BigDecimal trace = this.data[0][0];
        int i = 1;
    L6:
        if (i >= getRowDimension()) goto L9;
        trace = trace.add(this.data[i][i]);
        i = i + 1;
        goto L6
    L9:
        return trace;
    L11:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal[] operate(BigDecimal[] v) throws IllegalArgumentException {
        if (v.length != getColumnDimension()) goto L13;
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        BigDecimal[] out = new BigDecimal[nRows];
        int row = 0;
    L5:
        if (row >= nRows) goto L11;
        BigDecimal sum = ZERO;
        int i = 0;
    L7:
        if (i >= nCols) goto L9;
        sum = sum.add(this.data[row][i].multiply(v[i]));
        i = i + 1;
        goto L7
    L9:
        out[row] = sum;
        row = row + 1;
        goto L5
    L11:
        return out;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.length), Integer.valueOf(getColumnDimension())});
    }

    public BigDecimal[] operate(double[] v) throws IllegalArgumentException {
        BigDecimal[] bd = new BigDecimal[v.length];
        int i = 0;
    L4:
        if (i >= bd.length) goto L7;
        bd[i] = new BigDecimal(v[i]);
        i = i + 1;
        goto L4
    L7:
        return operate(bd);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal[] preMultiply(BigDecimal[] v) throws IllegalArgumentException {
        int nRows = getRowDimension();
        if (v.length != nRows) goto L13;
        int nCols = getColumnDimension();
        BigDecimal[] out = new BigDecimal[nCols];
        int col = 0;
    L5:
        if (col >= nCols) goto L11;
        BigDecimal sum = ZERO;
        int i = 0;
    L7:
        if (i >= nRows) goto L9;
        sum = sum.add(this.data[i][col].multiply(v[i]));
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

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigDecimal[] solve(BigDecimal[] b) throws IllegalArgumentException, InvalidMatrixException {
        int nRows = getRowDimension();
        if (b.length != nRows) goto L10;
        BigMatrix bMatrix = new BigMatrixImpl(b);
        BigDecimal[][] solution = ((BigMatrixImpl) solve(bMatrix)).getDataRef();
        BigDecimal[] out = new BigDecimal[nRows];
        int row = 0;
    L5:
        if (row >= nRows) goto L8;
        out[row] = solution[row][0];
        row = row + 1;
        goto L5
    L8:
        return out;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(b.length), Integer.valueOf(nRows)});
    }

    public BigDecimal[] solve(double[] b) throws IllegalArgumentException, InvalidMatrixException {
        BigDecimal[] bd = new BigDecimal[b.length];
        int i = 0;
    L4:
        if (i >= bd.length) goto L7;
        bd[i] = new BigDecimal(b[i]);
        i = i + 1;
        goto L4
    L7:
        return solve(bd);
    }

    @Override // org.apache.commons.math.linear.BigMatrix
    public BigMatrix solve(BigMatrix b) throws IllegalArgumentException, InvalidMatrixException {
        if (b.getRowDimension() != getRowDimension()) goto L42;
        if (isSquare() == false) goto L40;
        if (isSingular() == true) goto L38;
        int nCol = getColumnDimension();
        int nColB = b.getColumnDimension();
        int nRowB = b.getRowDimension();
        BigDecimal[][] bp = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRowB, nColB});
        int row = 0;
    L9:
        if (row >= nRowB) goto L14;
        BigDecimal[] bpRow = bp[row];
        int col = 0;
    L11:
        if (col >= nColB) goto L13;
        bpRow[col] = b.getEntry(this.permutation[row], col);
        col = col + 1;
        goto L11
    L13:
        row = row + 1;
        goto L9
    L14:
        int col2 = 0;
    L15:
        if (col2 >= nCol) goto L23;
        int i = col2 + 1;
    L17:
        if (i >= nCol) goto L22;
        BigDecimal[] bpI = bp[i];
        BigDecimal[] luI = this.lu[i];
        int j = 0;
    L19:
        if (j >= nColB) goto L21;
        bpI[j] = bpI[j].subtract(bp[col2][j].multiply(luI[col2]));
        j = j + 1;
        goto L19
    L21:
        i = i + 1;
        goto L17
    L22:
        col2 = col2 + 1;
        goto L15
    L23:
        int col3 = nCol - 1;
    L24:
        if (col3 < 0) goto L36;
        BigDecimal[] bpCol = bp[col3];
        BigDecimal luDiag = this.lu[col3][col3];
        int j2 = 0;
    L26:
        if (j2 >= nColB) goto L28;
        bpCol[j2] = bpCol[j2].divide(luDiag, this.scale, this.roundingMode);
        j2 = j2 + 1;
        goto L26
    L28:
        int i2 = 0;
    L29:
        if (i2 >= col3) goto L34;
        BigDecimal[] bpI2 = bp[i2];
        BigDecimal[] luI2 = this.lu[i2];
        int j3 = 0;
    L31:
        if (j3 >= nColB) goto L33;
        bpI2[j3] = bpI2[j3].subtract(bp[col3][j3].multiply(luI2[col3]));
        j3 = j3 + 1;
        goto L31
    L33:
        i2 = i2 + 1;
        goto L29
    L34:
        col3 = col3 - 1;
        goto L24
    L36:
        return new BigMatrixImpl(bp, false);
    L38:
        throw new SingularMatrixException();
    L40:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    L42:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(getRowDimension()), "n"});
    }

    public void luDecompose() throws InvalidMatrixException {
        int nRows = getRowDimension();
        int nCols = getColumnDimension();
        if (nRows != nCols) goto L40;
        this.lu = getData();
        this.permutation = new int[nRows];
        int row = 0;
    L5:
        if (row >= nRows) goto L7;
        this.permutation[row] = row;
        row = row + 1;
        goto L5
    L7:
        this.parity = 1;
        int col = 0;
    L8:
        if (col >= nCols) goto L38;
        BigDecimal r4 = ZERO;
        int row2 = 0;
    L10:
        if (row2 >= col) goto L15;
        BigDecimal[] luRow = this.lu[row2];
        BigDecimal sum = luRow[col];
        int i = 0;
    L12:
        if (i >= row2) goto L14;
        sum = sum.subtract(luRow[i].multiply(this.lu[i][col]));
        i = i + 1;
        goto L12
    L14:
        luRow[col] = sum;
        row2 = row2 + 1;
        goto L10
    L15:
        int max = col;
        BigDecimal largest = ZERO;
        int row3 = col;
    L16:
        if (row3 >= nRows) goto L25;
        BigDecimal[] luRow2 = this.lu[row3];
        BigDecimal sum2 = luRow2[col];
        int i2 = 0;
    L18:
        if (i2 >= col) goto L20;
        sum2 = sum2.subtract(luRow2[i2].multiply(this.lu[i2][col]));
        i2 = i2 + 1;
        goto L18
    L20:
        luRow2[col] = sum2;
        if (sum2.abs().compareTo(largest) != 1) goto L23;
        largest = sum2.abs();
        max = row3;
    L23:
        row3 = row3 + 1;
        goto L16
    L25:
        if (this.lu[max][col].abs().compareTo(TOO_SMALL) <= 0) goto L35;
        if (max == col) goto L31;
        BigDecimal r7 = ZERO;
        int i3 = 0;
    L28:
        if (i3 >= nCols) goto L30;
        BigDecimal tmp = this.lu[max][i3];
        this.lu[max][i3] = this.lu[col][i3];
        this.lu[col][i3] = tmp;
        i3 = i3 + 1;
        goto L28
    L30:
        int temp = this.permutation[max];
        this.permutation[max] = this.permutation[col];
        this.permutation[col] = temp;
        this.parity = -this.parity;
    L31:
        BigDecimal luDiag = this.lu[col][col];
        int row4 = col + 1;
    L32:
        if (row4 >= nRows) goto L34;
        BigDecimal[] luRow3 = this.lu[row4];
        luRow3[col] = luRow3[col].divide(luDiag, this.scale, this.roundingMode);
        row4 = row4 + 1;
        goto L32
    L34:
        col = col + 1;
        goto L8
    L35:
        this.lu = null;
        throw new SingularMatrixException();
    L38:
        return;
    L40:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("BigMatrixImpl{");
        if (this.data == null) goto L17;
        int i = 0;
    L6:
        if (i >= this.data.length) goto L17;
        if (i <= 0) goto L10;
        res.append(",");
    L10:
        res.append("{");
        int j = 0;
    L12:
        if (j >= this.data[0].length) goto L16;
        if (j <= 0) goto L15;
        res.append(",");
    L15:
        res.append(this.data[i][j]);
        j = j + 1;
        goto L12
    L16:
        res.append("}");
        i = i + 1;
    L17:
        res.append("}");
        return res.toString();
    }

    public boolean equals(Object object) {
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof BigMatrixImpl) == true) goto L8;
        return false;
    L8:
        BigMatrix m = (BigMatrix) object;
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
        BigDecimal[] dataRow = this.data[row];
        int col = 0;
    L16:
        if (col >= nCols) goto L21;
        if (dataRow[col].equals(m.getEntry(row, col)) == false) goto L19;
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
        BigDecimal[] dataRow = this.data[row];
        int col = 0;
    L5:
        if (col >= nCols) goto L7;
        ret2 = (ret2 * 31) + ((((row + 1) * 11) + ((col + 1) * 17)) * dataRow[col].hashCode());
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L9:
        return ret2;
    }

    protected BigMatrix getLUMatrix() throws InvalidMatrixException {
        if (this.lu != null) goto L6;
        luDecompose();
    L6:
        return new BigMatrixImpl(this.lu);
    }

    protected int[] getPermutation() {
        int[] out = new int[this.permutation.length];
        System.arraycopy(this.permutation, 0, out, 0, this.permutation.length);
        return out;
    }

    private BigDecimal[][] copyOut() {
        int nRows = getRowDimension();
        BigDecimal[][] out = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, getColumnDimension()});
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        System.arraycopy(this.data[i], 0, out[i], 0, this.data[i].length);
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    private void copyIn(BigDecimal[][] in) {
        setSubMatrix(in, 0, 0);
    }

    private void copyIn(double[][] in) {
        int nRows = in.length;
        int nCols = in[0].length;
        this.data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, nCols});
        int i = 0;
    L3:
        if (i >= nRows) goto L8;
        BigDecimal[] dataI = this.data[i];
        double[] inI = in[i];
        int j = 0;
    L5:
        if (j >= nCols) goto L7;
        dataI[j] = new BigDecimal(inI[j]);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L8:
        this.lu = null;
    }

    private void copyIn(String[][] in) {
        int nRows = in.length;
        int nCols = in[0].length;
        this.data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, nCols});
        int i = 0;
    L3:
        if (i >= nRows) goto L8;
        BigDecimal[] dataI = this.data[i];
        String[] inI = in[i];
        int j = 0;
    L5:
        if (j >= nCols) goto L7;
        dataI[j] = new BigDecimal(inI[j]);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L8:
        this.lu = null;
    }
}
