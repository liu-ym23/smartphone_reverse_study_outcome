package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import e3.c;
import e3.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.b;
import q3.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class UntypedObjectDeserializer extends StdDeserializer<Object> implements j, c {

    /* renamed from: n, reason: collision with root package name */
    public static final Object[] f4094n = new Object[0];

    /* renamed from: d, reason: collision with root package name */
    public b3.c<Object> f4095d;

    /* renamed from: e, reason: collision with root package name */
    public b3.c<Object> f4096e;
    public b3.c<Object> h;

    /* renamed from: j, reason: collision with root package name */
    public b3.c<Object> f4097j;

    /* renamed from: k, reason: collision with root package name */
    public final JavaType f4098k;

    /* renamed from: l, reason: collision with root package name */
    public final JavaType f4099l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f4100m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class Vanilla extends StdDeserializer<Object> {

        /* renamed from: e, reason: collision with root package name */
        public static final Vanilla f4101e = new Vanilla();

        /* renamed from: d, reason: collision with root package name */
        public final boolean f4102d;

        public Vanilla() {
            this(false);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            int i10 = 2;
            switch (jsonParser.P()) {
                case 1:
                    if (jsonParser.q1() == JsonToken.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 2:
                    return new LinkedHashMap(2);
                case 3:
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    if (jsonTokenQ1 == jsonToken) {
                        return deserializationContext.J(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? UntypedObjectDeserializer.f4094n : new ArrayList(2);
                    }
                    if (deserializationContext.J(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                        l lVarL = deserializationContext.L();
                        Object[] objArrG = lVarL.g();
                        int i11 = 0;
                        while (true) {
                            Object objD = d(jsonParser, deserializationContext);
                            if (i11 >= objArrG.length) {
                                objArrG = lVarL.c(objArrG);
                                i11 = 0;
                            }
                            int i12 = i11 + 1;
                            objArrG[i11] = objD;
                            if (jsonParser.q1() == JsonToken.END_ARRAY) {
                                return lVarL.e(objArrG, i12);
                            }
                            i11 = i12;
                        }
                    } else {
                        Object objD2 = d(jsonParser, deserializationContext);
                        if (jsonParser.q1() == jsonToken) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(objD2);
                            return arrayList;
                        }
                        Object objD3 = d(jsonParser, deserializationContext);
                        if (jsonParser.q1() == jsonToken) {
                            ArrayList arrayList2 = new ArrayList(2);
                            arrayList2.add(objD2);
                            arrayList2.add(objD3);
                            return arrayList2;
                        }
                        l lVarL2 = deserializationContext.L();
                        Object[] objArrG2 = lVarL2.g();
                        objArrG2[0] = objD2;
                        objArrG2[1] = objD3;
                        int i13 = 2;
                        while (true) {
                            Object objD4 = d(jsonParser, deserializationContext);
                            i10++;
                            if (i13 >= objArrG2.length) {
                                objArrG2 = lVarL2.c(objArrG2);
                                i13 = 0;
                            }
                            int i14 = i13 + 1;
                            objArrG2[i13] = objD4;
                            if (jsonParser.q1() == JsonToken.END_ARRAY) {
                                ArrayList arrayList3 = new ArrayList(i10);
                                lVarL2.d(objArrG2, i14, arrayList3);
                                return arrayList3;
                            }
                            i13 = i14;
                        }
                    }
                case 4:
                default:
                    deserializationContext.C(Object.class, jsonParser);
                    throw null;
                case 5:
                    break;
                case 6:
                    return jsonParser.V0();
                case 7:
                    return (StdDeserializer.f4053c & deserializationContext.f3664d) != 0 ? StdDeserializer.z(jsonParser, deserializationContext) : jsonParser.P0();
                case 8:
                    return deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.I0() : jsonParser.P0();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.K0();
            }
            String strV0 = jsonParser.V0();
            jsonParser.q1();
            Object objD5 = d(jsonParser, deserializationContext);
            String strO1 = jsonParser.o1();
            if (strO1 == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(2);
                linkedHashMap.put(strV0, objD5);
                return linkedHashMap;
            }
            jsonParser.q1();
            Object objD6 = d(jsonParser, deserializationContext);
            String strO12 = jsonParser.o1();
            if (strO12 == null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
                linkedHashMap2.put(strV0, objD5);
                if (linkedHashMap2.put(strO1, objD6) != null) {
                    j0(jsonParser, deserializationContext, linkedHashMap2, strV0, objD5, objD6, strO12);
                }
                return linkedHashMap2;
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put(strV0, objD5);
            if (linkedHashMap3.put(strO1, objD6) != null) {
                j0(jsonParser, deserializationContext, linkedHashMap3, strV0, objD5, objD6, strO12);
                return linkedHashMap3;
            }
            String strO13 = strO12;
            do {
                jsonParser.q1();
                Object objD7 = d(jsonParser, deserializationContext);
                Object objPut = linkedHashMap3.put(strO13, objD7);
                if (objPut != null) {
                    j0(jsonParser, deserializationContext, linkedHashMap3, strO13, objPut, objD7, jsonParser.o1());
                    return linkedHashMap3;
                }
                strO13 = jsonParser.o1();
            } while (strO13 != null);
            return linkedHashMap3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
        
            if (r5.q1() == com.fasterxml.jackson.core.JsonToken.END_OBJECT) goto L28;
         */
        @Override // b3.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object e(com.fasterxml.jackson.core.JsonParser r5, com.fasterxml.jackson.databind.DeserializationContext r6, java.lang.Object r7) {
            /*
                r4 = this;
                boolean r0 = r4.f4102d
                if (r0 == 0) goto L9
                java.lang.Object r4 = r4.d(r5, r6)
                return r4
            L9:
                int r0 = r5.P()
                r1 = 1
                if (r0 == r1) goto L3d
                r1 = 2
                if (r0 == r1) goto L45
                r1 = 3
                if (r0 == r1) goto L1d
                r1 = 4
                if (r0 == r1) goto L45
                r1 = 5
                if (r0 == r1) goto L46
                goto L6f
            L1d:
                com.fasterxml.jackson.core.JsonToken r0 = r5.q1()
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_ARRAY
                if (r0 != r1) goto L26
                goto L45
            L26:
                boolean r0 = r7 instanceof java.util.Collection
                if (r0 == 0) goto L6f
                r0 = r7
                java.util.Collection r0 = (java.util.Collection) r0
            L2d:
                java.lang.Object r1 = r4.d(r5, r6)
                r0.add(r1)
                com.fasterxml.jackson.core.JsonToken r1 = r5.q1()
                com.fasterxml.jackson.core.JsonToken r2 = com.fasterxml.jackson.core.JsonToken.END_ARRAY
                if (r1 != r2) goto L2d
                return r7
            L3d:
                com.fasterxml.jackson.core.JsonToken r0 = r5.q1()
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
                if (r0 != r1) goto L46
            L45:
                return r7
            L46:
                boolean r0 = r7 instanceof java.util.Map
                if (r0 == 0) goto L6f
                r0 = r7
                java.util.Map r0 = (java.util.Map) r0
                java.lang.String r1 = r5.C()
            L51:
                r5.q1()
                java.lang.Object r2 = r0.get(r1)
                if (r2 == 0) goto L5f
                java.lang.Object r3 = r4.e(r5, r6, r2)
                goto L63
            L5f:
                java.lang.Object r3 = r4.d(r5, r6)
            L63:
                if (r3 == r2) goto L68
                r0.put(r1, r3)
            L68:
                java.lang.String r1 = r5.o1()
                if (r1 != 0) goto L51
                return r7
            L6f:
                java.lang.Object r4 = r4.d(r5, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.e(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object):java.lang.Object");
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
        public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) throws MismatchedInputException {
            int iP = jsonParser.P();
            if (iP != 1 && iP != 3) {
                switch (iP) {
                    case 5:
                        break;
                    case 6:
                        return jsonParser.V0();
                    case 7:
                        return deserializationContext.J(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS) ? jsonParser.Q() : jsonParser.P0();
                    case 8:
                        return deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.I0() : jsonParser.P0();
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    case 12:
                        return jsonParser.K0();
                    default:
                        deserializationContext.C(Object.class, jsonParser);
                        throw null;
                }
            }
            return bVar.b(jsonParser, deserializationContext);
        }

        public final void j0(JsonParser jsonParser, DeserializationContext deserializationContext, LinkedHashMap linkedHashMap, String str, Object obj, Object obj2, String str2) throws MismatchedInputException {
            boolean zI = deserializationContext.I(StreamReadCapability.DUPLICATE_PROPERTIES);
            if (zI) {
                if (obj instanceof List) {
                    ((List) obj).add(obj2);
                    linkedHashMap.put(str, obj);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj);
                    arrayList.add(obj2);
                    linkedHashMap.put(str, arrayList);
                }
            }
            while (str2 != null) {
                jsonParser.q1();
                Object objD = d(jsonParser, deserializationContext);
                Object objPut = linkedHashMap.put(str2, objD);
                if (objPut != null && zI) {
                    if (objPut instanceof List) {
                        ((List) objPut).add(objD);
                        linkedHashMap.put(str2, objPut);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(objPut);
                        arrayList2.add(objD);
                        linkedHashMap.put(str2, arrayList2);
                    }
                }
                str2 = jsonParser.o1();
            }
        }

        @Override // b3.c
        public final LogicalType o() {
            return LogicalType.f4432e;
        }

        @Override // b3.c
        public final Boolean p(DeserializationConfig deserializationConfig) {
            if (this.f4102d) {
                return Boolean.FALSE;
            }
            return null;
        }

        public Vanilla(boolean z) {
            super((Class<?>) Object.class);
            this.f4102d = z;
        }
    }

    @Deprecated
    public UntypedObjectDeserializer() {
        this((JavaType) null, (JavaType) null);
    }

    @Override // e3.j
    public final void b(DeserializationContext deserializationContext) {
        JavaType javaTypeK = deserializationContext.k(Object.class);
        JavaType javaTypeK2 = deserializationContext.k(String.class);
        TypeFactory typeFactoryE = deserializationContext.e();
        JavaType javaType = this.f4098k;
        if (javaType == null) {
            b3.c<Object> cVarR = deserializationContext.r(typeFactoryE.f(javaTypeK, List.class));
            if (com.fasterxml.jackson.databind.util.a.v(cVarR)) {
                cVarR = null;
            }
            this.f4096e = cVarR;
        } else {
            this.f4096e = deserializationContext.r(javaType);
        }
        JavaType javaType2 = this.f4099l;
        if (javaType2 == null) {
            b3.c<Object> cVarR2 = deserializationContext.r(typeFactoryE.h(Map.class, javaTypeK2, javaTypeK));
            if (com.fasterxml.jackson.databind.util.a.v(cVarR2)) {
                cVarR2 = null;
            }
            this.f4095d = cVarR2;
        } else {
            this.f4095d = deserializationContext.r(javaType2);
        }
        b3.c<Object> cVarR3 = deserializationContext.r(javaTypeK2);
        if (com.fasterxml.jackson.databind.util.a.v(cVarR3)) {
            cVarR3 = null;
        }
        this.h = cVarR3;
        b3.c<Object> cVarR4 = deserializationContext.r(typeFactoryE.j(Number.class));
        if (com.fasterxml.jackson.databind.util.a.v(cVarR4)) {
            cVarR4 = null;
        }
        this.f4097j = cVarR4;
        SimpleType simpleTypeN = TypeFactory.n();
        this.f4095d = deserializationContext.z(this.f4095d, null, simpleTypeN);
        this.f4096e = deserializationContext.z(this.f4096e, null, simpleTypeN);
        this.h = deserializationContext.z(this.h, null, simpleTypeN);
        this.f4097j = deserializationContext.z(this.f4097j, null, simpleTypeN);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // e3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.c<?> c(com.fasterxml.jackson.databind.DeserializationContext r3, com.fasterxml.jackson.databind.BeanProperty r4) {
        /*
            r2 = this;
            r0 = 1
            if (r4 != 0) goto L15
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            com.fasterxml.jackson.databind.DeserializationConfig r3 = r3.f3663c
            com.fasterxml.jackson.databind.cfg.ConfigOverrides r3 = r3.f3835j
            r3.getClass()
            r3 = 0
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L15
            r3 = r0
            goto L16
        L15:
            r3 = 0
        L16:
            b3.c<java.lang.Object> r4 = r2.h
            if (r4 != 0) goto L39
            b3.c<java.lang.Object> r4 = r2.f4097j
            if (r4 != 0) goto L39
            b3.c<java.lang.Object> r4 = r2.f4095d
            if (r4 != 0) goto L39
            b3.c<java.lang.Object> r4 = r2.f4096e
            if (r4 != 0) goto L39
            java.lang.Class r4 = r2.getClass()
            java.lang.Class<com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer> r1 = com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.class
            if (r4 != r1) goto L39
            if (r3 == 0) goto L36
            com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer$Vanilla r2 = new com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer$Vanilla
            r2.<init>(r0)
            return r2
        L36:
            com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer$Vanilla r2 = com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.f4101e
            return r2
        L39:
            boolean r4 = r2.f4100m
            if (r3 == r4) goto L43
            com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer r4 = new com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer
            r4.<init>(r2, r3)
            return r4
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.c(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanProperty):b3.c");
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        switch (jsonParser.P()) {
            case 1:
            case 2:
            case 5:
                b3.c<Object> cVar = this.f4095d;
                return cVar != null ? cVar.d(jsonParser, deserializationContext) : m0(jsonParser, deserializationContext);
            case 3:
                if (deserializationContext.J(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return l0(jsonParser, deserializationContext);
                }
                b3.c<Object> cVar2 = this.f4096e;
                return cVar2 != null ? cVar2.d(jsonParser, deserializationContext) : k0(jsonParser, deserializationContext);
            case 4:
            default:
                deserializationContext.C(Object.class, jsonParser);
                throw null;
            case 6:
                b3.c<Object> cVar3 = this.h;
                return cVar3 != null ? cVar3.d(jsonParser, deserializationContext) : jsonParser.V0();
            case 7:
                b3.c<Object> cVar4 = this.f4097j;
                return cVar4 != null ? cVar4.d(jsonParser, deserializationContext) : (StdDeserializer.f4053c & deserializationContext.f3664d) != 0 ? StdDeserializer.z(jsonParser, deserializationContext) : jsonParser.P0();
            case 8:
                b3.c<Object> cVar5 = this.f4097j;
                return cVar5 != null ? cVar5.d(jsonParser, deserializationContext) : deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.I0() : jsonParser.P0();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.K0();
        }
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        if (this.f4100m) {
            return d(jsonParser, deserializationContext);
        }
        switch (jsonParser.P()) {
            case 1:
            case 2:
            case 5:
                b3.c<Object> cVar = this.f4095d;
                if (cVar == null) {
                    if (!(obj instanceof Map)) {
                        break;
                    } else {
                        Map map = (Map) obj;
                        JsonToken jsonTokenK = jsonParser.K();
                        if (jsonTokenK == JsonToken.START_OBJECT) {
                            jsonTokenK = jsonParser.q1();
                        }
                        if (jsonTokenK != JsonToken.END_OBJECT) {
                            String strC = jsonParser.C();
                            do {
                                jsonParser.q1();
                                Object obj2 = map.get(strC);
                                Object objE = obj2 != null ? e(jsonParser, deserializationContext, obj2) : d(jsonParser, deserializationContext);
                                if (objE != obj2) {
                                    map.put(strC, objE);
                                }
                                strC = jsonParser.o1();
                            } while (strC != null);
                        }
                    }
                } else {
                    break;
                }
                break;
            case 3:
                b3.c<Object> cVar2 = this.f4096e;
                if (cVar2 == null) {
                    if (!(obj instanceof Collection)) {
                        if (!deserializationContext.J(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                            break;
                        } else {
                            break;
                        }
                    } else {
                        Collection collection = (Collection) obj;
                        while (jsonParser.q1() != JsonToken.END_ARRAY) {
                            collection.add(d(jsonParser, deserializationContext));
                        }
                        break;
                    }
                } else {
                    break;
                }
            case 6:
                b3.c<Object> cVar3 = this.h;
                if (cVar3 == null) {
                    break;
                } else {
                    break;
                }
            case 7:
                b3.c<Object> cVar4 = this.f4097j;
                if (cVar4 == null) {
                    if ((StdDeserializer.f4053c & deserializationContext.f3664d) == 0) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 8:
                b3.c<Object> cVar5 = this.f4097j;
                if (cVar5 == null) {
                    if (!deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
        }
        return d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) throws MismatchedInputException {
        int iP = jsonParser.P();
        if (iP != 1 && iP != 3) {
            switch (iP) {
                case 5:
                    break;
                case 6:
                    b3.c<Object> cVar = this.h;
                    return cVar != null ? cVar.d(jsonParser, deserializationContext) : jsonParser.V0();
                case 7:
                    b3.c<Object> cVar2 = this.f4097j;
                    return cVar2 != null ? cVar2.d(jsonParser, deserializationContext) : (StdDeserializer.f4053c & deserializationContext.f3664d) != 0 ? StdDeserializer.z(jsonParser, deserializationContext) : jsonParser.P0();
                case 8:
                    b3.c<Object> cVar3 = this.f4097j;
                    return cVar3 != null ? cVar3.d(jsonParser, deserializationContext) : deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.I0() : jsonParser.P0();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.K0();
                default:
                    deserializationContext.C(Object.class, jsonParser);
                    throw null;
            }
        }
        return bVar.b(jsonParser, deserializationContext);
    }

    public final void j0(JsonParser jsonParser, DeserializationContext deserializationContext, LinkedHashMap linkedHashMap, String str, Object obj, Object obj2, String str2) throws MismatchedInputException {
        boolean zI = deserializationContext.I(StreamReadCapability.DUPLICATE_PROPERTIES);
        if (zI) {
            if (obj instanceof List) {
                ((List) obj).add(obj2);
                linkedHashMap.put(str, obj);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj);
                arrayList.add(obj2);
                linkedHashMap.put(str, arrayList);
            }
        }
        while (str2 != null) {
            jsonParser.q1();
            Object objD = d(jsonParser, deserializationContext);
            Object objPut = linkedHashMap.put(str2, objD);
            if (objPut != null && zI) {
                if (objPut instanceof List) {
                    ((List) objPut).add(objD);
                    linkedHashMap.put(str, objPut);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(objPut);
                    arrayList2.add(objD);
                    linkedHashMap.put(str, arrayList2);
                }
            }
            str2 = jsonParser.o1();
        }
    }

    public final Object k0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        JsonToken jsonTokenQ1 = jsonParser.q1();
        JsonToken jsonToken = JsonToken.END_ARRAY;
        int i10 = 2;
        if (jsonTokenQ1 == jsonToken) {
            return new ArrayList(2);
        }
        Object objD = d(jsonParser, deserializationContext);
        if (jsonParser.q1() == jsonToken) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(objD);
            return arrayList;
        }
        Object objD2 = d(jsonParser, deserializationContext);
        if (jsonParser.q1() == jsonToken) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(objD);
            arrayList2.add(objD2);
            return arrayList2;
        }
        l lVarL = deserializationContext.L();
        Object[] objArrG = lVarL.g();
        objArrG[0] = objD;
        objArrG[1] = objD2;
        int i11 = 2;
        while (true) {
            Object objD3 = d(jsonParser, deserializationContext);
            i10++;
            if (i11 >= objArrG.length) {
                objArrG = lVarL.c(objArrG);
                i11 = 0;
            }
            int i12 = i11 + 1;
            objArrG[i11] = objD3;
            if (jsonParser.q1() == JsonToken.END_ARRAY) {
                ArrayList arrayList3 = new ArrayList(i10);
                lVarL.d(objArrG, i12, arrayList3);
                return arrayList3;
            }
            i11 = i12;
        }
    }

    public final Object[] l0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (jsonParser.q1() == JsonToken.END_ARRAY) {
            return f4094n;
        }
        l lVarL = deserializationContext.L();
        Object[] objArrG = lVarL.g();
        int i10 = 0;
        while (true) {
            Object objD = d(jsonParser, deserializationContext);
            if (i10 >= objArrG.length) {
                objArrG = lVarL.c(objArrG);
                i10 = 0;
            }
            int i11 = i10 + 1;
            objArrG[i10] = objD;
            if (jsonParser.q1() == JsonToken.END_ARRAY) {
                return lVarL.e(objArrG, i11);
            }
            i10 = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(com.fasterxml.jackson.core.JsonParser r16, com.fasterxml.jackson.databind.DeserializationContext r17) throws com.fasterxml.jackson.databind.exc.MismatchedInputException {
        /*
            r15 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r16.K()
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            if (r0 != r1) goto Le
            java.lang.String r0 = r16.o1()
        Lc:
            r7 = r0
            goto L1d
        Le:
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r0 != r1) goto L17
            java.lang.String r0 = r16.C()
            goto Lc
        L17:
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
            r2 = 0
            if (r0 != r1) goto L9b
            r7 = r2
        L1d:
            r0 = 2
            if (r7 != 0) goto L26
            java.util.LinkedHashMap r15 = new java.util.LinkedHashMap
            r15.<init>(r0)
            return r15
        L26:
            r16.q1()
            java.lang.Object r8 = r15.d(r16, r17)
            java.lang.String r1 = r16.o1()
            if (r1 != 0) goto L3c
            java.util.LinkedHashMap r15 = new java.util.LinkedHashMap
            r15.<init>(r0)
            r15.put(r7, r8)
            return r15
        L3c:
            r16.q1()
            java.lang.Object r9 = r15.d(r16, r17)
            java.lang.String r10 = r16.o1()
            if (r10 != 0) goto L61
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r0 = 4
            r6.<init>(r0)
            r6.put(r7, r8)
            java.lang.Object r0 = r6.put(r1, r9)
            if (r0 == 0) goto L60
            r3 = r15
            r4 = r16
            r5 = r17
            r3.j0(r4, r5, r6, r7, r8, r9, r10)
        L60:
            return r6
        L61:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            r6.put(r7, r8)
            java.lang.Object r0 = r6.put(r1, r9)
            if (r0 == 0) goto L78
            r3 = r15
            r4 = r16
            r5 = r17
            r3.j0(r4, r5, r6, r7, r8, r9, r10)
            return r6
        L78:
            r11 = r10
        L79:
            r16.q1()
            java.lang.Object r13 = r15.d(r16, r17)
            java.lang.Object r12 = r6.put(r11, r13)
            if (r12 == 0) goto L94
            java.lang.String r14 = r16.o1()
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r6
            r7.j0(r8, r9, r10, r11, r12, r13, r14)
            return r6
        L94:
            java.lang.String r11 = r16.o1()
            if (r11 != 0) goto L79
            return r6
        L9b:
            java.lang.Class<?> r15 = r15.f4054a
            r4 = r16
            r5 = r17
            r5.C(r15, r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.m0(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
    }

    @Override // b3.c
    public final boolean n() {
        return true;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4432e;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return null;
    }

    public UntypedObjectDeserializer(JavaType javaType, JavaType javaType2) {
        super((Class<?>) Object.class);
        this.f4098k = javaType;
        this.f4099l = javaType2;
        this.f4100m = false;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, boolean z) {
        super((Class<?>) Object.class);
        this.f4095d = untypedObjectDeserializer.f4095d;
        this.f4096e = untypedObjectDeserializer.f4096e;
        this.h = untypedObjectDeserializer.h;
        this.f4097j = untypedObjectDeserializer.f4097j;
        this.f4098k = untypedObjectDeserializer.f4098k;
        this.f4099l = untypedObjectDeserializer.f4099l;
        this.f4100m = z;
    }
}
