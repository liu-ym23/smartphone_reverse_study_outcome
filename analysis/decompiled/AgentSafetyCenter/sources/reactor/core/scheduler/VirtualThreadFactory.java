package reactor.core.scheduler;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.function.BiConsumer;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class VirtualThreadFactory implements ThreadFactory, Thread.UncaughtExceptionHandler {
    public VirtualThreadFactory(String str, boolean z10, @Nullable BiConsumer<Thread, Throwable> biConsumer) {
        throw new UnsupportedOperationException("Virtual Threads are not supported in JVM lower than 21");
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        throw new UnsupportedOperationException("Virtual Threads are not supported in JVM lower than 21");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        throw new UnsupportedOperationException("Virtual Threads are not supported in JVM lower than 21");
    }
}
