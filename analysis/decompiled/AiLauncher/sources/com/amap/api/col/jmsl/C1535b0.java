package com.amap.api.col.jmsl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.jmsl.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1535b0 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile C1535b0 f16529c;

    /* renamed from: a, reason: collision with root package name */
    public BlockingQueue<Runnable> f16530a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f16531b;

    public C1535b0() {
        this.f16531b = null;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.f16531b = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors * 2, 1, TimeUnit.SECONDS, this.f16530a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static void a() {
        if (f16529c != null) {
            synchronized (C1535b0.class) {
                try {
                    if (f16529c != null) {
                        f16529c.f16531b.shutdownNow();
                        f16529c.f16531b = null;
                        f16529c = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static C1535b0 c() {
        if (f16529c == null) {
            synchronized (C1535b0.class) {
                try {
                    if (f16529c == null) {
                        f16529c = new C1535b0();
                    }
                } finally {
                }
            }
        }
        return f16529c;
    }

    public void b(Runnable runnable) {
        ExecutorService executorService = this.f16531b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
