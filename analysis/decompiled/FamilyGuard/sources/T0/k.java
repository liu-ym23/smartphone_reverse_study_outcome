package T0;

/* loaded from: classes.dex */
public class k implements e, d {

    /* renamed from: a, reason: collision with root package name */
    private final e f5385a;

    /* renamed from: b, reason: collision with root package name */
    private d f5386b;

    /* renamed from: c, reason: collision with root package name */
    private d f5387c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5388d;

    k() {
        this(null);
    }

    private boolean n() {
        e eVar = this.f5385a;
        return eVar == null || eVar.l(this);
    }

    private boolean o() {
        e eVar = this.f5385a;
        return eVar == null || eVar.i(this);
    }

    private boolean p() {
        e eVar = this.f5385a;
        return eVar == null || eVar.g(this);
    }

    private boolean q() {
        e eVar = this.f5385a;
        return eVar != null && eVar.a();
    }

    @Override // T0.e
    public boolean a() {
        return q() || f();
    }

    @Override // T0.d
    public void b() {
        this.f5386b.b();
        this.f5387c.b();
    }

    @Override // T0.e
    public void c(d dVar) {
        if (dVar.equals(this.f5387c)) {
            return;
        }
        e eVar = this.f5385a;
        if (eVar != null) {
            eVar.c(this);
        }
        if (this.f5387c.m()) {
            return;
        }
        this.f5387c.clear();
    }

    @Override // T0.d
    public void clear() {
        this.f5388d = false;
        this.f5387c.clear();
        this.f5386b.clear();
    }

    @Override // T0.e
    public void d(d dVar) {
        e eVar;
        if (dVar.equals(this.f5386b) && (eVar = this.f5385a) != null) {
            eVar.d(this);
        }
    }

    @Override // T0.d
    public boolean e(d dVar) {
        if (dVar instanceof k) {
            k kVar = (k) dVar;
            d dVar2 = this.f5386b;
            if (dVar2 != null ? dVar2.e(kVar.f5386b) : kVar.f5386b == null) {
                d dVar3 = this.f5387c;
                if (dVar3 == null) {
                    if (kVar.f5387c == null) {
                        return true;
                    }
                } else if (dVar3.e(kVar.f5387c)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // T0.d
    public boolean f() {
        return this.f5386b.f() || this.f5387c.f();
    }

    @Override // T0.e
    public boolean g(d dVar) {
        if (p()) {
            return dVar.equals(this.f5386b) || !this.f5386b.f();
        }
        return false;
    }

    @Override // T0.d
    public boolean h() {
        return this.f5386b.h();
    }

    @Override // T0.e
    public boolean i(d dVar) {
        return o() && dVar.equals(this.f5386b) && !a();
    }

    @Override // T0.d
    public boolean isRunning() {
        return this.f5386b.isRunning();
    }

    @Override // T0.d
    public boolean j() {
        return this.f5386b.j();
    }

    @Override // T0.d
    public void k() {
        this.f5388d = true;
        if (!this.f5386b.m() && !this.f5387c.isRunning()) {
            this.f5387c.k();
        }
        if (!this.f5388d || this.f5386b.isRunning()) {
            return;
        }
        this.f5386b.k();
    }

    @Override // T0.e
    public boolean l(d dVar) {
        return n() && dVar.equals(this.f5386b);
    }

    @Override // T0.d
    public boolean m() {
        return this.f5386b.m() || this.f5387c.m();
    }

    public void r(d dVar, d dVar2) {
        this.f5386b = dVar;
        this.f5387c = dVar2;
    }

    public k(e eVar) {
        this.f5385a = eVar;
    }
}
