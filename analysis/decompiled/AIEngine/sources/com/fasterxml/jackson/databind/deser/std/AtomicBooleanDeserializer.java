package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AtomicBooleanDeserializer extends StdScalarDeserializer<AtomicBoolean> {
    public AtomicBooleanDeserializer() {
        super(AtomicBoolean.class);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK == JsonToken.VALUE_TRUE) {
            return new AtomicBoolean(true);
        }
        if (jsonTokenK == JsonToken.VALUE_FALSE) {
            return new AtomicBoolean(false);
        }
        Boolean boolK = K(jsonParser, deserializationContext, AtomicBoolean.class);
        if (boolK == null) {
            return null;
        }
        return new AtomicBoolean(boolK.booleanValue());
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return new AtomicBoolean(false);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final LogicalType o() {
        return LogicalType.f4434k;
    }
}
