package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AIKernelApi.kt", c = {ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM}, d = "invokeSuspend", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$updatePackage$2")
final class AIKernelApi$updatePackage$2 extends l implements b<d<? super n<? extends PackageResource>>, Object> {
    final /* synthetic */ PackageResource $business;
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$updatePackage$2(AIKernelApi r3, PackageResource r4, RequestParams r5, d<? super AIKernelApi$updatePackage$2> r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.$business = r4;
        this.$params = r5;
        super(1, r7);
    }

    @Override // d.c.b.a.a
    public final d<x> create(d<?> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AIKernelApi$updatePackage$2(this.this$0, this.$business, this.$params, r6), d.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super n<PackageResource>> r3) {
        return ((AIKernelApi$updatePackage$2) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), AIKernelApi$updatePackage$2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.h.a.b
    public /* synthetic */ Object invoke(d<? super n<? extends PackageResource>> r3) {
        return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r7) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r7);
        Object r6 = ((n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.aiagent.plugin")).a();
    L12:
        return n.g(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r7);
        AIKernelApi r8 = this.this$0;
        PackageResource r2 = this.$business;
        RequestParams r4 = this.$params;
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r6 = AIKernelApi.m399access$updatePackageInner0E7RQCE(r8, r2, r4, r3);
        if (r6 != r0) goto L12;
        return r0;
    }
}
