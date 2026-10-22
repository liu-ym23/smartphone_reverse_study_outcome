package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    @Beta
    public class StandardKeySet extends Maps.SortedKeySet<K, V> {
        final /* synthetic */ ForwardingSortedMap this$0;

        public StandardKeySet(ForwardingSortedMap r10) {
            this.this$0 = r10;
            super(r10);
        }
    }

    public ForwardingSortedMap() {
    }

    private int unsafeCompare(Object r10, Object r11) {
        Comparator<? super K> r12 = comparator();
        if (r12 != null) goto L7;
        return ((Comparable) r10).compareTo(r11);
    L7:
        return r12.compare(r10, r11);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K r10) {
        return delegate().headMap(r10);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    @Beta
    public boolean standardContainsKey(@NullableDecl Object r10) {
        if (unsafeCompare(tailMap(r10).firstKey(), r10) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Beta
    public SortedMap<K, V> standardSubMap(K r10, K r11) {
        if (unsafeCompare(r10, r11) > 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "fromKey must be <= toKey");
        return tailMap(r10).headMap(r11);
    L5:
        r12 = false;
        goto L6
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r10, K r11) {
        return delegate().subMap(r10, r11);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r10) {
        return delegate().tailMap(r10);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }
}
