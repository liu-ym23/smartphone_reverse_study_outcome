package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Predicate<? super K> keyPredicate;
    final Multimap<K, V> unfiltered;

    public static class AddRejectingList<K, V> extends ForwardingList<V> {
        final K key;

        public AddRejectingList(K r10) {
            this.key = r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V r10) {
            add(0, r10);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r10) {
            addAll(0, r10);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int r10, V r11) {
            Preconditions.checkPositionIndex(r10, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int r10, Collection<? extends V> r11) {
            Preconditions.checkNotNull(r11);
            Preconditions.checkPositionIndex(r10, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public List<V> delegate() {
            return Collections.emptyList();
        }
    }

    public static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        final K key;

        public AddRejectingSet(K r10) {
            this.key = r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V r10) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r10) {
            Preconditions.checkNotNull(r10);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }

    public class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        final /* synthetic */ FilteredKeyMultimap this$0;

        public Entries(FilteredKeyMultimap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            if (this.this$0.unfiltered.containsKey(r11.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.this$0.keyPredicate.apply((Object) r11.getKey()) == true) goto L9;
            return false;
        L9:
            return this.this$0.unfiltered.remove(r11.getKey(), r11.getValue());
        L10:
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return Collections2.filter(this.this$0.unfiltered.entries(), this.this$0.entryPredicate());
        }
    }

    public FilteredKeyMultimap(Multimap<K, V> r10, Predicate<? super K> r11) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(r10);
        this.keyPredicate = (Predicate) Preconditions.checkNotNull(r11);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object r10) {
        if (this.unfiltered.containsKey(r10) == true) goto L5;
        return false;
    L5:
        return this.keyPredicate.apply(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return new Entries(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(K r10) {
        if (this.keyPredicate.apply(r10) == false) goto L7;
        return this.unfiltered.get(r10);
    L7:
        if ((this.unfiltered instanceof SetMultimap) == false) goto L11;
        return new AddRejectingSet(r10);
    L11:
        return new AddRejectingList(r10);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(Object r10) {
        if (containsKey(r10) == false) goto L6;
        return this.unfiltered.removeAll(r10);
    L6:
        return unmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator<Collection<V>> r10 = asMap().values().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.next().size();
        goto L4
    L6:
        return r11;
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        if ((this.unfiltered instanceof SetMultimap) == false) goto L7;
        return ImmutableSet.of();
    L7:
        return ImmutableList.of();
    }
}
