package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoCompletionStage<T> extends Mono<T> implements Scannable {
    final CompletionStage<? extends T> future;
    final boolean suppressCancellation;

    public MonoCompletionStage(CompletionStage<? extends T> completionStage, boolean z10) {
        Objects.requireNonNull(completionStage, "future");
        this.future = completionStage;
        this.suppressCancellation = z10;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.ASYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        CoreSubscriber coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(new MonoCompletionStageSubscription(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled, this.future, this.suppressCancellation));
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class MonoCompletionStageSubscription<T> implements InnerProducer<T>, BiFunction<T, Throwable, Void> {
        static final AtomicIntegerFieldUpdater<MonoCompletionStageSubscription> REQUESTED_ONCE = AtomicIntegerFieldUpdater.newUpdater(MonoCompletionStageSubscription.class, "requestedOnce");
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final CompletionStage<? extends T> future;
        volatile int requestedOnce;
        final boolean suppressCancellation;

        public MonoCompletionStageSubscription(CoreSubscriber<? super T> coreSubscriber, CompletionStage<? extends T> completionStage, boolean z10) {
            this.actual = coreSubscriber;
            this.future = completionStage;
            this.suppressCancellation = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        /* renamed from: apply, reason: avoid collision after fix types in other method */
        public Void apply2(@Nullable T t10, @Nullable Throwable th) {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (this.cancelled) {
                Context contextCurrentContext = coreSubscriber.currentContext();
                if (th == null || (th instanceof CancellationException)) {
                    Operators.onDiscard(t10, contextCurrentContext);
                } else {
                    Operators.onErrorDropped(th, contextCurrentContext);
                    Operators.onDiscard(t10, contextCurrentContext);
                }
                return null;
            }
            try {
                if (th instanceof CompletionException) {
                    coreSubscriber.onError(th.getCause());
                } else if (th != null) {
                    coreSubscriber.onError(th);
                } else if (t10 != null) {
                    coreSubscriber.onNext(t10);
                    coreSubscriber.onComplete();
                } else {
                    coreSubscriber.onComplete();
                }
                return null;
            } catch (Throwable th2) {
                Operators.onErrorDropped(th2, coreSubscriber.currentContext());
                throw Exceptions.bubble(th2);
            }
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.cancelled = true;
            CompletionStage<? extends T> completionStage = this.future;
            if (this.suppressCancellation || !(completionStage instanceof Future)) {
                return;
            }
            try {
                ((Future) completionStage).cancel(true);
            } catch (Throwable th) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (this.cancelled || this.requestedOnce == 1 || !REQUESTED_ONCE.compareAndSet(this, 0, 1)) {
                return;
            }
            this.future.handle(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiFunction
        public /* bridge */ /* synthetic */ Void apply(@Nullable Object obj, @Nullable Throwable th) {
            return apply2((MonoCompletionStageSubscription<T>) obj, th);
        }
    }
}
