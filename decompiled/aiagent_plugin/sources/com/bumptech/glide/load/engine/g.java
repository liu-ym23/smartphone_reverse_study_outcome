package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class g<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.b.n.a<?>> f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.g> f3641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GlideContext f3642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f3643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3644e;
    private int f;
    private Class<?> g;
    private h.d h;
    private com.bumptech.glide.load.i i;
    private Map<Class<?>, com.bumptech.glide.load.m<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.load.g n;
    private com.bumptech.glide.e o;
    private j p;
    private boolean q;
    private boolean r;

    g() {
        this.f3640a = new ArrayList();
        this.f3641b = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(GlideContext r8, Object r9, com.bumptech.glide.load.g r10, int r11, int r12, j r13, Class<?> r14, Class<R> r15, com.bumptech.glide.e r16, com.bumptech.glide.load.i r17, Map<Class<?>, com.bumptech.glide.load.m<?>> r18, boolean r19, boolean r20, h.d r21) {
        GlideContext r1 = (GlideContext) ZeusTransformUtils.wrapperContextForParams(r8, GlideContext.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r3 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Map<Class<?>, com.bumptech.glide.load.m<?>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        h.d r2 = (h.d) ZeusTransformUtils.wrapperContextForParams(r21, h.d.class, "com.obric.aiagent.plugin");
        this.f3642c = r1;
        this.f3643d = r9;
        this.n = r3;
        this.f3644e = r11;
        this.f = r12;
        this.p = r13;
        this.g = r14;
        this.h = r2;
        this.k = r15;
        this.o = r16;
        this.i = r17;
        this.j = r4;
        this.q = r19;
        this.r = r20;
    }

    void a() {
        this.f3642c = null;
        this.f3643d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f3640a.clear();
        this.l = false;
        this.f3641b.clear();
        this.m = false;
    }

    com.bumptech.glide.load.engine.b.a b() {
        return this.h.a();
    }

    j c() {
        return this.p;
    }

    com.bumptech.glide.e d() {
        return this.o;
    }

    com.bumptech.glide.load.i e() {
        return this.i;
    }

    com.bumptech.glide.load.g f() {
        return this.n;
    }

    int g() {
        return this.f3644e;
    }

    int h() {
        return this.f;
    }

    com.bumptech.glide.load.engine.a.b i() {
        return this.f3642c.getArrayPool();
    }

    Class<?> j() {
        return this.k;
    }

    Class<?> k() {
        return this.f3643d.getClass();
    }

    List<Class<?>> l() {
        return this.f3642c.getRegistry().b(this.f3643d.getClass(), this.g, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean a(Class<?> r1) {
        if (b(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    <Data> t<Data, ?, Transcode> b(Class<Data> r3) {
        return this.f3642c.getRegistry().a(r3, this.g, this.k);
    }

    boolean m() {
        return this.r;
    }

    <Z> com.bumptech.glide.load.m<Z> c(Class<Z> r7) {
        com.bumptech.glide.load.m<Z> r0 = (com.bumptech.glide.load.m) ZeusTransformUtils.preCheckCast(this.j.get(r7), com.bumptech.glide.load.m.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.m<?>>> r1 = this.j.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((Class) ZeusTransformUtils.preCheckCast(r3.getKey(), Class.class, "com.obric.aiagent.plugin")).isAssignableFrom(r7) == false) goto L6;
        r0 = (com.bumptech.glide.load.m) ZeusTransformUtils.preCheckCast(r3.getValue(), com.bumptech.glide.load.m.class, "com.obric.aiagent.plugin");
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        if (this.j.isEmpty() == false) goto L19;
        if (this.q == false) goto L19;
        throw new IllegalArgumentException("Missing transformation for " + r7 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    L19:
        return com.bumptech.glide.load.resource.c.a();
    }

    boolean a(v<?> r3) {
        v<?> r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        return this.f3642c.getRegistry().a(r4);
    }

    <Z> com.bumptech.glide.load.l<Z> b(v<Z> r3) {
        v r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        return this.f3642c.getRegistry().b(r4);
    }

    List<com.bumptech.glide.load.b.n<File, ?>> a(File r1) {
        return this.f3642c.getRegistry().c(r1);
    }

    boolean a(com.bumptech.glide.load.g r7) {
        com.bumptech.glide.load.g r8 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        List<com.bumptech.glide.load.b.n.a<?>> r6 = n();
        int r0 = r6.size();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        if (((com.bumptech.glide.load.b.n.a) ZeusTransformUtils.preCheckCast(r6.get(r3), com.bumptech.glide.load.b.n.a.class, "com.obric.aiagent.plugin")).f3466a.equals(r8) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    List<com.bumptech.glide.load.b.n.a<?>> n() {
        if (this.l == true) goto L11;
        this.l = true;
        this.f3640a.clear();
        List r0 = this.f3642c.getRegistry().c(this.f3643d);
        int r1 = 0;
        int r2 = r0.size();
    L5:
        if (r1 >= r2) goto L11;
        com.bumptech.glide.load.b.n.a<?> r3 = ((com.bumptech.glide.load.b.n) ZeusTransformUtils.preCheckCast(r0.get(r1), com.bumptech.glide.load.b.n.class, "com.obric.aiagent.plugin")).a(this.f3643d, this.f3644e, this.f, this.i);
        if (r3 == null) goto L9;
        this.f3640a.add(r3);
    L9:
        r1 = r1 + 1;
    L11:
        return this.f3640a;
    }

    List<com.bumptech.glide.load.g> o() {
        if (this.m == true) goto L18;
        this.m = true;
        this.f3641b.clear();
        List<com.bumptech.glide.load.b.n.a<?>> r0 = n();
        int r1 = r0.size();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L18;
        com.bumptech.glide.load.b.n.a r4 = (com.bumptech.glide.load.b.n.a) ZeusTransformUtils.preCheckCast(r0.get(r3), com.bumptech.glide.load.b.n.a.class, "com.obric.aiagent.plugin");
        if (this.f3641b.contains(r4.f3466a) == true) goto L9;
        this.f3641b.add(r4.f3466a);
    L9:
        int r5 = 0;
    L11:
        if (r5 >= r4.f3467b.size()) goto L16;
        if (this.f3641b.contains(r4.f3467b.get(r5)) == true) goto L15;
        this.f3641b.add(r4.f3467b.get(r5));
    L15:
        r5 = r5 + 1;
        goto L11
    L16:
        r3 = r3 + 1;
    L18:
        return this.f3641b;
    }

    <X> com.bumptech.glide.load.d<X> a(X r1) {
        return this.f3642c.getRegistry().a(r1);
    }
}
