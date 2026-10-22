package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements x {

    /* renamed from: c, reason: collision with root package name */
    public final String f1950c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1951f;

    public e(String str, int i) {
        this.f1951f = i;
        this.f1950c = str;
    }

    @Override // b8.x
    public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        switch (this.f1951f) {
            case 0:
                return new d(this, jsonNode, nVar, 0);
            default:
                d dVar = new d(this, jsonNode, nVar, 1);
                y7.a aVar = (y7.a) qVar.f1600c;
                JsonNode jsonNode4 = jsonNode.get(aVar.f15930b);
                String strTextValue = null;
                String strTextValue2 = jsonNode4 == null ? null : jsonNode4.textValue();
                String strTextValue3 = (!aVar.f15931c.containsKey("$anchor") || (jsonNode3 = jsonNode.get("$anchor")) == null) ? null : jsonNode3.textValue();
                if (aVar.f15931c.containsKey("$dynamicAnchor") && (jsonNode2 = jsonNode.get("$dynamicAnchor")) != null) {
                    strTextValue = jsonNode2.textValue();
                }
                if (strTextValue2 != null || strTextValue3 != null || strTextValue != null) {
                    qVar.d(nVar, jsonNode, lVar);
                }
                String str = this.f1950c;
                if ("$defs".equals(str) || "definitions".equals(str)) {
                    Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                    while (itFields.hasNext()) {
                        Map.Entry<String, JsonNode> next = itFields.next();
                        w7.n nVarB = nVar.b(next.getKey());
                        ((ConcurrentMap) qVar.f1602e).put(nVarB.toString(), qVar.d(nVarB, next.getValue(), lVar));
                    }
                }
                return dVar;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.f1950c, ((e) obj).f1950c);
        }
        return false;
    }

    @Override // b8.x
    public final String getValue() {
        return this.f1950c;
    }

    public final int hashCode() {
        return Objects.hash(this.f1950c);
    }

    public final String toString() {
        return this.f1950c;
    }
}
