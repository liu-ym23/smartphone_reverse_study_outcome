package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5141c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5142f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5143g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5144h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(int i, s1.o0 o0Var, int i3) {
        super(1);
        this.f5141c = 0;
        this.f5143g = i;
        this.f5142f = o0Var;
        this.f5144h = i3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        jb.v vVar;
        int i = this.f5141c;
        jb.v vVar2 = jb.v.f6774a;
        int i3 = this.f5144h;
        int i10 = this.f5143g;
        Object obj2 = this.f5142f;
        switch (i) {
            case 0:
                ((s1.n0) obj).g((s1.o0) obj2, ac.a.Q((i10 - r0.f11277c) / 2.0f), ac.a.Q((i3 - r0.f11278f) / 2.0f), 0.0f);
                break;
            case 1:
                s1.n0.m((s1.n0) obj, (s1.o0) obj2, i10, i3);
                break;
            case 2:
                ((s1.n0) obj).g((s1.o0) obj2, i10, i3, 0.0f);
                break;
            default:
                s1.n0 n0Var = (s1.n0) obj;
                s1.o0[] o0VarArr = (s1.o0[]) obj2;
                int length = o0VarArr.length;
                int i11 = 0;
                while (i11 < length) {
                    s1.o0 o0Var = o0VarArr[i11];
                    if (o0Var != null) {
                        long jB = ac.a.b(o0Var.f11277c, o0Var.f11278f);
                        long jB2 = ac.a.b(i10, i3);
                        o2.l lVar = o2.l.f9123c;
                        vVar = vVar2;
                        float f5 = (((int) (jB2 >> 32)) - ((int) (jB >> 32))) / 2.0f;
                        float f10 = (((int) (jB2 & 4294967295L)) - ((int) (jB & 4294967295L))) / 2.0f;
                        o2.l lVar2 = o2.l.f9123c;
                        float f11 = 1;
                        int iRound = Math.round((f11 - 1.0f) * f5);
                        long jRound = (Math.round((f11 - 1.0f) * f10) & 4294967295L) | (iRound << 32);
                        n0Var.g(o0Var, (int) (jRound >> 32), (int) (jRound & 4294967295L), 0.0f);
                    } else {
                        vVar = vVar2;
                    }
                    i11++;
                    vVar2 = vVar;
                }
                break;
        }
        return vVar2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(s1.o0 o0Var, int i, int i3, int i10) {
        super(1);
        this.f5141c = i10;
        this.f5142f = o0Var;
        this.f5143g = i;
        this.f5144h = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(s1.o0[] o0VarArr, r.j jVar, int i, int i3) {
        super(1);
        this.f5141c = 3;
        this.f5142f = o0VarArr;
        this.f5143g = i;
        this.f5144h = i3;
    }
}
