package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.invoke.VarHandle;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements x {

    /* renamed from: c, reason: collision with root package name */
    public String f2016c;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f2017f;

    @Override // b8.x
    public final a a(w7.n nVar, JsonNode jsonNode, w7.l lVar, androidx.room.q qVar) {
        z7.d dVar;
        if (jsonNode == null || !jsonNode.isTextual()) {
            dVar = null;
        } else {
            dVar = (z7.d) this.f2017f.get(jsonNode.textValue());
        }
        t tVar = new t(this, jsonNode, nVar, lVar, qVar);
        y7.a aVar = (y7.a) tVar.f1954d.f1600c;
        w7.q qVar2 = aVar.f15933e;
        if (qVar2 == null || qVar2.f15356c < 8) {
            tVar.f2020g = true;
        } else {
            tVar.f2020g = t.n(qVar2, aVar.f15932d);
        }
        tVar.f2021h = dVar;
        VarHandle.storeStoreFence();
        return tVar;
    }

    @Override // b8.x
    public final String getValue() {
        return this.f2016c;
    }
}
