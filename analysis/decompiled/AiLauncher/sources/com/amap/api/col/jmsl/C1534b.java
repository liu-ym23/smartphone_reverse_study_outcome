package com.amap.api.col.jmsl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.jmsl.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1534b {

    /* renamed from: c, reason: collision with root package name */
    public static volatile C1534b f16526c;

    /* renamed from: a, reason: collision with root package name */
    public BlockingQueue<Runnable> f16527a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f16528b;

    public C1534b() {
        this.f16528b = null;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.f16528b = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors * 2, 10, TimeUnit.SECONDS, this.f16527a, new F2("AMapThreadUtil"), new ThreadPoolExecutor.AbortPolicy());
    }

    public static C1534b a() {
        if (f16526c == null) {
            synchronized (C1534b.class) {
                try {
                    if (f16526c == null) {
                        f16526c = new C1534b();
                    }
                } finally {
                }
            }
        }
        return f16526c;
    }

    public void b(Runnable runnable) {
        ExecutorService executorService = this.f16528b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
