package f8;

/* loaded from: classes.dex */
public final class f0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3477g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e9.c f3478h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(e9.c cVar, int i2) {
        super(1);
        this.f3477g = i2;
        this.f3478h = cVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f3477g) {
            case 0:
                e9.c cVar = (e9.c) obj;
                q7.k.e(cVar, "it");
                return Boolean.valueOf(!cVar.d() && cVar.e().equals(this.f3478h));
            default:
                g8.j jVar = (g8.j) obj;
                q7.k.e(jVar, "it");
                return jVar.b(this.f3478h);
        }
    }
}
