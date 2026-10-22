package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v3.C2057a;

/* loaded from: classes3.dex */
public final class C extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final LinkedHashMap g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.f3031T, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f3032U, jsonNode, jVar, iVar, cVar);
                Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
                this.g = new LinkedHashMap(setProperties.size());
                for (Map.Entry<String, JsonNode> entry : setProperties) {
                    String key = entry.getKey();
                    u3.j jVarB = jVar.b(key);
                    for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                        ((Map) this.g.computeIfAbsent(key, new reactor.util.retry.a(9))).put(entry2.getKey(), cVar.c(jVarB.b(entry2.getKey()), entry2.getValue(), iVar));
                    }
                }
                break;
            default:
                this.g = new LinkedHashMap();
                Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                while (itFields.hasNext()) {
                    Map.Entry<String, JsonNode> next = itFields.next();
                    String key2 = next.getKey();
                    this.g.put(key2, cVar.c(jVar.b(key2), next.getValue(), iVar));
                }
                break;
        }
    }

    public static void n(u3.f fVar, Map.Entry entry, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        u3.i iVar = (u3.i) entry.getValue();
        JsonNode jsonNode3 = jsonNode == null ? null : jsonNode.get((String) entry.getKey());
        String str = (String) entry.getKey();
        aVar.getClass();
        A3.a aVar2 = new A3.a(aVar, str);
        KeywordType.f3031T.getClass();
        if (jsonNode3 == null && jsonNode != null) {
            jsonNode3 = jsonNode.get((String) entry.getKey());
        }
        JsonNode jsonNode4 = jsonNode3;
        int size = fVar.d.size();
        iVar.b(fVar, jsonNode4, jsonNode2, aVar2, z10);
        List list = fVar.d;
        list.subList(size, list.size());
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        switch (this.f) {
            case 0:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                break;
            default:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                break;
        }
    }

    @Override // u3.m
    public final void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        switch (this.f) {
            case 0:
                ((G3.a) fVar.f().f4555a).getClass();
                if (z10) {
                    if (jsonNode == null) {
                        jsonNode = MissingNode.getInstance();
                    }
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                fVar.f().getClass();
                for (Map.Entry entry : this.g.entrySet()) {
                    fVar.c((String) entry.getKey());
                    u3.f fVar2 = fVar;
                    try {
                        n(fVar2, entry, jsonNode, jsonNode2, aVar, z10);
                        fVar2 = fVar2;
                    } finally {
                        fVar2.d();
                    }
                }
                return;
            default:
                if (z10) {
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                for (Map.Entry entry2 : this.g.entrySet()) {
                    fVar.c((String) entry2.getKey());
                    try {
                        for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                            fVar.c((String) entry3.getKey());
                            try {
                                ((u3.i) entry3.getValue()).b(fVar, jsonNode, jsonNode2, aVar, false);
                                fVar.d();
                            } catch (Throwable th) {
                                fVar.d();
                                throw th;
                            }
                        }
                        fVar.d();
                    } catch (Throwable th2) {
                        fVar.d();
                        throw th2;
                    }
                }
                return;
        }
    }

    @Override // z3.AbstractC2156a
    public final void i() {
        switch (this.f) {
            case 0:
                AbstractC2161f.l(this.g.values());
                break;
            default:
                Iterator it = this.g.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) it.next()).values().iterator();
                    while (it2.hasNext()) {
                        ((u3.i) it2.next()).h();
                    }
                }
                break;
        }
    }

    public final void m(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        boolean z11;
        Map map;
        switch (this.f) {
            case 0:
                if (AbstractC2156a.h(fVar)) {
                    z11 = true;
                } else {
                    AbstractC2156a.d(fVar, e());
                    z11 = false;
                }
                Set linkedHashSet = null;
                for (Map.Entry entry : this.g.entrySet()) {
                    JsonNode jsonNode3 = jsonNode.get((String) entry.getKey());
                    if (jsonNode3 != null) {
                        String str = (String) entry.getKey();
                        aVar.getClass();
                        A3.a aVar2 = new A3.a(aVar, str);
                        if (z11) {
                            if (linkedHashSet == null) {
                                linkedHashSet = new LinkedHashSet();
                            }
                            linkedHashSet.add((String) entry.getKey());
                        }
                        fVar.c((String) entry.getKey());
                        if (z10) {
                            fVar.f().getClass();
                            n(fVar, entry, jsonNode, jsonNode2, aVar, true);
                        } else {
                            try {
                                ((u3.i) entry.getValue()).a(fVar, jsonNode3, jsonNode2, aVar2);
                            } finally {
                            }
                        }
                    } else if (z10) {
                        fVar.c((String) entry.getKey());
                        try {
                            fVar.f().getClass();
                            n(fVar, entry, jsonNode, jsonNode2, aVar, true);
                        } finally {
                            fVar.d();
                        }
                    } else {
                        continue;
                    }
                }
                if (z11) {
                    v3.b bVarE = fVar.e();
                    A3.a aVar3 = fVar.f;
                    if (linkedHashSet == null) {
                        linkedHashSet = Collections.EMPTY_SET;
                    }
                    bVarE.a(new C2057a(this.f6946a, aVar, this.c, aVar3, linkedHashSet));
                    return;
                }
                return;
            default:
                for (Map.Entry<String, JsonNode> entry2 : jsonNode.properties()) {
                    String key = entry2.getKey();
                    String strAsText = entry2.getValue().asText();
                    if (strAsText != null && (map = (Map) this.g.get(key)) != null) {
                        fVar.c(key);
                        try {
                            u3.i iVar = (u3.i) map.get(strAsText);
                            if (iVar != null) {
                                fVar.c(strAsText);
                                if (z10) {
                                    iVar.b(fVar, jsonNode, jsonNode2, aVar, true);
                                } else {
                                    try {
                                        iVar.a(fVar, jsonNode, jsonNode2, aVar);
                                    } catch (Throwable th) {
                                        fVar.d();
                                        throw th;
                                    }
                                }
                                fVar.d();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
