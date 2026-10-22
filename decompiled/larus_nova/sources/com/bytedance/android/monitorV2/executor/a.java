package com.bytedance.android.monitorV2.executor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.monitorV2.util.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f163034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f163035b;

    /* JADX INFO: renamed from: com.bytedance.android.monitorV2.executor.a$a, reason: collision with other inner class name */
    public static final class RunnableC2493a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f163036a;

        public RunnableC2493a(Function0<Unit> r100) {
            this.f163036a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f163036a.invoke();     // Catch: Throwable -> L4 Exception -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            f.b(e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    static {
        f163034a = new Handler(Looper.getMainLooper());
    }

    public static ExecutorService a() {
        if (f163035b != null) goto L5;
        f163035b = new PThreadPoolExecutor(4, 8, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("HybridMonitorExecutor"), new ThreadPoolExecutor.DiscardPolicy());
    L5:
        ExecutorService r100 = f163035b;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public static void b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        a().execute(new RunnableC2493a(r100));
    }

    public static void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L5;
        f163034a.post(r100);
        return;
    L5:
        r100.run();
    }

    public static void d(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        a().execute(new com.bytedance.android.monitorV2.exception.b(r100));
    }
}
