package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Maps {

    public static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        public AbstractFilteredMap(Map<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
            this.unfiltered = r10;
            this.predicate = r11;
        }

        public boolean apply(@NullableDecl Object r10, @NullableDecl V r11) {
            return this.predicate.apply(Maps.immutableEntry(r10, r11));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            if (this.unfiltered.containsKey(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (apply(r10, this.unfiltered.get(r10)) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<V> createValues() {
            return new FilteredMapValues(this, this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r10) {
            V r11 = this.unfiltered.get(r10);
            if (r11 != null) goto L5;
        L7:
            return null;
        L5:
            if (apply(r10, r11) == false) goto L7;
            return r11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r10, V r11) {
            Preconditions.checkArgument(apply(r10, r11));
            return this.unfiltered.put(r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> r10) {
            Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<? extends K, ? extends V> r12 = r11.next();
            Preconditions.checkArgument(apply(r12.getKey(), r12.getValue()));
            goto L4
        L6:
            this.unfiltered.putAll(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r10) {
            if (containsKey(r10) == true) goto L7;
            return null;
        L7:
            return this.unfiltered.remove(r10);
        }
    }

    public static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
        final Function<? super K, V> function;
        private final Set<K> set;

        public AsMapView(Set<K> r10, Function<? super K, V> r11) {
            this.set = (Set) Preconditions.checkNotNull(r10);
            this.function = (Function) Preconditions.checkNotNull(r11);
        }

        public Set<K> backingSet() {
            return this.set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            backingSet().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            return backingSet().contains(r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<K> createKeySet() {
            return Maps.access$200(backingSet());
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<V> createValues() {
            return Collections2.transform(this.set, this.function);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object r10) {
            if (Collections2.safeContains(backingSet(), r10) == true) goto L5;
            return null;
        L5:
            return this.function.apply(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@NullableDecl Object r10) {
            if (backingSet().remove(r10) == true) goto L5;
            return null;
        L5:
            return this.function.apply(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return backingSet().size();
        }
    }

    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        public BiMapConverter(BiMap<A, B> r10) {
            this.bimap = (BiMap) Preconditions.checkNotNull(r10);
        }

        private static <X, Y> Y convert(BiMap<X, Y> r10, X r11) {
            Y r12 = r10.get(r11);
            if (r12 == null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "No non-null mapping present for input: %s", r11);
            return r12;
        L5:
            r13 = false;
            goto L6
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B r10) {
            return (A) convert(this.bimap.inverse(), r10);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A r10) {
            return (B) convert(this.bimap, r10);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof BiMapConverter) == true) goto L5;
            return false;
        L5:
            return this.bimap.equals(((BiMapConverter) r10).bimap);
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    @GwtIncompatible
    public static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {

        @MonotonicNonNullDecl
        private transient Comparator<? super K> comparator;

        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> entrySet;

        @MonotonicNonNullDecl
        private transient NavigableSet<K> navigableKeySet;

        public DescendingMap() {
        }

        private static <T> Ordering<T> reverse(Comparator<T> r10) {
            return Ordering.from(r10).reverse();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r10) {
            return forward().floorEntry(r10);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r10) {
            return forward().floorKey(r10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> r10 = this.comparator;
            if (r10 != null) goto L9;
            Comparator<? super K> r11 = forward().comparator();
            if (r11 != null) goto L7;
            r11 = Ordering.natural();
        L7:
            Ordering r12 = reverse(r11);
            this.comparator = r12;
            return r12;
        L9:
            return r10;
        }

        public Set<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return forward().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return forward();
        }

        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r10 = this.entrySet;
            if (r10 != null) goto L6;
            Set<Map.Entry<K, V>> r11 = createEntrySet();
            this.entrySet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return forward().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return forward().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r10) {
            return forward().ceilingEntry(r10);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r10) {
            return forward().ceilingKey(r10);
        }

        public abstract NavigableMap<K, V> forward();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r10, boolean r11) {
            return forward().tailMap(r10, r11).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r10) {
            return forward().lowerEntry(r10);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r10) {
            return forward().lowerKey(r10);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return forward().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return forward().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r10) {
            return forward().higherEntry(r10);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r10) {
            return forward().higherKey(r10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> r10 = this.navigableKeySet;
            if (r10 != null) goto L6;
            NavigableKeySet r11 = new NavigableKeySet(this);
            this.navigableKeySet = r11;
            return r11;
        L6:
            return r10;
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
        public NavigableMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
            return forward().subMap(r12, r13, r10, r11).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r10, boolean r11) {
            return forward().headMap(r10, r11).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Collection<V> values() {
            return new Values(this);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Map<K, V> delegate() {
            return forward();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K r10) {
            return headMap(r10, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K r10, K r11) {
            return subMap(r10, true, r11, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K r10) {
            return tailMap(r10, true);
        }
    }

    public static abstract enum EntryFunction extends Enum<EntryFunction> implements Function<Map.Entry<?, ?>, Object> {
        private static final /* synthetic */ EntryFunction[] $VALUES = null;
        public static final EntryFunction KEY = null;
        public static final EntryFunction VALUE = null;

        static {
            final String r10 = "KEY";
            final int r11 = 0;
            EntryFunction r12 = new AnonymousClass1(r10, r11);
            KEY = r12;
            final String r13 = "VALUE";
            final int r14 = 1;
            EntryFunction r15 = new AnonymousClass2(r13, r14);
            VALUE = r15;
            $VALUES = new EntryFunction[]{r12, r15};
        }

        private EntryFunction(String r10, int r11) {
            super(r10, r11);
        }

        public static EntryFunction valueOf(String r10) {
            return (EntryFunction) Enum.valueOf(EntryFunction.class, r10);
        }

        public static EntryFunction[] values() {
            return (EntryFunction[]) $VALUES.clone();
        }

        public /* synthetic */ EntryFunction(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L11;
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            Object r13 = Maps.safeGet(map(), r12);
            if (Objects.equal(r13, r11.getValue()) == false) goto L12;
            if (r13 == null) goto L8;
        L9:
            return true;
        L8:
            if (map().containsKey(r12) == true) goto L9;
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

        public abstract Map<K, V> map();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (contains(r10) == true) goto L5;
            return false;
        L5:
            return map().keySet().remove(((Map.Entry) r10).getKey());
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            return super.removeAll((Collection) Preconditions.checkNotNull(r10));
        L5:
            return Sets.removeAllImpl(this, r10.iterator());
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r10));
        L4:
            HashSet r11 = Sets.newHashSetWithExpectedSize(r10.size());
            Iterator<?> r12 = r10.iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            Object r13 = r12.next();
            if (contains(r13) == false) goto L6;
            r11.add(((Map.Entry) r13).getKey());
            goto L6
        L11:
            return map().keySet().retainAll(r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@NullableDecl K r10, @NullableDecl V1 r11);
    }

    public static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {

        @RetainedWith
        private final BiMap<V, K> inverse;

        public FilteredEntryBiMap(BiMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
            super(r10, r11);
            this.inverse = new FilteredEntryBiMap(r10.inverse(), inversePredicate(r11), this);
        }

        private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> r10) {
            return new AnonymousClass1(r10);
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(@NullableDecl K r10, @NullableDecl V r11) {
            Preconditions.checkArgument(apply(r10, r11));
            return unfiltered().forcePut(r10, r11);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            return this.inverse;
        }

        public BiMap<K, V> unfiltered() {
            return (BiMap) this.unfiltered;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.inverse.keySet();
        }

        private FilteredEntryBiMap(BiMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11, BiMap<V, K> r12) {
            super(r10, r11);
            this.inverse = r12;
        }
    }

    public static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> filteredEntrySet;

        public class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            final /* synthetic */ FilteredEntryMap this$0;

            private EntrySet(FilteredEntryMap r10) {
                this.this$0 = r10;
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public /* bridge */ /* synthetic */ Object delegate() {
                return delegate();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                final Iterator<Map.Entry<K, V>> r10 = this.this$0.filteredEntrySet.iterator();
                return new AnonymousClass1(this, r10);
            }

            public /* synthetic */ EntrySet(FilteredEntryMap r10, AnonymousClass1 r11) {
                this(r10);
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public /* bridge */ /* synthetic */ Collection delegate() {
                return delegate();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<Map.Entry<K, V>> delegate() {
                return this.this$0.filteredEntrySet;
            }
        }

        public class KeySet extends KeySet<K, V> {
            final /* synthetic */ FilteredEntryMap this$0;

            public KeySet(FilteredEntryMap r10) {
                this.this$0 = r10;
                super(r10);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                if (this.this$0.containsKey(r10) == false) goto L6;
                this.this$0.unfiltered.remove(r10);
                return true;
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> r10) {
                FilteredEntryMap r11 = this.this$0;
                return FilteredEntryMap.removeAllKeys(r11.unfiltered, r11.predicate, r10);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r10) {
                FilteredEntryMap r11 = this.this$0;
                return FilteredEntryMap.retainAllKeys(r11.unfiltered, r11.predicate, r10);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] r10) {
                return (T[]) Lists.newArrayList(iterator()).toArray(r10);
            }
        }

        public FilteredEntryMap(Map<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
            super(r10, r11);
            this.filteredEntrySet = Sets.filter(r10.entrySet(), this.predicate);
        }

        public static <K, V> boolean removeAllKeys(Map<K, V> r10, Predicate<? super Map.Entry<K, V>> r11, Collection<?> r12) {
            Iterator<Map.Entry<K, V>> r13 = r10.entrySet().iterator();
            boolean r14 = false;
        L4:
            if (r13.hasNext() == false) goto L10;
            Map.Entry<K, V> r15 = r13.next();
            if (r11.apply(r15) == false) goto L4;
            if (r12.contains(r15.getKey()) == false) goto L4;
            r13.remove();
            r14 = true;
            goto L4
        L10:
            return r14;
        }

        public static <K, V> boolean retainAllKeys(Map<K, V> r10, Predicate<? super Map.Entry<K, V>> r11, Collection<?> r12) {
            Iterator<Map.Entry<K, V>> r13 = r10.entrySet().iterator();
            boolean r14 = false;
        L4:
            if (r13.hasNext() == false) goto L10;
            Map.Entry<K, V> r15 = r13.next();
            if (r11.apply(r15) == false) goto L4;
            if (r12.contains(r15.getKey()) == true) goto L4;
            r13.remove();
            r14 = true;
            goto L4
        L10:
            return r14;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet(this, null);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<K> createKeySet() {
            return new KeySet(this);
        }
    }

    @GwtIncompatible
    public static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
        private final Predicate<? super Map.Entry<K, V>> entryPredicate;
        private final Map<K, V> filteredDelegate;
        private final NavigableMap<K, V> unfiltered;

        public FilteredEntryNavigableMap(NavigableMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
            this.unfiltered = (NavigableMap) Preconditions.checkNotNull(r10);
            this.entryPredicate = r11;
            this.filteredDelegate = new FilteredEntryMap(r10, r11);
        }

        public static /* synthetic */ Predicate access$500(FilteredEntryNavigableMap r10) {
            return r10.entryPredicate;
        }

        public static /* synthetic */ NavigableMap access$600(FilteredEntryNavigableMap r10) {
            return r10.unfiltered;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.filteredDelegate.clear();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.unfiltered.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            return this.filteredDelegate.containsKey(r10);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return this.filteredDelegate.entrySet();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @NullableDecl
        public V get(@NullableDecl Object r10) {
            return this.filteredDelegate.get(r10);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r10, boolean r11) {
            return Maps.filterEntries(this.unfiltered.headMap(r10, r11), this.entryPredicate);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new AnonymousClass1(this, this);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r10, V r11) {
            return this.filteredDelegate.put(r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> r10) {
            this.filteredDelegate.putAll(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@NullableDecl Object r10) {
            return this.filteredDelegate.remove(r10);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.filteredDelegate.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
            return Maps.filterEntries(this.unfiltered.subMap(r10, r11, r12, r13), this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r10, boolean r11) {
            return Maps.filterEntries(this.unfiltered.tailMap(r10, r11), this.entryPredicate);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new FilteredMapValues(this, this.unfiltered, this.entryPredicate);
        }
    }

    public static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

        public class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            final /* synthetic */ FilteredEntrySortedMap this$0;

            public SortedKeySet(FilteredEntrySortedMap r10) {
                this.this$0 = r10;
                super(r10);
            }

            @Override // java.util.SortedSet
            public Comparator<? super K> comparator() {
                return this.this$0.sortedMap().comparator();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) this.this$0.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(K r10) {
                return (SortedSet) this.this$0.headMap(r10).keySet();
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) this.this$0.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(K r10, K r11) {
                return (SortedSet) this.this$0.subMap(r10, r11).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(K r10) {
                return (SortedSet) this.this$0.tailMap(r10).keySet();
            }
        }

        public FilteredEntrySortedMap(SortedMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
            super(r10, r11);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return keySet().iterator().next();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K r10) {
            return new FilteredEntrySortedMap(sortedMap().headMap(r10), this.predicate);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            SortedMap<K, V> r10 = sortedMap();
        L3:
            K r11 = r10.lastKey();
            if (apply(r11, this.unfiltered.get(r11)) == true) goto L5;
            r10 = sortedMap().headMap(r11);
            goto L3
        L5:
            return r11;
        }

        public SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K r10, K r11) {
            return new FilteredEntrySortedMap(sortedMap().subMap(r10, r11), this.predicate);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K r10) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(r10), this.predicate);
        }

        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet<K> createKeySet() {
            return new SortedKeySet(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }
    }

    public static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        final Predicate<? super K> keyPredicate;

        public FilteredKeyMap(Map<K, V> r10, Predicate<? super K> r11, Predicate<? super Map.Entry<K, V>> r12) {
            super(r10, r12);
            this.keyPredicate = r11;
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            if (this.unfiltered.containsKey(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.keyPredicate.apply(r10) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), this.predicate);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<K> createKeySet() {
            return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
        }
    }

    public static final class FilteredMapValues<K, V> extends Values<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        public FilteredMapValues(Map<K, V> r10, Map<K, V> r11, Predicate<? super Map.Entry<K, V>> r12) {
            super(r10);
            this.unfiltered = r11;
            this.predicate = r12;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r10) {
            Iterator<Map.Entry<K, V>> r11 = this.unfiltered.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            Map.Entry<K, V> r12 = r11.next();
            if (this.predicate.apply(r12) == false) goto L4;
            if (Objects.equal(r12.getValue(), r10) == false) goto L4;
            r11.remove();
            return true;
        L11:
            return false;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            Iterator<Map.Entry<K, V>> r11 = this.unfiltered.entrySet().iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L10;
            Map.Entry<K, V> r13 = r11.next();
            if (this.predicate.apply(r13) == false) goto L4;
            if (r10.contains(r13.getValue()) == false) goto L4;
            r11.remove();
            r12 = true;
            goto L4
        L10:
            return r12;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            Iterator<Map.Entry<K, V>> r11 = this.unfiltered.entrySet().iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L10;
            Map.Entry<K, V> r13 = r11.next();
            if (this.predicate.apply(r13) == false) goto L4;
            if (r10.contains(r13.getValue()) == true) goto L4;
            r11.remove();
            r12 = true;
            goto L4
        L10:
            return r12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r10) {
            return (T[]) Lists.newArrayList(iterator()).toArray(r10);
        }
    }

    public static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        public IteratorBasedAbstractMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.clear(entryIterator());
        }

        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    public static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {

        @Weak
        final Map<K, V> map;

        public KeySet(Map<K, V> r10) {
            this.map = (Map) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return map().containsKey(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        public Map<K, V> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (contains(r10) == false) goto L6;
            map().remove(r10);
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }
    }

    public static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final Map<K, MapDifference.ValueDifference<V>> differences;
        final Map<K, V> onBoth;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;

        public MapDifferenceImpl(Map<K, V> r10, Map<K, V> r11, Map<K, V> r12, Map<K, MapDifference.ValueDifference<V>> r13) {
            this.onlyOnLeft = Maps.access$100(r10);
            this.onlyOnRight = Maps.access$100(r11);
            this.onBoth = Maps.access$100(r12);
            this.differences = Maps.access$100(r13);
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
        public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesInCommon() {
            return this.onBoth;
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
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof MapDifference) == false) goto L18;
            MapDifference r11 = (MapDifference) r10;
            if (entriesOnlyOnLeft().equals(r11.entriesOnlyOnLeft()) == false) goto L17;
            if (entriesOnlyOnRight().equals(r11.entriesOnlyOnRight()) == false) goto L17;
            if (entriesInCommon().equals(r11.entriesInCommon()) == false) goto L17;
            if (entriesDiffering().equals(r11.entriesDiffering()) == false) goto L17;
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
            StringBuilder r10 = new StringBuilder("not equal");
            if (this.onlyOnLeft.isEmpty() == true) goto L10;
            r10.append(": only on left=");
            r10.append(this.onlyOnLeft);
        L10:
            if (this.onlyOnRight.isEmpty() == true) goto L13;
            r10.append(": only on right=");
            r10.append(this.onlyOnRight);
        L13:
            if (this.differences.isEmpty() == true) goto L16;
            r10.append(": value differences=");
            r10.append(this.differences);
        L16:
            return r10.toString();
        }
    }

    @GwtIncompatible
    public static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
        private final Function<? super K, V> function;
        private final NavigableSet<K> set;

        public NavigableAsMapView(NavigableSet<K> r10, Function<? super K, V> r11) {
            this.set = (NavigableSet) Preconditions.checkNotNull(r10);
            this.function = (Function) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.set.clear();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.set.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.asMap(this.set.descendingSet(), this.function);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return Maps.asMapEntryIterator(this.set, this.function);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @NullableDecl
        public V get(@NullableDecl Object r10) {
            if (Collections2.safeContains(this.set, r10) == true) goto L5;
            return null;
        L5:
            return this.function.apply(r10);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r10, boolean r11) {
            return Maps.asMap(this.set.headSet(r10, r11), this.function);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Maps.access$400(this.set);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.set.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
            return Maps.asMap(this.set.subSet(r10, r11, r12, r13), this.function);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r10, boolean r11) {
            return Maps.asMap(this.set.tailSet(r10, r11), this.function);
        }
    }

    @GwtIncompatible
    public static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        public NavigableKeySet(NavigableMap<K, V> r10) {
            super(r10);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K r10) {
            return map().ceilingKey(r10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return map().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K r10) {
            return map().floorKey(r10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K r10, boolean r11) {
            return map().headMap(r10, r11).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K r10) {
            return map().higherKey(r10);
        }

        @Override // java.util.NavigableSet
        public K lower(K r10) {
            return map().lowerKey(r10);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        public /* bridge */ /* synthetic */ Map map() {
            return map();
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
        public NavigableSet<K> subSet(K r10, boolean r11, K r12, boolean r13) {
            return map().subMap(r10, r11, r12, r13).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K r10, boolean r11) {
            return map().tailMap(r10, r11).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K r10) {
            return headSet(r10, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        public /* bridge */ /* synthetic */ SortedMap map() {
            return map();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K r10, K r11) {
            return subSet(r10, true, r11, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K r10) {
            return tailSet(r10, true);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        public NavigableMap<K, V> map() {
            return (NavigableMap) this.map;
        }
    }

    public static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        public SortedAsMapView(SortedSet<K> r10, Function<? super K, V> r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Maps.AsMapView
        public /* bridge */ /* synthetic */ Set backingSet() {
            return backingSet();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return backingSet().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return backingSet().first();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K r10) {
            return Maps.asMap(backingSet().headSet(r10), this.function);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return Maps.access$300(backingSet());
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return backingSet().last();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K r10, K r11) {
            return Maps.asMap(backingSet().subSet(r10, r11), this.function);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K r10) {
            return Maps.asMap(backingSet().tailSet(r10), this.function);
        }

        @Override // com.google.common.collect.Maps.AsMapView
        public SortedSet<K> backingSet() {
            return (SortedSet) super.backingSet();
        }
    }

    public static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        public SortedKeySet(SortedMap<K, V> r10) {
            super(r10);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return map().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return map().firstKey();
        }

        public SortedSet<K> headSet(K r10) {
            return new SortedKeySet(map().headMap(r10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return map().lastKey();
        }

        @Override // com.google.common.collect.Maps.KeySet
        public /* bridge */ /* synthetic */ Map map() {
            return map();
        }

        public SortedSet<K> subSet(K r10, K r11) {
            return new SortedKeySet(map().subMap(r10, r11));
        }

        public SortedSet<K> tailSet(K r10) {
            return new SortedKeySet(map().tailMap(r10));
        }

        @Override // com.google.common.collect.Maps.KeySet
        public SortedMap<K, V> map() {
            return (SortedMap) super.map();
        }
    }

    public static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        public SortedMapDifferenceImpl(SortedMap<K, V> r10, SortedMap<K, V> r11, SortedMap<K, V> r12, SortedMap<K, MapDifference.ValueDifference<V>> r13) {
            super(r10, r11, r12, r13);
        }

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

    public static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;

        public TransformedEntriesMap(Map<K, V1> r10, EntryTransformer<? super K, ? super V1, V2> r11) {
            this.fromMap = (Map) Preconditions.checkNotNull(r10);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.fromMap.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            return this.fromMap.containsKey(r10);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object r10) {
            V1 r11 = this.fromMap.get(r10);
            if (r11 != null) goto L9;
            if (this.fromMap.containsKey(r10) == true) goto L9;
            return null;
        L9:
            return this.transformer.transformEntry(r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object r10) {
            if (this.fromMap.containsKey(r10) == true) goto L7;
            return null;
        L7:
            return this.transformer.transformEntry(r10, this.fromMap.remove(r10));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.fromMap.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new Values(this);
        }
    }

    @GwtIncompatible
    public static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        public TransformedEntriesNavigableMap(NavigableMap<K, V1> r10, EntryTransformer<? super K, ? super V1, V2> r11) {
            super(r10, r11);
        }

        @NullableDecl
        private Map.Entry<K, V2> transformEntry(@NullableDecl Map.Entry<K, V1> r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            return Maps.transformEntry(this.transformer, r10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> ceilingEntry(K r10) {
            return transformEntry(fromMap().ceilingEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r10) {
            return fromMap().ceilingKey(r10);
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
        public Map.Entry<K, V2> floorEntry(K r10) {
            return transformEntry(fromMap().floorEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r10) {
            return fromMap().floorKey(r10);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        public /* bridge */ /* synthetic */ SortedMap fromMap() {
            return fromMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object r10) {
            return headMap(r10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> higherEntry(K r10) {
            return transformEntry(fromMap().higherEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r10) {
            return fromMap().higherKey(r10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lastEntry() {
            return transformEntry(fromMap().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lowerEntry(K r10) {
            return transformEntry(fromMap().lowerEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r10) {
            return fromMap().lowerKey(r10);
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap subMap(Object r10, Object r11) {
            return subMap(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object r10) {
            return tailMap(r10);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        public NavigableMap<K, V1> fromMap() {
            return (NavigableMap) super.fromMap();
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K r10) {
            return headMap(r10, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K r10, boolean r11, K r12, boolean r13) {
            return Maps.transformEntries(fromMap().subMap(r10, r11, r12, r13), this.transformer);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K r10) {
            return tailMap(r10, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K r10, boolean r11) {
            return Maps.transformEntries(fromMap().headMap(r10, r11), this.transformer);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K r10, boolean r11) {
            return Maps.transformEntries(fromMap().tailMap(r10, r11), this.transformer);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K r10, K r11) {
            return subMap(r10, true, r11, false);
        }
    }

    public static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        public TransformedEntriesSortedMap(SortedMap<K, V1> r10, EntryTransformer<? super K, ? super V1, V2> r11) {
            super(r10, r11);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        public SortedMap<K, V2> headMap(K r10) {
            return Maps.transformEntries(fromMap().headMap(r10), this.transformer);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(K r10, K r11) {
            return Maps.transformEntries(fromMap().subMap(r10, r11), this.transformer);
        }

        public SortedMap<K, V2> tailMap(K r10) {
            return Maps.transformEntries(fromMap().tailMap(r10), this.transformer);
        }
    }

    public static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;

        @RetainedWith
        @MonotonicNonNullDecl
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;

        @MonotonicNonNullDecl
        transient Set<V> values;

        public UnmodifiableBiMap(BiMap<? extends K, ? extends V> r10, @NullableDecl BiMap<V, K> r11) {
            this.unmodifiableMap = Collections.unmodifiableMap(r10);
            this.delegate = r10;
            this.inverse = r11;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K r10, V r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> r10 = this.inverse;
            if (r10 != null) goto L6;
            UnmodifiableBiMap r11 = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<V> values() {
            Set<V> r10 = this.values;
            if (r10 != null) goto L6;
            Set<V> r11 = Collections.unmodifiableSet(this.delegate.values());
            this.values = r11;
            return r11;
        L6:
            return r10;
        }
    }

    public static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> entries;

        public UnmodifiableEntries(Collection<Map.Entry<K, V>> r10) {
            this.entries = r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.unmodifiableEntryIterator(this.entries.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            return (T[]) standardToArray(r10);
        }
    }

    public static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        public UnmodifiableEntrySet(Set<Map.Entry<K, V>> r10) {
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

    @GwtIncompatible
    public static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;

        @MonotonicNonNullDecl
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r10) {
            this.delegate = r10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r10) {
            return Maps.access$800(this.delegate.ceilingEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r10) {
            return this.delegate.ceilingKey(r10);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> r10 = this.descendingMap;
            if (r10 != null) goto L6;
            UnmodifiableNavigableMap<K, V> r11 = new UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
            this.descendingMap = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.access$800(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r10) {
            return Maps.access$800(this.delegate.floorEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r10) {
            return this.delegate.floorKey(r10);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K r10) {
            return headMap(r10, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r10) {
            return Maps.access$800(this.delegate.higherEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r10) {
            return this.delegate.higherKey(r10);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.access$800(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r10) {
            return Maps.access$800(this.delegate.lowerEntry(r10));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r10) {
            return this.delegate.lowerKey(r10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K r10, K r11) {
            return subMap(r10, true, r11, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K r10) {
            return tailMap(r10, true);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r10, boolean r11) {
            return Maps.unmodifiableNavigableMap(this.delegate.headMap(r10, r11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
            return Maps.unmodifiableNavigableMap(this.delegate.subMap(r10, r11, r12, r13));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r10, boolean r11) {
            return Maps.unmodifiableNavigableMap(this.delegate.tailMap(r10, r11));
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r10, UnmodifiableNavigableMap<K, V> r11) {
            this.delegate = r10;
            this.descendingMap = r11;
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    public static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {

        @NullableDecl
        private final V left;

        @NullableDecl
        private final V right;

        private ValueDifferenceImpl(@NullableDecl V r10, @NullableDecl V r11) {
            this.left = r10;
            this.right = r11;
        }

        public static <V> MapDifference.ValueDifference<V> create(@NullableDecl V r10, @NullableDecl V r11) {
            return new ValueDifferenceImpl(r10, r11);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof MapDifference.ValueDifference) == false) goto L10;
            MapDifference.ValueDifference r11 = (MapDifference.ValueDifference) r10;
            if (Objects.equal(this.left, r11.leftValue()) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.right, r11.rightValue()) == false) goto L12;
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

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V leftValue() {
            return this.left;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V rightValue() {
            return this.right;
        }

        public String toString() {
            return "(" + this.left + ", " + this.right + ")";
        }
    }

    public static class Values<K, V> extends AbstractCollection<V> {

        @Weak
        final Map<K, V> map;

        public Values(Map<K, V> r10) {
            this.map = (Map) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object r10) {
            return map().containsValue(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        public final Map<K, V> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r10) {
            return super.remove(r10);
        L4:
            Iterator<Map.Entry<K, V>> r11 = map().entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L11;
            Map.Entry<K, V> r12 = r11.next();
            if (Objects.equal(r10, r12.getValue()) == false) goto L6;
            map().remove(r12.getKey());
            return true;
        L11:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            return super.removeAll((Collection) Preconditions.checkNotNull(r10));
        L4:
            HashSet r11 = Sets.newHashSet();
            Iterator<Map.Entry<K, V>> r12 = map().entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            Map.Entry<K, V> r13 = r12.next();
            if (r10.contains(r13.getValue()) == false) goto L6;
            r11.add(r13.getKey());
            goto L6
        L11:
            return map().keySet().removeAll(r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r10));
        L4:
            HashSet r11 = Sets.newHashSet();
            Iterator<Map.Entry<K, V>> r12 = map().entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            Map.Entry<K, V> r13 = r12.next();
            if (r10.contains(r13.getValue()) == false) goto L6;
            r11.add(r13.getKey());
            goto L6
        L11:
            return map().keySet().retainAll(r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return map().size();
        }
    }

    @GwtCompatible
    public static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {

        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> entrySet;

        @MonotonicNonNullDecl
        private transient Set<K> keySet;

        @MonotonicNonNullDecl
        private transient Collection<V> values;

        public ViewCachingAbstractMap() {
        }

        public abstract Set<Map.Entry<K, V>> createEntrySet();

        public Set<K> createKeySet() {
            return new KeySet(this);
        }

        public Collection<V> createValues() {
            return new Values(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r10 = this.entrySet;
            if (r10 != null) goto L6;
            Set<Map.Entry<K, V>> r11 = createEntrySet();
            this.entrySet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> r10 = this.keySet;
            if (r10 != null) goto L6;
            Set<K> r11 = createKeySet();
            this.keySet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> r10 = this.values;
            if (r10 != null) goto L6;
            Collection<V> r11 = createValues();
            this.values = r11;
            return r11;
        L6:
            return r10;
        }
    }

    private Maps() {
    }

    public static /* synthetic */ Map access$100(Map r10) {
        return unmodifiableMap(r10);
    }

    public static /* synthetic */ Set access$200(Set r10) {
        return removeOnlySet(r10);
    }

    public static /* synthetic */ SortedSet access$300(SortedSet r10) {
        return removeOnlySortedSet(r10);
    }

    public static /* synthetic */ NavigableSet access$400(NavigableSet r10) {
        return removeOnlyNavigableSet(r10);
    }

    public static /* synthetic */ Map.Entry access$800(Map.Entry r10) {
        return unmodifiableOrNull(r10);
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> r10) {
        return new BiMapConverter(r10);
    }

    public static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass13(r10);
    }

    public static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass11(r10);
    }

    public static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass9(r10);
    }

    public static <K, V> Map<K, V> asMap(Set<K> r10, Function<? super K, V> r11) {
        return new AsMapView(r10, r11);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> r10, final Function<? super K, V> r11) {
        final Iterator<K> r12 = r10.iterator();
        return new AnonymousClass3(r12, r11);
    }

    public static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> r10, final K r11) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass10(r10, r11);
    }

    public static int capacity(int r10) {
        if (r10 >= 3) goto L7;
        CollectPreconditions.checkNonnegative(r10, "expectedSize");
        return r10 + 1;
    L7:
        if (r10 < 1073741824) goto L9;
        return Channel.UNLIMITED;
    L9:
        return (int) ((r10 / 0.75f) + 1.0f);
    }

    public static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> r10, Object r11) {
        if ((r11 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return r10.contains(unmodifiableEntry((Map.Entry) r11));
    }

    public static boolean containsKeyImpl(Map<?, ?> r10, @NullableDecl Object r11) {
        return Iterators.contains(keyIterator(r10.entrySet().iterator()), r11);
    }

    public static boolean containsValueImpl(Map<?, ?> r10, @NullableDecl Object r11) {
        return Iterators.contains(valueIterator(r10.entrySet().iterator()), r11);
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> r10, Map<? extends K, ? extends V> r11) {
        if ((r10 instanceof SortedMap) == false) goto L7;
        return difference((SortedMap) r10, r11);
    L7:
        return difference(r10, r11, Equivalence.equals());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void doDifference(Map<? extends K, ? extends V> r10, Map<? extends K, ? extends V> r11, Equivalence<? super V> r12, Map<K, V> r13, Map<K, V> r14, Map<K, V> r15, Map<K, MapDifference.ValueDifference<V>> r16) {
        Iterator<Map.Entry<? extends K, ? extends V>> r17 = r10.entrySet().iterator();
    L4:
        if (r17.hasNext() == false) goto L12;
        Map.Entry<? extends K, ? extends V> r18 = r17.next();
        K r19 = r18.getKey();
        V r20 = r18.getValue();
        if (r11.containsKey(r19) == true) goto L7;
        r13.put(r19, r20);
        goto L4
    L7:
        V r21 = r14.remove(r19);
        if (r12.equivalent(r20, r21) == true) goto L9;
        r16.put(r19, ValueDifferenceImpl.create(r20, r21));
        goto L4
    L9:
        r15.put(r19, r20);
        goto L4
    }

    public static boolean equalsImpl(Map<?, ?> r10, Object r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if ((r11 instanceof Map) == true) goto L8;
        return false;
    L8:
        return r10.entrySet().equals(((Map) r11).entrySet());
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof AbstractFilteredMap) == false) goto L6;
        return filterFiltered((AbstractFilteredMap) r10, r11);
    L6:
        return new FilteredEntryMap((Map) Preconditions.checkNotNull(r10), r11);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        return new FilteredEntryMap(r10.unfiltered, Predicates.and(r10.predicate, r11));
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> r10, Predicate<? super K> r11) {
        Preconditions.checkNotNull(r11);
        Predicate r12 = keyPredicateOnEntries(r11);
        if ((r10 instanceof AbstractFilteredMap) == false) goto L6;
        return filterFiltered((AbstractFilteredMap) r10, r12);
    L6:
        return new FilteredKeyMap((Map) Preconditions.checkNotNull(r10), r11, r12);
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> r10, Predicate<? super V> r11) {
        return filterEntries(r10, valuePredicateOnEntries(r11));
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> fromProperties(Properties r10) {
        ImmutableMap.Builder r11 = ImmutableMap.builder();
        Enumeration<?> r12 = r10.propertyNames();
    L4:
        if (r12.hasMoreElements() == false) goto L7;
        String r13 = (String) r12.nextElement();
        r11.put(r13, r10.getProperty(r13));
        goto L4
    L7:
        return r11.build();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> immutableEntry(@NullableDecl K r10, @NullableDecl V r11) {
        return new ImmutableEntry(r10, r11);
    }

    @GwtCompatible(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> r10) {
        if ((r10 instanceof ImmutableEnumMap) == true) goto L5;
        Iterator<Map.Entry<K, ? extends V>> r11 = r10.entrySet().iterator();
        if (r11.hasNext() == false) goto L9;
        Map.Entry<K, ? extends V> r12 = r11.next();
        K r13 = r12.getKey();
        V r14 = r12.getValue();
        CollectPreconditions.checkEntryNotNull(r13, r14);
        EnumMap r15 = new EnumMap(r13.getDeclaringClass());
        r15.put(r13, r14);
    L12:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<K, ? extends V> r16 = r11.next();
        K r17 = r16.getKey();
        V r18 = r16.getValue();
        CollectPreconditions.checkEntryNotNull(r17, r18);
        r15.put(r17, r18);
        goto L12
    L15:
        return ImmutableEnumMap.asImmutable(r15);
    L9:
        return ImmutableMap.of();
    L5:
        return (ImmutableEnumMap) r10;
    }

    public static <E> ImmutableMap<E, Integer> indexMap(Collection<E> r10) {
        ImmutableMap.Builder r11 = new ImmutableMap.Builder(r10.size());
        Iterator<E> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L7;
        int r14 = r13 + 1;
        r11.put(r12.next(), Integer.valueOf(r13));
        r13 = r14;
        goto L4
    L7:
        return r11.build();
    }

    public static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> keyIterator(final Iterator<Map.Entry<K, V>> r10) {
        return new AnonymousClass1(r10);
    }

    @NullableDecl
    public static <K> K keyOrNull(@NullableDecl Map.Entry<K, ?> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getKey();
    }

    public static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> r10) {
        return Predicates.compose(r10, keyFunction());
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> r10) {
        return new EnumMap((Class) Preconditions.checkNotNull(r10));
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int r10) {
        return new HashMap(capacity(r10));
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int r10) {
        return new LinkedHashMap(capacity(r10));
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap();
    }

    public static <E> Comparator<? super E> orNaturalOrder(@NullableDecl Comparator<? super E> r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Ordering.natural();
    }

    public static <K, V> void putAllImpl(Map<K, V> r10, Map<? extends K, ? extends V> r11) {
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r13 = r12.next();
        r10.put(r13.getKey(), r13.getValue());
        goto L4
    }

    public static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> r10, Object r11) {
        if ((r11 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return r10.remove(unmodifiableEntry((Map.Entry) r11));
    }

    @GwtIncompatible
    private static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> r10) {
        return new AnonymousClass6(r10);
    }

    private static <E> Set<E> removeOnlySet(final Set<E> r10) {
        return new AnonymousClass4(r10);
    }

    private static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> r10) {
        return new AnonymousClass5(r10);
    }

    public static boolean safeContainsKey(Map<?, ?> r10, Object r11) {
        Preconditions.checkNotNull(r10);
        return r10.containsKey(r11);
    L5:
        return false;
    }

    public static <V> V safeGet(Map<?, V> r10, @NullableDecl Object r11) {
        Preconditions.checkNotNull(r10);
        return r10.get(r11);
    L5:
        return null;
    }

    public static <V> V safeRemove(Map<?, V> r10, Object r11) {
        Preconditions.checkNotNull(r10);
        return r10.remove(r11);
    L5:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> r10, Range<K> r11) {
        boolean r12 = false;
        if (r10.comparator() == null) goto L16;
        if (r10.comparator() == Ordering.natural()) goto L16;
        if (r11.hasLowerBound() == false) goto L16;
        if (r11.hasUpperBound() == false) goto L16;
        if (r10.comparator().compare(r11.lowerEndpoint(), r11.upperEndpoint()) > 0) goto L13;
        boolean r13 = true;
    L14:
        Preconditions.checkArgument(r13, "map is using a custom comparator which is inconsistent with the natural ordering.");
        goto L16
    L13:
        r13 = false;
    L16:
        if (r11.hasLowerBound() == false) goto L29;
        if (r11.hasUpperBound() == false) goto L29;
        Comparable r14 = r11.lowerEndpoint();
        BoundType r15 = r11.lowerBoundType();
        BoundType r16 = BoundType.CLOSED;
        if (r15 != r16) goto L22;
        boolean r17 = true;
    L23:
        Comparable r18 = r11.upperEndpoint();
        if (r11.upperBoundType() != r16) goto L27;
        r12 = true;
    L27:
        return r10.subMap(r14, r17, r18, r12);
    L22:
        r17 = false;
    L29:
        if (r11.hasLowerBound() == false) goto L36;
        Comparable r19 = r11.lowerEndpoint();
        if (r11.lowerBoundType() != BoundType.CLOSED) goto L34;
        r12 = true;
    L34:
        return r10.tailMap(r19, r12);
    L36:
        if (r11.hasUpperBound() == false) goto L43;
        Comparable r20 = r11.upperEndpoint();
        if (r11.upperBoundType() != BoundType.CLOSED) goto L41;
        r12 = true;
    L41:
        return r10.headMap(r20, r12);
    L43:
        return (NavigableMap) Preconditions.checkNotNull(r10);
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> r10) {
        return Synchronized.biMap(r10, null);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> r10) {
        return Synchronized.navigableMap(r10);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> r10, Function<? super K, V> r11) {
        return toMap(r10.iterator(), r11);
    }

    public static String toStringImpl(Map<?, ?> r10) {
        StringBuilder r11 = Collections2.newStringBuilderForCollection(r10.size());
        r11.append('{');
        Iterator<Map.Entry<?, ?>> r12 = r10.entrySet().iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<?, ?> r14 = r12.next();
        if (r13 == true) goto L8;
        r11.append(", ");
    L8:
        r11.append(r14.getKey());
        r11.append('=');
        r11.append(r14.getValue());
        r13 = false;
        goto L4
    L9:
        r11.append('}');
        return r11.toString();
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> r10, EntryTransformer<? super K, ? super V1, V2> r11) {
        return new TransformedEntriesMap(r10, r11);
    }

    public static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> r10, final Map.Entry<K, V1> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass12(r11, r10);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> r10, Function<? super V1, V2> r11) {
        return transformEntries(r10, asEntryTransformer(r11));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> r10, Function<? super V, K> r11) {
        return uniqueIndex(r10.iterator(), r11);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> r10) {
        return new UnmodifiableBiMap(r10, null);
    }

    public static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<? extends K, ? extends V> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass7(r10);
    }

    public static <K, V> UnmodifiableIterator<Map.Entry<K, V>> unmodifiableEntryIterator(final Iterator<Map.Entry<K, V>> r10) {
        return new AnonymousClass8(r10);
    }

    public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> r10) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(r10));
    }

    private static <K, V> Map<K, V> unmodifiableMap(Map<K, ? extends V> r10) {
        if ((r10 instanceof SortedMap) == false) goto L7;
        return Collections.unmodifiableSortedMap((SortedMap) r10);
    L7:
        return Collections.unmodifiableMap(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof UnmodifiableNavigableMap) == false) goto L6;
        return r10;
    L6:
        return new UnmodifiableNavigableMap(r10);
    }

    @NullableDecl
    private static <K, V> Map.Entry<K, V> unmodifiableOrNull(@NullableDecl Map.Entry<K, ? extends V> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return unmodifiableEntry(r10);
    }

    public static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    public static <K, V> Iterator<V> valueIterator(final Iterator<Map.Entry<K, V>> r10) {
        return new AnonymousClass2(r10);
    }

    @NullableDecl
    public static <V> V valueOrNull(@NullableDecl Map.Entry<?, V> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getValue();
    }

    public static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> r10) {
        return Predicates.compose(r10, valueFunction());
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> r10, Function<? super K, V> r11) {
        return new SortedAsMapView(r10, r11);
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> r10, Predicate<? super V> r11) {
        return filterEntries(r10, valuePredicateOnEntries(r11));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> r10) {
        return new EnumMap(r10);
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> r10) {
        return new HashMap(r10);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> r10) {
        return new LinkedHashMap(r10);
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> r10) {
        return new TreeMap(r10);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> r10, Function<? super K, V> r11) {
        Preconditions.checkNotNull(r11);
        LinkedHashMap r12 = newLinkedHashMap();
    L4:
        if (r10.hasNext() == false) goto L7;
        K r13 = r10.next();
        r12.put(r13, r11.apply(r13));
        goto L4
    L7:
        return ImmutableMap.copyOf(r12);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> r10, EntryTransformer<? super K, ? super V1, V2> r11) {
        return new TransformedEntriesSortedMap(r10, r11);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> r10, Function<? super V1, V2> r11) {
        return transformEntries(r10, asEntryTransformer(r11));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> r10, Function<? super V, K> r11) {
        Preconditions.checkNotNull(r11);
        ImmutableMap.Builder r12 = ImmutableMap.builder();
    L4:
        if (r10.hasNext() == false) goto L11;
        V r13 = r10.next();
        r12.put(r11.apply(r13), r13);
        goto L4
    L11:
        return r12.build();
    L8:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> r10, Function<? super K, V> r11) {
        return new NavigableAsMapView(r10, r11);
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Predicate r12 = Predicates.and(r10.predicate, r11);
        return new FilteredEntrySortedMap(r10.sortedMap(), r12);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> r10, Predicate<? super V> r11) {
        return filterEntries(r10, valuePredicateOnEntries(r11));
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@NullableDecl Comparator<C> r10) {
        return new TreeMap(r10);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> r10, EntryTransformer<? super K, ? super V1, V2> r11) {
        return new TransformedEntriesNavigableMap(r10, r11);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> r10, Function<? super V1, V2> r11) {
        return transformEntries(r10, asEntryTransformer(r11));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> r10, Predicate<? super V> r11) {
        return filterEntries(r10, valuePredicateOnEntries(r11));
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> r11, Map<? extends K, ? extends V> r12, Equivalence<? super V> r13) {
        Preconditions.checkNotNull(r13);
        LinkedHashMap r10 = newLinkedHashMap();
        LinkedHashMap r14 = new LinkedHashMap(r12);
        LinkedHashMap r15 = newLinkedHashMap();
        LinkedHashMap r16 = newLinkedHashMap();
        doDifference(r11, r12, r13, r10, r14, r15, r16);
        return new MapDifferenceImpl(r10, r14, r15, r16);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof FilteredEntrySortedMap) == false) goto L6;
        return filterFiltered((FilteredEntrySortedMap) r10, r11);
    L6:
        return new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(r10), r11);
    }

    @GwtIncompatible
    private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Predicate r12 = Predicates.and(FilteredEntryNavigableMap.access$500(r10), r11);
        return new FilteredEntryNavigableMap(FilteredEntryNavigableMap.access$600(r10), r12);
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> r10, Predicate<? super K> r11) {
        return filterEntries(r10, keyPredicateOnEntries(r11));
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Predicate r12 = Predicates.and(r10.predicate, r11);
        return new FilteredEntryBiMap(r10.unfiltered(), r12);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> r10, Predicate<? super K> r11) {
        return filterEntries(r10, keyPredicateOnEntries(r11));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> r10, Predicate<? super K> r11) {
        Preconditions.checkNotNull(r11);
        return filterEntries(r10, keyPredicateOnEntries(r11));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof FilteredEntryNavigableMap) == false) goto L6;
        return filterFiltered((FilteredEntryNavigableMap) r10, r11);
    L6:
        return new FilteredEntryNavigableMap((NavigableMap) Preconditions.checkNotNull(r10), r11);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> r11, Map<? extends K, ? extends V> r12) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        Comparator r10 = orNaturalOrder(r11.comparator());
        TreeMap r13 = newTreeMap(r10);
        TreeMap r14 = newTreeMap(r10);
        r14.putAll(r12);
        TreeMap r15 = newTreeMap(r10);
        TreeMap r16 = newTreeMap(r10);
        doDifference(r11, r12, Equivalence.equals(), r13, r14, r15, r16);
        return new SortedMapDifferenceImpl(r13, r14, r15, r16);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof FilteredEntryBiMap) == false) goto L6;
        return filterFiltered((FilteredEntryBiMap) r10, r11);
    L6:
        return new FilteredEntryBiMap(r10, r11);
    }
}
