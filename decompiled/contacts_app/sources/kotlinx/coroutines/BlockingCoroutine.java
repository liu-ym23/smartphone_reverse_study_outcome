package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    @Override // kotlinx.coroutines.JobSupport
    protected boolean isScopedCoroutine() {
        return true;
    }

    public BlockingCoroutine(CoroutineContext r2, Thread r3, EventLoop r4) {
        super(r2, true, true);
        this.blockedThread = r3;
        this.eventLoop = r4;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void afterCompletion(Object r2) {
        if (Intrinsics.areEqual(Thread.currentThread(), this.blockedThread) == true) goto L11;
        Thread r1 = this.blockedThread;
        AbstractTimeSource r3 = AbstractTimeSourceKt.getTimeSource();
        if (r3 == null) goto L7;
        r3.unpark(r1);
        Unit r4 = Unit.INSTANCE;
    L8:
        if (r4 != null) goto L12;
        LockSupport.unpark(r1);
        return;
    L12:
        return;
    L7:
        r4 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T joinBlocking() {
        AbstractTimeSource r0 = AbstractTimeSourceKt.getTimeSource();
        if (r0 == null) goto L50;
        r0.registerTimeLoopThread();
    L50:
        EventLoop r1 = this.eventLoop;     // Catch: Throwable -> L43
        CompletedExceptionally r3 = null;
        if (r1 == null) goto L48;
        EventLoop.incrementUseCount$default(r1, false, 1, null);     // Catch: Throwable -> L43
    L48:
    L38:
        th = move-exception;
        EventLoop r6 = this.eventLoop;     // Catch: Throwable -> L43
        if (r6 == null) goto L42;
        EventLoop.decrementUseCount$default(r6, false, 1, null);     // Catch: Throwable -> L43
    L42:
        throw th;     // Catch: Throwable -> L43
    L9:
        if (Thread.interrupted() == true) goto L36;
        EventLoop r2 = this.eventLoop;     // Catch: Throwable -> L38
        if (r2 == null) goto L13;
        long r4 = r2.processNextEvent();     // Catch: Throwable -> L38
    L15:
        if (isCompleted() == true) goto L23;
        AbstractTimeSource r5 = AbstractTimeSourceKt.getTimeSource();     // Catch: Throwable -> L38
        if (r5 == null) goto L19;
        r5.parkNanos(this, r4);     // Catch: Throwable -> L38
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L20:
        if (r7 != null) goto L48;
        LockSupport.parkNanos(this, r4);     // Catch: Throwable -> L38
        goto L48
    L19:
        r7 = null;
        goto L20
    L23:
        EventLoop r8 = this.eventLoop;     // Catch: Throwable -> L43
        if (r8 == null) goto L26;
        EventLoop.decrementUseCount$default(r8, false, 1, null);     // Catch: Throwable -> L43
    L26:
        AbstractTimeSource r9 = AbstractTimeSourceKt.getTimeSource();
        if (r9 == null) goto L29;
        r9.unregisterTimeLoopThread();
    L29:
        T r10 = (T) JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
        if ((r10 instanceof CompletedExceptionally) == false) goto L32;
        r3 = (CompletedExceptionally) r10;
    L32:
        if (r3 != null) goto L35;
        return r10;
    L35:
        throw r3.cause;
    L13:
        r4 = Long.MAX_VALUE;
        goto L15
    L36:
        InterruptedException r11 = new InterruptedException();     // Catch: Throwable -> L38
        cancelCoroutine(r11);     // Catch: Throwable -> L38
        throw r11;     // Catch: Throwable -> L38
    L43:
        th = move-exception;
        AbstractTimeSource r12 = AbstractTimeSourceKt.getTimeSource();
        if (r12 == null) goto L47;
        r12.unregisterTimeLoopThread();
    L47:
        throw th;
    }
}
