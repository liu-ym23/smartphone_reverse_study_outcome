package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxCreate;
import reactor.core.publisher.FluxSink;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes5.dex */
public abstract class FluxProcessor<IN, OUT> extends Flux<OUT> implements qc.c, qc.b, CoreSubscriber<IN>, Scannable, Disposable, ContextHolder {
    @Deprecated
    public static <T> FluxProcessor<qc.b<? extends T>, T> switchOnNext() {
        UnicastProcessor unicastProcessorCreate = UnicastProcessor.create();
        return wrap(unicastProcessorCreate, Flux.switchOnNext(unicastProcessorCreate));
    }

    public static <IN, OUT> FluxProcessor<IN, OUT> wrap(qc.c<IN> cVar, qc.b<OUT> bVar) {
        return new DelegateProcessor(bVar, cVar);
    }

    public Context currentContext() {
        return Context.empty();
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        onError(new CancellationException("Disposed"));
    }

    public long downstreamCount() {
        return inners().count();
    }

    public int getBufferSize() {
        return Integer.MAX_VALUE;
    }

    @Nullable
    public Throwable getError() {
        return null;
    }

    public final boolean hasCompleted() {
        return isTerminated() && getError() == null;
    }

    public boolean hasDownstreams() {
        return downstreamCount() != 0;
    }

    public final boolean hasError() {
        return isTerminated() && getError() != null;
    }

    public Stream<? extends Scannable> inners() {
        return Stream.empty();
    }

    public boolean isIdentityProcessor() {
        return false;
    }

    public boolean isSerialized() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(isTerminated());
        }
        if (attr == Scannable.Attr.ERROR) {
            return getError();
        }
        if (attr == Scannable.Attr.CAPACITY) {
            return Integer.valueOf(getBufferSize());
        }
        return null;
    }

    public final FluxProcessor<IN, OUT> serialize() {
        return new DelegateProcessor(this, Operators.serialize(this));
    }

    public boolean serializeAlways() {
        return true;
    }

    @Deprecated
    public final FluxSink<IN> sink() {
        return sink(FluxSink.OverflowStrategy.IGNORE);
    }

    @Deprecated
    public final FluxSink<IN> sink(FluxSink.OverflowStrategy overflowStrategy) {
        Objects.requireNonNull(overflowStrategy, "strategy");
        if (getBufferSize() == Integer.MAX_VALUE) {
            overflowStrategy = FluxSink.OverflowStrategy.IGNORE;
        }
        FluxCreate.BaseSink baseSinkCreateSink = FluxCreate.createSink(this, overflowStrategy);
        onSubscribe(baseSinkCreateSink);
        return (baseSinkCreateSink.isCancelled() || (isSerialized() && getBufferSize() == Integer.MAX_VALUE)) ? baseSinkCreateSink : serializeAlways() ? new FluxCreate.SerializedFluxSink(baseSinkCreateSink) : new FluxCreate.SerializeOnRequestSink(baseSinkCreateSink);
    }
}
