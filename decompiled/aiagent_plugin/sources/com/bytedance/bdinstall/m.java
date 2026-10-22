package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: Builder.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    String A;
    String B;
    String C;
    String D;
    JSONObject E;
    Map<String, Object> F;
    Account G;
    boolean H;
    ah I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    ad f6373J;
    boolean K;
    al L;
    boolean M;
    com.bytedance.bdinstall.c.b N;
    com.bytedance.bdinstall.c.c O;
    com.bytedance.bdinstall.c.a P;
    af Q;
    boolean R;
    boolean S;
    boolean T;
    boolean U;
    boolean V;
    boolean W;
    boolean X;
    public boolean Y;
    com.bytedance.bdinstall.j.c Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f6374a;
    com.bytedance.bdinstall.f.b aa;
    TelephonyManager ab;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    av f6376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ae f6378e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    ab j;
    boolean k;
    int l;
    ai m;
    Context n;
    String o;
    String p;
    String q;
    String r;
    long s;
    long t;
    long u;
    String v;
    String w;
    String x;
    String y;
    z z;

    @Deprecated
    public m h(boolean r1) {
        return this;
    }

    public m() {
        this.f6374a = true;
        this.f6375b = false;
        this.f = true;
        this.H = false;
        this.K = true;
        this.P = new com.bytedance.bdinstall.c.a.C0145a();
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = true;
        this.V = false;
        this.X = true;
        this.Y = false;
    }

    public m a(Context r3) {
        this.n = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        return this;
    }

    public m a(int r1) {
        this.l = r1;
        return this;
    }

    public m a(String r1) {
        this.v = r1;
        return this;
    }

    public m a(boolean r1) {
        this.h = r1;
        return this;
    }

    public m a(ai r3) {
        this.m = (ai) ZeusTransformUtils.wrapperContextForParams(r3, ai.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m a(ae r3) {
        this.f6378e = (ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m b(String r1) {
        this.w = r1;
        return this;
    }

    public m b(boolean r1) {
        this.f6377d = r1;
        return this;
    }

    public m c(String r1) {
        this.r = r1;
        return this;
    }

    public m a(long r1) {
        this.t = r1;
        return this;
    }

    public m d(String r1) {
        this.y = r1;
        return this;
    }

    public m a(z r3) {
        this.z = (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m c(boolean r1) {
        this.H = r1;
        return this;
    }

    public m e(String r1) {
        this.A = r1;
        return this;
    }

    public m a(Account r1) {
        this.G = r1;
        return this;
    }

    public m f(String r1) {
        this.q = r1;
        return this;
    }

    public m b(long r1) {
        this.s = r1;
        return this;
    }

    public m c(long r1) {
        this.u = r1;
        return this;
    }

    public m a(av r3) {
        this.f6376c = (av) ZeusTransformUtils.wrapperContextForParams(r3, av.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Deprecated
    public m g(String r1) {
        this.x = r1;
        return this;
    }

    public m d(boolean r1) {
        ba.a(r1);
        return this;
    }

    public m h(String r1) {
        this.C = r1;
        return this;
    }

    public m i(String r1) {
        this.D = r1;
        return this;
    }

    public m j(String r1) {
        this.o = r1;
        return this;
    }

    public m k(String r1) {
        this.p = r1;
        return this;
    }

    public m a(ad r3) {
        this.f6373J = (ad) ZeusTransformUtils.wrapperContextForParams(r3, ad.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m a(Map<String, Object> r3) {
        this.F = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m a(ab r3) {
        this.j = (ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m e(boolean r1) {
        this.k = r1;
        return this;
    }

    public m f(boolean r1) {
        this.i = r1;
        return this;
    }

    public m g(boolean r1) {
        this.g = r1;
        return this;
    }

    public m a(ah r3) {
        this.I = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m a(al r3) {
        this.L = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m a(com.bytedance.bdinstall.c.b r3) {
        this.N = (com.bytedance.bdinstall.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdinstall.c.b.class, "com.obric.aiagent.plugin");
        return this;
    }

    public m i(boolean r1) {
        this.M = r1;
        return this;
    }

    public m j(boolean r1) {
        this.R = r1;
        return this;
    }

    public m k(boolean r1) {
        this.S = r1;
        return this;
    }

    public m l(boolean r1) {
        this.U = r1;
        return this;
    }

    public m m(boolean r1) {
        this.Y = r1;
        return this;
    }

    public m a(com.bytedance.bdinstall.j.c r1) {
        this.Z = r1;
        return this;
    }

    public m a(com.bytedance.bdinstall.f.b r1) {
        this.aa = r1;
        return this;
    }

    public an a() {
        if (this.n != null) goto L5;
    L32:
        StringBuilder r1 = new StringBuilder().append("parameters error:");
        if (this.n != null) goto L35;
        boolean r2 = true;
    L37:
        throw new IllegalArgumentException(r1.append(r2).append(", ").append(this.l).append(", ").append(this.w).toString());
    L35:
        r2 = false;
        goto L37
    L5:
        if (this.l <= 0) goto L32;
        if (TextUtils.isEmpty(this.w) == true) goto L32;
        if (TextUtils.isEmpty(this.v) == true) goto L31;
        if (t.a() == true) goto L23;
        if (this.m == null) goto L21;
        if (this.f6378e != null) goto L23;
        throw new IllegalArgumentException("please set event depend");
    L21:
        throw new IllegalArgumentException("please set network client");
    L23:
        if (TextUtils.isEmpty(this.x) == false) goto L26;
        this.x = this.w;
    L26:
        if (this.ab != null) goto L28;
        this.ab = (TelephonyManager) ZeusTransformUtils.preCheckCast(this.n.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin");
    L28:
        com.bytedance.bdinstall.j.e.a().a(this.l);
        return new an(this);
    L31:
        throw new IllegalArgumentException("appName is empty");
    }
}
