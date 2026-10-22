package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.IPolicyResultCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.OutboundTargetParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.PolicyDecisionParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ProxyIpcClientMappers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocalPolicyCallback extends IOutboundPolicyCallback.Stub {
    private final OutboundPolicyEvaluator evaluator;
    private final Executor worker;

    public static /* synthetic */ void lambda$3pRwnRUBtKzs1cpLAaVjiIIkcHQ(LocalPolicyCallback r0, OutboundTargetParcel r1, IPolicyResultCallback r2, long r3) {
        evaluate$lambda$3(r0, r1, r2, r3);
    }

    public /* synthetic */ LocalPolicyCallback(OutboundPolicyEvaluator r2, Executor r3, int r4, d.h.b.h r5) {
        OutboundPolicyEvaluator r6 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r2, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = l.a();
    L5:
        this(r6, r7);
    }

    public LocalPolicyCallback(OutboundPolicyEvaluator r3, Executor r4) {
        OutboundPolicyEvaluator r5 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r3, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "evaluator");
        d.h.b.o.e(r6, "worker");
        this.evaluator = r5;
        this.worker = r6;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback
    public void evaluate(final long r10, final OutboundTargetParcel r12, IPolicyResultCallback r13) {
        final IPolicyResultCallback r14 = (IPolicyResultCallback) ZeusTransformUtils.wrapperContextForParams(r13, IPolicyResultCallback.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L5;
        return;
    L5:
        Runnable r1 = new $$Lambda$LocalPolicyCallback$3pRwnRUBtKzs1cpLAaVjiIIkcHQ(this, r12, r14, r10);
        d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L8
        ((LocalPolicyCallback) ZeusTransformUtils.preCheckCast(this, LocalPolicyCallback.class, "com.obric.aiagent.plugin")).worker.execute(r1);     // Catch: Throwable -> L8
        Object r16 = d.n.f(x.f38692a);     // Catch: Throwable -> L8
    L11:
        if (d.n.c(r16) == null) goto L21;
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L14
        LocalPolicyCallback r9 = (LocalPolicyCallback) ZeusTransformUtils.preCheckCast(this, LocalPolicyCallback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r14.onResult(r10, l.b());     // Catch: Throwable -> L14
        d.n.f(x.f38692a);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L21:
        return;
    L8:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L11
    }

    private static final void evaluate$lambda$3(LocalPolicyCallback r2, OutboundTargetParcel r3, IPolicyResultCallback r4, long r5) {
        IPolicyResultCallback r6 = (IPolicyResultCallback) ZeusTransformUtils.wrapperContextForParams(r4, IPolicyResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "this$0");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r3);     // Catch: Throwable -> L8
        OutboundPolicyEvaluator r7 = r2.evaluator;     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        PolicyDecisionParcel r8 = l.a(r7.evaluate(l.a(r3)));     // Catch: Throwable -> L8
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r8);     // Catch: Throwable -> L8
        Object r9 = d.n.f(r8);     // Catch: Throwable -> L8
    L11:
        if (d.n.c(r9) == null) goto L14;
        r9 = l.b();
    L14:
        PolicyDecisionParcel r10 = (PolicyDecisionParcel) ZeusTransformUtils.preCheckCast(r9, PolicyDecisionParcel.class, "com.obric.aiagent.plugin");
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L17
        r6.onResult(r5, r10);     // Catch: Throwable -> L17
        d.n.f(x.f38692a);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L11
    }
}
