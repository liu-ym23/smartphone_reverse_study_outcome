package c7;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final e f1147a = new e();

    public static final boolean a(int i8, byte[] a9, int i9, byte[] b9, int i10) {
        kotlin.jvm.internal.p.e(a9, "a");
        kotlin.jvm.internal.p.e(b9, "b");
        for (int i11 = 0; i11 < i10; i11++) {
            if (a9[i11 + i8] != b9[i11 + i9]) {
                return false;
            }
        }
        return true;
    }

    public static final p b(v vVar) {
        kotlin.jvm.internal.p.e(vVar, "<this>");
        return new p(vVar);
    }

    public static void c(long j4, f fVar, int i8, ArrayList arrayList, int i9, int i10, ArrayList arrayList2) {
        int i11;
        int i12;
        ArrayList arrayList3;
        long j8;
        int i13;
        int i14 = i8;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i9 >= i10) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i15 = i9; i15 < i10; i15++) {
            if (((i) arrayList4.get(i15)).c() < i14) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        i iVar = (i) arrayList.get(i9);
        i iVar2 = (i) arrayList4.get(i10 - 1);
        if (i14 == iVar.c()) {
            int iIntValue = ((Number) arrayList5.get(i9)).intValue();
            int i16 = i9 + 1;
            i iVar3 = (i) arrayList4.get(i16);
            i11 = i16;
            i12 = iIntValue;
            iVar = iVar3;
        } else {
            i11 = i9;
            i12 = -1;
        }
        if (iVar.f(i14) == iVar2.f(i14)) {
            int iMin = Math.min(iVar.c(), iVar2.c());
            int i17 = 0;
            for (int i18 = i14; i18 < iMin && iVar.f(i18) == iVar2.f(i18); i18++) {
                i17++;
            }
            long j9 = 4;
            long j10 = (fVar.f1164b / j9) + j4 + 2 + i17 + 1;
            fVar.F(-i17);
            fVar.F(i12);
            int i19 = i14 + i17;
            while (i14 < i19) {
                fVar.F(iVar.f(i14) & 255);
                i14++;
            }
            if (i11 + 1 == i10) {
                if (i19 != ((i) arrayList4.get(i11)).c()) {
                    throw new IllegalStateException("Check failed.");
                }
                fVar.F(((Number) arrayList5.get(i11)).intValue());
                return;
            } else {
                f fVar2 = new f();
                fVar.F(((int) ((fVar2.f1164b / j9) + j10)) * (-1));
                c(j10, fVar2, i19, arrayList4, i11, i10, arrayList5);
                fVar.z(fVar2);
                return;
            }
        }
        int i20 = 1;
        for (int i21 = i11 + 1; i21 < i10; i21++) {
            if (((i) arrayList4.get(i21 - 1)).f(i14) != ((i) arrayList4.get(i21)).f(i14)) {
                i20++;
            }
        }
        long j11 = 4;
        long j12 = (fVar.f1164b / j11) + j4 + 2 + (i20 * 2);
        fVar.F(i20);
        fVar.F(i12);
        for (int i22 = i11; i22 < i10; i22++) {
            int iF = ((i) arrayList4.get(i22)).f(i14);
            if (i22 == i11 || iF != ((i) arrayList4.get(i22 - 1)).f(i14)) {
                fVar.F(iF & 255);
            }
        }
        f fVar3 = new f();
        int i23 = i11;
        while (i23 < i10) {
            byte bF = ((i) arrayList4.get(i23)).f(i14);
            int i24 = i23 + 1;
            int i25 = i24;
            while (true) {
                if (i25 >= i10) {
                    i25 = i10;
                    break;
                } else if (bF != ((i) arrayList4.get(i25)).f(i14)) {
                    break;
                } else {
                    i25++;
                }
            }
            if (i24 == i25 && i14 + 1 == ((i) arrayList4.get(i23)).c()) {
                fVar.F(((Number) arrayList5.get(i23)).intValue());
                arrayList3 = arrayList5;
                j8 = j12;
                i13 = i25;
            } else {
                fVar.F(((int) ((fVar3.f1164b / j11) + j12)) * (-1));
                arrayList3 = arrayList5;
                j8 = j12;
                i13 = i25;
                c(j8, fVar3, i14 + 1, arrayList, i23, i13, arrayList3);
                arrayList4 = arrayList;
            }
            j12 = j8;
            i23 = i13;
            arrayList5 = arrayList3;
        }
        fVar.z(fVar3);
    }

    public static final void d(long j4, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j4 || j4 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j8 + " byteCount=" + j9);
        }
    }

    public static final String e(int i8) {
        if (i8 == 0) {
            return "0";
        }
        char[] cArr = d7.b.f1926a;
        int i9 = 0;
        char[] cArr2 = {cArr[(i8 >> 28) & 15], cArr[(i8 >> 24) & 15], cArr[(i8 >> 20) & 15], cArr[(i8 >> 16) & 15], cArr[(i8 >> 12) & 15], cArr[(i8 >> 8) & 15], cArr[(i8 >> 4) & 15], cArr[i8 & 15]};
        while (i9 < 8 && cArr2[i9] == '0') {
            i9++;
        }
        return x5.u.U0(cArr2, i9, 8);
    }
}
