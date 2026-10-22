package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes5.dex */
final class MonoCurrentContext extends Mono<Context> implements Fuseable, Scannable {
    static final MonoCurrentContext INSTANCE = new MonoCurrentContext();

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Context> coreSubscriber) {
        coreSubscriber.onSubscribe(Operators.scalarSubscription(coreSubscriber, coreSubscriber.currentContext()));
    }
}
