package com.fasterxml.jackson.databind.k;

/* JADX INFO: compiled from: ResolvedRecursiveType.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends m {
    protected com.fasterxml.jackson.databind.k f;

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Object r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k b(Object r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k c(Object r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k d() {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k d(Object r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean q() {
        return false;
    }

    public k(Class<?> r10, n r11) {
        super(r10, r11, null, null, 0, null, null, false);
    }

    public void c(com.fasterxml.jackson.databind.k r4) {
        if (this.f != null) goto L7;
        this.f = r4;
        return;
    L7:
        throw new IllegalStateException("Trying to re-set self reference; old value = " + this.f + ", new = " + r4);
    }

    @Override // com.fasterxml.jackson.databind.k.m, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k B() {
        com.fasterxml.jackson.databind.k r0 = this.f;
        if (r0 == null) goto L7;
        return r0.B();
    L7:
        return super.B();
    }

    public com.fasterxml.jackson.databind.k H() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.k.m, com.fasterxml.jackson.databind.k
    public n A() {
        com.fasterxml.jackson.databind.k r0 = this.f;
        if (r0 == null) goto L7;
        return r0.A();
    L7:
        return super.A();
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder a(StringBuilder r1) {
        com.fasterxml.jackson.databind.k r0 = this.f;
        if (r0 == null) goto L7;
        return r0.b(r1);
    L7:
        return r1.append("?");
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder b(StringBuilder r1) {
        com.fasterxml.jackson.databind.k r0 = this.f;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.b(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public String toString() {
        StringBuilder r0 = new StringBuilder(40).append("[recursive type; ");
        com.fasterxml.jackson.databind.k r2 = this.f;
        if (r2 != null) goto L5;
        r0.append("UNRESOLVED");
    L7:
        return r0.toString();
    L5:
        r0.append(r2.e().getName());
        goto L7
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r2.getClass() == getClass()) goto L10;
    L10:
        return false;
    }
}
