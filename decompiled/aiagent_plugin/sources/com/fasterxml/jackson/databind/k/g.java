package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MapLikeType.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends m {
    protected final com.fasterxml.jackson.databind.k f;
    protected final com.fasterxml.jackson.databind.k g;

    @Override // com.fasterxml.jackson.databind.k
    public boolean q() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean s() {
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

    public g(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14, com.fasterxml.jackson.databind.k r15, com.fasterxml.jackson.databind.k r16, Object r17, Object r18, boolean r19) {
        super(r11, r12, r13, r14, r15.hashCode() ^ r16.hashCode(), r17, r18, r19);
        this.f = r15;
        this.g = r16;
    }

    public g c(com.fasterxml.jackson.databind.k r12) {
        if (r12 != this.f) goto L6;
        return this;
    L6:
        return new g(this.f12956a, this.j, this.h, this.i, r12, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r12) {
        if (this.g != r12) goto L6;
        return this;
    L6:
        return new g(this.f12956a, this.j, this.h, this.i, this.f, r12, this.f12958c, this.f12959d, this.f12960e);
    }

    public g e(Object r12) {
        return new g(this.f12956a, this.j, this.h, this.i, this.f, this.g, this.f12958c, r12, this.f12960e);
    }

    public g f(Object r12) {
        return new g(this.f12956a, this.j, this.h, this.i, this.f, this.g.a(r12), this.f12958c, this.f12959d, this.f12960e);
    }

    public g g(Object r12) {
        return new g(this.f12956a, this.j, this.h, this.i, this.f, this.g, r12, this.f12959d, this.f12960e);
    }

    public g h(Object r12) {
        return new g(this.f12956a, this.j, this.h, this.i, this.f, this.g.c(r12), this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.k r5) {
        com.fasterxml.jackson.databind.k r1 = super.b(r5);
        com.fasterxml.jackson.databind.k r2 = r5.w();
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L8;
        if (r2 == null) goto L8;
        com.fasterxml.jackson.databind.k r3 = this.f.b(r2);
        if (r3 == this.f) goto L8;
        r1 = ((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin")).c(r3);
    L8:
        com.fasterxml.jackson.databind.k r6 = r5.x();
        if (r6 == null) goto L14;
        com.fasterxml.jackson.databind.k r7 = this.g.b(r6);
        if (r7 != this.g) goto L13;
        return r1;
    L13:
        return r1.a(r7);
    L14:
        return r1;
    }

    public g H() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new g(this.f12956a, this.j, this.h, this.i, this.f, this.g.d(), this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r12, n r13, com.fasterxml.jackson.databind.k r14, com.fasterxml.jackson.databind.k[] r15) {
        return new g(r12, r13, r14, r15, this.f, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k.m
    public String I() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f12956a.getName());
        if (this.f == null) goto L8;
        if (c(2) == false) goto L8;
        r0.append('<');
        r0.append(this.f.c());
        r0.append(',');
        r0.append(this.g.c());
        r0.append('>');
    L8:
        return r0.toString();
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k w() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k x() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean F() {
        if (super.F() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.g.F() == true) goto L10;
        if (this.f.F() == true) goto L10;
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
        this.g.a(r3);
        r3.append(">;");
        return r3;
    }

    public g i(Object r12) {
        return new g(this.f12956a, this.j, this.h, this.i, this.f.c(r12), this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k
    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", new Object[]{this.f12956a.getName(), this.f, this.g});
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
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f12956a != r6.f12956a) goto L19;
        if (this.f.equals(r6.f) == false) goto L19;
        if (this.g.equals(r6.g) == false) goto L19;
        return true;
    L19:
        return false;
    }
}
