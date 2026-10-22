package com.fasterxml.jackson.databind.deser;

import androidx.lifecycle.b;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import e3.a;
import e3.c;
import e3.j;
import f3.d;
import h0.e;
import i3.h;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BeanDeserializerBase extends StdDeserializer<Object> implements c, j, Serializable {
    public static final PropertyName A = new PropertyName("#temporary-name", null);

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3854d;

    /* renamed from: e, reason: collision with root package name */
    public final JsonFormat.Shape f3855e;
    public final ValueInstantiator h;

    /* renamed from: j, reason: collision with root package name */
    public b3.c<Object> f3856j;

    /* renamed from: k, reason: collision with root package name */
    public b3.c<Object> f3857k;

    /* renamed from: l, reason: collision with root package name */
    public PropertyBasedCreator f3858l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3859m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3860n;

    /* renamed from: o, reason: collision with root package name */
    public final BeanPropertyMap f3861o;

    /* renamed from: p, reason: collision with root package name */
    public final ValueInjector[] f3862p;

    /* renamed from: q, reason: collision with root package name */
    public SettableAnyProperty f3863q;
    public final Set<String> r;

    /* renamed from: s, reason: collision with root package name */
    public final Set<String> f3864s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f3865t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f3866u;

    /* renamed from: v, reason: collision with root package name */
    public final Map<String, SettableBeanProperty> f3867v;

    /* renamed from: w, reason: collision with root package name */
    public transient HashMap<ClassKey, b3.c<Object>> f3868w;

    /* renamed from: x, reason: collision with root package name */
    public b f3869x;

    /* renamed from: y, reason: collision with root package name */
    public d f3870y;
    public final ObjectIdReader z;

    public BeanDeserializerBase(a aVar, b3.a aVar2, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z, Set<String> set2, boolean z3) {
        super(aVar2.f3041a);
        this.f3854d = aVar2.f3041a;
        ValueInstantiator valueInstantiator = aVar.f8604i;
        this.h = valueInstantiator;
        ValueInjector[] valueInjectorArr = null;
        this.f3856j = null;
        this.f3857k = null;
        this.f3858l = null;
        this.f3861o = beanPropertyMap;
        this.f3867v = map;
        this.r = set;
        this.f3865t = z;
        this.f3864s = set2;
        this.f3863q = aVar.f8606k;
        ArrayList arrayList = aVar.f8601e;
        if (arrayList != null && !arrayList.isEmpty()) {
            valueInjectorArr = (ValueInjector[]) arrayList.toArray(new ValueInjector[arrayList.size()]);
        }
        this.f3862p = valueInjectorArr;
        ObjectIdReader objectIdReader = aVar.f8605j;
        this.z = objectIdReader;
        this.f3859m = this.f3869x != null || valueInstantiator.k() || valueInstantiator.g() || !valueInstantiator.j();
        this.f3855e = aVar2.a().f3451b;
        this.f3866u = z3;
        this.f3860n = !this.f3859m && valueInjectorArr == null && !z3 && objectIdReader == null;
    }

    public static void E0(DeserializationContext deserializationContext, Exception exc, Object obj, String str) throws IOException {
        Exception cause = exc;
        while ((cause instanceof InvocationTargetException) && cause.getCause() != null) {
            cause = cause.getCause();
        }
        com.fasterxml.jackson.databind.util.a.B(cause);
        boolean z = deserializationContext == null || deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS);
        if (cause instanceof IOException) {
            if (!z || !(cause instanceof JsonProcessingException)) {
                throw ((IOException) cause);
            }
        } else if (!z) {
            com.fasterxml.jackson.databind.util.a.D(cause);
        }
        int i10 = JsonMappingException.f3695d;
        throw JsonMappingException.g(cause, new JsonMappingException.Reference(obj, str));
    }

    public static b3.c l0(DeserializationContext deserializationContext, JavaType javaType, AnnotatedWithParams annotatedWithParams) {
        BeanProperty.Std std = new BeanProperty.Std(A, javaType, null, annotatedWithParams, PropertyMetadata.f3743l);
        k3.b bVarC = (k3.b) javaType.f3693d;
        if (bVarC == null) {
            DeserializationConfig deserializationConfig = deserializationContext.f3663c;
            deserializationConfig.getClass();
            com.fasterxml.jackson.databind.introspect.a aVar = deserializationConfig.j(javaType.f3690a).f9499e;
            k3.d dVarY = deserializationConfig.d().Y(javaType, deserializationConfig, aVar);
            if (dVarY == null) {
                deserializationConfig.f3828b.getClass();
                bVarC = null;
            } else {
                deserializationConfig.f3833d.getClass();
                Class<?> cls = aVar.f4175b;
                HashSet hashSet = new HashSet();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                StdSubtypeResolver.b(aVar, new NamedType(cls, null), deserializationConfig, hashSet, linkedHashMap);
                bVarC = dVarY.c(deserializationConfig, javaType, StdSubtypeResolver.c(cls, hashSet, linkedHashMap));
            }
        }
        b3.c<?> cVar = (b3.c) javaType.f3692c;
        b3.c<?> cVarO = cVar == null ? deserializationContext.o(javaType, std) : deserializationContext.z(cVar, std, javaType);
        return bVarC != null ? new TypeWrappedDeserializer(bVarC.f(std), cVarO) : cVarO;
    }

    public static void n0(BeanPropertyMap beanPropertyMap, SettableBeanProperty[] settableBeanPropertyArr, SettableBeanProperty settableBeanProperty, SettableBeanProperty settableBeanProperty2) {
        int length = beanPropertyMap.f3906e.length;
        for (int i10 = 1; i10 <= length; i10 += 2) {
            Object[] objArr = beanPropertyMap.f3906e;
            if (objArr[i10] == settableBeanProperty) {
                objArr[i10] = settableBeanProperty2;
                beanPropertyMap.h[beanPropertyMap.a(settableBeanProperty)] = settableBeanProperty2;
                if (settableBeanPropertyArr != null) {
                    int length2 = settableBeanPropertyArr.length;
                    for (int i11 = 0; i11 < length2; i11++) {
                        if (settableBeanPropertyArr[i11] == settableBeanProperty) {
                            settableBeanPropertyArr[i11] = settableBeanProperty2;
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
        throw new NoSuchElementException(ai.onnxruntime.a.o(new StringBuilder("No entry '"), settableBeanProperty.f3891c.f3755a, "' found, can't replace"));
    }

    public BeanDeserializerBase A0(BeanPropertyMap beanPropertyMap) {
        throw new UnsupportedOperationException("Class " + getClass().getName() + " does not override `withBeanProperties()`, needs to");
    }

    public abstract BeanDeserializerBase B0(Set<String> set, Set<String> set2);

    public abstract BeanDeserializerBase C0();

    public abstract BeanDeserializerBase D0(ObjectIdReader objectIdReader);

    public final void F0(Exception exc, DeserializationContext deserializationContext) throws IOException {
        Throwable cause = exc;
        while ((cause instanceof InvocationTargetException) && cause.getCause() != null) {
            cause = cause.getCause();
        }
        com.fasterxml.jackson.databind.util.a.B(cause);
        if (cause instanceof IOException) {
            throw ((IOException) cause);
        }
        if (deserializationContext != null && !deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS)) {
            com.fasterxml.jackson.databind.util.a.D(cause);
        }
        deserializationContext.w(this.f3854d.f3690a, cause);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0172, code lost:
    
        if (r6 != false) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0207 A[EDGE_INSN: B:180:0x0207->B:103:0x0207 BREAK  A[LOOP:2: B:93:0x01cd->B:102:0x0200], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cf  */
    @Override // e3.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.fasterxml.jackson.databind.DeserializationContext r27) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerBase.b(com.fasterxml.jackson.databind.DeserializationContext):void");
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        ObjectIdReader objectIdReader;
        h hVarY;
        SettableBeanProperty settableBeanProperty;
        JavaType javaType;
        ObjectIdGenerator objectIdGeneratorG;
        PropertyBasedCreator propertyBasedCreator;
        AnnotationIntrospector annotationIntrospectorD = deserializationContext.f3663c.d();
        AnnotatedMember annotatedMemberD = (beanProperty == null || annotationIntrospectorD == null) ? null : beanProperty.d();
        JavaType javaType2 = this.f3854d;
        BeanPropertyMap beanPropertyMap = this.f3861o;
        ObjectIdReader objectIdReader2 = this.z;
        if (annotatedMemberD == null || (hVarY = annotationIntrospectorD.y(annotatedMemberD)) == null) {
            objectIdReader = objectIdReader2;
        } else {
            h hVarZ = annotationIntrospectorD.z(annotatedMemberD, hVarY);
            Class<? extends ObjectIdGenerator<?>> cls = hVarZ.f9512b;
            com.fasterxml.jackson.annotation.a aVarH = deserializationContext.h(hVarZ);
            if (cls == ObjectIdGenerators$PropertyGenerator.class) {
                PropertyName propertyName = hVarZ.f9511a;
                String str = propertyName.f3755a;
                SettableBeanProperty settableBeanPropertyC = beanPropertyMap == null ? null : beanPropertyMap.c(str);
                if (settableBeanPropertyC == null && (propertyBasedCreator = this.f3858l) != null) {
                    settableBeanPropertyC = propertyBasedCreator.c(str);
                }
                if (settableBeanPropertyC == null) {
                    deserializationContext.j("Invalid Object Id definition for " + com.fasterxml.jackson.databind.util.a.y(javaType2.f3690a) + ": cannot find property with name " + com.fasterxml.jackson.databind.util.a.c(propertyName.f3755a));
                    throw null;
                }
                JavaType javaType3 = settableBeanPropertyC.f3892d;
                settableBeanProperty = settableBeanPropertyC;
                objectIdGeneratorG = new PropertyBasedObjectIdGenerator(hVarZ.f9514d);
                javaType = javaType3;
            } else {
                JavaType javaTypeK = deserializationContext.k(cls);
                deserializationContext.e().getClass();
                settableBeanProperty = null;
                javaType = TypeFactory.l(javaTypeK, ObjectIdGenerator.class)[0];
                objectIdGeneratorG = deserializationContext.g(hVarZ);
            }
            objectIdReader = new ObjectIdReader(javaType, hVarZ.f9511a, objectIdGeneratorG, deserializationContext.t(javaType), settableBeanProperty, aVarH);
        }
        BeanDeserializerBase beanDeserializerBaseD0 = (objectIdReader == null || objectIdReader == objectIdReader2) ? this : D0(objectIdReader);
        if (annotatedMemberD != null) {
            JsonIgnoreProperties.Value valueH = annotationIntrospectorD.H(annotatedMemberD);
            if (valueH.f3460b && !this.f3865t) {
                beanDeserializerBaseD0 = beanDeserializerBaseD0.C0();
            }
            Set<String> set = valueH.f3462d ? Collections.EMPTY_SET : valueH.f3459a;
            Set<String> set2 = beanDeserializerBaseD0.r;
            if (set.isEmpty()) {
                set = set2;
            } else if (set2 != null && !set2.isEmpty()) {
                HashSet hashSet = new HashSet(set2);
                hashSet.addAll(set);
                set = hashSet;
            }
            Set<String> set3 = beanDeserializerBaseD0.f3864s;
            Set<String> set4 = annotationIntrospectorD.K(annotatedMemberD).f3475a;
            if (set3 != null) {
                if (set4 == null) {
                    set4 = set3;
                } else {
                    HashSet hashSet2 = new HashSet();
                    for (String str2 : set4) {
                        if (set3.contains(str2)) {
                            hashSet2.add(str2);
                        }
                    }
                    set4 = hashSet2;
                }
            }
            if (set != set2 || set4 != set3) {
                beanDeserializerBaseD0 = beanDeserializerBaseD0.B0(set, set4);
            }
        }
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, javaType2.f3690a);
        if (valueD0 != null) {
            JsonFormat.Shape shape = valueD0.f3451b;
            shape = shape != JsonFormat.Shape.f3439a ? shape : null;
            Boolean boolB = valueD0.b(JsonFormat.Feature.f3435b);
            if (boolB != null) {
                boolean zBooleanValue = boolB.booleanValue();
                BeanPropertyMap beanPropertyMap2 = beanPropertyMap.f3902a == zBooleanValue ? beanPropertyMap : new BeanPropertyMap(beanPropertyMap, zBooleanValue);
                if (beanPropertyMap2 != beanPropertyMap) {
                    beanDeserializerBaseD0 = beanDeserializerBaseD0.A0(beanPropertyMap2);
                }
            }
        }
        if (shape == null) {
            shape = this.f3855e;
        }
        return shape == JsonFormat.Shape.f3442d ? beanDeserializerBaseD0.o0() : beanDeserializerBaseD0;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.h;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) {
        Object objR0;
        ObjectIdReader objectIdReader = this.z;
        if (objectIdReader != null) {
            if (jsonParser.a() && (objR0 = jsonParser.R0()) != null) {
                return m0(jsonParser, deserializationContext, bVar.d(jsonParser, deserializationContext), objR0);
            }
            JsonToken jsonTokenK = jsonParser.K();
            if (jsonTokenK != null) {
                if (jsonTokenK.f3600k) {
                    return s0(jsonParser, deserializationContext);
                }
                if (jsonTokenK == JsonToken.START_OBJECT) {
                    jsonTokenK = jsonParser.q1();
                }
                if (jsonTokenK == JsonToken.FIELD_NAME) {
                    objectIdReader.f3930c.getClass();
                }
            }
        }
        return bVar.d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final JavaType f0() {
        return this.f3854d;
    }

    @Override // b3.c
    public final SettableBeanProperty h(String str) {
        Map<String, SettableBeanProperty> map = this.f3867v;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // b3.c
    public final AccessPattern i() {
        return AccessPattern.f4493c;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final void i0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws UnrecognizedPropertyException, IgnoredPropertyException {
        if (this.f3865t) {
            jsonParser.v1();
            return;
        }
        if (IgnorePropertiesUtil.b(str, this.r, this.f3864s)) {
            v0(jsonParser, deserializationContext, obj, str);
        }
        super.i0(jsonParser, deserializationContext, obj, str);
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) throws JsonMappingException {
        try {
            return this.h.v(deserializationContext);
        } catch (IOException e10) {
            com.fasterxml.jackson.databind.util.a.A(deserializationContext, e10);
            throw null;
        }
    }

    public final b3.c<Object> j0() {
        b3.c<Object> cVar = this.f3856j;
        return cVar == null ? this.f3857k : cVar;
    }

    @Override // b3.c
    public final Collection<Object> k() {
        ArrayList arrayList = new ArrayList();
        Iterator<SettableBeanProperty> it = this.f3861o.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f3891c.f3755a);
        }
        return arrayList;
    }

    public abstract Object k0(JsonParser jsonParser, DeserializationContext deserializationContext);

    @Override // b3.c
    public final ObjectIdReader l() {
        return this.z;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Class<?> m() {
        return this.f3854d.f3690a;
    }

    public final Object m0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Object obj2) {
        ObjectIdReader objectIdReader = this.z;
        b3.c<Object> cVar = objectIdReader.f3932e;
        if (cVar.m() != obj2.getClass()) {
            p pVar = new p(jsonParser, deserializationContext);
            if (obj2 instanceof String) {
                pVar.f1((String) obj2);
            } else if (obj2 instanceof Long) {
                pVar.n1(JsonToken.VALUE_NUMBER_INT, (Long) obj2);
            } else if (obj2 instanceof Integer) {
                pVar.n1(JsonToken.VALUE_NUMBER_INT, (Integer) obj2);
            } else {
                pVar.writeObject(obj2);
            }
            p.a aVarT1 = pVar.t1(pVar.f11580b);
            aVarT1.q1();
            obj2 = cVar.d(aVarT1, deserializationContext);
        }
        deserializationContext.s(obj2, objectIdReader.f3930c, objectIdReader.f3931d).b(obj);
        SettableBeanProperty settableBeanProperty = objectIdReader.h;
        return settableBeanProperty != null ? settableBeanProperty.A(obj, obj2) : obj;
    }

    @Override // b3.c
    public final boolean n() {
        return true;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4431d;
    }

    public abstract BeanDeserializerBase o0();

    @Override // b3.c
    public Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    public final Object p0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        b3.c<Object> cVarJ0 = j0();
        ValueInstantiator valueInstantiator = this.h;
        if (cVarJ0 == null || valueInstantiator.c()) {
            return valueInstantiator.o(deserializationContext, jsonParser.K() == JsonToken.VALUE_TRUE);
        }
        Object objW = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
        if (this.f3862p != null) {
            z0(deserializationContext);
        }
        return objW;
    }

    @Override // b3.c
    public abstract b3.c<Object> q(NameTransformer nameTransformer);

    public final Object q0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        JsonParser.NumberType numberTypeO0 = jsonParser.O0();
        JsonParser.NumberType numberType = JsonParser.NumberType.f3578e;
        ValueInjector[] valueInjectorArr = this.f3862p;
        ValueInstantiator valueInstantiator = this.h;
        if (numberTypeO0 == numberType || numberTypeO0 == JsonParser.NumberType.f3577d) {
            b3.c<Object> cVarJ0 = j0();
            if (cVarJ0 == null || valueInstantiator.d()) {
                return valueInstantiator.p(deserializationContext, jsonParser.J0());
            }
            Object objW = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            return objW;
        }
        if (numberTypeO0 != JsonParser.NumberType.h) {
            deserializationContext.x(this.f3854d.f3690a, valueInstantiator, "no suitable creator method found to deserialize from Number value (%s)", jsonParser.P0());
            throw null;
        }
        b3.c<Object> cVarJ02 = j0();
        if (cVarJ02 == null || valueInstantiator.a()) {
            return valueInstantiator.m(deserializationContext, jsonParser.I0());
        }
        Object objW2 = valueInstantiator.w(deserializationContext, cVarJ02.d(jsonParser, deserializationContext));
        if (valueInjectorArr != null) {
            z0(deserializationContext);
        }
        return objW2;
    }

    public final Object r0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (this.z != null) {
            return s0(jsonParser, deserializationContext);
        }
        b3.c<Object> cVarJ0 = j0();
        JsonParser.NumberType numberTypeO0 = jsonParser.O0();
        JsonParser.NumberType numberType = JsonParser.NumberType.f3574a;
        ValueInjector[] valueInjectorArr = this.f3862p;
        ValueInstantiator valueInstantiator = this.h;
        if (numberTypeO0 == numberType) {
            if (cVarJ0 == null || valueInstantiator.e()) {
                return valueInstantiator.q(deserializationContext, jsonParser.M0());
            }
            Object objW = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            return objW;
        }
        if (numberTypeO0 == JsonParser.NumberType.f3575b) {
            if (cVarJ0 == null || valueInstantiator.e()) {
                return valueInstantiator.r(deserializationContext, jsonParser.N0());
            }
            Object objW2 = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
            if (valueInjectorArr != null) {
                z0(deserializationContext);
            }
            return objW2;
        }
        if (numberTypeO0 != JsonParser.NumberType.f3576c) {
            deserializationContext.x(this.f3854d.f3690a, valueInstantiator, "no suitable creator method found to deserialize from Number value (%s)", jsonParser.P0());
            throw null;
        }
        if (cVarJ0 == null || valueInstantiator.b()) {
            return valueInstantiator.n(deserializationContext, jsonParser.Q());
        }
        Object objW3 = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
        if (valueInjectorArr != null) {
            z0(deserializationContext);
        }
        return objW3;
    }

    public final Object s0(JsonParser jsonParser, DeserializationContext deserializationContext) throws UnresolvedForwardReference {
        ObjectIdReader objectIdReader = this.z;
        Object objD = objectIdReader.f3932e.d(jsonParser, deserializationContext);
        com.fasterxml.jackson.databind.deser.impl.a aVarS = deserializationContext.s(objD, objectIdReader.f3930c, objectIdReader.f3931d);
        Object objC = aVarS.f3951d.c(aVarS.f3949b);
        aVarS.f3948a = objC;
        if (objC != null) {
            return objC;
        }
        throw new UnresolvedForwardReference(jsonParser, "Could not resolve Object Id [" + objD + "] (for " + this.f3854d + ").", jsonParser.x0(), aVarS);
    }

    public final Object t0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        b3.c<Object> cVarJ0 = j0();
        ValueInstantiator valueInstantiator = this.h;
        if (cVarJ0 != null) {
            Object objW = valueInstantiator.w(deserializationContext, cVarJ0.d(jsonParser, deserializationContext));
            if (this.f3862p != null) {
                z0(deserializationContext);
            }
            return objW;
        }
        if (this.f3858l != null) {
            return k0(jsonParser, deserializationContext);
        }
        Class<?> cls = this.f3854d.f3690a;
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        if (!Modifier.isStatic(cls.getModifiers())) {
            if ((com.fasterxml.jackson.databind.util.a.w(cls) ? null : cls.getEnclosingClass()) != null) {
                deserializationContext.x(cls, null, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
                throw null;
            }
        }
        deserializationContext.x(cls, valueInstantiator, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
        throw null;
    }

    public final Object u0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (this.z != null) {
            return s0(jsonParser, deserializationContext);
        }
        b3.c<Object> cVarJ0 = j0();
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
        return D(jsonParser, deserializationContext);
    }

    public final void v0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IgnoredPropertyException {
        if (!deserializationContext.J(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)) {
            jsonParser.v1();
            return;
        }
        Collection<Object> collectionK = k();
        int i10 = IgnoredPropertyException.f4103j;
        IgnoredPropertyException ignoredPropertyException = new IgnoredPropertyException(jsonParser, e.c("Ignored field \"", str, "\" (class ", (obj instanceof Class ? (Class) obj : obj.getClass()).getName(), ") encountered; mapper configured not to allow this"), jsonParser.x0(), collectionK);
        ignoredPropertyException.f(new JsonMappingException.Reference(obj, str));
        throw ignoredPropertyException;
    }

    public final Object w0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, p pVar) throws UnrecognizedPropertyException, InvalidDefinitionException, IgnoredPropertyException {
        b3.c<Object> cVarT;
        synchronized (this) {
            HashMap<ClassKey, b3.c<Object>> map = this.f3868w;
            cVarT = map == null ? null : map.get(new ClassKey(obj.getClass()));
        }
        if (cVarT == null && (cVarT = deserializationContext.t(deserializationContext.k(obj.getClass()))) != null) {
            synchronized (this) {
                try {
                    if (this.f3868w == null) {
                        this.f3868w = new HashMap<>();
                    }
                    this.f3868w.put(new ClassKey(obj.getClass()), cVarT);
                } finally {
                }
            }
        }
        if (cVarT == null) {
            if (pVar != null) {
                x0(deserializationContext, obj, pVar);
            }
            return jsonParser != null ? e(jsonParser, deserializationContext, obj) : obj;
        }
        if (pVar != null) {
            pVar.G0();
            p.a aVarT1 = pVar.t1(pVar.f11580b);
            aVarT1.q1();
            obj = cVarT.e(aVarT1, deserializationContext, obj);
        }
        return jsonParser != null ? cVarT.e(jsonParser, deserializationContext, obj) : obj;
    }

    public final void x0(DeserializationContext deserializationContext, Object obj, p pVar) throws UnrecognizedPropertyException, IgnoredPropertyException {
        pVar.G0();
        p.a aVarT1 = pVar.t1(pVar.f11580b);
        while (aVarT1.q1() != JsonToken.END_OBJECT) {
            String strC = aVarT1.C();
            aVarT1.q1();
            i0(aVarT1, deserializationContext, obj, strC);
        }
    }

    public final void y0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (IgnorePropertiesUtil.b(str, this.r, this.f3864s)) {
            v0(jsonParser, deserializationContext, obj, str);
            return;
        }
        SettableAnyProperty settableAnyProperty = this.f3863q;
        if (settableAnyProperty == null) {
            i0(jsonParser, deserializationContext, obj, str);
            return;
        }
        try {
            settableAnyProperty.b(jsonParser, deserializationContext, obj, str);
        } catch (Exception e10) {
            E0(deserializationContext, e10, obj, str);
            throw null;
        }
    }

    public final void z0(DeserializationContext deserializationContext) {
        ValueInjector[] valueInjectorArr = this.f3862p;
        if (valueInjectorArr.length <= 0) {
            return;
        }
        deserializationContext.p(valueInjectorArr[0].f3947e);
        throw null;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase) {
        this(beanDeserializerBase, beanDeserializerBase.f3865t);
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase.f3854d);
        this.f3854d = beanDeserializerBase.f3854d;
        this.h = beanDeserializerBase.h;
        this.f3856j = beanDeserializerBase.f3856j;
        this.f3857k = beanDeserializerBase.f3857k;
        this.f3858l = beanDeserializerBase.f3858l;
        this.f3861o = beanDeserializerBase.f3861o;
        this.f3867v = beanDeserializerBase.f3867v;
        this.r = beanDeserializerBase.r;
        this.f3865t = z;
        this.f3864s = beanDeserializerBase.f3864s;
        this.f3863q = beanDeserializerBase.f3863q;
        this.f3862p = beanDeserializerBase.f3862p;
        this.z = beanDeserializerBase.z;
        this.f3859m = beanDeserializerBase.f3859m;
        this.f3869x = beanDeserializerBase.f3869x;
        this.f3866u = beanDeserializerBase.f3866u;
        this.f3855e = beanDeserializerBase.f3855e;
        this.f3860n = beanDeserializerBase.f3860n;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, NameTransformer nameTransformer) {
        PropertyName propertyName;
        b3.c<Object> cVarQ;
        PropertyName propertyName2;
        b3.c<Object> cVarQ2;
        super(beanDeserializerBase.f3854d);
        this.f3854d = beanDeserializerBase.f3854d;
        this.h = beanDeserializerBase.h;
        this.f3856j = beanDeserializerBase.f3856j;
        this.f3857k = beanDeserializerBase.f3857k;
        this.f3858l = beanDeserializerBase.f3858l;
        this.f3867v = beanDeserializerBase.f3867v;
        this.r = beanDeserializerBase.r;
        this.f3865t = true;
        this.f3864s = beanDeserializerBase.f3864s;
        this.f3863q = beanDeserializerBase.f3863q;
        this.f3862p = beanDeserializerBase.f3862p;
        this.z = beanDeserializerBase.z;
        this.f3859m = beanDeserializerBase.f3859m;
        b bVar = beanDeserializerBase.f3869x;
        String str = null;
        if (bVar != null) {
            ArrayList arrayList = (ArrayList) bVar.h;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                SettableBeanProperty settableBeanPropertyB = (SettableBeanProperty) obj;
                String strA = nameTransformer.a(settableBeanPropertyB.f3891c.f3755a);
                PropertyName propertyName3 = settableBeanPropertyB.f3891c;
                if (propertyName3 != null) {
                    strA = strA == null ? "" : strA;
                    propertyName2 = strA.equals(propertyName3.f3755a) ? propertyName3 : new PropertyName(strA, propertyName3.f3756b);
                } else {
                    propertyName2 = new PropertyName(strA, null);
                }
                settableBeanPropertyB = propertyName2 != propertyName3 ? settableBeanPropertyB.B(propertyName2) : settableBeanPropertyB;
                b3.c<Object> cVarR = settableBeanPropertyB.r();
                if (cVarR != null && (cVarQ2 = cVarR.q(nameTransformer)) != cVarR) {
                    settableBeanPropertyB = settableBeanPropertyB.D(cVarQ2);
                }
                arrayList2.add(settableBeanPropertyB);
            }
            bVar = new b(arrayList2, 3);
        }
        BeanPropertyMap beanPropertyMap = beanDeserializerBase.f3861o;
        SettableBeanProperty[] settableBeanPropertyArr = beanPropertyMap.h;
        if (nameTransformer != NameTransformer.f4511a) {
            int length = settableBeanPropertyArr.length;
            ArrayList arrayList3 = new ArrayList(length);
            int i11 = 0;
            while (i11 < length) {
                SettableBeanProperty settableBeanPropertyB2 = settableBeanPropertyArr[i11];
                if (settableBeanPropertyB2 == null) {
                    arrayList3.add(settableBeanPropertyB2);
                } else {
                    PropertyName propertyName4 = settableBeanPropertyB2.f3891c;
                    String strA2 = nameTransformer.a(propertyName4.f3755a);
                    if (propertyName4 != null) {
                        strA2 = strA2 == null ? "" : strA2;
                        propertyName = strA2.equals(propertyName4.f3755a) ? propertyName4 : new PropertyName(strA2, propertyName4.f3756b);
                    } else {
                        propertyName = new PropertyName(strA2, str);
                    }
                    settableBeanPropertyB2 = propertyName != propertyName4 ? settableBeanPropertyB2.B(propertyName) : settableBeanPropertyB2;
                    b3.c<Object> cVarR2 = settableBeanPropertyB2.r();
                    if (cVarR2 != null && (cVarQ = cVarR2.q(nameTransformer)) != cVarR2) {
                        settableBeanPropertyB2 = settableBeanPropertyB2.D(cVarQ);
                    }
                    arrayList3.add(settableBeanPropertyB2);
                }
                i11++;
                str = null;
            }
            beanPropertyMap = new BeanPropertyMap(beanPropertyMap.f3902a, arrayList3, beanPropertyMap.f3907j, beanPropertyMap.f3909l);
        }
        this.f3861o = beanPropertyMap;
        this.f3869x = bVar;
        this.f3866u = beanDeserializerBase.f3866u;
        this.f3855e = beanDeserializerBase.f3855e;
        this.f3860n = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase.f3854d);
        this.f3854d = beanDeserializerBase.f3854d;
        this.h = beanDeserializerBase.h;
        this.f3856j = beanDeserializerBase.f3856j;
        this.f3857k = beanDeserializerBase.f3857k;
        this.f3858l = beanDeserializerBase.f3858l;
        this.f3867v = beanDeserializerBase.f3867v;
        this.r = beanDeserializerBase.r;
        this.f3865t = beanDeserializerBase.f3865t;
        this.f3864s = beanDeserializerBase.f3864s;
        this.f3863q = beanDeserializerBase.f3863q;
        this.f3862p = beanDeserializerBase.f3862p;
        this.f3859m = beanDeserializerBase.f3859m;
        this.f3869x = beanDeserializerBase.f3869x;
        this.f3866u = beanDeserializerBase.f3866u;
        this.f3855e = beanDeserializerBase.f3855e;
        this.z = objectIdReader;
        this.f3861o = beanDeserializerBase.f3861o.g(new ObjectIdValueProperty(objectIdReader, PropertyMetadata.f3742k));
        this.f3860n = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, Set<String> set, Set<String> set2) {
        super(beanDeserializerBase.f3854d);
        this.f3854d = beanDeserializerBase.f3854d;
        this.h = beanDeserializerBase.h;
        this.f3856j = beanDeserializerBase.f3856j;
        this.f3857k = beanDeserializerBase.f3857k;
        this.f3858l = beanDeserializerBase.f3858l;
        this.f3867v = beanDeserializerBase.f3867v;
        this.r = set;
        this.f3865t = beanDeserializerBase.f3865t;
        this.f3864s = set2;
        this.f3863q = beanDeserializerBase.f3863q;
        this.f3862p = beanDeserializerBase.f3862p;
        this.f3859m = beanDeserializerBase.f3859m;
        this.f3869x = beanDeserializerBase.f3869x;
        this.f3866u = beanDeserializerBase.f3866u;
        this.f3855e = beanDeserializerBase.f3855e;
        this.f3860n = beanDeserializerBase.f3860n;
        this.z = beanDeserializerBase.z;
        BeanPropertyMap beanPropertyMap = beanDeserializerBase.f3861o;
        SettableBeanProperty[] settableBeanPropertyArr = beanPropertyMap.h;
        if ((set != null && !set.isEmpty()) || set2 != null) {
            ArrayList arrayList = new ArrayList(settableBeanPropertyArr.length);
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                if (settableBeanProperty != null && !IgnorePropertiesUtil.b(settableBeanProperty.f3891c.f3755a, set, set2)) {
                    arrayList.add(settableBeanProperty);
                }
            }
            beanPropertyMap = new BeanPropertyMap(beanPropertyMap.f3902a, arrayList, beanPropertyMap.f3907j, beanPropertyMap.f3909l);
        }
        this.f3861o = beanPropertyMap;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, BeanPropertyMap beanPropertyMap) {
        super(beanDeserializerBase.f3854d);
        this.f3854d = beanDeserializerBase.f3854d;
        this.h = beanDeserializerBase.h;
        this.f3856j = beanDeserializerBase.f3856j;
        this.f3857k = beanDeserializerBase.f3857k;
        this.f3858l = beanDeserializerBase.f3858l;
        this.f3861o = beanPropertyMap;
        this.f3867v = beanDeserializerBase.f3867v;
        this.r = beanDeserializerBase.r;
        this.f3865t = beanDeserializerBase.f3865t;
        this.f3864s = beanDeserializerBase.f3864s;
        this.f3863q = beanDeserializerBase.f3863q;
        this.f3862p = beanDeserializerBase.f3862p;
        this.z = beanDeserializerBase.z;
        this.f3859m = beanDeserializerBase.f3859m;
        this.f3869x = beanDeserializerBase.f3869x;
        this.f3866u = beanDeserializerBase.f3866u;
        this.f3855e = beanDeserializerBase.f3855e;
        this.f3860n = beanDeserializerBase.f3860n;
    }
}
