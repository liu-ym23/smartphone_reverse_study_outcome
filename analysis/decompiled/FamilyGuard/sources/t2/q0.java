package t2;

import android.app.Application;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C0521a;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import java.util.List;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class q0 extends C0521a implements Y {

    /* renamed from: c, reason: collision with root package name */
    private b0 f22610c;

    /* renamed from: d, reason: collision with root package name */
    private String f22611d;

    /* renamed from: e, reason: collision with root package name */
    private final A3.b f22612e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f22613f;

    public q0(Application application) {
        super(application);
        this.f22612e = new A3.b();
        this.f22613f = false;
    }

    private b0 Q(v2.e eVar, long j5) {
        return eVar instanceof v2.f ? new a0(this.f22611d, eVar, j5) : new k0(this.f22611d, eVar, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(RawPeriodInfo rawPeriodInfo) {
        this.f22610c.A(rawPeriodInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f22610c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(long j5) {
        this.f22610c.e(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f22610c.m();
        this.f22613f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(RawPeriodInfo rawPeriodInfo) {
        this.f22610c.B(rawPeriodInfo);
    }

    @Override // t2.Y
    public void A(final RawPeriodInfo rawPeriodInfo) {
        this.f22612e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.n0
            @Override // D3.a
            public final void run() {
                this.f22603a.T(rawPeriodInfo);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public void B(final RawPeriodInfo rawPeriodInfo) {
        this.f22612e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.p0
            @Override // D3.a
            public final void run() {
                this.f22608a.X(rawPeriodInfo);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> D() {
        return this.f22610c.D();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> E() {
        return this.f22610c.E();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<List<RawPeriodInfo>> F() {
        return this.f22610c.F();
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        super.J();
        this.f22610c.I();
    }

    public void R(String str, v2.e eVar, long j5) {
        this.f22611d = str;
        this.f22610c = Q(eVar, j5);
    }

    public boolean S() {
        return this.f22610c != null;
    }

    @Override // t2.Y
    public AbstractC0545z<Boolean> b() {
        return this.f22610c.b();
    }

    @Override // t2.Y
    public void e(final long j5) {
        this.f22612e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.o0
            @Override // D3.a
            public final void run() {
                this.f22606a.V(j5);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public void i() {
        if (this.f22613f && j().e().booleanValue()) {
            this.f22612e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.m0
                @Override // D3.a
                public final void run() {
                    this.f22601a.U();
                }
            }, S1.a.b()));
        }
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> j() {
        return this.f22610c.j();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<String> k() {
        return this.f22610c.k();
    }

    @Override // t2.Y
    public void m() {
        if (this.f22613f) {
            return;
        }
        this.f22612e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.l0
            @Override // D3.a
            public final void run() {
                this.f22599a.W();
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> o() {
        return this.f22610c.o();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> p() {
        return this.f22610c.p();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> s() {
        return this.f22610c.s();
    }

    @Override // t2.Y
    public boolean t() {
        return this.f22610c.t();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> u() {
        return this.f22610c.u();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> v() {
        return this.f22610c.v();
    }

    @Override // t2.Y
    public String w() {
        return this.f22610c.w();
    }
}
