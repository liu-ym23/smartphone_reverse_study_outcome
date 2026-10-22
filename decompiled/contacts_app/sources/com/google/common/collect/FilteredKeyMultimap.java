package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Predicate<? super K> keyPredicate;
    final Multimap<K, V> unfiltered;

    static class AddRejectingList<K, V> extends ForwardingList<V> {
        final K key;

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        AddRejectingList(K r1) {
            this.key = r1;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(V r2) {
            add(0, r2);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r2) {
            addAll(0, r2);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int r2, V r3) {
            Preconditions.checkPositionIndex(r2, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public boolean addAll(int r2, Collection<? extends V> r3) {
            Preconditions.checkNotNull(r3);
            Preconditions.checkPositionIndex(r2, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected List<V> delegate() {
            return Collections.emptyList();
        }
    }

    static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        final K key;

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        AddRejectingSet(K r1) {
            this.key = r1;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(V r3) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r3) {
            Preconditions.checkNotNull(r3);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<V> delegate() {
            return Collections.emptySet();
        }
    }

    class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        final /* synthetic */ FilteredKeyMultimap this$0;

        Entries(FilteredKeyMultimap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<Map.Entry<K, V>> delegate() {
            return Collections2.filter(this.this$0.unfiltered.entries(), this.this$0.entryPredicate());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object r3) {
            if ((r3 instanceof Map.Entry) == false) goto L10;
            Map.Entry r4 = (Map.Entry) r3;
            if (this.this$0.unfiltered.containsKey(r4.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.this$0.keyPredicate.apply((Object) r4.getKey()) == true) goto L9;
            return false;
        L9:
            return this.this$0.unfiltered.remove(r4.getKey(), r4.getValue());
        L10:
            return false;
        }
    }

    FilteredKeyMultimap(Multimap<K, V> r1, Predicate<? super K> r2) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(r1);
        this.keyPredicate = (Predicate) Preconditions.checkNotNull(r2);
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator<Collection<V>> r2 = asMap().values().iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.next().size();
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object r2) {
        if (this.unfiltered.containsKey(r2) == true) goto L5;
        return false;
    L5:
        return this.keyPredicate.apply(r2);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(Object r2) {
        if (containsKey(r2) == false) goto L6;
        return this.unfiltered.removeAll(r2);
    L6:
        return unmodifiableEmptyCollection();
    }

    Collection<V> unmodifiableEmptyCollection() {
        if ((this.unfiltered instanceof SetMultimap) == false) goto L7;
        return ImmutableSet.of();
    L7:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(K r2) {
        if (this.keyPredicate.apply(r2) == false) goto L7;
        return this.unfiltered.get(r2);
    L7:
        if ((this.unfiltered instanceof SetMultimap) == false) goto L11;
        return new AddRejectingSet(r2);
    L11:
        return new AddRejectingList(r2);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> createEntries() {
        return new Entries(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }
}
