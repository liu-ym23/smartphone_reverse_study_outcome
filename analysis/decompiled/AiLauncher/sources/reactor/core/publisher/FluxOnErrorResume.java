package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes5.dex */
final class FluxOnErrorResume<T> extends InternalFluxOperator<T, T> {
    final Function<? super Throwable, ? extends qc.b<? extends T>> nextFactory;

    public static final class ResumeSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        final Function<? super Throwable, ? extends qc.b<? extends T>> nextFactory;
        boolean second;

        public ResumeSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super Throwable, ? extends qc.b<? extends T>> function) {
            super(coreSubscriber);
            this.nextFactory = function;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.second) {
                this.actual.onError(th);
                return;
            }
            this.second = true;
            try {
                qc.b<? extends T> bVarApply = this.nextFactory.apply(th);
                Objects.requireNonNull(bVarApply, "The nextFactory returned a null Publisher");
                Operators.toFluxOrMono(bVarApply).subscribe((qc.c) this);
            } catch (Throwable th2) {
                this.actual.onError(Exceptions.addSuppressed(Operators.onOperatorError(th2, this.actual.currentContext()), th));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
            if (this.second) {
                return;
            }
            producedOne();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (!this.second) {
                this.actual.onSubscribe(this);
            }
            set(dVar);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnErrorResume(Flux<? extends T> flux, Function<? super Throwable, ? extends qc.b<? extends T>> function) {
        super(flux);
        Objects.requireNonNull(function, "nextFactory");
        this.nextFactory = function;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new ResumeSubscriber(coreSubscriber, this.nextFactory);
    }
}
