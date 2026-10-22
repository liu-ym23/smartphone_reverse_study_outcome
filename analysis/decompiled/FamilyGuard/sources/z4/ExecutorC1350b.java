package z4;

import java.util.concurrent.Executor;
import s4.AbstractC1056E;
import s4.AbstractC1071f0;
import x4.C1295G;
import x4.C1297I;

/* renamed from: z4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ExecutorC1350b extends AbstractC1071f0 implements Executor {

    /* renamed from: d, reason: collision with root package name */
    public static final ExecutorC1350b f24106d = new ExecutorC1350b();

    /* renamed from: e, reason: collision with root package name */
    private static final AbstractC1056E f24107e = m.f24127c.d0(C1297I.e("kotlinx.coroutines.io.parallelism", kotlin.ranges.l.b(64, C1295G.a()), 0, 0, 12, null));

    private ExecutorC1350b() {
    }

    @Override // s4.AbstractC1056E
    public void Y(Z3.i iVar, Runnable runnable) {
        f24107e.Y(iVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Y(Z3.j.f6656a, runnable);
    }

    @Override // s4.AbstractC1056E
    public String toString() {
        return "Dispatchers.IO";
    }
}
