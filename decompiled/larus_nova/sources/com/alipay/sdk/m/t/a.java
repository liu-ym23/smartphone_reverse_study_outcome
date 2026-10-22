package com.alipay.sdk.m.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25786g = "alipay_tid_storage";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f25787h = "tidinfo";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f25788i = "tid";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f25789j = "client_key";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25790k = "timestamp";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25791l = "vimei";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25792m = "vimsi";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Context f25793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static a f25794o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25800f;

    /* JADX INFO: renamed from: com.alipay.sdk.m.t.a$a, reason: collision with other inner class name */
    public static class C0494a {
        public static String a() {
            String r100 = a.j().getApplicationContext().getPackageName();     // Catch: Throwable -> L4
        L7:
            return (r100 + "0000000000000000000000000000").substring(0, 24);
        L4:
            th = move-exception;
            e.a(th);
            r100 = "";
            goto L7
        }

        public C0494a() {
        }

        public static boolean a(String r100, String r101) {
            if (a.j() != null) goto L6;
            return false;
        L6:
            return a.j().getSharedPreferences(r100, 0).contains(r101);
        }

        public static void b(String r100, String r101) {
            if (a.j() != null) goto L5;
            return;
        L5:
            a.j().getSharedPreferences(r100, 0).edit().remove(r101).apply();
        }

        public static boolean c(String r100, String r101) {
            if (a.j() != null) goto L6;
            return false;
        L6:
            return a.j().getSharedPreferences(r100, 0).contains(r101);
        }

        public static String d(String r100, String r101) {
            return a(r100, r101, true);
        }

        public static String a(String r100, String r101, boolean r102) {
            if (a.j() != null) goto L5;
            return null;
        L5:
            String r103 = a.j().getSharedPreferences(r100, 0).getString(r101, null);
            if (TextUtils.isEmpty(r103) == true) goto L11;
            if (r102 == false) goto L11;
            r103 = com.alipay.sdk.m.n.e.a(a(), r103, r103);
            if (TextUtils.isEmpty(r103) == false) goto L11;
            e.b(com.alipay.sdk.m.l.a.A, "tid_str: pref failed");
        L11:
            e.b(com.alipay.sdk.m.l.a.A, "tid_str: from local");
            return r103;
        }

        public static void a(String r100, String r101, String r102) {
            a(r100, r101, r102, true);
        }

        public static void a(String r100, String r101, String r102, boolean r103) {
            if (a.j() != null) goto L5;
            return;
        L5:
            SharedPreferences r104 = a.j().getSharedPreferences(r100, 0);
            if (r103 == false) goto L11;
            String r105 = a();
            String r106 = com.alipay.sdk.m.n.e.b(r105, r102, r102);
            if (TextUtils.isEmpty(r106) == false) goto L10;
            String.format("LocalPreference::putLocalPreferences failed %s，%s", new Object[]{r102, r105});
        L10:
            r102 = r106;
        L11:
            r104.edit().putString(r101, r102).apply();
        }
    }

    private void o() {
    }

    private void l() {
        Long r100 = Long.valueOf(System.currentTimeMillis());
        String r101 = null;
        String r102 = C0494a.a(f25786g, f25787h, true);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r102) == true) goto L17;
        JSONObject r103 = new JSONObject(r102);     // Catch: Exception -> L18
        String r104 = r103.optString("tid", "");     // Catch: Exception -> L18
        String r105 = r103.optString("client_key", "");     // Catch: Exception -> L15
        r100 = Long.valueOf(r103.optLong("timestamp", System.currentTimeMillis()));     // Catch: Exception -> L13
        String r106 = r103.optString(f25791l, "");     // Catch: Exception -> L13
        r101 = r103.optString(f25792m, "");     // Catch: Exception -> L11
    L22:
        String r107 = r101;
        r101 = r104;
    L23:
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: load");
        if (a(r101, r105, r106, r107) == false) goto L26;
        m();
        return;
    L26:
        this.f25795a = r101;
        this.f25796b = r105;
        this.f25797c = r100.longValue();
        this.f25798d = r106;
        this.f25799e = r107;
        return;
    L11:
        e = e;
    L21:
        e.a(e);
    L13:
        e = e;
        r106 = null;
    L15:
        e = e;
        r105 = null;
    L20:
        r106 = r105;
        goto L21
    L17:
        r107 = null;
        r105 = null;
        r106 = null;
    L18:
        e = e;
        r104 = null;
        r105 = null;
        goto L20
    }

    private void m() {
        this.f25795a = "";
        this.f25796b = b();
        this.f25797c = System.currentTimeMillis();
        this.f25798d = k();
        this.f25799e = k();
        C0494a.b(f25786g, f25787h);
    }

    private void n() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L16
        r100.put("tid", this.f25795a);     // Catch: Exception -> L16
        r100.put("client_key", this.f25796b);     // Catch: Exception -> L16
        r100.put("timestamp", this.f25797c);     // Catch: Exception -> L16
        r100.put(f25791l, this.f25798d);     // Catch: Exception -> L16
        r100.put(f25792m, this.f25799e);     // Catch: Exception -> L16
        C0494a.a(f25786g, f25787h, r100.toString(), true);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.a(e);
    }

    public void a() {
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: del");
        m();
    }

    public Long e() {
        return Long.valueOf(this.f25797c);
    }

    public boolean i() {
        if (TextUtils.isEmpty(this.f25795a) == false) goto L5;
    L12:
        return true;
    L5:
        if (TextUtils.isEmpty(this.f25796b) == true) goto L12;
        if (TextUtils.isEmpty(this.f25798d) == true) goto L12;
        if (TextUtils.isEmpty(this.f25799e) == true) goto L12;
        return false;
    }

    public a() {
        this.f25800f = false;
    }

    private String k() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public String b() {
        String r100 = Long.toHexString(System.currentTimeMillis());
        if (r100.length() > 10) goto L5;
        return r100;
    L5:
        return r100.substring(r100.length() - 10);
    }

    public boolean h() {
        return i();
    }

    public static /* synthetic */ Context j() {
        return f25793n;
    }

    public String c() {
        return this.f25796b;
    }

    public String d() {
        return this.f25795a;
    }

    public String f() {
        return this.f25798d;
    }

    public String g() {
        return this.f25799e;
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f25794o != null) goto L8;
        f25794o = new a();     // Catch: Throwable -> L13
    L8:
        if (f25793n != null) goto L10;
        f25794o.b(r100);     // Catch: Throwable -> L13
    L10:
        a r101 = f25794o;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r101;
    }

    private void b(Context r100) {
        if (r100 == null) goto L5;
        f25793n = r100.getApplicationContext();
    L5:
        if (this.f25800f == false) goto L7;
        return;
    L7:
        this.f25800f = true;
        l();
    }

    public void a(String r100, String r101) {
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: save");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        this.f25795a = r100;
        this.f25796b = r101;
        this.f25797c = System.currentTimeMillis();
        n();
        o();
        return;
    }

    private boolean a(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (TextUtils.isEmpty(r103) == true) goto L12;
        return false;
    }

    private void a(String r100, String r101, String r102, String r103, Long r104) {
        if (a(r100, r101, r102, r103) == false) goto L5;
        return;
    L5:
        this.f25795a = r100;
        this.f25796b = r101;
        this.f25798d = r102;
        this.f25799e = r103;
        if (r104 != null) goto L8;
        this.f25797c = System.currentTimeMillis();
    L9:
        n();
        return;
    L8:
        this.f25797c = r104.longValue();
        goto L9
    }
}
