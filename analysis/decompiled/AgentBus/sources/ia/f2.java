package ia;

/* loaded from: classes.dex */
public final class f2 implements g7.j, g7.k {

    /* renamed from: f, reason: collision with root package name */
    public static final f2 f4957f = new f2();

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return g7.i.plus(this, lVar);
    }

    @Override // g7.j
    public final g7.k getKey() {
        return this;
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
