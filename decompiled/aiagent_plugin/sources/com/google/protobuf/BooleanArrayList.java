package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final boolean[] EMPTY_ARRAY = null;
    private static final BooleanArrayList EMPTY_LIST = null;
    private boolean[] array;
    private int size;

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        add(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return add((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int r1) {
        return mutableCopyWithCapacity(r1);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return set(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin"));
    }

    static {
        boolean[] r1 = new boolean[0];
        EMPTY_ARRAY = r1;
        EMPTY_LIST = new BooleanArrayList(r1, 0, false);
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    BooleanArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    private BooleanArrayList(boolean[] r1, int r2, boolean r3) {
        super(r3);
        this.array = r1;
        this.size = r2;
    }

    @Override // java.util.AbstractList
    public void removeRange(int r3, int r4) {
        ensureIsMutable();
        if (r4 < r3) goto L7;
        boolean[] r0 = this.array;
        System.arraycopy(r0, r4, r0, r3, this.size - r4);
        this.size -= r4 - r3;
        this.modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, BooleanArrayList.class) == false) goto L8;
        BooleanArrayList r7 = (BooleanArrayList) ZeusTransformUtils.preCheckCast(r6, BooleanArrayList.class, "com.obric.aiagent.plugin");
        if (this.size == r7.size) goto L12;
        return false;
    L12:
        boolean[] r8 = r7.array;
        int r0 = 0;
    L14:
        if (r0 >= this.size) goto L19;
        if (this.array[r0] != r8[r0]) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r6);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r0 = 1;
        int r1 = 0;
    L4:
        if (r1 >= this.size) goto L6;
        r0 = (r0 * 31) + Internal.hashBoolean(this.array[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity(int r3) {
        if (r3 < this.size) goto L10;
        if (r3 != 0) goto L6;
        boolean[] r4 = EMPTY_ARRAY;
    L8:
        return new BooleanArrayList(r4, this.size, true);
    L6:
        r4 = Arrays.copyOf(this.array, r3);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int r1) {
        return Boolean.valueOf(getBoolean(r1));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int r1) {
        ensureIndexInRange(r1);
        return this.array[r1];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == true) goto L5;
        return -1;
    L5:
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        int r0 = size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (this.array[r2] == r6) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r2;
    L11:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    public Boolean set(int r1, Boolean r2) {
        return Boolean.valueOf(setBoolean(r1, r2.booleanValue()));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int r2, boolean r3) {
        ensureIsMutable();
        ensureIndexInRange(r2);
        boolean[] r1 = this.array;
        boolean r0 = r1[r2];
        r1[r2] = r3;
        return r0;
    }

    public boolean add(Boolean r1) {
        addBoolean(r1.booleanValue());
        return true;
    }

    public void add(int r1, Boolean r2) {
        addBoolean(r1, r2.booleanValue());
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean r5) {
        ensureIsMutable();
        int r0 = this.size;
        boolean[] r1 = this.array;
        if (r0 != r1.length) goto L5;
        boolean[] r2 = new boolean[growSize(r1.length)];
        System.arraycopy(this.array, 0, r2, 0, this.size);
        this.array = r2;
    L5:
        boolean[] r3 = this.array;
        int r4 = this.size;
        this.size = r4 + 1;
        r3[r4] = r5;
    }

    private void addBoolean(int r5, boolean r6) {
        ensureIsMutable();
        if (r5 < 0) goto L13;
        int r0 = this.size;
        if (r5 > r0) goto L13;
        boolean[] r1 = this.array;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.array[r5] = r6;
        this.size++;
        this.modCount++;
        return;
    L9:
        boolean[] r2 = new boolean[growSize(r1.length)];
        System.arraycopy(this.array, 0, r2, 0, r5);
        System.arraycopy(this.array, r5, r2, r5 + 1, this.size - r5);
        this.array = r2;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r5));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        ensureIsMutable();
        Internal.checkNotNull(r7);
        if (ZeusTransformUtils.instanceOf(r7, BooleanArrayList.class) == false) goto L5;
        BooleanArrayList r8 = (BooleanArrayList) ZeusTransformUtils.preCheckCast(r7, BooleanArrayList.class, "com.obric.aiagent.plugin");
        int r0 = r8.size;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r3 = this.size;
        if ((Integer.MAX_VALUE - r3) < r0) goto L17;
        int r4 = r3 + r0;
        boolean[] r1 = this.array;
        if (r4 <= r1.length) goto L14;
        this.array = Arrays.copyOf(r1, r4);
    L14:
        System.arraycopy(r8.array, 0, this.array, this.size, r8.size);
        this.size = r4;
        this.modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r7);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int r5) {
        ensureIsMutable();
        ensureIndexInRange(r5);
        boolean[] r0 = this.array;
        boolean r1 = r0[r5];
        int r2 = this.size;
        if (r5 >= (r2 - 1)) goto L5;
        System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
    L5:
        this.size--;
        this.modCount++;
        return Boolean.valueOf(r1);
    }

    void ensureCapacity(int r3) {
        boolean[] r0 = this.array;
        if (r3 > r0.length) goto L6;
        return;
    L6:
        if (r0.length != 0) goto L9;
        this.array = new boolean[Math.max(r3, 10)];
        return;
    L9:
        int r1 = r0.length;
    L10:
        if (r1 >= r3) goto L12;
        r1 = growSize(r1);
        goto L10
    L12:
        this.array = Arrays.copyOf(this.array, r1);
    }

    private static int growSize(int r1) {
        return Math.max(((r1 * 3) / 2) + 1, 10);
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
