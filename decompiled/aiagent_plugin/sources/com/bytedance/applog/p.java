package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import com.bytedance.bdinstall.ah;
import com.bytedance.bdinstall.ai;
import com.bytedance.bdinstall.al;
import com.bytedance.bdinstall.av;
import com.bytedance.bdinstall.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: InitConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private String E;
    private String F;
    private av G;
    private al H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f5829J;
    private boolean K;
    private a L;
    private z M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private volatile com.bytedance.bdinstall.c.b R;
    private d S;
    private com.bytedance.bdinstall.j.c T;
    private boolean U;
    private boolean V;
    private boolean W;
    private com.bytedance.bdinstall.f.b X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.mpaas.a f5833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5834e;
    private ah f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private String l;
    private String m;
    private q n;
    private String o;
    private String p;
    private long q;
    private long r;
    private long s;
    private String t;
    private String u;
    private Map<String, Object> v;
    private Account w;
    private ai x;
    private boolean y;
    private boolean z;

    /* JADX INFO: compiled from: InitConfig.java */
    public interface a {
        boolean a(String[] r1);
    }

    public p(String r4, String r5) {
        this.f5831b = true;
        this.i = false;
        this.k = 0;
        this.z = true;
        this.B = false;
        this.C = false;
        this.D = true;
        this.I = true;
        this.f5829J = true;
        this.L = null;
        this.M = null;
        this.O = true;
        this.P = false;
        this.Q = false;
        this.U = false;
        this.V = true;
        this.W = true;
        if (TextUtils.isEmpty(r4) == true) goto L11;
        if (TextUtils.isEmpty(r5) == true) goto L9;
        this.f5830a = r4;
        this.f5832c = r5;
        return;
    L9:
        throw new IllegalStateException("Channel must not be empty!");
    L11:
        throw new IllegalStateException("App id must not be empty!");
    }

    public p a(ah r3) {
        this.f = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.aiagent.plugin");
        return this;
    }

    public ah a() {
        return this.f;
    }

    public boolean b() {
        return this.f5831b;
    }

    public p a(boolean r1) {
        this.f5831b = r1;
        return this;
    }

    public String c() {
        return this.l;
    }

    public Map<String, Object> d() {
        return this.v;
    }

    public boolean e() {
        return this.j;
    }

    public String f() {
        return this.f5830a;
    }

    public String g() {
        return this.f5832c;
    }

    public p a(String r1) {
        this.f5834e = r1;
        return this;
    }

    public String h() {
        return this.f5834e;
    }

    public String i() {
        return this.g;
    }

    public p b(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 1;
    L5:
        this.k = r2;
        return this;
    L4:
        r2 = 2;
        goto L5
    }

    public int j() {
        return this.k;
    }

    public boolean k() {
        return this.B;
    }

    public p a(q r1) {
        this.n = r1;
        return this;
    }

    public q l() {
        return this.n;
    }

    public com.bytedance.mpaas.a m() {
        return this.f5833d;
    }

    public boolean n() {
        return this.h;
    }

    public boolean o() {
        return this.i;
    }

    public Account p() {
        return this.w;
    }

    public p a(ai r3) {
        this.x = (ai) ZeusTransformUtils.wrapperContextForParams(r3, ai.class, "com.obric.aiagent.plugin");
        return this;
    }

    public ai q() {
        return this.x;
    }

    public p b(String r1) {
        this.m = r1;
        return this;
    }

    public String r() {
        return this.m;
    }

    public p c(String r1) {
        this.o = r1;
        return this;
    }

    public String s() {
        return this.o;
    }

    public String t() {
        return this.p;
    }

    public boolean u() {
        return this.N;
    }

    public p a(long r1) {
        this.q = r1;
        return this;
    }

    public long v() {
        return this.q;
    }

    public p b(long r1) {
        this.r = r1;
        return this;
    }

    public long w() {
        return this.r;
    }

    public long x() {
        return this.s;
    }

    public String y() {
        return this.t;
    }

    public String z() {
        return this.u;
    }

    public boolean A() {
        return this.A;
    }

    public boolean B() {
        return this.z;
    }

    public boolean C() {
        return this.C;
    }

    public void c(boolean r1) {
        this.C = r1;
    }

    public boolean D() {
        return this.D;
    }

    public String E() {
        if (TextUtils.isEmpty(this.E) == false) goto L7;
        return com.bytedance.applog.util.p.a(this.f5830a) + "@bd_tea_agent.db";
    L7:
        return this.E;
    }

    public String F() {
        return this.F;
    }

    public p d(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.F = r2;
    L5:
        return this;
    }

    public z G() {
        return this.M;
    }

    public av H() {
        return this.G;
    }

    public al I() {
        return this.H;
    }

    public boolean J() {
        return this.K;
    }

    public void d(boolean r1) {
        this.K = r1;
    }

    public a K() {
        return this.L;
    }

    public com.bytedance.bdinstall.c.b L() {
        return this.R;
    }

    public d M() {
        return this.S;
    }

    public boolean N() {
        return this.y;
    }

    public p e(boolean r1) {
        this.O = r1;
        return this;
    }

    public boolean O() {
        return this.O;
    }

    public boolean P() {
        return this.P;
    }

    public boolean Q() {
        return this.Q;
    }

    public com.bytedance.bdinstall.j.c R() {
        return this.T;
    }

    public boolean S() {
        return this.U;
    }

    public boolean T() {
        return this.V;
    }

    public boolean U() {
        return this.W;
    }

    public void a(com.bytedance.bdinstall.f.b r1) {
        this.X = r1;
    }

    public com.bytedance.bdinstall.f.b V() {
        return this.X;
    }
}
