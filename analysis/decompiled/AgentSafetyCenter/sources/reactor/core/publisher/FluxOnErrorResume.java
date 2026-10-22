package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxOnErrorResume<T> extends InternalFluxOperator<T, T> {
    final Function<? super Throwable, ? extends qd.c> nextFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ResumeSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        final Function<? super Throwable, ? extends qd.c> nextFactory;
        boolean second;

        public ResumeSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super Throwable, ? extends qd.c> function) {
            super(coreSubscriber);
            this.nextFactory = function;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.second) {
                this.actual.onError(th);
                return;
            }
            this.second = true;
            try {
                qd.c cVarApply = this.nextFactory.apply(th);
                Objects.requireNonNull(cVarApply, "The nextFactory returned a null Publisher");
                Operators.toFluxOrMono(cVarApply).subscribe((qd.d) this);
            } catch (Throwable th2) {
                this.actual.onError(Exceptions.addSuppressed(Operators.onOperatorError(th2, this.actual.currentContext()), th));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
            if (this.second) {
                return;
            }
            producedOne();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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

    public FluxOnErrorResume(Flux<? extends T> flux, Function<? super Throwable, ? extends qd.c> function) {
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
