package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxZipIterable<T, U, R> extends InternalFluxOperator<T, R> {
    final Iterable<? extends U> other;
    final BiFunction<? super T, ? super U, ? extends R> zipper;

    public static final class ZipSubscriber<T, U, R> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        final Iterator<? extends U> it;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5835s;
        final BiFunction<? super T, ? super U, ? extends R> zipper;

        public ZipSubscriber(CoreSubscriber<? super R> coreSubscriber, Iterator<? extends U> it, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = coreSubscriber;
            this.it = it;
            this.zipper = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5835s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            try {
                try {
                    R rApply = this.zipper.apply(t9, this.it.next());
                    Objects.requireNonNull(rApply, "The zipper returned a null value");
                    this.actual.onNext(rApply);
                    try {
                        if (this.it.hasNext()) {
                            return;
                        }
                        this.done = true;
                        this.f5835s.cancel();
                        this.actual.onComplete();
                    } catch (Throwable th) {
                        this.done = true;
                        CoreSubscriber<? super R> coreSubscriber = this.actual;
                        coreSubscriber.onError(Operators.onOperatorError(this.f5835s, th, t9, coreSubscriber.currentContext()));
                    }
                } catch (Throwable th2) {
                    this.done = true;
                    CoreSubscriber<? super R> coreSubscriber2 = this.actual;
                    coreSubscriber2.onError(Operators.onOperatorError(this.f5835s, th2, t9, coreSubscriber2.currentContext()));
                }
            } catch (Throwable th3) {
                this.done = true;
                CoreSubscriber<? super R> coreSubscriber3 = this.actual;
                coreSubscriber3.onError(Operators.onOperatorError(this.f5835s, th3, t9, coreSubscriber3.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5835s, eVar)) {
                this.f5835s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5835s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f5835s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxZipIterable(Flux<? extends T> flux, Iterable<? extends U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(flux);
        Objects.requireNonNull(iterable, "other");
        this.other = iterable;
        Objects.requireNonNull(biFunction, "zipper");
        this.zipper = biFunction;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        Iterator<? extends U> it = this.other.iterator();
        Objects.requireNonNull(it, "The other iterable produced a null iterator");
        Iterator<? extends U> it2 = it;
        if (it2.hasNext()) {
            return new ZipSubscriber(coreSubscriber, it2, this.zipper);
        }
        Operators.complete(coreSubscriber);
        return null;
    }
}
