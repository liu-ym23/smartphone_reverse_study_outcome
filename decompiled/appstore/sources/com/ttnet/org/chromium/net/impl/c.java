package com.ttnet.org.chromium.net.impl;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends com.ttnet.org.chromium.net.t.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f18775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f18776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f18777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f18778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f18779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f18783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f18784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f18785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f18786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f18787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f18788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Long f18789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f18790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f18791t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Long f18792u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f18793v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f18794w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f18795x;

    static {
    }

    public c(long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, boolean r39, long r40, long r42, long r44, String r46, long r47, long r49, String r51, String r52) {
        this.f18772a = r13;
        this.f18773b = r15;
        this.f18774c = r17;
        this.f18775d = r19;
        this.f18776e = r21;
        this.f18777f = r23;
        this.f18778g = r25;
        this.f18779h = r27;
        this.f18780i = r29;
        this.f18781j = r31;
        this.f18782k = r33;
        this.f18783l = r35;
        this.f18784m = r37;
        this.f18785n = r39;
        this.f18788q = Long.valueOf(r40);
        this.f18789r = Long.valueOf(r42);
        this.f18795x = r44;
        this.f18790s = r46;
        this.f18791t = Long.valueOf(r47);
        this.f18792u = Long.valueOf(r49);
        if (r13 != (-1)) goto L5;
    L7:
        this.f18786o = null;
    L8:
        if (r13 != (-1)) goto L10;
    L13:
        this.f18787p = null;
    L14:
        this.f18793v = r51;
        this.f18794w = r52;
        return;
    L10:
        if (r37 == (-1)) goto L13;
        this.f18787p = Long.valueOf(r37 - r13);
        goto L14
    L5:
        if (r35 == (-1)) goto L7;
        this.f18786o = Long.valueOf(r35 - r13);
        goto L8
    }

    public static Date y(long r10) {
        if (r10 != (-1)) goto L5;
        return null;
    L5:
        return new Date(r10);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date a() {
        return y(this.f18776e);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date b() {
        return y(this.f18775d);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date c() {
        return y(this.f18774c);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date d() {
        return y(this.f18773b);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String e() {
        return this.f18790s;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long f() {
        return this.f18791t;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date g() {
        return y(this.f18795x);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date h() {
        return y(this.f18782k);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date i() {
        return y(this.f18781j);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long j() {
        return this.f18789r;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date k() {
        return y(this.f18784m);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String l() {
        return this.f18793v;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date m() {
        return y(this.f18772a);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String n() {
        return this.f18794w;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date o() {
        return y(this.f18783l);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long p() {
        return this.f18792u;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date q() {
        return y(this.f18780i);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date r() {
        return y(this.f18779h);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long s() {
        return this.f18788q;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public boolean t() {
        return this.f18785n;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date u() {
        return y(this.f18778g);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date v() {
        return y(this.f18777f);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long w() {
        return this.f18787p;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long x() {
        return this.f18786o;
    }
}
