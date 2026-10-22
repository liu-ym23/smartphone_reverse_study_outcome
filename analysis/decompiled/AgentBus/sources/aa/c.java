package aa;

import q7.k;
import v9.m0;
import v9.n0;
import v9.p0;
import v9.q0;

/* loaded from: classes.dex */
public final class c extends n0 {
    @Override // v9.n0
    public final p0 g(m0 m0Var) {
        k.e(m0Var, "key");
        i9.b bVar = m0Var instanceof i9.b ? (i9.b) m0Var : null;
        if (bVar == null) {
            return null;
        }
        return bVar.b().c() ? new q0(3, bVar.b().b()) : bVar.b();
    }
}
