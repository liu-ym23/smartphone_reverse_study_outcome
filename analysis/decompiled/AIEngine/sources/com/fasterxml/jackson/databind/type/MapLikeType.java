package com.fasterxml.jackson.databind.type;

import b3.c;
import b3.g;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MapLikeType extends TypeBase {

    /* renamed from: m, reason: collision with root package name */
    public final JavaType f4441m;

    /* renamed from: n, reason: collision with root package name */
    public final JavaType f4442n;

    public MapLikeType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2.f3691b ^ javaType3.f3691b, obj, obj2, z);
        this.f4441m = javaType2;
        this.f4442n = javaType3;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean B() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new MapLikeType(cls, typeBindings, javaType, javaTypeArr, this.f4441m, this.f4442n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType G(JavaType javaType) {
        if (this.f4442n == javaType) {
            return this;
        }
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, javaType, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType J(JavaType javaType) {
        JavaType javaType2;
        JavaType javaTypeJ;
        JavaType javaType3;
        JavaType javaTypeJ2;
        JavaType javaTypeJ3 = super.J(javaType);
        JavaType javaTypeO = javaType.o();
        if ((javaTypeJ3 instanceof MapLikeType) && javaTypeO != null && (javaTypeJ2 = (javaType3 = this.f4441m).J(javaTypeO)) != javaType3) {
            javaTypeJ3 = ((MapLikeType) javaTypeJ3).R(javaTypeJ2);
        }
        JavaType javaTypeK = javaType.k();
        return (javaTypeK == null || (javaTypeJ = (javaType2 = this.f4442n).J(javaTypeK)) == javaType2) ? javaTypeJ3 : javaTypeJ3.G(javaTypeJ);
    }

    @Override // com.fasterxml.jackson.databind.type.TypeBase
    public final String O() {
        StringBuilder sb2 = new StringBuilder();
        Class<?> cls = this.f3690a;
        sb2.append(cls.getName());
        JavaType javaType = this.f4441m;
        if (javaType != null && cls.getTypeParameters().length == 2) {
            sb2.append('<');
            sb2.append(javaType.e());
            sb2.append(',');
            sb2.append(this.f4442n.e());
            sb2.append('>');
        }
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public MapLikeType H(Object obj) {
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.L(obj), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public MapLikeType I(c cVar) {
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.M(cVar), this.f3692c, this.f3693d, this.f3694e);
    }

    public MapLikeType R(JavaType javaType) {
        if (javaType == this.f4441m) {
            return this;
        }
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType, this.f4442n, this.f3692c, this.f3693d, this.f3694e);
    }

    public MapLikeType S(g gVar) {
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m.M(gVar), this.f4442n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public MapLikeType K() {
        if (this.f3694e) {
            return this;
        }
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.K(), this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public MapLikeType L(Object obj) {
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public MapLikeType M(Object obj) {
        return new MapLikeType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MapLikeType mapLikeType = (MapLikeType) obj;
        return this.f3690a == mapLikeType.f3690a && this.f4441m.equals(mapLikeType.f4441m) && this.f4442n.equals(mapLikeType.f4442n);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType k() {
        return this.f4442n;
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
        this.f4441m.m(sb2);
        this.f4442n.m(sb2);
        sb2.append(">;");
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType o() {
        return this.f4441m;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean t() {
        return super.t() || this.f4442n.t() || this.f4441m.t();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", this.f3690a.getName(), this.f4441m, this.f4442n);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean y() {
        return true;
    }
}
