package qa;

import java.util.concurrent.Executor;

/* renamed from: qa.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1860l implements InterfaceC1852d {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5655a;
    public final InterfaceC1852d b;

    public C1860l(Executor executor, InterfaceC1852d interfaceC1852d) {
        this.f5655a = executor;
        this.b = interfaceC1852d;
    }

    @Override // qa.InterfaceC1852d
    public final void cancel() {
        this.b.cancel();
    }

    @Override // qa.InterfaceC1852d
    public final void g(InterfaceC1855g interfaceC1855g) {
        this.b.g(new F.g(this, interfaceC1855g));
    }

    @Override // qa.InterfaceC1852d
    public final F9.G i() {
        return this.b.i();
    }

    @Override // qa.InterfaceC1852d
    public final boolean l() {
        return this.b.l();
    }

    @Override // qa.InterfaceC1852d
    public final InterfaceC1852d clone() {
        return new C1860l(this.f5655a, this.b.clone());
    }
}
