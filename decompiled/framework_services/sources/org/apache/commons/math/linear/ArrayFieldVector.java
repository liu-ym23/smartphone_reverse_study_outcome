package org.apache.commons.math.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayFieldVector<T extends FieldElement<T>> implements FieldVector<T>, Serializable {
    private static final long serialVersionUID = 7648186910365927050L;
    protected T[] data;
    private final Field<T> field;

    public ArrayFieldVector(Field<T> field) {
        this(field, 0);
    }

    public ArrayFieldVector(Field<T> r3, int r4) {
        this.field = r3;
        this.data = (T[]) buildArray(r4);
        Arrays.fill(this.data, r3.getZero());
    }

    public ArrayFieldVector(int size, T preset) {
        this(preset.getField(), size);
        Arrays.fill(this.data, preset);
    }

    public ArrayFieldVector(T[] r4) throws IllegalArgumentException {
        this.field = r4[0].getField();     // Catch: ArrayIndexOutOfBoundsException -> L5
        this.data = (T[]) ((FieldElement[]) r4.clone());     // Catch: ArrayIndexOutOfBoundsException -> L5
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> r2, T[] r3) {
        this.field = r2;
        this.data = (T[]) ((FieldElement[]) r3.clone());
    }

    public ArrayFieldVector(T[] r3, boolean r4) throws NullPointerException, IllegalArgumentException {
        if (r3.length == 0) goto L11;
        this.field = r3[0].getField();
        if (r4 == false) goto L7;
        T[] r0 = (T[]) ((FieldElement[]) r3.clone());
    L8:
        this.data = r0;
        return;
    L7:
        r0 = r3;
        goto L8
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> r2, T[] r3, boolean r4) {
        this.field = r2;
        if (r4 == false) goto L5;
        T[] r0 = (T[]) ((FieldElement[]) r3.clone());
    L6:
        this.data = r0;
        return;
    L5:
        r0 = r3;
        goto L6
    }

    public ArrayFieldVector(T[] r5, int r6, int r7) {
        if (r5.length < (r6 + r7)) goto L7;
        this.field = r5[0].getField();
        this.data = (T[]) buildArray(r7);
        System.arraycopy(r5, r6, this.data, 0, r7);
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.POSITION_SIZE_MISMATCH_INPUT_ARRAY, new Object[]{Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r5.length)});
    }

    public ArrayFieldVector(FieldVector<T> r4) {
        this.field = r4.getField();
        this.data = (T[]) buildArray(r4.getDimension());
        int r0 = 0;
    L4:
        if (r0 >= this.data.length) goto L7;
        ((T[]) this.data)[r0] = r4.getEntry(r0);
        r0 = r0 + 1;
        goto L4
    }

    public ArrayFieldVector(ArrayFieldVector<T> r2) {
        this.field = r2.getField();
        this.data = (T[]) ((FieldElement[]) r2.data.clone());
    }

    public ArrayFieldVector(ArrayFieldVector<T> r2, boolean r3) {
        this.field = r2.getField();
        T[] r0 = r2.data;
        if (r3 == false) goto L5;
        r0 = (T[]) ((FieldElement[]) r0.clone());
    L5:
        this.data = r0;
    }

    public ArrayFieldVector(ArrayFieldVector<T> r6, ArrayFieldVector<T> r7) {
        this.field = r6.getField();
        this.data = (T[]) buildArray(r6.data.length + r7.data.length);
        System.arraycopy(r6.data, 0, this.data, 0, r6.data.length);
        System.arraycopy(r7.data, 0, this.data, r6.data.length, r7.data.length);
    }

    public ArrayFieldVector(ArrayFieldVector<T> r5, T[] r6) {
        this.field = r5.getField();
        this.data = (T[]) buildArray(r5.data.length + r6.length);
        System.arraycopy(r5.data, 0, this.data, 0, r5.data.length);
        System.arraycopy(r6, 0, this.data, r5.data.length, r6.length);
    }

    public ArrayFieldVector(T[] r6, ArrayFieldVector<T> r7) {
        this.field = r7.getField();
        this.data = (T[]) buildArray(r6.length + r7.data.length);
        System.arraycopy(r6, 0, this.data, 0, r6.length);
        System.arraycopy(r7.data, 0, this.data, r6.length, r7.data.length);
    }

    public ArrayFieldVector(T[] r5, T[] r6) {
        this.data = (T[]) buildArray(r5.length + r6.length);     // Catch: ArrayIndexOutOfBoundsException -> L5
        System.arraycopy(r5, 0, this.data, 0, r5.length);     // Catch: ArrayIndexOutOfBoundsException -> L5
        System.arraycopy(r6, 0, this.data, r5.length, r6.length);     // Catch: ArrayIndexOutOfBoundsException -> L5
        this.field = this.data[0].getField();     // Catch: ArrayIndexOutOfBoundsException -> L5
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> r5, T[] r6, T[] r7) {
        if ((r6.length + r7.length) == 0) goto L7;
        this.data = (T[]) buildArray(r6.length + r7.length);
        System.arraycopy(r6, 0, this.data, 0, r6.length);
        System.arraycopy(r7, 0, this.data, r6.length, r7.length);
        this.field = this.data[0].getField();
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    private T[] buildArray(int r2) {
        return (T[]) ((FieldElement[]) Array.newInstance(this.field.getZero().getClass(), r2));
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> copy() {
        return new ArrayFieldVector(this, true);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> add(FieldVector<T> v) throws IllegalArgumentException {
        return add((ArrayFieldVector) v);
    L5:
        checkVectorDimensions(v);
        FieldElement[] r1 = buildArray(this.data.length);
        int i = 0;
    L7:
        if (i >= this.data.length) goto L10;
        r1[i] = (FieldElement) this.data[i].add(v.getEntry(i));
        i = i + 1;
        goto L7
    L10:
        return new ArrayFieldVector(r1);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> add(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].add(v[i]);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    public ArrayFieldVector<T> add(ArrayFieldVector<T> v) throws IllegalArgumentException {
        return (ArrayFieldVector) add(v.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> subtract(FieldVector<T> v) throws IllegalArgumentException {
        return subtract((ArrayFieldVector) v);
    L5:
        checkVectorDimensions(v);
        FieldElement[] r1 = buildArray(this.data.length);
        int i = 0;
    L7:
        if (i >= this.data.length) goto L10;
        r1[i] = (FieldElement) this.data[i].subtract(v.getEntry(i));
        i = i + 1;
        goto L7
    L10:
        return new ArrayFieldVector(r1);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> subtract(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].subtract(v[i]);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    public ArrayFieldVector<T> subtract(ArrayFieldVector<T> v) throws IllegalArgumentException {
        return (ArrayFieldVector) subtract(v.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapAdd(T d) {
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].add(d);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.data.length) goto L7;
        ((T[]) this.data)[r0] = (FieldElement) this.data[r0].add(r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapSubtract(T d) {
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].subtract(d);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.data.length) goto L7;
        ((T[]) this.data)[r0] = (FieldElement) this.data[r0].subtract(r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapMultiply(T d) {
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].multiply(d);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.data.length) goto L7;
        ((T[]) this.data)[r0] = (FieldElement) this.data[r0].multiply(r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapDivide(T d) {
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].divide(d);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.data.length) goto L7;
        ((T[]) this.data)[r0] = (FieldElement) this.data[r0].divide(r4);
        r0 = r0 + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapInv() {
        FieldElement[] r0 = buildArray(this.data.length);
        T one = this.field.getOne();
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) one.divide(this.data[i]);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> mapInvToSelf() {
        T r0 = this.field.getOne();
        int r1 = 0;
    L4:
        if (r1 >= this.data.length) goto L7;
        ((T[]) this.data)[r1] = (FieldElement) r0.divide(this.data[r1]);
        r1 = r1 + 1;
        goto L4
    L7:
        return this;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeMultiply(FieldVector<T> v) throws IllegalArgumentException {
        return ebeMultiply((ArrayFieldVector) v);
    L5:
        checkVectorDimensions(v);
        FieldElement[] r1 = buildArray(this.data.length);
        int i = 0;
    L7:
        if (i >= this.data.length) goto L10;
        r1[i] = (FieldElement) this.data[i].multiply(v.getEntry(i));
        i = i + 1;
        goto L7
    L10:
        return new ArrayFieldVector(r1);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeMultiply(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].multiply(v[i]);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    public ArrayFieldVector<T> ebeMultiply(ArrayFieldVector<T> v) throws IllegalArgumentException {
        return (ArrayFieldVector) ebeMultiply(v.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeDivide(FieldVector<T> v) throws IllegalArgumentException {
        return ebeDivide((ArrayFieldVector) v);
    L5:
        checkVectorDimensions(v);
        FieldElement[] r1 = buildArray(this.data.length);
        int i = 0;
    L7:
        if (i >= this.data.length) goto L10;
        r1[i] = (FieldElement) this.data[i].divide(v.getEntry(i));
        i = i + 1;
        goto L7
    L10:
        return new ArrayFieldVector(r1);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> ebeDivide(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        FieldElement[] r0 = buildArray(this.data.length);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0[i] = (FieldElement) this.data[i].divide(v[i]);
        i = i + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0);
    }

    public ArrayFieldVector<T> ebeDivide(ArrayFieldVector<T> v) throws IllegalArgumentException {
        return (ArrayFieldVector) ebeDivide(v.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T[] getData() {
        return (T[]) ((FieldElement[]) this.data.clone());
    }

    public T[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T dotProduct(FieldVector<T> r6) throws IllegalArgumentException {
        return (T) dotProduct((ArrayFieldVector) r6);
    L5:
        checkVectorDimensions(r6);
        T r1 = this.field.getZero();
        int r2 = 0;
    L7:
        if (r2 >= this.data.length) goto L10;
        r1 = (T) r1.add((FieldElement) this.data[r2].multiply(r6.getEntry(r2)));
        r2 = r2 + 1;
        goto L7
    L10:
        return r1;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T dotProduct(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        T r0 = this.field.getZero();
        int i = 0;
    L4:
        if (i >= this.data.length) goto L7;
        r0 = (T) r0.add((FieldElement) this.data[i].multiply(v[i]));
        i = i + 1;
        goto L4
    L7:
        return r0;
    }

    public T dotProduct(ArrayFieldVector<T> r2) throws IllegalArgumentException {
        return (T) dotProduct(r2.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> projection(FieldVector<T> v) {
        return v.mapMultiply((FieldElement) dotProduct(v).divide(v.dotProduct(v)));
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> projection(T[] v) {
        return projection(new ArrayFieldVector(v, false));
    }

    public ArrayFieldVector<T> projection(ArrayFieldVector<T> v) {
        return (ArrayFieldVector) v.mapMultiply((FieldElement) dotProduct(v).divide(v.dotProduct(v)));
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldMatrix<T> outerProduct(FieldVector<T> v) throws IllegalArgumentException {
        return outerProduct((ArrayFieldVector) v);
    L5:
        checkVectorDimensions(v);
        int m = this.data.length;
        FieldMatrix<T> out = new Array2DRowFieldMatrix(this.field, m, m);
        int i = 0;
    L7:
        if (i >= this.data.length) goto L14;
        int j = 0;
    L10:
        if (j >= this.data.length) goto L12;
        out.setEntry(i, j, (FieldElement) this.data[i].multiply(v.getEntry(j)));
        j = j + 1;
        goto L10
    L12:
        i = i + 1;
        goto L7
    L14:
        return out;
    }

    public FieldMatrix<T> outerProduct(ArrayFieldVector<T> v) throws IllegalArgumentException {
        return outerProduct(v.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldMatrix<T> outerProduct(T[] v) throws IllegalArgumentException {
        checkVectorDimensions(v.length);
        int m = this.data.length;
        FieldMatrix<T> out = new Array2DRowFieldMatrix(this.field, m, m);
        int i = 0;
    L4:
        if (i >= this.data.length) goto L11;
        int j = 0;
    L7:
        if (j >= this.data.length) goto L9;
        out.setEntry(i, j, (FieldElement) this.data[i].multiply(v[j]));
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T getEntry(int index) throws MatrixIndexException {
        return this.data[index];
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> append(FieldVector<T> v) {
        return append((ArrayFieldVector) v);
    L6:
        return new ArrayFieldVector(this, new ArrayFieldVector(v));
    }

    public ArrayFieldVector<T> append(ArrayFieldVector<T> v) {
        return new ArrayFieldVector(this, v);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> append(T in) {
        FieldElement[] r0 = buildArray(this.data.length + 1);
        System.arraycopy(this.data, 0, r0, 0, this.data.length);
        r0[this.data.length] = in;
        return new ArrayFieldVector(r0);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> append(T[] in) {
        return new ArrayFieldVector(this, in);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public FieldVector<T> getSubVector(int index, int n) {
        ArrayFieldVector<T> out = new ArrayFieldVector(this.field, n);
        System.arraycopy(this.data, index, out.data, 0, n);     // Catch: IndexOutOfBoundsException -> L5
    L7:
        return out;
    L6:
        checkIndex(index);
        checkIndex((index + n) - 1);
        goto L7
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void setEntry(int index, T value) {
        this.data[index] = value;     // Catch: IndexOutOfBoundsException -> L4
        return;
    L5:
        checkIndex(index);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void setSubVector(int r5, FieldVector<T> r6) {
        set(r5, (ArrayFieldVector) r6);     // Catch: IndexOutOfBoundsException -> L4 ClassCastException -> L6
    L19:
        return;
    L7:
        int r1 = r5;
    L8:
        if (r1 >= (r6.getDimension() + r5)) goto L20;
        ((T[]) this.data)[r1] = r6.getEntry(r1 - r5);     // Catch: IndexOutOfBoundsException -> L4
        r1 = r1 + 1;
        goto L8
    L20:
        return;
    L13:
        checkIndex(r5);
        checkIndex((r6.getDimension() + r5) - 1);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void setSubVector(int index, T[] v) {
        System.arraycopy(v, 0, this.data, index, v.length);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L5:
        checkIndex(index);
        checkIndex((v.length + index) - 1);
    }

    public void set(int index, ArrayFieldVector<T> v) throws MatrixIndexException {
        setSubVector(index, v.data);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public void set(T value) {
        Arrays.fill(this.data, value);
    }

    @Override // org.apache.commons.math.linear.FieldVector
    public T[] toArray() {
        return (T[]) ((FieldElement[]) this.data.clone());
    }

    protected void checkVectorDimensions(FieldVector<T> v) throws IllegalArgumentException {
        checkVectorDimensions(v.getDimension());
    }

    protected void checkVectorDimensions(int n) throws IllegalArgumentException {
        if (this.data.length != n) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(this.data.length), Integer.valueOf(n)});
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L24;
        return false;
    L24:
        FieldVector<T> rhs = (FieldVector) other;     // Catch: ClassCastException -> L18
        if (this.data.length == rhs.getDimension()) goto L11;
        return false;
    L11:
        int i = 0;
    L13:
        if (i >= this.data.length) goto L21;
        if (this.data[i].equals(rhs.getEntry(i)) == false) goto L16;
        i = i + 1;
        goto L13
    L16:
        return false;
    L21:
        return true;
    L23:
        return false;
    }

    public int hashCode() {
        int h = 3542;
        T[] r1 = this.data;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        T a = r1[r3];
        h = h ^ a.hashCode();
        r3 = r3 + 1;
        goto L3
    L5:
        return h;
    }

    private void checkIndex(int index) throws MatrixIndexException {
        if (index < 0) goto L7;
        if (index >= getDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(index), 0, Integer.valueOf(getDimension() - 1)});
    }
}
