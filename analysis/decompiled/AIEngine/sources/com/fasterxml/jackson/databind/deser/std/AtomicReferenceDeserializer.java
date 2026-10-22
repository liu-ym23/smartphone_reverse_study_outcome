package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AtomicReferenceDeserializer extends ReferenceTypeDeserializer<AtomicReference<Object>> {
    @Override // b3.c, e3.i
    public final Object a(DeserializationContext deserializationContext) {
        return new AtomicReference(this.f4050j.a(deserializationContext));
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return new AtomicReference(this.f4050j.a(deserializationContext));
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }
}
