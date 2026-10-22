package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxTimeout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoTimeout<T, U, V> extends InternalMonoOperator<T, T> {
    static final Function NEVER = new a(12);
    final qd.c firstTimeout;
    final qd.c other;
    final String timeoutDescription;

    public MonoTimeout(Mono<? extends T> mono, qd.c cVar, qd.c cVar2) {
        super(mono);
        Objects.requireNonNull(cVar, "firstTimeout");
        this.firstTimeout = Mono.fromDirect(cVar);
        Objects.requireNonNull(cVar2, "other");
        this.other = Mono.fromDirect(cVar2);
        this.timeoutDescription = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$0(Object obj) {
        return Flux.never();
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxTimeout.TimeoutMainSubscriber(coreSubscriber, this.firstTimeout, NEVER, this.other, FluxTimeout.addNameToTimeoutDescription(this.source, this.timeoutDescription));
    }

    public MonoTimeout(Mono<? extends T> mono, qd.c cVar, String str) {
        super(mono);
        Objects.requireNonNull(cVar, "firstTimeout");
        this.firstTimeout = Mono.fromDirect(cVar);
        this.other = null;
        this.timeoutDescription = str;
    }
}
