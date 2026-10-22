package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10243c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.a f10244f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(boolean z10, xb.a aVar) {
        super(1);
        this.f10243c = z10;
        this.f10244f = aVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        d1.g0 g0Var = (d1.g0) obj;
        boolean z10 = !this.f10243c && ((Boolean) this.f10244f.invoke()).booleanValue();
        if (g0Var.f2984o != z10) {
            g0Var.f2975c |= 16384;
            g0Var.f2984o = z10;
        }
        return jb.v.f6774a;
    }
}
