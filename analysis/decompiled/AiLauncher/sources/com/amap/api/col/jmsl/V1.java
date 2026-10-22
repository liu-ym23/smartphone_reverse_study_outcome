package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.O1;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class V1 extends AbstractC1581m2 {

    /* renamed from: e, reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f16386e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static final int f16387f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f16388g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f16389h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f16390i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f16391j;

    /* renamed from: k, reason: collision with root package name */
    public static V1 f16392k;

    public static class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            C1541c2.b(th, "TPool", "ThreadPool");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f16387f = iAvailableProcessors;
        int iMax = Math.max(4, Math.min(iAvailableProcessors, 8));
        f16388g = iMax;
        int iMin = Math.min(iAvailableProcessors * 2, 16);
        f16389h = iMin;
        int iMax2 = Math.max(2, Math.min(iAvailableProcessors / 2, 4));
        f16390i = iMax2;
        int iMin2 = Math.min(iAvailableProcessors, 8);
        f16391j = iMin2;
        O1.a aVarA = new O1.a().c(f16386e).b("amap-global-threadPool").a(iMax2);
        if (iMin2 <= 0) {
            throw new NullPointerException("maxPoolSize  must > 0!");
        }
        f16392k = new V1(aVarA.d());
        O1.a aVarA2 = new O1.a().c(f16386e).b("amap-network-threadPool").a(iMax);
        if (iMin <= 0) {
            throw new NullPointerException("maxPoolSize  must > 0!");
        }
        new V1(aVarA2.g(9).d());
    }

    public V1(O1 o12) {
        try {
            this.f16748b = o12.f();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(o12.c(), o12.e(), o12.d(), TimeUnit.SECONDS, o12.g(), o12);
            this.f16747a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            C1541c2.b(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static V1 g(O1 o12) {
        return new V1(o12);
    }

    public static V1 h() {
        return f16392k;
    }
}
