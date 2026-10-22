package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StdScalarDeserializer<T> extends StdDeserializer<T> {
    @Override // b3.c
    public T e(JsonParser jsonParser, DeserializationContext deserializationContext, T t8) throws InvalidDefinitionException {
        deserializationContext.v(this);
        return d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.e(jsonParser, deserializationContext);
    }

    @Override // b3.c
    public final AccessPattern i() {
        return AccessPattern.f4492b;
    }

    @Override // b3.c
    public LogicalType o() {
        return LogicalType.f4439p;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }
}
