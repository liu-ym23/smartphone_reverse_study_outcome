package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
class ObjectCountHashMap<K> {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @VisibleForTesting
    transient long[] entries;
    transient Object[] keys;
    private transient float loadFactor;
    transient int modCount;
    transient int size;
    private transient int[] table;
    private transient int threshold;
    transient int[] values;

    public class MapEntry extends Multisets.AbstractEntry<K> {

        @NullableDecl
        final K key;
        int lastKnownIndex;
        final /* synthetic */ ObjectCountHashMap this$0;

        public MapEntry(ObjectCountHashMap r10, int r11) {
            this.this$0 = r10;
            this.key = (K) r10.keys[r11];
            this.lastKnownIndex = r11;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            updateLastKnownIndex();
            int r10 = this.lastKnownIndex;
            if (r10 != (-1)) goto L6;
            return 0;
        L6:
            return this.this$0.values[r10];
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.key;
        }

        @CanIgnoreReturnValue
        public int setCount(int r10) {
            updateLastKnownIndex();
            int r11 = this.lastKnownIndex;
            if (r11 != (-1)) goto L6;
            this.this$0.put(this.key, r10);
            return 0;
        L6:
            int[] r12 = this.this$0.values;
            int r13 = r12[r11];
            r12[r11] = r10;
            return r13;
        }

        public void updateLastKnownIndex() {
            int r10 = this.lastKnownIndex;
            if (r10 != (-1)) goto L5;
        L8:
            this.lastKnownIndex = this.this$0.indexOf(this.key);
            return;
        L5:
            if (r10 >= this.this$0.size()) goto L8;
            if (Objects.equal(this.key, this.this$0.keys[this.lastKnownIndex]) == false) goto L8;
        }
    }

    public ObjectCountHashMap() {
        init(3, 1.0f);
    }

