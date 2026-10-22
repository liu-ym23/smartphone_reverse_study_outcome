package ia;

/* loaded from: classes.dex */
public abstract class x extends g7.a implements g7.g {

    /* renamed from: g, reason: collision with root package name */
    public static final w f5021g = new w(g7.f.f3865f, new c6.d(18));

    public x() {
        super(g7.f.f3865f);
    }

    public abstract void R(g7.l lVar, Runnable runnable);

    public boolean S(g7.l lVar) {
        return !(this instanceof d2);
    }

    public x T(int i2) {
        na.b.a(i2);
        return new na.h(this, i2);
    }

    @Override // g7.a, g7.l
    public final g7.j o(g7.k kVar) {
        return g7.e.get(this, kVar);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + d0.k(this);
    }

    @Override // g7.a, g7.l
    public final g7.l z(g7.k kVar) {
        return g7.e.minusKey(this, kVar);
    }
}
