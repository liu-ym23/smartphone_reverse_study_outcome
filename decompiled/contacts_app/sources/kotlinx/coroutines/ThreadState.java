package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Interruptible.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0006\u0010\u0018\u001a\u00020\u0006R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "_state", "Lkotlinx/atomicfu/AtomicInt;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "invalidState", "", "state", "", "invoke", "setup", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ThreadState implements Function1<Throwable, Unit> {
    private static final AtomicIntegerFieldUpdater _state$FU = null;

    @Volatile
    private volatile int _state;
    private DisposableHandle cancelHandle;
    private final Job job;
    private final Thread targetThread;

    static {
        _state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater r1, Function1<? super Integer, Unit> r2, Object r3) {
    L2:
        r2.invoke(Integer.valueOf(r1.get(r3)));
        goto L2
    }

    public ThreadState(Job r1) {
        this.job = r1;
        this.targetThread = Thread.currentThread();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    public final void setup() {
        this.cancelHandle = this.job.invokeOnCompletion(true, true, this);
        AtomicIntegerFieldUpdater r0 = _state$FU;
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (_state$FU.compareAndSet(this, r1, 0) == false) goto L3;
        return;
    L6:
        if (r1 != 2) goto L8;
        return;
    L8:
        if (r1 == 3) goto L19;
        invalidState(r1);
        throw new KotlinNothingValueException();
    }

    public final void clearInterrupt() {
        AtomicIntegerFieldUpdater r0 = _state$FU;
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (_state$FU.compareAndSet(this, r1, 1) == false) goto L3;
        DisposableHandle r4 = this.cancelHandle;
        if (r4 == null) goto L26;
        r4.dispose();
        return;
    L26:
        return;
    L6:
        if (r1 == 2) goto L3;
        if (r1 != 3) goto L11;
        Thread.interrupted();
        return;
    L11:
        invalidState(r1);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable r5) {
        AtomicIntegerFieldUpdater r6 = _state$FU;
    L3:
        int r0 = r6.get(this);
        if (r0 != 0) goto L6;
        AtomicIntegerFieldUpdater r3 = _state$FU;
        if (r3.compareAndSet(this, r0, 2) == false) goto L3;
        this.targetThread.interrupt();
        r3.set(this, 3);
        return;
    L6:
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L21;
        invalidState(r0);
        throw new KotlinNothingValueException();
    L21:
        return;
    L20:
        return;
    }

    private final Void invalidState(int r3) {
        throw new IllegalStateException(("Illegal state " + r3).toString());
    }
}
