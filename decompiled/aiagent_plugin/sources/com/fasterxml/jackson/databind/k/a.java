package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: ArrayType.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends m {
    protected final com.fasterxml.jackson.databind.k f;
    protected final Object g;

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean g() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean h() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean j() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean q() {
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

    public a(com.fasterxml.jackson.databind.k r10, n r11, Object r12, Object r13, Object r14, boolean r15) {
        super(r12.getClass(), r11, null, null, r10.hashCode(), r13, r14, r15);
        this.f = r10;
        this.g = r12;
    }

    public static a a(com.fasterxml.jackson.databind.k r1, n r2) {
        return a(r1, r2, null, null);
    }

    public static a a(com.fasterxml.jackson.databind.k r9, n r10, Object r11, Object r12) {
        return new a(r9, r10, Array.newInstance(r9.e(), 0), r11, r12, false);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r10) {
        Object r5 = Array.newInstance(r10.e(), 0);
        return new a(r10, this.j, r5, this.f12958c, this.f12959d, this.f12960e);
    }

    public a e(Object r9) {
        if (r9 != this.f12959d) goto L6;
        return this;
    L6:
        return new a(this.f, this.j, this.g, this.f12958c, r9, this.f12960e);
    }

    public a f(Object r9) {
        if (r9 != this.f.E()) goto L6;
        return this;
    L6:
        return new a(this.f.a(r9), this.j, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    public a g(Object r9) {
        if (r9 != this.f12958c) goto L6;
        return this;
    L6:
        return new a(this.f, this.j, this.g, r9, this.f12959d, this.f12960e);
    }

    public a h(Object r9) {
        if (r9 != this.f.D()) goto L6;
        return this;
    L6:
        return new a(this.f.c(r9), this.j, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    public a H() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new a(this.f.d(), this.j, this.g, this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean v() {
        return this.f.v();
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
    public StringBuilder a(StringBuilder r2) {
        r2.append('[');
        return this.f.a(r2);
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder b(StringBuilder r2) {
        r2.append('[');
        return this.f.b(r2);
    }

    public Object[] f_() {
        return (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(this.g, Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public String toString() {
        return "[array type, component type: " + this.f + "]";
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
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        return this.f.equals(r5.f);
    }
}
