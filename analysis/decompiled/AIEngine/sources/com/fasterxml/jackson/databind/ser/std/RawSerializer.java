package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RawSerializer<T> extends StdSerializer<T> {
    @Override // b3.f
    public final void f(T t8, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.X0(t8.toString());
    }

    @Override // b3.f
    public final void g(T t8, JsonGenerator jsonGenerator, h hVar, e eVar) {
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_EMBEDDED_OBJECT, t8));
        f(t8, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
