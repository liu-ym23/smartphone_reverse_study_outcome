package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import v3.C2057a;

/* renamed from: z3.A, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2155A extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final u3.i g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2155A(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.f3026O, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f3033V, jsonNode, jVar, iVar, cVar);
                this.g = cVar.c(jVar, jsonNode, iVar);
                return;
            case 2:
                super(KeywordType.f3040d0, jsonNode, jVar, iVar, cVar);
                if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                    throw new IllegalArgumentException("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
                }
                this.g = cVar.c(jVar, jsonNode, iVar);
                return;
            default:
                this.g = cVar.c(jVar, jsonNode, iVar);
                return;
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) throws Throwable {
        switch (this.f) {
            case 0:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            case 1:
                List list = fVar.d;
                ArrayList arrayList = new ArrayList();
                fVar.d = arrayList;
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    TextNode textNodeValueOf = TextNode.valueOf(next);
                    aVar.getClass();
                    this.g.a(fVar, textNodeValueOf, jsonNode, new A3.a(aVar, next));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        u3.e eVar = (u3.e) it.next();
                        u3.g gVar = (u3.g) j().b(next);
                        gVar.getClass();
                        gVar.d = aVar;
                        gVar.b = fVar.f;
                        gVar.k = (Locale) fVar.f6698a.f177a;
                        gVar.e = new Object[]{next, eVar.a()};
                        list.add(gVar.a());
                    }
                    arrayList.clear();
                }
                fVar.d = list;
                return;
            default:
                JsonNode jsonNode3 = this.b;
                if (jsonNode.isObject()) {
                    S6.c cVar = new S6.c(22);
                    H h = new H(fVar, 1);
                    List list2 = (List) fVar.e().b.getOrDefault(aVar, Collections.EMPTY_LIST);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    Iterator it2 = ((List) list2.stream().filter(new S6.c(23)).filter(h).filter(cVar).collect(Collectors.toList())).iterator();
                    while (it2.hasNext()) {
                        Object obj = ((C2057a) it2.next()).e;
                        if (obj instanceof Set) {
                            linkedHashSet2.addAll((Set) obj);
                        }
                    }
                    Iterator it3 = ((List) list2.stream().filter(new S6.c(24)).filter(h).filter(cVar).collect(Collectors.toList())).iterator();
                    while (it3.hasNext()) {
                        Object obj2 = ((C2057a) it3.next()).e;
                        if (obj2 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj2);
                        }
                    }
                    Iterator it4 = ((List) list2.stream().filter(new S6.c(25)).filter(h).filter(cVar).collect(Collectors.toList())).iterator();
                    while (it4.hasNext()) {
                        Object obj3 = ((C2057a) it4.next()).e;
                        if (obj3 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj3);
                        }
                    }
                    Iterator it5 = ((List) list2.stream().filter(new S6.c(26)).filter(h).filter(cVar).collect(Collectors.toList())).iterator();
                    while (it5.hasNext()) {
                        Object obj4 = ((C2057a) it5.next()).e;
                        if (obj4 instanceof Set) {
                            linkedHashSet2.addAll((Set) obj4);
                        }
                    }
                    boolean zG = fVar.g();
                    try {
                        fVar.h(false);
                        Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                        while (itFieldNames2.hasNext()) {
                            String next2 = itFieldNames2.next();
                            if (!linkedHashSet2.contains(next2)) {
                                linkedHashSet.add(next2);
                                if (!jsonNode3.isBoolean() || jsonNode3.booleanValue()) {
                                    u3.i iVar = this.g;
                                    JsonNode jsonNode4 = jsonNode.get(next2);
                                    aVar.getClass();
                                    iVar.a(fVar, jsonNode4, jsonNode, new A3.a(aVar, next2));
                                } else {
                                    u3.g gVarJ = j();
                                    gVarJ.getClass();
                                    gVarJ.d = aVar;
                                    u3.g gVar2 = (u3.g) gVarJ.b(next2);
                                    gVar2.b = fVar.f;
                                    gVar2.e = new Object[]{next2};
                                    gVar2.k = (Locale) fVar.f6698a.f177a;
                                    fVar.a(gVar2.a());
                                }
                            }
                        }
                        fVar.h(zG);
                        fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, linkedHashSet));
                        return;
                    } catch (Throwable th) {
                        fVar.h(zG);
                        throw th;
                    }
                }
                return;
        }
    }

    @Override // u3.m
    public void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) throws Throwable {
        switch (this.f) {
            case 0:
                if (z10 && jsonNode != null) {
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    break;
                } else {
                    this.g.b(fVar, jsonNode, jsonNode2, aVar, false);
                    break;
                }
            default:
                super.b(fVar, jsonNode, jsonNode2, aVar, z10);
                break;
        }
    }

    @Override // z3.AbstractC2156a
    public void i() {
        switch (this.f) {
            case 0:
                u3.i iVar = this.g;
                if (iVar != null) {
                    iVar.h();
                    break;
                }
                break;
            case 1:
                this.g.h();
                break;
        }
    }

    public void m(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) throws Throwable {
        u3.f fVar2;
        Throwable th;
        A3.a aVar2;
        boolean zG = fVar.g();
        List list = fVar.d;
        ArrayList arrayList = new ArrayList();
        fVar.d = arrayList;
        try {
            fVar.h(false);
            if (z10) {
                fVar2 = fVar;
                aVar2 = aVar;
                try {
                    this.g.b(fVar2, jsonNode, jsonNode2, aVar2, true);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    fVar2.h(zG);
                    fVar2.d = list;
                    throw th;
                }
            } else {
                try {
                    this.g.a(fVar, jsonNode, jsonNode2, aVar);
                    fVar2 = fVar;
                    aVar2 = aVar;
                } catch (Throwable th3) {
                    th = th3;
                    fVar2 = fVar;
                    fVar2.h(zG);
                    fVar2.d = list;
                    throw th;
                }
            }
            fVar2.h(zG);
            fVar2.d = list;
            if (arrayList.isEmpty()) {
                u3.g gVarJ = j();
                gVarJ.getClass();
                gVarJ.d = aVar2;
                gVarJ.b = fVar2.f;
                gVarJ.k = (Locale) fVar2.f6698a.f177a;
                gVarJ.e = new Object[]{this.b.toString()};
                fVar2.a(gVarJ.a());
            }
        } catch (Throwable th4) {
            th = th4;
            fVar2 = fVar;
        }
    }
}
