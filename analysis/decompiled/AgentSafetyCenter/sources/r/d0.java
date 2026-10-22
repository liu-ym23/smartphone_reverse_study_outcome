package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10264c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f10265f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f10266g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f10267h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(Object obj, long j10, long j11, Object obj2, int i) {
        super(1);
        this.f10264c = i;
        this.f10267h = obj;
        this.f10265f = j10;
        this.f10266g = j11;
        this.i = obj2;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f10264c) {
            case 0:
                s1.n0 n0Var = (s1.n0) obj;
                s1.o0 o0Var = (s1.o0) this.f10267h;
                long j10 = this.f10265f;
                long j11 = this.f10266g;
                b.g gVar = (b.g) this.i;
                n0Var.getClass();
                s1.n0.b(n0Var, o0Var);
                o0Var.R(o2.i.d(((((int) (j10 >> 32)) + ((int) (j11 >> 32))) << 32) | ((((int) (j10 & 4294967295L)) + ((int) (j11 & 4294967295L))) & 4294967295L), o0Var.i), 0.0f, gVar);
                break;
            default:
                u1.i0 i0Var = (u1.i0) obj;
                i0Var.b();
                f1.d.Q(i0Var, (d1.f0) this.f10267h, this.f10265f, this.f10266g, 0.0f, (td.h) this.i, 104);
                break;
        }
        return jb.v.f6774a;
    }
}
