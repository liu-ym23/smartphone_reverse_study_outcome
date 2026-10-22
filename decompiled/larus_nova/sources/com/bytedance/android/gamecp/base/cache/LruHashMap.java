package com.bytedance.android.gamecp.base.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
final class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LruHashMap(int r100) {
        super(r100, 0.75f, true);
        this.capacity = r100;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry r100) {
        if (size() <= this.capacity) goto L5;
        return true;
    L5:
        return false;
    }
}
