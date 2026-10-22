package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CancelledContinuation extends CompletedExceptionally {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _resumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public CancelledContinuation(b<?> bVar, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + bVar + " was cancelled normally");
        }
        super(th, z);
        this._resumed$volatile = 0;
    }

    public final boolean makeResumed() {
        return _resumed$volatile$FU.compareAndSet(this, 0, 1);
    }
}
