package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamReadException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonParseException extends StreamReadException {
    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException
    public final Object c() {
        return this.f3609b;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    /* renamed from: d */
    public final JsonParser c() {
        return this.f3609b;
    }
}
