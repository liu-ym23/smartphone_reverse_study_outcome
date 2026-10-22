package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.a;
import e3.c;
import f3.g;
import java.io.IOException;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class FactoryBasedEnumDeserializer extends StdDeserializer<Object> implements c {

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3985d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3986e;
    public final AnnotatedMethod h;

    /* renamed from: j, reason: collision with root package name */
    public final b3.c<?> f3987j;

    /* renamed from: k, reason: collision with root package name */
    public final StdValueInstantiator f3988k;

    /* renamed from: l, reason: collision with root package name */
    public final SettableBeanProperty[] f3989l;

    /* renamed from: m, reason: collision with root package name */
    public transient PropertyBasedCreator f3990m;

    public FactoryBasedEnumDeserializer(Class cls, AnnotatedMethod annotatedMethod, JavaType javaType, StdValueInstantiator stdValueInstantiator, SettableBeanProperty[] settableBeanPropertyArr) {
        super((Class<?>) cls);
        this.h = annotatedMethod;
        this.f3986e = true;
        this.f3985d = javaType.u(String.class) ? null : javaType;
        this.f3987j = null;
        this.f3988k = stdValueInstantiator;
        this.f3989l = settableBeanPropertyArr;
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JavaType javaType;
        return (this.f3987j == null && (javaType = this.f3985d) != null && this.f3989l == null) ? new FactoryBasedEnumDeserializer(this, (b3.c<?>) deserializationContext.o(javaType, beanProperty)) : this;
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objV0;
        AnnotatedMethod annotatedMethod = this.h;
        Class<?> cls = this.f4054a;
        b3.c<?> cVar = this.f3987j;
        if (cVar != null) {
            objV0 = cVar.d(jsonParser, deserializationContext);
        } else {
            if (!this.f3986e) {
                jsonParser.v1();
                try {
                    return annotatedMethod.o();
                } catch (Exception e10) {
                    Throwable thQ = a.q(e10);
                    a.C(thQ);
                    deserializationContext.w(cls, thQ);
                    throw null;
                }
            }
            JsonToken jsonTokenK = jsonParser.K();
            SettableBeanProperty[] settableBeanPropertyArr = this.f3989l;
            if (settableBeanPropertyArr != null) {
                if (!jsonParser.m1()) {
                    deserializationContext.R("Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", a.r(g0(deserializationContext)), annotatedMethod, jsonParser.K());
                    throw null;
                }
                if (this.f3990m == null) {
                    this.f3990m = PropertyBasedCreator.b(deserializationContext, this.f3988k, settableBeanPropertyArr, deserializationContext.f3663c.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                }
                jsonParser.q1();
                PropertyBasedCreator propertyBasedCreator = this.f3990m;
                g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, null);
                JsonToken jsonTokenK2 = jsonParser.K();
                while (jsonTokenK2 == JsonToken.FIELD_NAME) {
                    String strC = jsonParser.C();
                    jsonParser.q1();
                    SettableBeanProperty settableBeanPropertyC = propertyBasedCreator.c(strC);
                    if ((!gVarD.d(strC) || settableBeanPropertyC != null) && settableBeanPropertyC != null) {
                        try {
                            gVarD.b(settableBeanPropertyC, settableBeanPropertyC.h(jsonParser, deserializationContext));
                        } catch (Exception e11) {
                            String str = settableBeanPropertyC.f3891c.f3755a;
                            Throwable thQ2 = a.q(e11);
                            a.B(thQ2);
                            boolean z = deserializationContext == null || deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS);
                            if (thQ2 instanceof IOException) {
                                if (!z || !(thQ2 instanceof JsonProcessingException)) {
                                    throw ((IOException) thQ2);
                                }
                            } else if (!z) {
                                a.D(thQ2);
                            }
                            int i10 = JsonMappingException.f3695d;
                            throw JsonMappingException.g(thQ2, new JsonMappingException.Reference(cls, str));
                        }
                    }
                    jsonTokenK2 = jsonParser.q1();
                }
                return propertyBasedCreator.a(deserializationContext, gVarD);
            }
            objV0 = (jsonTokenK == JsonToken.VALUE_STRING || jsonTokenK == JsonToken.FIELD_NAME) ? jsonParser.V0() : jsonTokenK == JsonToken.VALUE_NUMBER_INT ? jsonParser.P0() : jsonParser.f1();
        }
        try {
            return annotatedMethod.f4124d.invoke(cls, objV0);
        } catch (Exception e12) {
            Throwable thQ3 = a.q(e12);
            a.C(thQ3);
            if (deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL) && (thQ3 instanceof IllegalArgumentException)) {
                return null;
            }
            deserializationContext.w(cls, thQ3);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.f3988k;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return this.f3987j == null ? d(jsonParser, deserializationContext) : bVar.b(jsonParser, deserializationContext);
    }

    @Override // b3.c
    public final boolean n() {
        return true;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4435l;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }

    public FactoryBasedEnumDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod) {
        super(cls);
        this.h = annotatedMethod;
        this.f3986e = false;
        this.f3985d = null;
        this.f3987j = null;
        this.f3988k = null;
        this.f3989l = null;
    }

    public FactoryBasedEnumDeserializer(FactoryBasedEnumDeserializer factoryBasedEnumDeserializer, b3.c<?> cVar) {
        super(factoryBasedEnumDeserializer.f4054a);
        this.f3985d = factoryBasedEnumDeserializer.f3985d;
        this.h = factoryBasedEnumDeserializer.h;
        this.f3986e = factoryBasedEnumDeserializer.f3986e;
        this.f3988k = factoryBasedEnumDeserializer.f3988k;
        this.f3989l = factoryBasedEnumDeserializer.f3989l;
        this.f3987j = cVar;
    }
}
