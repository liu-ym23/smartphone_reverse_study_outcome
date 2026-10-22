package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Multimaps {

    public static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        @Weak
        private final Multimap<K, V> multimap;

        public class EntrySet extends Maps.EntrySet<K, Collection<V>> {
            final /* synthetic */ AsMap this$0;

            public EntrySet(AsMap r10) {
                this.this$0 = r10;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.asMapEntryIterator(AsMap.access$200(this.this$0).keySet(), new AnonymousClass1(this));
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, Collection<V>> map() {
                return this.this$0;
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                if (contains(r10) == true) goto L6;
                return false;
            L6:
                this.this$0.removeValuesForKey(((Map.Entry) r10).getKey());
                return true;
            }
        }

        public AsMap(Multimap<K, V> r10) {
            this.multimap = (Multimap) Preconditions.checkNotNull(r10);
        }

        public static /* synthetic */ Multimap access$200(AsMap r10) {
            return r10.multimap;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.multimap.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            return this.multimap.containsKey(r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new EntrySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return get(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.multimap.isEmpty();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.multimap.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object remove(Object r10) {
            return remove(r10);
        }

        public void removeValuesForKey(Object r10) {
            this.multimap.keySet().remove(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.multimap.keySet().size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object r10) {
            if (containsKey(r10) == true) goto L7;
            return null;
        L7:
            return this.multimap.get(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object r10) {
            if (containsKey(r10) == true) goto L7;
            return null;
        L7:
            return this.multimap.removeAll(r10);
        }
    }

    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> r10, Supplier<? extends List<V>> r11) {
            super(r10);
            this.factory = (Supplier) Preconditions.checkNotNull(r11);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            this.factory = (Supplier) r10.readObject();
            setMap((Map) r10.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream r10) throws IOException {
            r10.defaultWriteObject();
            r10.writeObject(this.factory);
            r10.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Collection<V>> factory;

        public CustomMultimap(Map<K, Collection<V>> r10, Supplier<? extends Collection<V>> r11) {
            super(r10);
            this.factory = (Supplier) Preconditions.checkNotNull(r11);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            this.factory = (Supplier) r10.readObject();
            setMap((Map) r10.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream r10) throws IOException {
            r10.defaultWriteObject();
            r10.writeObject(this.factory);
            r10.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r10) {
            if ((r10 instanceof NavigableSet) == false) goto L7;
            return Sets.unmodifiableNavigableSet((NavigableSet) r10);
        L7:
            if ((r10 instanceof SortedSet) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) r10);
        L11:
            if ((r10 instanceof Set) == false) goto L15;
            return Collections.unmodifiableSet((Set) r10);
        L15:
            if ((r10 instanceof List) == false) goto L19;
            return Collections.unmodifiableList((List) r10);
        L19:
            return Collections.unmodifiableCollection(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K r10, Collection<V> r11) {
            if ((r11 instanceof List) == false) goto L7;
            return wrapList(r10, (List) r11, null);
        L7:
            if ((r11 instanceof NavigableSet) == false) goto L11;
            return new AbstractMapBasedMultimap.WrappedNavigableSet(this, r10, (NavigableSet) r11, null);
        L11:
            if ((r11 instanceof SortedSet) == false) goto L15;
            return new AbstractMapBasedMultimap.WrappedSortedSet(this, r10, (SortedSet) r11, null);
        L15:
            if ((r11 instanceof Set) == false) goto L19;
            return new AbstractMapBasedMultimap.WrappedSet(this, r10, (Set) r11);
        L19:
            return new AbstractMapBasedMultimap.WrappedCollection(this, r10, r11, null);
        }
    }

    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        public CustomSetMultimap(Map<K, Collection<V>> r10, Supplier<? extends Set<V>> r11) {
            super(r10);
            this.factory = (Supplier) Preconditions.checkNotNull(r11);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            this.factory = (Supplier) r10.readObject();
            setMap((Map) r10.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream r10) throws IOException {
            r10.defaultWriteObject();
            r10.writeObject(this.factory);
            r10.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r10) {
            if ((r10 instanceof NavigableSet) == false) goto L7;
            return Sets.unmodifiableNavigableSet((NavigableSet) r10);
        L7:
            if ((r10 instanceof SortedSet) == false) goto L11;
            return Collections.unmodifiableSortedSet((SortedSet) r10);
        L11:
            return Collections.unmodifiableSet((Set) r10);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K r10, Collection<V> r11) {
            if ((r11 instanceof NavigableSet) == false) goto L7;
            return new AbstractMapBasedMultimap.WrappedNavigableSet(this, r10, (NavigableSet) r11, null);
        L7:
            if ((r11 instanceof SortedSet) == false) goto L11;
            return new AbstractMapBasedMultimap.WrappedSortedSet(this, r10, (SortedSet) r11, null);
        L11:
            return new AbstractMapBasedMultimap.WrappedSet(this, r10, (Set) r11);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;

        public CustomSortedSetMultimap(Map<K, Collection<V>> r10, Supplier<? extends SortedSet<V>> r11) {
            super(r10);
            this.factory = (Supplier) Preconditions.checkNotNull(r11);
            this.valueComparator = r11.get().comparator();
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            Supplier<? extends SortedSet<V>> r11 = (Supplier) r10.readObject();
            this.factory = r11;
            this.valueComparator = r11.get().comparator();
            setMap((Map) r10.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream r10) throws IOException {
            r10.defaultWriteObject();
            r10.writeObject(this.factory);
            r10.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Collection createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public /* bridge */ /* synthetic */ Set createCollection() {
            return createCollection();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }
    }

    public static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public Entries() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            multimap().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L6;
            Map.Entry r11 = (Map.Entry) r10;
            return multimap().containsEntry(r11.getKey(), r11.getValue());
        L6:
            return false;
        }

        public abstract Multimap<K, V> multimap();

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L6;
            Map.Entry r11 = (Map.Entry) r10;
            return multimap().remove(r11.getKey(), r11.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return multimap().size();
        }
    }

    public static class Keys<K, V> extends AbstractMultiset<K> {

        @Weak
        final Multimap<K, V> multimap;

        public Keys(Multimap<K, V> r10) {
            this.multimap = r10;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.multimap.clear();
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@NullableDecl Object r10) {
            return this.multimap.containsKey(r10);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object r10) {
            Collection r11 = (Collection) Maps.safeGet(this.multimap.asMap(), r10);
            if (r11 != null) goto L6;
            return 0;
        L6:
            return r11.size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return this.multimap.asMap().size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return this.multimap.keySet();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<K>> entryIterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r10 = this.multimap.asMap().entrySet().iterator();
            return new AnonymousClass1(this, r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.multimap.entries().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object r10, int r11) {
            CollectPreconditions.checkNonnegative(r11, "occurrences");
            if (r11 == 0) goto L5;
            Collection r12 = (Collection) Maps.safeGet(this.multimap.asMap(), r10);
            int r13 = 0;
            if (r12 != null) goto L9;
            return 0;
        L9:
            int r14 = r12.size();
            if (r11 < r14) goto L12;
            r12.clear();
        L15:
            return r14;
        L12:
            Iterator r15 = r12.iterator();
        L13:
            if (r13 >= r11) goto L15;
            r15.next();
            r15.remove();
            r13 = r13 + 1;
            goto L13
        L5:
            return count(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.multimap.size();
        }
    }

    public static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        public MapMultimap(Map<K, V> r10) {
            this.map = (Map) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsEntry(Object r10, Object r11) {
            return this.map.entrySet().contains(Maps.immutableEntry(r10, r11));
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object r10) {
            return this.map.containsKey(r10);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsValue(Object r10) {
            return this.map.containsValue(r10);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V>> createAsMap() {
            return new AsMap(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Multiset<K> createKeys() {
            return new Keys(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(K r10, V r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(Object r10, Object r11) {
            return this.map.entrySet().remove(Maps.immutableEntry(r10, r11));
        }

        @Override // com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.Multimap
        public Set<V> get(final K r10) {
            return new AnonymousClass1(this, r10);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public Set<V> removeAll(Object r10) {
            HashSet r11 = new HashSet(2);
            if (this.map.containsKey(r10) == true) goto L5;
            return r11;
        L5:
            r11.add(this.map.remove(r10));
            return r11;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
        public TransformedEntriesListMultimap(ListMultimap<K, V1> r10, Maps.EntryTransformer<? super K, ? super V1, V2> r11) {
            super(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        public /* bridge */ /* synthetic */ Collection transform(Object r10, Collection r11) {
            return transform(r10, r11);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public List<V2> get(K r10) {
            return transform(r10, this.fromMultimap.get(r10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public List<V2> removeAll(Object r10) {
            return transform(r10, this.fromMultimap.removeAll(r10));
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public List<V2> replaceValues(K r10, Iterable<? extends V2> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        public List<V2> transform(K r10, Collection<V1> r11) {
            return Lists.transform((List) r11, Maps.asValueToValueFunction(this.transformer, r10));
        }
    }

    public static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {
        final Multimap<K, V1> fromMultimap;
        final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

        public TransformedEntriesMultimap(Multimap<K, V1> r10, Maps.EntryTransformer<? super K, ? super V1, V2> r11) {
            this.fromMultimap = (Multimap) Preconditions.checkNotNull(r10);
            this.transformer = (Maps.EntryTransformer) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.fromMultimap.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object r10) {
            return this.fromMultimap.containsKey(r10);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Map<K, Collection<V2>> createAsMap() {
            return Maps.transformEntries(this.fromMultimap.asMap(), new AnonymousClass1(this));
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<Map.Entry<K, V2>> createEntries() {
            return new AbstractMultimap.Entries(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Set<K> createKeySet() {
            return this.fromMultimap.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Multiset<K> createKeys() {
            return this.fromMultimap.keys();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Collection<V2> createValues() {
            return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
        }

        @Override // com.google.common.collect.AbstractMultimap
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V2> get(K r10) {
            return transform(r10, this.fromMultimap.get(r10));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(K r10, V2 r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(K r10, Iterable<? extends V2> r11) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(Object r10, Object r11) {
            return get(r10).remove(r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public Collection<V2> removeAll(Object r10) {
            return transform(r10, this.fromMultimap.removeAll(r10));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public Collection<V2> replaceValues(K r10, Iterable<? extends V2> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.fromMultimap.size();
        }

        public Collection<V2> transform(K r10, Collection<V1> r11) {
            Function r12 = Maps.asValueToValueFunction(this.transformer, r10);
            if ((r11 instanceof List) == false) goto L7;
            return Lists.transform((List) r11, r12);
        L7:
            return Collections2.transform(r11, r12);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V2> r10) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableListMultimap(ListMultimap<K, V> r10) {
            super(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public List<V> get(K r10) {
            return Collections.unmodifiableList(delegate().get(r10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    public static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multimap<K, V> delegate;

        @MonotonicNonNullDecl
        transient Collection<Map.Entry<K, V>> entries;

        @MonotonicNonNullDecl
        transient Set<K> keySet;

        @MonotonicNonNullDecl
        transient Multiset<K> keys;

        @MonotonicNonNullDecl
        transient Map<K, Collection<V>> map;

        @MonotonicNonNullDecl
        transient Collection<V> values;

        public UnmodifiableMultimap(Multimap<K, V> r10) {
            this.delegate = (Multimap) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> r10 = this.map;
            if (r10 != null) goto L6;
            Map<K, Collection<V>> r11 = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), new AnonymousClass1(this)));
            this.map = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> r10 = this.entries;
            if (r10 != null) goto L6;
            Collection<Map.Entry<K, V>> r11 = Multimaps.access$100(this.delegate.entries());
            this.entries = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> get(K r10) {
            return Multimaps.access$000(this.delegate.get(r10));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> r10 = this.keySet;
            if (r10 != null) goto L6;
            Set<K> r11 = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> r10 = this.keys;
            if (r10 != null) goto L6;
            Multiset<K> r11 = Multisets.unmodifiableMultiset(this.delegate.keys());
            this.keys = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(K r10, V r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(Object r10, Object r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> removeAll(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> replaceValues(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> r10 = this.values;
            if (r10 != null) goto L6;
            Collection<V> r11 = Collections.unmodifiableCollection(this.delegate.values());
            this.values = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r10) {
            throw new UnsupportedOperationException();
        }
    }

    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSetMultimap(SetMultimap<K, V> r10) {
            super(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<V> get(K r10) {
            return Collections.unmodifiableSet(delegate().get(r10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<V> removeAll(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> r10) {
            super(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ SetMultimap delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public SortedSet<V> get(K r10) {
            return Collections.unmodifiableSortedSet(delegate().get(r10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public SortedSet<V> removeAll(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public SortedSet<V> replaceValues(K r10, Iterable<? extends V> r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }

    private Multimaps() {
    }

    public static /* synthetic */ Collection access$000(Collection r10) {
        return unmodifiableValueCollection(r10);
    }

    public static /* synthetic */ Collection access$100(Collection r10) {
        return unmodifiableEntries(r10);
    }

    @Beta
    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> r10) {
        return r10.asMap();
    }

    public static boolean equalsImpl(Multimap<?, ?> r10, @NullableDecl Object r11) {
        if (r11 != r10) goto L6;
        return true;
    L6:
        if ((r11 instanceof Multimap) == true) goto L8;
        return false;
    L8:
        return r10.asMap().equals(((Multimap) r11).asMap());
    }

    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof SetMultimap) == false) goto L7;
        return filterEntries((SetMultimap) r10, r11);
    L7:
        if ((r10 instanceof FilteredMultimap) == false) goto L10;
        return filterFiltered((FilteredMultimap) r10, r11);
    L10:
        return new FilteredEntryMultimap((Multimap) Preconditions.checkNotNull(r10), r11);
    }

    private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Predicate r12 = Predicates.and(r10.entryPredicate(), r11);
        return new FilteredEntryMultimap(r10.unfiltered(), r12);
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> r10, Predicate<? super K> r11) {
        if ((r10 instanceof SetMultimap) == false) goto L7;
        return filterKeys((SetMultimap) r10, r11);
    L7:
        if ((r10 instanceof ListMultimap) == false) goto L11;
        return filterKeys((ListMultimap) r10, r11);
    L11:
        if ((r10 instanceof FilteredKeyMultimap) == false) goto L15;
        FilteredKeyMultimap r12 = (FilteredKeyMultimap) r10;
        return new FilteredKeyMultimap(r12.unfiltered, Predicates.and(r12.keyPredicate, r11));
    L15:
        if ((r10 instanceof FilteredMultimap) == false) goto L19;
        return filterFiltered((FilteredMultimap) r10, Maps.keyPredicateOnEntries(r11));
    L19:
        return new FilteredKeyMultimap(r10, r11);
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> r10, Predicate<? super V> r11) {
        return filterEntries(r10, Maps.valuePredicateOnEntries(r11));
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> r10) {
        return new MapMultimap(r10);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> r10, Function<? super V, K> r11) {
        return index(r10.iterator(), r11);
    }

    @CanIgnoreReturnValue
    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> r10, M r11) {
        Preconditions.checkNotNull(r11);
        Iterator<Map.Entry<? extends V, ? extends K>> r12 = r10.entries().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<? extends V, ? extends K> r13 = r12.next();
        r11.put(r13.getValue(), r13.getKey());
        goto L4
    L6:
        return r11;
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> r10, Supplier<? extends List<V>> r11) {
        return new CustomListMultimap(r10, r11);
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> r10, Supplier<? extends Collection<V>> r11) {
        return new CustomMultimap(r10, r11);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> r10, Supplier<? extends Set<V>> r11) {
        return new CustomSetMultimap(r10, r11);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> r10, Supplier<? extends SortedSet<V>> r11) {
        return new CustomSortedSetMultimap(r10, r11);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> r10) {
        return Synchronized.listMultimap(r10, null);
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> r10) {
        return Synchronized.multimap(r10, null);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> r10) {
        return Synchronized.setMultimap(r10, null);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> r10) {
        return Synchronized.sortedSetMultimap(r10, null);
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> r10, Maps.EntryTransformer<? super K, ? super V1, V2> r11) {
        return new TransformedEntriesMultimap(r10, r11);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> r10, Function<? super V1, V2> r11) {
        Preconditions.checkNotNull(r11);
        return transformEntries(r10, Maps.asEntryTransformer(r11));
    }

    private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> r10) {
        if ((r10 instanceof Set) == false) goto L7;
        return Maps.unmodifiableEntrySet((Set) r10);
    L7:
        return new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(r10));
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> r10) {
        if ((r10 instanceof UnmodifiableListMultimap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableListMultimap) == true) goto L9;
        return new UnmodifiableListMultimap(r10);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> r10) {
        if ((r10 instanceof UnmodifiableMultimap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableMultimap) == true) goto L9;
        return new UnmodifiableMultimap(r10);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> r10) {
        if ((r10 instanceof UnmodifiableSetMultimap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableSetMultimap) == true) goto L9;
        return new UnmodifiableSetMultimap(r10);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> r10) {
        if ((r10 instanceof UnmodifiableSortedSetMultimap) == false) goto L6;
        return r10;
    L6:
        return new UnmodifiableSortedSetMultimap(r10);
    }

    private static <V> Collection<V> unmodifiableValueCollection(Collection<V> r10) {
        if ((r10 instanceof SortedSet) == false) goto L7;
        return Collections.unmodifiableSortedSet((SortedSet) r10);
    L7:
        if ((r10 instanceof Set) == false) goto L11;
        return Collections.unmodifiableSet((Set) r10);
    L11:
        if ((r10 instanceof List) == false) goto L15;
        return Collections.unmodifiableList((List) r10);
    L15:
        return Collections.unmodifiableCollection(r10);
    }

    @Beta
    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> r10) {
        return r10.asMap();
    }

    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> r10, Predicate<? super V> r11) {
        return filterEntries(r10, Maps.valuePredicateOnEntries(r11));
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> r10, Function<? super V, K> r11) {
        Preconditions.checkNotNull(r11);
        ImmutableListMultimap.Builder r12 = ImmutableListMultimap.builder();
    L4:
        if (r10.hasNext() == false) goto L7;
        V r13 = r10.next();
        Preconditions.checkNotNull(r13, r10);
        r12.put(r11.apply(r13), r13);
        goto L4
    L7:
        return r12.build();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> r10, Maps.EntryTransformer<? super K, ? super V1, V2> r11) {
        return new TransformedEntriesListMultimap(r10, r11);
    }

    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> r10) {
        return r10.asMap();
    }

    private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Predicate r12 = Predicates.and(r10.entryPredicate(), r11);
        return new FilteredEntrySetMultimap(r10.unfiltered(), r12);
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> r10) {
        return (ListMultimap) Preconditions.checkNotNull(r10);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> r10) {
        return (Multimap) Preconditions.checkNotNull(r10);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> r10) {
        return (SetMultimap) Preconditions.checkNotNull(r10);
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> r10) {
        return r10.asMap();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> r10, Function<? super V1, V2> r11) {
        Preconditions.checkNotNull(r11);
        return transformEntries(r10, Maps.asEntryTransformer(r11));
    }

    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> r10, Predicate<? super Map.Entry<K, V>> r11) {
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof FilteredSetMultimap) == false) goto L6;
        return filterFiltered((FilteredSetMultimap) r10, r11);
    L6:
        return new FilteredEntrySetMultimap((SetMultimap) Preconditions.checkNotNull(r10), r11);
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> r10, Predicate<? super K> r11) {
        if ((r10 instanceof FilteredKeySetMultimap) == false) goto L7;
        FilteredKeySetMultimap r12 = (FilteredKeySetMultimap) r10;
        return new FilteredKeySetMultimap(r12.unfiltered(), Predicates.and(r12.keyPredicate, r11));
    L7:
        if ((r10 instanceof FilteredSetMultimap) == false) goto L11;
        return filterFiltered((FilteredSetMultimap) r10, Maps.keyPredicateOnEntries(r11));
    L11:
        return new FilteredKeySetMultimap(r10, r11);
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> r10, Predicate<? super K> r11) {
        if ((r10 instanceof FilteredKeyListMultimap) == false) goto L7;
        FilteredKeyListMultimap r12 = (FilteredKeyListMultimap) r10;
        return new FilteredKeyListMultimap(r12.unfiltered(), Predicates.and(r12.keyPredicate, r11));
    L7:
        return new FilteredKeyListMultimap(r10, r11);
    }
}
