package com.amap.location.type.location;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Location implements Serializable {

    /* renamed from: A, reason: collision with root package name */
    public int f18149A;

    /* renamed from: B, reason: collision with root package name */
    public String f18150B;

    /* renamed from: C, reason: collision with root package name */
    public HashMap<String, Object> f18151C;

    /* renamed from: a, reason: collision with root package name */
    public String f18152a;

    /* renamed from: b, reason: collision with root package name */
    public int f18153b;

    /* renamed from: c, reason: collision with root package name */
    public int f18154c;

    /* renamed from: d, reason: collision with root package name */
    public long f18155d;

    /* renamed from: e, reason: collision with root package name */
    public long f18156e;

    /* renamed from: f, reason: collision with root package name */
    public double f18157f;

    /* renamed from: g, reason: collision with root package name */
    public double f18158g;

    /* renamed from: h, reason: collision with root package name */
    public double f18159h;

    /* renamed from: i, reason: collision with root package name */
    public float f18160i;

    /* renamed from: j, reason: collision with root package name */
    public float f18161j;

    /* renamed from: k, reason: collision with root package name */
    public float f18162k;

    /* renamed from: l, reason: collision with root package name */
    public float f18163l;

    /* renamed from: m, reason: collision with root package name */
    public float f18164m;

    /* renamed from: n, reason: collision with root package name */
    public float f18165n;

    /* renamed from: o, reason: collision with root package name */
    public String f18166o;

    /* renamed from: p, reason: collision with root package name */
    public int f18167p;

    /* renamed from: q, reason: collision with root package name */
    public String f18168q;

    /* renamed from: s, reason: collision with root package name */
    public int f18170s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f18172u;

    /* renamed from: x, reason: collision with root package name */
    public String f18175x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f18176y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f18177z;

    /* renamed from: t, reason: collision with root package name */
    public int f18171t = 0;

    /* renamed from: v, reason: collision with root package name */
    public int f18173v = -1;

    /* renamed from: w, reason: collision with root package name */
    public int f18174w = -1;

    /* renamed from: r, reason: collision with root package name */
    public String f18169r = Const.STR_PUBLIC_TAG;

    public Location(String str, int i10, int i11) {
        this.f18152a = str;
        this.f18153b = i10;
        this.f18154c = i11;
    }

    public int A() {
        return this.f18153b;
    }

    public float C() {
        return this.f18163l;
    }

    public boolean D() {
        return this.f18177z;
    }

    public boolean E() {
        return this.f18172u;
    }

    public boolean F() {
        return this.f18176y;
    }

    public synchronized HashMap<String, Object> a() {
        HashMap<String, Object> map = this.f18151C;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return new HashMap<>(this.f18151C);
    }

    public float b() {
        return this.f18162k;
    }

    public double c() {
        return this.f18159h;
    }

    public float d() {
        return this.f18161j;
    }

    public float e() {
        return this.f18165n;
    }

    @Deprecated
    public int f() {
        return this.f18170s;
    }

    public int g() {
        return this.f18167p;
    }

    public String h() {
        return this.f18168q;
    }

    public int i() {
        return this.f18173v;
    }

    public int j() {
        return this.f18174w;
    }

    public double k() {
        return this.f18157f;
    }

    public long l() {
        return this.f18156e;
    }

    public long m() {
        return this.f18155d;
    }

    public double n() {
        return this.f18158g;
    }

    public String q() {
        return this.f18150B;
    }

    public String s() {
        return this.f18166o;
    }

    public int t() {
        return this.f18149A;
    }

    public String u() {
        return this.f18152a;
    }

    public String v() {
        return this.f18175x;
    }

    public String w() {
        return this.f18169r;
    }

    public float x() {
        return this.f18160i;
    }

    public float y() {
        return this.f18164m;
    }

    public int z() {
        return this.f18154c;
    }
}
