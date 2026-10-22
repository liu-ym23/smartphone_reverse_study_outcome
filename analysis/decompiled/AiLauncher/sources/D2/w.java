package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class w implements B {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2234a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2235b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0793e f2236c;

    public w(Executor executor, InterfaceC0793e interfaceC0793e) {
        this.f2234a = executor;
        this.f2236c = interfaceC0793e;
    }

    @Override // D2.B
    public final void c(i iVar) {
        if (iVar.l() || iVar.j()) {
            return;
        }
        synchronized (this.f2235b) {
            try {
                if (this.f2236c == null) {
                    return;
                }
                this.f2234a.execute(new v(this, iVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
