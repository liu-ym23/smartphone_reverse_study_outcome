package w2;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C0521a;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import java.util.List;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class F1 extends C0521a implements U0 {

    /* renamed from: c, reason: collision with root package name */
    private q1 f23558c;

    /* renamed from: d, reason: collision with root package name */
    private final A3.b f23559d;

    public F1(Application application) {
        super(application);
        this.f23559d = new A3.b();
    }

    private q1 T(v2.e eVar) {
        return eVar instanceof v2.f ? new p1(eVar) : new w1(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23558c.f(context, aVar, dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23558c.h(context, aVar, dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23558c.l(aVar, dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23558c.d(aVar, dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23558c.n(aVar, dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(com.stepos.digitalwellbeing.server.data.a aVar) {
        this.f23558c.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23558c.z(aVar, dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        this.f23558c.a();
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        super.J();
        this.f23558c.I();
        this.f23559d.dispose();
        this.f23559d.d();
    }

    public AbstractC0545z<List<C1216d>> U(Context context) {
        return this.f23558c.J(context);
    }

    public AbstractC0545z<List<C1257w>> V(Context context) {
        return this.f23558c.K(context);
    }

    public AbstractC0545z<NotificationTimesStats[]> W() {
        return this.f23558c.L();
    }

    public AbstractC0545z<PackageNotificationTimesStats[]> X() {
        return this.f23558c.M();
    }

    public AbstractC0545z<PickupTimesStats[]> Y() {
        return this.f23558c.N();
    }

    public AbstractC0545z<DataToken> Z() {
        return this.f23558c.O();
    }

    @Override // w2.U0
    public void a() {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.x1
            @Override // D3.a
            public final void run() {
                this.f23683a.i0();
            }
        }, S1.a.b()));
    }

    public AbstractC0545z<UsingTimeStats[]> a0() {
        return this.f23558c.P();
    }

    public AbstractC0545z<Boolean> b() {
        return this.f23558c.b();
    }

    @Override // w2.U0
    public void c(final com.stepos.digitalwellbeing.server.data.a aVar) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.y1
            @Override // D3.a
            public final void run() {
                this.f23685a.g0(aVar);
            }
        }, S1.a.b()));
    }

    @Override // w2.U0
    public void d(final com.stepos.digitalwellbeing.server.data.a aVar, final DataToken dataToken) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.E1
            @Override // D3.a
            public final void run() {
                this.f23550a.e0(aVar, dataToken);
            }
        }, S1.a.b()));
    }

    @Override // w2.U0
    public void f(final Context context, final com.stepos.digitalwellbeing.server.data.a aVar, final DataToken dataToken) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.C1
            @Override // D3.a
            public final void run() {
                this.f23537a.b0(context, aVar, dataToken);
            }
        }, S1.a.b()));
    }

    @Override // w2.U0
    public void h(final Context context, final com.stepos.digitalwellbeing.server.data.a aVar, final DataToken dataToken) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.z1
            @Override // D3.a
            public final void run() {
                this.f23689a.c0(context, aVar, dataToken);
            }
        }, S1.a.b()));
    }

    public void j0(v2.e eVar) {
        this.f23558c = T(eVar);
    }

    @Override // w2.U0
    public void l(final com.stepos.digitalwellbeing.server.data.a aVar, final DataToken dataToken) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.B1
            @Override // D3.a
            public final void run() {
                this.f23532a.d0(aVar, dataToken);
            }
        }, S1.a.b()));
    }

    @Override // w2.U0
    public void n(final com.stepos.digitalwellbeing.server.data.a aVar, final DataToken dataToken) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.A1
            @Override // D3.a
            public final void run() {
                this.f23526a.f0(aVar, dataToken);
            }
        }, S1.a.b()));
    }

    @Override // w2.U0
    public void z(final com.stepos.digitalwellbeing.server.data.a aVar, final DataToken dataToken) {
        this.f23559d.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.D1
            @Override // D3.a
            public final void run() {
                this.f23542a.h0(aVar, dataToken);
            }
        }, S1.a.b()));
    }
}
