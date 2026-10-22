package reactor.core.publisher;

import java.util.Objects;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes4.dex */
final class DelegateProcessor<IN, OUT> extends FluxProcessor<IN, OUT> {
    final Z9.c downstream;
    final Z9.d upstream;

    public DelegateProcessor(Z9.c cVar, Z9.d dVar) {
        Objects.requireNonNull(cVar, "Downstream must not be null");
        this.downstream = cVar;
        Objects.requireNonNull(dVar, "Upstream must not be null");
        this.upstream = dVar;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        Z9.d dVar = this.upstream;
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
        Z9.d dVar = this.upstream;
        if (dVar instanceof SerializedSubscriber) {
            return true;
        }
        return (dVar instanceof FluxProcessor) && ((FluxProcessor) dVar).isSerialized();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isTerminated() {
        return ((Boolean) Scannable.from(this.upstream).scanOrDefault(Scannable.Attr.TERMINATED, Boolean.valueOf(super.isTerminated()))).booleanValue();
    }

    @Override // reactor.core.publisher.FluxProcessor, Z9.d
    public void onComplete() {
        this.upstream.onComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, Z9.d
    public void onError(Throwable th) {
        this.upstream.onError(th);
    }

    @Override // reactor.core.publisher.FluxProcessor, Z9.d
    public void onNext(IN in) {
        this.upstream.onNext(in);
    }

    @Override // Z9.d
    public void onSubscribe(Z9.e eVar) {
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
