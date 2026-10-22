package com.baidu.xclient.gdid;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f9519a = "sec_gd_config_mshield";

    /* renamed from: b, reason: collision with root package name */
    public static volatile e f9520b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f9521c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f9522d;

    public e() {
        SharedPreferences sharedPreferences = d.f9502b.getSharedPreferences(f9519a, 0);
        this.f9521c = sharedPreferences;
        this.f9522d = sharedPreferences.edit();
    }

    public static e e() {
        if (f9520b == null) {
            synchronized (e.class) {
                try {
                    if (f9520b == null) {
                        f9520b = new e();
                    }
                } finally {
                }
            }
        }
        return f9520b;
    }

    public int A() {
        return b("k_b_app_l_idx", 0);
    }

    public int a() {
        return b("k_f_p_idx", 0);
    }

    public int b() {
        return b("k_b_f_p_idx", 0);
    }

    public void c(int i4) {
        if (i4 <= 0) {
            return;
        }
        a("k_t_a_p", i4);
    }

    public void d() {
        a("k_is_rp_mgc", !c());
    }

    public long f() {
        return b("k_last_pull_pl_t", 0L);
    }

    public long g() {
        return b("k_pull_p_itl", com.baidu.xclient.gdid.d.a.f9512b * 8);
    }

    public long h() {
        return b("k_last_re_fing_t", 0L);
    }

    public long i() {
        return b("k_re_fing_itl", com.baidu.xclient.gdid.d.a.f9513c);
    }

    public String j() {
        return b("k_cu_p_ver_n", "");
    }

    public String k() {
        String strB = b("k_ply_s_n", "");
        if (!TextUtils.isEmpty(strB)) {
            return new String(Base64.decode(strB, 1));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e", 1);
            jSONObject.put("l", 1);
            jSONObject.put("p", ".zqobbx.pa");
            jSONObject.put(IntegerTokenConverter.CONVERTER_KEY, 1);
            jSONObject.put(ANSIConstants.ESC_END, 0);
            jSONObject.put("w", 1);
            jSONObject.put("s", 1);
            jSONObject.put("c", 0);
            jSONObject.put("y", 20);
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, 20);
            jSONObject.put("x", 0);
            jSONObject.put("u", 0);
            jSONObject.put("g", 20);
            jSONObject.put("n", 0);
            jSONObject.put("t", 0);
            jSONObject.put("q", 0);
            jSONObject.put("9", "");
            jSONObject.put("10", "");
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
        return jSONObject.toString();
    }

    public long l() {
        return b("k_last_alm_t", 0L);
    }

    public long m() {
        return b("k_alm_itl", com.baidu.xclient.gdid.d.a.f9512b);
    }

    public long n() {
        return b("k_last_pi_t", 0L);
    }

    public long o() {
        return b("K_pi_itl", com.baidu.xclient.gdid.d.a.f9512b * 12);
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
        return y() == 3;
    }

    public boolean w() {
        int iY = y();
        return iY == 3 || iY == 1;
    }

    public boolean x() {
        int iY = y();
        return iY == 3 || iY == 2;
    }

    public int y() {
        return b("k_mdl_sw", 3);
    }

    public int z() {
        return b("k_app_l_idx", 0);
    }

    public void a(int i4) {
        a("k_mdl_sw", i4);
    }

    public final int b(String str, int i4) {
        return this.f9521c.getInt(str, i4);
    }

    public void c(long j4) {
        a("k_last_re_fing_t", j4);
    }

    public void d(int i4) {
        if (i4 < 0) {
            return;
        }
        a("k_t_ca_p", i4);
    }

    public void e(int i4) {
        if (i4 < 0) {
            return;
        }
        a("l_td_t_s", i4 != 0);
    }

    public void f(int i4) {
        if (i4 < 0) {
            return;
        }
        a("k_t_m_s_s", i4 != 0);
    }

    public void g(int i4) {
        a("k_app_l_idx", i4);
    }

    public void h(int i4) {
        a("k_b_app_l_idx", i4);
    }

    public void i(int i4) {
        a("k_f_p_idx", i4);
    }

    public void j(int i4) {
        a("k_b_f_p_idx", i4);
    }

    public void k(boolean z4) {
        a("k_is_rp_lp", z4);
    }

    public void l(boolean z4) {
        a("k_is_rp_dnp", z4);
    }

    public void a(long j4) {
        a("k_last_pull_pl_t", j4);
    }

    public final long b(String str, long j4) {
        return this.f9521c.getLong(str, j4);
    }

    public void c(String str) {
        a("k_gu_all", str);
    }

    public void d(long j4) {
        if (j4 <= 0) {
            return;
        }
        a("k_re_fing_itl", j4);
    }

    public void e(long j4) {
        a("k_last_alm_t", j4);
    }

    public void f(long j4) {
        if (j4 <= 0) {
            return;
        }
        a("k_alm_itl", j4);
    }

    public void g(long j4) {
        a("k_last_pi_t", j4);
    }

    public void h(long j4) {
        if (j4 <= 0) {
            return;
        }
        a("K_pi_itl", j4);
    }

    public void i(boolean z4) {
        a("k_is_rep_wf", z4);
    }

    public void j(boolean z4) {
        a("k_ig_u_a", z4);
    }

    public void a(String str) {
        a("k_cu_p_ver_n", str);
    }

    public final String b(String str, String str2) {
        return this.f9521c.getString(str, str2);
    }

    public void c(boolean z4) {
        a("k_is_rep_im_e", z4);
    }

    public void d(String str) {
        a("k_rep_al", str);
    }

    public void e(String str) {
        a("k_rep_f_if", str);
    }

    public void f(String str) {
        a("k_last_ds_d", str);
    }

    public void g(String str) {
        a("k_gd_p", str);
    }

    public void h(boolean z4) {
        a("k_is_rep_o_i", z4);
    }

    public final void a(String str, int i4) {
        this.f9522d.putInt(str, i4);
        this.f9522d.commit();
    }

    public void b(int i4) {
        if (i4 <= 0) {
            return;
        }
        a("k_t_c_p", i4);
    }

    public boolean c() {
        return b("k_is_rp_mgc", false);
    }

    public void d(boolean z4) {
        a("k_is_rp_rg_crc", z4);
    }

    public void e(boolean z4) {
        a("k_is_rep_lc_4_p", z4);
    }

    public void f(boolean z4) {
        a("k_is_rep_ad", z4);
    }

    public void g(boolean z4) {
        a("k_is_rep_im_c", z4);
    }

    public final void a(String str, long j4) {
        this.f9522d.putLong(str, j4);
        this.f9522d.commit();
    }

    public void b(long j4) {
        if (j4 <= 0) {
            return;
        }
        a("k_pull_p_itl", j4);
    }

    public final void a(String str, String str2) {
        this.f9522d.putString(str, str2);
        this.f9522d.commit();
    }

    public void b(String str) {
        a("k_ply_s_n", str);
    }

    public final void a(String str, boolean z4) {
        this.f9522d.putBoolean(str, z4);
        this.f9522d.commit();
    }

    public void b(boolean z4) {
        a("k_is_rep_im_m", z4);
    }

    public void a(boolean z4) {
        a("k_is_rep_m", z4);
    }

    public final boolean b(String str, boolean z4) {
        return this.f9521c.getBoolean(str, z4);
    }
}
