package com.obric.aikernel.phx.sdk.api;

import android.os.IBinder;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AIKernelApi.kt", c = {}, d = "invokeSuspend", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$2$1$1")
final class AIKernelApi$wrapApiCall$2$1$1 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ AIKBinder $binder;
    final /* synthetic */ Throwable $cause;
    final /* synthetic */ int $event;
    final /* synthetic */ RequestParams $params;
    int label;

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    static final class AnonymousClass1 extends p implements b<RequestParams, x> {
        final /* synthetic */ RequestParams $params;

        AnonymousClass1(RequestParams r1) {
            this.$params = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(RequestParams r3) {
            invoke2((RequestParams) ZeusTransformUtils.preCheckCast(r3, RequestParams.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RequestParams r6) {
            o.e(r6, "$this$$receiver");
            r6.getBackend().putLong(IdlKeys.Args_ReqTime, this.$params.getBackend().getLong(IdlKeys.Args_ReqTime));
            r6.getBackend().putString(IdlKeys.Args_TraceId, this.$params.getBackend().getString(IdlKeys.Args_TraceId));
        }
    }

    AIKernelApi$wrapApiCall$2$1$1(RequestParams r3, int r4, Throwable r5, AIKBinder r6, d<? super AIKernelApi$wrapApiCall$2$1$1> r7) {
        AIKBinder r8 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r6, AIKBinder.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        this.$params = r3;
        this.$event = r4;
        this.$cause = r5;
        this.$binder = r8;
        super(2, r9);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r8, d<?> r9) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$2$1$1(this.$params, this.$event, this.$cause, this.$binder, r6), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((AIKernelApi$wrapApiCall$2$1$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AIKernelApi$wrapApiCall$2$1$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r6) {
        d.c.a.b.a();
        if (this.label != 0) goto L7;
        d.o.a(r6);
        AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] client req " + this.$params.getTraceIdStr() + " competed by event " + this.$event + " cause: " + this.$cause);
        com.obric.aikernel.core.b r7 = com.obric.aikernel.core.b.f22353a;
        IBinder r0 = this.$binder.asBinder();
        o.c(r0, "binder.asBinder()");
        r7.a(r0, new RequestParams(null, (b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$params), b.class, "com.obric.aiagent.plugin"), 1, null), this.$event);
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
