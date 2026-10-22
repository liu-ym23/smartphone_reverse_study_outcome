package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Scannable;
import reactor.core.publisher.FluxCreate;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
final class MonoCreate<T> extends Mono<T> implements SourceProducer<T> {
    final Consumer<MonoSink<T>> callback;
    static final Disposable TERMINATED = OperatorDisposables.DISPOSED;
    static final Disposable CANCELLED = Disposables.disposed();

    public MonoCreate(Consumer<MonoSink<T>> consumer) {
        this.callback = consumer;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        CoreSubscriber coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        DefaultMonoSink defaultMonoSink = new DefaultMonoSink(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled);
        coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(defaultMonoSink);
        try {
            this.callback.accept(defaultMonoSink);
        } catch (Throwable th) {
            defaultMonoSink.error(Operators.onOperatorError(th, coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.currentContext()));
        }
    }

    public static final class DefaultMonoSink<T> extends AtomicBoolean implements MonoSink<T>, InnerProducer<T> {
        static final int HAS_REQUEST_HAS_VALUE = 3;
        static final int HAS_REQUEST_NO_VALUE = 2;
        static final int NO_REQUEST_HAS_VALUE = 1;
        final CoreSubscriber<? super T> actual;
        volatile Disposable disposable;
        volatile LongConsumer requestConsumer;
        volatile int state;
        T value;
        static final AtomicReferenceFieldUpdater<DefaultMonoSink, Disposable> DISPOSABLE = AtomicReferenceFieldUpdater.newUpdater(DefaultMonoSink.class, Disposable.class, "disposable");
        static final AtomicIntegerFieldUpdater<DefaultMonoSink> STATE = AtomicIntegerFieldUpdater.newUpdater(DefaultMonoSink.class, VoiceWakeupReceiver.EXTRA_STATE);
        static final AtomicReferenceFieldUpdater<DefaultMonoSink, LongConsumer> REQUEST_CONSUMER = AtomicReferenceFieldUpdater.newUpdater(DefaultMonoSink.class, LongConsumer.class, "requestConsumer");

        public DefaultMonoSink(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (STATE.getAndSet(this, 3) != 3) {
                T t10 = this.value;
                this.value = null;
                Operators.onDiscard(t10, this.actual.currentContext());
                disposeResource(true);
            }
        }

        @Override // reactor.core.publisher.MonoSink
        public ContextView contextView() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.MonoSink
        @Deprecated
        public Context currentContext() {
            return this.actual.currentContext();
        }

        public void disposeResource(boolean z10) {
            Disposable disposable;
            Disposable andSet;
            Disposable disposable2 = z10 ? MonoCreate.CANCELLED : MonoCreate.TERMINATED;
            Disposable disposable3 = this.disposable;
            Disposable disposable4 = MonoCreate.TERMINATED;
            if (disposable3 == disposable4 || disposable3 == (disposable = MonoCreate.CANCELLED) || (andSet = DISPOSABLE.getAndSet(this, disposable2)) == null || andSet == disposable4 || andSet == disposable) {
                return;
            }
            if (z10 && (andSet instanceof FluxCreate.SinkDisposable)) {
                ((FluxCreate.SinkDisposable) andSet).cancel();
            }
            andSet.dispose();
        }

        @Override // reactor.core.publisher.MonoSink
        public void error(Throwable th) {
            if (isDisposed()) {
                Operators.onOperatorError(th, this.actual.currentContext());
            } else {
                if (STATE.getAndSet(this, 3) == 3) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                    return;
                }
                try {
                    this.actual.onError(th);
                } finally {
                    disposeResource(false);
                }
            }
        }

        public boolean isDisposed() {
            Disposable disposable = this.disposable;
            return disposable == MonoCreate.CANCELLED || disposable == MonoCreate.TERMINATED;
        }

        @Override // reactor.core.publisher.MonoSink
        public MonoSink<T> onCancel(Disposable disposable) {
            Objects.requireNonNull(disposable, "onCancel");
            if (!DISPOSABLE.compareAndSet(this, null, new FluxCreate.SinkDisposable(null, disposable))) {
                Disposable disposable2 = this.disposable;
                if (disposable2 == MonoCreate.CANCELLED) {
                    disposable.dispose();
                    return this;
                }
                if (disposable2 instanceof FluxCreate.SinkDisposable) {
                    FluxCreate.SinkDisposable sinkDisposable = (FluxCreate.SinkDisposable) disposable2;
                    if (sinkDisposable.onCancel == null) {
                        sinkDisposable.onCancel = disposable;
                        return this;
                    }
                    disposable.dispose();
                }
            }
            return this;
        }

        @Override // reactor.core.publisher.MonoSink
        public MonoSink<T> onDispose(Disposable disposable) {
            Objects.requireNonNull(disposable, "onDispose");
            if (!DISPOSABLE.compareAndSet(this, null, new FluxCreate.SinkDisposable(disposable, null))) {
                Disposable disposable2 = this.disposable;
                if (isDisposed()) {
                    disposable.dispose();
                    return this;
                }
                if (disposable2 instanceof FluxCreate.SinkDisposable) {
                    FluxCreate.SinkDisposable sinkDisposable = (FluxCreate.SinkDisposable) disposable2;
                    if (sinkDisposable.disposable == null) {
                        sinkDisposable.disposable = disposable;
                        return this;
                    }
                    disposable.dispose();
                }
            }
            return this;
        }

        @Override // reactor.core.publisher.MonoSink
        public MonoSink<T> onRequest(LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer, "onRequest");
            if (!REQUEST_CONSUMER.compareAndSet(this, null, longConsumer)) {
                throw new IllegalStateException("A consumer has already been assigned to consume requests");
            }
            int i10 = this.state;
            if (i10 != 2 && i10 != 3) {
                return this;
            }
            longConsumer.accept(Long.MAX_VALUE);
            return this;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            int i10;
            if (Operators.validate(j10)) {
                LongConsumer longConsumer = this.requestConsumer;
                if (longConsumer != null) {
                    longConsumer.accept(j10);
                }
                do {
                    i10 = this.state;
                    if (i10 == 2 || i10 == 3) {
                        return;
                    }
                    if (i10 == 1) {
                        if (STATE.compareAndSet(this, i10, 3)) {
                            try {
                                this.actual.onNext(this.value);
                                this.actual.onComplete();
                                return;
                            } finally {
                                disposeResource(false);
                            }
                        }
                        return;
                    }
                } while (!STATE.compareAndSet(this, i10, 2));
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.state == 3 || this.state == 1 || this.disposable == MonoCreate.TERMINATED);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.disposable == MonoCreate.CANCELLED);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.MonoSink
        public void success() {
            if (isDisposed() || STATE.getAndSet(this, 3) == 3) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                disposeResource(false);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "MonoSink";
        }

        @Override // reactor.core.publisher.MonoSink
        public void success(@Nullable T t10) {
            int i10;
            if (t10 == null) {
                success();
                return;
            }
            Disposable disposable = this.disposable;
            if (disposable == MonoCreate.CANCELLED) {
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            if (disposable == MonoCreate.TERMINATED) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            do {
                i10 = this.state;
                if (i10 == 3 || i10 == 1) {
                    Operators.onNextDropped(t10, this.actual.currentContext());
                    return;
                }
                if (i10 == 2) {
                    if (STATE.compareAndSet(this, i10, 3)) {
                        try {
                            this.actual.onNext(t10);
                            this.actual.onComplete();
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                    Operators.onNextDropped(t10, this.actual.currentContext());
                    return;
                }
                this.value = t10;
            } while (!STATE.compareAndSet(this, i10, 1));
        }
    }
}
