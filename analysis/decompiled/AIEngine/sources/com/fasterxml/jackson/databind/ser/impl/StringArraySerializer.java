package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class StringArraySerializer extends ArraySerializerBase<String[]> {
    public static final StringArraySerializer h;

    /* renamed from: e, reason: collision with root package name */
    public final f<Object> f4325e;

    static {
        TypeFactory.f4468d.getClass();
        TypeFactory.m(String.class);
        h = new StringArraySerializer();
    }

    public StringArraySerializer() {
        super(String[].class);
        this.f4325e = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r5, com.fasterxml.jackson.databind.BeanProperty r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L1a
            com.fasterxml.jackson.databind.SerializationConfig r1 = r5.f3044a
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r1.d()
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r6.d()
            if (r2 == 0) goto L1a
            java.lang.Object r1 = r1.d(r2)
            if (r1 == 0) goto L1a
            b3.f r1 = r5.G(r2, r1)
            goto L1b
        L1a:
            r1 = r0
        L1b:
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer.k(r5, r6, r2)
            if (r2 == 0) goto L2a
            com.fasterxml.jackson.annotation.JsonFormat$Feature r3 = com.fasterxml.jackson.annotation.JsonFormat.Feature.f3436c
            java.lang.Boolean r2 = r2.b(r3)
            goto L2b
        L2a:
            r2 = r0
        L2b:
            b3.f<java.lang.Object> r3 = r4.f4325e
            if (r1 != 0) goto L30
            r1 = r3
        L30:
            b3.f r1 = com.fasterxml.jackson.databind.ser.std.StdSerializer.j(r5, r6, r1)
            if (r1 != 0) goto L3c
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            b3.f r1 = r5.r(r1, r6)
        L3c:
            boolean r5 = com.fasterxml.jackson.databind.util.a.v(r1)
            if (r5 == 0) goto L43
            goto L44
        L43:
            r0 = r1
        L44:
            if (r0 != r3) goto L4f
            java.lang.Boolean r5 = r4.f4343d
            boolean r5 = java.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L4f
            return r4
        L4f:
            com.fasterxml.jackson.databind.ser.impl.StringArraySerializer r5 = new com.fasterxml.jackson.databind.ser.impl.StringArraySerializer
            r5.<init>(r4, r6, r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((String[]) obj).length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r4, com.fasterxml.jackson.core.JsonGenerator r5, b3.h r6) {
        /*
            r3 = this;
            java.lang.String[] r4 = (java.lang.String[]) r4
            int r0 = r4.length
            r1 = 1
            if (r0 != r1) goto L1c
            java.lang.Boolean r0 = r3.f4343d
            if (r0 != 0) goto L14
            com.fasterxml.jackson.databind.SerializationFeature r1 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            com.fasterxml.jackson.databind.SerializationConfig r2 = r6.f3044a
            boolean r1 = r2.q(r1)
            if (r1 != 0) goto L18
        L14:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L1c
        L18:
            r3.r(r4, r5, r6)
            return
        L1c:
            r5.b1(r4)
            r3.r(r4, r5, r6)
            r5.C0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public final f<?> q(BeanProperty beanProperty, Boolean bool) {
        return new StringArraySerializer(this, beanProperty, this.f4325e, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void r(String[] strArr, JsonGenerator jsonGenerator, h hVar) {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        int i10 = 0;
        f<Object> fVar = this.f4325e;
        if (fVar == null) {
            while (i10 < length) {
                String str = strArr[i10];
                if (str == null) {
                    jsonGenerator.J0();
                } else {
                    jsonGenerator.f1(str);
                }
                i10++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i10 < length2) {
            String str2 = strArr[i10];
            if (str2 == null) {
                hVar.p(jsonGenerator);
            } else {
                fVar.f(str2, jsonGenerator, hVar);
            }
            i10++;
        }
    }

    public StringArraySerializer(StringArraySerializer stringArraySerializer, BeanProperty beanProperty, f<?> fVar, Boolean bool) {
        super(stringArraySerializer, beanProperty, bool);
        this.f4325e = fVar;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return this;
    }
}
