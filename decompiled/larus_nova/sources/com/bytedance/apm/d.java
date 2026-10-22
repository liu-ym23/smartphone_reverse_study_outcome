package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.q;
import com.bytedance.apm.util.r;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.IHttpService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static long A;
    public static long B;
    public static long C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f190513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f190514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f190515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f190516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f190517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f190518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static JSONObject f190519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static gs3.b f190520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map<String, String> f190521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IHttpService f190522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static ff7.h f190523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f190524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile int f190525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f190526n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f190527o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f190528p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f190529q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f190530r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f190531s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f190532t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f190533u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static List<String> f190534v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f190535w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static f f190536x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static gs3.d f190537y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f190538z;

    static {
        f190519g = new JSONObject();
        f190520h = new gs3.a();
        f190521i = Collections.emptyMap();
        f190522j = new DefaultHttpServiceImpl();
        f190524l = -1;
        f190525m = -1;
        f190526n = false;
        f190533u = true;
        f190537y = null;
    }

    public static String c() {
        if (TextUtils.isEmpty(f190529q) == false) goto L6;
        f190529q = com.bytedance.apm.util.a.a(Process.myPid());
    L6:
        return f190529q;
    }

    public static JSONObject d() {
        return new JSONObject(String.valueOf(f190519g));
    L5:
        return new JSONObject();
    }

    public static long e() {
        if (f190528p != 0) goto L6;
        f190528p = System.currentTimeMillis();
    L6:
        return f190528p;
    }

    public static synchronized f f() {
        monitor-enter(d.class);
        f r100 = f190536x;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> g() {
        monitor-enter(d.class);
        gs3.d r100 = f190537y;     // Catch: Throwable -> L16
        if (r100 == null) goto L13;
        ((ApmDelegate.f.a) r100).getClass();     // Catch: Throwable -> L16
        Map<String, String> r101 = g();     // Catch: Throwable -> L16
        if (r101 == null) goto L13;
        if (r101.size() <= 0) goto L13;
        HashMap r102 = new HashMap(f190521i);     // Catch: Throwable -> L16
        r102.putAll(r101);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r102;
    L13:
        Map<String, String> r103 = f190521i;     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r103;
    L16:
        th = move-exception;
        throw th;
    }

    public static long h() {
        if (f190524l != (-1)) goto L6;
        f190524l = System.currentTimeMillis();
    L6:
        return f190524l;
    }

    public static boolean j() {
        if (f190514b == true) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean k() {
        boolean r100 = true;
        if (f190530r == false) goto L6;
        return true;
    L6:
        if (f190513a == null) goto L8;
        String r101 = c();
        if (r101 != null) goto L12;
    L14:
        if (r101 != null) goto L16;
    L18:
        r100 = false;
    L19:
        f190530r = r100;
    L21:
        return f190530r;
    L16:
        if (r101.equals(f190513a.getPackageName()) == false) goto L18;
    L12:
        if (r101.contains(":") == false) goto L14;
        f190530r = false;
        goto L21
    L8:
        return l();
    }

    public static boolean l() {
        if (f190530r == false) goto L5;
        return true;
    L5:
        String r100 = c();
        if (r100 != null) goto L8;
    L11:
        return true;
    L8:
        if (r100.contains(":") == false) goto L11;
        return false;
    }

    public static Context getContext() {
        return f190513a;
    }

    public static String i(long r100) {
        long r101 = r100 - f190528p;
        if (r101 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r101 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r101 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r101 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r101 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r101 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r101 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static synchronized void m(gs3.b r100) {
        monitor-enter(d.class);
        f190520h = r100;     // Catch: Throwable -> L39
        Map<String, String> r101 = r100.getCommonParams();     // Catch: Throwable -> L39
        f190521i = r101;     // Catch: Throwable -> L39
        if (r101 != null) goto L8;
        f190521i = new HashMap();     // Catch: Throwable -> L39
    L8:
        if (f190521i.containsKey("aid") == true) goto L11;
        f190521i.put("aid", f190519g.optString("aid"));     // Catch: Throwable -> L39
    L11:
        if (f190521i.containsKey("device_id") == true) goto L14;
        f190521i.put("device_id", f190519g.optString("device_id"));     // Catch: Throwable -> L39
    L14:
        if (f190521i.containsKey("device_platform") == true) goto L16;
        f190521i.put("device_platform", "android");     // Catch: Throwable -> L39
    L16:
        f190521i.put("os", "Android");     // Catch: Throwable -> L39
        if (f190521i.containsKey("update_version_code") == true) goto L20;
        f190521i.put("update_version_code", f190519g.optString("update_version_code"));     // Catch: Throwable -> L39
    L20:
        if (f190521i.containsKey("version_code") == true) goto L23;
        f190521i.put("version_code", f190519g.optString("version_code"));     // Catch: Throwable -> L39
    L23:
        if (f190521i.containsKey("channel") == true) goto L26;
        f190521i.put("channel", f190519g.optString("channel"));     // Catch: Throwable -> L39
    L26:
        if (f190521i.containsKey("os_api") == true) goto L29;
        f190521i.put("os_api", Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L39
    L29:
        if (j() == false) goto L34;
        if (f190521i.containsKey("_log_level") == true) goto L34;
        f190521i.put("_log_level", "debug");     // Catch: Throwable -> L39
    L34:
        if (f190536x != null) goto L36;
        f190536x = new f();     // Catch: Throwable -> L39
    L36:
        f190536x.f190557j = new HashMap(f190521i);     // Catch: Throwable -> L39
        monitor-exit(d.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized void n(JSONObject r100) {
        monitor-enter(d.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (f190536x != null) goto L7;
        f190536x = new f();     // Catch: Throwable -> L24 Exception -> L76
    L7:
        r100.put("os", "Android");     // Catch: Throwable -> L24 Exception -> L76
        r100.put("device_platform", "android");     // Catch: Throwable -> L24 Exception -> L76
        r100.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L24 Exception -> L76
        r100.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L24 Exception -> L76
        r100.put("device_model", Build.MODEL);     // Catch: Throwable -> L24 Exception -> L76
        r100.put("device_brand", Build.BRAND);     // Catch: Throwable -> L24 Exception -> L76
        r100.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L24 Exception -> L76
        r100.put("process_name", com.bytedance.apm.util.a.a(Process.myPid()));     // Catch: Throwable -> L24 Exception -> L76
        r100.put(WsConstants.KEY_SESSION_ID, h());     // Catch: Throwable -> L24 Exception -> L76
        r100.put("phone_startup_time", e());     // Catch: Throwable -> L24 Exception -> L76
        r100.put("verify_info", r.a());     // Catch: Throwable -> L24 Exception -> L76
        r100.put("rom_version", q.c());     // Catch: Throwable -> L24 Exception -> L76
        if (r100.has("version_name") == true) goto L10;
        PackageInfo r101 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L24 Exception -> L76
        r100.put("version_name", r101.versionName);     // Catch: Throwable -> L24 Exception -> L76
    L12:
        if (TextUtils.isEmpty(r100.optString("app_version")) == false) goto L15;
        r100.put("app_version", r100.optString("version_name"));     // Catch: Throwable -> L24 Exception -> L76
    L15:
        if (r100.has("version_code") == true) goto L20;
        if (r101 != null) goto L18;
        r101 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L24 Exception -> L76
    L18:
        r100.put("version_code", r101.versionCode);     // Catch: Throwable -> L24 Exception -> L76
    L20:
        if (TextUtils.isEmpty(r100.optString("package")) == false) goto L22;
        r100.put("package", getContext().getPackageName());     // Catch: Throwable -> L24 Exception -> L76
    L22:
        r100.put(MonitorConstants.EXTRA_MONITOR_VERSION, "5.0.21.46-alpha.1");     // Catch: Throwable -> L24 Exception -> L76
        goto L26
    L10:
        r101 = null;
    L26:
        f r102 = f190536x;     // Catch: Throwable -> L24
        r100.optString("process_name");     // Catch: Throwable -> L24
        r102.getClass();     // Catch: Throwable -> L24
        f r103 = f190536x;     // Catch: Throwable -> L24
        r103.f190549b = r100.optString("device_id");     // Catch: Throwable -> L24
        f r104 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r104.f190548a = r100.optInt("aid");     // Catch: Throwable -> L24 Exception -> L77
        f r105 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r105.f190550c = r100.optString("channel");     // Catch: Throwable -> L24 Exception -> L77
        if (r100.has("update_version_code") == false) goto L34;
        if ((r100.get("update_version_code") instanceof String) == false) goto L32;
        f r106 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r106.f190551d = CastIntegerProtector.valueOf(r100.optString("update_version_code")).intValue();     // Catch: Throwable -> L24 Exception -> L77
        goto L34
    L32:
        f r107 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r107.f190551d = r100.optInt("update_version_code");     // Catch: Throwable -> L24 Exception -> L77
    L34:
        if (r100.has("version_name") == false) goto L37;
        f r108 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r108.f190552e = r100.optString("version_name");     // Catch: Throwable -> L24 Exception -> L77
    L37:
        if (r100.has("manifest_version_code") == false) goto L43;
        if ((r100.get("manifest_version_code") instanceof String) == false) goto L41;
        f r109 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r109.f190553f = CastIntegerProtector.valueOf(r100.optString("manifest_version_code")).intValue();     // Catch: Throwable -> L24 Exception -> L77
        goto L43
    L41:
        f r110 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r110.f190553f = r100.optInt("manifest_version_code");     // Catch: Throwable -> L24 Exception -> L77
    L43:
        if (r100.has("version_code") == false) goto L49;
        if ((r100.get("version_code") instanceof String) == false) goto L47;
        f r111 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        CastIntegerProtector.valueOf(r100.optString("version_code")).intValue();     // Catch: Throwable -> L24 Exception -> L77
        r111.getClass();     // Catch: Throwable -> L24 Exception -> L77
        goto L49
    L47:
        f r112 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r100.optInt("version_code");     // Catch: Throwable -> L24 Exception -> L77
        r112.getClass();     // Catch: Throwable -> L24 Exception -> L77
    L49:
        if (r100.has("app_version") == false) goto L51;
        f r113 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r113.f190554g = r100.optString("app_version");     // Catch: Throwable -> L24 Exception -> L77
    L51:
        String r114 = r.a();     // Catch: Throwable -> L24 Exception -> L77
        if (TextUtils.isEmpty(r114) == true) goto L57;
        if (r114.equals("null") == true) goto L57;
        r100.put("release_build", r114);     // Catch: Throwable -> L24 Exception -> L77
        f r115 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r115.f190555h = r100.optString("release_build");     // Catch: Throwable -> L24 Exception -> L77
    L57:
        if (r.a().isEmpty() == true) goto L59;
        f r116 = f190536x;     // Catch: Throwable -> L24 Exception -> L77
        r116.f190555h = r.a();     // Catch: Throwable -> L24 Exception -> L77
    L59:
        f r117 = f190536x;     // Catch: Throwable -> L24
        JSONObject r118 = new JSONObject(r100.toString());     // Catch: Throwable -> L62
    L63:
        r117.f190556i = r118;     // Catch: Throwable -> L24
        if (f190519g != null) goto L66;
        f190519g = r100;     // Catch: Throwable -> L24
    L72:
        monitor-exit(d.class);
        return;
    L66:
        Iterator<String> r119 = r100.keys();     // Catch: Throwable -> L24
    L68:
        if (r119.hasNext() == false) goto L72;
        String r120 = r119.next();     // Catch: Throwable -> L24
        f190519g.put(r120, r100.get(r120));     // Catch: Throwable -> L24 JSONException -> L78
    L62:
        r118 = r100;
        goto L63
    }

    public static boolean b(String r100, String r101) {
        if (f190519g != null) goto L6;
        return false;
    L6:
        if (r100.equals("release_build") == false) goto L12;
        return false;
    L12:
        f190519g.put(r100, r101);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static ff7.b a(String r100, byte[] r101, Map<String, String> r102) throws Exception {
        return f190522j.doPost(r100, r101, r102);
    }
}
