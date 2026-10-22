package h1;

import i1.f0;
import i1.k;
import j1.y;
import java.util.HashSet;
import k.z;
import n0.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final y f4067a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.e f4068b = new d0.e(new i1.c[16]);

    /* renamed from: c, reason: collision with root package name */
    public final d0.e f4069c = new d0.e(new f[16]);

    /* renamed from: d, reason: collision with root package name */
    public final d0.e f4070d = new d0.e(new f0[16]);

    /* renamed from: e, reason: collision with root package name */
    public final d0.e f4071e = new d0.e(new f[16]);

    /* renamed from: f, reason: collision with root package name */
    public boolean f4072f;

    public c(y yVar) {
        this.f4067a = yVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void b(l lVar, f fVar, HashSet hashSet) {
        if (!lVar.f6797f.f6810s) {
            f1.a.b("visitSubtreeIf called on an unattached node");
        }
        d0.e eVar = new d0.e(new l[16]);
        l lVar2 = lVar.f6797f;
        l lVar3 = lVar2.f6802k;
        if (lVar3 == null) {
            i1.l.b(eVar, lVar2);
        } else {
            eVar.b(lVar3);
        }
        while (true) {
            int i2 = eVar.f2751h;
            if (i2 == 0) {
                return;
            }
            l lVar4 = (l) eVar.j(i2 - 1);
            if ((lVar4.f6800i & 32) != 0) {
                for (l lVar5 = lVar4; lVar5 != null; lVar5 = lVar5.f6802k) {
                    if ((lVar5.f6799h & 32) != 0) {
                        k kVarE = lVar5;
                        ?? eVar2 = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof d) {
                                d dVar = (d) kVarE;
                                if (dVar instanceof i1.c) {
                                    i1.c cVar = (i1.c) dVar;
                                    if ((cVar.f4415t instanceof r.y) && cVar.f4417v.contains(fVar)) {
                                        hashSet.add(dVar);
                                    }
                                }
                                if (dVar.h().j(fVar)) {
                                    break;
                                }
                            } else if ((kVarE.f6799h & 32) != 0 && (kVarE instanceof k)) {
                                l lVar6 = kVarE.f4514u;
                                int i10 = 0;
                                kVarE = kVarE;
                                eVar2 = eVar2;
                                while (lVar6 != null) {
                                    if ((lVar6.f6799h & 32) != 0) {
                                        i10++;
                                        eVar2 = eVar2;
                                        if (i10 == 1) {
                                            kVarE = lVar6;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new d0.e(new l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar2.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar2.b(lVar6);
                                        }
                                    }
                                    lVar6 = lVar6.f6802k;
                                    kVarE = kVarE;
                                    eVar2 = eVar2;
                                }
                                if (i10 == 1) {
                                }
                            }
                            kVarE = i1.l.e(eVar2);
                        }
                    }
                }
            }
            i1.l.b(eVar, lVar4);
        }
    }

    public final void a() {
        if (this.f4072f) {
            return;
        }
        this.f4072f = true;
        a8.c cVar = new a8.c(9, this);
        z zVar = this.f4067a.f5391x0;
        if (zVar.f(cVar) >= 0) {
            return;
        }
        zVar.a(cVar);
    }
}
