package reactor.core.publisher;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import reactor.core.CoreSubscriber;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoToCompletableFuture<T> extends CompletableFuture<T> implements CoreSubscriber<T> {
    final boolean cancelSourceOnNext;
    final AtomicReference<Z9.e> ref = new AtomicReference<>();

    public MonoToCompletableFuture(boolean z10) {
        this.cancelSourceOnNext = z10;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        Z9.e andSet;
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

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onComplete() {
        if (this.ref.getAndSet(null) != null) {
            complete(null);
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onError(Throwable th) {
        if (this.ref.getAndSet(null) != null) {
            completeExceptionally(th);
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onNext(T t9) {
        Z9.e andSet = this.ref.getAndSet(null);
        if (andSet == null) {
            Operators.onNextDropped(t9, currentContext());
            return;
        }
        complete(t9);
        if (this.cancelSourceOnNext) {
            andSet.cancel();
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onSubscribe(Z9.e eVar) {
        if (Operators.validate(this.ref.getAndSet(eVar), eVar)) {
            eVar.request(Long.MAX_VALUE);
        } else {
            eVar.cancel();
        }
    }
}
