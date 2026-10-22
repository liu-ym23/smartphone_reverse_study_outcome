package com.byted.cast.common;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int mMaxSize;

    public MaxSizeLinkedHashMap(int r100) {
        this.mMaxSize = r100;
        if (r100 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r100) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }
}
