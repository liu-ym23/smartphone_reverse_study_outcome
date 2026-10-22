package com.amap.api.mapcore.util;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public abstract class a9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f26887a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    a f26888g;

    public interface a {
    }

    public void onTaskCancelled() {
    }

    public void onTaskException(Throwable r100) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        com_amap_api_mapcore_util_a9_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public abstract void runTask();

    public final void com_amap_api_mapcore_util_a9__run$___twin___() {
        long r100 = SystemClock.elapsedRealtime();
        a r101 = this.f26888g;     // Catch: Throwable -> L27
        if (r101 == null) goto L8;
        ((x8.a) r101).a(this);     // Catch: Throwable -> L27
    L8:
        if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L14;
        n0.a("AMapThreadPool", "Task interrupted | task=".concat(getClass().getSimpleName()), false);     // Catch: Throwable -> L27
        h();     // Catch: Throwable -> L27
        a r102 = this.f26888g;
        if (r102 == null) goto L46;
        ((x8.a) r102).b(this);
        return;
    L46:
        return;
    L14:
        runTask();     // Catch: Throwable -> L27
        long r103 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L27
        if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L22;
        n0.a("AMapThreadPool", "Task interrupted after run | task=" + getClass().getSimpleName() + " | elapsed=" + r103 + "ms", false);     // Catch: Throwable -> L27
        h();     // Catch: Throwable -> L27
        a r104 = this.f26888g;
        if (r104 == null) goto L47;
        ((x8.a) r104).b(this);
        return;
    L47:
        return;
    L22:
        n0.a("AMapThreadPool", "Task finished | task=" + getClass().getSimpleName() + " | elapsed=" + r103 + "ms", false);     // Catch: Throwable -> L27
        a r105 = this.f26888g;
        if (r105 == null) goto L48;
        ((x8.a) r105).b(this);
        return;
    L48:
        return;
    L27:
        th = move-exception;
        a(th);     // Catch: Throwable -> L30
    L32:
        a(th, "run");     // Catch: Throwable -> L37
        a r106 = this.f26888g;
        if (r106 == null) goto L49;
        ((x8.a) r106).b(this);
        return;
    L49:
        return;
    L30:
        th = move-exception;
        a(th, "exceptionHook");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        a r107 = this.f26888g;
        if (r107 == null) goto L41;
        ((x8.a) r107).b(this);
    L41:
        throw th;
    }

    public final void h() {
        if (this.f26887a.compareAndSet(false, true) == false) goto L6;
        onTaskCancelled();
        return;
    }

    public a9() {
        this.f26887a = new AtomicBoolean(false);
    }

    public final void cancelTask() {
        h();     // Catch: Throwable -> L4
    L13:
        a r100 = this.f26888g;     // Catch: Throwable -> L10
        if (r100 == null) goto L17;
        ((x8.a) r100).c(this);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L10:
        th = move-exception;
        a(th, "cancelListener");
        return;
    L4:
        th = move-exception;
        a(th, "cancelHook");
        goto L13
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_amap_api_mapcore_util_a9_com_larus_apm_impl_protector_RunnableLancet_run(a9 r100) {
        r100.com_amap_api_mapcore_util_a9__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void a(Throwable r100) {
        if (this.f26887a.compareAndSet(false, true) == false) goto L6;
        onTaskException(r100);
        return;
    }

    private static void a(Throwable r100, String r101) {
        t6.a(r100, "ThreadTask", r101);     // Catch: Throwable -> L4
        return;
    }
}
