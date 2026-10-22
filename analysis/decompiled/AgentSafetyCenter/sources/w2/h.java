package w2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f15213a = new boolean[3];

    /* JADX WARN: Removed duplicated region for block: B:189:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x06c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x06df A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(w2.f r40, u2.c r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instructions count: 1772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.h.a(w2.f, u2.c, java.util.ArrayList, int):void");
    }

    public static void b(f fVar, u2.c cVar, e eVar) {
        eVar.f15183o = -1;
        d dVar = eVar.L;
        int[] iArr = eVar.f15184o0;
        d dVar2 = eVar.K;
        d dVar3 = eVar.I;
        d dVar4 = eVar.J;
        d dVar5 = eVar.H;
        eVar.f15185p = -1;
        int[] iArr2 = fVar.f15184o0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = dVar5.f15156g;
            int iO = fVar.o() - dVar4.f15156g;
            dVar5.i = cVar.k(dVar5);
            dVar4.i = cVar.k(dVar4);
            cVar.d(dVar5.i, i);
            cVar.d(dVar4.i, iO);
            eVar.f15183o = 2;
            eVar.X = i;
            int i3 = iO - i;
            eVar.T = i3;
            int i10 = eVar.f15159a0;
            if (i3 < i10) {
                eVar.T = i10;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i11 = dVar3.f15156g;
        int i12 = fVar.i() - dVar2.f15156g;
        dVar3.i = cVar.k(dVar3);
        dVar2.i = cVar.k(dVar2);
        cVar.d(dVar3.i, i11);
        cVar.d(dVar2.i, i12);
        if (eVar.Z > 0 || eVar.f0 == 8) {
            u2.e eVarK = cVar.k(dVar);
            dVar.i = eVarK;
            cVar.d(eVarK, eVar.Z + i11);
        }
        eVar.f15185p = 2;
        eVar.Y = i11;
        int i13 = i12 - i11;
        eVar.U = i13;
        int i14 = eVar.f15161b0;
        if (i13 < i14) {
            eVar.U = i14;
        }
    }

    public static final boolean c(int i, int i3) {
        return (i & i3) == i3;
    }
}
