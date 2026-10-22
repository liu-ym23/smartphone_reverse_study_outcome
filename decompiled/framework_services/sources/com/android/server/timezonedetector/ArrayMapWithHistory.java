package com.android.server.timezonedetector;

import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayMapWithHistory<K, V> {
    private static final String TAG = "ArrayMapWithHistory";
    private ArrayMap<K, ReferenceWithHistory<V>> mMap;
    private final int mMaxHistorySize;

    public ArrayMapWithHistory(int maxHistorySize) {
        if (maxHistorySize < 1) goto L7;
        this.mMaxHistorySize = maxHistorySize;
        return;
    L7:
        throw new IllegalArgumentException("maxHistorySize < 1: " + maxHistorySize);
    }

    public V put(K key, V value) {
        if (this.mMap != null) goto L5;
        this.mMap = new ArrayMap();
    L5:
        ReferenceWithHistory<V> valueHolder = this.mMap.get(key);
        if (valueHolder != null) goto L9;
        valueHolder = new ReferenceWithHistory(this.mMaxHistorySize);
        this.mMap.put(key, valueHolder);
    L12:
        return valueHolder.set(value);
    L9:
        if (valueHolder.getHistoryCount() != 0) goto L12;
        Log.w(TAG, "History for \"" + key + "\" was unexpectedly empty");
        goto L12
    }

    public V get(Object key) {
        if (this.mMap != null) goto L5;
        return null;
    L5:
        ReferenceWithHistory<V> valueHolder = this.mMap.get(key);
        if (valueHolder != null) goto L9;
        return null;
    L9:
        if (valueHolder.getHistoryCount() != 0) goto L12;
        Log.w(TAG, "History for \"" + key + "\" was unexpectedly empty");
    L12:
        return valueHolder.get();
    }

    public int size() {
        if (this.mMap != null) goto L6;
        return 0;
    L6:
        return this.mMap.size();
    }

    public K keyAt(int index) {
        if (this.mMap == null) goto L7;
        return this.mMap.keyAt(index);
    L7:
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public V valueAt(int index) {
        if (this.mMap == null) goto L14;
        ReferenceWithHistory<V> valueHolder = this.mMap.valueAt(index);
        if (valueHolder != null) goto L7;
    L11:
        Log.w(TAG, "valueAt(" + index + ") was unexpectedly null or empty");
        return null;
    L7:
        if (valueHolder.getHistoryCount() == 0) goto L11;
        return valueHolder.get();
    L14:
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public void dump(IndentingPrintWriter ipw) {
        if (this.mMap != null) goto L5;
        ipw.println("{Empty}");
    L9:
        ipw.flush();
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mMap.size()) goto L9;
        ipw.println("key idx: " + i + "=" + this.mMap.keyAt(i));
        ReferenceWithHistory<V> value = this.mMap.valueAt(i);
        ipw.println("val idx: " + i + "=" + value);
        ipw.increaseIndent();
        ipw.println("Historic values=[");
        ipw.increaseIndent();
        value.dump(ipw);
        ipw.decreaseIndent();
        ipw.println("]");
        ipw.decreaseIndent();
        i = i + 1;
        goto L7
    }

    public int getHistoryCountForKeyForTests(K key) {
        if (this.mMap != null) goto L5;
        return 0;
    L5:
        ReferenceWithHistory<V> valueHolder = this.mMap.get(key);
        if (valueHolder != null) goto L9;
        return 0;
    L9:
        if (valueHolder.getHistoryCount() != 0) goto L13;
        Log.w(TAG, "getValuesSizeForKeyForTests(\"" + key + "\") was unexpectedly empty");
        return 0;
    L13:
        return valueHolder.getHistoryCount();
    }

    public String toString() {
        return "ArrayMapWithHistory{mHistorySize=" + this.mMaxHistorySize + ", mMap=" + this.mMap + '}';
    }
}
