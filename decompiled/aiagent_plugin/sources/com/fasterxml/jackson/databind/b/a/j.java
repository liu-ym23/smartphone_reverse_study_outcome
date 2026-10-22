package com.fasterxml.jackson.databind.b.a;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: InnerClassProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends com.fasterxml.jackson.databind.b.v.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final transient Constructor<?> f12308d;

    public j(com.fasterxml.jackson.databind.b.v r1, Constructor<?> r2) {
        super(r1);
        this.f12308d = r2;
    }

    @Override // com.fasterxml.jackson.databind.b.v.a
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.v r2) {
        if (r2 != this.f12540c) goto L6;
        return this;
    L6:
        return new j(r2, this.f12308d);
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7, Object r8) {
        if (r6.l() != com.fasterxml.jackson.a.n.m) goto L6;
        Object r9 = this.m.a(r7);
    L14:
        a(r8, r9);
        return;
    L6:
        if (this.n == null) goto L16;
        r9 = this.m.a(r6, r7, this.n);
        goto L14
    L16:
        Object r0 = this.f12308d.newInstance(new Object[]{r8});     // Catch: Exception -> L11
    L13:
        this.m.a(r6, r7, r0);
        r9 = r0;
    L11:
        e = move-exception;
        com.fasterxml.jackson.databind.l.h.b(e, String.format("Failed to instantiate class %s, problem: %s", new Object[]{this.f12308d.getDeclaringClass().getName(), e.getMessage()}));
        r0 = null;
        goto L13
    }

    @Override // com.fasterxml.jackson.databind.b.v.a, com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        return b(r3, a(r1, r2));
    }
}
