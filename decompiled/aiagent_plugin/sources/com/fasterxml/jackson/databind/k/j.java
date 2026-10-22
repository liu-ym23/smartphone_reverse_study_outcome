package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: ReferenceType.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends l {
    protected final com.fasterxml.jackson.databind.k f;
    protected final com.fasterxml.jackson.databind.k g;

    @Override // com.fasterxml.jackson.a.g.a
    public boolean a() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public boolean f() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.k.l
    public /* synthetic */ l J() {
        return H();
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k a(Object r1) {
        return e(r1);
    }

    @Override // com.fasterxml.jackson.databind.k, com.fasterxml.jackson.a.g.a
    public /* synthetic */ com.fasterxml.jackson.a.g.a b() {
        return y();
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k b(Object r1) {
        return f(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k c(Object r1) {
        return g(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d() {
        return H();
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public /* synthetic */ com.fasterxml.jackson.databind.k d(Object r1) {
        return h(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.l
    public /* synthetic */ l i(Object r1) {
        return h(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.l
    public /* synthetic */ l j(Object r1) {
        return g(r1);
    }

    @Override // com.fasterxml.jackson.databind.k.l
    public /* synthetic */ l k(Object r1) {
        return e(r1);
    }

    public j(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14, com.fasterxml.jackson.databind.k r15, com.fasterxml.jackson.databind.k r16, Object r17, Object r18, boolean r19) {
        super(r11, r12, r13, r14, Objects.hashCode(r15), r17, r18, r19);
        this.f = r15;
        if (r16 != null) goto L5;
        com.fasterxml.jackson.databind.k r0 = this;
    L6:
        this.g = r0;
        return;
    L5:
        r0 = r16;
        goto L6
    }

    public static j a(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14, com.fasterxml.jackson.databind.k r15) {
        return new j(r11, r12, r13, r14, r15, null, null, null, false);
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r12) {
        if (this.f != r12) goto L6;
        return this;
    L6:
        return new j(this.f12956a, this.j, this.h, this.i, r12, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    public j e(Object r12) {
        if (r12 != this.f12959d) goto L6;
        return this;
    L6:
        return new j(this.f12956a, this.j, this.h, this.i, this.f, this.g, this.f12958c, r12, this.f12960e);
    }

    public j f(Object r12) {
        if (r12 != this.f.E()) goto L6;
        return this;
    L6:
        return new j(this.f12956a, this.j, this.h, this.i, this.f.a(r12), this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    public j g(Object r12) {
        if (r12 != this.f12958c) goto L6;
        return this;
    L6:
        return new j(this.f12956a, this.j, this.h, this.i, this.f, this.g, r12, this.f12959d, this.f12960e);
    }

    public j h(Object r12) {
        if (r12 != this.f.D()) goto L5;
        return this;
    L5:
        com.fasterxml.jackson.databind.k r6 = this.f.c(r12);
        return new j(this.f12956a, this.j, this.h, this.i, r6, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    public j H() {
        if (this.f12960e == false) goto L6;
        return this;
    L6:
        return new j(this.f12956a, this.j, this.h, this.i, this.f.d(), this.g, this.f12958c, this.f12959d, true);
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r11, n r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.k[] r14) {
        return new j(r11, this.j, r13, r14, this.f, this.g, this.f12958c, this.f12959d, this.f12960e);
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k.m
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
    public com.fasterxml.jackson.databind.k x() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k y() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public StringBuilder b(StringBuilder r2) {
        return a(this.f12956a, r2, true);
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public StringBuilder a(StringBuilder r3) {
        a(this.f12956a, r3, false);
        r3.append('<');
        StringBuilder r2 = this.f.a(r3);
        r2.append(">;");
        return r2;
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
    public String toString() {
        return new StringBuilder(40).append("[reference type, class ").append(I()).append('<').append(this.f).append('>').append(']').toString();
    }

    @Override // com.fasterxml.jackson.databind.k.l, com.fasterxml.jackson.databind.k
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
        j r5 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin");
        if (r5.f12956a == this.f12956a) goto L15;
        return false;
    L15:
        return this.f.equals(r5.f);
    }
}
