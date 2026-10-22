package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: AnnotatedParameter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final o f12642a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f12644e;

    @Override // com.fasterxml.jackson.databind.e.b
    public AnnotatedElement a() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String b() {
        return "";
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public /* synthetic */ b b(q r1) {
        return a(r1);
    }

    public n(o r3, com.fasterxml.jackson.databind.k r4, ag r5, q r6, int r7) {
        super((ag) ZeusTransformUtils.wrapperContextForParams(r5, ag.class, "com.obric.aiagent.plugin"), r6);
        this.f12642a = r3;
        this.f12643d = r4;
        this.f12644e = r7;
    }

    public n a(q r2) {
        if (r2 != this.f12633c) goto L6;
        return this;
    L6:
        return this.f12642a.a(this.f12644e, r2);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public Class<?> c() {
        return this.f12643d.e();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12643d;
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Class<?> f() {
        return this.f12642a.f();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Member g() {
        return this.f12642a.g();
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public void a(Object r2, Object r3) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + f().getName());
    }

    @Override // com.fasterxml.jackson.databind.e.j
    public Object b(Object r3) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + f().getName());
    }

    public o d() {
        return this.f12642a;
    }

    public int e() {
        return this.f12644e;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public int hashCode() {
        return this.f12642a.hashCode() + this.f12644e;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r5, getClass()) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (r6.f12642a.equals(this.f12642a) == false) goto L14;
        if (r6.f12644e != this.f12644e) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String toString() {
        return "[parameter #" + e() + ", annotations: " + this.f12633c + "]";
    }
}
