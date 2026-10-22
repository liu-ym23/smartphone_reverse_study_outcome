package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: IslandImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(b = "IslandImpl.kt", c = {113}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$updateAnimation$2$1")
final class IslandImpl$updateAnimation$2$1 extends l implements b<d<? super x>, Object> {
    final /* synthetic */ d<x> $continuation;
    final /* synthetic */ IslandSession $targetSession;
    final /* synthetic */ IslandWidget $targetWidget;
    int label;
    final /* synthetic */ IslandImpl this$0;

    IslandImpl$updateAnimation$2$1(IslandImpl r3, IslandSession r4, IslandWidget r5, d<? super x> r6, d<? super IslandImpl$updateAnimation$2$1> r7) {
        d<x> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.$targetSession = r4;
        this.$targetWidget = r5;
        this.$continuation = r8;
        super(1, r9);
    }

    @Override // d.c.b.a.a
    public final d<x> create(d<?> r9) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new IslandImpl$updateAnimation$2$1(this.this$0, this.$targetSession, this.$targetWidget, this.$continuation, r7), d.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super x> r3) {
        return ((IslandImpl$updateAnimation$2$1) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), IslandImpl$updateAnimation$2$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
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
        if (r6 == null) goto L14;
        r6.updateWidgetAnimation(this.$targetSession, this.$targetWidget);
    L14:
        d<x> r4 = this.$continuation;
        n.a r7 = n.f38560a;
        r4.resumeWith(n.f(x.f38692a));
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r5);
        IslandImpl r8 = this.this$0;
        d<? super IIslandService> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r5 = r8.getService(r2);
        if (r5 != r0) goto L11;
        return r0;
    }
}
