package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ResolvedRecursiveType extends TypeBase {

    /* renamed from: m, reason: collision with root package name */
    public JavaType f4447m;

    public ResolvedRecursiveType() {
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.fasterxml.jackson.databind.type.TypeBase, com.fasterxml.jackson.databind.JavaType
    public final TypeBindings j() {
        JavaType javaType = this.f4447m;
        return javaType != null ? javaType.j() : this.f4450k;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder l(StringBuilder sb2) {
        JavaType javaType = this.f4447m;
        return javaType != null ? javaType.l(sb2) : sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder m(StringBuilder sb2) {
        JavaType javaType = this.f4447m;
        if (javaType != null) {
            return javaType.l(sb2);
        }
        sb2.append("?");
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.type.TypeBase, com.fasterxml.jackson.databind.JavaType
    public final JavaType q() {
        JavaType javaType = this.f4447m;
        return javaType != null ? javaType.q() : this.h;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[recursive type; ");
        JavaType javaType = this.f4447m;
        if (javaType == null) {
            sb2.append("UNRESOLVED");
        } else {
            sb2.append(javaType.f3690a.getName());
        }
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean y() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType K() {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType G(JavaType javaType) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType H(Object obj) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType I(c cVar) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType L(Object obj) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType M(Object obj) {
        return this;
    }
}
