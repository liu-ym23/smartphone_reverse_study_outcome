package t2;

import android.app.Application;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C0521a;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import java.util.List;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class X extends C0521a implements Y {

    /* renamed from: c, reason: collision with root package name */
    private Q f22548c;

    /* renamed from: d, reason: collision with root package name */
    private final A3.b f22549d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f22550e;

    public X(Application application) {
        super(application);
        this.f22549d = new A3.b();
        this.f22550e = false;
    }

    private P Q(v2.e eVar, int i5, long j5) {
        if (eVar instanceof v2.f) {
            return new P(eVar, i5, j5);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(RawPeriodInfo rawPeriodInfo) {
        this.f22548c.A(rawPeriodInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f22548c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(long j5) {
        this.f22548c.e(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f22548c.m();
        this.f22550e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(RawPeriodInfo rawPeriodInfo) {
        this.f22548c.B(rawPeriodInfo);
    }

    @Override // t2.Y
    public void A(final RawPeriodInfo rawPeriodInfo) {
        this.f22549d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.W
            @Override // D3.a
            public final void run() {
                this.f22546a.T(rawPeriodInfo);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public void B(final RawPeriodInfo rawPeriodInfo) {
        this.f22549d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.U
            @Override // D3.a
            public final void run() {
                this.f22543a.X(rawPeriodInfo);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> D() {
        return this.f22548c.D();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> E() {
        return this.f22548c.E();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<List<RawPeriodInfo>> F() {
        return this.f22548c.F();
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        super.J();
        this.f22548c.I();
    }

    public void R(v2.e eVar, int i5, long j5) {
        this.f22548c = Q(eVar, i5, j5);
    }

    public boolean S() {
        return this.f22548c != null;
    }

    @Override // t2.Y
    public AbstractC0545z<Boolean> b() {
        return this.f22548c.b();
    }

    @Override // t2.Y
    public void e(final long j5) {
        this.f22549d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.S
            @Override // D3.a
            public final void run() {
                this.f22540a.V(j5);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public void i() {
        if (this.f22550e && j().e().booleanValue()) {
            this.f22549d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.V
                @Override // D3.a
                public final void run() {
                    this.f22545a.U();
                }
            }, S1.a.b()));
        }
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> j() {
        return this.f22548c.j();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<String> k() {
        return this.f22548c.k();
    }

    @Override // t2.Y
    public void m() {
        if (this.f22550e) {
            return;
        }
        this.f22549d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.T
            @Override // D3.a
            public final void run() {
                this.f22542a.W();
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> o() {
        return this.f22548c.o();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> p() {
        return this.f22548c.p();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> s() {
        return this.f22548c.s();
    }

    @Override // t2.Y
    public boolean t() {
        return this.f22548c.t();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> u() {
        return this.f22548c.u();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> v() {
        return this.f22548c.v();
    }

    @Override // t2.Y
    public String w() {
        return this.f22548c.w();
    }
}
