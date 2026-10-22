package com.fasterxml.jackson.databind.ser.impl;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UnsupportedTypeSerializer extends StdSerializer<Object> {

    /* renamed from: c, reason: collision with root package name */
    public final String f4327c;

    public UnsupportedTypeSerializer(JavaType javaType, String str) {
        super(Object.class);
        this.f4327c = str;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws InvalidDefinitionException {
        hVar.j(this.f4327c);
        throw null;
    }
}
