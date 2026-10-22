package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class LambdaSubscriber<T> implements InnerConsumer<T>, Disposable {

    /* renamed from: S, reason: collision with root package name */
    static final AtomicReferenceFieldUpdater<LambdaSubscriber, qc.d> f39640S = AtomicReferenceFieldUpdater.newUpdater(LambdaSubscriber.class, qc.d.class, "subscription");
    final Runnable completeConsumer;
    final Consumer<? super T> consumer;
    final Consumer<? super Throwable> errorConsumer;
    final Context initialContext;
    volatile qc.d subscription;
    final Consumer<? super qc.d> subscriptionConsumer;

    public LambdaSubscriber(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qc.d> consumer3, @Nullable Context context) {
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
        qc.d andSet = f39640S.getAndSet(this, Operators.cancelledSubscription());
        if (andSet == null || andSet == Operators.cancelledSubscription()) {
            return;
        }
        andSet.cancel();
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.subscription == Operators.cancelledSubscription();
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public final void onComplete() {
        Runnable runnable;
        if (f39640S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription() || (runnable = this.completeConsumer) == null) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
    public final void onError(Throwable th) {
        if (f39640S.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription()) {
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

    @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

    @Override // reactor.core.CoreSubscriber, qc.c
    public final void onSubscribe(qc.d dVar) {
        if (Operators.validate(this.subscription, dVar)) {
            this.subscription = dVar;
            Consumer<? super qc.d> consumer = this.subscriptionConsumer;
            if (consumer == null) {
                dVar.request(Long.MAX_VALUE);
                return;
            }
            try {
                consumer.accept(dVar);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dVar.cancel();
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
            return Integer.MAX_VALUE;
        }
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    public LambdaSubscriber(@Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable Runnable runnable, @Nullable Consumer<? super qc.d> consumer3) {
        this(consumer, consumer2, runnable, consumer3, null);
    }
}
