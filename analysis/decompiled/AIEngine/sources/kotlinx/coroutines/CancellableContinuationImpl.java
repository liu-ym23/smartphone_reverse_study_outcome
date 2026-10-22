package kotlinx.coroutines;

import b7.h;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import lb.n;
import rb.b;
import zb.l;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, b, Waiter {
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private final d context;
    private final qb.b<T> delegate;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(qb.b<? super T> bVar, int i10) {
        super(i10);
        this.delegate = bVar;
        this.context = bVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable th) {
        int i10 = _decisionAndIndex$volatile$FU.get(this) & 536870911;
        if (i10 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment.onCancellation(i10, th, getContext());
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean cancelLater(Throwable th) {
        if (!isReusable()) {
            return false;
        }
        qb.b<T> bVar = this.delegate;
        g.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) bVar).postponeCancellation$kotlinx_coroutines_core(th);
    }

    private final void detachChildIfNonResuable() {
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    private final void dispatchResume(int i10) {
        if (tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, i10);
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) _parentHandle$volatile$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return state$kotlinx_coroutines_core instanceof NotCompleted ? "Active" : state$kotlinx_coroutines_core instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleInvokeOnCompletion$default = JobKt__JobKt.invokeOnCompletion$default(job, false, new ChildContinuation(this), 1, null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, disposableHandleInvokeOnCompletion$default)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                return disposableHandleInvokeOnCompletion$default;
            }
        }
        return disposableHandleInvokeOnCompletion$default;
    }

    private final void invokeOnCancellationImpl(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof Active) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, obj)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            if (!(obj2 instanceof CancelHandler) && !(obj2 instanceof Segment)) {
                if (obj2 instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj2;
                    if (!completedExceptionally.makeHandled()) {
                        multipleHandlersError(obj, obj2);
                    }
                    if (obj2 instanceof CancelledContinuation) {
                        Throwable th = completedExceptionally.cause;
                        if (obj instanceof CancelHandler) {
                            callCancelHandler((CancelHandler) obj, th);
                            return;
                        } else {
                            g.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            callSegmentOnCancellation((Segment) obj, th);
                            return;
                        }
                    }
                    return;
                }
                if (!(obj2 instanceof CompletedContinuation)) {
                    if (obj instanceof Segment) {
                        return;
                    }
                    g.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CompletedContinuation completedContinuation = new CompletedContinuation(obj2, (CancelHandler) obj, null, null, null, 28, null);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = _state$volatile$FU;
                    while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj2, completedContinuation)) {
                        if (atomicReferenceFieldUpdater3.get(this) != obj2) {
                            break;
                        }
                    }
                    return;
                }
                CompletedContinuation completedContinuation2 = (CompletedContinuation) obj2;
                if (completedContinuation2.cancelHandler != null) {
                    multipleHandlersError(obj, obj2);
                }
                if (obj instanceof Segment) {
                    return;
                }
                g.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                CancelHandler cancelHandler = (CancelHandler) obj;
                if (completedContinuation2.getCancelled()) {
                    callCancelHandler(cancelHandler, completedContinuation2.cancelCause);
                    return;
                }
                CompletedContinuation completedContinuationCopy$default = CompletedContinuation.copy$default(completedContinuation2, null, cancelHandler, null, null, null, 29, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater4.compareAndSet(this, obj2, completedContinuationCopy$default)) {
                    if (atomicReferenceFieldUpdater4.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            multipleHandlersError(obj, obj2);
        }
    }

    private final boolean isReusable() {
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            return false;
        }
        qb.b<T> bVar = this.delegate;
        g.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) bVar).isReusable$kotlinx_coroutines_core();
    }

    private final void multipleHandlersError(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n resume$lambda$13$lambda$12(l lVar, Throwable th, Object obj, d dVar) {
        lVar.invoke(th);
        return n.f10413a;
    }

    public static /* synthetic */ void resumeImpl$kotlinx_coroutines_core$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i10, q qVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            qVar = null;
        }
        cancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core(obj, i10, qVar);
    }

    private final <R> Object resumedState(NotCompleted notCompleted, R r, int i10, q<? super Throwable, ? super R, ? super d, n> qVar, Object obj) {
        if (r instanceof CompletedExceptionally) {
            return r;
        }
        if ((DispatchedTaskKt.isCancellableMode(i10) || obj != null) && !(qVar == null && !(notCompleted instanceof CancelHandler) && obj == null)) {
            return new CompletedContinuation(r, notCompleted instanceof CancelHandler ? (CancelHandler) notCompleted : null, qVar, obj, null, 16, null);
        }
        return r;
    }

    private final boolean tryResume() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    private final <R> Symbol tryResumeImpl(R r, Object obj, q<? super Throwable, ? super R, ? super d, n> qVar) {
        CancellableContinuationImpl<T> cancellableContinuationImpl;
        R r8;
        Object obj2;
        q<? super Throwable, ? super R, ? super d, n> qVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof NotCompleted)) {
                Object obj4 = obj;
                if ((obj3 instanceof CompletedContinuation) && obj4 != null && ((CompletedContinuation) obj3).idempotentResume == obj4) {
                    return CancellableContinuationImplKt.RESUME_TOKEN;
                }
                return null;
            }
            cancellableContinuationImpl = this;
            r8 = r;
            obj2 = obj;
            qVar2 = qVar;
            Object objResumedState = cancellableContinuationImpl.resumedState((NotCompleted) obj3, r8, this.resumeMode, qVar2, obj2);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
            while (!atomicReferenceFieldUpdater2.compareAndSet(cancellableContinuationImpl, obj3, objResumedState)) {
                if (atomicReferenceFieldUpdater2.get(cancellableContinuationImpl) != obj3) {
                    break;
                }
            }
            cancellableContinuationImpl.detachChildIfNonResuable();
            return CancellableContinuationImplKt.RESUME_TOKEN;
            this = cancellableContinuationImpl;
            r = r8;
            qVar = qVar2;
            obj = obj2;
        }
    }

    private final boolean trySuspend() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    public final void callCancelHandler(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> void callOnCancellation(q<? super Throwable, ? super R, ? super d, n> qVar, Throwable th, R r) {
        try {
            qVar.invoke(th, r, getContext());
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, th, (obj instanceof CancelHandler) || (obj instanceof Segment));
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, cancelledContinuation)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj) {
                    break;
                }
            }
            NotCompleted notCompleted = (NotCompleted) obj;
            if (notCompleted instanceof CancelHandler) {
                callCancelHandler((CancelHandler) obj, th);
            } else if (notCompleted instanceof Segment) {
                callSegmentOnCancellation((Segment) obj, th);
            }
            detachChildIfNonResuable();
            dispatchResume(this.resumeMode);
            return true;
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (!(obj2 instanceof CompletedContinuation)) {
                th2 = th;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                CompletedContinuation completedContinuation = new CompletedContinuation(obj2, null, null, null, th2, 14, null);
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, completedContinuation)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            CompletedContinuation completedContinuation2 = (CompletedContinuation) obj2;
            if (completedContinuation2.getCancelled()) {
                throw new IllegalStateException("Must be called at most once");
            }
            Throwable th3 = th;
            CompletedContinuation completedContinuationCopy$default = CompletedContinuation.copy$default(completedContinuation2, null, null, null, null, th3, 15, null);
            th2 = th3;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = _state$volatile$FU;
            while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj2, completedContinuationCopy$default)) {
                if (atomicReferenceFieldUpdater3.get(this) != obj2) {
                    break;
                }
            }
            completedContinuation2.invokeHandlers(this, th2);
            return;
            th = th2;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object obj) {
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle == null) {
            return;
        }
        parentHandle.dispose();
        _parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override // rb.b
    public b getCallerFrame() {
        qb.b<T> bVar = this.delegate;
        if (bVar instanceof b) {
            return (b) bVar;
        }
        return null;
    }

    @Override // qb.b
    public d getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(Job job) {
        return job.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final qb.b<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public final Object getResult() {
        Job job;
        boolean zIsReusable = isReusable();
        if (trySuspend()) {
            if (getParentHandle() == null) {
                installParentHandle();
            }
            if (zIsReusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return CoroutineSingletons.f10059a;
        }
        if (zIsReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        if (!DispatchedTaskKt.isCancellableMode(this.resumeMode) || (job = (Job) getContext().get(Job.Key)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        }
        CancellationException cancellationException = job.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
        throw cancellationException;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedContinuation ? (T) ((CompletedContinuation) obj).result : obj;
    }

    public void initCancellability() {
        DisposableHandle disposableHandleInstallParentHandle = installParentHandle();
        if (disposableHandleInstallParentHandle != null && isCompleted()) {
            disposableHandleInstallParentHandle.dispose();
            _parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        invokeOnCancellationImpl(segment);
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(CancelHandler cancelHandler) {
        invokeOnCancellationImpl(cancelHandler);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th) {
        if (cancelLater(th)) {
            return;
        }
        cancel(th);
        detachChildIfNonResuable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Throwable thTryReleaseClaimedContinuation$kotlinx_coroutines_core;
        qb.b<T> bVar = this.delegate;
        DispatchedContinuation dispatchedContinuation = bVar instanceof DispatchedContinuation ? (DispatchedContinuation) bVar : null;
        if (dispatchedContinuation == null || (thTryReleaseClaimedContinuation$kotlinx_coroutines_core = dispatchedContinuation.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(thTryReleaseClaimedContinuation$kotlinx_coroutines_core);
    }

    public final boolean resetStateReusable() {
        Object obj = _state$volatile$FU.get(this);
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        _decisionAndIndex$volatile$FU.set(this, 536870911);
        _state$volatile$FU.set(this, Active.INSTANCE);
        return true;
    }

    public void resume(T t8, l<? super Throwable, n> lVar) {
        resumeImpl$kotlinx_coroutines_core(t8, this.resumeMode, lVar != null ? new h(lVar, 1) : null);
    }

    public final <R> void resumeImpl$kotlinx_coroutines_core(R r, int i10, q<? super Throwable, ? super R, ? super d, n> qVar) {
        CancellableContinuationImpl<T> cancellableContinuationImpl;
        R r8;
        int i11;
        q<? super Throwable, ? super R, ? super d, n> qVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof NotCompleted) {
                cancellableContinuationImpl = this;
                r8 = r;
                i11 = i10;
                qVar2 = qVar;
                Object objResumedState = cancellableContinuationImpl.resumedState((NotCompleted) obj, r8, i11, qVar2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(cancellableContinuationImpl, obj, objResumedState)) {
                    if (atomicReferenceFieldUpdater2.get(cancellableContinuationImpl) != obj) {
                        break;
                    }
                }
                cancellableContinuationImpl.detachChildIfNonResuable();
                cancellableContinuationImpl.dispatchResume(i11);
                return;
            }
            CancellableContinuationImpl<T> cancellableContinuationImpl2 = this;
            R r9 = r;
            q<? super Throwable, ? super R, ? super d, n> qVar3 = qVar;
            if (obj instanceof CancelledContinuation) {
                CancelledContinuation cancelledContinuation = (CancelledContinuation) obj;
                if (cancelledContinuation.makeResumed()) {
                    if (qVar3 != null) {
                        cancellableContinuationImpl2.callOnCancellation(qVar3, cancelledContinuation.cause, r9);
                        return;
                    }
                    return;
                }
            }
            cancellableContinuationImpl2.alreadyResumedError(r9);
            throw new KotlinNothingValueException();
            this = cancellableContinuationImpl;
            r = r8;
            i10 = i11;
            qVar = qVar2;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t8) {
        qb.b<T> bVar = this.delegate;
        DispatchedContinuation dispatchedContinuation = bVar instanceof DispatchedContinuation ? (DispatchedContinuation) bVar : null;
        resumeImpl$kotlinx_coroutines_core$default(this, t8, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // qb.b
    public void resumeWith(Object obj) {
        resumeImpl$kotlinx_coroutines_core$default(this, CompletionStateKt.toState(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable th) {
        return tryResumeImpl(new CompletedExceptionally(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public <R extends T> void resume(R r, q<? super Throwable, ? super R, ? super d, n> qVar) {
        resumeImpl$kotlinx_coroutines_core(r, this.resumeMode, qVar);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(l<? super Throwable, n> lVar) {
        CancellableContinuationKt.invokeOnCancellation(this, new CancelHandler.UserSupplied(lVar));
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public <R extends T> Object tryResume(R r, Object obj, q<? super Throwable, ? super R, ? super d, n> qVar) {
        return tryResumeImpl(r, obj, qVar);
    }
}
