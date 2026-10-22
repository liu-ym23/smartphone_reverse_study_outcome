package com.stepos.familyguard.ui.usage;

import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.data.DataToken;
import w2.V0;
import w2.W0;
import w2.X0;
import w2.n1;
import x3.AbstractC1286b;

/* renamed from: com.stepos.familyguard.ui.usage.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0610t extends androidx.lifecycle.T implements V0 {

    /* renamed from: b, reason: collision with root package name */
    private X0 f15153b;

    /* renamed from: c, reason: collision with root package name */
    private final A3.b f15154c = new A3.b();

    private X0 Q(v2.e eVar) {
        return eVar instanceof v2.f ? new W0(eVar) : new n1(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f15153b.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.f15153b.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        this.f15153b.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        this.f15153b.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DataToken dataToken) {
        this.f15153b.q(dataToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        this.f15153b.a();
    }

    @Override // w2.V0
    public void C() {
        this.f15154c.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.Z
            @Override // D3.a
            public final void run() {
                this.f23597a.Y();
            }
        }, S1.a.b()));
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        super.J();
        X0 x02 = this.f15153b;
        if (x02 != null) {
            x02.I();
        }
    }

    public AbstractC0545z<Long> R() {
        return this.f15153b.J();
    }

    public AbstractC0545z<DataToken> S() {
        return this.f15153b.K();
    }

    public AbstractC0545z<x> T() {
        return this.f15153b.L();
    }

    public AbstractC0545z<DataToken> U() {
        return this.f15153b.M();
    }

    public AbstractC0545z<U> V() {
        return this.f15153b.N();
    }

    @Override // w2.V0
    public void a() {
        this.f15154c.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.d0
            @Override // D3.a
            public final void run() {
                this.f23608a.b0();
            }
        }, S1.a.b()));
    }

    public AbstractC0545z<Boolean> b() {
        return this.f15153b.b();
    }

    public void c0(v2.e eVar) {
        this.f15153b = Q(eVar);
    }

    @Override // w2.V0
    public void g() {
        this.f15154c.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.c0
            @Override // D3.a
            public final void run() {
                this.f23601a.W();
            }
        }, S1.a.b()));
    }

    @Override // w2.V0
    public void q(final DataToken dataToken) {
        this.f15154c.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.e0
            @Override // D3.a
            public final void run() {
                this.f23611a.a0(dataToken);
            }
        }, S1.a.b()));
    }

    @Override // w2.V0
    public void r() {
        this.f15154c.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.b0
            @Override // D3.a
            public final void run() {
                this.f23600a.X();
            }
        }, S1.a.b()));
    }

    @Override // w2.V0
    public void x() {
        this.f15154c.c(AbstractC1286b.b().j(T3.a.c()).h(new D3.a() { // from class: w2.a0
            @Override // D3.a
            public final void run() {
                this.f23598a.Z();
            }
        }, S1.a.b()));
    }
}
