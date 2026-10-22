package o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final m0.e f9046a = new m0.e(new h[16]);

    /* renamed from: b, reason: collision with root package name */
    public final p.a0 f9047b = new p.a0(10);

    public boolean a(p.n nVar, s1.q qVar, ma.a aVar, boolean z10) {
        m0.e eVar = this.f9046a;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        boolean z11 = false;
        for (int i3 = 0; i3 < i; i3++) {
            z11 = ((h) objArr[i3]).a(nVar, qVar, aVar, z10) || z11;
        }
        return z11;
    }

    public void b(ma.a aVar) {
        m0.e eVar = this.f9046a;
        int i = eVar.f8160g;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            }
            if (((h) eVar.f8158c[i]).f9035d.f15389f == 0) {
                eVar.k(i);
            }
        }
    }
}
