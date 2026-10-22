package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class z extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final List g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.f3025N, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f3037Z, jsonNode, jVar, iVar, cVar);
                if (jsonNode.isArray()) {
                    this.g = new ArrayList(jsonNode.size());
                    Iterator<JsonNode> it = jsonNode.iterator();
                    while (it.hasNext()) {
                        this.g.add(it.next().asText());
                    }
                    break;
                } else {
                    this.g = Collections.EMPTY_LIST;
                    break;
                }
            default:
                if (jsonNode.isArray()) {
                    int size = jsonNode.size();
                    this.g = new ArrayList(size);
                    for (int i6 = 0; i6 < size; i6++) {
                        this.g.add(jsonNode.get(i6).asText());
                    }
                    break;
                } else {
                    this.g = Collections.EMPTY_LIST;
                    break;
                }
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        switch (this.f) {
            case 0:
                for (String str : this.g) {
                    if (jsonNode.get(str) != null) {
                        u3.g gVar = (u3.g) j().b(str);
                        gVar.getClass();
                        gVar.b = fVar.f;
                        aVar.getClass();
                        gVar.d = new A3.a(aVar, str);
                        gVar.k = (Locale) fVar.f6698a.f177a;
                        gVar.e = new Object[]{str};
                        fVar.a(gVar.a());
                    }
                }
                break;
            default:
                if (jsonNode.isObject()) {
                    for (String str2 : this.g) {
                        if (jsonNode.get(str2) == null) {
                            fVar.f6698a.getClass();
                            Boolean bool = Boolean.TRUE;
                            JsonNode jsonNode5 = null;
                            boolean zEquals = bool.equals(null);
                            u3.i iVar = this.e;
                            if (zEquals) {
                                JsonNode jsonNode6 = iVar.g.get("properties");
                                if (jsonNode6 != null && (jsonNode3 = jsonNode6.get(str2)) != null) {
                                    jsonNode5 = jsonNode3.get("readOnly");
                                }
                                if (jsonNode5 == null || !jsonNode5.booleanValue()) {
                                    u3.g gVarJ = j();
                                    gVarJ.getClass();
                                    u3.g gVar2 = (u3.g) gVarJ.b(str2);
                                    gVar2.d = aVar;
                                    gVar2.b = fVar.f;
                                    gVar2.k = (Locale) fVar.f6698a.f177a;
                                    gVar2.e = new Object[]{str2};
                                    fVar.a(gVar2.a());
                                }
                            } else {
                                if (bool.equals(null)) {
                                    JsonNode jsonNode7 = iVar.g.get("properties");
                                    if (jsonNode7 != null && (jsonNode4 = jsonNode7.get(str2)) != null) {
                                        jsonNode5 = jsonNode4.get("writeOnly");
                                    }
                                    if (jsonNode5 == null || !jsonNode5.booleanValue()) {
                                    }
                                }
                                u3.g gVarJ2 = j();
                                gVarJ2.getClass();
                                u3.g gVar22 = (u3.g) gVarJ2.b(str2);
                                gVar22.d = aVar;
                                gVar22.b = fVar.f;
                                gVar22.k = (Locale) fVar.f6698a.f177a;
                                gVar22.e = new Object[]{str2};
                                fVar.a(gVar22.a());
                            }
                        }
                    }
                    break;
                }
                break;
        }
    }
}
