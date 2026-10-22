package com.bytedance.safetyguard.lxc.internal.service;

import android.os.IBinder;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.IPolicyResultCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.OutboundTargetParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
final class f implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IOutboundPolicyCallback f11010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IBinder f11011b;

    public f(IOutboundPolicyCallback r3) {
        IOutboundPolicyCallback r4 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "callback");
        this.f11010a = r4;
        this.f11011b = r4.asBinder();
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.o
    public boolean a() {
        if (this.f11011b.isBinderAlive() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f11011b.pingBinder() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.o
    public void a(IBinder.DeathRecipient r3) {
        IBinder.DeathRecipient r4 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "recipient");
        this.f11011b.linkToDeath(r4, 0);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.o
    public void b(IBinder.DeathRecipient r3) {
        IBinder.DeathRecipient r4 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "recipient");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        d.n.f(Boolean.valueOf(((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin")).f11011b.unlinkToDeath(r4, 0)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.o
    public void a(long r3, OutboundTargetParcel r5, IPolicyResultCallback r6) {
        IPolicyResultCallback r7 = (IPolicyResultCallback) ZeusTransformUtils.wrapperContextForParams(r6, IPolicyResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "target");
        d.h.b.o.e(r7, "callback");
        this.f11010a.evaluate(r3, r5, r7);
    }
}
