package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NullifyingDeserializer extends StdDeserializer<Object> {

    /* renamed from: d, reason: collision with root package name */
    public static final NullifyingDeserializer f4015d = new NullifyingDeserializer();

    public NullifyingDeserializer() {
        super((Class<?>) Object.class);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!jsonParser.i1(JsonToken.FIELD_NAME)) {
            jsonParser.v1();
            return null;
        }
        while (true) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            if (jsonTokenQ1 == null || jsonTokenQ1 == JsonToken.END_OBJECT) {
                return null;
            }
            jsonParser.v1();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        int iP = jsonParser.P();
        if (iP == 1 || iP == 3 || iP == 5) {
            return bVar.b(jsonParser, deserializationContext);
        }
        return null;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }
}
