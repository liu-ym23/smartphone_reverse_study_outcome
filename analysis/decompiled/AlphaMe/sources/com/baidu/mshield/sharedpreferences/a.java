package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f8322a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f8323b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences.Editor f8324c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f8325d;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences.Editor f8326e;

    /* renamed from: f, reason: collision with root package name */
    public SharedPreferences f8327f;

    /* renamed from: g, reason: collision with root package name */
    public SharedPreferences.Editor f8328g;

    /* renamed from: h, reason: collision with root package name */
    public Context f8329h;

    /* renamed from: i, reason: collision with root package name */
    public int f8330i;

    /* renamed from: j, reason: collision with root package name */
    public String f8331j = null;

    /* renamed from: k, reason: collision with root package name */
    public Map<String, SharedPreferences> f8332k = new HashMap();

    public a(Context context) {
        this.f8329h = context;
        this.f8330i = com.baidu.mshield.utility.a.h(context);
        com.baidu.mshield.b.c.a.b("checking platformName:mshield_SOFIRE");
        i();
        c cVar = new c(this.f8329h, this.f8330i == 1 ? context.getSharedPreferences("leroadmshieldcfg", 0) : null, "leroadmshieldcfg", false, this.f8330i);
        this.f8323b = cVar;
        this.f8324c = cVar.edit();
        c cVar2 = new c(this.f8329h, (this.f8330i == 1 && TextUtils.isEmpty(this.f8331j)) ? context.getSharedPreferences("leroadcfg", 0) : null, "leroadcfg", true, this.f8330i, this.f8331j);
        this.f8325d = cVar2;
        this.f8326e = cVar2.edit();
        c cVar3 = new c(this.f8329h, this.f8330i == 1 ? context.getSharedPreferences("msre_po_rt", 0) : null, "msre_po_rt", false, this.f8330i);
        this.f8327f = cVar3;
        this.f8328g = cVar3.edit();
    }

    public int A() {
        return this.f8323b.getInt("wi_fa_pu_cl", 0);
    }

    public long B() {
        return this.f8327f.getLong("re_net_pu_de", 0L);
    }

    public String C() {
        return this.f8327f.getString("re_net_ali2_version", "");
    }

    public int D() {
        return this.f8327f.getInt("re_net_dy_lt", 50);
    }

    public int E() {
        return this.f8327f.getInt("g_r_d_d_n", 0);
    }

    public int F() {
        return this.f8327f.getInt("re_net_wt", 3);
    }

    public long G() {
        return this.f8327f.getLong("re_last_ofline_time", 0L);
    }

    public int H() {
        return this.f8327f.getInt("re_net_one_lt", 5);
    }

    public int I() {
        return this.f8327f.getInt("re_net_over", 7);
    }

    public int J() {
        if ("com.baidu.BaiduMap.meizu".equals(this.f8329h.getPackageName())) {
            return this.f8327f.getInt("re_net_hr", 24);
        }
        int i4 = this.f8327f.getInt("re_net_hr", 3);
        try {
            String[] strArrI = com.baidu.mshield.utility.a.i(this.f8329h);
            if (strArrI.length == 2 && !TextUtils.isEmpty(strArrI[0]) && !TextUtils.isEmpty(strArrI[1]) && "200080".equals(strArrI[0])) {
                if ("com.baidu.BaiduMap".equals(this.f8329h.getPackageName()) && i4 < 24) {
                    return 24;
                }
            }
        } catch (Throwable unused) {
        }
        return i4;
    }

    public String K() {
        return this.f8323b.getString("svi_n_wm", "");
    }

    public String a() {
        return this.f8323b.getString("svi_wm", "");
    }

    public long b() {
        long j4 = this.f8323b.getLong("se_ae_fd", 0L);
        if (j4 != 0) {
            return j4;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        k();
        return jCurrentTimeMillis;
    }

    public long c() {
        return this.f8327f.getLong("re_day_b_t", 0L);
    }

    public long d() {
        return this.f8327f.getLong("re_day_len", 0L);
    }

    public String e() {
        return this.f8325d.getString("xytk", "");
    }

    public String f() {
        return this.f8325d.getString("sgud", "");
    }

    public int g() {
        return this.f8327f.getInt("up_nu_co", 50);
    }

    public int h() {
        return this.f8327f.getInt("up_nu_li", 100);
    }

    public void i() {
        Bundle bundle = new Bundle();
        bundle.putString("operation", "querySharedHandler");
        Bundle bundleA = g.a(this.f8329h, "CallPreferences", bundle, false, "3.5.8.0", true);
        if (bundleA != null) {
            this.f8331j = bundleA.getString("handle_platform");
            com.baidu.mshield.b.c.a.b("get can handle shared platform:" + this.f8331j);
        }
    }

    public void j() {
        this.f8324c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.f8324c.commit();
    }

    public void k() {
        this.f8324c.putLong("se_ae_fd", System.currentTimeMillis());
        this.f8324c.commit();
    }

    public void l(String str) {
        this.f8326e.putString("rpmacadd", str);
        this.f8326e.commit();
    }

    public void m(String str) {
        this.f8326e.putString("xytk_m", str);
        this.f8326e.apply();
    }

    public void n(int i4) {
        this.f8328g.putInt("up_nu_co", i4);
        this.f8328g.commit();
    }

    public void o(String str) {
        this.f8326e.putString("sgud", str);
        this.f8326e.commit();
    }

    public List<com.baidu.mshield.rp.b.a> p() {
        com.baidu.mshield.rp.b.a aVarA;
        String string = this.f8327f.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (aVarA = com.baidu.mshield.rp.b.a.a(str)) != null) {
                arrayList.add(aVarA);
            }
        }
        return arrayList;
    }

    public String q() {
        return this.f8325d.getString("xyusec", "");
    }

    public String r() {
        return this.f8325d.getString("xygls", "");
    }

    public String s() {
        return this.f8325d.getString("rpiiem", "");
    }

    public String t() {
        return this.f8327f.getString("re_a_lc", "");
    }

    public String u() {
        return this.f8325d.getString("rpmacadd", "");
    }

    public String v() {
        return this.f8325d.getString("xytk_m", "");
    }

    public SharedPreferences w() {
        return this.f8323b;
    }

    public SharedPreferences x() {
        return this.f8325d;
    }

    public long y() {
        long j4 = this.f8323b.getLong("pu_cl_fd", 0L);
        if (j4 != 0) {
            return j4;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        j();
        return jCurrentTimeMillis;
    }

    public int z() {
        return this.f8323b.getInt("mo_fa_pu_cl", 0);
    }

    public static synchronized a a(Context context) {
        if (context == null) {
            return f8322a;
        }
        if (f8322a == null) {
            f8322a = new a(context);
        }
        return f8322a;
    }

    public SharedPreferences c(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.f8332k) {
                try {
                    sharedPreferences = this.f8332k.get(str);
                    if (sharedPreferences == null) {
                        c cVar = new c(this.f8329h, this.f8330i == 1 ? this.f8329h.getSharedPreferences(str, 0) : null, str, false, this.f8330i);
                        this.f8332k.put(str, cVar);
                        sharedPreferences = cVar;
                    }
                } finally {
                }
            }
            return sharedPreferences;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    public void d(String str, String str2) {
        this.f8324c.putString("svi_n_wm", str + "-" + str2);
        this.f8324c.commit();
    }

    public void e(int i4) {
        this.f8324c.putInt("wi_fa_pu_cl", i4);
        this.f8324c.commit();
    }

    public void f(int i4) {
        this.f8328g.putInt("re_net_dy_lt", i4);
        this.f8328g.commit();
    }

    public void g(String str) {
        this.f8326e.putString("rpandid", str);
        this.f8326e.commit();
    }

    public void h(String str) {
        this.f8326e.putString("xyus", str);
        this.f8326e.commit();
    }

    public void j(String str) {
        this.f8326e.putString("xygls", str);
        this.f8326e.commit();
    }

    public void k(String str) {
        this.f8326e.putString("rpiiem", str);
        this.f8326e.commit();
    }

    public void l(int i4) {
        this.f8328g.putInt("re_net_hr_bc", i4);
        this.f8328g.commit();
    }

    public String m() {
        return this.f8325d.getString("rpandid", "");
    }

    public void n(String str) {
        this.f8328g.putString("re_net_ali2_version", str);
        this.f8328g.commit();
    }

    public void o(int i4) {
        this.f8328g.putInt("up_nu_li", i4);
        this.f8328g.commit();
    }

    public void b(int i4) {
        this.f8324c.putInt("mo_fa_pu_ap", i4);
        this.f8324c.commit();
    }

    public void d(int i4) {
        this.f8324c.putInt("mo_fa_pu_cl", i4);
        this.f8324c.commit();
    }

    public boolean e(String str) {
        return this.f8327f.getBoolean("re_net_ins_" + str, false);
    }

    public void f(String str) {
        this.f8328g.putString("li_pk_s", str);
        this.f8328g.commit();
    }

    public void g(int i4) {
        this.f8328g.putInt("g_r_d_d_n", i4);
        this.f8328g.commit();
    }

    public void h(int i4) {
        this.f8328g.putInt("re_net_wt", i4);
        this.f8328g.commit();
    }

    public void m(int i4) {
        this.f8328g.putInt("re_net_hr", i4);
        this.f8328g.commit();
    }

    public void j(int i4) {
        this.f8328g.putInt("re_net_one_lt", i4);
        this.f8328g.commit();
    }

    public void k(int i4) {
        this.f8328g.putInt("re_net_over", i4);
        this.f8328g.commit();
    }

    public int l() {
        return this.f8323b.getInt("mo_ae_fa_ct", 0);
    }

    public String n() {
        return this.f8325d.getString("xyus", "");
    }

    public String o() {
        return this.f8327f.getString("re_a_cv", "");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle a(android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.sharedpreferences.a.a(android.os.Bundle):android.os.Bundle");
    }

    public void b(long j4) {
        this.f8328g.putLong("re_last_ofline_time", j4);
        this.f8328g.commit();
    }

    public String d(String str) {
        return this.f8327f.getString("re_net_ali2_" + str, "");
    }

    public void i(int i4) {
        this.f8328g.putInt("re_net_ty", i4);
        this.f8328g.commit();
    }

    public void d(long j4) {
        this.f8328g.putLong("re_day_len", j4);
        this.f8328g.commit();
    }

    public String b(String str) {
        return this.f8327f.getString("al_da" + str, "");
    }

    public void i(String str) {
        this.f8326e.putString("xyusec", str);
        this.f8326e.commit();
    }

    public void b(String str, String str2) {
        this.f8328g.putString("in_da" + str, str2);
        this.f8328g.commit();
    }

    public void c(int i4) {
        this.f8324c.putInt("wi_fa_pu_ap", i4);
        this.f8324c.commit();
    }

    public void c(String str, String str2) {
        this.f8328g.putString("re_net_ali2_" + str, str2);
        this.f8328g.commit();
    }

    public void c(long j4) {
        this.f8328g.putLong("re_day_b_t", j4);
        this.f8328g.commit();
    }

    public final SharedPreferences a(String str) {
        if (str.equals("leroadmshieldcfg")) {
            return this.f8323b;
        }
        if (str.equals("leroadcfg")) {
            return this.f8325d;
        }
        if (str.equals("msre_po_rt")) {
            return this.f8327f;
        }
        return c(str);
    }

    public void a(int i4) {
        this.f8324c.putInt("mo_ae_fa_ct", i4);
        this.f8324c.commit();
    }

    public void a(com.baidu.mshield.rp.b.a aVar) {
        if (aVar == null) {
            return;
        }
        String string = this.f8327f.getString("re_con", "");
        SharedPreferences.Editor editor = this.f8328g;
        StringBuilder sbV = B0.g.v(string, "||");
        sbV.append(com.baidu.mshield.rp.b.a.a(aVar));
        editor.putString("re_con", sbV.toString());
        this.f8328g.commit();
    }

    public void a(List<com.baidu.mshield.rp.b.a> list, com.baidu.mshield.rp.b.a aVar) {
        int iIndexOf;
        com.baidu.mshield.rp.b.a aVar2;
        if (aVar == null || list == null || (iIndexOf = list.indexOf(aVar)) == -1 || (aVar2 = list.get(iIndexOf)) == null) {
            return;
        }
        this.f8328g.putString("re_con", this.f8327f.getString("re_con", "").replace(com.baidu.mshield.rp.b.a.a(aVar2), com.baidu.mshield.rp.b.a.a(aVar)));
        this.f8328g.commit();
    }

    public void a(String str, boolean z4) {
        this.f8328g.putBoolean("re_net_ins_" + str, z4);
        this.f8328g.commit();
    }

    public void a(long j4) {
        this.f8328g.putLong("re_net_pu_de", j4);
        this.f8328g.commit();
    }

    public void a(String str, String str2) {
        this.f8328g.putString("al_da" + str, str2);
        this.f8328g.commit();
    }
}
