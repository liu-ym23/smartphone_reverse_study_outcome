package com.bytedance.securityguardkit.b;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContentDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String TAG = "ContentDetector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11130a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile b f11131d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PackageResource f11133c;

    /* JADX INFO: compiled from: ContentDetector.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            b r0 = b.c();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = b.c();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            o.c(r5, "appContext");     // Catch: Throwable -> L10
            r0 = new b(r5, null);     // Catch: Throwable -> L10
            a r6 = b.f11130a;     // Catch: Throwable -> L10
            b.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContentDetector.kt */
    @f(b = "ContentDetector.kt", c = {115, 123, ApWakeEvent.OTHER_START}, d = "invokeSuspend", e = "com.bytedance.securityguardkit.ai.ContentDetector$batchInfer$1")
    static final class C0253b extends l implements m<am, d<? super JSONArray>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f11134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f11136c;

        /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: ContentDetector.kt */
        static final class AnonymousClass1 extends p implements d.h.a.b<RequestParams, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String[] f11137a;

            /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ContentDetector.kt */
            static final class C02541 extends p implements d.h.a.b<Bundle, x> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ String[] f11138a;

                C02541(String[] r1) {
                    this.f11138a = r1;
                    super(1);
                }

                @Override // d.h.a.b
                public /* synthetic */ x invoke(Bundle r3) {
                    a((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"));
                    return x.f38692a;
                }

                public final void a(Bundle r2) {
                    o.e(r2, "$this$setCustomArgs");
                    r2.putStringArray(Params.PROMPT, this.f11138a);
                }
            }

            AnonymousClass1(String[] r1) {
                this.f11137a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(RequestParams r3) {
                a((RequestParams) ZeusTransformUtils.preCheckCast(r3, RequestParams.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(RequestParams r3) {
                o.e(r3, "$this$$receiver");
                ParamsKt.setCustomArgs(r3, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C02541(this.f11137a), d.h.a.b.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b$2, reason: invalid class name */
        /* JADX INFO: compiled from: ContentDetector.kt */
        static final class AnonymousClass2 extends p implements q<Boolean, Object, JSONObject, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ w<JSONArray> f11139a;

            AnonymousClass2(w<JSONArray> r3) {
                this.f11139a = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
                super(3);
            }

            @Override // d.h.a.q
            public /* synthetic */ x invoke(Boolean r3, Object r4, JSONObject r5) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), r4, (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(boolean r1, Object r2, JSONObject r3) {
                o.e(r3, "extra");
                a(b.TAG, "data: " + r2);
                this.f11139a.a(new JSONArray(String.valueOf(r2)));
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.i(r1, r2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b$3, reason: invalid class name */
        /* JADX INFO: compiled from: ContentDetector.kt */
        static final class AnonymousClass3 extends p implements q<Integer, String, JSONObject, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ w<JSONArray> f11140a;

            AnonymousClass3(w<JSONArray> r3) {
                this.f11140a = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
                super(3);
            }

            @Override // d.h.a.q
            public /* synthetic */ x invoke(Integer r3, String r4, JSONObject r5) {
                a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(int r3, String r4, JSONObject r5) {
                o.e(r4, "errInfo");
                o.e(r5, "extra");
                a(b.TAG, "errCode: " + r3);
                a(b.TAG, "errInfo: " + r4);
                this.f11140a.a((Throwable) ZeusTransformUtils.preCheckCast(new Exception("Inference failed: " + r3 + " - " + r4), Throwable.class, "com.obric.aiagent.plugin"));
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r0, String r1) {
                return Log.e(r0, r1);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b$4, reason: invalid class name */
        /* JADX INFO: compiled from: ContentDetector.kt */
        @f(b = "ContentDetector.kt", c = {ApWakeEvent.OTHER_END}, d = "invokeSuspend", e = "com.bytedance.securityguardkit.ai.ContentDetector$batchInfer$1$4")
        static final class AnonymousClass4 extends l implements m<am, d<? super JSONArray>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f11141a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ w<JSONArray> f11142b;

            AnonymousClass4(w<JSONArray> r3, d<? super AnonymousClass4> r4) {
                w<JSONArray> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f11142b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d<? super JSONArray> r4) {
                return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass4.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.f11142b, r4), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super JSONArray> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f11141a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                w<JSONArray> r6 = this.f11142b;
                d<? super JSONArray> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
                this.f11141a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.b$b$a */
        /* JADX INFO: compiled from: ContentDetector.kt */
        static final class a extends p implements d.h.a.b<RequestParams, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f11143a = null;

            static {
                f11143a = new a();
            }

            a() {
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(RequestParams r3) {
                a((RequestParams) ZeusTransformUtils.preCheckCast(r3, RequestParams.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(RequestParams r1) {
                o.e(r1, "$this$$receiver");
                ParamsKt.setPreloadSeconds(r1, 60);
            }
        }

        C0253b(String[] r3, d<? super C0253b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f11136c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super JSONArray> r4) {
            return ((C0253b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0253b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0253b(this.f11136c, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super JSONArray> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11135b;
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L13;
            if (r1 != 3) goto L12;
            d.o.a(r14);     // Catch: Exception -> L9 de -> L36
        L33:
        L40:
            return (JSONArray) ZeusTransformUtils.preCheckCast(r14, JSONArray.class, "com.obric.aiagent.plugin");
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            w r2 = (w) ZeusTransformUtils.preCheckCast(this.f11134a, w.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L24:
            Response r15 = (Response) ZeusTransformUtils.preCheckCast(r14, Response.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L30;
            Response r16 = ResponseKt.ok(r15, (q) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r2), q.class, "com.obric.aiagent.plugin"));
            if (r16 == null) goto L30;
            ResponseKt.fail(r16, (q) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r2), q.class, "com.obric.aiagent.plugin"));
        L30:
            m r17 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r2, null), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 de -> L36
            d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 de -> L36
            this.f11134a = null;     // Catch: Exception -> L9 de -> L36
            this.f11135b = 3;     // Catch: Exception -> L9 de -> L36
            r14 = dg.a(5000, r17, r3);     // Catch: Exception -> L9 de -> L36
            if (r14 != r0) goto L33;
            return r0;
        L14:
            r2 = (w) ZeusTransformUtils.preCheckCast(this.f11134a, w.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L19:
            IBaseModel r18 = (IBaseModel) ZeusTransformUtils.preCheckCast(r14, IBaseModel.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L30;
            RequestParams r8 = new RequestParams(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f11136c), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
            d<? super Response<Object>> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f11134a = r2;
            this.f11135b = 2;
            r14 = r18.infer(r8, r5);
            if (r14 != r0) goto L24;
            return r0;
        L15:
            d.o.a(r14);
            w r19 = y.a(null, 1, null);
            IAIKernelManager r4 = AIKernelManager.INSTANCE.invoke();
            RequestParams r9 = new RequestParams(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f11143a, d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
            d<? super IBaseModel> r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f11134a = r19;
            this.f11135b = 1;
            Object r6 = r4.loadPackage("pico_content_security", false, r9, r10);
            if (r6 != r0) goto L18;
            return r0;
        L18:
            r2 = r19;
            r14 = r6;
        L36:
            a(b.TAG, "Inference timed out");
            return null;
        L9:
            e = move-exception;
            a(b.TAG, "Inference failed: " + e.getMessage());
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    /* JADX INFO: compiled from: ContentDetector.kt */
    @f(b = "ContentDetector.kt", c = {38, 46}, d = "invokeSuspend", e = "com.bytedance.securityguardkit.ai.ContentDetector$init$1")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f11145b;

        /* JADX INFO: compiled from: ContentDetector.kt */
        static final class a extends p implements d.h.a.b<RequestParams, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f11146a = null;

            static {
                f11146a = new a();
            }

            a() {
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(RequestParams r3) {
                a((RequestParams) ZeusTransformUtils.preCheckCast(r3, RequestParams.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(RequestParams r3) {
                o.e(r3, "$this$$receiver");
                d.p.a.C1042a r2 = d.p.a.f38671a;
                r3.setTimeout(d.p.a.a(d.p.c.a(20, d.p.d.f38682e), d.p.d.f38680c));
            }
        }

        c(b r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f11145b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f11145b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11144a;
            boolean r3 = false;
            Throwable r5 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r15);
            Object r14 = ((n) ZeusTransformUtils.preCheckCast(r15, n.class, "com.obric.aiagent.plugin")).a();
        L37:
            if (n.b(r14) == false) goto L39;
            Object r16 = null;
        L40:
            PackageResource r17 = (PackageResource) ZeusTransformUtils.preCheckCast(r16, PackageResource.class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L43;
        L45:
            if (r3 == false) goto L48;
            a(b.TAG, "算法包准备好了，可以进行推理");
        L65:
            return x.f38692a;
        L48:
            if (n.b(r14) == false) goto L62;
            Throwable r18 = n.c(r14);
            if (ZeusTransformUtils.instanceOf(r18, AIKernelException.class) == false) goto L52;
            AIKernelException r19 = (AIKernelException) ZeusTransformUtils.preCheckCast(r18, AIKernelException.class, "com.obric.aiagent.plugin");
        L53:
            if (r19 == null) goto L55;
            Integer r110 = d.c.b.a.b.a(r19.getCode());
        L56:
            if (r19 == null) goto L58;
            String r2 = r19.getMessage();
        L59:
            if (r19 == null) goto L61;
            r5 = r19.getCause();
        L61:
            b(b.TAG, "更新失败：" + r110 + ", " + r2 + ", " + r5);
            goto L65
        L58:
            r2 = null;
            goto L59
        L55:
            r110 = null;
            goto L56
        L52:
            r19 = null;
            goto L53
        L62:
            a(b.TAG, "更新成功，但算法包暂不可用，可以稍后重试");
            goto L65
        L43:
            if (r17.isAvailable() != true) goto L45;
            r3 = true;
            goto L45
        L39:
            r16 = r14;
            goto L40
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r15);
            Object r111 = ((n) ZeusTransformUtils.preCheckCast(r15, n.class, "com.obric.aiagent.plugin")).a();
        L14:
            if (n.b(r111) == false) goto L16;
            r111 = null;
        L16:
            PackageResource r112 = (PackageResource) ZeusTransformUtils.preCheckCast(r111, PackageResource.class, "com.obric.aiagent.plugin");
            if (r112 != null) goto L19;
        L21:
            boolean r4 = false;
        L22:
            if (r4 == false) goto L24;
            a(b.TAG, "模型可以使用");
            b.a(this.f11145b, r112);
            goto L65
        L24:
            if (r112 != null) goto L26;
        L28:
            boolean r6 = false;
        L29:
            if (r6 == true) goto L32;
            a(b.TAG, "不支持的算法包");
            goto L65
        L32:
            if (r112.isDownloaded() == true) goto L63;
            a(b.TAG, "算法包资源待下载");
            IAIKernelManager r7 = AIKernelManager.INSTANCE.invoke();
            RequestParams r8 = new RequestParams(null, (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f11146a, d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
            d<? super n<PackageResource>> r9 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f11144a = 2;
            r14 = r7.mo394updatePackage0E7RQCE(r112, r8, r9);
            if (r14 != r0) goto L37;
            return r0;
        L63:
            a(b.TAG, "未知状态");
            goto L65
        L26:
            if (r112.isProvisioned() != true) goto L28;
            r6 = true;
            goto L29
        L19:
            if (r112.isAvailable() != true) goto L21;
            r4 = true;
            goto L22
        L10:
            d.o.a(r15);
            IAIKernelManager r10 = AIKernelManager.INSTANCE.invoke();
            d r11 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f11144a = 1;
            r111 = IAIKernelManager.DefaultImpls.m395getPackage0E7RQCE$default(r10, "pico_content_security", null, r11, 2, null);
            if (r111 != r0) goto L14;
            return r0;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    static {
        f11130a = new a(null);
    }

    public /* synthetic */ b(Context r2, h r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private b(Context r3) {
        this.f11132b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(b r0) {
        f11131d = r0;
    }

    public static final /* synthetic */ void a(b r0, PackageResource r1) {
        r0.f11133c = r1;
    }

    public static final /* synthetic */ b c() {
        return f11131d;
    }

    public final void a() {
        AIKernelConfig r0 = new AIKernelConfig.Builder(this.f11132b).appId(570851).build();
        AIKernelManager.INSTANCE.init(r0);
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final JSONObject a(String r3) {
        o.e(r3, "content");
        JSONArray r2 = a(new String[]{r3});
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getJSONObject(0);
    }

    public final JSONArray a(String[] r4) {
        o.e(r4, "batchContent");
        return (JSONArray) ZeusTransformUtils.preCheckCast(i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C0253b(r4, null), m.class, "com.obric.aiagent.plugin")), JSONArray.class, "com.obric.aiagent.plugin");
    }

    public final JSONObject b() {
        PackageResource r3 = this.f11133c;
        if (r3 == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put("name", r3.getName());
        r0.put("version", r3.getVersion());
        return r0;
    L5:
        return null;
    }
}
