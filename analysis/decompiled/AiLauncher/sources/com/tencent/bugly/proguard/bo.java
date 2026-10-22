package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class bo extends m {

    /* renamed from: A, reason: collision with root package name */
    public static ArrayList<bn> f31584A;

    /* renamed from: B, reason: collision with root package name */
    public static Map<String, String> f31585B;

    /* renamed from: C, reason: collision with root package name */
    public static Map<String, String> f31586C;

    /* renamed from: v, reason: collision with root package name */
    public static Map<String, String> f31587v;

    /* renamed from: w, reason: collision with root package name */
    public static bm f31588w;

    /* renamed from: x, reason: collision with root package name */
    public static bl f31589x;

    /* renamed from: y, reason: collision with root package name */
    public static ArrayList<bl> f31590y;

    /* renamed from: z, reason: collision with root package name */
    public static ArrayList<bl> f31591z;

    /* renamed from: a, reason: collision with root package name */
    public String f31592a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f31593b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f31594c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f31595d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f31596e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f31597f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f31598g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f31599h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f31600i = "";

    /* renamed from: j, reason: collision with root package name */
    public bm f31601j = null;

    /* renamed from: k, reason: collision with root package name */
    public int f31602k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f31603l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f31604m = "";

    /* renamed from: n, reason: collision with root package name */
    public bl f31605n = null;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<bl> f31606o = null;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<bl> f31607p = null;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<bn> f31608q = null;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f31609r = null;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f31610s = null;

    /* renamed from: t, reason: collision with root package name */
    public String f31611t = "";

    /* renamed from: u, reason: collision with root package name */
    public boolean f31612u = true;

    static {
        HashMap map = new HashMap();
        f31587v = map;
        map.put("", "");
        f31588w = new bm();
        f31589x = new bl();
        f31590y = new ArrayList<>();
        f31590y.add(new bl());
        f31591z = new ArrayList<>();
        f31591z.add(new bl());
        f31584A = new ArrayList<>();
        f31584A.add(new bn());
        HashMap map2 = new HashMap();
        f31585B = map2;
        map2.put("", "");
        HashMap map3 = new HashMap();
        f31586C = map3;
        map3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31592a = k10.u(0, true);
        this.f31593b = k10.g(this.f31593b, 1, true);
        this.f31594c = k10.u(2, true);
        this.f31595d = k10.u(3, false);
        this.f31596e = k10.u(4, false);
        this.f31597f = k10.u(5, false);
        this.f31598g = k10.u(6, false);
        this.f31599h = (Map) k10.i(f31587v, 7, false);
        this.f31600i = k10.u(8, false);
        this.f31601j = (bm) k10.h(f31588w, 9, false);
        this.f31602k = k10.d(this.f31602k, 10, false);
        this.f31603l = k10.u(11, false);
        this.f31604m = k10.u(12, false);
        this.f31605n = (bl) k10.h(f31589x, 13, false);
        this.f31606o = (ArrayList) k10.i(f31590y, 14, false);
        this.f31607p = (ArrayList) k10.i(f31591z, 15, false);
        this.f31608q = (ArrayList) k10.i(f31584A, 16, false);
        this.f31609r = (Map) k10.i(f31585B, 17, false);
        this.f31610s = (Map) k10.i(f31586C, 18, false);
        this.f31611t = k10.u(19, false);
        this.f31612u = k10.s(20, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.j(this.f31592a, 0);
        l10.g(this.f31593b, 1);
        l10.j(this.f31594c, 2);
        String str = this.f31595d;
        if (str != null) {
            l10.j(str, 3);
        }
        String str2 = this.f31596e;
        if (str2 != null) {
            l10.j(str2, 4);
        }
        String str3 = this.f31597f;
        if (str3 != null) {
            l10.j(str3, 5);
        }
        String str4 = this.f31598g;
        if (str4 != null) {
            l10.j(str4, 6);
        }
        Map<String, String> map = this.f31599h;
        if (map != null) {
            l10.l(map, 7);
        }
        String str5 = this.f31600i;
        if (str5 != null) {
            l10.j(str5, 8);
        }
        bm bmVar = this.f31601j;
        if (bmVar != null) {
            l10.h(bmVar, 9);
        }
        l10.f(this.f31602k, 10);
        String str6 = this.f31603l;
        if (str6 != null) {
            l10.j(str6, 11);
        }
        String str7 = this.f31604m;
        if (str7 != null) {
            l10.j(str7, 12);
        }
        bl blVar = this.f31605n;
        if (blVar != null) {
            l10.h(blVar, 13);
        }
        ArrayList<bl> arrayList = this.f31606o;
        if (arrayList != null) {
            l10.k(arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.f31607p;
        if (arrayList2 != null) {
            l10.k(arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.f31608q;
        if (arrayList3 != null) {
            l10.k(arrayList3, 16);
        }
        Map<String, String> map2 = this.f31609r;
        if (map2 != null) {
            l10.l(map2, 17);
        }
        Map<String, String> map3 = this.f31610s;
        if (map3 != null) {
            l10.l(map3, 18);
        }
        String str8 = this.f31611t;
        if (str8 != null) {
            l10.j(str8, 19);
        }
        l10.n(this.f31612u, 20);
    }
}
