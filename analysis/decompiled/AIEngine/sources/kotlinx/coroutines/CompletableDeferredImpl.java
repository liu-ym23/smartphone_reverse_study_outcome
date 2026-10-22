package kotlinx.coroutines;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T> {
    public CompletableDeferredImpl(Job job) {
        super(true);
        initParentJob(job);
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(b<? super T> bVar) throws Throwable {
        Object objAwaitInternal = awaitInternal(bVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return objAwaitInternal;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean complete(T t8) {
        return makeCompleting$kotlinx_coroutines_core(t8);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
