package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class u implements B {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2229a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2230b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0792d f2231c;

    public u(Executor executor, InterfaceC0792d interfaceC0792d) {
        this.f2229a = executor;
        this.f2231c = interfaceC0792d;
    }

    @Override // D2.B
    public final void c(i iVar) {
        synchronized (this.f2230b) {
            try {
                if (this.f2231c == null) {
                    return;
                }
                this.f2229a.execute(new t(this, iVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
