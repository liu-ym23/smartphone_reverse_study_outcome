package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class w implements com.bumptech.glide.load.a.d.a<Object>, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.a f3739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f3740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.g f3743e;
    private List<com.bumptech.glide.load.b.n<File, ?>> f;
    private int g;
    private volatile com.bumptech.glide.load.b.n.a<?> h;
    private File i;
    private x j;

    w(g<?> r3, f.a r4) {
        f.a r5 = (f.a) ZeusTransformUtils.wrapperContextForParams(r4, f.a.class, "com.obric.aiagent.plugin");
        this.f3742d = -1;
        this.f3740b = r3;
        this.f3739a = r5;
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        List<com.bumptech.glide.load.g> r0 = this.f3740b.o();
        boolean r2 = false;
        if (r0.isEmpty() == false) goto L5;
        return false;
    L5:
        List<Class<?>> r1 = this.f3740b.l();
        if (r1.isEmpty() == false) goto L13;
        if (File.class.equals(this.f3740b.j()) == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("Failed to find any load path from " + this.f3740b.k() + " to " + this.f3740b.j());
    L13:
        if (this.f != null) goto L15;
    L27:
        int r3 = this.f3742d + 1;
        this.f3742d = r3;
        if (r3 < r1.size()) goto L33;
        int r4 = this.f3741c + 1;
        this.f3741c = r4;
        if (r4 >= r0.size()) goto L31;
        this.f3742d = 0;
        goto L33
    L31:
        return false;
    L33:
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(r0.get(this.f3741c), com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Class r12 = (Class) ZeusTransformUtils.preCheckCast(r1.get(this.f3742d), Class.class, "com.obric.aiagent.plugin");
        this.j = new x(this.f3740b.i(), r5, this.f3740b.f(), this.f3740b.g(), this.f3740b.h(), this.f3740b.c(r12), r12, this.f3740b.e());
        File r6 = this.f3740b.b().a(this.j);
        this.i = r6;
        if (r6 == null) goto L13;
        this.f3743e = r5;
        this.f = this.f3740b.a(r6);
        this.g = 0;
        goto L13
    L15:
        if (c() == false) goto L27;
        this.h = null;
    L18:
        if (r2 == true) goto L26;
        if (c() == false) goto L26;
        List<com.bumptech.glide.load.b.n<File, ?>> r7 = this.f;
        int r8 = this.g;
        this.g = r8 + 1;
        this.h = ((com.bumptech.glide.load.b.n) ZeusTransformUtils.preCheckCast(r7.get(r8), com.bumptech.glide.load.b.n.class, "com.obric.aiagent.plugin")).a(this.i, this.f3740b.g(), this.f3740b.h(), this.f3740b.e());
        if (this.h == null) goto L18;
        if (this.f3740b.a(this.h.f3468c.a()) == false) goto L18;
        this.h.f3468c.a(this.f3740b.d(), this);
        r2 = true;
    L26:
        return r2;
    }

    private boolean c() {
        if (this.g >= this.f.size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.engine.f
    public void b() {
        com.bumptech.glide.load.b.n.a<?> r0 = this.h;
        if (r0 == null) goto L6;
        r0.f3468c.c();
        return;
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Object r7) {
        this.f3739a.a(this.f3743e, r7, this.h.f3468c, com.bumptech.glide.load.a.f3352d, this.j);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Exception r4) {
        this.f3739a.a(this.j, r4, this.h.f3468c, com.bumptech.glide.load.a.f3352d);
    }
}
