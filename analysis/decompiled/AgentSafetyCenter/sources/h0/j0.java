package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f5029c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f5030f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(float f5, long j10) {
        super(1);
        this.f5029c = f5;
        this.f5030f = j10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        f1.d dVar = (f1.d) obj;
        float f5 = this.f5029c;
        float f10 = 2;
        dVar.j(this.f5030f, id.k.d(0.0f, dVar.X(f5) / f10), id.k.d(c1.e.e(dVar.e()), dVar.X(f5) / f10), dVar.X(f5), (496 & 32) != 0 ? null : null);
        return jb.v.f6774a;
    }
}
