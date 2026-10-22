package com.bytedance.apm.block;

import org.json.JSONObject;

/* JADX INFO: compiled from: BlockRecord.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f4355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f4356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f4357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f4358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f4359e;
    boolean f;
    long g;
    long h;
    long i;
    boolean j;
    boolean k;
    volatile boolean l;
    boolean m;
    long n;
    long o;
    StackTraceElement[] p;
    StackTraceElement[] q;
    String r;
    String s;
    String t;
    JSONObject u;
    JSONObject v;
    JSONObject w;
    JSONObject x;

    d(long r4, String r6) {
        this.f4355a = true;
        this.f4357c = false;
        this.f4358d = false;
        this.f4359e = false;
        this.f = false;
        this.g = -1;
        this.h = -1;
        this.j = false;
        this.k = false;
        this.l = false;
        this.g = r4;
        this.f4356b = r6;
    }

    d a() {
        d r0 = new d(this.g, this.f4356b);
        r0.h = this.h;
        r0.f4355a = this.f4355a;
        r0.f4357c = this.f4357c;
        r0.f4358d = this.f4358d;
        r0.f4359e = this.f4359e;
        r0.f = this.f;
        r0.i = this.i;
        r0.j = this.j;
        r0.k = this.k;
        r0.n = this.n;
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        r0.s = this.s;
        r0.t = this.t;
        r0.u = this.u;
        r0.v = this.v;
        r0.w = this.w;
        r0.x = this.x;
        r0.m = this.m;
        return r0;
    }

    void a(long r1, String r3) {
        this.g = r1;
        this.f4356b = r3;
        this.h = -1;
        this.f4355a = false;
    }

    void b() {
        this.f4355a = true;
        this.f4357c = false;
        this.f4358d = false;
        this.f4359e = false;
        this.f = false;
        this.i = 0;
        this.j = false;
        this.l = false;
        this.k = false;
        this.m = false;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
    }
}
