package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import v3.C2057a;

/* loaded from: classes3.dex */
public final class s extends AbstractC2161f {
    public final u3.i f;
    public final int g;
    public final boolean h;

    public s(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        super(KeywordType.f3051w, jsonNode, jVar, iVar, cVar);
        JsonNode jsonNode2 = iVar.g.get("prefixItems");
        if (jsonNode2 instanceof ArrayNode) {
            this.g = jsonNode2.size();
        } else {
            if (jsonNode2 != null) {
                throw new IllegalArgumentException("The value of 'prefixItems' must be an array of JSON Schema.");
            }
            this.g = 0;
        }
        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
            throw new IllegalArgumentException("The value of 'items' MUST be a valid JSON Schema.");
        }
        this.f = cVar.c(jVar, jsonNode, iVar);
        this.h = jsonNode.isBoolean() ? jsonNode.booleanValue() : true;
    }

    public static void m(u3.f fVar, u3.i iVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        fVar.f().getClass();
        KeywordType.f3051w.getClass();
        int size = fVar.d.size();
        iVar.b(fVar, jsonNode, jsonNode2, aVar, z10);
        fVar.f().getClass();
        List list = fVar.d;
        list.subList(size, list.size());
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        if (jsonNode.isArray()) {
            boolean z10 = false;
            int i = this.g;
            while (i < jsonNode.size()) {
                aVar.getClass();
                A3.a aVar2 = new A3.a(aVar, i);
                if (this.h) {
                    this.f.a(fVar, jsonNode.get(i), jsonNode2, aVar2);
                } else {
                    u3.g gVarJ = j();
                    gVarJ.getClass();
                    gVarJ.d = aVar;
                    gVarJ.b = fVar.f;
                    gVarJ.k = (Locale) fVar.f6698a.f177a;
                    Integer numValueOf = Integer.valueOf(i);
                    if (gVarJ.f == null) {
                        gVarJ.f = new HashMap();
                    }
                    gVarJ.f.put("index", numValueOf);
                    gVarJ.e = new Object[]{Integer.valueOf(i)};
                    fVar.a(gVarJ.a());
                }
                i++;
                z10 = true;
            }
            if (z10) {
                if (!AbstractC2156a.g(fVar)) {
                    AbstractC2156a.d(fVar, e());
                    return;
                }
                fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, Boolean.TRUE));
            }
        }
    }

    @Override // u3.m
    public final void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        boolean z11 = jsonNode instanceof ArrayNode;
        int i = this.g;
        if (!z11) {
            aVar.getClass();
            m(fVar, this.f, null, jsonNode2, new A3.a(aVar, i), z10);
            return;
        }
        ((G3.a) fVar.f().f4555a).getClass();
        boolean z12 = false;
        while (i < jsonNode.size()) {
            JsonNode jsonNode3 = jsonNode.get(i);
            jsonNode3.isNull();
            aVar.getClass();
            m(fVar, this.f, jsonNode3, jsonNode2, new A3.a(aVar, i), z10);
            i++;
            z12 = true;
        }
        if (z12) {
            if (!AbstractC2156a.g(fVar)) {
                AbstractC2156a.d(fVar, e());
                return;
            }
            fVar.e().a(new C2057a(this.f6946a, aVar, this.c, fVar.f, Boolean.TRUE));
        }
    }

    @Override // z3.AbstractC2156a
    public final void i() {
        this.f.h();
    }
}
