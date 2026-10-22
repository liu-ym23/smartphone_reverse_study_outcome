package com.obric.agent;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: ObricService.kt */
/* JADX INFO: loaded from: classes2.dex */
@d.c.b.a.f(b = "ObricService.kt", c = {500, 501}, d = "invokeSuspend", e = "com.obric.agent.ObricService$dispatchIMAction$1$5$1$1$1")
final class ObricService$dispatchIMAction$1$5$1$1$1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {
    int label;

    ObricService$dispatchIMAction$1$5$1$1$1(d.c.d<? super ObricService$dispatchIMAction$1$5$1$1$1> r3) {
        super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
        return (d.c.d) ZeusTransformUtils.preCheckCast(new ObricService$dispatchIMAction$1$5$1$1$1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d.c.d<? super d.x> r4) {
        return ((ObricService$dispatchIMAction$1$5$1$1$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ObricService$dispatchIMAction$1$5$1$1$1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r8) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        d.o.a(r8);
    L19:
        return d.x.f38692a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        d.o.a(r8);
    L13:
        IAgentService r9 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L19;
        d.c.d<? super d.x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
        this.label = 2;
        if (r9.updateShortCutTasks(r2) != r0) goto L19;
        return r0;
    L10:
        d.o.a(r8);
        d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        if (ax.a(500, r10) != r0) goto L13;
        return r0;
    }
}
