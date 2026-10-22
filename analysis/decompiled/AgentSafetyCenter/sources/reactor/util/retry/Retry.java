package reactor.util.retry;

import a8.e;
import java.time.Duration;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import qd.c;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class Retry {
    public final ContextView retryContext;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    public static RetryBackoffSpec backoff(long j10, Duration duration) {
        Context contextEmpty = Context.empty();
        e eVar = new e(20);
        Duration duration2 = RetrySpec.MAX_BACKOFF;
        com.fasterxml.jackson.core.util.a aVar = new com.fasterxml.jackson.core.util.a(11);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetryBackoffSpec(contextEmpty, j10, eVar, false, duration, duration2, 2.0d, 0.5d, aVar, consumer, consumer, biFunction, biFunction, RetryBackoffSpec.BACKOFF_EXCEPTION_GENERATOR);
    }

    public static RetryBackoffSpec fixedDelay(long j10, Duration duration) {
        Context contextEmpty = Context.empty();
        e eVar = new e(22);
        com.fasterxml.jackson.core.util.a aVar = new com.fasterxml.jackson.core.util.a(11);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetryBackoffSpec(contextEmpty, j10, eVar, false, duration, duration, 2.0d, 0.0d, aVar, consumer, consumer, biFunction, biFunction, RetryBackoffSpec.BACKOFF_EXCEPTION_GENERATOR);
    }

    public static final Retry from(final Function<Flux<RetrySignal>, ? extends c> function) {
        return new Retry(Context.empty()) { // from class: reactor.util.retry.Retry.1
            @Override // reactor.util.retry.Retry
            public c generateCompanion(Flux<RetrySignal> flux) {
                return (c) function.apply(flux);
            }
        };
    }

    public static RetrySpec indefinitely() {
        Context contextEmpty = Context.empty();
        e eVar = new e(21);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, Long.MAX_VALUE, eVar, false, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
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

    public static RetrySpec max(long j10) {
        Context contextEmpty = Context.empty();
        e eVar = new e(19);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, j10, eVar, false, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static RetrySpec maxInARow(long j10) {
        Context contextEmpty = Context.empty();
        e eVar = new e(18);
        Consumer<RetrySignal> consumer = RetrySpec.NO_OP_CONSUMER;
        BiFunction<RetrySignal, Mono<Void>, Mono<Void>> biFunction = RetrySpec.NO_OP_BIFUNCTION;
        return new RetrySpec(contextEmpty, j10, eVar, true, consumer, consumer, biFunction, biFunction, RetrySpec.RETRY_EXCEPTION_GENERATOR);
    }

    public static final Retry withThrowable(final Function<Flux<Throwable>, ? extends c> function) {
        return new Retry(Context.empty()) { // from class: reactor.util.retry.Retry.2
            @Override // reactor.util.retry.Retry
            public c generateCompanion(Flux<RetrySignal> flux) {
                return (c) function.apply(flux.map(new reactor.util.context.b(1)));
            }
        };
    }

    public abstract c generateCompanion(Flux<RetrySignal> flux);

    public ContextView retryContext() {
        return this.retryContext;
    }

    public Retry(ContextView contextView) {
        this.retryContext = contextView;
    }
}
