package com.baidu.mshield.x6.f;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class c extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f8511a;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f8512b;

    public c() {
        super("BackgroundThread", 10);
    }

    public static void a() {
        if (f8511a == null) {
            f8511a = new c();
            f8511a.start();
            f8512b = new Handler(f8511a.getLooper());
        }
    }

    public static Handler b() {
        Handler handler;
        try {
            synchronized (c.class) {
                a();
                handler = f8512b;
            }
            return handler;
        } catch (Throwable th) {
            f.b(th);
            return f8512b;
        }
    }
}
