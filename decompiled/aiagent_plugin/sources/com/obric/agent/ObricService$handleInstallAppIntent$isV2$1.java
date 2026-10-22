package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: ObricService.kt */
/* JADX INFO: loaded from: classes2.dex */
@d.c.b.a.f(b = "ObricService.kt", c = {1107}, d = "invokeSuspend", e = "com.obric.agent.ObricService$handleInstallAppIntent$isV2$1")
final class ObricService$handleInstallAppIntent$isV2$1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {
    final /* synthetic */ String $actionName;
    int label;

    ObricService$handleInstallAppIntent$isV2$1(String r3, d.c.d<? super ObricService$handleInstallAppIntent$isV2$1> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        this.$actionName = r3;
        super(2, r5);
    }

    @Override // d.c.b.a.a
    public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return (d.c.d) ZeusTransformUtils.preCheckCast(new ObricService$handleInstallAppIntent$isV2$1(this.$actionName, r4), d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d.c.d<? super Boolean> r4) {
        return ((ObricService$handleInstallAppIntent$isV2$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ObricService$handleInstallAppIntent$isV2$1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r6) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        d.o.a(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        d.o.a(r6);
        com.obric.capability.schedulekit.a r7 = com.obric.capability.schedulekit.a.f31846a;
        String r2 = this.$actionName;
        d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r6 = r7.c(r2, r3);
        if (r6 != r0) goto L11;
        return r0;
    }
}
