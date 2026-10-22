package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.AIKListener;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.a;
import d.h.a.m;
import d.h.b.h;
import d.h.b.p;
import d.h.b.z;
import d.o;
import d.x;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.t;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AbsApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsApi implements IBaseModel {
    public static final Companion Companion = null;
    private static final String TAG = "AbsApi";

    /* JADX INFO: compiled from: AbsApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: AbsApi.kt */
    @f(b = "AbsApi.kt", c = {44}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1")
    static final class AnonymousClass1 extends l implements m<q<? super Bundle>, d<? super x>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ AIKBinder $binder;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AbsApi this$0;

        /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AbsApi.kt */
        static final class C04861 extends p implements a<x> {
            final /* synthetic */ ca $monitorTask;

            C04861(ca r3) {
                this.$monitorTask = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
                super(0);
            }

            @Override // d.h.a.a
            public /* bridge */ /* synthetic */ x invoke() {
                invoke2();
                return x.f38692a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ca r2 = this.$monitorTask;
                if (r2 == null) goto L6;
                ca.a.a(r2, null, 1, null);
                return;
            }
        }

        AnonymousClass1(AIKBinder r3, AbsApi r4, Bundle r5, d<? super AnonymousClass1> r6) {
            AIKBinder r7 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r3, AIKBinder.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$binder = r7;
            this.this$0 = r4;
            this.$args = r5;
            super(2, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r5, d<?> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$binder, this.this$0, this.$args, r7);
            r0.L$0 = r5;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(q<? super Bundle> r3, d<? super x> r4) {
            return invoke2((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(q<? super Bundle> r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            q r10 = (q) ZeusTransformUtils.preCheckCast(this.L$0, q.class, "com.obric.aiagent.plugin");
            AIKLog.INSTANCE.i(AbsApi.TAG, "start callModelAsFlow...");
            ca r2 = BinderMonitor.INSTANCE.monitorTransact(r10.a(), this.$binder, (a) ZeusTransformUtils.preCheckCast(new AbsApi$callModelAsFlow$1$monitorTask$1(r10), a.class, "com.obric.aiagent.plugin"));
            if (AbsApi.access$sendFlowCallMethod(this.this$0, this.$binder, this.$args, r10) == true) goto L12;
            if (r2 == null) goto L16;
            ca.a.a(r2, null, 1, null);
            goto L16
        L12:
            a r3 = (a) ZeusTransformUtils.preCheckCast(new C04861(r2), a.class, "com.obric.aiagent.plugin");
            d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (kotlinx.coroutines.a.o.a(r10, r3, r4) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AbsApi.kt */
    @f(b = "AbsApi.kt", c = {122}, d = "callModelAsResponse", e = "com.obric.aikernel.phx.core.api.AbsApi")
    static final class C11191<T> extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsApi this$0;

        C11191(AbsApi r3, d<? super C11191> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.callModelAsResponse(null, null, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$unload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AbsApi.kt */
    @f(b = "AbsApi.kt", c = {109}, d = "unload", e = "com.obric.aikernel.phx.core.api.AbsApi")
    static final class C11211 extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsApi this$0;

        C11211(AbsApi r3, d<? super C11211> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.unload(null, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Object getBinder(d<? super AIKBinder> r3) {
        return getBinder$suspendImpl(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
    }

    public AbsApi() {
    }

    public static final /* synthetic */ boolean access$sendFlowCallMethod(AbsApi r2, AIKBinder r3, Bundle r4, q r5) {
        return r2.sendFlowCallMethod((AIKBinder) ZeusTransformUtils.wrapperContextForParams(r3, AIKBinder.class, "com.obric.aiagent.plugin"), r4, (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        IBaseModel.DefaultImpls.close(this);
    }

    public final kotlinx.coroutines.b.h<Bundle> callModelAsFlow(AIKBinder r4, Bundle r5) {
        AIKBinder r6 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r4, AIKBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "binder");
        d.h.b.o.e(r5, "args");
        return j.c((m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this, r5, null), m.class, "com.obric.aiagent.plugin"));
    }

    public final <T> Object callModelAsResponse(AIKBinder r10, Bundle r11, d.h.a.b<? super Bundle, ? extends T> r12, d<? super T> r13) {
        AIKBinder r14 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r10, AIKBinder.class, "com.obric.aiagent.plugin");
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, C11191.class) == false) goto L7;
        C11191 r0 = (C11191) ZeusTransformUtils.preCheckCast(r16, C11191.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r17 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        z.f r18 = (z.f) ZeusTransformUtils.preCheckCast(r0.L$4, z.f.class, "com.obric.aiagent.plugin");
        g r19 = (g) ZeusTransformUtils.preCheckCast(r0.L$3, g.class, "com.obric.aiagent.plugin");
        r15 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r0.L$2, d.h.a.b.class, "com.obric.aiagent.plugin");
        Bundle r110 = (Bundle) ZeusTransformUtils.preCheckCast(r0.L$1, Bundle.class, "com.obric.aiagent.plugin");
        AIKBinder r111 = (AIKBinder) ZeusTransformUtils.preCheckCast(r0.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L25:
        Bundle r20 = (Bundle) ZeusTransformUtils.preCheckCast(r9, Bundle.class, "com.obric.aiagent.plugin");
        ca r112 = (ca) ZeusTransformUtils.preCheckCast(r18.f38504a, ca.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L29;
        ca.a.a(r112, null, 1, null);
    L29:
        return r15.invoke(r20);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        AIKLog.INSTANCE.v(TAG, "start callModelAsResponse " + r11.getString(IdlKeys.MethodName) + ", traceid=" + r11.getString(IdlKeys.Args_TraceId));
        g r21 = r0.getContext();
        z.f r3 = new z.f();
        r0.L$0 = r14;
        r0.L$1 = r11;
        r0.L$2 = r15;
        r0.L$3 = r21;
        r0.L$4 = r3;
        r0.label = 1;
        kotlinx.coroutines.o r5 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin")), 1);
        r5.e();
        final n r4 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        r3.f38504a = (T) BinderMonitor.INSTANCE.monitorTransact(r21, r14, (a) ZeusTransformUtils.preCheckCast(new AbsApi$callModelAsResponse$responseBundle$1$1(r4), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        r14.callModel(r11, (AIKListener) ZeusTransformUtils.preCheckCast(new AbsApi$callModelAsResponse$responseBundle$1$2(r4), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
    L19:
        r9 = r5.h();
        if (r9 != b.a()) goto L22;
        d.c.b.a.h.c((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin"));
    L22:
        if (r9 != r17) goto L24;
        return r17;
    L24:
        r18 = r3;
    L17:
        th = move-exception;
        ExtsKt.resume((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"), BundleExtKt.setErr(new Bundle(), 102, th.getMessage()));
    L7:
        r0 = new C11191(this, r16);
        goto L8
    }

    static /* synthetic */ Object getBinder$suspendImpl(AbsApi r6, d<? super AIKBinder> r7) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        return AIKernelApi.getBinder$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), 0, r3, 1, null);
    }

    private final boolean sendFlowCallMethod(AIKBinder r4, Bundle r5, q<? super Bundle> r6) {
        AIKBinder r3 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r4, AIKBinder.class, "com.obric.aiagent.plugin");
        final q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        AIKLog.INSTANCE.i(TAG, "start callModelAsFlow " + r5.getString(IdlKeys.MethodName));
        r3.callModel(r5, (AIKListener) ZeusTransformUtils.preCheckCast(new BinderC11201(r7), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        r7.a_(BundleExtKt.setErr(new Bundle(), 102, th.getMessage()));
        t.a.a((t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.aiagent.plugin"), null, 1, null);
        return false;
    }

    public final Object unload(AIKBinder r17, String r18, d<? super x> r19) {
        AIKBinder r0 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r17, AIKBinder.class, "com.obric.aiagent.plugin");
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11211.class) == false) goto L7;
        C11211 r3 = (C11211) ZeusTransformUtils.preCheckCast(r2, C11211.class, "com.obric.aiagent.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = b.a();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r0 = (AIKBinder) ZeusTransformUtils.preCheckCast(r3.L$1, AIKBinder.class, "com.obric.aiagent.plugin");
        final String r7 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L18:
        r0.callModel(BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r4, Bundle.class, "com.obric.aiagent.plugin"), r7, IdlKeys.Method_UnloadPackage, IdlKeys.Call_Type_CallBiz, null, TAG, "unload", null, false, 200, null), (AIKListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r7), AIKListener.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        ParamsCompat r8 = ParamsCompat.INSTANCE;
        RequestParams r9 = new RequestParams(null, null, 3, null);
        r3.L$0 = r18;
        r3.L$1 = r0;
        r3.label = 1;
        r4 = r8.startCompat(r9, r3);
        if (r4 != r5) goto L17;
        return r5;
    L17:
        r7 = r18;
    L7:
        r3 = new C11211(this, r2);
        goto L8
    }
}
