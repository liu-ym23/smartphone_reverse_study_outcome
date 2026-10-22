package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.live.kmp.statemachine.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f91877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<a> f91878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f91879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f91880d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Future<?> f91881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.live.revenuelink.multimsg.api.a<?, ?> f91882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f91883c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f91883c.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(com.bytedance.android.live.revenuelink.multimsg.api.a r100, g.b r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, "taskExecute");
            this.f91882b = r100;
            this.f91883c = r101;
        }
    }

    public f(ExecutorService r100) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        this.f91880d = r100;
        this.f91877a = new ReentrantLock();
        this.f91878b = new AtomicReference();
        this.f91879c = new ConcurrentLinkedQueue();
    }

    public static final void a(f r100, a r101) {
        r100.f91877a.lock();
        if (r101 != null) goto L23;
    L5:
        a r102 = r100.f91879c.poll();     // Catch: Exception -> L9 Throwable -> L16
        if (r102 == null) goto L18;
        r100.f91878b.getAndSet(r102);     // Catch: Exception -> L9 Throwable -> L16
        r102.f91881a = r100.f91880d.submit(r102);     // Catch: Exception -> L9 Throwable -> L16
    L9:
        e = move-exception;
        ALogger.e("MsgTaskScheduler", "", e);     // Catch: Throwable -> L16
        if (r101 == null) goto L18;
        com.bytedance.android.live.revenuelink.multimsg.api.a<?, ?> r103 = r101.f91882b;     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        TaskState<?, ?, com.bytedance.android.live.revenuelink.multimsg.api.a<?, ?>> r104 = r103.f91873a;     // Catch: Throwable -> L16
        int r105 = e.f91874a;     // Catch: Throwable -> L16
        Exception r106 = new Exception("Task cancel");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r106, BaseHttpRequestInfo.KEY_EXCEPTION);     // Catch: Throwable -> L16
        e.b r107 = new e.b(r106);     // Catch: Throwable -> L16
        r104.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r107, "result");     // Catch: Throwable -> L16
        StateMachine.c(r104.f91864d, new TaskState.a.C1427a(r107));     // Catch: Throwable -> L16
    L18:
        r100.f91877a.unlock();
        return;
    L23:
        r100.f91879c.offer(r101);     // Catch: Exception -> L9 Throwable -> L16
    L16:
        th = move-exception;
        r100.f91877a.unlock();
        throw th;
    }
}
