package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public final transient Method f4124d;

    /* renamed from: e, reason: collision with root package name */
    public Class<?>[] f4125e;
    public final Serialization h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Serialization implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public Class<?> f4126a;

        /* renamed from: b, reason: collision with root package name */
        public String f4127b;

        /* renamed from: c, reason: collision with root package name */
        public Class<?>[] f4128c;
    }

    public AnnotatedMethod(i iVar, Method method, i3.c cVar, i3.c[] cVarArr) {
        super(iVar, cVar, cVarArr);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.f4124d = method;
    }

    @Override // i3.a
    public final AnnotatedElement b() {
        return this.f4124d;
    }

    @Override // i3.a
    public final String d() {
        return this.f4124d.getName();
    }

    @Override // i3.a
    public final Class<?> e() {
        return this.f4124d.getReturnType();
    }

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return com.fasterxml.jackson.databind.util.a.s(AnnotatedMethod.class, obj) && ((AnnotatedMethod) obj).f4124d == this.f4124d;
    }

    @Override // i3.a
    public final JavaType f() {
        return this.f4122a.a(this.f4124d.getGenericReturnType());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Class<?> h() {
        return this.f4124d.getDeclaringClass();
    }

    @Override // i3.a
    public final int hashCode() {
        return this.f4124d.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final String i() {
        String strI = super.i();
        int length = v().length;
        if (length == 0) {
            return a0.a.j(strI, "()");
        }
        if (length != 1) {
            return String.format("%s(%d params)", super.i(), Integer.valueOf(v().length));
        }
        StringBuilder sbP = a0.a.p(strI, "(");
        sbP.append(u(0).getName());
        sbP.append(")");
        return sbP.toString();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Member j() {
        return this.f4124d;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final Object k(Object obj) {
        try {
            return this.f4124d.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new IllegalArgumentException("Failed to getValue() with method " + this.i() + ": " + e10.getMessage(), e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public final i3.a n(i3.c cVar) {
        return new AnnotatedMethod(this.f4122a, this.f4124d, cVar, this.f4132c);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object o() {
        return this.f4124d.invoke(null, null);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object p(Object[] objArr) {
        return this.f4124d.invoke(null, objArr);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object q(Object obj) {
        return this.f4124d.invoke(null, obj);
    }

    public Object readResolve() throws NoSuchMethodException, SecurityException {
        Serialization serialization = this.h;
        Class<?> cls = serialization.f4126a;
        try {
            Method declaredMethod = cls.getDeclaredMethod(serialization.f4127b, serialization.f4128c);
            if (!declaredMethod.isAccessible()) {
                com.fasterxml.jackson.databind.util.a.e(declaredMethod, false);
            }
            return new AnnotatedMethod(null, declaredMethod, null, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find method '" + serialization.f4127b + "' from Class '" + cls.getName());
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final int s() {
        return v().length;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final JavaType t(int i10) {
        Type[] genericParameterTypes = this.f4124d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f4122a.a(genericParameterTypes[i10]);
    }

    @Override // i3.a
    public final String toString() {
        return "[method " + i() + "]";
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Class<?> u(int i10) {
        Class<?>[] clsArrV = v();
        if (clsArrV.length <= 0) {
            return null;
        }
        return clsArrV[0];
    }

    public final Class<?>[] v() {
        if (this.f4125e == null) {
            this.f4125e = this.f4124d.getParameterTypes();
        }
        return this.f4125e;
    }

    public Object writeReplace() {
        Serialization serialization = new Serialization();
        Method method = this.f4124d;
        serialization.f4126a = method.getDeclaringClass();
        serialization.f4127b = method.getName();
        serialization.f4128c = method.getParameterTypes();
        return new AnnotatedMethod(serialization);
    }

    public AnnotatedMethod(Serialization serialization) {
        super(null, null, null);
        this.f4124d = null;
        this.h = serialization;
    }
}
