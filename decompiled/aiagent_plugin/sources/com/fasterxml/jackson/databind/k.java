package com.fasterxml.jackson.databind;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: JavaType.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends com.fasterxml.jackson.a.g.a implements Serializable, Type {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f12956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f12957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Object f12958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Object f12959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12960e;

    public abstract com.fasterxml.jackson.databind.k.n A();

    public abstract k B();

    public abstract List<k> C();

    public abstract k a(int r1);

    public abstract k a(k r1);

    public abstract k a(Class<?> r1, com.fasterxml.jackson.databind.k.n r2, k r3, k[] r4);

    public abstract k a(Object r1);

    public abstract StringBuilder a(StringBuilder r1);

    public abstract k b(Object r1);

    public abstract StringBuilder b(StringBuilder r1);

    public abstract k c(Object r1);

    public abstract k d();

    public abstract k d(Class<?> r1);

    public abstract k d(Object r1);

    public abstract boolean equals(Object r1);

    public boolean f() {
        return true;
    }

    public boolean j() {
        return false;
    }

    public abstract boolean q();

    public boolean r() {
        return false;
    }

    public boolean s() {
        return false;
    }

    public abstract String toString();

    public k w() {
        return null;
    }

    public k x() {
        return null;
    }

    public k y() {
        return null;
    }

    public abstract int z();

    @Override // com.fasterxml.jackson.a.g.a
    public /* synthetic */ com.fasterxml.jackson.a.g.a b() {
        return y();
    }

    public k(Class<?> r1, int r2, Object r3, Object r4, boolean r5) {
        this.f12956a = r1;
        this.f12957b = r1.getName().hashCode() + r2;
        this.f12958c = r3;
        this.f12959d = r4;
        this.f12960e = r5;
    }

    public k b(k r3) {
        Object r0 = r3.E();
        if (r0 == this.f12959d) goto L5;
        k r1 = a(r0);
    L6:
        Object r4 = r3.D();
        if (r4 != this.f12958c) goto L9;
        return r1;
    L9:
        return r1.c(r4);
    L5:
        r1 = this;
        goto L6
    }

    public final Class<?> e() {
        return this.f12956a;
    }

    public final boolean a(Class<?> r1) {
        if (this.f12956a != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(Class<?> r1) {
        Class<?> r0 = this.f12956a;
        if (r0 != r1) goto L5;
    L8:
        return true;
    L5:
        if (r1.isAssignableFrom(r0) == true) goto L8;
        return false;
    }

    public final boolean c(Class<?> r1) {
        Class<?> r0 = this.f12956a;
        if (r0 != r1) goto L5;
    L8:
        return true;
    L5:
        if (r0.isAssignableFrom(r1) == true) goto L8;
        return false;
    }

    public boolean g() {
        return Modifier.isAbstract(this.f12956a.getModifiers());
    }

    public boolean h() {
        if ((this.f12956a.getModifiers() & 1536) != 0) goto L7;
        return true;
    L7:
        return this.f12956a.isPrimitive();
    }

    public boolean i() {
        return Throwable.class.isAssignableFrom(this.f12956a);
    }

    public final boolean k() {
        return com.fasterxml.jackson.databind.l.h.l(this.f12956a);
    }

    public final boolean l() {
        if (com.fasterxml.jackson.databind.l.h.l(this.f12956a) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f12956a == Enum.class) goto L7;
        return true;
    }

    public final boolean m() {
        return com.fasterxml.jackson.databind.l.h.f(this.f12956a);
    }

    public final boolean n() {
        return this.f12956a.isInterface();
    }

    public final boolean o() {
        return this.f12956a.isPrimitive();
    }

    public final boolean p() {
        return Modifier.isFinal(this.f12956a.getModifiers());
    }

    public final boolean t() {
        if (this.f12956a != Object.class) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean u() {
        return this.f12960e;
    }

    public boolean v() {
        if (z() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public k b(int r1) {
        k r0 = a(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.fasterxml.jackson.databind.k.o.c();
    }

    public <T> T D() {
        return (T) this.f12958c;
    }

    public <T> T E() {
        return (T) this.f12959d;
    }

    public boolean F() {
        if (this.f12959d == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f12958c != null) goto L8;
        return false;
    }

    public String G() {
        StringBuilder r0 = new StringBuilder(40);
        a(r0);
        return r0.toString();
    }

    public final int hashCode() {
        return this.f12957b;
    }
}
