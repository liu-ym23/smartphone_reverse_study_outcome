package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SimpleType.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends m {
    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean f() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean q() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k a(Object r1) {
        return k(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k c(Object r1) {
        return j(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d() {
        return J();
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d(Object r1) {
        return i(r1);
    }

    public l(Class<?> r3) {
        this(r3, n.a(), null, null);
    }

    public l(Class<?> r9, n r10, com.fasterxml.jackson.databind.k r11, com.fasterxml.jackson.databind.k[] r12) {
        this(r9, r10, r11, r12, null, null, false);
    }

    public l(Class<?> r10, n r11, com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.k[] r13, Object r14, Object r15, boolean r16) {
        super(r10, r11, r12, r13, 0, r14, r15, r16);
    }

    public l(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4, int r5, Object r6, Object r7, boolean r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static l e(Class<?> r9) {
        return new l(r9, null, null, null, null, null, false);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r1) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    public l k(Object r10) {
        if (this.f12959d != r10) goto L6;
        return this;
    L6:
        return new l(this.f12956a, this.j, this.h, this.i, this.f12958c, r10, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k b(Object r1) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    public l j(Object r10) {
        if (r10 != this.f12958c) goto L6;
        return this;
    L6:
        return new l(this.f12956a, this.j, this.h, this.i, r10, this.f12959d, this.f12960e);
    }

    public l i(Object r1) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
    }

    public l J() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new l(this.f12956a, this.j, this.h, this.i, this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k.m
    public String I() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f12956a.getName());
        int r1 = this.j.c();
        if (r1 <= 0) goto L14;
        if (c(r1) == false) goto L14;
        r0.append('<');
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        com.fasterxml.jackson.databind.k r3 = a(r2);
        if (r2 <= 0) goto L11;
        r0.append(',');
    L11:
        r0.append(r3.c());
        r2 = r2 + 1;
        goto L7
    L12:
        r0.append('>');
    L14:
        return r0.toString();
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder b(StringBuilder r2) {
        return a(this.f12956a, r2, true);
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder a(StringBuilder r4) {
        int r1 = 0;
        a(this.f12956a, r4, false);
        int r0 = this.j.c();
        if (r0 <= 0) goto L8;
        r4.append('<');
    L5:
        if (r1 >= r0) goto L7;
        r4 = a(r1).a(r4);
        r1 = r1 + 1;
        goto L5
    L7:
        r4.append('>');
    L8:
        r4.append(';');
        return r4;
    }

    @Override // com.fasterxml.jackson.databind.k
    public String toString() {
        StringBuilder r0 = new StringBuilder(40);
        r0.append("[simple type, class ").append(I()).append(']');
        return r0.toString();
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.getClass() == getClass()) goto L11;
        return false;
    L11:
        l r5 = (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.aiagent.plugin");
        if (r5.f12956a == this.f12956a) goto L15;
        return false;
    L15:
        return this.j.equals(r5.j);
    }
}
