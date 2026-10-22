package com.google.common.collect;

import com.google.common.base.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 0;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient BiMap<V, K> inverse;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    /* JADX INFO: renamed from: com.google.common.collect.HashBiMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;

        @Nullable
        BiEntry<K, V> nextInKToVBucket;

        @Nullable
        BiEntry<K, V> nextInVToKBucket;
        final int valueHash;

        BiEntry(K r1, int r2, V r3, int r4) {
            super(r1, r3);
            this.keyHash = r2;
            this.valueHash = r4;
        }
    }

    private final class EntrySet extends Maps.EntrySet<K, V> {
        final /* synthetic */ HashBiMap this$0;

        private EntrySet(HashBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(HashBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> map() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }
    }

    private final class Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        final /* synthetic */ HashBiMap this$0;

        /* JADX INFO: renamed from: com.google.common.collect.HashBiMap$Inverse$1, reason: invalid class name */
        class AnonymousClass1 extends Maps.EntrySet<V, K> {
            final /* synthetic */ Inverse this$1;

            AnonymousClass1(Inverse r1) {
                this.this$1 = r1;
            }

            @Override // com.google.common.collect.Maps.EntrySet
            Map<V, K> map() {
                return this.this$1;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<V, K>> iterator() {
                return new C00551(this);
            }
        }

        private final class InverseKeySet extends Maps.KeySet<V, K> {
            final /* synthetic */ Inverse this$1;

            InverseKeySet(Inverse r1) {
                this.this$1 = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@Nullable Object r3) {
                BiEntry r4 = HashBiMap.access$600(this.this$1.this$0, r3, HashBiMap.access$300(r3));
                if (r4 != null) goto L6;
                return false;
            L6:
                HashBiMap.access$200(this.this$1.this$0, r4);
                return true;
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new AnonymousClass1(this);
            }
        }

        private Inverse(HashBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Inverse(HashBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        BiMap<K, V> forward() {
            return this.this$0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.access$900(this.this$0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object r1) {
            return forward().containsValue(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(@Nullable Object r2) {
            BiEntry r1 = HashBiMap.access$600(this.this$0, r2, HashBiMap.access$300(r2));
            if (r1 != null) goto L6;
            return null;
        L6:
            return r1.key;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public K put(@Nullable V r2, @Nullable K r3) {
            return (K) HashBiMap.access$1000(this.this$0, r2, r3, false);
        }

        @Override // com.google.common.collect.BiMap
        public K forcePut(@Nullable V r2, @Nullable K r3) {
            return (K) HashBiMap.access$1000(this.this$0, r2, r3, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(@Nullable Object r3) {
            BiEntry r4 = HashBiMap.access$600(this.this$0, r3, HashBiMap.access$300(r3));
            if (r4 != null) goto L6;
            return null;
        L6:
            HashBiMap.access$200(this.this$0, r4);
            return r4.key;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new InverseKeySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return forward().keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            return new AnonymousClass1(this);
        }

        Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }
    }

    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> r1) {
            this.bimap = r1;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    abstract class Itr<T> implements Iterator<T> {
        int expectedModCount;
        BiEntry<K, V> next;
        int nextBucket;
        final /* synthetic */ HashBiMap this$0;
        BiEntry<K, V> toRemove;

        abstract T output(BiEntry<K, V> r1);

        Itr(HashBiMap r2) {
            this.this$0 = r2;
            this.nextBucket = 0;
            this.next = null;
            this.toRemove = null;
            this.expectedModCount = HashBiMap.access$000(r2);
        }

        private void checkForConcurrentModification() {
            if (HashBiMap.access$000(this.this$0) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next == null) goto L6;
            return true;
        L6:
            if (this.nextBucket >= HashBiMap.access$100(this.this$0).length) goto L12;
            BiEntry[] r0 = HashBiMap.access$100(this.this$0);
            int r2 = this.nextBucket;
            if (r0[r2] != null) goto L9;
            this.nextBucket = r2 + 1;
            goto L6
        L9:
            BiEntry<K, V>[] r1 = HashBiMap.access$100(this.this$0);
            int r3 = this.nextBucket;
            this.nextBucket = r3 + 1;
            this.next = r1[r3];
            return true;
        L12:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (hasNext() == false) goto L7;
            BiEntry<K, V> r0 = this.next;
            this.next = r0.nextInKToVBucket;
            this.toRemove = r0;
            return output(r0);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            if (this.toRemove == null) goto L5;
            boolean r0 = true;
        L6:
            CollectPreconditions.checkRemove(r0);
            HashBiMap.access$200(this.this$0, this.toRemove);
            this.expectedModCount = HashBiMap.access$000(this.this$0);
            this.toRemove = null;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    private final class KeySet extends Maps.KeySet<K, V> {
        final /* synthetic */ HashBiMap this$0;

        KeySet(HashBiMap r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object r3) {
            BiEntry r4 = HashBiMap.access$400(this.this$0, r3, HashBiMap.access$300(r3));
            if (r4 != null) goto L6;
            return false;
        L6:
            HashBiMap.access$200(this.this$0, r4);
            return true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    static /* synthetic */ int access$000(HashBiMap r0) {
        return r0.modCount;
    }

    static /* synthetic */ BiEntry[] access$100(HashBiMap r0) {
        return r0.hashTableKToV;
    }

    static /* synthetic */ Object access$1000(HashBiMap r0, Object r1, Object r2, boolean r3) {
        return r0.putInverse(r1, r2, r3);
    }

    static /* synthetic */ void access$200(HashBiMap r0, BiEntry r1) {
        r0.delete(r1);
    }

    static /* synthetic */ int access$300(Object r0) {
        return hash(r0);
    }

    static /* synthetic */ BiEntry access$400(HashBiMap r0, Object r1, int r2) {
        return r0.seekByKey(r1, r2);
    }

    static /* synthetic */ BiEntry access$600(HashBiMap r0, Object r1, int r2) {
        return r0.seekByValue(r1, r2);
    }

    static /* synthetic */ void access$700(HashBiMap r0, BiEntry r1) {
        r0.insert(r1);
    }

    static /* synthetic */ int access$900(HashBiMap r0) {
        return r0.size;
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int r1) {
        return new HashBiMap(r1);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> r1) {
        HashBiMap<K, V> r0 = create(r1.size());
        r0.putAll(r1);
        return r0;
    }

    private HashBiMap(int r1) {
        init(r1);
    }

    private void init(int r3) {
        CollectPreconditions.checkNonnegative(r3, "expectedSize");
        int r4 = Hashing.closedTableSize(r3, 1.0d);
        this.hashTableKToV = createTable(r4);
        this.hashTableVToK = createTable(r4);
        this.mask = r4 - 1;
        this.modCount = 0;
        this.size = 0;
    }

    private void delete(BiEntry<K, V> r6) {
        int r0 = r6.keyHash & this.mask;
        BiEntry<K, V> r1 = this.hashTableKToV[r0];
        BiEntry<K, V> r2 = null;
        BiEntry<K, V> r3 = null;
    L3:
        if (r1 == r6) goto L4;
        r3 = r1;
        r1 = r1.nextInKToVBucket;
        goto L3
    L4:
        if (r3 != null) goto L6;
        this.hashTableKToV[r0] = r6.nextInKToVBucket;
    L7:
        int r4 = r6.valueHash & this.mask;
        BiEntry<K, V> r5 = this.hashTableVToK[r4];
    L8:
        BiEntry<K, V> r7 = r2;
        r2 = r5;
        if (r2 == r6) goto L10;
        r5 = r2.nextInVToKBucket;
        goto L8
    L10:
        if (r7 != null) goto L12;
        this.hashTableVToK[r4] = r6.nextInVToKBucket;
    L13:
        this.size--;
        this.modCount++;
        return;
    L12:
        r7.nextInVToKBucket = r6.nextInVToKBucket;
        goto L13
    L6:
        r3.nextInKToVBucket = r6.nextInKToVBucket;
        goto L7
    }

    private void insert(BiEntry<K, V> r3) {
        int r0 = r3.keyHash & this.mask;
        r3.nextInKToVBucket = this.hashTableKToV[r0];
        this.hashTableKToV[r0] = r3;
        int r1 = r3.valueHash & this.mask;
        r3.nextInVToKBucket = this.hashTableVToK[r1];
        this.hashTableVToK[r1] = r3;
        this.size++;
        this.modCount++;
    }

    private static int hash(@Nullable Object r0) {
        if (r0 != null) goto L4;
        int r1 = 0;
    L6:
        return Hashing.smear(r1);
    L4:
        r1 = r0.hashCode();
        goto L6
    }

    private BiEntry<K, V> seekByKey(@Nullable Object r2, int r3) {
        BiEntry<K, V> r1 = this.hashTableKToV[this.mask & r3];
    L3:
        if (r1 == null) goto L10;
        if (r3 != r1.keyHash) goto L9;
        if (Objects.equal(r2, r1.key) == false) goto L9;
        return r1;
    L9:
        r1 = r1.nextInKToVBucket;
        goto L3
    L10:
        return null;
    }

    private BiEntry<K, V> seekByValue(@Nullable Object r2, int r3) {
        BiEntry<K, V> r1 = this.hashTableVToK[this.mask & r3];
    L3:
        if (r1 == null) goto L10;
        if (r3 != r1.valueHash) goto L9;
        if (Objects.equal(r2, r1.value) == false) goto L9;
        return r1;
    L9:
        r1 = r1.nextInVToKBucket;
        goto L3
    L10:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object r2) {
        if (seekByKey(r2, hash(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@Nullable Object r2) {
        if (seekByValue(r2, hash(r2)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object r2) {
        BiEntry<K, V> r1 = seekByKey(r2, hash(r2));
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public V put(@Nullable K r2, @Nullable V r3) {
        return put(r2, r3, false);
    }

    @Override // com.google.common.collect.BiMap
    public V forcePut(@Nullable K r2, @Nullable V r3) {
        return put(r2, r3, true);
    }

    private V put(@Nullable K r5, @Nullable V r6, boolean r7) {
        int r0 = hash(r5);
        int r1 = hash(r6);
        BiEntry<K, V> r2 = seekByKey(r5, r0);
        if (r2 != null) goto L5;
    L9:
        BiEntry<K, V> r3 = seekByValue(r6, r1);
        if (r3 == null) goto L15;
        if (r7 == false) goto L14;
        delete(r3);
        goto L15
    L14:
        throw new IllegalArgumentException("value already present: " + r6);
    L15:
        if (r2 == null) goto L17;
        delete(r2);
    L17:
        insert(new BiEntry(r5, r0, r6, r1));
        rehashIfNecessary();
        if (r2 != null) goto L21;
        return null;
    L21:
        return r2.value;
    L5:
        if (r1 != r2.valueHash) goto L9;
        if (Objects.equal(r6, r2.value) == false) goto L9;
        return r6;
    }

    @Nullable
    private K putInverse(@Nullable V r5, @Nullable K r6, boolean r7) {
        int r0 = hash(r5);
        int r1 = hash(r6);
        BiEntry<K, V> r2 = seekByValue(r5, r0);
        if (r2 != null) goto L5;
    L9:
        BiEntry<K, V> r3 = seekByKey(r6, r1);
        if (r3 == null) goto L15;
        if (r7 == false) goto L14;
        delete(r3);
        goto L15
    L14:
        throw new IllegalArgumentException("value already present: " + r6);
    L15:
        if (r2 == null) goto L17;
        delete(r2);
    L17:
        insert(new BiEntry(r6, r1, r5, r0));
        rehashIfNecessary();
        if (r2 != null) goto L21;
        return null;
    L21:
        return r2.key;
    L5:
        if (r1 != r2.keyHash) goto L9;
        if (Objects.equal(r6, r2.key) == false) goto L9;
        return r6;
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] r0 = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, r0.length, 1.0d) == false) goto L15;
        int r1 = r0.length * 2;
        this.hashTableKToV = createTable(r1);
        this.hashTableVToK = createTable(r1);
        this.mask = r1 - 1;
        int r2 = 0;
        this.size = 0;
    L6:
        if (r2 >= r0.length) goto L11;
        BiEntry<K, V> r3 = r0[r2];
    L8:
        if (r3 == null) goto L10;
        BiEntry<K, V> r4 = r3.nextInKToVBucket;
        insert(r3);
        r3 = r4;
        goto L8
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        this.modCount++;
        return;
    }

    private BiEntry<K, V>[] createTable(int r1) {
        return new BiEntry[r1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@Nullable Object r2) {
        BiEntry<K, V> r3 = seekByKey(r2, hash(r2));
        if (r3 != null) goto L6;
        return null;
    L6:
        delete(r3);
        return r3.value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new KeySet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        return inverse().keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet(this, null);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        Inverse r1 = new Inverse(this, null);
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    private void writeObject(ObjectOutputStream r1) throws IOException {
        r1.defaultWriteObject();
        Serialization.writeMap(this, r1);
    }

    private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
        r2.defaultReadObject();
        int r0 = Serialization.readCount(r2);
        init(r0);
        Serialization.populateMap(this, r2, r0);
    }
}
