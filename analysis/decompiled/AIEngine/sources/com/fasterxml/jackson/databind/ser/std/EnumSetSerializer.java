package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.util.EnumSet;
import java.util.Iterator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((EnumSet) obj).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
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
            java.util.EnumSet r4 = (java.util.EnumSet) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.EnumSetSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public final AsArraySerializerBase<EnumSet<? extends Enum<?>>> r(BeanProperty beanProperty, e eVar, f fVar, Boolean bool) {
        return new EnumSetSerializer(this, beanProperty, eVar, fVar, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void q(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, h hVar) {
        Iterator<? extends Enum<?>> it = enumSet.iterator();
        f<Object> fVarR = this.f4348k;
        while (it.hasNext()) {
            Enum<?> next = it.next();
            if (fVarR == null) {
                fVarR = hVar.r(next.getDeclaringClass(), this.f4345d);
            }
            fVarR.f(next, jsonGenerator, hVar);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer o(e eVar) {
        return this;
    }
}
