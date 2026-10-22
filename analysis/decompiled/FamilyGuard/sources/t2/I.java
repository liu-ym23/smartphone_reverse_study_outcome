package t2;

import android.app.Application;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C0521a;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import java.util.List;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class I extends C0521a implements InterfaceC1136p {

    /* renamed from: c, reason: collision with root package name */
    private r f22506c;

    /* renamed from: d, reason: collision with root package name */
    private int f22507d;

    /* renamed from: e, reason: collision with root package name */
    private final A3.b f22508e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f22509f;

    public I(Application application) {
        super(application);
        this.f22508e = new A3.b();
        this.f22509f = false;
    }

    private r R(v2.e eVar, long j5) {
        return eVar instanceof v2.f ? new C1137q(this.f22507d, eVar, j5) : new C1118B(this.f22507d, eVar, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(RawPeriodInfo rawPeriodInfo) {
        this.f22506c.A(rawPeriodInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f22506c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(long j5) {
        this.f22506c.e(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(int i5) {
        this.f22506c.y(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        this.f22506c.m();
        this.f22509f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(RawPeriodInfo rawPeriodInfo) {
        this.f22506c.B(rawPeriodInfo);
    }

    @Override // t2.Y
    public void A(final RawPeriodInfo rawPeriodInfo) {
        this.f22508e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.F
            @Override // D3.a
            public final void run() {
                this.f22501a.U(rawPeriodInfo);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public void B(final RawPeriodInfo rawPeriodInfo) {
        this.f22508e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.C
            @Override // D3.a
            public final void run() {
                this.f22496a.Z(rawPeriodInfo);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> D() {
        return this.f22506c.D();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> E() {
        return this.f22506c.E();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<List<RawPeriodInfo>> F() {
        return this.f22506c.F();
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        super.J();
        this.f22506c.I();
    }

    public androidx.lifecycle.B<Category> S() {
        return this.f22506c.J();
    }

    public void T(int i5, v2.e eVar, long j5) {
        this.f22507d = i5;
        this.f22506c = R(eVar, j5);
    }

    @Override // t2.Y
    public AbstractC0545z<Boolean> b() {
        return this.f22506c.b();
    }

    @Override // t2.Y
    public void e(final long j5) {
        this.f22508e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.D
            @Override // D3.a
            public final void run() {
                this.f22498a.W(j5);
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public void i() {
        if (this.f22509f && j().e().booleanValue()) {
            this.f22508e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.H
                @Override // D3.a
                public final void run() {
                    this.f22505a.V();
                }
            }, S1.a.b()));
        }
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> j() {
        return this.f22506c.j();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<String> k() {
        return this.f22506c.k();
    }

    @Override // t2.Y
    public void m() {
        if (this.f22509f) {
            return;
        }
        this.f22508e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.E
            @Override // D3.a
            public final void run() {
                this.f22500a.Y();
            }
        }, S1.a.b()));
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> o() {
        return this.f22506c.o();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> p() {
        return this.f22506c.p();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> s() {
        return this.f22506c.s();
    }

    @Override // t2.Y
    public boolean t() {
        return this.f22506c.t();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Boolean> u() {
        return this.f22506c.u();
    }

    @Override // t2.Y
    public androidx.lifecycle.B<Long> v() {
        return this.f22506c.v();
    }

    @Override // t2.Y
    public String w() {
        return this.f22506c.w();
    }

    @Override // t2.InterfaceC1136p
    public void y(final int i5) {
        this.f22508e.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: t2.G
            @Override // D3.a
            public final void run() {
                this.f22503a.X(i5);
            }
        }, S1.a.b()));
    }
}
