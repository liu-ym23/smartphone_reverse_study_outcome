package com.ttnet.org.chromium.net.impl;

import android.util.Log;
import com.ttnet.org.chromium.net.w;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class r extends w.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f18893q = "r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngineBase f18894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.b f18895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f18897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f18900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f18906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f18907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18909p;

    static {
    }

    public r(w.b r10, Executor r11, CronetEngineBase r12) {
        this.f18908o = true;
        this.f18909p = true;
        Log.e(f18893q, "TTWebsocketConnectionBuilderImpl");
        this.f18894a = r12;
        this.f18895b = r10;
        this.f18896c = r11;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w a() {
        if (this.f18909p == false) goto L7;
        return this.f18894a.P(this.f18895b, this.f18896c, this.f18897d, this.f18898e, this.f18899f, this.f18900g, this.f18901h, this.f18902i, this.f18903j, this.f18904k, this.f18905l, this.f18906m, this.f18907n, this.f18908o);
    L7:
        return this.f18894a.Q(this.f18895b, this.f18896c, this.f18897d, this.f18906m, this.f18907n, this.f18908o);
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a b(int r10) {
        this.f18898e = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a c(String r10) {
        this.f18899f = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a d(int r10) {
        this.f18904k = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a e(Map r10) {
        this.f18907n = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a f(Map r10) {
        this.f18906m = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a g(long r10) {
        this.f18900g = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a h(int r10) {
        this.f18901h = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a i(long r10) {
        this.f18902i = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a j(String r10) {
        this.f18903j = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a k(boolean r10) {
        this.f18908o = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a l(List r10) {
        this.f18897d = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public w.a m(boolean r10) {
        this.f18909p = r10;
        return this;
    }
}
