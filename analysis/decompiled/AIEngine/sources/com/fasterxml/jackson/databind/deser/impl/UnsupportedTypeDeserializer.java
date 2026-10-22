package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UnsupportedTypeDeserializer extends StdDeserializer<Object> {

    /* renamed from: d, reason: collision with root package name */
    public final String f3946d;

    public UnsupportedTypeDeserializer(JavaType javaType, String str) {
        super(javaType);
        this.f3946d = str;
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws InvalidDefinitionException {
        deserializationContext.j(this.f3946d);
        throw null;
    }
}
