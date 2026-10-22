package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.InvalidSchemaRefException;
import com.networknt.schema.keyword.KeywordType;
import java.util.Iterator;
import java.util.Locale;
import u3.C2035a;

/* renamed from: z3.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2162g extends AbstractC2161f {
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2162g(t tVar, JsonNode jsonNode, u3.j jVar, u3.i iVar, G6.c cVar, int i) {
        super(tVar, jsonNode, jVar, iVar, cVar);
        this.f = i;
    }

    private final void n(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        switch (this.f) {
            case 0:
                JsonNode jsonNode3 = this.b;
                if (jsonNode3.isNumber() && jsonNode.isNumber()) {
                    if (jsonNode3.decimalValue().compareTo(jsonNode.decimalValue()) != 0) {
                        u3.g gVarJ = j();
                        gVarJ.getClass();
                        gVarJ.d = aVar;
                        gVarJ.b = fVar.f;
                        gVarJ.k = (Locale) fVar.f6698a.f177a;
                        gVarJ.e = new Object[]{jsonNode3.asText(), jsonNode.asText()};
                        fVar.a(gVarJ.a());
                        return;
                    }
                    return;
                }
                if (jsonNode3.equals(jsonNode)) {
                    return;
                }
                u3.g gVarJ2 = j();
                gVarJ2.getClass();
                gVarJ2.d = aVar;
                gVarJ2.b = fVar.f;
                gVarJ2.k = (Locale) fVar.f6698a.f177a;
                gVarJ2.e = new Object[]{jsonNode3.asText(), jsonNode.asText()};
                fVar.a(gVarJ2.a());
                return;
            case 1:
                u3.i iVarD = m(fVar).d();
                if (iVarD != null) {
                    iVarD.a(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                u3.g gVarJ3 = j();
                gVarJ3.f6696a = KeywordType.o.f3054a;
                gVarJ3.i = "internal.unresolvedRef";
                gVarJ3.g = "Reference {0} cannot be resolved";
                gVarJ3.d = aVar;
                gVarJ3.b = fVar.f;
                gVarJ3.e = new Object[]{this.b.asText()};
                throw new InvalidSchemaRefException(gVarJ3.a());
            case 2:
                Object objB = fVar.f.b.b(-1);
                String string = objB != null ? objB.toString() : null;
                u3.g gVarJ4 = j();
                gVarJ4.getClass();
                gVarJ4.d = aVar;
                gVarJ4.b = fVar.f;
                gVarJ4.k = (Locale) fVar.f6698a.f177a;
                gVarJ4.e = new Object[]{string};
                fVar.a(gVarJ4.a());
                return;
            case 3:
                u3.i iVarD2 = this.e.d();
                C2035a c2035a = iVarD2.i.f6704a;
                String str = c2035a != null ? c2035a.f6694a : "";
                if (iVarD2.f) {
                    Iterator itDescendingIterator = fVar.g.descendingIterator();
                    while (itDescendingIterator.hasNext()) {
                        u3.i iVar = (u3.i) itDescendingIterator.next();
                        C2035a c2035a2 = iVar.i.f6704a;
                        String str2 = c2035a2 != null ? c2035a2.f6694a : "";
                        if (!str.equals(str2)) {
                            u3.i iVarD3 = iVar.d();
                            if (iVarD3.f) {
                                iVarD2 = iVarD3;
                            }
                            str = str2;
                        }
                    }
                }
                if (iVarD2 != null) {
                    iVarD2.a(fVar, jsonNode, jsonNode2, aVar);
                    return;
                }
                u3.g gVarJ5 = j();
                gVarJ5.f6696a = KeywordType.f3035X.f3054a;
                gVarJ5.i = "internal.unresolvedRef";
                gVarJ5.g = "Reference {0} cannot be resolved";
                gVarJ5.d = aVar;
                gVarJ5.b = fVar.f;
                gVarJ5.e = new Object[]{this.b.asText()};
                throw new InvalidSchemaRefException(gVarJ5.a());
            default:
                return;
        }
    }

    @Override // u3.m
    public void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        switch (this.f) {
            case 1:
                u3.i iVarD = m(fVar).d();
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
                gVarJ.f6696a = KeywordType.o.f3054a;
                gVarJ.i = "internal.unresolvedRef";
                gVarJ.g = "Reference {0} cannot be resolved";
                gVarJ.d = aVar;
                gVarJ.b = fVar.f;
                gVarJ.e = new Object[]{this.b.asText()};
                throw new InvalidSchemaRefException(gVarJ.a());
            case 2:
            default:
                super.b(fVar, jsonNode, jsonNode2, aVar, z10);
                return;
            case 3:
                u3.i iVarD2 = this.e.d();
                C2035a c2035a = iVarD2.i.f6704a;
                String str = c2035a != null ? c2035a.f6694a : "";
                if (iVarD2.f) {
                    Iterator itDescendingIterator2 = fVar.g.descendingIterator();
                    while (itDescendingIterator2.hasNext()) {
                        u3.i iVar = (u3.i) itDescendingIterator2.next();
                        C2035a c2035a2 = iVar.i.f6704a;
                        String str2 = c2035a2 != null ? c2035a2.f6694a : "";
                        if (!str.equals(str2)) {
                            u3.i iVarD3 = iVar.d();
                            if (iVarD3.f) {
                                iVarD2 = iVarD3;
                            }
                            str = str2;
                        }
                    }
                }
                if (iVarD2 != null) {
                    if (jsonNode == null) {
                        u3.j jVar2 = iVarD2.i;
                        Iterator itDescendingIterator3 = fVar.g.descendingIterator();
                        while (itDescendingIterator3.hasNext()) {
                            if (((u3.i) itDescendingIterator3.next()).i.equals(jVar2)) {
                                return;
                            }
                        }
                    }
                    iVarD2.b(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                }
                u3.g gVarJ2 = j();
                gVarJ2.f6696a = KeywordType.f3035X.f3054a;
                gVarJ2.i = "internal.unresolvedRef";
                gVarJ2.g = "Reference {0} cannot be resolved";
                gVarJ2.d = aVar;
                gVarJ2.b = fVar.f;
                gVarJ2.e = new Object[]{this.b.asText()};
                throw new InvalidSchemaRefException(gVarJ2.a());
        }
    }

    public Q.a m(u3.f fVar) {
        u3.i iVar;
        String strAsText = this.b.asText();
        u3.i iVar2 = this.e;
        if (iVar2.f6702a == null || (iVar = iVar2.h) == null) {
            iVar = iVar2;
        }
        return new Q.a(new io.modelcontextprotocol.server.m(iVar2, u3.j.d(iVar.i, strAsText), strAsText, fVar, 3), 11);
    }
}
