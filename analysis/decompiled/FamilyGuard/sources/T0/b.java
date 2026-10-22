package T0;

/* loaded from: classes.dex */
public final class b implements e, d {

    /* renamed from: a, reason: collision with root package name */
    private final e f5334a;

    /* renamed from: b, reason: collision with root package name */
    private d f5335b;

    /* renamed from: c, reason: collision with root package name */
    private d f5336c;

    public b(e eVar) {
        this.f5334a = eVar;
    }

    private boolean n(d dVar) {
        if (dVar.equals(this.f5335b)) {
            return true;
        }
        return this.f5335b.h() && dVar.equals(this.f5336c);
    }

    private boolean o() {
        e eVar = this.f5334a;
        return eVar == null || eVar.l(this);
    }

    private boolean p() {
        e eVar = this.f5334a;
        return eVar == null || eVar.i(this);
    }

    private boolean q() {
        e eVar = this.f5334a;
        return eVar == null || eVar.g(this);
    }

    private boolean r() {
        e eVar = this.f5334a;
        return eVar != null && eVar.a();
    }

    @Override // T0.e
    public boolean a() {
        return r() || f();
    }

    @Override // T0.d
    public void b() {
        this.f5335b.b();
        this.f5336c.b();
    }

    @Override // T0.e
    public void c(d dVar) {
        e eVar = this.f5334a;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    @Override // T0.d
    public void clear() {
        this.f5335b.clear();
        if (this.f5336c.isRunning()) {
            this.f5336c.clear();
        }
    }

    @Override // T0.e
    public void d(d dVar) {
        if (!dVar.equals(this.f5336c)) {
            if (this.f5336c.isRunning()) {
                return;
            }
            this.f5336c.k();
        } else {
            e eVar = this.f5334a;
            if (eVar != null) {
                eVar.d(this);
            }
        }
    }

    @Override // T0.d
    public boolean e(d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            if (this.f5335b.e(bVar.f5335b) && this.f5336c.e(bVar.f5336c)) {
                return true;
            }
        }
        return false;
    }

    @Override // T0.d
    public boolean f() {
        return (this.f5335b.h() ? this.f5336c : this.f5335b).f();
    }

    @Override // T0.e
    public boolean g(d dVar) {
        return q() && n(dVar);
    }

    @Override // T0.d
    public boolean h() {
        return this.f5335b.h() && this.f5336c.h();
    }

    @Override // T0.e
    public boolean i(d dVar) {
        return p() && n(dVar);
    }

    @Override // T0.d
    public boolean isRunning() {
        return (this.f5335b.h() ? this.f5336c : this.f5335b).isRunning();
    }

    @Override // T0.d
    public boolean j() {
        return (this.f5335b.h() ? this.f5336c : this.f5335b).j();
    }

    @Override // T0.d
    public void k() {
        if (this.f5335b.isRunning()) {
            return;
        }
        this.f5335b.k();
    }

    @Override // T0.e
    public boolean l(d dVar) {
        return o() && n(dVar);
    }

    @Override // T0.d
    public boolean m() {
        return (this.f5335b.h() ? this.f5336c : this.f5335b).m();
    }

    public void s(d dVar, d dVar2) {
        this.f5335b = dVar;
        this.f5336c = dVar2;
    }
}
