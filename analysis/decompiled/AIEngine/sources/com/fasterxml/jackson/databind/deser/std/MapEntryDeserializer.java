package com.fasterxml.jackson.databind.deser.std;

import b3.g;
import c3.a;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.LogicalType;
import e3.c;
import e3.d;
import e3.i;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class MapEntryDeserializer extends ContainerDeserializerBase<Map.Entry<Object, Object>> implements c {

    /* renamed from: k, reason: collision with root package name */
    public final g f4012k;

    /* renamed from: l, reason: collision with root package name */
    public final b3.c<Object> f4013l;

    /* renamed from: m, reason: collision with root package name */
    public final b f4014m;

    public MapEntryDeserializer(JavaType javaType, g gVar, b3.c<Object> cVar, b bVar) {
        super(javaType, (i) null, (Boolean) null);
        if (javaType.g() != 2) {
            throw new IllegalArgumentException("Missing generic type information for " + javaType);
        }
        this.f4012k = gVar;
        this.f4013l = cVar;
        this.f4014m = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JavaType javaType = this.f3964d;
        g gVar = this.f4012k;
        g gVarQ = gVar == 0 ? deserializationContext.q(javaType.f(0), beanProperty) : gVar instanceof d ? ((d) gVar).a() : gVar;
        b3.c<?> cVar = this.f4013l;
        b3.c<?> cVarC0 = StdDeserializer.c0(deserializationContext, beanProperty, cVar);
        JavaType javaTypeF = javaType.f(1);
        b3.c<?> cVarO = cVarC0 == null ? deserializationContext.o(javaTypeF, beanProperty) : deserializationContext.z(cVarC0, beanProperty, javaTypeF);
        b bVar = this.f4014m;
        b bVarF = bVar != null ? bVar.f(beanProperty) : bVar;
        return (gVar == gVarQ && cVar == cVarO && bVar == bVarF) ? this : new MapEntryDeserializer(this, gVarQ, cVarO, bVarF);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objD;
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK == JsonToken.START_OBJECT) {
            jsonTokenK = jsonParser.q1();
        } else if (jsonTokenK != JsonToken.FIELD_NAME && jsonTokenK != JsonToken.END_OBJECT) {
            if (jsonTokenK == JsonToken.START_ARRAY) {
                return B(jsonParser, deserializationContext);
            }
            deserializationContext.A(jsonParser, g0(deserializationContext));
            throw null;
        }
        JsonToken jsonToken = JsonToken.FIELD_NAME;
        if (jsonTokenK != jsonToken) {
            if (jsonTokenK == JsonToken.END_OBJECT) {
                deserializationContext.P(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
                throw null;
            }
            deserializationContext.C(this.f4054a, jsonParser);
            throw null;
        }
        String strC = jsonParser.C();
        Object objA = this.f4012k.a(deserializationContext, strC);
        JsonToken jsonTokenQ1 = jsonParser.q1();
        try {
            JsonToken jsonToken2 = JsonToken.VALUE_NULL;
            b3.c<Object> cVar = this.f4013l;
            if (jsonTokenQ1 == jsonToken2) {
                objD = cVar.a(deserializationContext);
            } else {
                b bVar = this.f4014m;
                objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
            }
            JsonToken jsonTokenQ12 = jsonParser.q1();
            if (jsonTokenQ12 == JsonToken.END_OBJECT) {
                return new AbstractMap.SimpleEntry(objA, objD);
            }
            if (jsonTokenQ12 == jsonToken) {
                deserializationContext.P(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", jsonParser.C());
                throw null;
            }
            deserializationContext.P(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + jsonTokenQ12, new Object[0]);
            throw null;
        } catch (Exception e10) {
            ContainerDeserializerBase.k0(deserializationContext, e10, Map.Entry.class, strC);
            throw null;
        }
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public final b3.c<Object> j0() {
        return this.f4013l;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4430c;
    }

    public MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer, g gVar, b3.c<Object> cVar, b bVar) {
        super(mapEntryDeserializer, mapEntryDeserializer.f3965e, mapEntryDeserializer.f3966j);
        this.f4012k = gVar;
        this.f4013l = cVar;
        this.f4014m = bVar;
    }
}
