package com.amap.api.mapcore.util;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class t6 extends p6 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ExecutorService f28006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Set<Integer> f28007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakReference<Context> f28008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadFactory f28009h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f28010i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f28011d;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f28012a;

        /* JADX INFO: renamed from: com.amap.api.mapcore.util.t6$a$a, reason: collision with other inner class name */
        public class C0512a extends PthreadThreadV2 {
            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public final void run() {
                com_amap_api_mapcore_util_t6$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public final void com_amap_api_mapcore_util_t6$a$a__run$___twin___() {
                super.run();     // Catch: Throwable -> L4
                return;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_mapcore_util_t6$a$a_com_larus_apm_impl_protector_RunnableLancet_run(C0512a r100) {
                r100.com_amap_api_mapcore_util_t6$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public C0512a(a r100, Runnable r101, String r102) {
                super(r101, r102);
            }
        }

        public a() {
            this.f28012a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new C0512a(this, r100, "pama#" + this.f28012a.getAndIncrement());
        }
    }

    static {
        f28007f = Collections.synchronizedSet(new HashSet());
        f28009h = new a();
    }

    public static synchronized ExecutorService a() {
        monitor-enter(t6.class);
        ExecutorService r100 = f28006e;     // Catch: Throwable -> L15
        if (r100 != null) goto L7;
    L8:
        f28006e = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f28009h);     // Catch: Throwable -> L15
        goto L18
    L7:
        if (r100.isShutdown() == true) goto L8;
    L18:
        ExecutorService r101 = f28006e;     // Catch: Throwable -> L12
        monitor-exit(t6.class);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void b() {
        monitor-enter(t6.class);
        ExecutorService r100 = f28006e;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.shutdown();     // Catch: Throwable -> L9
    L7:
        o7.d();     // Catch: Throwable -> L9
    L29:
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L12:
        if (p6.f27840c == null) goto L18;
        Thread.UncaughtExceptionHandler r101 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L21
        p6 r102 = p6.f27840c;     // Catch: Throwable -> L21
        if (r101 != r102) goto L18;
        Thread.UncaughtExceptionHandler r103 = r102.f27841a;     // Catch: Throwable -> L21
        if (r103 == null) goto L18;
        Thread.setDefaultUncaughtExceptionHandler(r103);     // Catch: Throwable -> L21
    L18:
        p6.f27840c = null;     // Catch: Throwable -> L21
        monitor-exit(t6.class);
        return;
    L25:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        goto L29
    }

    public static void c() {
        WeakReference<Context> r100 = f28008g;
        if (r100 != null) goto L5;
    L8:
        p6 r101 = p6.f27840c;
        if (r101 == null) goto L12;
        q6.a(((t6) r101).f28011d);
        return;
    L12:
        return;
    L5:
        if (r100.get() == null) goto L8;
        q6.a(f28008g.get());
    }

    private t6(Context r100) {
        this.f28011d = r100;
        Thread.UncaughtExceptionHandler r101 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        this.f27841a = r101;     // Catch: Throwable -> L17
        if (r101 != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f27842b = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r102 = r101.toString();     // Catch: Throwable -> L17
        if (r102.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f27842b = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r102.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.f27842b = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r102.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(Context r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        f28008g = new WeakReference(r100.getApplicationContext());     // Catch: Throwable -> L6
        return;
    }

    public static /* synthetic */ Context a(t6 r100) {
        return r100.f28011d;
    }

    public static synchronized t6 a(Context r100, w5 r101) throws k5 {
        monitor-enter(t6.class);
        if (r101 == null) goto L32;
        if (r101.d() == null) goto L30;
        if ("".equals(r101.d()) == true) goto L30;
    L24:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L26:
        t6 r102 = (t6) p6.f27840c;     // Catch: Throwable -> L33
        monitor-exit(t6.class);
        return r102;
    L10:
        if (f28007f.add(Integer.valueOf(r101.hashCode())) == true) goto L14;
        t6 r103 = (t6) p6.f27840c;     // Catch: Throwable -> L24
        monitor-exit(t6.class);
        return r103;
    L14:
        p6 r104 = p6.f27840c;     // Catch: Throwable -> L24
        if (r104 != null) goto L17;
        p6.f27840c = new t6(r100);     // Catch: Throwable -> L24
    L18:
        p6 r105 = p6.f27840c;     // Catch: Throwable -> L24
        boolean r106 = r105.f27842b;     // Catch: Throwable -> L24
        t6 r107 = (t6) r105;     // Catch: Throwable -> L24
        z8.f().d(new s6(r107, r101, r106));     // Catch: Throwable -> L21 RejectedExecutionException -> L36
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L26
    L17:
        r104.f27842b = false;     // Catch: Throwable -> L24
    L30:
        throw new k5("sdk name is invalid");     // Catch: Throwable -> L33
    L32:
        throw new k5("sdk info is null");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r100, Throwable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        u6.a(this.f28011d, r101, 0, null, null);
        Thread.UncaughtExceptionHandler r102 = this.f27841a;
        if (r102 == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(r102);     // Catch: Throwable -> L9
    L7:
        this.f27841a.uncaughtException(r100, r101);
        return;
    }

    public static void a(Throwable r100, String r101, String r102) {
        p6 r103 = p6.f27840c;     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        u6.a(((t6) r103).f28011d, r100, 1, r101, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void a(w5 r100, String r101, String r102) {
        p6 r103 = p6.f27840c;     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        u6.a(r100, ((t6) r103).f28011d, r102, r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // com.amap.api.mapcore.util.p6
    public final void a(Throwable r100, int r101, String r102, String r103) {
        u6.a(this.f28011d, r100, r101, r102, r103);
    }

    public static void a(w5 r100, String r101, String r102, String r103, String r104, String r105) {
        if (p6.f27840c != null) goto L6;
        return;
    L6:
        u6.a(r100, ((t6) p6.f27840c).f28011d, "networkError", "path:" + r101 + ",type:" + r102 + ",gsid:" + r103 + ",csid:" + r104 + ",code:" + r105);     // Catch: Throwable -> L8
        return;
    }
}
