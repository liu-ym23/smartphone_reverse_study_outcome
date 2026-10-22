package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15030c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f15031f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f15032g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f15033h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f15034j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(d1 d1Var, int i, s1.o0 o0Var, int i3, u1.o0 o0Var2) {
        super(1);
        this.f15033h = d1Var;
        this.f15031f = i;
        this.i = o0Var;
        this.f15032g = i3;
        this.f15034j = o0Var2;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [xb.p, yb.l] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        int iRound;
        switch (this.f15030c) {
            case 0:
                s1.n0 n0Var = (s1.n0) obj;
                s1.o0[] o0VarArr = (s1.o0[]) this.f15033h;
                r0 r0Var = (r0) this.i;
                int[] iArr = (int[]) this.f15034j;
                int length = o0VarArr.length;
                int i = 0;
                int i3 = 0;
                while (i < length) {
                    s1.o0 o0Var = o0VarArr[i];
                    int i10 = i3 + 1;
                    o0Var.getClass();
                    Object objV = o0Var.v();
                    o0 o0Var2 = objV instanceof o0 ? (o0) objV : null;
                    t.c1 c1Var = o0Var2 != null ? o0Var2.f15019c : null;
                    int i11 = this.f15031f;
                    if (c1Var != null) {
                        iRound = c1Var.c(i11 - o0Var.f11278f, o2.l.f9123c, o0Var, this.f15032g);
                    } else {
                        iRound = Math.round((1 + r0Var.f15041b.f15105a) * (((i11 - o0Var.f11278f) - 0) / 2.0f));
                    }
                    n0Var.g(o0Var, iArr[i3], iRound, 0.0f);
                    i++;
                    i3 = i10;
                }
                break;
            default:
                ?? r02 = ((d1) this.f15033h).f14965t;
                s1.o0 o0Var3 = (s1.o0) this.i;
                s1.n0.k((s1.n0) obj, o0Var3, ((o2.i) r02.invoke(o2.k.a(ac.a.b(this.f15031f - o0Var3.f11277c, this.f15032g - o0Var3.f11278f)), ((u1.o0) this.f15034j).getLayoutDirection())).f9116a);
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(s1.o0[] o0VarArr, r0 r0Var, int i, int i3, int[] iArr) {
        super(1);
        this.f15033h = o0VarArr;
        this.i = r0Var;
        this.f15031f = i;
        this.f15032g = i3;
        this.f15034j = iArr;
    }
}
