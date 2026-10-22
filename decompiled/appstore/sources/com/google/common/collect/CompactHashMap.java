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
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final float LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] entries;

    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySetView;

    @MonotonicNonNullDecl
    private transient Set<K> keySetView;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] keys;
    transient int modCount;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] values;

    @MonotonicNonNullDecl
    private transient Collection<V> valuesView;

    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ CompactHashMap this$0;

        public EntrySetView(CompactHashMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            int r12 = CompactHashMap.access$200(this.this$0, r11.getKey());
            if (r12 != (-1)) goto L7;
            return false;
        L7:
            if (Objects.equal(this.this$0.values[r12], r11.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.this$0.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            int r12 = CompactHashMap.access$200(this.this$0, r11.getKey());
            if (r12 != (-1)) goto L7;
            return false;
        L7:
            if (Objects.equal(this.this$0.values[r12], r11.getValue()) == false) goto L13;
            CompactHashMap.access$000(this.this$0, r12);
            return true;
        L13:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.access$100(this.this$0);
        }
    }

    public abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedModCount;
        int indexToRemove;
        final /* synthetic */ CompactHashMap this$0;

        private Itr(CompactHashMap r10) {
            this.this$0 = r10;
            this.expectedModCount = r10.modCount;
            this.currentIndex = r10.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (this.this$0.modCount != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        public abstract T getOutput(int r10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.currentIndex < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (hasNext() == false) goto L7;
            int r10 = this.currentIndex;
            this.indexToRemove = r10;
            T r11 = getOutput(r10);
            this.currentIndex = this.this$0.getSuccessor(this.currentIndex);
            return r11;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            if (this.indexToRemove < 0) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            this.expectedModCount++;
            CompactHashMap.access$000(this.this$0, this.indexToRemove);
            this.currentIndex = this.this$0.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
            return;
        L5:
            r10 = false;
            goto L6
        }

        public /* synthetic */ Itr(CompactHashMap r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class KeySetView extends AbstractSet<K> {
        final /* synthetic */ CompactHashMap this$0;

        public KeySetView(CompactHashMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return this.this$0.containsKey(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.this$0.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object r10) {
            int r11 = CompactHashMap.access$200(this.this$0, r10);
            if (r11 != (-1)) goto L6;
            return false;
        L6:
            CompactHashMap.access$000(this.this$0, r11);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.access$100(this.this$0);
        }
    }

    public final class MapEntry extends AbstractMapEntry<K, V> {

        @NullableDecl
        private final K key;
        private int lastKnownIndex;
        final /* synthetic */ CompactHashMap this$0;

        public MapEntry(CompactHashMap r10, int r11) {
            this.this$0 = r10;
            this.key = (K) r10.keys[r11];
            this.lastKnownIndex = r11;
        }

        private void updateLastKnownIndex() {
            int r10 = this.lastKnownIndex;
            if (r10 != (-1)) goto L5;
        L8:
            this.lastKnownIndex = CompactHashMap.access$200(this.this$0, this.key);
            return;
        L5:
            if (r10 >= this.this$0.size()) goto L8;
            if (Objects.equal(this.key, this.this$0.keys[this.lastKnownIndex]) == false) goto L8;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            updateLastKnownIndex();
            int r10 = this.lastKnownIndex;
            if (r10 != (-1)) goto L6;
            return null;
        L6:
            return (V) this.this$0.values[r10];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V r10) {
            updateLastKnownIndex();
            int r11 = this.lastKnownIndex;
            if (r11 != (-1)) goto L6;
            this.this$0.put(this.key, r10);
            return null;
        L6:
            Object[] r12 = this.this$0.values;
            V r13 = (V) r12[r11];
            r12[r11] = r10;
            return r13;
        }
    }

    public class ValuesView extends AbstractCollection<V> {
        final /* synthetic */ CompactHashMap this$0;

        public ValuesView(CompactHashMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.access$100(this.this$0);
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static /* synthetic */ Object access$000(CompactHashMap r10, int r11) {
        return r10.removeEntry(r11);
    }

    public static /* synthetic */ int access$100(CompactHashMap r10) {
        return r10.size;
    }

    public static /* synthetic */ int access$200(CompactHashMap r10, Object r11) {
        return r10.indexOf(r11);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int r10) {
        return new CompactHashMap(r10);
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

    private int indexOf(@NullableDecl Object r10) {
        if (needsAllocArrays() == false) goto L5;
        return -1;
    L5:
        int r11 = Hashing.smearedHash(r10);
        int r12 = this.table[hashTableMask() & r11];
    L6:
        if (r12 == (-1)) goto L13;
        long r13 = this.entries[r12];
        if (getHash(r13) != r11) goto L12;
        if (Objects.equal(r10, this.keys[r12]) == false) goto L12;
        return r12;
    L12:
        r12 = getNext(r13);
        goto L6
    L13:
        return -1;
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
        put(r10.readObject(), r10.readObject());
        r12 = r12 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException("Invalid size: " + r11);
    }

    @CanIgnoreReturnValue
    private V removeEntry(int r10) {
        return remove(this.keys[r10], getHash(this.entries[r10]));
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
        r10.writeObject(this.keys[r11]);
        r10.writeObject(this.values[r11]);
        r11 = getSuccessor(r11);
        goto L3
    }

    public void accessEntry(int r10) {
    }

    public int adjustAfterRemove(int r10, int r11) {
        return r10 - 1;
    }

    public void allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int r10 = this.modCount;
        this.table = newTable(Hashing.closedTableSize(r10, 1.0d));
        this.entries = newEntries(r10);
        this.keys = new Object[r10];
        this.values = new Object[r10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, 0, this.size, -1);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.size) goto L10;
        if (Objects.equal(r10, this.values[r11]) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView(this);
    }

    public Set<K> createKeySet() {
        return new KeySetView(this);
    }

    public Collection<V> createValues() {
        return new ValuesView(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r10 = this.entrySetView;
        if (r10 != null) goto L6;
        Set<Map.Entry<K, V>> r11 = createEntrySet();
        this.entrySetView = r11;
        return r11;
    L6:
        return r10;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new AnonymousClass2(this);
    }

    public int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object r10) {
        int r11 = indexOf(r10);
        accessEntry(r11);
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return (V) this.values[r11];
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
        Preconditions.checkArgument(r11, "Expected size must be non-negative");
        this.modCount = Math.max(1, r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void insertEntry(int r10, @NullableDecl K r11, @NullableDecl V r12, int r13) {
        this.entries[r10] = (((long) r13) << 32) | NEXT_MASK;
        this.keys[r10] = r11;
        this.values[r10] = r12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r10 = this.keySetView;
        if (r10 != null) goto L6;
        Set<K> r11 = createKeySet();
        this.keySetView = r11;
        return r11;
    L6:
        return r10;
    }

    public Iterator<K> keySetIterator() {
        return new AnonymousClass1(this);
    }

    public void moveLastEntry(int r10) {
        int r11 = size() - 1;
        if (r10 >= r11) goto L11;
        Object[] r12 = this.keys;
        r12[r10] = r12[r11];
        Object[] r13 = this.values;
        r13[r10] = r13[r11];
        r12[r11] = null;
        r13[r11] = null;
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
        this.values[r10] = null;
        this.entries[r10] = -1;
    }

    public boolean needsAllocArrays() {
        if (this.table != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K r12, @NullableDecl V r13) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        long[] r10 = this.entries;
        Object[] r11 = this.keys;
        Object[] r14 = this.values;
        int r15 = Hashing.smearedHash(r12);
        int r16 = hashTableMask() & r15;
        int r17 = this.size;
        int[] r18 = this.table;
        int r19 = r18[r16];
        if (r19 != (-1)) goto L8;
        r18[r16] = r17;
    L18:
        if (r17 == Integer.MAX_VALUE) goto L25;
        int r20 = r17 + 1;
        resizeMeMaybe(r20);
        insertEntry(r17, r12, r13, r15);
        this.size = r20;
        int r110 = this.table.length;
        if (Hashing.needsResizing(r17, r110, 1.0d) == false) goto L22;
        resizeTable(r110 * 2);
    L22:
        this.modCount++;
        return null;
    L25:
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    L8:
        long r21 = r10[r19];
        if (getHash(r21) == r15) goto L11;
    L14:
        int r22 = getNext(r21);
        if (r22 == (-1)) goto L16;
        r19 = r22;
        goto L8
    L16:
        r10[r19] = swapNext(r21, r17);
        goto L18
    L11:
        if (Objects.equal(r12, r11[r19]) == false) goto L14;
        V r111 = (V) r14[r19];
        r14[r19] = r13;
        accessEntry(r19);
        return r111;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object r10) {
        if (needsAllocArrays() == false) goto L7;
        return null;
    L7:
        return remove(r10, Hashing.smearedHash(r10));
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

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
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

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r10 = this.valuesView;
        if (r10 != null) goto L6;
        Collection<V> r11 = createValues();
        this.valuesView = r11;
        return r11;
    L6:
        return r10;
    }

    public Iterator<V> valuesIterator() {
        return new AnonymousClass3(this);
    }

    public CompactHashMap(int r10) {
        init(r10);
    }

    @NullableDecl
    private V remove(@NullableDecl Object r10, int r11) {
        int r12 = hashTableMask() & r11;
        int r13 = this.table[r12];
        if (r13 != (-1)) goto L5;
        return null;
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
        return null;
    L9:
        if (Objects.equal(r10, this.keys[r13]) == false) goto L16;
        V r16 = (V) this.values[r13];
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
}
