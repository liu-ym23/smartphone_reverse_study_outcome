package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.h.b.h;
import d.h.b.p;
import d.o;
import d.x;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: CloudBizApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CloudBizApi extends AbsApi {
    public static final Companion Companion = null;
    private static final String TAG = "CloudBizApi";
    private final String bizName;

    /* JADX INFO: compiled from: CloudBizApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$infer$2, reason: invalid class name */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @f(b = "CloudBizApi.kt", c = {20, 20}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.CloudBizApi$infer$2")
    static final class AnonymousClass2 extends l implements b<d<? super Response<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass2(CloudBizApi r3, RequestParams r4, d<? super AnonymousClass2> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$params, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super Response<Object>> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super Response<Object>> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r8);
        L16:
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r2 = (CloudBizApi) ZeusTransformUtils.preCheckCast(this.L$0, CloudBizApi.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L13:
            Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.aiagent.plugin");
            d<? super Response<Object>> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.L$0 = null;
            this.label = 2;
            r8 = r2.inference(r9, r3);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            o.a(r8);
            r2 = this.this$0;
            ParamsCompat r10 = ParamsCompat.INSTANCE;
            RequestParams r5 = this.$params;
            d<? super Bundle> r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.L$0 = r2;
            this.label = 1;
            r8 = r10.startCompat(r5, r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @f(b = "CloudBizApi.kt", c = {25, 25}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2")
    static final class C11222 extends l implements b<d<? super kotlinx.coroutines.b.h<? extends Response<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        C11222(CloudBizApi r3, RequestParams r4, d<? super C11222> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11222(this.this$0, this.$params, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super kotlinx.coroutines.b.h<Response<Object>>> r3) {
            return ((C11222) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11222.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super kotlinx.coroutines.b.h<? extends Response<Object>>> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r8);
        L16:
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r2 = (CloudBizApi) ZeusTransformUtils.preCheckCast(this.L$0, CloudBizApi.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L13:
            Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.aiagent.plugin");
            d<? super kotlinx.coroutines.b.h<Response<Object>>> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.L$0 = null;
            this.label = 2;
            r8 = r2.inferenceAsFlow(r9, r3);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            o.a(r8);
            r2 = this.this$0;
            ParamsCompat r10 = ParamsCompat.INSTANCE;
            RequestParams r5 = this.$params;
            d<? super Bundle> r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.L$0 = r2;
            this.label = 1;
            r8 = r10.startCompat(r5, r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inference$1, reason: invalid class name */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @f(b = "CloudBizApi.kt", c = {32, 34}, d = "inference", e = "com.obric.aikernel.phx.core.api.CloudBizApi")
    static final class AnonymousClass1 extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass1(CloudBizApi r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.inference(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inference$3, reason: invalid class name */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    static final class AnonymousClass3 extends p implements b<Bundle, Response<Object>> {
        public static final AnonymousClass3 INSTANCE = null;

        /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inference$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: CloudBizApi.kt */
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
                d.h.b.o.e(r1, "bundle");
                d.h.b.o.e(r2, "key");
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
            return BundleExtKt.toNetResponse(r3, (m) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, m.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CloudBizApi.kt */
    @f(b = "CloudBizApi.kt", c = {45}, d = "inferenceAsFlow", e = "com.obric.aikernel.phx.core.api.CloudBizApi")
    static final class C11231 extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CloudBizApi this$0;

        C11231(CloudBizApi r3, d<? super C11231> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.inferenceAsFlow(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CloudBizApi(String r2) {
        d.h.b.o.e(r2, "bizName");
        this.bizName = r2;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r10, d<? super Response<Object>> r11) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        return AIKernelApi.wrapApiCall$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), r10, null, (b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r10, null), b.class, "com.obric.aiagent.plugin"), r6, 2, null);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r10, d<? super kotlinx.coroutines.b.h<Response<Object>>> r11) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        return AIKernelApi.wrapApiCall$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), r10, null, (b) ZeusTransformUtils.preCheckCast(new C11222(this, r10, null), b.class, "com.obric.aiagent.plugin"), r6, 2, null);
    }

    public final Object inference(Bundle r20, d<? super Response<Object>> r21) {
        CloudBizApi r0 = this;
        Bundle r1 = r20;
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r21, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r2, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = d.c.a.b.a();
        int r6 = r4.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        o.a(r3);
    L26:
        return r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r7 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$1, Bundle.class, "com.obric.aiagent.plugin");
        CloudBizApi r8 = (CloudBizApi) ZeusTransformUtils.preCheckCast(r4.L$0, CloudBizApi.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r1 = r7;
        r0 = r8;
    L19:
        AIKBinder r9 = (AIKBinder) ZeusTransformUtils.preCheckCast(r3, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L22;
        b r10 = (b) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, b.class, "com.obric.aiagent.plugin");
        r4.L$0 = null;
        r4.L$1 = null;
        r4.label = 2;
        r3 = r0.callModelAsResponse(r9, r1, r10, r4);
        if (r3 != r5) goto L26;
        return r5;
    L22:
        return new Response(102, null, null, false, false, null, null, 126, null);
    L16:
        o.a(r3);
        BundleExtKt.setBizCall(r1, r0.bizName, TAG, "inference").putBoolean(IdlKeys.Args_UseCloud, true);
        r4.L$0 = r0;
        r4.L$1 = r1;
        r4.label = 1;
        r3 = r0.getBinder(r4);
        if (r3 != r5) goto L19;
        return r5;
    L7:
        r4 = new AnonymousClass1(r0, r2);
        goto L8
    }

    public final Object inferenceAsFlow(Bundle r7, d<? super kotlinx.coroutines.b.h<Response<Object>>> r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C11231.class) == false) goto L7;
        C11231 r0 = (C11231) ZeusTransformUtils.preCheckCast(r9, C11231.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = d.c.a.b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (Bundle) ZeusTransformUtils.preCheckCast(r0.L$1, Bundle.class, "com.obric.aiagent.plugin");
        CloudBizApi this = (CloudBizApi) ZeusTransformUtils.preCheckCast(r0.L$0, CloudBizApi.class, "com.obric.aiagent.plugin");
        o.a(r10);
    L17:
        AIKBinder r11 = (AIKBinder) ZeusTransformUtils.preCheckCast(r10, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        final kotlinx.coroutines.b.h<Bundle> r6 = this.callModelAsFlow(r11, r7);
        return (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new CloudBizApi$inferenceAsFlow$$inlined$map$1(r6), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
    L20:
        return j.a((m) ZeusTransformUtils.preCheckCast(new CloudBizApi$inferenceAsFlow$binder$1(null), m.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        Bundle r12 = BundleExtKt.setBizCall(r7, this.bizName, TAG, "inferenceAsFlow");
        r12.putBoolean(IdlKeys.Args_UseCloud, true);
        r12.putBoolean(IdlKeys.Args_StreamingCall, true);
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.label = 1;
        r10 = getBinder(r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new C11231(this, r9);
        goto L8
    }
}
