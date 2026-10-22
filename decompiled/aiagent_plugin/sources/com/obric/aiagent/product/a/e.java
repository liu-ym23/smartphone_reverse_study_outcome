package com.obric.aiagent.product.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.g;
import d.x;

/* JADX INFO: compiled from: ThreadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f18782b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f<HandlerThread> f18783c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f f18784d = null;

    /* JADX INFO: compiled from: ThreadUtils.kt */
    private static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f18785a;

        public a(Runnable r3) {
            this.f18785a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r0 = this.f18785a;
            if (r0 != null) goto L12;
            return;
        L12:
            r0.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (ZeusTransformUtils.instanceOf(th, Error.class) == true) goto L10;
            ILogDepend.Companion.e("SafeWrapper", "fail to execute runnable = " + this.f18785a + " error = " + Log.getStackTraceString(th));
            return;
        L10:
            throw th;
        }
    }

    /* JADX INFO: compiled from: ThreadUtils.kt */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f18786a;

        public b(d.h.a.a<x> r3) {
            this.f18786a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f18786a.invoke();
        }
    }

    public static /* synthetic */ HandlerThread lambda$7mOfQGJp7QC1SviJSksp2wPKRI8() {
        return d();
    }

    public static /* synthetic */ Handler lambda$pzCiX7yvqLyNcYahT1jqvfA0OlA() {
        return e();
    }

    private e() {
    }

    static {
        f18781a = new e();
        f18782b = new Handler(Looper.getMainLooper());
        f18783c = g.a($$Lambda$e$7mOfQGJp7QC1SviJSksp2wPKRI8.INSTANCE);
        f18784d = g.a($$Lambda$e$pzCiX7yvqLyNcYahT1jqvfA0OlA.INSTANCE);
    }

    public final Handler a() {
        return f18782b;
    }

    private static final HandlerThread d() {
        HandlerThread r0 = new HandlerThread("background_thread_utils");
        r0.start();
        ILogDepend.Companion.i("ThreadUtils", "ThreadUtils inited，currentThread = " + Thread.currentThread());
        return r0;
    }

    private final HandlerThread c() {
        return (HandlerThread) ZeusTransformUtils.preCheckCast(f18783c.b(), HandlerThread.class, "com.obric.aiagent.plugin");
    }

    private static final Handler e() {
        return new Handler(f18781a.c().getLooper());
    }

    public final Handler b() {
        return (Handler) ZeusTransformUtils.preCheckCast(f18784d.b(), Handler.class, "com.obric.aiagent.plugin");
    }

    public final void a(Runnable r3) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        f18782b.post((Runnable) ZeusTransformUtils.preCheckCast(new a(r2), Runnable.class, "com.obric.aiagent.plugin"));
    }

    public final void a(Runnable r3, long r4) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        f18782b.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(new a(r2), Runnable.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L8;
        r4.run();
        return;
    L8:
        a(r4);
    }
}
