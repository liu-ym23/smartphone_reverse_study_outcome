package reactor.core.publisher;

import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class BlockingLastSubscriber<T> extends BlockingSingleSubscriber<T> {
    public BlockingLastSubscriber(Context context) {
        super(context);
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onNext(T t9) {
        this.value = t9;
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return "blockLast";
    }
}
