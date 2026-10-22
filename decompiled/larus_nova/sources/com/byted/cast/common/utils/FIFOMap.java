package com.byted.cast.common.utils;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes39.dex */
public class FIFOMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public FIFOMap(int r100) {
        this.maxSize = r100;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        if (size() < this.maxSize) goto L6;
        remove(entrySet().iterator().next().getKey());
    L6:
        return (V) super.put(r100, r101);
    }
}
