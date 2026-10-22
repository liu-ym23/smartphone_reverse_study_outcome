package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import java.io.IOException;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4395e;
    public final JavaType h;

    /* renamed from: j, reason: collision with root package name */
    public final e f4396j;

    /* renamed from: k, reason: collision with root package name */
    public final f<Object> f4397k;

    /* renamed from: l, reason: collision with root package name */
    public com.fasterxml.jackson.databind.ser.impl.a f4398l;

    public ObjectArraySerializer(JavaType javaType, boolean z, e eVar, f<Object> fVar) {
        super(Object[].class);
        this.h = javaType;
        this.f4395e = z;
        this.f4396j = eVar;
        this.f4398l = a.b.f4334a;
        this.f4397k = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r9, com.fasterxml.jackson.databind.BeanProperty r10) {
        /*
            r8 = this;
            k3.e r0 = r8.f4396j
            if (r0 == 0) goto La
            k3.e r1 = r0.a(r10)
            r5 = r1
            goto Lb
        La:
            r5 = r0
        Lb:
            r1 = 0
            if (r10 == 0) goto L25
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r10.d()
            com.fasterxml.jackson.databind.SerializationConfig r3 = r9.f3044a
            com.fasterxml.jackson.databind.AnnotationIntrospector r3 = r3.d()
            if (r2 == 0) goto L25
            java.lang.Object r3 = r3.d(r2)
            if (r3 == 0) goto L25
            b3.f r2 = r9.G(r2, r3)
            goto L26
        L25:
            r2 = r1
        L26:
            java.lang.Class<T> r3 = r8.f4417a
            com.fasterxml.jackson.annotation.JsonFormat$Value r3 = com.fasterxml.jackson.databind.ser.std.StdSerializer.k(r9, r10, r3)
            if (r3 == 0) goto L34
            com.fasterxml.jackson.annotation.JsonFormat$Feature r1 = com.fasterxml.jackson.annotation.JsonFormat.Feature.f3436c
            java.lang.Boolean r1 = r3.b(r1)
        L34:
            r7 = r1
            b3.f<java.lang.Object> r1 = r8.f4397k
            if (r2 != 0) goto L3a
            r2 = r1
        L3a:
            b3.f r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer.j(r9, r10, r2)
            if (r2 != 0) goto L52
            com.fasterxml.jackson.databind.JavaType r3 = r8.h
            if (r3 == 0) goto L52
            boolean r4 = r8.f4395e
            if (r4 == 0) goto L52
            boolean r4 = r3.A()
            if (r4 != 0) goto L52
            b3.f r2 = r9.q(r3, r10)
        L52:
            r6 = r2
            com.fasterxml.jackson.databind.BeanProperty r9 = r8.f4342c
            if (r9 != r10) goto L64
            if (r6 != r1) goto L64
            if (r0 != r5) goto L64
            java.lang.Boolean r9 = r8.f4343d
            boolean r9 = java.util.Objects.equals(r9, r7)
            if (r9 == 0) goto L64
            return r8
        L64:
            com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer r2 = new com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer
            r3 = r8
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r4, com.fasterxml.jackson.core.JsonGenerator r5, b3.h r6) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object[] r4 = (java.lang.Object[]) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return new ObjectArraySerializer(this.h, this.f4395e, eVar, this.f4397k);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public final f<?> q(BeanProperty beanProperty, Boolean bool) {
        return new ObjectArraySerializer(this, beanProperty, this.f4396j, this.f4397k, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void r(Object[] objArr, JsonGenerator jsonGenerator, h hVar) throws IOException {
        Object obj;
        Object obj2;
        com.fasterxml.jackson.databind.ser.impl.a aVarB;
        JavaType javaType = this.h;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        e eVar = this.f4396j;
        int i10 = 0;
        f<Object> fVar = this.f4397k;
        if (fVar != null) {
            int length2 = objArr.length;
            Object obj3 = null;
            while (i10 < length2) {
                try {
                    obj3 = objArr[i10];
                    if (obj3 == null) {
                        hVar.p(jsonGenerator);
                    } else if (eVar == null) {
                        fVar.f(obj3, jsonGenerator, hVar);
                    } else {
                        fVar.g(obj3, jsonGenerator, hVar, eVar);
                    }
                    i10++;
                } catch (Exception e10) {
                    StdSerializer.m(hVar, e10, obj3, i10);
                    throw null;
                }
            }
            return;
        }
        BeanProperty beanProperty = this.f4342c;
        if (eVar != null) {
            int length3 = objArr.length;
            try {
                com.fasterxml.jackson.databind.ser.impl.a aVar = this.f4398l;
                obj2 = null;
                while (i10 < length3) {
                    try {
                        obj2 = objArr[i10];
                        if (obj2 == null) {
                            hVar.p(jsonGenerator);
                        } else {
                            Class<?> cls = obj2.getClass();
                            f<Object> fVarC = aVar.c(cls);
                            if (fVarC == null && aVar != (aVarB = aVar.b(cls, (fVarC = hVar.r(cls, beanProperty))))) {
                                this.f4398l = aVarB;
                            }
                            fVarC.g(obj2, jsonGenerator, hVar, eVar);
                        }
                        i10++;
                    } catch (Exception e11) {
                        e = e11;
                        StdSerializer.m(hVar, e, obj2, i10);
                        throw null;
                    }
                }
            } catch (Exception e12) {
                e = e12;
                obj2 = null;
            }
        } else {
            try {
                com.fasterxml.jackson.databind.ser.impl.a aVar2 = this.f4398l;
                obj = null;
                while (i10 < length) {
                    try {
                        obj = objArr[i10];
                        if (obj == null) {
                            hVar.p(jsonGenerator);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            f<Object> fVarC2 = aVar2.c(cls2);
                            if (fVarC2 == null) {
                                if (javaType.s()) {
                                    a.d dVarA = aVar2.a(hVar.o(javaType, cls2), hVar, beanProperty);
                                    com.fasterxml.jackson.databind.ser.impl.a aVar3 = dVarA.f4337b;
                                    if (aVar2 != aVar3) {
                                        this.f4398l = aVar3;
                                    }
                                    fVarC2 = dVarA.f4336a;
                                } else {
                                    fVarC2 = hVar.r(cls2, beanProperty);
                                    com.fasterxml.jackson.databind.ser.impl.a aVarB2 = aVar2.b(cls2, fVarC2);
                                    if (aVar2 != aVarB2) {
                                        this.f4398l = aVarB2;
                                    }
                                }
                            }
                            fVarC2.f(obj, jsonGenerator, hVar);
                        }
                        i10++;
                    } catch (Exception e13) {
                        e = e13;
                        StdSerializer.m(hVar, e, obj, i10);
                        throw null;
                    }
                }
            } catch (Exception e14) {
                e = e14;
                obj = null;
            }
        }
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, BeanProperty beanProperty, e eVar, f<?> fVar, Boolean bool) {
        super(objectArraySerializer, beanProperty, bool);
        this.h = objectArraySerializer.h;
        this.f4396j = eVar;
        this.f4395e = objectArraySerializer.f4395e;
        this.f4398l = a.b.f4334a;
        this.f4397k = fVar;
    }
}
