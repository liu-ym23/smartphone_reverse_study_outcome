package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient Multiset<K> keys;
    private transient Collection<V> values;

    /* JADX INFO: renamed from: com.google.common.collect.AbstractMultimap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class Entries extends Multimaps.Entries<K, V> {
        final /* synthetic */ AbstractMultimap this$0;

        private Entries(AbstractMultimap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Entries(AbstractMultimap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.Multimaps.Entries
        Multimap<K, V> multimap() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.this$0.entryIterator();
        }
    }

    private class EntrySet extends AbstractMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        final /* synthetic */ AbstractMultimap this$0;

        private EntrySet(AbstractMultimap r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ EntrySet(AbstractMultimap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r1) {
            return Sets.equalsImpl(this, r1);
        }
    }

    class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractMultimap this$0;

        Values(AbstractMultimap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }
    }

    abstract Map<K, Collection<V>> createAsMap();

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    AbstractMultimap() {
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@Nullable Object r2) {
        Iterator<Collection<V>> r1 = asMap().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().contains(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@Nullable Object r1, @Nullable Object r2) {
        Collection<V> r0 = asMap().get(r1);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r2) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(@Nullable Object r1, @Nullable Object r2) {
        Collection<V> r0 = asMap().get(r1);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.remove(r2) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(@Nullable K r1, @Nullable V r2) {
        return get(r1).add(r2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(@Nullable K r4, Iterable<? extends V> r5) {
        Preconditions.checkNotNull(r5);
        if ((r5 instanceof Collection) == false) goto L11;
        Collection<? extends V> r6 = (Collection) r5;
        if (r6.isEmpty() == true) goto L10;
        if (get(r4).addAll(r6) == false) goto L10;
        return true;
    L10:
        return false;
    L11:
        Iterator<? extends V> r7 = r5.iterator();
        if (r7.hasNext() == false) goto L17;
        if (Iterators.addAll(get(r4), r7) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> r4) {
        Iterator<Map.Entry<? extends K, ? extends V>> r5 = r4.entries().iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r1 = r5.next();
        r0 = r0 | put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> replaceValues(@Nullable K r2, Iterable<? extends V> r3) {
        Preconditions.checkNotNull(r3);
        Collection<V> r0 = removeAll(r2);
        putAll(r2, r3);
        return r0;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> r0 = this.entries;
        if (r0 != null) goto L6;
        Collection<Map.Entry<K, V>> r1 = createEntries();
        this.entries = r1;
        return r1;
    L6:
        return r0;
    }

    Collection<Map.Entry<K, V>> createEntries() {
        AnonymousClass1 r1 = null;
        if ((this instanceof SetMultimap) == false) goto L7;
        return new EntrySet(this, r1);
    L7:
        return new Entries(this, r1);
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        Set<K> r0 = this.keySet;
        if (r0 != null) goto L6;
        Set<K> r1 = createKeySet();
        this.keySet = r1;
        return r1;
    L6:
        return r0;
    }

    Set<K> createKeySet() {
        return new Maps.KeySet(asMap());
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        Multiset<K> r0 = this.keys;
        if (r0 != null) goto L6;
        Multiset<K> r1 = createKeys();
        this.keys = r1;
        return r1;
    L6:
        return r0;
    }

    Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L6;
        Collection<V> r1 = createValues();
        this.values = r1;
        return r1;
    L6:
        return r0;
    }

    Collection<V> createValues() {
        return new Values(this);
    }

    Iterator<V> valueIterator() {
        return Maps.valueIterator(entries().iterator());
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> r0 = this.asMap;
        if (r0 != null) goto L6;
        Map<K, Collection<V>> r1 = createAsMap();
        this.asMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public boolean equals(@Nullable Object r1) {
        return Multimaps.equalsImpl(this, r1);
    }

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
