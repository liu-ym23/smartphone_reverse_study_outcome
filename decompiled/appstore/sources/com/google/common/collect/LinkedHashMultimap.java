package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;

    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private transient ValueEntry<K, V> multimapHeaderEntry;

    @VisibleForTesting
    transient int valueSetCapacity;

    @VisibleForTesting
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {

        @NullableDecl
        ValueEntry<K, V> nextInValueBucket;

        @NullableDecl
        ValueEntry<K, V> predecessorInMultimap;

        @NullableDecl
        ValueSetLink<K, V> predecessorInValueSet;
        final int smearedValueHash;

        @NullableDecl
        ValueEntry<K, V> successorInMultimap;

        @NullableDecl
        ValueSetLink<K, V> successorInValueSet;

        public ValueEntry(@NullableDecl K r10, @NullableDecl V r11, int r12, @NullableDecl ValueEntry<K, V> r13) {
            super(r10, r11);
            this.smearedValueHash = r12;
            this.nextInValueBucket = r13;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        public boolean matchesValue(@NullableDecl Object r10, int r11) {
            if (this.smearedValueHash == r11) goto L5;
        L7:
            return false;
        L5:
            if (Objects.equal(getValue(), r10) == false) goto L7;
            return true;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> r10) {
            this.predecessorInMultimap = r10;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setPredecessorInValueSet(ValueSetLink<K, V> r10) {
            this.predecessorInValueSet = r10;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> r10) {
            this.successorInMultimap = r10;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setSuccessorInValueSet(ValueSetLink<K, V> r10) {
            this.successorInValueSet = r10;
        }
    }

    @VisibleForTesting
    public final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        private ValueSetLink<K, V> firstEntry;

        @VisibleForTesting
        ValueEntry<K, V>[] hashTable;
        private final K key;
        private ValueSetLink<K, V> lastEntry;
        private int modCount;
        private int size;
        final /* synthetic */ LinkedHashMultimap this$0;

        public ValueSet(LinkedHashMultimap r10, K r11, int r12) {
            this.this$0 = r10;
            this.size = 0;
            this.modCount = 0;
            this.key = r11;
            this.firstEntry = this;
            this.lastEntry = this;
            this.hashTable = new ValueEntry[Hashing.closedTableSize(r12, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        public static /* synthetic */ ValueSetLink access$000(ValueSet r10) {
            return r10.firstEntry;
        }

        public static /* synthetic */ int access$100(ValueSet r10) {
            return r10.modCount;
        }

        private int mask() {
            return this.hashTable.length - 1;
        }

        private void rehashIfNecessary() {
            if (Hashing.needsResizing(this.size, this.hashTable.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) == false) goto L7;
            int r10 = this.hashTable.length * 2;
            ValueEntry<K, V>[] r11 = new ValueEntry[r10];
            this.hashTable = r11;
            int r12 = r10 - 1;
            ValueSetLink<K, V> r13 = this.firstEntry;
        L5:
            if (r13 == this) goto L9;
            ValueEntry<K, V> r14 = (ValueEntry) r13;
            int r15 = r14.smearedValueHash & r12;
            r14.nextInValueBucket = r11[r15];
            r11[r15] = r14;
            r13 = r13.getSuccessorInValueSet();
            goto L5
        L9:
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@NullableDecl V r10) {
            int r11 = Hashing.smearedHash(r10);
            int r12 = mask() & r11;
            ValueEntry<K, V> r13 = this.hashTable[r12];
            ValueEntry<K, V> r14 = r13;
        L3:
            if (r14 == null) goto L9;
            if (r14.matchesValue(r10, r11) == true) goto L6;
            r14 = r14.nextInValueBucket;
            goto L3
        L6:
            return false;
        L9:
            ValueEntry<K, V> r15 = new ValueEntry(this.key, r10, r11, r13);
            LinkedHashMultimap.access$200(this.lastEntry, r15);
            LinkedHashMultimap.access$200(r15, this);
            LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this.this$0).getPredecessorInMultimap(), r15);
            LinkedHashMultimap.access$400(r15, LinkedHashMultimap.access$300(this.this$0));
            this.hashTable[r12] = r15;
            this.size++;
            this.modCount++;
            rehashIfNecessary();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.hashTable, null);
            this.size = 0;
            ValueSetLink<K, V> r10 = this.firstEntry;
        L3:
            if (r10 == this) goto L5;
            LinkedHashMultimap.access$600((ValueEntry) r10);
            r10 = r10.getSuccessorInValueSet();
            goto L3
        L5:
            LinkedHashMultimap.access$200(this, this);
            this.modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            int r11 = Hashing.smearedHash(r10);
            ValueEntry<K, V> r12 = this.hashTable[mask() & r11];
        L3:
            if (r12 == null) goto L9;
            if (r12.matchesValue(r10, r11) == true) goto L6;
            r12 = r12.nextInValueBucket;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.lastEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.firstEntry;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object r10) {
            int r11 = Hashing.smearedHash(r10);
            int r12 = mask() & r11;
            ValueEntry<K, V> r13 = this.hashTable[r12];
            ValueEntry<K, V> r14 = null;
        L3:
            if (r13 == null) goto L12;
            if (r13.matchesValue(r10, r11) == true) goto L6;
            r14 = r13;
            r13 = r13.nextInValueBucket;
            goto L3
        L6:
            if (r14 != null) goto L8;
            this.hashTable[r12] = r13.nextInValueBucket;
        L9:
            LinkedHashMultimap.access$500(r13);
            LinkedHashMultimap.access$600(r13);
            this.size--;
            this.modCount++;
            return true;
        L8:
            r14.nextInValueBucket = r13.nextInValueBucket;
            goto L9
        L12:
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setPredecessorInValueSet(ValueSetLink<K, V> r10) {
            this.lastEntry = r10;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setSuccessorInValueSet(ValueSetLink<K, V> r10) {
            this.firstEntry = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    public interface ValueSetLink<K, V> {
        ValueSetLink<K, V> getPredecessorInValueSet();

        ValueSetLink<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(ValueSetLink<K, V> r10);

        void setSuccessorInValueSet(ValueSetLink<K, V> r10);
    }

    private LinkedHashMultimap(int r10, int r11) {
        super(Platform.newLinkedHashMapWithExpectedSize(r10));
        this.valueSetCapacity = 2;
        CollectPreconditions.checkNonnegative(r11, "expectedValuesPerKey");
        this.valueSetCapacity = r11;
        ValueEntry<K, V> r12 = new ValueEntry(null, null, 0, null);
        this.multimapHeaderEntry = r12;
        succeedsInMultimap(r12, r12);
    }

    public static /* synthetic */ void access$200(ValueSetLink r10, ValueSetLink r11) {
        succeedsInValueSet(r10, r11);
    }

    public static /* synthetic */ ValueEntry access$300(LinkedHashMultimap r10) {
        return r10.multimapHeaderEntry;
    }

    public static /* synthetic */ void access$400(ValueEntry r10, ValueEntry r11) {
        succeedsInMultimap(r10, r11);
    }

    public static /* synthetic */ void access$500(ValueSetLink r10) {
        deleteFromValueSet(r10);
    }

    public static /* synthetic */ void access$600(ValueEntry r10) {
        deleteFromMultimap(r10);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap(16, 2);
    }

    private static <K, V> void deleteFromMultimap(ValueEntry<K, V> r10) {
        succeedsInMultimap(r10.getPredecessorInMultimap(), r10.getSuccessorInMultimap());
    }

    private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> r10) {
        succeedsInValueSet(r10.getPredecessorInValueSet(), r10.getSuccessorInValueSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r11 = 0;
        ValueEntry<K, V> r12 = new ValueEntry(null, null, 0, null);
        this.multimapHeaderEntry = r12;
        succeedsInMultimap(r12, r12);
        this.valueSetCapacity = 2;
        int r13 = r10.readInt();
        Map r14 = Platform.newLinkedHashMapWithExpectedSize(12);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        Object r16 = r10.readObject();
        r14.put(r16, createCollection(r16));
        r15 = r15 + 1;
        goto L3
    L5:
        int r17 = r10.readInt();
    L6:
        if (r11 >= r17) goto L8;
        Object r18 = r10.readObject();
        ((Collection) r14.get(r18)).add(r10.readObject());
        r11 = r11 + 1;
        goto L6
    L8:
        setMap(r14);
    }

    private static <K, V> void succeedsInMultimap(ValueEntry<K, V> r10, ValueEntry<K, V> r11) {
        r10.setSuccessorInMultimap(r11);
        r11.setPredecessorInMultimap(r10);
    }

    private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> r10, ValueSetLink<K, V> r11) {
        r10.setSuccessorInValueSet(r11);
        r11.setPredecessorInValueSet(r10);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeInt(keySet().size());
        Iterator<K> r11 = keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.writeObject(r11.next());
        goto L4
    L6:
        r10.writeInt(size());
        Iterator<Map.Entry<K, V>> r12 = entries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<K, V> r13 = r12.next();
        r10.writeObject(r13.getKey());
        r10.writeObject(r13.getValue());
        goto L8
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        ValueEntry<K, V> r10 = this.multimapHeaderEntry;
        succeedsInMultimap(r10, r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.containsEntry(r10, r11);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(@NullableDecl Object r10) {
        return super.containsKey(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object r10) {
        return super.containsValue(r10);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set get(@NullableDecl Object r10) {
        return super.get(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.put(r10, r11);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap r10) {
        return super.putAll(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.remove(r10, r11);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(@NullableDecl Object r10) {
        return super.removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@NullableDecl Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public Iterator<V> valueIterator() {
        return Maps.valueIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int r10, int r11) {
        return new LinkedHashMultimap(Maps.capacity(r10), Maps.capacity(r11));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return Platform.newLinkedHashSetWithExpectedSize(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object r10, Iterable r11) {
        return super.putAll(r10, r11);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@NullableDecl K r10, Iterable<? extends V> r11) {
        return super.replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K r10) {
        return new ValueSet(this, r10, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> r10) {
        LinkedHashMultimap<K, V> r11 = create(r10.keySet().size(), 2);
        r11.putAll(r10);
        return r11;
    }
}
