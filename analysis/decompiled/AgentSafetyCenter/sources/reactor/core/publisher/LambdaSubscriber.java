package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class LambdaSubscriber<T> implements InnerConsumer<T>, Disposable {
    static final AtomicReferenceFieldUpdater<LambdaSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(LambdaSubscriber.class, qd.e.class, "subscription");
    final Runnable completeConsumer;
    final Consumer<? super T> consumer;
    final Consumer<? super Throwable> errorConsumer;
    final Context initialContext;
    volatile qd.e subscription;
    final Consumer<? super qd.e> subscriptionConsumer;

    public LambdaSubscriber(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qd.e> consumer3, @Nullable Context context) {
        this.consumer = consumer;
        this.errorConsumer = consumer2;
        this.completeConsumer = runnable;
        this.subscriptionConsumer = consumer3;
        this.initialContext = context == null ? Context.empty() : context;
    }

    @Override // reactor.core.CoreSubscriber
    public Context currentContext() {
        return this.initialContext;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        qd.e andSet = S.getAndSet(this, Operators.cancelledSubscription());
        if (andSet == null || andSet == Operators.cancelledSubscription()) {
            return;
        }
        andSet.cancel();
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.subscription == Operators.cancelledSubscription();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public final void onComplete() {
        Runnable runnable;
        if (S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription() || (runnable = this.completeConsumer) == null) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public final void onError(Throwable th) {
        if (S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription()) {
            Operators.onErrorDropped(th, this.initialContext);
            return;
        }
        Consumer<? super Throwable> consumer = this.errorConsumer;
        if (consumer != null) {
            consumer.accept(th);
        } else {
            Operators.onErrorDropped(Exceptions.errorCallbackNotImplemented(th), this.initialContext);
        }
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public final void onNext(T t10) {
        try {
            Consumer<? super T> consumer = this.consumer;
            if (consumer != null) {
                consumer.accept(t10);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.subscription.cancel();
            onError(th);
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public final void onSubscribe(qd.e eVar) {
        if (Operators.validate(this.subscription, eVar)) {
            this.subscription = eVar;
            Consumer<? super qd.e> consumer = this.subscriptionConsumer;
            if (consumer == null) {
                eVar.request(Long.MAX_VALUE);
                return;
            }
            try {
                consumer.accept(eVar);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                eVar.cancel();
                onError(th);
            }
        }
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.subscription;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(Reader.READ_DONE);
        }
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    public LambdaSubscriber(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qd.e> consumer3) {
        this(consumer, consumer2, runnable, consumer3, null);
    }
}
