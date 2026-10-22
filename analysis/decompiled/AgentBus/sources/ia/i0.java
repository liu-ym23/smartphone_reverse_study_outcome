package ia;

/* loaded from: classes.dex */
public abstract class i0 {
    @c7.a
    public static Object delay(j0 j0Var, long j2, g7.d dVar) {
        if (j2 > 0) {
            m mVar = new m(1, ib.k.C(dVar));
            mVar.s();
            j0Var.k(j2, mVar);
            Object objR = mVar.r();
            if (objR == h7.a.f4212f) {
                return objR;
            }
        }
        return c7.r.f1986a;
    }

    public static p0 invokeOnTimeout(j0 j0Var, long j2, Runnable runnable, g7.l lVar) {
        return f0.f4956a.C(j2, runnable, lVar);
    }
}
