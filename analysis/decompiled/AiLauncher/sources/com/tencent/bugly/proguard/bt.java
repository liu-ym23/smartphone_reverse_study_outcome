package com.tencent.bugly.proguard;

import Z7.J;
import Z7.K;
import Z7.L;
import Z7.M;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class bt extends m implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    public static bs f31653m = new bs();

    /* renamed from: n, reason: collision with root package name */
    public static Map<String, String> f31654n = null;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ boolean f31655o = true;

    /* renamed from: a, reason: collision with root package name */
    public boolean f31656a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31657b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31658c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f31659d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f31660e = "";

    /* renamed from: f, reason: collision with root package name */
    public bs f31661f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f31662g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f31663h = 0;

    /* renamed from: i, reason: collision with root package name */
    public String f31664i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f31665j = "";

    /* renamed from: k, reason: collision with root package name */
    public int f31666k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f31667l = 0;

    static {
        HashMap map = new HashMap();
        f31654n = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31656a = k10.s(0, true);
        this.f31657b = k10.s(1, true);
        this.f31658c = k10.s(2, true);
        this.f31659d = k10.u(3, false);
        this.f31660e = k10.u(4, false);
        this.f31661f = (bs) k10.h(f31653m, 5, false);
        this.f31662g = (Map) k10.i(f31654n, 6, false);
        this.f31663h = k10.g(this.f31663h, 7, false);
        this.f31664i = k10.u(8, false);
        this.f31665j = k10.u(9, false);
        this.f31666k = k10.d(this.f31666k, 10, false);
        this.f31667l = k10.d(this.f31667l, 11, false);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f31655o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.n(this.f31656a, 0);
        l10.n(this.f31657b, 1);
        l10.n(this.f31658c, 2);
        String str = this.f31659d;
        if (str != null) {
            l10.j(str, 3);
        }
        String str2 = this.f31660e;
        if (str2 != null) {
            l10.j(str2, 4);
        }
        bs bsVar = this.f31661f;
        if (bsVar != null) {
            l10.h(bsVar, 5);
        }
        Map<String, String> map = this.f31662g;
        if (map != null) {
            l10.l(map, 6);
        }
        l10.g(this.f31663h, 7);
        String str3 = this.f31664i;
        if (str3 != null) {
            l10.j(str3, 8);
        }
        String str4 = this.f31665j;
        if (str4 != null) {
            l10.j(str4, 9);
        }
        l10.f(this.f31666k, 10);
        l10.f(this.f31667l, 11);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        return M.d(this.f31656a, btVar.f31656a) && M.d(this.f31657b, btVar.f31657b) && M.d(this.f31658c, btVar.f31658c) && M.c(this.f31659d, btVar.f31659d) && M.c(this.f31660e, btVar.f31660e) && M.c(this.f31661f, btVar.f31661f) && M.c(this.f31662g, btVar.f31662g) && M.b(this.f31663h, btVar.f31663h) && M.c(this.f31664i, btVar.f31664i) && M.c(this.f31665j, btVar.f31665j) && M.a(this.f31666k, btVar.f31666k) && M.a(this.f31667l, btVar.f31667l);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
        J j10 = new J(sb2, i10);
        j10.m(this.f31656a, "enable");
        j10.m(this.f31657b, "enableUserInfo");
        j10.m(this.f31658c, "enableQuery");
        j10.i(this.f31659d, "url");
        j10.i(this.f31660e, "expUrl");
        j10.g(this.f31661f, "security");
        j10.k(this.f31662g, "valueMap");
        j10.f(this.f31663h, "strategylastUpdateTime");
        j10.i(this.f31664i, "httpsUrl");
        j10.i(this.f31665j, "httpsExpUrl");
        j10.e(this.f31666k, "eventRecordCount");
        j10.e(this.f31667l, "eventTimeInterval");
    }

    public final int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
