package ob;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class q implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final k0 f8023f;

    public q(k0 k0Var) {
        q7.k.e(k0Var, "delegate");
        this.f8023f = k0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8023f.close();
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f8023f.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f8023f + ')';
    }
}
