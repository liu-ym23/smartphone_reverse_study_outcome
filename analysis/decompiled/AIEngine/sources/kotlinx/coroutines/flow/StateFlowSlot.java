package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Concurrent_commonKt;
import kotlinx.coroutines.internal.Symbol;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    private final AtomicReference<Object> _state = new AtomicReference<>(null);

    public final Object awaitPending(qb.b<? super n> bVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReference atomicReference = this._state;
        Symbol symbol = StateFlowKt.NONE;
        while (true) {
            if (atomicReference.compareAndSet(symbol, cancellableContinuationImpl)) {
                break;
            }
            if (atomicReference.get() != symbol) {
                cancellableContinuationImpl.resumeWith(n.f10413a);
                break;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.f10059a ? result : n.f10413a;
    }

    public final void makePending() {
        AtomicReference<Object> atomicReference = this._state;
        while (true) {
            Object value = Concurrent_commonKt.getValue(atomicReference);
            if (value == null || value == StateFlowKt.PENDING) {
                return;
            }
            if (value == StateFlowKt.NONE) {
                AtomicReference<Object> atomicReference2 = this._state;
                Symbol symbol = StateFlowKt.PENDING;
                while (!atomicReference2.compareAndSet(value, symbol)) {
                    if (atomicReference2.get() != value) {
                        break;
                    }
                }
                return;
            }
            AtomicReference<Object> atomicReference3 = this._state;
            Symbol symbol2 = StateFlowKt.NONE;
            while (!atomicReference3.compareAndSet(value, symbol2)) {
                if (atomicReference3.get() != value) {
                    break;
                }
            }
            ((CancellableContinuationImpl) value).resumeWith(n.f10413a);
            return;
        }
    }

    public final boolean takePending() {
        Object andSet = this._state.getAndSet(StateFlowKt.NONE);
        g.c(andSet);
        return andSet == StateFlowKt.PENDING;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        if (Concurrent_commonKt.getValue(this._state) != null) {
            return false;
        }
        Concurrent_commonKt.setValue(this._state, StateFlowKt.NONE);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public qb.b<n>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        Concurrent_commonKt.setValue(this._state, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }
}
