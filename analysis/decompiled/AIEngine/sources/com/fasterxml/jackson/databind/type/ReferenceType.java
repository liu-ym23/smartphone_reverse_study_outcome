package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ReferenceType extends SimpleType {

    /* renamed from: m, reason: collision with root package name */
    public final JavaType f4445m;

    /* renamed from: n, reason: collision with root package name */
    public final JavaType f4446n;

    public ReferenceType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2.f3691b, obj, obj2, z);
        this.f4445m = javaType2;
        this.f4446n = javaType3 == null ? this : javaType3;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new ReferenceType(cls, this.f4450k, javaType, javaTypeArr, this.f4445m, this.f4446n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final JavaType G(JavaType javaType) {
        if (this.f4445m == javaType) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType, this.f4446n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final JavaType H(Object obj) {
        JavaType javaType = this.f4445m;
        if (obj == javaType.f3693d) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType.L(obj), this.f4446n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final JavaType L(Object obj) {
        if (obj == this.f3693d) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4445m, this.f4446n, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final JavaType M(Object obj) {
        if (obj == this.f3692c) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4445m, this.f4446n, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.type.TypeBase
    public final String O() {
        StringBuilder sb2 = new StringBuilder();
        Class<?> cls = this.f3690a;
        sb2.append(cls.getName());
        JavaType javaType = this.f4445m;
        if (javaType != null && cls.getTypeParameters().length == 1) {
            sb2.append('<');
            sb2.append(javaType.e());
            sb2.append('>');
        }
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType
    /* renamed from: S */
    public final SimpleType L(Object obj) {
        if (obj == this.f3693d) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4445m, this.f4446n, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType
    /* renamed from: T */
    public final SimpleType M(Object obj) {
        if (obj == this.f3692c) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4445m, this.f4446n, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ReferenceType I(c cVar) {
        JavaType javaType = this.f4445m;
        if (cVar == javaType.f3692c) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType.M(cVar), this.f4446n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final ReferenceType K() {
        if (this.f3694e) {
            return this;
        }
        return new ReferenceType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4445m.K(), this.f4446n, this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.core.type.a
    public final JavaType c() {
        return this.f4445m;
    }

    @Override // com.fasterxml.jackson.core.type.a
    public final boolean d() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        ReferenceType referenceType = (ReferenceType) obj;
        if (referenceType.f3690a != this.f3690a) {
            return false;
        }
        return this.f4445m.equals(referenceType.f4445m);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType k() {
        return this.f4445m;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final StringBuilder l(StringBuilder sb2) {
        TypeBase.N(this.f3690a, sb2, true);
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final StringBuilder m(StringBuilder sb2) {
        TypeBase.N(this.f3690a, sb2, false);
        sb2.append('<');
        StringBuilder sbM = this.f4445m.m(sb2);
        sbM.append(">;");
        return sbM;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: p */
    public final JavaType c() {
        return this.f4445m;
    }

    @Override // com.fasterxml.jackson.databind.type.SimpleType, com.fasterxml.jackson.databind.JavaType
    public final String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[reference type, class ");
        sb2.append(O());
        sb2.append('<');
        sb2.append(this.f4445m);
        sb2.append(">]");
        return sb2.toString();
    }
}
