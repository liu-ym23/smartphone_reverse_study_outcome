package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.Serializable;
import java.util.Collection;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TypeWrappedDeserializer extends c<Object> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final b f3944a;

    /* renamed from: b, reason: collision with root package name */
    public final c<Object> f3945b;

    public TypeWrappedDeserializer(b bVar, c<?> cVar) {
        this.f3944a = bVar;
        this.f3945b = cVar;
    }

    @Override // b3.c, e3.i
    public final Object a(DeserializationContext deserializationContext) {
        return this.f3945b.a(deserializationContext);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return this.f3945b.f(jsonParser, deserializationContext, this.f3944a);
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return this.f3945b.e(jsonParser, deserializationContext, obj);
    }

    @Override // b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return this.f3945b.j(deserializationContext);
    }

    @Override // b3.c
    public final Collection<Object> k() {
        return this.f3945b.k();
    }

    @Override // b3.c
    public final Class<?> m() {
        return this.f3945b.m();
    }

    @Override // b3.c
    public final LogicalType o() {
        return this.f3945b.o();
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return this.f3945b.p(deserializationConfig);
    }
}
