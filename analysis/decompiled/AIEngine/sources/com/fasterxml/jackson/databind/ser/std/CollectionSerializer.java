package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CollectionSerializer extends AsArraySerializerBase<Collection<?>> {
    public CollectionSerializer(JavaType javaType, boolean z, e eVar, f<Object> fVar) {
        super((Class<?>) Collection.class, javaType, z, eVar, fVar);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((Collection) obj).isEmpty();
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
            java.util.Collection r4 = (java.util.Collection) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.CollectionSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return new CollectionSerializer(this, this.f4345d, eVar, this.f4348k, this.h);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public final AsArraySerializerBase<Collection<?>> r(BeanProperty beanProperty, e eVar, f fVar, Boolean bool) {
        return new CollectionSerializer(this, beanProperty, eVar, fVar, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void q(Collection<?> collection, JsonGenerator jsonGenerator, h hVar) throws IOException {
        JavaType javaType = this.f4344c;
        jsonGenerator.Q(collection);
        int i10 = 0;
        e eVar = this.f4347j;
        f<Object> fVar = this.f4348k;
        if (fVar != null) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            hVar.p(jsonGenerator);
                        } catch (Exception e10) {
                            StdSerializer.m(hVar, e10, collection, i10);
                            throw null;
                        }
                    } else if (eVar == null) {
                        fVar.f(next, jsonGenerator, hVar);
                    } else {
                        fVar.g(next, jsonGenerator, hVar, eVar);
                    }
                    i10++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator<?> it2 = collection.iterator();
        if (it2.hasNext()) {
            a aVar = this.f4349l;
            do {
                try {
                    Object next2 = it2.next();
                    if (next2 == null) {
                        hVar.p(jsonGenerator);
                    } else {
                        Class<?> cls = next2.getClass();
                        f<Object> fVarC = aVar.c(cls);
                        if (fVarC == null) {
                            if (javaType.s()) {
                                fVarC = p(aVar, hVar.o(javaType, cls), hVar);
                            } else {
                                fVarC = hVar.r(cls, this.f4345d);
                                a aVarB = aVar.b(cls, fVarC);
                                if (aVar != aVarB) {
                                    this.f4349l = aVarB;
                                }
                            }
                            aVar = this.f4349l;
                        }
                        if (eVar == null) {
                            fVarC.f(next2, jsonGenerator, hVar);
                        } else {
                            fVarC.g(next2, jsonGenerator, hVar, eVar);
                        }
                    }
                    i10++;
                } catch (Exception e11) {
                    StdSerializer.m(hVar, e11, collection, i10);
                    throw null;
                }
            } while (it2.hasNext());
        }
    }
}
