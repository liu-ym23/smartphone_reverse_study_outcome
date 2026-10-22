package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13731c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f13732f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, int i) {
        super(0);
        this.f13731c = i;
        this.f13732f = cVar;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f13731c) {
            case 0:
                this.f13732f.D0();
                break;
            default:
                c cVar = this.f13732f;
                w0.k kVar = cVar.f13733s;
                kVar.getClass();
                ((t1.c) kVar).e(cVar);
                break;
        }
        return jb.v.f6774a;
    }
}
