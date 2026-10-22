package com.fasterxml.jackson.databind.k;

/* JADX INFO: compiled from: MapType.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends g {
    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g H() {
        return J();
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k a(Object r1) {
        return j(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k b(Object r1) {
        return k(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g c(com.fasterxml.jackson.databind.k r1) {
        return d(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k c(Object r1) {
        return l(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d() {
        return J();
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d(Object r1) {
        return m(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g e(Object r1) {
        return j(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g f(Object r1) {
        return k(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g g(Object r1) {
        return l(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g h(Object r1) {
        return m(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.g
    public /* synthetic */ g i(Object r1) {
        return n(r1);
    }

    private h(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.k r6, Object r7, Object r8, boolean r9) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static h a(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14, com.fasterxml.jackson.databind.k r15, com.fasterxml.jackson.databind.k r16) {
        return new h(r11, r12, r13, r14, r15, r16, null, null, false);
    }

    public h j(Object r12) {
        return new h(this.f12956a, this.j, this.h, this.i, this.f, this.g, this.f12958c, r12, this.f12960e);
    }

    public h k(Object r12) {
        return new h(this.f12956a, this.j, this.h, this.i, this.f, this.g.a(r12), this.f12958c, this.f12959d, this.f12960e);
    }

    public h l(Object r12) {
        return new h(this.f12956a, this.j, this.h, this.i, this.f, this.g, r12, this.f12959d, this.f12960e);
    }

    public h m(Object r12) {
        return new h(this.f12956a, this.j, this.h, this.i, this.f, this.g.c(r12), this.f12958c, this.f12959d, this.f12960e);
    }

    public h J() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new h(this.f12956a, this.j, this.h, this.i, this.f.d(), this.g.d(), this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r12) {
        if (this.g != r12) goto L6;
        return this;
    L6:
        return new h(this.f12956a, this.j, this.h, this.i, this.f, r12, this.f12958c, this.f12959d, this.f12960e);
    }

    public h d(com.fasterxml.jackson.databind.k r12) {
        if (r12 != this.f) goto L6;
        return this;
    L6:
        return new h(this.f12956a, this.j, this.h, this.i, r12, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r12, n r13, com.fasterxml.jackson.databind.k r14, com.fasterxml.jackson.databind.k[] r15) {
        return new h(r12, r13, r14, r15, this.f, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    public h n(Object r12) {
        return new h(this.f12956a, this.j, this.h, this.i, this.f.c(r12), this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k.g, com.fasterxml.jackson.databind.k
    public String toString() {
        return "[map type; class " + this.f12956a.getName() + ", " + this.f + " -> " + this.g + "]";
    }
}
