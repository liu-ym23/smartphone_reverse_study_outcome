package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import e3.c;
import e3.i;
import java.util.EnumSet;
import java.util.Objects;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> implements c {

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3981d;

    /* renamed from: e, reason: collision with root package name */
    public final b3.c<Enum<?>> f3982e;
    public final i h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3983j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f3984k;

    public EnumSetDeserializer(JavaType javaType) {
        super((Class<?>) EnumSet.class);
        this.f3981d = javaType;
        if (!javaType.z()) {
            throw new IllegalArgumentException("Type " + javaType + " not Java Enum type");
        }
        this.f3982e = null;
        this.f3984k = null;
        this.h = null;
        this.f3983j = false;
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, EnumSet.class);
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3434a) : null;
        JavaType javaType = this.f3981d;
        b3.c<Enum<?>> cVar = this.f3982e;
        b3.c<?> cVarO = cVar == null ? deserializationContext.o(javaType, beanProperty) : deserializationContext.z(cVar, beanProperty, javaType);
        return (Objects.equals(this.f3984k, boolB) && cVar == cVarO && this.h == cVarO) ? this : new EnumSetDeserializer(this, cVarO, StdDeserializer.b0(deserializationContext, beanProperty, cVarO), boolB);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        EnumSet enumSetNoneOf = EnumSet.noneOf(this.f3981d.f3690a);
        if (jsonParser.l1()) {
            j0(jsonParser, deserializationContext, enumSetNoneOf);
            return enumSetNoneOf;
        }
        k0(jsonParser, deserializationContext, enumSetNoneOf);
        return enumSetNoneOf;
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        EnumSet enumSet = (EnumSet) obj;
        if (jsonParser.l1()) {
            j0(jsonParser, deserializationContext, enumSet);
            return enumSet;
        }
        k0(jsonParser, deserializationContext, enumSet);
        return enumSet;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.c(jsonParser, deserializationContext);
    }

    @Override // b3.c
    public final AccessPattern i() {
        return AccessPattern.f4493c;
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return EnumSet.noneOf(this.f3981d.f3690a);
    }

    public final void j0(JsonParser jsonParser, DeserializationContext deserializationContext, EnumSet enumSet) throws JsonMappingException {
        Enum<?> enumD;
        while (true) {
            try {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                    return;
                }
                if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                    enumD = this.f3982e.d(jsonParser, deserializationContext);
                } else if (!this.f3983j) {
                    enumD = (Enum) this.h.a(deserializationContext);
                }
                if (enumD != null) {
                    enumSet.add(enumD);
                }
            } catch (Exception e10) {
                throw JsonMappingException.h(e10, enumSet, enumSet.size());
            }
        }
    }

    public final void k0(JsonParser jsonParser, DeserializationContext deserializationContext, EnumSet enumSet) throws JsonMappingException {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = this.f3984k;
        if (bool2 != bool && (bool2 != null || !deserializationContext.J(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            deserializationContext.C(EnumSet.class, jsonParser);
            throw null;
        }
        if (jsonParser.i1(JsonToken.VALUE_NULL)) {
            deserializationContext.A(jsonParser, this.f3981d);
            throw null;
        }
        try {
            Enum<?> enumD = this.f3982e.d(jsonParser, deserializationContext);
            if (enumD != null) {
                enumSet.add(enumD);
            }
        } catch (Exception e10) {
            throw JsonMappingException.h(e10, enumSet, enumSet.size());
        }
    }

    @Override // b3.c
    public final boolean n() {
        return this.f3981d.f3692c == null;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4429b;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnumSetDeserializer(EnumSetDeserializer enumSetDeserializer, b3.c<?> cVar, i iVar, Boolean bool) {
        super(enumSetDeserializer);
        this.f3981d = enumSetDeserializer.f3981d;
        this.f3982e = cVar;
        this.h = iVar;
        this.f3983j = NullsConstantProvider.b(iVar);
        this.f3984k = bool;
    }
}
