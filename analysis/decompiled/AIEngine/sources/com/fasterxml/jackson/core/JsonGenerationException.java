package com.fasterxml.jackson.core;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonGenerationException extends JsonProcessingException {

    /* renamed from: b, reason: collision with root package name */
    public final transient JsonGenerator f3539b;

    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, null, null);
        this.f3539b = jsonGenerator;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public final Object c() {
        return this.f3539b;
    }
}
