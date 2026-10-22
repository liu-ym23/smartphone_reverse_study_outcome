package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import lb.n;
import qb.b;

/* loaded from: classes.dex */
public final class JobKt {
    public static final CompletableJob Job(Job job) {
        return JobKt__JobKt.Job(job);
    }

    public static final void cancel(d dVar, CancellationException cancellationException) {
        JobKt__JobKt.cancel(dVar, cancellationException);
    }

    public static final Object cancelAndJoin(Job job, b<? super n> bVar) {
        return JobKt__JobKt.cancelAndJoin(job, bVar);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    public static final void ensureActive(d dVar) {
        JobKt__JobKt.ensureActive(dVar);
    }

    public static final DisposableHandle invokeOnCompletion(Job job, boolean z, JobNode jobNode) {
        return JobKt__JobKt.invokeOnCompletion(job, z, jobNode);
    }

    public static final void ensureActive(Job job) {
        JobKt__JobKt.ensureActive(job);
    }
}
