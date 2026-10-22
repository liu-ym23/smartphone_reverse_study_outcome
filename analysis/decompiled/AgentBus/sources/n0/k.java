package n0;

/* loaded from: classes.dex */
public interface k extends m {
    @Override // n0.m
    default Object a(Object obj, p7.n nVar) {
        return nVar.invoke(obj, this);
    }

    @Override // n0.m
    default boolean b(p7.k kVar) {
        return ((Boolean) kVar.invoke(this)).booleanValue();
    }
}
