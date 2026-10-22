package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {

    @VisibleForTesting
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final float LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @MonotonicNonNullDecl
    transient Object[] elements;

    @MonotonicNonNullDecl
    private transient long[] entries;
    transient int modCount;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;

    public CompactHashSet() {
        init(3);
    }

    public static /* synthetic */ long[] access$000(CompactHashSet r10) {
        return r10.entries;
    }

    public static /* synthetic */ int access$100(long r10) {
        return getHash(r10);
    }

    public static /* synthetic */ boolean access$200(CompactHashSet r10, Object r11, int r12) {
        return r10.remove(r11, r12);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int r10) {
        return new CompactHashSet(r10);
    }

    private static int getHash(long r10) {
        return (int) (r10 >>> 32);
    }

    private static int getNext(long r10) {
        return (int) r10;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int r10) {
        long[] r11 = new long[r10];
        Arrays.fill(r11, -1);
        return r11;
    }

    private static int[] newTable(int r10) {
        int[] r11 = new int[r10];
        Arrays.fill(r11, -1);
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r11 = r10.readInt();
        if (r11 < 0) goto L9;
        init(r11);
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        add(r10.readObject());
        r12 = r12 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException("Invalid size: " + r11);
    }

    private void resizeMeMaybe(int r10) {
        int r11 = this.entries.length;
        if (r10 <= r11) goto L10;
        int r12 = Math.max(1, r11 >>> 1) + r11;
        if (r12 >= 0) goto L7;
        r12 = Channel.UNLIMITED;
    L7:
        if (r12 == r11) goto L11;
        resizeEntries(r12);
        return;
    L11:
        return;
    }

    private void resizeTable(int r11) {
        int[] r12 = newTable(r11);
        long[] r10 = this.entries;
        int r13 = r12.length - 1;
        int r14 = 0;
    L4:
        if (r14 >= this.size) goto L6;
        int r15 = getHash(r10[r14]);
        int r16 = r15 & r13;
        int r17 = r12[r16];
        r12[r16] = r14;
        r10[r14] = (((long) r15) << 32) | (((long) r17) & NEXT_MASK);
        r14 = r14 + 1;
        goto L4
    L6:
        this.table = r12;
    }

    private static long swapNext(long r10, int r11) {
        return (r10 & HASH_MASK) | (NEXT_MASK & ((long) r11));
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeInt(this.size);
        int r11 = firstEntryIndex();
    L3:
        if (r11 < 0) goto L5;
        r10.writeObject(this.elements[r11]);
        r11 = getSuccessor(r11);
        goto L3
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E r11) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        long[] r10 = this.entries;
        Object[] r12 = this.elements;
        int r13 = Hashing.smearedHash(r11);
        int r14 = hashTableMask() & r13;
        int r15 = this.size;
        int[] r16 = this.table;
        int r17 = r16[r14];
        if (r17 != (-1)) goto L8;
        r16[r14] = r15;
    L18:
        if (r15 == Integer.MAX_VALUE) goto L25;
        int r18 = r15 + 1;
        resizeMeMaybe(r18);
        insertEntry(r15, r11, r13);
        this.size = r18;
        int r19 = this.table.length;
        if (Hashing.needsResizing(r15, r19, 1.0d) == false) goto L22;
        resizeTable(r19 * 2);
    L22:
        this.modCount++;
        return true;
    L25:
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    L8:
        long r20 = r10[r17];
        if (getHash(r20) == r13) goto L11;
    L14:
        int r21 = getNext(r20);
        if (r21 == (-1)) goto L16;
        r17 = r21;
        goto L8
    L16:
        r10[r17] = swapNext(r20, r15);
        goto L18
    L11:
        if (Objects.equal(r11, r12[r17]) == false) goto L14;
        return false;
    }

    public int adjustAfterRemove(int r10, int r11) {
        return r10 - 1;
    }

    public void allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int r10 = this.modCount;
        this.table = newTable(Hashing.closedTableSize(r10, 1.0d));
        this.entries = newEntries(r10);
        this.elements = new Object[r10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, 0, this.size, -1);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object r10) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        int r11 = Hashing.smearedHash(r10);
        int r12 = this.table[hashTableMask() & r11];
    L7:
        if (r12 == (-1)) goto L15;
        long r13 = this.entries[r12];
        if (getHash(r13) != r11) goto L14;
        if (Objects.equal(r10, this.elements[r12]) == false) goto L14;
        return true;
    L14:
        r12 = getNext(r13);
        goto L7
    L15:
        return false;
    }

    public int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    public int getSuccessor(int r10) {
        int r11 = r10 + 1;
        if (r11 < this.size) goto L7;
        return -1;
    L7:
        return r11;
    }

    public void init(int r10) {
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Initial capacity must be non-negative");
        this.modCount = Math.max(1, r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void insertEntry(int r10, E r11, int r12) {
        this.entries[r10] = (((long) r12) << 32) | NEXT_MASK;
        this.elements[r10] = r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new AnonymousClass1(this);
    }

    public void moveLastEntry(int r10) {
        int r11 = size() - 1;
        if (r10 >= r11) goto L11;
        Object[] r12 = this.elements;
        r12[r10] = r12[r11];
        r12[r11] = null;
        long[] r13 = this.entries;
        long r14 = r13[r11];
        r13[r10] = r14;
        r13[r11] = -1;
        int r15 = getHash(r14) & hashTableMask();
        int[] r16 = this.table;
        int r17 = r16[r15];
        if (r17 != r11) goto L7;
        r16[r15] = r10;
        return;
    L7:
        long r18 = this.entries[r17];
        int r19 = getNext(r18);
        if (r19 == r11) goto L9;
        r17 = r19;
        goto L7
    L9:
        this.entries[r17] = swapNext(r18, r10);
        return;
    L11:
        this.elements[r10] = null;
        this.entries[r10] = -1;
    }

    public boolean needsAllocArrays() {
        if (this.table != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object r10) {
        if (needsAllocArrays() == false) goto L7;
        return false;
    L7:
        return remove(r10, Hashing.smearedHash(r10));
    }

    public void resizeEntries(int r10) {
        this.elements = Arrays.copyOf(this.elements, r10);
        long[] r11 = this.entries;
        int r12 = r11.length;
        long[] r13 = Arrays.copyOf(r11, r10);
        if (r10 <= r12) goto L5;
        Arrays.fill(r13, r12, r10, -1);
    L5:
        this.entries = r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays() == false) goto L7;
        return new Object[0];
    L7:
        return Arrays.copyOf(this.elements, this.size);
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        int r10 = this.size;
        if (r10 >= this.entries.length) goto L8;
        resizeEntries(r10);
    L8:
        int r11 = Hashing.closedTableSize(r10, 1.0d);
        if (r11 >= this.table.length) goto L12;
        resizeTable(r11);
        return;
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> r10) {
        CompactHashSet<E> r11 = createWithExpectedSize(r10.size());
        r11.addAll(r10);
        return r11;
    }

    public CompactHashSet(int r10) {
        init(r10);
    }

    @CanIgnoreReturnValue
    private boolean remove(Object r10, int r11) {
        int r12 = hashTableMask() & r11;
        int r13 = this.table[r12];
        if (r13 != (-1)) goto L5;
        return false;
    L5:
        int r14 = -1;
    L7:
        if (getHash(this.entries[r13]) == r11) goto L9;
    L15:
        int r15 = getNext(this.entries[r13]);
        if (r15 == (-1)) goto L17;
        r14 = r13;
        r13 = r15;
        goto L7
    L17:
        return false;
    L9:
        if (Objects.equal(r10, this.elements[r13]) == false) goto L15;
        if (r14 != (-1)) goto L12;
        this.table[r12] = getNext(this.entries[r13]);
    L13:
        moveLastEntry(r13);
        this.size--;
        this.modCount++;
        return true;
    L12:
        long[] r16 = this.entries;
        r16[r14] = swapNext(r16[r14], getNext(r16[r13]));
        goto L13
    }

    public static <E> CompactHashSet<E> create(E... r10) {
        CompactHashSet<E> r11 = createWithExpectedSize(r10.length);
        Collections.addAll(r11, r10);
        return r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] r10) {
        if (needsAllocArrays() == false) goto L9;
        if (r10.length <= 0) goto L7;
        r10[0] = null;
    L7:
        return r10;
    L9:
        return (T[]) ObjectArrays.toArrayImpl(this.elements, 0, this.size, r10);
    }
}
