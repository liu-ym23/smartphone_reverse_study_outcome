package com.bytedance.ai.model;

import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class o implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.n f36891a;

    public /* synthetic */ o(com.bytedance.ai.applet.app.foundation.performance.n r100) {
        this.f36891a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        com.bytedance.ai.applet.app.foundation.performance.n r100 = this.f36891a;
        AtomicInteger r101 = AppletRuntime.f36716x;
        if (r100 == null) goto L26;
        long r102 = System.currentTimeMillis();
        Object r103 = r100.f34342d;
        monitor-enter(r103);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (r100.a(r102) == true) goto L9;
    L13:
        com.bytedance.ai.applet.app.foundation.performance.f.c r104 = null;
    L14:
        com.bytedance.ai.applet.app.foundation.performance.f.c r105 = r104;
        monitor-exit(r103);
        if (r105 != null) goto L19;
        com.bytedance.ai.applet.app.foundation.performance.c r106 = r100.f34339a;
        String r107 = "invalid, duplicate, or closed trace: " + r100.f34341c;
        r106.getClass();
        com.bytedance.ai.applet.app.foundation.performance.c.k("completeEvaluateScript", r107);
        goto L26
    L19:
        if (com.bytedance.ai.applet.app.foundation.performance.k.d(r100, AppletPerformanceOutcome.SUCCESS, r102, AppletPerformanceErrorCode.SUCCESS, null, 8) == false) goto L26;
        r100.f34339a.j(r105);
        goto L26
    L9:
        if (r100.f34360i == true) goto L13;
        r100.f34360i = true;     // Catch: Throwable -> L22
        long r108 = r100.f34340b;     // Catch: Throwable -> L22
        r104 = new com.bytedance.ai.applet.app.foundation.performance.f.c(r108, r102 - r108, new com.bytedance.ai.applet.app.foundation.performance.g.b(r100.f34341c), r100.f34359h);     // Catch: Throwable -> L22
    L26:
        return Unit.INSTANCE;
    }
}
