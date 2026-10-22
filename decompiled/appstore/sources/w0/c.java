package w0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.r;
import com.bytedance.apm.util.s;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedanceos.common.ad.common.AdConstant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static boolean A;
    public static f B;
    public static boolean C;
    public static IQueryParams D;
    public static long E;
    public static long F;
    public static long G;
    public static long H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f25240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f25241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f25242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f25243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f25244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f25245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f25246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static JSONObject f25247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static IDynamicParams f25248i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Map f25249j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static IHttpService f25250k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f25251l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile int f25252m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f25253n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f25254o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f25255p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f25256q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f25257r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f25258s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f25259t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f25260u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f25261v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f25262w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f25263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static List f25264y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f25265z;

    static {
        f25247h = new JSONObject();
        f25248i = new j1.a();
        f25249j = Collections.emptyMap();
        f25250k = new DefaultHttpServiceImpl();
        f25251l = -1;
        f25252m = -1;
        f25253n = false;
        f25262w = 0;
        f25263x = true;
        A = true;
        C = false;
        D = null;
    }

    public static String A(long r10) {
        long r11 = r10 - f25255p;
        if (r11 >= PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS) goto L7;
        return "0 - 30s";
    L7:
        if (r11 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r11 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r11 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r11 >= AdConstant.SPLASH_AD_INTERVAL) goto L23;
        return "5min - 10min";
    L23:
        if (r11 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r11 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static boolean B() {
        if (f25241b == false) goto L5;
    L8:
        return true;
    L5:
        if (f25243d == true) goto L8;
        return false;
    }

    public static boolean C() {
        return f25260u;
    }

    public static boolean D() {
        return f25242c;
    }

    public static boolean E() {
        JSONObject r10 = f25247h;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.optString("channel") != null) goto L8;
        return false;
    L8:
        return f25247h.optString("channel").contains("local");
    }

    public static boolean F() {
        boolean r10 = true;
        if (f25259t == false) goto L6;
        return true;
    L6:
        if (f25240a == null) goto L8;
        String r11 = h();
        if (r11 != null) goto L12;
    L14:
        if (r11 != null) goto L16;
    L18:
        r10 = false;
    L19:
        f25259t = r10;
    L21:
        return f25259t;
    L16:
        if (r11.equals(f25240a.getPackageName()) == false) goto L18;
    L12:
        if (r11.contains(":") == false) goto L14;
        f25259t = false;
        goto L21
    L8:
        return G();
    }

    public static boolean G() {
        if (f25259t == false) goto L5;
        return true;
    L5:
        String r10 = h();
        if (r10 != null) goto L8;
    L11:
        return true;
    L8:
        if (r10.contains(":") == false) goto L11;
        return false;
    }

    public static boolean H() {
        return f25263x;
    }

    public static boolean I() {
        return f25253n;
    }

    public static void J(String r10) {
        f25265z = r10;
    }

    public static void K(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        long r11 = f25254o;
        if (r11 != 0) goto L8;
    L9:
        f25254o = r10;
        return;
    L8:
        if (r10 < r11) goto L9;
    }

    public static void L(Context r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f25240a = com.bytedance.apm.util.a.a(r10);
    }

    public static void M(String r10) {
        f25258s = r10;
    }

    public static void N(boolean r10) {
        f25241b = r10;
        r3.a.f(B());
    }

    public static void O(boolean r10) {
        f25260u = r10;
    }

    public static synchronized void P(IDynamicParams r10) {
        monitor-enter(c.class);
        f25248i = r10;     // Catch: Throwable -> L7
        Map<String, String> r11 = r10.getCommonParams();     // Catch: Throwable -> L7
        f25249j = r11;     // Catch: Throwable -> L7
        if (r11 != null) goto L10;
        f25249j = new HashMap();     // Catch: Throwable -> L7
    L10:
        if (f25249j.containsKey("aid") == true) goto L13;
        f25249j.put("aid", f25247h.optString("aid"));     // Catch: Throwable -> L7
    L13:
        if (f25249j.containsKey("device_id") == true) goto L16;
        f25249j.put("device_id", f25247h.optString("device_id"));     // Catch: Throwable -> L7
    L16:
        if (f25249j.containsKey("device_platform") == true) goto L18;
        f25249j.put("device_platform", "android");     // Catch: Throwable -> L7
    L18:
        f25249j.put("os", "Android");     // Catch: Throwable -> L7
        if (f25249j.containsKey("update_version_code") == true) goto L22;
        f25249j.put("update_version_code", f25247h.optString("update_version_code"));     // Catch: Throwable -> L7
    L22:
        if (f25249j.containsKey("version_code") == true) goto L25;
        f25249j.put("version_code", f25247h.optString("version_code"));     // Catch: Throwable -> L7
    L25:
        if (f25249j.containsKey("channel") == true) goto L28;
        f25249j.put("channel", f25247h.optString("channel"));     // Catch: Throwable -> L7
    L28:
        if (f25249j.containsKey("os_api") == true) goto L31;
        f25249j.put("os_api", Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L7
    L31:
        if (B() == false) goto L36;
        if (f25249j.containsKey("_log_level") == true) goto L36;
        f25249j.put("_log_level", "debug");     // Catch: Throwable -> L7
    L36:
        if (B != null) goto L38;
        B = new f();     // Catch: Throwable -> L7
    L38:
        B.r(new HashMap(f25249j));     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void Q(JSONObject r10) {
        monitor-enter(c.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (B != null) goto L9;
        B = new f();     // Catch: Throwable -> L7 Exception -> L71
    L9:
        r10.put("os", "Android");     // Catch: Throwable -> L7 Exception -> L71
        r10.put("device_platform", "android");     // Catch: Throwable -> L7 Exception -> L71
        r10.put(CommonKey.KEY_OS_VERSION, Build.VERSION.RELEASE);     // Catch: Throwable -> L7 Exception -> L71
        r10.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L7 Exception -> L71
        r10.put("device_model", Build.MODEL);     // Catch: Throwable -> L7 Exception -> L71
        r10.put("device_brand", Build.BRAND);     // Catch: Throwable -> L7 Exception -> L71
        r10.put(CommonKey.KEY_DEVICE_MANUFACTURER, Build.MANUFACTURER);     // Catch: Throwable -> L7 Exception -> L71
        r10.put("process_name", com.bytedance.apm.util.a.b(Process.myPid()));     // Catch: Throwable -> L7 Exception -> L71
        r10.put("sid", z());     // Catch: Throwable -> L7 Exception -> L71
        r10.put(CommonKey.KEY_PHONE_STARTUP_TIME, s());     // Catch: Throwable -> L7 Exception -> L71
        r10.put(CommonKey.KEY_VERIFY_INFO, s.a());     // Catch: Throwable -> L7 Exception -> L71
        r10.put(CommonKey.KEY_ROM_VERSION, r.k());     // Catch: Throwable -> L7 Exception -> L71
        if (r10.has(CommonKey.KEY_VERSION_NAME) == true) goto L12;
        PackageInfo r11 = g().getPackageManager().getPackageInfo(g().getPackageName(), 0);     // Catch: Throwable -> L7 Exception -> L71
        r10.put(CommonKey.KEY_VERSION_NAME, r11.versionName);     // Catch: Throwable -> L7 Exception -> L71
    L14:
        if (TextUtils.isEmpty(r10.optString("app_version")) == false) goto L17;
        r10.put("app_version", r10.optString(CommonKey.KEY_VERSION_NAME));     // Catch: Throwable -> L7 Exception -> L71
    L17:
        if (r10.has("version_code") == true) goto L22;
        if (r11 != null) goto L20;
        r11 = g().getPackageManager().getPackageInfo(g().getPackageName(), 0);     // Catch: Throwable -> L7 Exception -> L71
    L20:
        r10.put("version_code", r11.versionCode);     // Catch: Throwable -> L7 Exception -> L71
    L22:
        if (TextUtils.isEmpty(r10.optString("package")) == false) goto L24;
        r10.put("package", g().getPackageName());     // Catch: Throwable -> L7 Exception -> L71
    L24:
        r10.put(CommonKey.KEY_MONITOR_VERSION, "5.0.21.21");     // Catch: Throwable -> L7 Exception -> L71
        goto L25
    L12:
        r11 = null;
    L25:
        B.s(r10.optString("process_name"));     // Catch: Throwable -> L7
        B.p(r10.optString("device_id"));     // Catch: Throwable -> L7
        B.m(r10.optInt("aid"));     // Catch: Throwable -> L7 Exception -> L72
        B.o(r10.optString("channel"));     // Catch: Throwable -> L7 Exception -> L72
        if (r10.has("update_version_code") == false) goto L33;
        if ((r10.get("update_version_code") instanceof String) == false) goto L31;
        B.v(Integer.valueOf(r10.optString("update_version_code")).intValue());     // Catch: Throwable -> L7 Exception -> L72
        goto L33
    L31:
        B.v(r10.optInt("update_version_code"));     // Catch: Throwable -> L7 Exception -> L72
    L33:
        if (r10.has(CommonKey.KEY_VERSION_NAME) == false) goto L36;
        B.x(r10.optString(CommonKey.KEY_VERSION_NAME));     // Catch: Throwable -> L7 Exception -> L72
    L36:
        if (r10.has(CommonKey.KEY_MANIFEST_VERSION_CODE) == false) goto L42;
        if ((r10.get(CommonKey.KEY_MANIFEST_VERSION_CODE) instanceof String) == false) goto L40;
        B.q(Integer.valueOf(r10.optString(CommonKey.KEY_MANIFEST_VERSION_CODE)).intValue());     // Catch: Throwable -> L7 Exception -> L72
        goto L42
    L40:
        B.q(r10.optInt(CommonKey.KEY_MANIFEST_VERSION_CODE));     // Catch: Throwable -> L7 Exception -> L72
    L42:
        if (r10.has("version_code") == false) goto L48;
        if ((r10.get("version_code") instanceof String) == false) goto L46;
        B.w(Integer.valueOf(r10.optString("version_code")).intValue());     // Catch: Throwable -> L7 Exception -> L72
        goto L48
    L46:
        B.w(r10.optInt("version_code"));     // Catch: Throwable -> L7 Exception -> L72
    L48:
        if (r10.has("app_version") == false) goto L50;
        B.n(r10.optString("app_version"));     // Catch: Throwable -> L7 Exception -> L72
    L50:
        String r12 = s.a();     // Catch: Throwable -> L7 Exception -> L72
        if (TextUtils.isEmpty(r12) == true) goto L56;
        if (r12.equals("null") == true) goto L56;
        r10.put(CommonKey.KEY_RELEASE_BUILD, r12);     // Catch: Throwable -> L7 Exception -> L72
        B.t(r10.optString(CommonKey.KEY_RELEASE_BUILD));     // Catch: Throwable -> L7 Exception -> L72
    L56:
        if (s.a().isEmpty() == true) goto L58;
        B.t(s.a());     // Catch: Throwable -> L7 Exception -> L72
    L58:
        B.u(com.bytedance.apm.util.i.c(r10));     // Catch: Throwable -> L7
        if (f25247h != null) goto L61;
        f25247h = r10;     // Catch: Throwable -> L7
    L67:
        monitor-exit(c.class);
        return;
    L61:
        Iterator<String> r13 = r10.keys();     // Catch: Throwable -> L7
    L63:
        if (r13.hasNext() == false) goto L67;
        String r14 = r13.next();     // Catch: Throwable -> L7
        f25247h.put(r14, r10.get(r14));     // Catch: Throwable -> L7 JSONException -> L73
        goto L63
    }

    public static void R(IHttpService r10) {
        if (r10 == null) goto L5;
        f25250k = r10;
        return;
    }

    public static void S(long r10) {
        f25244e = r10;
    }

    public static void T(long r10) {
        E = r10;
    }

    public static void U(long r10) {
        F = r10;
    }

    public static void V(long r10) {
        G = r10;
    }

    public static void W(long r10) {
        H = r10;
    }

    public static void X(long r10) {
        f25245f = r10;
    }

    public static void Y(long r10) {
        f25255p = r10;
    }

    public static void Z(long r10) {
        f25256q = r10;
    }

    public static IMultipartUploader a(String r10, String r11, boolean r12) {
        return f25250k.buildMultipartUpload(r10, r11, r12);
    }

    public static void a0(boolean r10) {
        f25242c = r10;
    }

    public static IMultipartUploader b(String r10, String r11, boolean r12, Map r13) {
        return f25250k.buildMultipartUpload(r10, r11, r12, r13);
    }

    public static void b0(boolean r10) {
        C = r10;
    }

    public static i6.c c(String r10, Map r11) {
        return f25250k.doGet(r10, r11);
    }

    public static void c0(int r10) {
        f25252m = r10;
    }

    public static i6.c d(String r10, byte[] r11, Map r12) {
        return f25250k.doPost(r10, r11, r12);
    }

    public static synchronized void d0(IQueryParams r10) {
        monitor-enter(c.class);
        D = r10;     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean e(String r10, String r11) {
        if (f25247h != null) goto L6;
        return false;
    L6:
        if (r10.equals(CommonKey.KEY_RELEASE_BUILD) == false) goto L12;
        return false;
    L12:
        f25247h.put(r10, r11);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static void e0(List r10) {
        f25264y = r10;
    }

    public static long f() {
        return f25254o;
    }

    public static void f0(long r10) {
        f25246g = r10;
    }

    public static Context g() {
        return f25240a;
    }

    public static void g0(long r10) {
        f25257r = r10;
    }

    public static String h() {
        if (TextUtils.isEmpty(f25258s) == false) goto L6;
        f25258s = com.bytedance.apm.util.a.b(Process.myPid());
    L6:
        return f25258s;
    }

    public static void h0(boolean r10) {
        f25253n = r10;
    }

    public static IDynamicParams i() {
        return f25248i;
    }

    public static void i0(boolean r10) {
        f25261v = r10;
    }

    public static JSONObject j() {
        return new JSONObject(String.valueOf(f25247h));
    L5:
        return new JSONObject();
    }

    public static boolean j0() {
        return f25261v;
    }

    public static JSONObject k() {
        return f25247h;
    }

    public static i6.c k0(String r10, List r11, Map r12) {
        return f25250k.uploadFiles(r10, r11, r12);
    }

    public static IHttpService l() {
        return f25250k;
    }

    public static long m() {
        return f25244e;
    }

    public static long n() {
        return f25245f;
    }

    public static long o() {
        return E;
    }

    public static long p() {
        return F;
    }

    public static long q() {
        return G;
    }

    public static long r() {
        return H;
    }

    public static long s() {
        if (f25255p != 0) goto L6;
        f25255p = System.currentTimeMillis();
    L6:
        return f25255p;
    }

    public static int t() {
        return f25252m;
    }

    public static synchronized f u() {
        monitor-enter(c.class);
        f r10 = B;     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map v() {
        monitor-enter(c.class);
        IQueryParams r10 = D;     // Catch: Throwable -> L15
        if (r10 == null) goto L19;
        Map<String, String> r11 = r10.getQueryParams();     // Catch: Throwable -> L15
        if (r11 == null) goto L19;
        if (r11.size() <= 0) goto L19;
        if (B.f() == null) goto L17;
        HashMap r12 = new HashMap(B.f());     // Catch: Throwable -> L15
        r12.putAll(r11);     // Catch: Throwable -> L15
        monitor-exit(c.class);
        return r12;
    L17:
        monitor-exit(c.class);
        return r11;
    L19:
        f r13 = B;     // Catch: Throwable -> L15
        if (r13 == null) goto L24;
        Map r14 = r13.f();     // Catch: Throwable -> L15
        monitor-exit(c.class);
        return r14;
    L24:
        monitor-exit(c.class);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static d w() {
        return null;
    }

    public static synchronized Map x() {
        monitor-enter(c.class);
        IQueryParams r10 = D;     // Catch: Throwable -> L13
        if (r10 == null) goto L15;
        Map<String, String> r11 = r10.getQueryParams();     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        if (r11.size() <= 0) goto L15;
        HashMap r12 = new HashMap(f25249j);     // Catch: Throwable -> L13
        r12.putAll(r11);     // Catch: Throwable -> L13
        monitor-exit(c.class);
        return r12;
    L15:
        Map r13 = f25249j;     // Catch: Throwable -> L13
        monitor-exit(c.class);
        return r13;
    L13:
        th = move-exception;
        throw th;
    }

    public static long y() {
        return f25246g;
    }

    public static long z() {
        if (f25251l != (-1)) goto L6;
        f25251l = System.currentTimeMillis();
    L6:
        return f25251l;
    }
}
