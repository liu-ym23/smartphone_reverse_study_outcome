package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractNavigableMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V> {

    private final class DescendingMap extends Maps.DescendingMap<K, V> {
        final /* synthetic */ AbstractNavigableMap this$0;

        private DescendingMap(AbstractNavigableMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DescendingMap(AbstractNavigableMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap<K, V> forward() {
            return this.this$0;
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return this.this$0.descendingEntryIterator();
        }
    }

    abstract Iterator<Map.Entry<K, V>> descendingEntryIterator();

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public abstract V get(@Nullable Object r1);

    @Override // java.util.AbstractMap, java.util.Map
    public abstract int size();

    AbstractNavigableMap() {
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.getNext(entryIterator(), null);
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.getNext(descendingEntryIterator(), null);
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entryIterator());
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingEntryIterator());
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> r0 = firstEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> r0 = lastEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> lowerEntry(K r2) {
        return headMap(r2, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> floorEntry(K r2) {
        return headMap(r2, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> ceilingEntry(K r2) {
        return tailMap(r2, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @Nullable
    public Map.Entry<K, V> higherEntry(K r2) {
        return tailMap(r2, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r1) {
        return (K) Maps.keyOrNull(lowerEntry(r1));
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r1) {
        return (K) Maps.keyOrNull(floorEntry(r1));
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r1) {
        return (K) Maps.keyOrNull(ceilingEntry(r1));
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r1) {
        return (K) Maps.keyOrNull(higherEntry(r1));
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

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<Map.Entry<K, V>> entrySet() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap(this, null);
    }
}
