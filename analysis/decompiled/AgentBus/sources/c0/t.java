package c0;

import b0.r2;
import b0.s2;
import i1.a1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final t f1761d = new t(1, 0, 2);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        b0.a aVar;
        int iC;
        int iB = kVar.b(0);
        if (s2Var.f1359n != 0) {
            b0.s.c("Cannot move a group while inserting");
        }
        if (iB < 0) {
            b0.s.c("Parameter offset is out of bounds");
        }
        if (iB == 0) {
            return;
        }
        int i2 = s2Var.f1365t;
        int i10 = s2Var.f1367v;
        int i11 = s2Var.f1366u;
        int i12 = i2;
        while (iB > 0) {
            i12 += s2Var.f1347b[(s2Var.q(i12) * 5) + 3];
            if (i12 > i11) {
                b0.s.c("Parameter offset is out of bounds");
            }
            iB--;
        }
        int i13 = s2Var.f1347b[(s2Var.q(i12) * 5) + 3];
        int iG = s2Var.g(s2Var.q(s2Var.f1365t), s2Var.f1347b);
        int iG2 = s2Var.g(s2Var.q(i12), s2Var.f1347b);
        int i14 = i12 + i13;
        int iG3 = s2Var.g(s2Var.q(i14), s2Var.f1347b);
        int i15 = iG3 - iG2;
        s2Var.v(i15, Math.max(s2Var.f1365t - 1, 0));
        s2Var.u(i13);
        int[] iArr = s2Var.f1347b;
        int iQ = s2Var.q(i14) * 5;
        d7.n.W(iArr, iArr, s2Var.q(i2) * 5, iQ, (i13 * 5) + iQ);
        if (i15 > 0) {
            Object[] objArr = s2Var.f1348c;
            int iH = s2Var.h(iG2 + i15);
            System.arraycopy(objArr, iH, objArr, iG, s2Var.h(iG3 + i15) - iH);
        }
        int i16 = iG2 + i15;
        int i17 = i16 - iG;
        int i18 = s2Var.f1356k;
        int i19 = s2Var.f1357l;
        int length = s2Var.f1348c.length;
        int i20 = s2Var.f1358m;
        int i21 = i2 + i13;
        int i22 = i2;
        while (i22 < i21) {
            int iQ2 = s2Var.q(i22);
            int i23 = i17;
            int[] iArr2 = iArr;
            iArr2[(iQ2 * 5) + 4] = s2.i(s2.i(s2Var.g(iQ2, iArr) - i23, i20 < iQ2 ? 0 : i18, i19, length), s2Var.f1356k, s2Var.f1357l, s2Var.f1348c.length);
            i22++;
            i17 = i23;
            iArr = iArr2;
            i18 = i18;
        }
        int i24 = i14 + i13;
        int iO = s2Var.o();
        int iB2 = r2.b(s2Var.f1349d, i14, iO);
        ArrayList arrayList = new ArrayList();
        if (iB2 >= 0) {
            while (iB2 < s2Var.f1349d.size() && (iC = s2Var.c((aVar = (b0.a) s2Var.f1349d.get(iB2)))) >= i14 && iC < i24) {
                arrayList.add(aVar);
            }
        }
        int i25 = i2 - i14;
        int size = arrayList.size();
        for (int i26 = 0; i26 < size; i26++) {
            b0.a aVar2 = (b0.a) arrayList.get(i26);
            int iC2 = s2Var.c(aVar2) + i25;
            if (iC2 >= s2Var.f1352g) {
                aVar2.f1096a = -(iO - iC2);
            } else {
                aVar2.f1096a = iC2;
            }
            s2Var.f1349d.add(r2.b(s2Var.f1349d, iC2, iO), aVar2);
        }
        if (s2Var.F(i14, i13)) {
            b0.s.c("Unexpectedly removed anchors");
        }
        s2Var.m(i10, s2Var.f1366u, i2);
        if (i15 > 0) {
            s2Var.G(i16, i15, i14 - 1);
        }
    }
}
