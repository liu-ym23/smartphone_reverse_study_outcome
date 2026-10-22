package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: com.google.common.collect.AbstractNavigableMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class DescendingMap extends Maps.DescendingMap<K, V> {
        final /* synthetic */ AbstractNavigableMap this$0;

        private DescendingMap(AbstractNavigableMap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.this$0.descendingEntryIterator();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public NavigableMap<K, V> forward() {
            return this.this$0;
        }

        public /* synthetic */ DescendingMap(AbstractNavigableMap r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public AbstractNavigableMap() {
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> ceilingEntry(K r10) {
        return tailMap(r10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r10) {
        return (K) Maps.keyOrNull(ceilingEntry(r10));
    }

    public abstract Iterator<Map.Entry<K, V>> descendingEntryIterator();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap(this, null);
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.getNext(entryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> r10 = firstEntry();
        if (r10 == null) goto L7;
        return r10.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> floorEntry(K r10) {
        return headMap(r10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r10) {
        return (K) Maps.keyOrNull(floorEntry(r10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public abstract V get(@NullableDecl Object r10);

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K r10) {
        return headMap(r10, false);
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> higherEntry(K r10) {
        return tailMap(r10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r10) {
        return (K) Maps.keyOrNull(higherEntry(r10));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.getNext(descendingEntryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> r10 = lastEntry();
        if (r10 == null) goto L7;
        return r10.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> lowerEntry(K r10) {
        return headMap(r10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r10) {
        return (K) Maps.keyOrNull(lowerEntry(r10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entryIterator());
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingEntryIterator());
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
