package com.baidu.xclient.gdid.j;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class b extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    public static b f9535a;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f9536b;

    public b() {
        super("BackgroundThread", 10);
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            c();
            bVar = f9535a;
        }
        return bVar;
    }

    public static Handler b() {
        Handler handler;
        synchronized (b.class) {
            c();
            handler = f9536b;
        }
        return handler;
    }

    public static void c() {
        if (f9535a == null) {
            b bVar = new b();
            f9535a = bVar;
            bVar.start();
            f9536b = new Handler(f9535a.getLooper());
        }
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            b().post(runnable);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
