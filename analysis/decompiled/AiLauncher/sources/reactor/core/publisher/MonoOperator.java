package reactor.core.publisher;

import java.util.Objects;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public abstract class MonoOperator<I, O> extends Mono<O> implements Scannable {
    protected final Mono<? extends I> source;

    public MonoOperator(Mono<? extends I> mono) {
        Objects.requireNonNull(mono);
        this.source = mono;
    }

    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.MAX_VALUE;
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
