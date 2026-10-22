package com.bytedance.android.livesdk.performance.battery;

import android.content.Context;
import android.os.BatteryManager;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePerformancePowerHelper f154472a;

    public b(LivePerformancePowerHelper r100) {
        this.f154472a = r100;
    }

    public final void a() {
        LivePerformancePowerHelper r100 = this.f154472a;
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L29
        rn2.a r102 = r100.f154467b;     // Catch: Throwable -> L29
        r102.f538668h = System.currentTimeMillis();     // Catch: Throwable -> L29
        rn2.a r103 = r100.f154467b;     // Catch: Throwable -> L29
        r103.f538665e = com.bytedance.android.livesdk.performance.b.d(s1.getContext());     // Catch: Throwable -> L29
        rn2.a r104 = r100.f154467b;     // Catch: Throwable -> L29
        Context r105 = s1.getContext();     // Catch: Throwable -> L29
        boolean r106 = true;
        long r107 = -1;
        if (com.bytedance.android.livesdk.performance.b.a(r105) == false) goto L12;
        BatteryManager r108 = com.bytedance.android.livesdk.performance.b.b(r105);     // Catch: Exception -> L32 Throwable -> L29
        if (r108 == null) goto L12;
        r107 = r108.getLongProperty(1);     // Catch: Exception -> L32 Throwable -> L29
    L12:
        r104.f538666f = r107;     // Catch: Throwable -> L29
        rn2.a r109 = r100.f154467b;     // Catch: Throwable -> L29
        r109.f538661a = r100.f154466a;     // Catch: Throwable -> L29
        if (r109.f538669i == false) goto L15;
    L27:
        int r110 = sn2.a.f542650a;     // Catch: Throwable -> L29
        sn2.a.a(r100.f154467b);     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L15:
        if (LivePerformancePowerHelper.f154465f == false) goto L17;
        boolean r111 = LivePerformancePowerHelper.f154465f;     // Catch: Throwable -> L29
    L26:
        r109.f538669i = r111;     // Catch: Throwable -> L29
        goto L27
    L17:
        int r112 = com.bytedance.android.livesdk.performance.b.c(s1.getContext());     // Catch: Throwable -> L29
        if (r112 != 2) goto L20;
    L25:
        r111 = r106;
        goto L26
    L20:
        if (r112 == 4) goto L25;
        if (r112 == 5) goto L25;
        r106 = false;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
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
