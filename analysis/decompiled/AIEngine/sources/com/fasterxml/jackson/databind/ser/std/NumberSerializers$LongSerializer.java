package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class NumberSerializers$LongSerializer extends NumberSerializers$Base<Object> {
    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.N0(((Long) obj).longValue());
    }
}
