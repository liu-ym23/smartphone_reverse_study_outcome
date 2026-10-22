package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.android.contacts.numberassistant.MarkInfoUtil;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001b\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103J;\u0010.\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/04j\u0002`72\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0017\u00108\u001a\u00020/2\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:H\u0082\bJ1\u0010;\u001a\u00020/2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/042\u0006\u00102\u001a\u000203J\u001e\u0010=\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010@\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001f\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0010¢\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\u0012H\u0016J\r\u0010G\u001a\u00020/H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020/H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020NH\u0016J\u0019\u0010O\u001a\u0004\u0018\u0001032\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\bPJ\n\u0010Q\u001a\u0004\u0018\u00010\u0012H\u0001J\u0010\u0010R\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0016J\u001f\u0010U\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020/H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0010H\u0002J1\u0010Z\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/04j\u0002`7H\u0016J\u001c\u0010Z\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010[\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0002J\b\u0010]\u001a\u00020\u001dH\u0002J1\u0010^\u001a\u0002012'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/04j\u0002`7H\u0002J\u001a\u0010_\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010`\u001a\u00020(H\u0014J\u0015\u0010a\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bbJ\r\u0010c\u001a\u00020/H\u0000¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020\u001dH\u0001J:\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00028\u00002#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0016¢\u0006\u0002\u0010hJA\u0010i\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0002J\u001e\u0010j\u001a\u00020/2\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000lH\u0016ø\u0001\u0000¢\u0006\u0002\u0010mJS\u0010n\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020o2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u0001042\b\u0010p\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010q\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\brJ\b\u0010s\u001a\u00020(H\u0016J\b\u0010t\u001a\u00020\u001dH\u0002J!\u0010t\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00028\u00002\b\u0010p\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010uJF\u0010t\u001a\u0004\u0018\u00010\u00122\u0006\u0010g\u001a\u00028\u00002\b\u0010p\u001a\u0004\u0018\u00010\u00122#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0016¢\u0006\u0002\u0010vJC\u0010w\u001a\u0004\u0018\u00010x2\b\u0010-\u001a\u0004\u0018\u00010\u00122\b\u0010p\u001a\u0004\u0018\u00010\u00122#\u0010<\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u000104H\u0002J\u0012\u0010y\u001a\u0004\u0018\u00010\u00122\u0006\u0010z\u001a\u000203H\u0016J\b\u0010{\u001a\u00020\u001dH\u0002J\u0019\u0010|\u001a\u00020/*\u00020}2\u0006\u0010g\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010~J\u0014\u0010\u007f\u001a\u00020/*\u00020}2\u0006\u0010z\u001a\u000203H\u0016R\t\u0010\f\u001a\u00020\rX\u0082\u0004R\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004R\u001c\u0010\u0013\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0080\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/DisposableHandle;", "_state", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "alreadyResumedError", "", "proposedUpdate", "callCancelHandler", "", "handler", "Lkotlinx/coroutines/CancelHandler;", "cause", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callOnCancellation", "onCancellation", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "cancel", "cancelCompletedResult", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "completeResume", "token", "detachChild", "detachChild$kotlinx_coroutines_core", "detachChildIfNonResuable", "dispatchResume", "mode", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getResult", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "installParentHandle", "invokeOnCancellation", "index", "invokeOnCancellationImpl", "isReusable", "makeCancelHandler", "multipleHandlersError", "nameString", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resetStateReusable", "resume", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "takeState", "takeState$kotlinx_coroutines_core", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeWithException", "exception", "trySuspend", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    private static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = null;
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = null;
    private static final AtomicReferenceFieldUpdater _state$FU = null;

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    private volatile Object _parentHandle;

    @Volatile
    private volatile Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;

    static {
        _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
        _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater r1, Function1<? super Integer, Unit> r2, Object r3) {
    L2:
        r2.invoke(Integer.valueOf(r1.get(r3)));
        goto L2
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    private final void update$atomicfu(AtomicIntegerFieldUpdater r2, Function1<? super Integer, Integer> r3, Object r4) {
    L2:
        int r1 = r2.get(r4);
        if (r2.compareAndSet(r4, r1, r3.invoke(Integer.valueOf(r1)).intValue()) == false) goto L2;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> r2, int r3) {
        super(r3);
        this.delegate = r2;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        this.context = r2.getContext();
        this._decisionAndIndex = 536870911;
        this._state = Active.INSTANCE;
        return;
    L5:
        if (r3 == (-1)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L12;
        throw new AssertionError();
    L7:
        r4 = false;
        goto L8
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) _parentHandle$FU.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    private final String getStateDebugRepresentation() {
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof NotCompleted) == false) goto L6;
        return "Active";
    L6:
        if ((r1 instanceof CancelledContinuation) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle r0 = installParentHandle();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isCompleted() == false) goto L9;
        r0.dispose();
        _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
        return;
    }

    private final boolean isReusable() {
        if (DispatchedTaskKt.isReusableMode(this.resumeMode) == false) goto L7;
        Continuation<T> r1 = this.delegate;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((DispatchedContinuation) r1).isReusable$kotlinx_coroutines_core() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean resetStateReusable() {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (this.resumeMode != 2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L15;
    L22:
        AtomicReferenceFieldUpdater r1 = _state$FU;
        Object r3 = r1.get(this);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L30;
        if ((!(r3 instanceof NotCompleted)) == true) goto L30;
        throw new AssertionError();
    L30:
        if ((r3 instanceof CompletedContinuation) == true) goto L32;
    L35:
        _decisionAndIndex$FU.set(this, 536870911);
        r1.set(this, Active.INSTANCE);
        return true;
    L32:
        if (((CompletedContinuation) r3).idempotentResume == null) goto L35;
        detachChild$kotlinx_coroutines_core();
        return false;
    L15:
        if (getParentHandle() == NonDisposableHandle.INSTANCE) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L22;
        throw new AssertionError();
    L17:
        r2 = false;
        goto L18
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r1 = this.delegate;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object r20, Throwable r21) {
        AtomicReferenceFieldUpdater r1 = _state$FU;
    L3:
        Object r10 = r1.get(this);
        if ((r10 instanceof NotCompleted) == true) goto L22;
        if ((r10 instanceof CompletedExceptionally) == true) goto L7;
        if ((r10 instanceof CompletedContinuation) == true) goto L10;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r10, new CompletedContinuation(r10, null, null, null, r21, 14, null)) == false) goto L3;
        return;
    L10:
        CompletedContinuation r2 = (CompletedContinuation) r10;
        if ((!r2.getCancelled()) == false) goto L17;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r10, CompletedContinuation.copy$default(r2, null, null, null, null, r21, 15, null)) == false) goto L3;
        r2.invokeHandlers(this, r21);
        return;
    L17:
        throw new IllegalStateException("Must be called at most once".toString());
    L7:
        return;
    L22:
        throw new IllegalStateException("Not completed".toString());
    }

    private final boolean cancelLater(Throwable r2) {
        if (isReusable() == true) goto L6;
        return false;
    L6:
        Continuation<T> r1 = this.delegate;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) r1).postponeCancellation$kotlinx_coroutines_core(r2);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable r8) {
        AtomicReferenceFieldUpdater r0 = _state$FU;
    L3:
        Object r1 = r0.get(this);
        boolean r3 = false;
        if ((r1 instanceof NotCompleted) == false) goto L5;
        CancellableContinuationImpl<T> r4 = this;
        if ((r1 instanceof CancelHandler) == false) goto L9;
    L10:
        r3 = true;
    L12:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r1, new CancelledContinuation(r4, r8, r3)) == false) goto L3;
        NotCompleted r2 = (NotCompleted) r1;
        if ((r2 instanceof CancelHandler) == false) goto L17;
        callCancelHandler((CancelHandler) r1, r8);
    L19:
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    L17:
        if ((r2 instanceof Segment) == false) goto L19;
        callSegmentOnCancellation((Segment) r1, r8);
        goto L19
    L9:
        if ((r1 instanceof Segment) == false) goto L12;
    L5:
        return false;
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable r2) {
        if (cancelLater(r2) == false) goto L5;
        return;
    L5:
        cancel(r2);
        detachChildIfNonResuable();
    }

    private final void callCancelHandlerSafely(Function0<Unit> r5) {
        r5.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void callCancelHandler(CancelHandler r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    private final void callSegmentOnCancellation(Segment<?> r4, Throwable r5) {
        int r0 = _decisionAndIndex$FU.get(this) & 536870911;
        if (r0 == 536870911) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L13;
        r4.onCancellation(r0, r5, getContext());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    public Throwable getContinuationCancellationCause(Job r1) {
        return r1.getCancellationException();
    }

    private final boolean trySuspend() {
        AtomicIntegerFieldUpdater r0 = _decisionAndIndex$FU;
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        if (r2 != 0) goto L6;
        if (_decisionAndIndex$FU.compareAndSet(this, r1, MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST + (536870911 & r1)) == false) goto L3;
        return true;
    L6:
        if (r2 != 2) goto L10;
        return false;
    L10:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final boolean tryResume() {
        AtomicIntegerFieldUpdater r0 = _decisionAndIndex$FU;
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        if (r2 != 0) goto L5;
        if (_decisionAndIndex$FU.compareAndSet(this, r1, 1073741824 + (536870911 & r1)) == false) goto L3;
        return true;
    L5:
        if (r2 != 1) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already resumed".toString());
    }

    public final Object getResult() {
        boolean r0 = isReusable();
        if (trySuspend() == true) goto L5;
        if (r0 == false) goto L13;
        releaseClaimedReusableContinuation$kotlinx_coroutines_core();
    L13:
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof CompletedExceptionally) == false) goto L23;
        Throwable r2 = ((CompletedExceptionally) r1).cause;
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L37;
        CancellableContinuationImpl<T> r3 = this;
        if ((r3 instanceof CoroutineStackFrame) == true) goto L21;
        throw r2;
    L21:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r2, r3);
    L37:
        throw r2;
    L23:
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) == false) goto L36;
        Job r4 = (Job) getContext().get(Job.Key);
        if (r4 == null) goto L36;
        if (r4.isActive() == true) goto L36;
        CancellationException r5 = r4.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(r1, r5);
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L39;
        CancellableContinuationImpl<T> r6 = this;
        if ((r6 instanceof CoroutineStackFrame) == true) goto L34;
        throw r5;
    L34:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r5, r6);
    L39:
        throw r5;
    L36:
        return getSuccessfulResult$kotlinx_coroutines_core(r1);
    L5:
        if (getParentHandle() != null) goto L7;
        installParentHandle();
    L7:
        if (r0 == false) goto L10;
        releaseClaimedReusableContinuation$kotlinx_coroutines_core();
    L10:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    private final DisposableHandle installParentHandle() {
        Job r1 = (Job) getContext().get(Job.Key);
        if (r1 != null) goto L5;
        return null;
    L5:
        DisposableHandle r2 = Job.DefaultImpls.invokeOnCompletion$default(r1, true, false, new ChildContinuation(this), 2, null);
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_parentHandle$FU, this, null, r2);
        return r2;
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Continuation<T> r0 = this.delegate;
        if ((r0 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r1 = (DispatchedContinuation) r0;
    L6:
        if (r1 == null) goto L12;
        Throwable r2 = r1.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this);
        if (r2 == null) goto L13;
        detachChild$kotlinx_coroutines_core();
        cancel(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r8) {
        resumeImpl$default(this, CompletionStateKt.toState(r8, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T r2, Function1<? super Throwable, Unit> r3) {
        resumeImpl(r2, this.resumeMode, r3);
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> r5, int r6) {
        AtomicIntegerFieldUpdater r0 = _decisionAndIndex$FU;
    L3:
        int r1 = r0.get(this);
        if ((r1 & 536870911) != 536870911) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L13;
        if (r0.compareAndSet(this, r1, ((r1 >> 29) << 29) + r6) == false) goto L3;
        invokeOnCancellationImpl(r5);
        return;
    L13:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    L6:
        r2 = false;
        goto L7
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> r1) {
        invokeOnCancellationImpl(makeCancelHandler(r1));
    }

    private final void invokeOnCancellationImpl(Object r22) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L15:
        AtomicReferenceFieldUpdater r2 = _state$FU;
    L16:
        Object r12 = r2.get(this);
        if ((r12 instanceof Active) == true) goto L19;
        if ((r12 instanceof CancelHandler) == false) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == true) goto L26;
        boolean r5 = r12 instanceof CompletedExceptionally;
        if (r5 == true) goto L29;
        if ((r12 instanceof CompletedContinuation) == true) goto L47;
        if ((r22 instanceof Segment) == true) goto L62;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r12, new CompletedContinuation(r12, (CancelHandler) r22, null, null, null, 28, null)) == false) goto L16;
        return;
    L62:
        return;
    L47:
        CompletedContinuation r13 = (CompletedContinuation) r12;
        if (r13.cancelHandler == null) goto L51;
        multipleHandlersError(r22, r12);
    L51:
        if ((r22 instanceof Segment) == true) goto L52;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        CancelHandler r15 = (CancelHandler) r22;
        if (r13.getCancelled() == true) goto L55;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r12, CompletedContinuation.copy$default(r13, null, r15, null, null, null, 29, null)) == false) goto L16;
        return;
    L55:
        callCancelHandler(r15, r13.cancelCause);
        return;
    L52:
        return;
    L29:
        CompletedExceptionally r3 = (CompletedExceptionally) r12;
        if (r3.makeHandled() == true) goto L33;
        multipleHandlersError(r22, r12);
    L33:
        if ((r12 instanceof CancelledContinuation) == false) goto L84;
        Throwable r6 = null;
        if (r5 == true) goto L38;
        r3 = null;
    L38:
        if (r3 == null) goto L41;
        r6 = r3.cause;
    L41:
        if ((r22 instanceof CancelHandler) == false) goto L43;
        callCancelHandler((CancelHandler) r22, r6);
        return;
    L43:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        callSegmentOnCancellation((Segment) r22, r6);
        return;
    L84:
        return;
    L26:
        multipleHandlersError(r22, r12);
        goto L16
    L24:
        r4 = r12 instanceof Segment;
        goto L25
    L19:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r12, r22) == false) goto L16;
        return;
    L5:
        if ((r22 instanceof CancelHandler) == false) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L15;
        throw new AssertionError();
    L7:
        if ((r22 instanceof Segment) == true) goto L10;
        r7 = false;
        goto L11
    }

    private final void multipleHandlersError(Object r3, Object r4) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r4).toString());
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> r1) {
        if ((r1 instanceof CancelHandler) == false) goto L6;
        return (CancelHandler) r1;
    L6:
        return new InvokeOnCancel(r1);
    }

    private final void dispatchResume(int r2) {
        if (tryResume() == false) goto L5;
        return;
    L5:
        DispatchedTaskKt.dispatch(this, r2);
    }

    private final Object resumedState(NotCompleted r9, Object r10, int r11, Function1<? super Throwable, Unit> r12, Object r13) {
        if ((r10 instanceof CompletedExceptionally) == false) goto L23;
        boolean r14 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L14;
        if (r13 != null) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L14;
        throw new AssertionError();
    L8:
        r8 = false;
    L14:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L36;
        if (r12 == null) goto L18;
        r14 = false;
    L18:
        if (r14 == false) goto L21;
        return r10;
    L21:
        throw new AssertionError();
    L36:
        return r10;
    L23:
        if (DispatchedTaskKt.isCancellableMode(r11) == true) goto L26;
        if (r13 != null) goto L26;
        return r10;
    L26:
        if (r12 != null) goto L31;
        if ((r9 instanceof CancelHandler) == true) goto L31;
        if (r13 != null) goto L31;
        return r10;
    L31:
        if ((r9 instanceof CancelHandler) == false) goto L33;
        CancelHandler r15 = (CancelHandler) r9;
    L35:
        return new CompletedContinuation(r10, r15, r12, r13, null, 16, null);
    L33:
        r15 = null;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl r0, Object r1, int r2, Function1 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.resumeImpl(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final void resumeImpl(Object r10, int r11, Function1<? super Throwable, Unit> r12) {
        AtomicReferenceFieldUpdater r0 = _state$FU;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof NotCompleted) == false) goto L10;
        Object r2 = resumedState((NotCompleted) r1, r10, r11, r12, null);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r1, r2) == false) goto L3;
        detachChildIfNonResuable();
        dispatchResume(r11);
        return;
    L10:
        if ((r1 instanceof CancelledContinuation) == false) goto L16;
        CancelledContinuation r3 = (CancelledContinuation) r1;
        if (r3.makeResumed() == false) goto L16;
        if (r12 == null) goto L21;
        callOnCancellation(r12, r3.cause);
        return;
    L21:
        return;
    L16:
        alreadyResumedError(r10);
        throw new KotlinNothingValueException();
    }

    private final Symbol tryResumeImpl(Object r10, Object r11, Function1<? super Throwable, Unit> r12) {
        AtomicReferenceFieldUpdater r0 = _state$FU;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof NotCompleted) == false) goto L10;
        Object r2 = resumedState((NotCompleted) r1, r10, this.resumeMode, r12, r11);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, r1, r2) == false) goto L3;
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    L10:
        if ((r1 instanceof CompletedContinuation) == false) goto L26;
        if (r11 == null) goto L27;
        CompletedContinuation r3 = (CompletedContinuation) r1;
        if (r3.idempotentResume == r11) goto L15;
        return null;
    L15:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L22;
        if (Intrinsics.areEqual(r3.result, r10) == true) goto L22;
        throw new AssertionError();
    L22:
        return CancellableContinuationImplKt.RESUME_TOKEN;
    L27:
        return null;
    L26:
        return null;
    }

    private final Void alreadyResumedError(Object r3) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + r3).toString());
    }

    private final void detachChildIfNonResuable() {
        if (isReusable() == true) goto L6;
        detachChild$kotlinx_coroutines_core();
        return;
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle r0 = getParentHandle();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispose();
        _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T r2, Object r3) {
        return tryResumeImpl(r2, r3, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T r1, Object r2, Function1<? super Throwable, Unit> r3) {
        return tryResumeImpl(r1, r2, r3);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable r5) {
        return tryResumeImpl(new CompletedExceptionally(r5, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object r2) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        dispatchResume(this.resumeMode);
        return;
    L5:
        if (r2 != CancellableContinuationImplKt.RESUME_TOKEN) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher r7, T r8) {
        Continuation<T> r0 = this.delegate;
        CoroutineDispatcher r2 = null;
        if ((r0 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r1 = (DispatchedContinuation) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.dispatcher;
    L8:
        if (r2 != r7) goto L10;
        int r9 = 4;
    L11:
        resumeImpl$default(this, r8, r9, null, 4, null);
        return;
    L10:
        r9 = this.resumeMode;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher r10, Throwable r11) {
        Continuation<T> r0 = this.delegate;
        CoroutineDispatcher r2 = null;
        if ((r0 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r1 = (DispatchedContinuation) r0;
    L6:
        CompletedExceptionally r4 = new CompletedExceptionally(r11, false, 2, null);
        if (r1 == null) goto L9;
        r2 = r1.dispatcher;
    L9:
        if (r2 != r10) goto L11;
        int r12 = 4;
    L12:
        resumeImpl$default(this, r4, r12, null, 4, null);
        return;
    L11:
        r12 = this.resumeMode;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object r1) {
        if ((r1 instanceof CompletedContinuation) == true) goto L5;
        return r1;
    L5:
        return (T) ((CompletedContinuation) r1).result;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object r2) {
        Throwable r3 = super.getExceptionalResult$kotlinx_coroutines_core(r2);
        if (r3 == null) goto L10;
        Continuation<T> r1 = this.delegate;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L7;
        return r3;
    L7:
        if ((r1 instanceof CoroutineStackFrame) == true) goto L13;
        return r3;
    L13:
        return StackTraceRecoveryKt.access$recoverFromStackFrame(r3, (CoroutineStackFrame) r1);
    L10:
        return null;
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }
}
