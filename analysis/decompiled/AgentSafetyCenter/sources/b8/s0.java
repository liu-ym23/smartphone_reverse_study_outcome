package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public final int f2018g;

    /* renamed from: h, reason: collision with root package name */
    public final k f2019h;

    public s0(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        super(b0.f1915b0, jsonNode, nVar, lVar, qVar);
        int iV = td.h.v(jsonNode);
        this.f2018g = iV;
        if (iV == 10) {
            this.f2019h = new k(nVar, jsonNode, lVar, qVar);
        } else {
            this.f2019h = null;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        boolean zEquals;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        int i = this.f2018g;
        if (i == 10) {
            this.f2019h.b(fVar, jsonNode, jsonNode2, aVar);
            return;
        }
        int i3 = g8.b.f4369b;
        androidx.room.q qVar = this.f1954d;
        u9.d dVar = ((w7.o) qVar.f1601d).f15349g;
        int iX = td.h.x(jsonNode, dVar);
        if (iX != i) {
            if (i == 4 && iX == 5) {
                return;
            }
            if (i == 5 && iX == 4 && jsonNode.canConvertToExactIntegral() && g8.b.f4368a <= ((y7.a) qVar.f1600c).f15933e.f15356c) {
                return;
            }
            w7.l lVar = this.f1955e;
            if (iX == 7 && lVar != null && qVar.f1599b) {
                w7.l lVar2 = lVar.f15332h;
                if (lVar2 != null && (jsonNode4 = lVar2.f15331g.get("nullable")) != null && jsonNode4.asBoolean()) {
                    return;
                }
                JsonNode jsonNode5 = lVar.f15331g.get("nullable");
                if (jsonNode5 != null && jsonNode5.asBoolean()) {
                    return;
                }
            }
            if (!dVar.b("type", Boolean.TRUE)) {
                JsonNode jsonNode6 = null;
                if (lVar != null) {
                    JsonNode jsonNode7 = lVar.f15331g;
                    if (jsonNode7 != null) {
                        jsonNode6 = jsonNode7.get("type");
                        jsonNode3 = jsonNode7.get("enum");
                    } else {
                        jsonNode3 = null;
                    }
                    zEquals = "$ref".equals(fVar.f15311f.f2224f.d(-1));
                } else {
                    zEquals = false;
                    jsonNode3 = null;
                }
                if (jsonNode6 != null && jsonNode3 != null && zEquals && td.h.v(jsonNode6) == 1 && jsonNode3.isArray()) {
                    return;
                }
            }
            if (i == 8) {
                return;
            }
            int iX2 = td.h.x(jsonNode, ((w7.o) qVar.f1601d).f15349g);
            w7.j jVarJ = j();
            jVarJ.f15293d = aVar;
            jVarJ.f15291b = fVar.f15311f;
            jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
            jVarJ.f15294e = new Object[]{androidx.activity.b.b(iX2), androidx.activity.b.b(i)};
            fVar.a(jVarJ.a());
        }
    }
}
