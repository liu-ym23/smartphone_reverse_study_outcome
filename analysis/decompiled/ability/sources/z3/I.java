package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class I extends AbstractC2161f {
    public final boolean f;

    public I(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        super(KeywordType.f3041e0, jsonNode, jVar, iVar, cVar);
        if (jsonNode.isBoolean()) {
            this.f = jsonNode.booleanValue();
        } else {
            this.f = false;
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        if (this.f) {
            HashSet hashSet = new HashSet();
            Iterator<JsonNode> it = jsonNode.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next())) {
                    u3.g gVarJ = j();
                    gVarJ.getClass();
                    gVarJ.d = aVar;
                    gVarJ.b = fVar.f;
                    gVarJ.k = (Locale) fVar.f6698a.f177a;
                    fVar.a(gVarJ.a());
                }
            }
        }
    }
}
