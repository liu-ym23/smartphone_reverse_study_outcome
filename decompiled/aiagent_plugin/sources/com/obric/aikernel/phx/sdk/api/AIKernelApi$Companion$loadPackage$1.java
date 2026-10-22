package com.obric.aikernel.phx.sdk.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AIKernelApi.kt", c = {477, 518}, d = "loadPackage$sdk_release", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion")
final class AIKernelApi$Companion$loadPackage$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi.Companion this$0;

    AIKernelApi$Companion$loadPackage$1(AIKernelApi.Companion r3, d.c.d<? super AIKernelApi$Companion$loadPackage$1> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadPackage$sdk_release(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
    }
}
