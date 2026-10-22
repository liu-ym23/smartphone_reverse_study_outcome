package com.obric.autogui.agents.vlm.models.impl.request.c.a;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: StreamingFlowHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "StdModel-StreamRH";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28069a = null;
    private static AtomicReference<c> g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.b.C0677b f28070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.c.a.c f28073e;
    private JsonObject f;

    /* JADX INFO: compiled from: StreamingFlowHandler.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ void a(a r0, c r1) {
            r0.a(r1);
        }

        public final void a() {
            a(null);
        }

        private final void a(c r4) {
            c r3 = (c) ZeusTransformUtils.preCheckCast(b.b().getAndSet(r4), c.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.c().a().d();
            r3.b().a(new CancellationException("cancelled by user."));
            if (r4 == null) goto L9;
            Loog.INSTANCE.i(b.TAG, "[SSE-streaming] awaiting for requestId=" + r3.a() + " --> " + r4.a());
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.c.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StreamingFlowHandler.kt */
    public static final class C0708b extends Throwable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a f28074a;

        public /* synthetic */ C0708b(com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a r1, Throwable r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a a() {
            return this.f28074a;
        }

        public C0708b(com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a r3, Throwable r4) {
            o.e(r3, "streamTermType");
            super("Error in StreamingHandling -> " + r3, r4);
            this.f28074a = r3;
        }
    }

    /* JADX INFO: compiled from: StreamingFlowHandler.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ca f28076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f28077c;

        public c(String r3, ca r4, b r5) {
            ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
            o.e(r3, "requestId");
            o.e(r6, "job");
            o.e(r5, "handler");
            this.f28075a = r3;
            this.f28076b = r6;
            this.f28077c = r5;
        }

        public final String a() {
            return this.f28075a;
        }

        public final ca b() {
            return this.f28076b;
        }

        public final b c() {
            return this.f28077c;
        }
    }

    /* JADX INFO: compiled from: StreamingFlowHandler.kt */
    @d.c.b.a.f(b = "StreamingFlowHandler.kt", c = {81, 100}, d = "awaitFinalResponse", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.streaming.StreamingFlowHandler")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f28081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28082e;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28081d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28080c = r3;
            this.f28082e |= Integer.MIN_VALUE;
            return this.f28081d.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StreamingFlowHandler.kt */
    @d.c.b.a.f(b = "StreamingFlowHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.streaming.StreamingFlowHandler$awaitFinalResponse$job$1")
    static final class e extends l implements m<am, d.c.d<? super ca>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f28084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w<com.obric.autogui.agents.vlm.models.impl.request.c.a.d> f28085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f28086d;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.c.a.b$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: StreamingFlowHandler.kt */
        @d.c.b.a.f(b = "StreamingFlowHandler.kt", c = {84}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.streaming.StreamingFlowHandler$awaitFinalResponse$job$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28087a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f28088b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ w<com.obric.autogui.agents.vlm.models.impl.request.c.a.d> f28089c;

            AnonymousClass1(b r3, w<com.obric.autogui.agents.vlm.models.impl.request.c.a.d> r4, d.c.d<? super AnonymousClass1> r5) {
                w<com.obric.autogui.agents.vlm.models.impl.request.c.a.d> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28088b = r3;
                this.f28089c = r6;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f28088b, this.f28089c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28087a;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                d.o.a(r5);     // Catch: Throwable -> L7
            L15:
                com.obric.autogui.agents.vlm.models.impl.request.c.a.d r6 = (com.obric.autogui.agents.vlm.models.impl.request.c.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.impl.request.c.a.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                this.f28089c.a(r6);
                return x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r5);
                b r7 = this.f28088b;     // Catch: Throwable -> L7
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                this.f28087a = 1;     // Catch: Throwable -> L7
                r5 = b.a(r7, r2);     // Catch: Throwable -> L7
                if (r5 != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                this.f28089c.a(th);
                return x.f38692a;
            }
        }

        e(b r3, w<com.obric.autogui.agents.vlm.models.impl.request.c.a.d> r4, d.c.d<? super e> r5) {
            w<com.obric.autogui.agents.vlm.models.impl.request.c.a.d> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28084b = r3;
            this.f28085c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super ca> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f28084b, this.f28085c, r6);
            r0.f28086d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ca> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f28083a != 0) goto L7;
            d.o.a(r9);
            return i.a((am) ZeusTransformUtils.preCheckCast(this.f28086d, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f28084b, this.f28085c, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StreamingFlowHandler.kt */
    @d.c.b.a.f(b = "StreamingFlowHandler.kt", c = {132}, d = "awaitFinalResponseInternal", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.streaming.StreamingFlowHandler")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f28093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f28094e;
        final /* synthetic */ b f;
        int g;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28094e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReference b() {
        return g;
    }

    public b(com.obric.autogui.agents.vlm.b.C0677b r2, String r3, String r4, com.obric.autogui.agents.vlm.models.impl.request.c.a.c r5) {
        o.e(r2, "vlmSession");
        o.e(r3, "stepId");
        o.e(r4, "requestId");
        o.e(r5, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        this.f28070b = r2;
        this.f28071c = r3;
        this.f28072d = r4;
        this.f28073e = r5;
    }

    public final com.obric.autogui.agents.vlm.models.impl.request.c.a.c a() {
        return this.f28073e;
    }

    static {
        f28069a = new a(null);
        g = new AtomicReference();
    }

    private final Gson c() {
        return com.obric.autogui.util.b.f31495a.a();
    }

    public final Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.c.a.d> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f28082e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28082e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f28080c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28082e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r12);
    L22:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        w r9 = (w) ZeusTransformUtils.preCheckCast(r0.f28079b, w.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r0.f28078a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
        w r13 = r9;
        b this = r4;
        Object r5 = r12;
    L19:
        a.a(f28069a, new c(this.f28072d, (ca) ZeusTransformUtils.preCheckCast(r5, ca.class, "com.obric.aiagent.plugin"), this));
        r0.f28078a = null;
        r0.f28079b = null;
        r0.f28082e = 2;
        r12 = r13.a(r0);
        if (r12 != r2) goto L22;
        return r2;
    L16:
        d.o.a(r12);
        r13 = y.a(null, 1, null);
        m r6 = (m) ZeusTransformUtils.preCheckCast(new e(this, r13, null), m.class, "com.obric.aiagent.plugin");
        r0.f28078a = this;
        r0.f28079b = r13;
        r0.f28082e = 1;
        r5 = an.a(r6, r0);
        if (r5 != r2) goto L19;
        return r2;
    L7:
        r0 = new d(this, r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00fa -> B:32:0x00fd). Please report as a decompilation issue!!! */
    private final Object b(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.c.a.d> r17) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L7;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f28094e;
        Object r4 = d.c.a.b.a();
        int r5 = r3.g;
        int r8 = 1;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        int r0 = r3.f28093d;
        IAutoActionPresentationApi.IStreamingReplyDisplayingChannel r6 = (IAutoActionPresentationApi.IStreamingReplyDisplayingChannel) ZeusTransformUtils.preCheckCast(r3.f28092c, IAutoActionPresentationApi.IStreamingReplyDisplayingChannel.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.a.d<com.obric.autogui.agents.vlm.models.impl.request.c.a.f> r9 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(r3.f28091b, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r3.f28090a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: CancellationException -> L14 Throwable -> L70
        Object r7 = ((kotlinx.coroutines.a.h) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.a.h.class, "com.obric.aiagent.plugin")).a();     // Catch: CancellationException -> L14 Throwable -> L70
    L33:
        if (kotlinx.coroutines.a.h.a(r7) == false) goto L49;
        com.obric.autogui.agents.vlm.models.impl.request.c.a.f r11 = (com.obric.autogui.agents.vlm.models.impl.request.c.a.f) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.h.d(r7), com.obric.autogui.agents.vlm.models.impl.request.c.a.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        if (r11 != null) goto L38;
    L54:
        b r12 = r10;
    L24:
        String r13 = r12.f28070b.a().v();     // Catch: Throwable -> L70
        if (o.a(r13, r12.f28071c) == true) goto L76;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(r12), "[SSE] trackingStepId changed (" + r12.f28071c + ") ---> (" + r13 + ')');     // Catch: Throwable -> L70
        r0 = 1;
    L60:
        if (r12.f == null) goto L63;
        com.obric.autogui.agents.vlm.models.impl.request.c.a.d r14 = new com.obric.autogui.agents.vlm.models.impl.request.c.a.d(r12.f, null, null, 6, null);     // Catch: Throwable -> L70
    L40:
        f28069a.a();
        return r14;
    L63:
        if (r12.f28070b.a().K() == true) goto L65;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r12), "[SSE] early-stopped before the action is received. " + r12.f28070b.a().a() + "[sId=" + r12.f28071c + ", rId=" + r12.f28072d + ']');     // Catch: Throwable -> L70
        r12.f28073e.d();     // Catch: Throwable -> L70
    L66:
        if (r8 == 0) goto L68;
        r12.f28073e.d();     // Catch: Throwable -> L70
        r14 = new com.obric.autogui.agents.vlm.models.impl.request.c.a.d(null, com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f28107b, null, 4, null);     // Catch: Throwable -> L70
        goto L40
    L68:
        Loog.INSTANCE.e(TAG, "[SSE] end-before final response; rId=" + r12.f28072d);     // Catch: Throwable -> L70
        r14 = new com.obric.autogui.agents.vlm.models.impl.request.c.a.d(null, com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f28108c, null, 4, null);     // Catch: Throwable -> L70
        goto L40
    L65:
        r8 = r0;
        goto L66
    L76:
        r3.f28090a = r12;     // Catch: CancellationException -> L55 Throwable -> L70
        r3.f28091b = r9;     // Catch: CancellationException -> L55 Throwable -> L70
        r3.f28092c = r6;     // Catch: CancellationException -> L55 Throwable -> L70
        r3.f28093d = r0;     // Catch: CancellationException -> L55 Throwable -> L70
        r3.g = 1;     // Catch: CancellationException -> L55 Throwable -> L70
        Object r15 = r9.a_(r3);     // Catch: CancellationException -> L55 Throwable -> L70
        if (r15 != r4) goto L31;
        return r4;
    L31:
        r10 = r12;
        r7 = r15;
    L55:
        CancellationException e2 = e;
        r10 = r12;
    L57:
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(r10), "[SSE] receiveCatching cancelled, " + e2);     // Catch: Throwable -> L70
        r0 = 1;
    L58:
        r12 = r10;
        goto L60
    L38:
        if (r11.d() == null) goto L43;
        r14 = new com.obric.autogui.agents.vlm.models.impl.request.c.a.d(null, com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f28110e, (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.b(r11.d()), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L70
        goto L40
    L43:
        if (r11.e() == null) goto L46;
        r14 = new com.obric.autogui.agents.vlm.models.impl.request.c.a.d(null, com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f, (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.d(r11.e().a(), r11.e().b(), r11.e().c()), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L70
        goto L40
    L46:
        if (r10.a(r11, r6) == true) goto L54;
    L49:
        if (kotlinx.coroutines.a.h.c(r7) == false) goto L52;
        Loog.INSTANCE.d(TAG, "[SSE] receiving channel close; rId=" + r10.f28072d);     // Catch: Throwable -> L70
        goto L58
    L52:
        if (kotlinx.coroutines.a.h.b(r7) == false) goto L54;
        Throwable r16 = kotlinx.coroutines.a.h.e(r7);     // Catch: Throwable -> L70
        Loog.INSTANCE.e(TAG, "[SSE] channel failure on receive: " + r16, r16);     // Catch: Throwable -> L70
    L14:
        e2 = e;
        goto L57
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r2);
        kotlinx.coroutines.a.d<com.obric.autogui.agents.vlm.models.impl.request.c.a.f> r18 = this.f28073e.c();     // Catch: Throwable -> L70
        IAutoActionPresentationApi r19 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        if (r19 == null) goto L22;
        r6 = r19.openStreamingReplyChannel();     // Catch: Throwable -> L70
    L23:
        r12 = this;
        r0 = 0;
        r9 = r18;
        goto L24
    L22:
        r6 = null;
    L70:
        th = move-exception;
        f28069a.a();
        throw th;
    L7:
        r3 = new f(this, r1);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(com.obric.autogui.agents.vlm.models.impl.request.c.a.f r17, IAutoActionPresentationApi.IStreamingReplyDisplayingChannel r18) {
        IAutoActionPresentationApi.IStreamingReplyDisplayingChannel r4 = (IAutoActionPresentationApi.IStreamingReplyDisplayingChannel) ZeusTransformUtils.wrapperContextForParams(r18, IAutoActionPresentationApi.IStreamingReplyDisplayingChannel.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (o.a(r17.a(), this.f28072d) == true) goto L7;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] ignored unmatched request id: " + r17.a() + " != " + this.f28072d);
        return false;
    L7:
        if (this.f28070b.a().K() == true) goto L10;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] ignored a terminated vlmSession's response: " + this.f28070b.a().a() + "[sId=" + this.f28071c + ", rId=" + this.f28072d + ']');
        this.f28073e.d();
        return false;
    L10:
        Object r7 = null;
        Object[] r8 = 0;
        Object[] r9 = 0;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17.b(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L13;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(c().fromJson(r17.b(), JsonElement.class), JsonElement.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96
        if (ZeusTransformUtils.instanceOf(r0, JsonObject.class) == false) goto L94;
        JsonObject r10 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L28
        b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        JsonElement r3 = r10.get("action_type");     // Catch: Throwable -> L28
        if (r3 == null) goto L25;
        String r6 = r3.getAsString();     // Catch: Throwable -> L28
    L26:
        Object r11 = n.f(r6);     // Catch: Throwable -> L28
    L31:
        if (n.b(r11) == false) goto L33;
        r11 = null;
    L33:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        n.a r13 = n.f38560a;     // Catch: Throwable -> L40
        b r14 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        JsonElement r15 = r10.get("action");     // Catch: Throwable -> L40
        if (r15 == null) goto L37;
        String r16 = r15.getAsString();     // Catch: Throwable -> L40
    L38:
        Object r19 = n.f(r16);     // Catch: Throwable -> L40
    L43:
        if (n.b(r19) == false) goto L45;
        r19 = null;
    L45:
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.aiagent.plugin");
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L48;
    L51:
        Object[] r111 = true;
    L52:
        if (r111 == false) goto L58;
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L56;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] resp json without ACTION_TYPE (rId=" + this.f28072d + "): " + r17.b());
        goto L58
    L56:
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] resp json without ACTION_TYPE (rId=" + this.f28072d + ").");
    L58:
        if (o.a(r12, VDPlayerEffectProviderImpl.KEY_THOUGHT) == false) goto L60;
    L109:
        n.a r21 = n.f38560a;     // Catch: Throwable -> L78
        b r22 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L78
        JsonElement r23 = r10.get(VDPlayerEffectProviderImpl.KEY_THOUGHT);     // Catch: Throwable -> L78
        if (r23 == null) goto L75;
        String r24 = r23.getAsString();     // Catch: Throwable -> L78
    L76:
        Object r25 = n.f(r24);     // Catch: Throwable -> L78
    L81:
        if (n.b(r25) == true) goto L84;
        r7 = r25;
    L84:
        String r26 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        CharSequence r27 = (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin");
        if (r27 != null) goto L87;
    L88:
        r5 = true;
    L89:
        if (r5 == true) goto L93;
        if (r4 == null) goto L93;
        r4.pushThought(r26);
    L93:
        return !r17.c();
    L87:
        if (d.o.o.d(r27) == false) goto L89;
    L75:
        r24 = null;
    L78:
        th = move-exception;
        n.a r28 = n.f38560a;
        r25 = n.f(d.o.a(th));
        goto L81
    L60:
        if (o.a(r20, VDPlayerEffectProviderImpl.KEY_THOUGHT) == true) goto L109;
        if (o.a(r12, "thought_end") == false) goto L65;
    L69:
        if (r4 == null) goto L71;
        r4.thoughtEnd();
    L71:
        return true;
    L65:
        if (o.a(r20, "thought_end") == true) goto L69;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [SSE-Streaming] stopped receiving for (rId=" + this.f28072d + ')');
        this.f = r10;
        return false;
    L48:
        if (d.o.o.d(r110) == true) goto L51;
        r111 = false;
        goto L52
    L37:
        r16 = null;
    L40:
        th = move-exception;
        n.a r112 = n.f38560a;
        r19 = n.f(d.o.a(th));
        goto L43
    L25:
        r6 = null;
    L28:
        th = move-exception;
        n.a r29 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L31
    L94:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] parsed json is not a json object: " + r17.b());
        throw new C0708b(com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f28109d, null);
    L96:
        th = move-exception;
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L100;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] failed to parse json: " + r17.b() + ", " + th, th);
    L102:
        throw new C0708b(com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f28109d, th);
    L100:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] failed to parse ModelReply json, " + th, th);
        goto L102
    L13:
        if (r17.c() == true) goto L16;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] received empty string; rId=" + this.f28072d);
        return true;
    L16:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[SSE] received empty `end` before action received; rId=" + this.f28072d);
        IAutoActionTrackingApi r30 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r113 = new JSONObject();
        r113.put("exception_type", "streaming_empty_end_before_action");
        r113.put("debug_info", r17.f());
        x r31 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r30, "technical_bad_case", r113, false, false, null, 28, null);
        throw new C0708b(com.obric.autogui.agents.vlm.models.impl.request.c.a.d.a.f28108c, r9 == true ? 1 : 0, 2, r8 == true ? 1 : 0);
    }
}
