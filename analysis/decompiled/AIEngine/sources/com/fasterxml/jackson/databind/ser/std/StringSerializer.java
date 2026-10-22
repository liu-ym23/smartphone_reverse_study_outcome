package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class StringSerializer extends StdScalarSerializer<Object> {
    public StringSerializer() {
        super(String.class);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((String) obj).isEmpty();
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.f1((String) obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        jsonGenerator.f1((String) obj);
    }
}
