package com.ttnet.org.chromium.net.impl;

import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: UrlRequestBuilderImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class ag extends com.ttnet.org.chromium.net.i.a {
    private static final String TAG = "ag";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f38105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f38106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.ai.b f38107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f38108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f38109e;
    private final ArrayList<Pair<String, String>> f;
    private boolean g;
    private boolean h;
    private int i;
    private Collection<Object> j;
    private com.ttnet.org.chromium.net.ag k;
    private Executor l;
    private boolean m;
    private boolean n;
    private int o;
    private boolean p;
    private int q;
    private com.ttnet.org.chromium.net.w.a r;
    private long s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;

    static {
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a a() {
        return c();
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a a(int r1) {
        return m(r1);
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a a(com.ttnet.org.chromium.net.ag r3, Executor r4) {
        return b(r3, (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a a(com.ttnet.org.chromium.net.w.a r1) {
        return b(r1);
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a a(String r1, String r2) {
        return b(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a b(int r1) {
        return n(r1);
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i b() {
        return d();
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public /* synthetic */ com.ttnet.org.chromium.net.i.a c(int r1) {
        return h(r1);
    }

    @Override // com.ttnet.org.chromium.net.ai.a
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a d(int r1) {
        return i(r1);
    }

    @Override // com.ttnet.org.chromium.net.ai.a
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a e(int r1) {
        return j(r1);
    }

    @Override // com.ttnet.org.chromium.net.ai.a
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a f(int r1) {
        return k(r1);
    }

    @Override // com.ttnet.org.chromium.net.ai.a
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a g(int r1) {
        return l(r1);
    }

    ag(String r3, com.ttnet.org.chromium.net.ai.b r4, Executor r5, d r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        this.f = new ArrayList();
        this.i = 3;
        this.s = -1;
        this.t = 0;
        Objects.requireNonNull(r3, "URL is required.");
        Objects.requireNonNull(r4, "Callback is required.");
        Objects.requireNonNull(r7, "Executor is required.");
        Objects.requireNonNull(r6, "CronetEngine is required.");
        this.f38106b = r3;
        this.f38107c = r4;
        this.f38108d = r7;
        this.f38105a = r6;
    }

    @Override // com.ttnet.org.chromium.net.i.a
    public com.ttnet.org.chromium.net.i.a a(String r2) {
        Objects.requireNonNull(r2, "Method is required.");
        this.f38109e = r2;
        return this;
    }

    public ag b(String r2, String r3) {
        Objects.requireNonNull(r2, "Invalid header name.");
        Objects.requireNonNull(r3, "Invalid header value.");
        this.f.add(Pair.create(r2, r3));
        return this;
    }

    public ag c() {
        this.g = true;
        return this;
    }

    public ag h(int r1) {
        this.i = r1;
        return this;
    }

    public ag i(int r1) {
        this.u = r1;
        return this;
    }

    public ag j(int r1) {
        this.v = r1;
        return this;
    }

    public ag k(int r1) {
        this.w = r1;
        return this;
    }

    public ag l(int r1) {
        this.x = r1;
        return this;
    }

    public ag b(com.ttnet.org.chromium.net.ag r3, Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r3, "Invalid UploadDataProvider.");
        Objects.requireNonNull(r5, "Invalid UploadDataProvider Executor.");
        if (this.f38109e != null) goto L5;
        this.f38109e = "POST";
    L5:
        this.k = r3;
        this.l = r5;
        return this;
    }

    public ag m(int r2) {
        this.n = true;
        this.o = r2;
        return this;
    }

    public ag n(int r2) {
        this.p = true;
        this.q = r2;
        return this;
    }

    public ag b(com.ttnet.org.chromium.net.w.a r1) {
        this.r = r1;
        return this;
    }

    public af d() {
        af r1 = this.f38105a.a(this.f38106b, this.f38107c, this.f38108d, this.i, this.j, this.g, this.h, this.m, this.n, this.o, this.p, this.q, this.r, this.t, this.s);
        String r2 = this.f38109e;
        if (r2 == null) goto L5;
        r1.b(r2);
    L5:
        Iterator<Pair<String, String>> r3 = this.f.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.aiagent.plugin");
        r1.c((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.aiagent.plugin"));
        goto L7
    L9:
        com.ttnet.org.chromium.net.ag r5 = this.k;
        if (r5 == null) goto L12;
        r1.a(r5, this.l);
    L12:
        r1.d(this.u);
        r1.e(this.v);
        r1.f(this.w);
        r1.g(this.x);
        return r1;
    }
}
