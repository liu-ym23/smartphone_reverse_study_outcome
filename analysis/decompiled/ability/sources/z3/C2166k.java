package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: z3.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2166k extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final HashMap g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2166k(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.l, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.m, jsonNode, jVar, iVar, cVar);
                this.g = new HashMap();
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    JsonNode jsonNode2 = jsonNode.get(next);
                    if (jsonNode2.isObject() || jsonNode2.isBoolean()) {
                        this.g.put(next, cVar.c(jVar.b(next), jsonNode2, iVar));
                    }
                }
                break;
            default:
                this.g = new HashMap();
                Iterator<String> itFieldNames2 = jsonNode.fieldNames();
                while (itFieldNames2.hasNext()) {
                    String next2 = itFieldNames2.next();
                    JsonNode jsonNode3 = jsonNode.get(next2);
                    if (jsonNode3.isArray()) {
                        List list = (List) this.g.computeIfAbsent(next2, new reactor.util.retry.a(7));
                        for (int i6 = 0; i6 < jsonNode3.size(); i6++) {
                            list.add(jsonNode3.get(i6).asText());
                        }
                    }
                }
                break;
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) throws Throwable {
        switch (this.f) {
            case 0:
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    List<String> list = (List) this.g.get(next);
                    if (list != null && !list.isEmpty()) {
                        for (String str : list) {
                            if (jsonNode.get(str) == null) {
                                u3.g gVarJ = j();
                                gVarJ.getClass();
                                u3.g gVar = (u3.g) gVarJ.b(next);
                                gVar.d = aVar;
                                gVar.b = fVar.f;
                                gVar.k = (Locale) fVar.f6698a.f177a;
                                gVar.e = new Object[]{str, next};
                                fVar.a(gVar.a());
                            }
                        }
                    }
                }
                break;
            default:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                break;
        }
    }

    @Override // u3.m
    public void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) throws Throwable {
        switch (this.f) {
            case 1:
                if (!z10) {
                    Iterator it = this.g.values().iterator();
                    while (it.hasNext()) {
                        ((u3.i) it.next()).b(fVar, jsonNode, jsonNode2, aVar, false);
                    }
                    break;
                } else {
                    m(fVar, jsonNode, jsonNode2, aVar, true);
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
            case 1:
                AbstractC2161f.l(this.g.values());
                break;
        }
    }

    public void m(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) throws Throwable {
        u3.f fVar2;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        A3.a aVar2;
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            u3.i iVar = (u3.i) this.g.get(next);
            if (iVar != null) {
                fVar.c(next);
                if (z10) {
                    fVar2 = fVar;
                    jsonNode3 = jsonNode;
                    jsonNode4 = jsonNode2;
                    aVar2 = aVar;
                    try {
                        iVar.b(fVar2, jsonNode3, jsonNode4, aVar2, true);
                        fVar2.d();
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        fVar2.d();
                        throw th2;
                    }
                } else {
                    try {
                        iVar.a(fVar, jsonNode, jsonNode2, aVar);
                        fVar2 = fVar;
                        jsonNode3 = jsonNode;
                        jsonNode4 = jsonNode2;
                        aVar2 = aVar;
                        fVar2.d();
                    } catch (Throwable th3) {
                        th = th3;
                        fVar2 = fVar;
                        Throwable th22 = th;
                        fVar2.d();
                        throw th22;
                    }
                }
            } else {
                fVar2 = fVar;
                jsonNode3 = jsonNode;
                jsonNode4 = jsonNode2;
                aVar2 = aVar;
            }
            fVar = fVar2;
            jsonNode = jsonNode3;
            jsonNode2 = jsonNode4;
            aVar = aVar2;
        }
    }
}
