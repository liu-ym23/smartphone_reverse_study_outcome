package d3;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.services.apm.api.IHttpService;
import i6.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends r3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ApmContextAdapter f19044d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f19045e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f19046f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f19047g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f19048h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f19049i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f19050j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f19051k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f19052l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f19053m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f19054n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f19055o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static JSONObject f19056p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Map f19057q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f19058r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static INtpTimeService f19059s;

    static {
    }

    public static boolean A() {
        if (f19046f != null) goto L26;
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f19046f != null) goto L21;
        String r10 = m();     // Catch: Throwable -> L13
        if (r10 != null) goto L11;
    L15:
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        f19046f = Boolean.valueOf(r11);     // Catch: Throwable -> L13
        goto L21
    L17:
        if (r10.equals(r3.a.b().getPackageName()) == false) goto L19;
        r11 = true;
        goto L20
    L11:
        if (r10.contains(":") == false) goto L15;
        f19046f = Boolean.FALSE;     // Catch: Throwable -> L13
    L21:
        monitor-exit(a.class);     // Catch: Throwable -> L13
    L26:
        return f19046f.booleanValue();
    }

    public static void B(ApmContextAdapter r10) {
        if (r10 == null) goto L6;
        f19044d = r10;
        r3.a.e(r10.getContext());
        return;
    L6:
        throw new IllegalArgumentException("apmAdapter cannot be null!");
    }

    public static void C(long r10) {
        f19058r = r10;
    }

    public static void D(long r10) {
        f19054n = r10;
    }

    public static void E(INtpTimeService r10) {
        f19059s = r10;
    }

    public static void F(long r10) {
        f19053m = r10;
    }

    public static c g(String r10, Map r11, byte[] r12) {
        return ((IHttpService) o3.a.a(IHttpService.class)).doPost(r10, r12, r11);
    }

    public static int h() {
        return f19044d.getAid();
    }

    public static ApmContextAdapter i() {
        return f19044d;
    }

    public static String j() {
        if (TextUtils.isEmpty(f19051k) == false) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f19051k) == false) goto L11;
        f19051k = f19044d.getAppVersion();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19051k;
    }

    public static String k() {
        if (f19047g != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19047g != null) goto L11;
        f19047g = f19044d.getChannel();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19047g;
    }

    public static long l() {
        return f19058r;
    }

    public static String m() {
        if (f19045e != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19045e != null) goto L11;
        f19045e = f19044d.getProcessName();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19045e;
    }

    public static String n() {
        return f19044d.getDeviceId();
    }

    public static long o() {
        if (f19054n > 0) goto L6;
        f19054n = System.currentTimeMillis();
    L6:
        return f19054n;
    }

    public static String p() {
        if (f19055o != (-1)) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19055o != (-1)) goto L11;
        f19055o = f19044d.getManifestVersionCode();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return String.valueOf(f19055o);
    }

    public static INtpTimeService q() {
        return f19059s;
    }

    public static String r() {
        if (TextUtils.isEmpty(f19052l) == false) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f19052l) == false) goto L11;
        f19052l = f19044d.getReleaseBuild();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19052l;
    }

    public static String s() {
        return f19044d.getSessionId();
    }

    public static JSONObject t() {
        if (f19056p != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19056p != null) goto L11;
        f19056p = f19044d.getStableHeaderExtras();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19056p;
    }

    public static long u() {
        if (f19053m >= 0) goto L6;
        f19053m = System.currentTimeMillis();
    L6:
        return f19053m;
    }

    public static int v() {
        if (f19048h != (-1)) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19048h != (-1)) goto L11;
        f19048h = f19044d.getUpdateVersionCode();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19048h;
    }

    public static Map w() {
        if (f19057q != null) goto L5;
        HashMap r10 = new HashMap();
        f19057q = r10;
        r10.put("aid", String.valueOf(h()));
        f19057q.put("os", "Android");
        f19057q.put("device_platform", "android");
        f19057q.put("os_api", Build.VERSION.SDK_INT + "");
        f19057q.put("update_version_code", String.valueOf(v()));
        f19057q.put("version_code", j());
        f19057q.put("channel", k());
        f19057q.put("device_model", Build.MODEL);
        f19057q.put("device_brand", Build.BRAND);
    L5:
        f19057q.put("device_id", n());
        if (r3.a.c() == false) goto L20;
        f19057q.put("_log_level", "debug");
    L20:
        Map<String, String> r11 = i().getParamsExtras();     // Catch: Throwable -> L19
        if (r11 == null) goto L18;
        if (r11.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, String> r13 = r12.next();     // Catch: Throwable -> L19
        f19057q.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L19
    L18:
        return f19057q;
    }

    public static long x() {
        return f19044d.getUid();
    }

    public static int y() {
        if (f19050j != (-1)) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19050j != (-1)) goto L11;
        f19050j = f19044d.getVersionCode();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19050j;
    }

    public static String z() {
        if (TextUtils.isEmpty(f19049i) == false) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f19049i) == false) goto L11;
        f19049i = f19044d.getVersionName();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19049i;
    }
}
