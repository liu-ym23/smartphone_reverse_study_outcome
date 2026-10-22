package com.fasterxml.jackson.databind.ser.impl;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UnknownSerializer extends StdSerializer<Object> {
    public UnknownSerializer() {
        super(Object.class);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return true;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        if (hVar.f3044a.q(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            o(hVar, obj);
            throw null;
        }
        jsonGenerator.e1(obj);
        jsonGenerator.G0();
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        if (hVar.f3044a.q(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            o(hVar, obj);
            throw null;
        }
        eVar.f(jsonGenerator, eVar.e(jsonGenerator, eVar.d(JsonToken.START_OBJECT, obj)));
    }

    public final void o(h hVar, Object obj) {
        hVar.i(this.f4417a, "No serializer found for class " + obj.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)");
        throw null;
    }
}
