package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CancellableSimpleLock extends DefaultSimpleLock {
    private final Runnable checkCancelled;
    private final Function1<InterruptedException, Unit> interruptedExceptionHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(Lock r2, Runnable r3, Function1<? super InterruptedException, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "lock");
        Intrinsics.checkNotNullParameter(r3, "checkCancelled");
        Intrinsics.checkNotNullParameter(r4, "interruptedExceptionHandler");
        super(r2);
        this.checkCancelled = r3;
        this.interruptedExceptionHandler = r4;
    }

    public CancellableSimpleLock(Runnable r2, Function1<? super InterruptedException, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "checkCancelled");
        Intrinsics.checkNotNullParameter(r3, "interruptedExceptionHandler");
        this(new ReentrantLock(), r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
    L9:
    L6:
        e = move-exception;
        this.interruptedExceptionHandler.invoke(e);
        return;
    L3:
        if (getLock().tryLock(50, TimeUnit.MILLISECONDS) == true) goto L13;
        this.checkCancelled.run();     // Catch: InterruptedException -> L6
        goto L9
    }
}
