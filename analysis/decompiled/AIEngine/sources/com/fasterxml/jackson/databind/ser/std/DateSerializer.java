package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import java.text.DateFormat;
import java.util.Date;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class DateSerializer extends DateTimeSerializerBase<Date> {
    public static final DateSerializer h = new DateSerializer();

    public DateSerializer() {
        this(null, null);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Date date = (Date) obj;
        if (o(hVar)) {
            jsonGenerator.N0(date == null ? 0L : date.getTime());
        } else {
            p(date, jsonGenerator, hVar);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    public final DateTimeSerializerBase<Date> q(Boolean bool, DateFormat dateFormat) {
        return new DateSerializer(bool, dateFormat);
    }

    public DateSerializer(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
