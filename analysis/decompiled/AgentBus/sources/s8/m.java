package s8;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9581g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p f9582h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(p pVar, int i2) {
        super(1);
        this.f9581g = i2;
        this.f9582h = pVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f9581g) {
            case 0:
                e9.f fVar = (e9.f) obj;
                q7.k.e(fVar, "it");
                return p.v(this.f9582h, fVar);
            default:
                e9.f fVar2 = (e9.f) obj;
                q7.k.e(fVar2, "it");
                return p.w(this.f9582h, fVar2);
        }
    }
}
