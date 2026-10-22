package com.obric.aikernel.phx.core.api;

import android.content.Context;
import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.ChildProcessLifecycleBinding;
import com.obric.aikernel.phx.core.conn.ProcessLifecycleHandle;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.b;
import d.h.a.m;
import d.h.b.h;
import d.h.b.p;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: ScriptBizApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScriptBizApi extends AbsApi {
    public static final Companion Companion = null;
    private static final String TAG = "ScriptBizApi";
    private final String bizName;
    private final RequestParams params;
    private AIKBinder remote;
    private final String servicePackage;
    private String targetProcess;

    /* JADX INFO: compiled from: ScriptBizApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$getBinder$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @f(b = "ScriptBizApi.kt", c = {31}, d = "getBinder", e = "com.obric.aikernel.phx.core.api.ScriptBizApi")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass1(ScriptBizApi r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getBinder((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @f(b = "ScriptBizApi.kt", c = {40}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2")
    static final class AnonymousClass2 extends l implements b<d.c.d<? super Response<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass2(ScriptBizApi r3, RequestParams r4, d.c.d<? super AnonymousClass2> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$params, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d.c.d<? super Response<Object>> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Response<Object>> r3) {
            return invoke2((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ScriptBizApi r7 = this.this$0;
            RequestParams r2 = this.$params;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r6 = ScriptBizApi.access$inferenceTo(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @f(b = "ScriptBizApi.kt", c = {45}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2")
    static final class C11242 extends l implements b<d.c.d<? super kotlinx.coroutines.b.h<? extends Response<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        C11242(ScriptBizApi r3, RequestParams r4, d.c.d<? super C11242> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11242(this.this$0, this.$params, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d.c.d<? super kotlinx.coroutines.b.h<Response<Object>>> r3) {
            return ((C11242) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C11242.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super kotlinx.coroutines.b.h<? extends Response<Object>>> r3) {
            return invoke2((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ScriptBizApi r7 = this.this$0;
            RequestParams r2 = this.$params;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r6 = ScriptBizApi.access$inferenceAsFlow(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @f(b = "ScriptBizApi.kt", c = {62}, d = "inferenceAsFlow", e = "com.obric.aikernel.phx.core.api.ScriptBizApi")
    static final class C11251 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        C11251(ScriptBizApi r3, d.c.d<? super C11251> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ScriptBizApi.access$inferenceAsFlow(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @f(b = "ScriptBizApi.kt", c = {66, 66}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$2")
    static final class C11262 extends l implements m<i<? super Response<Object>>, d.c.d<? super x>, Object> {
        final /* synthetic */ AIKBinder $binder;
        final /* synthetic */ RequestParams $params;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        C11262(ScriptBizApi r3, AIKBinder r4, RequestParams r5, d.c.d<? super C11262> r6) {
            AIKBinder r7 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r4, AIKBinder.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$binder = r7;
            this.$params = r5;
            super(2, r8);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            C11262 r0 = new C11262(this.this$0, this.$binder, this.$params, r7);
            r0.L$0 = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super Response<Object>> r3, d.c.d<? super x> r4) {
            return invoke2((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(i<? super Response<Object>> r3, d.c.d<? super x> r4) {
            return ((C11262) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11262.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            ProcessLifecycleHandle r13 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(this.L$0, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
            o.a(r14);     // Catch: Throwable -> L9
        L26:
            r13.close();
            return x.f38692a;
        L9:
            Throwable th = th;
        L30:
            r13.close();
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            AIKBinder r2 = (AIKBinder) ZeusTransformUtils.preCheckCast(this.L$3, AIKBinder.class, "com.obric.aiagent.plugin");
            ScriptBizApi r5 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(this.L$2, ScriptBizApi.class, "com.obric.aiagent.plugin");
            i r6 = (i) ZeusTransformUtils.preCheckCast(this.L$1, i.class, "com.obric.aiagent.plugin");
            ProcessLifecycleHandle r7 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(this.L$0, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
            o.a(r14);     // Catch: Throwable -> L16
            Object r8 = r14;
            ProcessLifecycleHandle r15 = r7;
        L22:
            RequestParams r9 = this.$params;     // Catch: Throwable -> L28
            ScriptBizApi r10 = this.this$0;     // Catch: Throwable -> L28
            Bundle r11 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            BundleExtKt.setBizCall(r9.getBackend(), r10.getBizName(), ScriptBizApi.TAG, "inferenceAsFlow").putBoolean(IdlKeys.Args_StreamingCall, true);     // Catch: Throwable -> L28
            x r3 = x.f38692a;     // Catch: Throwable -> L28
            final kotlinx.coroutines.b.h<Bundle> r4 = r5.callModelAsFlow(r2, (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L28
            kotlinx.coroutines.b.h r12 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new ScriptBizApi$inferenceAsFlow$2$invokeSuspend$$inlined$map$1(r4), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            d.c.d r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            this.L$0 = r15;     // Catch: Throwable -> L28
            this.L$1 = null;     // Catch: Throwable -> L28
            this.L$2 = null;     // Catch: Throwable -> L28
            this.L$3 = null;     // Catch: Throwable -> L28
            this.label = 2;     // Catch: Throwable -> L28
            if (j.a(r6, r12, r16) != r0) goto L25;
            return r0;
        L25:
            r13 = r15;
        L28:
            th = move-exception;
            ProcessLifecycleHandle r17 = r15;
            th = th;
            r13 = r17;
        L16:
            th = th;
            r13 = r7;
            goto L30
        L18:
            o.a(r14);
            r6 = (i) ZeusTransformUtils.preCheckCast(this.L$0, i.class, "com.obric.aiagent.plugin");
            r15 = ScriptBizApi.access$ensureProcessLifecycleBinding(this.this$0);
            r5 = this.this$0;     // Catch: Throwable -> L28
            r2 = this.$binder;     // Catch: Throwable -> L28
            ParamsCompat r18 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L28
            RequestParams r19 = this.$params;     // Catch: Throwable -> L28
            d.c.d<? super Bundle> r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            this.L$0 = r15;     // Catch: Throwable -> L28
            this.L$1 = r6;     // Catch: Throwable -> L28
            this.L$2 = r5;     // Catch: Throwable -> L28
            this.L$3 = r2;     // Catch: Throwable -> L28
            this.label = 1;     // Catch: Throwable -> L28
            r8 = r18.startCompat(r19, r20);     // Catch: Throwable -> L28
            if (r8 != r0) goto L22;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    @f(b = "ScriptBizApi.kt", c = {49, 52, 52}, d = "inferenceTo", e = "com.obric.aikernel.phx.core.api.ScriptBizApi")
    static final class C11271 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        C11271(ScriptBizApi r3, d.c.d<? super C11271> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ScriptBizApi.access$inferenceTo(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceTo$3, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptBizApi.kt */
    static final class AnonymousClass3 extends p implements b<Bundle, Response<Object>> {
        public static final AnonymousClass3 INSTANCE = null;

        /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceTo$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: ScriptBizApi.kt */
        static final class AnonymousClass1 extends p implements m<Bundle, String, Object> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            AnonymousClass1() {
                super(2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Bundle r1, String r2) {
                d.h.b.o.e(r1, "b");
                d.h.b.o.e(r2, "k");
                return r1.get(r2);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(Bundle r3, String r4) {
                return invoke2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            INSTANCE = new AnonymousClass3();
        }

        AnonymousClass3() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Response<Object> invoke(Bundle r3) {
            return invoke2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Response<Object> invoke2(Bundle r3) {
            d.h.b.o.e(r3, "it");
            return BundleExtKt.toUserResponse(r3, (m) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, m.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ ProcessLifecycleHandle access$ensureProcessLifecycleBinding(ScriptBizApi r0) {
        return r0.ensureProcessLifecycleBinding();
    }

    public static final /* synthetic */ AIKBinder access$getRemote$p(ScriptBizApi r0) {
        return r0.remote;
    }

    public static final /* synthetic */ Object access$inferenceAsFlow(ScriptBizApi r2, RequestParams r3, d.c.d r4) {
        return r2.inferenceAsFlow(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$inferenceTo(ScriptBizApi r2, RequestParams r3, d.c.d r4) {
        return r2.inferenceTo(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final RequestParams getParams() {
        return this.params;
    }

    public ScriptBizApi(String r3, RequestParams r4, AIKBinder r5, String r6, String r7) {
        AIKBinder r8 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r5, AIKBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "bizName");
        d.h.b.o.e(r4, "params");
        d.h.b.o.e(r8, "remote");
        d.h.b.o.e(r6, "servicePackage");
        this.bizName = r3;
        this.params = r4;
        this.remote = r8;
        this.servicePackage = r6;
        this.targetProcess = r7;
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi
    public Object getBinder(d.c.d<? super AIKBinder> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r7 = r1;
        Object r13 = r7.result;
        Object r2 = d.c.a.b.a();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ScriptBizApi this = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r7.L$0, ScriptBizApi.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L21:
        if (ZeusTransformUtils.instanceOf(r13, ScriptBizApi.class) == false) goto L23;
        ScriptBizApi r14 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r13, ScriptBizApi.class, "com.obric.aiagent.plugin");
    L24:
        if (r14 == null) goto L27;
        this.remote = r14.remote;
        this.targetProcess = r14.targetProcess;
    L27:
        return this.remote;
    L23:
        r14 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        if (this.remote.asBinder().isBinderAlive() == true) goto L28;
        IAIKernelManager r4 = AIKernelManager.INSTANCE.invoke();
        String r15 = this.bizName;
        RequestParams r6 = this.params;
        r7.L$0 = this;
        r7.label = 1;
        r13 = IAIKernelManager.DefaultImpls.loadPackage$default(r4, r15, false, r6, r7, 2, null);
        if (r13 != r2) goto L21;
        return r2;
    L28:
        return this.remote;
    L7:
        r1 = new AnonymousClass1(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r6, d.c.d<? super Response<Object>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return AIKernelManager.INSTANCE.getInstance$sdk_release().wrapApiCall(r6, this.remote, (b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r6, null), b.class, "com.obric.aiagent.plugin"), r8);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r6, d.c.d<? super kotlinx.coroutines.b.h<Response<Object>>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return AIKernelManager.INSTANCE.getInstance$sdk_release().wrapApiCall(r6, this.remote, (b) ZeusTransformUtils.preCheckCast(new C11242(this, r6, null), b.class, "com.obric.aiagent.plugin"), r8);
    }

    private final Object inferenceTo(RequestParams r21, d.c.d<? super Response<Object>> r22) {
        ScriptBizApi r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11271.class) == false) goto L7;
        C11271 r4 = (C11271) ZeusTransformUtils.preCheckCast(r2, C11271.class, "com.obric.aiagent.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = d.c.a.b.a();
        int r6 = r4.label;
        if (r6 == 0) goto L26;
        if (r6 == 1) goto L25;
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        ProcessLifecycleHandle r1 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(r4.L$0, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L16
    L42:
        Response r7 = (Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        r1.close();
        return r7;
    L16:
        th = th;
    L47:
        r1.close();
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        AIKBinder r8 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$4, AIKBinder.class, "com.obric.aiagent.plugin");
        ScriptBizApi r9 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r4.L$3, ScriptBizApi.class, "com.obric.aiagent.plugin");
        ProcessLifecycleHandle r10 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(r4.L$2, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
        RequestParams r11 = (RequestParams) ZeusTransformUtils.preCheckCast(r4.L$1, RequestParams.class, "com.obric.aiagent.plugin");
        ScriptBizApi r12 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r4.L$0, ScriptBizApi.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L23
        ScriptBizApi r13 = r9;
        ProcessLifecycleHandle r14 = r10;
    L38:
        Bundle r15 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        BundleExtKt.setBizCall(r11.getBackend(), r12.bizName, TAG, "inferenceTo");     // Catch: Throwable -> L45
        x r16 = x.f38692a;     // Catch: Throwable -> L45
        Bundle r17 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        b r18 = (b) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        r4.L$0 = r14;     // Catch: Throwable -> L45
        r4.L$1 = null;     // Catch: Throwable -> L45
        r4.L$2 = null;     // Catch: Throwable -> L45
        r4.L$3 = null;     // Catch: Throwable -> L45
        r4.L$4 = null;     // Catch: Throwable -> L45
        r4.label = 3;     // Catch: Throwable -> L45
        r3 = r13.callModelAsResponse(r8, r17, r18, r4);     // Catch: Throwable -> L45
        if (r3 != r5) goto L41;
        return r5;
    L41:
        r1 = r14;
    L45:
        th = th;
        r1 = r14;
    L23:
        th = th;
        r1 = r10;
        goto L47
    L25:
        RequestParams r19 = (RequestParams) ZeusTransformUtils.preCheckCast(r4.L$1, RequestParams.class, "com.obric.aiagent.plugin");
        ScriptBizApi r20 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r4.L$0, ScriptBizApi.class, "com.obric.aiagent.plugin");
        o.a(r3);
        RequestParams r23 = r19;
        r0 = r20;
    L29:
        AIKBinder r24 = (AIKBinder) ZeusTransformUtils.preCheckCast(r3, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L32;
        r14 = r0.ensureProcessLifecycleBinding();
        ParamsCompat r25 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L45
        r4.L$0 = r0;     // Catch: Throwable -> L45
        r4.L$1 = r23;     // Catch: Throwable -> L45
        r4.L$2 = r14;     // Catch: Throwable -> L45
        r4.L$3 = r0;     // Catch: Throwable -> L45
        r4.L$4 = r24;     // Catch: Throwable -> L45
        r4.label = 2;     // Catch: Throwable -> L45
        Object r26 = r25.startCompat(r23, r4);     // Catch: Throwable -> L45
        if (r26 != r5) goto L37;
        return r5;
    L37:
        r11 = r23;
        r12 = r0;
        r8 = r24;
        r3 = r26;
        r13 = r12;
        goto L38
    L32:
        return new Response(102, null, null, false, false, null, null, 126, null);
    L26:
        o.a(r3);
        r4.L$0 = r0;
        r23 = r21;
        r4.L$1 = r23;
        r4.label = 1;
        r3 = r0.getBinder(r4);
        if (r3 != r5) goto L29;
        return r5;
    L7:
        r4 = new C11271(r0, r2);
        goto L8
    }

    static /* synthetic */ Object inferenceTo$default(ScriptBizApi r1, RequestParams r2, d.c.d r3, int r4, Object r5) {
        d.c.d<? super Response<Object>> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new RequestParams(null, null, 3, null);
    L6:
        return r1.inferenceTo(r2, r6);
    }

    private final Object inferenceAsFlow(RequestParams r7, d.c.d<? super kotlinx.coroutines.b.h<Response<Object>>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C11251.class) == false) goto L7;
        C11251 r0 = (C11251) ZeusTransformUtils.preCheckCast(r9, C11251.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = d.c.a.b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$1, RequestParams.class, "com.obric.aiagent.plugin");
        ScriptBizApi this = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r0.L$0, ScriptBizApi.class, "com.obric.aiagent.plugin");
        o.a(r10);
    L17:
        AIKBinder r11 = (AIKBinder) ZeusTransformUtils.preCheckCast(r10, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L22;
        return j.a((m) ZeusTransformUtils.preCheckCast(new ScriptBizApi$inferenceAsFlow$binder$1(null), m.class, "com.obric.aiagent.plugin"));
    L22:
        return j.a((m) ZeusTransformUtils.preCheckCast(new C11262(this, r11, r7, null), m.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        AIKLog.INSTANCE.i(TAG, "call inferenceAsFlow " + this.bizName);
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.label = 1;
        r10 = getBinder(r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new C11251(this, r9);
        goto L8
    }

    static /* synthetic */ Object inferenceAsFlow$default(ScriptBizApi r1, RequestParams r2, d.c.d r3, int r4, Object r5) {
        d.c.d<? super kotlinx.coroutines.b.h<Response<Object>>> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new RequestParams(null, null, 3, null);
    L6:
        return r1.inferenceAsFlow(r2, r6);
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi, com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new ScriptBizApi$close$1$1(this, null), m.class, "com.obric.aiagent.plugin"), 1, null);     // Catch: Throwable -> L4
        n.f(x.f38692a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        n.a r1 = n.f38560a;
        n.f(o.a(th));
    }

    private final ProcessLifecycleHandle ensureProcessLifecycleBinding() {
        ChildProcessLifecycleBinding r0 = ChildProcessLifecycleBinding.INSTANCE;
        AIKernelConfig r1 = a.f22349a.a();
        if (r1 == null) goto L5;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        return ChildProcessLifecycleBinding.bind$default(r0, r2, this.servicePackage, this.targetProcess, false, 8, null);
    L5:
        r2 = null;
        goto L7
    }
}
