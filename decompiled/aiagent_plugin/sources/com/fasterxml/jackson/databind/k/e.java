package com.fasterxml.jackson.databind.k;

/* JADX INFO: compiled from: CollectionType.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends d {
    @Override // com.fasterxml.jackson.databind.k.d
    public /* synthetic */ d H() {
        return J();
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k a(Object r1) {
        return i(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k b(Object r1) {
        return j(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k c(Object r1) {
        return k(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d() {
        return J();
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d(Object r1) {
        return l(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d
    public /* synthetic */ d e(Object r1) {
        return i(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d
    public /* synthetic */ d f(Object r1) {
        return j(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d
    public /* synthetic */ d g(Object r1) {
        return k(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.d
    public /* synthetic */ d h(Object r1) {
        return l(r1);
    }

    private e(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4, com.fasterxml.jackson.databind.k r5, Object r6, Object r7, boolean r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static e a(Class<?> r10, n r11, com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.k[] r13, com.fasterxml.jackson.databind.k r14) {
        return new e(r10, r11, r12, r13, r14, null, null, false);
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r11) {
        if (this.f != r11) goto L6;
        return this;
    L6:
        return new e(this.f12956a, this.j, this.h, this.i, r11, this.f12958c, this.f12959d, this.f12960e);
    }

    public e i(Object r11) {
        return new e(this.f12956a, this.j, this.h, this.i, this.f, this.f12958c, r11, this.f12960e);
    }

    public e j(Object r11) {
        return new e(this.f12956a, this.j, this.h, this.i, this.f.a(r11), this.f12958c, this.f12959d, this.f12960e);
    }

    public e k(Object r11) {
        return new e(this.f12956a, this.j, this.h, this.i, this.f, r11, this.f12959d, this.f12960e);
    }

    public e l(Object r11) {
        return new e(this.f12956a, this.j, this.h, this.i, this.f.c(r11), this.f12958c, this.f12959d, this.f12960e);
    }

    public e J() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new e(this.f12956a, this.j, this.h, this.i, this.f.d(), this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14) {
        return new e(r11, r12, r13, r14, this.f, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k.d, com.fasterxml.jackson.databind.k
    public String toString() {
        return "[collection type; class " + this.f12956a.getName() + ", contains " + this.f + "]";
    }
}
