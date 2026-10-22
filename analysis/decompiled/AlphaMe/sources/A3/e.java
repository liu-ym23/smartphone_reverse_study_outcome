package A3;

/* loaded from: classes2.dex */
public final class e implements x3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f86a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x3.a f87b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f88c;

    public /* synthetic */ e(b bVar, x3.a aVar, int i4) {
        this.f86a = i4;
        this.f88c = bVar;
        this.f87b = aVar;
    }

    @Override // x3.a
    public final void b() {
        int i4 = this.f86a;
        x3.a aVar = this.f87b;
        b bVar = this.f88c;
        switch (i4) {
            case 0:
                if (!bVar.a()) {
                    aVar.b();
                    break;
                }
                break;
            default:
                if (!bVar.a()) {
                    aVar.b();
                    break;
                }
                break;
        }
    }
}
