package reactor.util.retry;

import io.modelcontextprotocol.server.C1588f;
import io.modelcontextprotocol.server.o;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;

/* loaded from: classes4.dex */
public final class RetryBackoffSpec extends Retry {
    static final BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> BACKOFF_EXCEPTION_GENERATOR = new o(2);
    final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> asyncPostRetry;
    final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> asyncPreRetry;
    public final Supplier<Scheduler> backoffSchedulerSupplier;
    public final Predicate<Throwable> errorFilter;
    public final boolean isTransientErrors;
    public final double jitterFactor;
    public final long maxAttempts;
    public final Duration maxBackoff;
    public final Duration minBackoff;
    public final double multiplier;
    final BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> retryExhaustedGenerator;
    final Consumer<Retry.RetrySignal> syncPostRetry;
    final Consumer<Retry.RetrySignal> syncPreRetry;

    public RetryBackoffSpec(ContextView contextView, long j5, Predicate<? super Throwable> predicate, boolean z10, Duration duration, Duration duration2, double d, double d6, Supplier<Scheduler> supplier, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> biFunction3) {
        super(contextView);
        this.maxAttempts = j5;
        predicate.getClass();
        this.errorFilter = new androidx.window.embedding.b(predicate, 11);
        this.isTransientErrors = z10;
        this.minBackoff = duration;
        this.maxBackoff = duration2;
        this.multiplier = d <= 1.0d ? 1.0d : d;
        this.jitterFactor = d6;
        this.backoffSchedulerSupplier = supplier;
        this.syncPreRetry = consumer;
        this.syncPostRetry = consumer2;
        this.asyncPreRetry = biFunction;
        this.asyncPostRetry = biFunction2;
        this.retryExhaustedGenerator = biFunction3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$doAfterRetryAsync$2(Function function, Retry.RetrySignal retrySignal, Mono mono) {
        return this.asyncPostRetry.apply(retrySignal, mono).then((Mono) function.apply(retrySignal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$doBeforeRetryAsync$1(Function function, Retry.RetrySignal retrySignal, Mono mono) {
        return this.asyncPreRetry.apply(retrySignal, mono).then((Mono) function.apply(retrySignal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$generateCompanion$5(Flux flux, ContextView contextView) {
        return flux.contextWrite(contextView).concatMap(new C1588f(6, this, contextView)).onErrorStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$null$4(ContextView contextView, Retry.RetrySignal retrySignal) {
        Duration durationMultipliedBy;
        long jRound;
        long jNextLong;
        Retry.RetrySignal retrySignalCopy = retrySignal.copy();
        Throwable thFailure = retrySignalCopy.failure();
        long j5 = this.isTransientErrors ? retrySignalCopy.totalRetriesInARow() : retrySignalCopy.totalRetries();
        if (thFailure == null) {
            return com.stepos.statsrpk.service.c.i("Retry.RetrySignal#failure() not expected to be null");
        }
        if (!this.errorFilter.test(thFailure)) {
            return Mono.error(thFailure);
        }
        if (j5 >= this.maxAttempts) {
            return Mono.error(this.retryExhaustedGenerator.apply(this, retrySignalCopy));
        }
        try {
            durationMultipliedBy = this.minBackoff.multipliedBy((long) Math.pow(this.multiplier, j5));
            if (durationMultipliedBy.compareTo(this.maxBackoff) > 0) {
                durationMultipliedBy = this.maxBackoff;
            }
        } catch (ArithmeticException unused) {
            durationMultipliedBy = this.maxBackoff;
        }
        if (durationMultipliedBy.isZero()) {
            return RetrySpec.applyHooks(retrySignalCopy, Mono.just(Long.valueOf(j5)), this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, contextView);
        }
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        try {
            jRound = durationMultipliedBy.multipliedBy((long) (this.jitterFactor * 100.0d)).dividedBy(100L).toMillis();
        } catch (ArithmeticException unused2) {
            jRound = Math.round(this.jitterFactor * 9.223372036854776E18d);
        }
        long jMax = Math.max(this.minBackoff.minus(durationMultipliedBy).toMillis(), -jRound);
        long jMin = Math.min(this.maxBackoff.minus(durationMultipliedBy).toMillis(), jRound);
        if (jMin == jMax) {
            jNextLong = 0;
            if (jMin != 0) {
                jNextLong = threadLocalRandomCurrent.nextLong(jMin);
            }
        } else {
            jNextLong = threadLocalRandomCurrent.nextLong(jMax, jMin);
        }
        return RetrySpec.applyHooks(retrySignalCopy, Mono.delay(durationMultipliedBy.plusMillis(jNextLong), this.backoffSchedulerSupplier.get()), this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Scheduler lambda$scheduler$3(Scheduler scheduler) {
        return scheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Throwable lambda$static$0(RetryBackoffSpec retryBackoffSpec, Retry.RetrySignal retrySignal) {
        String str;
        StringBuilder sb = new StringBuilder("Retries exhausted: ");
        if (retryBackoffSpec.isTransientErrors) {
            str = retrySignal.totalRetriesInARow() + "/" + retryBackoffSpec.maxAttempts + " in a row (" + retrySignal.totalRetries() + " total)";
        } else {
            str = retrySignal.totalRetries() + "/" + retryBackoffSpec.maxAttempts;
        }
        sb.append(str);
        return Exceptions.retryExhausted(sb.toString(), retrySignal.failure());
    }

    public RetryBackoffSpec doAfterRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry.andThen(consumer), this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doAfterRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, new b(this, function, 0), this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doBeforeRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry.andThen(consumer), this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doBeforeRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, new b(this, function, 1), this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec filter(Predicate<? super Throwable> predicate) {
        ContextView contextView = this.retryContext;
        long j5 = this.maxAttempts;
        Objects.requireNonNull(predicate, "errorFilter");
        return new RetryBackoffSpec(contextView, j5, predicate, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public /* bridge */ /* synthetic */ Z9.c generateCompanion(Flux flux) {
        return generateCompanion((Flux<Retry.RetrySignal>) flux);
    }

    public RetryBackoffSpec jitter(double d) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, d, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec maxAttempts(long j5) {
        return new RetryBackoffSpec(this.retryContext, j5, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec maxBackoff(Duration duration) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, duration, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec minBackoff(Duration duration) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, duration, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec modifyErrorFilter(Function<Predicate<Throwable>, Predicate<? super Throwable>> function) {
        Objects.requireNonNull(function, "predicateAdjuster");
        Predicate<? super Throwable> predicateApply = function.apply(this.errorFilter);
        Objects.requireNonNull(predicateApply, "predicateAdjuster must return a new predicate");
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, predicateApply, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec multiplier(double d) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, d, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec onRetryExhaustedThrow(BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> biFunction) {
        ContextView contextView = this.retryContext;
        long j5 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Duration duration = this.minBackoff;
        Duration duration2 = this.maxBackoff;
        double d = this.multiplier;
        double d6 = this.jitterFactor;
        Supplier<Scheduler> supplier = this.backoffSchedulerSupplier;
        Consumer<Retry.RetrySignal> consumer = this.syncPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.syncPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2 = this.asyncPreRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = this.asyncPostRetry;
        Objects.requireNonNull(biFunction, "retryExhaustedGenerator");
        return new RetryBackoffSpec(contextView, j5, predicate, z10, duration, duration2, d, d6, supplier, consumer, consumer2, biFunction2, biFunction3, biFunction);
    }

    public RetryBackoffSpec scheduler(@Nullable Scheduler scheduler) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, scheduler == null ? new C3.a(13) : new com.fasterxml.jackson.core.util.a(scheduler, 3), this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec transientErrors(boolean z10) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, z10, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public void validateArguments() {
        double d = this.jitterFactor;
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterFactor must be between 0 and 1 (default 0.5)");
        }
    }

    public RetryBackoffSpec withRetryContext(ContextView contextView) {
        return new RetryBackoffSpec(contextView, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public Flux<Long> generateCompanion(Flux<Retry.RetrySignal> flux) {
        validateArguments();
        return Flux.deferContextual(new C1588f(7, this, flux));
    }
}
