package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
interface InnerProducer<O> extends Scannable, Z9.e {
    CoreSubscriber<? super O> actual();

    /* synthetic */ void cancel();

    /* synthetic */ void request(long j5);

    @Override // reactor.core.Scannable
    @Nullable
    default Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.ACTUAL) {
            return actual();
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }
}
