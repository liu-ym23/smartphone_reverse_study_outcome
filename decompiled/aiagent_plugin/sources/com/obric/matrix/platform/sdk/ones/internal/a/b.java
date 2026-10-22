package com.obric.matrix.platform.sdk.ones.internal.a;

import android.content.Context;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.framwork.core.sdkmonitor.h;
import com.obric.matrix.platform.sdk.ones.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SdkMonitorManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "SdkMonitorManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f33681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f33682c;

    /* JADX INFO: compiled from: SdkMonitorManager.kt */
    public static final class a implements h.a {
        @Override // com.bytedance.framwork.core.sdkmonitor.h.a
        public String a() {
            return null;
        }

        a() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.h.a
        public Map<String, String> b() {
            if (b.a(b.f33680a) == false) goto L5;
            String r4 = "1";
        L6:
            m[] r0 = new m[2];
            com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
            if (r2 == null) goto L10;
            String r3 = r2.a();
            if (r3 == null) goto L10;
        L11:
            r0[0] = s.a("host_aid", r3);
            r0[1] = s.a("oversea", r4);
            return ao.b(r0);
        L10:
            r3 = "";
            goto L11
        L5:
            r4 = "0";
            goto L6
        }
    }

    private final int d() {
        return BuildConfig.SDK_VERSION_CODE;
    }

    private final String e() {
        return BuildConfig.SDK_VERSION_NAME;
    }

    private final String g() {
        return "release";
    }

    private b() {
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.f();
    }

    static {
        f33680a = new b();
        f33682c = "ones_sdk";
    }

    private final String a() {
        f();
        return "568500";
    }

    private final String b() {
        if (f() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";
    L5:
        return "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    }

    private final String c() {
        if (f() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/collect/";
    L5:
        return "https://mon.snssdk.com/monitor/collect/";
    }

    public final void a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        SDKMonitorUtils.a(a(), p.a(b()));
        SDKMonitorUtils.b(a(), p.a(c()));
        String r3 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "sdk aid " + a() + " , config url " + b() + " \n , reporturl " + c(), null, 4, null);
        JSONObject r0 = new JSONObject();
        com.obric.matrix.platform.sdk.ones.a r5 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
        if (r5 == null) goto L5;
        String r6 = r5.c();
    L6:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "device_id = " + r6, null, 4, null);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == false) goto L16;
        f33681b = false;
        return;
    L16:
        r0.put("device_id", r6);
        r0.put("sdk_version", e());
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "sdk version = " + e(), null, 4, null);
        com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
        if (r2 == null) goto L19;
        String r4 = r2.a();
    L20:
        r0.put("host_aid", r4);
        com.obric.matrix.platform.sdk.ones.a r9 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
        if (r9 == null) goto L23;
        r3 = r9.b();
    L23:
        r0.put(WsConstants.KEY_APP_VERSION, r3);
        r0.put("channel", g());
        SDKMonitorUtils.a(r11, a(), r0, (h.a) ZeusTransformUtils.preCheckCast(new a(), h.a.class, "com.obric.aiagent.plugin"));
        f33681b = true;
        return;
    L19:
        r4 = null;
        goto L20
    L9:
        if (r7.length() == 0) goto L12;
        r8 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public final void a(String r3, JSONObject r4) {
        o.e(r3, "eventName");
        o.e(r4, "category");
        a(r3, r4, new JSONObject(), new JSONObject());
    }

    public final void a(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        o.e(r8, "eventName");
        o.e(r9, "category");
        o.e(r10, "metric");
        o.e(r11, "logExtr");
    L24:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "event report exception " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), null, 4, null);
        return;
    L4:
        if (f33681b == true) goto L22;
        com.obric.matrix.platform.sdk.ones.a r4 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();     // Catch: Exception -> L24
        if (r4 == null) goto L8;
        String r5 = r4.c();     // Catch: Exception -> L24
    L9:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "on event device_id = " + r5, null, 4, null);     // Catch: Exception -> L24
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L19;
        f33681b = false;     // Catch: Exception -> L24
        return;
    L19:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.b.f33630a.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (r12 == null) goto L22;
        f33680a.a(r12);     // Catch: Exception -> L24
        goto L22
    L12:
        if (r6.length() == 0) goto L15;
        r7 = false;
        goto L16
    L8:
        r5 = null;
    L22:
        r9.put("sdk_version_code", d());     // Catch: Exception -> L24
        r9.put("sdk_name", f33682c);     // Catch: Exception -> L24
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "event " + r8 + ", category: " + r9 + ", metric " + r10 + ", logExtr " + r11, null, 4, null);     // Catch: Exception -> L24
        SDKMonitorUtils.a(a()).a(r8, r9, r10, r11);     // Catch: Exception -> L24
    }

    private final boolean f() {
        com.obric.matrix.platform.sdk.ones.a r0 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }
}
