package com.baidu.mshield.x0.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.mshield.x0.d.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f8436a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f8437b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f8438c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f8439d;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences.Editor f8440e;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msgzpfc", 4);
            this.f8436a = sharedPreferences;
            this.f8437b = sharedPreferences.edit();
            this.f8438c = context.getSharedPreferences("msre_po_rt", 4);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("msfffppcfg", 4);
            this.f8439d = sharedPreferences2;
            this.f8440e = sharedPreferences2.edit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void a(String str, String str2) {
        this.f8437b.putString(str, str2);
        this.f8437b.commit();
    }

    public void b(String str, String str2) {
        this.f8437b.putString(str, str2);
        this.f8437b.commit();
    }

    public String c(String str) {
        return this.f8436a.getString(str, "");
    }

    public void d(int i4) {
        this.f8437b.putInt("pl_p_p_itl", i4);
        this.f8437b.commit();
    }

    public void e(int i4) {
        this.f8437b.putInt("rst", i4);
        this.f8437b.commit();
    }

    public void f(long j4) {
        this.f8440e.putLong("g_u_tk_ti", j4);
        this.f8440e.apply();
    }

    public void g(String str) {
        this.f8437b.putString("se-s-v", str);
        this.f8437b.commit();
    }

    public long h() {
        return this.f8436a.getLong("l_apd_ti", 0L);
    }

    public long i() {
        return this.f8436a.getLong("la_ice_in_t", 0L);
    }

    public long j() {
        return this.f8436a.getLong("pl_l_p_p_t", 0L);
    }

    public String k() {
        return this.f8438c.getString("re_a_lc", "");
    }

    public int l() {
        JSONObject jSONObjectOptJSONObject;
        try {
            String strC = c("plc62");
            if (!TextUtils.isEmpty(strC) && (jSONObjectOptJSONObject = new JSONObject(strC).optJSONObject("3")) != null) {
                return jSONObjectOptJSONObject.optInt("2", 1);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 1;
    }

    public int m() {
        return this.f8436a.getInt("pl_p_p_itl", Opcodes.GETFIELD);
    }

    public long n() {
        return this.f8436a.getLong("s_al_tri_t", 0L);
    }

    public long o() {
        return this.f8439d.getLong("g_u_tk_ti", 0L);
    }

    public String p() {
        return this.f8436a.getString("xgz_wl_sha1", "");
    }

    public void c(long j4) {
        this.f8437b.putLong("pl_l_p_p_t", j4);
        this.f8437b.commit();
    }

    public void a(boolean z4) {
        this.f8437b.putBoolean("s_ph_pl", z4);
        this.f8437b.putLong("s_p_p_t", System.currentTimeMillis());
        this.f8437b.commit();
    }

    public String b(String str) {
        return this.f8436a.getString(str, "");
    }

    public String d(String str) {
        return this.f8436a.getString("re_net_ali4_" + str, "");
    }

    public List<b> e() {
        String string = this.f8438c.getString("re_con", "");
        com.baidu.mshield.b.c.a.b("re_con==" + string);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : string.split("\\|\\|")) {
                if (!TextUtils.isEmpty(str)) {
                    b bVarA = b.a(str);
                    if (bVarA == null) {
                        com.baidu.mshield.b.c.a.b("re_con==empty");
                    } else {
                        com.baidu.mshield.b.c.a.b("re_con==" + bVarA.toString());
                        arrayList.add(bVarA);
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return arrayList;
    }

    public void f(int i4) {
        this.f8437b.putInt("wm_d_c_s", i4);
        this.f8437b.commit();
    }

    public void g(int i4) {
        this.f8437b.putInt("wm_in_ma_cco", i4);
        this.f8437b.commit();
    }

    public void b(int i4) {
        this.f8437b.putInt("cloud_sw", i4);
        this.f8437b.commit();
    }

    public void c(String str, String str2) {
        this.f8437b.putString("re_net_ali4_" + str, str2);
        this.f8437b.commit();
    }

    public void d(long j4) {
        this.f8437b.putLong("po_fe_su_la_tm", j4);
        this.f8437b.commit();
    }

    public void f(String str) {
        this.f8437b.putString("a_de_ti_in_tm", str);
        this.f8437b.commit();
    }

    public int g() {
        JSONObject jSONObjectOptJSONObject;
        try {
            String strC = c("plc03");
            if (!TextUtils.isEmpty(strC) && (jSONObjectOptJSONObject = new JSONObject(strC).optJSONObject("5")) != null) {
                return jSONObjectOptJSONObject.optInt("1", 1);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 1;
    }

    public String a() {
        return this.f8438c.getString("li_pk_s", "");
    }

    public int b() {
        return this.f8436a.getInt("apd_inte", 24);
    }

    public String c() {
        return this.f8438c.getString("re_a_cv", "");
    }

    public boolean d() {
        return this.f8436a.getInt("cloud_sw", 0) == 1;
    }

    public String a(String str) {
        return this.f8438c.getString("al_da" + str, "");
    }

    public void b(long j4) {
        this.f8437b.putLong("la_ice_in_t", j4);
        this.f8437b.commit();
    }

    public void c(int i4) {
        this.f8437b.putInt("ice_inv_int", i4);
        this.f8437b.commit();
    }

    public int f() {
        return this.f8436a.getInt("ice_inv_int", 60);
    }

    public void a(int i4) {
        this.f8437b.putInt("apd_inte", i4);
        this.f8437b.commit();
    }

    public void a(long j4) {
        this.f8437b.putLong("l_apd_ti", j4);
        this.f8437b.commit();
    }

    public void e(long j4) {
        this.f8437b.putLong("s_al_tri_t", j4);
        this.f8437b.commit();
    }

    public void e(String str) {
        this.f8437b.putString("apd_taid", str);
        this.f8437b.commit();
    }
}
