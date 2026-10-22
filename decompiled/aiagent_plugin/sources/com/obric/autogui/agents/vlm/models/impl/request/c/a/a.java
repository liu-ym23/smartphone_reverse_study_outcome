package com.obric.autogui.agents.vlm.models.impl.request.c.a;

import android.content.Context;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.t;

/* JADX INFO: compiled from: StdModelSSEStreamingImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.agents.vlm.models.impl.request.c.a {
    private static final String TAG = "M-Std-SSE/SShot";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0707a f28057b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f28058c;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StdModelSSEStreamingImpl.kt */
    public static final class C0707a {
        public /* synthetic */ C0707a(h r1) {
            this();
        }

        private C0707a() {
        }
    }

    /* JADX INFO: compiled from: StdModelSSEStreamingImpl.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlinx.coroutines.a.d<f> f28060b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28059a, r6.f28059a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f28060b, r6.f28060b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f28059a.hashCode() * 31) + this.f28060b.hashCode();
        }

        public String toString() {
            return "StreamingResponseChannelEntry(requestId=" + this.f28059a + ", replyChannel=" + this.f28060b + ')';
        }

        public b(String r3, kotlinx.coroutines.a.d<f> r4) {
            kotlinx.coroutines.a.d<f> r5 = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
            o.e(r3, "requestId");
            o.e(r5, "replyChannel");
            this.f28059a = r3;
            this.f28060b = r5;
        }

        public final kotlinx.coroutines.a.d<f> a() {
            return this.f28060b;
        }
    }

    /* JADX INFO: compiled from: StdModelSSEStreamingImpl.kt */
    @d.c.b.a.f(b = "StdModelSSEStreamingImpl.kt", c = {183}, d = "requestModel", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.streaming.StdModelSSEStreamingImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f28065e;
        final /* synthetic */ a f;
        int g;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f28065e = r8;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StdModelSSEStreamingImpl.kt */
    public static final class d implements com.obric.autogui.tools.api.net.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f28066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f28067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.b.C0677b f28068c;

        d(String r1, a r2, com.obric.autogui.agents.vlm.b.C0677b r3) {
            this.f28066a = r1;
            this.f28067b = r2;
            this.f28068c = r3;
        }

        @Override // com.obric.autogui.tools.api.net.a.a
        public void a() {
            Loog.INSTANCE.d(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onStart");
        }

        @Override // com.obric.autogui.tools.api.net.a.a
        public void a(String r23) {
            o.e(r23, "snapshot");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L36;
            Iterator r3 = p.h(d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"))).iterator();
        L9:
            if (r3.hasNext() == false) goto L59;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
            if (d.o.o.b(r5, "data:", false, 2, null) == true) goto L12;
            if (d.o.o.b(r5, "{", false, 2, null) == false) goto L9;
            if (d.o.o.c(r5, "}", false, 2, null) == false) goto L9;
            JsonObject r6 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r5, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            int r7 = r6.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L35
            String r8 = r6.get("msg").getAsString();     // Catch: Throwable -> L35
            JsonElement r9 = r6.get("data");     // Catch: Throwable -> L35
            String r10 = r6.get("log_id").getAsString();     // Catch: Throwable -> L35
            if (ZeusTransformUtils.instanceOf(r9, JsonNull.class) == false) goto L9;
            Loog.INSTANCE.e(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onStreamOutput, eCode=" + r7 + ", eMsg=" + r8 + ", eLogId=" + r10);     // Catch: Throwable -> L35
            b r11 = (b) ZeusTransformUtils.preCheckCast(a.a(this.f28067b).get(this.f28066a), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            if (r11 == null) goto L9;
            kotlinx.coroutines.a.d<f> r12 = r11.a();     // Catch: Throwable -> L35
            if (r12 == null) goto L9;
            String r14 = this.f28066a;     // Catch: Throwable -> L35
            o.a(r8);     // Catch: Throwable -> L35
            o.a(r10);     // Catch: Throwable -> L35
            kotlinx.coroutines.a.h.i(r12.a_(new f(r14, "", true, null, new e(r7, r8, r10), null, 40, null)));     // Catch: Throwable -> L35
        L35:
            Loog.INSTANCE.e(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onStreamOutput, maybeErrorInfo=" + r5);
            goto L9
        L12:
            String r15 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.b(r5, "data:", null, 2, null), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (d.o.o.c(r15, "}", false, 2, null) == false) goto L9;
            if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L18;
            Loog.INSTANCE.d(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onStreamOutput, snapshot-length=" + r23.length());
        L18:
            b r1 = (b) ZeusTransformUtils.preCheckCast(a.a(this.f28067b).get(this.f28066a), b.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L56;
            kotlinx.coroutines.a.d<f> r4 = r1.a();
            if (r4 == null) goto L57;
            kotlinx.coroutines.a.h.i(r4.a_(new f(this.f28066a, r15, false, null, null, null, 56, null)));
            return;
        L57:
            return;
        L56:
            return;
        L59:
            return;
        L36:
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.obric.autogui.tools.api.net.a.a
        public void b(String r13) {
            Loog.INSTANCE.d(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onFinish (lId=" + r13 + ')');
            b r0 = (b) ZeusTransformUtils.preCheckCast(a.a(this.f28067b).remove(this.f28066a), b.class, "com.obric.aiagent.plugin");
            StringBuilder r1 = new StringBuilder();
            String r3 = this.f28066a;
            com.obric.autogui.agents.vlm.b.C0677b r4 = this.f28068c;
            r1.append("l=" + r13);
            r1.append(";r=" + r3);
            r1.append(";s=" + r4.a().b());
            r1.append(";o=" + r4.a().l().getLaunchOrigin());
            String r9 = r1.toString();
            o.c(r9, "toString(...)");
            if (r0 == null) goto L8;
            kotlinx.coroutines.a.d<f> r14 = r0.a();
            if (r14 == null) goto L9;
            r14.a_(new f(this.f28066a, "", true, null, null, r9, 24, null));
            t.a.a((t) ZeusTransformUtils.preCheckCast(r14, t.class, "com.obric.aiagent.plugin"), null, 1, null);
            return;
        L9:
            return;
        }

        @Override // com.obric.autogui.tools.api.net.a.a
        public void a(com.obric.autogui.tools.api.net.b r13) {
            com.obric.autogui.tools.api.net.b r6 = (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
            o.e(r6, "analysedError");
            Loog.INSTANCE.d(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onError, excp=" + r6.getType());
            b r14 = (b) ZeusTransformUtils.preCheckCast(a.a(this.f28067b).remove(this.f28066a), b.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L6;
            r14.a().a_(new f(this.f28066a, "", true, r6, null, null, 48, null));
            t.a.a((t) ZeusTransformUtils.preCheckCast(r14.a(), t.class, "com.obric.aiagent.plugin"), null, 1, null);
            return;
        }

        @Override // com.obric.autogui.tools.api.net.a.a
        public void c(String r3) {
            o.e(r3, "logId");
            Loog.INSTANCE.d(a.TAG, " - [SSE-Streaming/" + this.f28066a + "] postSSE onGetLogID");
        }
    }

    static {
        f28057b = new C0707a(null);
    }

    public static final /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f28058c;
    }

    public a() {
        this.f28058c = new ConcurrentHashMap();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r16, String r17, String r18, int r19, JsonObject r20, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r21) {
        a r0 = this;
        com.obric.autogui.agents.vlm.b.C0677b r1 = r16;
        String r2 = r18;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L7;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
        r5.g -= Integer.MIN_VALUE;
    L8:
        c r13 = r5;
        Object r4 = r13.f28065e;
        Object r6 = d.c.a.b.a();
        int r7 = r13.g;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r13.f28064d, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r13.f28063c, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r10 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r13.f28062b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        a r11 = (a) ZeusTransformUtils.preCheckCast(r13.f28061a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        Object r12 = r4;
        String r14 = r9;
        r1 = r10;
        r2 = r8;
        r0 = r11;
    L25:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r15 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");
        if (r15.a() == false) goto L29;
        com.obric.autogui.tools.api.net.a.b r22 = (com.obric.autogui.tools.api.net.a.b) ZeusTransformUtils.preCheckCast(r15.c(), com.obric.autogui.tools.api.net.a.b.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.a.d r23 = g.a(0, null, null, 7, null);
        ((Map) ZeusTransformUtils.preCheckCast(r0.f28058c, Map.class, "com.obric.aiagent.plugin")).put(r2, new b(r2, r23));
        return new com.obric.autogui.agents.vlm.models.impl.request.c.a.c(r1, r14, r2, r23, r22);
    L29:
        com.obric.autogui.tools.api.net.b r24 = r15.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.d(TAG, " - [SSE-Streaming/" + r2 + "] postSSE got-Error, excp=" + r24.getType());
        return r0.a(r24);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        com.obric.autogui.tools.api.net.a r25 = a();
        if (r25 != null) goto L19;
        Loog.INSTANCE.e(TAG, " - [streaming] Std model client not configured.");
        return b();
    L19:
        if (r0.f28058c.contains(r2) == false) goto L22;
        Loog.INSTANCE.e(TAG, " - [streaming] requestModelStreaming, requestId=" + r2 + " already exists.");
        return b();
    L22:
        d r26 = new d(r2, this, r1);
        Context r27 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.a r110 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.preCheckCast(r26, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
        r13.f28061a = r0;
        r13.f28062b = r1;
        r14 = r17;
        r13.f28063c = r14;
        r13.f28064d = r2;
        r13.g = 1;
        r12 = r25.a(r27, "auto_action/api/task/inference", r20, r19, true, r110, r13);
        if (r12 != r6) goto L25;
        return r6;
    L7:
        r5 = new c(this, r3);
        goto L8
    }
}
