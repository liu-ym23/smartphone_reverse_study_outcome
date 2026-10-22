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
import java.util.Collection;
import java.util.Iterator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> {

    /* renamed from: d, reason: collision with root package name */
    public static final StringCollectionSerializer f4326d = new StringCollectionSerializer();

    public StringCollectionSerializer() {
        super(Collection.class);
    }

    public static void p(Collection collection, JsonGenerator jsonGenerator, h hVar) throws IOException {
        int i10 = 0;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    hVar.p(jsonGenerator);
                } else {
                    jsonGenerator.f1(str);
                }
                i10++;
            }
        } catch (Exception e10) {
            StdSerializer.m(hVar, e10, collection, i10);
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r2 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r3, com.fasterxml.jackson.core.JsonGenerator r4, b3.h r5) throws java.io.IOException {
        /*
            r2 = this;
            java.util.Collection r3 = (java.util.Collection) r3
            int r0 = r3.size()
            r1 = 1
            if (r0 != r1) goto L1f
            java.lang.Boolean r2 = r2.f4407c
            if (r2 != 0) goto L17
            com.fasterxml.jackson.databind.SerializationFeature r0 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            com.fasterxml.jackson.databind.SerializationConfig r1 = r5.f3044a
            boolean r0 = r1.q(r0)
            if (r0 != 0) goto L1b
        L17:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            if (r2 != r0) goto L1f
        L1b:
            p(r3, r4, r5)
            return
        L1f:
            r4.b1(r3)
            p(r3, r4, r5)
            r4.C0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) throws IOException {
        Collection collection = (Collection) obj;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_ARRAY, collection));
        jsonGenerator.Q(collection);
        p(collection, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public final f<?> o(BeanProperty beanProperty, Boolean bool) {
        return new StringCollectionSerializer(this, bool);
    }
}