    public static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap();
    }

    public static <K> ObjectCountHashMap<K> createWithExpectedSize(int r10) {
        return new ObjectCountHashMap(r10);
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

    private void resizeTable(int r12) {
        if (this.table.length < 1073741824) goto L6;
        this.threshold = Channel.UNLIMITED;
        return;
    L6:
        int r10 = ((int) (r12 * this.loadFactor)) + 1;
        int[] r13 = newTable(r12);
        long[] r11 = this.entries;
        int r14 = r13.length - 1;
        int r15 = 0;
    L8:
        if (r15 >= this.size) goto L10;
        int r16 = getHash(r11[r15]);
        int r17 = r16 & r14;
        int r18 = r13[r17];
        r13[r17] = r15;
        r11[r15] = (((long) r16) << 32) | (((long) r18) & NEXT_MASK);
        r15 = r15 + 1;
        goto L8
    L10:
        this.threshold = r10;
        this.table = r13;
    }

    private static long swapNext(long r10, int r11) {
        return (r10 & HASH_MASK) | (NEXT_MASK & ((long) r11));
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1);
        this.size = 0;
    }

    public boolean containsKey(@NullableDecl Object r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r10) {
        if (r10 <= this.entries.length) goto L6;
        resizeEntries(r10);
    L6:
        if (r10 < this.threshold) goto L9;
        resizeTable(Math.max(2, Integer.highestOneBit(r10 - 1) << 1));
        return;
    }

    public int firstIndex() {
        if (this.size != 0) goto L5;
        return -1;
    L5:
        return 0;
    }

    public int get(@NullableDecl Object r10) {
        int r11 = indexOf(r10);
        if (r11 != (-1)) goto L6;
        return 0;
    L6:
        return this.values[r11];
    }

    public Multiset.Entry<K> getEntry(int r10) {
        Preconditions.checkElementIndex(r10, this.size);
        return new MapEntry(this, r10);
    }

    public K getKey(int r10) {
        Preconditions.checkElementIndex(r10, this.size);
        return (K) this.keys[r10];
    }

    public int getValue(int r10) {
        Preconditions.checkElementIndex(r10, this.size);
        return this.values[r10];
    }

    public int indexOf(@NullableDecl Object r10) {
        int r11 = Hashing.smearedHash(r10);
        int r12 = this.table[hashTableMask() & r11];
    L4:
        if (r12 == (-1)) goto L11;
        long r13 = this.entries[r12];
        if (getHash(r13) != r11) goto L10;
        if (Objects.equal(r10, this.keys[r12]) == false) goto L10;
        return r12;
    L10:
        r12 = getNext(r13);
        goto L4
    L11:
        return -1;
    }

    public void init(int r10, float r11) {
        boolean r12 = false;
        if (r10 < 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "Initial capacity must be non-negative");
        if (r11 <= 0.0f) goto L9;
        r12 = true;
    L9:
        Preconditions.checkArgument(r12, "Illegal load factor");
        int r14 = Hashing.closedTableSize(r10, r11);
        this.table = newTable(r14);
        this.loadFactor = r11;
        this.keys = new Object[r10];
        this.values = new int[r10];
        this.entries = newEntries(r10);
        this.threshold = Math.max(1, (int) (r14 * r11));
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void insertEntry(int r10, @NullableDecl K r11, int r12, int r13) {
        this.entries[r10] = (((long) r13) << 32) | NEXT_MASK;
        this.keys[r10] = r11;
        this.values[r10] = r12;
    }

    public void moveLastEntry(int r10) {
        int r11 = size() - 1;
        if (r10 >= r11) goto L11;
        Object[] r12 = this.keys;
        r12[r10] = r12[r11];
        int[] r13 = this.values;
        r13[r10] = r13[r11];
        r12[r11] = null;
        r13[r11] = 0;
        long[] r14 = this.entries;
        long r15 = r14[r11];
        r14[r10] = r15;
        r14[r11] = -1;
        int r16 = getHash(r15) & hashTableMask();
        int[] r17 = this.table;
        int r18 = r17[r16];
        if (r18 != r11) goto L7;
        r17[r16] = r10;
        return;
    L7:
        long r19 = this.entries[r18];
        int r20 = getNext(r19);
        if (r20 == r11) goto L9;
        r18 = r20;
        goto L7
    L9:
        this.entries[r18] = swapNext(r19, r10);
        return;
    L11:
        this.keys[r10] = null;
        this.values[r10] = 0;
        this.entries[r10] = -1;
    }

    public int nextIndex(int r10) {
        int r11 = r10 + 1;
        if (r11 < this.size) goto L7;
        return -1;
    L7:
        return r11;
    }

    public int nextIndexAfterRemove(int r10, int r11) {
        return r10 - 1;
    }

    @CanIgnoreReturnValue
    public int put(@NullableDecl K r12, int r13) {
        CollectPreconditions.checkPositive(r13, "count");
        long[] r10 = this.entries;
        Object[] r11 = this.keys;
        int[] r14 = this.values;
        int r15 = Hashing.smearedHash(r12);
        int r16 = hashTableMask() & r15;
        int r17 = this.size;
        int[] r18 = this.table;
        int r19 = r18[r16];
        if (r19 != (-1)) goto L5;
        r18[r16] = r17;
    L15:
        if (r17 == Integer.MAX_VALUE) goto L22;
        int r20 = r17 + 1;
        resizeMeMaybe(r20);
        insertEntry(r17, r12, r13, r15);
        this.size = r20;
        if (r17 < this.threshold) goto L19;
        resizeTable(this.table.length * 2);
    L19:
        this.modCount++;
        return 0;
    L22:
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    L5:
        long r21 = r10[r19];
        if (getHash(r21) == r15) goto L8;
    L11:
        int r22 = getNext(r21);
        if (r22 == (-1)) goto L13;
        r19 = r22;
        goto L5
    L13:
        r10[r19] = swapNext(r21, r17);
        goto L15
    L8:
        if (Objects.equal(r12, r11[r19]) == false) goto L11;
        int r110 = r14[r19];
        r14[r19] = r13;
        return r110;
    }

    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object r10) {
        return remove(r10, Hashing.smearedHash(r10));
    }

    @CanIgnoreReturnValue
    public int removeEntry(int r10) {
        return remove(this.keys[r10], getHash(this.entries[r10]));
    }

    public void resizeEntries(int r10) {
        this.keys = Arrays.copyOf(this.keys, r10);
        this.values = Arrays.copyOf(this.values, r10);
        long[] r11 = this.entries;
        int r12 = r11.length;
        long[] r13 = Arrays.copyOf(r11, r10);
        if (r10 <= r12) goto L5;
        Arrays.fill(r13, r12, r10, -1);
    L5:
        this.entries = r13;
    }

    public void setValue(int r10, int r11) {
        Preconditions.checkElementIndex(r10, this.size);
        this.values[r10] = r11;
    }

    public int size() {
        return this.size;
    }

    private int remove(@NullableDecl Object r10, int r11) {
        int r12 = hashTableMask() & r11;
        int r13 = this.table[r12];
        if (r13 != (-1)) goto L5;
        return 0;
    L5:
        int r14 = -1;
    L7:
        if (getHash(this.entries[r13]) == r11) goto L9;
    L16:
        int r15 = getNext(this.entries[r13]);
        if (r15 == (-1)) goto L18;
        r14 = r13;
        r13 = r15;
        goto L7
    L18:
        return 0;
    L9:
        if (Objects.equal(r10, this.keys[r13]) == false) goto L16;
        int r16 = this.values[r13];
        if (r14 != (-1)) goto L13;
        this.table[r12] = getNext(this.entries[r13]);
    L14:
        moveLastEntry(r13);
        this.size--;
        this.modCount++;
        return r16;
    L13:
        long[] r17 = this.entries;
        r17[r14] = swapNext(r17[r14], getNext(r17[r13]));
        goto L14
    }

    public ObjectCountHashMap(ObjectCountHashMap<? extends K> r10) {
        init(r10.size(), 1.0f);
        int r11 = r10.firstIndex();
    L4:
        if (r11 == (-1)) goto L6;
        put(r10.getKey(r11), r10.getValue(r11));
        r11 = r10.nextIndex(r11);
        goto L4
    }

    public ObjectCountHashMap(int r10) {
        this(r10, 1.0f);
    }

    public ObjectCountHashMap(int r10, float r11) {
        init(r10, r11);
    }
}
