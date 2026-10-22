package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ArrayType extends TypeBase {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f4421o = 0;

    /* renamed from: m, reason: collision with root package name */
    public final JavaType f4422m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f4423n;

    public ArrayType(JavaType javaType, TypeBindings typeBindings, Object obj, Object obj2, Object obj3, boolean z) {
        super(obj.getClass(), typeBindings, null, null, javaType.f3691b, obj2, obj3, z);
        this.f4422m = javaType;
        this.f4423n = obj;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType G(JavaType javaType) throws NegativeArraySizeException {
        return new ArrayType(javaType, this.f4450k, Array.newInstance(javaType.f3690a, 0), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType H(Object obj) {
        JavaType javaType = this.f4422m;
        if (obj == javaType.f3693d) {
            return this;
        }
        return new ArrayType(javaType.L(obj), this.f4450k, this.f4423n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType I(c cVar) {
        JavaType javaType = this.f4422m;
        if (cVar == javaType.f3692c) {
            return this;
        }
        return new ArrayType(javaType.M(cVar), this.f4450k, this.f4423n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType K() {
        if (this.f3694e) {
            return this;
        }
        return new ArrayType(this.f4422m.K(), this.f4450k, this.f4423n, this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType L(Object obj) {
        if (obj == this.f3693d) {
            return this;
        }
        return new ArrayType(this.f4422m, this.f4450k, this.f4423n, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType M(Object obj) {
        if (obj == this.f3692c) {
            return this;
        }
        return new ArrayType(this.f4422m, this.f4450k, this.f4423n, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == ArrayType.class) {
            return this.f4422m.equals(((ArrayType) obj).f4422m);
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType k() {
        return this.f4422m;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder l(StringBuilder sb2) {
        sb2.append('[');
        return this.f4422m.l(sb2);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder m(StringBuilder sb2) {
        sb2.append('[');
        return this.f4422m.m(sb2);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean s() {
        return this.f4422m.s();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean t() {
        return super.t() || this.f4422m.t();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final String toString() {
        return "[array type, component type: " + this.f4422m + "]";
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean v() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean x() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean y() {
        return true;
    }
}
