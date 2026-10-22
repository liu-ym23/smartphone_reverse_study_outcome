package reactor.core.publisher;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import reactor.core.CoreSubscriber;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class MonoToCompletableFuture<T> extends CompletableFuture<T> implements CoreSubscriber<T> {
    final boolean cancelSourceOnNext;
    final AtomicReference<qc.d> ref = new AtomicReference<>();

    public MonoToCompletableFuture(boolean z10) {
        this.cancelSourceOnNext = z10;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        qc.d andSet;
        boolean zCancel = super.cancel(z10);
        if (zCancel && (andSet = this.ref.getAndSet(null)) != null) {
            andSet.cancel();
        }
        return zCancel;
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return Context.empty();
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onComplete() {
        if (this.ref.getAndSet(null) != null) {
            complete(null);
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onError(Throwable th) {
        if (this.ref.getAndSet(null) != null) {
            completeExceptionally(th);
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onNext(T t10) {
        qc.d andSet = this.ref.getAndSet(null);
        if (andSet == null) {
            Operators.onNextDropped(t10, currentContext());
            return;
        }
        complete(t10);
        if (this.cancelSourceOnNext) {
            andSet.cancel();
        }
    }

    @Override // reactor.core.CoreSubscriber, qc.c
    public void onSubscribe(qc.d dVar) {
        if (Operators.validate(this.ref.getAndSet(dVar), dVar)) {
            dVar.request(Long.MAX_VALUE);
        } else {
            dVar.cancel();
        }
    }
}
