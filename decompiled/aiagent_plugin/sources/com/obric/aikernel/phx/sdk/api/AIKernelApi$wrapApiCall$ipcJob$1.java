package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AIKernelApi.kt", c = {336, 337}, d = "invokeSuspend", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$ipcJob$1")
final class AIKernelApi$wrapApiCall$ipcJob$1<T> extends l implements m<am, d<? super T>, Object> {
    final /* synthetic */ b<d<? super T>, Object> $block;
    final /* synthetic */ RequestParams $params;
    Object L$0;
    int label;

    AIKernelApi$wrapApiCall$ipcJob$1(RequestParams r3, b<? super d<? super T>, ? extends Object> r4, d<? super AIKernelApi$wrapApiCall$ipcJob$1> r5) {
        b<d<? super T>, Object> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        this.$params = r3;
        this.$block = r6;
        super(2, r7);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$ipcJob$1(this.$params, this.$block, r5), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, Object r4) {
        return invoke((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    public final Object invoke(am r3, d<? super T> r4) {
        return ((AIKernelApi$wrapApiCall$ipcJob$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AIKernelApi$wrapApiCall$ipcJob$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r7) {
        Object r0 = d.c.a.b.a();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        o.a(r7);     // Catch: Throwable -> L22
    L20:
        Object r6 = n.f(r7);     // Catch: Throwable -> L22
    L24:
        Throwable r8 = n.c(r6);
        if (r8 == null) goto L28;
        AIKLog.INSTANCE.w(AIKernelApi.TAG, "asyncTransact got exception: " + r8);
    L28:
        if (n.b(r6) == false) goto L31;
        return null;
    L31:
        return r6;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        b<d<? super T>, Object> r2 = (b) ZeusTransformUtils.preCheckCast(this.L$0, b.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L22
    L17:
        this.L$0 = null;     // Catch: Throwable -> L22
        this.label = 2;     // Catch: Throwable -> L22
        r7 = r2.invoke(this);     // Catch: Throwable -> L22
        if (r7 != r0) goto L20;
        return r0;
    L13:
        o.a(r7);
        RequestParams r9 = this.$params;
        r2 = this.$block;
        n.a r5 = n.f38560a;     // Catch: Throwable -> L22
        ParamsCompat r10 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L22
        this.L$0 = r2;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        if (r10.startCompat(r9, this) != r0) goto L17;
        return r0;
    L22:
        th = move-exception;
        n.a r11 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L24
    }
}
