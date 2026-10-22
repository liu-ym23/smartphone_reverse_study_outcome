package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SidecarDeviceFlowCallback f10701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f10702b;

    public j(SidecarDeviceFlowCallback r3) {
        SidecarDeviceFlowCallback r4 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r3, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        o.e(r4, "callback");
        this.f10701a = r4;
        this.f10702b = new AtomicBoolean(false);
    }

    public final void a(String r3, int r4) {
        o.e(r3, "url");
        if (this.f10702b.get() == false) goto L10;
        return;
    L10:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        ((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin")).f10701a.onVerificationUrl(r3, r4);     // Catch: Throwable -> L7
        d.n.f(x.f38692a);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    public final boolean a(SidecarResult r4) {
        o.e(r4, "result");
        if (this.f10702b.compareAndSet(false, true) == true) goto L10;
        return false;
    L10:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        ((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin")).f10701a.onComplete(r4);     // Catch: Throwable -> L7
        d.n.f(x.f38692a);     // Catch: Throwable -> L7
    L9:
        return true;
    L7:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L9
    }
}
