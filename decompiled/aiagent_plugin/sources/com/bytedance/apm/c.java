package com.bytedance.apm;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.s;
import com.bytedance.apm.util.t;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.services.apm.api.IHttpService;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApmContext.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static boolean A;
    private static long B;
    private static boolean C;
    private static List<String> D;
    private static String E;
    private static boolean F;
    private static f G;
    private static boolean H;
    private static d I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static com.bytedance.apm.core.d f4454J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static long f4455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static long f4456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static long f4457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static long f4458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Context f4459e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static long i;
    private static long j;
    private static long k;
    private static JSONObject l;
    private static com.bytedance.apm.core.b m;
    private static Map<String, String> n;
    private static IHttpService o;
    private static com.bytedance.services.apm.api.i p;
    private static long q;
    private static volatile int r;
    private static boolean s;
    private static long t;
    private static long u;
    private static long v;
    private static long w;
    private static String x;
    private static boolean y;
    private static boolean z;

    static {
        l = new JSONObject();
        m = new com.bytedance.apm.core.a();
        n = Collections.emptyMap();
        o = new DefaultHttpServiceImpl();
        q = -1;
        r = -1;
        s = false;
        B = 0;
        C = true;
        F = true;
        H = false;
        I = null;
        f4454J = null;
    }

    public static void a(boolean r0) {
        H = r0;
    }

    public static Context getContext() {
        return f4459e;
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        f4459e = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.util.a.a(r3), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    public static void a(String r0) {
        x = r0;
    }

    public static void a(long r0) {
        i = r0;
    }

    public static void b(long r0) {
        j = r0;
    }

    public static void c(long r0) {
        f4455a = r0;
    }

    public static void d(long r0) {
        f4456b = r0;
    }

    public static void e(long r0) {
        f4457c = r0;
    }

    public static void f(long r0) {
        f4458d = r0;
    }

    public static void g(long r0) {
        k = r0;
    }

    public static boolean a() {
        return C;
    }

    public static d b() {
        return I;
    }

    public static String c() {
        if (TextUtils.isEmpty(x) == false) goto L6;
        x = com.bytedance.apm.util.a.a(Process.myPid());
    L6:
        return x;
    }

    public static boolean d() {
        boolean r1 = true;
        if (y == false) goto L6;
        return true;
    L6:
        if (f4459e == null) goto L8;
        String r0 = c();
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L16;
    L18:
        r1 = false;
    L19:
        y = r1;
    L21:
        return y;
    L16:
        if (r0.equals(f4459e.getPackageName()) == false) goto L18;
    L12:
        if (r0.contains(":") == false) goto L14;
        y = false;
        goto L21
    L8:
        return e();
    }

    public static boolean e() {
        if (y == false) goto L5;
        return true;
    L5:
        String r0 = c();
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.contains(":") == false) goto L11;
        return false;
    }

    public static boolean f() {
        return s;
    }

    public static String h(long r2) {
        long r3 = r2 - u;
        if (r3 >= OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS) goto L7;
        return "0 - 30s";
    L7:
        if (r3 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r3 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r3 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r3 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r3 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r3 >= DownloadConstants.HOUR) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static long g() {
        if (q != (-1)) goto L6;
        q = System.currentTimeMillis();
    L6:
        return q;
    }

    public static int h() {
        return r;
    }

    public static void a(int r0) {
        r = r0;
    }

    public static void b(boolean r0) {
        f = r0;
        com.bytedance.apm6.foundation.context.a.a(i());
    }

    public static void c(boolean r0) {
        g = r0;
    }

    public static boolean i() {
        if (f == false) goto L5;
    L8:
        return true;
    L5:
        if (h == true) goto L8;
        return false;
    }

    public static boolean j() {
        return g;
    }

    public static synchronized void a(JSONObject r6) {
        monitor-enter(c.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (G != null) goto L7;
        G = new f();     // Catch: Throwable -> L23 Exception -> L71
    L7:
        r6.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Throwable -> L23 Exception -> L71
        r6.put("device_platform", "android");     // Catch: Throwable -> L23 Exception -> L71
        r6.put(RomInfo.KEY_ROM_OS_VERSION, Build.VERSION.RELEASE);     // Catch: Throwable -> L23 Exception -> L71
        r6.put(RomInfo.KEY_ROM_OS_API, Build.VERSION.SDK_INT);     // Catch: Throwable -> L23 Exception -> L71
        r6.put(HardwareInfo.KEY_HW_VENDOR_MODEL, Build.MODEL);     // Catch: Throwable -> L23 Exception -> L71
        r6.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);     // Catch: Throwable -> L23 Exception -> L71
        r6.put(HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, Build.MANUFACTURER);     // Catch: Throwable -> L23 Exception -> L71
        r6.put("process_name", com.bytedance.apm.util.a.a(Process.myPid()));     // Catch: Throwable -> L23 Exception -> L71
        r6.put("sid", g());     // Catch: Throwable -> L23 Exception -> L71
        r6.put("phone_startup_time", t());     // Catch: Throwable -> L23 Exception -> L71
        r6.put("verify_info", t.a());     // Catch: Throwable -> L23 Exception -> L71
        r6.put("rom_version", s.a());     // Catch: Throwable -> L23 Exception -> L71
        PackageInfo r1 = null;
        if (r6.has("version_name") == true) goto L11;
        r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName(), 0);     // Catch: Throwable -> L23 Exception -> L71
        r6.put("version_name", r1.versionName);     // Catch: Throwable -> L23 Exception -> L71
    L11:
        if (TextUtils.isEmpty(r6.optString(WsConstants.KEY_APP_VERSION)) == false) goto L14;
        r6.put(WsConstants.KEY_APP_VERSION, r6.optString("version_name"));     // Catch: Throwable -> L23 Exception -> L71
    L14:
        if (r6.has("version_code") == true) goto L19;
        if (r1 != null) goto L17;
        r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName(), 0);     // Catch: Throwable -> L23 Exception -> L71
    L17:
        r6.put("version_code", r1.versionCode);     // Catch: Throwable -> L23 Exception -> L71
    L19:
        if (TextUtils.isEmpty(r6.optString("package")) == false) goto L21;
        r6.put("package", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());     // Catch: Throwable -> L23 Exception -> L71
    L21:
        r6.put(MonitorConstants.EXTRA_MONITOR_VERSION, "5.0.21.41");     // Catch: Throwable -> L23 Exception -> L71
    L25:
        G.b(r6.optString("process_name"));     // Catch: Throwable -> L23
        G.a(r6.optString("device_id"));     // Catch: Throwable -> L23
        G.a(r6.optInt(WsConstants.KEY_APP_ID));     // Catch: Throwable -> L23 Exception -> L72
        G.c(r6.optString("channel"));     // Catch: Throwable -> L23 Exception -> L72
        if (r6.has("update_version_code") == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r6.get("update_version_code"), String.class) == false) goto L31;
        G.b(Integer.valueOf(r6.optString("update_version_code")).intValue());     // Catch: Throwable -> L23 Exception -> L72
        goto L33
    L31:
        G.b(r6.optInt("update_version_code"));     // Catch: Throwable -> L23 Exception -> L72
    L33:
        if (r6.has("version_name") == false) goto L36;
        G.d(r6.optString("version_name"));     // Catch: Throwable -> L23 Exception -> L72
    L36:
        if (r6.has("manifest_version_code") == false) goto L42;
        if (ZeusTransformUtils.instanceOf(r6.get("manifest_version_code"), String.class) == false) goto L40;
        G.c(Integer.valueOf(r6.optString("manifest_version_code")).intValue());     // Catch: Throwable -> L23 Exception -> L72
        goto L42
    L40:
        G.c(r6.optInt("manifest_version_code"));     // Catch: Throwable -> L23 Exception -> L72
    L42:
        if (r6.has("version_code") == false) goto L48;
        if (ZeusTransformUtils.instanceOf(r6.get("version_code"), String.class) == false) goto L46;
        G.d(Integer.valueOf(r6.optString("version_code")).intValue());     // Catch: Throwable -> L23 Exception -> L72
        goto L48
    L46:
        G.d(r6.optInt("version_code"));     // Catch: Throwable -> L23 Exception -> L72
    L48:
        if (r6.has(WsConstants.KEY_APP_VERSION) == false) goto L50;
        G.e(r6.optString(WsConstants.KEY_APP_VERSION));     // Catch: Throwable -> L23 Exception -> L72
    L50:
        String r2 = t.a();     // Catch: Throwable -> L23 Exception -> L72
        if (TextUtils.isEmpty(r2) == true) goto L56;
        if (r2.equals("null") == true) goto L56;
        r6.put("release_build", r2);     // Catch: Throwable -> L23 Exception -> L72
        G.f(r6.optString("release_build"));     // Catch: Throwable -> L23 Exception -> L72
    L56:
        if (t.a().isEmpty() == true) goto L58;
        G.f(t.a());     // Catch: Throwable -> L23 Exception -> L72
    L58:
        G.a(com.bytedance.apm.util.i.d(r6));     // Catch: Throwable -> L23
        if (l != null) goto L61;
        l = r6;     // Catch: Throwable -> L23
    L67:
        monitor-exit(c.class);
        return;
    L61:
        Iterator<String> r3 = r6.keys();     // Catch: Throwable -> L23
    L63:
        if (r3.hasNext() == false) goto L67;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        l.put(r4, r6.get(r4));     // Catch: Throwable -> L23 JSONException -> L73
        goto L63
    }

    public static void a(IHttpService r2) {
        IHttpService r3 = (IHttpService) ZeusTransformUtils.wrapperContextForParams(r2, IHttpService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        o = r3;
        return;
    }

    public static void a(com.bytedance.services.apm.api.i r2) {
        p = (com.bytedance.services.apm.api.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.services.apm.api.i.class, "com.obric.aiagent.plugin");
    }

    public static com.bytedance.services.apm.api.i k() {
        return p;
    }

    public static boolean l() {
        JSONObject r0 = l;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.optString("channel") != null) goto L8;
        return false;
    L8:
        return l.optString("channel").contains("local");
    }

    public static synchronized f m() {
        monitor-enter(c.class);
        f r1 = G;     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> n() {
        monitor-enter(c.class);
        com.bytedance.apm.core.d r1 = f4454J;     // Catch: Throwable -> L25
        if (r1 == null) goto L17;
        Map<String, String> r2 = r1.a();     // Catch: Throwable -> L25
        if (r2 == null) goto L17;
        if (r2.size() <= 0) goto L17;
        if (G.l() == null) goto L15;
        HashMap r3 = new HashMap(G.l());     // Catch: Throwable -> L25
        r3.putAll(r2);     // Catch: Throwable -> L25
        monitor-exit(c.class);
        return r3;
    L15:
        monitor-exit(c.class);
        return r2;
    L17:
        f r4 = G;     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        Map<String, String> r5 = r4.l();     // Catch: Throwable -> L25
        monitor-exit(c.class);
        return r5;
    L23:
        monitor-exit(c.class);
        return null;
    L25:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(com.bytedance.apm.core.d r3) {
        monitor-enter(c.class);
        f4454J = (com.bytedance.apm.core.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.core.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(com.bytedance.apm.core.b r4) {
        monitor-enter(c.class);
        com.bytedance.apm.core.b r5 = (com.bytedance.apm.core.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.apm.core.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        m = r5;     // Catch: Throwable -> L39
        Map<String, String> r6 = r5.a();     // Catch: Throwable -> L39
        n = r6;     // Catch: Throwable -> L39
        if (r6 != null) goto L8;
        n = new HashMap();     // Catch: Throwable -> L39
    L8:
        if (n.containsKey(WsConstants.KEY_APP_ID) == true) goto L11;
        n.put(WsConstants.KEY_APP_ID, l.optString(WsConstants.KEY_APP_ID));     // Catch: Throwable -> L39
    L11:
        if (n.containsKey("device_id") == true) goto L14;
        n.put("device_id", l.optString("device_id"));     // Catch: Throwable -> L39
    L14:
        if (n.containsKey("device_platform") == true) goto L16;
        n.put("device_platform", "android");     // Catch: Throwable -> L39
    L16:
        n.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Throwable -> L39
        if (n.containsKey("update_version_code") == true) goto L20;
        n.put("update_version_code", l.optString("update_version_code"));     // Catch: Throwable -> L39
    L20:
        if (n.containsKey("version_code") == true) goto L23;
        n.put("version_code", l.optString("version_code"));     // Catch: Throwable -> L39
    L23:
        if (n.containsKey("channel") == true) goto L26;
        n.put("channel", l.optString("channel"));     // Catch: Throwable -> L39
    L26:
        if (n.containsKey(RomInfo.KEY_ROM_OS_API) == true) goto L29;
        n.put(RomInfo.KEY_ROM_OS_API, Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L39
    L29:
        if (i() == false) goto L34;
        if (n.containsKey("_log_level") == true) goto L34;
        n.put("_log_level", "debug");     // Catch: Throwable -> L39
    L34:
        if (G != null) goto L36;
        G = new f();     // Catch: Throwable -> L39
    L36:
        G.a(new HashMap(n));     // Catch: Throwable -> L39
        monitor-exit(c.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> o() {
        monitor-enter(c.class);
        com.bytedance.apm.core.d r1 = f4454J;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        Map<String, String> r2 = r1.a();     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r2.size() <= 0) goto L13;
        HashMap r3 = new HashMap(n);     // Catch: Throwable -> L16
        r3.putAll(r2);     // Catch: Throwable -> L16
        monitor-exit(c.class);
        return r3;
    L13:
        Map<String, String> r4 = n;     // Catch: Throwable -> L16
        monitor-exit(c.class);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static JSONObject p() {
        return l;
    }

    public static JSONObject q() {
        return new JSONObject(String.valueOf(l));
    L5:
        return new JSONObject();
    }

    public static boolean a(String r2, String r3) {
        if (l != null) goto L6;
        return false;
    L6:
        if (r2.equals("release_build") == false) goto L12;
        return false;
    L12:
        l.put(r2, r3);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static com.bytedance.apm.core.b r() {
        return m;
    }

    public static IHttpService s() {
        return o;
    }

    public static com.bytedance.services.apm.api.c a(String r2, byte[] r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return o.doPost(r2, r3, r5);
    }

    public static com.bytedance.services.apm.api.c a(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return o.doGet(r2, r4);
    }

    public static com.bytedance.services.apm.api.c a(String r2, List<File> r3, Map<String, String> r4) {
        List<File> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return o.uploadFiles(r2, r5, r6);
    }

    public static com.bytedance.services.apm.api.h a(String r1, String r2, boolean r3) {
        return o.buildMultipartUpload(r1, r2, r3);
    }

    public static com.bytedance.services.apm.api.h a(String r2, String r3, boolean r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        return o.buildMultipartUpload(r2, r3, r4, r6);
    }

    public static long t() {
        if (u != 0) goto L6;
        u = System.currentTimeMillis();
    L6:
        return u;
    }

    public static void i(long r0) {
        u = r0;
    }

    public static void j(long r0) {
        v = r0;
    }

    public static void k(long r0) {
        w = r0;
    }

    public static void l(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        long r2 = t;
        if (r2 != 0) goto L8;
    L9:
        t = r4;
        return;
    L8:
        if (r4 < r2) goto L9;
    }

    public static long u() {
        return t;
    }

    public static boolean v() {
        return A;
    }

    public static void d(boolean r0) {
        A = r0;
    }

    public static long w() {
        return i;
    }

    public static long x() {
        return j;
    }

    public static long y() {
        return f4455a;
    }

    public static long z() {
        return f4456b;
    }

    public static long A() {
        return f4457c;
    }

    public static long B() {
        return f4458d;
    }

    public static long C() {
        return k;
    }

    public static void e(boolean r0) {
        z = r0;
    }

    public static boolean D() {
        return z;
    }

    public static void a(List<String> r2) {
        D = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
    }

    public static void b(String r0) {
        E = r0;
    }

    public static String E() {
        return E;
    }
}
