package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TokenBufferReadContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class z extends com.fasterxml.jackson.a.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.m f13087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.i f13088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f13089e;
    protected Object f;

    public z(com.fasterxml.jackson.a.m r3, com.fasterxml.jackson.a.d.d r4) {
        super(r3);
        this.f13087c = r3.a();
        this.f13089e = r3.h();
        this.f = r3.i();
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.a.e.c.class) == false) goto L5;
        this.f13088d = ((com.fasterxml.jackson.a.e.c) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.a.e.c.class, "com.obric.aiagent.plugin")).a(r4);
        return;
    L5:
        this.f13088d = com.fasterxml.jackson.a.i.f12130a;
    }

    public z(com.fasterxml.jackson.a.m r2, com.fasterxml.jackson.a.i r3) {
        super(r2);
        this.f13087c = r2.a();
        this.f13089e = r2.h();
        this.f = r2.i();
        this.f13088d = r3;
    }

    public z() {
        super(0, -1);
        this.f13087c = null;
        this.f13088d = com.fasterxml.jackson.a.i.f12130a;
    }

    public z(z r1, int r2, int r3) {
        super(r2, r3);
        this.f13087c = r1;
        this.f13088d = r1.f13088d;
    }

    @Override // com.fasterxml.jackson.a.m
    public Object i() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.a.m
    public void a(Object r1) {
        this.f = r1;
    }

    public static z a(com.fasterxml.jackson.a.m r2) {
        if (r2 != null) goto L6;
        return new z();
    L6:
        return new z(r2, com.fasterxml.jackson.a.d.d.a());
    }

    public z j() {
        this.f12150b++;
        return new z(this, 1, -1);
    }

    public z k() {
        this.f12150b++;
        return new z(this, 2, -1);
    }

    public z l() {
        if (ZeusTransformUtils.instanceOf(this.f13087c, z.class) == false) goto L7;
        return (z) ZeusTransformUtils.preCheckCast(this.f13087c, z.class, "com.obric.aiagent.plugin");
    L7:
        if (this.f13087c != null) goto L11;
        return new z();
    L11:
        return new z(this.f13087c, this.f13088d);
    }

    @Override // com.fasterxml.jackson.a.m
    public String h() {
        return this.f13089e;
    }

    @Override // com.fasterxml.jackson.a.m
    public com.fasterxml.jackson.a.m a() {
        return this.f13087c;
    }

    public void a(String r1) {
        this.f13089e = r1;
    }

    public void m() {
        this.f12150b++;
    }
}
