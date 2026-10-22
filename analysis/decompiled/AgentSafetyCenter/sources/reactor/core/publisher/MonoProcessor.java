package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
public abstract class MonoProcessor<O> extends Mono<O> implements qd.d, qd.c, CoreSubscriber<O>, Disposable, qd.e, Scannable {
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

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        Stream<? extends Scannable> streamInners = inners();
        h hVar = new h(3);
        hVar.f10797f = InnerProducer.class;
        VarHandle.storeStoreFence();
        Stream<? extends Scannable> streamFilter = streamInners.filter(hVar);
        b1 b1Var = new b1(0);
        b1Var.f10765b = InnerProducer.class;
        VarHandle.storeStoreFence();
        return Operators.multiSubscribersContext((InnerProducer[]) streamFilter.map(b1Var).toArray(new u(1)));
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

    @Override // qd.d
    public abstract /* synthetic */ void onComplete();

    @Override // qd.d
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // qd.d
    public abstract /* synthetic */ void onNext(Object obj);

    @Nullable
    @Deprecated
    public O peek() {
        return null;
    }

    @Override // qd.e
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
            return Integer.valueOf(Reader.READ_DONE);
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

    @Override // qd.e
    @Deprecated
    public void cancel() {
    }
}
