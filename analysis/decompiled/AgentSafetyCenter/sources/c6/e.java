package c6;

import p.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n6.a f2216g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i, n6.a aVar) {
        super(i);
        this.f2216g = aVar;
    }

    @Override // p.p
    public final void a(Object obj, Object obj2, Object obj3) {
        d dVar = (d) obj2;
        ((wd.a) this.f2216g.f8776c).i((a) obj, dVar.f2213a, dVar.f2214b, dVar.f2215c);
    }

    @Override // p.p
    public final int f(Object obj, Object obj2) {
        return ((d) obj2).f2215c;
    }
}
