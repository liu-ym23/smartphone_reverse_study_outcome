package com.obric.autogui.agents.vlm.models.omni.c;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AppPredictionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f28244a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Gson f28246c;

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    @d.c.b.a.f(b = "AppPredictionProvider.kt", c = {45}, d = "predict", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPredictionProvider")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f28248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28249c;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28248b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f28247a = r4;
            this.f28249c |= Integer.MIN_VALUE;
            return this.f28248b.a(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    @d.c.b.a.f(b = "AppPredictionProvider.kt", c = {61}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPredictionProvider$predict$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f28251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.c.c f28252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.tools.api.net.a f28253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f28254e;

        c(d r3, com.obric.autogui.agents.vlm.models.omni.c.c r4, com.obric.autogui.tools.api.net.a r5, long r6, d.c.d<? super c> r8) {
            com.obric.autogui.tools.api.net.a r7 = (com.obric.autogui.tools.api.net.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.tools.api.net.a.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28251b = r3;
            this.f28252c = r4;
            this.f28253d = r7;
            this.f28254e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super f> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f28251b, this.f28252c, this.f28253d, this.f28254e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super f> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28250a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L11:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a r13 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");
            if (r13.a() == false) goto L14;
            String r14 = (String) ZeusTransformUtils.preCheckCast(r13.c(), String.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L20;
            return new f.a("native_empty_response");
        L20:
            return d.a(this.f28251b, r14);
        L14:
            return new f.a("native_http_error");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            String r7 = d.a(this.f28251b).toJson(ao.a(new d.m[]{s.a("model", "oauto_deep_link"), s.a("messages", d.a.p.b(new Map[]{ao.a(new d.m[]{s.a("role", "system"), s.a("content", d.b(this.f28251b))}), ao.a(new d.m[]{s.a("role", "user"), s.a("content", e.a(this.f28252c))})}))}));
            com.obric.autogui.tools.api.net.a r4 = this.f28253d;
            String r5 = com.obric.aiagent.product.a.a.f18769a.a("/api/v1/chat/completions");
            Map<String, String> r6 = ao.a(s.a(DownloadHelper.CONTENT_TYPE, "application/json"));
            d.h.b.o.a(r7);
            int r8 = (int) this.f28254e;
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28250a = 1;
            r12 = r4.a(r5, r6, r7, r8, r9);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    static {
        f28244a = new a(null);
    }

    public d(String r2) {
        d.h.b.o.e(r2, "systemPrompt");
        this.f28245b = r2;
        this.f28246c = new Gson();
    }

    public static final /* synthetic */ Gson a(d r0) {
        return r0.f28246c;
    }

    public static final /* synthetic */ f a(d r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String b(d r0) {
        return r0.f28245b;
    }

    public final Object a(com.obric.autogui.agents.vlm.models.omni.c.c r13, long r14, d.c.d<? super f> r16) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r16, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if ((r2.f28249c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f28249c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f28247a;
        Object r10 = d.c.a.b.a();
        int r3 = r2.f28249c;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        d.o.a(r1);     // Catch: Exception -> L13 CancellationException -> L15
    L26:
        f r4 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13 CancellationException -> L15
        if (r4 != null) goto L35;
    L36:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("model_timeout"), f.class, "com.obric.aiagent.plugin");
    L35:
        return r4;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r1);
        com.obric.autogui.tools.api.net.a r6 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r6 == null) goto L22;
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r13, r6, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13 CancellationException -> L15
        r2.f28249c = 1;     // Catch: Exception -> L13 CancellationException -> L15
        r1 = dg.b(r14, r5, r2);     // Catch: Exception -> L13 CancellationException -> L15
        if (r1 != r10) goto L26;
        return r10;
    L22:
        return new f.a("native_http_client_unavailable");
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_model_exception:" + e.getClass().getSimpleName()), f.class, "com.obric.aiagent.plugin");
    L7:
        r2 = new b(this, r0);
        goto L8
    }

    private final f a(String r7) {
        JsonElement r8 = JsonParser.parseString(r7);     // Catch: Exception -> L72
        if (r8.isJsonPrimitive() == true) goto L6;
    L8:
        JsonArray r9 = r8.getAsJsonObject().getAsJsonArray("choices");     // Catch: Exception -> L72
        if (r9 == null) goto L71;
        JsonElement r10 = (JsonElement) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L72
        if (r10 == null) goto L71;
        JsonObject r11 = r10.getAsJsonObject();     // Catch: Exception -> L72
        if (r11 == null) goto L71;
        JsonObject r12 = r11.getAsJsonObject("message");     // Catch: Exception -> L72
        if (r12 == null) goto L71;
        JsonElement r13 = r12.get("content");     // Catch: Exception -> L72
        if (r13 == null) goto L71;
        String r14 = r13.getAsString();     // Catch: Exception -> L72
        if (r14 == null) goto L71;
        String r15 = e.a(r14);     // Catch: Exception -> L72
        if (r15 == null) goto L23;
        JsonElement r16 = JsonParser.parseString(r15);     // Catch: Exception -> L72
        if (r16.isJsonObject() == false) goto L48;
        if (r16.getAsJsonObject().has("apps") == true) goto L48;
        JsonElement r1 = r16.getAsJsonObject().get("shouldPrewarm");     // Catch: Exception -> L72
        if (r1 == null) goto L46;
        if (r1.isJsonPrimitive() == false) goto L46;
        if (r1.getAsJsonPrimitive().isBoolean() == false) goto L46;
        if (r1.getAsBoolean() == false) goto L79;
        JsonObject r17 = r16.getAsJsonObject();     // Catch: Exception -> L72
        d.h.b.o.c(r17, "getAsJsonObject(...)");     // Catch: Exception -> L72
        com.obric.autogui.agents.vlm.models.omni.c.b r6 = a(r17);     // Catch: Exception -> L72
        if (r6 != null) goto L44;
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_prediction_invalid_app"), f.class, "com.obric.aiagent.plugin");
    L44:
        return (f) ZeusTransformUtils.preCheckCast(new f.b(d.a.p.a(r6)), f.class, "com.obric.aiagent.plugin");
    L79:
        return (f) ZeusTransformUtils.preCheckCast(new f.b(d.a.p.b()), f.class, "com.obric.aiagent.plugin");
    L46:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_prediction_missing_apps"), f.class, "com.obric.aiagent.plugin");
    L48:
        if (r16.isJsonArray() == true) goto L51;
        r16 = r16.getAsJsonObject().get("apps");     // Catch: Exception -> L72
    L51:
        if (r16 == null) goto L69;
        if (r16.isJsonArray() == false) goto L69;
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L72
        Iterator<JsonElement> r18 = r16.getAsJsonArray().iterator();     // Catch: Exception -> L72
        d.h.b.o.c(r18, "iterator(...)");     // Catch: Exception -> L72
    L57:
        if (r18.hasNext() == false) goto L80;
        JsonElement r3 = (JsonElement) ZeusTransformUtils.preCheckCast(r18.next(), JsonElement.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L72
        if (r3.isJsonObject() == false) goto L61;
        JsonObject r4 = r3.getAsJsonObject();     // Catch: Exception -> L72
        d.h.b.o.c(r4, "getAsJsonObject(...)");     // Catch: Exception -> L72
        com.obric.autogui.agents.vlm.models.omni.c.b r5 = a(r4);     // Catch: Exception -> L72
        if (r5 == null) goto L65;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add(r5);     // Catch: Exception -> L72
        goto L57
    L65:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_prediction_invalid_app"), f.class, "com.obric.aiagent.plugin");
    L61:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_prediction_invalid_app"), f.class, "com.obric.aiagent.plugin");
    L80:
        return (f) ZeusTransformUtils.preCheckCast(new f.b(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"))), f.class, "com.obric.aiagent.plugin");
    L69:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_prediction_invalid_apps"), f.class, "com.obric.aiagent.plugin");
    L23:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_prediction_not_json"), f.class, "com.obric.aiagent.plugin");
    L71:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_response_missing_content"), f.class, "com.obric.aiagent.plugin");
    L6:
        if (r8.getAsJsonPrimitive().isString() == false) goto L8;
        r8 = JsonParser.parseString(r8.getAsString());     // Catch: Exception -> L72
    L72:
        e = move-exception;
        return (f) ZeusTransformUtils.preCheckCast(new f.a("native_response_parse_error:" + e.getClass().getSimpleName()), f.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autogui.agents.vlm.models.omni.c.b a(JsonObject r3) {
        JsonElement r2 = r3.get("packageName");
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.isJsonPrimitive() == true) goto L8;
        return null;
    L8:
        if (r2.getAsJsonPrimitive().isString() == false) goto L13;
        String r4 = r2.getAsString();
        d.h.b.o.c(r4, "getAsString(...)");
        return new com.obric.autogui.agents.vlm.models.omni.c.b(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString());
    L13:
        return null;
    }
}
