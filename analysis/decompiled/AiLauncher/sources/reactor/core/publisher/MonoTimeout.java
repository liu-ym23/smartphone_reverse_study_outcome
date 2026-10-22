package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxTimeout;

/* loaded from: classes5.dex */
final class MonoTimeout<T, U, V> extends InternalMonoOperator<T, T> {
    static final Function NEVER = new Function() { // from class: reactor.core.publisher.V1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Flux.never();
        }
    };
    final qc.b<U> firstTimeout;
    final qc.b<? extends T> other;
    final String timeoutDescription;

    public MonoTimeout(Mono<? extends T> mono, qc.b<U> bVar, String str) {
        super(mono);
        Objects.requireNonNull(bVar, "firstTimeout");
        this.firstTimeout = Mono.fromDirect(bVar);
        this.other = null;
        this.timeoutDescription = str;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxTimeout.TimeoutMainSubscriber(coreSubscriber, this.firstTimeout, NEVER, this.other, FluxTimeout.addNameToTimeoutDescription(this.source, this.timeoutDescription));
    }

    public MonoTimeout(Mono<? extends T> mono, qc.b<U> bVar, qc.b<? extends T> bVar2) {
        super(mono);
        Objects.requireNonNull(bVar, "firstTimeout");
        this.firstTimeout = Mono.fromDirect(bVar);
        Objects.requireNonNull(bVar2, "other");
        this.other = Mono.fromDirect(bVar2);
        this.timeoutDescription = null;
    }
}
