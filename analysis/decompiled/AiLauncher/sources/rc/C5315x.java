package rc;

/* renamed from: rc.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5315x {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC5276d f39433a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39434b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f39435c = -1;

    public C5315x(AbstractC5276d abstractC5276d) {
        this.f39433a = abstractC5276d;
    }

    public void a(E e10) {
        this.f39434b = false;
        this.f39435c = -1;
        this.f39433a = e10;
    }

    public AbstractC5284h b(Y0 y02) {
        if (this.f39434b) {
            ((AbstractC5300p) this.f39433a).k();
        }
        AbstractC5284h abstractC5284hF = this.f39433a.f(y02);
        if (this.f39434b) {
            ((AbstractC5300p) this.f39433a).n();
        }
        return abstractC5284hF;
    }

    public C5298o c(Z0 z02) {
        return ((AbstractC5300p) this.f39433a).i(z02);
    }

    public int d() {
        int i10 = this.f39435c;
        return i10 >= 0 ? i10 : this.f39433a.g();
    }

    public int e() {
        int i10 = this.f39435c;
        return i10 >= 0 ? i10 : this.f39433a.h();
    }

    public boolean f() {
        AbstractC5276d abstractC5276d = this.f39433a;
        return (abstractC5276d instanceof C5294m) && ((C5294m) abstractC5276d).q();
    }

    public boolean g() {
        return this.f39433a instanceof AbstractC5300p;
    }

    public boolean h() {
        return this.f39433a instanceof R0;
    }

    public void i() {
        this.f39434b = true;
    }

    public void j(C5315x c5315x) {
        Cloneable cloneable = this.f39433a;
        if (cloneable instanceof H0) {
            ((H0) cloneable).a(c5315x);
        }
    }

    public void k(int i10) {
        this.f39435c = i10;
    }
}
