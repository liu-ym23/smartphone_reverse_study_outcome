package reactor.util.retry;

import java.time.Duration;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;

/* loaded from: classes5.dex */
public abstract class Retry {
    public final ContextView retryContext;

    public interface RetrySignal {
        default RetrySignal copy() {
            return new ImmutableRetrySignal(totalRetries(), totalRetriesInARow(), failure(), retryContextView());
        }

        Throwable failure();

        default ContextView retryContextView() {
            return Context.empty();
        }

        long totalRetries();

        long totalRetriesInARow();
    }

    public Retry() {
        this(Context.empty());
    }

    public static /* synthetic */ boolean a(Throwable th) {
        return true;
    }

    public static /* synthetic */ boolean b(Throwable th) {
        return true;
    }

    public static RetryBackoffSpec backoff(long j10, Duration duration) {
        Context contextEmpty = Context.empty();
        Predicate predicate = new Predicate() { // from class: reactor.util.retry.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Retry.b((Throwable) obj);
            }
        };
        Duration duration2 = RetrySpec.MAX_BACKOFF;
        d dVar = new d();
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetryBackoffSpec(contextEmpty, j10, predicate, false, duration, duration2, 2.0d, 0.5d, dVar, consumer, consumer, biFunction, biFunction, RetryBackoffSpec.BACKOFF_EXCEPTION_GENERATOR);
    }

    public static /* synthetic */ boolean c(Throwable th) {
        return true;
    }

    public static /* synthetic */ boolean d(Throwable th) {
        return true;
    }

    public static /* synthetic */ boolean e(Throwable th) {
        return true;
    }

    public static RetryBackoffSpec fixedDelay(long j10, Duration duration) {
        Context contextEmpty = Context.empty();
        Predicate predicate = new Predicate() { // from class: reactor.util.retry.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Retry.c((Throwable) obj);
            }
        };
        d dVar = new d();
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetryBackoffSpec(contextEmpty, j10, predicate, false, duration, duration, 2.0d, 0.0d, dVar, consumer, consumer, biFunction, biFunction, RetryBackoffSpec.BACKOFF_EXCEPTION_GENERATOR);
    }

    public static final Retry from(final Function<Flux<RetrySignal>, ? extends qc.b<?>> function) {
        return new Retry(Context.empty()) { // from class: reactor.util.retry.Retry.1
            @Override // reactor.util.retry.Retry
            public qc.b<?> generateCompanion(Flux<RetrySignal> flux) {
                return (qc.b) function.apply(flux);
            }
        };
    }

    public static RetrySpec indefinitely() {
        Context contextEmpty = Context.empty();
        Predicate predicate = new Predicate() { // from class: reactor.util.retry.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Retry.e((Throwable) obj);
            }
        };
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, Long.MAX_VALUE, predicate, false, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static RetrySpec max(long j10) {
        Context contextEmpty = Context.empty();
        Predicate predicate = new Predicate() { // from class: reactor.util.retry.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Retry.a((Throwable) obj);
            }
        };
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, j10, predicate, false, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static RetrySpec maxInARow(long j10) {
        Context contextEmpty = Context.empty();
        Predicate predicate = new Predicate() { // from class: reactor.util.retry.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Retry.d((Throwable) obj);
            }
        };
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, j10, predicate, true, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static final Retry withThrowable(final Function<Flux<Throwable>, ? extends qc.b<?>> function) {
        return new Retry(Context.empty()) { // from class: reactor.util.retry.Retry.2
            @Override // reactor.util.retry.Retry
            public qc.b<?> generateCompanion(Flux<RetrySignal> flux) {
                return (qc.b) function.apply(flux.map(new Function() { // from class: reactor.util.retry.g
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((Retry.RetrySignal) obj).failure();
                    }
                }));
            }
        };
    }

    public abstract qc.b<?> generateCompanion(Flux<RetrySignal> flux);

    public ContextView retryContext() {
        return this.retryContext;
    }

    public Retry(ContextView contextView) {
        this.retryContext = contextView;
    }
}
