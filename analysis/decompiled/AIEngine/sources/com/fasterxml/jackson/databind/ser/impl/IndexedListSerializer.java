package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.List;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((List) obj).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
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
            java.util.List r4 = (java.util.List) r4
            int r0 = r4.size()
            r1 = 1
            if (r0 != r1) goto L1f
            java.lang.Boolean r0 = r3.h
            if (r0 != 0) goto L17
            com.fasterxml.jackson.databind.SerializationFeature r1 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            com.fasterxml.jackson.databind.SerializationConfig r2 = r6.f3044a
            boolean r1 = r2.q(r1)
            if (r1 != 0) goto L1b
        L17:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L1f
        L1b:
            r3.q(r4, r5, r6)
            return
        L1f:
            r5.b1(r4)
            r3.q(r4, r5, r6)
            r5.C0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return new IndexedListSerializer(this, this.f4345d, eVar, this.f4348k, this.h);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public final AsArraySerializerBase<List<?>> r(BeanProperty beanProperty, e eVar, f fVar, Boolean bool) {
        return new IndexedListSerializer(this, beanProperty, eVar, fVar, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void q(List<?> list, JsonGenerator jsonGenerator, h hVar) throws IOException {
        int i10 = 0;
        e eVar = this.f4347j;
        f<Object> fVar = this.f4348k;
        if (fVar != null) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            while (i10 < size) {
                Object obj = list.get(i10);
                if (obj == null) {
                    try {
                        hVar.p(jsonGenerator);
                    } catch (Exception e10) {
                        StdSerializer.m(hVar, e10, list, i10);
                        throw null;
                    }
                } else if (eVar == null) {
                    fVar.f(obj, jsonGenerator, hVar);
                } else {
                    fVar.g(obj, jsonGenerator, hVar, eVar);
                }
                i10++;
            }
            return;
        }
        BeanProperty beanProperty = this.f4345d;
        JavaType javaType = this.f4344c;
        if (eVar != null) {
            int size2 = list.size();
            if (size2 == 0) {
                return;
            }
            try {
                a aVar = this.f4349l;
                while (i10 < size2) {
                    Object obj2 = list.get(i10);
                    if (obj2 == null) {
                        hVar.p(jsonGenerator);
                    } else {
                        Class<?> cls = obj2.getClass();
                        f<Object> fVarC = aVar.c(cls);
                        if (fVarC == null) {
                            if (javaType.s()) {
                                fVarC = p(aVar, hVar.o(javaType, cls), hVar);
                            } else {
                                fVarC = hVar.r(cls, beanProperty);
                                a aVarB = aVar.b(cls, fVarC);
                                if (aVar != aVarB) {
                                    this.f4349l = aVarB;
                                }
                            }
                            aVar = this.f4349l;
                        }
                        fVarC.g(obj2, jsonGenerator, hVar, eVar);
                    }
                    i10++;
                }
                return;
            } catch (Exception e11) {
                StdSerializer.m(hVar, e11, list, i10);
                throw null;
            }
        }
        int size3 = list.size();
        if (size3 == 0) {
            return;
        }
        try {
            a aVar2 = this.f4349l;
            while (i10 < size3) {
                Object obj3 = list.get(i10);
                if (obj3 == null) {
                    hVar.p(jsonGenerator);
                } else {
                    Class<?> cls2 = obj3.getClass();
                    f<Object> fVarC2 = aVar2.c(cls2);
                    if (fVarC2 == null) {
                        if (javaType.s()) {
                            fVarC2 = p(aVar2, hVar.o(javaType, cls2), hVar);
                        } else {
                            fVarC2 = hVar.r(cls2, beanProperty);
                            a aVarB2 = aVar2.b(cls2, fVarC2);
                            if (aVar2 != aVarB2) {
                                this.f4349l = aVarB2;
                            }
                        }
                        aVar2 = this.f4349l;
                    }
                    fVarC2.f(obj3, jsonGenerator, hVar);
                }
                i10++;
            }
        } catch (Exception e12) {
            StdSerializer.m(hVar, e12, list, i10);
            throw null;
        }
    }
}
