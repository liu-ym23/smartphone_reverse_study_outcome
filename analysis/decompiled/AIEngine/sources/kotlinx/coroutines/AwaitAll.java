package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class AwaitAll<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater notCompletedCount$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");
    private final Deferred<T>[] deferreds;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class AwaitAllNode extends JobNode {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _disposer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer$volatile");
        private volatile /* synthetic */ Object _disposer$volatile;
        private final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;

        /* JADX WARN: Multi-variable type inference failed */
        public AwaitAllNode(CancellableContinuation<? super List<? extends T>> cancellableContinuation) {
            this.continuation = cancellableContinuation;
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel) _disposer$volatile$FU.get(this);
        }

        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            g.l("handle");
            throw null;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(Throwable th) {
            if (th != null) {
                Object objTryResumeWithException = this.continuation.tryResumeWithException(th);
                if (objTryResumeWithException != null) {
                    this.continuation.completeResume(objTryResumeWithException);
                    AwaitAll<T>.DisposeHandlersOnCancel disposer = getDisposer();
                    if (disposer != null) {
                        disposer.disposeAll();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.getNotCompletedCount$volatile$FU().decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.continuation;
                Deferred[] deferredArr = ((AwaitAll) AwaitAll.this).deferreds;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resumeWith(arrayList);
            }
        }

        public final void setDisposer(AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            _disposer$volatile$FU.set(this, disposeHandlersOnCancel);
        }

        public final void setHandle(DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class DisposeHandlersOnCancel implements CancelHandler {
        private final AwaitAll<T>.AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            this.nodes = awaitAllNodeArr;
        }

        public final void disposeAll() {
            for (AwaitAll<T>.AwaitAllNode awaitAllNode : this.nodes) {
                awaitAllNode.getHandle().dispose();
            }
        }

        @Override // kotlinx.coroutines.CancelHandler
        public void invoke(Throwable th) {
            disposeAll();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(Deferred<? extends T>[] deferredArr) {
        this.deferreds = deferredArr;
        this.notCompletedCount$volatile = deferredArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicIntegerFieldUpdater getNotCompletedCount$volatile$FU() {
        return notCompletedCount$volatile$FU;
    }

    public final Object await(b<? super List<? extends T>> bVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        for (int i10 = 0; i10 < length; i10++) {
            Deferred deferred = this.deferreds[i10];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.setHandle(JobKt__JobKt.invokeOnCompletion$default(deferred, false, awaitAllNode, 1, null));
            n nVar = n.f10413a;
            awaitAllNodeArr[i10] = awaitAllNode;
        }
        AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i11 = 0; i11 < length; i11++) {
            awaitAllNodeArr[i11].setDisposer(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            disposeHandlersOnCancel.disposeAll();
        } else {
            CancellableContinuationKt.invokeOnCancellation(cancellableContinuationImpl, disposeHandlersOnCancel);
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return result;
    }
}
