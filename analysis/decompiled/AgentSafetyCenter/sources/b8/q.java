package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2010g;

    /* renamed from: h, reason: collision with root package name */
    public r0 f2011h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f2010g = i;
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f2010g) {
            case 0:
                r0 r0Var = this.f2011h;
                if (g8.b.a(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g) && r0Var.o(jsonNode)) {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ.f15294e = new Object[]{r0Var.k()};
                    fVar.a(jVarJ.a());
                    break;
                }
                break;
            default:
                r0 r0Var2 = this.f2011h;
                if (g8.b.a(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g) && r0Var2.o(jsonNode)) {
                    w7.j jVarJ2 = j();
                    jVarJ2.f15293d = aVar;
                    jVarJ2.f15291b = fVar.f15311f;
                    jVarJ2.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ2.f15294e = new Object[]{r0Var2.k()};
                    fVar.a(jVarJ2.a());
                    break;
                }
                break;
        }
    }
}
