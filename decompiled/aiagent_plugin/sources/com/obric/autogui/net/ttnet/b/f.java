package com.obric.autogui.net.ttnet.b;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.common.utility.j;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.ttnet.TTNetInit;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.a.m;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "TTNetInitHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f29233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Application f29234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f29235c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final g.l<com.bytedance.ttnet.d.b> f29236d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final g.d<com.bytedance.ttnet.d.b> f29237e = null;

    /* JADX INFO: compiled from: TTNetHelper.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f29238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29239b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f29238a == r6.f29238a) goto L12;
            return false;
        L12:
            if (o.a(this.f29239b, r6.f29239b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f29238a) * 31;
            String r1 = this.f29239b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "PpeConfig(isPpe=" + this.f29238a + ", ppeEnv=" + this.f29239b + ')';
        }

        public a(boolean r1, String r2) {
            this.f29238a = r1;
            this.f29239b = r2;
        }

        public final boolean a() {
            return this.f29238a;
        }

        public final String b() {
            return this.f29239b;
        }
    }

    /* JADX INFO: compiled from: TTNetHelper.kt */
    public static final class b implements g.d<com.bytedance.ttnet.d.b> {
        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public String a(String r1, boolean r2) {
            o.e(r1, "url");
            return r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public String a(String r1, boolean r2, Object... r3) {
            o.e(r1, "url");
            o.e(r3, "extra");
            return r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public void a() {
        }

        b() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public Map<String, String> a(int r2) {
            return (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: TTNetHelper.kt */
    public static final class c implements g.l<com.bytedance.ttnet.d.b> {
        c() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.l
        public /* synthetic */ void a(long r9, long r11, String r13, String r14, com.bytedance.frameworks.baselib.network.http.b r15) {
            a(r9, r11, r13, r14, (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r15, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.l
        public /* synthetic */ void a(long r11, long r13, String r15, String r16, com.bytedance.frameworks.baselib.network.http.b r17, Throwable r18) {
            a(r11, r13, r15, r16, (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r17, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin"), r18);
        }

        public void a(long r15, long r17, String r19, String r20, com.bytedance.ttnet.d.b r21, Throwable r22) {
            f.a(f.f29233a, true, r20, r19, r15, r17, r21);
            String[] r2 = new String[1];     // Catch: Throwable -> L28
            int r12 = com.obric.autogui.net.ttnet.b.a.a(r22, r2);     // Catch: Throwable -> L28
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L28
            if (r22 == null) goto L20;
            if (j.a(r22.getClass().getName()) == true) goto L20;
            r13.put("ex_name", r22.getClass().getName());     // Catch: Throwable -> L28
            if (r12 != 1) goto L12;
            if (ApmDelegate.a().a("ex_message_open") == false) goto L12;
        L13:
            String r1 = com.bytedance.ttnet.utils.e.a(r22);     // Catch: Throwable -> L28
            if (j.a(r1) == true) goto L16;
            r13.put("ex_message", r1);     // Catch: Throwable -> L28
        L16:
            String r3 = com.bytedance.ttnet.c.a();     // Catch: Throwable -> L28
            if (j.a(r3) == true) goto L20;
            r13.put("cronet_init_ex_message", r3);     // Catch: Throwable -> L28
        L12:
            if (ApmDelegate.a().a("debug_ex_message_open") == true) goto L13;
        L20:
            if (j.a(r2[0]) == false) goto L26;
            if (r21 == null) goto L24;
            String r4 = r21.w;     // Catch: Throwable -> L28
            if (r4 == null) goto L24;
        L25:
            r2[0] = r4;     // Catch: Throwable -> L28
        L24:
            r4 = "";
        L26:
            f.a(f.f29233a, r21, r13);     // Catch: Throwable -> L28
            com.bytedance.apm.b.b(r15, r17, r19, r2[0], r20, r12, r13);     // Catch: Throwable -> L28
            com.bytedance.apm.b.a(r15, r17, r19, r2[0], r20, r12, r13);     // Catch: Throwable -> L28
            return;
        L28:
            th = move-exception;
            th.printStackTrace();
        }

        public void a(long r14, long r16, String r18, String r19, com.bytedance.ttnet.d.b r20) {
            o.e(r18, "url");
            o.e(r19, "traceCode");
            f.a(f.f29233a, false, r19, r18, r14, r16, r20);
            String[] r1 = new String[1];     // Catch: Throwable -> L12
            JSONObject r12 = new JSONObject();     // Catch: Throwable -> L12
            if (j.a(r1[0]) == false) goto L10;
            if (r20 == null) goto L8;
            String r3 = r20.w;     // Catch: Throwable -> L12
            if (r3 == null) goto L8;
        L9:
            r1[0] = r3;     // Catch: Throwable -> L12
        L8:
            r3 = "";
        L10:
            f.a(f.f29233a, r20, r12);     // Catch: Throwable -> L12
            com.bytedance.apm.b.a(r14, r16, r18, r1[0], r19, 200, r12);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
        }
    }

    private f() {
    }

    public static final /* synthetic */ void a(f r0, com.bytedance.ttnet.d.b r1, JSONObject r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(f r0, boolean r1, String r2, String r3, long r4, long r6, com.bytedance.ttnet.d.b r8) {
        r0.a(r1, r2, r3, r4, r6, r8);
    }

    static {
        f29233a = new f();
        f29235c = new ConcurrentHashMap(4, 0.9f, 1);
        f29236d = (g.l) ZeusTransformUtils.preCheckCast(new c(), g.l.class, "com.obric.aiagent.plugin");
        f29237e = (g.d) ZeusTransformUtils.preCheckCast(new b(), g.d.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r1, long r2) {
        o.e(r1, "url");
        f29235c.put(r1, Long.valueOf(r2));
    }

    private final void a(String r7) {
        JSONObject r6 = new JSONObject(r7);     // Catch: Throwable -> L10
        Iterator<String> r8 = r6.keys();     // Catch: Throwable -> L10
        o.c(r8, "keys(...)");     // Catch: Throwable -> L10
    L4:
        if (r8.hasNext() == false) goto L18;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        o.a(r0);     // Catch: Throwable -> L10
        String r1 = r0.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L10
        o.c(r1, "toLowerCase(...)");     // Catch: Throwable -> L10
        Object r2 = r6.get(r1);     // Catch: Throwable -> L10
        if (d.o.o.b(r1, "x-tt", false, 2, null) == false) goto L4;
        Loog.INSTANCE.i(TAG, " - [header] `" + r1 + "` = " + r2);     // Catch: Throwable -> L10
    L18:
        return;
    }

    private final void a(boolean r4, String r5, String r6, long r7, long r9, com.bytedance.ttnet.d.b r11) {
        Loog.INSTANCE.i(TAG, "[TTNet headers - isError=" + r4 + ']');
        Loog.INSTANCE.i(TAG, " - [url|traceCode] = " + r6 + " | " + r5);
        Loog.INSTANCE.i(TAG, " - [duration|sendTime] = " + r7 + " | " + r9);
        if (r11 == null) goto L7;
        String r8 = r11.M;
        if (r8 == null) goto L7;
        a(r8);
    L7:
        if (r11 == null) goto L12;
        String r10 = r11.N;
        if (r10 == null) goto L13;
        a(r10);
        return;
    L13:
        return;
    }

    private final void a(com.bytedance.ttnet.d.b r3, JSONObject r4) {
        if (r3 == null) goto L18;
        if (r4 == null) goto L19;
        r4.put("cronet_plugin_install", TTNetInit.getTTNetDepend().a());     // Catch: JSONException -> L13
        r4.put("appLevelRequestStart", r3.f8139e);     // Catch: JSONException -> L13
        r4.put("beforeAllInterceptors", r3.f);     // Catch: JSONException -> L13
        r4.put("requestStart", r3.g);     // Catch: JSONException -> L13
        r4.put("responseBack", r3.h);     // Catch: JSONException -> L13
        r4.put("completeReadResponse", r3.i);     // Catch: JSONException -> L13
        r4.put("requestEnd", r3.j);     // Catch: JSONException -> L13
        r4.put("recycleCount", r3.C);     // Catch: JSONException -> L13
        if (r3.G != 0) goto L9;
        r4.put("timing_dns", r3.n);     // Catch: JSONException -> L13
        r4.put("timing_connect", r3.o);     // Catch: JSONException -> L13
        r4.put("timing_ssl", r3.p);     // Catch: JSONException -> L13
        r4.put("timing_send", r3.q);     // Catch: JSONException -> L13
        r4.put("timing_waiting", r3.s);     // Catch: JSONException -> L13
        r4.put("timing_receive", r3.t);     // Catch: JSONException -> L13
        r4.put("timing_total", r3.u);     // Catch: JSONException -> L13
        r4.put("timing_isSocketReused", r3.D);     // Catch: JSONException -> L13
        r4.put("timing_totalSendBytes", r3.x);     // Catch: JSONException -> L13
        r4.put("timing_totalReceivedBytes", r3.y);     // Catch: JSONException -> L13
        r4.put("timing_remoteIP", r3.w);     // Catch: JSONException -> L13
        r4.put(MonitorConstants.REQUEST_LOG, r3.f8134J);     // Catch: JSONException -> L13
    L9:
        if (r3.K == null) goto L11;
        r4.put("req_info", r3.K);     // Catch: JSONException -> L13
    L11:
        r4.put("streaming", r3.L);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[packageRequestParamters] json op error. ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L19:
        return;
    }

    public final a a() {
        String r7 = AutoActionConfigs.INSTANCE.getStringCfg("network.ppe_env");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        Loog.INSTANCE.d(TAG, "use ppe env from settings: " + r7);
        return new a(true, r7);
    L13:
        m r8 = m.f28999a;
        Application r3 = f29234b;
        if (ZeusTransformUtils.instanceOf(r3, Context.class) == false) goto L16;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin");
    L17:
        if (r4 != null) goto L19;
        r4 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L19:
        k r9 = r8.a(r4);
        com.obric.autogui.common.a.g r5 = r9.h();
        if (((Number) ZeusTransformUtils.preCheckCast(r5.d(), Number.class, "com.obric.aiagent.plugin")).intValue() != 2) goto L24;
        Loog.INSTANCE.d(TAG, "This is a build for test");
        return new a(true, "ppe_oauto_eval");
    L24:
        if (((Number) ZeusTransformUtils.preCheckCast(r5.d(), Number.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L26;
        r2 = true;
    L26:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.l().d(), String.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "isPpe, type: " + r5 + ", result: " + r2 + ", env=" + r10);
        return new a(r2, r10);
    L16:
        r4 = null;
        goto L17
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
