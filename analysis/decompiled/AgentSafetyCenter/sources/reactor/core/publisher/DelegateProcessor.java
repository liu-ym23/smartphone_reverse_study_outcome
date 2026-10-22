package reactor.core.publisher;

import java.util.Objects;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
final class DelegateProcessor<IN, OUT> extends FluxProcessor<IN, OUT> {
    final qd.c downstream;
    final qd.d upstream;

    public DelegateProcessor(qd.c cVar, qd.d dVar) {
        Objects.requireNonNull(cVar, "Downstream must not be null");
        this.downstream = cVar;
        Objects.requireNonNull(dVar, "Upstream must not be null");
        this.upstream = dVar;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        qd.d dVar = this.upstream;
        return dVar instanceof CoreSubscriber ? ((CoreSubscriber) dVar).currentContext() : Context.empty();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public int getBufferSize() {
        return ((Integer) Scannable.from(this.upstream).scanOrDefault(Scannable.Attr.CAPACITY, Integer.valueOf(super.getBufferSize()))).intValue();
    }

    @Override // reactor.core.publisher.FluxProcessor
    @Nullable
    public Throwable getError() {
        return (Throwable) Scannable.from(this.upstream).scanOrDefault(Scannable.Attr.ERROR, super.getError());
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Scannable.from(this.upstream).inners();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isSerialized() {
        qd.d dVar = this.upstream;
        if (dVar instanceof SerializedSubscriber) {
            return true;
        }
        return (dVar instanceof FluxProcessor) && ((FluxProcessor) dVar).isSerialized();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isTerminated() {
        return ((Boolean) Scannable.from(this.upstream).scanOrDefault(Scannable.Attr.TERMINATED, Boolean.valueOf(super.isTerminated()))).booleanValue();
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onComplete() {
        this.upstream.onComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onError(Throwable th) {
        this.upstream.onError(th);
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onNext(IN in) {
        this.upstream.onNext(in);
    }

    @Override // qd.d
    public void onSubscribe(qd.e eVar) {
        this.upstream.onSubscribe(eVar);
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PARENT ? this.downstream : Scannable.from(this.upstream).scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super OUT> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe");
        this.downstream.subscribe(coreSubscriber);
    }
}
