package reactor.core.publisher;

import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface SourceProducer<O> extends Scannable, qd.c {
    @Override // reactor.core.Scannable
    @Nullable
    default Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT || attr == Scannable.Attr.ACTUAL || attr != InternalProducerAttr.INSTANCE) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // reactor.core.Scannable
    default String stepName() {
        return "source(" + getClass().getSimpleName() + ")";
    }

    @Override // qd.c
    /* synthetic */ void subscribe(qd.d dVar);
}
