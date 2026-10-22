package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f32421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f32422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences.Editor f32423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f32424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SharedPreferences.Editor f32425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SharedPreferences f32426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SharedPreferences.Editor f32427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f32428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f32430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, SharedPreferences> f32431k;

    public int A() {
        return this.f32422b.getInt("wi_fa_pu_cl", 0);
    }

    public long B() {
        return this.f32426f.getLong("re_net_pu_de", 0);
    }

    public String C() {
        return this.f32426f.getString("re_net_ali2_version", "");
    }

    public int D() {
        return this.f32426f.getInt("re_net_dy_lt", 50);
    }

    public int E() {
        return this.f32426f.getInt("g_r_d_d_n", 0);
    }

    public int F() {
        return this.f32426f.getInt("re_net_wt", 3);
    }

    public long G() {
        return this.f32426f.getLong("re_last_ofline_time", 0);
    }

    public int H() {
        return this.f32426f.getInt("re_net_one_lt", 5);
    }

    public int I() {
        return this.f32426f.getInt("re_net_over", 7);
    }

    public int J() {
        if ("com.baidu.BaiduMap.meizu".equals(this.f32428h.getPackageName()) == true) goto L5;
        int r100 = this.f32426f.getInt("re_net_hr", 3);
        String[] r101 = com.baidu.mshield.utility.a.i(this.f32428h);     // Catch: Throwable -> L23
        if (r101.length != 2) goto L22;
        if (TextUtils.isEmpty(r101[0]) == true) goto L22;
        if (TextUtils.isEmpty(r101[1]) == true) goto L22;
        if ("200080".equals(r101[0]) == false) goto L22;
        if (MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP.equals(this.f32428h.getPackageName()) == false) goto L22;
        if (r100 >= 24) goto L22;
        return 24;
    L22:
        return r100;
    L5:
        return this.f32426f.getInt("re_net_hr", 24);
    }

    public String K() {
        return this.f32422b.getString("svi_n_wm", "");
    }

    public String a() {
        return this.f32422b.getString("svi_wm", "");
    }

    public long b() {
        long r100 = this.f32422b.getLong("se_ae_fd", 0);
        if (r100 != 0) goto L6;
        long r101 = System.currentTimeMillis();
        k();
        return r101;
    L6:
        return r100;
    }

    public long c() {
        return this.f32426f.getLong("re_day_b_t", 0);
    }

    public long d() {
        return this.f32426f.getLong("re_day_len", 0);
    }

    public String e() {
        return this.f32424d.getString("xytk", "");
    }

    public String f() {
        return this.f32424d.getString("sgud", "");
    }

    public int g() {
        return this.f32426f.getInt("up_nu_co", 50);
    }

    public int h() {
        return this.f32426f.getInt("up_nu_li", 100);
    }

    public void i() {
        Bundle r100 = new Bundle();
        r100.putString(WikiFolderPushPlugin.OPT, "querySharedHandler");
        Bundle r101 = g.a(this.f32428h, "CallPreferences", r100, false, "3.5.8.0", true);
        if (r101 == null) goto L6;
        this.f32430j = r101.getString("handle_platform");
        com.baidu.mshield.b.c.a.b("get can handle shared platform:" + this.f32430j);
        return;
    }

    public void j() {
        this.f32423c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.f32423c.commit();
    }

    public void k() {
        this.f32423c.putLong("se_ae_fd", System.currentTimeMillis());
        this.f32423c.commit();
    }

    public int l() {
        return this.f32422b.getInt("mo_ae_fa_ct", 0);
    }

    public String m() {
        return this.f32424d.getString("rpandid", "");
    }

    public String n() {
        return this.f32424d.getString("xyus", "");
    }

    public String o() {
        return this.f32426f.getString("re_a_cv", "");
    }

    public List<com.baidu.mshield.rp.b.a> p() {
        String r100 = this.f32426f.getString("re_con", "");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        String[] r102 = r100.split("\\|\\|");
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L16;
        String r105 = r102[r104];
        if (TextUtils.isEmpty(r105) == true) goto L15;
        com.baidu.mshield.rp.b.a r106 = com.baidu.mshield.rp.b.a.a(r105);
        if (r106 == null) goto L15;
        r101.add(r106);
    L15:
        r104 = r104 + 1;
        goto L7
    L16:
        return r101;
    }

    public String q() {
        return this.f32424d.getString("xyusec", "");
    }

    public String r() {
        return this.f32424d.getString("xygls", "");
    }

    public String s() {
        return this.f32424d.getString("rpiiem", "");
    }

    public String t() {
        return this.f32426f.getString("re_a_lc", "");
    }

    public String u() {
        return this.f32424d.getString("rpmacadd", "");
    }

    public String v() {
        return this.f32424d.getString("xytk_m", "");
    }

    public long y() {
        long r100 = this.f32422b.getLong("pu_cl_fd", 0);
        if (r100 != 0) goto L6;
        long r101 = System.currentTimeMillis();
        j();
        return r101;
    L6:
        return r100;
    }

    public int z() {
        return this.f32422b.getInt("mo_fa_pu_cl", 0);
    }

    public SharedPreferences w() {
        return this.f32422b;
    }

    public SharedPreferences x() {
        return this.f32424d;
    }

    public a(Context r110) {
        SharedPreferences r100 = null;
        this.f32430j = null;
        this.f32431k = new HashMap();
        this.f32428h = r110;
        this.f32429i = com.baidu.mshield.utility.a.h(r110);
        com.baidu.mshield.b.c.a.b("checking platformName:mshield_SOFIRE");
        i();
        if (this.f32429i != 1) goto L5;
        SharedPreferences r101 = r110.getSharedPreferences("leroadmshieldcfg", 0);
    L6:
        c r102 = new c(this.f32428h, r101, "leroadmshieldcfg", false, this.f32429i);
        this.f32422b = r102;
        this.f32423c = r102.edit();
        if (this.f32429i == 1) goto L9;
    L11:
        SharedPreferences r103 = null;
    L12:
        c r104 = new c(this.f32428h, r103, "leroadcfg", true, this.f32429i, this.f32430j);
        this.f32424d = r104;
        this.f32425e = r104.edit();
        if (this.f32429i != 1) goto L15;
        r100 = r110.getSharedPreferences("msre_po_rt", 0);
    L15:
        c r111 = new c(this.f32428h, r100, "msre_po_rt", false, this.f32429i);
        this.f32426f = r111;
        this.f32427g = r111.edit();
        return;
    L9:
        if (TextUtils.isEmpty(this.f32430j) == false) goto L11;
        r103 = r110.getSharedPreferences("leroadcfg", 0);
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public Bundle a(Bundle r110) {
        String r100 = r110.getString(WikiFolderPushPlugin.OPT);     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if ("querySharedHandler".equals(r100) == false) goto L10;
        Bundle r111 = new Bundle();     // Catch: Throwable -> L93
        r111.putString("handle_platform", "mshield");     // Catch: Throwable -> L93
        return r111;
    L10:
        String r101 = r110.getString("pref_name");     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return null;
    L13:
        String r102 = r110.getString("key");     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r102) == false) goto L16;
        return null;
    L16:
        com.baidu.mshield.b.c.a.b("handleRemoteCall:" + r100 + "_" + r101 + "_" + r102);     // Catch: Throwable -> L93
        SharedPreferences r103 = a(r101);     // Catch: Throwable -> L93
        byte r104 = 0;
        if (r100.startsWith(MonitorConstants.CONNECT_TYPE_GET) == false) goto L59;
        String r112 = r110.getString("defult_value");     // Catch: Throwable -> L93
        if ("getString".equals(r100) == false) goto L21;
    L23:
        com.baidu.mshield.b.c.a.b("handleRemoteCall get:" + r100 + "_defValue=" + r112);     // Catch: Throwable -> L93
        if (r103 != null) goto L26;
        return null;
    L26:
        Bundle r105 = new Bundle();     // Catch: Throwable -> L93
        switch(r100.hashCode()) {
            case -1249359687: goto L42;
            case -75354382: goto L39;
            case 804029191: goto L36;
            case 1101572082: goto L33;
            case 1953351846: goto L30;
            default: goto L44;
        };     // Catch: Throwable -> L93
    L44:
        r104 = -1;
    L46:
        if (r104 == 0) goto L56;
        if (r104 == 1) goto L55;
        if (r104 == 2) goto L54;
        if (r104 == 3) goto L53;
        if (r104 != 4) goto L57;
        r105.putBoolean("result", r103.getBoolean(r102, Boolean.parseBoolean(r112)));     // Catch: Throwable -> L93
    L57:
        return r105;
    L53:
        r105.putFloat("result", r103.getFloat(r102, Float.parseFloat(r112)));     // Catch: Throwable -> L93
        goto L57
    L54:
        r105.putLong("result", r103.getLong(r102, Long.parseLong(r112)));     // Catch: Throwable -> L93
        goto L57
    L55:
        r105.putInt("result", r103.getInt(r102, Integer.parseInt(r112)));     // Catch: Throwable -> L93
        goto L57
    L56:
        r105.putString("result", r103.getString(r102, r112));     // Catch: Throwable -> L93
        goto L57
    L30:
        if (r100.equals("getFloat") == false) goto L44;
        r104 = 3;
        goto L46
    L33:
        if (r100.equals("getBoolean") == false) goto L44;
        r104 = 4;
        goto L46
    L36:
        if (r100.equals("getString") == false) goto L44;
    L39:
        if (r100.equals("getLong") == false) goto L44;
        r104 = 2;
        goto L46
    L42:
        if (r100.equals("getInt") == false) goto L44;
        r104 = 1;
        goto L46
    L21:
        if (TextUtils.isEmpty(r112) == false) goto L23;
        return null;
    L59:
        if (r100.startsWith("put") == false) goto L95;
        SharedPreferences.Editor r106 = r103.edit();     // Catch: Throwable -> L93
        com.baidu.mshield.b.c.a.b("handleRemoteCall put:".concat(r100));     // Catch: Throwable -> L93
        switch(r100.hashCode()) {
            case -976920992: goto L76;
            case -462997504: goto L73;
            case -219689429: goto L70;
            case 478450201: goto L67;
            case 1773932685: goto L64;
            default: goto L78;
        };     // Catch: Throwable -> L93
    L78:
        r104 = -1;
    L80:
        if (r104 == 0) goto L90;
        if (r104 == 1) goto L89;
        if (r104 == 2) goto L88;
        if (r104 == 3) goto L87;
        if (r104 != 4) goto L91;
        r106.putBoolean(r102, r110.getBoolean("value"));     // Catch: Throwable -> L93
    L91:
        r106.apply();     // Catch: Throwable -> L93
        goto L95
    L87:
        r106.putFloat(r102, r110.getFloat("value"));     // Catch: Throwable -> L93
        goto L91
    L88:
        r106.putLong(r102, r110.getLong("value"));     // Catch: Throwable -> L93
        goto L91
    L89:
        r106.putInt(r102, r110.getInt("value"));     // Catch: Throwable -> L93
        goto L91
    L90:
        r106.putString(r102, r110.getString("value"));     // Catch: Throwable -> L93
        goto L91
    L64:
        if (r100.equals("putFloat") == false) goto L78;
        r104 = 3;
        goto L80
    L67:
        if (r100.equals("putBoolean") == false) goto L78;
        r104 = 4;
        goto L80
    L70:
        if (r100.equals("putLong") == false) goto L78;
        r104 = 2;
        goto L80
    L73:
        if (r100.equals("putString") == false) goto L78;
    L76:
        if (r100.equals("putInt") == false) goto L78;
        r104 = 1;
    L95:
        return null;
    L93:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L95
    }

    public String b(String r100) {
        return this.f32426f.getString("al_da" + r100, "");
    }

    public SharedPreferences c(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L24;
        return null;
    L24:
        Map<String, SharedPreferences> r100 = this.f32431k;     // Catch: Throwable -> L19
        monitor-enter(r100);     // Catch: Throwable -> L19
        SharedPreferences r101 = this.f32431k.get(r110);     // Catch: Throwable -> L16
        if (r101 == null) goto L10;
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return r101;
    L10:
        if (this.f32429i != 1) goto L12;
        SharedPreferences r102 = this.f32428h.getSharedPreferences(r110, 0);     // Catch: Throwable -> L16
    L13:
        c r103 = new c(this.f32428h, r102, r110, false, this.f32429i);     // Catch: Throwable -> L16
        this.f32431k.put(r110, r103);     // Catch: Throwable -> L16
        r101 = r103;
        goto L14
    L12:
        r102 = null;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return null;
    }

    public String d(String r100) {
        return this.f32426f.getString("re_net_ali2_" + r100, "");
    }

    public boolean e(String r100) {
        return this.f32426f.getBoolean("re_net_ins_" + r100, false);
    }

    public void f(int r100) {
        this.f32427g.putInt("re_net_dy_lt", r100);
        this.f32427g.commit();
    }

    public void g(String r100) {
        this.f32425e.putString("rpandid", r100);
        this.f32425e.commit();
    }

    public void h(String r100) {
        this.f32425e.putString("xyus", r100);
        this.f32425e.commit();
    }

    public void i(String r100) {
        this.f32425e.putString("xyusec", r100);
        this.f32425e.commit();
    }

    public void j(String r100) {
        this.f32425e.putString("xygls", r100);
        this.f32425e.commit();
    }

    public void k(String r100) {
        this.f32425e.putString("rpiiem", r100);
        this.f32425e.commit();
    }

    public void l(String r100) {
        this.f32425e.putString("rpmacadd", r100);
        this.f32425e.commit();
    }

    public void m(String r100) {
        this.f32425e.putString("xytk_m", r100);
        this.f32425e.apply();
    }

    public void n(int r100) {
        this.f32427g.putInt("up_nu_co", r100);
        this.f32427g.commit();
    }

    public void o(int r100) {
        this.f32427g.putInt("up_nu_li", r100);
        this.f32427g.commit();
    }

    public void a(com.baidu.mshield.rp.b.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = this.f32426f.getString("re_con", "");
        this.f32427g.putString("re_con", r101 + "||" + com.baidu.mshield.rp.b.a.a(r100));
        this.f32427g.commit();
    }

    public void b(int r100) {
        this.f32423c.putInt("mo_fa_pu_ap", r100);
        this.f32423c.commit();
    }

    public void c(int r100) {
        this.f32423c.putInt("wi_fa_pu_ap", r100);
        this.f32423c.commit();
    }

    public void d(int r100) {
        this.f32423c.putInt("mo_fa_pu_cl", r100);
        this.f32423c.commit();
    }

    public void e(int r100) {
        this.f32423c.putInt("wi_fa_pu_cl", r100);
        this.f32423c.commit();
    }

    public void f(String r100) {
        this.f32427g.putString("li_pk_s", r100);
        this.f32427g.commit();
    }

    public void g(int r100) {
        this.f32427g.putInt("g_r_d_d_n", r100);
        this.f32427g.commit();
    }

    public void h(int r100) {
        this.f32427g.putInt("re_net_wt", r100);
        this.f32427g.commit();
    }

    public void i(int r100) {
        this.f32427g.putInt("re_net_ty", r100);
        this.f32427g.commit();
    }

    public void j(int r100) {
        this.f32427g.putInt("re_net_one_lt", r100);
        this.f32427g.commit();
    }

    public void k(int r100) {
        this.f32427g.putInt("re_net_over", r100);
        this.f32427g.commit();
    }

    public void l(int r100) {
        this.f32427g.putInt("re_net_hr_bc", r100);
        this.f32427g.commit();
    }

    public void m(int r100) {
        this.f32427g.putInt("re_net_hr", r100);
        this.f32427g.commit();
    }

    public void n(String r100) {
        this.f32427g.putString("re_net_ali2_version", r100);
        this.f32427g.commit();
    }

    public void o(String r100) {
        this.f32425e.putString("sgud", r100);
        this.f32425e.commit();
    }

    public final SharedPreferences a(String r100) {
        if (r100.equals("leroadmshieldcfg") == false) goto L7;
        return this.f32422b;
    L7:
        if (r100.equals("leroadcfg") == false) goto L11;
        return this.f32424d;
    L11:
        if (r100.equals("msre_po_rt") == false) goto L15;
        return this.f32426f;
    L15:
        return c(r100);
    }

    public void b(long r100) {
        this.f32427g.putLong("re_last_ofline_time", r100);
        this.f32427g.commit();
    }

    public void c(long r100) {
        this.f32427g.putLong("re_day_b_t", r100);
        this.f32427g.commit();
    }

    public void d(long r100) {
        this.f32427g.putLong("re_day_len", r100);
        this.f32427g.commit();
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
        if (r100 != null) goto L9;
        a r101 = f32421a;     // Catch: Throwable -> L14
        monitor-exit(a.class);
        return r101;
    L9:
        if (f32421a != null) goto L11;
        f32421a = new a(r100);     // Catch: Throwable -> L14
    L11:
        a r102 = f32421a;     // Catch: Throwable -> L14
        monitor-exit(a.class);
        return r102;
    L14:
        th = move-exception;
        throw th;
    }

    public void a(int r100) {
        this.f32423c.putInt("mo_ae_fa_ct", r100);
        this.f32423c.commit();
    }

    public void a(long r100) {
        this.f32427g.putLong("re_net_pu_de", r100);
        this.f32427g.commit();
    }

    public void a(List<com.baidu.mshield.rp.b.a> r100, com.baidu.mshield.rp.b.a r101) {
        if (r101 == null) goto L13;
        if (r100 == null) goto L14;
        int r102 = r100.indexOf(r101);
        if (r102 != (-1)) goto L8;
        return;
    L8:
        com.baidu.mshield.rp.b.a r103 = (com.baidu.mshield.rp.b.a) ListProtector.get(r100, r102);
        if (r103 != null) goto L11;
        return;
    L11:
        String r104 = com.baidu.mshield.rp.b.a.a(r103);
        String r105 = com.baidu.mshield.rp.b.a.a(r101);
        String r106 = this.f32426f.getString("re_con", "").replace(r104, r105);
        this.f32427g.putString("re_con", r106);
        this.f32427g.commit();
        return;
    L14:
        return;
    }

    public void b(String r100, String r101) {
        this.f32427g.putString("in_da" + r100, r101);
        this.f32427g.commit();
    }

    public void c(String r100, String r101) {
        this.f32427g.putString("re_net_ali2_" + r100, r101);
        this.f32427g.commit();
    }

    public void d(String r100, String r101) {
        this.f32423c.putString("svi_n_wm", r100 + "-" + r101);
        this.f32423c.commit();
    }

    public void a(String r100, String r101) {
        this.f32427g.putString("al_da" + r100, r101);
        this.f32427g.commit();
    }

    public void a(String r100, boolean r101) {
        this.f32427g.putBoolean("re_net_ins_" + r100, r101);
        this.f32427g.commit();
    }
}
