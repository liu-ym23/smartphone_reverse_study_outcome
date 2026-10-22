package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CollectionType extends CollectionLikeType {
    public CollectionType() {
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new CollectionType(cls, typeBindings, javaType, javaTypeArr, this.f4427m, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType G(JavaType javaType) {
        if (this.f4427m == javaType) {
            return this;
        }
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, javaType, this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType H(Object obj) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.L(obj), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType I(c cVar) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.M(cVar), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType L(Object obj) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final JavaType M(Object obj) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType
    /* renamed from: P */
    public final CollectionLikeType H(Object obj) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.L(obj), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType
    /* renamed from: Q */
    public final CollectionLikeType I(c cVar) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.M(cVar), this.f3692c, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType
    /* renamed from: S */
    public final CollectionLikeType L(Object obj) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType
    /* renamed from: T */
    public final CollectionLikeType M(Object obj) {
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final CollectionType K() {
        if (this.f3694e) {
            return this;
        }
        return new CollectionType(this.f3690a, this.f4450k, this.h, this.f4449j, this.f4427m.K(), this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.type.CollectionLikeType, com.fasterxml.jackson.databind.JavaType
    public final String toString() {
        return "[collection type; class " + this.f3690a.getName() + ", contains " + this.f4427m + "]";
    }
}
