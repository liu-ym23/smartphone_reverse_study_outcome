package la;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class d extends ma.e {
    private volatile /* synthetic */ int consumed$volatile;

    /* renamed from: i, reason: collision with root package name */
    public final ka.x f5912i;

    static {
        AtomicIntegerFieldUpdater.newUpdater(d.class, "consumed$volatile");
    }

    public /* synthetic */ d(ka.x xVar) {
        this(xVar, g7.m.f3866f, -3, ka.a.f5661f);
    }

    @Override // ma.e
    public final String a() {
        return "channel=" + this.f5912i;
    }

    @Override // ma.e
    public final Object b(ka.t tVar, g7.d dVar) throws Throwable {
        Object objI = k0.i(new ma.u(tVar), this.f5912i, false, dVar);
        return objI == h7.a.f4212f ? objI : c7.r.f1986a;
    }

    @Override // ma.e
    public final ma.e c(g7.l lVar, int i2, ka.a aVar) {
        return new d(this.f5912i, lVar, i2, aVar);
    }

    @Override // ma.e
    public final j d() {
        return new d(this.f5912i);
    }

    @Override // ma.e
    public final ka.x e(ia.b0 b0Var) {
        return this.f6483g == -3 ? this.f5912i : super.e(b0Var);
    }

    @Override // ma.e, la.j
    public final Object x(k kVar, g7.d dVar) throws Throwable {
        if (this.f6483g == -3) {
            Object objI = k0.i(kVar, this.f5912i, false, dVar);
            if (objI == h7.a.f4212f) {
                return objI;
            }
        } else {
            Object objX = super.x(kVar, dVar);
            if (objX == h7.a.f4212f) {
                return objX;
            }
        }
        return c7.r.f1986a;
    }

    public d(ka.x xVar, g7.l lVar, int i2, ka.a aVar) {
        super(lVar, i2, aVar);
        this.f5912i = xVar;
    }
}
