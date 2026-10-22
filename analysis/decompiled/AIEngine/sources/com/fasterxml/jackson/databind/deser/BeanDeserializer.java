package com.fasterxml.jackson.databind.deser;

import androidx.appcompat.widget.l;
import androidx.lifecycle.b;
import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.impl.a;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import e3.e;
import f3.d;
import f3.f;
import f3.g;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    public transient NullPointerException B;
    public volatile transient NameTransformer C;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends a.AbstractC0031a {

        /* renamed from: c, reason: collision with root package name */
        public final DeserializationContext f3851c;

        /* renamed from: d, reason: collision with root package name */
        public final SettableBeanProperty f3852d;

        /* renamed from: e, reason: collision with root package name */
        public Object f3853e;

        public a(DeserializationContext deserializationContext, UnresolvedForwardReference unresolvedForwardReference, JavaType javaType, SettableBeanProperty settableBeanProperty) {
            super(unresolvedForwardReference, javaType);
            this.f3851c = deserializationContext;
            this.f3852d = settableBeanProperty;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a.AbstractC0031a
        public final void a(Object obj, Object obj2) throws MismatchedInputException {
            Object obj3 = this.f3853e;
            SettableBeanProperty settableBeanProperty = this.f3852d;
            if (obj3 != null) {
                settableBeanProperty.z(obj3, obj2);
            } else {
                this.f3851c.Q(settableBeanProperty, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", settableBeanProperty.f3891c.f3755a, settableBeanProperty.n().getName());
                throw null;
            }
        }
    }

    public BeanDeserializer() {
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase A0(BeanPropertyMap beanPropertyMap) {
        return new BeanDeserializer(this, beanPropertyMap);
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
            return objU;
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
    public final BeanDeserializerBase B0(Set set, Set set2) {
        return new BeanDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase C0() {
        return new BeanDeserializer(this, true);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase D0(ObjectIdReader objectIdReader) {
        return new BeanDeserializer(this, objectIdReader);
    }

    public final Object G0(JsonParser jsonParser, DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws IOException {
        try {
            return settableBeanProperty.h(jsonParser, deserializationContext);
        } catch (Exception e10) {
            BeanDeserializerBase.E0(deserializationContext, e10, this.f3854d.f3690a, settableBeanProperty.f3891c.f3755a);
            throw null;
        }
    }

    public final Object H0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, d dVar) throws IOException {
        if (this.f3866u) {
            deserializationContext.getClass();
        }
        JsonToken jsonTokenK = jsonParser.K();
        while (jsonTokenK == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            JsonToken jsonTokenQ1 = jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC = this.f3861o.c(strC);
            if (settableBeanPropertyC != null) {
                if (jsonTokenQ1.f3600k) {
                    dVar.f(jsonParser, deserializationContext, obj, strC);
                }
                try {
                    settableBeanPropertyC.i(jsonParser, deserializationContext, obj);
                } catch (Exception e10) {
                    BeanDeserializerBase.E0(deserializationContext, e10, obj, strC);
                    throw null;
                }
            } else if (IgnorePropertiesUtil.b(strC, this.r, this.f3864s)) {
                v0(jsonParser, deserializationContext, obj, strC);
            } else if (dVar.e(jsonParser, deserializationContext, obj, strC)) {
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
        dVar.d(jsonParser, deserializationContext, obj);
        return obj;
    }

    public Object I0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objR0;
        ObjectIdReader objectIdReader = this.z;
        if (objectIdReader != null) {
            objectIdReader.f3930c.getClass();
        }
        boolean z = this.f3859m;
        ValueInjector[] valueInjectorArr = this.f3862p;
        boolean z3 = this.f3866u;
        ValueInstantiator valueInstantiator = this.h;
        BeanPropertyMap beanPropertyMap = this.f3861o;
        if (!z) {
            Object objV = valueInstantiator.v(deserializationContext);
            jsonParser.u1(objV);
            if (jsonParser.a() && (objR0 = jsonParser.R0()) != null) {
                m0(jsonParser, deserializationContext, objV, objR0);
            }
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            if (z3) {
                deserializationContext.getClass();
            }
            if (jsonParser.j1()) {
                String strC = jsonParser.C();
                do {
                    jsonParser.q1();
                    SettableBeanProperty settableBeanPropertyC = beanPropertyMap.c(strC);
                    if (settableBeanPropertyC != null) {
                        try {
                            settableBeanPropertyC.i(jsonParser, deserializationContext, objV);
                        } catch (Exception e10) {
                            BeanDeserializerBase.E0(deserializationContext, e10, objV, strC);
                            throw null;
                        }
                    } else {
                        y0(jsonParser, deserializationContext, objV, strC);
                    }
                    strC = jsonParser.o1();
                } while (strC != null);
            }
            return objV;
        }
        b bVar = this.f3869x;
        JavaType javaType = this.f3854d;
        Set<String> set = this.r;
        Set<String> set2 = this.f3864s;
        if (bVar == null) {
            d dVar = this.f3870y;
            if (dVar == null) {
                return t0(jsonParser, deserializationContext);
            }
            if (this.f3858l == null) {
                c<Object> cVar = this.f3856j;
                if (cVar != null) {
                    return valueInstantiator.w(deserializationContext, cVar.d(jsonParser, deserializationContext));
                }
                Object objV2 = valueInstantiator.v(deserializationContext);
                d dVar2 = this.f3870y;
                dVar2.getClass();
                H0(jsonParser, deserializationContext, objV2, new d(dVar2));
                return objV2;
            }
            d dVar3 = new d(dVar);
            PropertyBasedCreator propertyBasedCreator = this.f3858l;
            g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, objectIdReader);
            if (z3) {
                deserializationContext.getClass();
            }
            JsonToken jsonTokenK = jsonParser.K();
            while (jsonTokenK == JsonToken.FIELD_NAME) {
                String strC2 = jsonParser.C();
                JsonToken jsonTokenQ1 = jsonParser.q1();
                SettableBeanProperty settableBeanPropertyC2 = propertyBasedCreator.c(strC2);
                if (!gVarD.d(strC2) || settableBeanPropertyC2 != null) {
                    if (settableBeanPropertyC2 == null) {
                        SettableBeanProperty settableBeanPropertyC3 = beanPropertyMap.c(strC2);
                        if (settableBeanPropertyC3 != null) {
                            if (jsonTokenQ1.f3600k) {
                                dVar3.f(jsonParser, deserializationContext, null, strC2);
                            }
                            gVarD.c(settableBeanPropertyC3, settableBeanPropertyC3.h(jsonParser, deserializationContext));
                        } else if (!dVar3.e(jsonParser, deserializationContext, null, strC2)) {
                            if (IgnorePropertiesUtil.b(strC2, set, set2)) {
                                v0(jsonParser, deserializationContext, javaType.f3690a, strC2);
                            } else {
                                SettableAnyProperty settableAnyProperty = this.f3863q;
                                if (settableAnyProperty != null) {
                                    gVarD.h = new f.a(gVarD.h, settableAnyProperty.a(jsonParser, deserializationContext), settableAnyProperty, strC2);
                                } else {
                                    i0(jsonParser, deserializationContext, this.f4054a, strC2);
                                }
                            }
                        }
                    } else if (!dVar3.e(jsonParser, deserializationContext, null, strC2) && gVarD.b(settableBeanPropertyC2, G0(jsonParser, deserializationContext, settableBeanPropertyC2))) {
                        jsonParser.q1();
                        try {
                            Object objA = propertyBasedCreator.a(deserializationContext, gVarD);
                            if (objA.getClass() == javaType.f3690a) {
                                H0(jsonParser, deserializationContext, objA, dVar3);
                                return objA;
                            }
                            deserializationContext.j(String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", javaType, objA.getClass()));
                            throw null;
                        } catch (Exception e11) {
                            BeanDeserializerBase.E0(deserializationContext, e11, javaType.f3690a, strC2);
                            throw null;
                        }
                    }
                }
                jsonTokenK = jsonParser.q1();
            }
            try {
                return dVar3.c(jsonParser, deserializationContext, gVarD, propertyBasedCreator);
            } catch (Exception e12) {
                this.F0(e12, deserializationContext);
                throw null;
            }
        }
        c<Object> cVar2 = this.f3856j;
        if (cVar2 != null) {
            return valueInstantiator.w(deserializationContext, cVar2.d(jsonParser, deserializationContext));
        }
        PropertyBasedCreator propertyBasedCreator2 = this.f3858l;
        if (propertyBasedCreator2 == null) {
            p pVar = new p(jsonParser, deserializationContext);
            pVar.c1();
            Object objV3 = valueInstantiator.v(deserializationContext);
            jsonParser.u1(objV3);
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            if (z3) {
                deserializationContext.getClass();
            }
            String strC3 = jsonParser.j1() ? jsonParser.C() : null;
            while (strC3 != null) {
                jsonParser.q1();
                SettableBeanProperty settableBeanPropertyC4 = beanPropertyMap.c(strC3);
                if (settableBeanPropertyC4 != null) {
                    try {
                        settableBeanPropertyC4.i(jsonParser, deserializationContext, objV3);
                    } catch (Exception e13) {
                        BeanDeserializerBase.E0(deserializationContext, e13, objV3, strC3);
                        throw null;
                    }
                } else if (IgnorePropertiesUtil.b(strC3, set, set2)) {
                    v0(jsonParser, deserializationContext, objV3, strC3);
                } else if (this.f3863q == null) {
                    pVar.H0(strC3);
                    pVar.u1(jsonParser);
                } else {
                    p pVar2 = new p(jsonParser, null);
                    pVar2.u1(jsonParser);
                    pVar.H0(strC3);
                    pVar.r1(pVar2);
                    try {
                        SettableAnyProperty settableAnyProperty2 = this.f3863q;
                        p.a aVarT1 = pVar2.t1(pVar2.f11580b);
                        aVarT1.q1();
                        settableAnyProperty2.b(aVarT1, deserializationContext, objV3, strC3);
                    } catch (Exception e14) {
                        BeanDeserializerBase.E0(deserializationContext, e14, objV3, strC3);
                        throw null;
                    }
                }
                strC3 = jsonParser.o1();
            }
            pVar.G0();
            this.f3869x.f(deserializationContext, objV3, pVar);
            return objV3;
        }
        g gVarD2 = propertyBasedCreator2.d(jsonParser, deserializationContext, objectIdReader);
        p pVar3 = new p(jsonParser, deserializationContext);
        pVar3.c1();
        JsonToken jsonTokenK2 = jsonParser.K();
        while (jsonTokenK2 == JsonToken.FIELD_NAME) {
            String strC4 = jsonParser.C();
            jsonParser.q1();
            SettableBeanProperty settableBeanPropertyC5 = propertyBasedCreator2.c(strC4);
            if (!gVarD2.d(strC4) || settableBeanPropertyC5 != null) {
                if (settableBeanPropertyC5 == null) {
                    SettableBeanProperty settableBeanPropertyC6 = beanPropertyMap.c(strC4);
                    if (settableBeanPropertyC6 != null) {
                        gVarD2.c(settableBeanPropertyC6, G0(jsonParser, deserializationContext, settableBeanPropertyC6));
                    } else if (IgnorePropertiesUtil.b(strC4, set, set2)) {
                        v0(jsonParser, deserializationContext, javaType.f3690a, strC4);
                    } else if (this.f3863q == null) {
                        pVar3.H0(strC4);
                        pVar3.u1(jsonParser);
                    } else {
                        p pVar4 = new p(jsonParser, null);
                        pVar4.u1(jsonParser);
                        pVar3.H0(strC4);
                        pVar3.r1(pVar4);
                        try {
                            SettableAnyProperty settableAnyProperty3 = this.f3863q;
                            p.a aVarT12 = pVar4.t1(pVar4.f11580b);
                            aVarT12.q1();
                            gVarD2.h = new f.a(gVarD2.h, settableAnyProperty3.a(aVarT12, deserializationContext), settableAnyProperty3, strC4);
                        } catch (Exception e15) {
                            BeanDeserializerBase.E0(deserializationContext, e15, javaType.f3690a, strC4);
                            throw null;
                        }
                    }
                } else if (gVarD2.b(settableBeanPropertyC5, G0(jsonParser, deserializationContext, settableBeanPropertyC5))) {
                    JsonToken jsonTokenQ12 = jsonParser.q1();
                    try {
                        Object objA2 = propertyBasedCreator2.a(deserializationContext, gVarD2);
                        jsonParser.u1(objA2);
                        while (jsonTokenQ12 == JsonToken.FIELD_NAME) {
                            pVar3.u1(jsonParser);
                            jsonTokenQ12 = jsonParser.q1();
                        }
                        JsonToken jsonToken = JsonToken.END_OBJECT;
                        if (jsonTokenQ12 != jsonToken) {
                            deserializationContext.T(this, jsonToken, "Attempted to unwrap '%s' value", javaType.f3690a.getName());
                            throw null;
                        }
                        pVar3.G0();
                        if (objA2.getClass() == javaType.f3690a) {
                            this.f3869x.f(deserializationContext, objA2, pVar3);
                            return objA2;
                        }
                        deserializationContext.Q(settableBeanPropertyC5, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                        throw null;
                    } catch (Exception e16) {
                        F0(e16, deserializationContext);
                        throw null;
                    }
                }
            }
            jsonTokenK2 = jsonParser.q1();
        }
        try {
            Object objA3 = propertyBasedCreator2.a(deserializationContext, gVarD2);
            this.f3869x.f(deserializationContext, objA3, pVar3);
            return objA3;
        } catch (Exception e17) {
            F0(e17, deserializationContext);
            throw null;
        }
    }

    public final Object J0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objV = this.h.v(deserializationContext);
        jsonParser.u1(objV);
        if (jsonParser.j1()) {
            String strC = jsonParser.C();
            do {
                jsonParser.q1();
                SettableBeanProperty settableBeanPropertyC = this.f3861o.c(strC);
                if (settableBeanPropertyC != null) {
                    try {
                        settableBeanPropertyC.i(jsonParser, deserializationContext, objV);
                    } catch (Exception e10) {
                        BeanDeserializerBase.E0(deserializationContext, e10, objV, strC);
                        throw null;
                    }
                } else {
                    y0(jsonParser, deserializationContext, objV, strC);
                }
                strC = jsonParser.o1();
            } while (strC != null);
        }
        return objV;
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objI0;
        boolean zM1 = jsonParser.m1();
        ObjectIdReader objectIdReader = this.z;
        if (zM1) {
            if (this.f3860n) {
                jsonParser.q1();
                return J0(jsonParser, deserializationContext);
            }
            jsonParser.q1();
            return objectIdReader != null ? I0(jsonParser, deserializationContext) : I0(jsonParser, deserializationContext);
        }
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK != null) {
            switch (jsonTokenK.ordinal()) {
                case 2:
                case 5:
                    return this.f3860n ? J0(jsonParser, deserializationContext) : objectIdReader != null ? I0(jsonParser, deserializationContext) : I0(jsonParser, deserializationContext);
                case 3:
                    return B(jsonParser, deserializationContext);
                case 6:
                    if (objectIdReader != null) {
                        return s0(jsonParser, deserializationContext);
                    }
                    c<Object> cVarJ0 = j0();
                    if (cVarJ0 != null) {
                        ValueInstantiator valueInstantiator = this.h;
                        if (!valueInstantiator.h()) {
                            Object objW = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
                            if (this.f3862p != null) {
                                z0(deserializationContext);
                            }
                            return objW;
                        }
                    }
                    Object objK0 = jsonParser.K0();
                    if (objK0 != null) {
                        Class<?> cls = objK0.getClass();
                        JavaType javaType = this.f3854d;
                        if (!javaType.E(cls)) {
                            deserializationContext.f3663c.getClass();
                            Class<?> cls2 = javaType.f3690a;
                            for (l lVar = null; lVar != null; lVar = (l) lVar.h) {
                                ((e) lVar.f887g).getClass();
                            }
                            throw new InvalidFormatException(deserializationContext.h, h0.e.c("Cannot deserialize value of type ", com.fasterxml.jackson.databind.util.a.y(cls2), " from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type ", com.fasterxml.jackson.databind.util.a.f(objK0), ": incompatible types"), objK0);
                        }
                    }
                    return objK0;
                case 7:
                    return u0(jsonParser, deserializationContext);
                case 8:
                    return r0(jsonParser, deserializationContext);
                case 9:
                    return q0(jsonParser, deserializationContext);
                case 10:
                case 11:
                    return p0(jsonParser, deserializationContext);
                case 12:
                    if (!jsonParser.t1()) {
                        deserializationContext.A(jsonParser, g0(deserializationContext));
                        throw null;
                    }
                    p pVar = new p(jsonParser, deserializationContext);
                    pVar.G0();
                    p.a aVarS1 = pVar.s1(jsonParser);
                    aVarS1.q1();
                    if (this.f3860n) {
                        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                        objI0 = J0(aVarS1, deserializationContext);
                    } else {
                        objI0 = I0(aVarS1, deserializationContext);
                    }
                    aVarS1.close();
                    return objI0;
            }
        }
        deserializationContext.A(jsonParser, g0(deserializationContext));
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // b3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(com.fasterxml.jackson.core.JsonParser r8, com.fasterxml.jackson.databind.DeserializationContext r9, java.lang.Object r10) throws java.io.IOException {
        /*
            r7 = this;
            r8.u1(r10)
            com.fasterxml.jackson.databind.deser.impl.ValueInjector[] r0 = r7.f3862p
            if (r0 == 0) goto La
            r7.z0(r9)
        La:
            androidx.lifecycle.b r0 = r7.f3869x
            r1 = 0
            com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap r2 = r7.f3861o
            boolean r3 = r7.f3866u
            if (r0 == 0) goto L8e
            com.fasterxml.jackson.core.JsonToken r0 = r8.K()
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            if (r0 != r4) goto L1f
            com.fasterxml.jackson.core.JsonToken r0 = r8.q1()
        L1f:
            q3.p r4 = new q3.p
            r4.<init>(r8, r9)
            r4.c1()
            if (r3 == 0) goto L2c
            r9.getClass()
        L2c:
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r0 != r3) goto L85
            java.lang.String r0 = r8.C()
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r3 = r2.c(r0)
            r8.q1()
            if (r3 == 0) goto L46
            r3.i(r8, r9, r10)     // Catch: java.lang.Exception -> L41
            goto L7b
        L41:
            r7 = move-exception
            com.fasterxml.jackson.databind.deser.BeanDeserializerBase.E0(r9, r7, r10, r0)
            throw r1
        L46:
            java.util.Set<java.lang.String> r3 = r7.r
            java.util.Set<java.lang.String> r5 = r7.f3864s
            boolean r3 = com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.b(r0, r3, r5)
            if (r3 == 0) goto L54
            r7.v0(r8, r9, r10, r0)
            goto L7b
        L54:
            com.fasterxml.jackson.databind.deser.SettableAnyProperty r3 = r7.f3863q
            if (r3 != 0) goto L5f
            r4.H0(r0)
            r4.u1(r8)
            goto L7b
        L5f:
            q3.p r3 = new q3.p
            r3.<init>(r8, r1)
            r3.u1(r8)
            r4.H0(r0)
            r4.r1(r3)
            com.fasterxml.jackson.databind.deser.SettableAnyProperty r5 = r7.f3863q     // Catch: java.lang.Exception -> L80
            v2.c r6 = r3.f11580b     // Catch: java.lang.Exception -> L80
            q3.p$a r3 = r3.t1(r6)     // Catch: java.lang.Exception -> L80
            r3.q1()     // Catch: java.lang.Exception -> L80
            r5.b(r3, r9, r10, r0)     // Catch: java.lang.Exception -> L80
        L7b:
            com.fasterxml.jackson.core.JsonToken r0 = r8.q1()
            goto L2c
        L80:
            r7 = move-exception
            com.fasterxml.jackson.databind.deser.BeanDeserializerBase.E0(r9, r7, r10, r0)
            throw r1
        L85:
            r4.G0()
            androidx.lifecycle.b r7 = r7.f3869x
            r7.f(r9, r10, r4)
            return r10
        L8e:
            f3.d r0 = r7.f3870y
            if (r0 == 0) goto L9e
            r0.getClass()
            f3.d r1 = new f3.d
            r1.<init>(r0)
            r7.H0(r8, r9, r10, r1)
            return r10
        L9e:
            boolean r0 = r8.m1()
            if (r0 == 0) goto Lab
            java.lang.String r0 = r8.o1()
            if (r0 != 0) goto Lb5
            goto Ld5
        Lab:
            boolean r0 = r8.j1()
            if (r0 == 0) goto Ld5
            java.lang.String r0 = r8.C()
        Lb5:
            if (r3 == 0) goto Lba
            r9.getClass()
        Lba:
            r8.q1()
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r3 = r2.c(r0)
            if (r3 == 0) goto Lcc
            r3.i(r8, r9, r10)     // Catch: java.lang.Exception -> Lc7
            goto Lcf
        Lc7:
            r7 = move-exception
            com.fasterxml.jackson.databind.deser.BeanDeserializerBase.E0(r9, r7, r10, r0)
            throw r1
        Lcc:
            r7.y0(r8, r9, r10, r0)
        Lcf:
            java.lang.String r0 = r8.o1()
            if (r0 != 0) goto Lba
        Ld5:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializer.e(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object):java.lang.Object");
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final Object k0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        PropertyBasedCreator propertyBasedCreator = this.f3858l;
        g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, this.z);
        if (this.f3866u) {
            deserializationContext.getClass();
        }
        JsonToken jsonTokenK = jsonParser.K();
        ArrayList arrayList = null;
        p pVar = null;
        while (true) {
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            JavaType javaType = this.f3854d;
            if (jsonTokenK != jsonToken) {
                try {
                    Object objA = propertyBasedCreator.a(deserializationContext, gVarD);
                    if (this.f3862p != null) {
                        z0(deserializationContext);
                    }
                    if (arrayList != null) {
                        int size = arrayList.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = arrayList.get(i10);
                            i10++;
                            ((a) obj).f3853e = objA;
                        }
                    }
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
                if (settableBeanPropertyC == null) {
                    SettableBeanProperty settableBeanPropertyC2 = this.f3861o.c(strC);
                    if (settableBeanPropertyC2 != null) {
                        try {
                            gVarD.c(settableBeanPropertyC2, G0(jsonParser, deserializationContext, settableBeanPropertyC2));
                        } catch (UnresolvedForwardReference e11) {
                            a aVar = new a(deserializationContext, e11, settableBeanPropertyC2.f3892d, settableBeanPropertyC2);
                            e11.f3900e.a(aVar);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(aVar);
                        }
                    } else if (IgnorePropertiesUtil.b(strC, this.r, this.f3864s)) {
                        v0(jsonParser, deserializationContext, javaType.f3690a, strC);
                    } else {
                        SettableAnyProperty settableAnyProperty = this.f3863q;
                        if (settableAnyProperty != null) {
                            try {
                                gVarD.h = new f.a(gVarD.h, settableAnyProperty.a(jsonParser, deserializationContext), settableAnyProperty, strC);
                            } catch (Exception e12) {
                                BeanDeserializerBase.E0(deserializationContext, e12, javaType.f3690a, strC);
                                throw null;
                            }
                        } else {
                            if (pVar == null) {
                                pVar = new p(jsonParser, deserializationContext);
                            }
                            pVar.H0(strC);
                            pVar.u1(jsonParser);
                        }
                    }
                } else if (gVarD.b(settableBeanPropertyC, G0(jsonParser, deserializationContext, settableBeanPropertyC))) {
                    jsonParser.q1();
                    try {
                        Object objA2 = propertyBasedCreator.a(deserializationContext, gVarD);
                        if (objA2 == null) {
                            Class<?> cls = javaType.f3690a;
                            if (this.B == null) {
                                this.B = new NullPointerException("JSON Creator returned null");
                            }
                            deserializationContext.w(cls, this.B);
                            throw null;
                        }
                        jsonParser.u1(objA2);
                        if (objA2.getClass() != javaType.f3690a) {
                            return w0(jsonParser, deserializationContext, objA2, pVar);
                        }
                        if (pVar != null) {
                            x0(deserializationContext, objA2, pVar);
                        }
                        e(jsonParser, deserializationContext, objA2);
                        return objA2;
                    } catch (Exception e13) {
                        F0(e13, deserializationContext);
                        throw null;
                    }
                }
            }
            jsonTokenK = jsonParser.q1();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase o0() {
        return new BeanAsArrayDeserializer(this, this.f3861o.h);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, b3.c
    public c<Object> q(NameTransformer nameTransformer) {
        if (getClass() != BeanDeserializer.class || this.C == nameTransformer) {
            return this;
        }
        this.C = nameTransformer;
        try {
            return new BeanDeserializer(this, nameTransformer);
        } finally {
            this.C = null;
        }
    }
}
