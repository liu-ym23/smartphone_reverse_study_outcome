package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.v;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CronetEngineBuilderImpl extends com.ttnet.org.chromium.net.i {
    public static final Pattern F = null;
    public static final String G = null;
    public String A;
    public boolean B;
    public long C;
    public String D;
    public boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f18523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f18532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f18534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TTAppInfoProvider f18539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public v f18540t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.ttnet.org.chromium.net.u f18541u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f18542v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f18543w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map f18544x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f18545y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f18546z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18549c;

        public a(String r10, int r11, int r12) {
            this.f18547a = r10;
            this.f18548b = r11;
            this.f18549c = r12;
        }
    }

    static {
        F = Pattern.compile("^[0-9\\.]*$");
        G = CronetEngineBuilderImpl.class.getSimpleName();
    }

    public CronetEngineBuilderImpl(Context r10) {
        this.f18522b = new LinkedList();
        this.f18523c = new LinkedList();
        this.f18536p = 20;
        this.f18521a = r10.getApplicationContext();
        M(true);
        H(true);
        G(false);
        I(0, 0);
        K(false);
        L(true);
        J(false);
        j0(false);
    }

    public long A() {
        return this.C;
    }

    public CronetEngineBuilderImpl A0(String r10) {
        File r11 = new File(r10);
        if (r11.exists() == true) goto L10;
        if (r11.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r11.isDirectory() == false) goto L14;
        this.f18526f = r10;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    public CronetEngineBuilderImpl B(String r10, int r11, int r12) {
        if (r10.contains(LibrarianImpl.Constants.SEPARATOR) == true) goto L7;
        this.f18522b.add(new a(r10, r11, r12));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + r10);
    }

    public CronetEngineBuilderImpl B0(String r10) {
        this.f18546z = r10;
        return this;
    }

    public boolean C() {
        return this.B;
    }

    public CronetEngineBuilderImpl C0(int r10) {
        if (r10 > 19) goto L9;
        if (r10 < (-20)) goto L9;
        this.f18536p = r10;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    public boolean D() {
        return this.f18529i;
    }

    public CronetEngineBuilderImpl D0(String r10) {
        this.f18525e = r10;
        return this;
    }

    public boolean E() {
        return this.f18530j;
    }

    public String E0() {
        return this.f18526f;
    }

    public CronetEngineBuilderImpl F(boolean r10) {
        this.B = r10;
        return this;
    }

    public int F0(int r10) {
        int r11 = this.f18536p;
        if (r11 != 20) goto L6;
        return r10;
    L6:
        return r11;
    }

    public CronetEngineBuilderImpl G(boolean r10) {
        this.f18529i = r10;
        return this;
    }

    public boolean G0() {
        return this.f18538r;
    }

    public CronetEngineBuilderImpl H(boolean r10) {
        this.f18528h = r10;
        return this;
    }

    public CronetEngineBuilderImpl I(int r10, long r11) {
        if (r10 == 3) goto L12;
        if (r10 == 2) goto L12;
        if (E0() == null) goto L14;
        throw new IllegalArgumentException("Storage path must not be set");
    L14:
        if (r10 == 0) goto L18;
        if (r10 == 2) goto L18;
        boolean r12 = false;
    L19:
        this.f18530j = r12;
        this.f18532l = r11;
        if (r10 == 0) goto L29;
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L27;
        if (r10 == 3) goto L27;
        throw new IllegalArgumentException("Unknown cache mode");
    L27:
        this.f18531k = 1;
    L30:
        return this;
    L28:
        this.f18531k = 2;
        goto L30
    L29:
        this.f18531k = 0;
    L18:
        r12 = true;
    L12:
        if (E0() != null) goto L14;
        throw new IllegalArgumentException("Storage path must be set");
    }

    public CronetEngineBuilderImpl J(boolean r10) {
        this.f18537q = r10;
        return this;
    }

    public CronetEngineBuilderImpl K(boolean r10) {
        this.f18535o = r10;
        return this;
    }

    public CronetEngineBuilderImpl L(boolean r10) {
        this.f18524d = r10;
        return this;
    }

    public CronetEngineBuilderImpl M(boolean r10) {
        this.f18527g = r10;
        return this;
    }

    public CronetEngineBuilderImpl N() {
        this.f18538r = true;
        return this;
    }

    public String O() {
        return this.f18533m;
    }

    public TTAppInfoProvider P() {
        return this.f18539s;
    }

    public v Q() {
        return this.f18540t;
    }

    public String R() {
        return this.f18545y;
    }

    public Map S() {
        return this.f18544x;
    }

    public Context T() {
        return this.f18521a;
    }

    public String U() {
        return this.D;
    }

    public String V() {
        if (this.f18527g == true) goto L7;
        return "";
    L7:
        return u.c(this.f18521a);
    }

    public String W() {
        return u.b(this.f18521a);
    }

    public com.ttnet.org.chromium.net.u X() {
        return this.f18541u;
    }

    public String Y() {
        return this.f18542v;
    }

    public boolean Z() {
        return this.E;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i a(String r10, int r11, int r12) {
        return B(r10, r11, r12);
    }

    public ArrayList a0() {
        return this.f18543w;
    }

    public String b0() {
        return this.A;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i c(boolean r10) {
        return F(r10);
    }

    public String c0() {
        return this.f18546z;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i d(boolean r10) {
        return G(r10);
    }

    public String d0() {
        return this.f18525e;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i e(boolean r10) {
        return H(r10);
    }

    public boolean e0() {
        return this.f18528h;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i f(int r10, long r11) {
        return I(r10, r11);
    }

    public long f0() {
        return this.f18532l;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i g(boolean r10) {
        return J(r10);
    }

    public int g0() {
        return this.f18531k;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i h(boolean r10) {
        return K(r10);
    }

    public boolean h0() {
        return this.f18537q;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i i(boolean r10) {
        return M(r10);
    }

    public VersionSafeCallbacks.b i0() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i j() {
        return N();
    }

    public CronetEngineBuilderImpl j0(boolean r10) {
        this.E = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i k(boolean r10) {
        return j0(r10);
    }

    public long k0() {
        return this.f18534n;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i l(long r10) {
        return q0(r10);
    }

    public boolean l0() {
        return this.f18535o;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i m(TTAppInfoProvider r10) {
        return r0(r10);
    }

    public boolean m0() {
        return this.f18524d;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i n(v r10) {
        return s0(r10);
    }

    public List n0() {
        return this.f18523c;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i o(String r10) {
        return t0(r10);
    }

    public boolean o0() {
        return this.f18527g;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i p(Map r10) {
        return u0(r10);
    }

    public List p0() {
        return this.f18522b;
    }

    @Override // com.ttnet.org.chromium.net.i
    public com.ttnet.org.chromium.net.i q(String r10) {
        this.D = r10;
        return this;
    }

    public CronetEngineBuilderImpl q0(long r10) {
        this.C = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i r(com.ttnet.org.chromium.net.u r10) {
        return v0(r10);
    }

    public CronetEngineBuilderImpl r0(TTAppInfoProvider r10) {
        this.f18539s = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i s(String r10) {
        return w0(r10);
    }

    public CronetEngineBuilderImpl s0(v r10) {
        this.f18540t = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i t(com.ttnet.org.chromium.net.c.a.b r10) {
        return x0(r10);
    }

    public CronetEngineBuilderImpl t0(String r10) {
        this.f18545y = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i u(ArrayList r10) {
        return y0(r10);
    }

    public CronetEngineBuilderImpl u0(Map r10) {
        this.f18544x = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i v(String r10) {
        return z0(r10);
    }

    public CronetEngineBuilderImpl v0(com.ttnet.org.chromium.net.u r10) {
        this.f18541u = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i w(String r10) {
        return A0(r10);
    }

    public CronetEngineBuilderImpl w0(String r10) {
        this.f18542v = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i x(String r10) {
        return B0(r10);
    }

    public CronetEngineBuilderImpl x0(com.ttnet.org.chromium.net.c.a.b r10) {
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i y(int r10) {
        return C0(r10);
    }

    public CronetEngineBuilderImpl y0(ArrayList r10) {
        this.f18543w = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.i
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.i z(String r10) {
        return D0(r10);
    }

    public CronetEngineBuilderImpl z0(String r10) {
        this.A = r10;
        return this;
    }
}
