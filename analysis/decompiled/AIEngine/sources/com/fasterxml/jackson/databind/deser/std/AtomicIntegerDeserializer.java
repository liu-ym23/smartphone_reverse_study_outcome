package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AtomicIntegerDeserializer extends StdScalarDeserializer<AtomicInteger> {
    public AtomicIntegerDeserializer() {
        super(AtomicInteger.class);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (jsonParser.k1()) {
            return new AtomicInteger(jsonParser.M0());
        }
        Integer numS = S(jsonParser, deserializationContext, AtomicInteger.class);
        if (numS == null) {
            return null;
        }
        return new AtomicInteger(numS.intValue());
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return new AtomicInteger();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final LogicalType o() {
        return LogicalType.h;
    }
}
