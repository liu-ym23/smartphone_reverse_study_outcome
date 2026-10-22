package com.obric.livecard.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.ILiveCard;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.h;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: IslandImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(b = "IslandImpl.kt", c = {386}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$getService$3$1")
final class IslandImpl$getService$3$1 extends l implements m<am, d<? super IIslandService>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ IslandImpl this$0;

    IslandImpl$getService$3$1(IslandImpl r3, d<? super IslandImpl$getService$3$1> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r2, d<?> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new IslandImpl$getService$3$1(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super IIslandService> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super IIslandService> r4) {
        return ((IslandImpl$getService$3$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), IslandImpl$getService$3$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r9) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IslandImpl r8 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$0, IslandImpl.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L16:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r9);
        final IslandImpl r10 = this.this$0;
        this.L$0 = r10;
        this.label = 1;
        kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")), 1);
        r4.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin");
        ServiceConnection r5 = new IslandImpl$getService$3$1$1$serviceConnection$1(r10, r2);
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        Intent r6 = new Intent();
        IslandImpl.access$setLiveCardComponentName(r10, (Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), r6);
        ZeusTransformUtils.bindService(r3, r6, (ServiceConnection) ZeusTransformUtils.preCheckCast(r5, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, "com.obric.aiagent.plugin");
    L11:
        r9 = r4.h();
        if (r9 != b.a()) goto L14;
        h.c((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
    L14:
        if (r9 != r0) goto L16;
        return r0;
    }
}
