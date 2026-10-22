package com.google.common.collect;

import com.android.vcard.VCardConstants;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Maps {
    static final Joiner.MapJoiner STANDARD_JOINER = null;

    private static abstract class AbstractFilteredMap<K, V> extends ImprovedAbstractMap<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        AbstractFilteredMap(Map<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
            this.unfiltered = r1;
            this.predicate = r2;
        }

        boolean apply(@Nullable Object r1, @Nullable V r2) {
            return this.predicate.apply(Maps.immutableEntry(r1, r2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r2, V r3) {
            Preconditions.checkArgument(apply(r2, r3));
            return this.unfiltered.put(r2, r3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> r4) {
            Iterator<Map.Entry<? extends K, ? extends V>> r0 = r4.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<? extends K, ? extends V> r1 = r0.next();
            Preconditions.checkArgument(apply(r1.getKey(), r1.getValue()));
            goto L4
        L6:
            this.unfiltered.putAll(r4);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r2) {
            if (this.unfiltered.containsKey(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (apply(r2, this.unfiltered.get(r2)) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r2) {
            V r0 = this.unfiltered.get(r2);
            if (r0 != null) goto L5;
        L7:
            return null;
        L5:
            if (apply(r2, r0) == false) goto L7;
            return r0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r2) {
            if (containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.unfiltered.remove(r2);
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        Collection<V> createValues() {
            return new FilteredMapValues(this, this.unfiltered, this.predicate);
        }
    }

    private static class AsMapView<K, V> extends ImprovedAbstractMap<K, V> {
        final Function<? super K, V> function;
        private final Set<K> set;

        Set<K> backingSet() {
            return this.set;
        }

        AsMapView(Set<K> r1, Function<? super K, V> r2) {
            this.set = (Set) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        public Set<K> createKeySet() {
            return Maps.access$200(backingSet());
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        Collection<V> createValues() {
            return Collections2.transform(this.set, this.function);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return backingSet().size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object r1) {
            return backingSet().contains(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object r2) {
            if (Collections2.safeContains(backingSet(), r2) == true) goto L5;
            return null;
        L5:
            return this.function.apply(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@Nullable Object r2) {
            if (backingSet().remove(r2) == true) goto L5;
            return null;
        L5:
            return this.function.apply(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            backingSet().clear();
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new AnonymousClass1(this);
        }
    }

    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        BiMapConverter(BiMap<A, B> r1) {
            this.bimap = (BiMap) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A r1) {
            return (B) convert(this.bimap, r1);
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B r1) {
            return (A) convert(this.bimap.inverse(), r1);
        }

        private static <X, Y> Y convert(BiMap<X, Y> r3, X r4) {
            Y r5 = r3.get(r4);
            if (r5 == null) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "No non-null mapping present for input: %s", new Object[]{r4});
            return r5;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof BiMapConverter) == true) goto L5;
            return false;
        L5:
            return this.bimap.equals(((BiMapConverter) r2).bimap);
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
        private transient Comparator<? super K> comparator;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient NavigableSet<K> navigableKeySet;

        abstract Iterator<Map.Entry<K, V>> entryIterator();

        abstract NavigableMap<K, V> forward();

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        DescendingMap() {
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected final Map<K, V> delegate() {
            return forward();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> r0 = this.comparator;
            if (r0 != null) goto L9;
            Comparator<? super K> r1 = forward().comparator();
            if (r1 != null) goto L7;
            r1 = Ordering.natural();
        L7:
            Ordering r2 = reverse(r1);
            this.comparator = r2;
            return r2;
        L9:
            return r0;
        }

        private static <T> Ordering<T> reverse(Comparator<T> r0) {
            return Ordering.from(r0).reverse();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return forward().lastKey();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return forward().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r1) {
            return forward().higherEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r1) {
            return forward().higherKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r1) {
            return forward().ceilingEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r1) {
            return forward().ceilingKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r1) {
            return forward().floorEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r1) {
            return forward().floorKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r1) {
            return forward().lowerEntry(r1);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r1) {
            return forward().lowerKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return forward().lastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return forward().firstEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return forward().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return forward().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return forward();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r0 = this.entrySet;
            if (r0 != null) goto L6;
            Set<Map.Entry<K, V>> r1 = createEntrySet();
            this.entrySet = r1;
            return r1;
        L6:
            return r0;
        }

        Set<Map.Entry<K, V>> createEntrySet() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> r0 = this.navigableKeySet;
            if (r0 != null) goto L6;
            NavigableKeySet r1 = new NavigableKeySet(this);
            this.navigableKeySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return forward().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r1, boolean r2, K r3, boolean r4) {
            return forward().subMap(r3, r4, r1, r2).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r1, boolean r2) {
            return forward().tailMap(r1, r2).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r1, boolean r2) {
            return forward().headMap(r1, r2).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K r2) {
            return tailMap(r2, true);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Collection<V> values() {
            return new Values(this);
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }
    }

    private static abstract enum EntryFunction extends Enum<EntryFunction> implements Function<Map.Entry<?, ?>, Object> {
        private static final /* synthetic */ EntryFunction[] $VALUES = null;
        public static final EntryFunction KEY = null;
        public static final EntryFunction VALUE = null;

        private EntryFunction(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ EntryFunction(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static EntryFunction valueOf(String r1) {
            return (EntryFunction) Enum.valueOf(EntryFunction.class, r1);
        }

        public static EntryFunction[] values() {
            return (EntryFunction[]) $VALUES.clone();
        }

        static {
            final String r1 = "KEY";
            final int r2 = 0;
            EntryFunction r0 = new AnonymousClass1(r1, r2);
            KEY = r0;
            final String r3 = VCardConstants.PARAM_VALUE;
            final int r4 = 1;
            EntryFunction r5 = new AnonymousClass2(r3, r4);
            VALUE = r5;
            $VALUES = new EntryFunction[]{r0, r5};
        }
    }

    static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        abstract Map<K, V> map();

        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if ((r4 instanceof Map.Entry) == false) goto L11;
            Map.Entry r5 = (Map.Entry) r4;
            Object r0 = r5.getKey();
            Object r2 = Maps.safeGet(map(), r0);
            if (Objects.equal(r2, r5.getValue()) == false) goto L12;
            if (r2 == null) goto L8;
        L9:
            return true;
        L8:
            if (map().containsKey(r0) == true) goto L9;
            return false;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            if (contains(r2) == true) goto L5;
            return false;
        L5:
            return map().keySet().remove(((Map.Entry) r2).getKey());
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r2) {
            return super.removeAll((Collection) Preconditions.checkNotNull(r2));
        L5:
            return Sets.removeAllImpl(this, r2.iterator());
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r4) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r4));
        L4:
            HashSet r0 = Sets.newHashSetWithExpectedSize(r4.size());
            Iterator<?> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L11;
            Object r1 = r5.next();
            if (contains(r1) == false) goto L6;
            r0.add(((Map.Entry) r1).getKey());
            goto L6
        L11:
            return map().keySet().retainAll(r0);
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@Nullable K r1, @Nullable V1 r2);
    }

    static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
        private final BiMap<V, K> inverse;

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> r1) {
            return new AnonymousClass1(r1);
        }

        FilteredEntryBiMap(BiMap<K, V> r2, Predicate<? super Map.Entry<K, V>> r3) {
            super(r2, r3);
            this.inverse = new FilteredEntryBiMap(r2.inverse(), inversePredicate(r3), this);
        }

        private FilteredEntryBiMap(BiMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2, BiMap<V, K> r3) {
            super(r1, r2);
            this.inverse = r3;
        }

        BiMap<K, V> unfiltered() {
            return (BiMap) this.unfiltered;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(@Nullable K r2, @Nullable V r3) {
            Preconditions.checkArgument(apply(r2, r3));
            return unfiltered().forcePut(r2, r3);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            return this.inverse;
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.inverse.keySet();
        }
    }

    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> filteredEntrySet;

        private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            final /* synthetic */ FilteredEntryMap this$0;

            private EntrySet(FilteredEntryMap r1) {
                this.this$0 = r1;
            }

            /* synthetic */ EntrySet(FilteredEntryMap r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            protected /* bridge */ /* synthetic */ Object delegate() {
                return delegate();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            protected /* bridge */ /* synthetic */ Collection delegate() {
                return delegate();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            protected Set<Map.Entry<K, V>> delegate() {
                return this.this$0.filteredEntrySet;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                final Iterator<Map.Entry<K, V>> r1 = this.this$0.filteredEntrySet.iterator();
                return new AnonymousClass1(this, r1);
            }
        }

        class KeySet extends KeySet<K, V> {
            final /* synthetic */ FilteredEntryMap this$0;

            KeySet(FilteredEntryMap r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r2) {
                if (this.this$0.containsKey(r2) == false) goto L6;
                this.this$0.unfiltered.remove(r2);
                return true;
            L6:
                return false;
            }

            private boolean removeIf(Predicate<? super K> r2) {
                return Iterables.removeIf(this.this$0.unfiltered.entrySet(), Predicates.and(this.this$0.predicate, Maps.keyPredicateOnEntries(r2)));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> r1) {
                return removeIf(Predicates.in(r1));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r1) {
                return removeIf(Predicates.not(Predicates.in(r1)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] r1) {
                return (T[]) Lists.newArrayList(iterator()).toArray(r1);
            }
        }

        FilteredEntryMap(Map<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
            super(r1, r2);
            this.filteredEntrySet = Sets.filter(r1.entrySet(), this.predicate);
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet(this, null);
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        Set<K> createKeySet() {
            return new KeySet(this);
        }
    }

    private static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
        private final Predicate<? super Map.Entry<K, V>> entryPredicate;
        private final Map<K, V> filteredDelegate;
        private final NavigableMap<K, V> unfiltered;

        static /* synthetic */ Predicate access$600(FilteredEntryNavigableMap r0) {
            return r0.entryPredicate;
        }

        static /* synthetic */ NavigableMap access$700(FilteredEntryNavigableMap r0) {
            return r0.unfiltered;
        }

        FilteredEntryNavigableMap(NavigableMap<K, V> r2, Predicate<? super Map.Entry<K, V>> r3) {
            this.unfiltered = (NavigableMap) Preconditions.checkNotNull(r2);
            this.entryPredicate = r3;
            this.filteredDelegate = new FilteredEntryMap(r2, r3);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.unfiltered.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new AnonymousClass1(this, this);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new FilteredMapValues(this, this.unfiltered, this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.filteredDelegate.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public V get(@Nullable Object r1) {
            return this.filteredDelegate.get(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object r1) {
            return this.filteredDelegate.containsKey(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r1, V r2) {
            return this.filteredDelegate.put(r1, r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@Nullable Object r1) {
            return this.filteredDelegate.remove(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> r1) {
            this.filteredDelegate.putAll(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.filteredDelegate.clear();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return this.filteredDelegate.entrySet();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r2, boolean r3, K r4, boolean r5) {
            return Maps.filterEntries(this.unfiltered.subMap(r2, r3, r4, r5), this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r2, boolean r3) {
            return Maps.filterEntries(this.unfiltered.headMap(r2, r3), this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r2, boolean r3) {
            return Maps.filterEntries(this.unfiltered.tailMap(r2, r3), this.entryPredicate);
        }
    }

    private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

        class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            final /* synthetic */ FilteredEntrySortedMap this$0;

            SortedKeySet(FilteredEntrySortedMap r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // java.util.SortedSet
            public Comparator<? super K> comparator() {
                return this.this$0.sortedMap().comparator();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(K r1, K r2) {
                return (SortedSet) this.this$0.subMap(r1, r2).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(K r1) {
                return (SortedSet) this.this$0.headMap(r1).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(K r1) {
                return (SortedSet) this.this$0.tailMap(r1).keySet();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) this.this$0.firstKey();
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) this.this$0.lastKey();
            }
        }

        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ImprovedAbstractMap
        /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        FilteredEntrySortedMap(SortedMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
            super(r1, r2);
        }

        SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ImprovedAbstractMap
        SortedSet<K> createKeySet() {
            return new SortedKeySet(this);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return keySet().iterator().next();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            SortedMap<K, V> r0 = sortedMap();
        L3:
            K r1 = r0.lastKey();
            if (apply(r1, this.unfiltered.get(r1)) == true) goto L5;
            r0 = sortedMap().headMap(r1);
            goto L3
        L5:
            return r1;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K r3) {
            return new FilteredEntrySortedMap(sortedMap().headMap(r3), this.predicate);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return new FilteredEntrySortedMap(sortedMap().subMap(r3, r4), this.predicate);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K r3) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(r3), this.predicate);
        }
    }

    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        Predicate<? super K> keyPredicate;

        FilteredKeyMap(Map<K, V> r1, Predicate<? super K> r2, Predicate<? super Map.Entry<K, V>> r3) {
            super(r1, r3);
            this.keyPredicate = r2;
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), this.predicate);
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        Set<K> createKeySet() {
            return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r2) {
            if (this.unfiltered.containsKey(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.keyPredicate.apply(r2) == false) goto L7;
            return true;
        }
    }

    private static final class FilteredMapValues<K, V> extends Values<K, V> {
        Predicate<? super Map.Entry<K, V>> predicate;
        Map<K, V> unfiltered;

        FilteredMapValues(Map<K, V> r1, Map<K, V> r2, Predicate<? super Map.Entry<K, V>> r3) {
            super(r1);
            this.unfiltered = r2;
            this.predicate = r3;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            if (Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(r2)))) == null) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean removeIf(Predicate<? super V> r2) {
            return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(r2)));
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r1) {
            return removeIf(Predicates.in(r1));
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r1) {
            return removeIf(Predicates.not(Predicates.in(r1)));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) Lists.newArrayList(iterator()).toArray(r1);
        }
    }

    static abstract class ImprovedAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        abstract Set<Map.Entry<K, V>> createEntrySet();

        ImprovedAbstractMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r0 = this.entrySet;
            if (r0 != null) goto L6;
            Set<Map.Entry<K, V>> r1 = createEntrySet();
            this.entrySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.AbstractMap, java.util.Map
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
            return new KeySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
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
    }

    static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
        final Map<K, V> map;

        KeySet(Map<K, V> r1) {
            this.map = (Map) Preconditions.checkNotNull(r1);
        }

        Map<K, V> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return map().containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            if (contains(r2) == false) goto L6;
            map().remove(r2);
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }
    }

    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final Map<K, MapDifference.ValueDifference<V>> differences;
        final Map<K, V> onBoth;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;

        MapDifferenceImpl(Map<K, V> r1, Map<K, V> r2, Map<K, V> r3, Map<K, MapDifference.ValueDifference<V>> r4) {
            this.onlyOnLeft = Maps.access$100(r1);
            this.onlyOnRight = Maps.access$100(r2);
            this.onBoth = Maps.access$100(r3);
            this.differences = Maps.access$100(r4);
        }

        @Override // com.google.common.collect.MapDifference
        public boolean areEqual() {
            if (this.onlyOnLeft.isEmpty() == true) goto L5;
        L9:
            return false;
        L5:
            if (this.onlyOnRight.isEmpty() == false) goto L9;
            if (this.differences.isEmpty() == false) goto L9;
            return true;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        @Override // com.google.common.collect.MapDifference
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof MapDifference) == false) goto L18;
            MapDifference r6 = (MapDifference) r5;
            if (entriesOnlyOnLeft().equals(r6.entriesOnlyOnLeft()) == false) goto L17;
            if (entriesOnlyOnRight().equals(r6.entriesOnlyOnRight()) == false) goto L17;
            if (entriesInCommon().equals(r6.entriesInCommon()) == false) goto L17;
            if (entriesDiffering().equals(r6.entriesDiffering()) == false) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        @Override // com.google.common.collect.MapDifference
        public int hashCode() {
            return Objects.hashCode(new Object[]{entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering()});
        }

        public String toString() {
            if (areEqual() == false) goto L6;
            return "equal";
        L6:
            StringBuilder r0 = new StringBuilder("not equal");
            if (this.onlyOnLeft.isEmpty() == true) goto L10;
            r0.append(": only on left=").append(this.onlyOnLeft);
        L10:
            if (this.onlyOnRight.isEmpty() == true) goto L13;
            r0.append(": only on right=").append(this.onlyOnRight);
        L13:
            if (this.differences.isEmpty() == true) goto L16;
            r0.append(": value differences=").append(this.differences);
        L16:
            return r0.toString();
        }
    }

    private static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
        private final Function<? super K, V> function;
        private final NavigableSet<K> set;

        NavigableAsMapView(NavigableSet<K> r1, Function<? super K, V> r2) {
            this.set = (NavigableSet) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r2, boolean r3, K r4, boolean r5) {
            return Maps.asMap(this.set.subSet(r2, r3, r4, r5), this.function);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r2, boolean r3) {
            return Maps.asMap(this.set.headSet(r2, r3), this.function);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r2, boolean r3) {
            return Maps.asMap(this.set.tailSet(r2, r3), this.function);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.set.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public V get(@Nullable Object r2) {
            if (Collections2.safeContains(this.set, r2) == true) goto L5;
            return null;
        L5:
            return this.function.apply(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.set.clear();
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return Maps.asMapEntryIterator(this.set, this.function);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Maps.access$400(this.set);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.set.size();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.asMap(this.set.descendingSet(), this.function);
        }
    }

    static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        /* bridge */ /* synthetic */ Map map() {
            return map();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        /* bridge */ /* synthetic */ SortedMap map() {
            return map();
        }

        NavigableKeySet(NavigableMap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        NavigableMap<K, V> map() {
            return (NavigableMap) this.map;
        }

        @Override // java.util.NavigableSet
        public K lower(K r1) {
            return map().lowerKey(r1);
        }

        @Override // java.util.NavigableSet
        public K floor(K r1) {
            return map().floorKey(r1);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K r1) {
            return map().ceilingKey(r1);
        }

        @Override // java.util.NavigableSet
        public K higher(K r1) {
            return map().higherKey(r1);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.keyOrNull(map().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.keyOrNull(map().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return map().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K r1, boolean r2, K r3, boolean r4) {
            return map().subMap(r1, r2, r3, r4).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K r1, boolean r2) {
            return map().headMap(r1, r2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K r1, boolean r2) {
            return map().tailMap(r1, r2).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K r3, K r4) {
            return subSet(r3, true, r4, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K r2) {
            return headSet(r2, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K r2) {
            return tailSet(r2, true);
        }
    }

    private static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        @Override // com.google.common.collect.Maps.AsMapView
        /* bridge */ /* synthetic */ Set backingSet() {
            return backingSet();
        }

        SortedAsMapView(SortedSet<K> r1, Function<? super K, V> r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Maps.AsMapView
        SortedSet<K> backingSet() {
            return (SortedSet) super.backingSet();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return backingSet().comparator();
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return Maps.access$300(backingSet());
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K r2, K r3) {
            return Maps.asMap(backingSet().subSet(r2, r3), this.function);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K r2) {
            return Maps.asMap(backingSet().headSet(r2), this.function);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K r2) {
            return Maps.asMap(backingSet().tailSet(r2), this.function);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return backingSet().first();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return backingSet().last();
        }
    }

    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        @Override // com.google.common.collect.Maps.KeySet
        /* bridge */ /* synthetic */ Map map() {
            return map();
        }

        SortedKeySet(SortedMap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.Maps.KeySet
        SortedMap<K, V> map() {
            return (SortedMap) super.map();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return map().comparator();
        }

        public SortedSet<K> subSet(K r2, K r3) {
            return new SortedKeySet(map().subMap(r2, r3));
        }

        public SortedSet<K> headSet(K r2) {
            return new SortedKeySet(map().headMap(r2));
        }

        public SortedSet<K> tailSet(K r2) {
            return new SortedKeySet(map().tailMap(r2));
        }

        @Override // java.util.SortedSet
        public K first() {
            return map().firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return map().lastKey();
        }
    }

    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public /* bridge */ /* synthetic */ Map entriesDiffering() {
            return entriesDiffering();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public /* bridge */ /* synthetic */ Map entriesInCommon() {
            return entriesInCommon();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public /* bridge */ /* synthetic */ Map entriesOnlyOnLeft() {
            return entriesOnlyOnLeft();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public /* bridge */ /* synthetic */ Map entriesOnlyOnRight() {
            return entriesOnlyOnRight();
        }

        SortedMapDifferenceImpl(SortedMap<K, V> r1, SortedMap<K, V> r2, SortedMap<K, V> r3, SortedMap<K, MapDifference.ValueDifference<V>> r4) {
            super(r1, r2, r3, r4);
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return (SortedMap) super.entriesDiffering();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap) super.entriesInCommon();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap) super.entriesOnlyOnLeft();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap) super.entriesOnlyOnRight();
        }
    }

    static class TransformedEntriesMap<K, V1, V2> extends ImprovedAbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMap(Map<K, V1> r1, EntryTransformer<? super K, ? super V1, V2> r2) {
            this.fromMap = (Map) Preconditions.checkNotNull(r1);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.fromMap.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.fromMap.containsKey(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object r3) {
            V1 r0 = this.fromMap.get(r3);
            if (r0 != null) goto L9;
            if (this.fromMap.containsKey(r3) == true) goto L9;
            return null;
        L9:
            return this.transformer.transformEntry(r3, r0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object r2) {
            if (this.fromMap.containsKey(r2) == true) goto L7;
            return null;
        L7:
            return this.transformer.transformEntry(r2, this.fromMap.remove(r2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.fromMap.clear();
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap
        protected Set<Map.Entry<K, V2>> createEntrySet() {
            return new AnonymousClass1(this);
        }
    }

    private static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        protected /* bridge */ /* synthetic */ SortedMap fromMap() {
            return fromMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object r1) {
            return headMap(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap subMap(Object r1, Object r2) {
            return subMap(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object r1) {
            return tailMap(r1);
        }

        TransformedEntriesNavigableMap(NavigableMap<K, V1> r1, EntryTransformer<? super K, ? super V1, V2> r2) {
            super(r1, r2);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> ceilingEntry(K r2) {
            return transformEntry(fromMap().ceilingEntry(r2));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r1) {
            return fromMap().ceilingKey(r1);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return fromMap().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return Maps.transformEntries(fromMap().descendingMap(), this.transformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> firstEntry() {
            return transformEntry(fromMap().firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> floorEntry(K r2) {
            return transformEntry(fromMap().floorEntry(r2));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r1) {
            return fromMap().floorKey(r1);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K r2, boolean r3) {
            return Maps.transformEntries(fromMap().headMap(r2, r3), this.transformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> higherEntry(K r2) {
            return transformEntry(fromMap().higherEntry(r2));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r1) {
            return fromMap().higherKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lastEntry() {
            return transformEntry(fromMap().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lowerEntry(K r2) {
            return transformEntry(fromMap().lowerEntry(r2));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r1) {
            return fromMap().lowerKey(r1);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return fromMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollFirstEntry() {
            return transformEntry(fromMap().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollLastEntry() {
            return transformEntry(fromMap().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K r2, boolean r3, K r4, boolean r5) {
            return Maps.transformEntries(fromMap().subMap(r2, r3, r4, r5), this.transformer);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K r2) {
            return tailMap(r2, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K r2, boolean r3) {
            return Maps.transformEntries(fromMap().tailMap(r2, r3), this.transformer);
        }

        @Nullable
        private Map.Entry<K, V2> transformEntry(@Nullable Map.Entry<K, V1> r1) {
            if (r1 != null) goto L5;
            return null;
        L5:
            return Maps.transformEntry(this.transformer, r1);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        protected NavigableMap<K, V1> fromMap() {
            return (NavigableMap) super.fromMap();
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        protected SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> r1, EntryTransformer<? super K, ? super V1, V2> r2) {
            super(r1, r2);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V2> headMap(K r2) {
            return Maps.transformEntries(fromMap().headMap(r2), this.transformer);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(K r2, K r3) {
            return Maps.transformEntries(fromMap().subMap(r2, r3), this.transformer);
        }

        public SortedMap<K, V2> tailMap(K r2) {
            return Maps.transformEntries(fromMap().tailMap(r2), this.transformer);
        }
    }

    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        transient Set<V> values;

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> r2, @Nullable BiMap<V, K> r3) {
            this.unmodifiableMap = Collections.unmodifiableMap(r2);
            this.delegate = r2;
            this.inverse = r3;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K r1, V r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> r0 = this.inverse;
            if (r0 != null) goto L6;
            UnmodifiableBiMap r1 = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<V> values() {
            Set<V> r0 = this.values;
            if (r0 != null) goto L6;
            Set<V> r1 = Collections.unmodifiableSet(this.delegate.values());
            this.values = r1;
            return r1;
        L6:
            return r0;
        }
    }

    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> entries;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        UnmodifiableEntries(Collection<Map.Entry<K, V>> r1) {
            this.entries = r1;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            final Iterator r0 = super.iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }
    }

    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set<Map.Entry<K, V>> r1) {
            super(r1);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r1) {
            return Sets.equalsImpl(this, r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, V> delegate;
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        UnmodifiableNavigableMap(NavigableMap<K, V> r1) {
            this.delegate = r1;
        }

        UnmodifiableNavigableMap(NavigableMap<K, V> r1, UnmodifiableNavigableMap<K, V> r2) {
            this.delegate = r1;
            this.descendingMap = r2;
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r1) {
            return Maps.access$800(this.delegate.lowerEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r1) {
            return this.delegate.lowerKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r1) {
            return Maps.access$800(this.delegate.floorEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r1) {
            return this.delegate.floorKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r1) {
            return Maps.access$800(this.delegate.ceilingEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r1) {
            return this.delegate.ceilingKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r1) {
            return Maps.access$800(this.delegate.higherEntry(r1));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r1) {
            return this.delegate.higherKey(r1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.access$800(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.access$800(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> r0 = this.descendingMap;
            if (r0 != null) goto L6;
            UnmodifiableNavigableMap<K, V> r1 = new UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
            this.descendingMap = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K r2) {
            return tailMap(r2, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r1, boolean r2, K r3, boolean r4) {
            return Maps.unmodifiableNavigableMap(this.delegate.subMap(r1, r2, r3, r4));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r1, boolean r2) {
            return Maps.unmodifiableNavigableMap(this.delegate.headMap(r1, r2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r1, boolean r2) {
            return Maps.unmodifiableNavigableMap(this.delegate.tailMap(r1, r2));
        }
    }

    static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
        private final V left;
        private final V right;

        static <V> MapDifference.ValueDifference<V> create(@Nullable V r1, @Nullable V r2) {
            return new ValueDifferenceImpl(r1, r2);
        }

        private ValueDifferenceImpl(@Nullable V r1, @Nullable V r2) {
            this.left = r1;
            this.right = r2;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V leftValue() {
            return this.left;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V rightValue() {
            return this.right;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof MapDifference.ValueDifference) == false) goto L10;
            MapDifference.ValueDifference r5 = (MapDifference.ValueDifference) r4;
            if (Objects.equal(this.left, r5.leftValue()) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.right, r5.rightValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public int hashCode() {
            return Objects.hashCode(new Object[]{this.left, this.right});
        }

        public String toString() {
            return "(" + this.left + ", " + this.right + ")";
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        final Map<K, V> map;

        Values(Map<K, V> r1) {
            this.map = (Map) Preconditions.checkNotNull(r1);
        }

        final Map<K, V> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r4) {
            return super.remove(r4);
        L4:
            Iterator<Map.Entry<K, V>> r0 = map().entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L11;
            Map.Entry<K, V> r1 = r0.next();
            if (Objects.equal(r4, r1.getValue()) == false) goto L6;
            map().remove(r1.getKey());
            return true;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r5) {
            return super.removeAll((Collection) Preconditions.checkNotNull(r5));
        L4:
            HashSet r0 = Sets.newHashSet();
            Iterator<Map.Entry<K, V>> r1 = map().entrySet().iterator();
        L6:
            if (r1.hasNext() == false) goto L11;
            Map.Entry<K, V> r2 = r1.next();
            if (r5.contains(r2.getValue()) == false) goto L6;
            r0.add(r2.getKey());
            goto L6
        L11:
            return map().keySet().removeAll(r0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r5) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r5));
        L4:
            HashSet r0 = Sets.newHashSet();
            Iterator<Map.Entry<K, V>> r1 = map().entrySet().iterator();
        L6:
            if (r1.hasNext() == false) goto L11;
            Map.Entry<K, V> r2 = r1.next();
            if (r5.contains(r2.getValue()) == false) goto L6;
            r0.add(r2.getKey());
            goto L6
        L11:
            return map().keySet().retainAll(r0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return map().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object r1) {
            return map().containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            map().clear();
        }
    }

    static /* synthetic */ Map access$100(Map r0) {
        return unmodifiableMap(r0);
    }

    static /* synthetic */ Set access$200(Set r0) {
        return removeOnlySet(r0);
    }

    static /* synthetic */ SortedSet access$300(SortedSet r0) {
        return removeOnlySortedSet(r0);
    }

    static /* synthetic */ NavigableSet access$400(NavigableSet r0) {
        return removeOnlyNavigableSet(r0);
    }

    static /* synthetic */ Map.Entry access$800(Map.Entry r0) {
        return unmodifiableOrNull(r0);
    }

    private Maps() {
    }

    static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> r1) {
        return Iterators.transform(r1, keyFunction());
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> r1) {
        return Iterators.transform(r1, valueFunction());
    }

    static <K, V> UnmodifiableIterator<V> valueIterator(final UnmodifiableIterator<Map.Entry<K, V>> r1) {
        return new AnonymousClass1(r1);
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> r3) {
        if ((r3 instanceof ImmutableEnumMap) == false) goto L7;
        return (ImmutableEnumMap) r3;
    L7:
        if (r3.isEmpty() == true) goto L9;
        Iterator<Map.Entry<K, ? extends V>> r0 = r3.entrySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L15;
        Map.Entry<K, ? extends V> r1 = r0.next();
        Preconditions.checkNotNull(r1.getKey());
        Preconditions.checkNotNull(r1.getValue());
        goto L12
    L15:
        return ImmutableEnumMap.asImmutable(new EnumMap(r3));
    L9:
        return ImmutableMap.of();
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int r1) {
        return new HashMap(capacity(r1));
    }

    static int capacity(int r1) {
        if (r1 >= 3) goto L7;
        CollectPreconditions.checkNonnegative(r1, "expectedSize");
        return r1 + 1;
    L7:
        if (r1 < 1073741824) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return r1 + (r1 / 3);
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> r1) {
        return new HashMap(r1);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> r1) {
        return new LinkedHashMap(r1);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new MapMaker().makeMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> r1) {
        return new TreeMap(r1);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> r1) {
        return new TreeMap(r1);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> r1) {
        return new EnumMap((Class) Preconditions.checkNotNull(r1));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> r1) {
        return new EnumMap(r1);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap();
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> r1, Map<? extends K, ? extends V> r2) {
        if ((r1 instanceof SortedMap) == false) goto L7;
        return difference((SortedMap) r1, r2);
    L7:
        return difference(r1, r2, Equivalence.equals());
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> r11, Map<? extends K, ? extends V> r12, Equivalence<? super V> r13) {
        Preconditions.checkNotNull(r13);
        HashMap r7 = newHashMap();
        HashMap r8 = new HashMap(r12);
        HashMap r9 = newHashMap();
        HashMap r10 = newHashMap();
        doDifference(r11, r12, r13, r7, r8, r9, r10);
        return new MapDifferenceImpl(r7, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void doDifference(Map<? extends K, ? extends V> r4, Map<? extends K, ? extends V> r5, Equivalence<? super V> r6, Map<K, V> r7, Map<K, V> r8, Map<K, V> r9, Map<K, MapDifference.ValueDifference<V>> r10) {
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r4.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<? extends K, ? extends V> r0 = r11.next();
        K r1 = r0.getKey();
        V r2 = r0.getValue();
        if (r5.containsKey(r1) == true) goto L7;
        r7.put(r1, r2);
        goto L4
    L7:
        V r3 = r8.remove(r1);
        if (r6.equivalent(r2, r3) == true) goto L9;
        r10.put(r1, ValueDifferenceImpl.create(r2, r3));
        goto L4
    L9:
        r9.put(r1, r2);
        goto L4
    }

    private static <K, V> Map<K, V> unmodifiableMap(Map<K, V> r1) {
        if ((r1 instanceof SortedMap) == false) goto L7;
        return Collections.unmodifiableSortedMap((SortedMap) r1);
    L7:
        return Collections.unmodifiableMap(r1);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> r11, Map<? extends K, ? extends V> r12) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        Comparator r0 = orNaturalOrder(r11.comparator());
        TreeMap r8 = newTreeMap(r0);
        TreeMap r9 = newTreeMap(r0);
        r9.putAll(r12);
        TreeMap r10 = newTreeMap(r0);
        TreeMap r1 = newTreeMap(r0);
        doDifference(r11, r12, Equivalence.equals(), r8, r9, r10, r1);
        return new SortedMapDifferenceImpl(r8, r9, r10, r1);
    }

    static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Ordering.natural();
    }

    public static <K, V> Map<K, V> asMap(Set<K> r1, Function<? super K, V> r2) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return asMap((SortedSet) r1, r2);
    L7:
        return new AsMapView(r1, r2);
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> r0, Function<? super K, V> r1) {
        return Platform.mapsAsMapSortedSet(r0, r1);
    }

    static <K, V> SortedMap<K, V> asMapSortedIgnoreNavigable(SortedSet<K> r1, Function<? super K, V> r2) {
        return new SortedAsMapView(r1, r2);
    }

    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> r1, Function<? super K, V> r2) {
        return new NavigableAsMapView(r1, r2);
    }

    static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> r1, final Function<? super K, V> r2) {
        final Iterator<K> r3 = r1.iterator();
        return new AnonymousClass2(r3, r2);
    }

    private static <E> Set<E> removeOnlySet(final Set<E> r1) {
        return new AnonymousClass3(r1);
    }

    private static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> r1) {
        return new AnonymousClass4(r1);
    }

    private static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> r1) {
        return new AnonymousClass5(r1);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> r0, Function<? super K, V> r1) {
        return toMap(r0.iterator(), r1);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> r3, Function<? super K, V> r4) {
        Preconditions.checkNotNull(r4);
        LinkedHashMap r0 = newLinkedHashMap();
    L4:
        if (r3.hasNext() == false) goto L7;
        K r1 = r3.next();
        r0.put(r1, r4.apply(r1));
        goto L4
    L7:
        return ImmutableMap.copyOf(r0);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> r0, Function<? super V, K> r1) {
        return uniqueIndex(r0.iterator(), r1);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> r3, Function<? super V, K> r4) {
        Preconditions.checkNotNull(r4);
        ImmutableMap.Builder r0 = ImmutableMap.builder();
    L4:
        if (r3.hasNext() == false) goto L7;
        V r1 = r3.next();
        r0.put(r4.apply(r1), r1);
        goto L4
    L7:
        return r0.build();
    }

    public static ImmutableMap<String, String> fromProperties(Properties r4) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        Enumeration<?> r1 = r4.propertyNames();
    L4:
        if (r1.hasMoreElements() == false) goto L7;
        String r2 = (String) r1.nextElement();
        r0.put(r2, r4.getProperty(r2));
        goto L4
    L7:
        return r0.build();
    }

    public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K r1, @Nullable V r2) {
        return new ImmutableEntry(r1, r2);
    }

    static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> r1) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(r1));
    }

    static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<? extends K, ? extends V> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass6(r1);
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> r1) {
        return new BiMapConverter(r1);
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> r1) {
        return Synchronized.biMap(r1, null);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> r2) {
        return new UnmodifiableBiMap(r2, null);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> r0, Function<? super V1, V2> r1) {
        return transformEntries(r0, asEntryTransformer(r1));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> r0, Function<? super V1, V2> r1) {
        return transformEntries(r0, asEntryTransformer(r1));
    }

    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> r0, Function<? super V1, V2> r1) {
        return transformEntries(r0, asEntryTransformer(r1));
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> r1, EntryTransformer<? super K, ? super V1, V2> r2) {
        if ((r1 instanceof SortedMap) == false) goto L7;
        return transformEntries((SortedMap) r1, r2);
    L7:
        return new TransformedEntriesMap(r1, r2);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> r0, EntryTransformer<? super K, ? super V1, V2> r1) {
        return Platform.mapsTransformEntriesSortedMap(r0, r1);
    }

    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> r1, EntryTransformer<? super K, ? super V1, V2> r2) {
        return new TransformedEntriesNavigableMap(r1, r2);
    }

    static <K, V1, V2> SortedMap<K, V2> transformEntriesIgnoreNavigable(SortedMap<K, V1> r1, EntryTransformer<? super K, ? super V1, V2> r2) {
        return new TransformedEntriesSortedMap(r1, r2);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass7(r1);
    }

    static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> r1, final K r2) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass8(r1, r2);
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass9(r1);
    }

    static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> r1, final Map.Entry<K, V1> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass10(r2, r1);
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass11(r1);
    }

    static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> r1) {
        return Predicates.compose(r1, keyFunction());
    }

    static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> r1) {
        return Predicates.compose(r1, valueFunction());
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> r2, Predicate<? super K> r3) {
        if ((r2 instanceof SortedMap) == false) goto L7;
        return filterKeys((SortedMap) r2, r3);
    L7:
        if ((r2 instanceof BiMap) == true) goto L9;
        Preconditions.checkNotNull(r3);
        Predicate r0 = keyPredicateOnEntries(r3);
        if ((r2 instanceof AbstractFilteredMap) == false) goto L14;
        return filterFiltered((AbstractFilteredMap) r2, r0);
    L14:
        return new FilteredKeyMap((Map) Preconditions.checkNotNull(r2), r3, r0);
    L9:
        return filterKeys((BiMap) r2, r3);
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> r0, Predicate<? super K> r1) {
        return filterEntries(r0, keyPredicateOnEntries(r1));
    }

    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> r0, Predicate<? super K> r1) {
        return filterEntries(r0, keyPredicateOnEntries(r1));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> r0, Predicate<? super K> r1) {
        Preconditions.checkNotNull(r1);
        return filterEntries(r0, keyPredicateOnEntries(r1));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> r1, Predicate<? super V> r2) {
        if ((r1 instanceof SortedMap) == false) goto L7;
        return filterValues((SortedMap) r1, r2);
    L7:
        if ((r1 instanceof BiMap) == false) goto L11;
        return filterValues((BiMap) r1, r2);
    L11:
        return filterEntries(r1, valuePredicateOnEntries(r2));
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> r0, Predicate<? super V> r1) {
        return filterEntries(r0, valuePredicateOnEntries(r1));
    }

    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> r0, Predicate<? super V> r1) {
        return filterEntries(r0, valuePredicateOnEntries(r1));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> r0, Predicate<? super V> r1) {
        return filterEntries(r0, valuePredicateOnEntries(r1));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        if ((r1 instanceof SortedMap) == false) goto L7;
        return filterEntries((SortedMap) r1, r2);
    L7:
        if ((r1 instanceof BiMap) == true) goto L9;
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof AbstractFilteredMap) == false) goto L14;
        return filterFiltered((AbstractFilteredMap) r1, r2);
    L14:
        return new FilteredEntryMap((Map) Preconditions.checkNotNull(r1), r2);
    L9:
        return filterEntries((BiMap) r1, r2);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> r0, Predicate<? super Map.Entry<K, V>> r1) {
        return Platform.mapsFilterSortedMap(r0, r1);
    }

    static <K, V> SortedMap<K, V> filterSortedIgnoreNavigable(SortedMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof FilteredEntrySortedMap) == false) goto L6;
        return filterFiltered((FilteredEntrySortedMap) r1, r2);
    L6:
        return new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(r1), r2);
    }

    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof FilteredEntryNavigableMap) == false) goto L6;
        return filterFiltered((FilteredEntryNavigableMap) r1, r2);
    L6:
        return new FilteredEntryNavigableMap((NavigableMap) Preconditions.checkNotNull(r1), r2);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof FilteredEntryBiMap) == false) goto L6;
        return filterFiltered((FilteredEntryBiMap) r1, r2);
    L6:
        return new FilteredEntryBiMap(r1, r2);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> r2, Predicate<? super Map.Entry<K, V>> r3) {
        return new FilteredEntryMap(r2.unfiltered, Predicates.and(r2.predicate, r3));
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Predicate r3 = Predicates.and(r1.predicate, r2);
        return new FilteredEntrySortedMap(r1.sortedMap(), r3);
    }

    private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Predicate r3 = Predicates.and(FilteredEntryNavigableMap.access$600(r1), r2);
        return new FilteredEntryNavigableMap(FilteredEntryNavigableMap.access$700(r1), r3);
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        Predicate r3 = Predicates.and(r1.predicate, r2);
        return new FilteredEntryBiMap(r1.unfiltered(), r3);
    }

    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, V> r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof UnmodifiableNavigableMap) == false) goto L6;
        return r1;
    L6:
        return new UnmodifiableNavigableMap(r1);
    }

    @Nullable
    private static <K, V> Map.Entry<K, V> unmodifiableOrNull(@Nullable Map.Entry<K, V> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return unmodifiableEntry(r0);
    }

    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> r0) {
        return Synchronized.navigableMap(r0);
    }

    static <V> V safeGet(Map<?, V> r1, @Nullable Object r2) {
        Preconditions.checkNotNull(r1);
        return r1.get(r2);
    L5:
        return null;
    }

    static boolean safeContainsKey(Map<?, ?> r1, Object r2) {
        Preconditions.checkNotNull(r1);
        return r1.containsKey(r2);
    L5:
        return false;
    }

    static <V> V safeRemove(Map<?, V> r1, Object r2) {
        Preconditions.checkNotNull(r1);
        return r1.remove(r2);
    L5:
        return null;
    }

    static boolean containsKeyImpl(Map<?, ?> r0, @Nullable Object r1) {
        return Iterators.contains(keyIterator(r0.entrySet().iterator()), r1);
    }

    static boolean containsValueImpl(Map<?, ?> r0, @Nullable Object r1) {
        return Iterators.contains(valueIterator(r0.entrySet().iterator()), r1);
    }

    static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> r1, Object r2) {
        if ((r2 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return r1.contains(unmodifiableEntry((Map.Entry) r2));
    }

    static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> r1, Object r2) {
        if ((r2 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return r1.remove(unmodifiableEntry((Map.Entry) r2));
    }

    static boolean equalsImpl(Map<?, ?> r1, Object r2) {
        if (r1 != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof Map) == true) goto L8;
        return false;
    L8:
        return r1.entrySet().equals(((Map) r2).entrySet());
    }

    static {
        STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
    }

    static String toStringImpl(Map<?, ?> r2) {
        StringBuilder r0 = Collections2.newStringBuilderForCollection(r2.size()).append('{');
        STANDARD_JOINER.appendTo(r0, r2);
        return r0.append('}').toString();
    }

    static <K, V> void putAllImpl(Map<K, V> r2, Map<? extends K, ? extends V> r3) {
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r0 = r4.next();
        r2.put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Nullable
    static <K> K keyOrNull(@Nullable Map.Entry<K, ?> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getKey();
    }

    @Nullable
    static <V> V valueOrNull(@Nullable Map.Entry<?, V> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getValue();
    }
}
