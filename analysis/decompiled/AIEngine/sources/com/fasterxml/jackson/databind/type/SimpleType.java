package com.fasterxml.jackson.databind.type;

import b3.c;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SimpleType extends TypeBase {
    public SimpleType() {
        throw null;
    }

    public SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        super(cls, typeBindings, javaType, javaTypeArr, 0, null, null, false);
    }

    public static SimpleType P(Class<?> cls) {
        return new SimpleType(cls, null, null, null, 0, null, null, false);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType F(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType G(JavaType javaType) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public JavaType H(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override // com.fasterxml.jackson.databind.type.TypeBase
    public String O() {
        StringBuilder sb2 = new StringBuilder();
        Class<?> cls = this.f3690a;
        sb2.append(cls.getName());
        TypeBindings typeBindings = this.f4450k;
        int length = typeBindings.f4454b.length;
        if (length > 0 && cls.getTypeParameters().length == length) {
            sb2.append('<');
            for (int i10 = 0; i10 < length; i10++) {
                JavaType javaTypeD = typeBindings.d(i10);
                if (i10 > 0) {
                    sb2.append(',');
                }
                sb2.append(javaTypeD.e());
            }
            sb2.append('>');
        }
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public SimpleType I(c cVar) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public SimpleType K() {
        return this.f3694e ? this : new SimpleType(this.f3690a, this.f4450k, this.h, this.f4449j, 0, this.f3692c, this.f3693d, true);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public SimpleType L(Object obj) {
        if (this.f3693d == obj) {
            return this;
        }
        return new SimpleType(this.f3690a, this.f4450k, this.h, this.f4449j, 0, this.f3692c, obj, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public SimpleType M(Object obj) {
        if (obj == this.f3692c) {
            return this;
        }
        return new SimpleType(this.f3690a, this.f4450k, this.h, this.f4449j, 0, obj, this.f3693d, this.f3694e);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        SimpleType simpleType = (SimpleType) obj;
        if (simpleType.f3690a != this.f3690a) {
            return false;
        }
        return this.f4450k.equals(simpleType.f4450k);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public StringBuilder l(StringBuilder sb2) {
        TypeBase.N(this.f3690a, sb2, true);
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public StringBuilder m(StringBuilder sb2) {
        TypeBase.N(this.f3690a, sb2, false);
        TypeBindings typeBindings = this.f4450k;
        int length = typeBindings.f4454b.length;
        if (length > 0) {
            sb2.append('<');
            for (int i10 = 0; i10 < length; i10++) {
                sb2 = typeBindings.d(i10).m(sb2);
            }
            sb2.append('>');
        }
        sb2.append(';');
        return sb2;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public boolean r() {
        return this instanceof ReferenceType;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[simple type, class ");
        sb2.append(O());
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean y() {
        return false;
    }

    public SimpleType(Class<?> cls) {
        this(cls, TypeBindings.f4452j, null, null);
    }
}
