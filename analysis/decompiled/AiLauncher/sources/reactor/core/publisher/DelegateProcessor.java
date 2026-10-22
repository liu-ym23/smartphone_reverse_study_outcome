package reactor.core.publisher;

import java.util.Objects;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes5.dex */
final class DelegateProcessor<IN, OUT> extends FluxProcessor<IN, OUT> {
    final qc.b<OUT> downstream;
    final qc.c<IN> upstream;

    public DelegateProcessor(qc.b<OUT> bVar, qc.c<IN> cVar) {
        Objects.requireNonNull(bVar, "Downstream must not be null");
        this.downstream = bVar;
        Objects.requireNonNull(cVar, "Upstream must not be null");
        this.upstream = cVar;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        qc.c<IN> cVar = this.upstream;
        return cVar instanceof CoreSubscriber ? ((CoreSubscriber) cVar).currentContext() : Context.empty();
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
        qc.c<IN> cVar = this.upstream;
        if (cVar instanceof SerializedSubscriber) {
            return true;
        }
        return (cVar instanceof FluxProcessor) && ((FluxProcessor) cVar).isSerialized();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isTerminated() {
        return ((Boolean) Scannable.from(this.upstream).scanOrDefault(Scannable.Attr.TERMINATED, Boolean.valueOf(super.isTerminated()))).booleanValue();
    }

    @Override // reactor.core.publisher.FluxProcessor, qc.c
    public void onComplete() {
        this.upstream.onComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, qc.c
    public void onError(Throwable th) {
        this.upstream.onError(th);
    }

    @Override // reactor.core.publisher.FluxProcessor, qc.c
    public void onNext(IN in) {
        this.upstream.onNext(in);
    }

    @Override // qc.c
    public void onSubscribe(qc.d dVar) {
        this.upstream.onSubscribe(dVar);
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
