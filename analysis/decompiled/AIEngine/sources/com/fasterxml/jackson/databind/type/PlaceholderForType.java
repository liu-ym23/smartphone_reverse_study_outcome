package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PlaceholderForType extends TypeBase {

    /* renamed from: m, reason: collision with root package name */
    public final int f4443m;

    /* renamed from: n, reason: collision with root package name */
    public JavaType f4444n;

    public PlaceholderForType(int i10) {
        super(Object.class, TypeBindings.f4452j, TypeFactory.n(), null, 1, null, null, false);
        this.f4443m = i10;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType G(JavaType javaType) {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType H(Object obj) {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType I(c cVar) {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType K() {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType L(Object obj) {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final JavaType M(Object obj) {
        P();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.type.TypeBase
    public final String O() {
        return toString();
    }

    public final void P() {
        throw new UnsupportedOperationException("Operation should not be attempted on ".concat(getClass().getName()));
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder l(StringBuilder sb2) {
        sb2.append('$');
        sb2.append(this.f4443m + 1);
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final StringBuilder m(StringBuilder sb2) {
        l(sb2);
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        l(sb2);
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean y() {
        return false;
    }
}
