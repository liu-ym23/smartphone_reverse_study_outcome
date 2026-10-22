package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import java.util.TimeZone;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TimeZoneSerializer extends StdScalarSerializer<TimeZone> {
    public TimeZoneSerializer() {
        super(TimeZone.class);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.f1(((TimeZone) obj).getID());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        TimeZone timeZone = (TimeZone) obj;
        WritableTypeId writableTypeIdD = eVar.d(JsonToken.VALUE_STRING, timeZone);
        writableTypeIdD.f3620b = TimeZone.class;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, writableTypeIdD);
        jsonGenerator.f1(timeZone.getID());
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
