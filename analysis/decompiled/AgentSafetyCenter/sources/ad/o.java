package ad;

import b8.y0;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.lang.invoke.VarHandle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f549a;

    public /* synthetic */ o(int i) {
        this.f549a = i;
    }

    public static /* synthetic */ void b(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    public static /* synthetic */ void c(Object obj, Object obj2) {
        throw new IllegalStateException("Cannot find wrapper for " + obj + ((Object) ", seems like it is not bound by this adapter: ") + obj2);
    }

    public static /* synthetic */ void d(Object obj, Object obj2, Object obj3, Throwable th) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(obj2);
        sb2.append(obj3);
        throw new IllegalStateException(sb2.toString(), th);
    }

    public static /* synthetic */ void e(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void f(String str, Object obj, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void g(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void h(Throwable th) {
        throw new RuntimeException(th);
    }

    public static /* synthetic */ void i(Throwable th, Object obj, String str) {
        throw new RuntimeException(str + obj, th);
    }

    public static /* synthetic */ void j(int i, String str) {
        throw new IllegalArgumentException(str + i);
    }

    public static /* synthetic */ void k(Object obj, String str) {
        throw new RuntimeException(str + obj);
    }

    public static /* synthetic */ void l(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void n(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b8.y0
    public b8.a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        b8.i iVar;
        BigDecimal bigDecimalDecimalValue = null;
        int i = 1;
        int i3 = 0;
        switch (this.f549a) {
            case 13:
                JsonNode jsonNode2 = lVar.f15331g;
                b8.b bVar = new b8.b(b8.b0.f1919h, jsonNode, nVar, lVar, qVar, 0);
                if (jsonNode.isBoolean()) {
                    bVar.i = jsonNode.booleanValue();
                    bVar.f1911h = null;
                } else if (jsonNode.isObject()) {
                    bVar.i = true;
                    bVar.f1911h = qVar.d(nVar, jsonNode, lVar);
                } else {
                    bVar.i = false;
                    bVar.f1911h = null;
                }
                JsonNode jsonNode3 = jsonNode2.get("properties");
                if (jsonNode3 != null) {
                    bVar.f1912j = new HashSet();
                    Iterator<String> itFieldNames = jsonNode3.fieldNames();
                    while (itFieldNames.hasNext()) {
                        ((Set) bVar.f1912j).add(itFieldNames.next());
                    }
                } else {
                    bVar.f1912j = Collections.EMPTY_SET;
                }
                JsonNode jsonNode4 = jsonNode2.get("patternProperties");
                if (jsonNode4 != null) {
                    bVar.f1913k = new ArrayList(jsonNode4.size());
                    Iterator<String> itFieldNames2 = jsonNode4.fieldNames();
                    while (itFieldNames2.hasNext()) {
                        ((List) bVar.f1913k).add(d8.c.a(itFieldNames2.next(), qVar));
                    }
                } else {
                    bVar.f1913k = Collections.EMPTY_LIST;
                }
                VarHandle.storeStoreFence();
                return bVar;
            case 14:
                return new b8.i(nVar, jsonNode, lVar, qVar);
            case 15:
                b8.c cVar = new b8.c(b8.b0.i, jsonNode, nVar, lVar, qVar, 0);
                if (!jsonNode.isArray()) {
                    int iX = td.h.x(jsonNode, ((w7.o) cVar.f1954d.f1601d).f15349g);
                    w7.j jVarJ = cVar.j();
                    jVarJ.f15293d = nVar.f15340b;
                    jVarJ.i = "type";
                    jVarJ.f15294e = new Object[]{androidx.activity.b.b(iX), "array"};
                    throw new w7.m(jVarJ.a());
                }
                int size = jsonNode.size();
                cVar.f1942h = new ArrayList(size);
                while (i3 < size) {
                    cVar.f1942h.add(qVar.d(nVar.a(i3), jsonNode.get(i3), lVar));
                    i3++;
                }
                VarHandle.storeStoreFence();
                return cVar;
            case 16:
                b8.c0 c0Var = new b8.c0(b8.b0.D, jsonNode, nVar, lVar, qVar, 0);
                if (jsonNode.canConvertToExactIntegral()) {
                    c0Var.f1944h = jsonNode.intValue();
                } else {
                    c0Var.f1944h = 0;
                }
                VarHandle.storeStoreFence();
                return c0Var;
            case 17:
                b8.c0 c0Var2 = new b8.c0(b8.b0.E, jsonNode, nVar, lVar, qVar, 1);
                if (jsonNode == null || !jsonNode.canConvertToExactIntegral()) {
                    c0Var2.f1944h = Reader.READ_DONE;
                } else {
                    c0Var2.f1944h = jsonNode.intValue();
                }
                VarHandle.storeStoreFence();
                return c0Var2;
            case 18:
                b8.c0 c0Var3 = new b8.c0(b8.b0.F, jsonNode, nVar, lVar, qVar, 2);
                if (jsonNode.canConvertToExactIntegral()) {
                    c0Var3.f1944h = jsonNode.intValue();
                } else {
                    c0Var3.f1944h = Reader.READ_DONE;
                }
                VarHandle.storeStoreFence();
                return c0Var3;
            case 19:
                b8.e0 e0Var = new b8.e0(b8.b0.G, jsonNode, nVar, lVar, qVar, 0);
                if (!jsonNode.isNumber()) {
                    throw new w7.m("maximum value is not a number");
                }
                JsonNode jsonNode5 = e0Var.f1955e.f15331g.get("exclusiveMaximum");
                if (jsonNode5 == null || !jsonNode5.isBoolean()) {
                    e0Var.f1953h = false;
                } else {
                    e0Var.f1953h = jsonNode5.booleanValue();
                }
                String strAsText = jsonNode.asText();
                if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(e0Var.k())) {
                    long jAsLong = jsonNode.asLong();
                    b8.d0 d0Var = new b8.d0();
                    d0Var.f1949h = e0Var;
                    d0Var.f1947f = jsonNode;
                    d0Var.f1948g = strAsText;
                    d0Var.f1946c = jAsLong;
                    VarHandle.storeStoreFence();
                    e0Var.i = d0Var;
                } else {
                    p5.m mVar = new p5.m(5);
                    mVar.f9743h = e0Var;
                    mVar.f9741f = jsonNode;
                    mVar.f9742g = strAsText;
                    VarHandle.storeStoreFence();
                    e0Var.i = mVar;
                }
                VarHandle.storeStoreFence();
                return e0Var;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                b8.c0 c0Var4 = new b8.c0(b8.b0.I, jsonNode, nVar, lVar, qVar, 3);
                c0Var4.f1944h = 0;
                if (jsonNode.canConvertToExactIntegral()) {
                    c0Var4.f1944h = jsonNode.intValue();
                }
                return c0Var4;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                b8.c0 c0Var5 = new b8.c0(b8.b0.J, jsonNode, nVar, lVar, qVar, 4);
                c0Var5.f1944h = Integer.MIN_VALUE;
                if (jsonNode != null && jsonNode.canConvertToExactIntegral()) {
                    c0Var5.f1944h = jsonNode.intValue();
                }
                return c0Var5;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                b8.c0 c0Var6 = new b8.c0(b8.b0.K, jsonNode, nVar, lVar, qVar, 5);
                if (jsonNode.canConvertToExactIntegral()) {
                    c0Var6.f1944h = jsonNode.intValue();
                } else {
                    c0Var6.f1944h = 0;
                }
                VarHandle.storeStoreFence();
                return c0Var6;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                b8.e0 e0Var2 = new b8.e0(b8.b0.L, jsonNode, nVar, lVar, qVar, 1);
                if (!jsonNode.isNumber()) {
                    throw new w7.m("minimum value is not a number");
                }
                JsonNode jsonNode6 = e0Var2.f1955e.f15331g.get("exclusiveMinimum");
                if (jsonNode6 == null || !jsonNode6.isBoolean()) {
                    e0Var2.f1953h = false;
                } else {
                    e0Var2.f1953h = jsonNode6.booleanValue();
                }
                String strAsText2 = jsonNode.asText();
                if ((jsonNode.isLong() || jsonNode.isInt()) && "integer".equals(e0Var2.k())) {
                    long jAsLong2 = jsonNode.asLong();
                    b8.p pVar = new b8.p(i);
                    pVar.f2005h = e0Var2;
                    pVar.f2003f = strAsText2;
                    pVar.f2004g = jAsLong2;
                    VarHandle.storeStoreFence();
                    e0Var2.i = pVar;
                } else {
                    p5.m mVar2 = new p5.m(6);
                    mVar2.f9743h = e0Var2;
                    mVar2.f9741f = jsonNode;
                    mVar2.f9742g = strAsText2;
                    VarHandle.storeStoreFence();
                    e0Var2.i = mVar2;
                }
                VarHandle.storeStoreFence();
                return e0Var2;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                b8.n nVar2 = new b8.n(b8.b0.f1929r, jsonNode, nVar, lVar, qVar);
                ObjectNode objectNode = jsonNode.isObject() ? (ObjectNode) jsonNode : null;
                if (objectNode != null) {
                    JsonNode jsonNode7 = objectNode.get("propertyName");
                    nVar2.f1988g = jsonNode7 != null ? jsonNode7.asText() : "";
                    JsonNode jsonNode8 = objectNode.get("mapping");
                    ObjectNode objectNode2 = (jsonNode8 == null || !jsonNode8.isObject()) ? null : (ObjectNode) jsonNode8;
                    if (objectNode2 != null) {
                        nVar2.f1989h = new HashMap();
                        Iterator<Map.Entry<String, JsonNode>> itFields = objectNode2.fields();
                        while (itFields.hasNext()) {
                            Map.Entry<String, JsonNode> next = itFields.next();
                            nVar2.f1989h.put(next.getKey(), next.getValue().asText());
                        }
                    } else {
                        nVar2.f1989h = Collections.EMPTY_MAP;
                    }
                    JsonNode jsonNode9 = objectNode.get("defaultMapping");
                    if (jsonNode9 != null) {
                        nVar2.i = jsonNode9.asText();
                    } else {
                        nVar2.i = null;
                    }
                } else {
                    nVar2.f1988g = "";
                    nVar2.f1989h = Collections.EMPTY_MAP;
                    nVar2.i = null;
                }
                VarHandle.storeStoreFence();
                return nVar2;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                b8.i iVar2 = new b8.i(b8.b0.M, jsonNode, nVar, lVar, qVar, 2);
                if (jsonNode.isNumber()) {
                    double dDoubleValue = jsonNode.doubleValue();
                    if (dDoubleValue != 0.0d) {
                        bigDecimalDecimalValue = jsonNode.isBigDecimal() ? jsonNode.decimalValue() : BigDecimal.valueOf(dDoubleValue);
                    }
                }
                iVar2.f1967h = bigDecimalDecimalValue;
                iVar = iVar2;
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                b8.c cVar2 = new b8.c(b8.b0.f1921j, jsonNode, nVar, lVar, qVar, 1);
                if (!jsonNode.isArray()) {
                    int iX2 = td.h.x(jsonNode, ((w7.o) cVar2.f1954d.f1601d).f15349g);
                    w7.j jVarJ2 = cVar2.j();
                    jVarJ2.f15293d = nVar.f15340b;
                    jVarJ2.i = "type";
                    jVarJ2.f15294e = new Object[]{androidx.activity.b.b(iX2), "array"};
                    throw new w7.m(jVarJ2.a());
                }
                int size2 = jsonNode.size();
                cVar2.f1942h = new ArrayList(size2);
                while (i3 < size2) {
                    cVar2.f1942h.add(qVar.d(nVar.a(i3), jsonNode.get(i3), lVar));
                    i3++;
                }
                VarHandle.storeStoreFence();
                return cVar2;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                b8.i0 i0Var = new b8.i0(b8.b0.N, jsonNode, nVar, lVar, qVar, 0);
                if (jsonNode.isArray()) {
                    int size3 = jsonNode.size();
                    i0Var.f1969h = new ArrayList(size3);
                    while (i3 < size3) {
                        i0Var.f1969h.add(jsonNode.get(i3).asText());
                        i3++;
                    }
                } else {
                    i0Var.f1969h = Collections.EMPTY_LIST;
                }
                VarHandle.storeStoreFence();
                return i0Var;
            case 28:
                b8.j0 j0Var = new b8.j0(b8.b0.O, jsonNode, nVar, lVar, qVar, 0);
                j0Var.f1973h = qVar.d(nVar, jsonNode, lVar);
                iVar = j0Var;
                break;
            default:
                b8.c cVar3 = new b8.c(b8.b0.P, jsonNode, nVar, lVar, qVar, 2);
                if (!jsonNode.isArray()) {
                    int iX3 = td.h.x(jsonNode, ((w7.o) cVar3.f1954d.f1601d).f15349g);
                    w7.j jVarJ3 = cVar3.j();
                    jVarJ3.f15293d = nVar.f15340b;
                    jVarJ3.i = "type";
                    jVarJ3.f15294e = new Object[]{androidx.activity.b.b(iX3), "array"};
                    throw new w7.m(jVarJ3.a());
                }
                int size4 = jsonNode.size();
                cVar3.f1942h = new ArrayList(size4);
                while (i3 < size4) {
                    cVar3.f1942h.add(qVar.d(nVar.a(i3), jsonNode.get(i3), lVar));
                    i3++;
                }
                VarHandle.storeStoreFence();
                return cVar3;
        }
        VarHandle.storeStoreFence();
        return iVar;
    }
}
