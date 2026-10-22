package com.fasterxml.jackson.databind.deser.std;

import b3.g;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.a;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import e3.c;
import e3.i;
import e3.j;
import f3.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements c, j {

    /* renamed from: k, reason: collision with root package name */
    public final g f3996k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3997l;

    /* renamed from: m, reason: collision with root package name */
    public final b3.c<Object> f3998m;

    /* renamed from: n, reason: collision with root package name */
    public final k3.b f3999n;

    /* renamed from: o, reason: collision with root package name */
    public final ValueInstantiator f4000o;

    /* renamed from: p, reason: collision with root package name */
    public b3.c<Object> f4001p;

    /* renamed from: q, reason: collision with root package name */
    public PropertyBasedCreator f4002q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public Set<String> f4003s;

    /* renamed from: t, reason: collision with root package name */
    public Set<String> f4004t;

    /* renamed from: u, reason: collision with root package name */
    public IgnorePropertiesUtil.Checker f4005u;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends a.AbstractC0031a {

        /* renamed from: c, reason: collision with root package name */
        public final b f4006c;

        /* renamed from: d, reason: collision with root package name */
        public final LinkedHashMap f4007d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f4008e;

        public a(b bVar, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this.f4007d = new LinkedHashMap();
            this.f4006c = bVar;
            this.f4008e = obj;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a.AbstractC0031a
        public final void a(Object obj, Object obj2) {
            b bVar = this.f4006c;
            Iterator it = bVar.f4011c.iterator();
            Map<Object, Object> map = bVar.f4010b;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                boolean zEquals = obj.equals(aVar.f3952a.f3900e.f3949b.f3498c);
                LinkedHashMap linkedHashMap = aVar.f4007d;
                if (zEquals) {
                    it.remove();
                    map.put(aVar.f4008e, obj2);
                    map.putAll(linkedHashMap);
                    return;
                }
                map = linkedHashMap;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4009a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<Object, Object> f4010b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f4011c = new ArrayList();

        public b(Class<?> cls, Map<Object, Object> map) {
            this.f4009a = cls;
            this.f4010b = map;
        }

        public final void a(Object obj, Object obj2) {
            ArrayList arrayList = this.f4011c;
            if (arrayList.isEmpty()) {
                this.f4010b.put(obj, obj2);
            } else {
                ((a) arrayList.get(arrayList.size() - 1)).f4007d.put(obj, obj2);
            }
        }
    }

    public MapDeserializer(MapType mapType, ValueInstantiator valueInstantiator, g gVar, b3.c cVar, k3.b bVar) {
        super(mapType, (i) null, (Boolean) null);
        this.f3996k = gVar;
        this.f3998m = cVar;
        this.f3999n = bVar;
        this.f4000o = valueInstantiator;
        this.r = valueInstantiator.j();
        this.f4001p = null;
        this.f4002q = null;
        this.f3997l = l0(mapType, gVar);
        this.f4005u = null;
    }

    public static boolean l0(JavaType javaType, g gVar) {
        JavaType javaTypeO;
        if (gVar == null || (javaTypeO = javaType.o()) == null) {
            return true;
        }
        Class<?> cls = javaTypeO.f3690a;
        return (cls == String.class || cls == Object.class) && com.fasterxml.jackson.databind.util.a.v(gVar);
    }

    @Override // e3.j
    public final void b(DeserializationContext deserializationContext) throws InvalidDefinitionException {
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        ValueInstantiator valueInstantiator = this.f4000o;
        boolean zK = valueInstantiator.k();
        JavaType javaType = this.f3964d;
        if (zK) {
            JavaType javaTypeB = valueInstantiator.B();
            if (javaTypeB == null) {
                deserializationContext.j(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, valueInstantiator.getClass().getName()));
                throw null;
            }
            this.f4001p = deserializationContext.o(javaTypeB, null);
        } else if (valueInstantiator.i()) {
            JavaType javaTypeY = valueInstantiator.y();
            if (javaTypeY == null) {
                deserializationContext.j(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType, valueInstantiator.getClass().getName()));
                throw null;
            }
            this.f4001p = deserializationContext.o(javaTypeY, null);
        }
        if (valueInstantiator.g()) {
            this.f4002q = PropertyBasedCreator.b(deserializationContext, valueInstantiator, valueInstantiator.C(deserializationConfig), deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this.f3997l = l0(javaType, this.f3996k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    @Override // e3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.c<?> c(com.fasterxml.jackson.databind.DeserializationContext r13, com.fasterxml.jackson.databind.BeanProperty r14) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            r12 = this;
            com.fasterxml.jackson.databind.JavaType r0 = r12.f3964d
            b3.g r1 = r12.f3996k
            if (r1 != 0) goto L10
            com.fasterxml.jackson.databind.JavaType r2 = r0.o()
            b3.g r2 = r13.q(r2, r14)
        Le:
            r5 = r2
            goto L1d
        L10:
            boolean r2 = r1 instanceof e3.d
            if (r2 == 0) goto L1c
            r2 = r1
            e3.d r2 = (e3.d) r2
            b3.g r2 = r2.a()
            goto Le
        L1c:
            r5 = r1
        L1d:
            b3.c<java.lang.Object> r2 = r12.f3998m
            if (r14 == 0) goto L26
            b3.c r3 = com.fasterxml.jackson.databind.deser.std.StdDeserializer.c0(r13, r14, r2)
            goto L27
        L26:
            r3 = r2
        L27:
            com.fasterxml.jackson.databind.JavaType r0 = r0.k()
            if (r3 != 0) goto L33
            b3.c r0 = r13.o(r0, r14)
        L31:
            r6 = r0
            goto L38
        L33:
            b3.c r0 = r13.z(r3, r14, r0)
            goto L31
        L38:
            k3.b r0 = r12.f3999n
            if (r0 == 0) goto L42
            k3.b r3 = r0.f(r14)
            r7 = r3
            goto L43
        L42:
            r7 = r0
        L43:
            java.util.Set<java.lang.String> r3 = r12.f4003s
            java.util.Set<java.lang.String> r4 = r12.f4004t
            com.fasterxml.jackson.databind.DeserializationConfig r8 = r13.f3663c
            com.fasterxml.jackson.databind.AnnotationIntrospector r8 = r8.d()
            if (r8 == 0) goto Lbe
            if (r14 == 0) goto Lbe
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r9 = r14.d()
            if (r9 == 0) goto Lbe
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r10 = r8.H(r9)
            if (r10 == 0) goto L8e
            boolean r11 = r10.f3462d
            if (r11 == 0) goto L64
            java.util.Set r10 = java.util.Collections.EMPTY_SET
            goto L66
        L64:
            java.util.Set<java.lang.String> r10 = r10.f3459a
        L66:
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L8e
            if (r3 != 0) goto L74
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            goto L7a
        L74:
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>(r3)
            r3 = r11
        L7a:
            java.util.Iterator r10 = r10.iterator()
        L7e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L8e
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            r3.add(r11)
            goto L7e
        L8e:
            com.fasterxml.jackson.annotation.JsonIncludeProperties$Value r8 = r8.K(r9)
            java.util.Set<java.lang.String> r8 = r8.f3475a
            if (r8 == 0) goto Lbe
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            if (r4 != 0) goto La3
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>(r8)
            goto Lbe
        La3:
            java.util.Iterator r8 = r8.iterator()
        La7:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto Lbd
            java.lang.Object r10 = r8.next()
            java.lang.String r10 = (java.lang.String) r10
            boolean r11 = r4.contains(r10)
            if (r11 == 0) goto La7
            r9.add(r10)
            goto La7
        Lbd:
            r4 = r9
        Lbe:
            r9 = r3
            r10 = r4
            e3.i r8 = com.fasterxml.jackson.databind.deser.std.StdDeserializer.b0(r13, r14, r6)
            if (r1 != r5) goto Ld7
            if (r2 != r6) goto Ld7
            if (r0 != r7) goto Ld7
            e3.i r13 = r12.f3965e
            if (r13 != r8) goto Ld7
            java.util.Set<java.lang.String> r13 = r12.f4003s
            if (r13 != r9) goto Ld7
            java.util.Set<java.lang.String> r13 = r12.f4004t
            if (r13 != r10) goto Ld7
            return r12
        Ld7:
            com.fasterxml.jackson.databind.deser.std.MapDeserializer r3 = new com.fasterxml.jackson.databind.deser.std.MapDeserializer
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.MapDeserializer.c(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanProperty):b3.c");
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strC;
        Object objD;
        Object objD2;
        PropertyBasedCreator propertyBasedCreator = this.f4002q;
        i iVar = this.f3965e;
        boolean z = this.h;
        k3.b bVar = this.f3999n;
        b3.c<Object> cVar = this.f3998m;
        JavaType javaType = this.f3964d;
        if (propertyBasedCreator != null) {
            f3.g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, null);
            String strO1 = jsonParser.m1() ? jsonParser.o1() : jsonParser.i1(JsonToken.FIELD_NAME) ? jsonParser.C() : null;
            while (strO1 != null) {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                IgnorePropertiesUtil.Checker checker = this.f4005u;
                if (checker == null || !checker.a(strO1)) {
                    SettableBeanProperty settableBeanPropertyC = propertyBasedCreator.c(strO1);
                    if (settableBeanPropertyC == null) {
                        Object objA = this.f3996k.a(deserializationContext, strO1);
                        try {
                            if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                                objD2 = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                            } else if (!z) {
                                objD2 = iVar.a(deserializationContext);
                            }
                            gVarD.h = new f.b(gVarD.h, objD2, objA);
                        } catch (Exception e10) {
                            ContainerDeserializerBase.k0(deserializationContext, e10, javaType.f3690a, strO1);
                            throw null;
                        }
                    } else if (gVarD.b(settableBeanPropertyC, settableBeanPropertyC.h(jsonParser, deserializationContext))) {
                        jsonParser.q1();
                        try {
                            Map<Object, Object> map = (Map) propertyBasedCreator.a(deserializationContext, gVarD);
                            m0(jsonParser, deserializationContext, map);
                            return map;
                        } catch (Exception e11) {
                            ContainerDeserializerBase.k0(deserializationContext, e11, javaType.f3690a, strO1);
                            throw null;
                        }
                    }
                } else {
                    jsonParser.v1();
                }
                strO1 = jsonParser.o1();
            }
            try {
                return (Map) propertyBasedCreator.a(deserializationContext, gVarD);
            } catch (Exception e12) {
                ContainerDeserializerBase.k0(deserializationContext, e12, javaType.f3690a, strO1);
                throw null;
            }
        }
        b3.c<Object> cVar2 = this.f4001p;
        ValueInstantiator valueInstantiator = this.f4000o;
        if (cVar2 != null) {
            return (Map) valueInstantiator.w(deserializationContext, cVar2.d(jsonParser, deserializationContext));
        }
        if (!this.r) {
            deserializationContext.x(javaType.f3690a, valueInstantiator, "no default constructor found", new Object[0]);
            throw null;
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
        Map<Object, Object> map2 = (Map) valueInstantiator.v(deserializationContext);
        if (!this.f3997l) {
            m0(jsonParser, deserializationContext, map2);
            return map2;
        }
        boolean z3 = cVar.l() != null;
        b bVar2 = z3 ? new b(javaType.k().f3690a, map2) : null;
        if (!jsonParser.m1()) {
            JsonToken jsonTokenK = jsonParser.K();
            if (jsonTokenK != JsonToken.END_OBJECT) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (jsonTokenK != jsonToken) {
                    deserializationContext.T(this, jsonToken, null, new Object[0]);
                    throw null;
                }
                strC = jsonParser.C();
            }
            return map2;
        }
        strC = jsonParser.o1();
        while (strC != null) {
            JsonToken jsonTokenQ12 = jsonParser.q1();
            IgnorePropertiesUtil.Checker checker2 = this.f4005u;
            if (checker2 == null || !checker2.a(strC)) {
                try {
                    if (jsonTokenQ12 != JsonToken.VALUE_NULL) {
                        objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                    } else if (!z) {
                        objD = iVar.a(deserializationContext);
                    }
                    if (z3) {
                        bVar2.a(strC, objD);
                    } else {
                        map2.put(strC, objD);
                    }
                } catch (UnresolvedForwardReference e13) {
                    n0(deserializationContext, bVar2, strC, e13);
                } catch (Exception e14) {
                    ContainerDeserializerBase.k0(deserializationContext, e14, map2, strC);
                    throw null;
                }
            } else {
                jsonParser.v1();
            }
            strC = jsonParser.o1();
        }
        return map2;
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        String strC;
        String strC2;
        Map map = (Map) obj;
        jsonParser.u1(map);
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK != JsonToken.START_OBJECT && jsonTokenK != JsonToken.FIELD_NAME) {
            deserializationContext.C(this.f3964d.f3690a, jsonParser);
            throw null;
        }
        boolean z = this.f3997l;
        i iVar = this.f3965e;
        boolean z3 = this.h;
        k3.b bVar = this.f3999n;
        b3.c<Object> cVar = this.f3998m;
        if (z) {
            if (jsonParser.m1()) {
                strC2 = jsonParser.o1();
            } else {
                JsonToken jsonTokenK2 = jsonParser.K();
                if (jsonTokenK2 != JsonToken.END_OBJECT) {
                    JsonToken jsonToken = JsonToken.FIELD_NAME;
                    if (jsonTokenK2 != jsonToken) {
                        deserializationContext.T(this, jsonToken, null, new Object[0]);
                        throw null;
                    }
                    strC2 = jsonParser.C();
                }
            }
            while (strC2 != null) {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                IgnorePropertiesUtil.Checker checker = this.f4005u;
                if (checker == null || !checker.a(strC2)) {
                    try {
                        if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                            Object obj2 = map.get(strC2);
                            Object objE = obj2 != null ? bVar == null ? cVar.e(jsonParser, deserializationContext, obj2) : cVar.g(jsonParser, deserializationContext, bVar) : bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                            if (objE != obj2) {
                                map.put(strC2, objE);
                            }
                        } else if (!z3) {
                            map.put(strC2, iVar.a(deserializationContext));
                        }
                    } catch (Exception e10) {
                        ContainerDeserializerBase.k0(deserializationContext, e10, map, strC2);
                        throw null;
                    }
                } else {
                    jsonParser.v1();
                }
                strC2 = jsonParser.o1();
            }
        } else {
            if (jsonParser.m1()) {
                strC = jsonParser.o1();
            } else {
                JsonToken jsonTokenK3 = jsonParser.K();
                if (jsonTokenK3 != JsonToken.END_OBJECT) {
                    JsonToken jsonToken2 = JsonToken.FIELD_NAME;
                    if (jsonTokenK3 != jsonToken2) {
                        deserializationContext.T(this, jsonToken2, null, new Object[0]);
                        throw null;
                    }
                    strC = jsonParser.C();
                }
            }
            while (strC != null) {
                Object objA = this.f3996k.a(deserializationContext, strC);
                JsonToken jsonTokenQ12 = jsonParser.q1();
                IgnorePropertiesUtil.Checker checker2 = this.f4005u;
                if (checker2 == null || !checker2.a(strC)) {
                    try {
                        if (jsonTokenQ12 != JsonToken.VALUE_NULL) {
                            Object obj3 = map.get(objA);
                            Object objE2 = obj3 != null ? bVar == null ? cVar.e(jsonParser, deserializationContext, obj3) : cVar.g(jsonParser, deserializationContext, bVar) : bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                            if (objE2 != obj3) {
                                map.put(objA, objE2);
                            }
                        } else if (!z3) {
                            map.put(objA, iVar.a(deserializationContext));
                        }
                    } catch (Exception e11) {
                        ContainerDeserializerBase.k0(deserializationContext, e11, map, strC);
                        throw null;
                    }
                } else {
                    jsonParser.v1();
                }
                strC = jsonParser.o1();
            }
        }
        return map;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.f4000o;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) {
        return bVar.d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final JavaType f0() {
        return this.f3964d;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public final b3.c<Object> j0() {
        return this.f3998m;
    }

    public final void m0(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strC;
        Object objD;
        b3.c<Object> cVar = this.f3998m;
        boolean z = cVar.l() != null;
        b bVar = z ? new b(this.f3964d.k().f3690a, map) : null;
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
            Object objA = this.f3996k.a(deserializationContext, strC);
            JsonToken jsonTokenQ1 = jsonParser.q1();
            IgnorePropertiesUtil.Checker checker = this.f4005u;
            if (checker == null || !checker.a(strC)) {
                try {
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                        k3.b bVar2 = this.f3999n;
                        objD = bVar2 == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar2);
                    } else if (!this.h) {
                        objD = this.f3965e.a(deserializationContext);
                    }
                    if (z) {
                        bVar.a(objA, objD);
                    } else {
                        map.put(objA, objD);
                    }
                } catch (UnresolvedForwardReference e10) {
                    n0(deserializationContext, bVar, objA, e10);
                } catch (Exception e11) {
                    ContainerDeserializerBase.k0(deserializationContext, e11, map, strC);
                    throw null;
                }
            } else {
                jsonParser.v1();
            }
            strC = jsonParser.o1();
        }
    }

    @Override // b3.c
    public final boolean n() {
        return this.f3998m == null && this.f3996k == null && this.f3999n == null && this.f4003s == null && this.f4004t == null;
    }

    public final void n0(DeserializationContext deserializationContext, b bVar, Object obj, UnresolvedForwardReference unresolvedForwardReference) throws MismatchedInputException {
        if (bVar != null) {
            a aVar = new a(bVar, unresolvedForwardReference, bVar.f4009a, obj);
            bVar.f4011c.add(aVar);
            unresolvedForwardReference.f3900e.a(aVar);
        } else {
            deserializationContext.P(this, "Unresolved forward reference but no identity info: " + unresolvedForwardReference, new Object[0]);
            throw null;
        }
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4430c;
    }

    public MapDeserializer(MapDeserializer mapDeserializer, g gVar, b3.c<Object> cVar, k3.b bVar, i iVar, Set<String> set, Set<String> set2) {
        super(mapDeserializer, iVar, mapDeserializer.f3966j);
        this.f3996k = gVar;
        this.f3998m = cVar;
        this.f3999n = bVar;
        this.f4000o = mapDeserializer.f4000o;
        this.f4002q = mapDeserializer.f4002q;
        this.f4001p = mapDeserializer.f4001p;
        this.r = mapDeserializer.r;
        this.f4003s = set;
        this.f4004t = set2;
        this.f4005u = IgnorePropertiesUtil.a(set, set2);
        this.f3997l = l0(this.f3964d, gVar);
    }
}
