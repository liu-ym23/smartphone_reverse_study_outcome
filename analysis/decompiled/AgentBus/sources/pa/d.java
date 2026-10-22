package pa;

import ia.x;
import ia.y0;
import java.util.concurrent.Executor;
import na.u;

/* loaded from: classes.dex */
public final class d extends y0 implements Executor {

    /* renamed from: h, reason: collision with root package name */
    public static final d f8556h = new d();

    /* renamed from: i, reason: collision with root package name */
    public static final x f8557i;

    static {
        l lVar = l.f8570h;
        int i2 = u.f6929a;
        if (64 >= i2) {
            i2 = 64;
        }
        f8557i = lVar.T(na.b.l("kotlinx.coroutines.io.parallelism", i2, 12));
    }

    @Override // ia.x
    public final void R(g7.l lVar, Runnable runnable) {
        f8557i.R(lVar, runnable);
    }

    @Override // ia.x
    public final x T(int i2) {
        return l.f8570h.T(i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        R(g7.m.f3866f, runnable);
    }

    @Override // ia.x
    public final String toString() {
        return "Dispatchers.IO";
    }
}
