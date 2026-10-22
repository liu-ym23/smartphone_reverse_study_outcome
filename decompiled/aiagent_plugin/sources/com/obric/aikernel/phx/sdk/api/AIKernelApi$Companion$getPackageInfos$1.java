package com.obric.aikernel.phx.sdk.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.n;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AIKernelApi.kt", c = {393, 521}, d = "getPackageInfos-BWLJW6A", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion")
final class AIKernelApi$Companion$getPackageInfos$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi.Companion this$0;

    AIKernelApi$Companion$getPackageInfos$1(AIKernelApi.Companion r3, d.c.d<? super AIKernelApi$Companion$getPackageInfos$1> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        Object r2 = this.this$0.m405getPackageInfosBWLJW6A(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        if (r2 != b.a()) goto L6;
        return r2;
    L6:
        return n.g(r2);
    }
}
