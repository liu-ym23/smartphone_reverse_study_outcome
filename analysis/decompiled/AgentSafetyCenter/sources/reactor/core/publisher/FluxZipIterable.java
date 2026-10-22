package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxZipIterable<T, U, R> extends InternalFluxOperator<T, R> {
    final Iterable<? extends U> other;
    final BiFunction<? super T, ? super U, ? extends R> zipper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipSubscriber<T, U, R> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        final Iterator<? extends U> it;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10718s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10718s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                try {
                    R rApply = this.zipper.apply(t10, this.it.next());
                    Objects.requireNonNull(rApply, "The zipper returned a null value");
                    this.actual.onNext(rApply);
                    try {
                        if (this.it.hasNext()) {
                            return;
                        }
                        this.done = true;
                        this.f10718s.cancel();
                        this.actual.onComplete();
                    } catch (Throwable th) {
                        this.done = true;
                        CoreSubscriber<? super R> coreSubscriber = this.actual;
                        coreSubscriber.onError(Operators.onOperatorError(this.f10718s, th, t10, coreSubscriber.currentContext()));
                    }
                } catch (Throwable th2) {
                    this.done = true;
                    CoreSubscriber<? super R> coreSubscriber2 = this.actual;
                    coreSubscriber2.onError(Operators.onOperatorError(this.f10718s, th2, t10, coreSubscriber2.currentContext()));
                }
            } catch (Throwable th3) {
                this.done = true;
                CoreSubscriber<? super R> coreSubscriber3 = this.actual;
                coreSubscriber3.onError(Operators.onOperatorError(this.f10718s, th3, t10, coreSubscriber3.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10718s, eVar)) {
                this.f10718s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10718s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f10718s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
