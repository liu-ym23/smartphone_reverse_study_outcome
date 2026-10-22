package com.bytedance.common.utility.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class WeakValueMap<K, V> {
    private final HashMap<K, WeakValue<K, V>> mMap;
    private final ReferenceQueue<V> mRefrenceQueue;

    public static final class WeakValue<K, V> extends WeakReference<V> {
        final K mKey;

        public WeakValue(K r1, V r2, ReferenceQueue<V> r3) {
            super(r2, r3);
            this.mKey = r1;
        }
    }

    public WeakValueMap() {
        this.mMap = new HashMap();
        this.mRefrenceQueue = new ReferenceQueue();
    }

    private void poll() {
    L2:
        WeakValue r0 = (WeakValue) this.mRefrenceQueue.poll();
        if (r0 == null) goto L7;
        if (this.mMap.isEmpty() == true) goto L2;
        this.mMap.remove(r0.mKey);
        goto L2
    }

    public V get(K r2) {
        poll();
        if (r2 != null) goto L5;
        return null;
    L5:
        WeakValue<K, V> r1 = this.mMap.get(r2);
        if (r1 != null) goto L8;
        return null;
    L8:
        return (V) r1.get();
    }

    public void put(K r3, V r4) {
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        this.mMap.remove(r3);
        poll();
        WeakValue<K, V> r0 = new WeakValue(r3, r4, this.mRefrenceQueue);
        this.mMap.put(r3, r0);
        return;
    L8:
        return;
    }

    public void remove(K r1) {
        poll();
        if (r1 == null) goto L6;
        this.mMap.remove(r1);
        return;
    }

    public void clear() {
        this.mMap.clear();
        poll();
    }

    public boolean isEmpty() {
        poll();
        return this.mMap.isEmpty();
    }

    public int size() {
        poll();
        return this.mMap.size();
    }
}
