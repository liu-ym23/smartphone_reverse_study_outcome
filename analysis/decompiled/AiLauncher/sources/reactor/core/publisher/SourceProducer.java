package reactor.core.publisher;

import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
interface SourceProducer<O> extends Scannable, qc.b<O> {
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

    @Override // qc.b
    /* synthetic */ void subscribe(qc.c cVar);
}
