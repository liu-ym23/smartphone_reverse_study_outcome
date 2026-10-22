package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AnnotatedField extends AnnotatedMember implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final transient Field f4118c;

    /* renamed from: d, reason: collision with root package name */
    public final Serialization f4119d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Serialization implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public Class<?> f4120a;

        /* renamed from: b, reason: collision with root package name */
        public String f4121b;
    }

    public AnnotatedField(i iVar, Field field, i3.c cVar) {
        super(iVar, cVar);
        this.f4118c = field;
    }

    @Override // i3.a
    public final AnnotatedElement b() {
        return this.f4118c;
    }

    @Override // i3.a
    public final String d() {
        return this.f4118c.getName();
    }

    @Override // i3.a
    public final Class<?> e() {
        return this.f4118c.getType();
    }

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return com.fasterxml.jackson.databind.util.a.s(AnnotatedField.class, obj) && ((AnnotatedField) obj).f4118c == this.f4118c;
    }

    @Override // i3.a
    public final JavaType f() {
        return this.f4122a.a(this.f4118c.getGenericType());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Class<?> h() {
        return this.f4118c.getDeclaringClass();
    }

    @Override // i3.a
    public final int hashCode() {
        return this.f4118c.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Member j() {
        return this.f4118c;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Object k(Object obj) {
        try {
            return this.f4118c.get(obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Failed to getValue() for field " + this.i() + ": " + e10.getMessage(), e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final i3.a n(i3.c cVar) {
        return new AnnotatedField(this.f4122a, this.f4118c, cVar);
    }

    public Object readResolve() throws NoSuchFieldException {
        Serialization serialization = this.f4119d;
        Class<?> cls = serialization.f4120a;
        try {
            Field declaredField = cls.getDeclaredField(serialization.f4121b);
            if (!declaredField.isAccessible()) {
                com.fasterxml.jackson.databind.util.a.e(declaredField, false);
            }
            return new AnnotatedField(null, declaredField, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find method '" + serialization.f4121b + "' from Class '" + cls.getName());
        }
    }

    @Override // i3.a
    public final String toString() {
        return "[field " + i() + "]";
    }

    public Object writeReplace() {
        Serialization serialization = new Serialization();
        Field field = this.f4118c;
        serialization.f4120a = field.getDeclaringClass();
        serialization.f4121b = field.getName();
        return new AnnotatedField(serialization);
    }

    public AnnotatedField(Serialization serialization) {
        super(null, null);
        this.f4118c = null;
        this.f4119d = serialization;
    }
}
