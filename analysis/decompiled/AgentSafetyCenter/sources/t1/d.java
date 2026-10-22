package t1;

import java.util.HashSet;
import p.a0;
import u1.m;
import v1.t;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public t f13128a;

    /* renamed from: b, reason: collision with root package name */
    public m0.e f13129b;

    /* renamed from: c, reason: collision with root package name */
    public m0.e f13130c;

    /* renamed from: d, reason: collision with root package name */
    public m0.e f13131d;

    /* renamed from: e, reason: collision with root package name */
    public m0.e f13132e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13133f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void b(l lVar, i iVar, HashSet hashSet) {
        if (!lVar.f15114c.f15126r) {
            r1.a.b("visitSubtreeIf called on an unattached node");
        }
        m0.e eVar = new m0.e(new l[16]);
        l lVar2 = lVar.f15114c;
        l lVar3 = lVar2.f15118j;
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
            l lVar4 = (l) eVar.k(i - 1);
            if ((lVar4.f15117h & 32) != 0) {
                for (l lVar5 = lVar4; lVar5 != null; lVar5 = lVar5.f15118j) {
                    if ((lVar5.f15116g & 32) != 0) {
                        m mVarE = lVar5;
                        ?? eVar2 = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof f) {
                                f fVar = (f) mVarE;
                                if (fVar instanceof u1.c) {
                                    u1.c cVar = (u1.c) fVar;
                                    if ((cVar.f13733s instanceof c) && cVar.f13735u.contains(iVar)) {
                                        hashSet.add(fVar);
                                    }
                                }
                                if (fVar.R().d(iVar)) {
                                    break;
                                }
                            } else if ((mVarE.f15116g & 32) != 0 && (mVarE instanceof m)) {
                                l lVar6 = mVarE.f13866t;
                                int i3 = 0;
                                mVarE = mVarE;
                                eVar2 = eVar2;
                                while (lVar6 != null) {
                                    if ((lVar6.f15116g & 32) != 0) {
                                        i3++;
                                        eVar2 = eVar2;
                                        if (i3 == 1) {
                                            mVarE = lVar6;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new m0.e(new l[16]);
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

    public final void a() {
        if (this.f13133f) {
            return;
        }
        this.f13133f = true;
        t tVar = this.f13128a;
        ad.l lVar = new ad.l(this, 24);
        a0 a0Var = tVar.f14574x0;
        if (a0Var.f(lVar) >= 0) {
            return;
        }
        a0Var.a(lVar);
    }
}
