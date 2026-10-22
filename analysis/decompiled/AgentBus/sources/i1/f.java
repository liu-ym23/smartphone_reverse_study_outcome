package i1;

import b0.c3;

/* loaded from: classes.dex */
public final class f extends q7.m implements p7.n {

    /* renamed from: h, reason: collision with root package name */
    public static final f f4447h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f4448i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f4449j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f4450k;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4451g;

    static {
        int i2 = 2;
        f4447h = new f(i2, 0);
        f4448i = new f(i2, 1);
        f4449j = new f(i2, 2);
        f4450k = new f(i2, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i2, int i10) {
        super(i2);
        this.f4451g = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4451g) {
            case 0:
                ((Number) obj2).intValue();
                ((h) obj).getClass();
                break;
            case 1:
                g1.p pVar = (g1.p) obj2;
                f0 f0Var = (f0) ((h) obj);
                if (!q7.k.a(f0Var.f4472z, pVar)) {
                    f0Var.f4472z = pVar;
                    f0Var.x();
                }
                break;
            case 2:
                ((f0) ((h) obj)).T((n0.m) obj2);
                break;
            default:
                b0.b0 b0Var = (b0.b0) obj2;
                f0 f0Var2 = (f0) ((h) obj);
                f0Var2.D = b0Var;
                a1 a1Var = f0Var2.H;
                c3 c3Var = j1.g1.f5174h;
                j0.h hVar = (j0.h) b0Var;
                hVar.getClass();
                f0Var2.Q((d2.c) b0.b.o(hVar, c3Var));
                d2.l lVar = (d2.l) b0.b.o(hVar, j1.g1.f5180n);
                if (f0Var2.B != lVar) {
                    f0Var2.B = lVar;
                    f0Var2.x();
                    f0 f0VarN = f0Var2.n();
                    if (f0VarN != null) {
                        f0VarN.v();
                    }
                    f0Var2.w();
                    for (n0.l lVar2 = (n0.l) a1Var.f4404j; lVar2 != null; lVar2 = lVar2.f6802k) {
                        lVar2.W();
                    }
                }
                f0Var2.U((j1.y1) b0.b.o(hVar, j1.g1.f5185s));
                n0.l lVar3 = (n0.l) a1Var.f4404j;
                if ((lVar3.f6800i & 32768) != 0) {
                    while (lVar3 != null) {
                        if ((lVar3.f6799h & 32768) != 0) {
                            k kVarE = lVar3;
                            ?? eVar = 0;
                            while (kVarE != 0) {
                                if (kVarE instanceof i) {
                                    n0.l lVar4 = ((n0.l) ((i) kVarE)).f6797f;
                                    if (lVar4.f6810s) {
                                        e1.c(lVar4);
                                    } else {
                                        lVar4.f6806o = true;
                                    }
                                } else if ((kVarE.f6799h & 32768) != 0 && (kVarE instanceof k)) {
                                    n0.l lVar5 = kVarE.f4514u;
                                    int i2 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar5 != null) {
                                        if ((lVar5.f6799h & 32768) != 0) {
                                            i2++;
                                            eVar = eVar;
                                            if (i2 == 1) {
                                                kVarE = lVar5;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new d0.e(new n0.l[16]);
                                                }
                                                if (kVarE != 0) {
                                                    eVar.b(kVarE);
                                                    kVarE = 0;
                                                }
                                                eVar.b(lVar5);
                                            }
                                        }
                                        lVar5 = lVar5.f6802k;
                                        kVarE = kVarE;
                                        eVar = eVar;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                kVarE = l.e(eVar);
                            }
                        }
                        if ((lVar3.f6800i & 32768) != 0) {
                            lVar3 = lVar3.f6802k;
                        }
                    }
                }
                break;
        }
        return c7.r.f1986a;
    }
}
