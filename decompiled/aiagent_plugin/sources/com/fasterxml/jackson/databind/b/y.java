package com.fasterxml.jackson.databind.b;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: ValueInstantiator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class y {

    /* JADX INFO: compiled from: ValueInstantiator.java */
    public static class a extends y implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Class<?> f12546a;

        public a(Class<?> r1) {
            this.f12546a = r1;
        }

        public a(com.fasterxml.jackson.databind.k r1) {
            this.f12546a = r1.e();
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public String b() {
            return this.f12546a.getName();
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public Class<?> a() {
            return this.f12546a;
        }
    }

    public y a(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.c r2) {
        return this;
    }

    public v[] a(com.fasterxml.jackson.databind.g r1) {
        return null;
    }

    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.g r1) {
        return null;
    }

    public com.fasterxml.jackson.databind.k c(com.fasterxml.jackson.databind.g r1) {
        return null;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public com.fasterxml.jackson.databind.e.o o() {
        return null;
    }

    public com.fasterxml.jackson.databind.e.o p() {
        return null;
    }

    public com.fasterxml.jackson.databind.e.o q() {
        return null;
    }

    public y() {
    }

    public Class<?> a() {
        return Object.class;
    }

    public String b() {
        Class<?> r0 = a();
        if (r0 != null) goto L7;
        return "UNKNOWN";
    L7:
        return r0.getName();
    }

    public boolean c() {
        if (k() == false) goto L5;
    L22:
        return true;
    L5:
        if (l() == true) goto L22;
        if (m() == true) goto L22;
        if (n() == true) goto L22;
        if (d() == true) goto L22;
        if (e() == true) goto L22;
        if (f() == true) goto L22;
        if (h() == true) goto L22;
        if (j() == true) goto L22;
        return false;
    }

    public boolean k() {
        if (o() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Object a(com.fasterxml.jackson.databind.h r7) {
        return r7.a(a(), this, null, "no default no-arguments constructor found", new Object[0]);
    }

    public Object a(com.fasterxml.jackson.databind.h r7, Object[] r8) {
        return r7.a(a(), this, null, "no creator with arguments specified", new Object[0]);
    }

    public Object a(com.fasterxml.jackson.databind.h r1, v[] r2, com.fasterxml.jackson.databind.b.a.y r3) {
        return a(r1, r3.a(r2));
    }

    public Object a(com.fasterxml.jackson.databind.h r7, Object r8) {
        return r7.a(a(), this, null, "no delegate creator specified", new Object[0]);
    }

    public Object b(com.fasterxml.jackson.databind.h r7, Object r8) {
        return r7.a(a(), this, null, "no array delegate creator specified", new Object[0]);
    }

    public Object a(com.fasterxml.jackson.databind.h r7, String r8) {
        return r7.a(a(), this, r7.j(), "no String-argument constructor/factory method to deserialize from String value ('%s')", new Object[]{r8});
    }

    public Object a(com.fasterxml.jackson.databind.h r7, int r8) {
        return r7.a(a(), this, null, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", new Object[]{Integer.valueOf(r8)});
    }

    public Object a(com.fasterxml.jackson.databind.h r7, long r8) {
        return r7.a(a(), this, null, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", new Object[]{Long.valueOf(r8)});
    }

    public Object a(com.fasterxml.jackson.databind.h r7, BigInteger r8) {
        return r7.a(a(), this, null, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", new Object[]{r8});
    }

    public Object a(com.fasterxml.jackson.databind.h r7, double r8) {
        return r7.a(a(), this, null, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", new Object[]{Double.valueOf(r8)});
    }

    public Object a(com.fasterxml.jackson.databind.h r7, BigDecimal r8) {
        return r7.a(a(), this, null, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", new Object[]{r8});
    }

    public Object a(com.fasterxml.jackson.databind.h r7, boolean r8) {
        return r7.a(a(), this, null, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", new Object[]{Boolean.valueOf(r8)});
    }
}
