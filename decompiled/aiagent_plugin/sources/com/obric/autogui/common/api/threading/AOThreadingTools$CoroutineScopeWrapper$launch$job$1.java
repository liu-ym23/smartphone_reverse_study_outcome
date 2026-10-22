package com.obric.autogui.common.api.threading;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AOThreadingTools.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AOThreadingTools.kt", c = {53}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingTools$CoroutineScopeWrapper$launch$job$1")
final class AOThreadingTools$CoroutineScopeWrapper$launch$job$1 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ b<d<? super x>, Object> $block;
    int label;

    AOThreadingTools$CoroutineScopeWrapper$launch$job$1(b<? super d<? super x>, ? extends Object> r3, d<? super AOThreadingTools$CoroutineScopeWrapper$launch$job$1> r4) {
        b<d<? super x>, Object> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.$block = r5;
        super(2, r6);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r2, d<?> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AOThreadingTools$CoroutineScopeWrapper$launch$job$1(this.$block, r4), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((AOThreadingTools$CoroutineScopeWrapper$launch$job$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AOThreadingTools$CoroutineScopeWrapper$launch$job$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r4) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r4);
    L12:
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r4);
        b<d<? super x>, Object> r5 = this.$block;
        this.label = 1;
        if (r5.invoke(this) != r0) goto L12;
        return r0;
    }
}
