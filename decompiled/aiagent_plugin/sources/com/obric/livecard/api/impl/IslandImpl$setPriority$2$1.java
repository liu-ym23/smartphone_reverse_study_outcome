package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.o;
import d.x;

/* JADX INFO: compiled from: IslandImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(b = "IslandImpl.kt", c = {185}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$setPriority$2$1")
final class IslandImpl$setPriority$2$1 extends l implements b<d<? super x>, Object> {
    final /* synthetic */ IslandSession $session;
    int label;
    final /* synthetic */ IslandImpl this$0;

    IslandImpl$setPriority$2$1(IslandImpl r3, IslandSession r4, d<? super IslandImpl$setPriority$2$1> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.$session = r4;
        super(1, r6);
    }

    @Override // d.c.b.a.a
    public final d<x> create(d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new IslandImpl$setPriority$2$1(this.this$0, this.$session, r5), d.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super x> r3) {
        return ((IslandImpl$setPriority$2$1) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), IslandImpl$setPriority$2$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.h.a.b
    public /* synthetic */ Object invoke(d<? super x> r3) {
        return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r5) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r5);
    L11:
        IIslandService r6 = (IIslandService) ZeusTransformUtils.preCheckCast(r5, IIslandService.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L15;
        r6.setPriority(this.$session);
    L15:
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r5);
        IslandImpl r7 = this.this$0;
        d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r5 = r7.getService(r2);
        if (r5 != r0) goto L11;
        return r0;
    }
}
