package p;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public o f4624a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f4625b;

    public static long a(f fVar, long j4) {
        o oVar = fVar.d;
        ArrayList arrayList = fVar.f4619k;
        if (oVar instanceof j) {
            return j4;
        }
        int size = arrayList.size();
        long jMin = j4;
        for (int i8 = 0; i8 < size; i8++) {
            d dVar = (d) arrayList.get(i8);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != oVar) {
                    jMin = Math.min(jMin, a(fVar2, fVar2.f4614f + j4));
                }
            }
        }
        f fVar3 = oVar.f4640i;
        f fVar4 = oVar.f4639h;
        if (fVar != fVar3) {
            return jMin;
        }
        long j8 = j4 - oVar.j();
        return Math.min(Math.min(jMin, a(fVar4, j8)), j8 - fVar4.f4614f);
    }

    public static long b(f fVar, long j4) {
        o oVar = fVar.d;
        ArrayList arrayList = fVar.f4619k;
        if (oVar instanceof j) {
            return j4;
        }
        int size = arrayList.size();
        long jMax = j4;
        for (int i8 = 0; i8 < size; i8++) {
            d dVar = (d) arrayList.get(i8);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != oVar) {
                    jMax = Math.max(jMax, b(fVar2, fVar2.f4614f + j4));
                }
            }
        }
        f fVar3 = oVar.f4639h;
        f fVar4 = oVar.f4640i;
        if (fVar != fVar3) {
            return jMax;
        }
        long j8 = oVar.j() + j4;
        return Math.max(Math.max(jMax, b(fVar4, j8)), j8 - fVar4.f4614f);
    }
}
