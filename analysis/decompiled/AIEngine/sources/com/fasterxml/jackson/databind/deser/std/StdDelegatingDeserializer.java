package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.a;
import e3.c;
import e3.i;
import e3.j;
import f3.e;
import k3.b;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StdDelegatingDeserializer<T> extends StdDeserializer<T> implements c, j {

    /* renamed from: d, reason: collision with root package name */
    public final g<Object, T> f4051d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaType f4052e;
    public final b3.c<Object> h;

    public StdDelegatingDeserializer(e.a aVar) {
        super((Class<?>) Object.class);
        this.f4051d = aVar;
        this.f4052e = null;
        this.h = null;
    }

    @Override // e3.j
    public final void b(DeserializationContext deserializationContext) {
        i iVar = this.h;
        if (iVar == null || !(iVar instanceof j)) {
            return;
        }
        ((j) iVar).b(deserializationContext);
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        g<Object, T> gVar = this.f4051d;
        b3.c<?> cVar = this.h;
        if (cVar == null) {
            deserializationContext.e();
            JavaType inputType = gVar.getInputType();
            b3.c<Object> cVarO = deserializationContext.o(inputType, beanProperty);
            a.E(StdDelegatingDeserializer.class, this, "withDelegate");
            return new StdDelegatingDeserializer(gVar, inputType, cVarO);
        }
        JavaType javaType = this.f4052e;
        b3.c<?> cVarZ = deserializationContext.z(cVar, beanProperty, javaType);
        if (cVarZ == cVar) {
            return this;
        }
        a.E(StdDelegatingDeserializer.class, this, "withDelegate");
        return new StdDelegatingDeserializer(gVar, javaType, cVarZ);
    }

    @Override // b3.c
    public final T d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object objD = this.h.d(jsonParser, deserializationContext);
        if (objD == null) {
            return null;
        }
        return this.f4051d.a(objD);
    }

    @Override // b3.c
    public final T e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        JavaType javaType = this.f4052e;
        if (javaType.f3690a.isAssignableFrom(obj.getClass())) {
            return (T) this.h.e(jsonParser, deserializationContext, obj);
        }
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)".concat(obj.getClass().getName()), javaType));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        Object objD = this.h.d(jsonParser, deserializationContext);
        if (objD == null) {
            return null;
        }
        return this.f4051d.a(objD);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Class<?> m() {
        return this.h.m();
    }

    @Override // b3.c
    public final LogicalType o() {
        return this.h.o();
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return this.h.p(deserializationConfig);
    }

    public StdDelegatingDeserializer(g<Object, T> gVar, JavaType javaType, b3.c<?> cVar) {
        super(javaType);
        this.f4051d = gVar;
        this.f4052e = javaType;
        this.h = cVar;
    }
}
