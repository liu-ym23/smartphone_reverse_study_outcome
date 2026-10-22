package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AnnotatedParameter extends AnnotatedMember {

    /* renamed from: c, reason: collision with root package name */
    public final AnnotatedWithParams f4129c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f4130d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4131e;

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, JavaType javaType, i iVar, i3.c cVar, int i10) {
        super(iVar, cVar);
        this.f4129c = annotatedWithParams;
        this.f4130d = javaType;
        this.f4131e = i10;
    }

    @Override // i3.a
    public final AnnotatedElement b() {
        return null;
    }

    @Override // i3.a
    public final String d() {
        return "";
    }

    @Override // i3.a
    public final Class<?> e() {
        return this.f4130d.f3690a;
    }

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!com.fasterxml.jackson.databind.util.a.s(AnnotatedParameter.class, obj)) {
            return false;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) obj;
        return annotatedParameter.f4129c.equals(this.f4129c) && annotatedParameter.f4131e == this.f4131e;
    }

    @Override // i3.a
    public final JavaType f() {
        return this.f4130d;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Class<?> h() {
        return this.f4129c.h();
    }

    @Override // i3.a
    public final int hashCode() {
        return this.f4129c.hashCode() + this.f4131e;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Member j() {
        return this.f4129c.j();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Object k(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of ".concat(this.f4129c.h().getName()));
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final i3.a n(i3.c cVar) {
        if (cVar == this.f4123b) {
            return this;
        }
        AnnotatedWithParams annotatedWithParams = this.f4129c;
        i3.c[] cVarArr = annotatedWithParams.f4132c;
        int i10 = this.f4131e;
        cVarArr[i10] = cVar;
        return annotatedWithParams.r(i10);
    }

    @Override // i3.a
    public final String toString() {
        return "[parameter #" + this.f4131e + ", annotations: " + this.f4123b + "]";
    }
}
