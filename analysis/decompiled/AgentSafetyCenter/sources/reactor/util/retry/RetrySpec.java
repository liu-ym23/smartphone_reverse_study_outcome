package reactor.util.retry;

import a8.c;
import androidx.room.a0;
import b8.h;
import io.modelcontextprotocol.server.e;
import io.modelcontextprotocol.server.m;
import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
    static final Consumer<Retry.RetrySignal> NO_OP_CONSUMER = new h(8);
    static final BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> NO_OP_BIFUNCTION = new m(3);
    static final BiFunction<RetrySpec, Retry.RetrySignal, Throwable> RETRY_EXCEPTION_GENERATOR = new m(4);

    public RetrySpec(ContextView contextView, long j10, Predicate<? super Throwable> predicate, boolean z10, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, BiFunction<RetrySpec, Retry.RetrySignal, Throwable> biFunction3) {
        super(contextView);
        this.maxAttempts = j10;
        predicate.getClass();
        io.modelcontextprotocol.spec.h hVar = new io.modelcontextprotocol.spec.h(2);
        hVar.f6367f = predicate;
        VarHandle.storeStoreFence();
        this.errorFilter = hVar;
        this.isTransientErrors = z10;
        this.doPreRetry = consumer;
        this.doPostRetry = consumer2;
        this.asyncPreRetry = biFunction;
        this.asyncPostRetry = biFunction2;
        this.retryExhaustedGenerator = biFunction3;
    }

    public static <T> Mono<T> applyHooks(Retry.RetrySignal retrySignal, Mono<T> mono, Consumer<Retry.RetrySignal> consumer, Consumer<Retry.RetrySignal> consumer2, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction, BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction2, ContextView contextView) {
        Mono<Void> monoEmpty;
        Consumer<Retry.RetrySignal> consumer3 = NO_OP_CONSUMER;
        if (consumer != consumer3) {
            try {
                consumer.accept(retrySignal);
            } catch (Throwable th) {
                return Mono.error(th);
            }
        }
        if (consumer2 != consumer3) {
            a0 a0Var = new a0(9);
            a0Var.f1506f = consumer2;
            a0Var.f1507g = retrySignal;
            VarHandle.storeStoreFence();
            monoEmpty = Mono.fromRunnable(a0Var);
        } else {
            monoEmpty = Mono.empty();
        }
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction3 = NO_OP_BIFUNCTION;
        Mono<Void> monoEmpty2 = biFunction == biFunction3 ? Mono.empty() : biFunction.apply(retrySignal, Mono.empty());
        if (biFunction2 != biFunction3) {
            monoEmpty = biFunction2.apply(retrySignal, monoEmpty);
        }
        Mono<V> monoThen = monoEmpty2.then(mono);
        monoEmpty.getClass();
        c cVar = new c(6);
        cVar.f234b = monoEmpty;
        VarHandle.storeStoreFence();
        return monoThen.flatMap(cVar).contextWrite(contextView);
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
    public /* synthetic */ qd.c lambda$generateCompanion$6(Flux flux, ContextView contextView) {
        Flux fluxContextWrite = flux.contextWrite(contextView);
        e eVar = new e(9);
        eVar.f6261b = this;
        eVar.f6262c = contextView;
        VarHandle.storeStoreFence();
        return fluxContextWrite.concatMap(eVar).onErrorStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$null$5(ContextView contextView, Retry.RetrySignal retrySignal) {
        Retry.RetrySignal retrySignalCopy = retrySignal.copy();
        Throwable thFailure = retrySignalCopy.failure();
        long j10 = this.isTransientErrors ? retrySignalCopy.totalRetriesInARow() : retrySignalCopy.totalRetries();
        return thFailure == null ? androidx.activity.b.q("RetryWhenState#failure() not expected to be null") : !this.errorFilter.test(thFailure) ? Mono.error(thFailure) : j10 >= this.maxAttempts ? Mono.error(this.retryExhaustedGenerator.apply(this, retrySignalCopy)) : applyHooks(retrySignalCopy, Mono.just(Long.valueOf(j10)), this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, contextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Throwable lambda$static$2(RetrySpec retrySpec, Retry.RetrySignal retrySignal) {
        String str;
        if (retrySpec.isTransientErrors) {
            str = retrySignal.totalRetriesInARow() + "/" + retrySpec.maxAttempts + " in a row (" + retrySignal.totalRetries() + " total)";
        } else {
            str = retrySignal.totalRetries() + "/" + retrySpec.maxAttempts;
        }
        return Exceptions.retryExhausted("Retries exhausted: ".concat(str), retrySignal.failure());
    }

    public RetrySpec doAfterRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry, this.doPostRetry.andThen(consumer), this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec doAfterRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Consumer<Retry.RetrySignal> consumer = this.doPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.doPostRetry;
        BiFunction<Retry.RetrySignal, Mono<Void>, Mono<Void>> biFunction = this.asyncPreRetry;
        b bVar = new b(1);
        bVar.f10925f = this;
        bVar.f10926g = function;
        VarHandle.storeStoreFence();
        return new RetrySpec(contextView, j10, predicate, z10, consumer, consumer2, biFunction, bVar, this.retryExhaustedGenerator);
    }

    public RetrySpec doBeforeRetry(Consumer<Retry.RetrySignal> consumer) {
        return new RetrySpec(this.retryContext, this.maxAttempts, this.errorFilter, this.isTransientErrors, this.doPreRetry.andThen(consumer), this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec doBeforeRetryAsync(Function<Retry.RetrySignal, Mono<Void>> function) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Predicate<Throwable> predicate = this.errorFilter;
        boolean z10 = this.isTransientErrors;
        Consumer<Retry.RetrySignal> consumer = this.doPreRetry;
        Consumer<Retry.RetrySignal> consumer2 = this.doPostRetry;
        b bVar = new b(0);
        bVar.f10925f = this;
        bVar.f10926g = function;
        VarHandle.storeStoreFence();
        return new RetrySpec(contextView, j10, predicate, z10, consumer, consumer2, bVar, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    public RetrySpec filter(Predicate<? super Throwable> predicate) {
        ContextView contextView = this.retryContext;
        long j10 = this.maxAttempts;
        Objects.requireNonNull(predicate, "errorFilter");
        return new RetrySpec(contextView, j10, predicate, this.isTransientErrors, this.doPreRetry, this.doPostRetry, this.asyncPreRetry, this.asyncPostRetry, this.retryExhaustedGenerator);
    }

    @Override // reactor.util.retry.Retry
    public Flux<Long> generateCompanion(Flux<Retry.RetrySignal> flux) {
        e eVar = new e(8);
        eVar.f6261b = this;
        eVar.f6262c = flux;
        VarHandle.storeStoreFence();
        return Flux.deferContextual(eVar);
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
    public /* bridge */ /* synthetic */ qd.c generateCompanion(Flux flux) {
        return generateCompanion((Flux<Retry.RetrySignal>) flux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Retry.RetrySignal retrySignal) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$static$1(Retry.RetrySignal retrySignal, Mono mono) {
        return mono;
    }
}
