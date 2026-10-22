package com.baidu.mshield.x6.f;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes39.dex */
public class c extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f32610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f32611b;

    public c() {
        super("BackgroundThread", 10);
    }

    public static void a() {
        if (f32610a != null) goto L6;
        f32610a = new c();
        ThreadMethodProxy.start(f32610a);
        f32611b = new Handler(f32610a.getLooper());
        return;
    }

    public static Handler b() {
        monitor-enter(c.class);     // Catch: Throwable -> L10
        a();     // Catch: Throwable -> L7
        Handler r100 = f32611b;     // Catch: Throwable -> L7
        monitor-exit(c.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f.b(th);
        return f32611b;
    }
}
