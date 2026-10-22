package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess {
    private static final BooleanArrayList EMPTY_LIST = null;
    private boolean[] array;
    private int size;

    static {
        BooleanArrayList r10 = new BooleanArrayList();
        EMPTY_LIST = r10;
        r10.makeImmutable();
    }

    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int r10) {
        if (r10 < 0) goto L7;
        if (r10 >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r10));
    }

    private String makeOutOfBoundsExceptionMessage(int r10) {
        return "Index:" + r10 + ", Size:" + this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
        add(r10, (Boolean) r11);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> r10) {
        ensureIsMutable();
        if (r10 == null) goto L21;
        if ((r10 instanceof BooleanArrayList) == false) goto L7;
        BooleanArrayList r11 = (BooleanArrayList) r10;
        int r12 = r11.size;
        if (r12 != 0) goto L11;
        return false;
    L11:
        int r13 = this.size;
        if ((Channel.UNLIMITED - r13) < r12) goto L19;
        int r14 = r13 + r12;
        boolean[] r15 = this.array;
        if (r14 <= r15.length) goto L16;
        this.array = Arrays.copyOf(r15, r14);
    L16:
        System.arraycopy(r11.array, 0, this.array, this.size, r11.size);
        this.size = r14;
        ((AbstractList) this).modCount++;
        return true;
    L19:
        throw new OutOfMemoryError();
    L7:
        return super.addAll(r10);
    L21:
        throw null;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean r10) {
        addBoolean(this.size, r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BooleanArrayList) == false) goto L8;
        BooleanArrayList r11 = (BooleanArrayList) r10;
        if (this.size == r11.size) goto L12;
        return false;
    L12:
        boolean[] r12 = r11.array;
        int r13 = 0;
    L14:
        if (r13 >= this.size) goto L19;
        if (this.array[r13] != r12[r13]) goto L17;
        r13 = r13 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int r10) {
        ensureIndexInRange(r10);
        return this.array[r10];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r10 = 1;
        int r11 = 0;
    L4:
        if (r11 >= this.size) goto L6;
        r10 = (r10 * 31) + Internal.hashBoolean(this.array[r11]);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int r10) {
        return mutableCopyWithCapacity(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r10) {
        return remove(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
        return set(r10, (Boolean) r11);
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int r10, boolean r11) {
        ensureIsMutable();
        ensureIndexInRange(r10);
        boolean[] r12 = this.array;
        boolean r13 = r12[r10];
        r12[r10] = r11;
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] r10, int r11) {
        this.array = r10;
        this.size = r11;
    }

    private void addBoolean(int r10, boolean r11) {
        ensureIsMutable();
        if (r10 < 0) goto L13;
        int r12 = this.size;
        if (r10 > r12) goto L13;
        boolean[] r13 = this.array;
        if (r12 >= r13.length) goto L9;
        System.arraycopy(r13, r10, r13, r10 + 1, r12 - r10);
    L10:
        this.array[r10] = r11;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        boolean[] r14 = new boolean[((r12 * 3) / 2) + 1];
        System.arraycopy(r13, 0, r14, 0, r10);
        System.arraycopy(this.array, r10, r14, r10 + 1, this.size - r10);
        this.array = r14;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r10));
    }

    public void add(int r10, Boolean r11) {
        addBoolean(r10, r11.booleanValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int r10) {
        return Boolean.valueOf(getBoolean(r10));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity(int r10) {
        if (r10 < this.size) goto L7;
        return new BooleanArrayList(Arrays.copyOf(this.array, r10), this.size);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        ensureIsMutable();
        int r11 = 0;
    L4:
        if (r11 >= this.size) goto L10;
        if (r10.equals(Boolean.valueOf(this.array[r11])) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        boolean[] r12 = this.array;
        System.arraycopy(r12, r11 + 1, r12, r11, this.size - r11);
        this.size--;
        ((AbstractList) this).modCount++;
        return true;
    L10:
        return false;
    }

    public Boolean set(int r10, Boolean r11) {
        return Boolean.valueOf(setBoolean(r10, r11.booleanValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int r10) {
        ensureIsMutable();
        ensureIndexInRange(r10);
        boolean[] r11 = this.array;
        boolean r12 = r11[r10];
        System.arraycopy(r11, r10 + 1, r11, r10, this.size - r10);
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(r12);
    }
}
