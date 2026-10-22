package c0;

import b0.l2;
import b0.s2;
import i1.a1;

/* loaded from: classes.dex */
public final class e extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final e f1733d = new e(0, 2, 1);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        b0.a aVar = (b0.a) kVar.c(0);
        Object objC = kVar.c(1);
        if (objC instanceof l2) {
            l2 l2Var = (l2) objC;
            a1Var.f4397c.b(l2Var);
            ((k.b0) a1Var.f4401g).a(l2Var);
        }
        if (s2Var.f1359n != 0) {
            b0.s.c("Can only append a slot if not current inserting");
        }
        int i2 = s2Var.f1354i;
        int i10 = s2Var.f1355j;
        int iC = s2Var.c(aVar);
        int iG = s2Var.g(s2Var.q(iC + 1), s2Var.f1347b);
        s2Var.f1354i = iG;
        s2Var.f1355j = iG;
        s2Var.v(1, iC);
        if (i2 >= iG) {
            i2++;
            i10++;
        }
        s2Var.f1348c[iG] = objC;
        s2Var.f1354i = i2;
        s2Var.f1355j = i10;
    }
}
