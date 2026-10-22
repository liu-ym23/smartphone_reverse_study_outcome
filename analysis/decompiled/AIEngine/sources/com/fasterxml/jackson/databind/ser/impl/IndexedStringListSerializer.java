package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.List;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> {

    /* renamed from: d, reason: collision with root package name */
    public static final IndexedStringListSerializer f4314d = new IndexedStringListSerializer();

    public IndexedStringListSerializer() {
        super(List.class);
    }

    public static void p(List list, JsonGenerator jsonGenerator, h hVar, int i10) throws IOException {
        for (int i11 = 0; i11 < i10; i11++) {
            try {
                String str = (String) list.get(i11);
                if (str == null) {
                    hVar.p(jsonGenerator);
                } else {
                    jsonGenerator.f1(str);
                }
            } catch (Exception e10) {
                StdSerializer.m(hVar, e10, list, i11);
                throw null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r4 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r5, com.fasterxml.jackson.core.JsonGenerator r6, b3.h r7) throws java.io.IOException {
        /*
            r4 = this;
            java.util.List r5 = (java.util.List) r5
            int r0 = r5.size()
            r1 = 1
            if (r0 != r1) goto L1f
            java.lang.Boolean r4 = r4.f4407c
            if (r4 != 0) goto L17
            com.fasterxml.jackson.databind.SerializationFeature r2 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            com.fasterxml.jackson.databind.SerializationConfig r3 = r7.f3044a
            boolean r2 = r3.q(r2)
            if (r2 != 0) goto L1b
        L17:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            if (r4 != r2) goto L1f
        L1b:
            p(r5, r6, r7, r1)
            return
        L1f:
            r6.b1(r5)
            p(r5, r6, r7, r0)
            r6.C0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) throws IOException {
        List list = (List) obj;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_ARRAY, list));
        jsonGenerator.Q(list);
        p(list, jsonGenerator, hVar, list.size());
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public final f<?> o(BeanProperty beanProperty, Boolean bool) {
        return new IndexedStringListSerializer(this, bool);
    }
}
