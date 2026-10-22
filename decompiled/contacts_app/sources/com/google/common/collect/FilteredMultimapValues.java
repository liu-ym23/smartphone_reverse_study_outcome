package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class FilteredMultimapValues<K, V> extends AbstractCollection<V> {
    private final FilteredMultimap<K, V> multimap;

    FilteredMultimapValues(FilteredMultimap<K, V> r1) {
        this.multimap = (FilteredMultimap) Preconditions.checkNotNull(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return Maps.valueIterator(this.multimap.entries().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@Nullable Object r1) {
        return this.multimap.containsValue(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.multimap.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@Nullable Object r4) {
        Predicate<? super Map.Entry<K, V>> r0 = this.multimap.entryPredicate();
        Iterator<Map.Entry<K, V>> r3 = this.multimap.unfiltered().entries().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Map.Entry<K, V> r1 = r3.next();
        if (r0.apply(r1) == false) goto L4;
        if (Objects.equal(r1.getValue(), r4) == false) goto L4;
        r3.remove();
        return true;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> r2) {
        return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.in(r2))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> r2) {
        return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(r2)))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.multimap.clear();
    }
}
