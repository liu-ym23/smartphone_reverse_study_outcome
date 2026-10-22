package u9;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.AbstractC1702U;
import m9.AbstractC1729v;
import s9.AbstractC1921a;
import s9.r;

/* loaded from: classes4.dex */
public final class c extends AbstractC1702U implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6743a = new c();
    public static final AbstractC1729v b;

    static {
        k kVar = k.f6748a;
        int i = r.f6007a;
        if (64 >= i) {
            i = 64;
        }
        b = AbstractC1729v.limitedParallelism$default(kVar, AbstractC1921a.j(i, 12, "kotlinx.coroutines.io.parallelism"), null, 2, null);
    }

    @Override // m9.AbstractC1702U
    public final Executor E() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        b.dispatch(hVar, runnable);
    }

    @Override // m9.AbstractC1729v
    public final void dispatchYield(H7.h hVar, Runnable runnable) {
        b.dispatchYield(hVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.f4908a, runnable);
    }

    @Override // m9.AbstractC1729v
    public final AbstractC1729v limitedParallelism(int i, String str) {
        return k.f6748a.limitedParallelism(i, str);
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return "Dispatchers.IO";
    }
}
