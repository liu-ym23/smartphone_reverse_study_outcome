package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarResultParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class v implements SidecarOperation, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProxyServiceConnector f10077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SidecarDeviceFlowCallback f10078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f10079d;

    public v(String r3, ProxyServiceConnector r4, SidecarDeviceFlowCallback r5) {
        SidecarDeviceFlowCallback r6 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r5, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "operationId");
        d.h.b.o.e(r4, "connector");
        d.h.b.o.e(r6, "callback");
        this.f10076a = r3;
        this.f10077b = r4;
        this.f10078c = r6;
        this.f10079d = new AtomicBoolean(false);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SidecarOperation.DefaultImpls.close(this);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public String getOperationId() {
        return this.f10076a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.client.u
    public void a(String r3, int r4) {
        d.h.b.o.e(r3, "url");
        if (this.f10079d.get() == false) goto L10;
        return;
    L10:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        ((v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin")).f10078c.onVerificationUrl(r3, r4);     // Catch: Throwable -> L7
        d.n.f(x.f38692a);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.client.u
    public void a(SidecarResultParcel r14) {
        d.h.b.o.e(r14, "result");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        v r2 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r15 = d.n.f(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r14));     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r15) == null) goto L11;
        r15 = com.bytedance.safetyguard.lxc.internal.e.b.m.a(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a, WsConstants.KEY_SERVICE, "service_protocol_mismatch", 503, "invalid sidecar service result", null, null, null, null, 240, null);
    L11:
        a((SidecarResult) ZeusTransformUtils.preCheckCast(r15, SidecarResult.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
        goto L8
    }

    public final boolean a(SidecarResult r4) {
        d.h.b.o.e(r4, "result");
        if (this.f10079d.compareAndSet(false, true) == true) goto L10;
        return false;
    L10:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        ((v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin")).f10078c.onComplete(r4);     // Catch: Throwable -> L7
        d.n.f(x.f38692a);     // Catch: Throwable -> L7
    L9:
        return true;
    L7:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L9
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public boolean cancel() {
        if (this.f10079d.compareAndSet(false, true) == true) goto L5;
        return false;
    L5:
        this.f10077b.b(getOperationId());
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        ((v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin")).f10078c.onComplete(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h());     // Catch: Throwable -> L8
        d.n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        return true;
    L8:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }
}
