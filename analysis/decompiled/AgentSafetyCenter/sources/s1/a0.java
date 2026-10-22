package s1;

import u1.a2;
import u1.z1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public p.v f11199a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ b0 f11200b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f11201c;

    @Override // s1.w0
    public final int a() {
        u1.g0 g0Var = (u1.g0) this.f11200b.f11211n.g(this.f11201c);
        if (g0Var != null) {
            return ((m0.b) g0Var.m()).f8152c.f8160g;
        }
        return 0;
    }

    @Override // s1.w0
    public final void b(int i, long j10) {
        b0 b0Var = this.f11200b;
        u1.g0 g0Var = (u1.g0) b0Var.f11211n.g(this.f11201c);
        if (g0Var == null || !g0Var.G()) {
            return;
        }
        int i3 = ((m0.b) g0Var.m()).f8152c.f8160g;
        if (i < 0 || i >= i3) {
            r1.a.d("Index (" + i + ") is out of bound of [0, " + i3 + ')');
        }
        if (g0Var.H()) {
            r1.a.a("Pre-measure called on node that is not placed");
        }
        u1.g0 g0Var2 = b0Var.f11203c;
        g0Var2.f13803t = true;
        ((v1.t) u1.j0.a(g0Var)).u((u1.g0) ((m0.b) g0Var.m()).get(i), j10);
        g0Var2.f13803t = false;
        this.f11199a.a(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [n1.h] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // s1.w0
    public final void c(n1.h hVar) {
        u1.c1 c1Var;
        w0.l lVar;
        z1 z1Var;
        u1.g0 g0Var = (u1.g0) this.f11200b.f11211n.g(this.f11201c);
        if (g0Var == null || (c1Var = g0Var.H) == null || (lVar = c1Var.f13746f) == null) {
            return;
        }
        if (!lVar.f15114c.f15126r) {
            r1.a.b("visitSubtreeIf called on an unattached node");
        }
        m0.e eVar = new m0.e(new w0.l[16]);
        w0.l lVar2 = lVar.f15114c;
        w0.l lVar3 = lVar2.f15118j;
        if (lVar3 == null) {
            u1.f.b(eVar, lVar2);
        } else {
            eVar.b(lVar3);
        }
        while (true) {
            int i = eVar.f8160g;
            if (i == 0) {
                return;
            }
            w0.l lVar4 = (w0.l) eVar.k(i - 1);
            if ((lVar4.f15117h & 262144) != 0) {
                for (w0.l lVar5 = lVar4; lVar5 != null; lVar5 = lVar5.f15118j) {
                    if ((lVar5.f15116g & 262144) != 0) {
                        u1.m mVarE = lVar5;
                        ?? eVar2 = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof a2) {
                                a2 a2Var = (a2) mVarE;
                                if ("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode".equals(a2Var.k())) {
                                    hVar.invoke(a2Var);
                                    z1Var = z1.f13978f;
                                } else {
                                    z1Var = z1.f13977c;
                                }
                                if (z1Var == z1.f13979g) {
                                    return;
                                }
                                if (z1Var == z1.f13978f) {
                                    break;
                                }
                            } else if ((mVarE.f15116g & 262144) != 0 && (mVarE instanceof u1.m)) {
                                w0.l lVar6 = mVarE.f13866t;
                                int i3 = 0;
                                mVarE = mVarE;
                                eVar2 = eVar2;
                                while (lVar6 != null) {
                                    if ((lVar6.f15116g & 262144) != 0) {
                                        i3++;
                                        eVar2 = eVar2;
                                        if (i3 == 1) {
                                            mVarE = lVar6;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar2.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar2.b(lVar6);
                                        }
                                    }
                                    lVar6 = lVar6.f15118j;
                                    mVarE = mVarE;
                                    eVar2 = eVar2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            mVarE = u1.f.e(eVar2);
                        }
                    }
                }
            }
            u1.f.b(eVar, lVar4);
        }
    }

    @Override // s1.w0
    public final void dispose() {
        b0 b0Var = this.f11200b;
        Object obj = this.f11201c;
        u1.g0 g0Var = b0Var.f11203c;
        b0Var.d();
        u1.g0 g0Var2 = (u1.g0) b0Var.f11211n.k(obj);
        if (g0Var2 != null) {
            if (b0Var.f11216s <= 0) {
                r1.a.b("No pre-composed items to dispose");
            }
            int i = ((m0.b) g0Var.n()).f8152c.i(g0Var2);
            if (i < ((m0.b) g0Var.n()).f8152c.f8160g - b0Var.f11216s) {
                r1.a.b("Item is not in pre-composed item range");
            }
            b0Var.f11215r++;
            b0Var.f11216s--;
            u uVar = (u) b0Var.f11207j.g(g0Var2);
            if (uVar != null) {
                uVar.getClass();
            }
            int i3 = (((m0.b) g0Var.n()).f8152c.f8160g - b0Var.f11216s) - b0Var.f11215r;
            g0Var.f13803t = true;
            g0Var.K(i, i3, 1);
            g0Var.f13803t = false;
            b0Var.c(i3);
        }
    }
}
