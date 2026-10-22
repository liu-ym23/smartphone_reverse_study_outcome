package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.InvalidSchemaRefException;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.utils.JsonType;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.stream.Stream;
import v3.C2057a;
import w3.C2097b;

/* renamed from: z3.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2163h extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C2163h(u3.j r7, com.fasterxml.jackson.databind.JsonNode r8, u3.i r9, G6.c r10, int r11) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2163h.<init>(u3.j, com.fasterxml.jackson.databind.JsonNode, u3.i, G6.c, int):void");
    }

    public static Q.a m(final u3.i iVar, final G6.c cVar, final String str) {
        if (!str.startsWith("#")) {
            final int iIndexOf = str.indexOf("#");
            final String strO = o(iVar, iIndexOf > 0 ? str.substring(0, iIndexOf) : str);
            final u3.j jVarC = u3.j.c(strO);
            Supplier supplier = new Supplier() { // from class: z3.E
                @Override // java.util.function.Supplier
                public final Object get() {
                    G6.c cVar2 = cVar;
                    ConcurrentMap concurrentMap = (ConcurrentMap) cVar2.f;
                    ConcurrentMap concurrentMap2 = (ConcurrentMap) cVar2.g;
                    u3.i iVarE = (u3.i) concurrentMap.get(strO);
                    u3.j jVar = jVarC;
                    if (iVarE == null && (iVarE = ((u3.k) cVar2.d).e(jVar)) != null) {
                        G6.c cVar3 = iVarE.f6703j;
                        ConcurrentMap concurrentMap3 = (ConcurrentMap) cVar3.f;
                        ConcurrentMap concurrentMap4 = (ConcurrentMap) cVar3.e;
                        if (!concurrentMap3.isEmpty()) {
                            concurrentMap.putAll((ConcurrentMap) cVar3.f);
                        }
                        ConcurrentMap concurrentMap5 = (ConcurrentMap) cVar3.g;
                        if (!concurrentMap4.isEmpty()) {
                            ((ConcurrentMap) cVar2.e).putAll(concurrentMap4);
                        }
                        if (!concurrentMap5.isEmpty()) {
                            concurrentMap2.putAll(concurrentMap5);
                        }
                    }
                    int i = iIndexOf;
                    if (i < 0) {
                        if (iVarE == null) {
                            return null;
                        }
                        return iVarE;
                    }
                    String strSubstring = str.substring(i);
                    String str2 = jVar.f6704a + strSubstring;
                    u3.i iVarN = (u3.i) concurrentMap.get(str2);
                    if (iVarN == null) {
                        iVarN = (u3.i) concurrentMap2.get(str2);
                    }
                    if (iVarN == null) {
                        iVarN = C2163h.n(iVarE, cVar2, strSubstring, str);
                    }
                    if (iVarN == null) {
                        return null;
                    }
                    return iVarN;
                }
            };
            ((u3.k) cVar.d).g.getClass();
            E3.f fVar = new E3.f();
            fVar.b = null;
            fVar.f466a = supplier;
            return new Q.a(fVar, 11);
        }
        if (str.startsWith("#") && !"#".equals(str) && !str.startsWith("#/")) {
            final String strO2 = o(iVar, str);
            Supplier supplier2 = new Supplier() { // from class: z3.F
                @Override // java.util.function.Supplier
                public final Object get() {
                    G6.c cVar2 = cVar;
                    ConcurrentMap concurrentMap = (ConcurrentMap) cVar2.f;
                    String str2 = strO2;
                    u3.i iVarN = (u3.i) concurrentMap.get(str2);
                    if (iVarN == null) {
                        iVarN = (u3.i) ((ConcurrentMap) cVar2.g).get(str2);
                    }
                    if (iVarN == null) {
                        iVarN = C2163h.n(iVar, cVar2, str, str);
                    }
                    if (iVarN == null) {
                        return null;
                    }
                    return iVarN;
                }
            };
            ((u3.k) cVar.d).g.getClass();
            E3.f fVar2 = new E3.f();
            fVar2.b = null;
            fVar2.f466a = supplier2;
            return new Q.a(fVar2, 11);
        }
        if (str.equals("#")) {
            com.fasterxml.jackson.core.util.a aVar = new com.fasterxml.jackson.core.util.a(iVar, 5);
            ((u3.k) cVar.d).g.getClass();
            E3.f fVar3 = new E3.f();
            fVar3.b = null;
            fVar3.f466a = aVar;
            return new Q.a(fVar3, 11);
        }
        io.modelcontextprotocol.server.m mVar = new io.modelcontextprotocol.server.m(iVar, cVar, str, str);
        ((u3.k) cVar.d).g.getClass();
        E3.f fVar4 = new E3.f();
        fVar4.b = null;
        fVar4.f466a = mVar;
        return new Q.a(fVar4, 11);
    }

    public static u3.i n(u3.i iVar, G6.c cVar, String str, String str2) {
        u3.i iVarF;
        String strO = o(iVar, str2);
        u3.i iVar2 = (u3.i) ((ConcurrentMap) cVar.e).get(strO);
        if (iVar2 != null) {
            return iVar2;
        }
        A3.a aVarA = u3.h.a(str);
        synchronized (((u3.k) cVar.d)) {
            try {
                iVarF = (u3.i) ((ConcurrentMap) cVar.e).get(strO);
                if (iVarF == null && (iVarF = iVar.f(aVarA)) != null) {
                    ((ConcurrentMap) cVar.e).put(strO, iVarF);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVarF;
    }

    public static String o(u3.i iVar, String str) {
        u3.i iVar2;
        if (iVar.f6702a != null && (iVar2 = iVar.h) != null && ((C2097b) iVar.f6703j.c).e.f3013a <= 7) {
            iVar = iVar2;
        }
        return u3.j.d(iVar.i, str);
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        BigDecimal bigDecimalDecimalValue;
        boolean z10;
        switch (this.f) {
            case 0:
                String str = (String) this.g;
                if (com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g) != JsonType.STRING) {
                    return;
                }
                c(fVar);
                String strAsText = jsonNode.asText();
                if ("base64".equals(str)) {
                    try {
                        Base64.getDecoder().decode(strAsText);
                        return;
                    } catch (IllegalArgumentException unused) {
                        u3.g gVarJ = j();
                        gVarJ.getClass();
                        gVarJ.d = aVar;
                        gVarJ.b = fVar.f;
                        gVarJ.k = (Locale) fVar.f6698a.f177a;
                        gVarJ.e = new Object[]{str};
                        fVar.a(gVarJ.a());
                        return;
                    }
                }
                return;
            case 1:
                LinkedHashSet linkedHashSet = (LinkedHashSet) this.g;
                if (linkedHashSet != null) {
                    Stream map = linkedHashSet.stream().map(new io.modelcontextprotocol.client.r(this, jsonNode, aVar, fVar, 4));
                    Objects.requireNonNull(fVar);
                    map.forEach(new com.stepos.mcp.sdk.java.a(fVar, 8));
                    return;
                }
                return;
            case 2:
                BigDecimal bigDecimal = (BigDecimal) this.g;
                if (bigDecimal != null) {
                    if (jsonNode.isNumber()) {
                        bigDecimalDecimalValue = jsonNode.isBigDecimal() ? jsonNode.decimalValue() : BigDecimal.valueOf(jsonNode.doubleValue());
                    } else {
                        ((u3.k) this.d.d).g.getClass();
                        bigDecimalDecimalValue = null;
                    }
                    if (bigDecimalDecimalValue == null || bigDecimalDecimalValue.divideAndRemainder(bigDecimal)[1].abs().compareTo(BigDecimal.ZERO) <= 0) {
                        return;
                    }
                    u3.g gVarJ2 = j();
                    gVarJ2.getClass();
                    gVarJ2.d = aVar;
                    gVarJ2.b = fVar.f;
                    gVarJ2.k = (Locale) fVar.f6698a.f177a;
                    gVarJ2.e = new Object[]{bigDecimal};
                    fVar.a(gVarJ2.a());
                    return;
                }
                return;
            case 3:
                if (jsonNode.isObject()) {
                    Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                    if (AbstractC2156a.h(fVar)) {
                        z10 = true;
                    } else {
                        AbstractC2156a.d(fVar, e());
                        z10 = false;
                    }
                    Set linkedHashSet2 = null;
                    while (itFields.hasNext()) {
                        Map.Entry<String, JsonNode> next = itFields.next();
                        String key = next.getKey();
                        JsonNode value = next.getValue();
                        for (Map.Entry entry : ((IdentityHashMap) this.g).entrySet()) {
                            if (((B3.c) entry.getKey()).matches(key)) {
                                aVar.getClass();
                                A3.a aVar2 = new A3.a(aVar, key);
                                int size = fVar.d.size();
                                u3.i iVar = (u3.i) entry.getValue();
                                fVar.c(iVar.i.b.b(-1).toString());
                                try {
                                    iVar.a(fVar, value, jsonNode2, aVar2);
                                    fVar.d();
                                    if (size == fVar.d.size() && z10) {
                                        if (linkedHashSet2 == null) {
                                            linkedHashSet2 = new LinkedHashSet();
                                        }
                                        linkedHashSet2.add(key);
                                    }
                                } catch (Throwable th) {
                                    fVar.d();
                                    throw th;
                                }
                            }
                        }
                    }
                    if (z10) {
                        v3.b bVarE = fVar.e();
                        A3.a aVar3 = fVar.f;
                        if (linkedHashSet2 == null) {
                            linkedHashSet2 = Collections.EMPTY_SET;
                        }
                        bVarE.a(new C2057a(this.f6946a, aVar, this.c, aVar3, linkedHashSet2));
                        return;
                    }
                    return;
                }
                return;
            default:
                u3.i iVarD = ((Q.a) this.g).d();
                if (iVarD != null) {
                    iVarD.a(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                u3.g gVarJ3 = j();
                gVarJ3.f6696a = KeywordType.f3036Y.f3054a;
                gVarJ3.i = "internal.unresolvedRef";
                gVarJ3.g = "Reference {0} cannot be resolved";
                gVarJ3.d = aVar;
                gVarJ3.b = fVar.f;
                gVarJ3.e = new Object[]{this.b.asText()};
                throw new InvalidSchemaRefException(gVarJ3.a());
        }
    }

    @Override // u3.m
    public void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        switch (this.f) {
            case 4:
                u3.i iVarD = ((Q.a) this.g).d();
                if (iVarD != null) {
                    if (jsonNode == null) {
                        u3.j jVar = iVarD.i;
                        Iterator itDescendingIterator = fVar.g.descendingIterator();
                        while (itDescendingIterator.hasNext()) {
                            if (((u3.i) itDescendingIterator.next()).i.equals(jVar)) {
                                return;
                            }
                        }
                    }
                    iVarD.b(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                }
                u3.g gVarJ = j();
                gVarJ.f6696a = KeywordType.f3036Y.f3054a;
                gVarJ.i = "internal.unresolvedRef";
                gVarJ.g = "Reference {0} cannot be resolved";
                gVarJ.d = aVar;
                gVarJ.b = fVar.f;
                gVarJ.e = new Object[]{this.b.asText()};
                throw new InvalidSchemaRefException(gVarJ.a());
            default:
                super.b(fVar, jsonNode, jsonNode2, aVar, z10);
                return;
        }
    }

    @Override // z3.AbstractC2156a
    public void i() {
        switch (this.f) {
            case 3:
                AbstractC2161f.l(((IdentityHashMap) this.g).values());
                return;
            case 4:
                try {
                    ((Q.a) this.g).d().h();
                    return;
                } catch (SchemaException e) {
                    throw e;
                } catch (RuntimeException e6) {
                    throw new SchemaException(e6);
                }
            default:
                return;
        }
    }
}
