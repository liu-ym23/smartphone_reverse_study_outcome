package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class StringDeserializer extends StdScalarDeserializer<String> {

    /* renamed from: d, reason: collision with root package name */
    public static final StringDeserializer f4092d = new StringDeserializer();

    public StringDeserializer() {
        super(String.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return d(jsonParser, deserializationContext);
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return "";
    }

    @Override // b3.c
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public final String d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        String strF1;
        if (jsonParser.i1(JsonToken.VALUE_STRING)) {
            return jsonParser.V0();
        }
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK == JsonToken.START_ARRAY) {
            return B(jsonParser, deserializationContext);
        }
        if (jsonTokenK == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object objK0 = jsonParser.K0();
            if (objK0 == null) {
                return null;
            }
            return objK0 instanceof byte[] ? deserializationContext.f3663c.f3828b.f3795k.e((byte[]) objK0) : objK0.toString();
        }
        JsonToken jsonToken = JsonToken.START_OBJECT;
        Class<?> cls = this.f4054a;
        if (jsonTokenK == jsonToken) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (jsonTokenK.f3600k && (strF1 = jsonParser.f1()) != null) {
            return strF1;
        }
        deserializationContext.C(cls, jsonParser);
        throw null;
    }

    @Override // b3.c
    public final boolean n() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final LogicalType o() {
        return LogicalType.f4436m;
    }
}
