package reactor.util.retry;

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

/* loaded from: classes5.dex */
public final class RetryBackoffSpec extends Retry {
    static final BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> BACKOFF_EXCEPTION_GENERATOR = new BiFunction() { // from class: reactor.util.retry.m
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return RetryBackoffSpec.h((RetryBackoffSpec) obj, (Retry.RetrySignal) obj2);
        }
    };
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

    public RetryBackoffSpec(ContextView contextView, long j10, Predicate<? super Throwable> predicate, boolean z10, Duration duration, Duration duration2, double d10, double d11, Supplier<Scheduler> supplier, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> biFunction3) {
        super(contextView);
        this.maxAttempts = j10;
        predicate.getClass();
        this.errorFilter = new h(predicate);
        this.isTransientErrors = z10;
        this.minBackoff = duration;
        this.maxBackoff = duration2;
        this.multiplier = d10 <= 1.0d ? 1.0d : d10;
        this.jitterFactor = d11;
        this.backoffSchedulerSupplier = supplier;
        this.syncPreRetry = consumer;
        this.syncPostRetry = consumer2;
        this.asyncPreRetry = biFunction;
        this.asyncPostRetry = biFunction2;
        this.retryExhaustedGenerator = biFunction3;
    }

    public static /* synthetic */ qc.b f(final RetryBackoffSpec retryBackoffSpec, Flux flux, final ContextView contextView) {
        retryBackoffSpec.getClass();
        return flux.contextWrite(contextView).concatMap(new Function() { // from class: reactor.util.retry.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RetryBackoffSpec.g(this.f39869a, contextView, (Retry.RetrySignal) obj);
            }
        }).onErrorStop();
    }

    public static /* synthetic */ qc.b g(RetryBackoffSpec retryBackoffSpec, ContextView contextView, Retry.RetrySignal retrySignal) {
        Duration durationMultipliedBy;
        long jRound;
        long jNextLong;
        retryBackoffSpec.getClass();
        Retry.RetrySignal retrySignalCopy = retrySignal.copy();
        Throwable thFailure = retrySignalCopy.failure();
        long j10 = retryBackoffSpec.isTransientErrors ? retrySignalCopy.totalRetriesInARow() : retrySignalCopy.totalRetries();
        if (thFailure == null) {
            return Mono.error(new IllegalStateException("Retry.RetrySignal#failure() not expected to be null"));
        }
        if (!retryBackoffSpec.errorFilter.test(thFailure)) {
            return Mono.error(thFailure);
        }
        if (j10 >= retryBackoffSpec.maxAttempts) {
            return Mono.error(retryBackoffSpec.retryExhaustedGenerator.apply(retryBackoffSpec, retrySignalCopy));
        }
        try {
            durationMultipliedBy = retryBackoffSpec.minBackoff.multipliedBy((long) Math.pow(retryBackoffSpec.multiplier, j10));
            if (durationMultipliedBy.compareTo(retryBackoffSpec.maxBackoff) > 0) {
                durationMultipliedBy = retryBackoffSpec.maxBackoff;
            }
        } catch (ArithmeticException unused) {
            durationMultipliedBy = retryBackoffSpec.maxBackoff;
        }
        if (durationMultipliedBy.isZero()) {
            return RetrySpec.applyHooks(retrySignalCopy, Mono.just(Long.valueOf(j10)), retryBackoffSpec.syncPreRetry, retryBackoffSpec.syncPostRetry, retryBackoffSpec.asyncPreRetry, retryBackoffSpec.asyncPostRetry, contextView);
        }
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        try {
            jRound = durationMultipliedBy.multipliedBy((long) (retryBackoffSpec.jitterFactor * 100.0d)).dividedBy(100L).toMillis();
        } catch (ArithmeticException unused2) {
            jRound = Math.round(retryBackoffSpec.jitterFactor * 9.223372036854776E18d);
        }
        long jMax = Math.max(retryBackoffSpec.minBackoff.minus(durationMultipliedBy).toMillis(), -jRound);
        long jMin = Math.min(retryBackoffSpec.maxBackoff.minus(durationMultipliedBy).toMillis(), jRound);
        if (jMin == jMax) {
            jNextLong = 0;
            if (jMin != 0) {
                jNextLong = threadLocalRandomCurrent.nextLong(jMin);
            }
        } else {
            jNextLong = threadLocalRandomCurrent.nextLong(jMax, jMin);
        }
        return RetrySpec.applyHooks(retrySignalCopy, Mono.delay(durationMultipliedBy.plusMillis(jNextLong), retryBackoffSpec.backoffSchedulerSupplier.get()), retryBackoffSpec.syncPreRetry, retryBackoffSpec.syncPostRetry, retryBackoffSpec.asyncPreRetry, retryBackoffSpec.asyncPostRetry, contextView);
    }

    public static /* synthetic */ Throwable h(RetryBackoffSpec retryBackoffSpec, Retry.RetrySignal retrySignal) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Retries exhausted: ");
        if (retryBackoffSpec.isTransientErrors) {
            str = retrySignal.totalRetriesInARow() + "/" + retryBackoffSpec.maxAttempts + " in a row (" + retrySignal.totalRetries() + " total)";
        } else {
            str = retrySignal.totalRetries() + "/" + retryBackoffSpec.maxAttempts;
        }
        sb2.append(str);
        return Exceptions.retryExhausted(sb2.toString(), retrySignal.failure());
    }

    public static /* synthetic */ Scheduler i(Scheduler scheduler) {
        return scheduler;
    }

    public RetryBackoffSpec doAfterRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry.andThen(consumer), this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doAfterRetryAsync(final Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, new BiFunction() { // from class: reactor.util.retry.i
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Retry.RetrySignal retrySignal = (Retry.RetrySignal) obj;
                return this.f39866a.asyncPostRetry.apply(retrySignal, (Mono) obj2).then((Mono) function.apply(retrySignal));
            }
        }, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doBeforeRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry.andThen(consumer), this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doBeforeRetryAsync(final Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, new BiFunction() { // from class: reactor.util.retry.l
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Retry.RetrySignal retrySignal = (Retry.RetrySignal) obj;
                return this.f39871a.asyncPreRetry.apply(retrySignal, (Mono) obj2).then((Mono) function.apply(retrySignal));
            }
        }, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec filter(Predicate<? super Throwable> predicate) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Objects.requireNonNull(predicate, "errorFilter");
        return new RetryBackoffSpec(contextView, j10, predicate, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public /* bridge */ /* synthetic */ qc.b generateCompanion(Flux flux) {
        return generateCompanion((Flux<Retry.RetrySignal>) flux);
    }

    public RetryBackoffSpec jitter(double d10) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, d10, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec maxAttempts(long j10) {
        return new RetryBackoffSpec(this.retryContext, j10, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
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

    public RetryBackoffSpec multiplier(double d10) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, d10, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec onRetryExhaustedThrow(BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> biFunction) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Duration duration = this.minBackoff;
        Duration duration2 = this.maxBackoff;
        double d10 = this.multiplier;
        double d11 = this.jitterFactor;
        Supplier<Scheduler> supplier = this.backoffSchedulerSupplier;
        Consumer<Retry.RetrySignal> consumer = this.syncPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.syncPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2 = this.asyncPreRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = this.asyncPostRetry;
        Objects.requireNonNull(biFunction, "retryExhaustedGenerator");
        return new RetryBackoffSpec(contextView, j10, predicate, z10, duration, duration2, d10, d11, supplier, consumer, consumer2, biFunction2, biFunction3, biFunction);
    }

    public RetryBackoffSpec scheduler(@Nullable final Scheduler scheduler) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, scheduler == null ? new d() : new Supplier() { // from class: reactor.util.retry.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return RetryBackoffSpec.i(scheduler);
            }
        }, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec transientErrors(boolean z10) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, z10, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public void validateArguments() {
        double d10 = this.jitterFactor;
        if (d10 < 0.0d || d10 > 1.0d) {
            throw new IllegalArgumentException("jitterFactor must be between 0 and 1 (default 0.5)");
        }
    }

    public RetryBackoffSpec withRetryContext(ContextView contextView) {
        return new RetryBackoffSpec(contextView, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public Flux<Long> generateCompanion(final Flux<Retry.RetrySignal> flux) {
        validateArguments();
        return Flux.deferContextual(new Function() { // from class: reactor.util.retry.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RetryBackoffSpec.f(this.f39873a, flux, (ContextView) obj);
            }
        });
    }
}
