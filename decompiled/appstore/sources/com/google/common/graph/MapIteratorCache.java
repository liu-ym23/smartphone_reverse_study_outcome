package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
class MapIteratorCache<K, V> {
    private final Map<K, V> backingMap;

    @NullableDecl
    private transient Map.Entry<K, V> entrySetCache;

    public MapIteratorCache(Map<K, V> r10) {
        this.backingMap = (Map) Preconditions.checkNotNull(r10);
    }

    public static /* synthetic */ Map access$000(MapIteratorCache r10) {
        return r10.backingMap;
    }

    public static /* synthetic */ Map.Entry access$102(MapIteratorCache r10, Map.Entry r11) {
        r10.entrySetCache = r11;
        return r11;
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public void clearCache() {
        this.entrySetCache = null;
    }

    public final boolean containsKey(@NullableDecl Object r10) {
        if (getIfCached(r10) == null) goto L5;
    L8:
        return true;
    L5:
        if (this.backingMap.containsKey(r10) == true) goto L8;
        return false;
    }

    public V get(@NullableDecl Object r10) {
        V r11 = getIfCached(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return getWithoutCaching(r10);
    }

    public V getIfCached(@NullableDecl Object r10) {
        Map.Entry<K, V> r11 = this.entrySetCache;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getKey() == r10) goto L7;
        return null;
    L7:
        return r11.getValue();
    }

    public final V getWithoutCaching(@NullableDecl Object r10) {
        return this.backingMap.get(r10);
    }

    @CanIgnoreReturnValue
    public V put(@NullableDecl K r10, @NullableDecl V r11) {
        clearCache();
        return this.backingMap.put(r10, r11);
    }

    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object r10) {
        clearCache();
        return this.backingMap.remove(r10);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AnonymousClass1(this);
    }
}
