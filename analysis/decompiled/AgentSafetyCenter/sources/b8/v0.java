package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public boolean f2033g;

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        if (this.f2033g) {
            HashSet hashSet = new HashSet();
            Iterator<JsonNode> it = jsonNode.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next())) {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    fVar.a(jVarJ.a());
                }
            }
        }
    }
}
