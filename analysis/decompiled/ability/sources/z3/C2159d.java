package z3;

import com.fasterxml.jackson.databind.JsonNode;

/* renamed from: z3.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2159d extends AbstractC2156a {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2159d(t tVar, JsonNode jsonNode, u3.j jVar, int i) {
        super(tVar, jsonNode, jVar);
        this.d = i;
    }

    private final void j(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
    }

    @Override // z3.AbstractC2156a, u3.m
    public void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        switch (this.d) {
            case 1:
                break;
            default:
                super.a(fVar, jsonNode, jsonNode2, aVar);
                break;
        }
    }
}
