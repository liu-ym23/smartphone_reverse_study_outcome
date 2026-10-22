package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.lang.invoke.VarHandle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'h' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b0 implements x {
    public static final b0 A;
    public static final b0 B;
    public static final b0 C;
    public static final b0 D;
    public static final b0 E;
    public static final b0 F;
    public static final b0 G;
    public static final b0 H;
    public static final b0 I;
    public static final b0 J;
    public static final b0 K;
    public static final b0 L;
    public static final b0 M;
    public static final b0 N;
    public static final b0 O;
    public static final b0 P;
    public static final b0 Q;
    public static final b0 R;
    public static final b0 S;
    public static final b0 T;
    public static final b0 U;
    public static final b0 V;
    public static final b0 W;
    public static final b0 X;
    public static final b0 Y;
    public static final b0 Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final b0 f1914a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final b0 f1915b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final b0 f1916c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final b0 f1917d0;
    public static final b0 e0;
    public static final b0 f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final HashMap f1918g0;

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f1919h;

    /* renamed from: h0, reason: collision with root package name */
    public static final /* synthetic */ b0[] f1920h0;
    public static final b0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final b0 f1921j;

    /* renamed from: k, reason: collision with root package name */
    public static final b0 f1922k;

    /* renamed from: l, reason: collision with root package name */
    public static final b0 f1923l;

    /* renamed from: m, reason: collision with root package name */
    public static final b0 f1924m;

    /* renamed from: n, reason: collision with root package name */
    public static final b0 f1925n;

    /* renamed from: o, reason: collision with root package name */
    public static final b0 f1926o;

    /* renamed from: p, reason: collision with root package name */
    public static final b0 f1927p;

    /* renamed from: q, reason: collision with root package name */
    public static final b0 f1928q;

    /* renamed from: r, reason: collision with root package name */
    public static final b0 f1929r;

    /* renamed from: s, reason: collision with root package name */
    public static final b0 f1930s;

    /* renamed from: t, reason: collision with root package name */
    public static final b0 f1931t;

    /* renamed from: u, reason: collision with root package name */
    public static final b0 f1932u;

    /* renamed from: v, reason: collision with root package name */
    public static final b0 f1933v;

    /* renamed from: w, reason: collision with root package name */
    public static final b0 f1934w;

    /* renamed from: x, reason: collision with root package name */
    public static final a0 f1935x;

    /* renamed from: y, reason: collision with root package name */
    public static final b0 f1936y;

    /* renamed from: z, reason: collision with root package name */
    public static final b0 f1937z;

    /* renamed from: c, reason: collision with root package name */
    public final String f1938c;

    /* renamed from: f, reason: collision with root package name */
    public final y0 f1939f;

    /* renamed from: g, reason: collision with root package name */
    public final w7.r f1940g;

    static {
        ad.o oVar = new ad.o(13);
        w7.r rVar = w7.r.f15361j;
        b0 b0Var = new b0("ADDITIONAL_PROPERTIES", 0, "additionalProperties", oVar, rVar);
        f1919h = b0Var;
        b0 b0Var2 = new b0("ALL_OF", 1, "allOf", new ad.o(15), rVar);
        i = b0Var2;
        final int i3 = 26;
        b0 b0Var3 = new b0("ANY_OF", 2, "anyOf", new ad.o(i3), rVar);
        f1921j = b0Var3;
        final int i10 = 8;
        y0 y0Var = new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i11 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i10) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i11), it.next(), lVar));
                            i11++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var4 = b0.X;
                        g gVar = new g(b0Var4, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var4.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i12 = 0; i12 < value.size(); i12++) {
                                    arrayList.add(value.get(i12).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i13 = 0; i13 < jsonNode4.size(); i13++) {
                                    list.add(jsonNode4.get(i13).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar2 = new r();
                            rVar2.f2015f = strAsText3;
                            rVar2.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar2;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        };
        w7.r rVar2 = w7.r.i;
        b0 b0Var4 = new b0("CONST", 3, "const", y0Var, rVar2);
        f1922k = b0Var4;
        final int i11 = 20;
        b0 b0Var5 = new b0("CONTAINS", 4, "contains", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i11) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i12 = 0; i12 < value.size(); i12++) {
                                    arrayList.add(value.get(i12).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i13 = 0; i13 < jsonNode4.size(); i13++) {
                                    list.add(jsonNode4.get(i13).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar2);
        f1923l = b0Var5;
        final int i12 = 21;
        y0 y0Var2 = new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i12) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i13 = 0; i13 < jsonNode4.size(); i13++) {
                                    list.add(jsonNode4.get(i13).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        };
        w7.r rVar3 = w7.r.f15364m;
        b0 b0Var6 = new b0("CONTENT_ENCODING", 5, "contentEncoding", y0Var2, rVar3);
        f1924m = b0Var6;
        final int i13 = 22;
        b0 b0Var7 = new b0("CONTENT_MEDIA_TYPE", 6, "contentMediaType", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i13) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar3);
        f1925n = b0Var7;
        final int i14 = 23;
        y0 y0Var3 = new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i14) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        };
        w7.r rVar4 = w7.r.f15359g;
        b0 b0Var8 = new b0("DEPENDENCIES", 7, "dependencies", y0Var3, rVar4);
        f1926o = b0Var8;
        final int i15 = 24;
        y0 y0Var4 = new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i15) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        };
        w7.r rVar5 = w7.r.f15358f;
        b0 b0Var9 = new b0("DEPENDENT_REQUIRED", 8, "dependentRequired", y0Var4, rVar5);
        f1927p = b0Var9;
        final int i16 = 25;
        b0 b0Var10 = new b0("DEPENDENT_SCHEMAS", 9, "dependentSchemas", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i16) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        f1928q = b0Var10;
        b0 b0Var11 = new b0("DISCRIMINATOR", 10, "discriminator", new ad.o(i15), rVar5);
        f1929r = b0Var11;
        final int i17 = 5;
        b0 b0Var12 = new b0("DYNAMIC_REF", 11, "$dynamicRef", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i17) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        f1930s = b0Var12;
        final int i18 = 16;
        b0 b0Var13 = new b0("ENUM", 12, "enum", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i18) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        f1931t = b0Var13;
        b0 b0Var14 = new b0("EXCLUSIVE_MAXIMUM", 13, "exclusiveMaximum", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i3) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar2);
        f1932u = b0Var14;
        final int i19 = 27;
        b0 b0Var15 = new b0("EXCLUSIVE_MINIMUM", 14, "exclusiveMinimum", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i19) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar2);
        f1933v = b0Var15;
        final int i20 = 28;
        y0 y0Var5 = new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i20) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        };
        w7.r rVar6 = w7.r.f15360h;
        b0 b0Var16 = new b0("FALSE", 15, "false", y0Var5, rVar6);
        f1934w = b0Var16;
        a0 a0Var = new a0("FORMAT", 16, "format", null, rVar);
        f1935x = a0Var;
        b0 b0Var17 = new b0("ID", 17, "id", null, rVar4);
        f1936y = b0Var17;
        final int i21 = 29;
        b0 b0Var18 = new b0("IF_THEN_ELSE", 18, "if", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i21) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar3);
        f1937z = b0Var18;
        b0 b0Var19 = new b0("ITEMS", 19, "items", new z(0), rVar5);
        A = b0Var19;
        b0 b0Var20 = new b0("ITEMS_LEGACY", 20, "items", new z(1), rVar);
        B = b0Var20;
        final int i22 = 14;
        b0 b0Var21 = new b0("MAX_CONTAINS", 21, "maxContains", new ad.o(i22), rVar5);
        C = b0Var21;
        b0 b0Var22 = new b0("MAX_ITEMS", 22, "maxItems", new ad.o(i18), rVar);
        D = b0Var22;
        b0 b0Var23 = new b0("MAX_LENGTH", 23, "maxLength", new ad.o(17), rVar);
        E = b0Var23;
        b0 b0Var24 = new b0("MAX_PROPERTIES", 24, "maxProperties", new ad.o(18), rVar);
        F = b0Var24;
        b0 b0Var25 = new b0("MAXIMUM", 25, "maximum", new ad.o(19), rVar);
        G = b0Var25;
        b0 b0Var26 = new b0("MIN_CONTAINS", 26, "minContains", new ad.o(i22), rVar5);
        H = b0Var26;
        b0 b0Var27 = new b0("MIN_ITEMS", 27, "minItems", new ad.o(i11), rVar);
        I = b0Var27;
        b0 b0Var28 = new b0("MIN_LENGTH", 28, "minLength", new ad.o(i12), rVar);
        J = b0Var28;
        b0 b0Var29 = new b0("MIN_PROPERTIES", 29, "minProperties", new ad.o(i13), rVar);
        K = b0Var29;
        b0 b0Var30 = new b0("MINIMUM", 30, "minimum", new ad.o(23), rVar);
        L = b0Var30;
        b0 b0Var31 = new b0("MULTIPLE_OF", 31, "multipleOf", new ad.o(25), rVar);
        M = b0Var31;
        b0 b0Var32 = new b0("NOT_ALLOWED", 32, "notAllowed", new ad.o(i19), rVar4);
        N = b0Var32;
        b0 b0Var33 = new b0("NOT", 33, "not", new ad.o(28), rVar);
        O = b0Var33;
        b0 b0Var34 = new b0("ONE_OF", 34, "oneOf", new ad.o(29), rVar);
        P = b0Var34;
        final int i23 = 0;
        b0 b0Var35 = new b0("PATTERN_PROPERTIES", 35, "patternProperties", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i23) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        Q = b0Var35;
        final int i24 = 1;
        b0 b0Var36 = new b0("PATTERN", 36, "pattern", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i24) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        R = b0Var36;
        final int i25 = 2;
        b0 b0Var37 = new b0("PREFIX_ITEMS", 37, "prefixItems", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i25) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        S = b0Var37;
        final int i26 = 3;
        b0 b0Var38 = new b0("PROPERTIES", 38, "properties", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i26) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        T = b0Var38;
        final int i27 = 4;
        b0 b0Var39 = new b0("PROPERTY_DEPENDENCIES", 39, "propertyDependencies", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i27) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        U = b0Var39;
        final int i28 = 6;
        b0 b0Var40 = new b0("PROPERTY_NAMES", 40, "propertyNames", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i28) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar2);
        V = b0Var40;
        final int i29 = 7;
        b0 b0Var41 = new b0("READ_ONLY", 41, "readOnly", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i29) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var42 = b0.X;
                        g gVar = new g(b0Var42, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var42.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar3);
        W = b0Var41;
        final int i30 = 9;
        b0 b0Var42 = new b0("RECURSIVE_REF", 42, "$recursiveRef", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i30) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        X = b0Var42;
        final int i31 = 10;
        b0 b0Var43 = new b0("REF", 43, "$ref", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i31) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        Y = b0Var43;
        final int i32 = 11;
        b0 b0Var44 = new b0("REQUIRED", 44, "required", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i32) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        Z = b0Var44;
        final int i33 = 12;
        b0 b0Var45 = new b0("TRUE", 45, "true", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i33) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar6);
        f1914a0 = b0Var45;
        final int i34 = 13;
        b0 b0Var46 = new b0("TYPE", 46, "type", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i34) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        f1915b0 = b0Var46;
        b0 b0Var47 = new b0("UNEVALUATED_ITEMS", 47, "unevaluatedItems", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i22) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        f1916c0 = b0Var47;
        final int i35 = 15;
        b0 b0Var48 = new b0("UNEVALUATED_PROPERTIES", 48, "unevaluatedProperties", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i35) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        f1917d0 = b0Var48;
        final int i36 = 17;
        b0 b0Var49 = new b0("UNION_TYPE", 49, "unionType", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i36) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar5);
        final int i37 = 18;
        b0 b0Var50 = new b0("UNIQUE_ITEMS", 50, "uniqueItems", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i37) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar);
        e0 = b0Var50;
        final int i38 = 19;
        b0 b0Var51 = new b0("WRITE_ONLY", 51, "writeOnly", new y0() { // from class: b8.y
            @Override // b8.y0
            public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
                JsonNode jsonNode2;
                Integer numValueOf;
                int i112 = 0;
                w7.l lVarD = null;
                Integer num = null;
                switch (i38) {
                    case 0:
                        i iVar = new i(b0.Q, jsonNode, nVar, lVar, qVar, 3);
                        iVar.f1967h = new IdentityHashMap();
                        if (!jsonNode.isObject()) {
                            throw new w7.m("patternProperties must be an object node");
                        }
                        Iterator<String> itFieldNames = jsonNode.fieldNames();
                        while (itFieldNames.hasNext()) {
                            String next = itFieldNames.next();
                            ((IdentityHashMap) iVar.f1967h).put(d8.c.a(next, qVar), qVar.d(nVar.b(next), jsonNode.get(next), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return iVar;
                    case 1:
                        k0 k0Var = new k0(b0.R, jsonNode, nVar, lVar, qVar);
                        String str = (String) Optional.ofNullable(jsonNode).filter(new a8.e(3)).map(new a8.b(4)).orElse(null);
                        k0Var.f1976g = str;
                        try {
                            k0Var.f1977h = d8.c.a(str, qVar);
                            VarHandle.storeStoreFence();
                            return k0Var;
                        } catch (RuntimeException e10) {
                            e10.setStackTrace(new StackTraceElement[0]);
                            k0.i.e("Failed to compile pattern '{}': {}", k0Var.f1976g, e10.getMessage());
                            throw e10;
                        }
                    case 2:
                        c cVar = new c(b0.S, jsonNode, nVar, lVar, qVar, 3);
                        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
                            g5.f.s("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
                            return null;
                        }
                        cVar.f1942h = new ArrayList(jsonNode.size());
                        Iterator<JsonNode> it = jsonNode.iterator();
                        while (it.hasNext()) {
                            cVar.f1942h.add(qVar.d(nVar.a(i112), it.next(), lVar));
                            i112++;
                        }
                        VarHandle.storeStoreFence();
                        return cVar;
                    case 3:
                        l0 l0Var = new l0(b0.T, jsonNode, nVar, lVar, qVar, 0);
                        l0Var.f1981h = new LinkedHashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next2 = itFields.next();
                            String key = next2.getKey();
                            l0Var.f1981h.put(key, qVar.d(nVar.b(key), next2.getValue(), lVar));
                        }
                        VarHandle.storeStoreFence();
                        return l0Var;
                    case 4:
                        l0 l0Var2 = new l0(b0.U, jsonNode, nVar, lVar, qVar, 1);
                        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                        l0Var2.f1981h = new LinkedHashMap(setProperties.size());
                        for (Map.Entry<String, JsonNode> entry : setProperties) {
                            String key2 = entry.getKey();
                            w7.n nVarB = nVar.b(key2);
                            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                                ((Map) l0Var2.f1981h.computeIfAbsent(key2, new a8.b(5))).put(entry2.getKey(), qVar.d(nVarB.b(entry2.getKey()), entry2.getValue(), lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return l0Var2;
                    case 5:
                        return new g(b0.f1930s, jsonNode, nVar, lVar, qVar, 1);
                    case 6:
                        j0 j0Var = new j0(b0.V, jsonNode, nVar, lVar, qVar, 1);
                        j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var;
                    case 7:
                        m0 m0Var = new m0(b0.W, jsonNode, nVar, lVar, qVar);
                        m0.f1987g.a("Loaded ReadOnlyValidator for property {} as {}", lVar, "read mode");
                        return m0Var;
                    case 8:
                        return new g(b0.f1922k, jsonNode, nVar, lVar, qVar, 0);
                    case 9:
                        b0 b0Var422 = b0.X;
                        g gVar = new g(b0Var422, jsonNode, nVar, lVar, qVar, 3);
                        String strAsText = jsonNode.asText();
                        if ("#".equals(strAsText)) {
                            return gVar;
                        }
                        w7.j jVarJ = gVar.j();
                        jVarJ.f15290a = b0Var422.f1938c;
                        jVarJ.i = "internal.invalidRecursiveRef";
                        jVarJ.f15296g = "The value of a $recursiveRef must be '#' but is '{0}'";
                        jVarJ.f15293d = nVar.f15340b;
                        jVarJ.f15294e = new Object[]{strAsText};
                        throw new w7.m(jVarJ.a());
                    case 10:
                        i iVar2 = new i(b0.Y, jsonNode, nVar, lVar, qVar, 4);
                        iVar2.f1967h = i.m(lVar, qVar, jsonNode.asText());
                        VarHandle.storeStoreFence();
                        return iVar2;
                    case 11:
                        i0 i0Var = new i0(b0.Z, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode.isArray()) {
                            i0Var.f1969h = new ArrayList(jsonNode.size());
                            Iterator<JsonNode> it2 = jsonNode.iterator();
                            while (it2.hasNext()) {
                                i0Var.f1969h.add(it2.next().asText());
                            }
                        } else {
                            i0Var.f1969h = Collections.EMPTY_LIST;
                        }
                        VarHandle.storeStoreFence();
                        return i0Var;
                    case 12:
                        return new g(b0.f1914a0, jsonNode, nVar, lVar, qVar, 4);
                    case 13:
                        return new s0(nVar, jsonNode, lVar, qVar);
                    case 14:
                        e0 e0Var = new e0(b0.f1916c0, jsonNode, nVar, lVar, qVar, 2);
                        e0Var.f1953h = w7.r.f15363l.f15366c.contains(((y7.a) qVar.f1600c).f15933e);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                            return null;
                        }
                        e0Var.i = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return e0Var;
                    case 15:
                        j0 j0Var2 = new j0(b0.f1917d0, jsonNode, nVar, lVar, qVar, 2);
                        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                            g5.f.s("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                            return null;
                        }
                        j0Var2.f1973h = qVar.d(nVar, jsonNode, lVar);
                        VarHandle.storeStoreFence();
                        return j0Var2;
                    case 16:
                        k kVar = new k(b0.f1931t, jsonNode, nVar, lVar, qVar, 1);
                        if (jsonNode == null || !jsonNode.isArray()) {
                            kVar.f1975h = Collections.EMPTY_SET;
                            kVar.i = "[none]";
                        } else {
                            kVar.f1975h = new HashSet();
                            StringBuilder sb2 = new StringBuilder("[");
                            Iterator<JsonNode> it3 = jsonNode.iterator();
                            String str2 = "";
                            while (it3.hasNext()) {
                                JsonNode next3 = it3.next();
                                if (next3.isNumber()) {
                                    ((Set) kVar.f1975h).add(DecimalNode.valueOf(new BigDecimal(next3.decimalValue().toPlainString())));
                                } else if (next3.isArray()) {
                                    ((Set) kVar.f1975h).add(k.m((ArrayNode) next3));
                                } else {
                                    ((Set) kVar.f1975h).add(next3);
                                }
                                sb2.append(str2);
                                sb2.append((next3.isObject() || next3.isArray() || next3.isTextual()) ? next3.toString() : next3.asText());
                                str2 = ", ";
                            }
                            if (qVar.f1599b && (jsonNode2 = lVar.f15331g.get("nullable")) != null && jsonNode2.asBoolean()) {
                                ((Set) kVar.f1975h).add(NullNode.getInstance());
                                sb2.append(", null");
                            }
                            sb2.append(']');
                            kVar.i = sb2.toString();
                        }
                        VarHandle.storeStoreFence();
                        return kVar;
                    case 17:
                        return new k(nVar, jsonNode, lVar, qVar);
                    case 18:
                        v0 v0Var = new v0(b0.e0, jsonNode, nVar, lVar, qVar);
                        if (jsonNode.isBoolean()) {
                            v0Var.f2033g = jsonNode.booleanValue();
                        } else {
                            v0Var.f2033g = false;
                        }
                        VarHandle.storeStoreFence();
                        return v0Var;
                    case 19:
                        z0 z0Var = new z0(b0.f0, jsonNode, nVar, lVar, qVar);
                        z0.f2041g.a("Loaded WriteOnlyValidator for property {} as {}", lVar, "write mode");
                        return z0Var;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        b bVar = new b(b0.f1923l, jsonNode, nVar, lVar, qVar, 1);
                        bVar.i = w7.r.f15362k.f15366c.contains(((y7.a) bVar.f1954d.f1600c).f15933e);
                        if (jsonNode.isObject() || jsonNode.isBoolean()) {
                            bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                            JsonNode jsonNode3 = lVar.f15331g;
                            Optional optionalFilter = Optional.ofNullable(jsonNode3.get(b0.C.f1938c)).filter(new a8.e(2));
                            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                            Optional optionalFilter2 = Optional.ofNullable(jsonNode3.get(b0.H.f1938c)).filter(new a8.e(2));
                            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                            num = numValueOf2;
                        } else {
                            bVar.f1911h = null;
                            numValueOf = null;
                        }
                        bVar.f1913k = num;
                        bVar.f1912j = numValueOf;
                        VarHandle.storeStoreFence();
                        return bVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        i iVar3 = new i(b0.f1924m, jsonNode, nVar, lVar, qVar, 0);
                        iVar3.f1967h = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return iVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        j jVar = new j(b0.f1925n, jsonNode, nVar, lVar, qVar);
                        jVar.f1971g = jsonNode.textValue();
                        VarHandle.storeStoreFence();
                        return jVar;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        k kVar2 = new k(b0.f1926o, jsonNode, nVar, lVar, qVar, 0);
                        HashMap map = new HashMap();
                        kVar2.f1975h = map;
                        kVar2.i = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields2 = jsonNode.fields();
                        while (itFields2.hasNext()) {
                            Map.Entry<String, JsonNode> next4 = itFields2.next();
                            String key3 = next4.getKey();
                            JsonNode value = next4.getValue();
                            if (value.isArray()) {
                                List arrayList = (List) map.get(key3);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(key3, arrayList);
                                }
                                for (int i122 = 0; i122 < value.size(); i122++) {
                                    arrayList.add(value.get(i122).asText());
                                }
                            } else if (value.isObject() || value.isBoolean()) {
                                ((HashMap) kVar2.i).put(key3, qVar.d(nVar.b(key3), value, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return kVar2;
                    case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                        l lVar2 = new l(b0.f1927p, jsonNode, nVar, lVar, qVar, 0);
                        lVar2.f1979h = new HashMap();
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next5 = itFieldNames2.next();
                            JsonNode jsonNode4 = jsonNode.get(next5);
                            if (jsonNode4.isArray()) {
                                List list = (List) lVar2.f1979h.computeIfAbsent(next5, new a8.b(3));
                                for (int i132 = 0; i132 < jsonNode4.size(); i132++) {
                                    list.add(jsonNode4.get(i132).asText());
                                }
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        l lVar3 = new l(b0.f1928q, jsonNode, nVar, lVar, qVar, 1);
                        lVar3.f1979h = new HashMap();
                        Iterator<String> itFieldNames3 = jsonNode.fieldNames();
                        while (itFieldNames3.hasNext()) {
                            String next6 = itFieldNames3.next();
                            JsonNode jsonNode5 = jsonNode.get(next6);
                            if (jsonNode5.isObject() || jsonNode5.isBoolean()) {
                                lVar3.f1979h.put(next6, qVar.d(nVar.b(next6), jsonNode5, lVar));
                            }
                        }
                        VarHandle.storeStoreFence();
                        return lVar3;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        q qVar2 = new q(b0.f1932u, jsonNode, nVar, lVar, qVar, 0);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMaximum value is not a number");
                        }
                        String strAsText2 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar2.k())) {
                            long jAsLong = jsonNode.asLong();
                            p pVar = new p(0);
                            pVar.f2005h = jsonNode;
                            pVar.f2003f = strAsText2;
                            pVar.f2004g = jAsLong;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = pVar;
                        } else {
                            p5.e eVar = new p5.e(2);
                            eVar.f9722f = jsonNode;
                            eVar.f9723g = strAsText2;
                            VarHandle.storeStoreFence();
                            qVar2.f2011h = eVar;
                        }
                        VarHandle.storeStoreFence();
                        return qVar2;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        q qVar3 = new q(b0.f1933v, jsonNode, nVar, lVar, qVar, 1);
                        if (!jsonNode.isNumber()) {
                            throw new w7.m("exclusiveMinimum value is not a number");
                        }
                        String strAsText3 = jsonNode.asText();
                        if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(qVar3.k())) {
                            long jAsLong2 = jsonNode.asLong();
                            r rVar22 = new r();
                            rVar22.f2015f = strAsText3;
                            rVar22.f2014c = jAsLong2;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = rVar22;
                        } else {
                            p5.l lVar4 = new p5.l();
                            lVar4.f9738c = jsonNode;
                            lVar4.f9739f = strAsText3;
                            VarHandle.storeStoreFence();
                            qVar3.f2011h = lVar4;
                        }
                        VarHandle.storeStoreFence();
                        return qVar3;
                    case 28:
                        return new g(b0.f1934w, jsonNode, nVar, lVar, qVar, 2);
                    default:
                        u uVar = new u(b0.f1937z, jsonNode, nVar, lVar, qVar);
                        w7.l lVarD2 = null;
                        w7.l lVarD3 = null;
                        for (String str3 : u.f2024j) {
                            JsonNode jsonNode6 = lVar.f15331g.get(str3);
                            w7.n nVarB2 = lVar.i.b(str3);
                            if (str3.equals("if")) {
                                lVarD = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("then") && jsonNode6 != null) {
                                lVarD2 = qVar.d(nVarB2, jsonNode6, lVar);
                            } else if (str3.equals("else") && jsonNode6 != null) {
                                lVarD3 = qVar.d(nVarB2, jsonNode6, lVar);
                            }
                        }
                        uVar.f2025g = lVarD;
                        uVar.f2026h = lVarD2;
                        uVar.i = lVarD3;
                        VarHandle.storeStoreFence();
                        return uVar;
                }
            }
        }, rVar3);
        f0 = b0Var51;
        f1920h0 = new b0[]{b0Var, b0Var2, b0Var3, b0Var4, b0Var5, b0Var6, b0Var7, b0Var8, b0Var9, b0Var10, b0Var11, b0Var12, b0Var13, b0Var14, b0Var15, b0Var16, a0Var, b0Var17, b0Var18, b0Var19, b0Var20, b0Var21, b0Var22, b0Var23, b0Var24, b0Var25, b0Var26, b0Var27, b0Var28, b0Var29, b0Var30, b0Var31, b0Var32, b0Var33, b0Var34, b0Var35, b0Var36, b0Var37, b0Var38, b0Var39, b0Var40, b0Var41, b0Var42, b0Var43, b0Var44, b0Var45, b0Var46, b0Var47, b0Var48, b0Var49, b0Var50, b0Var51};
        f1918g0 = new HashMap();
        for (b0 b0Var52 : values()) {
            f1918g0.put(b0Var52.f1938c, b0Var52);
        }
    }

    public b0(String str, int i3, String str2, y0 y0Var, w7.r rVar) {
        this.f1938c = str2;
        this.f1939f = y0Var;
        this.f1940g = rVar;
    }

    public static ArrayList b(w7.q qVar) {
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : values()) {
            if (b0Var.f1940g.f15366c.contains(qVar)) {
                arrayList.add(b0Var);
            }
        }
        return arrayList;
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) f1920h0.clone();
    }

    public a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        y0 y0Var = this.f1939f;
        if (y0Var != null) {
            return y0Var.a(nVar, jsonNode, lVar, qVar);
        }
        g5.f.o("No suitable validator for ".concat(this.f1938c));
        return null;
    }

    @Override // b8.x
    public final String getValue() {
        return this.f1938c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f1938c;
    }
}
