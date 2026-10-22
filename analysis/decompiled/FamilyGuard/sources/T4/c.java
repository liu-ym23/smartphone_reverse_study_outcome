package T4;

import A1.e;
import A1.k;
import A1.t;
import C4.G;
import R4.f;

/* loaded from: classes.dex */
final class c<T> implements f<G, T> {

    /* renamed from: a, reason: collision with root package name */
    private final e f5430a;

    /* renamed from: b, reason: collision with root package name */
    private final t<T> f5431b;

    c(e eVar, t<T> tVar) {
        this.f5430a = eVar;
        this.f5431b = tVar;
    }

    @Override // R4.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(G g5) {
        G1.a aVarO = this.f5430a.o(g5.f());
        try {
            T tB = this.f5431b.b(aVarO);
            if (aVarO.V() == G1.b.END_DOCUMENT) {
                return tB;
            }
            throw new k("JSON document was not fully consumed.");
        } finally {
            g5.close();
        }
    }
}
