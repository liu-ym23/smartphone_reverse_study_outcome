package kotlinx.coroutines;

import kotlin.coroutines.d;
import lb.n;
import qb.b;
import zb.l;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface CancellableContinuation<T> extends b<T> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean cancel$default(CancellableContinuation cancellableContinuation, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return cancellableContinuation.cancel(th);
        }
    }

    boolean cancel(Throwable th);

    void completeResume(Object obj);

    void invokeOnCancellation(l<? super Throwable, n> lVar);

    boolean isActive();

    boolean isCompleted();

    <R extends T> void resume(R r, q<? super Throwable, ? super R, ? super d, n> qVar);

    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t8);

    <R extends T> Object tryResume(R r, Object obj, q<? super Throwable, ? super R, ? super d, n> qVar);

    Object tryResumeWithException(Throwable th);
}
