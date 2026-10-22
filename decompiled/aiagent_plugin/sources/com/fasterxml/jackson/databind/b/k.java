package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CreatorProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.n f12524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JacksonInject.Value f12525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected v f12526e;
    protected final int f;
    protected boolean g;

    public k(com.fasterxml.jackson.databind.x r9, com.fasterxml.jackson.databind.k r10, com.fasterxml.jackson.databind.x r11, com.fasterxml.jackson.databind.h.e r12, com.fasterxml.jackson.databind.l.b r13, com.fasterxml.jackson.databind.e.n r14, int r15, JacksonInject.Value r16, com.fasterxml.jackson.databind.w r17) {
        super(r9, r10, r11, r12, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r13, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"), r17);
        this.f12524c = r14;
        this.f = r15;
        this.f12525d = r16;
        this.f12526e = null;
    }

    public static k a(com.fasterxml.jackson.databind.x r11, com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.x r13, com.fasterxml.jackson.databind.h.e r14, com.fasterxml.jackson.databind.l.b r15, com.fasterxml.jackson.databind.e.n r16, int r17, JacksonInject.Value r18, com.fasterxml.jackson.databind.w r19) {
        return new k(r11, r12, r13, r14, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r15, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"), r16, r17, r18, r19);
    }

    public k(k r1, com.fasterxml.jackson.databind.x r2) {
        super(r1, r2);
        this.f12524c = r1.f12524c;
        this.f12525d = r1.f12525d;
        this.f12526e = r1.f12526e;
        this.f = r1.f;
        this.g = r1.g;
    }

    public k(k r3, com.fasterxml.jackson.databind.l<?> r4, s r5) {
        super(r3, r4, (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.aiagent.plugin"));
        this.f12524c = r3.f12524c;
        this.f12525d = r3.f12525d;
        this.f12526e = r3.f12526e;
        this.f = r3.f;
        this.g = r3.g;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public v a(com.fasterxml.jackson.databind.x r2) {
        return new k(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public v a(com.fasterxml.jackson.databind.l<?> r3) {
        if (this.m != r3) goto L6;
        return this;
    L6:
        if (this.m != this.o) goto L8;
        s r0 = r3;
    L10:
        return new k(this, r3, r0);
    L8:
        r0 = this.o;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public v a(s r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.aiagent.plugin");
        return new k(this, this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.databind.g r1) {
        v r0 = this.f12526e;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(v r1) {
        this.f12526e = r1;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void e() {
        this.g = true;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public boolean f() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.f12524c;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public int g() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4) {
        t();
        this.f12526e.a(r4, a(r2, r3));
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4) {
        t();
        return this.f12526e.b(r4, a(r2, r3));
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(Object r1, Object r2) {
        t();
        this.f12526e.a(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(Object r1, Object r2) {
        t();
        return this.f12526e.b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.e.w, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.w c() {
        com.fasterxml.jackson.databind.w r0 = super.c();
        v r1 = this.f12526e;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0.a(r1.c().d());
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object h() {
        JacksonInject.Value r0 = this.f12525d;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getId();
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public boolean i() {
        JacksonInject.Value r1 = this.f12525d;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.willUseInput(true) == true) goto L7;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public String toString() {
        return "[creator property, name " + com.fasterxml.jackson.databind.l.h.b(a()) + "; inject id '" + h() + "']";
    }

    private final void t() {
        if (this.f12526e != null) goto L6;
        b(null, null);
        return;
    }

    private void b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        String r0 = "No fallback setter/field defined for creator property " + com.fasterxml.jackson.databind.l.h.b(a());
        if (r4 == null) goto L7;
        r4.b(getType(), r0);
        return;
    L7:
        throw com.fasterxml.jackson.databind.c.b.a(r3, r0, getType());
    }
}
