package reactor.core.publisher;

import java.time.Duration;
import java.util.Queue;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public final class Sinks {

    public static final class EmissionException extends IllegalStateException {
        final EmitResult reason;

        public EmissionException(EmitResult emitResult) {
            this(emitResult, "Sink emission failed with " + emitResult);
        }

        public EmitResult getReason() {
            return this.reason;
        }

        public EmissionException(Throwable th, EmitResult emitResult) {
            super("Sink emission failed with " + emitResult, th);
            this.reason = emitResult;
        }

        public EmissionException(EmitResult emitResult, String str) {
            super(str);
            this.reason = emitResult;
        }
    }

    public interface EmitFailureHandler {
        public static final EmitFailureHandler FAIL_FAST = new EmitFailureHandler() { // from class: reactor.core.publisher.I2
            @Override // reactor.core.publisher.Sinks.EmitFailureHandler
            public final boolean onEmitFailure(SignalType signalType, Sinks.EmitResult emitResult) {
                return Sinks.EmitFailureHandler.a(signalType, emitResult);
            }
        };

        static /* synthetic */ boolean a(SignalType signalType, EmitResult emitResult) {
            return false;
        }

        static EmitFailureHandler busyLooping(Duration duration) {
            return new OptimisticEmitFailureHandler(duration);
        }

        boolean onEmitFailure(SignalType signalType, EmitResult emitResult);
    }

    public enum EmitResult {
        OK,
        FAIL_TERMINATED,
        FAIL_OVERFLOW,
        FAIL_CANCELLED,
        FAIL_NON_SERIALIZED,
        FAIL_ZERO_SUBSCRIBER;

        public boolean isFailure() {
            return this != OK;
        }

        public boolean isSuccess() {
            return this == OK;
        }

        public void orThrow() {
            if (this != OK) {
                throw new EmissionException(this);
            }
        }

        public void orThrowWithCause(Throwable th) {
            if (this != OK) {
                throw new EmissionException(th, this);
            }
        }
    }

    public interface Empty<T> extends Scannable {
        Mono<T> asMono();

        int currentSubscriberCount();

        void emitEmpty(EmitFailureHandler emitFailureHandler);

        void emitError(Throwable th, EmitFailureHandler emitFailureHandler);

        EmitResult tryEmitEmpty();

        EmitResult tryEmitError(Throwable th);
    }

    public interface Many<T> extends Scannable {
        Flux<T> asFlux();

        int currentSubscriberCount();

        void emitComplete(EmitFailureHandler emitFailureHandler);

        void emitError(Throwable th, EmitFailureHandler emitFailureHandler);

        void emitNext(T t10, EmitFailureHandler emitFailureHandler);

        EmitResult tryEmitComplete();

        EmitResult tryEmitError(Throwable th);

        EmitResult tryEmitNext(T t10);
    }

    public interface ManySpec {
        MulticastSpec multicast();

        MulticastReplaySpec replay();

        UnicastSpec unicast();
    }

    public interface ManyWithUpstream<T> extends Many<T> {
        Disposable subscribeTo(qc.b<? extends T> bVar);
    }

    public interface ManyWithUpstreamUnsafeSpec {
        <T> ManyWithUpstream<T> multicastOnBackpressureBuffer();

        <T> ManyWithUpstream<T> multicastOnBackpressureBuffer(int i10, boolean z10);
    }

    public interface MulticastReplaySpec {
        <T> Many<T> all();

        <T> Many<T> all(int i10);

        <T> Many<T> latest();

        <T> Many<T> latestOrDefault(T t10);

        <T> Many<T> limit(int i10);

        <T> Many<T> limit(int i10, Duration duration);

        <T> Many<T> limit(int i10, Duration duration, Scheduler scheduler);

        <T> Many<T> limit(Duration duration);

        <T> Many<T> limit(Duration duration, Scheduler scheduler);
    }

    public interface MulticastSpec {
        <T> Many<T> directAllOrNothing();

        <T> Many<T> directBestEffort();

        <T> Many<T> onBackpressureBuffer();

        <T> Many<T> onBackpressureBuffer(int i10);

        <T> Many<T> onBackpressureBuffer(int i10, boolean z10);
    }

    public interface One<T> extends Empty<T> {
        void emitValue(@Nullable T t10, EmitFailureHandler emitFailureHandler);

        EmitResult tryEmitValue(@Nullable T t10);
    }

    public static class OptimisticEmitFailureHandler implements EmitFailureHandler {
        private final long deadline;

        public OptimisticEmitFailureHandler(Duration duration) {
            this.deadline = System.nanoTime() + duration.toNanos();
        }

        @Override // reactor.core.publisher.Sinks.EmitFailureHandler
        public boolean onEmitFailure(SignalType signalType, EmitResult emitResult) {
            return emitResult.equals(EmitResult.FAIL_NON_SERIALIZED) && System.nanoTime() < this.deadline;
        }
    }

    public interface RootSpec {
        <T> Empty<T> empty();

        ManySpec many();

        ManyWithUpstreamUnsafeSpec manyWithUpstream();

        <T> One<T> one();
    }

    public interface UnicastSpec {
        <T> Many<T> onBackpressureBuffer();

        <T> Many<T> onBackpressureBuffer(Queue<T> queue);

        <T> Many<T> onBackpressureBuffer(Queue<T> queue, Disposable disposable);

        <T> Many<T> onBackpressureError();
    }

    private Sinks() {
    }

    public static <T> Empty<T> empty() {
        return SinksSpecs.DEFAULT_SINKS.empty();
    }

    public static ManySpec many() {
        return SinksSpecs.DEFAULT_SINKS.many();
    }

    public static <T> One<T> one() {
        return SinksSpecs.DEFAULT_SINKS.one();
    }

    public static RootSpec unsafe() {
        return SinksSpecs.UNSAFE_ROOT_SPEC;
    }
}
