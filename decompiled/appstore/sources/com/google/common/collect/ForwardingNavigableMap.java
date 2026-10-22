package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    @Beta
    public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        final /* synthetic */ ForwardingNavigableMap this$0;

        public StandardDescendingMap(ForwardingNavigableMap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public NavigableMap<K, V> forward() {
            return this.this$0;
        }
    }

    @Beta
    public class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        final /* synthetic */ ForwardingNavigableMap this$0;

        public StandardNavigableKeySet(ForwardingNavigableMap r10) {
            this.this$0 = r10;
            super(r10);
        }
    }

    public ForwardingNavigableMap() {
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r10) {
        return delegate().ceilingEntry(r10);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r10) {
        return delegate().ceilingKey(r10);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract NavigableMap<K, V> delegate();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r10) {
        return delegate().floorEntry(r10);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r10) {
        return delegate().floorKey(r10);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K r10, boolean r11) {
        return delegate().headMap(r10, r11);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r10) {
        return delegate().higherEntry(r10);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r10) {
        return delegate().higherKey(r10);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r10) {
        return delegate().lowerEntry(r10);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r10) {
        return delegate().lowerKey(r10);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public Map.Entry<K, V> standardCeilingEntry(K r10) {
        return tailMap(r10, true).firstEntry();
    }

    public K standardCeilingKey(K r10) {
        return (K) Maps.keyOrNull(ceilingEntry(r10));
    }

    @Beta
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry<K, V> r10 = firstEntry();
        if (r10 == null) goto L7;
        return r10.getKey();
    L7:
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardFloorEntry(K r10) {
        return headMap(r10, true).lastEntry();
    }

    public K standardFloorKey(K r10) {
        return (K) Maps.keyOrNull(floorEntry(r10));
    }

    public SortedMap<K, V> standardHeadMap(K r10) {
        return headMap(r10, false);
    }

    public Map.Entry<K, V> standardHigherEntry(K r10) {
        return tailMap(r10, false).firstEntry();
    }

    public K standardHigherKey(K r10) {
        return (K) Maps.keyOrNull(higherEntry(r10));
    }

    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry<K, V> r10 = lastEntry();
        if (r10 == null) goto L7;
        return r10.getKey();
    L7:
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardLowerEntry(K r10) {
        return headMap(r10, false).lastEntry();
    }

    public K standardLowerKey(K r10) {
        return (K) Maps.keyOrNull(lowerEntry(r10));
    }

    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    public SortedMap<K, V> standardSubMap(K r10, K r11) {
        return subMap(r10, true, r11, false);
    }

    public SortedMap<K, V> standardTailMap(K r10) {
        return tailMap(r10, true);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
        return delegate().subMap(r10, r11, r12, r13);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K r10, boolean r11) {
        return delegate().tailMap(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ SortedMap delegate() {
        return delegate();
    }
}
