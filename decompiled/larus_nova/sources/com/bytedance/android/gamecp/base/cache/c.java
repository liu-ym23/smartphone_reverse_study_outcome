package com.bytedance.android.gamecp.base.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class c<K, V> implements a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f51398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51400c;

    public final synchronized String toString() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f51398a == null) goto L6;
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L15
        Iterator<Map.Entry<K, V>> r101 = ((LinkedHashMap) this.f51398a).entrySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<K, V> r102 = r101.next();     // Catch: Throwable -> L15
        r100.append(r102.getKey());     // Catch: Throwable -> L15
        r100.append(com.alipay.sdk.m.n.a.f25612h);     // Catch: Throwable -> L15
        r100.append(r102.getValue());     // Catch: Throwable -> L15
        r100.append(",");     // Catch: Throwable -> L15
        goto L10
    L12:
        r100.append("maxMemory=");     // Catch: Throwable -> L15
        r100.append(this.f51399b);     // Catch: Throwable -> L15
        r100.append(",");     // Catch: Throwable -> L15
        r100.append("memorySize=");     // Catch: Throwable -> L15
        r100.append(this.f51400c);     // Catch: Throwable -> L15
        String r103 = r100.toString();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r103;
    L6:
        monitor-exit(this);
        return "";
    }

    public c() {
        this(8);
    }

    public c(int r100) {
        if (r100 <= 0) goto L9;
        this.f51398a = new LruHashMap(r100);     // Catch: OutOfMemoryError -> L6
        this.f51399b = r100;     // Catch: OutOfMemoryError -> L6
        return;
    L6:
        this.f51398a = new LruHashMap(10);
        this.f51399b = 10;
        return;
    L9:
        throw new IllegalArgumentException("capacity <= 0");
    }

    public final V a(K r100) {
        if (this.f51398a != null) goto L5;
        return null;
    L5:
        monitor-enter(this);
        V r101 = (V) ((LinkedHashMap) this.f51398a).get(r100);
        if (r101 == null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L12
        return r101;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public final void c(int r100) {
    L3:
        if (this.f51400c <= r100) goto L18;
        Map<K, V> r101 = this.f51398a;
        if (r101 == null) goto L26;
        if (((HashMap) r101).isEmpty() == true) goto L27;
        if (this.f51400c < 0) goto L17;
        if (((HashMap) this.f51398a).isEmpty() == false) goto L15;
        if (this.f51400c != 0) goto L17;
    L15:
        Map.Entry<K, V> r102 = ((LinkedHashMap) this.f51398a).entrySet().iterator().next();
        ((HashMap) this.f51398a).remove(r102.getKey());
        int r103 = this.f51400c;
        r102.getValue();
        this.f51400c = r103 - 1;
    L17:
        throw new IllegalStateException(c.class.getName().concat(".getValueSize() is reporting inconsistent results"));
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.gamecp.base.cache.a
    public final void delete(K r100) {
        if (this.f51398a != null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (((HashMap) this.f51398a).remove(r100) == null) goto L9;
        this.f51400c--;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public final void b(K r100, V r101) {
        if (this.f51398a != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        Object r102 = ((HashMap) this.f51398a).put(r100, r101);     // Catch: Throwable -> L12
        int r103 = this.f51400c + 1;     // Catch: Throwable -> L12
        this.f51400c = r103;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        this.f51400c = r103 - 1;     // Catch: Throwable -> L12
    L9:
        c(this.f51399b);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
