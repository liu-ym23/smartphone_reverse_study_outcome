package com.bytedance.reparo.core.b;

import java.lang.Throwable;

/* JADX INFO: compiled from: ReturnMayWithError.java */
/* JADX INFO: loaded from: classes.dex */
public class h<V, T extends Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f9158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private V f9159b;

    public h(V r1, T r2) {
        this.f9158a = r2;
        this.f9159b = r1;
    }

    public V a() {
        return this.f9159b;
    }

    public V b() {
        T r0 = this.f9158a;
        if (r0 == null) goto L5;
        throw r0;
    L5:
        return this.f9159b;
    }
}
