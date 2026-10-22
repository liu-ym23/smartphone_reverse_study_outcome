package com.obric.aikernel.phx.core.api;

import com.obric.aikernel.AIKBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: ScriptBizApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "ScriptBizApi.kt", c = {81}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.ScriptBizApi$close$1$1")
final class ScriptBizApi$close$1$1 extends l implements m<am, d<? super x>, Object> {
    int label;
    final /* synthetic */ ScriptBizApi this$0;

    ScriptBizApi$close$1$1(ScriptBizApi r3, d<? super ScriptBizApi$close$1$1> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r2, d<?> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new ScriptBizApi$close$1$1(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((ScriptBizApi$close$1$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), ScriptBizApi$close$1$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r7) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r7);
    L12:
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r7);
        ScriptBizApi r8 = this.this$0;
        AIKBinder r2 = ScriptBizApi.access$getRemote$p(r8);
        String r3 = this.this$0.getBizName();
        d<? super x> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        if (r8.unload(r2, r3, r4) != r0) goto L12;
        return r0;
    }
}
