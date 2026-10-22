package z3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SpecificationVersionRange;
import com.networknt.schema.keyword.KeywordType;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import v3.C2057a;
import w3.C2097b;

/* loaded from: classes3.dex */
public final class x extends AbstractC2161f {
    public final /* synthetic */ int f;
    public final boolean g;
    public final Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, int i) {
        super(KeywordType.f3019C, jsonNode, jVar, iVar, cVar);
        this.f = i;
        switch (i) {
            case 1:
                super(KeywordType.f3023L, jsonNode, jVar, iVar, cVar);
                if (!jsonNode.isNumber()) {
                    throw new SchemaException("minimum value is not a number");
                }
                JsonNode jsonNode2 = this.e.g.get("exclusiveMinimum");
                if (jsonNode2 == null || !jsonNode2.isBoolean()) {
                    this.g = false;
                } else {
                    this.g = jsonNode2.booleanValue();
                }
                String strAsText = jsonNode.asText();
                if ((jsonNode.isLong() || jsonNode.isInt()) && TypedValues.Custom.S_INT.equals(k())) {
                    this.h = new C5.b(this, strAsText, jsonNode.asLong(), 4);
                    return;
                } else {
                    this.h = new A5.c((AbstractC2161f) this, jsonNode, strAsText, 24);
                    return;
                }
            case 2:
                super(KeywordType.f3039c0, jsonNode, jVar, iVar, cVar);
                this.g = SpecificationVersionRange.h.f3015a.contains(((C2097b) cVar.c).e);
                if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
                    throw new IllegalArgumentException("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
                }
                this.h = cVar.c(jVar, jsonNode, iVar);
                return;
            default:
                if (!jsonNode.isNumber()) {
                    throw new SchemaException("maximum value is not a number");
                }
                JsonNode jsonNode3 = this.e.g.get("exclusiveMaximum");
                if (jsonNode3 == null || !jsonNode3.isBoolean()) {
                    this.g = false;
                } else {
                    this.g = jsonNode3.booleanValue();
                }
                String strAsText2 = jsonNode.asText();
                if ((jsonNode.isLong() || jsonNode.isInt()) && TypedValues.Custom.S_INT.equals(k())) {
                    this.h = new F5.f(this, jsonNode, strAsText2, jsonNode.asLong());
                    return;
                } else {
                    this.h = new A5.c((AbstractC2161f) this, jsonNode, strAsText2, 23);
                    return;
                }
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        boolean z10;
        int i;
        boolean z11;
        switch (this.f) {
            case 0:
                G g = (G) this.h;
                if (E3.b.a(jsonNode, ((u3.k) this.d.d).g) && g.x(jsonNode)) {
                    u3.g gVarJ = j();
                    gVarJ.getClass();
                    gVarJ.d = aVar;
                    gVarJ.b = fVar.f;
                    gVarJ.k = (Locale) fVar.f6698a.f177a;
                    gVarJ.e = new Object[]{g.w()};
                    fVar.a(gVarJ.a());
                    break;
                }
                break;
            case 1:
                G g10 = (G) this.h;
                if (E3.b.a(jsonNode, ((u3.k) this.d.d).g) && g10.x(jsonNode)) {
                    u3.g gVarJ2 = j();
                    gVarJ2.getClass();
                    gVarJ2.d = aVar;
                    gVarJ2.b = fVar.f;
                    gVarJ2.k = (Locale) fVar.f6698a.f177a;
                    gVarJ2.e = new Object[]{g10.w()};
                    fVar.a(gVarJ2.a());
                    break;
                }
                break;
            default:
                if (jsonNode.isArray()) {
                    boolean z12 = this.g;
                    String str = z12 ? "prefixItems" : "items";
                    String str2 = z12 ? "items" : "additionalItems";
                    S6.c cVar = new S6.c(19);
                    H h = new H(fVar, 0);
                    List list = (List) fVar.e().b.getOrDefault(aVar, Collections.EMPTY_LIST);
                    JsonNode jsonNode3 = this.b;
                    boolean z13 = false;
                    if (!jsonNode3.isBoolean() || !jsonNode3.booleanValue()) {
                        List list2 = (List) list.stream().filter(new io.modelcontextprotocol.spec.g(str, 1)).filter(h).filter(cVar).collect(Collectors.toList());
                        if (list2.isEmpty()) {
                            z10 = false;
                            i = 0;
                        } else {
                            Iterator it = list2.iterator();
                            z10 = false;
                            i = 0;
                            while (it.hasNext()) {
                                Object obj = ((C2057a) it.next()).e;
                                if (obj instanceof Number) {
                                    int iIntValue = ((Number) obj).intValue();
                                    if (iIntValue > i) {
                                        i = iIntValue;
                                    }
                                } else if (obj instanceof Boolean) {
                                    z10 = true;
                                }
                            }
                        }
                        if (!z10) {
                            Iterator it2 = ((List) list.stream().filter(new io.modelcontextprotocol.spec.g(str2, 2)).filter(h).filter(cVar).collect(Collectors.toList())).iterator();
                            while (it2.hasNext()) {
                                Object obj2 = ((C2057a) it2.next()).e;
                                if ((obj2 instanceof Boolean) && Boolean.TRUE.equals(obj2)) {
                                    z10 = true;
                                }
                            }
                        }
                        if (!z10) {
                            Iterator it3 = ((List) list.stream().filter(new S6.c(20)).filter(h).filter(cVar).collect(Collectors.toList())).iterator();
                            while (it3.hasNext()) {
                                Object obj3 = ((C2057a) it3.next()).e;
                                if ((obj3 instanceof Boolean) && Boolean.TRUE.equals(obj3)) {
                                    z10 = true;
                                }
                            }
                        }
                        z11 = false;
                    } else if (jsonNode.isEmpty()) {
                        z11 = false;
                        i = 0;
                        z10 = true;
                    } else {
                        i = 0;
                        z11 = true;
                        z10 = true;
                    }
                    if (!z10) {
                        fVar.d.size();
                        List list3 = (List) list.stream().filter(new S6.c(21)).filter(h).filter(cVar).collect(Collectors.toList());
                        HashSet hashSet = new HashSet();
                        Iterator it4 = list3.iterator();
                        while (it4.hasNext()) {
                            Object obj4 = ((C2057a) it4.next()).e;
                            if (obj4 instanceof List) {
                                hashSet.addAll((List) obj4);
                            } else if (obj4 instanceof Boolean) {
                                z13 = true;
                            }
                        }
                        if (!z13) {
                            while (i < jsonNode.size()) {
                                if (!hashSet.contains(Integer.valueOf(i))) {
                                    if (!jsonNode3.isBoolean() || jsonNode3.booleanValue()) {
                                        u3.i iVar = (u3.i) this.h;
                                        JsonNode jsonNode4 = jsonNode.get(i);
                                        aVar.getClass();
                                        iVar.a(fVar, jsonNode4, jsonNode, new A3.a(aVar, i));
                                    } else {
                                        u3.g gVarJ3 = j();
                                        gVarJ3.getClass();
                                        gVarJ3.d = aVar;
                                        gVarJ3.e = new Object[]{Integer.valueOf(i)};
                                        gVarJ3.b = fVar.f;
                                        gVarJ3.k = (Locale) fVar.f6698a.f177a;
                                        fVar.a(gVarJ3.a());
                                    }
                                    z11 = true;
                                }
                                i++;
                            }
                        }
                        fVar.d.size();
                    }
                    if (z11) {
                        fVar.e().a(new C2057a("unevaluatedItems", aVar, this.c, fVar.f, Boolean.TRUE));
                        break;
                    }
                }
                break;
        }
    }
}
