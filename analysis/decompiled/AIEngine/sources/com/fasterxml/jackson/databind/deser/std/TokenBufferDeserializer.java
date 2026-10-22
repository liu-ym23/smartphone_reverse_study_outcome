package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class TokenBufferDeserializer extends StdScalarDeserializer<p> {
    public TokenBufferDeserializer() {
        super(p.class);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException, JsonGenerationException {
        JsonToken jsonTokenQ1;
        p pVar = new p(jsonParser, null);
        if (!jsonParser.i1(JsonToken.FIELD_NAME)) {
            pVar.u1(jsonParser);
            return pVar;
        }
        pVar.c1();
        do {
            pVar.u1(jsonParser);
            jsonTokenQ1 = jsonParser.q1();
        } while (jsonTokenQ1 == JsonToken.FIELD_NAME);
        JsonToken jsonToken = JsonToken.END_OBJECT;
        if (jsonTokenQ1 == jsonToken) {
            pVar.G0();
            return pVar;
        }
        String str = "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + jsonTokenQ1;
        deserializationContext.getClass();
        throw DeserializationContext.X(deserializationContext.h, jsonToken, str);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final LogicalType o() {
        return LogicalType.f4432e;
    }
}
