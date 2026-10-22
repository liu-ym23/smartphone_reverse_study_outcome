package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {

    @MonotonicNonNullDecl
    private transient Map<K, Collection<V>> asMap;

    @MonotonicNonNullDecl
    private transient Collection<Map.Entry<K, V>> entries;

    @MonotonicNonNullDecl
    private transient Set<K> keySet;

    @MonotonicNonNullDecl
    private transient Multiset<K> keys;

    @MonotonicNonNullDecl
    private transient Collection<V> values;

    public class Entries extends Multimaps.Entries<K, V> {
        final /* synthetic */ AbstractMultimap this$0;

        public Entries(AbstractMultimap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.this$0.entryIterator();
        }

        @Override // com.google.common.collect.Multimaps.Entries
        public Multimap<K, V> multimap() {
            return this.this$0;
        }
    }

    public class EntrySet extends AbstractMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        final /* synthetic */ AbstractMultimap this$0;

        public EntrySet(AbstractMultimap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object r10) {
            return Sets.equalsImpl(this, r10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractMultimap this$0;

        public Values(AbstractMultimap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object r10) {
            return this.this$0.containsValue(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }
    }

    public AbstractMultimap() {
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> r10 = this.asMap;
        if (r10 != null) goto L6;
        Map<K, Collection<V>> r11 = createAsMap();
        this.asMap = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@NullableDecl Object r10, @NullableDecl Object r11) {
        Collection<V> r12 = asMap().get(r10);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.contains(r11) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object r10) {
        Iterator<Collection<V>> r11 = asMap().values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r11.next().contains(r10) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract Multiset<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> r10 = this.entries;
        if (r10 != null) goto L6;
        Collection<Map.Entry<K, V>> r11 = createEntries();
        this.entries = r11;
        return r11;
    L6:
        return r10;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public boolean equals(@NullableDecl Object r10) {
        return Multimaps.equalsImpl(this, r10);
    }

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        Set<K> r10 = this.keySet;
        if (r10 != null) goto L6;
        Set<K> r11 = createKeySet();
        this.keySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        Multiset<K> r10 = this.keys;
        if (r10 != null) goto L6;
        Multiset<K> r11 = createKeys();
        this.keys = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K r10, @NullableDecl V r11) {
        return get(r10).add(r11);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean putAll(@NullableDecl K r10, Iterable<? extends V> r11) {
        Preconditions.checkNotNull(r11);
        if ((r11 instanceof Collection) == false) goto L10;
        Collection<? extends V> r12 = (Collection) r11;
        if (r12.isEmpty() == false) goto L7;
        return false;
    L7:
        if (get(r10).addAll(r12) == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        Iterator<? extends V> r13 = r11.iterator();
        if (r13.hasNext() == true) goto L13;
        return false;
    L13:
        if (Iterators.addAll(get(r10), r13) == true) goto L15;
        return false;
    L15:
        return true;
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        Collection<V> r12 = asMap().get(r10);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.remove(r11) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public Collection<V> replaceValues(@NullableDecl K r10, Iterable<? extends V> r11) {
        Preconditions.checkNotNull(r11);
        Collection<V> r12 = removeAll(r10);
        putAll(r10, r11);
        return r12;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return Maps.valueIterator(entries().iterator());
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> values() {
        Collection<V> r10 = this.values;
        if (r10 != null) goto L6;
        Collection<V> r11 = createValues();
        this.values = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean putAll(Multimap<? extends K, ? extends V> r10) {
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entries().iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r13 = r11.next();
        r12 = r12 | put(r13.getKey(), r13.getValue());
        goto L4
    L6:
        return r12;
    }
}
