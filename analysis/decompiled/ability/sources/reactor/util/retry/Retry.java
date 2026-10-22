package reactor.util.retry;

import java.time.Duration;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
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

    public static RetryBackoffSpec backoff(long j5, Duration duration) {
        Context contextEmpty = Context.empty();
        S6.c cVar = new S6.c(9);
        Duration duration2 = RetrySpec.MAX_BACKOFF;
        C3.a aVar = new C3.a(13);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetryBackoffSpec(contextEmpty, j5, cVar, false, duration, duration2, 2.0d, 0.5d, aVar, consumer, consumer, biFunction, biFunction, RetryBackoffSpec.BACKOFF_EXCEPTION_GENERATOR);
    }

    public static RetryBackoffSpec fixedDelay(long j5, Duration duration) {
        Context contextEmpty = Context.empty();
        S6.c cVar = new S6.c(11);
        C3.a aVar = new C3.a(13);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetryBackoffSpec(contextEmpty, j5, cVar, false, duration, duration, 2.0d, 0.0d, aVar, consumer, consumer, biFunction, biFunction, RetryBackoffSpec.BACKOFF_EXCEPTION_GENERATOR);
    }

    public static final Retry from(final Function<Flux<RetrySignal>, ? extends Z9.c> function) {
        return new Retry(Context.empty()) { // from class: reactor.util.retry.Retry.1
            @Override // reactor.util.retry.Retry
            public Z9.c generateCompanion(Flux<RetrySignal> flux) {
                return (Z9.c) function.apply(flux);
            }
        };
    }

    public static RetrySpec indefinitely() {
        Context contextEmpty = Context.empty();
        S6.c cVar = new S6.c(10);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, Long.MAX_VALUE, cVar, false, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$backoff$0(Throwable th) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$fixedDelay$1(Throwable th) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$indefinitely$4(Throwable th) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$max$2(Throwable th) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$maxInARow$3(Throwable th) {
        return true;
    }

    public static RetrySpec max(long j5) {
        Context contextEmpty = Context.empty();
        S6.c cVar = new S6.c(8);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, j5, cVar, false, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static RetrySpec maxInARow(long j5) {
        Context contextEmpty = Context.empty();
        S6.c cVar = new S6.c(7);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, j5, cVar, true, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static final Retry withThrowable(final Function<Flux<Throwable>, ? extends Z9.c> function) {
        return new Retry(Context.empty()) { // from class: reactor.util.retry.Retry.2
            @Override // reactor.util.retry.Retry
            public Z9.c generateCompanion(Flux<RetrySignal> flux) {
                return (Z9.c) function.apply(flux.map(new a(0)));
            }
        };
    }

    public abstract Z9.c generateCompanion(Flux<RetrySignal> flux);

    public ContextView retryContext() {
        return this.retryContext;
    }

    public Retry(ContextView contextView) {
        this.retryContext = contextView;
    }
}
