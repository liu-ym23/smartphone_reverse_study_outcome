package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Deprecated
/* loaded from: classes.dex */
public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.H0(obj.toString());
    }
}
