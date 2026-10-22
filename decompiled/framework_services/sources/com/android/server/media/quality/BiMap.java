package com.android.server.media.quality;

import android.util.ArrayMap;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BiMap<K, V> {
    private Map<K, V> mPrimaryMap;
    private Map<V, K> mSecondaryMap;

    public BiMap() {
        this.mPrimaryMap = new ArrayMap();
        this.mSecondaryMap = new ArrayMap();
    }

    public boolean put(K key, V value) {
        if (key == null) goto L11;
        if (value != null) goto L5;
        return false;
    L5:
        if (this.mPrimaryMap.containsKey(key) == false) goto L7;
        return false;
    L7:
        if (this.mSecondaryMap.containsKey(value) == true) goto L15;
        this.mPrimaryMap.put(key, value);
        this.mSecondaryMap.put(value, key);
        return true;
    L15:
        return false;
    L11:
        return false;
    }

    public boolean remove(K key) {
        if (key != null) goto L6;
        return false;
    L6:
        if (this.mPrimaryMap.containsKey(key) == false) goto L9;
        V value = getValue(key);
        this.mPrimaryMap.remove(key);
        this.mSecondaryMap.remove(value);
        return true;
    L9:
        return false;
    }

    public boolean removeValue(V value) {
        if (value != null) goto L6;
        return false;
    L6:
        return remove(getKey(value));
    }

    public V getValue(K key) {
        return this.mPrimaryMap.get(key);
    }

    public K getKey(V value) {
        return this.mSecondaryMap.get(value);
    }

    public Collection<V> getValues() {
        return this.mPrimaryMap.values();
    }

    public void clear() {
        this.mPrimaryMap.clear();
        this.mSecondaryMap.clear();
    }
}
