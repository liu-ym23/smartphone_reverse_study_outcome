package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class NumberSerializers$DoubleSerializer extends NumberSerializers$Base<Object> {
    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.K0(((Double) obj).doubleValue());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        Double d8 = (Double) obj;
        double dDoubleValue = d8.doubleValue();
        if (!Double.isNaN(dDoubleValue) && !Double.isInfinite(dDoubleValue)) {
            jsonGenerator.K0(d8.doubleValue());
            return;
        }
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_NUMBER_FLOAT, obj));
        jsonGenerator.K0(d8.doubleValue());
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
