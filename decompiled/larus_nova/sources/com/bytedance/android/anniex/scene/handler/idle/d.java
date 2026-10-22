package com.bytedance.android.anniex.scene.handler.idle;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<?> f41215a;

    public d(c<?> r100) {
        this.f41215a = r100;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        h r101 = h.f41220a;
        h.b(this.f41215a, TaskStatus.RUNNING);
        c<?> r102 = this.f41215a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.android.anniex.scene.handler.idle.IdleTask<kotlin.Any>");     // Catch: Throwable -> L5
        r102.a(this.f41215a.getContext());     // Catch: Throwable -> L5
        boolean r103 = true;
    L7:
        long r104 = System.currentTimeMillis() - r100;
        h r105 = h.f41220a;
        c<?> r106 = this.f41215a;
        if (r103 == false) goto L10;
        TaskStatus r107 = TaskStatus.SUCCESS;
    L11:
        h.b(r106, r107);
        HybridLogger r108 = HybridLogger.f246343a;
        HybridLogger.f("IdleTaskQueue", "[Parallel] " + this.f41215a.f41199b + '-' + this.f41215a.f41198a + " duration=" + r104 + "ms", null, 12);
        return;
    L10:
        r107 = TaskStatus.FAILED;
    L5:
        th = move-exception;
        String r109 = this.f41215a.f41198a;
        th.getMessage();
        r103 = false;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
