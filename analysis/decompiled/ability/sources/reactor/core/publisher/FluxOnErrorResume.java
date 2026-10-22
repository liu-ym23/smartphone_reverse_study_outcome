package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
final class FluxOnErrorResume<T> extends InternalFluxOperator<T, T> {
    final Function<? super Throwable, ? extends Z9.c> nextFactory;

    public static final class ResumeSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        final Function<? super Throwable, ? extends Z9.c> nextFactory;
        boolean second;

        public ResumeSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super Throwable, ? extends Z9.c> function) {
            super(coreSubscriber);
            this.nextFactory = function;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.second) {
                this.actual.onError(th);
                return;
            }
            this.second = true;
            try {
                Z9.c cVarApply = this.nextFactory.apply(th);
                Objects.requireNonNull(cVarApply, "The nextFactory returned a null Publisher");
                Operators.toFluxOrMono(cVarApply).subscribe((Z9.d) this);
            } catch (Throwable th2) {
                this.actual.onError(Exceptions.addSuppressed(Operators.onOperatorError(th2, this.actual.currentContext()), th));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
            if (this.second) {
                return;
            }
            producedOne();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (!this.second) {
                this.actual.onSubscribe(this);
            }
            set(eVar);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnErrorResume(Flux<? extends T> flux, Function<? super Throwable, ? extends Z9.c> function) {
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
