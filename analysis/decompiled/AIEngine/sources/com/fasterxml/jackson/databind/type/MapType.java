package com.fasterxml.jackson.databind.type;

import b3.c;
import b3.g;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MapType extends MapLikeType {
    public MapType() {
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new MapType(cls, typeBindings, javaType, javaTypeArr, this.f4441m, this.f4442n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType G(JavaType javaType) {
        if (this.f4442n == javaType) {
            return this;
        }
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, javaType, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType H(Object obj) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.L(obj), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType I(c cVar) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.M(cVar), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType L(Object obj) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType M(Object obj) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    /* renamed from: P */
    public final MapLikeType H(Object obj) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.L(obj), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    /* renamed from: Q */
    public final MapLikeType I(c cVar) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n.M(cVar), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    public final MapLikeType R(JavaType javaType) {
        if (javaType == this.f4441m) {
            return this;
        }
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType, this.f4442n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    public final MapLikeType S(g gVar) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m.M(gVar), this.f4442n, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    /* renamed from: U */
    public final MapLikeType L(Object obj) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    /* renamed from: V */
    public final MapLikeType M(Object obj) {
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m, this.f4442n, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final MapType K() {
        if (this.f3694e) {
            return this;
        }
        return new MapType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4441m.K(), this.f4442n.K(), this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.type.MapLikeType, com.fasterxml.jackson.databind.JavaType
    public final String toString() {
        return "[map type; class " + this.f3690a.getName() + ", " + this.f4441m + " -> " + this.f4442n + "]";
    }
}
