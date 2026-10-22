package com.ttnet.org.chromium.net.impl;

import android.util.Pair;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class s extends com.ttnet.org.chromium.net.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngineBase f18910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0.b f18912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f18913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f18915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f18918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Collection f18919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y f18920k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Executor f18921l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18925p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18926q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.ttnet.org.chromium.net.t.a f18927r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f18928s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18929t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18930u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18931v;

    static {
    }

    public s(String r10, a0.b r11, Executor r12, CronetEngineBase r13) {
        this.f18915f = new ArrayList();
        this.f18918i = 3;
        if (r10 == null) goto L16;
        if (r11 == null) goto L14;
        if (r12 == null) goto L12;
        if (r13 == null) goto L10;
        this.f18911b = r10;
        this.f18912c = r11;
        this.f18913d = r12;
        this.f18910a = r13;
        return;
    L10:
        throw new NullPointerException("CronetEngine is required.");
    L12:
        throw new NullPointerException("Executor is required.");
    L14:
        throw new NullPointerException("Callback is required.");
    L16:
        throw new NullPointerException("URL is required.");
    }

    @Override // com.ttnet.org.chromium.net.a0.a
    public /* bridge */ /* synthetic */ a0.a a(int r10) {
        return q(r10);
    }

    @Override // com.ttnet.org.chromium.net.a0.a
    public /* bridge */ /* synthetic */ a0.a b(int r10) {
        return r(r10);
    }

    @Override // com.ttnet.org.chromium.net.a0.a
    public /* bridge */ /* synthetic */ a0.a c(int r10) {
        return s(r10);
    }

    @Override // com.ttnet.org.chromium.net.a0.a
    public /* bridge */ /* synthetic */ a0.a d(int r10) {
        return t(r10);
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g.a e(String r10, String r11) {
        return m(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g f() {
        return n();
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g.a g() {
        return o();
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public com.ttnet.org.chromium.net.g.a h(String r10) {
        if (r10 == null) goto L6;
        this.f18914e = r10;
        return this;
    L6:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g.a i(int r10) {
        return p(r10);
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g.a j(int r10) {
        return u(r10);
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g.a k(int r10) {
        return v(r10);
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.g.a l(y r10, Executor r11) {
        return w(r10, r11);
    }

    public s m(String r10, String r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L7;
        this.f18915f.add(Pair.create(r10, r11));
        return this;
    L7:
        throw new NullPointerException("Invalid header value.");
    L9:
        throw new NullPointerException("Invalid header name.");
    }

    public UrlRequestBase n() {
        UrlRequestBase r10 = this.f18910a.O(this.f18911b, this.f18912c, this.f18913d, this.f18918i, this.f18919j, this.f18916g, this.f18917h, this.f18922m, this.f18923n, this.f18924o, this.f18925p, this.f18926q, this.f18927r);
        String r11 = this.f18914e;
        if (r11 == null) goto L5;
        r10.m(r11);
    L5:
        Iterator r12 = this.f18915f.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Pair r13 = (Pair) r12.next();
        r10.k((String) r13.first, (String) r13.second);
        goto L7
    L9:
        y r14 = this.f18920k;
        if (r14 == null) goto L12;
        r10.r(r14, this.f18921l);
    L12:
        r10.o(this.f18928s);
        r10.p(this.f18929t);
        r10.q(this.f18930u);
        r10.n(this.f18931v);
        return r10;
    }

    public s o() {
        this.f18916g = true;
        return this;
    }

    public s p(int r10) {
        this.f18918i = r10;
        return this;
    }

    public s q(int r10) {
        this.f18931v = r10;
        return this;
    }

    public s r(int r10) {
        this.f18928s = r10;
        return this;
    }

    public s s(int r10) {
        this.f18929t = r10;
        return this;
    }

    public s t(int r10) {
        this.f18930u = r10;
        return this;
    }

    public s u(int r10) {
        this.f18923n = true;
        this.f18924o = r10;
        return this;
    }

    public s v(int r10) {
        this.f18925p = true;
        this.f18926q = r10;
        return this;
    }

    public s w(y r10, Executor r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L10;
        if (this.f18914e != null) goto L7;
        this.f18914e = "POST";
    L7:
        this.f18920k = r10;
        this.f18921l = r11;
        return this;
    L10:
        throw new NullPointerException("Invalid UploadDataProvider Executor.");
    L12:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }
}
