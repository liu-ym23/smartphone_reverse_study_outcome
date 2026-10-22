package com.bytedance.location.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private E[] array;
    private int size;

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r1) {
        return mutableCopyWithCapacity(r1);
    }

    static {
        EMPTY_LIST = new ProtobufArrayList(new Object[0], 0);
        EMPTY_LIST.makeImmutable();
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private ProtobufArrayList(E[] array, int size) {
        this.array = array;
        this.size = size;
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int capacity) {
        if (capacity < this.size) goto L7;
        return new ProtobufArrayList(Arrays.copyOf(this.array, capacity), this.size);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r5) {
        ensureIsMutable();
        if (this.size != this.array.length) goto L5;
        this.array = (E[]) Arrays.copyOf(this.array, ((this.size * 3) / 2) + 1);
    L5:
        E[] r0 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        r0[r1] = r5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r6, E r7) {
        ensureIsMutable();
        if (r6 < 0) goto L13;
        if (r6 > this.size) goto L13;
        if (this.size >= this.array.length) goto L9;
        System.arraycopy(this.array, r6, this.array, r6 + 1, this.size - r6);
    L10:
        this.array[r6] = r7;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        E[] r1 = (E[]) createArray(((this.size * 3) / 2) + 1);
        System.arraycopy(this.array, 0, r1, 0, r6);
        System.arraycopy(this.array, r6, r1, r6 + 1, this.size - r6);
        this.array = r1;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r6));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        E value = this.array[index];
        if (index >= (this.size - 1)) goto L5;
        System.arraycopy(this.array, index + 1, this.array, index, (this.size - index) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return value;
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        E toReturn = this.array[index];
        this.array[index] = element;
        ((AbstractList) this).modCount++;
        return toReturn;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private static <E> E[] createArray(int r1) {
        return (E[]) new Object[r1];
    }

    private void ensureIndexInRange(int index) {
        if (index < 0) goto L7;
        if (index >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
    }

    private String makeOutOfBoundsExceptionMessage(int index) {
        return "Index:" + index + ", Size:" + this.size;
    }
}
