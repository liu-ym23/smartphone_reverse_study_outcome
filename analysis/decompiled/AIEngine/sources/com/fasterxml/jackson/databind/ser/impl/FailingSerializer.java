package com.fasterxml.jackson.databind.ser.impl;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FailingSerializer extends StdSerializer<Object> {

    /* renamed from: c, reason: collision with root package name */
    public final String f4309c;

    public FailingSerializer() {
        super(Object.class);
        this.f4309c = "Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)";
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws JsonMappingException {
        hVar.getClass();
        throw new JsonMappingException(((DefaultSerializerProvider) hVar).r, this.f4309c, (Throwable) null);
    }
}
