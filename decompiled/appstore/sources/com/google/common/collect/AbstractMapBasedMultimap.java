package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> submap;
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            final /* synthetic */ AsMap this$1;

            public AsMapEntries(AsMap r10) {
                this.this$1 = r10;
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r10) {
                return Collections2.safeContains(this.this$1.submap.entrySet(), r10);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator(this.this$1);
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public Map<K, Collection<V>> map() {
                return this.this$1;
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                if (contains(r10) == true) goto L6;
                return false;
            L6:
                AbstractMapBasedMultimap.access$300(this.this$1.this$0, ((Map.Entry) r10).getKey());
                return true;
            }
        }

        public class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {

            @NullableDecl
            Collection<V> collection;
            final Iterator<Map.Entry<K, Collection<V>>> delegateIterator;
            final /* synthetic */ AsMap this$1;

            public AsMapIterator(AsMap r10) {
                this.this$1 = r10;
                this.delegateIterator = r10.submap.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegateIterator.hasNext();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.collection == null) goto L5;
                boolean r10 = true;
            L6:
                CollectPreconditions.checkRemove(r10);
                this.delegateIterator.remove();
                AbstractMapBasedMultimap r11 = this.this$1.this$0;
                AbstractMapBasedMultimap.access$202(r11, AbstractMapBasedMultimap.access$200(r11) - this.collection.size());
                this.collection.clear();
                this.collection = null;
                return;
            L5:
                r10 = false;
                goto L6
            }

            @Override // java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> r10 = this.delegateIterator.next();
                this.collection = r10.getValue();
                return this.this$1.wrapEntry(r10);
            }
        }

        public AsMap(AbstractMapBasedMultimap r10, Map<K, Collection<V>> r11) {
            this.this$0 = r10;
            this.submap = r11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.submap != AbstractMapBasedMultimap.access$000(this.this$0)) goto L5;
            this.this$0.clear();
            return;
        L5:
            Iterators.clear(new AsMapIterator(this));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            return Maps.safeContainsKey(this.submap, r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new AsMapEntries(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object r10) {
            if (this != r10) goto L4;
        L7:
            return true;
        L4:
            if (this.submap.equals(r10) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return get(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.submap.hashCode();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.this$0.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object remove(Object r10) {
            return remove(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.submap.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.submap.toString();
        }

        public Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> r10) {
            K r11 = r10.getKey();
            return Maps.immutableEntry(r11, this.this$0.wrapCollection(r11, r10.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object r10) {
            Collection<V> r11 = (Collection) Maps.safeGet(this.submap, r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return this.this$0.wrapCollection(r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object r10) {
            Collection<V> r11 = this.submap.remove(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            Collection<V> r12 = this.this$0.createCollection();
            r12.addAll(r11);
            AbstractMapBasedMultimap r13 = this.this$0;
            AbstractMapBasedMultimap.access$202(r13, AbstractMapBasedMultimap.access$200(r13) - r11.size());
            r11.clear();
            return r12;
        }
    }

    public abstract class Itr<T> implements Iterator<T> {

        @MonotonicNonNullDecl
        Collection<V> collection;

        @NullableDecl
        K key;
        final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
        final /* synthetic */ AbstractMapBasedMultimap this$0;
        Iterator<V> valueIterator;

        public Itr(AbstractMapBasedMultimap r10) {
            this.this$0 = r10;
            this.keyIterator = AbstractMapBasedMultimap.access$000(r10).entrySet().iterator();
            this.key = null;
            this.collection = null;
            this.valueIterator = Iterators.emptyModifiableIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.keyIterator.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.valueIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.valueIterator.hasNext() == true) goto L6;
            Map.Entry<K, Collection<V>> r10 = this.keyIterator.next();
            this.key = r10.getKey();
            Collection<V> r11 = r10.getValue();
            this.collection = r11;
            this.valueIterator = r11.iterator();
        L6:
            return output(this.key, this.valueIterator.next());
        }

        public abstract T output(K r10, V r11);

        @Override // java.util.Iterator
        public void remove() {
            this.valueIterator.remove();
            if (this.collection.isEmpty() == false) goto L5;
            this.keyIterator.remove();
        L5:
            AbstractMapBasedMultimap.access$210(this.this$0);
        }
    }

    public class KeySet extends Maps.KeySet<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public KeySet(AbstractMapBasedMultimap r10, Map<K, Collection<V>> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.clear(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r10) {
            return map().keySet().containsAll(r10);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object r10) {
            if (this != r10) goto L4;
        L7:
            return true;
        L4:
            if (map().keySet().equals(r10) == true) goto L7;
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return map().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r10 = map().entrySet().iterator();
            return new AnonymousClass1(this, r10);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            Collection<V> r11 = map().remove(r10);
            if (r11 == null) goto L5;
            int r12 = r11.size();
            r11.clear();
            AbstractMapBasedMultimap r13 = this.this$0;
            AbstractMapBasedMultimap.access$202(r13, AbstractMapBasedMultimap.access$200(r13) - r12);
        L6:
            if (r12 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r12 = 0;
            goto L6
        }
    }

    public class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public NavigableAsMap(AbstractMapBasedMultimap r10, NavigableMap<K, Collection<V>> r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K r10) {
            Map.Entry<K, Collection<V>> r11 = sortedMap().ceilingEntry(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r11);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r10) {
            return sortedMap().ceilingKey(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(this.this$0, sortedMap().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> r10 = sortedMap().firstEntry();
            if (r10 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K r10) {
            Map.Entry<K, Collection<V>> r11 = sortedMap().floorEntry(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r11);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r10) {
            return sortedMap().floorKey(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object r10) {
            return headMap(r10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K r10) {
            Map.Entry<K, Collection<V>> r11 = sortedMap().higherEntry(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r11);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r10) {
            return sortedMap().higherKey(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> r10 = sortedMap().lastEntry();
            if (r10 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K r10) {
            Map.Entry<K, Collection<V>> r11 = sortedMap().lowerEntry(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return wrapEntry(r11);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r10) {
            return sortedMap().lowerKey(r10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        public Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> r10) {
            if (r10.hasNext() == true) goto L6;
            return null;
        L6:
            Map.Entry<K, Collection<V>> r11 = r10.next();
            Collection<V> r12 = this.this$0.createCollection();
            r12.addAll(r11.getValue());
            r10.remove();
            return Maps.immutableEntry(r11.getKey(), this.this$0.unmodifiableCollectionSubclass(r12));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return pollAsMapEntry(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return pollAsMapEntry(descendingMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        public /* bridge */ /* synthetic */ SortedMap sortedMap() {
            return sortedMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap subMap(Object r10, Object r11) {
            return subMap(r10, r11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object r10) {
            return tailMap(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public /* bridge */ /* synthetic */ SortedSet createKeySet() {
            return createKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K r10) {
            return headMap(r10, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ SortedSet keySet() {
            return keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        public NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap) super.sortedMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K r10, K r11) {
            return subMap(r10, true, r11, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K r10) {
            return tailMap(r10, true);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public NavigableSet<K> createKeySet() {
            return new NavigableKeySet(this.this$0, sortedMap());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K r10, boolean r11) {
            return new NavigableAsMap(this.this$0, sortedMap().headMap(r10, r11));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K r10, boolean r11, K r12, boolean r13) {
            return new NavigableAsMap(this.this$0, sortedMap().subMap(r10, r11, r12, r13));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K r10, boolean r11) {
            return new NavigableAsMap(this.this$0, sortedMap().tailMap(r10, r11));
        }
    }

    public class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public NavigableKeySet(AbstractMapBasedMultimap r10, NavigableMap<K, Collection<V>> r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K r10) {
            return sortedMap().ceilingKey(r10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(this.this$0, sortedMap().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K r10) {
            return sortedMap().floorKey(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet headSet(Object r10) {
            return headSet(r10);
        }

        @Override // java.util.NavigableSet
        public K higher(K r10) {
            return sortedMap().higherKey(r10);
        }

        @Override // java.util.NavigableSet
        public K lower(K r10) {
            return sortedMap().lowerKey(r10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.pollNext(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.pollNext(descendingIterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        public /* bridge */ /* synthetic */ SortedMap sortedMap() {
            return sortedMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet subSet(Object r10, Object r11) {
            return subSet(r10, r11);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(Object r10) {
            return tailSet(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> headSet(K r10) {
            return headSet(r10, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        public NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap) super.sortedMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> subSet(K r10, K r11) {
            return subSet(r10, true, r11, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<K> tailSet(K r10) {
            return tailSet(r10, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K r10, boolean r11) {
            return new NavigableKeySet(this.this$0, sortedMap().headMap(r10, r11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K r10, boolean r11, K r12, boolean r13) {
            return new NavigableKeySet(this.this$0, sortedMap().subMap(r10, r11, r12, r13));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K r10, boolean r11) {
            return new NavigableKeySet(this.this$0, sortedMap().tailMap(r10, r11));
        }
    }

    public class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public RandomAccessWrappedList(@NullableDecl AbstractMapBasedMultimap r10, K r11, @NullableDecl List<V> r12, AbstractMapBasedMultimap<K, V>.WrappedCollection r13) {
            this.this$0 = r10;
            super(r10, r11, r12, r13);
        }
    }

    public class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {

        @MonotonicNonNullDecl
        SortedSet<K> sortedKeySet;
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public SortedAsMap(AbstractMapBasedMultimap r10, SortedMap<K, Collection<V>> r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return sortedMap().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(K r10) {
            return new SortedAsMap(this.this$0, sortedMap().headMap(r10));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return sortedMap().lastKey();
        }

        public SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) this.submap;
        }

        public SortedMap<K, Collection<V>> subMap(K r10, K r11) {
            return new SortedAsMap(this.this$0, sortedMap().subMap(r10, r11));
        }

        public SortedMap<K, Collection<V>> tailMap(K r10) {
            return new SortedAsMap(this.this$0, sortedMap().tailMap(r10));
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet<K> createKeySet() {
            return new SortedKeySet(this.this$0, sortedMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            SortedSet<K> r10 = this.sortedKeySet;
            if (r10 != null) goto L6;
            SortedSet<K> r11 = createKeySet();
            this.sortedKeySet = r11;
            return r11;
        L6:
            return r10;
        }
    }

    public class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public SortedKeySet(AbstractMapBasedMultimap r10, SortedMap<K, Collection<V>> r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return sortedMap().firstKey();
        }

        public SortedSet<K> headSet(K r10) {
            return new SortedKeySet(this.this$0, sortedMap().headMap(r10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return sortedMap().lastKey();
        }

        public SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) super.map();
        }

        public SortedSet<K> subSet(K r10, K r11) {
            return new SortedKeySet(this.this$0, sortedMap().subMap(r10, r11));
        }

        public SortedSet<K> tailSet(K r10) {
            return new SortedKeySet(this.this$0, sortedMap().tailMap(r10));
        }
    }

    public class WrappedCollection extends AbstractCollection<V> {

        @NullableDecl
        final AbstractMapBasedMultimap<K, V>.WrappedCollection ancestor;

        @NullableDecl
        final Collection<V> ancestorDelegate;
        Collection<V> delegate;

        @NullableDecl
        final K key;
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public class WrappedIterator implements Iterator<V> {
            final Iterator<V> delegateIterator;
            final Collection<V> originalDelegate;
            final /* synthetic */ WrappedCollection this$1;

            public WrappedIterator(WrappedCollection r10) {
                this.this$1 = r10;
                Collection<V> r11 = r10.delegate;
                this.originalDelegate = r11;
                this.delegateIterator = AbstractMapBasedMultimap.access$100(r11);
            }

            public Iterator<V> getDelegateIterator() {
                validateIterator();
                return this.delegateIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                validateIterator();
                return this.delegateIterator.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                validateIterator();
                return this.delegateIterator.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$210(this.this$1.this$0);
                this.this$1.removeIfEmpty();
            }

            public void validateIterator() {
                this.this$1.refreshIfEmpty();
                if (this.this$1.delegate != this.originalDelegate) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            public WrappedIterator(WrappedCollection r10, Iterator<V> r11) {
                this.this$1 = r10;
                this.originalDelegate = r10.delegate;
                this.delegateIterator = r11;
            }
        }

        public WrappedCollection(@NullableDecl AbstractMapBasedMultimap r10, K r11, @NullableDecl Collection<V> r12, AbstractMapBasedMultimap<K, V>.WrappedCollection r13) {
            this.this$0 = r10;
            this.key = r11;
            this.delegate = r12;
            this.ancestor = r13;
            if (r13 != null) goto L5;
            Collection<V> r14 = null;
        L6:
            this.ancestorDelegate = r14;
            return;
        L5:
            r14 = r13.getDelegate();
            goto L6
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V r10) {
            refreshIfEmpty();
            boolean r11 = this.delegate.isEmpty();
            boolean r12 = this.delegate.add(r10);
            if (r12 == false) goto L7;
            AbstractMapBasedMultimap.access$208(this.this$0);
            if (r11 == false) goto L7;
            addToMap();
        L7:
            return r12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> r10) {
            if (r10.isEmpty() == false) goto L6;
            return false;
        L6:
            int r11 = size();
            boolean r12 = this.delegate.addAll(r10);
            if (r12 == false) goto L11;
            int r13 = this.delegate.size();
            AbstractMapBasedMultimap r14 = this.this$0;
            AbstractMapBasedMultimap.access$202(r14, AbstractMapBasedMultimap.access$200(r14) + (r13 - r11));
            if (r11 != 0) goto L11;
            addToMap();
        L11:
            return r12;
        }

        public void addToMap() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection r10 = this.ancestor;
            if (r10 == null) goto L5;
            r10.addToMap();
            return;
        L5:
            AbstractMapBasedMultimap.access$000(this.this$0).put(this.key, this.delegate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int r10 = size();
            if (r10 != 0) goto L5;
            return;
        L5:
            this.delegate.clear();
            AbstractMapBasedMultimap r11 = this.this$0;
            AbstractMapBasedMultimap.access$202(r11, AbstractMapBasedMultimap.access$200(r11) - r10);
            removeIfEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r10) {
            refreshIfEmpty();
            return this.delegate.contains(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r10) {
            refreshIfEmpty();
            return this.delegate.containsAll(r10);
        }

        @Override // java.util.Collection
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            refreshIfEmpty();
            return this.delegate.equals(r10);
        }

        public AbstractMapBasedMultimap<K, V>.WrappedCollection getAncestor() {
            return this.ancestor;
        }

        public Collection<V> getDelegate() {
            return this.delegate;
        }

        public K getKey() {
            return this.key;
        }

        @Override // java.util.Collection
        public int hashCode() {
            refreshIfEmpty();
            return this.delegate.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            refreshIfEmpty();
            return new WrappedIterator(this);
        }

        public void refreshIfEmpty() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection r10 = this.ancestor;
            if (r10 == null) goto L10;
            r10.refreshIfEmpty();
            if (this.ancestor.getDelegate() != this.ancestorDelegate) goto L8;
            return;
        L8:
            throw new ConcurrentModificationException();
        L10:
            if (this.delegate.isEmpty() == false) goto L15;
            Collection<V> r11 = (Collection) AbstractMapBasedMultimap.access$000(this.this$0).get(this.key);
            if (r11 == null) goto L16;
            this.delegate = r11;
            return;
        L16:
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r10) {
            refreshIfEmpty();
            boolean r11 = this.delegate.remove(r10);
            if (r11 == false) goto L5;
            AbstractMapBasedMultimap.access$210(this.this$0);
            removeIfEmpty();
        L5:
            return r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            if (r10.isEmpty() == false) goto L6;
            return false;
        L6:
            int r11 = size();
            boolean r12 = this.delegate.removeAll(r10);
            if (r12 == false) goto L9;
            int r13 = this.delegate.size();
            AbstractMapBasedMultimap r14 = this.this$0;
            AbstractMapBasedMultimap.access$202(r14, AbstractMapBasedMultimap.access$200(r14) + (r13 - r11));
            removeIfEmpty();
        L9:
            return r12;
        }

        public void removeIfEmpty() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection r10 = this.ancestor;
            if (r10 == null) goto L6;
            r10.removeIfEmpty();
            return;
        L6:
            if (this.delegate.isEmpty() == false) goto L10;
            AbstractMapBasedMultimap.access$000(this.this$0).remove(this.key);
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            Preconditions.checkNotNull(r10);
            int r11 = size();
            boolean r12 = this.delegate.retainAll(r10);
            if (r12 == false) goto L5;
            int r13 = this.delegate.size();
            AbstractMapBasedMultimap r14 = this.this$0;
            AbstractMapBasedMultimap.access$202(r14, AbstractMapBasedMultimap.access$200(r14) + (r13 - r11));
            removeIfEmpty();
        L5:
            return r12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            refreshIfEmpty();
            return this.delegate.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            refreshIfEmpty();
            return this.delegate.toString();
        }
    }

    public class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
            final /* synthetic */ WrappedList this$1;

            public WrappedListIterator(WrappedList r10) {
                this.this$1 = r10;
                super(r10);
            }

            private ListIterator<V> getDelegateListIterator() {
                return (ListIterator) getDelegateIterator();
            }

            @Override // java.util.ListIterator
            public void add(V r10) {
                boolean r11 = this.this$1.isEmpty();
                getDelegateListIterator().add(r10);
                AbstractMapBasedMultimap.access$208(this.this$1.this$0);
                if (r11 == false) goto L6;
                this.this$1.addToMap();
                return;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return getDelegateListIterator().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return getDelegateListIterator().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return getDelegateListIterator().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return getDelegateListIterator().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V r10) {
                getDelegateListIterator().set(r10);
            }

            public WrappedListIterator(WrappedList r10, int r11) {
                this.this$1 = r10;
                super(r10, r10.getListDelegate().listIterator(r11));
            }
        }

        public WrappedList(@NullableDecl AbstractMapBasedMultimap r10, K r11, @NullableDecl List<V> r12, AbstractMapBasedMultimap<K, V>.WrappedCollection r13) {
            this.this$0 = r10;
            super(r10, r11, r12, r13);
        }

        @Override // java.util.List
        public void add(int r10, V r11) {
            refreshIfEmpty();
            boolean r12 = getDelegate().isEmpty();
            getListDelegate().add(r10, r11);
            AbstractMapBasedMultimap.access$208(this.this$0);
            if (r12 == false) goto L6;
            addToMap();
            return;
        }

        @Override // java.util.List
        public boolean addAll(int r10, Collection<? extends V> r11) {
            if (r11.isEmpty() == false) goto L6;
            return false;
        L6:
            int r12 = size();
            boolean r13 = getListDelegate().addAll(r10, r11);
            if (r13 == false) goto L11;
            int r14 = getDelegate().size();
            AbstractMapBasedMultimap r15 = this.this$0;
            AbstractMapBasedMultimap.access$202(r15, AbstractMapBasedMultimap.access$200(r15) + (r14 - r12));
            if (r12 != 0) goto L11;
            addToMap();
        L11:
            return r13;
        }

        @Override // java.util.List
        public V get(int r10) {
            refreshIfEmpty();
            return getListDelegate().get(r10);
        }

        public List<V> getListDelegate() {
            return (List) getDelegate();
        }

        @Override // java.util.List
        public int indexOf(Object r10) {
            refreshIfEmpty();
            return getListDelegate().indexOf(r10);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r10) {
            refreshIfEmpty();
            return getListDelegate().lastIndexOf(r10);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            refreshIfEmpty();
            return new WrappedListIterator(this);
        }

        @Override // java.util.List
        public V remove(int r10) {
            refreshIfEmpty();
            V r11 = getListDelegate().remove(r10);
            AbstractMapBasedMultimap.access$210(this.this$0);
            removeIfEmpty();
            return r11;
        }

        @Override // java.util.List
        public V set(int r10, V r11) {
            refreshIfEmpty();
            return getListDelegate().set(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.AbstractMapBasedMultimap] */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.List
        public List<V> subList(int r10, int r11) {
            refreshIfEmpty();
            ?? r12 = this.this$0;
            Object r13 = getKey();
            List<V> r14 = getListDelegate().subList(r10, r11);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r15 = getAncestor();
            ?? r16 = this;
            if (r15 == null) goto L7;
            r16 = getAncestor();
        L7:
            return r12.wrapList(r13, r14, r16);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int r10) {
            refreshIfEmpty();
            return new WrappedListIterator(this, r10);
        }
    }

    public class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public WrappedNavigableSet(@NullableDecl AbstractMapBasedMultimap r10, K r11, @NullableDecl NavigableSet<V> r12, AbstractMapBasedMultimap<K, V>.WrappedCollection r13) {
            this.this$0 = r10;
            super(r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        private NavigableSet<V> wrap(NavigableSet<V> r10) {
            AbstractMapBasedMultimap r11 = this.this$0;
            K r12 = this.key;
            AbstractMapBasedMultimap<K, V>.WrappedCollection r13 = getAncestor();
            ?? r14 = this;
            if (r13 == null) goto L7;
            r14 = getAncestor();
        L7:
            return new WrappedNavigableSet(r11, r12, r10, r14);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V r10) {
            return getSortedSetDelegate().ceiling(r10);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new WrappedCollection.WrappedIterator(this, getSortedSetDelegate().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return wrap(getSortedSetDelegate().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V r10) {
            return getSortedSetDelegate().floor(r10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        public /* bridge */ /* synthetic */ SortedSet getSortedSetDelegate() {
            return getSortedSetDelegate();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V r10, boolean r11) {
            return wrap(getSortedSetDelegate().headSet(r10, r11));
        }

        @Override // java.util.NavigableSet
        public V higher(V r10) {
            return getSortedSetDelegate().higher(r10);
        }

        @Override // java.util.NavigableSet
        public V lower(V r10) {
            return getSortedSetDelegate().lower(r10);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.pollNext(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.pollNext(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V r10, boolean r11, V r12, boolean r13) {
            return wrap(getSortedSetDelegate().subSet(r10, r11, r12, r13));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V r10, boolean r11) {
            return wrap(getSortedSetDelegate().tailSet(r10, r11));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        public NavigableSet<V> getSortedSetDelegate() {
            return (NavigableSet) super.getSortedSetDelegate();
        }
    }

    public class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public WrappedSet(@NullableDecl AbstractMapBasedMultimap r10, K r11, Set<V> r12) {
            this.this$0 = r10;
            super(r10, r11, r12, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            if (r10.isEmpty() == false) goto L6;
            return false;
        L6:
            int r11 = size();
            boolean r12 = Sets.removeAllImpl((Set) this.delegate, r10);
            if (r12 == false) goto L9;
            int r13 = this.delegate.size();
            AbstractMapBasedMultimap r14 = this.this$0;
            AbstractMapBasedMultimap.access$202(r14, AbstractMapBasedMultimap.access$200(r14) + (r13 - r11));
            removeIfEmpty();
        L9:
            return r12;
        }
    }

    public class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap this$0;

        public WrappedSortedSet(@NullableDecl AbstractMapBasedMultimap r10, K r11, @NullableDecl SortedSet<V> r12, AbstractMapBasedMultimap<K, V>.WrappedCollection r13) {
            this.this$0 = r10;
            super(r10, r11, r12, r13);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return getSortedSetDelegate().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            refreshIfEmpty();
            return getSortedSetDelegate().first();
        }

        public SortedSet<V> getSortedSetDelegate() {
            return (SortedSet) getDelegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V r10) {
            refreshIfEmpty();
            AbstractMapBasedMultimap r11 = this.this$0;
            Object r12 = getKey();
            SortedSet<V> r13 = getSortedSetDelegate().headSet(r10);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r14 = getAncestor();
            ?? r15 = this;
            if (r14 == null) goto L7;
            r15 = getAncestor();
        L7:
            return new WrappedSortedSet(r11, r12, r13, r15);
        }

        @Override // java.util.SortedSet
        public V last() {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V r10, V r11) {
            refreshIfEmpty();
            AbstractMapBasedMultimap r12 = this.this$0;
            Object r13 = getKey();
            SortedSet<V> r14 = getSortedSetDelegate().subSet(r10, r11);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r15 = getAncestor();
            ?? r16 = this;
            if (r15 == null) goto L7;
            r16 = getAncestor();
        L7:
            return new WrappedSortedSet(r12, r13, r14, r16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V r10) {
            refreshIfEmpty();
            AbstractMapBasedMultimap r11 = this.this$0;
            Object r12 = getKey();
            SortedSet<V> r13 = getSortedSetDelegate().tailSet(r10);
            AbstractMapBasedMultimap<K, V>.WrappedCollection r14 = getAncestor();
            ?? r15 = this;
            if (r14 == null) goto L7;
            r15 = getAncestor();
        L7:
            return new WrappedSortedSet(r11, r12, r13, r15);
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> r10) {
        Preconditions.checkArgument(r10.isEmpty());
        this.map = r10;
    }

    public static /* synthetic */ Map access$000(AbstractMapBasedMultimap r10) {
        return r10.map;
    }

    public static /* synthetic */ Iterator access$100(Collection r10) {
        return iteratorOrListIterator(r10);
    }

    public static /* synthetic */ int access$200(AbstractMapBasedMultimap r10) {
        return r10.totalSize;
    }

    public static /* synthetic */ int access$202(AbstractMapBasedMultimap r10, int r11) {
        r10.totalSize = r11;
        return r11;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap r10) {
        int r11 = r10.totalSize;
        r10.totalSize = r11 + 1;
        return r11;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap r10) {
        int r11 = r10.totalSize;
        r10.totalSize = r11 - 1;
        return r11;
    }

    public static /* synthetic */ void access$300(AbstractMapBasedMultimap r10, Object r11) {
        r10.removeValuesForKey(r11);
    }

    private Collection<V> getOrCreateCollection(@NullableDecl K r10) {
        Collection<V> r11 = this.map.get(r10);
        if (r11 != null) goto L6;
        Collection<V> r12 = createCollection(r10);
        this.map.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    private static <E> Iterator<E> iteratorOrListIterator(Collection<E> r10) {
        if ((r10 instanceof List) == false) goto L6;
        return ((List) r10).listIterator();
    L6:
        return r10.iterator();
    }

    private void removeValuesForKey(Object r10) {
        Collection r11 = (Collection) Maps.safeRemove(this.map, r10);
        if (r11 == null) goto L6;
        int r12 = r11.size();
        r11.clear();
        this.totalSize -= r12;
        return;
    }

    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<Collection<V>> r10 = this.map.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().clear();
        goto L4
    L6:
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object r10) {
        return this.map.containsKey(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new AsMap(this, this.map);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(@NullableDecl K r10) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        if ((this instanceof SetMultimap) == false) goto L7;
        return new AbstractMultimap.EntrySet(this);
    L7:
        return new AbstractMultimap.Entries(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return new KeySet(this, this.map);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> r10 = this.map;
        if ((r10 instanceof NavigableMap) == false) goto L7;
        return new NavigableAsMap(this, (NavigableMap) this.map);
    L7:
        if ((r10 instanceof SortedMap) == false) goto L11;
        return new SortedAsMap(this, (SortedMap) this.map);
    L11:
        return new AsMap(this, this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> r10 = this.map;
        if ((r10 instanceof NavigableMap) == false) goto L7;
        return new NavigableKeySet(this, (NavigableMap) this.map);
    L7:
        if ((r10 instanceof SortedMap) == false) goto L11;
        return new SortedKeySet(this, (SortedMap) this.map);
    L11:
        return new KeySet(this, this.map);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<V> createValues() {
        return new AbstractMultimap.Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(@NullableDecl K r10) {
        Collection<V> r11 = this.map.get(r10);
        if (r11 != null) goto L6;
        r11 = createCollection(r10);
    L6:
        return wrapCollection(r10, r11);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(@NullableDecl K r10, @NullableDecl V r11) {
        Collection<V> r12 = this.map.get(r10);
        if (r12 != null) goto L11;
        Collection<V> r13 = createCollection(r10);
        if (r13.add(r11) == false) goto L9;
        this.totalSize++;
        this.map.put(r10, r13);
        return true;
    L9:
        throw new AssertionError("New Collection violated the Collection spec");
    L11:
        if (r12.add(r11) == false) goto L14;
        this.totalSize++;
        return true;
    L14:
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@NullableDecl Object r10) {
        Collection<V> r11 = this.map.remove(r10);
        if (r11 == null) goto L5;
        Collection r12 = createCollection();
        r12.addAll(r11);
        this.totalSize -= r11.size();
        r11.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(r12);
    L5:
        return createUnmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> replaceValues(@NullableDecl K r10, Iterable<? extends V> r11) {
        Iterator<? extends V> r12 = r11.iterator();
        if (r12.hasNext() == false) goto L5;
        Collection<V> r13 = getOrCreateCollection(r10);
        Collection<V> r14 = createCollection();
        r14.addAll(r13);
        this.totalSize -= r13.size();
        r13.clear();
    L8:
        if (r12.hasNext() == false) goto L13;
        if (r13.add(r12.next()) == false) goto L8;
        this.totalSize++;
        goto L8
    L13:
        return (Collection<V>) unmodifiableCollectionSubclass(r14);
    L5:
        return removeAll(r10);
    }

    public final void setMap(Map<K, Collection<V>> r10) {
        this.map = r10;
        this.totalSize = 0;
        Iterator<Collection<V>> r11 = r10.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Collection<V> r12 = r11.next();
        Preconditions.checkArgument(!r12.isEmpty());
        this.totalSize += r12.size();
        goto L4
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r10) {
        return Collections.unmodifiableCollection(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<V> valueIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(@NullableDecl K r10, Collection<V> r11) {
        return new WrappedCollection(this, r10, r11, null);
    }

    public final List<V> wrapList(@NullableDecl K r10, List<V> r11, @NullableDecl AbstractMapBasedMultimap<K, V>.WrappedCollection r12) {
        if ((r11 instanceof RandomAccess) == false) goto L6;
        return new RandomAccessWrappedList(this, r10, r11, r12);
    L6:
        return new WrappedList(this, r10, r11, r12);
    }
}
