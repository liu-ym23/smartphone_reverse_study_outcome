package m;

/* loaded from: classes.dex */
public final class s extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f6096g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p7.a f6097h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(boolean z4, p7.a aVar) {
        super(1);
        this.f6096g = z4;
        this.f6097h = aVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        u0.a0 a0Var = (u0.a0) obj;
        boolean z4 = !this.f6096g && ((Boolean) this.f6097h.c()).booleanValue();
        if (a0Var.f9882p != z4) {
            a0Var.f9872f |= 16384;
            a0Var.f9882p = z4;
        }
        return c7.r.f1986a;
    }
}
