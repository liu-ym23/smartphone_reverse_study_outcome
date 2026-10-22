package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StreamReadException extends JsonProcessingException {

    /* renamed from: b, reason: collision with root package name */
    public transient JsonParser f3609b;

    public StreamReadException(JsonParser jsonParser, String str) {
        super(str, jsonParser == null ? null : jsonParser.x0(), null);
        this.f3609b = jsonParser;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public JsonParser c() {
        return this.f3609b;
    }
}
