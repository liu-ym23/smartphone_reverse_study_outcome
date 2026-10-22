package g1;

/* loaded from: classes.dex */
public final class a0 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3698g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h[] f3699h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(h[] hVarArr, int i2) {
        super(2);
        this.f3698g = i2;
        this.f3699h = hVarArr;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3698g) {
            case 0:
                return Float.valueOf(w7.e0.c((r) obj, true, this.f3699h, ((Number) obj2).floatValue()));
            default:
                return Float.valueOf(w7.e0.c((r) obj, false, this.f3699h, ((Number) obj2).floatValue()));
        }
    }
}
