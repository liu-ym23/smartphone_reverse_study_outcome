package com.obric.agent;

import com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: ObricService.kt */
/* JADX INFO: loaded from: classes2.dex */
@d.c.b.a.f(b = "ObricService.kt", c = {2232}, d = "invokeSuspend", e = "com.obric.agent.ObricService$awaitSemanticEditResult$result$1")
final class ObricService$awaitSemanticEditResult$result$1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {
    final /* synthetic */ d.h.a.b<IFlowSemanticEditCallbackIDL, d.x> $block;
    Object L$0;
    int label;

    ObricService$awaitSemanticEditResult$result$1(d.h.a.b<? super IFlowSemanticEditCallbackIDL, d.x> r3, d.c.d<? super ObricService$awaitSemanticEditResult$result$1> r4) {
        d.h.a.b<IFlowSemanticEditCallbackIDL, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        this.$block = r5;
        super(2, r6);
    }

    @Override // d.c.b.a.a
    public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return (d.c.d) ZeusTransformUtils.preCheckCast(new ObricService$awaitSemanticEditResult$result$1(this.$block, r4), d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d.c.d<? super Integer> r4) {
        return ((ObricService$awaitSemanticEditResult$result$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ObricService$awaitSemanticEditResult$result$1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r6) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(this.L$0, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L13:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        d.o.a(r6);
        d.h.a.b<IFlowSemanticEditCallbackIDL, d.x> r7 = this.$block;
        this.L$0 = r7;
        this.label = 1;
        kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r4.e();
        final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r7.invoke(new ObricService$awaitSemanticEditResult$result$1$1$callback$1(r2));
        r6 = r4.h();
        if (r6 != d.c.a.b.a()) goto L11;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
    L11:
        if (r6 != r0) goto L13;
        return r0;
    }
}
