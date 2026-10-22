package l0;

import java.util.ArrayList;
import k0.h2;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final u f7707c = new u(1, 0, 2);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        int[] iArr;
        k0.b bVar;
        int iC;
        int iD = jVar.d(0);
        if (i2Var.f6950n != 0) {
            k0.t.c("Cannot move a group while inserting");
        }
        if (iD < 0) {
            k0.t.c("Parameter offset is out of bounds");
        }
        if (iD == 0) {
            return;
        }
        int i = i2Var.f6956t;
        int i3 = i2Var.f6958v;
        int i10 = i2Var.f6957u;
        int iA = i;
        while (true) {
            iArr = i2Var.f6939b;
            if (iD <= 0) {
                break;
            }
            iA += h2.a(iArr, i2Var.r(iA));
            if (iA > i10) {
                k0.t.c("Parameter offset is out of bounds");
            }
            iD--;
        }
        int iA2 = h2.a(iArr, i2Var.r(iA));
        int iG = i2Var.g(i2Var.f6939b, i2Var.r(i2Var.f6956t));
        int iG2 = i2Var.g(i2Var.f6939b, i2Var.r(iA));
        int i11 = iA + iA2;
        int iG3 = i2Var.g(i2Var.f6939b, i2Var.r(i11));
        int i12 = iG3 - iG2;
        i2Var.w(i12, Math.max(i2Var.f6956t - 1, 0));
        i2Var.v(iA2);
        int[] iArr2 = i2Var.f6939b;
        int iR = i2Var.r(i11) * 5;
        kb.k.f0(i2Var.r(i) * 5, iR, iArr2, iArr2, (iA2 * 5) + iR);
        if (i12 > 0) {
            Object[] objArr = i2Var.f6940c;
            int iH = i2Var.h(iG2 + i12);
            System.arraycopy(objArr, iH, objArr, iG, i2Var.h(iG3 + i12) - iH);
        }
        int i13 = iG2 + i12;
        int i14 = i13 - iG;
        int i15 = i2Var.f6947k;
        int i16 = i2Var.f6948l;
        int length = i2Var.f6940c.length;
        int i17 = i2Var.f6949m;
        int i18 = i + iA2;
        int i19 = i;
        while (i19 < i18) {
            int iR2 = i2Var.r(i19);
            int i20 = i14;
            int[] iArr3 = iArr2;
            iArr3[(iR2 * 5) + 4] = i2.i(i2.i(i2Var.g(iArr2, iR2) - i20, i17 < iR2 ? 0 : i15, i16, length), i2Var.f6947k, i2Var.f6948l, i2Var.f6940c.length);
            i19++;
            i14 = i20;
            iArr2 = iArr3;
            i15 = i15;
        }
        int i21 = i11 + iA2;
        int iP = i2Var.p();
        int iB = h2.b(i2Var.f6941d, i11, iP);
        ArrayList arrayList = new ArrayList();
        if (iB >= 0) {
            while (iB < i2Var.f6941d.size() && (iC = i2Var.c((bVar = (k0.b) i2Var.f6941d.get(iB)))) >= i11 && iC < i21) {
                arrayList.add(bVar);
            }
        }
        int i22 = i - i11;
        int size = arrayList.size();
        for (int i23 = 0; i23 < size; i23++) {
            k0.b bVar2 = (k0.b) arrayList.get(i23);
            int iC2 = i2Var.c(bVar2) + i22;
            if (iC2 >= i2Var.f6944g) {
                bVar2.f6864a = -(iP - iC2);
            } else {
                bVar2.f6864a = iC2;
            }
            i2Var.f6941d.add(h2.b(i2Var.f6941d, iC2, iP), bVar2);
        }
        if (i2Var.H(i11, iA2)) {
            k0.t.c("Unexpectedly removed anchors");
        }
        i2Var.m(i3, i2Var.f6957u, i);
        if (i12 > 0) {
            i2Var.I(i13, i12, i11 - 1);
        }
    }
}
