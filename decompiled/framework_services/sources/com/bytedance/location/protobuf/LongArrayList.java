package com.bytedance.location.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST = null;
    private long[] array;
    private int size;

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
        add(r1, (Long) r2);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return add((Long) r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Long> mutableCopyWithCapacity2(int r1) {
        return mutableCopyWithCapacity(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
        return set(r1, (Long) r2);
    }

    static {
        EMPTY_LIST = new LongArrayList(new long[0], 0);
        EMPTY_LIST.makeImmutable();
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    private LongArrayList(long[] other, int size) {
        this.array = other;
        this.size = size;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex < fromIndex) goto L7;
        System.arraycopy(this.array, toIndex, this.array, fromIndex, this.size - toIndex);
        this.size -= toIndex - fromIndex;
        ((AbstractList) this).modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof LongArrayList) == false) goto L8;
        LongArrayList other = (LongArrayList) o;
        if (this.size == other.size) goto L12;
        return false;
    L12:
        long[] arr = other.array;
        int i = 0;
    L14:
        if (i >= this.size) goto L20;
        if (this.array[i] != arr[i]) goto L17;
        i = i + 1;
        goto L14
    L17:
        return false;
    L20:
        return true;
    L8:
        return super.equals(o);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int result = 1;
        int i = 0;
    L4:
        if (i >= this.size) goto L7;
        result = (result * 31) + Internal.hashLong(this.array[i]);
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Long> mutableCopyWithCapacity(int capacity) {
        if (capacity < this.size) goto L7;
        return new LongArrayList(Arrays.copyOf(this.array, capacity), this.size);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int index) {
        return Long.valueOf(getLong(index));
    }

    @Override // com.bytedance.location.protobuf.Internal.LongList
    public long getLong(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        if ((element instanceof Long) == true) goto L5;
        return -1;
    L5:
        long unboxedElement = ((Long) element).longValue();
        int numElems = size();
        int i = 0;
    L6:
        if (i >= numElems) goto L12;
        if (this.array[i] == unboxedElement) goto L9;
        i = i + 1;
        goto L6
    L9:
        return i;
    L12:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        if (indexOf(element) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    public Long set(int index, Long element) {
        return Long.valueOf(setLong(index, element.longValue()));
    }

    @Override // com.bytedance.location.protobuf.Internal.LongList
    public long setLong(int index, long element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        long previousValue = this.array[index];
        this.array[index] = element;
        return previousValue;
    }

    public boolean add(Long element) {
        addLong(element.longValue());
        return true;
    }

    public void add(int index, Long element) {
        addLong(index, element.longValue());
    }

    @Override // com.bytedance.location.protobuf.Internal.LongList
    public void addLong(long element) {
        ensureIsMutable();
        if (this.size != this.array.length) goto L5;
        int length = ((this.size * 3) / 2) + 1;
        long[] newArray = new long[length];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
    L5:
        long[] r0 = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        r0[r1] = element;
    }

    private void addLong(int index, long element) {
        ensureIsMutable();
        if (index < 0) goto L13;
        if (index > this.size) goto L13;
        if (this.size >= this.array.length) goto L9;
        System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
    L10:
        this.array[index] = element;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        int length = ((this.size * 3) / 2) + 1;
        long[] newArray = new long[length];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index, newArray, index + 1, this.size - index);
        this.array = newArray;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if ((collection instanceof LongArrayList) == false) goto L5;
        LongArrayList list = (LongArrayList) collection;
        if (list.size != 0) goto L9;
        return false;
    L9:
        int overflow = Integer.MAX_VALUE - this.size;
        if (overflow < list.size) goto L17;
        int newSize = this.size + list.size;
        if (newSize <= this.array.length) goto L14;
        this.array = Arrays.copyOf(this.array, newSize);
    L14:
        System.arraycopy(list.array, 0, this.array, this.size, list.size);
        this.size = newSize;
        ((AbstractList) this).modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(collection);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        long value = this.array[index];
        if (index >= (this.size - 1)) goto L5;
        System.arraycopy(this.array, index + 1, this.array, index, (this.size - index) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(value);
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
