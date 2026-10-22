package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReferenceTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class y<T> extends ab<T> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.y f12502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12504d;

    @Override // com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
    public abstract T a(com.fasterxml.jackson.databind.h r1);

    public abstract T a(T r1, Object r2);

    public abstract y<T> b(com.fasterxml.jackson.databind.h.e r1, com.fasterxml.jackson.databind.l<?> r2);

    public abstract Object b(T r1);

    public abstract T c(Object r1);

    public y(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.b.y r2, com.fasterxml.jackson.databind.h.e r3, com.fasterxml.jackson.databind.l<?> r4) {
        super(r1);
        this.f12502b = r2;
        this.f12501a = r1;
        this.f12504d = r4;
        this.f12503c = r3;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l<?> r0 = this.f12504d;
        if (r0 != null) goto L5;
        com.fasterxml.jackson.databind.l<?> r6 = r3.a(this.f12501a.y(), r5);
    L6:
        com.fasterxml.jackson.databind.h.e r1 = this.f12503c;
        if (r1 == null) goto L10;
        r1 = r1.a(r5);
    L10:
        if (r6 != this.f12504d) goto L15;
        if (r1 != this.f12503c) goto L15;
        return this;
    L15:
        return b(r1, r6);
    L5:
        r6 = r3.b(r0, r5, this.f12501a.y());
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12996c;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return a(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.b.y k() {
        return this.f12502b;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.k j() {
        return this.f12501a;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12504d;
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        return super.b();
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12504d;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.databind.b.y r0 = this.f12502b;
        if (r0 != null) goto L5;
        com.fasterxml.jackson.databind.h.e r1 = this.f12503c;
        if (r1 != null) goto L9;
        Object r5 = this.f12504d.a(r3, r4);
    L11:
        return (T) c(r5);
    L9:
        r5 = this.f12504d.a(r3, r4, r1);
        goto L11
    L5:
        return (T) a(r3, r4, r0.a(r4));
    }

    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, T r5) {
        if (this.f12504d.a(r4.c()).equals(Boolean.FALSE) == false) goto L5;
    L16:
        com.fasterxml.jackson.databind.h.e r0 = this.f12503c;
        if (r0 != null) goto L19;
        Object r6 = this.f12504d.a(r3, r4);
    L21:
        return a(r5, r6);
    L19:
        r6 = this.f12504d.a(r3, r4, r0);
        goto L21
    L5:
        if (this.f12503c != null) goto L16;
        Object r1 = b(r5);
        if (r1 != null) goto L15;
        com.fasterxml.jackson.databind.h.e r7 = this.f12503c;
        if (r7 != null) goto L12;
        Object r8 = this.f12504d.a(r3, r4);
    L14:
        return c(r8);
    L12:
        r8 = this.f12504d.a(r3, r4, r7);
        goto L14
    L15:
        r6 = this.f12504d.a(r3, r4, r1);
        goto L21
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        if (r1.a(com.fasterxml.jackson.a.n.m) == true) goto L5;
        com.fasterxml.jackson.databind.h.e r4 = this.f12503c;
        if (r4 != null) goto L11;
        return a(r1, r2);
    L11:
        return c(r4.d(r1, r2));
    L5:
        return a(r2);
    }
}
