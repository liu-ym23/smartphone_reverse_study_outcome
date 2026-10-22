package com.bytedance.android.ec.core.imagex.common;

import android.os.Looper;
import android.os.Process;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AsyncWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f44549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f44551c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AsyncWorker f44552d = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f44553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f44554b;

        public a(boolean r100, Function0 r101) {
            this.f44553a = r100;
            this.f44554b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Executor r100 = AsyncWorker.f44549a;     // Catch: Throwable -> L13
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            if (this.f44553a == false) goto L6;
            Process.setThreadPriority(-4);     // Catch: Throwable -> L9
        L7:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            this.f44554b.invoke();     // Catch: Throwable -> L13
            return;
        L6:
            Process.setThreadPriority(0);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L17;
            return;
        L17:
            throw th;
        }
    }

    public AsyncWorker() {
    }

    static {
        f44552d = new AsyncWorker();
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.f44407j.getValue()).booleanValue() == false) goto L5;
        Executor r100 = new b("AsyncWorker");
    L6:
        f44549a = r100;
        f44550b = LazyKt.lazy(AsyncWorker$workerDispatcher$2.INSTANCE);
        f44551c = LazyKt.lazy(AsyncWorker$highPriorityDispatcher$2.INSTANCE);
        return;
    L5:
        r100 = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("n/AsyncWorker"));
        goto L6
    }

    public static boolean a() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L5;
    L7:
        return false;
    L5:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        return true;
    }

    public final void b(boolean r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "block");
        if (r100 == true) goto L5;
    L7:
        Executor r103 = f44549a;
        if (r101 == false) goto L10;
        int r104 = -4;
    L11:
        r103.execute(new v.a(Integer.valueOf(r104), new a(r101, r102)));
        return;
    L10:
        r104 = 0;
        goto L11
    L5:
        if (a() == true) goto L7;
        r102.invoke();
    }
}
