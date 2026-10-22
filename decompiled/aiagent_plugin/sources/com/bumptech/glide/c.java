package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.a.j;
import com.bumptech.glide.load.engine.b.i;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, h<?, ?>> f3265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f3266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.e f3267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.b f3268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.engine.b.h f3269e;
    private com.bumptech.glide.load.engine.c.a f;
    private com.bumptech.glide.load.engine.c.a g;
    private com.bumptech.glide.load.engine.b.a.InterfaceC0093a h;
    private i i;
    private com.bumptech.glide.manager.d j;
    private int k;
    private Glide.a l;
    private RequestManagerRetriever.a m;
    private com.bumptech.glide.load.engine.c.a n;
    private boolean o;
    private List<com.bumptech.glide.request.g<Object>> p;
    private boolean q;
    private boolean r;

    public c() {
        this.f3265a = new androidx.b.a();
        this.k = 4;
        this.l = new AnonymousClass1(this);
    }

    void a(RequestManagerRetriever.a r3) {
        this.m = (RequestManagerRetriever.a) ZeusTransformUtils.wrapperContextForParams(r3, RequestManagerRetriever.a.class, "com.obric.aiagent.plugin");
    }

    Glide a(Context r15) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        if (this.f != null) goto L6;
        this.f = com.bumptech.glide.load.engine.c.a.d();
    L6:
        if (this.g != null) goto L9;
        this.g = com.bumptech.glide.load.engine.c.a.b();
    L9:
        if (this.n != null) goto L12;
        this.n = com.bumptech.glide.load.engine.c.a.g();
    L12:
        if (this.i != null) goto L15;
        this.i = new i.a(r1).a();
    L15:
        if (this.j != null) goto L18;
        this.j = new com.bumptech.glide.manager.f();
    L18:
        if (this.f3267c != null) goto L24;
        int r16 = this.i.b();
        if (r16 <= 0) goto L22;
        this.f3267c = new com.bumptech.glide.load.engine.a.k(r16);
        goto L24
    L22:
        this.f3267c = new com.bumptech.glide.load.engine.a.f();
    L24:
        if (this.f3268d != null) goto L27;
        this.f3268d = new j(this.i.c());
    L27:
        if (this.f3269e != null) goto L30;
        this.f3269e = new com.bumptech.glide.load.engine.b.g(this.i.a());
    L30:
        if (this.h != null) goto L33;
        this.h = new com.bumptech.glide.load.engine.b.f(r1);
    L33:
        if (this.f3266b != null) goto L35;
        this.f3266b = new k(this.f3269e, this.h, this.g, this.f, com.bumptech.glide.load.engine.c.a.e(), this.n, this.o);
    L35:
        List<com.bumptech.glide.request.g<Object>> r17 = this.p;
        if (r17 != null) goto L38;
        this.p = Collections.emptyList();
    L40:
        return new Glide(r1, this.f3266b, this.f3269e, this.f3267c, this.f3268d, new RequestManagerRetriever(this.m), this.j, this.k, this.l, this.f3265a, this.p, this.q, this.r);
    L38:
        this.p = Collections.unmodifiableList(r17);
        goto L40
    }
}
