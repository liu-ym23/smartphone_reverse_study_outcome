package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class A<TResult, TContinuationResult> implements InterfaceC0794f<TContinuationResult>, InterfaceC0793e, InterfaceC0791c, B {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2202a;

    /* renamed from: b, reason: collision with root package name */
    public final h f2203b;

    /* renamed from: c, reason: collision with root package name */
    public final G f2204c;

    public A(Executor executor, h hVar, G g10) {
        this.f2202a = executor;
        this.f2203b = hVar;
        this.f2204c = g10;
    }

    @Override // D2.InterfaceC0794f
    public final void a(TContinuationResult tcontinuationresult) {
        this.f2204c.o(tcontinuationresult);
    }

    @Override // D2.InterfaceC0791c
    public final void b() {
        this.f2204c.p();
    }

    @Override // D2.B
    public final void c(i iVar) {
        this.f2202a.execute(new z(this, iVar));
    }

    @Override // D2.InterfaceC0793e
    public final void onFailure(Exception exc) {
        this.f2204c.n(exc);
    }
}
