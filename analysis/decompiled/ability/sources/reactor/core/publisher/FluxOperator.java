package reactor.core.publisher;

import java.util.Objects;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
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
