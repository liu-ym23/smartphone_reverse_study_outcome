package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
        final /* synthetic */ ForwardingSortedMap this$0;

        public StandardKeySet(ForwardingSortedMap r1) {
            this.this$0 = r1;
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected abstract SortedMap<K, V> delegate();

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    protected ForwardingSortedMap() {
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K r1) {
        return delegate().headMap(r1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r1, K r2) {
        return delegate().subMap(r1, r2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r1) {
        return delegate().tailMap(r1);
    }

    private int unsafeCompare(Object r1, Object r2) {
        Comparator<? super K> r0 = comparator();
        if (r0 != null) goto L7;
        return ((Comparable) r1).compareTo(r2);
    L7:
        return r0.compare(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    protected boolean standardContainsKey(@Nullable Object r3) {
        if (unsafeCompare(tailMap(r3).firstKey(), r3) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    protected SortedMap<K, V> standardSubMap(K r3, K r4) {
        if (unsafeCompare(r3, r4) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "fromKey must be <= toKey");
        return tailMap(r3).headMap(r4);
    L5:
        r0 = false;
        goto L6
    }
}
