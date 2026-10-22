package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.Job;
import lb.n;
import qb.b;
import zb.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class JobKt__JobKt {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Throwable, n> {
        public AnonymousClass1(Object obj) {
            super(1, obj, JobNode.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        @Override // zb.l
        public /* bridge */ /* synthetic */ n invoke(Throwable th) {
            invoke2(th);
            return n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ((JobNode) this.receiver).invoke(th);
        }
    }

    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final void cancel(d dVar, CancellationException cancellationException) {
        Job job = (Job) dVar.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(d dVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(dVar, cancellationException);
    }

    public static final Object cancelAndJoin(Job job, b<? super n> bVar) {
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        Object objJoin = job.join(bVar);
        return objJoin == CoroutineSingletons.f10059a ? objJoin : n.f10413a;
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return invokeOnCompletion$default(job, false, new DisposeOnCompletion(disposableHandle), 1, null);
    }

    public static final void ensureActive(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final DisposableHandle invokeOnCompletion(Job job, boolean z, JobNode jobNode) {
        return job instanceof JobSupport ? ((JobSupport) job).invokeOnCompletionInternal$kotlinx_coroutines_core(z, jobNode) : job.invokeOnCompletion(jobNode.getOnCancelling(), z, new AnonymousClass1(jobNode));
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, JobNode jobNode, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = true;
        }
        return JobKt.invokeOnCompletion(job, z, jobNode);
    }

    public static final void ensureActive(d dVar) {
        Job job = (Job) dVar.get(Job.Key);
        if (job != null) {
            JobKt.ensureActive(job);
        }
    }
}
