package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001bJ\u0006\u0010\u001c\u001a\u00020\fJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001eR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public void cancelCompletedResult$kotlinx_coroutines_core(Object r1, Throwable r2) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object r1) {
        return r1;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public DispatchedTask(int r1) {
        this.resumeMode = r1;
    }

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object r2) {
        if ((r2 instanceof CompletedExceptionally) == false) goto L5;
        CompletedExceptionally r3 = (CompletedExceptionally) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.cause;
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        TaskContext r0 = this.taskContext;
        Continuation<T> r1 = getDelegate$kotlinx_coroutines_core();     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L54
        DispatchedContinuation r2 = (DispatchedContinuation) r1;     // Catch: Throwable -> L54
        Continuation<T> r3 = r2.continuation;     // Catch: Throwable -> L54
        Object r4 = r2.countOrElement;     // Catch: Throwable -> L54
        CoroutineContext r5 = r3.getContext();     // Catch: Throwable -> L54
        Object r6 = ThreadContextKt.updateThreadContext(r5, r4);     // Catch: Throwable -> L54
        if (r6 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L17;
        UndispatchedCoroutine<?> r7 = CoroutineContextKt.updateUndispatchedCompletion(r3, r5, r6);     // Catch: Throwable -> L54
    L61:
        CoroutineContext r8 = r3.getContext();     // Catch: Throwable -> L48
        Object r9 = takeState$kotlinx_coroutines_core();     // Catch: Throwable -> L48
        Throwable r10 = getExceptionalResult$kotlinx_coroutines_core(r9);     // Catch: Throwable -> L48
        if (r10 == null) goto L21;
    L23:
        Job r11 = null;
    L24:
        if (r11 != null) goto L26;
    L35:
        if (r10 == null) goto L37;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L48
        r3.resumeWith(Result.m803constructorimpl(ResultKt.createFailure(r10)));     // Catch: Throwable -> L48
    L38:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L48
        if (r7 != null) goto L41;
    L42:
        ThreadContextKt.restoreThreadContext(r5, r6);     // Catch: Throwable -> L54
    L65:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L45
        DispatchedTask<T> r15 = this;     // Catch: Throwable -> L45
        r0.afterTask();     // Catch: Throwable -> L45
        Object r16 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        handleFatalException$kotlinx_coroutines_core(null, Result.m806exceptionOrNullimpl(r16));
        return;
    L45:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L47
    L41:
        if (r7.clearThreadContext() == false) goto L65;
    L37:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L48
        r3.resumeWith(Result.m803constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(r9)));     // Catch: Throwable -> L48
        goto L38
    L26:
        if (r11.isActive() == true) goto L35;
        CancellationException r19 = r11.getCancellationException();     // Catch: Throwable -> L48
        cancelCompletedResult$kotlinx_coroutines_core(r9, r19);     // Catch: Throwable -> L48
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L48
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L30;
    L33:
        CancellationException r21 = r19;     // Catch: Throwable -> L48
    L34:
        r3.resumeWith(Result.m803constructorimpl(ResultKt.createFailure(r21)));     // Catch: Throwable -> L48
        goto L38
    L30:
        if ((r3 instanceof CoroutineStackFrame) == false) goto L33;
        r21 = StackTraceRecoveryKt.access$recoverFromStackFrame(r19, (CoroutineStackFrame) r3);     // Catch: Throwable -> L48
        goto L34
    L21:
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) == false) goto L23;
        r11 = (Job) r8.get(Job.Key);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if (r7 != null) goto L51;
    L52:
        ThreadContextKt.restoreThreadContext(r5, r6);     // Catch: Throwable -> L54
    L53:
        throw th;     // Catch: Throwable -> L54
    L51:
        if (r7.clearThreadContext() == false) goto L53;
    L17:
        r7 = null;
    L54:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L57
        r0.afterTask();     // Catch: Throwable -> L57
        Object r23 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        handleFatalException$kotlinx_coroutines_core(th, Result.m806exceptionOrNullimpl(r23));
        return;
    L57:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L59
    L5:
        if (this.resumeMode == (-1)) goto L7;
        boolean r25 = true;
    L8:
        if (r25 == true) goto L12;
        throw new AssertionError();
    L7:
        r25 = false;
        goto L8
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        kotlin.ExceptionsKt.addSuppressed(r3, r4);
    L8:
        if (r3 != null) goto L10;
        r3 = r4;
    L10:
        Intrinsics.checkNotNull(r3);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r3));
    }
}
