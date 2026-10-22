package com.baidu.xclient.gdid;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33608a = "sec_gd_config_mshield";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f33609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f33610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f33611d;

    public e() {
        SharedPreferences r100 = d.f33591b.getSharedPreferences(f33608a, 0);
        this.f33610c = r100;
        this.f33611d = r100.edit();
    }

    public static e e() {
        if (f33609b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33609b != null) goto L9;
        f33609b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f33609b;
    }

    public int A() {
        return b("k_b_app_l_idx", 0);
    }

    public int a() {
        return b("k_f_p_idx", 0);
    }

    public void a(int r100) {
        a("k_mdl_sw", r100);
    }

    public void a(long r100) {
        a("k_last_pull_pl_t", r100);
    }

    public void a(String r100) {
        a("k_cu_p_ver_n", r100);
    }

    public final void a(String r100, int r101) {
        this.f33611d.putInt(r100, r101);
        this.f33611d.commit();
    }

    public final void a(String r100, long r101) {
        this.f33611d.putLong(r100, r101);
        this.f33611d.commit();
    }

    public final void a(String r100, String r101) {
        this.f33611d.putString(r100, r101);
        this.f33611d.commit();
    }

    public final void a(String r100, boolean r101) {
        this.f33611d.putBoolean(r100, r101);
        this.f33611d.commit();
    }

    public void a(boolean r100) {
        a("k_is_rep_m", r100);
    }

    public int b() {
        return b("k_b_f_p_idx", 0);
    }

    public final int b(String r100, int r101) {
        return this.f33610c.getInt(r100, r101);
    }

    public final long b(String r100, long r101) {
        return this.f33610c.getLong(r100, r101);
    }

    public final String b(String r100, String r101) {
        return this.f33610c.getString(r100, r101);
    }

    public void b(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        a("k_t_c_p", r100);
    }

    public void b(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        a("k_pull_p_itl", r100);
    }

    public void b(String r100) {
        a("k_ply_s_n", r100);
    }

    public void b(boolean r100) {
        a("k_is_rep_im_m", r100);
    }

    public final boolean b(String r100, boolean r101) {
        return this.f33610c.getBoolean(r100, r101);
    }

    public void c(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        a("k_t_a_p", r100);
    }

    public void c(long r100) {
        a("k_last_re_fing_t", r100);
    }

    public void c(String r100) {
        a("k_gu_all", r100);
    }

    public void c(boolean r100) {
        a("k_is_rep_im_e", r100);
    }

    public boolean c() {
        return b("k_is_rp_mgc", false);
    }

    public void d() {
        a("k_is_rp_mgc", !c());
    }

    public void d(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        a("k_t_ca_p", r100);
    }

    public void d(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        a("k_re_fing_itl", r100);
    }

    public void d(String r100) {
        a("k_rep_al", r100);
    }

    public void d(boolean r100) {
        a("k_is_rp_rg_crc", r100);
    }

    public void e(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        boolean r101 = false;
    L8:
        a("l_td_t_s", r101);
        return;
    L7:
        r101 = true;
        goto L8
    }

    public void e(long r100) {
        a("k_last_alm_t", r100);
    }

    public void e(String r100) {
        a("k_rep_f_if", r100);
    }

    public void e(boolean r100) {
        a("k_is_rep_lc_4_p", r100);
    }

    public long f() {
        return b("k_last_pull_pl_t", 0);
    }

    public void f(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        boolean r101 = false;
    L8:
        a("k_t_m_s_s", r101);
        return;
    L7:
        r101 = true;
        goto L8
    }

    public void f(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        a("k_alm_itl", r100);
    }

    public void f(String r100) {
        a("k_last_ds_d", r100);
    }

    public void f(boolean r100) {
        a("k_is_rep_ad", r100);
    }

    public long g() {
        return b("k_pull_p_itl", com.baidu.xclient.gdid.d.a.f33601b * 8);
    }

    public void g(int r100) {
        a("k_app_l_idx", r100);
    }

    public void g(long r100) {
        a("k_last_pi_t", r100);
    }

    public void g(String r100) {
        a("k_gd_p", r100);
    }

    public void g(boolean r100) {
        a("k_is_rep_im_c", r100);
    }

    public long h() {
        return b("k_last_re_fing_t", 0);
    }

    public void h(int r100) {
        a("k_b_app_l_idx", r100);
    }

    public void h(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        a("K_pi_itl", r100);
    }

    public void h(boolean r100) {
        a("k_is_rep_o_i", r100);
    }

    public long i() {
        return b("k_re_fing_itl", com.baidu.xclient.gdid.d.a.f33602c);
    }

    public void i(int r100) {
        a("k_f_p_idx", r100);
    }

    public void i(boolean r100) {
        a("k_is_rep_wf", r100);
    }

    public String j() {
        return b("k_cu_p_ver_n", "");
    }

    public void j(int r100) {
        a("k_b_f_p_idx", r100);
    }

    public void j(boolean r100) {
        a("k_ig_u_a", r100);
    }

    public String k() {
        String r100 = b("k_ply_s_n", "");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        JSONObject r101 = new JSONObject();
        r101.put("e", 1);     // Catch: Throwable -> L9
        r101.put("l", 1);     // Catch: Throwable -> L9
        r101.put("p", ".zqobbx.pa");     // Catch: Throwable -> L9
        r101.put(RXScreenCaptureService.KEY_INDEX, 1);     // Catch: Throwable -> L9
        r101.put("m", 0);     // Catch: Throwable -> L9
        r101.put("w", 1);     // Catch: Throwable -> L9
        r101.put("s", 1);     // Catch: Throwable -> L9
        r101.put("c", 0);     // Catch: Throwable -> L9
        r101.put("y", 20);     // Catch: Throwable -> L9
        r101.put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, 20);     // Catch: Throwable -> L9
        r101.put("x", 0);     // Catch: Throwable -> L9
        r101.put("u", 0);     // Catch: Throwable -> L9
        r101.put(ce.f26391f, 20);     // Catch: Throwable -> L9
        r101.put(OfficeSDKRequestTag.KEY_NEW_USER, 0);     // Catch: Throwable -> L9
        r101.put("t", 0);     // Catch: Throwable -> L9
        r101.put("q", 0);     // Catch: Throwable -> L9
        r101.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "");     // Catch: Throwable -> L9
        r101.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "");     // Catch: Throwable -> L9
    L12:
        return r101.toString();
    L9:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        goto L12
    L5:
        return new String(Base64.decode(r100, 1));
    }

    public void k(boolean r100) {
        a("k_is_rp_lp", r100);
    }

    public long l() {
        return b("k_last_alm_t", 0);
    }

    public void l(boolean r100) {
        a("k_is_rp_dnp", r100);
    }

    public long m() {
        return b("k_alm_itl", com.baidu.xclient.gdid.d.a.f33601b);
    }

    public long n() {
        return b("k_last_pi_t", 0);
    }

    public long o() {
        return b("K_pi_itl", com.baidu.xclient.gdid.d.a.f33601b * 12);
    }

    public String p() {
        return b("k_ext_id4", "");
    }

    public String q() {
        return b("k_gu_all", "");
    }

    public String r() {
        return b("k_rep_al", "");
    }

    public String s() {
        return b("k_rep_f_if", "");
    }

    public String t() {
        return b("k_n_g_d", "");
    }

    public String u() {
        return b("k_ext_j", "");
    }

    public boolean v() {
        if (y() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean w() {
        int r100 = y();
        if (r100 == 3) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean x() {
        int r100 = y();
        if (r100 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    public int y() {
        return b("k_mdl_sw", 3);
    }

    public int z() {
        return b("k_app_l_idx", 0);
    }
}
