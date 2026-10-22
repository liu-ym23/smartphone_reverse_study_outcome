package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObjectIdReferenceProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends com.fasterxml.jackson.databind.b.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.fasterxml.jackson.databind.b.v f12333c;

    /* JADX INFO: compiled from: ObjectIdReferenceProperty.java */
    public static final class a extends z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f12334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final t f12335b;

        public a(t r1, com.fasterxml.jackson.databind.b.w r2, Class<?> r3, Object r4) {
            super(r2, r3);
            this.f12335b = r1;
            this.f12334a = r4;
        }

        @Override // com.fasterxml.jackson.databind.b.a.z.a
        public void a(Object r2, Object r3) {
            if (b(r2) == false) goto L7;
            this.f12335b.a(this.f12334a, r3);
            return;
        L7:
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + r2 + "] that wasn't previously seen as unresolved.");
        }
    }

    public t(com.fasterxml.jackson.databind.b.v r1, com.fasterxml.jackson.databind.e.ac r2) {
        super(r1);
        this.f12333c = r1;
        this.q = r2;
    }

    public t(t r3, com.fasterxml.jackson.databind.l<?> r4, com.fasterxml.jackson.databind.b.s r5) {
        super(r3, r4, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"));
        this.f12333c = r3.f12333c;
        this.q = r3.q;
    }

    public t(t r1, com.fasterxml.jackson.databind.x r2) {
        super(r1, r2);
        this.f12333c = r1.f12333c;
        this.q = r1.q;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.x r2) {
        return new t(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.l<?> r3) {
        if (this.m != r3) goto L6;
        return this;
    L6:
        if (this.m != this.o) goto L8;
        com.fasterxml.jackson.databind.b.s r0 = r3;
    L10:
        return new t(this, r3, r0);
    L8:
        r0 = this.o;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.s r3) {
        com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new t(this, this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.databind.g r1) {
        com.fasterxml.jackson.databind.b.v r0 = this.f12333c;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.f12333c.d();
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public int g() {
        return this.f12333c.g();
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        b(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return b(r5, a(r3, r4));
    L4:
        e = move-exception;
        if (this.q == null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L16;
        e.f().a(new a(this, e, this.j.e(), r5));
        return null;
    L16:
        throw com.fasterxml.jackson.databind.m.a(r3, "Unresolved forward reference but no identity info", e);
    L8:
        if (this.m.f() != null) goto L11;
        r0 = false;
        goto L12
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(Object r1, Object r2) {
        this.f12333c.a(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(Object r1, Object r2) {
        return this.f12333c.b(r1, r2);
    }
}
