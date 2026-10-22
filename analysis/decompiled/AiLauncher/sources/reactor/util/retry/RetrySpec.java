package reactor.util.retry;

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

/* loaded from: classes5.dex */
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
    static final Consumer<Retry.RetrySignal> NO_OP_CONSUMER = new Consumer() { // from class: reactor.util.retry.p
        @Override // java.util.function.Consumer
        public final void accept(Object obj) {
            RetrySpec.j((Retry.RetrySignal) obj);
        }
    };
    static final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> NO_OP_BIFUNCTION = new BiFunction() { // from class: reactor.util.retry.q
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return RetrySpec.k((Retry.RetrySignal) obj, (Mono) obj2);
        }
    };
    static final BiFunction<RetrySpec, Retry.RetrySignal, Throwable> RETRY_EXCEPTION_GENERATOR = new BiFunction() { // from class: reactor.util.retry.r
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return RetrySpec.m((RetrySpec) obj, (Retry.RetrySignal) obj2);
        }
    };

    public RetrySpec(ContextView contextView, long j10, Predicate<? super Throwable> predicate, boolean z10, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, BiFunction<RetrySpec, Retry.RetrySignal, Throwable> biFunction3) {
        super(contextView);
        this.maxAttempts = j10;
        predicate.getClass();
        this.errorFilter = new h(predicate);
        this.isTransientErrors = z10;
        this.doPreRetry = consumer;
        this.doPostRetry = consumer2;
        this.asyncPreRetry = biFunction;
        this.asyncPostRetry = biFunction2;
        this.retryExhaustedGenerator = biFunction3;
    }

    public static <T> Mono<T> applyHooks(final Retry.RetrySignal retrySignal, Mono<T> mono, Consumer<Retry.RetrySignal> consumer, final Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, ContextView contextView) {
        Consumer<Retry.RetrySignal> consumer3 = NO_OP_CONSUMER;
        if (consumer != consumer3) {
            try {
                consumer.accept(retrySignal);
            } catch (Throwable th) {
                return Mono.error(th);
            }
        }
        final Mono<Void> monoFromRunnable = consumer2 != consumer3 ? Mono.fromRunnable(new Runnable() { // from class: reactor.util.retry.v
            @Override // java.lang.Runnable
            public final void run() {
                consumer2.accept(retrySignal);
            }
        }) : Mono.empty();
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = NO_OP_BIFUNCTION;
        Mono<Void> monoEmpty = biFunction == biFunction3 ? Mono.empty() : biFunction.apply(retrySignal, Mono.empty());
        if (biFunction2 != biFunction3) {
            monoFromRunnable = biFunction2.apply(retrySignal, monoFromRunnable);
        }
        Mono<V> monoThen = monoEmpty.then(mono);
        monoFromRunnable.getClass();
        return monoThen.flatMap(new Function() { // from class: reactor.util.retry.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return monoFromRunnable.thenReturn(obj);
            }
        }).contextWrite(contextView);
    }

    public static /* synthetic */ qc.b f(RetrySpec retrySpec, ContextView contextView, Retry.RetrySignal retrySignal) {
        retrySpec.getClass();
        Retry.RetrySignal retrySignalCopy = retrySignal.copy();
        Throwable thFailure = retrySignalCopy.failure();
        long j10 = retrySpec.isTransientErrors ? retrySignalCopy.totalRetriesInARow() : retrySignalCopy.totalRetries();
        return thFailure == null ? Mono.error(new IllegalStateException("RetryWhenState#failure() not expected to be null")) : !retrySpec.errorFilter.test(thFailure) ? Mono.error(thFailure) : j10 >= retrySpec.maxAttempts ? Mono.error(retrySpec.retryExhaustedGenerator.apply(retrySpec, retrySignalCopy)) : applyHooks(retrySignalCopy, Mono.just(Long.valueOf(j10)), retrySpec.doPreRetry, retrySpec.doPostRetry, retrySpec.asyncPreRetry, retrySpec.asyncPostRetry, contextView);
    }

    public static /* synthetic */ qc.b i(final RetrySpec retrySpec, Flux flux, final ContextView contextView) {
        retrySpec.getClass();
        return flux.contextWrite(contextView).concatMap(new Function() { // from class: reactor.util.retry.u
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RetrySpec.f(this.f39881a, contextView, (Retry.RetrySignal) obj);
            }
        }).onErrorStop();
    }

    public static /* synthetic */ void j(Retry.RetrySignal retrySignal) {
    }

    public static /* synthetic */ Mono k(Retry.RetrySignal retrySignal, Mono mono) {
        return mono;
    }

    public static /* synthetic */ Throwable m(RetrySpec retrySpec, Retry.RetrySignal retrySignal) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Retries exhausted: ");
        if (retrySpec.isTransientErrors) {
            str = retrySignal.totalRetriesInARow() + "/" + retrySpec.maxAttempts + " in a row (" + retrySignal.totalRetries() + " total)";
        } else {
            str = retrySignal.totalRetries() + "/" + retrySpec.maxAttempts;
        }
        sb2.append(str);
        return Exceptions.retryExhausted(sb2.toString(), retrySignal.failure());
    }

    public RetrySpec doAfterRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry.andThen(consumer), this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec doAfterRetryAsync(final Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, new BiFunction() { // from class: reactor.util.retry.s
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Retry.RetrySignal retrySignal = (Retry.RetrySignal) obj;
                return this.f39877a.asyncPostRetry.apply(retrySignal, (Mono) obj2).then((Mono) function.apply(retrySignal));
            }
        }, this.retryExhaustedGenerator);
    }

    public RetrySpec doBeforeRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry.andThen(consumer), this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec doBeforeRetryAsync(final Function<Retry.RetrySignal, Mono<Void>> function) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, new BiFunction() { // from class: reactor.util.retry.o
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Retry.RetrySignal retrySignal = (Retry.RetrySignal) obj;
                return this.f39875a.asyncPreRetry.apply(retrySignal, (Mono) obj2).then((Mono) function.apply(retrySignal));
            }
        }, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec filter(Predicate<? super Throwable> predicate) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Objects.requireNonNull(predicate, "errorFilter");
        return new RetrySpec(contextView, j10, predicate, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public /* bridge */ /* synthetic */ qc.b generateCompanion(Flux flux) {
        return generateCompanion((Flux<Retry.RetrySignal>) flux);
    }

    public RetrySpec maxAttempts(long j10) {
        return new RetrySpec(this.retryContext, j10, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec modifyErrorFilter(Function<Predicate<Throwable>, Predicate<? super Throwable>> function) {
        Objects.requireNonNull(function, "predicateAdjuster");
        Predicate<? super Throwable> predicateApply = function.apply(this.errorFilter);
        Objects.requireNonNull(predicateApply, "predicateAdjuster must return a new predicate");
        return new RetrySpec(this.retryContext, this.maxAttempts, predicateApply, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec onRetryExhaustedThrow(BiFunction<RetrySpec, Retry.RetrySignal, Throwable> biFunction) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Consumer<Retry.RetrySignal> consumer = this.doPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.doPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2 = this.asyncPreRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = this.asyncPostRetry;
        Objects.requireNonNull(biFunction, "retryExhaustedGenerator");
        return new RetrySpec(contextView, j10, predicate, z10, consumer, consumer2, biFunction2, biFunction3, biFunction);
    }

    public RetrySpec transientErrors(boolean z10) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, z10, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec withRetryContext(ContextView contextView) {
        return new RetrySpec(contextView, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public Flux<Long> generateCompanion(final Flux<Retry.RetrySignal> flux) {
        return Flux.deferContextual(new Function() { // from class: reactor.util.retry.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RetrySpec.i(this.f39879a, flux, (ContextView) obj);
            }
        });
    }
}
