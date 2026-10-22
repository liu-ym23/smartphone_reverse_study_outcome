package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class y implements B {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2239a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2240b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0794f f2241c;

    public y(Executor executor, InterfaceC0794f interfaceC0794f) {
        this.f2239a = executor;
        this.f2241c = interfaceC0794f;
    }

    @Override // D2.B
    public final void c(i iVar) {
        if (iVar.l()) {
            synchronized (this.f2240b) {
                try {
                    if (this.f2241c == null) {
                        return;
                    }
                    this.f2239a.execute(new x(this, iVar));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
