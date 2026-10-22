package c0;

import b0.h1;
import b0.s2;
import i1.a1;

/* loaded from: classes.dex */
public final class f extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final f f1735d = new f(0, 2, 1);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        j0.e eVar = (j0.e) kVar.c(1);
        int i2 = eVar != null ? eVar.f5076a : 0;
        a aVar = (a) kVar.c(0);
        if (i2 > 0) {
            cVar = new h1(cVar, i2);
        }
        aVar.Q(cVar, s2Var, a1Var, h0Var != null ? new q6.b(5, h0Var, s2Var) : null);
    }
}
