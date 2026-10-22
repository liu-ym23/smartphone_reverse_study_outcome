package c0;

import b0.s2;
import i1.a1;

/* loaded from: classes.dex */
public final class y extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final y f1766d = new y(0, 0, 3);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        if (s2Var.f1359n != 0) {
            b0.s.c("Cannot reset when inserting");
        }
        s2Var.D();
        s2Var.f1365t = 0;
        s2Var.f1366u = s2Var.n() - s2Var.f1353h;
        s2Var.f1354i = 0;
        s2Var.f1355j = 0;
        s2Var.f1360o = 0;
    }
}
