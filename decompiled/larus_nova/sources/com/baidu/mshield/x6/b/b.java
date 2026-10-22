package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32552a = "kship";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32553b = "kshinp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f32554c = "krti";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f32555d = "ksdci";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f32556e = "kwfi";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f32557f = "kbti";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f32558g = "kssi";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f32559h = "ktpti";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f32560i = "kusbi";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f32561j = "kdkdi";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f32562k = "kcpui";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f32563l = "ksci";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f32564m = "kfstl";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f32565n = "kvti";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f32566o = "kvtij";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f32567p = "kopgl";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f32568q = "kpalwp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f32569r = "kstafac";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f32570s = "ksglcid";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f32571t = "kshwoaid";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f32572u = "kxceck";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SharedPreferences f32573v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SharedPreferences.Editor f32574w;

    public String A() {
        return this.f32573v.getString("global_xid", "");
    }

    public String B() {
        return this.f32573v.getString("h_ca_to_in", "");
    }

    public boolean C() {
        return this.f32573v.getBoolean("kicfr", false);
    }

    public long D() {
        return this.f32573v.getLong("l_bd_r_t", 0);
    }

    public String E() {
        return this.f32573v.getString("g_l_p_tar", "");
    }

    public int F() {
        return this.f32573v.getInt("l_to_re_re", 0);
    }

    public String G() {
        return this.f32573v.getString("l_to_re_t_re", "");
    }

    public int H() {
        return this.f32573v.getInt("s_to_re_co", 0);
    }

    public long I() {
        return this.f32573v.getLong("s_to_re_ot", 0);
    }

    public int J() {
        return this.f32573v.getInt("s_zid_lc_s", 1);
    }

    public long K() {
        return this.f32573v.getLong("s_zid_lc_t", 0);
    }

    public String L() {
        return this.f32573v.getString("g_ma_m", "");
    }

    public String M() {
        return this.f32573v.getString("g_mo_m", "");
    }

    public String N() {
        return this.f32573v.getString("m_s_i_cc_id", "");
    }

    public String O() {
        return this.f32573v.getString("m_s_i_id", "");
    }

    public String P() {
        return this.f32573v.getString("g_b_o_b_s", "");
    }

    public String Q() {
        return this.f32573v.getString("global_o_xid", "");
    }

    public boolean a() {
        return this.f32573v.getBoolean("s_ai_n_c_f", false);
    }

    public int b() {
        return this.f32573v.getInt("s_pc_al_i", 360);
    }

    public String c() {
        return this.f32573v.getString("re_stc_s_t", "");
    }

    public String d() {
        return this.f32573v.getString("g_rn_m", "");
    }

    public String e() {
        return this.f32573v.getString("g_rv_m", "");
    }

    public boolean f() {
        return this.f32573v.getBoolean("s_s_c_f", false);
    }

    public String g() {
        String r100 = this.f32573v.getString("tk_rm_py", "");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return f.a(r100);
    L8:
        th = move-exception;
        f.b(th);
        return "";
    }

    public String h() {
        return this.f32573v.getString("s_to_dy_d", "");
    }

    public int i() {
        return this.f32573v.getInt("s_to_dy_op", 0);
    }

    public String j() {
        return this.f32573v.getString("s_to_re_d", "");
    }

    public int k() {
        return this.f32573v.getInt("s_to_re_li", 10);
    }

    public boolean l() {
        return this.f32573v.getBoolean("is_x_r_f_2_1_0", false);
    }

    public int m() {
        return this.f32573v.getInt("s_zid_cf", 0);
    }

    public boolean n() {
        return this.f32573v.getBoolean("s_z_d_c_f", false);
    }

    public int o() {
        return this.f32573v.getInt("g_z_c_f_q", 60);
    }

    public final void q() {
        this.f32574w.commit();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        f.b(th);
    }

    public String r() {
        return this.f32573v.getString("g_a_i_m", "");
    }

    public String s() {
        return this.f32573v.getString("g_bu_m", "");
    }

    public String t() {
        return this.f32573v.getString("g_bvr_m", "");
    }

    public String u() {
        return this.f32573v.getString("g_b_g_b_s", "");
    }

    public int v() {
        return this.f32573v.getInt("s_c_f_o_qec", 0);
    }

    public int w() {
        return this.f32573v.getInt("s_c_f_o_ttc", 10);
    }

    public String x() {
        return this.f32573v.getString("g_d_d_v", "");
    }

    public String y() {
        return this.f32573v.getString("g_e_s_m", "");
    }

    public boolean z() {
        return this.f32573v.getBoolean("i_ft_tm_z", true);
    }

    public void p() {
        b("tk_rm_py");
    }

    public b(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("msfffppcfg", 4);     // Catch: Throwable -> L5
        this.f32573v = r101;     // Catch: Throwable -> L5
        this.f32574w = r101.edit();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.b(th);
    }

    public void a(int r100) {
        this.f32574w.putInt("s_c_f_o_qec", r100);
        q();
    }

    public void b(String r100) {
    L6:
        th = move-exception;
        f.b(th);
        return;
    L3:
        if (TextUtils.isEmpty(this.f32573v.getString(r100, "")) == true) goto L11;
        this.f32574w.remove(r100);     // Catch: Throwable -> L6
        q();     // Catch: Throwable -> L6
        return;
    }

    public void c(long r100) {
        this.f32574w.putLong("s_zid_lc_t", r100);
        q();
    }

    public void d(int r100) {
        this.f32574w.putInt("l_to_re_re", r100);
        q();
        long r101 = System.currentTimeMillis();
        if (r100 <= 0) goto L5;
        int r102 = 1;
    L6:
        a(r101, r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void e(int r100) {
        this.f32574w.putInt("s_to_re_co", r100);
        q();
    }

    public void f(int r100) {
        this.f32574w.putInt("s_nc_al_i", r100);
        q();
    }

    public void g(int r100) {
        this.f32574w.putInt("s_pc_al_i", r100);
        q();
    }

    public void h(String r100) {
        this.f32574w.putString("g_e_s_m", r100);
        this.f32574w.commit();
    }

    public void i(int r100) {
        this.f32574w.putInt("s_to_dy_op", r100);
        q();
    }

    public void j(int r100) {
        this.f32574w.putInt("s_to_re_li", r100);
        q();
    }

    public void k(int r100) {
        this.f32574w.putInt("s_zid_cf", r100);
        q();
    }

    public void l(int r100) {
        this.f32574w.putInt("g_z_c_f_q", r100);
        q();
    }

    public void m(int r100) {
        this.f32574w.putInt("y_z_c_s", r100);
        q();
    }

    public void n(String r100) {
        this.f32574w.putString("m_s_i_cc_id", r100);
        q();
    }

    public void o(String r100) {
        this.f32574w.putString("m_s_i_id", r100);
        q();
    }

    public void p(String r100) {
        this.f32574w.putString("g_b_o_b_s", r100);
        q();
    }

    public void q(String r100) {
        this.f32574w.putString("global_o_xid", r100);
        q();
    }

    public void r(String r100) {
        this.f32574w.putString("pu_py_t", r100);
        this.f32574w.commit();
    }

    public void s(String r100) {
        this.f32574w.putString("re_stc_s_t", r100);
        this.f32574w.commit();
    }

    public void t(String r100) {
        this.f32574w.putString("g_rn_m", r100);
        q();
    }

    public void u(String r100) {
        this.f32574w.putString("g_rv_m", r100);
        q();
    }

    public void v(String r100) {
    L7:
        th = move-exception;
        f.b(th);
        return;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String r101 = f.b(r100);     // Catch: Throwable -> L7
        this.f32574w.putString("tk_rm_py", r101);     // Catch: Throwable -> L7
        this.f32574w.commit();     // Catch: Throwable -> L7
    }

    public void w(String r100) {
        this.f32574w.putString("s_to_dy_d", r100);
        q();
    }

    public void x(String r100) {
        this.f32574w.putString("s_to_re_d", r100);
        q();
    }

    public void y(String r100) {
        this.f32574w.putString("g_l_b_x_v", r100);
        q();
    }

    public void a(long r100) {
        this.f32574w.putLong("l_bd_r_t", r100);
        q();
    }

    public void b(int r100) {
        this.f32574w.putInt("s_c_f_o_ttc", r100);
        q();
    }

    public void c(boolean r100) {
        this.f32574w.putBoolean("s_ai_n_c_f", r100);
        q();
    }

    public void d(long r100) {
        this.f32574w.putLong("g_u_tk_ti", r100);
        this.f32574w.commit();
    }

    public void e(String r100) {
        this.f32574w.putString("g_bvr_m", r100);
        q();
    }

    public void f(String r100) {
        this.f32574w.putString("g_b_g_b_s", r100);
        q();
    }

    public void g(boolean r100) {
        this.f32574w.putBoolean("s_z_d_c_f", r100);
        q();
    }

    public void h(int r100) {
        this.f32574w.putInt("s_sd_al_i", r100);
        q();
    }

    public void i(String r100) {
        this.f32574w.putString("global_xid", r100);
        q();
    }

    public void j(String r100) {
        this.f32574w.putString("h_ca_to_in", r100);
        q();
    }

    public void k(String r100) {
        this.f32574w.putString("g_b_z_o_c_t_d", r100);
        q();
    }

    public void l(String r100) {
        this.f32574w.putString("g_ma_m", r100);
        q();
    }

    public void m(String r100) {
        this.f32574w.putString("g_mo_m", r100);
        q();
    }

    public void a(boolean r100) {
        this.f32574w.putBoolean("i_ft_tm_z", r100);
        q();
    }

    public void b(long r100) {
        this.f32574w.putLong("s_to_re_ot", r100);
        q();
    }

    public void c(int r100) {
        this.f32574w.putInt("k_em_t_a", r100);
        q();
    }

    public void d(boolean r100) {
        this.f32574w.putBoolean("s_s_c_f", r100);
        q();
    }

    public void e(boolean r100) {
        this.f32574w.putBoolean("is_sim_changed_today", r100);
        q();
    }

    public void f(boolean r100) {
        this.f32574w.putBoolean("is_x_r_f_2_1_0", r100);
        q();
    }

    public void g(String r100) {
        this.f32574w.putString("g_d_d_v", r100);
        q();
    }

    public String a(String r100) {
        return this.f32573v.getString(r100, "");
    }

    public void b(boolean r100) {
        this.f32574w.putBoolean("kicfr", r100);
        q();
    }

    public void c(String r100) {
        this.f32574w.putString("g_a_i_m", r100);
        q();
    }

    public void d(String r100) {
        this.f32574w.putString("g_bu_m", r100);
        q();
    }

    public void a(long r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = "1";
    L12:
    L9:
        th = move-exception;
        f.b(th);
        return;
    L7:
        this.f32574w.putString("g_l_p_tar", r100 + "#" + r102);     // Catch: Throwable -> L9
        q();     // Catch: Throwable -> L9
        return;
    L4:
        r102 = "0";
        goto L12
    }

    public void a(long r100, int r101) {
    L6:
        th = move-exception;
        f.b(th);
        return;
    L4:
        this.f32574w.putString("l_to_re_t_re", r100 + "#" + r101);     // Catch: Throwable -> L6
        q();     // Catch: Throwable -> L6
    }

    public void a(String r100, String r101) {
        this.f32574w.putString(r100, r101);
        q();
    }
}
