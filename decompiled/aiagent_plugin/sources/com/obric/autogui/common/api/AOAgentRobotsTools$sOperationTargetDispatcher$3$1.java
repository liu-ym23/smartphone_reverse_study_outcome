package com.obric.autogui.common.api;

import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.a;
import d.h.a.b;
import d.o;
import d.x;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AOSystemTools.kt", c = {EntityType.SIM_CARD}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$sOperationTargetDispatcher$3$1")
final class AOAgentRobotsTools$sOperationTargetDispatcher$3$1 extends l implements b<d<? super x>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ a<x> $retry;
    int label;

    AOAgentRobotsTools$sOperationTargetDispatcher$3$1(long r3, a<x> r5, d<? super AOAgentRobotsTools$sOperationTargetDispatcher$3$1> r6) {
        a<x> r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        this.$delayMillis = r3;
        this.$retry = r7;
        super(1, r8);
    }

    @Override // d.c.b.a.a
    public final d<x> create(d<?> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AOAgentRobotsTools$sOperationTargetDispatcher$3$1(this.$delayMillis, this.$retry, r6), d.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super x> r3) {
        return ((AOAgentRobotsTools$sOperationTargetDispatcher$3$1) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), AOAgentRobotsTools$sOperationTargetDispatcher$3$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.h.a.b
    public /* synthetic */ Object invoke(d<? super x> r3) {
        return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r7) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r7);
    L11:
        this.$retry.invoke();
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r7);
        AOThreadingTools r8 = AOThreadingTools.INSTANCE;
        long r3 = this.$delayMillis;
        d<? super x> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        if (r8.delayForMillis(r3, r2) != r0) goto L11;
        return r0;
    }
}
