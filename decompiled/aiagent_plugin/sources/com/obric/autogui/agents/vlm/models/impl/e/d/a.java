package com.obric.autogui.agents.vlm.models.impl.e.d;

import android.content.Context;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.agents.vlm.models.impl.l;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.o;
import d.x;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autogui.agents.vlm.models.impl.e.d.b {
    private static final String TAG = "Script-Runtime";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0693a f27849a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f27850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.e.f.d f27851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JsWorker f27852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference<n<l.b<com.obric.autogui.agents.scripted.a.l>>> f27853e;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.e.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
    public static final class C0693a {
        public /* synthetic */ C0693a(h r1) {
            this();
        }

        private C0693a() {
        }
    }

    /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
    @f(b = "JsWorkerScriptRuntimeImpl.kt", c = {345}, d = "nextStepWithParams", e = "com.obric.autogui.agents.vlm.models.impl.script.runtime.JsWorkerScriptRuntimeImpl")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f27857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27858e;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27857d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f27856c = r7;
            this.f27858e |= Integer.MIN_VALUE;
            return a.a(this.f27857d, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
    @f(b = "JsWorkerScriptRuntimeImpl.kt", c = {392}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.script.runtime.JsWorkerScriptRuntimeImpl$nextStepWithParams$2")
    static final class c extends d.c.b.a.l implements m<am, d.c.d<? super l.b<? extends com.obric.autogui.agents.scripted.a.l>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27863e;
        int f;
        final /* synthetic */ a g;
        final /* synthetic */ com.obric.autogui.agents.scripted.a.b h;
        final /* synthetic */ JsonArray i;
        final /* synthetic */ String j;
        final /* synthetic */ JsWorker k;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.e.d.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
        static final class C0694a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f27864a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<l.b<com.obric.autogui.agents.scripted.a.l>> f27865b;

            C0694a(a r3, n<? super l.b<com.obric.autogui.agents.scripted.a.l>> r4) {
                n<l.b<com.obric.autogui.agents.scripted.a.l>> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
                this.f27864a = r3;
                this.f27865b = r5;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r2) {
                a.a(this.f27864a).compareAndSet(this.f27865b, null);
            }
        }

        c(a r3, com.obric.autogui.agents.scripted.a.b r4, JsonArray r5, String r6, JsWorker r7, d.c.d<? super c> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            this.h = r4;
            this.i = r5;
            this.j = r6;
            this.k = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.g, this.h, this.i, this.j, this.k, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super l.b<? extends com.obric.autogui.agents.scripted.a.l>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            JsWorker r2 = (JsWorker) ZeusTransformUtils.preCheckCast(this.f27863e, JsWorker.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f27862d, String.class, "com.obric.aiagent.plugin");
            JsonArray r4 = (JsonArray) ZeusTransformUtils.preCheckCast(this.f27861c, JsonArray.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.scripted.a.b r5 = (com.obric.autogui.agents.scripted.a.b) ZeusTransformUtils.preCheckCast(this.f27860b, com.obric.autogui.agents.scripted.a.b.class, "com.obric.aiagent.plugin");
            a r13 = (a) ZeusTransformUtils.preCheckCast(this.f27859a, a.class, "com.obric.aiagent.plugin");
            o.a(r14);
        L18:
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r14);
            a r15 = this.g;
            com.obric.autogui.agents.scripted.a.b r6 = this.h;
            JsonArray r7 = this.i;
            String r8 = this.j;
            JsWorker r9 = this.k;
            this.f27859a = r15;
            this.f27860b = r6;
            this.f27861c = r7;
            this.f27862d = r8;
            this.f27863e = r9;
            this.f = 1;
            kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r12.e();
            n r10 = (n) ZeusTransformUtils.preCheckCast(r12, n.class, "com.obric.aiagent.plugin");
            a.a(r15).set(r10);
            com.obric.autogui.agents.scripted.impl.a.a(com.obric.autogui.agents.scripted.impl.a.f26972a, r9, "AutoShortcutEngine.nextStep(" + new Gson().toJson(new Gson().toJson(new com.obric.autogui.agents.scripted.a.f(r6, r7, r8))) + ')', null, 2, null);     // Catch: Exception -> L11
        L13:
            r10.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0694a(r15, r10), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r14 = r12.h();
            if (r14 != d.c.a.b.a()) goto L16;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L16:
            if (r14 != r0) goto L18;
            return r0;
        L11:
            e = move-exception;
            a.a(r15, "js_error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), false, false, 12, null);
            goto L13
        }
    }

    /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
    @f(b = "JsWorkerScriptRuntimeImpl.kt", c = {280}, d = "startScriptWithParams", e = "com.obric.autogui.agents.vlm.models.impl.script.runtime.JsWorkerScriptRuntimeImpl")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f27869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27870e;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27869d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.f27868c = r9;
            this.f27870e |= Integer.MIN_VALUE;
            return a.a(this.f27869d, null, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
    @f(b = "JsWorkerScriptRuntimeImpl.kt", c = {392}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.script.runtime.JsWorkerScriptRuntimeImpl$startScriptWithParams$2")
    static final class e extends d.c.b.a.l implements m<am, d.c.d<? super l.b<? extends com.obric.autogui.agents.scripted.a.l>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27875e;
        Object f;
        Object g;
        Object h;
        int i;
        final /* synthetic */ a j;
        final /* synthetic */ String k;
        final /* synthetic */ JsonObject l;
        final /* synthetic */ String m;
        final /* synthetic */ JsonArray n;
        final /* synthetic */ JsonObject o;
        final /* synthetic */ String p;
        final /* synthetic */ JsWorker q;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.e.d.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JsWorkerScriptRuntimeImpl.kt */
        static final class C0695a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f27876a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<l.b<com.obric.autogui.agents.scripted.a.l>> f27877b;

            C0695a(a r3, n<? super l.b<com.obric.autogui.agents.scripted.a.l>> r4) {
                n<l.b<com.obric.autogui.agents.scripted.a.l>> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
                this.f27876a = r3;
                this.f27877b = r5;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r2) {
                a.a(this.f27876a).compareAndSet(this.f27877b, null);
            }
        }

        e(a r3, String r4, JsonObject r5, String r6, JsonArray r7, JsonObject r8, String r9, JsWorker r10, d.c.d<? super e> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            this.k = r4;
            this.l = r5;
            this.m = r6;
            this.n = r7;
            this.o = r8;
            this.p = r9;
            this.q = r10;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super l.b<? extends com.obric.autogui.agents.scripted.a.l>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r2 = d.c.a.b.a();
            int r0 = this.i;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            JsWorker r1 = (JsWorker) ZeusTransformUtils.preCheckCast(this.h, JsWorker.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.g, String.class, "com.obric.aiagent.plugin");
            JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(this.f, JsonObject.class, "com.obric.aiagent.plugin");
            JsonArray r5 = (JsonArray) ZeusTransformUtils.preCheckCast(this.f27875e, JsonArray.class, "com.obric.aiagent.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f27874d, String.class, "com.obric.aiagent.plugin");
            JsonObject r7 = (JsonObject) ZeusTransformUtils.preCheckCast(this.f27873c, JsonObject.class, "com.obric.aiagent.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f27872b, String.class, "com.obric.aiagent.plugin");
            a r9 = (a) ZeusTransformUtils.preCheckCast(this.f27871a, a.class, "com.obric.aiagent.plugin");
            o.a(r21);
            return r21;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r21);
            a r12 = this.j;
            String r10 = this.k;
            JsonObject r11 = this.l;
            String r13 = this.m;
            JsonArray r14 = this.n;
            JsonObject r15 = this.o;
            String r16 = this.p;
            JsWorker r17 = this.q;
            this.f27871a = r12;
            this.f27872b = r10;
            this.f27873c = r11;
            this.f27874d = r13;
            this.f27875e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = 1;
            kotlinx.coroutines.o r18 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r18.e();
            n r19 = (n) ZeusTransformUtils.preCheckCast(r18, n.class, "com.obric.aiagent.plugin");
            a.a(r12).set(r19);
            kotlinx.coroutines.o r110 = r18;
            com.obric.autogui.agents.scripted.impl.a.a(com.obric.autogui.agents.scripted.impl.a.f26972a, r17, "AutoShortcutEngine.startScript(" + new Gson().toJson(new Gson().toJson(new com.obric.autogui.agents.scripted.a.m(r10, r11, r13, r14, r15, r16))) + ')', null, 2, null);     // Catch: Exception -> L13
        L18:
            r19.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0695a(r12, r19), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Object r20 = r110.h();
            if (r20 != d.c.a.b.a()) goto L21;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L21:
            if (r20 != r2) goto L28;
            return r2;
        L28:
            return r20;
        L13:
            e = e;
        L17:
            a.a(r12, "js_error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), false, false, 12, null);
        L15:
            e = e;
            r110 = r18;
            goto L17
        }
    }

    static {
        f27849a = new C0693a(null);
    }

    /* JADX INFO: renamed from: lambda$3X_OGBaxYgfRGpaB-1-10PskG2M, reason: not valid java name */
    public static /* synthetic */ void m755lambda$3X_OGBaxYgfRGpaB110PskG2M(a r0, String r1) {
        a(r0, r1);
    }

    public static /* synthetic */ x lambda$CPufMV2UteRdMjJJa4A4dyzeq_Q(Throwable r0) {
        return c(r0);
    }

    public static /* synthetic */ x lambda$O0vsWo69S3EogBBemXq_cJxKgh0(Throwable r0) {
        return d(r0);
    }

    public static /* synthetic */ x lambda$XLYBUkT81ALHi6j_gWXfI2zPQWM(Throwable r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$l67sugrKg4cRn5RhiqmDZ8s4-mo, reason: not valid java name */
    public static /* synthetic */ void m756lambda$l67sugrKg4cRn5RhiqmDZ8s4mo(a r0, String r1) {
        b(r0, r1);
    }

    public static /* synthetic */ x lambda$qNhRdFE6_UGvRI5pyDzWWOELGIo(Throwable r0) {
        return a(r0);
    }

    public a(Context r3, com.obric.autogui.agents.vlm.models.impl.e.f.d r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        d.h.b.o.e(r4, "stats");
        this.f27850b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f27851c = r4;
        this.f27853e = new AtomicReference();
    }

    public static final /* synthetic */ Object a(a r6, String r7, com.obric.autogui.agents.scripted.a.b r8, String r9, JsonArray r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r8, String r9, String r10, JsonObject r11, String r12, JsonObject r13, JsonArray r14, d.c.d r15) {
        return r8.a(r9, r10, r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReference a(a r0) {
        return r0.f27853e;
    }

    public final l.b<x> a() {
        IJSScriptService r5 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
        if (r5 == null) goto L6;
        JsWorker r6 = r5.getScriptJSWorker(this.f27850b);     // Catch: Exception -> L30
    L7:
        if (r6 == null) goto L9;
        IJSScriptService r7 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r7 == null) goto L13;
        String r8 = r7.getScriptEngine(this.f27850b);     // Catch: Exception -> L28
    L14:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r9 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L25;
        a(r6);     // Catch: Exception -> L28
        return (l.b) ZeusTransformUtils.preCheckCast(new l.b.a.c("init_js_env_failed", "failed to init js env (engineJS is null)", false, true), l.b.class, "com.obric.aiagent.plugin");
    L25:
        com.obric.autogui.agents.scripted.impl.a.a(com.obric.autogui.agents.scripted.impl.a.f26972a, r6, r8, null, 2, null);     // Catch: Exception -> L28
        this.f27852d = r6;     // Catch: Exception -> L28
        r6.setOnMessageCallback(new $$Lambda$a$3X_OGBaxYgfRGpaB110PskG2M(this));     // Catch: Exception -> L28
        r6.setOnErrorCallback(new $$Lambda$a$l67sugrKg4cRn5RhiqmDZ8s4mo(this));     // Catch: Exception -> L28
        return (l.b) ZeusTransformUtils.preCheckCast(new l.b.C0700b(x.f38692a), l.b.class, "com.obric.aiagent.plugin");
    L17:
        if (r9.length() == 0) goto L20;
        r10 = false;
        goto L21
    L13:
        r8 = null;
    L28:
        e = move-exception;
        JsWorker r11 = r6;
        e = e;
    L32:
        e.printStackTrace();
        if (r11 == null) goto L35;
        a(r11);
    L35:
        this.f27852d = null;
        return (l.b) ZeusTransformUtils.preCheckCast(new l.b.a.C0699b("init_js_env_failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), false, true), l.b.class, "com.obric.aiagent.plugin");
    L9:
        return (l.b) ZeusTransformUtils.preCheckCast(new l.b.a.c("init_js_env_failed", "failed to init js env (jsWorker is null)", false, true), l.b.class, "com.obric.aiagent.plugin");
    L6:
        r6 = null;
    L30:
        e = e;
        r11 = null;
        goto L32
    }

    private static final void a(a r3, String r4) {
        if (r4 == null) goto L5;
        Loog.INSTANCE.d(TAG, "message from js: " + r4);
        r3.a(r4);
        return;
    }

    private static final void b(a r9, String r10) {
        if (r10 == null) goto L5;
        Loog.INSTANCE.e(TAG, "error from js: " + r10);
        r9.a("js_error", r10, null, true, true);
        return;
    }

    private final void a(JsWorker r3) {
        r3.setOnMessageCallback(null);     // Catch: Exception -> L5
        r3.setOnErrorCallback(null);     // Catch: Exception -> L5
        r3.terminate();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "terminate uninitialized js worker failed: " + e.getMessage());
    }

    private final void a(String r8, String r9, String r10, boolean r11, boolean r12) {
        Loog.INSTANCE.e(TAG, "Script execution failed (engine): error=" + r9 + ", errorStack=" + r10);
        n r7 = (n) ZeusTransformUtils.preCheckCast(this.f27853e.getAndSet(null), n.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.a() == false) goto L9;
        r7.a(new l.b.a.C0698a(r8, r9, r10, r11, r12), $$Lambda$a$qNhRdFE6_UGvRI5pyDzWWOELGIo.INSTANCE);
        return;
    }

    private static final x a(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return x.f38692a;
    }

    static /* synthetic */ void a(a r1, String r2, String r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = true;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = true;
    L8:
        r1.a(r2, r3, r4, r5);
    }

    private final void a(String r4, String r5, boolean r6, boolean r7) {
        Loog.INSTANCE.e(TAG, "Script execution failed (local): " + r5);
        n r3 = (n) ZeusTransformUtils.preCheckCast(this.f27853e.getAndSet(null), n.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.a() == false) goto L9;
        r3.a(new l.b.a.c(r4, r5, r6, r7), $$Lambda$a$XLYBUkT81ALHi6j_gWXfI2zPQWM.INSTANCE);
        return;
    }

    private static final x b(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return x.f38692a;
    }

    static /* synthetic */ void a(a r1, String r2, Throwable r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = true;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = true;
    L8:
        r1.a(r2, r3, r4, r5);
    }

    private final void a(String r4, Throwable r5, boolean r6, boolean r7) {
        Loog.INSTANCE.e(TAG, "Script execution failed (exception): " + aa.b(r5.getClass()).b() + ": " + r5.getMessage(), r5);
        n r3 = (n) ZeusTransformUtils.preCheckCast(this.f27853e.getAndSet(null), n.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.a() == false) goto L9;
        r3.a(new l.b.a.C0699b(r4, r5, r6, r7), $$Lambda$a$CPufMV2UteRdMjJJa4A4dyzeq_Q.INSTANCE);
        return;
    }

    private static final x c(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return x.f38692a;
    }

    private final void a(com.obric.autogui.agents.scripted.a.l r3) {
        n r2 = (n) ZeusTransformUtils.preCheckCast(this.f27853e.getAndSet(null), n.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.a() == false) goto L9;
        r2.a(new l.b.C0700b(r3), $$Lambda$a$O0vsWo69S3EogBBemXq_cJxKgh0.INSTANCE);
        return;
    }

    private static final x d(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return x.f38692a;
    }

    private final void a(String r10) {
        com.obric.autogui.agents.scripted.a.c r11 = (com.obric.autogui.agents.scripted.a.c) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r10, com.obric.autogui.agents.scripted.a.c.class), com.obric.autogui.agents.scripted.a.c.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
        if (d.h.b.o.a(r11.getType(), "engineResp") == false) goto L28;
        this.f27851c.a(r11.b());     // Catch: Exception -> L30
        String r5 = r11.c();     // Catch: Exception -> L30
        if (r5 == null) goto L24;
        com.obric.autogui.agents.scripted.a.l r1 = r11.a();     // Catch: Exception -> L30
        if (r1 == null) goto L12;
        Boolean r2 = r1.f();     // Catch: Exception -> L30
        if (r2 == null) goto L12;
        boolean r7 = r2.booleanValue();     // Catch: Exception -> L30
    L13:
        com.obric.autogui.agents.scripted.a.l r3 = r11.a();     // Catch: Exception -> L30
        if (r3 == null) goto L18;
        Boolean r4 = r3.g();     // Catch: Exception -> L30
        if (r4 == null) goto L18;
        boolean r8 = r4.booleanValue();     // Catch: Exception -> L30
    L19:
        com.obric.autogui.agents.scripted.a.l r12 = r11.a();     // Catch: Exception -> L30
        if (r12 == null) goto L22;
        String r13 = r12.e();     // Catch: Exception -> L30
    L23:
        a("js_error", r5, r13, r7, r8);     // Catch: Exception -> L30
        return;
    L22:
        r13 = null;
    L18:
        r8 = true;
    L12:
        r7 = true;
        goto L13
    L24:
        com.obric.autogui.agents.scripted.a.l r14 = r11.a();     // Catch: Exception -> L30
        if (r14 == null) goto L27;
        a(r14);     // Catch: Exception -> L30
        return;
    L27:
        a(this, "js_error", "Engine response data and error are both null", false, false, 12, null);     // Catch: Exception -> L30
        return;
    L28:
        Loog.INSTANCE.w(TAG, "Unknown message type: " + r11.getType());     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        a(this, "js_error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), false, false, 12, null);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.d.b
    public Object a(String r11, String r12, JsonObject r13, String r14, d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r15) {
        d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        JSONObject r16 = ICloudConfig.Companion.getSettingsConfig("obric_script_toggle_map");
        if (r16 == null) goto L7;
        String r17 = r16.toString();
        if (r17 == null) goto L7;
        JsonObject r18 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r17, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
    L9:
        return a(r11, r12, r13, r14, r18, com.obric.autogui.agents.scripted.impl.l.f27011a.b(r11), r9);
    L7:
        r18 = null;
        goto L9
    }

    private final Object a(String r19, String r20, JsonObject r21, String r22, JsonObject r23, JsonArray r24, d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r25) {
        a r10 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r1.f27870e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f27870e -= Integer.MIN_VALUE;
    L8:
        d r13 = r1;
        Object r2 = r13.f27868c;
        Object r14 = d.c.a.b.a();
        int r3 = r13.f27870e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        JsWorker r4 = (JsWorker) ZeusTransformUtils.preCheckCast(r13.f27867b, JsWorker.class, "com.obric.aiagent.plugin");
        a r5 = (a) ZeusTransformUtils.preCheckCast(r13.f27866a, a.class, "com.obric.aiagent.plugin");
        o.a(r2);
        r10 = r5;
    L22:
        l.b r6 = (l.b) ZeusTransformUtils.preCheckCast(r2, l.b.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L26;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        r7.f27853e.set(null);
        r4.setOnMessageCallback(null);
        r4.setOnErrorCallback(null);
        r7.f27852d = null;
        return (l.b) ZeusTransformUtils.preCheckCast(new l.b.a.c("js_execution_timeout", "JS execution startScript timed out", true, true), l.b.class, "com.obric.aiagent.plugin");
    L26:
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        JsWorker r9 = r10.f27852d;
        if (r9 == null) goto L17;
        m r8 = (m) ZeusTransformUtils.preCheckCast(new e(this, r19, r21, r20, r24, r23, r22, r9, null), m.class, "com.obric.aiagent.plugin");
        r13.f27866a = r10;
        r13.f27867b = r9;
        r13.f27870e = 1;
        r2 = dg.b(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r8, r13);
        if (r2 != r14) goto L21;
        return r14;
    L21:
        r4 = r9;
        goto L22
    L17:
        return new l.b.a.c("init_js_env_failed", "Worker not initialized", false, true);
    L7:
        r1 = new d(r10, r0);
        goto L8
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.d.b
    public Object a(String r7, com.obric.autogui.agents.scripted.a.b r8, String r9, d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r10) {
        d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r7, r8, r9, com.obric.autogui.agents.scripted.impl.l.f27011a.b(r7), r5);
    }

    private final Object a(String r17, com.obric.autogui.agents.scripted.a.b r18, String r19, JsonArray r20, d.c.d<? super l.b<com.obric.autogui.agents.scripted.a.l>> r21) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if ((r1.f27858e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f27858e -= Integer.MIN_VALUE;
    L8:
        b r10 = r1;
        Object r2 = r10.f27856c;
        Object r11 = d.c.a.b.a();
        int r3 = r10.f27858e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        JsWorker r4 = (JsWorker) ZeusTransformUtils.preCheckCast(r10.f27855b, JsWorker.class, "com.obric.aiagent.plugin");
        a r5 = (a) ZeusTransformUtils.preCheckCast(r10.f27854a, a.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L22:
        l.b r6 = (l.b) ZeusTransformUtils.preCheckCast(r2, l.b.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L26;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        r7.f27853e.set(null);
        r4.setOnMessageCallback(null);
        r4.setOnErrorCallback(null);
        r7.f27852d = null;
        return (l.b) ZeusTransformUtils.preCheckCast(new l.b.a.c("js_execution_timeout", "JS execution nextStep timed out", true, true), l.b.class, "com.obric.aiagent.plugin");
    L26:
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        JsWorker r13 = this.f27852d;
        if (r13 == null) goto L17;
        m r8 = (m) ZeusTransformUtils.preCheckCast(new c(this, r18, r20, r19, r13, null), m.class, "com.obric.aiagent.plugin");
        r10.f27854a = this;
        r10.f27855b = r13;
        r10.f27858e = 1;
        r2 = dg.b(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r8, r10);
        if (r2 != r11) goto L21;
        return r11;
    L21:
        r5 = this;
        r4 = r13;
        goto L22
    L17:
        return new l.b.a.c("init_js_env_failed", "Worker not initialized", false, true);
    L7:
        r1 = new b(this, r0);
        goto L8
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.d.b
    public void b() {
        JsWorker r0 = this.f27852d;
        if (r0 == null) goto L5;
        r0.setOnMessageCallback(null);
        r0.setOnErrorCallback(null);
    L5:
        JsWorker r1 = this.f27852d;
        if (r1 == null) goto L8;
        r1.terminate();
    L8:
        this.f27852d = null;
    }
}
