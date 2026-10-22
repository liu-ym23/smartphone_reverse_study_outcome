package reactor.core.publisher;

import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes4.dex */
public abstract class MonoProcessor<O> extends Mono<O> implements Z9.d, Z9.c, CoreSubscriber<O>, Disposable, Z9.e, Scannable {
    @Deprecated
    public static <T> MonoProcessor<T> create() {
        return new NextProcessor(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InnerProducer[] lambda$currentContext$0(int i) {
        return new InnerProducer[i];
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public O block() {
        return block(null);
    }

    @Override // Z9.e
    @Deprecated
    public void cancel() {
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return Operators.multiSubscribersContext((InnerProducer[]) inners().filter(new b0()).map(new c0()).toArray(new C1903t(1)));
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

    @Override // Z9.d
    public abstract /* synthetic */ void onComplete();

    @Override // Z9.d
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // Z9.d
    public abstract /* synthetic */ void onNext(Object obj);

    @Nullable
    @Deprecated
    public O peek() {
        return null;
    }

    @Override // Z9.e
    @Deprecated
    public void request(long j5) {
        Operators.validate(j5);
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
