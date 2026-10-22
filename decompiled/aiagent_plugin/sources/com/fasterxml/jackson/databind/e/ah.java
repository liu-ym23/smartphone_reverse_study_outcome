package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: VirtualAnnotatedMember.java */
/* JADX INFO: loaded from: classes2.dex */
public class ah extends j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f12600a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f12602e;

    @Override // com.fasterxml.jackson.databind.e.j
    public b b(q r1) {
        return this;
    }

    public Field d() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Member g() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public /* synthetic */ AnnotatedElement a() {
        return d();
    }

    public ah(ag r3, Class<?> r4, String r5, com.fasterxml.jackson.databind.k r6) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"), null);
        this.f12600a = r4;
        this.f12601d = r6;
        this.f12602e = r5;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String b() {
        return this.f12602e;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public Class<?> c() {
        return this.f12601d.e();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12601d;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Class<?> f() {
        return this.f12600a;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public void a(Object r2, Object r3) {
        throw new IllegalArgumentException("Cannot set virtual property '" + this.f12602e + "'");
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Object b(Object r3) {
        throw new IllegalArgumentException("Cannot get virtual property '" + this.f12602e + "'");
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public int hashCode() {
        return this.f12602e.hashCode();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r5, getClass()) == true) goto L8;
        return false;
    L8:
        ah r6 = (ah) ZeusTransformUtils.preCheckCast(r5, ah.class, "com.obric.aiagent.plugin");
        if (r6.f12600a != this.f12600a) goto L14;
        if (r6.f12602e.equals(this.f12602e) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String toString() {
        return "[virtual " + i() + "]";
    }
}
