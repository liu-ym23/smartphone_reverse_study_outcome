package rc;

import java.util.concurrent.Executor;
import kc.p;
import kc.p0;
import pc.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends p0 implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public static final d f10552f = new d();

    /* renamed from: g, reason: collision with root package name */
    public static final p f10553g;

    static {
        k kVar = k.f10566f;
        int i = u.f9986a;
        if (64 >= i) {
            i = 64;
        }
        f10553g = kVar.P(pc.a.j(i, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        f10553g.M(gVar, runnable);
    }

    @Override // kc.p
    public final void N(nb.g gVar, Runnable runnable) {
        f10553g.N(gVar, runnable);
    }

    @Override // kc.p
    public final p P(int i) {
        return k.f10566f.P(1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        M(nb.h.f8811c, runnable);
    }

    @Override // kc.p
    public final String toString() {
        return "Dispatchers.IO";
    }
}
