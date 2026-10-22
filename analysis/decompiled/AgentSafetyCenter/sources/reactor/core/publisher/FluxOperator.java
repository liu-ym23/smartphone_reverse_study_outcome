package reactor.core.publisher;

import java.util.Objects;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class FluxOperator<I, O> extends Flux<O> implements Scannable {
    protected final Flux<? extends I> source;

    public FluxOperator(Flux<? extends I> flux) {
        Objects.requireNonNull(flux);
        this.source = flux;
    }

    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.FALSE;
        }
        return null;
    }
}
