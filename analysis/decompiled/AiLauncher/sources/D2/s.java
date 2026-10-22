package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class s implements B {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2224a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2225b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0791c f2226c;

    public s(Executor executor, InterfaceC0791c interfaceC0791c) {
        this.f2224a = executor;
        this.f2226c = interfaceC0791c;
    }

    @Override // D2.B
    public final void c(i iVar) {
        if (iVar.j()) {
            synchronized (this.f2225b) {
                try {
                    if (this.f2226c == null) {
                        return;
                    }
                    this.f2224a.execute(new r(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
