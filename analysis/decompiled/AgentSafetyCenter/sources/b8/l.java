package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1978g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f1979h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1978g = i;
    }

    @Override // w7.s
    public void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) throws Throwable {
        switch (this.f1978g) {
            case 1:
                if (!z10) {
                    Iterator it = this.f1979h.values().iterator();
                    while (it.hasNext()) {
                        ((w7.l) it.next()).a(fVar, jsonNode, jsonNode2, aVar, false);
                    }
                    break;
                } else {
                    m(fVar, jsonNode, jsonNode2, aVar, true);
                    break;
                }
            default:
                super.a(fVar, jsonNode, jsonNode2, aVar, z10);
                break;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) throws Throwable {
        switch (this.f1978g) {
            case 0:
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    List<String> list = (List) this.f1979h.get(next);
                    if (list != null && !list.isEmpty()) {
                        for (String str : list) {
                            if (jsonNode.get(str) == null) {
                                w7.j jVar = (w7.j) j().b(next);
                                jVar.f15293d = aVar;
                                jVar.f15291b = fVar.f15311f;
                                jVar.f15319l = (Locale) fVar.f15306a.f7721f;
                                jVar.f15294e = new Object[]{str, next};
                                fVar.a(jVar.a());
                            }
                        }
                    }
                }
                break;
            default:
                m(fVar, jsonNode, jsonNode2, aVar, false);
                break;
        }
    }

    @Override // b8.a
    public void i() {
        switch (this.f1978g) {
            case 1:
                f.l(this.f1979h.values());
                break;
        }
    }

    public void m(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) throws Throwable {
        w7.f fVar2;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        c8.a aVar2;
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            w7.l lVar = (w7.l) this.f1979h.get(next);
            if (lVar != null) {
                fVar.c(next);
                if (z10) {
                    fVar2 = fVar;
                    jsonNode3 = jsonNode;
                    jsonNode4 = jsonNode2;
                    aVar2 = aVar;
                    try {
                        lVar.a(fVar2, jsonNode3, jsonNode4, aVar2, true);
                        fVar2.d();
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        fVar2.d();
                        throw th2;
                    }
                } else {
                    try {
                        lVar.b(fVar, jsonNode, jsonNode2, aVar);
                        fVar2 = fVar;
                        jsonNode3 = jsonNode;
                        jsonNode4 = jsonNode2;
                        aVar2 = aVar;
                        fVar2.d();
                    } catch (Throwable th3) {
                        th = th3;
                        fVar2 = fVar;
                        Throwable th22 = th;
                        fVar2.d();
                        throw th22;
                    }
                }
            } else {
                fVar2 = fVar;
                jsonNode3 = jsonNode;
                jsonNode4 = jsonNode2;
                aVar2 = aVar;
            }
            fVar = fVar2;
            jsonNode = jsonNode3;
            jsonNode2 = jsonNode4;
            aVar = aVar2;
        }
    }
}
