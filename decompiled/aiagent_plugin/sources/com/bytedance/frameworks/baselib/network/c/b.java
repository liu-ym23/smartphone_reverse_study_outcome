package com.bytedance.frameworks.baselib.network.c;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: IApiTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements c, Comparable<c>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f8006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicBoolean f8007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f8008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f8009d;

    @Deprecated
    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public b() {
        this.f8006a = new AtomicBoolean(false);
        this.f8007b = new AtomicBoolean(false);
        this.f8008c = 0;
    }

    public boolean e() {
        return this.f8007b.get();
    }

    public b c(int r1) {
        this.f8009d = r1;
        return this;
    }

    public int f() {
        return this.f8008c;
    }
}
