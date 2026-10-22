package f3;

import Z2.A;
import Z2.AbstractC0123e0;
import Z2.I;
import d3.x;
import f1.AbstractC0557a;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class c extends AbstractC0123e0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final c f12565a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final A f12566b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [d3.j] */
    static {
        k jVar = k.f12581a;
        int iE0 = AbstractC0557a.e0("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, x.f12483a), 0, 0, 12);
        jVar.getClass();
        I.e(iE0);
        if (iE0 < j.f12576d) {
            I.e(iE0);
            jVar = new d3.j(jVar, iE0);
        }
        f12566b = jVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f12566b.dispatch(coroutineContext, runnable);
    }

    @Override // Z2.A
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f12566b.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // Z2.A
    public final String toString() {
        return "Dispatchers.IO";
    }
}
