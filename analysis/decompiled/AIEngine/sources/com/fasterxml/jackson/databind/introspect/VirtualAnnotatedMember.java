package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Class<?> f4166c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f4167d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4168e;

    public VirtualAnnotatedMember(a aVar, Class cls, String str, JavaType javaType) {
        super(aVar, null);
        this.f4166c = cls;
        this.f4167d = javaType;
        this.f4168e = str;
    }

    @Override // i3.a
    public final /* bridge */ /* synthetic */ AnnotatedElement b() {
        return null;
    }

    @Override // i3.a
    public final String d() {
        return this.f4168e;
    }

    @Override // i3.a
    public final Class<?> e() {
        return this.f4167d.f3690a;
    }

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!com.fasterxml.jackson.databind.util.a.s(getClass(), obj)) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        return virtualAnnotatedMember.f4166c == this.f4166c && virtualAnnotatedMember.f4168e.equals(this.f4168e);
    }

    @Override // i3.a
    public final JavaType f() {
        return this.f4167d;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Class<?> h() {
        return this.f4166c;
    }

    @Override // i3.a
    public final int hashCode() {
        return this.f4168e.hashCode();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Member j() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Object k(Object obj) {
        throw new IllegalArgumentException(ai.onnxruntime.a.o(new StringBuilder("Cannot get virtual property '"), this.f4168e, "'"));
    }

    @Override // i3.a
    public final String toString() {
        return "[virtual " + i() + "]";
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final i3.a n(i3.c cVar) {
        return this;
    }
}
