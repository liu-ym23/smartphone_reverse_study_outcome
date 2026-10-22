package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ToStringSerializerBase extends StdSerializer<Object> {
    @Override // b3.f
    public boolean d(h hVar, Object obj) {
        return o(obj).isEmpty();
    }

    @Override // b3.f
    public void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.f1(o(obj));
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_STRING, obj));
        f(obj, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    public abstract String o(Object obj);
}
