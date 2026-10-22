package com.obric.agent.trace.omni;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: PrivacyGrantAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p {
    private static final String TAG = "PrivacyGrantAuditLogger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f15699a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f15700b = null;

    private p() {
    }

    static {
        f15699a = new p();
        f15700b = new d();
    }

    public final void a(n r6) {
        if (r6 != null) goto L6;
        return;
    L6:
        if (f15700b.a(r6.a()) == true) goto L17;
        ISecureLogDepend.Companion.i(TAG, "PrivacyGrant audit ignored: duplicate messageId=" + r6.a());
        return;
    L17:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        p r5 = (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        ISecureLogDepend.Companion.i(TAG, "write PrivacyGrant audit, messageId=" + r6.a() + ", action=" + r6.b());     // Catch: Throwable -> L11
        AOAgentRobotsTools.INSTANCE.writeToolAuditLog((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), q.a(r6, "PrivacyGrant"));     // Catch: Throwable -> L11
        Object r7 = d.n.f(x.f38692a);     // Catch: Throwable -> L11
    L13:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L19;
        ISecureLogDepend.Companion.e(TAG, "write PrivacyGrant audit failed, messageId=" + r6.a() + ", action=" + r6.b(), r8);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L13
    }
}
