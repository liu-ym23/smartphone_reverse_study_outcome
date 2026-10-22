package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GuidelineReference.java */
/* JADX INFO: loaded from: classes.dex */
class j extends p {
    @Override // androidx.constraintlayout.a.c.a.p
    boolean a() {
        return false;
    }

    public j(androidx.constraintlayout.a.c.e r3) {
        super(r3);
        r3.f.c();
        r3.g.c();
        this.h = ((androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r3, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin")).c();
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void c() {
        this.j.a();
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    private void a(f r2) {
        this.j.k.add(r2);
        r2.l.add(this.j);
    }

    @Override // androidx.constraintlayout.a.c.a.p, androidx.constraintlayout.a.c.a.d
    public void update(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (this.j.f711c == true) goto L6;
        return;
    L6:
        if (this.j.j == false) goto L8;
        return;
    L8:
        this.j.a((int) ((((f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin")).g * ((androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(this.f743d, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin")).f()) + 0.5f));
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void f() {
        androidx.constraintlayout.a.c.h r0 = (androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(this.f743d, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        int r1 = r0.g();
        int r2 = r0.h();
        r0.f();
        if (r0.c() != 1) goto L10;
        if (r1 == (-1)) goto L6;
        this.j.l.add(this.f743d.L.f.j);
        this.f743d.L.f.j.k.add(this.j);
        this.j.f = r1;
    L9:
        a(this.f743d.f.j);
        a(this.f743d.f.k);
        return;
    L6:
        if (r2 == (-1)) goto L8;
        this.j.l.add(this.f743d.L.f.k);
        this.f743d.L.f.k.k.add(this.j);
        int r3 = -r2;
        this.j.f = r3;
        goto L9
    L8:
        this.j.f710b = true;
        this.j.l.add(this.f743d.L.f.k);
        this.f743d.L.f.k.k.add(this.j);
        goto L9
    L10:
        if (r1 == (-1)) goto L12;
        this.j.l.add(this.f743d.L.g.j);
        this.f743d.L.g.j.k.add(this.j);
        this.j.f = r1;
    L15:
        a(this.f743d.g.j);
        a(this.f743d.g.k);
        return;
    L12:
        if (r2 == (-1)) goto L14;
        this.j.l.add(this.f743d.L.g.k);
        this.f743d.L.g.k.k.add(this.j);
        int r4 = -r2;
        this.j.f = r4;
        goto L15
    L14:
        this.j.f710b = true;
        this.j.l.add(this.f743d.L.g.k);
        this.f743d.L.g.k.k.add(this.j);
        goto L15
    }

    @Override // androidx.constraintlayout.a.c.a.p
    public void e() {
        if (((androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(this.f743d, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin")).c() != 1) goto L5;
        this.f743d.o(this.j.g);
        return;
    L5:
        this.f743d.p(this.j.g);
    }
}
