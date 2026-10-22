package com.bytedance.reparo.c;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.reparo.IReparoConfig;
import com.bytedance.reparo.core.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorService.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String TAG = "MonitorService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.framwork.core.sdkmonitor.h f9121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f9122b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f9123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static IReparoConfig f9124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Application f9125e;

    public g() {
    }

    static {
        f9122b = new AnonymousClass1();
        f9123c = false;
        f9124d = null;
        f9125e = null;
    }

    public static void a(Application r2, IReparoConfig r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        f9124d = r3;
        f9125e = r4;
    }

    public static void b(Application r2, IReparoConfig r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        f9124d = r3;
        f9125e = r4;
        d();
    }

    public static boolean a() {
        return f9123c;
    }

    private static void d() {
        if (f9123c == false) goto L5;
        return;
    L5:
        if (f9125e == null) goto L15;
        IReparoConfig r0 = f9124d;
        if (r0 != null) goto L10;
        return;
    L10:
        if (b.a(r0.getDeviceId()) == true) goto L12;
        return;
    L12:
        f9123c = true;
        a(f9125e, f9124d.getDeviceId(), f9124d.getAppId(), f9124d.getChannel(), f9124d.getUpdateVersionCode());
        return;
    }

    public static void a(Application r1, String r2, String r3, String r4, String r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r1, Application.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        r7.put("device_id", r2);     // Catch: JSONException -> L5
        r7.put("host_aid", r3);     // Catch: JSONException -> L5
        r7.put("channel", "release");     // Catch: JSONException -> L5
        r7.put(WsConstants.KEY_APP_VERSION, "0.0.4-rc.50");     // Catch: JSONException -> L5
        r7.put("update_version_code", r5);     // Catch: JSONException -> L5
        r7.put("package_name", r6.getPackageName());     // Catch: JSONException -> L5
    L7:
        SDKMonitorUtils.a("7506", Collections.singletonList("https://mon.snssdk.com/monitor/appmonitor/v2/settings"));
        SDKMonitorUtils.b("7506", Collections.singletonList("https://mon.snssdk.com/monitor/collect/"));
        SDKMonitorUtils.a(r6, "7506", r7, new AnonymousClass2());
        e.a(TAG, "real init with did: " + r2);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static String b() {
        String r0 = Build.BRAND;
        String r1 = Build.MODEL;
        if (TextUtils.isEmpty(r1) == false) goto L7;
        if (r0 != null) goto L13;
        return "UNKNOWN";
    L13:
        return r0;
    L7:
        if (r0 != null) goto L9;
    L12:
        return r1;
    L9:
        if (r1.contains(r0) == true) goto L12;
        return r0 + ' ' + r1;
    }

    static com.bytedance.framwork.core.sdkmonitor.h c() {
        if (f9121a == null) goto L5;
    L14:
        d();
        return f9121a;
    L5:
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9121a != null) goto L9;
        f9121a = SDKMonitorUtils.a("7506");     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void a(com.bytedance.reparo.core.a.a.a r7) {
        String r0 = r7.a();
        if (TextUtils.isEmpty(r0) == true) goto L10;
        Map<String, String> r1 = f9122b;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1.get(r0), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get(r0), String.class, "com.obric.aiagent.plugin");
        JSONObject r5 = r7.e();     // Catch: JSONException -> L12
        JSONObject r4 = a(r7.f());     // Catch: JSONException -> L12
        JSONObject r6 = r7.g();     // Catch: JSONException -> L12
        c().a(r2, r7.l(), r4, r5, r6);     // Catch: JSONException -> L12
        return;
    L15:
        return;
    L10:
        b(r7);
    }

    private static void b(com.bytedance.reparo.core.a.a.a r2) {
        if (r2.k() == false) goto L6;
        e.a(TAG, r2.toString());
        return;
    L6:
        if (r2.c() == null) goto L8;
        e.a(TAG, r2.a(), r2.c());
        return;
    L8:
        e.b(TAG, r2.toString());
    }

    private static JSONObject a(JSONObject r3) {
        if (r3 != null) goto L7;
        r3 = new JSONObject();
    L7:
        r3.put("is_64_device", com.bytedance.reparo.d.a.a());     // Catch: Throwable -> L6
        r3.put("is_x86_device", com.bytedance.reparo.d.a.b());     // Catch: Throwable -> L6
        r3.put("api_level", Build.VERSION.SDK_INT);     // Catch: Throwable -> L6
        r3.put("sdk_channel", "release");     // Catch: Throwable -> L6
        r3.put("is_64_runtime", m.a().c().contains("64"));     // Catch: Throwable -> L6
    L5:
        return r3;
    }
}
