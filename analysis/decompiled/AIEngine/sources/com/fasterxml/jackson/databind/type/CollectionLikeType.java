package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CollectionLikeType extends TypeBase {

    /* renamed from: m, reason: collision with root package name */
    public final JavaType f4427m;

    public CollectionLikeType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2.f3691b, obj, obj2, z);
        this.f4427m = javaType2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new CollectionLikeType(cls, typeBindings, javaType, javaTypeArr, this.f4427m, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType G(JavaType javaType) {
        if (this.f4427m == javaType) {
            return this;
        }
        return new CollectionLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType J(JavaType javaType) {
        JavaType javaType2;
        JavaType javaTypeJ;
        JavaType javaTypeJ2 = super.J(javaType);
        JavaType javaTypeK = javaType.k();
        return (javaTypeK == null || (javaTypeJ = (javaType2 = this.f4427m).J(javaTypeK)) == javaType2) ? javaTypeJ2 : javaTypeJ2.G(javaTypeJ);
    }

    @Override // com.fasterxml.jackson.databind.type.TypeBase
    public final String O() {
        StringBuilder sb2 = new StringBuilder();
        Class<?> cls = this.f3690a;
        sb2.append(cls.getName());
        JavaType javaType = this.f4427m;
        if (javaType != null && cls.getTypeParameters().length == 1) {
            sb2.append('<');
            sb2.append(javaType.e());
            sb2.append('>');
        }
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType H(Object obj) {
        return new CollectionLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.L(obj), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType I(c cVar) {
        return new CollectionLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.M(cVar), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType K() {
        if (this.f3694e) {
            return this;
        }
        return new CollectionLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.K(), this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType L(Object obj) {
        return new CollectionLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public CollectionLikeType M(Object obj) {
        return new CollectionLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        CollectionLikeType collectionLikeType = (CollectionLikeType) obj;
        return this.f3690a == collectionLikeType.f3690a && this.f4427m.equals(collectionLikeType.f4427m);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType k() {
        return this.f4427m;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder l(StringBuilder sb2) {
        TypeBase.N(this.f3690a, sb2, true);
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder m(StringBuilder sb2) {
        TypeBase.N(this.f3690a, sb2, false);
        sb2.append('<');
        this.f4427m.m(sb2);
        sb2.append(">;");
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean t() {
        return super.t() || this.f4427m.t();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public String toString() {
        return "[collection-like type; class " + this.f3690a.getName() + ", contains " + this.f4427m + "]";
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean w() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean y() {
        return true;
    }
}
