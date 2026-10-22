package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final Object[] EMPTY_ARRAY = null;
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private E[] array;
    private int size;

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r1) {
        return mutableCopyWithCapacity(r1);
    }

    static {
        Object[] r1 = new Object[0];
        EMPTY_ARRAY = r1;
        EMPTY_LIST = new ProtobufArrayList(r1, 0, false);
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    ProtobufArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    private ProtobufArrayList(E[] r1, int r2, boolean r3) {
        super(r3);
        this.array = r1;
        this.size = r2;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int r3) {
        if (r3 < this.size) goto L10;
        if (r3 != 0) goto L6;
        Object[] r4 = EMPTY_ARRAY;
    L8:
        return new ProtobufArrayList(r4, this.size, true);
    L6:
        r4 = Arrays.copyOf(this.array, r3);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r4) {
        ensureIsMutable();
        int r0 = this.size;
        E[] r1 = this.array;
        if (r0 != r1.length) goto L5;
        this.array = (E[]) Arrays.copyOf(this.array, growSize(r1.length));
    L5:
        E[] r2 = this.array;
        int r3 = this.size;
        this.size = r3 + 1;
        r2[r3] = r4;
        this.modCount++;
        return true;
    }

    private static int growSize(int r1) {
        return Math.max(((r1 * 3) / 2) + 1, 10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r5, E r6) {
        ensureIsMutable();
        if (r5 < 0) goto L13;
        int r0 = this.size;
        if (r5 > r0) goto L13;
        E[] r1 = this.array;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.array[r5] = r6;
        this.size++;
        this.modCount++;
        return;
    L9:
        E[] r2 = (E[]) createArray(growSize(r1.length));
        System.arraycopy(this.array, 0, r2, 0, r5);
        System.arraycopy(this.array, r5, r2, r5 + 1, this.size - r5);
        this.array = r2;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r5));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r1) {
        ensureIndexInRange(r1);
        return this.array[r1];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int r5) {
        ensureIsMutable();
        ensureIndexInRange(r5);
        E[] r0 = this.array;
        E r1 = r0[r5];
        int r2 = this.size;
        if (r5 >= (r2 - 1)) goto L5;
        System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
    L5:
        this.size--;
        this.modCount++;
        return r1;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        ensureIsMutable();
        ensureIndexInRange(r3);
        E[] r0 = this.array;
        E r1 = r0[r3];
        r0[r3] = r4;
        this.modCount++;
        return r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    void ensureCapacity(int r3) {
        E[] r0 = this.array;
        if (r3 > r0.length) goto L6;
        return;
    L6:
        if (r0.length != 0) goto L9;
        this.array = (E[]) new Object[Math.max(r3, 10)];
        return;
    L9:
        int r1 = r0.length;
    L10:
        if (r1 >= r3) goto L12;
        r1 = growSize(r1);
        goto L10
    L12:
        this.array = (E[]) Arrays.copyOf(this.array, r1);
    }

    private static <E> E[] createArray(int r0) {
        return (E[]) new Object[r0];
    }

    private void ensureIndexInRange(int r2) {
        if (r2 < 0) goto L7;
        if (r2 >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r2));
    }

    private String makeOutOfBoundsExceptionMessage(int r3) {
        return "Index:" + r3 + ", Size:" + this.size;
    }
}
