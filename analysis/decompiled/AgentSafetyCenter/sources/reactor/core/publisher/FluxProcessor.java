package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
public abstract class FluxProcessor<IN, OUT> extends Flux<OUT> implements qd.d, qd.c, CoreSubscriber<IN>, Scannable, Disposable, ContextHolder {
    @Deprecated
    public static <T> FluxProcessor<qd.c, T> switchOnNext() {
        UnicastProcessor unicastProcessorCreate = UnicastProcessor.create();
        return wrap(unicastProcessorCreate, Flux.switchOnNext(unicastProcessorCreate));
    }

    public static <IN, OUT> FluxProcessor<IN, OUT> wrap(qd.d dVar, qd.c cVar) {
        return new DelegateProcessor(cVar, dVar);
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
        return Reader.READ_DONE;
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
    public final FluxSink<IN> sink(FluxSink.OverflowStrategy overflowStrategy) {
        Objects.requireNonNull(overflowStrategy, "strategy");
        if (getBufferSize() == Integer.MAX_VALUE) {
            overflowStrategy = FluxSink.OverflowStrategy.IGNORE;
        }
        FluxCreate.BaseSink baseSinkCreateSink = FluxCreate.createSink(this, overflowStrategy);
        onSubscribe(baseSinkCreateSink);
        return (baseSinkCreateSink.isCancelled() || (isSerialized() && getBufferSize() == Integer.MAX_VALUE)) ? baseSinkCreateSink : serializeAlways() ? new FluxCreate.SerializedFluxSink(baseSinkCreateSink) : new FluxCreate.SerializeOnRequestSink(baseSinkCreateSink);
    }

    @Deprecated
    public final FluxSink<IN> sink() {
        return sink(FluxSink.OverflowStrategy.IGNORE);
    }
}
