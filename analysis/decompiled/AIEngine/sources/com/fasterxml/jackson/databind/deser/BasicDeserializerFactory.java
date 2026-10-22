package com.fasterxml.jackson.databind.deser;

import b3.c;
import b3.g;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.util.EnumResolver;
import e3.f;
import f3.a;
import f3.b;
import i3.e;
import i3.i;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import k3.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BasicDeserializerFactory extends f implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializerFactoryConfig f3848a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Class<? extends Collection>> f3849a;

        /* renamed from: b, reason: collision with root package name */
        public static final HashMap<String, Class<? extends Map>> f3850b;

        static {
            HashMap<String, Class<? extends Collection>> map = new HashMap<>();
            map.put(Collection.class.getName(), ArrayList.class);
            map.put(List.class.getName(), ArrayList.class);
            map.put(Set.class.getName(), HashSet.class);
            map.put(SortedSet.class.getName(), TreeSet.class);
            map.put(Queue.class.getName(), LinkedList.class);
            map.put(AbstractList.class.getName(), ArrayList.class);
            map.put(AbstractSet.class.getName(), HashSet.class);
            map.put(Deque.class.getName(), LinkedList.class);
            map.put(NavigableSet.class.getName(), TreeSet.class);
            f3849a = map;
            HashMap<String, Class<? extends Map>> map2 = new HashMap<>();
            map2.put(Map.class.getName(), LinkedHashMap.class);
            map2.put(AbstractMap.class.getName(), LinkedHashMap.class);
            map2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            map2.put(SortedMap.class.getName(), TreeMap.class);
            map2.put(NavigableMap.class.getName(), TreeMap.class);
            map2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            f3850b = map2;
        }
    }

    static {
        new PropertyName("@JsonUnwrapped", null);
    }

    public BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this.f3848a = deserializerFactoryConfig;
    }

    public static boolean g(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, e eVar) {
        String name;
        if ((eVar == null || !eVar.A()) && annotationIntrospector.p(annotatedWithParams.r(0)) == null) {
            return (eVar == null || (name = eVar.getName()) == null || name.isEmpty() || !eVar.h()) ? false : true;
        }
        return true;
    }

    public static void i(b bVar, AnnotatedWithParams annotatedWithParams, boolean z, boolean z3) {
        Class<?> clsU = annotatedWithParams.u(0);
        if (clsU == String.class || clsU == CharSequence.class) {
            if (z || z3) {
                bVar.e(annotatedWithParams, 1, z);
                return;
            }
            return;
        }
        if (clsU == Integer.TYPE || clsU == Integer.class) {
            if (z || z3) {
                bVar.e(annotatedWithParams, 2, z);
                return;
            }
            return;
        }
        if (clsU == Long.TYPE || clsU == Long.class) {
            if (z || z3) {
                bVar.e(annotatedWithParams, 3, z);
                return;
            }
            return;
        }
        if (clsU == Double.TYPE || clsU == Double.class) {
            if (z || z3) {
                bVar.e(annotatedWithParams, 5, z);
                return;
            }
            return;
        }
        if (clsU == Boolean.TYPE || clsU == Boolean.class) {
            if (z || z3) {
                bVar.e(annotatedWithParams, 7, z);
                return;
            }
            return;
        }
        if (clsU == BigInteger.class && (z || z3)) {
            bVar.e(annotatedWithParams, 4, z);
        }
        if (clsU == BigDecimal.class && (z || z3)) {
            bVar.e(annotatedWithParams, 6, z);
        }
        if (z) {
            bVar.b(annotatedWithParams, z, null, 0);
        }
    }

    public static boolean j(DeserializationContext deserializationContext, AnnotatedWithParams annotatedWithParams) {
        JsonCreator.Mode modeE;
        MapperConfig<?> mapperConfig = deserializationContext.f3663c;
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        return (annotationIntrospectorD == null || (modeE = annotationIntrospectorD.e(mapperConfig, annotatedWithParams)) == null || modeE == JsonCreator.Mode.f3432d) ? false : true;
    }

    public static EnumResolver l(Class cls, DeserializationConfig deserializationConfig, AnnotatedMember annotatedMember) {
        if (annotatedMember != null) {
            deserializationConfig.getClass();
            if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                com.fasterxml.jackson.databind.util.a.e(annotatedMember.j(), deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            AnnotationIntrospector annotationIntrospectorD = deserializationConfig.d();
            boolean zK = deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
            Enum<?>[] enumArrA = EnumResolver.a(cls);
            HashMap map = new HashMap();
            int length = enumArrA.length;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                Enum<?> r12 = enumArrA[length];
                try {
                    Object objK = annotatedMember.k(r12);
                    if (objK != null) {
                        map.put(objK.toString(), r12);
                    }
                } catch (Exception e10) {
                    throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r12 + ": " + e10.getMessage());
                }
            }
            return new EnumResolver(cls, enumArrA, map, annotationIntrospectorD != null ? annotationIntrospectorD.g(cls) : null, zK);
        }
        AnnotationIntrospector annotationIntrospectorD2 = deserializationConfig.d();
        boolean zK2 = deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Enum<?>[] enumArrA2 = EnumResolver.a(cls);
        String[] strArrL = annotationIntrospectorD2.l(cls, enumArrA2, new String[enumArrA2.length]);
        String[][] strArr = new String[strArrL.length][];
        annotationIntrospectorD2.k(cls, enumArrA2, strArr);
        HashMap map2 = new HashMap();
        int length2 = enumArrA2.length;
        for (int i10 = 0; i10 < length2; i10++) {
            Enum<?> r42 = enumArrA2[i10];
            String strName = strArrL[i10];
            if (strName == null) {
                strName = r42.name();
            }
            map2.put(strName, r42);
            String[] strArr2 = strArr[i10];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    if (!map2.containsKey(str)) {
                        map2.put(str, r42);
                    }
                }
            }
        }
        return new EnumResolver(cls, enumArrA2, map2, annotationIntrospectorD2.g(cls), zK2);
    }

    public static c m(DeserializationContext deserializationContext, i3.a aVar) {
        Object objJ;
        AnnotationIntrospector annotationIntrospectorD = deserializationContext.f3663c.d();
        if (annotationIntrospectorD == null || (objJ = annotationIntrospectorD.j(aVar)) == null) {
            return null;
        }
        return deserializationContext.l(objJ);
    }

    public static g n(DeserializationContext deserializationContext, i3.a aVar) {
        Object objR;
        AnnotationIntrospector annotationIntrospectorD = deserializationContext.f3663c.d();
        if (annotationIntrospectorD == null || (objR = annotationIntrospectorD.r(aVar)) == null) {
            return null;
        }
        return deserializationContext.K(objR);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0181 A[RETURN] */
    @Override // e3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.c a(com.fasterxml.jackson.databind.DeserializationContext r12, com.fasterxml.jackson.databind.type.CollectionType r13, i3.d r14) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.a(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.type.CollectionType, i3.d):b3.c");
    }

    @Override // e3.f
    public final k3.b b(DeserializationConfig deserializationConfig, JavaType javaType) throws InvalidDefinitionException {
        Class<?> cls = javaType.f3690a;
        com.fasterxml.jackson.databind.introspect.a aVar = deserializationConfig.j(cls).f9499e;
        d dVarY = deserializationConfig.d().Y(javaType, deserializationConfig, aVar);
        if (dVarY == null) {
            deserializationConfig.f3828b.getClass();
            return null;
        }
        deserializationConfig.f3833d.getClass();
        Class<?> cls2 = aVar.f4175b;
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StdSubtypeResolver.b(aVar, new NamedType(cls2, null), deserializationConfig, hashSet, linkedHashMap);
        ArrayList arrayListC = StdSubtypeResolver.c(cls2, hashSet, linkedHashMap);
        if (dVarY.e() == null && javaType.v()) {
            c(javaType);
            if (!javaType.u(cls)) {
                dVarY = dVarY.a(cls);
            }
        }
        try {
            return dVarY.c(deserializationConfig, javaType, arrayListC);
        } catch (IllegalArgumentException | IllegalStateException e10) {
            InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(null, com.fasterxml.jackson.databind.util.a.i(e10));
            invalidDefinitionException.initCause(e10);
            throw invalidDefinitionException;
        }
    }

    @Override // e3.f
    public final JavaType c(JavaType javaType) {
        Class<?> cls = javaType.f3690a;
        androidx.datastore.preferences.protobuf.f[] fVarArr = this.f3848a.f3825d;
        if (fVarArr.length > 0) {
            int i10 = 0;
            while (true) {
                if (!(i10 < fVarArr.length)) {
                    break;
                }
                if (i10 >= fVarArr.length) {
                    throw new NoSuchElementException();
                }
                fVarArr[i10].getClass();
                i10++;
            }
        }
        return javaType;
    }

    public final void d(DeserializationContext deserializationContext, b3.a aVar, b bVar, f3.a aVar2, ConstructorDetector constructorDetector) throws InvalidDefinitionException {
        int i10 = aVar2.f8682c;
        AnnotatedWithParams annotatedWithParams = aVar2.f8681b;
        a.C0079a[] c0079aArr = aVar2.f8683d;
        int i11 = 0;
        if (1 != i10) {
            constructorDetector.getClass();
            int i12 = -1;
            int i13 = -1;
            while (true) {
                if (i11 >= i10) {
                    i12 = i13;
                    break;
                }
                if (c0079aArr[i11].f8686c == null) {
                    if (i13 >= 0) {
                        break;
                    } else {
                        i13 = i11;
                    }
                }
                i11++;
            }
            if (i12 < 0 || aVar2.c(i12) != null) {
                f(deserializationContext, aVar, bVar, aVar2);
                return;
            } else {
                e(deserializationContext, aVar, bVar, aVar2);
                return;
            }
        }
        a.C0079a c0079a = c0079aArr[0];
        AnnotatedParameter annotatedParameter = c0079a.f8684a;
        JacksonInject.Value value = c0079a.f8686c;
        constructorDetector.getClass();
        e eVarD = aVar2.d(0);
        e eVar = c0079aArr[0].f8685b;
        PropertyName propertyNameB = (eVar == null || !eVar.A()) ? null : eVar.b();
        boolean z = (propertyNameB == null && value == null) ? false : true;
        if (!z && eVarD != null) {
            propertyNameB = aVar2.c(0);
            z = propertyNameB != null && eVarD.h();
        }
        PropertyName propertyName = propertyNameB;
        if (z) {
            bVar.c(annotatedWithParams, true, new SettableBeanProperty[]{k(deserializationContext, aVar, propertyName, 0, annotatedParameter, value)});
            return;
        }
        i(bVar, annotatedWithParams, true, true);
        e eVarD2 = aVar2.d(0);
        if (eVarD2 != null) {
            ((i) eVarD2).f9522k = null;
        }
    }

    public final void e(DeserializationContext deserializationContext, b3.a aVar, b bVar, f3.a aVar2) throws InvalidDefinitionException {
        int i10 = aVar2.f8682c;
        AnnotatedWithParams annotatedWithParams = aVar2.f8681b;
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[i10];
        int i11 = -1;
        for (int i12 = 0; i12 < i10; i12++) {
            a.C0079a c0079a = aVar2.f8683d[i12];
            AnnotatedParameter annotatedParameter = c0079a.f8684a;
            JacksonInject.Value value = c0079a.f8686c;
            if (value != null) {
                settableBeanPropertyArr[i12] = k(deserializationContext, aVar, null, i12, annotatedParameter, value);
            } else {
                if (i11 >= 0) {
                    deserializationContext.O(aVar, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i11), Integer.valueOf(i12), aVar2);
                    throw null;
                }
                i11 = i12;
            }
        }
        if (i11 < 0) {
            deserializationContext.O(aVar, "No argument left as delegating for Creator %s: exactly one required", aVar2);
            throw null;
        }
        if (i10 != 1) {
            bVar.b(annotatedWithParams, true, settableBeanPropertyArr, i11);
            return;
        }
        i(bVar, annotatedWithParams, true, true);
        e eVarD = aVar2.d(0);
        if (eVarD != null) {
            ((i) eVarD).f9522k = null;
        }
    }

    public final void f(DeserializationContext deserializationContext, b3.a aVar, b bVar, f3.a aVar2) throws InvalidDefinitionException {
        int i10 = aVar2.f8682c;
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[i10];
        int i11 = 0;
        while (i11 < i10) {
            a.C0079a c0079a = aVar2.f8683d[i11];
            JacksonInject.Value value = c0079a.f8686c;
            AnnotatedParameter annotatedParameter = c0079a.f8684a;
            PropertyName propertyNameC = aVar2.c(i11);
            if (propertyNameC == null) {
                if (deserializationContext.f3663c.d().Z(annotatedParameter) != null) {
                    deserializationContext.O(aVar, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(annotatedParameter.f4131e));
                    throw null;
                }
                propertyNameC = aVar2.b(i11);
                if (propertyNameC == null && value == null) {
                    deserializationContext.O(aVar, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", Integer.valueOf(i11), aVar2);
                    throw null;
                }
            }
            BasicDeserializerFactory basicDeserializerFactory = this;
            DeserializationContext deserializationContext2 = deserializationContext;
            b3.a aVar3 = aVar;
            settableBeanPropertyArr[i11] = basicDeserializerFactory.k(deserializationContext2, aVar3, propertyNameC, i11, annotatedParameter, value);
            i11++;
            this = basicDeserializerFactory;
            deserializationContext = deserializationContext2;
            aVar = aVar3;
        }
        bVar.c(aVar2.f8681b, true, settableBeanPropertyArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:240:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x05e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x058c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.deser.std.StdValueInstantiator h(com.fasterxml.jackson.databind.DeserializationContext r37, b3.a r38) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            Method dump skipped, instructions count: 1772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.h(com.fasterxml.jackson.databind.DeserializationContext, b3.a):com.fasterxml.jackson.databind.deser.std.StdValueInstantiator");
    }

    public final CreatorProperty k(DeserializationContext deserializationContext, b3.a aVar, PropertyName propertyName, int i10, AnnotatedParameter annotatedParameter, JacksonInject.Value value) throws InvalidDefinitionException {
        Nulls nulls;
        Nulls nulls2;
        Nulls nulls3;
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        AnnotationIntrospector annotationIntrospectorD = deserializationConfig.d();
        PropertyMetadata propertyMetadataA = annotationIntrospectorD == null ? PropertyMetadata.f3744m : PropertyMetadata.a(annotationIntrospectorD.k0(annotatedParameter), annotationIntrospectorD.G(annotatedParameter), annotationIntrospectorD.L(annotatedParameter), annotationIntrospectorD.F(annotatedParameter));
        JavaType javaTypeP = p(deserializationContext, annotatedParameter, annotatedParameter.f4130d);
        annotationIntrospectorD.getClass();
        k3.b bVarB = (k3.b) javaTypeP.f3693d;
        if (bVarB == null) {
            bVarB = b(deserializationConfig, javaTypeP);
        }
        AnnotationIntrospector annotationIntrospectorD2 = deserializationConfig.d();
        Nulls nulls4 = Nulls.f3494d;
        if (annotationIntrospectorD2 != null) {
            JsonSetter.Value valueV = annotationIntrospectorD2.V(annotatedParameter);
            nulls2 = valueV.f3479a;
            if (nulls2 == nulls4) {
                nulls2 = null;
            }
            nulls = valueV.f3480b;
            if (nulls == nulls4) {
                nulls = null;
            }
        } else {
            nulls = null;
            nulls2 = null;
        }
        deserializationConfig.e(javaTypeP.f3690a).getClass();
        JsonSetter.Value value2 = deserializationConfig.f3835j.f3811b;
        if (nulls2 == null && (nulls2 = value2.f3479a) == nulls4) {
            nulls2 = null;
        }
        Nulls nulls5 = nulls2;
        if (nulls == null) {
            Nulls nulls6 = value2.f3480b;
            nulls3 = nulls6 != nulls4 ? nulls6 : null;
        } else {
            nulls3 = nulls;
        }
        CreatorProperty creatorProperty = new CreatorProperty(propertyName, javaTypeP, bVarB, ((i3.d) aVar).f9499e.f4182m, annotatedParameter, i10, value, (nulls5 == null && nulls3 == null) ? propertyMetadataA : new PropertyMetadata(propertyMetadataA.f3745a, propertyMetadataA.f3746b, propertyMetadataA.f3747c, propertyMetadataA.f3748d, propertyMetadataA.f3749e, nulls5, nulls3));
        c<?> cVarM = m(deserializationContext, annotatedParameter);
        if (cVarM == null) {
            cVarM = (c) javaTypeP.f3692c;
        }
        return cVarM != null ? (CreatorProperty) creatorProperty.D(deserializationContext.y(cVarM, creatorProperty, javaTypeP)) : creatorProperty;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.deser.ValueInstantiator o(com.fasterxml.jackson.databind.DeserializationContext r5, b3.a r6) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            r4 = this;
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r5.f3663c
            r1 = r6
            i3.d r1 = (i3.d) r1
            com.fasterxml.jackson.databind.introspect.a r1 = r1.f9499e
            com.fasterxml.jackson.databind.AnnotationIntrospector r2 = r0.d()
            java.lang.Object r1 = r2.a0(r1)
            r2 = 0
            if (r1 == 0) goto L58
            boolean r3 = r1 instanceof com.fasterxml.jackson.databind.deser.ValueInstantiator
            if (r3 == 0) goto L19
            com.fasterxml.jackson.databind.deser.ValueInstantiator r1 = (com.fasterxml.jackson.databind.deser.ValueInstantiator) r1
            goto L59
        L19:
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r3 = com.fasterxml.jackson.databind.util.a.t(r1)
            if (r3 == 0) goto L22
            goto L58
        L22:
            java.lang.Class<com.fasterxml.jackson.databind.deser.ValueInstantiator> r3 = com.fasterxml.jackson.databind.deser.ValueInstantiator.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L3b
            r0.h()
            com.fasterxml.jackson.databind.MapperFeature r3 = com.fasterxml.jackson.databind.MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r0.k(r3)
            java.lang.Object r0 = com.fasterxml.jackson.databind.util.a.h(r1, r0)
            r1 = r0
            com.fasterxml.jackson.databind.deser.ValueInstantiator r1 = (com.fasterxml.jackson.databind.deser.ValueInstantiator) r1
            goto L59
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "AnnotationIntrospector returned Class "
            r5.<init>(r6)
            java.lang.String r6 = r1.getName()
            r5.append(r6)
            java.lang.String r6 = "; expected Class<ValueInstantiator>"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L58:
            r1 = r2
        L59:
            if (r1 != 0) goto L69
            com.fasterxml.jackson.databind.JavaType r0 = r6.f3041a
            java.lang.Class<?> r0 = r0.f3690a
            com.fasterxml.jackson.databind.deser.ValueInstantiator$Base r1 = com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators.a(r0)
            if (r1 != 0) goto L69
            com.fasterxml.jackson.databind.deser.std.StdValueInstantiator r1 = r4.h(r5, r6)
        L69:
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r4 = r4.f3848a
            e3.l[] r4 = r4.f3826e
            int r0 = r4.length
            if (r0 <= 0) goto L9c
            r0 = 0
        L71:
            int r3 = r4.length
            if (r0 >= r3) goto L9c
            int r1 = r4.length
            if (r0 >= r1) goto L96
            int r1 = r0 + 1
            r0 = r4[r0]
            com.fasterxml.jackson.databind.deser.ValueInstantiator r3 = r0.a()
            if (r3 == 0) goto L84
            r0 = r1
            r1 = r3
            goto L71
        L84:
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r0 = "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator"
            r5.O(r6, r0, r4)
            throw r2
        L96:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            r4.<init>()
            throw r4
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.o(com.fasterxml.jackson.databind.DeserializationContext, b3.a):com.fasterxml.jackson.databind.deser.ValueInstantiator");
    }

    public final JavaType p(DeserializationContext deserializationContext, AnnotatedMember annotatedMember, JavaType javaType) throws InvalidDefinitionException {
        Object objC;
        g gVarK;
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        AnnotationIntrospector annotationIntrospectorD = deserializationConfig.d();
        if (annotationIntrospectorD == null) {
            return javaType;
        }
        if (javaType.B() && javaType.o() != null && (gVarK = deserializationContext.K(annotationIntrospectorD.r(annotatedMember))) != null) {
            javaType = ((MapLikeType) javaType).S(gVarK);
        }
        if (javaType.r()) {
            c cVarL = deserializationContext.l(annotationIntrospectorD.c(annotatedMember));
            if (cVarL != null) {
                javaType = javaType.I(cVarL);
            }
            d<?> dVarE = deserializationConfig.d().E(deserializationConfig, annotatedMember, javaType);
            JavaType javaTypeK = javaType.k();
            Object objB = dVarE == null ? b(deserializationConfig, javaTypeK) : dVarE.c(deserializationConfig, javaTypeK, deserializationConfig.f3833d.e(deserializationConfig, annotatedMember, javaTypeK));
            if (objB != null) {
                javaType = javaType.H(objB);
            }
        }
        d<?> dVarM = deserializationConfig.d().M(deserializationConfig, annotatedMember, javaType);
        if (dVarM == null) {
            objC = b(deserializationConfig, javaType);
        } else {
            try {
                objC = dVarM.c(deserializationConfig, javaType, deserializationConfig.f3833d.e(deserializationConfig, annotatedMember, javaType));
            } catch (IllegalArgumentException | IllegalStateException e10) {
                InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(null, com.fasterxml.jackson.databind.util.a.i(e10));
                invalidDefinitionException.initCause(e10);
                throw invalidDefinitionException;
            }
        }
        if (objC != null) {
            javaType = javaType.L(objC);
        }
        return annotationIntrospectorD.o0(deserializationConfig, annotatedMember, javaType);
    }
}
