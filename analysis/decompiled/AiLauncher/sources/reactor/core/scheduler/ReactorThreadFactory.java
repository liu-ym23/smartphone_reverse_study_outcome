package reactor.core.scheduler;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
class ReactorThreadFactory implements ThreadFactory, Supplier<String>, Thread.UncaughtExceptionHandler {
    private final AtomicLong counterReference;
    private final boolean daemon;
    private final String name;
    private final boolean rejectBlocking;

    @Nullable
    private final BiConsumer<Thread, Throwable> uncaughtExceptionHandler;

    public static final class NonBlockingThread extends Thread implements NonBlocking {
        public NonBlockingThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public ReactorThreadFactory(String str, AtomicLong atomicLong, boolean z10, boolean z11, @Nullable BiConsumer<Thread, Throwable> biConsumer) {
        this.name = str;
        this.counterReference = atomicLong;
        this.daemon = z10;
        this.rejectBlocking = z11;
        this.uncaughtExceptionHandler = biConsumer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        String str = this.name + O6.l.DATE_SEPARATOR + this.counterReference.incrementAndGet();
        Thread nonBlockingThread = this.rejectBlocking ? new NonBlockingThread(runnable, str) : new Thread(runnable, str);
        if (this.daemon) {
            nonBlockingThread.setDaemon(true);
        }
        if (this.uncaughtExceptionHandler != null) {
            nonBlockingThread.setUncaughtExceptionHandler(this);
        }
        return nonBlockingThread;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        BiConsumer<Thread, Throwable> biConsumer = this.uncaughtExceptionHandler;
        if (biConsumer == null) {
            return;
        }
        biConsumer.accept(thread, th);
    }

    @Override // java.util.function.Supplier
    public final String get() {
        return this.name;
    }
}
