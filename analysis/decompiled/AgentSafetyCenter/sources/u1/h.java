package u1;

import k0.s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends yb.l implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public static final h f13818f;

    /* renamed from: g, reason: collision with root package name */
    public static final h f13819g;

    /* renamed from: h, reason: collision with root package name */
    public static final h f13820h;
    public static final h i;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13821c;

    static {
        int i3 = 2;
        f13818f = new h(i3, 0);
        f13819g = new h(i3, 1);
        f13820h = new h(i3, 2);
        i = new h(i3, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i3, int i10) {
        super(i3);
        this.f13821c = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f13821c) {
            case 0:
                ((Number) obj2).intValue();
                ((j) obj).getClass();
                break;
            case 1:
                ((g0) ((j) obj)).c0((s1.f0) obj2);
                break;
            case 2:
                ((g0) ((j) obj)).d0((w0.m) obj2);
                break;
            default:
                k0.c0 c0Var = (k0.c0) obj2;
                g0 g0Var = (g0) ((j) obj);
                g0Var.D = c0Var;
                c1 c1Var = g0Var.H;
                s2 s2Var = v1.a1.f14363h;
                s0.g gVar = (s0.g) c0Var;
                gVar.getClass();
                g0Var.Z((o2.c) k0.z.x(gVar, s2Var));
                o2.l lVar = (o2.l) k0.z.x(gVar, v1.a1.f14368n);
                if (g0Var.B != lVar) {
                    g0Var.B = lVar;
                    g0Var.C();
                    g0 g0VarT = g0Var.t();
                    if (g0VarT != null) {
                        g0VarT.A();
                    }
                    g0Var.B();
                    for (w0.l lVar2 = c1Var.f13746f; lVar2 != null; lVar2 = lVar2.f15118j) {
                        lVar2.L();
                    }
                }
                g0Var.e0((v1.u1) k0.z.x(gVar, v1.a1.f14373s));
                w0.l lVar3 = c1Var.f13746f;
                if ((lVar3.f15117h & 32768) != 0) {
                    while (lVar3 != null) {
                        if ((lVar3.f15116g & 32768) != 0) {
                            m mVarE = lVar3;
                            ?? eVar = 0;
                            while (mVarE != 0) {
                                if (mVarE instanceof k) {
                                    w0.l lVar4 = ((w0.l) ((k) mVarE)).f15114c;
                                    if (lVar4.f15126r) {
                                        h1.c(lVar4);
                                    } else {
                                        lVar4.f15122n = true;
                                    }
                                } else if ((mVarE.f15116g & 32768) != 0 && (mVarE instanceof m)) {
                                    w0.l lVar5 = mVarE.f13866t;
                                    int i3 = 0;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                    while (lVar5 != null) {
                                        if ((lVar5.f15116g & 32768) != 0) {
                                            i3++;
                                            eVar = eVar;
                                            if (i3 == 1) {
                                                mVarE = lVar5;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new m0.e(new w0.l[16]);
                                                }
                                                if (mVarE != 0) {
                                                    eVar.b(mVarE);
                                                    mVarE = 0;
                                                }
                                                eVar.b(lVar5);
                                            }
                                        }
                                        lVar5 = lVar5.f15118j;
                                        mVarE = mVarE;
                                        eVar = eVar;
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                mVarE = f.e(eVar);
                            }
                        }
                        if ((lVar3.f15117h & 32768) != 0) {
                            lVar3 = lVar3.f15118j;
                        }
                    }
                }
                break;
        }
        return jb.v.f6774a;
    }
}
