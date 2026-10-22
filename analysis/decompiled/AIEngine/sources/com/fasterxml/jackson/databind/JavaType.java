package com.fasterxml.jackson.databind;

import b3.c;
import com.fasterxml.jackson.core.type.a;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class JavaType extends a implements Serializable, Type {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f3690a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3691b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3692c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3693d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3694e;

    public JavaType(Class<?> cls, int i10, Object obj, Object obj2, boolean z) {
        this.f3690a = cls;
        this.f3691b = cls.getName().hashCode() + i10;
        this.f3692c = obj;
        this.f3693d = obj2;
        this.f3694e = z;
    }

    public final boolean A() {
        return this.f3690a == Object.class;
    }

    public boolean B() {
        return false;
    }

    public final boolean C() {
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        Class<? super Object> superclass = this.f3690a.getSuperclass();
        return superclass != null && "com.android.tools.r8.RecordTag".equals(superclass.getName());
    }

    public final boolean D(Class<?> cls) {
        Class<?> cls2 = this.f3690a;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    public final boolean E(Class<?> cls) {
        Class<?> cls2 = this.f3690a;
        return cls2 == cls || cls2.isAssignableFrom(cls);
    }

    public abstract JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr);

    public abstract JavaType G(JavaType javaType);

    public abstract JavaType H(Object obj);

    public abstract JavaType I(c cVar);

    public JavaType J(JavaType javaType) {
        Object obj = javaType.f3693d;
        JavaType javaTypeL = obj != this.f3693d ? L(obj) : this;
        Object obj2 = javaType.f3692c;
        return obj2 != this.f3692c ? javaTypeL.M(obj2) : javaTypeL;
    }

    public abstract JavaType K();

    public abstract JavaType L(Object obj);

    public abstract JavaType M(Object obj);

    public abstract boolean equals(Object obj);

    public abstract JavaType f(int i10);

    public abstract int g();

    public final JavaType h(int i10) {
        JavaType javaTypeF = f(i10);
        return javaTypeF == null ? TypeFactory.n() : javaTypeF;
    }

    public final int hashCode() {
        return this.f3691b;
    }

    public abstract JavaType i(Class<?> cls);

    public abstract TypeBindings j();

    public JavaType k() {
        return null;
    }

    public abstract StringBuilder l(StringBuilder sb2);

    public abstract StringBuilder m(StringBuilder sb2);

    public abstract List<JavaType> n();

    public JavaType o() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.type.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public JavaType c() {
        return null;
    }

    public abstract JavaType q();

    public boolean r() {
        return true;
    }

    public boolean s() {
        return g() > 0;
    }

    public boolean t() {
        return (this.f3693d == null && this.f3692c == null) ? false : true;
    }

    public abstract String toString();

    public final boolean u(Class<?> cls) {
        return this.f3690a == cls;
    }

    public boolean v() {
        return Modifier.isAbstract(this.f3690a.getModifiers());
    }

    public boolean w() {
        return false;
    }

    public boolean x() {
        Class<?> cls = this.f3690a;
        if ((cls.getModifiers() & 1536) == 0) {
            return true;
        }
        return cls.isPrimitive();
    }

    public abstract boolean y();

    public final boolean z() {
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        return Enum.class.isAssignableFrom(this.f3690a);
    }
}
