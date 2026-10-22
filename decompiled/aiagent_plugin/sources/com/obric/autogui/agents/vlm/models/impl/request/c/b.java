package com.obric.autogui.agents.vlm.models.impl.request.c;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.d;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StdModelSingleShotHttpImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.agents.vlm.models.impl.request.c.a {
    private static final String TAG = "M-Std-Http/Short";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f28120b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Gson f28121c = null;

    /* JADX INFO: compiled from: StdModelSingleShotHttpImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StdModelSingleShotHttpImpl.kt */
    private final class C0709b extends com.obric.autogui.agents.vlm.models.impl.request.a.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f28122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f28124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f28125e;
        private String f;
        private JsonObject g;
        private final a h;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.c.b$b$a */
        /* JADX INFO: compiled from: StdModelSingleShotHttpImpl.kt */
        public static final class a implements com.obric.autogui.agents.vlm.models.impl.request.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0709b f28126a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f28127b;

            a(C0709b r1) {
                this.f28126a = r1;
                this.f28127b = true;
            }

            @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
            public boolean a() {
                return this.f28127b;
            }

            @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
            public JsonObject b() {
                JsonObject r0 = C0709b.a(this.f28126a);
                o.a(r0);
                return r0;
            }

            @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
            public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r2) {
                o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
                throw new UnsupportedOperationException("analyseError() called on a succeeded response.");
            }
        }

        public static /* synthetic */ String lambda$X5Qy9VkespnmeYkPsangUu3Tdlo(C0709b r0) {
            return b(r0);
        }

        public C0709b(b r3, String r4) {
            this.f28122b = r3;
            this.f28123c = r4;
            this.f28125e = "";
            this.f = "";
            if (r4 != null) goto L11;
        L9:
            this.h = new a(this);
            return;
        L11:
            JsonObject r5 = c();     // Catch: Throwable -> L6
        L8:
            this.g = r5;
        L6:
            th = move-exception;
            Loog.INSTANCE.e(b.TAG, " - [single-shot] requestModelSingleShot failed (json-err), e=" + th.getMessage());
            Loog.INSTANCE.dp(b.TAG, new $$Lambda$b$b$X5Qy9VkespnmeYkPsangUu3Tdlo(this));
            r5 = null;
            goto L8
        }

        public static final /* synthetic */ JsonObject a(C0709b r0) {
            return r0.g;
        }

        private static final String b(C0709b r2) {
            return " - [single-shot] JSONText=" + r2.f28123c;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
        public boolean a() {
            if (this.f28123c != null) goto L5;
        L7:
            return false;
        L5:
            if (this.g == null) goto L7;
            return true;
        }

        private final JsonObject c() {
            JsonObject r0 = (JsonObject) ZeusTransformUtils.preCheckCast(b.c().fromJson(this.f28123c, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
            this.f28124d = r0.get(MonitorConstants.CODE).getAsInt();
            String r1 = r0.get("msg").getAsString();
            o.c(r1, "getAsString(...)");
            this.f28125e = r1;
            String r2 = r0.get("log_id").getAsString();
            o.c(r2, "getAsString(...)");
            this.f = r2;
            if (this.f28124d == com.obric.autogui.common.b.c.f29006c.a()) goto L7;
            Loog.INSTANCE.e(b.TAG, "[single-shot] requestModelSingleShot failed (serv-err), code=" + this.f28124d + ", msg=" + this.f28125e + ", logId=" + this.f);
            return null;
        L7:
            return (JsonObject) ZeusTransformUtils.preCheckCast(b.c().fromJson(r0.getAsJsonObject("data").get("text").getAsString(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
        public Object a(d<? super com.obric.autogui.agents.vlm.models.impl.request.a.d> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            if (a() == false) goto L7;
            return this.h;
        L7:
            throw new UnsupportedOperationException("awaitResponse() called on a failed request.");
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
        public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            o.e(r10, "context");
            if (a() == true) goto L19;
            if (this.f28123c != null) goto L9;
            Loog.INSTANCE.e(b.TAG, "[SyncHttpResult] null data returned by the Model");
            com.obric.autogui.agents.vlm.models.impl.request.b.b r0 = com.obric.autogui.agents.vlm.models.impl.request.b.b.h;
            com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a r4 = com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a;
            String r11 = r10.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_model_unexpected_response, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_model_unexpected_response"));
            o.c(r11, "getString(...)");
            return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.a(r0, r4, r11), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        L9:
            if (this.f28124d == com.obric.autogui.common.b.c.f29006c.a()) goto L13;
            Loog.INSTANCE.e(b.TAG, "[SyncHttpResult] server-side error (servCode=" + this.f28124d + ").");
            return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.d(this.f28124d, this.f28125e, this.f), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        L13:
            if (this.g != null) goto L17;
            Loog.INSTANCE.e(b.TAG, "[SyncHttpResult] JSON error in response body.");
            com.obric.autogui.agents.vlm.models.impl.request.b.b r1 = com.obric.autogui.agents.vlm.models.impl.request.b.b.h;
            com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a r5 = com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a;
            String r12 = r10.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_responded_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_responded_failure"), new Object[]{"JERR"});
            o.c(r12, "getString(...)");
            return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.a(r1, r5, r12), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        L17:
            throw new UnsupportedOperationException("analyseError() failed (isOk=" + a() + ')');
        L19:
            throw new UnsupportedOperationException("analyseError() called on a succeeded request.");
        }
    }

    /* JADX INFO: compiled from: StdModelSingleShotHttpImpl.kt */
    @f(b = "StdModelSingleShotHttpImpl.kt", c = {181}, d = "requestModel", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.StdModelSingleShotHttpImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f28131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28132e;

        c(b r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f28131d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f28130c = r8;
            this.f28132e |= Integer.MIN_VALUE;
            return this.f28131d.a(null, null, null, 0, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ Gson c() {
        return f28121c;
    }

    public b() {
    }

    static {
        f28120b = new a(null);
        f28121c = com.obric.autogui.util.b.f31495a.a();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.c.a, com.obric.autogui.agents.vlm.models.impl.request.a
    public void a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r4) {
        o.e(r4, "inferenceContext");
        super.a(r4);
        r4.c().addProperty("enable_stream", true);
        r4.c().addProperty("dispatch_flag", (Number) ZeusTransformUtils.preCheckCast(1, Number.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r6, String r7, String r8, int r9, JsonObject r10, d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r11) {
        d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r13 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r13.f28132e & Integer.MIN_VALUE) == 0) goto L7;
        r13.f28132e -= Integer.MIN_VALUE;
    L8:
        Object r14 = r13.f28130c;
        Object r0 = d.c.a.b.a();
        int r1 = r13.f28132e;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        r6 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r13.f28129b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        b this = (b) ZeusTransformUtils.preCheckCast(r13.f28128a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L21:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r15 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");
        if (r15.a() == true) goto L26;
        com.obric.autogui.tools.api.net.b r16 = r15.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.e(TAG, " - [single-shot] requestModelSingleShot failed (http-err), e=" + r16.getType());
        return this.a(r16);
    L26:
        return new C0709b(this, (String) ZeusTransformUtils.preCheckCast(r15.c(), String.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        com.obric.autogui.tools.api.net.a r17 = a();
        if (r17 != null) goto L18;
        Loog.INSTANCE.e(TAG, " - Std model client not configured.");
        return b();
    L18:
        String r2 = com.obric.autogui.a.a.f26086a.d();
        String r18 = r10.toString();
        o.c(r18, "toString(...)");
        r13.f28128a = this;
        r13.f28129b = r6;
        r13.f28132e = 1;
        r14 = r17.a(r2, r18, r9, r13);
        if (r14 != r0) goto L21;
        return r0;
    L7:
        r13 = new c(this, r12);
        goto L8
    }
}
