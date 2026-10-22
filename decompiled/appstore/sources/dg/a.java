package dg;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19198d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CoroutineDispatcher f19199e = null;

    static {
        f19198d = new a();
        f19199e = k.f19219c.d(c0.g("kotlinx.coroutines.io.parallelism", bg.h.d(64, c0.a()), 0, 0, 12, null));
    }

    public a() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        f19199e.a(r10, r11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void b(CoroutineContext r10, Runnable r11) {
        f19199e.b(r10, r11);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        a(EmptyCoroutineContext.INSTANCE, r10);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.IO";
    }
}
