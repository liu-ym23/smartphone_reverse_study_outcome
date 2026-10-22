package reactor.core.publisher;

import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
interface SourceProducer<O> extends Scannable, Z9.c {
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

    @Override // Z9.c
    /* synthetic */ void subscribe(Z9.d dVar);
}
