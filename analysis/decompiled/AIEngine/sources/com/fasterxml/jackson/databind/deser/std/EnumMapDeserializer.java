package com.fasterxml.jackson.databind.deser.std;

import b3.g;
import com.fasterxml.jackson.core.JsonParser;
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
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.a;
import e3.c;
import e3.i;
import e3.j;
import f3.f;
import java.io.IOException;
import java.util.EnumMap;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EnumMapDeserializer extends ContainerDeserializerBase<EnumMap<?, ?>> implements c, j {

    /* renamed from: k, reason: collision with root package name */
    public final Class<?> f3974k;

    /* renamed from: l, reason: collision with root package name */
    public final g f3975l;

    /* renamed from: m, reason: collision with root package name */
    public final b3.c<Object> f3976m;

    /* renamed from: n, reason: collision with root package name */
    public final b f3977n;

    /* renamed from: o, reason: collision with root package name */
    public final ValueInstantiator f3978o;

    /* renamed from: p, reason: collision with root package name */
    public b3.c<Object> f3979p;

    /* renamed from: q, reason: collision with root package name */
    public PropertyBasedCreator f3980q;

    public EnumMapDeserializer(MapType mapType, ValueInstantiator valueInstantiator, b3.c cVar, b bVar) {
        super(mapType, (i) null, (Boolean) null);
        this.f3974k = mapType.f4441m.f3690a;
        this.f3975l = null;
        this.f3976m = cVar;
        this.f3977n = bVar;
        this.f3978o = valueInstantiator;
    }

    @Override // e3.j
    public final void b(DeserializationContext deserializationContext) throws InvalidDefinitionException {
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        ValueInstantiator valueInstantiator = this.f3978o;
        if (valueInstantiator != null) {
            boolean zK = valueInstantiator.k();
            JavaType javaType = this.f3964d;
            if (zK) {
                JavaType javaTypeB = valueInstantiator.B();
                if (javaTypeB != null) {
                    this.f3979p = deserializationContext.o(javaTypeB, null);
                    return;
                } else {
                    deserializationContext.j(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, valueInstantiator.getClass().getName()));
                    throw null;
                }
            }
            if (!valueInstantiator.i()) {
                if (valueInstantiator.g()) {
                    this.f3980q = PropertyBasedCreator.b(deserializationContext, valueInstantiator, valueInstantiator.C(deserializationConfig), deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                }
            } else {
                JavaType javaTypeY = valueInstantiator.y();
                if (javaTypeY != null) {
                    this.f3979p = deserializationContext.o(javaTypeY, null);
                } else {
                    deserializationContext.j(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType, valueInstantiator.getClass().getName()));
                    throw null;
                }
            }
        }
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        JavaType javaType = this.f3964d;
        g gVar = this.f3975l;
        g gVarQ = gVar == null ? deserializationContext.q(javaType.o(), beanProperty) : gVar;
        JavaType javaTypeK = javaType.k();
        b3.c<?> cVar = this.f3976m;
        b3.c<?> cVarO = cVar == null ? deserializationContext.o(javaTypeK, beanProperty) : deserializationContext.z(cVar, beanProperty, javaTypeK);
        b bVar = this.f3977n;
        b bVarF = bVar != null ? bVar.f(beanProperty) : bVar;
        i iVarB0 = StdDeserializer.b0(deserializationContext, beanProperty, cVarO);
        return (gVarQ == gVar && iVarB0 == this.f3965e && cVarO == cVar && bVarF == bVar) ? this : new EnumMapDeserializer(this, gVarQ, cVarO, bVarF, iVarB0);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objD;
        PropertyBasedCreator propertyBasedCreator = this.f3980q;
        if (propertyBasedCreator == null) {
            b3.c<Object> cVar = this.f3979p;
            if (cVar != null) {
                return (EnumMap) this.f3978o.w(deserializationContext, cVar.d(jsonParser, deserializationContext));
            }
            int iP = jsonParser.P();
            if (iP != 1 && iP != 2) {
                if (iP == 3) {
                    return B(jsonParser, deserializationContext);
                }
                if (iP != 5) {
                    if (iP == 6) {
                        return D(jsonParser, deserializationContext);
                    }
                    deserializationContext.A(jsonParser, g0(deserializationContext));
                    throw null;
                }
            }
            EnumMap<?, ?> enumMapL0 = l0(deserializationContext);
            m0(jsonParser, deserializationContext, enumMapL0);
            return enumMapL0;
        }
        f3.g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, null);
        String strO1 = jsonParser.m1() ? jsonParser.o1() : jsonParser.i1(JsonToken.FIELD_NAME) ? jsonParser.C() : null;
        while (true) {
            JavaType javaType = this.f3964d;
            if (strO1 == null) {
                try {
                    return (EnumMap) propertyBasedCreator.a(deserializationContext, gVarD);
                } catch (Exception e10) {
                    ContainerDeserializerBase.k0(deserializationContext, e10, javaType.f3690a, strO1);
                    throw null;
                }
            }
            JsonToken jsonTokenQ1 = jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC = propertyBasedCreator.c(strO1);
            if (settableBeanPropertyC == null) {
                Enum r62 = (Enum) this.f3975l.a(deserializationContext, strO1);
                if (r62 != null) {
                    try {
                        if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                            b bVar = this.f3977n;
                            b3.c<Object> cVar2 = this.f3976m;
                            objD = bVar == null ? cVar2.d(jsonParser, deserializationContext) : cVar2.f(jsonParser, deserializationContext, bVar);
                        } else if (!this.h) {
                            objD = this.f3965e.a(deserializationContext);
                        }
                        gVarD.h = new f.b(gVarD.h, objD, r62);
                    } catch (Exception e11) {
                        ContainerDeserializerBase.k0(deserializationContext, e11, javaType.f3690a, strO1);
                        throw null;
                    }
                } else {
                    if (!deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                        deserializationContext.G(this.f3974k, strO1, "value not one of declared Enum instance names for %s", javaType.o());
                        throw null;
                    }
                    jsonParser.q1();
                    jsonParser.v1();
                }
            } else if (gVarD.b(settableBeanPropertyC, settableBeanPropertyC.h(jsonParser, deserializationContext))) {
                jsonParser.q1();
                try {
                    EnumMap enumMap = (EnumMap) propertyBasedCreator.a(deserializationContext, gVarD);
                    m0(jsonParser, deserializationContext, enumMap);
                    return enumMap;
                } catch (Exception e12) {
                    ContainerDeserializerBase.k0(deserializationContext, e12, javaType.f3690a, strO1);
                    throw null;
                }
            }
            strO1 = jsonParser.o1();
        }
    }

    @Override // b3.c
    public final /* bridge */ /* synthetic */ Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        EnumMap enumMap = (EnumMap) obj;
        m0(jsonParser, deserializationContext, enumMap);
        return enumMap;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.f3978o;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return l0(deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public final b3.c<Object> j0() {
        return this.f3976m;
    }

    public final EnumMap<?, ?> l0(DeserializationContext deserializationContext) throws JsonMappingException {
        ValueInstantiator valueInstantiator = this.f3978o;
        if (valueInstantiator == null) {
            return new EnumMap<>(this.f3974k);
        }
        try {
            if (valueInstantiator.j()) {
                return (EnumMap) valueInstantiator.v(deserializationContext);
            }
            deserializationContext.x(this.f4054a, valueInstantiator, "no default constructor found", new Object[0]);
            throw null;
        } catch (IOException e10) {
            a.A(deserializationContext, e10);
            throw null;
        }
    }

    public final void m0(JsonParser jsonParser, DeserializationContext deserializationContext, EnumMap enumMap) throws IOException {
        String strC;
        Object objD;
        jsonParser.u1(enumMap);
        if (jsonParser.m1()) {
            strC = jsonParser.o1();
        } else {
            JsonToken jsonTokenK = jsonParser.K();
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenK != jsonToken) {
                if (jsonTokenK == JsonToken.END_OBJECT) {
                    return;
                }
                deserializationContext.T(this, jsonToken, null, new Object[0]);
                throw null;
            }
            strC = jsonParser.C();
        }
        while (strC != null) {
            Enum r22 = (Enum) this.f3975l.a(deserializationContext, strC);
            JsonToken jsonTokenQ1 = jsonParser.q1();
            if (r22 != null) {
                try {
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                        b3.c<Object> cVar = this.f3976m;
                        b bVar = this.f3977n;
                        objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                    } else if (!this.h) {
                        objD = this.f3965e.a(deserializationContext);
                    }
                    enumMap.put((EnumMap) r22, (Enum) objD);
                } catch (Exception e10) {
                    ContainerDeserializerBase.k0(deserializationContext, e10, enumMap, strC);
                    throw null;
                }
            } else {
                if (!deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    deserializationContext.G(this.f3974k, strC, "value not one of declared Enum instance names for %s", this.f3964d.o());
                    throw null;
                }
                jsonParser.v1();
            }
            strC = jsonParser.o1();
        }
    }

    @Override // b3.c
    public final boolean n() {
        return this.f3976m == null && this.f3975l == null && this.f3977n == null;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4430c;
    }

    public EnumMapDeserializer(EnumMapDeserializer enumMapDeserializer, g gVar, b3.c<?> cVar, b bVar, i iVar) {
        super(enumMapDeserializer, iVar, enumMapDeserializer.f3966j);
        this.f3974k = enumMapDeserializer.f3974k;
        this.f3975l = gVar;
        this.f3976m = cVar;
        this.f3977n = bVar;
        this.f3978o = enumMapDeserializer.f3978o;
        this.f3979p = enumMapDeserializer.f3979p;
        this.f3980q = enumMapDeserializer.f3980q;
    }
}
