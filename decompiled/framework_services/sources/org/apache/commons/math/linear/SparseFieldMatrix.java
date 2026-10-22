package org.apache.commons.math.linear;

import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.util.OpenIntToFieldHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SparseFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> {
    private static final long serialVersionUID = 9078068119297757342L;
    private final int columns;
    private final OpenIntToFieldHashMap<T> entries;
    private final int rows;

    public SparseFieldMatrix(Field<T> field) {
        super(field);
        this.rows = 0;
        this.columns = 0;
        this.entries = new OpenIntToFieldHashMap(field);
    }

    public SparseFieldMatrix(Field<T> field, int rowDimension, int columnDimension) throws IllegalArgumentException {
        super(field, rowDimension, columnDimension);
        this.rows = rowDimension;
        this.columns = columnDimension;
        this.entries = new OpenIntToFieldHashMap(field);
    }

    public SparseFieldMatrix(SparseFieldMatrix<T> other) {
        super(other.getField(), other.getRowDimension(), other.getColumnDimension());
        this.rows = other.getRowDimension();
        this.columns = other.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap(other.entries);
    }

    public SparseFieldMatrix(FieldMatrix<T> other) {
        super(other.getField(), other.getRowDimension(), other.getColumnDimension());
        this.rows = other.getRowDimension();
        this.columns = other.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap(getField());
        int i = 0;
    L4:
        if (i >= this.rows) goto L11;
        int j = 0;
    L7:
        if (j >= this.columns) goto L9;
        setEntry(i, j, other.getEntry(i, j));
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void addToEntry(int row, int column, T increment) throws MatrixIndexException {
        checkRowIndex(row);
        checkColumnIndex(column);
        int key = computeKey(row, column);
        FieldElement r1 = (FieldElement) this.entries.get(key).add(increment);
        if (getField().getZero().equals(r1) == false) goto L5;
        this.entries.remove(key);
        return;
    L5:
        this.entries.put(key, r1);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        return new SparseFieldMatrix(this);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        return new SparseFieldMatrix(getField(), rowDimension, columnDimension);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T getEntry(int r3, int r4) throws MatrixIndexException {
        checkRowIndex(r3);
        checkColumnIndex(r4);
        return (T) this.entries.get(computeKey(r3, r4));
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void multiplyEntry(int row, int column, T factor) throws MatrixIndexException {
        checkRowIndex(row);
        checkColumnIndex(column);
        int key = computeKey(row, column);
        FieldElement r1 = (FieldElement) this.entries.get(key).multiply(factor);
        if (getField().getZero().equals(r1) == false) goto L5;
        this.entries.remove(key);
        return;
    L5:
        this.entries.put(key, r1);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setEntry(int row, int column, T value) throws MatrixIndexException {
        checkRowIndex(row);
        checkColumnIndex(column);
        if (getField().getZero().equals(value) == false) goto L5;
        this.entries.remove(computeKey(row, column));
        return;
    L5:
        this.entries.put(computeKey(row, column), value);
    }

    private int computeKey(int row, int column) {
        return (this.columns * row) + column;
    }
}
