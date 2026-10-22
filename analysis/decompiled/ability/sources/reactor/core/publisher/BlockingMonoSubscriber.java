package reactor.core.publisher;

import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class BlockingMonoSubscriber<T> extends BlockingSingleSubscriber<T> {
    public BlockingMonoSubscriber(Context context) {
        super(context);
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onNext(T t9) {
        if (this.value == null) {
            this.value = t9;
            countDown();
        }
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return "block";
    }
}
