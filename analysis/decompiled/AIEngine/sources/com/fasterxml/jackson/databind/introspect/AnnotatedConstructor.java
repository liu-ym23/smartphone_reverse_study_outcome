package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AnnotatedConstructor extends AnnotatedWithParams {

    /* renamed from: d, reason: collision with root package name */
    public final Constructor<?> f4114d;

    /* renamed from: e, reason: collision with root package name */
    public final Serialization f4115e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Serialization implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public Class<?> f4116a;

        /* renamed from: b, reason: collision with root package name */
        public Class<?>[] f4117b;
    }

    public AnnotatedConstructor(i iVar, Constructor<?> constructor, i3.c cVar, i3.c[] cVarArr) {
        super(iVar, cVar, cVarArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this.f4114d = constructor;
    }

    @Override // i3.a
    public final AnnotatedElement b() {
        return this.f4114d;
    }

    @Override // i3.a
    public final String d() {
        return this.f4114d.getName();
    }

    @Override // i3.a
    public final Class<?> e() {
        return this.f4114d.getDeclaringClass();
    }

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return com.fasterxml.jackson.databind.util.a.s(AnnotatedConstructor.class, obj) && ((AnnotatedConstructor) obj).f4114d == this.f4114d;
    }

    @Override // i3.a
    public final JavaType f() {
        return this.f4122a.a(this.f4114d.getDeclaringClass());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Class<?> h() {
        return this.f4114d.getDeclaringClass();
    }

    @Override // i3.a
    public final int hashCode() {
        return this.f4114d.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Member j() {
        return this.f4114d;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Object k(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of ".concat(this.f4114d.getDeclaringClass().getName()));
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final i3.a n(i3.c cVar) {
        return new AnnotatedConstructor(this.f4122a, this.f4114d, cVar, this.f4132c);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object o() {
        return this.f4114d.newInstance(null);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object p(Object[] objArr) {
        return this.f4114d.newInstance(objArr);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object q(Object obj) {
        return this.f4114d.newInstance(obj);
    }

    public Object readResolve() throws NoSuchMethodException, SecurityException {
        Serialization serialization = this.f4115e;
        Class<?> cls = serialization.f4116a;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(serialization.f4117b);
            if (!declaredConstructor.isAccessible()) {
                com.fasterxml.jackson.databind.util.a.e(declaredConstructor, false);
            }
            return new AnnotatedConstructor(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find constructor with " + serialization.f4117b.length + " args from Class '" + cls.getName());
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final int s() {
        return this.f4114d.getParameterTypes().length;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final JavaType t(int i10) {
        Type[] genericParameterTypes = this.f4114d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f4122a.a(genericParameterTypes[i10]);
    }

    @Override // i3.a
    public final String toString() {
        Constructor<?> constructor = this.f4114d;
        int length = constructor.getParameterTypes().length;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", com.fasterxml.jackson.databind.util.a.y(constructor.getDeclaringClass()), Integer.valueOf(length), length == 1 ? "" : "s", this.f4123b);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Class<?> u(int i10) {
        Class<?>[] parameterTypes = this.f4114d.getParameterTypes();
        if (i10 >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i10];
    }

    public Object writeReplace() {
        Serialization serialization = new Serialization();
        Constructor<?> constructor = this.f4114d;
        serialization.f4116a = constructor.getDeclaringClass();
        serialization.f4117b = constructor.getParameterTypes();
        return new AnnotatedConstructor(serialization);
    }

    public AnnotatedConstructor(Serialization serialization) {
        super(null, null, null);
        this.f4114d = null;
        this.f4115e = serialization;
    }
}
