package o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f4295a = new boolean[3];

    /* JADX WARN: Removed duplicated region for block: B:188:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x06d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x06f2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(o.e r40, m.c r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instructions count: 1791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.j.a(o.e, m.c, java.util.ArrayList, int):void");
    }

    public static void b(e eVar, m.c cVar, d dVar) {
        dVar.f4236n = -1;
        c cVar2 = dVar.L;
        int[] iArr = dVar.f4239o0;
        c cVar3 = dVar.K;
        c cVar4 = dVar.I;
        c cVar5 = dVar.J;
        c cVar6 = dVar.H;
        dVar.f4238o = -1;
        int[] iArr2 = eVar.f4239o0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i8 = cVar6.f4209g;
            int iN = eVar.n() - cVar5.f4209g;
            cVar6.f4211i = cVar.k(cVar6);
            cVar5.f4211i = cVar.k(cVar5);
            cVar.d(cVar6.f4211i, i8);
            cVar.d(cVar5.f4211i, iN);
            dVar.f4236n = 2;
            dVar.X = i8;
            int i9 = iN - i8;
            dVar.T = i9;
            int i10 = dVar.f4213a0;
            if (i9 < i10) {
                dVar.T = i10;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i11 = cVar4.f4209g;
        int iK = eVar.k() - cVar3.f4209g;
        cVar4.f4211i = cVar.k(cVar4);
        cVar3.f4211i = cVar.k(cVar3);
        cVar.d(cVar4.f4211i, i11);
        cVar.d(cVar3.f4211i, iK);
        if (dVar.Z > 0 || dVar.f4222f0 == 8) {
            m.g gVarK = cVar.k(cVar2);
            cVar2.f4211i = gVarK;
            cVar.d(gVarK, dVar.Z + i11);
        }
        dVar.f4238o = 2;
        dVar.Y = i11;
        int i12 = iK - i11;
        dVar.U = i12;
        int i13 = dVar.f4215b0;
        if (i12 < i13) {
            dVar.U = i13;
        }
    }

    public static final boolean c(int i8, int i9) {
        return (i8 & i9) == i9;
    }
}
