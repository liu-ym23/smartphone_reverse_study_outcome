package com.obric.autogui.session.state;

import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "AO-OperationState";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f31397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f31398b = null;

    /* JADX INFO: renamed from: lambda$-XcuRh_krKa3DW4f2TMRe8tfpn8, reason: not valid java name */
    public static /* synthetic */ x m902lambda$XcuRh_krKa3DW4f2TMRe8tfpn8(String r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$vF6xpPbR6JFJt2dT0ats0xG7iwE(String r0) {
        return c(r0);
    }

    private e() {
    }

    static {
        f31397a = new e();
        f31398b = new f($$Lambda$e$XcuRh_krKa3DW4f2TMRe8tfpn8.INSTANCE, $$Lambda$e$vF6xpPbR6JFJt2dT0ats0xG7iwE.INSTANCE);
    }

    private static final x b(String r3) {
        Loog r0 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("desired target changed: ");
        if (r3 != null) goto L5;
        String r2 = "<none>";
    L6:
        r0.i(TAG, r1.append(r2).toString());
        AOAgentRobotsTools.INSTANCE.updateOperationTarget(r3);
        return x.f38692a;
    L5:
        r2 = r3;
        goto L6
    }

    private static final boolean c(String r1) {
        o.e(r1, "sessionKey");
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 == null) goto L5;
        String r2 = r0.a();
    L7:
        return o.a(r2, r1);
    L5:
        r2 = null;
        goto L7
    }

    public final void a(String r1, BizStatus r2) {
        o.e(r1, "sessionKey");
        o.e(r2, "status");
        f31398b.a(r1, r2);
    }

    public final void a(String r1, String r2) {
        o.e(r1, "sessionKey");
        f31398b.a(r1, r2);
    }

    public final void a(String r1) {
        o.e(r1, "sessionKey");
        f31398b.a(r1);
    }
}
