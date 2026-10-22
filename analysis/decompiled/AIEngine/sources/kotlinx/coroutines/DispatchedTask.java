package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public DispatchedTask(int i10) {
        this.resumeMode = i10;
    }

    public abstract b<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            g.d(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            b<T> bVar = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            d context = bVar.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            Job job = null;
            UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(bVar, context, objUpdateThreadContext) : null;
            try {
                d context2 = bVar.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null && DispatchedTaskKt.isCancellableMode(this.resumeMode)) {
                    job = (Job) context2.get(Job.Key);
                }
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    bVar.resumeWith(c.a(cancellationException));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    bVar.resumeWith(c.a(exceptionalResult$kotlinx_coroutines_core));
                } else {
                    bVar.resumeWith(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core));
                }
                n nVar = n.f10413a;
                if (undispatchedCoroutineUpdateUndispatchedCompletion != null && !undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    return;
                }
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            } catch (Throwable th) {
                if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                throw th;
            }
        } catch (Throwable th2) {
            handleFatalException$kotlinx_coroutines_core(th2);
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }
}
