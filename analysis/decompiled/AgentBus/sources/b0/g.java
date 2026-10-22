package b0;

/* loaded from: classes.dex */
public final class g implements g7.j {

    /* renamed from: f, reason: collision with root package name */
    public static final b1 f1151f = new b1(5);

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return g7.i.plus(this, lVar);
    }

    @Override // g7.j
    public final g7.k getKey() {
        return f1151f;
    }

    @Override // g7.l
    public final g7.j o(g7.k kVar) {
        return g7.i.get(this, kVar);
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return g7.i.fold(this, obj, nVar);
    }

    @Override // g7.l
    public final g7.l z(g7.k kVar) {
        return g7.i.minusKey(this, kVar);
    }
}
