package b8;

import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1945d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(x xVar, JsonNode jsonNode, w7.n nVar, int i) {
        super(xVar, jsonNode, nVar);
        this.f1945d = i;
    }

    @Override // b8.a, w7.s
    public void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f1945d) {
            case 1:
                break;
            default:
                super.b(fVar, jsonNode, jsonNode2, aVar);
                break;
        }
    }

    private final void j(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
    }
}
