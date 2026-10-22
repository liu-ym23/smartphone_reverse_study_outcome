package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.android.contacts.common.list.DefaultContactListAdapter;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u001f\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020%H\u0010¢\u0006\u0002\b&J\u0015\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH\u0000¢\u0006\u0002\b(J\u001f\u0010)\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00028\u0000H\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/H\u0016J\r\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6JH\u00107\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000092%\b\b\u0010:\u001a\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b($\u0012\u0004\u0012\u00020 \u0018\u00010;H\u0080\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010\fH\u0080\b¢\u0006\u0002\bBJ!\u0010C\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0080\bø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0016ø\u0001\u0000¢\u0006\u0002\u0010EJ\u000f\u0010G\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020JH\u0016J\u001b\u0010K\u001a\u0004\u0018\u00010%2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030LH\u0000¢\u0006\u0002\bMR\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_reusableCancellableContinuation", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "reusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "awaitReusability", "", "awaitReusability$kotlinx_coroutines_core", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "claimReusableCancellableContinuation", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "dispatchYield", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "isReusable", "", "isReusable$kotlinx_coroutines_core", "postponeCancellation", "postponeCancellation$kotlinx_coroutines_core", "release", "release$kotlinx_coroutines_core", "resumeCancellableWith", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resumeCancellableWith$kotlinx_coroutines_core", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeCancelled", "state", "resumeCancelled$kotlinx_coroutines_core", "resumeUndispatchedWith", "resumeUndispatchedWith$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeWith", "takeState", "takeState$kotlinx_coroutines_core", "toString", "", "tryReleaseClaimedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = null;

    @Volatile
    private volatile Object _reusableCancellableContinuation;
    public Object _state;
    public final Continuation<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    static {
        _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher r2, Continuation<? super T> r3) {
        super(-1);
        this.dispatcher = r2;
        this.continuation = r3;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(getContext());
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r1 = this.continuation;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r1;
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object r1 = _reusableCancellableContinuation$FU.get(this);
        if ((r1 instanceof CancellableContinuationImpl) == true) goto L7;
        return null;
    L7:
        return (CancellableContinuationImpl) r1;
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        if (_reusableCancellableContinuation$FU.get(this) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater r0 = _reusableCancellableContinuation$FU;
    L4:
        if (r0.get(this) == DispatchedContinuationKt.REUSABLE_CLAIMED) goto L4;
    }

    public final void release$kotlinx_coroutines_core() {
        awaitReusability$kotlinx_coroutines_core();
        CancellableContinuationImpl<?> r0 = getReusableCancellableContinuation();
        if (r0 == null) goto L6;
        r0.detachChild$kotlinx_coroutines_core();
        return;
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater r0 = _reusableCancellableContinuation$FU;
    L3:
        Object r1 = r0.get(this);
        if (r1 == null) goto L5;
        if ((r1 instanceof CancellableContinuationImpl) == true) goto L10;
        if (r1 == DispatchedContinuationKt.REUSABLE_CLAIMED) goto L3;
        if ((r1 instanceof Throwable) == true) goto L3;
        throw new IllegalStateException(("Inconsistent state " + r1).toString());
    L10:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, r1, DispatchedContinuationKt.REUSABLE_CLAIMED) == false) goto L3;
        return (CancellableContinuationImpl) r1;
    L5:
        _reusableCancellableContinuation$FU.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
        return null;
    }

    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(CancellableContinuation<?> r5) {
        AtomicReferenceFieldUpdater r0 = _reusableCancellableContinuation$FU;
    L3:
        Object r1 = r0.get(this);
        if (r1 != DispatchedContinuationKt.REUSABLE_CLAIMED) goto L9;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, r5) == false) goto L3;
        return null;
    L9:
        if ((r1 instanceof Throwable) == false) goto L17;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, r1, null) == false) goto L15;
        return (Throwable) r1;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        throw new IllegalStateException(("Inconsistent state " + r1).toString());
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(Throwable r5) {
        AtomicReferenceFieldUpdater r0 = _reusableCancellableContinuation$FU;
    L3:
        Object r1 = r0.get(this);
        if (Intrinsics.areEqual(r1, DispatchedContinuationKt.REUSABLE_CLAIMED) == true) goto L6;
        if ((r1 instanceof Throwable) == true) goto L10;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, r1, null) == false) goto L3;
        return false;
    L10:
        return true;
    L6:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, r5) == false) goto L3;
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        Object r0 = this._state;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return r0;
    L5:
        if (r0 == DispatchedContinuationKt.access$getUNDEFINED$p()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r7) {
        CoroutineContext r0 = this.continuation.getContext();
        Object r3 = CompletionStateKt.toState$default(r7, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(r0) == false) goto L5;
        this._state = r3;
        this.resumeMode = 0;
        this.dispatcher.mo2376dispatch(r0, this);
        return;
    L5:
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop r1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r1.isUnconfinedLoopActive() == false) goto L8;
        this._state = r3;
        this.resumeMode = 0;
        r1.dispatchUnconfined(this);
        return;
    L8:
        DispatchedContinuation<T> r4 = this;
        r1.incrementUseCount(true);
        CoroutineContext r5 = getContext();     // Catch: Throwable -> L18
        Object r6 = ThreadContextKt.updateThreadContext(r5, this.countOrElement);     // Catch: Throwable -> L18
        this.continuation.resumeWith(r7);     // Catch: Throwable -> L15
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        ThreadContextKt.restoreThreadContext(r5, r6);     // Catch: Throwable -> L18
    L13:
        if (r1.processUnconfinedEvent() == true) goto L13;
    L20:
        r1.decrementUseCount(true);
        return;
    L15:
        th = move-exception;
        ThreadContextKt.restoreThreadContext(r5, r6);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r4.handleFatalException$kotlinx_coroutines_core(th, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r1.decrementUseCount(true);
        throw th;
    }

    public final void resumeCancellableWith$kotlinx_coroutines_core(Object r8, Function1<? super Throwable, Unit> r9) {
        Object r10 = CompletionStateKt.toState(r8, r9);
        if (this.dispatcher.isDispatchNeeded(getContext()) == false) goto L5;
        this._state = r10;
        this.resumeMode = 1;
        this.dispatcher.mo2376dispatch(getContext(), this);
        return;
    L5:
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop r0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r0.isUnconfinedLoopActive() == false) goto L8;
        this._state = r10;
        this.resumeMode = 1;
        r0.dispatchUnconfined(this);
        return;
    L8:
        DispatchedContinuation<T> r2 = this;
        r0.incrementUseCount(true);
        Job r4 = (Job) getContext().get(Job.Key);     // Catch: Throwable -> L39
        if (r4 != null) goto L12;
    L14:
        boolean r11 = false;
    L15:
        if (r11 == true) goto L37;
        Continuation<T> r12 = this.continuation;     // Catch: Throwable -> L39
        Object r5 = this.countOrElement;     // Catch: Throwable -> L39
        CoroutineContext r6 = r12.getContext();     // Catch: Throwable -> L39
        Object r7 = ThreadContextKt.updateThreadContext(r6, r5);     // Catch: Throwable -> L39
        if (r7 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L20;
        UndispatchedCoroutine<?> r13 = CoroutineContextKt.updateUndispatchedCompletion(r12, r6, r7);     // Catch: Throwable -> L39
    L50:
        this.continuation.resumeWith(r8);     // Catch: Throwable -> L28
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L28
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L39
        if (r13 != null) goto L25;
    L26:
        ThreadContextKt.restoreThreadContext(r6, r7);     // Catch: Throwable -> L39
    L27:
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L39
        goto L37
    L25:
        if (r13.clearThreadContext() == false) goto L27;
    L28:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L39
        if (r13 != null) goto L32;
    L33:
        ThreadContextKt.restoreThreadContext(r6, r7);     // Catch: Throwable -> L39
    L34:
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L32:
        if (r13.clearThreadContext() == false) goto L34;
    L20:
        r13 = null;
    L37:
        if (r0.processUnconfinedEvent() == true) goto L37;
        InlineMarker.finallyStart(1);
    L42:
        r0.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        if (r4.isActive() == true) goto L14;
        CancellationException r15 = r4.getCancellationException();     // Catch: Throwable -> L39
        cancelCompletedResult$kotlinx_coroutines_core(r10, r15);     // Catch: Throwable -> L39
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L39
        resumeWith(Result.m803constructorimpl(ResultKt.createFailure(r15)));     // Catch: Throwable -> L39
        r11 = true;
    L39:
        th = move-exception;
        r2.handleFatalException$kotlinx_coroutines_core(th, null);     // Catch: Throwable -> L44
        InlineMarker.finallyStart(1);
    L44:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object r1, Throwable r2) {
        if ((r1 instanceof CompletedWithCancellation) == false) goto L6;
        ((CompletedWithCancellation) r1).onCancellation.invoke(r2);
        return;
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(Object r3) {
        Job r0 = (Job) getContext().get(Job.Key);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isActive() == true) goto L10;
        CancellationException r1 = r0.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(r3, r1);
        Result.Companion r4 = Result.Companion;
        resumeWith(Result.m803constructorimpl(ResultKt.createFailure(r1)));
        return true;
    L10:
        return false;
    }

    public final void resumeUndispatchedWith$kotlinx_coroutines_core(Object r5) {
        Continuation<T> r0 = this.continuation;
        Object r1 = this.countOrElement;
        CoroutineContext r2 = r0.getContext();
        Object r3 = ThreadContextKt.updateThreadContext(r2, r1);
        if (r3 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L5;
        UndispatchedCoroutine<?> r4 = CoroutineContextKt.updateUndispatchedCompletion(r0, r2, r3);
    L23:
        this.continuation.resumeWith(r5);     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        if (r4 != null) goto L11;
    L12:
        ThreadContextKt.restoreThreadContext(r2, r3);
    L13:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        if (r4.clearThreadContext() == false) goto L13;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r4 != null) goto L19;
    L20:
        ThreadContextKt.restoreThreadContext(r2, r3);
    L21:
        InlineMarker.finallyEnd(1);
        throw th;
    L19:
        if (r4.clearThreadContext() == false) goto L21;
    L5:
        r4 = null;
        goto L23
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext r1, T r2) {
        this._state = r2;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(r1, this);
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + DefaultContactListAdapter.SNIPPET_END_MATCH;
    }
}
