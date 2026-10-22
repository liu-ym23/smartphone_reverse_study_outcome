package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThreadPoolDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/ThreadPoolDispatcherKt")
final /* synthetic */ class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt {
    public static /* synthetic */ Thread $r8$lambda$CXeTp9524z5WcFUqzWTDHsXGzHM(int r0, String r1, AtomicInteger r2, Runnable r3) {
        return newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(r0, r1, r2, r3);
    }

    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(final int r2, final String r3) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        final AtomicInteger r1 = new AtomicInteger();
        return ExecutorsKt.from(Executors.newScheduledThreadPool(r2, new ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(r2, r3, r1)));
    L10:
        throw new IllegalArgumentException(("Expected at least one thread, but " + r2 + " specified").toString());
    }

    private static final Thread newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(int r2, String r3, AtomicInteger r4, Runnable r5) {
        if (r2 == 1) goto L6;
        r3 = r3 + '-' + r4.incrementAndGet();
    L6:
        Thread r0 = new Thread(r5, r3);
        r0.setDaemon(true);
        return r0;
    }
}
