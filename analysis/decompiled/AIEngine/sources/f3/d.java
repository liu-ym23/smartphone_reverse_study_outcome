package f3;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final JavaType f8697a;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f8698b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f8699c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f8700d;

    /* renamed from: e, reason: collision with root package name */
    public final p[] f8701e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final JavaType f8702a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f8703b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f8704c = new HashMap();

        public a(JavaType javaType) {
            this.f8702a = javaType;
        }

        public final void a(String str, Integer num) {
            HashMap map = this.f8704c;
            Object obj = map.get(str);
            if (obj == null) {
                map.put(str, num);
                return;
            }
            if (obj instanceof List) {
                ((List) obj).add(num);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(obj);
            linkedList.add(num);
            map.put(str, linkedList);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final SettableBeanProperty f8705a;

        /* renamed from: b, reason: collision with root package name */
        public final k3.b f8706b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8707c;

        /* renamed from: d, reason: collision with root package name */
        public SettableBeanProperty f8708d;

        public b(SettableBeanProperty settableBeanProperty, k3.b bVar) {
            this.f8705a = settableBeanProperty;
            this.f8706b = bVar;
            this.f8707c = bVar.h();
        }
    }

    public d(JavaType javaType, b[] bVarArr, Map map) {
        this.f8697a = javaType;
        this.f8698b = bVarArr;
        this.f8699c = map;
        this.f8700d = null;
        this.f8701e = null;
    }

    public final void a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, int i10, String str) throws MismatchedInputException, JsonGenerationException {
        if (str == null) {
            deserializationContext.R("Internal error in external Type Id handling: `null` type id passed", new Object[0]);
            throw null;
        }
        p.a aVarS1 = this.f8701e[i10].s1(jsonParser);
        JsonToken jsonTokenQ1 = aVarS1.q1();
        JsonToken jsonToken = JsonToken.VALUE_NULL;
        b[] bVarArr = this.f8698b;
        if (jsonTokenQ1 == jsonToken) {
            bVarArr[i10].f8705a.z(obj, null);
            return;
        }
        p pVar = new p(jsonParser, deserializationContext);
        pVar.Z0();
        pVar.f1(str);
        pVar.u1(aVarS1);
        pVar.C0();
        p.a aVarS12 = pVar.s1(jsonParser);
        aVarS12.q1();
        bVarArr[i10].f8705a.i(aVarS12, deserializationContext, obj);
    }

    public final boolean b(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj, String str2, int i10) throws MismatchedInputException, JsonGenerationException {
        if (!str.equals(this.f8698b[i10].f8707c)) {
            return false;
        }
        if (obj != null) {
            p[] pVarArr = this.f8701e;
            if (pVarArr[i10] != null) {
                a(jsonParser, deserializationContext, obj, i10, str2);
                pVarArr[i10] = null;
                return true;
            }
        }
        this.f8700d[i10] = str2;
        return true;
    }

    public final Object c(JsonParser jsonParser, DeserializationContext deserializationContext, g gVar, PropertyBasedCreator propertyBasedCreator) throws MismatchedInputException, JsonGenerationException {
        String strE;
        b[] bVarArr = this.f8698b;
        int length = bVarArr.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = this.f8700d[i10];
            b bVar = bVarArr[i10];
            JavaType javaType = this.f8697a;
            Object objH = null;
            p[] pVarArr = this.f8701e;
            if (str == null) {
                p pVar = pVarArr[i10];
                if (pVar != null && pVar.f11586l.d(0) != JsonToken.VALUE_NULL) {
                    if (!bVar.f8706b.k()) {
                        String str2 = bVar.f8705a.f3891c.f3755a;
                        Object[] objArr2 = {bVar.f8707c};
                        deserializationContext.getClass();
                        Class<?> cls = javaType.f3690a;
                        MismatchedInputException mismatchedInputException = new MismatchedInputException(deserializationContext.h, String.format("Missing external type id property '%s'", objArr2));
                        if (str2 == null) {
                            throw mismatchedInputException;
                        }
                        mismatchedInputException.f(new JsonMappingException.Reference(cls, str2));
                        throw mismatchedInputException;
                    }
                    k3.b bVar2 = bVar.f8706b;
                    Class<?> clsG = bVar2.g();
                    strE = clsG == null ? null : bVar2.i().e(clsG, null);
                }
            } else {
                strE = str;
                if (pVarArr[i10] == null) {
                    SettableBeanProperty settableBeanProperty = bVar.f8705a;
                    Boolean bool = settableBeanProperty.f4149a.f3745a;
                    if (bool == null || !bool.booleanValue()) {
                        strE = str;
                        if (deserializationContext.J(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                        }
                    }
                    String str3 = settableBeanProperty.f3891c.f3755a;
                    Object[] objArr3 = {str3, bVarArr[i10].f8707c};
                    deserializationContext.getClass();
                    Class<?> cls2 = javaType.f3690a;
                    MismatchedInputException mismatchedInputException2 = new MismatchedInputException(deserializationContext.h, String.format("Missing property '%s' for external type id '%s'", objArr3));
                    if (str3 == null) {
                        throw mismatchedInputException2;
                    }
                    mismatchedInputException2.f(new JsonMappingException.Reference(cls2, str3));
                    throw mismatchedInputException2;
                }
            }
            p pVar2 = pVarArr[i10];
            if (pVar2 != null) {
                p.a aVarS1 = pVar2.s1(jsonParser);
                if (aVarS1.q1() != JsonToken.VALUE_NULL) {
                    p pVar3 = new p(jsonParser, deserializationContext);
                    pVar3.Z0();
                    pVar3.f1(strE);
                    pVar3.u1(aVarS1);
                    pVar3.C0();
                    p.a aVarS12 = pVar3.s1(jsonParser);
                    aVarS12.q1();
                    objH = bVarArr[i10].f8705a.h(aVarS12, deserializationContext);
                }
                objArr[i10] = objH;
            }
            SettableBeanProperty settableBeanProperty2 = bVar.f8705a;
            if (settableBeanProperty2.m() >= 0) {
                gVar.b(settableBeanProperty2, objArr[i10]);
                SettableBeanProperty settableBeanProperty3 = bVar.f8708d;
                if (settableBeanProperty3 != null && settableBeanProperty3.m() >= 0) {
                    Object objD = strE;
                    if (!settableBeanProperty3.f3892d.u(String.class)) {
                        p pVar4 = new p(jsonParser, deserializationContext);
                        pVar4.f1(strE);
                        b3.c<Object> cVarR = settableBeanProperty3.r();
                        p.a aVarT1 = pVar4.t1(pVar4.f11580b);
                        aVarT1.q1();
                        objD = cVarR.d(aVarT1, deserializationContext);
                    }
                    gVar.b(settableBeanProperty3, objD);
                }
            }
        }
        Object objA = propertyBasedCreator.a(deserializationContext, gVar);
        for (int i11 = 0; i11 < length; i11++) {
            SettableBeanProperty settableBeanProperty4 = bVarArr[i11].f8705a;
            if (settableBeanProperty4.m() < 0) {
                settableBeanProperty4.z(objA, objArr[i11]);
            }
        }
        return objA;
    }

    public final void d(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws MismatchedInputException, JsonGenerationException {
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        Object obj2;
        d dVar;
        b[] bVarArr = this.f8698b;
        int length = bVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            String strE = this.f8700d[i10];
            b bVar = bVarArr[i10];
            p[] pVarArr = this.f8701e;
            if (strE == null) {
                p pVar = pVarArr[i10];
                if (pVar != null) {
                    if (pVar.f11586l.d(0).f3600k) {
                        p.a aVarS1 = pVar.s1(jsonParser);
                        aVarS1.q1();
                        SettableBeanProperty settableBeanProperty = bVar.f8705a;
                        Object objA = k3.b.a(aVarS1, settableBeanProperty.f3892d);
                        if (objA != null) {
                            settableBeanProperty.z(obj, objA);
                        }
                    }
                    k3.b bVar2 = bVar.f8706b;
                    String str = bVar.f8707c;
                    PropertyName propertyName = bVar.f8705a.f3891c;
                    boolean zK = bVar2.k();
                    JavaType javaType = this.f8697a;
                    if (!zK) {
                        String str2 = propertyName.f3755a;
                        deserializationContext.getClass();
                        Class<?> cls = javaType.f3690a;
                        MismatchedInputException mismatchedInputException = new MismatchedInputException(deserializationContext.h, String.format("Missing external type id property '%s' (and no 'defaultImpl' specified)", str));
                        if (str2 == null) {
                            throw mismatchedInputException;
                        }
                        mismatchedInputException.f(new JsonMappingException.Reference(cls, str2));
                        throw mismatchedInputException;
                    }
                    k3.b bVar3 = bVar.f8706b;
                    Class<?> clsG = bVar3.g();
                    strE = clsG == null ? null : bVar3.i().e(clsG, null);
                    if (strE == null) {
                        String str3 = propertyName.f3755a;
                        deserializationContext.getClass();
                        Class<?> cls2 = javaType.f3690a;
                        MismatchedInputException mismatchedInputException2 = new MismatchedInputException(deserializationContext.h, String.format("Invalid default type id for property '%s': `null` returned by TypeIdResolver", str));
                        if (str3 == null) {
                            throw mismatchedInputException2;
                        }
                        mismatchedInputException2.f(new JsonMappingException.Reference(cls2, str3));
                        throw mismatchedInputException2;
                    }
                }
                dVar = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                obj2 = obj;
                i10++;
                this = dVar;
                jsonParser = jsonParser2;
                deserializationContext = deserializationContext2;
                obj = obj2;
            } else if (pVarArr[i10] == null) {
                SettableBeanProperty settableBeanProperty2 = bVar.f8705a;
                Boolean bool = settableBeanProperty2.f4149a.f3745a;
                if ((bool == null || !bool.booleanValue()) && !deserializationContext.J(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                    return;
                }
                Class<?> cls3 = obj.getClass();
                String str4 = settableBeanProperty2.f3891c.f3755a;
                Object[] objArr = {str4, bVar.f8707c};
                deserializationContext.getClass();
                MismatchedInputException mismatchedInputException3 = new MismatchedInputException(deserializationContext.h, String.format("Missing property '%s' for external type id '%s'", objArr));
                if (str4 == null) {
                    throw mismatchedInputException3;
                }
                mismatchedInputException3.f(new JsonMappingException.Reference(cls3, str4));
                throw mismatchedInputException3;
            }
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            obj2 = obj;
            String str5 = strE;
            dVar = this;
            dVar.a(jsonParser2, deserializationContext2, obj2, i10, str5);
            i10++;
            this = dVar;
            jsonParser = jsonParser2;
            deserializationContext = deserializationContext2;
            obj = obj2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12, java.lang.Object r13, java.lang.String r14) throws com.fasterxml.jackson.databind.exc.MismatchedInputException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r10 = this;
            java.util.Map<java.lang.String, java.lang.Object> r4 = r10.f8699c
            java.lang.Object r4 = r4.get(r14)
            if (r4 != 0) goto La
            r0 = 0
            return r0
        La:
            boolean r5 = r4 instanceof java.util.List
            r6 = 1
            f3.d$b[] r7 = r10.f8698b
            q3.p[] r8 = r10.f8701e
            java.lang.String[] r9 = r10.f8700d
            if (r5 == 0) goto L70
            java.util.List r4 = (java.util.List) r4
            java.util.Iterator r0 = r4.iterator()
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r5 = r4.intValue()
            r5 = r7[r5]
            java.lang.String r5 = r5.f8707c
            boolean r3 = r14.equals(r5)
            if (r3 == 0) goto L4f
            java.lang.String r2 = r11.V0()
            r11.v1()
            int r1 = r4.intValue()
            r9[r1] = r2
        L3c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r9[r1] = r2
            goto L3c
        L4f:
            q3.p r3 = new q3.p
            r3.<init>(r11, r12)
            r3.u1(r11)
            int r1 = r4.intValue()
            r8[r1] = r3
        L5d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r8[r1] = r3
            goto L5d
        L70:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r7[r4]
            java.lang.String r5 = r5.f8707c
            boolean r3 = r14.equals(r5)
            if (r3 == 0) goto L90
            java.lang.String r3 = r11.f1()
            r9[r4] = r3
            r11.v1()
            if (r13 == 0) goto Lae
            r3 = r8[r4]
            if (r3 == 0) goto Lae
            goto La0
        L90:
            q3.p r3 = new q3.p
            r3.<init>(r11, r12)
            r3.u1(r11)
            r8[r4] = r3
            if (r13 == 0) goto Lae
            r3 = r9[r4]
            if (r3 == 0) goto Lae
        La0:
            r5 = r9[r4]
            r7 = 0
            r9[r4] = r7
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r0.a(r1, r2, r3, r4, r5)
            r8[r4] = r7
        Lae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.d.e(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object, java.lang.String):boolean");
    }

    public final void f(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws MismatchedInputException, JsonGenerationException {
        Object obj2 = this.f8699c.get(str);
        if (obj2 == null) {
            return;
        }
        String strV0 = jsonParser.V0();
        if (!(obj2 instanceof List)) {
            b(jsonParser, deserializationContext, str, obj, strV0, ((Integer) obj2).intValue());
            return;
        }
        Iterator it = ((List) obj2).iterator();
        while (it.hasNext()) {
            b(jsonParser, deserializationContext, str, obj, strV0, ((Integer) it.next()).intValue());
        }
    }

    public d(d dVar) {
        this.f8697a = dVar.f8697a;
        b[] bVarArr = dVar.f8698b;
        this.f8698b = bVarArr;
        this.f8699c = dVar.f8699c;
        int length = bVarArr.length;
        this.f8700d = new String[length];
        this.f8701e = new p[length];
    }
}
