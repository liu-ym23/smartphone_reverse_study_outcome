package com.alipay.sdk.m.m;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.j;
import com.alipay.sdk.m.u.n;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static final String A0 = "cfg_max_time";
    public static final String B0 = "get_oa_id";
    public static final String C0 = "notifyFailApp";
    public static final String D0 = "startactivity_in_ui_thread";
    public static final String E = "DynCon";
    public static final String E0 = "scheme_pay_2";
    public static final int F = 10000;
    public static final String F0 = "intercept_batch";
    public static final String G = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final String G0 = "bind_with_startActivity";
    public static final int H = 10;
    public static final String H0 = "startActivity_InsteadOf_Scheme";
    public static final boolean I = false;
    public static final String I0 = "enableStartActivityFallback";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final boolean f25532J = true;
    public static final String J0 = "enableBindExFallback";
    public static final boolean K = false;
    public static a K0 = null;
    public static final boolean L = true;
    public static final boolean M = true;
    public static final String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final boolean Q = false;
    public static final boolean R = false;
    public static final boolean S = true;
    public static final String T = "";
    public static final boolean U = false;
    public static final boolean V = false;
    public static final boolean W = false;
    public static final int X = 1000;
    public static final boolean Y = true;
    public static final String Z = "";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final boolean f25533a0 = false;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final boolean f25534b0 = false;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final boolean f25535c0 = false;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f25536d0 = 1000;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f25537e0 = 20000;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final boolean f25538f0 = false;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f25539g0 = "alipay_cashier_dynamic_config";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f25540h0 = "timeout";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f25541i0 = "h5_port_degrade";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f25542j0 = "st_sdk_config";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f25543k0 = "tbreturl";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f25544l0 = "launchAppSwitch";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f25545m0 = "configQueryInterval";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f25546n0 = "deg_log_mcgw";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f25547o0 = "deg_start_srv_first";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f25548p0 = "prev_jump_dual";

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f25549q0 = "use_sc_only";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f25550r0 = "retry_aidl_activity_not_start";

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f25551s0 = "bind_use_imp";

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f25552t0 = "retry_bnd_once";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f25553u0 = "skip_trans";

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f25554v0 = "start_trans";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f25555w0 = "up_before_pay";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f25556x0 = "lck_k";

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f25557y0 = "use_sc_lck_a";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f25558z0 = "utdid_factor";
    public JSONObject A;
    public boolean B;
    public List<b> C;
    public int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f25568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f25570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f25571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f25572n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f25573o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f25574p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f25575q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f25576r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f25577s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f25578t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f25579u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f25580v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f25581w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f25582x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f25583y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f25584z;

    /* JADX INFO: renamed from: com.alipay.sdk.m.m.a$a, reason: collision with other inner class name */
    public class RunnableC0488a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.s.a f25585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f25586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f25587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f25588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f25589e;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_m_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_m_a$a__run$___twin___() {
            com.alipay.sdk.m.p.b r100 = new com.alipay.sdk.m.q.b().a(this.f25585a, this.f25586b);     // Catch: Throwable -> L9
            if (r100 == null) goto L14;
            a.a(this.f25589e, this.f25585a, r100.a());     // Catch: Throwable -> L9
            a.a(this.f25589e, com.alipay.sdk.m.s.a.h());     // Catch: Throwable -> L9
            com.alipay.sdk.m.k.a.a(this.f25585a, "biz", "offcfg|" + this.f25587c + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f25588d);     // Catch: Throwable -> L9
            return;
        L14:
            return;
        L9:
            th = move-exception;
            e.a(th);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_m_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0488a r100) {
            r100.com_alipay_sdk_m_m_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0488a(a r100, com.alipay.sdk.m.s.a r101, Context r102, boolean r103, int r104) {
            this.f25589e = r100;
            this.f25585a = r101;
            this.f25586b = r102;
            this.f25587c = r103;
            this.f25588d = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f25591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25592c;

        public String toString() {
            return String.valueOf(a(this));
        }

        public static JSONObject a(b r100) {
            if (r100 != null) goto L16;
            return null;
        L16:
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L13
            JSONObject r102 = r101.put("pn", r100.f25590a);     // Catch: JSONException -> L13
            JSONObject r103 = r102.put(BaseSwitches.V, r100.f25591b);     // Catch: JSONException -> L13
            return r103.put(PbRequest.SwitchType.PK, r100.f25592c);
        L13:
            e = move-exception;
            e.a(e);
            return null;
        }

        public static JSONArray a(List<b> r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            JSONArray r101 = new JSONArray();
            Iterator<b> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            r101.put(a(r102.next()));
            goto L7
        L9:
            return r101;
        }

        public static List<b> a(JSONArray r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r101 = new ArrayList();
            int r102 = r100.length();
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L11;
            b r104 = a(r100.optJSONObject(r103));
            if (r104 == null) goto L10;
            r101.add(r104);
        L10:
            r103 = r103 + 1;
            goto L6
        L11:
            return r101;
        }

        public static b a(JSONObject r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return new b(r100.optString("pn"), r100.optInt(BaseSwitches.V, 0), r100.optString(PbRequest.SwitchType.PK));
        }

        public b(String r100, int r101, String r102) {
            this.f25590a = r100;
            this.f25591b = r101;
            this.f25592c = r102;
        }
    }

    public static a D() {
        if (K0 != null) goto L6;
        a r100 = new a();
        K0 = r100;
        r100.t();
    L6:
        return K0;
    }

    private JSONObject E() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("timeout", k());
        r100.put(f25541i0, y());
        r100.put(f25543k0, r());
        r100.put(f25545m0, d());
        r100.put(f25544l0, b.a(l()));
        r100.put(E0, i());
        r100.put(F0, h());
        r100.put(f25546n0, e());
        r100.put(f25547o0, f());
        r100.put(f25548p0, m());
        r100.put(f25549q0, g());
        r100.put(f25551s0, b());
        r100.put(f25552t0, n());
        r100.put(f25553u0, p());
        r100.put(f25554v0, B());
        r100.put(f25555w0, s());
        r100.put(f25557y0, o());
        r100.put(f25556x0, j());
        r100.put(G0, c());
        r100.put(H0, q());
        r100.put(f25550r0, A());
        r100.put(A0, C());
        r100.put(B0, x());
        r100.put(C0, v());
        r100.put(I0, w());
        r100.put(J0, u());
        r100.put(D0, z());
        r100.put(com.alipay.sdk.m.u.a.f25802b, a());
        return r100;
    }

    public int k() {
        int r100 = this.f25559a;
        if (r100 >= 1000) goto L5;
    L9:
        e.b(E, "time(def) = 10000");
        return 10000;
    L5:
        if (r100 > 20000) goto L9;
        e.b(E, "time = " + this.f25559a);
        return this.f25559a;
    }

    public a() {
        this.f25559a = 10000;
        this.f25560b = false;
        this.f25561c = G;
        this.f25562d = 10;
        this.f25563e = false;
        this.f25564f = true;
        this.f25565g = false;
        this.f25566h = false;
        this.f25567i = false;
        this.f25568j = true;
        this.f25569k = true;
        this.f25570l = "";
        this.f25571m = false;
        this.f25572n = false;
        this.f25573o = false;
        this.f25574p = false;
        this.f25575q = true;
        this.f25576r = "";
        this.f25577s = "";
        this.f25578t = false;
        this.f25579u = false;
        this.f25580v = false;
        this.f25581w = false;
        this.f25582x = false;
        this.f25583y = 1000;
        this.f25584z = false;
        this.B = true;
        this.C = null;
        this.D = -1;
    }

    public void t() {
        Context r100 = com.alipay.sdk.m.s.b.d().b();
        String r101 = j.a(com.alipay.sdk.m.s.a.h(), r100, f25539g0, null);
        this.D = CastIntegerProtector.parseInt(j.a(com.alipay.sdk.m.s.a.h(), r100, f25558z0, "-1"));     // Catch: Exception -> L6
    L4:
        a(r101);
    }

    private int C() {
        return this.f25583y;
    }

    public boolean A() {
        return this.f25582x;
    }

    public boolean B() {
        return this.f25574p;
    }

    public JSONObject a() {
        return this.A;
    }

    public boolean b() {
        return this.f25571m;
    }

    public String c() {
        return this.f25577s;
    }

    public int d() {
        return this.f25562d;
    }

    public boolean e() {
        return this.f25567i;
    }

    public boolean f() {
        return this.f25568j;
    }

    public String g() {
        return this.f25570l;
    }

    public boolean h() {
        return this.f25564f;
    }

    public boolean i() {
        return this.f25563e;
    }

    public String j() {
        return this.f25576r;
    }

    public List<b> l() {
        return this.C;
    }

    public boolean m() {
        return this.f25569k;
    }

    public boolean n() {
        return this.f25572n;
    }

    public boolean o() {
        return this.f25581w;
    }

    public boolean p() {
        return this.f25573o;
    }

    public boolean q() {
        return this.f25578t;
    }

    public String r() {
        return this.f25561c;
    }

    public boolean s() {
        return this.f25575q;
    }

    public boolean u() {
        return this.f25580v;
    }

    public boolean v() {
        return this.f25584z;
    }

    public boolean w() {
        return this.f25579u;
    }

    public boolean x() {
        return this.B;
    }

    public boolean y() {
        return this.f25560b;
    }

    public boolean z() {
        return this.f25565g;
    }

    private void a(JSONObject r100) {
        this.f25559a = r100.optInt("timeout", 10000);
        this.f25560b = r100.optBoolean(f25541i0, false);
        this.f25561c = r100.optString(f25543k0, G).trim();
        this.f25562d = r100.optInt(f25545m0, 10);
        this.C = b.a(r100.optJSONArray(f25544l0));
        this.f25563e = r100.optBoolean(E0, false);
        this.f25564f = r100.optBoolean(F0, true);
        this.f25567i = r100.optBoolean(f25546n0, false);
        this.f25568j = r100.optBoolean(f25547o0, true);
        this.f25569k = r100.optBoolean(f25548p0, true);
        this.f25570l = r100.optString(f25549q0, "");
        this.f25571m = r100.optBoolean(f25551s0, false);
        this.f25572n = r100.optBoolean(f25552t0, false);
        this.f25573o = r100.optBoolean(f25553u0, false);
        this.f25574p = r100.optBoolean(f25554v0, false);
        this.f25575q = r100.optBoolean(f25555w0, true);
        this.f25576r = r100.optString(f25556x0, "");
        this.f25581w = r100.optBoolean(f25557y0, false);
        this.f25582x = r100.optBoolean(f25550r0, false);
        this.f25584z = r100.optBoolean(C0, false);
        this.f25577s = r100.optString(G0, "");
        this.f25578t = r100.optBoolean(H0, false);
        this.f25583y = r100.optInt(A0, 1000);
        this.B = r100.optBoolean(B0, true);
        this.f25579u = r100.optBoolean(I0, false);
        this.f25580v = r100.optBoolean(J0, false);
        this.f25565g = r100.optBoolean(D0, false);
        this.A = r100.optJSONObject(com.alipay.sdk.m.u.a.f25802b);
    }

    private void a(com.alipay.sdk.m.s.a r100) {
        JSONObject r101 = E();     // Catch: Exception -> L6
        Context r102 = com.alipay.sdk.m.s.b.d().b();     // Catch: Exception -> L6
        j.b(r100, r102, f25539g0, r101.toString());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.a(e);
    }

    private void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        a(new JSONObject(r100));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        e.a(th);
    }

    public void a(boolean r100) {
        this.f25566h = r100;
    }

    private void a(com.alipay.sdk.m.s.a r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return;
    L14:
        JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L10
        JSONObject r103 = r102.optJSONObject(f25542j0);     // Catch: Throwable -> L10
        com.alipay.sdk.m.u.a.a(r100, r103, com.alipay.sdk.m.u.a.a(r100, r102));     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        a(r103);     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        e.e(E, "empty config");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        e.a(th);
    }

    public boolean a(Context r100, int r101) {
        if (this.D != (-1)) goto L6;
        this.D = n.a();
        j.b(com.alipay.sdk.m.s.a.h(), r100, f25558z0, String.valueOf(this.D));
    L6:
        if (this.D >= r101) goto L8;
        return true;
    L8:
        return false;
    }

    public static /* synthetic */ void a(a r100, com.alipay.sdk.m.s.a r101) {
        r100.a(r101);
    }

    public static /* synthetic */ void a(a r100, com.alipay.sdk.m.s.a r101, String r102) {
        r100.a(r101, r102);
    }

    public void a(com.alipay.sdk.m.s.a r100, Context r110, boolean r111, int r112) {
        com.alipay.sdk.m.k.a.a(r100, "biz", "oncfg|" + r111 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r112);
        RunnableC0488a r101 = new RunnableC0488a(this, r100, r110, r111, r112);
        if (r111 == true) goto L5;
    L9:
        PthreadThreadV2 r102 = new PthreadThreadV2(r101, "pay/sdk/m/m/a");
        ThreadMethodProxy.setName(r102, "AlipayDCP");
        ThreadMethodProxy.start(r102);
        return;
    L5:
        if (n.h() == true) goto L9;
        int r113 = C();
        if (n.a(r113, r101, "AlipayDCPBlok") == true) goto L11;
        com.alipay.sdk.m.k.a.b(r100, "biz", com.alipay.sdk.m.k.b.f25411m0, "" + r113);
        return;
    }
}
