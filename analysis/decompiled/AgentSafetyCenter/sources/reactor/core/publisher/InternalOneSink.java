package reactor.core.publisher;

import reactor.core.Exceptions;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface InternalOneSink<T> extends Sinks.One<T>, InternalEmptySink<T> {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: reactor.core.publisher.InternalOneSink$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$Sinks$EmitResult;

        static {
            int[] iArr = new int[Sinks.EmitResult.values().length];
            $SwitchMap$reactor$core$publisher$Sinks$EmitResult = iArr;
            try {
                iArr[Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_NON_SERIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.One
    default void emitValue(@Nullable T t10, Sinks.EmitFailureHandler emitFailureHandler) {
        Sinks.EmitResult emitResultTryEmitValue;
        if (t10 == null) {
            emitEmpty(emitFailureHandler);
            return;
        }
        do {
            emitResultTryEmitValue = tryEmitValue(t10);
            if (emitResultTryEmitValue.isSuccess()) {
                return;
            }
        } while (emitFailureHandler.onEmitFailure(SignalType.ON_NEXT, emitResultTryEmitValue));
        int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$Sinks$EmitResult[emitResultTryEmitValue.ordinal()];
        if (i != 1) {
            if (i == 2) {
                Operators.onDiscard(t10, currentContext());
                emitError(Exceptions.failWithOverflow("Backpressure overflow during Sinks.One#emitValue"), emitFailureHandler);
            } else if (i == 3) {
                Operators.onDiscard(t10, currentContext());
            } else if (i == 4) {
                Operators.onNextDropped(t10, currentContext());
            } else {
                if (i == 5) {
                    throw new Sinks.EmissionException(emitResultTryEmitValue, "Spec. Rule 1.3 - onSubscribe, onNext, onError and onComplete signaled to a Subscriber MUST be signaled serially.");
                }
                throw new Sinks.EmissionException(emitResultTryEmitValue, "Unknown emitResult value");
            }
        }
    }
}
