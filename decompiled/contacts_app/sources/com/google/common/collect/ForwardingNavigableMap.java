package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        final /* synthetic */ ForwardingNavigableMap this$0;

        public StandardDescendingMap(ForwardingNavigableMap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap<K, V> forward() {
            return this.this$0;
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        protected Iterator<Map.Entry<K, V>> entryIterator() {
            return new AnonymousClass1(this);
        }
    }

    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        final /* synthetic */ ForwardingNavigableMap this$0;

        public StandardNavigableKeySet(ForwardingNavigableMap r1) {
            this.this$0 = r1;
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected abstract NavigableMap<K, V> delegate();

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ SortedMap delegate() {
        return delegate();
    }

    protected ForwardingNavigableMap() {
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r1) {
        return delegate().lowerEntry(r1);
    }

    protected Map.Entry<K, V> standardLowerEntry(K r2) {
        return headMap(r2, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r1) {
        return delegate().lowerKey(r1);
    }

    protected K standardLowerKey(K r1) {
        return (K) Maps.keyOrNull(lowerEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r1) {
        return delegate().floorEntry(r1);
    }

    protected Map.Entry<K, V> standardFloorEntry(K r2) {
        return headMap(r2, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r1) {
        return delegate().floorKey(r1);
    }

    protected K standardFloorKey(K r1) {
        return (K) Maps.keyOrNull(floorEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r1) {
        return delegate().ceilingEntry(r1);
    }

    protected Map.Entry<K, V> standardCeilingEntry(K r2) {
        return tailMap(r2, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r1) {
        return delegate().ceilingKey(r1);
    }

    protected K standardCeilingKey(K r1) {
        return (K) Maps.keyOrNull(ceilingEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r1) {
        return delegate().higherEntry(r1);
    }

    protected Map.Entry<K, V> standardHigherEntry(K r2) {
        return tailMap(r2, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r1) {
        return delegate().higherKey(r1);
    }

    protected K standardHigherKey(K r1) {
        return (K) Maps.keyOrNull(higherEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    protected Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    protected K standardFirstKey() {
        Map.Entry<K, V> r0 = firstEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    protected Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    protected K standardLastKey() {
        Map.Entry<K, V> r0 = lastEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    protected Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    protected Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    protected NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    protected SortedMap<K, V> standardSubMap(K r3, K r4) {
        return subMap(r3, true, r4, false);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K r1, boolean r2, K r3, boolean r4) {
        return delegate().subMap(r1, r2, r3, r4);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K r1, boolean r2) {
        return delegate().headMap(r1, r2);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K r1, boolean r2) {
        return delegate().tailMap(r1, r2);
    }

    protected SortedMap<K, V> standardHeadMap(K r2) {
        return headMap(r2, false);
    }

    protected SortedMap<K, V> standardTailMap(K r2) {
        return tailMap(r2, true);
    }
}
