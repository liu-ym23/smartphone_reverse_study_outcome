package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;

    @NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @RetainedWith
    @MonotonicNonNullDecl
    private transient BiMap<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;

    @NullableDecl
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    public final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;

        @NullableDecl
        final K key;
        final /* synthetic */ HashBiMap this$0;

        public EntryForKey(HashBiMap r10, int r11) {
            this.this$0 = r10;
            this.key = r10.keys[r11];
            this.index = r11;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            updateIndex();
            int r10 = this.index;
            if (r10 != (-1)) goto L6;
            return null;
        L6:
            return this.this$0.values[r10];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V r10) {
            updateIndex();
            int r11 = this.index;
            if (r11 == (-1)) goto L5;
            V r12 = this.this$0.values[r11];
            if (Objects.equal(r12, r10) == false) goto L9;
            return r10;
        L9:
            HashBiMap.access$200(this.this$0, this.index, r10, false);
            return r12;
        L5:
            return (V) this.this$0.put(this.key, r10);
        }

        public void updateIndex() {
            int r10 = this.index;
            if (r10 == (-1)) goto L8;
            HashBiMap r11 = this.this$0;
            if (r10 > r11.size) goto L8;
            if (Objects.equal(r11.keys[r10], this.key) == false) goto L8;
            return;
        L8:
            this.index = this.this$0.findEntryByKey(this.key);
        }
    }

    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;
        final V value;

        public EntryForValue(HashBiMap<K, V> r10, int r11) {
            this.biMap = r10;
            this.value = r10.values[r11];
            this.index = r11;
        }

        private void updateIndex() {
            int r10 = this.index;
            if (r10 == (-1)) goto L8;
            HashBiMap<K, V> r11 = this.biMap;
            if (r10 > r11.size) goto L8;
            if (Objects.equal(this.value, r11.values[r10]) == false) goto L8;
            return;
        L8:
            this.index = this.biMap.findEntryByValue(this.value);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getKey() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getValue() {
            updateIndex();
            int r10 = this.index;
            if (r10 != (-1)) goto L6;
            return null;
        L6:
            return this.biMap.keys[r10];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K setValue(K r10) {
            updateIndex();
            int r11 = this.index;
            if (r11 == (-1)) goto L5;
            K r12 = this.biMap.keys[r11];
            if (Objects.equal(r12, r10) == false) goto L9;
            return r10;
        L9:
            HashBiMap.access$400(this.biMap, this.index, r10, false);
            return r12;
        L5:
            return this.biMap.putInverse(this.value, r10, false);
        }
    }

    public final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        final /* synthetic */ HashBiMap this$0;

        public EntrySet(HashBiMap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            Object r13 = r11.getValue();
            int r14 = this.this$0.findEntryByKey(r12);
            if (r14 != (-1)) goto L7;
            return false;
        L7:
            if (Objects.equal(r13, this.this$0.values[r14]) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.HashBiMap.View
        public /* bridge */ /* synthetic */ Object forEntry(int r10) {
            return forEntry(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            Object r13 = r11.getValue();
            int r14 = Hashing.smearedHash(r12);
            int r15 = this.this$0.findEntryByKey(r12, r14);
            if (r15 != (-1)) goto L7;
            return false;
        L7:
            if (Objects.equal(r13, this.this$0.values[r15]) == false) goto L13;
            this.this$0.removeEntryKeyHashKnown(r15, r14);
            return true;
        L13:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<K, V> forEntry(int r10) {
            return new EntryForKey(this.this$0, r10);
        }
    }

    public static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> r10) {
            this.forward = r10;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream r10) throws ClassNotFoundException, IOException {
            r10.defaultReadObject();
            HashBiMap.access$302(this.forward, this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            return this.forward.containsValue(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object r10) {
            return this.forward.containsKey(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> r10 = this.inverseEntrySet;
            if (r10 != null) goto L6;
            InverseEntrySet r11 = new InverseEntrySet(this.forward);
            this.inverseEntrySet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K forcePut(@NullableDecl V r10, @NullableDecl K r11) {
            return this.forward.putInverse(r10, r11, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object r10) {
            return this.forward.getInverse(r10);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K put(@NullableDecl V r10, @NullableDecl K r11) {
            return this.forward.putInverse(r10, r11, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K remove(@NullableDecl Object r10) {
            return this.forward.removeInverse(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    public static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        public InverseEntrySet(HashBiMap<K, V> r10) {
            super(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            Object r13 = r11.getValue();
            int r14 = this.biMap.findEntryByValue(r12);
            if (r14 != (-1)) goto L7;
            return false;
        L7:
            if (Objects.equal(this.biMap.keys[r14], r13) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.HashBiMap.View
        public /* bridge */ /* synthetic */ Object forEntry(int r10) {
            return forEntry(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            Object r13 = r11.getValue();
            int r14 = Hashing.smearedHash(r12);
            int r15 = this.biMap.findEntryByValue(r12, r14);
            if (r15 != (-1)) goto L7;
            return false;
        L7:
            if (Objects.equal(this.biMap.keys[r15], r13) == false) goto L13;
            this.biMap.removeEntryValueHashKnown(r15, r14);
            return true;
        L13:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<V, K> forEntry(int r10) {
            return new EntryForValue(this.biMap, r10);
        }
    }

    public final class KeySet extends View<K, V, K> {
        final /* synthetic */ HashBiMap this$0;

        public KeySet(HashBiMap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            return this.this$0.containsKey(r10);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public K forEntry(int r10) {
            return this.this$0.keys[r10];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object r10) {
            int r11 = Hashing.smearedHash(r10);
            int r12 = this.this$0.findEntryByKey(r10, r11);
            if (r12 == (-1)) goto L6;
            this.this$0.removeEntryKeyHashKnown(r12, r11);
            return true;
        L6:
            return false;
        }
    }

    public final class ValueSet extends View<K, V, V> {
        final /* synthetic */ HashBiMap this$0;

        public ValueSet(HashBiMap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            return this.this$0.containsValue(r10);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public V forEntry(int r10) {
            return this.this$0.values[r10];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object r10) {
            int r11 = Hashing.smearedHash(r10);
            int r12 = this.this$0.findEntryByValue(r10, r11);
            if (r12 == (-1)) goto L6;
            this.this$0.removeEntryValueHashKnown(r12, r11);
            return true;
        L6:
            return false;
        }
    }

    public static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        public View(HashBiMap<K, V> r10) {
            this.biMap = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.biMap.clear();
        }

        public abstract T forEntry(int r10);

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.biMap.size;
        }
    }

    private HashBiMap(int r10) {
        init(r10);
    }

    public static /* synthetic */ int access$000(HashBiMap r10) {
        return r10.firstInInsertionOrder;
    }

    public static /* synthetic */ int[] access$100(HashBiMap r10) {
        return r10.nextInInsertionOrder;
    }

    public static /* synthetic */ void access$200(HashBiMap r10, int r11, Object r12, boolean r13) {
        r10.replaceValueInEntry(r11, r12, r13);
    }

    public static /* synthetic */ BiMap access$302(HashBiMap r10, BiMap r11) {
        r10.inverse = r11;
        return r11;
    }

    public static /* synthetic */ void access$400(HashBiMap r10, int r11, Object r12, boolean r13) {
        r10.replaceKeyInEntry(r11, r12, r13);
    }

    private int bucket(int r10) {
        return (this.hashTableKToV.length - 1) & r10;
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int r10) {
        int[] r11 = new int[r10];
        Arrays.fill(r11, -1);
        return r11;
    }

    private void deleteFromTableKToV(int r10, int r11) {
        if (r10 == (-1)) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = bucket(r11);
        int[] r14 = this.hashTableKToV;
        int r15 = r14[r13];
        if (r15 != r10) goto L10;
        int[] r16 = this.nextInBucketKToV;
        r14[r13] = r16[r10];
        r16[r10] = -1;
        return;
    L10:
        int r17 = this.nextInBucketKToV[r15];
    L11:
        int r18 = r15;
        r15 = r17;
        if (r15 == (-1)) goto L18;
        if (r15 == r10) goto L14;
        r17 = this.nextInBucketKToV[r15];
        goto L11
    L14:
        int[] r19 = this.nextInBucketKToV;
        r19[r18] = r19[r10];
        r19[r10] = -1;
        return;
    L18:
        throw new AssertionError("Expected to find entry with key " + this.keys[r10]);
    L5:
        r12 = false;
        goto L6
    }

    private void deleteFromTableVToK(int r10, int r11) {
        if (r10 == (-1)) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = bucket(r11);
        int[] r14 = this.hashTableVToK;
        int r15 = r14[r13];
        if (r15 != r10) goto L10;
        int[] r16 = this.nextInBucketVToK;
        r14[r13] = r16[r10];
        r16[r10] = -1;
        return;
    L10:
        int r17 = this.nextInBucketVToK[r15];
    L11:
        int r18 = r15;
        r15 = r17;
        if (r15 == (-1)) goto L18;
        if (r15 == r10) goto L14;
        r17 = this.nextInBucketVToK[r15];
        goto L11
    L14:
        int[] r19 = this.nextInBucketVToK;
        r19[r18] = r19[r10];
        r19[r10] = -1;
        return;
    L18:
        throw new AssertionError("Expected to find entry with value " + this.values[r10]);
    L5:
        r12 = false;
        goto L6
    }

    private void ensureCapacity(int r10) {
        int[] r11 = this.nextInBucketKToV;
        if (r11.length >= r10) goto L6;
        int r12 = ImmutableCollection.Builder.expandedCapacity(r11.length, r10);
        this.keys = (K[]) Arrays.copyOf(this.keys, r12);
        this.values = (V[]) Arrays.copyOf(this.values, r12);
        this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, r12);
        this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, r12);
        this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, r12);
        this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, r12);
    L6:
        if (this.hashTableKToV.length >= r10) goto L11;
        int r13 = Hashing.closedTableSize(r10, 1.0d);
        this.hashTableKToV = createFilledWithAbsent(r13);
        this.hashTableVToK = createFilledWithAbsent(r13);
        int r14 = 0;
    L9:
        if (r14 >= this.size) goto L13;
        int r15 = bucket(Hashing.smearedHash(this.keys[r14]));
        int[] r16 = this.nextInBucketKToV;
        int[] r17 = this.hashTableKToV;
        r16[r14] = r17[r15];
        r17[r15] = r14;
        int r18 = bucket(Hashing.smearedHash(this.values[r14]));
        int[] r19 = this.nextInBucketVToK;
        int[] r20 = this.hashTableVToK;
        r19[r14] = r20[r18];
        r20[r18] = r14;
        r14 = r14 + 1;
        goto L9
    L13:
        return;
    }

    private static int[] expandAndFillWithAbsent(int[] r10, int r11) {
        int r12 = r10.length;
        int[] r13 = Arrays.copyOf(r10, r11);
        Arrays.fill(r13, r12, r11, -1);
        return r13;
    }

    private void insertIntoTableKToV(int r10, int r11) {
        if (r10 == (-1)) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = bucket(r11);
        int[] r14 = this.nextInBucketKToV;
        int[] r15 = this.hashTableKToV;
        r14[r10] = r15[r13];
        r15[r13] = r10;
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void insertIntoTableVToK(int r10, int r11) {
        if (r10 == (-1)) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = bucket(r11);
        int[] r14 = this.nextInBucketVToK;
        int[] r15 = this.hashTableVToK;
        r14[r10] = r15[r13];
        r15[r13] = r10;
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void moveEntryToIndex(int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        int r12 = this.prevInInsertionOrder[r10];
        int r13 = this.nextInInsertionOrder[r10];
        setSucceeds(r12, r11);
        setSucceeds(r11, r13);
        K[] r14 = this.keys;
        K r15 = r14[r10];
        V[] r16 = this.values;
        V r17 = r16[r10];
        r14[r11] = r15;
        r16[r11] = r17;
        int r18 = bucket(Hashing.smearedHash(r15));
        int[] r19 = this.hashTableKToV;
        int r20 = r19[r18];
        if (r20 != r10) goto L7;
        r19[r18] = r11;
    L11:
        int[] r21 = this.nextInBucketKToV;
        r21[r11] = r21[r10];
        r21[r10] = -1;
        int r22 = bucket(Hashing.smearedHash(r17));
        int[] r23 = this.hashTableVToK;
        int r24 = r23[r22];
        if (r24 != r10) goto L14;
        r23[r22] = r11;
    L18:
        int[] r25 = this.nextInBucketVToK;
        r25[r11] = r25[r10];
        r25[r10] = -1;
        return;
    L14:
        int r26 = this.nextInBucketVToK[r24];
    L15:
        int r27 = r24;
        r24 = r26;
        if (r24 == r10) goto L17;
        r26 = this.nextInBucketVToK[r24];
        goto L15
    L17:
        this.nextInBucketVToK[r27] = r11;
        goto L18
    L7:
        int r28 = this.nextInBucketKToV[r20];
    L8:
        int r29 = r20;
        r20 = r28;
        if (r20 == r10) goto L10;
        r28 = this.nextInBucketKToV[r20];
        goto L8
    L10:
        this.nextInBucketKToV[r29] = r11;
        goto L11
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r11 = Serialization.readCount(r10);
        init(16);
        Serialization.populateMap(this, r10, r11);
    }

    private void replaceKeyInEntry(int r10, @NullableDecl K r11, boolean r12) {
        if (r10 == (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13);
        int r14 = Hashing.smearedHash(r11);
        int r15 = findEntryByKey(r11, r14);
        int r16 = this.lastInInsertionOrder;
        if (r15 == (-1)) goto L14;
        if (r12 == false) goto L13;
        r16 = this.prevInInsertionOrder[r15];
        int r17 = this.nextInInsertionOrder[r15];
        removeEntryKeyHashKnown(r15, r14);
        if (r10 != this.size) goto L15;
        r10 = r15;
    L15:
        if (r16 != r10) goto L18;
        r16 = this.prevInInsertionOrder[r10];
    L20:
        if (r17 != r10) goto L23;
        r15 = this.nextInInsertionOrder[r10];
    L26:
        setSucceeds(this.prevInInsertionOrder[r10], this.nextInInsertionOrder[r10]);
        deleteFromTableKToV(r10, Hashing.smearedHash(this.keys[r10]));
        this.keys[r10] = r11;
        insertIntoTableKToV(r10, Hashing.smearedHash(r11));
        setSucceeds(r16, r10);
        setSucceeds(r10, r15);
        return;
    L23:
        if (r17 == this.size) goto L26;
        r15 = r17;
        goto L26
    L18:
        if (r16 != this.size) goto L20;
        r16 = r15;
        goto L20
    L13:
        throw new IllegalArgumentException("Key already present in map: " + r11);
    L14:
        r17 = -2;
        goto L15
    L5:
        r13 = false;
        goto L6
    }

    private void replaceValueInEntry(int r10, @NullableDecl V r11, boolean r12) {
        if (r10 == (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13);
        int r14 = Hashing.smearedHash(r11);
        int r15 = findEntryByValue(r11, r14);
        if (r15 == (-1)) goto L14;
        if (r12 == false) goto L13;
        removeEntryValueHashKnown(r15, r14);
        if (r10 != this.size) goto L14;
        r10 = r15;
        goto L14
    L13:
        throw new IllegalArgumentException("Value already present in map: " + r11);
    L14:
        deleteFromTableVToK(r10, Hashing.smearedHash(this.values[r10]));
        this.values[r10] = r11;
        insertIntoTableVToK(r10, r14);
        return;
    L5:
        r13 = false;
        goto L6
    }

    private void setSucceeds(int r10, int r11) {
        if (r10 != (-2)) goto L5;
        this.firstInInsertionOrder = r11;
    L6:
        if (r11 != (-2)) goto L8;
        this.lastInInsertionOrder = r10;
        return;
    L8:
        this.prevInInsertionOrder[r11] = r10;
        return;
    L5:
        this.nextInInsertionOrder[r10] = r11;
        goto L6
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        Serialization.writeMap(this, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object r10) {
        if (findEntryByKey(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object r10) {
        if (findEntryByValue(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r10 = this.entrySet;
        if (r10 != null) goto L6;
        EntrySet r11 = new EntrySet(this);
        this.entrySet = r11;
        return r11;
    L6:
        return r10;
    }

    public int findEntry(@NullableDecl Object r10, int r11, int[] r12, int[] r13, Object[] r14) {
        int r15 = r12[bucket(r11)];
    L4:
        if (r15 == (-1)) goto L9;
        if (Objects.equal(r14[r15], r10) == true) goto L7;
        r15 = r13[r15];
        goto L4
    L7:
        return r15;
    L9:
        return -1;
    }

    public int findEntryByKey(@NullableDecl Object r10) {
        return findEntryByKey(r10, Hashing.smearedHash(r10));
    }

    public int findEntryByValue(@NullableDecl Object r10) {
        return findEntryByValue(r10, Hashing.smearedHash(r10));
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @NullableDecl
    public V forcePut(@NullableDecl K r10, @NullableDecl V r11) {
        return put(r10, r11, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object r10) {
        int r11 = findEntryByKey(r10);
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return this.values[r11];
    }

    @NullableDecl
    public K getInverse(@NullableDecl Object r10) {
        int r11 = findEntryByValue(r10);
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return this.keys[r11];
    }

    public void init(int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedSize");
        int r11 = Hashing.closedTableSize(r10, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[r10];
        this.values = (V[]) new Object[r10];
        this.hashTableKToV = createFilledWithAbsent(r11);
        this.hashTableVToK = createFilledWithAbsent(r11);
        this.nextInBucketKToV = createFilledWithAbsent(r10);
        this.nextInBucketVToK = createFilledWithAbsent(r10);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(r10);
        this.nextInInsertionOrder = createFilledWithAbsent(r10);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> r10 = this.inverse;
        if (r10 != null) goto L6;
        Inverse r11 = new Inverse(this);
        this.inverse = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r10 = this.keySet;
        if (r10 != null) goto L6;
        KeySet r11 = new KeySet(this);
        this.keySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K r10, @NullableDecl V r11) {
        return put(r10, r11, false);
    }

    @NullableDecl
    public K putInverse(@NullableDecl V r10, @NullableDecl K r11, boolean r12) {
        int r13 = Hashing.smearedHash(r10);
        int r14 = findEntryByValue(r10, r13);
        if (r14 == (-1)) goto L9;
        K r15 = this.keys[r14];
        if (Objects.equal(r15, r11) == false) goto L7;
        return r11;
    L7:
        replaceKeyInEntry(r14, r11, r12);
        return r15;
    L9:
        int r16 = this.lastInInsertionOrder;
        int r17 = Hashing.smearedHash(r11);
        int r18 = findEntryByKey(r11, r17);
        if (r12 == false) goto L13;
        if (r18 == (-1)) goto L17;
        r16 = this.prevInInsertionOrder[r18];
        removeEntryKeyHashKnown(r18, r17);
    L17:
        ensureCapacity(this.size + 1);
        K[] r19 = this.keys;
        int r20 = this.size;
        r19[r20] = r11;
        this.values[r20] = r10;
        insertIntoTableKToV(r20, r17);
        insertIntoTableVToK(this.size, r13);
        if (r16 != (-2)) goto L20;
        int r21 = this.firstInInsertionOrder;
    L21:
        setSucceeds(r16, this.size);
        setSucceeds(this.size, r21);
        this.size++;
        this.modCount++;
        return null;
    L20:
        r21 = this.nextInInsertionOrder[r16];
        goto L21
    L13:
        if (r18 != (-1)) goto L15;
        boolean r22 = true;
    L16:
        Preconditions.checkArgument(r22, "Key already present: %s", r11);
        goto L17
    L15:
        r22 = false;
        goto L16
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object r10) {
        int r11 = Hashing.smearedHash(r10);
        int r12 = findEntryByKey(r10, r11);
        if (r12 != (-1)) goto L6;
        return null;
    L6:
        V r13 = this.values[r12];
        removeEntryKeyHashKnown(r12, r11);
        return r13;
    }

    public void removeEntry(int r10) {
        removeEntryKeyHashKnown(r10, Hashing.smearedHash(this.keys[r10]));
    }

    public void removeEntryKeyHashKnown(int r10, int r11) {
        removeEntry(r10, r11, Hashing.smearedHash(this.values[r10]));
    }

    public void removeEntryValueHashKnown(int r10, int r11) {
        removeEntry(r10, Hashing.smearedHash(this.keys[r10]), r11);
    }

    @NullableDecl
    public K removeInverse(@NullableDecl Object r10) {
        int r11 = Hashing.smearedHash(r10);
        int r12 = findEntryByValue(r10, r11);
        if (r12 != (-1)) goto L6;
        return null;
    L6:
        K r13 = this.keys[r12];
        removeEntryValueHashKnown(r12, r11);
        return r13;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> HashBiMap<K, V> create(int r10) {
        return new HashBiMap(r10);
    }

    private void removeEntry(int r10, int r11, int r12) {
        if (r10 == (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13);
        deleteFromTableKToV(r10, r11);
        deleteFromTableVToK(r10, r12);
        setSucceeds(this.prevInInsertionOrder[r10], this.nextInInsertionOrder[r10]);
        moveEntryToIndex(this.size - 1, r10);
        K[] r14 = this.keys;
        int r15 = this.size;
        r14[r15 - 1] = null;
        this.values[r15 - 1] = null;
        this.size = r15 - 1;
        this.modCount++;
        return;
    L5:
        r13 = false;
        goto L6
    }

    public int findEntryByKey(@NullableDecl Object r10, int r11) {
        return findEntry(r10, r11, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(@NullableDecl Object r10, int r11) {
        return findEntry(r10, r11, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @NullableDecl
    public V put(@NullableDecl K r10, @NullableDecl V r11, boolean r12) {
        int r13 = Hashing.smearedHash(r10);
        int r14 = findEntryByKey(r10, r13);
        if (r14 == (-1)) goto L9;
        V r15 = this.values[r14];
        if (Objects.equal(r15, r11) == false) goto L7;
        return r11;
    L7:
        replaceValueInEntry(r14, r11, r12);
        return r15;
    L9:
        int r16 = Hashing.smearedHash(r11);
        int r17 = findEntryByValue(r11, r16);
        if (r12 == false) goto L13;
        if (r17 == (-1)) goto L17;
        removeEntryValueHashKnown(r17, r16);
    L17:
        ensureCapacity(this.size + 1);
        K[] r18 = this.keys;
        int r19 = this.size;
        r18[r19] = r10;
        this.values[r19] = r11;
        insertIntoTableKToV(r19, r13);
        insertIntoTableVToK(this.size, r16);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    L13:
        if (r17 != (-1)) goto L15;
        boolean r20 = true;
    L16:
        Preconditions.checkArgument(r20, "Value already present: %s", r11);
        goto L17
    L15:
        r20 = false;
        goto L16
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> r10 = this.valueSet;
        if (r10 != null) goto L6;
        ValueSet r11 = new ValueSet(this);
        this.valueSet = r11;
        return r11;
    L6:
        return r10;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> r10) {
        HashBiMap<K, V> r11 = create(r10.size());
        r11.putAll(r10);
        return r11;
    }
}
