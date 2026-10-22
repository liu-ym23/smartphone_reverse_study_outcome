package reactor.core.publisher;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import reactor.core.CoreSubscriber;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoToCompletableFuture<T> extends CompletableFuture<T> implements CoreSubscriber<T> {
    final boolean cancelSourceOnNext;
    final AtomicReference<qd.e> ref = new AtomicReference<>();

    public MonoToCompletableFuture(boolean z10) {
        this.cancelSourceOnNext = z10;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        qd.e andSet;
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

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onComplete() {
        if (this.ref.getAndSet(null) != null) {
            complete(null);
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onError(Throwable th) {
        if (this.ref.getAndSet(null) != null) {
            completeExceptionally(th);
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onNext(T t10) {
        qd.e andSet = this.ref.getAndSet(null);
        if (andSet == null) {
            Operators.onNextDropped(t10, currentContext());
            return;
        }
        complete(t10);
        if (this.cancelSourceOnNext) {
            andSet.cancel();
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onSubscribe(qd.e eVar) {
        if (Operators.validate(this.ref.getAndSet(eVar), eVar)) {
            eVar.request(Long.MAX_VALUE);
        } else {
            eVar.cancel();
        }
    }
}
