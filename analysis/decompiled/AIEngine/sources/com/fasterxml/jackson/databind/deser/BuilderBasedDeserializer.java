package com.fasterxml.jackson.databind.deser;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import e3.a;
import f3.d;
import f3.f;
import f3.g;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BuilderBasedDeserializer extends BeanDeserializerBase {
    public final AnnotatedMethod B;
    public final JavaType C;

    public BuilderBasedDeserializer(a aVar, b3.a aVar2, JavaType javaType, BeanPropertyMap beanPropertyMap, HashMap map, HashSet hashSet, boolean z, HashSet hashSet2, boolean z3) {
        super(aVar, aVar2, beanPropertyMap, map, hashSet, z, hashSet2, z3);
        this.C = javaType;
        this.B = aVar.f8608m;
        if (this.z == null) {
            return;
        }
        throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + aVar2.f3041a + ")");
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase A0(BeanPropertyMap beanPropertyMap) {
        return new BuilderBasedDeserializer(this, beanPropertyMap);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final Object B(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        c<Object> cVar = this.f3857k;
        if (cVar != null || (cVar = this.f3856j) != null) {
            Object objU = this.h.u(deserializationContext, cVar.d(jsonParser, deserializationContext));
            if (this.f3862p != null) {
                z0(deserializationContext);
            }
            return J0(deserializationContext, objU);
        }
        CoercionAction coercionActionM = deserializationContext.m(LogicalType.f4431d, m(), CoercionInputShape.f3808d);
        boolean zJ = deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zJ || coercionActionM != CoercionAction.f3796a) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenQ1 == jsonToken) {
                int iOrdinal = coercionActionM.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return null;
                }
                if (iOrdinal == 3) {
                    return j(deserializationContext);
                }
                deserializationContext.B(g0(deserializationContext), JsonToken.START_ARRAY, jsonParser, null, new Object[0]);
                throw null;
            }
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            if (zJ) {
                Object objD = d(jsonParser2, deserializationContext2);
                if (jsonParser2.q1() == jsonToken) {
                    return objD;
                }
                h0(deserializationContext2);
                throw null;
            }
        } else {
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
        }
        deserializationContext2.A(jsonParser2, g0(deserializationContext2));
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase B0(Set<String> set, Set<String> set2) {
        return new BuilderBasedDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase C0() {
        return new BuilderBasedDeserializer(this);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase D0(ObjectIdReader objectIdReader) {
        return new BuilderBasedDeserializer(this, objectIdReader);
    }

    public final Object G0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        boolean z = this.f3859m;
        boolean z3 = this.f3866u;
        ValueInjector[] valueInjectorArr = this.f3862p;
        BeanPropertyMap beanPropertyMap = this.f3861o;
        ValueInstantiator valueInstantiator = this.h;
        if (!z) {
            Object objV = valueInstantiator.v(deserializationContext);
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            if (z3) {
                deserializationContext.getClass();
            }
            while (jsonParser.K() == JsonToken.FIELD_NAME) {
                String strC = jsonParser.C();
                jsonParser.q1();
                SettableBeanProperty settableBeanPropertyC = beanPropertyMap.c(strC);
                if (settableBeanPropertyC != null) {
                    try {
                        objV = settableBeanPropertyC.j(jsonParser, deserializationContext, objV);
                    } catch (Exception e10) {
                        BeanDeserializerBase.E0(deserializationContext, e10, objV, strC);
                        throw null;
                    }
                } else {
                    y0(jsonParser, deserializationContext, objV, strC);
                }
                jsonParser.q1();
            }
            return objV;
        }
        if (this.f3869x == null) {
            if (this.f3870y == null) {
                return t0(jsonParser, deserializationContext);
            }
            if (this.f3858l == null) {
                return H0(jsonParser, deserializationContext, valueInstantiator.v(deserializationContext));
            }
            deserializationContext.j(String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", this.C));
            throw null;
        }
        c<Object> cVar = this.f3856j;
        if (cVar != null) {
            return valueInstantiator.w(deserializationContext, cVar.d(jsonParser, deserializationContext));
        }
        PropertyBasedCreator propertyBasedCreator = this.f3858l;
        Set<String> set = this.f3864s;
        Set<String> set2 = this.r;
        if (propertyBasedCreator == null) {
            p pVar = new p(jsonParser, deserializationContext);
            pVar.c1();
            Object objV2 = valueInstantiator.v(deserializationContext);
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            if (z3) {
                deserializationContext.getClass();
            }
            while (jsonParser.K() == JsonToken.FIELD_NAME) {
                String strC2 = jsonParser.C();
                jsonParser.q1();
                SettableBeanProperty settableBeanPropertyC2 = beanPropertyMap.c(strC2);
                if (settableBeanPropertyC2 != null) {
                    try {
                        objV2 = settableBeanPropertyC2.j(jsonParser, deserializationContext, objV2);
                    } catch (Exception e11) {
                        BeanDeserializerBase.E0(deserializationContext, e11, objV2, strC2);
                        throw null;
                    }
                } else if (IgnorePropertiesUtil.b(strC2, set2, set)) {
                    v0(jsonParser, deserializationContext, objV2, strC2);
                } else {
                    pVar.H0(strC2);
                    pVar.u1(jsonParser);
                    SettableAnyProperty settableAnyProperty = this.f3863q;
                    if (settableAnyProperty != null) {
                        try {
                            settableAnyProperty.b(jsonParser, deserializationContext, objV2, strC2);
                        } catch (Exception e12) {
                            BeanDeserializerBase.E0(deserializationContext, e12, objV2, strC2);
                            throw null;
                        }
                    } else {
                        continue;
                    }
                }
                jsonParser.q1();
            }
            pVar.G0();
            this.f3869x.f(deserializationContext, objV2, pVar);
            return objV2;
        }
        g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, this.z);
        p pVar2 = new p(jsonParser, deserializationContext);
        pVar2.c1();
        JsonToken jsonTokenK = jsonParser.K();
        while (jsonTokenK == JsonToken.FIELD_NAME) {
            String strC3 = jsonParser.C();
            jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC3 = propertyBasedCreator.c(strC3);
            if (!gVarD.d(strC3) || settableBeanPropertyC3 != null) {
                JavaType javaType = this.f3854d;
                if (settableBeanPropertyC3 == null) {
                    SettableBeanProperty settableBeanPropertyC4 = beanPropertyMap.c(strC3);
                    if (settableBeanPropertyC4 != null) {
                        gVarD.c(settableBeanPropertyC4, settableBeanPropertyC4.h(jsonParser, deserializationContext));
                    } else if (IgnorePropertiesUtil.b(strC3, set2, set)) {
                        v0(jsonParser, deserializationContext, javaType.f3690a, strC3);
                    } else {
                        pVar2.H0(strC3);
                        pVar2.u1(jsonParser);
                        SettableAnyProperty settableAnyProperty2 = this.f3863q;
                        if (settableAnyProperty2 != null) {
                            gVarD.h = new f.a(gVarD.h, settableAnyProperty2.a(jsonParser, deserializationContext), settableAnyProperty2, strC3);
                        }
                    }
                } else if (gVarD.b(settableBeanPropertyC3, settableBeanPropertyC3.h(jsonParser, deserializationContext))) {
                    jsonParser.q1();
                    try {
                        Object objA = propertyBasedCreator.a(deserializationContext, gVarD);
                        return objA.getClass() != javaType.f3690a ? w0(jsonParser, deserializationContext, objA, pVar2) : I0(jsonParser, deserializationContext, objA, pVar2);
                    } catch (Exception e13) {
                        BeanDeserializerBase.E0(deserializationContext, e13, javaType.f3690a, strC3);
                        throw null;
                    }
                }
            }
            jsonTokenK = jsonParser.q1();
        }
        pVar2.G0();
        try {
            Object objA2 = propertyBasedCreator.a(deserializationContext, gVarD);
            this.f3869x.f(deserializationContext, objA2, pVar2);
            return objA2;
        } catch (Exception e14) {
            F0(e14, deserializationContext);
            throw null;
        }
    }

    public final Object H0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this.f3866u) {
            deserializationContext.getClass();
        }
        d dVar = this.f3870y;
        dVar.getClass();
        d dVar2 = new d(dVar);
        JsonToken jsonTokenK = jsonParser.K();
        while (jsonTokenK == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            JsonToken jsonTokenQ1 = jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC = this.f3861o.c(strC);
            if (settableBeanPropertyC != null) {
                if (jsonTokenQ1.f3600k) {
                    dVar2.f(jsonParser, deserializationContext, obj, strC);
                }
                try {
                    obj = settableBeanPropertyC.j(jsonParser, deserializationContext, obj);
                } catch (Exception e10) {
                    BeanDeserializerBase.E0(deserializationContext, e10, obj, strC);
                    throw null;
                }
            } else if (IgnorePropertiesUtil.b(strC, this.r, this.f3864s)) {
                v0(jsonParser, deserializationContext, obj, strC);
            } else if (dVar2.e(jsonParser, deserializationContext, obj, strC)) {
                continue;
            } else {
                SettableAnyProperty settableAnyProperty = this.f3863q;
                if (settableAnyProperty != null) {
                    try {
                        settableAnyProperty.b(jsonParser, deserializationContext, obj, strC);
                    } catch (Exception e11) {
                        BeanDeserializerBase.E0(deserializationContext, e11, obj, strC);
                        throw null;
                    }
                } else {
                    i0(jsonParser, deserializationContext, obj, strC);
                }
            }
            jsonTokenK = jsonParser.q1();
        }
        dVar2.d(jsonParser, deserializationContext, obj);
        return obj;
    }

    public final Object I0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, p pVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (this.f3866u) {
            deserializationContext.getClass();
        }
        JsonToken jsonTokenK = jsonParser.K();
        while (jsonTokenK == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            SettableBeanProperty settableBeanPropertyC = this.f3861o.c(strC);
            jsonParser.q1();
            if (settableBeanPropertyC != null) {
                try {
                    obj = settableBeanPropertyC.j(jsonParser, deserializationContext, obj);
                } catch (Exception e10) {
                    BeanDeserializerBase.E0(deserializationContext, e10, obj, strC);
                    throw null;
                }
            } else if (IgnorePropertiesUtil.b(strC, this.r, this.f3864s)) {
                v0(jsonParser, deserializationContext, obj, strC);
            } else {
                pVar.H0(strC);
                pVar.u1(jsonParser);
                SettableAnyProperty settableAnyProperty = this.f3863q;
                if (settableAnyProperty != null) {
                    settableAnyProperty.b(jsonParser, deserializationContext, obj, strC);
                }
            }
            jsonTokenK = jsonParser.q1();
        }
        pVar.G0();
        this.f3869x.f(deserializationContext, obj, pVar);
        return obj;
    }

    public final Object J0(DeserializationContext deserializationContext, Object obj) throws IOException {
        AnnotatedMethod annotatedMethod = this.B;
        if (annotatedMethod == null) {
            return obj;
        }
        try {
            return annotatedMethod.f4124d.invoke(obj, null);
        } catch (Exception e10) {
            this.F0(e10, deserializationContext);
            throw null;
        }
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.m1()) {
            switch (jsonParser.P()) {
                case 2:
                case 5:
                    return J0(deserializationContext, G0(jsonParser, deserializationContext));
                case 3:
                    return B(jsonParser, deserializationContext);
                case 4:
                case 11:
                default:
                    deserializationContext.A(jsonParser, g0(deserializationContext));
                    throw null;
                case 6:
                    return J0(deserializationContext, u0(jsonParser, deserializationContext));
                case 7:
                    return J0(deserializationContext, r0(jsonParser, deserializationContext));
                case 8:
                    return J0(deserializationContext, q0(jsonParser, deserializationContext));
                case 9:
                case 10:
                    return J0(deserializationContext, p0(jsonParser, deserializationContext));
                case 12:
                    return jsonParser.K0();
            }
        }
        jsonParser.q1();
        if (!this.f3860n) {
            return J0(deserializationContext, G0(jsonParser, deserializationContext));
        }
        Object objV = this.h.v(deserializationContext);
        while (jsonParser.K() == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC = this.f3861o.c(strC);
            if (settableBeanPropertyC != null) {
                try {
                    objV = settableBeanPropertyC.j(jsonParser, deserializationContext, objV);
                } catch (Exception e10) {
                    BeanDeserializerBase.E0(deserializationContext, e10, objV, strC);
                    throw null;
                }
            } else {
                y0(jsonParser, deserializationContext, objV, strC);
            }
            jsonParser.q1();
        }
        return J0(deserializationContext, objV);
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws InvalidDefinitionException {
        Class<?> cls = this.f3854d.f3690a;
        Class<?> cls2 = obj.getClass();
        boolean zIsAssignableFrom = cls.isAssignableFrom(cls2);
        JavaType javaType = this.C;
        if (zIsAssignableFrom) {
            deserializationContext.j(String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", javaType, cls.getName()));
            throw null;
        }
        deserializationContext.j(String.format("Deserialization of %s by passing existing instance (of %s) not supported", javaType, cls2.getName()));
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final Object k0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        PropertyBasedCreator propertyBasedCreator = this.f3858l;
        g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, this.z);
        boolean z = this.f3866u;
        if (z) {
            deserializationContext.getClass();
        }
        JsonToken jsonTokenK = jsonParser.K();
        p pVar = null;
        while (true) {
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            JavaType javaType = this.f3854d;
            if (jsonTokenK != jsonToken) {
                try {
                    Object objA = propertyBasedCreator.a(deserializationContext, gVarD);
                    if (pVar != null) {
                        if (objA.getClass() != javaType.f3690a) {
                            return w0(null, deserializationContext, objA, pVar);
                        }
                        x0(deserializationContext, objA, pVar);
                    }
                    return objA;
                } catch (Exception e10) {
                    F0(e10, deserializationContext);
                    throw null;
                }
            }
            String strC = jsonParser.C();
            jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC = propertyBasedCreator.c(strC);
            if (!gVarD.d(strC) || settableBeanPropertyC != null) {
                BeanPropertyMap beanPropertyMap = this.f3861o;
                if (settableBeanPropertyC == null) {
                    SettableBeanProperty settableBeanPropertyC2 = beanPropertyMap.c(strC);
                    if (settableBeanPropertyC2 != null) {
                        gVarD.c(settableBeanPropertyC2, settableBeanPropertyC2.h(jsonParser, deserializationContext));
                    } else if (IgnorePropertiesUtil.b(strC, this.r, this.f3864s)) {
                        v0(jsonParser, deserializationContext, javaType.f3690a, strC);
                    } else {
                        SettableAnyProperty settableAnyProperty = this.f3863q;
                        if (settableAnyProperty != null) {
                            gVarD.h = new f.a(gVarD.h, settableAnyProperty.a(jsonParser, deserializationContext), settableAnyProperty, strC);
                        } else {
                            if (pVar == null) {
                                pVar = new p(jsonParser, deserializationContext);
                            }
                            pVar.H0(strC);
                            pVar.u1(jsonParser);
                        }
                    }
                } else if (gVarD.b(settableBeanPropertyC, settableBeanPropertyC.h(jsonParser, deserializationContext))) {
                    jsonParser.q1();
                    try {
                        Object objA2 = propertyBasedCreator.a(deserializationContext, gVarD);
                        if (objA2.getClass() != javaType.f3690a) {
                            return w0(jsonParser, deserializationContext, objA2, pVar);
                        }
                        if (pVar != null) {
                            x0(deserializationContext, objA2, pVar);
                        }
                        if (this.f3862p != null) {
                            z0(deserializationContext);
                        }
                        if (this.f3869x != null) {
                            if (jsonParser.i1(JsonToken.START_OBJECT)) {
                                jsonParser.q1();
                            }
                            p pVar2 = new p(jsonParser, deserializationContext);
                            pVar2.c1();
                            return I0(jsonParser, deserializationContext, objA2, pVar2);
                        }
                        if (this.f3870y != null) {
                            return H0(jsonParser, deserializationContext, objA2);
                        }
                        if (z) {
                            deserializationContext.getClass();
                        }
                        JsonToken jsonTokenK2 = jsonParser.K();
                        if (jsonTokenK2 == JsonToken.START_OBJECT) {
                            jsonTokenK2 = jsonParser.q1();
                        }
                        while (jsonTokenK2 == JsonToken.FIELD_NAME) {
                            String strC2 = jsonParser.C();
                            jsonParser.q1();
                            SettableBeanProperty settableBeanPropertyC3 = beanPropertyMap.c(strC2);
                            if (settableBeanPropertyC3 != null) {
                                try {
                                    objA2 = settableBeanPropertyC3.j(jsonParser, deserializationContext, objA2);
                                } catch (Exception e11) {
                                    BeanDeserializerBase.E0(deserializationContext, e11, objA2, strC2);
                                    throw null;
                                }
                            } else {
                                y0(jsonParser, deserializationContext, objA2, strC2);
                            }
                            jsonTokenK2 = jsonParser.q1();
                        }
                        return objA2;
                    } catch (Exception e12) {
                        BeanDeserializerBase.E0(deserializationContext, e12, javaType.f3690a, strC);
                        throw null;
                    }
                }
            }
            jsonTokenK = jsonParser.q1();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase o0() {
        return new BeanAsArrayBuilderDeserializer(this, this.C, this.f3861o.h, this.B);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, b3.c
    public final c<Object> q(NameTransformer nameTransformer) {
        return new BuilderBasedDeserializer(this, nameTransformer);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer) {
        super((BeanDeserializerBase) builderBasedDeserializer, true);
        this.B = builderBasedDeserializer.B;
        this.C = builderBasedDeserializer.C;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, NameTransformer nameTransformer) {
        super(builderBasedDeserializer, nameTransformer);
        this.B = builderBasedDeserializer.B;
        this.C = builderBasedDeserializer.C;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, ObjectIdReader objectIdReader) {
        super(builderBasedDeserializer, objectIdReader);
        this.B = builderBasedDeserializer.B;
        this.C = builderBasedDeserializer.C;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set, Set<String> set2) {
        super(builderBasedDeserializer, set, set2);
        this.B = builderBasedDeserializer.B;
        this.C = builderBasedDeserializer.C;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, BeanPropertyMap beanPropertyMap) {
        super(builderBasedDeserializer, beanPropertyMap);
        this.B = builderBasedDeserializer.B;
        this.C = builderBasedDeserializer.C;
    }
}
