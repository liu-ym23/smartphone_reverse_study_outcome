package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: AnnotatedMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final transient Method f12634a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Class<?>[] f12635d;

    @Override // com.fasterxml.jackson.databind.e.b
    public /* synthetic */ AnnotatedElement a() {
        return d();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public /* synthetic */ b b(q r1) {
        return a(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public /* synthetic */ Member g() {
        return h();
    }

    public k(ag r3, Method r4, q r5, q[] r6) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"), r5, r6);
        if (r4 == null) goto L7;
        this.f12634a = r4;
        return;
    L7:
        throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
    }

    public k a(q r4) {
        return new k(this.f12632b, this.f12634a, r4, this.f12645e);
    }

    public Method d() {
        return this.f12634a;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String b() {
        return this.f12634a.getName();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12632b.a(this.f12634a.getGenericReturnType());
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public Class<?> c() {
        return this.f12634a.getReturnType();
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public final Object call() {
        return this.f12634a.invoke(null, new Object[0]);
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public final Object call(Object[] r2) {
        return this.f12634a.invoke(null, r2);
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public final Object a(Object r3) {
        return this.f12634a.invoke(null, new Object[]{r3});
    }

    public final Object a(Object r1, Object... r2) {
        return this.f12634a.invoke(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public int e() {
        return k().length;
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public Class<?> a(int r2) {
        Class<?>[] r1 = k();
        if (r2 < r1.length) goto L6;
        return null;
    L6:
        return r1[r2];
    }

    @Override // com.fasterxml.jackson.databind.e.o
    public com.fasterxml.jackson.databind.k b(int r3) {
        Type[] r0 = this.f12634a.getGenericParameterTypes();
        if (r3 < r0.length) goto L7;
        return null;
    L7:
        return this.f12632b.a(r0[r3]);
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Class<?> f() {
        return this.f12634a.getDeclaringClass();
    }

    public Method h() {
        return this.f12634a;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public void a(Object r4, Object r5) {
        this.f12634a.invoke(r4, new Object[]{r5});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Failed to setValue() with method " + i() + ": " + com.fasterxml.jackson.databind.l.h.h(e), e);
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Object b(Object r5) {
        return this.f12634a.invoke(r5, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Failed to getValue() with method " + i() + ": " + com.fasterxml.jackson.databind.l.h.h(e), e);
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public String i() {
        String r0 = super.i();
        int r1 = e();
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        return String.format("%s(%d params)", new Object[]{super.i(), Integer.valueOf(e())});
    L9:
        return r0 + "(" + a(0).getName() + ")";
    L11:
        return r0 + "()";
    }

    public Class<?>[] k() {
        if (this.f12635d != null) goto L6;
        this.f12635d = this.f12634a.getParameterTypes();
    L6:
        return this.f12635d;
    }

    public Class<?> l() {
        return this.f12634a.getReturnType();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String toString() {
        return "[method " + i() + "]";
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public int hashCode() {
        return this.f12634a.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r5, getClass()) == true) goto L8;
        return false;
    L8:
        Method r6 = ((k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin")).f12634a;
        if (r6 != null) goto L16;
        if (this.f12634a != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r6.equals(this.f12634a);
    }
}
