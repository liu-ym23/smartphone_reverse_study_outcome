package com.bytedance.android.livesdk.performance.battery;

import android.content.Context;
import android.os.BatteryManager;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePerformancePowerHelper f154471a;

    public a(LivePerformancePowerHelper r100) {
        this.f154471a = r100;
    }

    public final void a() {
        LivePerformancePowerHelper r100 = this.f154471a;
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L36
        rn2.a r102 = new rn2.a();     // Catch: Throwable -> L36
        r100.f154467b = r102;     // Catch: Throwable -> L36
        r102.f538667g = System.currentTimeMillis();     // Catch: Throwable -> L36
        rn2.a r103 = r100.f154467b;     // Catch: Throwable -> L36
        Context r104 = s1.getContext();     // Catch: Throwable -> L36
        if (com.bytedance.android.livesdk.performance.b.a(r104) == false) goto L13;
        BatteryManager r105 = com.bytedance.android.livesdk.performance.b.b(r104);     // Catch: Exception -> L40 Throwable -> L36
        if (r105 == null) goto L13;
        int r106 = r105.getIntProperty(4);     // Catch: Exception -> L40 Throwable -> L36
    L14:
        r103.f538664d = r106;     // Catch: Throwable -> L36
        rn2.a r107 = r100.f154467b;     // Catch: Throwable -> L36
        Context r108 = s1.getContext();     // Catch: Throwable -> L36
        boolean r109 = true;
        long r110 = -1;
        if (com.bytedance.android.livesdk.performance.b.a(r108) == false) goto L23;
        BatteryManager r111 = com.bytedance.android.livesdk.performance.b.b(r108);     // Catch: Exception -> L39 Throwable -> L36
        if (r111 == null) goto L23;
        r110 = r111.getLongProperty(1);     // Catch: Exception -> L39 Throwable -> L36
    L23:
        r107.f538663c = r110;     // Catch: Throwable -> L36
        rn2.a r112 = r100.f154467b;     // Catch: Throwable -> L36
        r112.f538662b = com.bytedance.android.livesdk.performance.b.d(s1.getContext());     // Catch: Throwable -> L36
        rn2.a r113 = r100.f154467b;     // Catch: Throwable -> L36
        if (LivePerformancePowerHelper.f154465f == false) goto L26;
        boolean r114 = LivePerformancePowerHelper.f154465f;     // Catch: Throwable -> L36
    L34:
        r113.f538669i = r114;     // Catch: Throwable -> L36
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
        return;
    L26:
        int r115 = com.bytedance.android.livesdk.performance.b.c(s1.getContext());     // Catch: Throwable -> L36
        if (r115 == 2) goto L33;
        if (r115 == 4) goto L33;
        if (r115 == 5) goto L33;
        r109 = false;
    L33:
        r114 = r109;
    L13:
        r106 = -1;
    L36:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
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
