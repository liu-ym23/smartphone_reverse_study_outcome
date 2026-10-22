package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class CompletedContinuation<R> {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final q<Throwable, R, d, n> onCancellation;
    public final R result;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(R r, CancelHandler cancelHandler, q<? super Throwable, ? super R, ? super d, n> qVar, Object obj, Throwable th) {
        this.result = r;
        this.cancelHandler = cancelHandler;
        this.onCancellation = qVar;
        this.idempotentResume = obj;
        this.cancelCause = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, q qVar, Object obj2, Throwable th, int i10, Object obj3) {
        R r = obj;
        if ((i10 & 1) != 0) {
            r = completedContinuation.result;
        }
        if ((i10 & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        if ((i10 & 4) != 0) {
            qVar = completedContinuation.onCancellation;
        }
        if ((i10 & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        if ((i10 & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        Throwable th2 = th;
        q qVar2 = qVar;
        return completedContinuation.copy(r, cancelHandler, qVar2, obj2, th2);
    }

    public final CompletedContinuation<R> copy(R r, CancelHandler cancelHandler, q<? super Throwable, ? super R, ? super d, n> qVar, Object obj, Throwable th) {
        return new CompletedContinuation<>(r, cancelHandler, qVar, obj, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return g.b(this.result, completedContinuation.result) && g.b(this.cancelHandler, completedContinuation.cancelHandler) && g.b(this.onCancellation, completedContinuation.onCancellation) && g.b(this.idempotentResume, completedContinuation.idempotentResume) && g.b(this.cancelCause, completedContinuation.cancelCause);
    }

    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    public int hashCode() {
        R r = this.result;
        int iHashCode = (r == null ? 0 : r.hashCode()) * 31;
        CancelHandler cancelHandler = this.cancelHandler;
        int iHashCode2 = (iHashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        q<Throwable, R, d, n> qVar = this.onCancellation;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj = this.idempotentResume;
        int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void invokeHandlers(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            cancellableContinuationImpl.callCancelHandler(cancelHandler, th);
        }
        q<Throwable, R, d, n> qVar = this.onCancellation;
        if (qVar != null) {
            cancellableContinuationImpl.callOnCancellation(qVar, th, this.result);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, q qVar, Object obj2, Throwable th, int i10, e eVar) {
        this(obj, (i10 & 2) != 0 ? null : cancelHandler, (i10 & 4) != 0 ? null : qVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
