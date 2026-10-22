package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.util.Iterator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return !((Iterable) obj).iterator().hasNext();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r4, com.fasterxml.jackson.core.JsonGenerator r5, b3.h r6) {
        /*
            r3 = this;
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.Boolean r0 = r3.h
            if (r0 != 0) goto L10
            com.fasterxml.jackson.databind.SerializationFeature r1 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            com.fasterxml.jackson.databind.SerializationConfig r2 = r6.f3044a
            boolean r1 = r2.q(r1)
            if (r1 != 0) goto L14
        L10:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L2d
        L14:
            if (r4 == 0) goto L2d
            java.util.Iterator r0 = r4.iterator()
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2d
            r0.next()
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L2d
            r3.q(r4, r5, r6)
            return
        L2d:
            r5.a1(r4)
            r3.q(r4, r5, r6)
            r5.C0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.IterableSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return new IterableSerializer(this, this.f4345d, eVar, this.f4348k, this.h);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public final AsArraySerializerBase<Iterable<?>> r(BeanProperty beanProperty, e eVar, f fVar, Boolean bool) {
        return new IterableSerializer(this, beanProperty, eVar, fVar, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void q(Iterable<?> iterable, JsonGenerator jsonGenerator, h hVar) {
        f<Object> fVar;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            Class<?> cls = null;
            f<Object> fVarY = null;
            do {
                Object next = it.next();
                if (next == null) {
                    hVar.p(jsonGenerator);
                } else {
                    f<Object> fVar2 = this.f4348k;
                    if (fVar2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            fVarY = hVar.y(cls2, this.f4345d);
                            cls = cls2;
                        }
                        fVar = fVarY;
                    } else {
                        fVar = fVarY;
                        fVarY = fVar2;
                    }
                    e eVar = this.f4347j;
                    if (eVar == null) {
                        fVarY.f(next, jsonGenerator, hVar);
                    } else {
                        fVarY.g(next, jsonGenerator, hVar, eVar);
                    }
                    fVarY = fVar;
                }
            } while (it.hasNext());
        }
    }
}
