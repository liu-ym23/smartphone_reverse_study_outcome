package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aI\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"recoverResult", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompletionStateKt {
    public static /* synthetic */ Object toState$default(Object r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return toState(r0, r1);
    }

    public static final <T> Object toState(Object r3, Function1<? super Throwable, Unit> r4) {
        Throwable r0 = Result.m806exceptionOrNullimpl(r3);
        if (r0 != null) goto L7;
        if (r4 != null) goto L9;
        return r3;
    L9:
        return new CompletedWithCancellation(r3, r4);
    L7:
        return new CompletedExceptionally(r0, false, 2, null);
    }

    public static final <T> Object toState(Object r3, CancellableContinuation<?> r4) {
        Throwable r0 = Result.m806exceptionOrNullimpl(r3);
        if (r0 != null) goto L6;
    L12:
        return r3;
    L6:
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L11;
        CancellableContinuation<?> r5 = r4;
        if ((r5 instanceof CoroutineStackFrame) == false) goto L11;
        r0 = StackTraceRecoveryKt.access$recoverFromStackFrame(r0, (CoroutineStackFrame) r5);
    L11:
        r3 = new CompletedExceptionally(r0, false, 2, null);
        goto L12
    }

    public static final <T> Object recoverResult(Object r1, Continuation<? super T> r2) {
        if ((r1 instanceof CompletedExceptionally) == false) goto L11;
        Result.Companion r0 = Result.Companion;
        Throwable r3 = ((CompletedExceptionally) r1).cause;
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L13;
        if ((r2 instanceof CoroutineStackFrame) == false) goto L13;
        r3 = StackTraceRecoveryKt.access$recoverFromStackFrame(r3, (CoroutineStackFrame) r2);
    L13:
        return Result.m803constructorimpl(ResultKt.createFailure(r3));
    L11:
        Result.Companion r4 = Result.Companion;
        return Result.m803constructorimpl(r1);
    }
}
