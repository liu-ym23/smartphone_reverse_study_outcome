package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Predicate<? super Map.Entry<K, V>> predicate;
    final Multimap<K, V> unfiltered;

    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        final /* synthetic */ FilteredEntryMultimap this$0;

        public AsMap(FilteredEntryMultimap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            if (get(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<K> createKeySet() {
            return new C1KeySetImpl(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<Collection<V>> createValues() {
            return new C1ValuesImpl(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(@NullableDecl Object r10) {
            return get(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object r10) {
            return remove(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(@NullableDecl Object r10) {
            Collection<V> r11 = this.this$0.unfiltered.asMap().get(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            Collection<V> r12 = FilteredEntryMultimap.filterCollection(r11, new ValuePredicate(this.this$0, r10));
            if (r12.isEmpty() == false) goto L9;
            return null;
        L9:
            return r12;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(@NullableDecl Object r10) {
            Collection<V> r11 = this.this$0.unfiltered.asMap().get(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            ArrayList r12 = Lists.newArrayList();
            Iterator<V> r13 = r11.iterator();
        L7:
            if (r13.hasNext() == false) goto L12;
            V r14 = r13.next();
            if (FilteredEntryMultimap.access$000(this.this$0, r10, r14) == false) goto L7;
            r13.remove();
            r12.add(r14);
            goto L7
        L12:
            if (r12.isEmpty() == false) goto L15;
            return null;
        L15:
            if ((this.this$0.unfiltered instanceof SetMultimap) == false) goto L19;
            return Collections.unmodifiableSet(Sets.newLinkedHashSet(r12));
        L19:
            return Collections.unmodifiableList(r12);
        }
    }

    public class Keys extends Multimaps.Keys<K, V> {
        final /* synthetic */ FilteredEntryMultimap this$0;

        public Keys(FilteredEntryMultimap r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<K>> entrySet() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.Multimaps.Keys, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object r10, int r11) {
            CollectPreconditions.checkNonnegative(r11, "occurrences");
            if (r11 == 0) goto L5;
            Collection<V> r12 = this.this$0.unfiltered.asMap().get(r10);
            int r13 = 0;
            if (r12 != null) goto L9;
            return 0;
        L9:
            Iterator<V> r14 = r12.iterator();
        L11:
            if (r14.hasNext() == false) goto L17;
            V r15 = r14.next();
            if (FilteredEntryMultimap.access$000(this.this$0, r10, r15) == false) goto L11;
            r13 = r13 + 1;
            if (r13 > r11) goto L11;
            r14.remove();
            goto L11
        L17:
            return r13;
        L5:
            return count(r10);
        }
    }

    public final class ValuePredicate implements Predicate<V> {
        private final K key;
        final /* synthetic */ FilteredEntryMultimap this$0;

        public ValuePredicate(FilteredEntryMultimap r10, K r11) {
            this.this$0 = r10;
            this.key = r11;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl V r10) {
            return FilteredEntryMultimap.access$000(this.this$0, this.key, r10);
        }
    }

    public FilteredEntryMultimap(Multimap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(r10);
        this.predicate = (Predicate) Preconditions.checkNotNull(r11);
    }

    public static /* synthetic */ boolean access$000(FilteredEntryMultimap r10, Object r11, Object r12) {
        return r10.satisfies(r11, r12);
    }

    public static <E> Collection<E> filterCollection(Collection<E> r10, Predicate<? super E> r11) {
        if ((r10 instanceof Set) == false) goto L7;
        return Sets.filter((Set) r10, r11);
    L7:
        return Collections2.filter(r10, r11);
    }

    private boolean satisfies(K r10, V r11) {
        return this.predicate.apply(Maps.immutableEntry(r10, r11));
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object r10) {
        if (asMap().get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new AsMap(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new Keys(this);
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
        return this.predicate;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(K r10) {
        return filterCollection(this.unfiltered.get(r10), new ValuePredicate(this, r10));
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@NullableDecl Object r10) {
        return (Collection) MoreObjects.firstNonNull(asMap().remove(r10), unmodifiableEmptyCollection());
    }

    public boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> r10) {
        Iterator<Map.Entry<K, Collection<V>>> r11 = this.unfiltered.asMap().entrySet().iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<K, Collection<V>> r13 = r11.next();
        K r14 = r13.getKey();
        Collection r15 = filterCollection(r13.getValue(), new ValuePredicate(this, r14));
        if (r15.isEmpty() == true) goto L4;
        if (r10.apply(Maps.immutableEntry(r14, r15)) == false) goto L4;
        if (r15.size() != r13.getValue().size()) goto L12;
        r11.remove();
    L13:
        r12 = true;
        goto L4
    L12:
        r15.clear();
        goto L13
    L14:
        return r12;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        if ((this.unfiltered instanceof SetMultimap) == false) goto L6;
        return Collections.emptySet();
    L6:
        return Collections.emptyList();
    }
}
