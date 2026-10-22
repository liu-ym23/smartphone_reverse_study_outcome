package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import e3.c;
import java.util.concurrent.atomic.AtomicReference;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ReferenceTypeDeserializer<T> extends StdDeserializer<T> implements c {

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f4048d;

    /* renamed from: e, reason: collision with root package name */
    public final ValueInstantiator f4049e;
    public final b h;

    /* renamed from: j, reason: collision with root package name */
    public final b3.c<Object> f4050j;

    public ReferenceTypeDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, b bVar, b3.c<?> cVar) {
        super(javaType);
        this.f4049e = valueInstantiator;
        this.f4048d = javaType;
        this.f4050j = cVar;
        this.h = bVar;
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JavaType javaType = this.f4048d;
        b3.c<?> cVar = this.f4050j;
        b3.c<?> cVarO = cVar == null ? deserializationContext.o(javaType.c(), beanProperty) : deserializationContext.z(cVar, beanProperty, javaType.c());
        b bVar = this.h;
        b bVarF = bVar != null ? bVar.f(beanProperty) : bVar;
        if (cVarO == cVar && bVarF == bVar) {
            return this;
        }
        AtomicReferenceDeserializer atomicReferenceDeserializer = (AtomicReferenceDeserializer) this;
        return new AtomicReferenceDeserializer(atomicReferenceDeserializer.f4048d, atomicReferenceDeserializer.f4049e, bVarF, cVarO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b3.c
    public final T d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ValueInstantiator valueInstantiator = this.f4049e;
        if (valueInstantiator != null) {
            return (T) e(jsonParser, deserializationContext, valueInstantiator.v(deserializationContext));
        }
        b3.c<Object> cVar = this.f4050j;
        b bVar = this.h;
        return (T) new AtomicReference(bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.util.concurrent.atomic.AtomicReference] */
    @Override // b3.c
    public final T e(JsonParser jsonParser, DeserializationContext deserializationContext, T t8) throws InvalidDefinitionException {
        Object objD;
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        b3.c<Object> cVar = this.f4050j;
        boolean zEquals = cVar.p(deserializationConfig).equals(Boolean.FALSE);
        b bVar = this.h;
        if (zEquals || bVar != null) {
            objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
        } else {
            Object obj = ((AtomicReference) t8).get();
            if (obj == null) {
                return (T) new AtomicReference(bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar));
            }
            objD = cVar.e(jsonParser, deserializationContext, obj);
        }
        ?? r62 = (T) ((AtomicReference) t8);
        r62.set(objD);
        return r62;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.f4049e;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        if (jsonParser.i1(JsonToken.VALUE_NULL)) {
            return new AtomicReference(((AtomicReferenceDeserializer) this).f4050j.a(deserializationContext));
        }
        b bVar2 = this.h;
        return bVar2 == null ? d(jsonParser, deserializationContext) : new AtomicReference(bVar2.b(jsonParser, deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final JavaType f0() {
        return this.f4048d;
    }

    @Override // b3.c
    public final AccessPattern i() {
        return AccessPattern.f4493c;
    }

    @Override // b3.c
    public final LogicalType o() {
        b3.c<Object> cVar = this.f4050j;
        if (cVar != null) {
            return cVar.o();
        }
        return null;
    }
}
