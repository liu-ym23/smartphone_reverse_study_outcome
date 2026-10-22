package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class o implements t {

    /* renamed from: a, reason: collision with root package name */
    public final String f6950a = KeywordType.f3049t.f3054a;
    public final Map b;

    public o(HashMap map) {
        this.b = map;
    }

    @Override // z3.t
    public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        x3.d dVar;
        if (jsonNode == null || !jsonNode.isTextual()) {
            dVar = null;
        } else {
            dVar = (x3.d) this.b.get(jsonNode.textValue());
        }
        return new p(jVar, jsonNode, iVar, cVar, dVar, this);
    }

    @Override // z3.t
    public final String getValue() {
        return this.f6950a;
    }
}
