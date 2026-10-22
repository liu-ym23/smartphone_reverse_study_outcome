package rc;

import java.lang.invoke.VarHandle;
import kc.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends p0 {

    /* renamed from: g, reason: collision with root package name */
    public static final e f10554g;

    /* renamed from: f, reason: collision with root package name */
    public c f10555f;

    static {
        int i = j.f10562c;
        int i3 = j.f10563d;
        long j10 = j.f10564e;
        String str = j.f10560a;
        e eVar = new e();
        eVar.f10555f = new c(i, i3, j10, str);
        VarHandle.storeStoreFence();
        f10554g = eVar;
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        c.g(this.f10555f, runnable, 6);
    }

    @Override // kc.p
    public final void N(nb.g gVar, Runnable runnable) {
        c.g(this.f10555f, runnable, 2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kc.p
    public final String toString() {
        return "Dispatchers.Default";
    }
}
