package com.amap.api.mapcore.util;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public final class z8 extends x8 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f28595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28596f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28597g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28598h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28599i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28600j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28601k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static z8 f28602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static z8 f28603m;

    public static class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r100, Throwable r101) {
            t6.a(r101, "TPool", "ThreadPool");
        }
    }

    static {
        f28595e = new a();
        int r100 = Runtime.getRuntime().availableProcessors();
        f28596f = r100;
        int r101 = Math.min(r100 * 2, Math.max(8, r100 * 4));
        f28597g = r101;
        int r102 = Math.max(4, Math.min(r100, 8));
        f28598h = r102;
        int r103 = Math.max(r102, r101);
        f28599i = r103;
        int r104 = Math.max(2, Math.min(r100 / 2, 4));
        f28600j = r104;
        int r105 = Math.max(r104, r101);
        f28601k = r105;
        f28602l = new z8(new y8.a().a(f28595e).a("amap-global-threadPool").a(r104).b(r105).a());
        f28603m = new z8(new y8.a().a(f28595e).a("amap-network-threadPool").a(r102).b(r103).c(9).a());
    }

    public static z8 e() {
        return new z8(new y8.a().a(f28595e).a());
    }

    public static synchronized z8 g() {
        monitor-enter(z8.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f28602l != null) goto L7;
        f28602l = new z8(new y8.a().a(f28595e).a());     // Catch: Throwable -> L10
    L7:
        z8 r100 = f28602l;     // Catch: Throwable -> L10
        monitor-exit(z8.class);
        return r100;
    }

    public static int i() {
        z8 r100 = f28603m;
        if (r100 != null) goto L5;
        return -1;
    L5:
        ThreadPoolExecutor r101 = r100.f28339a;
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r101.getCorePoolSize();
    }

    public static int j() {
        z8 r100 = f28603m;
        if (r100 != null) goto L5;
        return -1;
    L5:
        ThreadPoolExecutor r101 = r100.f28339a;
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r101.getMaximumPoolSize();
    }

    public static z8 f() {
        return f28602l;
    }

    public static z8 h() {
        return f28603m;
    }

    private z8(y8 r110) {
        this.f28340b = r110.f();     // Catch: Throwable -> L5
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(r110.c(), r110.e(), r110.d(), TimeUnit.SECONDS, r110.g(), r110);     // Catch: Throwable -> L5
        this.f28339a = r100;     // Catch: Throwable -> L5
        r100.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        t6.a(th, "TPool", "ThreadPool");
        th.printStackTrace();
    }

    public static boolean a(int r100) {
        return a(f28603m, r100, r100);
    }

    public static z8 a(y8 r100) {
        return new z8(r100);
    }

    public static boolean a(int r100, int r101) {
        return a(f28603m, r100, r101);
    }

    private static boolean a(z8 r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 <= 0) goto L42;
        if (r102 > 0) goto L8;
        return false;
    L8:
        if (r101 > 32) goto L44;
        if (r102 > 32) goto L45;
        if (r101 > r102) goto L47;
        monitor-enter(r100);
        if (r101 <= 0) goto L36;
        if (r102 <= 0) goto L36;
        if (r101 > r102) goto L36;
        ThreadPoolExecutor r103 = r100.f28339a;     // Catch: Throwable -> L33
        if (r103 == null) goto L36;
        if (r103.isShutdown() == true) goto L36;
    L30:
        th = move-exception;
        t6.a(th, "TPool", "configurePoolSize");     // Catch: Throwable -> L33
        goto L36
    L23:
        if (r101 <= r100.f28339a.getMaximumPoolSize()) goto L25;
        r100.f28339a.setMaximumPoolSize(r101);     // Catch: Throwable -> L30
    L25:
        r100.f28339a.setCorePoolSize(r101);     // Catch: Throwable -> L30
        if (r100.f28339a.getMaximumPoolSize() == r102) goto L28;
        r100.f28339a.setMaximumPoolSize(r102);     // Catch: Throwable -> L30
    L28:
        monitor-exit(r100);
        return true;
    L33:
        th = move-exception;
        throw th;
    L36:
        monitor-exit(r100);
        return false;
    L47:
        return false;
    L45:
        return false;
    L44:
        return false;
    L42:
        return false;
    }
}
