package com.bytedance.android.ec.core.arch.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f43844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f43845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f43846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<Runnable> f43847d;

    public final void a() {
        if (this.f43846c == false) goto L27;
        return;
    L27:
        this.f43846c = true;     // Catch: Throwable -> L24
    L7:
        if ((!((ArrayDeque) this.f43847d).isEmpty()) == false) goto L22;
        if (this.f43845b == false) goto L12;
    L15:
        boolean r100 = true;
    L16:
        if (r100 == false) goto L22;
        Runnable r101 = (Runnable) ((ArrayDeque) this.f43847d).poll();     // Catch: Throwable -> L24
        if (r101 == null) goto L7;
        r101.run();     // Catch: Throwable -> L24
        goto L7
    L12:
        if (this.f43844a == false) goto L15;
        r100 = false;
    L22:
        this.f43846c = false;
        return;
    L24:
        th = move-exception;
        this.f43846c = false;
        throw th;
    }

    public b() {
        this.f43844a = true;
        this.f43847d = new ArrayDeque();
    }
}
