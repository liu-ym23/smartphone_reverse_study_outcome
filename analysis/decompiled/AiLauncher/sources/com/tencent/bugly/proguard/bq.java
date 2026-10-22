package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class bq extends m {

    /* renamed from: y, reason: collision with root package name */
    public static byte[] f31615y = {0};

    /* renamed from: z, reason: collision with root package name */
    public static Map<String, String> f31616z;

    /* renamed from: a, reason: collision with root package name */
    public int f31617a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f31618b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f31619c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f31620d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f31621e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f31622f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f31623g = 0;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f31624h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f31625i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f31626j = "";

    /* renamed from: k, reason: collision with root package name */
    public Map<String, String> f31627k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f31628l = "";

    /* renamed from: m, reason: collision with root package name */
    public long f31629m = 0;

    /* renamed from: n, reason: collision with root package name */
    public String f31630n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f31631o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f31632p = "";

    /* renamed from: q, reason: collision with root package name */
    public long f31633q = 0;

    /* renamed from: r, reason: collision with root package name */
    public String f31634r = "";

    /* renamed from: s, reason: collision with root package name */
    public String f31635s = "";

    /* renamed from: t, reason: collision with root package name */
    public String f31636t = "";

    /* renamed from: u, reason: collision with root package name */
    public String f31637u = "";

    /* renamed from: v, reason: collision with root package name */
    public String f31638v = "";

    /* renamed from: w, reason: collision with root package name */
    public String f31639w = "";

    /* renamed from: x, reason: collision with root package name */
    public String f31640x = "";

    static {
        HashMap map = new HashMap();
        f31616z = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31617a = k10.d(this.f31617a, 0, true);
        this.f31618b = k10.u(1, true);
        this.f31619c = k10.u(2, true);
        this.f31620d = k10.u(3, true);
        this.f31621e = k10.u(4, false);
        this.f31622f = k10.u(5, true);
        this.f31623g = k10.d(this.f31623g, 6, true);
        this.f31624h = k10.y(7, true);
        this.f31625i = k10.u(8, false);
        this.f31626j = k10.u(9, false);
        this.f31627k = (Map) k10.i(f31616z, 10, false);
        this.f31628l = k10.u(11, false);
        this.f31629m = k10.g(this.f31629m, 12, false);
        this.f31630n = k10.u(13, false);
        this.f31631o = k10.u(14, false);
        this.f31632p = k10.u(15, false);
        this.f31633q = k10.g(this.f31633q, 16, false);
        this.f31634r = k10.u(17, false);
        this.f31635s = k10.u(18, false);
        this.f31636t = k10.u(19, false);
        this.f31637u = k10.u(20, false);
        this.f31638v = k10.u(21, false);
        this.f31639w = k10.u(22, false);
        this.f31640x = k10.u(23, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.f(this.f31617a, 0);
        l10.j(this.f31618b, 1);
        l10.j(this.f31619c, 2);
        l10.j(this.f31620d, 3);
        String str = this.f31621e;
        if (str != null) {
            l10.j(str, 4);
        }
        l10.j(this.f31622f, 5);
        l10.f(this.f31623g, 6);
        l10.o(this.f31624h, 7);
        String str2 = this.f31625i;
        if (str2 != null) {
            l10.j(str2, 8);
        }
        String str3 = this.f31626j;
        if (str3 != null) {
            l10.j(str3, 9);
        }
        Map<String, String> map = this.f31627k;
        if (map != null) {
            l10.l(map, 10);
        }
        String str4 = this.f31628l;
        if (str4 != null) {
            l10.j(str4, 11);
        }
        l10.g(this.f31629m, 12);
        String str5 = this.f31630n;
        if (str5 != null) {
            l10.j(str5, 13);
        }
        String str6 = this.f31631o;
        if (str6 != null) {
            l10.j(str6, 14);
        }
        String str7 = this.f31632p;
        if (str7 != null) {
            l10.j(str7, 15);
        }
        l10.g(this.f31633q, 16);
        String str8 = this.f31634r;
        if (str8 != null) {
            l10.j(str8, 17);
        }
        String str9 = this.f31635s;
        if (str9 != null) {
            l10.j(str9, 18);
        }
        String str10 = this.f31636t;
        if (str10 != null) {
            l10.j(str10, 19);
        }
        String str11 = this.f31637u;
        if (str11 != null) {
            l10.j(str11, 20);
        }
        String str12 = this.f31638v;
        if (str12 != null) {
            l10.j(str12, 21);
        }
        String str13 = this.f31639w;
        if (str13 != null) {
            l10.j(str13, 22);
        }
        String str14 = this.f31640x;
        if (str14 != null) {
            l10.j(str14, 23);
        }
    }
}
