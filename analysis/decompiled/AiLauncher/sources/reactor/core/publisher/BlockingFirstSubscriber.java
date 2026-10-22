package reactor.core.publisher;

import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class BlockingFirstSubscriber<T> extends BlockingSingleSubscriber<T> {
    public BlockingFirstSubscriber(Context context) {
        super(context);
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public void onNext(T t10) {
        if (this.value == null) {
            this.value = t10;
            dispose();
            countDown();
        }
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return "blockFirst";
    }
}
