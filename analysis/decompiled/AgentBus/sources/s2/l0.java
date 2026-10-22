package s2;

/* loaded from: classes.dex */
public final class l0 implements g7.j {

    /* renamed from: f, reason: collision with root package name */
    public final l0 f9400f;

    /* renamed from: g, reason: collision with root package name */
    public final z f9401g;

    public l0(l0 l0Var, z zVar) {
        this.f9400f = l0Var;
        this.f9401g = zVar;
    }

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return g7.i.plus(this, lVar);
    }

    public final void c(z zVar) {
        if (this.f9401g == zVar) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        l0 l0Var = this.f9400f;
        if (l0Var != null) {
            l0Var.c(zVar);
        }
    }

    @Override // g7.j
    public final g7.k getKey() {
        return k0.f9398f;
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
