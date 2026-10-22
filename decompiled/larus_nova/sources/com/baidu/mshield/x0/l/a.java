package com.baidu.mshield.x0.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f32535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f32536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f32537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f32538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SharedPreferences.Editor f32539e;

    public int g() {
        String r100 = c("plc03");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r100) == true) goto L11;
        JSONObject r101 = new JSONObject(r100).optJSONObject("5");     // Catch: Throwable -> L9
        if (r101 == null) goto L11;
        return r101.optInt("1", 1);
    L11:
        return 1;
    L9:
        th = move-exception;
        d.a(th);
        goto L11
    }

    public int l() {
        String r100 = c("plc62");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r100) == true) goto L11;
        JSONObject r101 = new JSONObject(r100).optJSONObject("3");     // Catch: Throwable -> L9
        if (r101 == null) goto L11;
        return r101.optInt("2", 1);
    L11:
        return 1;
    L9:
        th = move-exception;
        d.a(th);
        goto L11
    }

    public String a() {
        return this.f32537c.getString("li_pk_s", "");
    }

    public int b() {
        return this.f32535a.getInt("apd_inte", 24);
    }

    public String c() {
        return this.f32537c.getString("re_a_cv", "");
    }

    public boolean d() {
        if (this.f32535a.getInt("cloud_sw", 0) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public List<b> e() {
        String r100 = this.f32537c.getString("re_con", "");
        com.baidu.mshield.b.c.a.b("re_con==" + r100);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        String[] r102 = r100.split("\\|\\|");     // Catch: Throwable -> L17
        int r103 = r102.length;     // Catch: Throwable -> L17
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L19;
        String r105 = r102[r104];     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r105) == true) goto L16;
        b r106 = b.a(r105);     // Catch: Throwable -> L17
        if (r106 != null) goto L15;
        com.baidu.mshield.b.c.a.b("re_con==empty");     // Catch: Throwable -> L17
        goto L16
    L15:
        com.baidu.mshield.b.c.a.b("re_con==" + r106.toString());     // Catch: Throwable -> L17
        r101.add(r106);     // Catch: Throwable -> L17
    L16:
        r104 = r104 + 1;
    L19:
        return r101;
    L17:
        th = move-exception;
        d.a(th);
        goto L19
    }

    public int f() {
        return this.f32535a.getInt("ice_inv_int", 60);
    }

    public long h() {
        return this.f32535a.getLong("l_apd_ti", 0);
    }

    public long i() {
        return this.f32535a.getLong("la_ice_in_t", 0);
    }

    public long j() {
        return this.f32535a.getLong("pl_l_p_p_t", 0);
    }

    public String k() {
        return this.f32537c.getString("re_a_lc", "");
    }

    public int m() {
        return this.f32535a.getInt("pl_p_p_itl", 180);
    }

    public long n() {
        return this.f32535a.getLong("s_al_tri_t", 0);
    }

    public long o() {
        return this.f32538d.getLong("g_u_tk_ti", 0);
    }

    public String p() {
        return this.f32535a.getString("xgz_wl_sha1", "");
    }

    public a(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("msgzpfc", 4);     // Catch: Throwable -> L5
        this.f32535a = r101;     // Catch: Throwable -> L5
        this.f32536b = r101.edit();     // Catch: Throwable -> L5
        this.f32537c = r100.getSharedPreferences("msre_po_rt", 4);     // Catch: Throwable -> L5
        SharedPreferences r102 = r100.getSharedPreferences("msfffppcfg", 4);     // Catch: Throwable -> L5
        this.f32538d = r102;     // Catch: Throwable -> L5
        this.f32539e = r102.edit();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.a(th);
    }

    public void a(boolean r100) {
        this.f32536b.putBoolean("s_ph_pl", r100);
        this.f32536b.putLong("s_p_p_t", System.currentTimeMillis());
        this.f32536b.commit();
    }

    public void b(int r100) {
        this.f32536b.putInt("cloud_sw", r100);
        this.f32536b.commit();
    }

    public void c(int r100) {
        this.f32536b.putInt("ice_inv_int", r100);
        this.f32536b.commit();
    }

    public String d(String r100) {
        return this.f32535a.getString("re_net_ali4_" + r100, "");
    }

    public void e(int r100) {
        this.f32536b.putInt("rst", r100);
        this.f32536b.commit();
    }

    public void f(int r100) {
        this.f32536b.putInt("wm_d_c_s", r100);
        this.f32536b.commit();
    }

    public void g(int r100) {
        this.f32536b.putInt("wm_in_ma_cco", r100);
        this.f32536b.commit();
    }

    public String a(String r100) {
        return this.f32537c.getString("al_da" + r100, "");
    }

    public void b(long r100) {
        this.f32536b.putLong("la_ice_in_t", r100);
        this.f32536b.commit();
    }

    public void c(long r100) {
        this.f32536b.putLong("pl_l_p_p_t", r100);
        this.f32536b.commit();
    }

    public void d(int r100) {
        this.f32536b.putInt("pl_p_p_itl", r100);
        this.f32536b.commit();
    }

    public void e(long r100) {
        this.f32536b.putLong("s_al_tri_t", r100);
        this.f32536b.commit();
    }

    public void f(long r100) {
        this.f32539e.putLong("g_u_tk_ti", r100);
        this.f32539e.apply();
    }

    public void g(String r100) {
        this.f32536b.putString("se-s-v", r100);
        this.f32536b.commit();
    }

    public void a(int r100) {
        this.f32536b.putInt("apd_inte", r100);
        this.f32536b.commit();
    }

    public String b(String r100) {
        return this.f32535a.getString(r100, "");
    }

    public String c(String r100) {
        return this.f32535a.getString(r100, "");
    }

    public void d(long r100) {
        this.f32536b.putLong("po_fe_su_la_tm", r100);
        this.f32536b.commit();
    }

    public void e(String r100) {
        this.f32536b.putString("apd_taid", r100);
        this.f32536b.commit();
    }

    public void f(String r100) {
        this.f32536b.putString("a_de_ti_in_tm", r100);
        this.f32536b.commit();
    }

    public void a(long r100) {
        this.f32536b.putLong("l_apd_ti", r100);
        this.f32536b.commit();
    }

    public void a(String r100, String r101) {
        this.f32536b.putString(r100, r101);
        this.f32536b.commit();
    }

    public void b(String r100, String r101) {
        this.f32536b.putString(r100, r101);
        this.f32536b.commit();
    }

    public void c(String r100, String r101) {
        this.f32536b.putString("re_net_ali4_" + r100, r101);
        this.f32536b.commit();
    }
}
