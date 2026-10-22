package com.obric.aikernel.phx.core.api;

import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: CloudBizApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "CloudBizApi.kt", c = {45}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$binder$1")
final class CloudBizApi$inferenceAsFlow$binder$1 extends l implements m<i<? super Response<Object>>, d<? super x>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    CloudBizApi$inferenceAsFlow$binder$1(d<? super CloudBizApi$inferenceAsFlow$binder$1> r3) {
        super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r2, d<?> r3) {
        CloudBizApi$inferenceAsFlow$binder$1 r4 = new CloudBizApi$inferenceAsFlow$binder$1((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        r4.L$0 = r2;
        return (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(i<? super Response<Object>> r3, d<? super x> r4) {
        return invoke2((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(i<? super Response<Object>> r3, d<? super x> r4) {
        return ((CloudBizApi$inferenceAsFlow$binder$1) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), CloudBizApi$inferenceAsFlow$binder$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r15) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r15);
    L12:
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r15);
        i r16 = (i) ZeusTransformUtils.preCheckCast(this.L$0, i.class, "com.obric.aiagent.plugin");
        Response r2 = new Response(102, null, null, false, false, null, null, 126, null);
        d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        if (r16.emit(r2, r3) != r0) goto L12;
        return r0;
    }
}
