package com.android.server.am;

import android.util.ArrayMap;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class UidProcessMap<E> {
    final SparseArray<ArrayMap<String, E>> mMap;

    public UidProcessMap() {
        this.mMap = new SparseArray();
    }

    public E get(int uid, String name) {
        ArrayMap<String, E> names = this.mMap.get(uid);
        if (names != null) goto L7;
        return null;
    L7:
        return names.get(name);
    }

    public E put(int uid, String name, E value) {
        ArrayMap<String, E> names = this.mMap.get(uid);
        if (names != null) goto L5;
        names = new ArrayMap(2);
        this.mMap.put(uid, names);
    L5:
        names.put(name, value);
        return value;
    }

    public E remove(int uid, String name) {
        int index = this.mMap.indexOfKey(uid);
        if (index >= 0) goto L5;
        return null;
    L5:
        ArrayMap<String, E> names = this.mMap.valueAt(index);
        if (names == null) goto L11;
        E old = names.remove(name);
        if (names.isEmpty() == false) goto L10;
        this.mMap.removeAt(index);
    L10:
        return old;
    L11:
        return null;
    }

    public SparseArray<ArrayMap<String, E>> getMap() {
        return this.mMap;
    }

    public int size() {
        return this.mMap.size();
    }

    public void clear() {
        this.mMap.clear();
    }

    public void putAll(UidProcessMap<E> other) {
        int i = other.mMap.size() - 1;
    L3:
        if (i < 0) goto L10;
        int uid = other.mMap.keyAt(i);
        ArrayMap<String, E> names = this.mMap.get(uid);
        if (names == null) goto L7;
        names.putAll(other.mMap.valueAt(i));
    L8:
        i = i - 1;
        goto L3
    L7:
        this.mMap.put(uid, new ArrayMap(other.mMap.valueAt(i)));
        goto L8
    }
}
