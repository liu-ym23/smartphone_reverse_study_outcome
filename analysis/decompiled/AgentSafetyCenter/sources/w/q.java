package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15024c = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f15025f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f15026g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s1.h0 f15027h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f15028j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f15029k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s1.o0 o0Var, s1.e0 e0Var, s1.h0 h0Var, int i, int i3, s sVar) {
        super(1);
        this.i = o0Var;
        this.f15028j = e0Var;
        this.f15027h = h0Var;
        this.f15025f = i;
        this.f15026g = i3;
        this.f15029k = sVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f15024c) {
            case 0:
                p.b((s1.n0) obj, (s1.o0) this.i, (s1.e0) this.f15028j, this.f15027h.getLayoutDirection(), this.f15025f, this.f15026g, ((s) this.f15029k).f15042a);
                break;
            default:
                s1.n0 n0Var = (s1.n0) obj;
                s1.o0[] o0VarArr = (s1.o0[]) this.i;
                v vVar = (v) this.f15028j;
                int[] iArr = (int[]) this.f15029k;
                int length = o0VarArr.length;
                int i = 0;
                int i3 = 0;
                while (i < length) {
                    s1.o0 o0Var = o0VarArr[i];
                    int i10 = i3 + 1;
                    o0Var.getClass();
                    Object objV = o0Var.v();
                    o0 o0Var2 = objV instanceof o0 ? (o0) objV : null;
                    o2.l layoutDirection = this.f15027h.getLayoutDirection();
                    t.c1 c1Var = o0Var2 != null ? o0Var2.f15019c : null;
                    int i11 = this.f15025f;
                    n0Var.g(o0Var, c1Var != null ? c1Var.c(i11 - o0Var.f11277c, layoutDirection, o0Var, this.f15026g) : vVar.f15056b.a(0, i11 - o0Var.f11277c, layoutDirection), iArr[i3], 0.0f);
                    i++;
                    i3 = i10;
                }
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s1.o0[] o0VarArr, v vVar, int i, int i3, s1.h0 h0Var, int[] iArr) {
        super(1);
        this.i = o0VarArr;
        this.f15028j = vVar;
        this.f15025f = i;
        this.f15026g = i3;
        this.f15027h = h0Var;
        this.f15029k = iArr;
    }
}
