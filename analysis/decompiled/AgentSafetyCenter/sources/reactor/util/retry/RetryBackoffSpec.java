package reactor.util.retry;

import b8.q0;
import g5.f;
import io.modelcontextprotocol.server.e;
import io.modelcontextprotocol.server.m;
import io.modelcontextprotocol.spec.h;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import qd.c;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class RetryBackoffSpec extends Retry {
    static final BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> BACKOFF_EXCEPTION_GENERATOR = new m(2);
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

    public RetryBackoffSpec(ContextView contextView, long j10, Predicate<? super Throwable> predicate, boolean z10, Duration duration, Duration duration2, double d7, double d10, Supplier<Scheduler> supplier, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> biFunction3) {
        super(contextView);
        this.maxAttempts = j10;
        predicate.getClass();
        h hVar = new h(2);
        hVar.f6367f = predicate;
        VarHandle.storeStoreFence();
        this.errorFilter = hVar;
        this.isTransientErrors = z10;
        this.minBackoff = duration;
        this.maxBackoff = duration2;
        this.multiplier = d7 <= 1.0d ? 1.0d : d7;
        this.jitterFactor = d10;
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
    public /* synthetic */ c lambda$generateCompanion$5(Flux flux, ContextView contextView) {
        Flux fluxContextWrite = flux.contextWrite(contextView);
        e eVar = new e(6);
        eVar.f6261b = this;
        eVar.f6262c = contextView;
        VarHandle.storeStoreFence();
        return fluxContextWrite.concatMap(eVar).onErrorStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c lambda$null$4(ContextView contextView, Retry.RetrySignal retrySignal) {
        Duration durationMultipliedBy;
        long jRound;
        long jNextLong;
        Retry.RetrySignal retrySignalCopy = retrySignal.copy();
        Throwable thFailure = retrySignalCopy.failure();
        long j10 = this.isTransientErrors ? retrySignalCopy.totalRetriesInARow() : retrySignalCopy.totalRetries();
        if (thFailure == null) {
            return androidx.activity.b.q("Retry.RetrySignal#failure() not expected to be null");
        }
        if (!this.errorFilter.test(thFailure)) {
            return Mono.error(thFailure);
        }
        if (j10 >= this.maxAttempts) {
            return Mono.error(this.retryExhaustedGenerator.apply(this, retrySignalCopy));
        }
        try {
            durationMultipliedBy = this.minBackoff.multipliedBy((long) Math.pow(this.multiplier, j10));
            if (durationMultipliedBy.compareTo(this.maxBackoff) > 0) {
                durationMultipliedBy = this.maxBackoff;
            }
        } catch (ArithmeticException unused) {
            durationMultipliedBy = this.maxBackoff;
        }
        if (durationMultipliedBy.isZero()) {
            return RetrySpec.applyHooks(retrySignalCopy, Mono.just(Long.valueOf(j10)), this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, contextView);
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
    public static /* synthetic */ Throwable lambda$static$0(RetryBackoffSpec retryBackoffSpec, Retry.RetrySignal retrySignal) {
        String str;
        if (retryBackoffSpec.isTransientErrors) {
            str = retrySignal.totalRetriesInARow() + "/" + retryBackoffSpec.maxAttempts + " in a row (" + retrySignal.totalRetries() + " total)";
        } else {
            str = retrySignal.totalRetries() + "/" + retryBackoffSpec.maxAttempts;
        }
        return Exceptions.retryExhausted("Retries exhausted: ".concat(str), retrySignal.failure());
    }

    public RetryBackoffSpec doAfterRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry.andThen(consumer), this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doAfterRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Duration duration = this.minBackoff;
        Duration duration2 = this.maxBackoff;
        double d7 = this.multiplier;
        double d10 = this.jitterFactor;
        Supplier<Scheduler> supplier = this.backoffSchedulerSupplier;
        Consumer<Retry.RetrySignal> consumer = this.syncPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.syncPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction = this.asyncPreRetry;
        a aVar = new a(0);
        aVar.f10922f = this;
        aVar.f10923g = function;
        VarHandle.storeStoreFence();
        return new RetryBackoffSpec(contextView, j10, predicate, z10, duration, duration2, d7, d10, supplier, consumer, consumer2, biFunction, aVar, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doBeforeRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry.andThen(consumer), this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec doBeforeRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Duration duration = this.minBackoff;
        Duration duration2 = this.maxBackoff;
        double d7 = this.multiplier;
        double d10 = this.jitterFactor;
        Supplier<Scheduler> supplier = this.backoffSchedulerSupplier;
        Consumer<Retry.RetrySignal> consumer = this.syncPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.syncPostRetry;
        a aVar = new a(1);
        aVar.f10922f = this;
        aVar.f10923g = function;
        VarHandle.storeStoreFence();
        return new RetryBackoffSpec(contextView, j10, predicate, z10, duration, duration2, d7, d10, supplier, consumer, consumer2, aVar, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec filter(Predicate<? super Throwable> predicate) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Objects.requireNonNull(predicate, "errorFilter");
        return new RetryBackoffSpec(contextView, j10, predicate, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public Flux<Long> generateCompanion(Flux<Retry.RetrySignal> flux) {
        validateArguments();
        e eVar = new e(7);
        eVar.f6261b = this;
        eVar.f6262c = flux;
        VarHandle.storeStoreFence();
        return Flux.deferContextual(eVar);
    }

    public RetryBackoffSpec jitter(double d7) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, d7, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
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

    public RetryBackoffSpec multiplier(double d7) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, d7, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec onRetryExhaustedThrow(BiFunction<RetryBackoffSpec, Retry.RetrySignal, Throwable> biFunction) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Duration duration = this.minBackoff;
        Duration duration2 = this.maxBackoff;
        double d7 = this.multiplier;
        double d10 = this.jitterFactor;
        Supplier<Scheduler> supplier = this.backoffSchedulerSupplier;
        Consumer<Retry.RetrySignal> consumer = this.syncPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.syncPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2 = this.asyncPreRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = this.asyncPostRetry;
        Objects.requireNonNull(biFunction, "retryExhaustedGenerator");
        return new RetryBackoffSpec(contextView, j10, predicate, z10, duration, duration2, d7, d10, supplier, consumer, consumer2, biFunction2, biFunction3, biFunction);
    }

    public RetryBackoffSpec scheduler(@Nullable Scheduler scheduler) {
        Supplier aVar;
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Duration duration = this.minBackoff;
        Duration duration2 = this.maxBackoff;
        double d7 = this.multiplier;
        double d10 = this.jitterFactor;
        if (scheduler == null) {
            aVar = new com.fasterxml.jackson.core.util.a(11);
        } else {
            q0 q0Var = new q0(4);
            q0Var.f2013f = scheduler;
            VarHandle.storeStoreFence();
            aVar = q0Var;
        }
        return new RetryBackoffSpec(contextView, j10, predicate, z10, duration, duration2, d7, d10, aVar, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetryBackoffSpec transientErrors(boolean z10) {
        return new RetryBackoffSpec(this.retryContext, this.maxAttempts, this.errorFilter, z10, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public void validateArguments() {
        double d7 = this.jitterFactor;
        if (d7 < 0.0d || d7 > 1.0d) {
            f.s("jitterFactor must be between 0 and 1 (default 0.5)");
        }
    }

    public RetryBackoffSpec withRetryContext(ContextView contextView) {
        return new RetryBackoffSpec(contextView, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.minBackoff, this.maxBackoff, this.multiplier, this.jitterFactor, this.backoffSchedulerSupplier, this.syncPreRetry, this.syncPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public /* bridge */ /* synthetic */ c generateCompanion(Flux flux) {
        return generateCompanion((Flux<Retry.RetrySignal>) flux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Scheduler lambda$scheduler$3(Scheduler scheduler) {
        return scheduler;
    }
}
