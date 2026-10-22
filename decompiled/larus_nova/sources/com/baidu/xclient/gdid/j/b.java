package com.baidu.xclient.gdid.j;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes39.dex */
public class b extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f33624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f33625b;

    public b() {
        super("BackgroundThread", 10);
    }

    public static b a() {
        monitor-enter(b.class);
        c();     // Catch: Throwable -> L7
        b r100 = f33624a;     // Catch: Throwable -> L7
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler b() {
        monitor-enter(b.class);
        c();     // Catch: Throwable -> L7
        Handler r100 = f33625b;     // Catch: Throwable -> L7
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c() {
        if (f33624a != null) goto L6;
        b r100 = new b();
        f33624a = r100;
        ThreadMethodProxy.start(r100);
        f33625b = new Handler(f33624a.getLooper());
        return;
    }

    public void a(Runnable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        b().post(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        d.a(th);
    }
}
