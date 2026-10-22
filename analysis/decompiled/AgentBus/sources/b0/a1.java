package b0;

/* loaded from: classes.dex */
public abstract class a1 {
    public static <R> R fold(c1 c1Var, R r10, p7.n nVar) {
        return (R) g7.i.fold(c1Var, r10, nVar);
    }

    public static <E extends g7.j> E get(c1 c1Var, g7.k kVar) {
        return (E) g7.i.get(c1Var, kVar);
    }

    @Deprecated
    public static g7.k getKey(c1 c1Var) {
        c1Var.getClass();
        return b1.f1107g;
    }

    public static g7.l minusKey(c1 c1Var, g7.k kVar) {
        return g7.i.minusKey(c1Var, kVar);
    }

    public static g7.l plus(c1 c1Var, g7.l lVar) {
        return g7.i.plus(c1Var, lVar);
    }
}
