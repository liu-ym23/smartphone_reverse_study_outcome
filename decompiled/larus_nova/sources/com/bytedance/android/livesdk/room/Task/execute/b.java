package com.bytedance.android.livesdk.room.Task.execute;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdk.room.Task.base.LiveTask;
import com.bytedance.common.jato.Jato;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f157602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.room.Task.base.b f157603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveTask f157604c;

    public final void a() {
        this.f157604c.getClass();
        if (this.f157603b.f157576k == true) goto L23;
        LiveTask r100 = this.f157604c;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (r100.f157555a != null) goto L9;
        r100.f157555a = new CountDownLatch(r100.f().size());     // Catch: Throwable -> L20
    L9:
        monitor-exit(r100);
        if (r100.f157558d <= 0) goto L16;
        CountDownLatch r101 = r100.f157555a;
        if (r101 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("countDownLatch");
    L15:
        r101.await(r100.f157558d, TimeUnit.MILLISECONDS);
        goto L23
    L16:
        CountDownLatch r102 = r100.f157555a;
        if (r102 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("countDownLatch");
    L19:
        r102.await();
    L23:
        this.f157604c.e();
        long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L26 Exception -> L28
        b();     // Catch: Throwable -> L26 Exception -> L28
        long r104 = SystemClock.elapsedRealtime() - r103;     // Catch: Throwable -> L26 Exception -> L28
        this.f157603b.b(this.f157604c.taskID(), r104);     // Catch: Throwable -> L26 Exception -> L28
        this.f157604c.a();     // Catch: Throwable -> L26 Exception -> L28
    L31:
        this.f157603b.c(this.f157604c);
        return;
    L28:
        e = move-exception;
        this.f157604c.b(e);     // Catch: Throwable -> L26
        int r105 = hs2.b.f486950a;     // Catch: Throwable -> L26
        hs2.b.b(Log.getStackTraceString(e));     // Catch: Throwable -> L26
        int r106 = ps2.d.f530436a;     // Catch: Throwable -> L26
        ps2.d.b(e, "3", null, this.f157604c.taskID(), null, null);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.f157603b.c(this.f157604c);
        throw th;
    }

    public final void b() {
        long r100 = ThreadMethodProxy.currentThread().getId();
        if (this.f157602a == true) goto L5;
    L12:
        boolean r101 = false;
    L13:
        this.f157604c.run();
        if (r101 == false) goto L17;
        Jato.resetCoreBind((int) r100);
        Jato.releaseBoost();
        return;
    L17:
        return;
    L5:
        if (Jato.isInited() == false) goto L12;
        r101 = true;
        if (this.f157604c.d() != LiveTaskType.BOOT) goto L10;
        Jato.bindBigCore((int) r100);
        Jato.tryCpuBoost(500);
        goto L13
    L10:
        if (this.f157604c.d() != LiveTaskType.POST) goto L12;
        Jato.bindLittleCore((int) r100);
        goto L13
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

    public b(com.bytedance.android.livesdk.room.Task.base.b r100, LiveTask r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "task");
        this.f157603b = r100;
        this.f157604c = r101;
        if (fs2.c.a().b() == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f157602a = r102;
        return;
    L5:
        if (fs2.c.a().c() == false) goto L7;
        r102 = true;
        goto L8
    }
}
