package c0;

import b0.p2;
import b0.s2;
import i1.a1;

/* loaded from: classes.dex */
public final class s extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final s f1760d = new s(0, 3, 1);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        q6.b bVar;
        p2 p2Var = (p2) kVar.c(1);
        b0.a aVar = (b0.a) kVar.c(0);
        c cVar2 = (c) kVar.c(2);
        s2 s2VarH = p2Var.h();
        if (h0Var != null) {
            try {
                bVar = new q6.b(5, h0Var, s2Var);
            } catch (Throwable th) {
                s2VarH.e(false);
                throw th;
            }
        } else {
            bVar = null;
        }
        if (!cVar2.f1729b.S()) {
            b0.s.c("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        cVar2.f1728a.R(cVar, s2VarH, a1Var, bVar);
        s2VarH.e(true);
        s2Var.d();
        aVar.getClass();
        s2Var.x(p2Var, p2Var.a(aVar));
        s2Var.k();
    }
}
