package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObjectIdValueProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends com.fasterxml.jackson.databind.b.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final s f12336c;

    @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return null;
    }

    public u(s r4, com.fasterxml.jackson.databind.w r5) {
        super(r4.f12329b, r4.b(), r5, r4.a());
        this.f12336c = r4;
    }

    public u(u r3, com.fasterxml.jackson.databind.l<?> r4, com.fasterxml.jackson.databind.b.s r5) {
        super(r3, r4, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"));
        this.f12336c = r3.f12336c;
    }

    public u(u r1, com.fasterxml.jackson.databind.x r2) {
        super(r1, r2);
        this.f12336c = r1.f12336c;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.x r2) {
        return new u(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.l<?> r3) {
        if (this.m != r3) goto L6;
        return this;
    L6:
        if (this.m != this.o) goto L8;
        com.fasterxml.jackson.databind.b.s r0 = r3;
    L10:
        return new u(this, r3, r0);
    L8:
        r0 = this.o;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.s r3) {
        com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new u(this, this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        b(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (r3.a(com.fasterxml.jackson.a.n.m) == false) goto L6;
        return null;
    L6:
        Object r6 = this.m.a(r3, r4);
        r4.a(r6, this.f12336c.f12330c, this.f12336c.f12331d).a(r5);
        com.fasterxml.jackson.databind.b.v r2 = this.f12336c.f;
        if (r2 != null) goto L9;
        return r5;
    L9:
        return r2.b(r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(Object r1, Object r2) {
        b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(Object r1, Object r2) {
        com.fasterxml.jackson.databind.b.v r0 = this.f12336c.f;
        if (r0 == null) goto L7;
        return r0.b(r1, r2);
    L7:
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }
}
