package com.fasterxml.jackson.databind.b.a;

/* JADX INFO: compiled from: MergingSettableBeanProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends com.fasterxml.jackson.databind.b.v.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.j f12317d;

    public n(com.fasterxml.jackson.databind.b.v r1, com.fasterxml.jackson.databind.e.j r2) {
        super(r1);
        this.f12317d = r2;
    }

    public static n a(com.fasterxml.jackson.databind.b.v r1, com.fasterxml.jackson.databind.e.j r2) {
        return new n(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v.a
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.v r2) {
        return new n(r2, this.f12317d);
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        Object r0 = this.f12317d.b(r5);
        if (r0 != null) goto L5;
        Object r6 = this.f12540c.a(r3, r4);
    L6:
        if (r6 == r0) goto L9;
        this.f12540c.a(r5, r6);
        return;
    L9:
        return;
    L5:
        r6 = this.f12540c.c(r3, r4, r0);
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        Object r0 = this.f12317d.b(r5);
        if (r0 != null) goto L5;
        Object r6 = this.f12540c.a(r3, r4);
    L6:
        if (r6 == r0) goto L10;
        if (r6 == null) goto L10;
        return this.f12540c.b(r5, r6);
    L10:
        return r5;
    L5:
        r6 = this.f12540c.c(r3, r4, r0);
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public void a(Object r1, Object r2) {
        if (r2 == null) goto L5;
        this.f12540c.a(r1, r2);
        return;
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public Object b(Object r1, Object r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        return this.f12540c.b(r1, r2);
    }
}
