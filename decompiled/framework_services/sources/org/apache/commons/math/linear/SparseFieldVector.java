package org.apache.commons.math.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.OpenIntToFieldHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SparseFieldVector<T extends FieldElement<T>> implements FieldVector<T>, Serializable {
    private static final long serialVersionUID = 7841233292190413362L;
    private final OpenIntToFieldHashMap<T> entries;
    private final Field<T> field;
    private final int virtualSize;

    public SparseFieldVector(Field<T> field) {
        this(field, 0);
    }

    public SparseFieldVector(Field<T> field, int dimension) {
        this.field = field;
        this.virtualSize = dimension;
        this.entries = new OpenIntToFieldHashMap(field);
    }

    protected SparseFieldVector(SparseFieldVector<T> v, int resize) {
        this.field = v.field;
        this.virtualSize = v.getDimension() + resize;
        this.entries = new OpenIntToFieldHashMap(v.entries);
    }

    public SparseFieldVector(Field<T> field, int dimension, int expectedSize) {
        this.field = field;
        this.virtualSize = dimension;
        this.entries = new OpenIntToFieldHashMap(field, expectedSize);
    }

    public SparseFieldVector(Field<T> field, T[] values) {
        this.field = field;
        this.virtualSize = values.length;
        this.entries = new OpenIntToFieldHashMap(field);
        int key = 0;
    L4:
        if (key >= values.length) goto L7;
        T value = values[key];
        this.entries.put(key, value);
        key = key + 1;
        goto L4
    }

    public SparseFieldVector(SparseFieldVector<T> v) {
        this.field = v.field;
        this.virtualSize = v.getDimension();
        this.entries = new OpenIntToFieldHashMap(v.getEntries());
    }

    private OpenIntToFieldHashMap<T> getEntries() {
        return this.entries;
    }

    public FieldVector<T> add(SparseFieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        SparseFieldVector<T> res = (SparseFieldVector) copy();
        OpenIntToFieldHashMap<T>.Iterator iter = v.getEntries().iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int key = iter.key();
        FieldElement r3 = iter.value();
        if (this.entries.containsKey(key) == true) goto L7;
        res.setEntry(key, r3);
        goto L4
    L7:
        res.setEntry(key, (FieldElement) this.entries.get(key).add(r3));
        goto L4
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> add(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        SparseFieldVector<T> res = new SparseFieldVector(this.field, getDimension());
        int i = 0;
    L4:
        if (i >= v.length) goto L7;
        res.setEntry(i, (FieldElement) v[i].add(getEntry(i)));
        i = i + 1;
        goto L4
    L7:
        return res;
    }

    public FieldVector<T> append(SparseFieldVector<T> v) {
        SparseFieldVector<T> res = new SparseFieldVector(this, v.getDimension());
        OpenIntToFieldHashMap<T>.Iterator iter = v.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key() + this.virtualSize, iter.value());
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> append(FieldVector<T> v) {
        if ((v instanceof SparseFieldVector) == false) goto L7;
        return append((SparseFieldVector) v);
    L7:
        return append(v.toArray());
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> append(T d) {
        FieldVector<T> res = new SparseFieldVector(this, 1);
        res.setEntry(this.virtualSize, d);
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> append(T[] a) {
        FieldVector<T> res = new SparseFieldVector(this, a.length);
        int i = 0;
    L4:
        if (i >= a.length) goto L7;
        res.setEntry(this.virtualSize + i, a[i]);
        i = i + 1;
        goto L4
    L7:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> copy() {
        return new SparseFieldVector(this);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T dotProduct(FieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        T r0 = this.field.getZero();
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        r0 = (T) r0.add((FieldElement) v.getEntry(iter.key()).multiply(iter.value()));
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T dotProduct(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        T r0 = this.field.getZero();
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L9;
        int idx = iter.key();
        T value = this.field.getZero();
        if (idx >= v.length) goto L8;
        value = v[idx];
    L8:
        r0 = (T) r0.add((FieldElement) value.multiply(iter.value()));
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeDivide(FieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        SparseFieldVector<T> res = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), (FieldElement) iter.value().divide(v.getEntry(iter.key())));
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeDivide(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        SparseFieldVector<T> res = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), (FieldElement) iter.value().divide(v[iter.key()]));
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeMultiply(FieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        SparseFieldVector<T> res = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), (FieldElement) iter.value().multiply(v.getEntry(iter.key())));
        goto L4
    L6:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeMultiply(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        SparseFieldVector<T> res = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator iter = res.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        res.setEntry(iter.key(), (FieldElement) iter.value().multiply(v[iter.key()]));
        goto L4
    L6:
        return res;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.FieldVector
    public T[] getData() {
        T[] r0 = (T[]) buildArray(this.virtualSize);
        OpenIntToFieldHashMap<T>.Iterator r1 = this.entries.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.advance();
        r0[r1.key()] = r1.value();
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public int getDimension() {
        return this.virtualSize;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T getEntry(int r2) throws MatrixIndexException {
        checkIndex(r2);
        return (T) this.entries.get(r2);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> getSubVector(int index, int n) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((index + n) - 1);
        SparseFieldVector<T> res = new SparseFieldVector(this.field, n);
        int end = index + n;
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int key = iter.key();
        if (key < index) goto L4;
        if (key >= end) goto L4;
        res.setEntry(key - index, iter.value());
        goto L4
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapAdd(T d) {
        return copy().mapAddToSelf(d);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T d) {
        int i = 0;
    L4:
        if (i >= this.virtualSize) goto L7;
        setEntry(i, (FieldElement) getEntry(i).add(d));
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapDivide(T d) {
        return copy().mapDivideToSelf(d);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T d) {
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        this.entries.put(iter.key(), (FieldElement) iter.value().divide(d));
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapInv() {
        return copy().mapInvToSelf();
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapInvToSelf() {
        int i = 0;
    L4:
        if (i >= this.virtualSize) goto L7;
        setEntry(i, (FieldElement) this.field.getOne().divide(getEntry(i)));
        i = i + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapMultiply(T d) {
        return copy().mapMultiplyToSelf(d);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T d) {
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L6;
        iter.advance();
        this.entries.put(iter.key(), (FieldElement) iter.value().multiply(d));
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapSubtract(T d) {
        return copy().mapSubtractToSelf(d);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T d) {
        return mapAddToSelf((FieldElement) this.field.getZero().subtract(d));
    }

    public FieldMatrix<T> outerProduct(SparseFieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        SparseFieldMatrix<T> res = new SparseFieldMatrix(this.field, this.virtualSize, this.virtualSize);
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        OpenIntToFieldHashMap<T>.Iterator iter2 = v.entries.iterator();
    L7:
        if (iter2.hasNext() == false) goto L4;
        iter2.advance();
        res.setEntry(iter.key(), iter2.key(), (FieldElement) iter.value().multiply(iter2.value()));
        goto L7
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldMatrix<T> outerProduct(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        FieldMatrix<T> res = new SparseFieldMatrix(this.field, this.virtualSize, this.virtualSize);
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int row = iter.key();
        FieldElement<T> value = iter.value();
        int col = 0;
    L7:
        if (col >= this.virtualSize) goto L4;
        res.setEntry(row, col, value.multiply(v[col]));
        col = col + 1;
        goto L7
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldMatrix<T> outerProduct(FieldVector<T> v) throws IllegalArgumentException {
        if ((v instanceof SparseFieldVector) == false) goto L7;
        return outerProduct((SparseFieldVector) v);
    L7:
        return outerProduct(v.toArray());
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> projection(FieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        return v.mapMultiply((FieldElement) dotProduct(v).divide(v.dotProduct(v)));
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> projection(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        return projection(new SparseFieldVector(this.field, v));
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void set(T value) {
        int i = 0;
    L4:
        if (i >= this.virtualSize) goto L7;
        setEntry(i, value);
        i = i + 1;
        goto L4
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void setEntry(int index, T value) throws MatrixIndexException {
        checkIndex(index);
        this.entries.put(index, value);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void setSubVector(int index, FieldVector<T> v) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((v.getDimension() + index) - 1);
        setSubVector(index, v.getData());
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void setSubVector(int index, T[] v) throws MatrixIndexException {
        checkIndex(index);
        checkIndex((v.length + index) - 1);
        int i = 0;
    L4:
        if (i >= v.length) goto L7;
        setEntry(i + index, v[i]);
        i = i + 1;
        goto L4
    }

    public SparseFieldVector<T> subtract(SparseFieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
        SparseFieldVector<T> res = (SparseFieldVector) copy();
        OpenIntToFieldHashMap<T>.Iterator iter = v.getEntries().iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int key = iter.key();
        if (this.entries.containsKey(key) == true) goto L7;
        res.setEntry(key, (FieldElement) this.field.getZero().subtract(iter.value()));
        goto L4
    L7:
        res.setEntry(key, (FieldElement) this.entries.get(key).subtract(iter.value()));
        goto L4
    L10:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> subtract(FieldVector<T> v) throws IllegalArgumentException {
        if ((v instanceof SparseFieldVector) == false) goto L7;
        return subtract((SparseFieldVector) v);
    L7:
        return subtract(v.toArray());
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> subtract(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        SparseFieldVector<T> res = new SparseFieldVector(this);
        int i = 0;
    L4:
        if (i >= v.length) goto L11;
        if (this.entries.containsKey(i) == false) goto L8;
        res.setEntry(i, (FieldElement) this.entries.get(i).subtract(v[i]));
    L9:
        i = i + 1;
        goto L4
    L8:
        res.setEntry(i, (FieldElement) this.field.getZero().subtract(v[i]));
        goto L9
    L11:
        return res;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T[] toArray() {
        return (T[]) getData();
    }

    private void checkIndex(int index) throws MatrixIndexException {
        if (index < 0) goto L7;
        if (index >= getDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(index), 0, Integer.valueOf(getDimension() - 1)});
    }

    protected void checkVectorDimensions(int n) throws IllegalArgumentException {
        if (getDimension() != n) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(getDimension()), Integer.valueOf(n)});
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> add(FieldVector<T> v) throws IllegalArgumentException {
        if ((v instanceof SparseFieldVector) == false) goto L7;
        return add((SparseFieldVector) v);
    L7:
        return add(v.toArray());
    }

    private T[] buildArray(int r2) {
        return (T[]) ((FieldElement[]) Array.newInstance(this.field.getZero().getClass(), r2));
    }

    public int hashCode() {
        int r2 = 1 * 31;
        if (this.field != null) goto L5;
        int r3 = 0;
    L6:
        int result = r2 + r3;
        int result2 = (result * 31) + this.virtualSize;
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L8:
        if (iter.hasNext() == false) goto L10;
        iter.advance();
        int temp = iter.value().hashCode();
        result2 = (result2 * 31) + temp;
        goto L8
    L10:
        return result2;
    L5:
        r3 = this.field.hashCode();
        goto L6
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof SparseFieldVector) == true) goto L8;
        return false;
    L8:
        SparseFieldVector<T> other = (SparseFieldVector) obj;
        if (this.field != null) goto L14;
        if (other.field == null) goto L17;
        return false;
    L17:
        if (this.virtualSize == other.virtualSize) goto L19;
        return false;
    L19:
        OpenIntToFieldHashMap<T>.Iterator iter = this.entries.iterator();
    L21:
        if (iter.hasNext() == false) goto L26;
        iter.advance();
        if (other.getEntry(iter.key()).equals(iter.value()) == true) goto L21;
        return false;
    L26:
        OpenIntToFieldHashMap<T>.Iterator iter2 = other.getEntries().iterator();
    L28:
        if (iter2.hasNext() == false) goto L33;
        iter2.advance();
        if (iter2.value().equals(getEntry(iter2.key())) == true) goto L28;
        return false;
    L33:
        return true;
    L14:
        if (this.field.equals(other.field) == true) goto L17;
        return false;
    }
}
