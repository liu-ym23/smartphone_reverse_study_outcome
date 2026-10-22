package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CollectionLikeType.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends m {
    protected final com.fasterxml.jackson.databind.k f;

    @Override // com.fasterxml.jackson.databind.k
    public boolean q() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean r() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k a(Object r1) {
        return e(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k b(Object r1) {
        return f(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k c(Object r1) {
        return g(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d() {
        return H();
    }

    @Override // com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d(Object r1) {
        return h(r1);
    }

    public d(Class<?> r10, n r11, com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.k[] r13, com.fasterxml.jackson.databind.k r14, Object r15, Object r16, boolean r17) {
        super(r10, r11, r12, r13, r14.hashCode(), r15, r16, r17);
        this.f = r14;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r11) {
        if (this.f != r11) goto L6;
        return this;
    L6:
        return new d(this.f12956a, this.j, this.h, this.i, r11, this.f12958c, this.f12959d, this.f12960e);
    }

    public d e(Object r11) {
        return new d(this.f12956a, this.j, this.h, this.i, this.f, this.f12958c, r11, this.f12960e);
    }

    public d f(Object r11) {
        return new d(this.f12956a, this.j, this.h, this.i, this.f.a(r11), this.f12958c, this.f12959d, this.f12960e);
    }

    public d g(Object r11) {
        return new d(this.f12956a, this.j, this.h, this.i, this.f, r11, this.f12959d, this.f12960e);
    }

    public d h(Object r11) {
        return new d(this.f12956a, this.j, this.h, this.i, this.f.c(r11), this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.k r3) {
        com.fasterxml.jackson.databind.k r0 = super.b(r3);
        com.fasterxml.jackson.databind.k r4 = r3.x();
        if (r4 == null) goto L8;
        com.fasterxml.jackson.databind.k r5 = this.f.b(r4);
        if (r5 != this.f) goto L7;
        return r0;
    L7:
        return r0.a(r5);
    L8:
        return r0;
    }

    public d H() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new d(this.f12956a, this.j, this.h, this.i, this.f.d(), this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14) {
        return new d(r11, r12, r13, r14, this.f, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k x() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean F() {
        if (super.F() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f.F() == true) goto L8;
        return false;
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder b(StringBuilder r2) {
        return a(this.f12956a, r2, true);
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder a(StringBuilder r3) {
        a(this.f12956a, r3, false);
        r3.append('<');
        this.f.a(r3);
        r3.append(">;");
        return r3;
    }

    @Override // com.fasterxml.jackson.databind.k.m
    public String I() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f12956a.getName());
        if (this.f == null) goto L8;
        if (c(1) == false) goto L8;
        r0.append('<');
        r0.append(this.f.c());
        r0.append('>');
    L8:
        return r0.toString();
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getClass() == getClass()) goto L11;
        return false;
    L11:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f12956a != r6.f12956a) goto L17;
        if (this.f.equals(r6.f) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.k
    public String toString() {
        return "[collection-like type; class " + this.f12956a.getName() + ", contains " + this.f + "]";
    }
}
