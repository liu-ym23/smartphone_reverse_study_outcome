package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: AnnotatedConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Constructor<?> f12623a;

    @Override // com.fasterxml.jackson.databind.e.b
    public /* synthetic */ AnnotatedElement a() {
        return d();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public /* synthetic */ b b(q r1) {
        return a(r1);
    }

    public f(ag r3, Constructor<?> r4, q r5, q[] r6) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"), r5, r6);
        if (r4 == null) goto L7;
        this.f12623a = r4;
        return;
    L7:
        throw new IllegalArgumentException("Null constructor not allowed");
    }

    public f a(q r4) {
        return new f(this.f12632b, this.f12623a, r4, this.f12645e);
    }

    public Constructor<?> d() {
        return this.f12623a;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String b() {
        return this.f12623a.getName();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12632b.a(c());
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public Class<?> c() {
        return this.f12623a.getDeclaringClass();
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public int e() {
        return this.f12623a.getParameterTypes().length;
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public Class<?> a(int r2) {
        Class<?>[] r1 = this.f12623a.getParameterTypes();
        if (r2 < r1.length) goto L6;
        return null;
    L6:
        return r1[r2];
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public com.fasterxml.jackson.databind.k b(int r3) {
        Type[] r0 = this.f12623a.getGenericParameterTypes();
        if (r3 < r0.length) goto L7;
        return null;
    L7:
        return this.f12632b.a(r0[r3]);
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public final Object call() {
        return this.f12623a.newInstance((Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public final Object call(Object[] r1) {
        return this.f12623a.newInstance(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public final Object a(Object r3) {
        return this.f12623a.newInstance(new Object[]{r3});
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Class<?> f() {
        return this.f12623a.getDeclaringClass();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Member g() {
        return this.f12623a;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public void a(Object r2, Object r3) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + f().getName());
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Object b(Object r3) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + f().getName());
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String toString() {
        int r0 = this.f12623a.getParameterTypes().length;
        Object[] r1 = new Object[4];
        r1[0] = com.fasterxml.jackson.databind.l.h.h(this.f12623a.getDeclaringClass());
        r1[1] = Integer.valueOf(r0);
        if (r0 != 1) goto L5;
        String r2 = "";
    L6:
        r1[2] = r2;
        r1[3] = this.f12633c;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", r1);
    L5:
        r2 = "s";
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public int hashCode() {
        return this.f12623a.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r5, getClass()) == true) goto L8;
        return false;
    L8:
        Constructor<?> r6 = ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f12623a;
        if (r6 != null) goto L16;
        if (this.f12623a != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r6.equals(this.f12623a);
    }
}
