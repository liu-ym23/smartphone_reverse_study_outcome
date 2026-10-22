package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public n f15548a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f15549b;

    public static long a(e eVar, long j10) {
        n nVar = eVar.f15537d;
        ArrayList arrayList = eVar.f15543k;
        if (nVar instanceof i) {
            return j10;
        }
        int size = arrayList.size();
        long jMin = j10;
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof e) {
                e eVar2 = (e) dVar;
                if (eVar2.f15537d != nVar) {
                    jMin = Math.min(jMin, a(eVar2, eVar2.f15539f + j10));
                }
            }
        }
        e eVar3 = nVar.i;
        e eVar4 = nVar.f15565h;
        if (eVar != eVar3) {
            return jMin;
        }
        long j11 = j10 - nVar.j();
        return Math.min(Math.min(jMin, a(eVar4, j11)), j11 - eVar4.f15539f);
    }

    public static long b(e eVar, long j10) {
        n nVar = eVar.f15537d;
        ArrayList arrayList = eVar.f15543k;
        if (nVar instanceof i) {
            return j10;
        }
        int size = arrayList.size();
        long jMax = j10;
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof e) {
                e eVar2 = (e) dVar;
                if (eVar2.f15537d != nVar) {
                    jMax = Math.max(jMax, b(eVar2, eVar2.f15539f + j10));
                }
            }
        }
        e eVar3 = nVar.f15565h;
        e eVar4 = nVar.i;
        if (eVar != eVar3) {
            return jMax;
        }
        long j11 = nVar.j() + j10;
        return Math.max(Math.max(jMax, b(eVar4, j11)), j11 - eVar4.f15539f);
    }
}
