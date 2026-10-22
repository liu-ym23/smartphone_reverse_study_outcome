package com.alipay.sdk.m.s;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public static final String A = "act_info";
    public static final String B = "UTF-8";
    public static final String C = "new_external_info==";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25755m = "\"&";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25756n = "&";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25757o = "bizcontext=\"";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25758p = "bizcontext=";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f25759q = "\"";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f25760r = "appkey";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f25761s = "ty";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f25762t = "sv";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f25763u = "an";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f25764v = "setting";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f25765w = "av";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f25766x = "sdk_start_time";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f25767y = "extInfo";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f25768z = "ap_link_token";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f25771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f25772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f25773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f25774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f25775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f25778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ActivityInfo f25779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.alipay.sdk.m.k.b f25780l;

    /* JADX INFO: renamed from: com.alipay.sdk.m.s.a$a, reason: collision with other inner class name */
    public static final class C0493a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<UUID, a> f25781a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashMap<String, a> f25782b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f25783c = "i_uuid_b_c";

        static {
            f25781a = new HashMap();
            f25782b = new HashMap();
        }

        public C0493a() {
        }

        public static a a(Intent r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            Serializable r101 = r100.getSerializableExtra(f25783c);
            if ((r101 instanceof UUID) == true) goto L8;
            return null;
        L8:
            return f25781a.remove((UUID) r101);
        }

        public static a a(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L7;
            return null;
        L7:
            return f25782b.remove(r100);
        }

        public static void a(a r100, Intent r101) {
            if (r100 == null) goto L7;
            if (r101 == null) goto L8;
            UUID r102 = UUID.randomUUID();
            f25781a.put(r102, r100);
            r101.putExtra(f25783c, r102);
            return;
        L8:
            return;
        }

        public static void a(a r100, String r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (TextUtils.isEmpty(r101) == true) goto L9;
            f25782b.put(r101, r100);
            return;
        }
    }

    public static a h() {
        return null;
    }

    private JSONObject g() {
        JSONObject r100 = new JSONObject();
        r100.put(f25768z, this.f25772d);     // Catch: Throwable -> L5
    L4:
        return r100;
    }

    public Context a() {
        return this.f25771c;
    }

    public String b() {
        return this.f25770b;
    }

    public String c() {
        return this.f25769a;
    }

    public boolean d() {
        return this.f25777i;
    }

    public boolean e() {
        return this.f25776h;
    }

    public boolean f() {
        return this.f25778j;
    }

    private String b(String r100) throws JSONException {
        return a(new JSONObject(r100));
    }

    private String c(String r100) {
        String r101 = a(r100, "&", f25758p);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r100 = r100 + "&" + a(f25758p, "");     // Catch: Throwable -> L9
    L12:
    L11:
        return r100;
    L7:
        int r102 = r100.indexOf(r101);     // Catch: Throwable -> L9
        r100 = r100.substring(0, r102) + b(r101, f25758p, "") + r100.substring(r102 + r101.length());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(this, "biz", "fmt1", th, r100);
        goto L11
    }

    private String d(String r100) {
        JSONObject r101 = new JSONObject(r100.substring(19));     // Catch: Throwable -> L5
        r101.put("bizcontext", b(r101.optString("bizcontext")));     // Catch: Throwable -> L5
        return C + r101.toString();
    L8:
        return r100;
    }

    private String e(String r100) {
        String r101 = a(r100, f25755m, f25757o);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return r100 + "&" + a(f25757o, "\"");
    L8:
        if (r101.endsWith("\"") == true) goto L10;
        r101 = r101.concat("\"");     // Catch: Throwable -> L12
    L10:
        int r102 = r100.indexOf(r101);     // Catch: Throwable -> L12
        return r100.substring(0, r102) + b(r101, f25757o, "\"") + r100.substring(r102 + r101.length());
    L12:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(this, "biz", "fmt2", th, r100);
        return r100;
    }

    private boolean f(String r100) {
        return !r100.contains(f25755m);
    }

    public String a(JSONObject r110) {
    L34:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(this, "biz", "fmt3", th, String.valueOf(r110));
        e.a(th);
        if (r110 != null) goto L42;
        return SliceInitService.DEFAULT_SWITCH;
    L42:
        return r110.toString();
    L4:
        if (r110.has("appkey") == true) goto L7;
        r110.put("appkey", com.alipay.sdk.m.l.a.f25459g);     // Catch: Throwable -> L34
    L7:
        if (r110.has("ty") == true) goto L10;
        r110.put("ty", "and_lite");     // Catch: Throwable -> L34
    L10:
        if (r110.has(f25762t) == true) goto L13;
        r110.put(f25762t, "h.a.3.8.15");     // Catch: Throwable -> L34
    L13:
        if (r110.has(f25763u) == true) goto L16;
        r110.put(f25763u, this.f25770b);     // Catch: Throwable -> L34
    L16:
        if (r110.has(f25765w) == true) goto L19;
        r110.put(f25765w, this.f25769a);     // Catch: Throwable -> L34
    L19:
        if (r110.has(f25766x) == true) goto L22;
        r110.put(f25766x, System.currentTimeMillis());     // Catch: Throwable -> L34
    L22:
        if (r110.has(f25767y) == true) goto L25;
        r110.put(f25767y, g());     // Catch: Throwable -> L34
    L25:
        if (r110.has(A) == false) goto L27;
    L32:
        return r110.toString();
    L27:
        if (this.f25779k == null) goto L30;
        String r100 = this.f25779k.name + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f25779k.launchMode;     // Catch: Throwable -> L34
    L31:
        r110.put(A, r100);     // Catch: Throwable -> L34
        goto L32
    L30:
        r100 = "null";
        goto L31
    }

    public static HashMap<String, String> a(a r100) {
        HashMap<String, String> r101 = new HashMap();
        if (r100 == null) goto L5;
        r101.put("sdk_ver", "15.8.15");
        r101.put("app_name", r100.f25770b);
        r101.put("token", r100.f25772d);
        r101.put("call_type", r100.f25775g);
        r101.put("ts_api_invoke", String.valueOf(r100.f25773e));
        com.alipay.sdk.m.u.a.a(r100, r101);
    L5:
        return r101;
    }

    public void b(boolean r100) {
        this.f25776h = r100;
    }

    public void c(boolean r100) {
        this.f25778j = r100;
    }

    public String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        if (r100.startsWith(C) == false) goto L10;
        return d(r100);
    L10:
        if (f(r100) == false) goto L14;
        return c(r100);
    L14:
        return e(r100);
    }

    public void a(boolean r100) {
        this.f25777i = r100;
    }

    private String a(String r100, String r101) {
        return r100 + a(new JSONObject()) + r101;
    }

    public static String b(String r100, String r101) {
        Locale r102 = Locale.getDefault();     // Catch: Throwable -> L16
        Object[] r103 = new Object[4];     // Catch: Throwable -> L16
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r103[0] = r100;     // Catch: Throwable -> L16
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        r103[1] = r101;     // Catch: Throwable -> L16
        r103[2] = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L16
        r103[3] = UUID.randomUUID().toString();     // Catch: Throwable -> L16
        return String.format("EP%s%s_%s", new Object[]{"1", n.g(String.format(r102, "%s%s%d%s", r103)), Long.valueOf(System.currentTimeMillis())});
    L16:
        return "-";
    }

    public a(Context r100, String r101, String r110) {
        this.f25769a = "";
        this.f25770b = "";
        this.f25771c = null;
        this.f25776h = false;
        this.f25777i = false;
        this.f25778j = false;
        boolean r102 = TextUtils.isEmpty(r110);
        this.f25780l = new com.alipay.sdk.m.k.b(r100, r102);
        String r103 = b(r101, this.f25770b);
        this.f25772d = r103;
        this.f25773e = SystemClock.elapsedRealtime();
        this.f25774f = n.g();
        ActivityInfo r104 = n.a(r100);
        this.f25779k = r104;
        this.f25775g = r110;
        if (r102 == true) goto L20;
        com.alipay.sdk.m.k.a.a(this, "biz", "eptyp", r110 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103);
        if (r104 == null) goto L7;
        String r111 = r104.name + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r104.launchMode;
    L8:
        com.alipay.sdk.m.k.a.a(this, "biz", "actInfo", r111);
        com.alipay.sdk.m.k.a.a(this, "biz", NotificationCompat.CATEGORY_SYSTEM, n.a(this));
        com.alipay.sdk.m.k.a.a(this, "biz", "sdkv", "1281fd4-clean");
        goto L20
    L7:
        r111 = "null";
    L20:
        this.f25771c = r100.getApplicationContext();     // Catch: Exception -> L11
        PackageInfo r112 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Exception -> L11
        this.f25769a = r112.versionName;     // Catch: Exception -> L11
        this.f25770b = r112.packageName;     // Catch: Exception -> L11
    L13:
        if (r102 == true) goto L15;
        com.alipay.sdk.m.k.a.a(this, "biz", "u" + n.g());
        com.alipay.sdk.m.k.a.a(this, "biz", com.alipay.sdk.m.k.b.Q, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.m.k.a.a(r100, this, r101, this.f25772d);
    L15:
        if (r102 == false) goto L17;
        return;
    L17:
        if (com.alipay.sdk.m.m.a.D().s() == false) goto L23;
        com.alipay.sdk.m.m.a.D().a(this, this.f25771c, true, 2);
        return;
    L23:
        return;
    L11:
        e = move-exception;
        e.a(e);
        goto L13
    }

    private String a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String[] r103 = r100.split(r101);
        int r104 = 0;
    L7:
        if (r104 >= r103.length) goto L19;
        if (TextUtils.isEmpty(r103[r104]) == true) goto L13;
        if (r103[r104].startsWith(r102) == false) goto L13;
        return r103[r104];
    L13:
        r104 = r104 + 1;
        goto L7
    L19:
        return null;
    }

    private String b(String r100, String r101, String r102) throws JSONException {
        String r103 = r100.substring(r101.length());
        boolean r104 = false;
        String r105 = r103.substring(0, r103.length() - r102.length());
        if (r105.length() >= 2) goto L5;
    L9:
        JSONObject r106 = new JSONObject(r105);
    L10:
        String r107 = a(r106);
        if (r104 == false) goto L14;
        r107 = "\"" + r107 + "\"";
    L14:
        return r101 + r107 + r102;
    L5:
        if (r105.startsWith("\"") == false) goto L9;
        if (r105.endsWith("\"") == false) goto L9;
        r106 = new JSONObject(r105.substring(1, r105.length() - 1));
        r104 = true;
        goto L10
    }
}
