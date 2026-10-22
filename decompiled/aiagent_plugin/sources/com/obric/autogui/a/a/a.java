package com.obric.autogui.a.a;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: HeartBeatHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "HeartBeatHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f26092b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ca f26093c;

    /* JADX INFO: renamed from: com.obric.autogui.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeartBeatHelper.kt */
    @f(b = "HeartBeatHelper.kt", c = {85}, d = "heartbeatApiCall", e = "com.obric.autogui.request.model.HeartBeatHelper")
    static final class C0654a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f26097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f26098e;
        int f;

        C0654a(a r3, d.c.d<? super C0654a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26098e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26097d = r3;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f26098e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: HeartBeatHelper.kt */
    @f(b = "HeartBeatHelper.kt", c = {44, 46}, d = "invokeSuspend", e = "com.obric.autogui.request.model.HeartBeatHelper$startHeartbeat$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f26100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f26101c;

        b(com.obric.autogui.session.a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26100b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f26100b, r5);
            r0.f26101c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0072 -> B:7:0x001d). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26099a;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f26101c, am.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L7:
            am r9 = r2;
        L13:
            if (an.a(r9) == false) goto L22;
            a r3 = a.f26091a;
            com.obric.autogui.session.a r5 = this.f26100b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26101c = r9;
            this.f26099a = 1;
            if (a.a(r3, r5, r6) != r0) goto L17;
            return r0;
        L17:
            r2 = r9;
        L18:
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26101c = r2;
            this.f26099a = 2;
            if (ax.a(10000, r10) != r0) goto L7;
            return r0;
        L22:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = (am) ZeusTransformUtils.preCheckCast(this.f26101c, am.class, "com.obric.aiagent.plugin");
            o.a(r8);
            goto L18
        L11:
            o.a(r8);
            r9 = (am) ZeusTransformUtils.preCheckCast(this.f26101c, am.class, "com.obric.aiagent.plugin");
            goto L13
        }
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f26091a = new a();
        f26092b = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    public final void a(com.obric.autogui.session.a r9) {
        d.h.b.o.e(r9, SensitiveType.SESSION);
        Loog.INSTANCE.d(TAG, "startHeartbeat, session=" + r9.b() + '/' + r9.a());
        if (r9.c() == false) goto L6;
        Loog.INSTANCE.d(TAG, "no need to heartbeat for omni session");
        return;
    L6:
        f26093c = i.a(f26092b, null, null, (m) ZeusTransformUtils.preCheckCast(new b(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r3) {
        d.h.b.o.e(r3, "from");
        Loog.INSTANCE.d(TAG, "stopHeartbeat, from: " + r3);
        ca r2 = f26093c;
        if (r2 == null) goto L5;
        ca.a.a(r2, null, 1, null);
    L5:
        f26093c = null;
    }

    private final Object a(com.obric.autogui.session.a r10, d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, C0654a.class) == false) goto L7;
        C0654a r0 = (C0654a) ZeusTransformUtils.preCheckCast(r12, C0654a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f26097d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        JSONObject r9 = (JSONObject) ZeusTransformUtils.preCheckCast(r0.f26096c, JSONObject.class, "com.obric.aiagent.plugin");
        r10 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f26095b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.f26094a, a.class, "com.obric.aiagent.plugin");
        o.a(r13);     // Catch: Throwable -> L38
    L24:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r14 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (r14.a() == true) goto L28;
        com.obric.autogui.tools.api.net.b r15 = r14.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L38
        r15.b();     // Catch: Throwable -> L38
        Loog.INSTANCE.e(TAG, "heartbeatApiCall failed: " + r15.getType());     // Catch: Throwable -> L38
        return x.f38692a;
    L28:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        Loog.INSTANCE.d(TAG, "heartbeatApiCall response: " + r16 + ", requestBody: " + r9);     // Catch: Throwable -> L38
        JsonObject r17 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r16, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        JsonObject r18 = r17.getAsJsonObject("data");     // Catch: Throwable -> L38
        String r19 = r17.get("log_id").getAsString();     // Catch: Throwable -> L38
        JsonElement r110 = r18.get("task_status");     // Catch: Throwable -> L38
        if (r110 == null) goto L31;
        Integer r111 = d.c.b.a.b.a(r110.getAsInt());     // Catch: Throwable -> L38
    L32:
        Loog.INSTANCE.d(TAG, "heartbeatApiCall taskStatus: " + r111 + ", logId: " + r19);     // Catch: Throwable -> L38
        if (r111 == null) goto L41;
        if (r111.intValue() != com.obric.autogui.a.a.b.f26106e.a()) goto L41;
        r1.a("task completed");     // Catch: Throwable -> L38
    L41:
        return x.f38692a;
    L31:
        r111 = null;
        goto L32
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r13);
        Loog.INSTANCE.d(TAG, "heartbeatApiCall, sessionId: " + r10.b());
        com.obric.autogui.agents.vlm.models.b r112 = com.obric.autogui.agents.vlm.models.b.f27277a.a(((Number) ZeusTransformUtils.preCheckCast(com.obric.autogui.common.a.m.f28999a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).e().d(), Number.class, "com.obric.aiagent.plugin")).intValue());
        Loog.INSTANCE.d(TAG, "current modelName: " + r112.a());
        JSONObject r4 = new JSONObject();
        r4.put("session_id", r10.b());
        r4.put("session_origin", r10.l().getLaunchOrigin());
        r4.put("request_type", c.f26111e.a());
        r4.put("model_name", r112.a());
        r4.put("device_id", AODeviceInfo.INSTANCE.getRpDid());
        String r113 = com.obric.autogui.a.a.f26086a.a();
        com.obric.autogui.tools.api.net.a r6 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r6 != null) goto L20;
        Loog.INSTANCE.e(TAG, "heartbeatApiCall, client is null");
        return x.f38692a;
    L20:
        String r7 = r4.toString();     // Catch: Throwable -> L38
        d.h.b.o.c(r7, "toString(...)");     // Catch: Throwable -> L38
        r0.f26094a = this;     // Catch: Throwable -> L38
        r0.f26095b = r10;     // Catch: Throwable -> L38
        r0.f26096c = r4;     // Catch: Throwable -> L38
        r0.f = 1;     // Catch: Throwable -> L38
        r13 = r6.a(r113, r7, 60000, r0);     // Catch: Throwable -> L38
        if (r13 != r2) goto L23;
        return r2;
    L23:
        r1 = this;
        r9 = r4;
    L38:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "heartbeatApiCall error: " + th.getMessage());
    L7:
        r0 = new C0654a(this, r12);
        goto L8
    }
}
