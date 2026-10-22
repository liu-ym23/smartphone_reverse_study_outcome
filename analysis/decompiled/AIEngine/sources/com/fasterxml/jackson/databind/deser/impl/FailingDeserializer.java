package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FailingDeserializer extends StdDeserializer<Object> {

    /* renamed from: d, reason: collision with root package name */
    public final String f3910d;

    public FailingDeserializer() {
        super((Class<?>) Object.class);
        this.f3910d = "No _valueDeserializer assigned";
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        deserializationContext.P(this, this.f3910d, new Object[0]);
        throw null;
    }
}
