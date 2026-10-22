package reactor.util.retry;

import Ba.g;
import I4.l;
import io.modelcontextprotocol.server.C1588f;
import io.modelcontextprotocol.server.o;
import java.time.Duration;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;

/* loaded from: classes4.dex */
public final class RetrySpec extends Retry {
    final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> asyncPostRetry;
    final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> asyncPreRetry;
    final Consumer<Retry.RetrySignal> doPostRetry;
    final Consumer<Retry.RetrySignal> doPreRetry;
    public final Predicate<Throwable> errorFilter;
    public final boolean isTransientErrors;
    public final long maxAttempts;
    final BiFunction<RetrySpec, Retry.RetrySignal, Throwable> retryExhaustedGenerator;
    static final Duration MAX_BACKOFF = Duration.ofMillis(Long.MAX_VALUE);
    static final Consumer<Retry.RetrySignal> NO_OP_CONSUMER = new io.modelcontextprotocol.spec.b(7);
    static final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> NO_OP_BIFUNCTION = new o(3);
    static final BiFunction<RetrySpec, Retry.RetrySignal, Throwable> RETRY_EXCEPTION_GENERATOR = new o(4);

    public RetrySpec(ContextView contextView, long j5, Predicate<? super Throwable> predicate, boolean z10, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, BiFunction<RetrySpec, Retry.RetrySignal, Throwable> biFunction3) {
        super(contextView);
        this.maxAttempts = j5;
        predicate.getClass();
        this.errorFilter = new androidx.window.embedding.b(predicate, 11);
        this.isTransientErrors = z10;
        this.doPreRetry = consumer;
        this.doPostRetry = consumer2;
        this.asyncPreRetry = biFunction;
        this.asyncPostRetry = biFunction2;
        this.retryExhaustedGenerator = biFunction3;
    }

    public static <T> Mono<T> applyHooks(Retry.RetrySignal retrySignal, Mono<T> mono, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, ContextView contextView) {
        Consumer<Retry.RetrySignal> consumer3 = NO_OP_CONSUMER;
        if (consumer != consumer3) {
            try {
                consumer.accept(retrySignal);
            } catch (Throwable th) {
                return Mono.error(th);
            }
        }
        Mono<Void> monoFromRunnable = consumer2 != consumer3 ? Mono.fromRunnable(new l(29, consumer2, retrySignal)) : Mono.empty();
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = NO_OP_BIFUNCTION;
        Mono<Void> monoEmpty = biFunction == biFunction3 ? Mono.empty() : biFunction.apply(retrySignal, Mono.empty());
        if (biFunction2 != biFunction3) {
            monoFromRunnable = biFunction2.apply(retrySignal, monoFromRunnable);
        }
        Mono<V> monoThen = monoEmpty.then(mono);
        monoFromRunnable.getClass();
        return monoThen.flatMap(new g(monoFromRunnable, 5)).contextWrite(contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$doAfterRetryAsync$4(Function function, Retry.RetrySignal retrySignal, Mono mono) {
        return this.asyncPostRetry.apply(retrySignal, mono).then((Mono) function.apply(retrySignal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$doBeforeRetryAsync$3(Function function, Retry.RetrySignal retrySignal, Mono mono) {
        return this.asyncPreRetry.apply(retrySignal, mono).then((Mono) function.apply(retrySignal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$generateCompanion$6(Flux flux, ContextView contextView) {
        return flux.contextWrite(contextView).concatMap(new C1588f(9, this, contextView)).onErrorStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$null$5(ContextView contextView, Retry.RetrySignal retrySignal) {
        Retry.RetrySignal retrySignalCopy = retrySignal.copy();
        Throwable thFailure = retrySignalCopy.failure();
        long j5 = this.isTransientErrors ? retrySignalCopy.totalRetriesInARow() : retrySignalCopy.totalRetries();
        return thFailure == null ? com.stepos.statsrpk.service.c.i("RetryWhenState#failure() not expected to be null") : !this.errorFilter.test(thFailure) ? Mono.error(thFailure) : j5 >= this.maxAttempts ? Mono.error(this.retryExhaustedGenerator.apply(this, retrySignalCopy)) : applyHooks(retrySignalCopy, Mono.just(Long.valueOf(j5)), this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Retry.RetrySignal retrySignal) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$static$1(Retry.RetrySignal retrySignal, Mono mono) {
        return mono;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Throwable lambda$static$2(RetrySpec retrySpec, Retry.RetrySignal retrySignal) {
        String str;
        StringBuilder sb = new StringBuilder("Retries exhausted: ");
        if (retrySpec.isTransientErrors) {
            str = retrySignal.totalRetriesInARow() + "/" + retrySpec.maxAttempts + " in a row (" + retrySignal.totalRetries() + " total)";
        } else {
            str = retrySignal.totalRetries() + "/" + retrySpec.maxAttempts;
        }
        sb.append(str);
        return Exceptions.retryExhausted(sb.toString(), retrySignal.failure());
    }

    public RetrySpec doAfterRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry.andThen(consumer), this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec doAfterRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, new c(this, function, 1), this.retryExhaustedGenerator);
    }

    public RetrySpec doBeforeRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry.andThen(consumer), this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec doBeforeRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, new c(this, function, 0), this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec filter(Predicate<? super Throwable> predicate) {
        ContextView contextView = this.retryContext;
        long j5 = this.maxAttempts;
        Objects.requireNonNull(predicate, "errorFilter");
        return new RetrySpec(contextView, j5, predicate, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public /* bridge */ /* synthetic */ Z9.c generateCompanion(Flux flux) {
        return generateCompanion((Flux<Retry.RetrySignal>) flux);
    }

    public RetrySpec maxAttempts(long j5) {
        return new RetrySpec(this.retryContext, j5, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec modifyErrorFilter(Function<Predicate<Throwable>, Predicate<? super Throwable>> function) {
        Objects.requireNonNull(function, "predicateAdjuster");
        Predicate<? super Throwable> predicateApply = function.apply(this.errorFilter);
        Objects.requireNonNull(predicateApply, "predicateAdjuster must return a new predicate");
        return new RetrySpec(this.retryContext, this.maxAttempts, predicateApply, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec onRetryExhaustedThrow(BiFunction<RetrySpec, Retry.RetrySignal, Throwable> biFunction) {
        ContextView contextView = this.retryContext;
        long j5 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Consumer<Retry.RetrySignal> consumer = this.doPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.doPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2 = this.asyncPreRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = this.asyncPostRetry;
        Objects.requireNonNull(biFunction, "retryExhaustedGenerator");
        return new RetrySpec(contextView, j5, predicate, z10, consumer, consumer2, biFunction2, biFunction3, biFunction);
    }

    public RetrySpec transientErrors(boolean z10) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, z10, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec withRetryContext(ContextView contextView) {
        return new RetrySpec(contextView, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public Flux<Long> generateCompanion(Flux<Retry.RetrySignal> flux) {
        return Flux.deferContextual(new C1588f(8, this, flux));
    }
}
