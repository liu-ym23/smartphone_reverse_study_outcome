package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.type.LogicalType;
import e3.c;
import e3.i;
import java.util.Collection;
import java.util.Objects;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements c {

    /* renamed from: k, reason: collision with root package name */
    public final b3.c<String> f4089k;

    /* renamed from: l, reason: collision with root package name */
    public final ValueInstantiator f4090l;

    /* renamed from: m, reason: collision with root package name */
    public final b3.c<Object> f4091m;

    /* JADX WARN: Multi-variable type inference failed */
    public StringCollectionDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, b3.c<?> cVar, b3.c<?> cVar2, i iVar, Boolean bool) {
        super(javaType, iVar, bool);
        this.f4089k = cVar2;
        this.f4090l = valueInstantiator;
        this.f4091m = cVar;
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        b3.c<Object> cVar;
        b3.c<?> cVarZ;
        b3.c<Object> cVarO;
        ValueInstantiator valueInstantiator = this.f4090l;
        if (valueInstantiator == null) {
            cVar = null;
        } else {
            if (valueInstantiator.x() != null) {
                cVarO = deserializationContext.o(valueInstantiator.y(), beanProperty);
            } else {
                if (valueInstantiator.A() != null) {
                    cVarO = deserializationContext.o(valueInstantiator.B(), beanProperty);
                }
                cVar = null;
            }
            cVar = cVarO;
        }
        JavaType javaTypeK = this.f3964d.k();
        b3.c<String> cVar2 = this.f4089k;
        if (cVar2 == null) {
            cVarZ = StdDeserializer.c0(deserializationContext, beanProperty, cVar2);
            if (cVarZ == null) {
                cVarZ = deserializationContext.o(javaTypeK, beanProperty);
            }
        } else {
            cVarZ = deserializationContext.z(cVar2, beanProperty, javaTypeK);
        }
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, Collection.class);
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3434a) : null;
        i iVarB0 = StdDeserializer.b0(deserializationContext, beanProperty, cVarZ);
        b3.c<?> cVar3 = com.fasterxml.jackson.databind.util.a.v(cVarZ) ? null : cVarZ;
        return (Objects.equals(this.f3966j, boolB) && this.f3965e == iVarB0 && cVar2 == cVar3 && this.f4091m == cVar) ? this : new StringCollectionDeserializer(this.f3964d, this.f4090l, cVar, cVar3, iVarB0, boolB);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ValueInstantiator valueInstantiator = this.f4090l;
        b3.c<Object> cVar = this.f4091m;
        return cVar != null ? (Collection) valueInstantiator.w(deserializationContext, cVar.d(jsonParser, deserializationContext)) : e(jsonParser, deserializationContext, (Collection) valueInstantiator.v(deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.f4090l;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.c(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public final b3.c<Object> j0() {
        return this.f4089k;
    }

    @Override // b3.c
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public final Collection<String> e(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws JsonMappingException {
        String strD;
        String strW;
        String strW2;
        boolean zL1 = jsonParser.l1();
        b3.c<String> cVar = this.f4089k;
        i iVar = this.f3965e;
        boolean z = this.h;
        if (!zL1) {
            Boolean bool = Boolean.TRUE;
            Boolean bool2 = this.f3966j;
            if (bool2 != bool && (bool2 != null || !deserializationContext.J(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
                if (jsonParser.i1(JsonToken.VALUE_STRING)) {
                    return D(jsonParser, deserializationContext);
                }
                deserializationContext.A(jsonParser, this.f3964d);
                throw null;
            }
            if (jsonParser.K() != JsonToken.VALUE_NULL) {
                try {
                    strW2 = cVar == null ? W(jsonParser, deserializationContext) : cVar.d(jsonParser, deserializationContext);
                } catch (Exception e10) {
                    throw JsonMappingException.h(e10, collection, collection.size());
                }
            } else if (!z) {
                strW2 = (String) iVar.a(deserializationContext);
            }
            collection.add(strW2);
            return collection;
        }
        if (cVar != null) {
            while (true) {
                try {
                    if (jsonParser.p1() == null) {
                        JsonToken jsonTokenK = jsonParser.K();
                        if (jsonTokenK == JsonToken.END_ARRAY) {
                            break;
                        }
                        if (jsonTokenK != JsonToken.VALUE_NULL) {
                            strD = cVar.d(jsonParser, deserializationContext);
                        } else if (!z) {
                            strD = (String) iVar.a(deserializationContext);
                        }
                    } else {
                        strD = cVar.d(jsonParser, deserializationContext);
                    }
                    collection.add(strD);
                } catch (Exception e11) {
                    throw JsonMappingException.h(e11, collection, collection.size());
                }
            }
        } else {
            while (true) {
                try {
                    String strP1 = jsonParser.p1();
                    if (strP1 != null) {
                        collection.add(strP1);
                    } else {
                        JsonToken jsonTokenK2 = jsonParser.K();
                        if (jsonTokenK2 == JsonToken.END_ARRAY) {
                            break;
                        }
                        if (jsonTokenK2 != JsonToken.VALUE_NULL) {
                            strW = W(jsonParser, deserializationContext);
                        } else if (!z) {
                            strW = (String) iVar.a(deserializationContext);
                        }
                        collection.add(strW);
                    }
                } catch (Exception e12) {
                    throw JsonMappingException.h(e12, collection, collection.size());
                }
            }
        }
        return collection;
    }

    @Override // b3.c
    public final boolean n() {
        return this.f4089k == null && this.f4091m == null;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4429b;
    }
}
