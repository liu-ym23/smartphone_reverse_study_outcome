package reactor.core.publisher;

import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class BlockingMonoSubscriber<T> extends BlockingSingleSubscriber<T> {
    public BlockingMonoSubscriber(Context context) {
        super(context);
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    @Override // reactor.core.publisher.BlockingSingleSubscriber, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public void onNext(T t10) {
        if (this.value == null) {
            this.value = t10;
            countDown();
        }
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return "block";
    }
}
