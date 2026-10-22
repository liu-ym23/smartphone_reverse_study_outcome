package com.alipay.apmobilesecuritysdk.f;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f25110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f25111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList<Runnable> f25112c;

    static {
        f25110a = new b();
    }

    public b() {
        this.f25111b = null;
        this.f25112c = new LinkedList();
    }

    public static b a() {
        return f25110a;
    }

    public static /* synthetic */ LinkedList a(b r100) {
        return r100.f25112c;
    }

    public static /* synthetic */ Thread b(b r100) {
        r100.f25111b = null;
        return null;
    }

    public final synchronized void a(Runnable r100) {
        monitor-enter(this);
        this.f25112c.add(r100);     // Catch: Throwable -> L8
        if (this.f25111b != null) goto L6;
        PthreadThreadV2 r101 = new PthreadThreadV2(new c(this), "curitysdk/f/b");     // Catch: Throwable -> L8
        this.f25111b = r101;     // Catch: Throwable -> L8
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
