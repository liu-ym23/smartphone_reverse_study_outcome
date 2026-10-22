package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1968g;

    /* renamed from: h, reason: collision with root package name */
    public List f1969h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1968g = i;
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        switch (this.f1968g) {
            case 0:
                for (String str : this.f1969h) {
                    if (jsonNode.get(str) != null) {
                        w7.j jVar = (w7.j) j().b(str);
                        jVar.f15291b = fVar.f15311f;
                        jVar.f15293d = aVar.b(str);
                        jVar.f15319l = (Locale) fVar.f15306a.f7721f;
                        jVar.f15294e = new Object[]{str};
                        fVar.a(jVar.a());
                    }
                }
                break;
            default:
                if (jsonNode.isObject()) {
                    for (String str2 : this.f1969h) {
                        if (jsonNode.get(str2) == null) {
                            fVar.f15306a.getClass();
                            Boolean bool = Boolean.TRUE;
                            JsonNode jsonNode5 = null;
                            boolean zEquals = bool.equals(null);
                            w7.l lVar = this.f1955e;
                            if (zEquals) {
                                JsonNode jsonNode6 = lVar.f15331g.get("properties");
                                if (jsonNode6 != null && (jsonNode3 = jsonNode6.get(str2)) != null) {
                                    jsonNode5 = jsonNode3.get("readOnly");
                                }
                                if (jsonNode5 == null || !jsonNode5.booleanValue()) {
                                    w7.j jVar2 = (w7.j) j().b(str2);
                                    jVar2.f15293d = aVar;
                                    jVar2.f15291b = fVar.f15311f;
                                    jVar2.f15319l = (Locale) fVar.f15306a.f7721f;
                                    jVar2.f15294e = new Object[]{str2};
                                    fVar.a(jVar2.a());
                                }
                            } else {
                                if (bool.equals(null)) {
                                    JsonNode jsonNode7 = lVar.f15331g.get("properties");
                                    if (jsonNode7 != null && (jsonNode4 = jsonNode7.get(str2)) != null) {
                                        jsonNode5 = jsonNode4.get("writeOnly");
                                    }
                                    if (jsonNode5 == null || !jsonNode5.booleanValue()) {
                                    }
                                }
                                w7.j jVar22 = (w7.j) j().b(str2);
                                jVar22.f15293d = aVar;
                                jVar22.f15291b = fVar.f15311f;
                                jVar22.f15319l = (Locale) fVar.f15306a.f7721f;
                                jVar22.f15294e = new Object[]{str2};
                                fVar.a(jVar22.a());
                            }
                        }
                    }
                    break;
                }
                break;
        }
    }
}
