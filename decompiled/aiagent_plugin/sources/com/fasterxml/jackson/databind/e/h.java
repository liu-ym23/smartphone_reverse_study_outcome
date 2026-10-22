package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: AnnotatedField.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final transient Field f12626a;

    @Override // com.fasterxml.jackson.databind.e.b
    public /* synthetic */ AnnotatedElement a() {
        return d();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public /* synthetic */ b b(q r1) {
        return a(r1);
    }

    public h(ag r3, Field r4, q r5) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"), r5);
        this.f12626a = r4;
    }

    public h a(q r3) {
        return new h(this.f12632b, this.f12626a, r3);
    }

    public Field d() {
        return this.f12626a;
    }

    public int e() {
        return this.f12626a.getModifiers();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String b() {
        return this.f12626a.getName();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public Class<?> c() {
        return this.f12626a.getType();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12632b.a(this.f12626a.getGenericType());
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Class<?> f() {
        return this.f12626a.getDeclaringClass();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Member g() {
        return this.f12626a;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public void a(Object r3, Object r4) {
        this.f12626a.set(r3, r4);     // Catch: IllegalAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Failed to setValue() for field " + i() + ": " + e.getMessage(), e);
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Object b(Object r4) {
        return this.f12626a.get(r4);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Failed to getValue() for field " + i() + ": " + e.getMessage(), e);
    }

    public boolean h() {
        return Modifier.isTransient(e());
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public int hashCode() {
        return this.f12626a.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r5, getClass()) == true) goto L8;
        return false;
    L8:
        Field r6 = ((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).f12626a;
        if (r6 != null) goto L16;
        if (this.f12626a != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r6.equals(this.f12626a);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String toString() {
        return "[field " + i() + "]";
    }
}
