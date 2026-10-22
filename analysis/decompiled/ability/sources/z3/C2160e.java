package z3;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import w3.C2097b;

/* renamed from: z3.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2160e implements t {

    /* renamed from: a, reason: collision with root package name */
    public final String f6948a;
    public final /* synthetic */ int b;

    public C2160e(String str, int i) {
        this.b = i;
        this.f6948a = str;
    }

    @Override // z3.t
    public final AbstractC2156a a(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        switch (this.b) {
            case 0:
                return new C2159d(this, jsonNode, jVar, 0);
            default:
                C2159d c2159d = new C2159d(this, jsonNode, jVar, 1);
                C2097b c2097b = (C2097b) cVar.c;
                JsonNode jsonNode4 = jsonNode.get(c2097b.b);
                String strTextValue = null;
                String strTextValue2 = jsonNode4 == null ? null : jsonNode4.textValue();
                String strTextValue3 = (!c2097b.c.containsKey("$anchor") || (jsonNode3 = jsonNode.get("$anchor")) == null) ? null : jsonNode3.textValue();
                if (c2097b.c.containsKey("$dynamicAnchor") && (jsonNode2 = jsonNode.get("$dynamicAnchor")) != null) {
                    strTextValue = jsonNode2.textValue();
                }
                if (strTextValue2 != null || strTextValue3 != null || strTextValue != null) {
                    cVar.c(jVar, jsonNode, iVar);
                }
                String str = this.f6948a;
                if ("$defs".equals(str) || "definitions".equals(str)) {
                    Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                    while (itFields.hasNext()) {
                        Map.Entry<String, JsonNode> next = itFields.next();
                        u3.j jVarB = jVar.b(next.getKey());
                        ((ConcurrentMap) cVar.e).put(jVarB.toString(), cVar.c(jVarB, next.getValue(), iVar));
                    }
                }
                return c2159d;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.f6948a, ((C2160e) obj).f6948a);
        }
        return false;
    }

    @Override // z3.t
    public final String getValue() {
        return this.f6948a;
    }

    public final int hashCode() {
        return Objects.hash(this.f6948a);
    }

    public final String toString() {
        return this.f6948a;
    }
}
