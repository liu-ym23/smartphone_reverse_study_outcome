package h6;

import a6.b0;
import a6.b1;
import f6.s;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends b1 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final d f3059c = new d();
    public static final b0 d;

    static {
        l lVar = l.f3070c;
        int i8 = s.f2661a;
        if (64 >= i8) {
            i8 = 64;
        }
        d = lVar.G(f6.a.l(i8, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // a6.b0
    public final void C(f5.h hVar, Runnable runnable) {
        d.C(hVar, runnable);
    }

    @Override // a6.b0
    public final void E(f5.h hVar, Runnable runnable) {
        d.E(hVar, runnable);
    }

    @Override // a6.b0
    public final b0 G(int i8) {
        return l.f3070c.G(i8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        C(f5.i.f2626a, runnable);
    }

    @Override // a6.b0
    public final String toString() {
        return "Dispatchers.IO";
    }
}
