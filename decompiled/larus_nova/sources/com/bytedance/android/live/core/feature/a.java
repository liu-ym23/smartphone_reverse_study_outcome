package com.bytedance.android.live.core.feature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes45.dex */
public final class a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f64787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<K> f64788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f64790d;

    public a(int r100) {
        this.f64789c = r100;
        this.f64790d = false;
        this.f64787a = new ConcurrentHashMap(r100, 0.9f);
        this.f64788b = new ConcurrentLinkedQueue();
    }

    public final void a(K r100, V r101) {
        if (r100 == null) goto L19;
        if (r101 != null) goto L6;
        return;
    L6:
        if (((ConcurrentHashMap) this.f64787a).get(r100) == null) goto L9;
        this.f64788b.remove(r100);
        this.f64788b.add(r100);
        ((ConcurrentHashMap) this.f64787a).put(r100, r101);
        return;
    L9:
        if (((ConcurrentHashMap) this.f64787a).size() >= (this.f64789c * 0.8f)) goto L11;
        ((ConcurrentHashMap) this.f64787a).put(r100, r101);
        this.f64788b.add(r100);
        return;
    L11:
        if (this.f64790d == false) goto L13;
        this.f64788b.clear();
        ((ConcurrentHashMap) this.f64787a).clear();
    L16:
        ((ConcurrentHashMap) this.f64787a).put(r100, r101);
        this.f64788b.add(r100);
        return;
    L13:
        K r102 = this.f64788b.poll();
        if (r102 == null) goto L16;
        ((ConcurrentHashMap) this.f64787a).remove(r102);
        goto L16
    }
}
