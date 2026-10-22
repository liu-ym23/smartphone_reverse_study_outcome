package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.util.Iterator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return !((Iterator) obj).hasNext();
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Iterator<?> it = (Iterator) obj;
        jsonGenerator.a1(it);
        q(it, jsonGenerator, hVar);
        jsonGenerator.C0();
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return new IteratorSerializer(this, this.f4345d, eVar, this.f4348k, this.h);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public final AsArraySerializerBase<Iterator<?>> r(BeanProperty beanProperty, e eVar, f fVar, Boolean bool) {
        return new IteratorSerializer(this, beanProperty, eVar, fVar, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void q(Iterator<?> it, JsonGenerator jsonGenerator, h hVar) {
        if (it.hasNext()) {
            e eVar = this.f4347j;
            f<Object> fVar = this.f4348k;
            if (fVar != null) {
                do {
                    Object next = it.next();
                    if (next == null) {
                        hVar.p(jsonGenerator);
                    } else if (eVar == null) {
                        fVar.f(next, jsonGenerator, hVar);
                    } else {
                        fVar.g(next, jsonGenerator, hVar, eVar);
                    }
                } while (it.hasNext());
                return;
            }
            a aVar = this.f4349l;
            do {
                Object next2 = it.next();
                if (next2 == null) {
                    hVar.p(jsonGenerator);
                } else {
                    Class<?> cls = next2.getClass();
                    f<Object> fVarC = aVar.c(cls);
                    if (fVarC == null) {
                        JavaType javaType = this.f4344c;
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
            } while (it.hasNext());
        }
    }
}
