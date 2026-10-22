package com.fasterxml.jackson.databind.l;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: LRUMap.java */
/* JADX INFO: loaded from: classes2.dex */
public class n<K, V> implements p<K, V>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final transient int f13044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final transient ConcurrentHashMap<K, V> f13045b;

    public n(int r4, int r5) {
        this.f13045b = new ConcurrentHashMap(r4, 0.8f, 4);
        this.f13044a = r5;
    }

    public V a(K r3, V r4) {
        if (this.f13045b.size() < this.f13044a) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f13045b.size() < this.f13044a) goto L8;
        a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f13045b.put(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.l.p
    public V b(K r3, V r4) {
        if (this.f13045b.size() < this.f13044a) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f13045b.size() < this.f13044a) goto L8;
        a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f13045b.putIfAbsent(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.l.p
    public V a(Object r1) {
        return this.f13045b.get(r1);
    }

    public void a() {
        this.f13045b.clear();
    }
}
