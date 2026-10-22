package Z7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: Z7.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1130b {

    /* renamed from: x0, reason: collision with root package name */
    public static final Map<String, String> f7417x0 = new HashMap();

    /* renamed from: y0, reason: collision with root package name */
    public static C1130b f7418y0 = null;

    /* renamed from: D, reason: collision with root package name */
    public String f7422D;

    /* renamed from: E, reason: collision with root package name */
    public int f7423E;

    /* renamed from: F, reason: collision with root package name */
    public String f7424F;

    /* renamed from: G, reason: collision with root package name */
    public String f7425G;

    /* renamed from: H, reason: collision with root package name */
    public String f7426H;

    /* renamed from: O, reason: collision with root package name */
    public List<String> f7433O;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f7444Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7445a;

    /* renamed from: a0, reason: collision with root package name */
    public String f7446a0;

    /* renamed from: b, reason: collision with root package name */
    public String f7447b;

    /* renamed from: b0, reason: collision with root package name */
    public String f7448b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f7450c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f7452d0;

    /* renamed from: e, reason: collision with root package name */
    public String f7453e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7455f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f7456f0;

    /* renamed from: g, reason: collision with root package name */
    public String f7457g;

    /* renamed from: k0, reason: collision with root package name */
    public final SharedPreferences f7466k0;

    /* renamed from: l0, reason: collision with root package name */
    public final SharedPreferences f7468l0;

    /* renamed from: m, reason: collision with root package name */
    public String f7469m;

    /* renamed from: n, reason: collision with root package name */
    public final String f7471n;

    /* renamed from: o, reason: collision with root package name */
    public String f7473o;

    /* renamed from: z, reason: collision with root package name */
    public String f7493z;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7459h = true;

    /* renamed from: i, reason: collision with root package name */
    public final String f7461i = "com.tencent.bugly";

    /* renamed from: j, reason: collision with root package name */
    public String f7463j = "4.1.9.3";

    /* renamed from: k, reason: collision with root package name */
    public final String f7465k = "";

    /* renamed from: l, reason: collision with root package name */
    @Deprecated
    public final String f7467l = "";

    /* renamed from: p, reason: collision with root package name */
    public String f7475p = "unknown";

    /* renamed from: q, reason: collision with root package name */
    public String f7477q = "unknown";

    /* renamed from: r, reason: collision with root package name */
    public String f7479r = "";

    /* renamed from: s, reason: collision with root package name */
    public long f7481s = 0;

    /* renamed from: t, reason: collision with root package name */
    public String f7483t = null;

    /* renamed from: u, reason: collision with root package name */
    public long f7485u = -1;

    /* renamed from: v, reason: collision with root package name */
    public long f7487v = -1;

    /* renamed from: w, reason: collision with root package name */
    public long f7489w = -1;

    /* renamed from: x, reason: collision with root package name */
    public String f7491x = null;

    /* renamed from: y, reason: collision with root package name */
    public String f7492y = null;

    /* renamed from: A, reason: collision with root package name */
    public Map<String, PlugInBean> f7419A = null;

    /* renamed from: B, reason: collision with root package name */
    public boolean f7420B = false;

    /* renamed from: C, reason: collision with root package name */
    public String f7421C = null;

    /* renamed from: I, reason: collision with root package name */
    public Boolean f7427I = null;

    /* renamed from: J, reason: collision with root package name */
    public String f7428J = null;

    /* renamed from: K, reason: collision with root package name */
    public String f7429K = null;

    /* renamed from: L, reason: collision with root package name */
    public String f7430L = null;

    /* renamed from: M, reason: collision with root package name */
    public Map<String, PlugInBean> f7431M = null;

    /* renamed from: N, reason: collision with root package name */
    public Map<String, PlugInBean> f7432N = null;

    /* renamed from: P, reason: collision with root package name */
    public int f7434P = -1;

    /* renamed from: Q, reason: collision with root package name */
    public int f7435Q = -1;

    /* renamed from: R, reason: collision with root package name */
    public final Map<String, String> f7436R = new HashMap();

    /* renamed from: S, reason: collision with root package name */
    public final Map<String, String> f7437S = new HashMap();

    /* renamed from: T, reason: collision with root package name */
    public final Map<String, String> f7438T = new HashMap();

    /* renamed from: U, reason: collision with root package name */
    public String f7439U = "unknown";

    /* renamed from: V, reason: collision with root package name */
    public long f7440V = 0;

    /* renamed from: W, reason: collision with root package name */
    public long f7441W = 0;

    /* renamed from: X, reason: collision with root package name */
    public long f7442X = 0;

    /* renamed from: Y, reason: collision with root package name */
    public long f7443Y = 0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f7454e0 = false;

    /* renamed from: g0, reason: collision with root package name */
    public HashMap<String, String> f7458g0 = new HashMap<>();

    /* renamed from: h0, reason: collision with root package name */
    public List<String> f7460h0 = new ArrayList();

    /* renamed from: i0, reason: collision with root package name */
    public boolean f7462i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public P f7464j0 = null;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f7470m0 = true;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f7472n0 = true;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f7474o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    public final Object f7476p0 = new Object();

    /* renamed from: q0, reason: collision with root package name */
    public final Object f7478q0 = new Object();

    /* renamed from: r0, reason: collision with root package name */
    public final Object f7480r0 = new Object();

    /* renamed from: s0, reason: collision with root package name */
    public final Object f7482s0 = new Object();

    /* renamed from: t0, reason: collision with root package name */
    public final Object f7484t0 = new Object();

    /* renamed from: u0, reason: collision with root package name */
    public final Object f7486u0 = new Object();

    /* renamed from: v0, reason: collision with root package name */
    public final Object f7488v0 = new Object();

    /* renamed from: w0, reason: collision with root package name */
    public final List<Integer> f7490w0 = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final long f7449c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public final byte f7451d = 1;

    public C1130b(Context context) {
        this.f7493z = null;
        this.f7422D = null;
        this.f7424F = null;
        this.f7425G = null;
        this.f7426H = null;
        this.f7433O = null;
        this.f7444Z = false;
        this.f7446a0 = null;
        this.f7448b0 = null;
        this.f7450c0 = null;
        this.f7452d0 = "";
        this.f7456f0 = false;
        this.f7445a = C1143o.a(context);
        PackageInfo packageInfoE = Y.e(context);
        if (packageInfoE != null) {
            try {
                String str = packageInfoE.versionName;
                this.f7422D = str;
                this.f7446a0 = str;
                this.f7448b0 = Integer.toString(packageInfoE.versionCode);
            } catch (Throwable th) {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f7453e = Y.b(context);
        this.f7455f = Y.a(Process.myPid());
        this.f7424F = Y.f(context);
        this.f7471n = "Android " + ab.d() + ",level " + ab.e();
        Map<String, String> mapG = Y.g(context);
        if (mapG != null) {
            try {
                this.f7433O = Y.c(mapG);
                String str2 = mapG.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f7425G = str2;
                    m("APP_ID", str2);
                }
                String str3 = mapG.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f7422D = str3;
                }
                String str4 = mapG.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f7426H = str4;
                }
                String str5 = mapG.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.f7444Z = str5.equalsIgnoreCase("true");
                }
                String str6 = mapG.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.f7450c0 = str6;
                }
                String str7 = mapG.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f7423E = Integer.parseInt(str7);
                }
                String str8 = mapG.get("BUGLY_AREA");
                if (str8 != null) {
                    this.f7452d0 = str8;
                }
            } catch (Throwable th2) {
                if (!C1139k.e(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f7456f0 = true;
                C1139k.h("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (O.f7341c) {
                th3.printStackTrace();
            }
        }
        this.f7466k0 = C1143o.b("BUGLY_COMMON_VALUES", context);
        this.f7468l0 = C1143o.b("BUGLY_RESERVED_VALUES", context);
        this.f7493z = ab.b(context);
        e();
        C1139k.h("com info create end", new Object[0]);
    }

    @Deprecated
    public static String B() {
        return "";
    }

    public static int b() {
        return ab.e();
    }

    @Deprecated
    public static boolean c() {
        C1139k.d("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean d() {
        C1139k.d("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    public static String g() {
        String string = UUID.randomUUID().toString();
        return !C1143o.G(string) ? string.replaceAll(O6.l.DATE_SEPARATOR, "") : string;
    }

    public static synchronized C1130b h(Context context) {
        try {
            if (f7418y0 == null) {
                f7418y0 = new C1130b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7418y0;
    }

    public static synchronized C1130b l() {
        return f7418y0;
    }

    public final String A() {
        if (!TextUtils.isEmpty(this.f7492y)) {
            C1139k.h("get cpu type from so:%s", this.f7492y);
            return this.f7492y;
        }
        if (TextUtils.isEmpty(this.f7493z)) {
            return "unknown";
        }
        C1139k.h("get cpu type from lib dir:%s", this.f7493z);
        return this.f7493z;
    }

    public final String C() {
        try {
            Map<String, ?> all = this.f7445a.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f7478q0) {
                    try {
                    } catch (Throwable th) {
                        C1139k.e(th);
                    } finally {
                    }
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.f7458g0.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th2) {
            C1139k.e(th2);
        }
        if (this.f7458g0.isEmpty()) {
            C1139k.h("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.f7458g0.entrySet()) {
            sb2.append("[");
            sb2.append(entry2.getKey());
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(entry2.getValue());
            sb2.append("] ");
        }
        C1139k.h("SDK_INFO = %s", sb2.toString());
        m("SDK_INFO", sb2.toString());
        return sb2.toString();
    }

    public final synchronized Map<String, PlugInBean> D() {
        Map<String, PlugInBean> map = this.f7419A;
        if (map != null && map.size() > 0) {
            HashMap map2 = new HashMap(this.f7419A.size());
            map2.putAll(this.f7419A);
            return map2;
        }
        return null;
    }

    public final String E() {
        if (this.f7421C == null) {
            this.f7421C = ab.p();
        }
        return this.f7421C;
    }

    public final Boolean F() {
        if (this.f7427I == null) {
            this.f7427I = Boolean.valueOf(ab.t());
        }
        return this.f7427I;
    }

    public final String G() {
        if (this.f7428J == null) {
            String str = ab.q();
            this.f7428J = str;
            C1139k.d("ROM ID: %s", str);
        }
        return this.f7428J;
    }

    public final Map<String, String> H() {
        synchronized (this.f7480r0) {
            try {
                if (this.f7436R.size() <= 0) {
                    return null;
                }
                return new HashMap(this.f7436R);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<String, String> I() {
        synchronized (this.f7488v0) {
            try {
                if (this.f7437S.size() <= 0) {
                    return null;
                }
                return new HashMap(this.f7437S);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<String, String> J() {
        synchronized (this.f7482s0) {
            try {
                if (this.f7438T.size() <= 0) {
                    return null;
                }
                return new HashMap(this.f7438T);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int K() {
        int i10;
        synchronized (this.f7484t0) {
            i10 = this.f7434P;
        }
        return i10;
    }

    public final synchronized Map<String, PlugInBean> a() {
        Map<String, PlugInBean> map;
        map = this.f7431M;
        Map<String, PlugInBean> map2 = this.f7432N;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final void e() {
        try {
            for (Map.Entry<String, ?> entry : this.f7468l0.getAll().entrySet()) {
                C1139k.h("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                j(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : f7417x0.entrySet()) {
                C1139k.h("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                j(entry2.getKey(), entry2.getValue(), true);
            }
            f7417x0.clear();
        } catch (Throwable th) {
            C1139k.g(th);
        }
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f7483t)) {
            this.f7483t = C1143o.M("androidid", null);
        }
        return this.f7483t;
    }

    public final void i(int i10, boolean z10) {
        C1139k.h("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i10), Boolean.valueOf(z10));
        if (z10) {
            this.f7490w0.add(Integer.valueOf(i10));
        } else {
            this.f7490w0.remove(Integer.valueOf(i10));
            this.f7490w0.remove((Object) 0);
        }
        P p10 = this.f7464j0;
        if (p10 != null) {
            p10.a(this.f7490w0.size() > 0);
        }
    }

    public final void j(String str, String str2, boolean z10) {
        if (C1143o.G(str)) {
            C1139k.i("key should not be empty %s", str);
            return;
        }
        C1139k.h("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z10));
        synchronized (this.f7488v0) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    this.f7437S.remove(str);
                    this.f7468l0.edit().remove(str).apply();
                } else {
                    this.f7437S.put(str, str2);
                    if (z10) {
                        this.f7468l0.edit().putString(str, str2).apply();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k() {
        boolean z10 = this.f7490w0.size() > 0;
        C1139k.h("isAppForeground:%s", Boolean.valueOf(z10));
        return z10;
    }

    public final void m(String str, String str2) {
        if (C1143o.G(str) || C1143o.G(str2)) {
            C1139k.i("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.f7482s0) {
            this.f7438T.put(str, str2);
        }
    }

    public final void n() {
        synchronized (this.f7476p0) {
            this.f7447b = UUID.randomUUID().toString();
        }
    }

    public final synchronized void o(String str) {
        this.f7477q = String.valueOf(str);
    }

    public final String p() {
        String str;
        synchronized (this.f7476p0) {
            try {
                if (this.f7447b == null) {
                    n();
                }
                str = this.f7447b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final synchronized void q(String str) {
        this.f7479r = String.valueOf(str);
    }

    public final String r() {
        return !C1143o.G(this.f7457g) ? this.f7457g : this.f7425G;
    }

    public final void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7492y = str.trim();
    }

    public final String t() {
        String str;
        synchronized (this.f7486u0) {
            str = this.f7475p;
        }
        return str;
    }

    public final String u() {
        String str = this.f7473o;
        if (str != null) {
            return str;
        }
        String strM = C1143o.M("deviceId", null);
        this.f7473o = strM;
        if (strM != null) {
            return strM;
        }
        String strF = f();
        this.f7473o = strF;
        if (TextUtils.isEmpty(strF)) {
            this.f7473o = g();
        }
        String str2 = this.f7473o;
        if (str2 == null) {
            return "";
        }
        C1143o.J("deviceId", str2);
        return this.f7473o;
    }

    public final synchronized String v() {
        String str = this.f7469m;
        if (str != null) {
            return str;
        }
        String strM = C1143o.M("deviceModel", null);
        this.f7469m = strM;
        if (strM != null) {
            C1139k.h("collect device model from sp:%s", strM);
            return this.f7469m;
        }
        if (!this.f7420B) {
            C1139k.h("not allow collect device model", new Object[0]);
            return "fail";
        }
        String strA = ab.a();
        this.f7469m = strA;
        C1139k.h("collect device model:%s", strA);
        C1143o.J("deviceModel", this.f7469m);
        return this.f7469m;
    }

    public final synchronized String w() {
        return this.f7479r;
    }

    public final long x() {
        if (this.f7485u <= 0) {
            this.f7485u = ab.h();
        }
        return this.f7485u;
    }

    public final long y() {
        if (this.f7487v <= 0) {
            this.f7487v = ab.l();
        }
        return this.f7487v;
    }

    public final long z() {
        if (this.f7489w <= 0) {
            this.f7489w = ab.n();
        }
        return this.f7489w;
    }
}
