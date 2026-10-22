package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: DataCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class c implements com.bumptech.glide.load.a.d.a<Object>, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.g> f3589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f3590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.a f3591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.g f3593e;
    private List<com.bumptech.glide.load.b.n<File, ?>> f;
    private int g;
    private volatile com.bumptech.glide.load.b.n.a<?> h;
    private File i;

    c(g<?> r3, f.a r4) {
        f.a r5 = (f.a) ZeusTransformUtils.wrapperContextForParams(r4, f.a.class, "com.obric.aiagent.plugin");
        this(r3.o(), r3, r5);
    }

    c(List<com.bumptech.glide.load.g> r3, g<?> r4, f.a r5) {
        List<com.bumptech.glide.load.g> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        f.a r7 = (f.a) ZeusTransformUtils.wrapperContextForParams(r5, f.a.class, "com.obric.aiagent.plugin");
        this.f3592d = -1;
        this.f3589a = r6;
        this.f3590b = r4;
        this.f3591c = r7;
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
    L2:
        boolean r2 = false;
        if (this.f != null) goto L5;
    L17:
        int r0 = this.f3592d + 1;
        this.f3592d = r0;
        if (r0 >= this.f3589a.size()) goto L19;
        com.bumptech.glide.load.g r1 = (com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(this.f3589a.get(this.f3592d), com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        File r3 = this.f3590b.b().a(new d(r1, this.f3590b.f()));
        this.i = r3;
        if (r3 == null) goto L2;
        this.f3593e = r1;
        this.f = this.f3590b.a(r3);
        this.g = 0;
        goto L2
    L19:
        return false;
    L5:
        if (c() == false) goto L17;
        this.h = null;
    L8:
        if (r2 == true) goto L16;
        if (c() == false) goto L16;
        List<com.bumptech.glide.load.b.n<File, ?>> r4 = this.f;
        int r5 = this.g;
        this.g = r5 + 1;
        this.h = ((com.bumptech.glide.load.b.n) ZeusTransformUtils.preCheckCast(r4.get(r5), com.bumptech.glide.load.b.n.class, "com.obric.aiagent.plugin")).a(this.i, this.f3590b.g(), this.f3590b.h(), this.f3590b.e());
        if (this.h == null) goto L8;
        if (this.f3590b.a(this.h.f3468c.a()) == false) goto L8;
        this.h.f3468c.a(this.f3590b.d(), this);
        r2 = true;
    L16:
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
        this.f3591c.a(this.f3593e, r7, this.h.f3468c, com.bumptech.glide.load.a.f3351c, this.f3593e);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Exception r4) {
        this.f3591c.a(this.f3593e, r4, this.h.f3468c, com.bumptech.glide.load.a.f3351c);
    }
}
