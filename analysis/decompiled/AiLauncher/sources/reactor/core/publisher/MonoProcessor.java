package reactor.core.publisher;

import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes5.dex */
public abstract class MonoProcessor<O> extends Mono<O> implements qc.c, qc.b, CoreSubscriber<O>, Disposable, qc.d, Scannable {
    public static /* synthetic */ InnerProducer[] R(int i10) {
        return new InnerProducer[i10];
    }

    @Deprecated
    public static <T> MonoProcessor<T> create() {
        return new NextProcessor(null);
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public O block() {
        return block(null);
    }

    @Override // qc.d
    @Deprecated
    public void cancel() {
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        final Class<InnerProducer> cls = InnerProducer.class;
        return Operators.multiSubscribersContext((InnerProducer[]) inners().filter(new Predicate() { // from class: reactor.core.publisher.R1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((Scannable) obj);
            }
        }).map(new Function() { // from class: reactor.core.publisher.S1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (InnerProducer) cls.cast((Scannable) obj);
            }
        }).toArray(new IntFunction() { // from class: reactor.core.publisher.T1
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return MonoProcessor.R(i10);
            }
        }));
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        onError(new CancellationException("Disposed"));
    }

    public long downstreamCount() {
        return inners().count();
    }

    @Nullable
    public Throwable getError() {
        return null;
    }

    public final boolean hasDownstreams() {
        return downstreamCount() != 0;
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Stream.empty();
    }

    @Deprecated
    public boolean isCancelled() {
        return false;
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return isTerminated() || isCancelled();
    }

    public final boolean isError() {
        return getError() != null;
    }

    public final boolean isSuccess() {
        return isTerminated() && !isError();
    }

    public boolean isTerminated() {
        return false;
    }

    @Override // qc.c
    public abstract /* synthetic */ void onComplete();

    @Override // qc.c
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // qc.c
    public abstract /* synthetic */ void onNext(Object obj);

    @Nullable
    @Deprecated
    public O peek() {
        return null;
    }

    @Override // qc.d
    @Deprecated
    public void request(long j10) {
        Operators.validate(j10);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        boolean zIsTerminated = isTerminated();
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(zIsTerminated);
        }
        if (attr == Scannable.Attr.ERROR) {
            return getError();
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.MAX_VALUE;
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isCancelled());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public O block(@Nullable Duration duration) {
        return peek();
    }
}
