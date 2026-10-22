package com.obric.autogui.common.api.threading;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AOThreadingTools.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AOThreadingTools.kt", c = {220}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingTools$launchIOJob$job$1")
final class AOThreadingTools$launchIOJob$job$1 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ m<am, d<? super x>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    AOThreadingTools$launchIOJob$job$1(m<? super am, ? super d<? super x>, ? extends Object> r3, d<? super AOThreadingTools$launchIOJob$job$1> r4) {
        m<am, d<? super x>, Object> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.$block = r5;
        super(2, r6);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        AOThreadingTools$launchIOJob$job$1 r0 = new AOThreadingTools$launchIOJob$job$1(this.$block, r5);
        r0.L$0 = r3;
        return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((AOThreadingTools$launchIOJob$job$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AOThreadingTools$launchIOJob$job$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r5) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r5);
    L12:
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r5);
        am r6 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
        m<am, d<? super x>, Object> r2 = this.$block;
        this.label = 1;
        if (r2.invoke(r6, this) != r0) goto L12;
        return r0;
    }
}
