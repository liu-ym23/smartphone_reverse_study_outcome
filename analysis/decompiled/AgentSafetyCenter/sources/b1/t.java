package b1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1854c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q f1855f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f1856g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f1857h;
    public final /* synthetic */ b.g i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1858j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(q qVar, q qVar2, Object obj, int i, b.g gVar, int i3) {
        super(1);
        this.f1854c = i3;
        this.f1855f = qVar;
        this.f1856g = qVar2;
        this.f1858j = obj;
        this.f1857h = i;
        this.i = gVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f1854c) {
            case 0:
                s1.d dVar = (s1.d) obj;
                q qVar = this.f1856g;
                if (this.f1855f != ((i) ((v1.t) u1.f.v(qVar)).getFocusOwner()).f1825h) {
                    return Boolean.TRUE;
                }
                boolean zB = e.B(qVar, (q) this.f1858j, this.f1857h, this.i);
                Boolean boolValueOf = Boolean.valueOf(zB);
                if (zB || !dVar.a()) {
                    return boolValueOf;
                }
                return null;
            default:
                s1.d dVar2 = (s1.d) obj;
                q qVar2 = this.f1856g;
                if (this.f1855f != ((i) ((v1.t) u1.f.v(qVar2)).getFocusOwner()).f1825h) {
                    return Boolean.TRUE;
                }
                boolean zA = e.A(this.f1857h, this.i, qVar2, (c1.c) this.f1858j);
                Boolean boolValueOf2 = Boolean.valueOf(zA);
                if (zA || !dVar2.a()) {
                    return boolValueOf2;
                }
                return null;
        }
    }
}
