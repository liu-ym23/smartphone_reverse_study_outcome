package org.apache.commons.math.linear;

import java.io.Serializable;
import org.apache.commons.math.util.OpenIntToDoubleHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class OpenMapRealMatrix extends AbstractRealMatrix implements SparseRealMatrix, Serializable {
    private static final long serialVersionUID = -5962461716457143437L;
    private final int columns;
    private final OpenIntToDoubleHashMap entries;
    private final int rows;

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix add(RealMatrix r1) throws IllegalArgumentException {
        return add(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix copy() {
        return copy();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix createMatrix(int r1, int r2) throws IllegalArgumentException {
        return createMatrix(r1, r2);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix subtract(RealMatrix r1) throws IllegalArgumentException {
        return subtract(r1);
    }

    public OpenMapRealMatrix(int rowDimension, int columnDimension) {
        super(rowDimension, columnDimension);
        this.rows = rowDimension;
        this.columns = columnDimension;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
    }

    public OpenMapRealMatrix(OpenMapRealMatrix matrix) {
        this.rows = matrix.rows;
        this.columns = matrix.columns;
        this.entries = new OpenIntToDoubleHashMap(matrix.entries);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public OpenMapRealMatrix copy() {
        return new OpenMapRealMatrix(this);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public OpenMapRealMatrix createMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        return new OpenMapRealMatrix(rowDimension, columnDimension);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public OpenMapRealMatrix add(RealMatrix m) throws IllegalArgumentException {
        return add((OpenMapRealMatrix) m);
    L6:
        return (OpenMapRealMatrix) super.add(m);
    }

    public OpenMapRealMatrix add(OpenMapRealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkAdditionCompatible(this, m);
        OpenMapRealMatrix out = new OpenMapRealMatrix(this);
        OpenIntToDoubleHashMap.Iterator iterator = m.entries.iterator();
    L4:
        if (iterator.hasNext() == false) goto L7;
        iterator.advance();
        int row = iterator.key() / this.columns;
        int col = iterator.key() - (this.columns * row);
        out.setEntry(row, col, getEntry(row, col) + iterator.value());
        goto L4
    L7:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public OpenMapRealMatrix subtract(RealMatrix m) throws IllegalArgumentException {
        return subtract((OpenMapRealMatrix) m);
    L6:
        return (OpenMapRealMatrix) super.subtract(m);
    }

    public OpenMapRealMatrix subtract(OpenMapRealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkAdditionCompatible(this, m);
        OpenMapRealMatrix out = new OpenMapRealMatrix(this);
        OpenIntToDoubleHashMap.Iterator iterator = m.entries.iterator();
    L4:
        if (iterator.hasNext() == false) goto L7;
        iterator.advance();
        int row = iterator.key() / this.columns;
        int col = iterator.key() - (this.columns * row);
        out.setEntry(row, col, getEntry(row, col) - iterator.value());
        goto L4
    L7:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix multiply(RealMatrix m) throws IllegalArgumentException {
        return multiply((OpenMapRealMatrix) m);
    L5:
        MatrixUtils.checkMultiplicationCompatible(this, m);
        int outCols = m.getColumnDimension();
        BlockRealMatrix out = new BlockRealMatrix(this.rows, outCols);
        OpenIntToDoubleHashMap.Iterator iterator = this.entries.iterator();
    L7:
        if (iterator.hasNext() == false) goto L13;
        iterator.advance();
        double value = iterator.value();
        int key = iterator.key();
        int i = key / this.columns;
        int k = key % this.columns;
        int j = 0;
    L9:
        if (j >= outCols) goto L7;
        out.addToEntry(i, j, m.getEntry(k, j) * value);
        j = j + 1;
        goto L9
    L13:
        return out;
    }

    public OpenMapRealMatrix multiply(OpenMapRealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkMultiplicationCompatible(this, m);
        int outCols = m.getColumnDimension();
        OpenMapRealMatrix out = new OpenMapRealMatrix(this.rows, outCols);
        OpenIntToDoubleHashMap.Iterator iterator = this.entries.iterator();
    L4:
        if (iterator.hasNext() == false) goto L16;
        iterator.advance();
        double value = iterator.value();
        int key = iterator.key();
        int i = key / this.columns;
        int k = key % this.columns;
        int j = 0;
    L6:
        if (j >= outCols) goto L4;
        int rightKey = m.computeKey(k, j);
        if (m.entries.containsKey(rightKey) == false) goto L13;
        int outKey = out.computeKey(i, j);
        double outValue = out.entries.get(outKey) + (m.entries.get(rightKey) * value);
        if (outValue != 0.0d) goto L12;
        out.entries.remove(outKey);
        goto L13
    L12:
        out.entries.put(outKey, outValue);
    L13:
        j = j + 1;
        goto L6
    L16:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double getEntry(int row, int column) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        MatrixUtils.checkColumnIndex(this, column);
        return this.entries.get(computeKey(row, column));
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setEntry(int row, int column, double value) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        MatrixUtils.checkColumnIndex(this, column);
        if (value != 0.0d) goto L5;
        this.entries.remove(computeKey(row, column));
        return;
    L5:
        this.entries.put(computeKey(row, column), value);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void addToEntry(int row, int column, double increment) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        MatrixUtils.checkColumnIndex(this, column);
        int key = computeKey(row, column);
        double value = this.entries.get(key) + increment;
        if (value != 0.0d) goto L5;
        this.entries.remove(key);
        return;
    L5:
        this.entries.put(key, value);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void multiplyEntry(int row, int column, double factor) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        MatrixUtils.checkColumnIndex(this, column);
        int key = computeKey(row, column);
        double value = this.entries.get(key) * factor;
        if (value != 0.0d) goto L5;
        this.entries.remove(key);
        return;
    L5:
        this.entries.put(key, value);
    }

    private int computeKey(int row, int column) {
        return (this.columns * row) + column;
    }
}
