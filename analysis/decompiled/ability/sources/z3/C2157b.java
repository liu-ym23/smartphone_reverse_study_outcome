package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SpecificationVersionRange;
import com.networknt.schema.keyword.KeywordType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import v3.C2057a;
import w3.C2097b;

/* renamed from: z3.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2157b extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final u3.i g;
    public final boolean h;
    public final Object i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f6947j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2157b(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        Integer numValueOf;
        super(KeywordType.d, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.h, jsonNode, jVar, iVar, cVar);
                this.h = SpecificationVersionRange.g.f3015a.contains(((C2097b) this.d.c).e);
                if (jsonNode.isObject() || jsonNode.isBoolean()) {
                    this.g = cVar.c(jVar, jsonNode, iVar);
                    JsonNode jsonNode2 = iVar.g;
                    Optional optionalFilter = Optional.ofNullable(jsonNode2.get(KeywordType.y.f3054a)).filter(new S6.c(17));
                    Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
                    Optional optionalFilter2 = Optional.ofNullable(jsonNode2.get(KeywordType.f3020D.f3054a)).filter(new S6.c(17));
                    numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
                    num = numValueOf2;
                } else {
                    this.g = null;
                    numValueOf = null;
                }
                this.f6947j = num;
                this.i = numValueOf;
                break;
            default:
                JsonNode jsonNode3 = iVar.g;
                if (jsonNode.isBoolean()) {
                    this.h = jsonNode.booleanValue();
                    this.g = null;
                } else if (jsonNode.isObject()) {
                    this.h = true;
                    this.g = cVar.c(jVar, jsonNode, iVar);
                } else {
                    this.h = false;
                    this.g = null;
                }
                JsonNode jsonNode4 = jsonNode3.get("properties");
                if (jsonNode4 != null) {
                    this.i = new HashSet();
                    Iterator<String> itFieldNames = jsonNode4.fieldNames();
                    while (itFieldNames.hasNext()) {
                        ((Set) this.i).add(itFieldNames.next());
                    }
                } else {
                    this.i = Collections.EMPTY_SET;
                }
                JsonNode jsonNode5 = jsonNode3.get("patternProperties");
                if (jsonNode5 == null) {
                    this.f6947j = Collections.EMPTY_LIST;
                    break;
                } else {
                    this.f6947j = new ArrayList(jsonNode5.size());
                    Iterator<String> itFieldNames2 = jsonNode5.fieldNames();
                    while (itFieldNames2.hasNext()) {
                        ((List) this.f6947j).add(B3.c.a(itFieldNames2.next(), cVar));
                    }
                    break;
                }
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        C2157b c2157b;
        u3.f fVar2;
        int i;
        switch (this.f) {
            case 0:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            default:
                Integer num = (Integer) this.i;
                Integer num2 = (Integer) this.f6947j;
                ArrayList arrayList = new ArrayList();
                int i6 = 0;
                u3.i iVar = this.g;
                if (iVar == null || !jsonNode.isArray()) {
                    c2157b = this;
                    fVar2 = fVar;
                    i = 0;
                } else {
                    boolean zG = fVar.g();
                    List list = fVar.d;
                    try {
                        fVar.h(false);
                        ArrayList arrayList2 = new ArrayList();
                        fVar.d = arrayList2;
                        Iterator<JsonNode> it = jsonNode.iterator();
                        int i10 = 0;
                        i = 0;
                        while (it.hasNext()) {
                            JsonNode next = it.next();
                            aVar.getClass();
                            iVar.a(fVar, next, jsonNode2, new A3.a(aVar, i));
                            if (arrayList2.isEmpty()) {
                                i10++;
                                arrayList.add(Integer.valueOf(i));
                            } else {
                                arrayList2.clear();
                            }
                            i++;
                        }
                        fVar.h(zG);
                        fVar.d = list;
                        int iIntValue = num != null ? num.intValue() : 1;
                        boolean z10 = this.h;
                        if (i10 < iIntValue) {
                            m(fVar, z10 ? KeywordType.f3020D : KeywordType.h, (Locale) fVar.f6698a.f177a, jsonNode, aVar, iIntValue);
                        }
                        if (num2 == null || i10 <= num2.intValue()) {
                            c2157b = this;
                        } else {
                            m(fVar, z10 ? KeywordType.y : KeywordType.h, (Locale) fVar.f6698a.f177a, jsonNode, aVar, num2.intValue());
                            c2157b = this;
                        }
                        fVar2 = fVar;
                        i6 = i10;
                    } catch (Throwable th) {
                        fVar.h(zG);
                        fVar.d = list;
                        throw th;
                    }
                }
                boolean zG2 = AbstractC2156a.g(fVar2);
                if (iVar != null) {
                    if (!zG2) {
                        fVar2.f6698a.getClass();
                    } else if (i6 == i) {
                        fVar2.e().a(new C2057a("contains", aVar, c2157b.c, fVar2.f, Boolean.TRUE));
                    } else {
                        fVar2.e().a(new C2057a("contains", aVar, c2157b.c, fVar2.f, arrayList));
                    }
                    u3.j jVar = c2157b.c;
                    if (num != null) {
                        if (zG2) {
                            fVar2.c("minContains");
                            fVar2.e().a(new C2057a("minContains", aVar, jVar.b("minContains"), fVar2.f, (Integer) c2157b.i));
                            fVar2.d();
                        } else {
                            fVar2.f6698a.getClass();
                        }
                    }
                    if (num2 != null) {
                        if (!zG2) {
                            fVar2.f6698a.getClass();
                            return;
                        }
                        fVar2.c("maxContains");
                        fVar2.e().a(new C2057a("maxContains", aVar, jVar.b("maxContains"), fVar2.f, (Integer) c2157b.f6947j));
                        fVar2.d();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // u3.m
    public void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        u3.i iVar;
        switch (this.f) {
            case 0:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    break;
                } else if (jsonNode != null && jsonNode.isObject()) {
                    Iterator<String> itFieldNames = jsonNode.fieldNames();
                    while (itFieldNames.hasNext()) {
                        String next = itFieldNames.next();
                        if (!next.startsWith("#") && !((Set) this.i).contains(next)) {
                            Iterator it = ((List) this.f6947j).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((B3.c) it.next()).matches(next)) {
                                        break;
                                    }
                                } else if (this.h && (iVar = this.g) != null) {
                                    JsonNode jsonNode3 = jsonNode.get(next);
                                    aVar.getClass();
                                    iVar.b(fVar, jsonNode3, jsonNode2, new A3.a(aVar, next), z10);
                                }
                            }
                        }
                    }
                    break;
                }
                break;
            default:
                super.b(fVar, jsonNode, jsonNode2, aVar, z10);
                break;
        }
    }

    @Override // z3.AbstractC2156a
    public final void i() {
        switch (this.f) {
            case 0:
                u3.i iVar = this.g;
                if (iVar != null) {
                    iVar.h();
                    break;
                }
                break;
            default:
                Optional.ofNullable(this.g).ifPresent(new io.modelcontextprotocol.spec.b(8));
                break;
        }
    }

    public void m(u3.f fVar, KeywordType keywordType, Locale locale, JsonNode jsonNode, A3.a aVar, int i) {
        String str = KeywordType.f3020D.equals(keywordType) ? "contains.min" : KeywordType.y.equals(keywordType) ? "contains.max" : "contains";
        u3.g gVarJ = j();
        gVarJ.getClass();
        gVarJ.d = aVar;
        gVarJ.b = fVar.f;
        gVarJ.i = str;
        gVarJ.k = locale;
        gVarJ.e = new Object[]{String.valueOf(i), this.g.g.toString()};
        gVarJ.f6696a = keywordType.f3054a;
        fVar.a(gVarJ.a());
    }

    public void n(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        boolean z11;
        u3.f fVar2;
        JsonNode jsonNode3;
        if (jsonNode.isObject()) {
            if (AbstractC2156a.h(fVar)) {
                z11 = true;
            } else {
                AbstractC2156a.d(fVar, e());
                z11 = false;
            }
            boolean z12 = this.h;
            Set linkedHashSet = null;
            if (z12 && z11) {
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(itFieldNames.next());
                }
            }
            Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                String key = next.getKey();
                if (!key.startsWith("#")) {
                    if (((Set) this.i).contains(key)) {
                        fVar2 = fVar;
                        jsonNode3 = jsonNode2;
                        fVar = fVar2;
                        jsonNode2 = jsonNode3;
                    } else {
                        Iterator it = ((List) this.f6947j).iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((B3.c) it.next()).matches(key)) {
                                    break;
                                }
                            } else if (z12) {
                                u3.i iVar = this.g;
                                if (iVar == null) {
                                    break;
                                }
                                if (z10) {
                                    JsonNode value = next.getValue();
                                    aVar.getClass();
                                    fVar2 = fVar;
                                    jsonNode3 = jsonNode2;
                                    iVar.b(fVar2, value, jsonNode3, new A3.a(aVar, key), true);
                                } else {
                                    JsonNode value2 = next.getValue();
                                    aVar.getClass();
                                    iVar.a(fVar, value2, jsonNode2, new A3.a(aVar, key));
                                }
                            } else {
                                u3.g gVarJ = j();
                                gVarJ.getClass();
                                u3.g gVar = (u3.g) gVarJ.b(key);
                                gVar.d = aVar;
                                gVar.b = fVar.f;
                                gVar.k = (Locale) fVar.f6698a.f177a;
                                gVar.e = new Object[]{key};
                                fVar.a(gVar.a());
                            }
                        }
                        fVar2 = fVar;
                        jsonNode3 = jsonNode2;
                        fVar = fVar2;
                        jsonNode2 = jsonNode3;
                    }
                }
            }
            u3.f fVar3 = fVar;
            if (z11) {
                v3.b bVarE = fVar3.e();
                A3.a aVar2 = fVar3.f;
                if (linkedHashSet == null) {
                    linkedHashSet = Collections.EMPTY_SET;
                }
                bVarE.a(new C2057a(this.f6946a, aVar, this.c, aVar2, linkedHashSet));
            }
        }
    }
}
