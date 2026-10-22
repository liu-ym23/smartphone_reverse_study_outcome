package com.bytedance.android.anniex.scene.handler.idle;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<?> f41217a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f41218a = null;

        static {
            f41218a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.f41220a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(c<?> r100) {
        this.f41217a = r100;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        h r101 = h.f41220a;
        h.b(this.f41217a, TaskStatus.RUNNING);
        boolean r102 = true;
        c<?> r103 = this.f41217a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.android.anniex.scene.handler.idle.IdleTask<kotlin.Any>");     // Catch: Throwable -> L5
        r103.a(this.f41217a.getContext());     // Catch: Throwable -> L5
        boolean r104 = true;
    L7:
        long r105 = System.currentTimeMillis() - r100;
        h r106 = h.f41220a;
        c<?> r107 = this.f41217a;
        if (r104 == false) goto L10;
        TaskStatus r108 = TaskStatus.SUCCESS;
    L11:
        h.b(r107, r108);
        HybridLogger r109 = HybridLogger.f246343a;
        Long r110 = null;
        HybridLogger.f("IdleTaskQueue", "[Serial] " + this.f41217a.f41199b + '-' + this.f41217a.f41198a + " duration=" + r105 + "ms", null, 12);
        h.f41225f.set(false);
        Long r111 = Long.valueOf(this.f41217a.f41203f);
        if (r111.longValue() > 0) goto L15;
        r102 = false;
    L15:
        if (r102 == false) goto L17;
        r110 = r111;
    L17:
        if (r110 == null) goto L19;
        long r112 = r110.longValue();
    L20:
        h.f41223d.schedule(a.f41218a, r112, TimeUnit.MILLISECONDS);
        return;
    L19:
        r112 = 1000;
        goto L20
    L10:
        r108 = TaskStatus.FAILED;
    L5:
        th = move-exception;
        String r113 = this.f41217a.f41198a;
        th.getMessage();
        r104 = false;
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
