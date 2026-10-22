package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1943g;

    /* renamed from: h, reason: collision with root package name */
    public int f1944h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1943g = i;
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f1943g) {
            case 0:
                int i = this.f1944h;
                if (!jsonNode.isArray()) {
                    ((w7.o) this.f1954d.f1601d).f15349g.getClass();
                    break;
                } else if (jsonNode.size() > i) {
                    w7.j jVarJ = j();
                    jVarJ.f15293d = aVar;
                    jVarJ.f15291b = fVar.f15311f;
                    jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ.f15294e = new Object[]{Integer.valueOf(i), Integer.valueOf(jsonNode.size())};
                    fVar.a(jVarJ.a());
                    break;
                }
                break;
            case 1:
                int i3 = this.f1944h;
                if (td.h.x(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g) == 3 && jsonNode.textValue().codePointCount(0, jsonNode.textValue().length()) > i3) {
                    w7.j jVarJ2 = j();
                    jVarJ2.f15293d = aVar;
                    jVarJ2.f15291b = fVar.f15311f;
                    jVarJ2.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ2.f15294e = new Object[]{Integer.valueOf(i3)};
                    fVar.a(jVarJ2.a());
                    break;
                }
                break;
            case 2:
                int i10 = this.f1944h;
                if (jsonNode.isObject() && jsonNode.size() > i10) {
                    w7.j jVarJ3 = j();
                    jVarJ3.f15293d = aVar;
                    jVarJ3.f15291b = fVar.f15311f;
                    jVarJ3.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ3.f15294e = new Object[]{Integer.valueOf(i10)};
                    fVar.a(jVarJ3.a());
                    break;
                }
                break;
            case 3:
                int i11 = this.f1944h;
                if (!jsonNode.isArray()) {
                    ((w7.o) this.f1954d.f1601d).f15349g.getClass();
                    break;
                } else if (jsonNode.size() < i11) {
                    w7.j jVarJ4 = j();
                    jVarJ4.f15293d = aVar;
                    jVarJ4.f15291b = fVar.f15311f;
                    jVarJ4.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ4.f15294e = new Object[]{Integer.valueOf(i11), Integer.valueOf(jsonNode.size())};
                    fVar.a(jVarJ4.a());
                    break;
                }
                break;
            case 4:
                int i12 = this.f1944h;
                if (td.h.x(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g) == 3 && jsonNode.textValue().codePointCount(0, jsonNode.textValue().length()) < i12) {
                    w7.j jVarJ5 = j();
                    jVarJ5.f15293d = aVar;
                    jVarJ5.f15291b = fVar.f15311f;
                    jVarJ5.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ5.f15294e = new Object[]{Integer.valueOf(i12)};
                    fVar.a(jVarJ5.a());
                    break;
                }
                break;
            default:
                int i13 = this.f1944h;
                if (jsonNode.isObject() && jsonNode.size() < i13) {
                    w7.j jVarJ6 = j();
                    jVarJ6.f15293d = aVar;
                    jVarJ6.f15291b = fVar.f15311f;
                    jVarJ6.f15319l = (Locale) fVar.f15306a.f7721f;
                    jVarJ6.f15294e = new Object[]{Integer.valueOf(i13)};
                    fVar.a(jVarJ6.a());
                    break;
                }
                break;
        }
    }
}
