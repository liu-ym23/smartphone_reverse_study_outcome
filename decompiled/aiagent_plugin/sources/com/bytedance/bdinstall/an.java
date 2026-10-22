package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: InstallOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class an {
    private final com.bytedance.bdinstall.c.b A;
    private final com.bytedance.bdinstall.c.c B;
    private final com.bytedance.bdinstall.c.a C;
    private final af D;
    private final boolean E;
    private final boolean F;
    private final boolean G;
    private Account H;
    private final ab I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final boolean f6117J;
    private final boolean K;
    private final boolean L;
    private final boolean M;
    private final ae N;
    private final boolean O;
    private final av P;
    private final boolean Q;
    private final boolean R;
    private final boolean S;
    private final boolean T;
    private final boolean U;
    private final boolean V;
    private final com.bytedance.bdinstall.j.c W;
    private final com.bytedance.bdinstall.f.b X;
    private final com.bytedance.bdinstall.f.b Y;
    private SharedPreferences Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TelephonyManager f6118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ai f6121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6122e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final z l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final JSONObject q;
    private final Map<String, Object> r;
    private final boolean s;
    private final h t;
    private final boolean u;
    private final ah v;
    private final ad w;
    private final boolean x;
    private final al y;
    private final boolean z;

    an(m r3) {
        this.Z = null;
        this.f6122e = ZeusTransformUtils.wrapperContext(r3.n, "com.obric.aiagent.plugin");
        this.f6120c = r3.l;
        if (r3.m == null) goto L5;
        ai r0 = r3.m;
    L6:
        this.f6121d = r0;
        if (TextUtils.isEmpty(r3.o) == false) goto L9;
        String r1 = "applog_stats";
    L10:
        this.f = r1;
        this.g = r3.p;
        this.h = r3.v;
        this.i = r3.w;
        this.j = r3.x;
        this.k = r3.y;
        this.l = r3.z;
        this.m = r3.A;
        this.n = r3.B;
        this.o = r3.C;
        this.p = r3.D;
        this.q = r3.E;
        this.r = r3.F;
        this.I = r3.j;
        this.f6117J = r3.k;
        this.K = r3.i;
        this.s = r3.h;
        this.L = r3.g;
        this.M = r3.f;
        this.N = r3.f6378e;
        this.O = r3.f6377d;
        this.P = r3.f6376c;
        this.t = new h(r3);
        this.H = r3.G;
        this.u = r3.H;
        this.v = r3.I;
        if (r3.f6373J == null) goto L13;
        ad r2 = r3.f6373J;
    L14:
        this.w = r2;
        this.x = r3.K;
        this.y = r3.L;
        this.z = r3.M;
        this.A = r3.N;
        this.Q = r3.f6375b;
        this.R = r3.f6374a;
        this.B = r3.O;
        this.C = r3.P;
        this.D = r3.Q;
        this.E = r3.R;
        this.F = r3.S;
        this.G = r3.T;
        this.S = r3.U;
        this.T = r3.W;
        this.U = r3.X;
        this.V = r3.Y;
        this.W = r3.Z;
        com.bytedance.bdinstall.f.b r4 = r3.aa;
        this.X = r4;
        this.f6118a = r3.ab;
        if (r4 == null) goto L17;
        this.Y = r4;
        r4.a(this);
        return;
    L17:
        com.bytedance.bdinstall.f.b r5 = new com.bytedance.bdinstall.f.b();
        this.Y = r5;
        r5.a(this);
        return;
    L13:
        r2 = new ad.a();
        goto L14
    L9:
        r1 = r3.o;
        goto L10
    L5:
        r0 = new p();
        goto L6
    }

    public int a() {
        return this.f6120c;
    }

    public String b() {
        return String.valueOf(this.f6120c);
    }

    public ai c() {
        return this.f6121d;
    }

    public Context getContext() {
        return this.f6122e;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.t.a();
    }

    public String f() {
        return this.t.b();
    }

    public long g() {
        return this.t.c();
    }

    public long h() {
        return this.t.d();
    }

    public long i() {
        return this.t.e();
    }

    public String j() {
        return this.h;
    }

    public String k() {
        return this.i;
    }

    public String l() {
        return this.j;
    }

    public String m() {
        return this.k;
    }

    public z n() {
        return this.l;
    }

    public boolean o() {
        return this.f6119b;
    }

    void a(boolean r1) {
        this.f6119b = r1;
    }

    public String p() {
        if (TextUtils.isEmpty(this.m) == true) goto L7;
        return this.m;
    L7:
        return com.bytedance.bdinstall.j.j.a(this.f6122e, this).getString("user_agent", null);
    }

    public String q() {
        if (TextUtils.isEmpty(this.o) == true) goto L7;
        return this.o;
    L7:
        return com.bytedance.bdinstall.j.j.a(this.f6122e, this).getString("app_language", null);
    }

    public String r() {
        if (TextUtils.isEmpty(this.p) == true) goto L7;
        return this.p;
    L7:
        return com.bytedance.bdinstall.j.j.a(this.f6122e, this).getString("app_region", null);
    }

    public JSONObject s() {
        JSONObject r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = com.bytedance.bdinstall.j.j.a(this.f6122e, this).getString("app_track", null);
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(r2);
    }

    public Map<String, Object> t() {
        return this.r;
    }

    public String u() {
        z r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.j();
    }

    public SharedPreferences v() {
        if (this.Z != null) goto L10;
        if (this.f6119b == false) goto L7;
        String r0 = this.f;
    L8:
        this.Z = this.f6122e.getSharedPreferences(r0, 0);
        goto L10
    L7:
        r0 = this.f + "_" + this.f6120c;
    L10:
        return this.Z;
    }

    public String w() {
        return v().getString("app_language", null);
    }

    public String x() {
        return v().getString("app_region", null);
    }

    public boolean y() {
        return this.L;
    }

    public boolean z() {
        return this.M;
    }

    public Map<String, Object> A() {
        ab r0 = this.I;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    public boolean B() {
        if (I() == true) goto L5;
        return true;
    L5:
        return this.f6117J;
    }

    public boolean C() {
        return this.K;
    }

    public boolean D() {
        return this.s;
    }

    public ae E() {
        return this.N;
    }

    public boolean F() {
        return this.O;
    }

    public av G() {
        return this.P;
    }

    public Account H() {
        return this.H;
    }

    public boolean I() {
        return this.u;
    }

    public boolean J() {
        return this.T;
    }

    ad K() {
        return this.w;
    }

    public void a(SharedPreferences.Editor r3) {
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        String r0 = q();
        String r2 = r();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r4.putString("app_language", r0);
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r4.putString("app_region", r2);
        return;
    }

    public al L() {
        return this.y;
    }

    public boolean M() {
        return this.z;
    }

    public com.bytedance.bdinstall.c.b N() {
        return this.A;
    }

    public boolean O() {
        return this.Q;
    }

    public boolean P() {
        return this.R;
    }

    public com.bytedance.bdinstall.c.a Q() {
        return this.C;
    }

    public com.bytedance.bdinstall.c.c R() {
        return this.B;
    }

    public af S() {
        return this.D;
    }

    public boolean T() {
        return this.E;
    }

    public boolean U() {
        return this.F;
    }

    public boolean V() {
        return this.G;
    }

    public boolean W() {
        return this.S;
    }

    public boolean X() {
        return this.U;
    }

    public boolean Y() {
        return this.V;
    }

    public String Z() {
        com.bytedance.bdinstall.j.c r0 = this.W;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    public com.bytedance.bdinstall.f.b aa() {
        return this.Y;
    }

    public TelephonyManager ab() {
        return this.f6118a;
    }
}
