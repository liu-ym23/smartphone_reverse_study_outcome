package g7;

/* loaded from: classes.dex */
public abstract class i {
    public static <R> R fold(j jVar, R r10, p7.n nVar) {
        q7.k.e(nVar, "operation");
        return (R) nVar.invoke(r10, jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends j> E get(j jVar, k kVar) {
        q7.k.e(kVar, "key");
        if (q7.k.a(jVar.getKey(), kVar)) {
            return jVar;
        }
        return null;
    }

    public static l minusKey(j jVar, k kVar) {
        q7.k.e(kVar, "key");
        return q7.k.a(jVar.getKey(), kVar) ? m.f3866f : jVar;
    }

    public static l plus(j jVar, l lVar) {
        q7.k.e(lVar, "context");
        return h.plus(jVar, lVar);
    }
}
