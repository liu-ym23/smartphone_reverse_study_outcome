package z3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.utils.JsonType;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;
import w3.C2097b;

/* loaded from: classes3.dex */
public final class p extends x3.a {
    public static final InterfaceC0315b h = AbstractC0317d.b(p.class);
    public final x3.d g;

    public p(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar, x3.d dVar, o oVar) {
        super(jVar, jsonNode, iVar, oVar, cVar);
        this.g = dVar;
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        c(fVar);
        boolean zM = m(fVar);
        G6.c cVar = this.d;
        x3.d dVar = this.g;
        if (dVar == null) {
            if (!m(fVar) || !((u3.k) cVar.d).g.c(this.f6946a, Boolean.FALSE)) {
                C2097b c2097b = (C2097b) cVar.c;
                if (!x3.a.n(c2097b.e, c2097b.d)) {
                    return;
                }
            }
            JsonNode jsonNode3 = this.b;
            if (jsonNode3.isTextual()) {
                u3.g gVarJ = j();
                gVarJ.d = aVar;
                gVarJ.b = fVar.f;
                gVarJ.i = "format.unknown";
                gVarJ.e = new Object[]{jsonNode3.textValue()};
                fVar.a(gVarJ.a());
                return;
            }
            return;
        }
        if (zM) {
            try {
                if (com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) cVar.d).g) != JsonType.STRING ? true : dVar.b(fVar, cVar, jsonNode.textValue())) {
                    return;
                }
                u3.g gVarJ2 = j();
                gVarJ2.getClass();
                gVarJ2.d = aVar;
                gVarJ2.b = fVar.f;
                gVarJ2.i = dVar.a();
                gVarJ2.k = (Locale) fVar.f6698a.f177a;
                gVarJ2.e = new Object[]{dVar.getName(), jsonNode.asText()};
                fVar.a(gVarJ2.a());
            } catch (PatternSyntaxException e) {
                h.error("Failed to apply pattern on {}: Invalid RE syntax [{}]", aVar, dVar.getName(), e);
            }
        }
    }
}
