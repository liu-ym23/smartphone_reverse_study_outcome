package reactor.core.publisher;

import java.io.Serializable;
import java.util.Objects;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
final class ImmutableSignal<T> implements Signal<T>, Serializable {
    private static final Signal<?> ON_COMPLETE = new ImmutableSignal(Context.empty(), SignalType.ON_COMPLETE, null, null, null);
    private static final long serialVersionUID = -2004454746525418508L;
    private final transient ContextView contextView;
    private final transient qc.d subscription;
    private final Throwable throwable;
    private final SignalType type;
    private final T value;

    /* renamed from: reactor.core.publisher.ImmutableSignal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$SignalType;

        static {
            int[] iArr = new int[SignalType.values().length];
            $SwitchMap$reactor$core$publisher$SignalType = iArr;
            try {
                iArr[SignalType.ON_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ImmutableSignal(ContextView contextView, SignalType signalType, @Nullable T t10, @Nullable Throwable th, @Nullable qc.d dVar) {
        this.contextView = contextView;
        this.value = t10;
        this.subscription = dVar;
        this.throwable = th;
        this.type = signalType;
    }

    public static <U> Signal<U> onComplete() {
        return (Signal<U>) ON_COMPLETE;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Signal)) {
            Signal signal = (Signal) obj;
            if (getType() != signal.getType()) {
                return false;
            }
            if (isOnComplete()) {
                return true;
            }
            if (isOnSubscribe()) {
                return Objects.equals(getSubscription(), signal.getSubscription());
            }
            if (isOnError()) {
                return Objects.equals(getThrowable(), signal.getThrowable());
            }
            if (isOnNext()) {
                return Objects.equals(get(), signal.get());
            }
        }
        return false;
    }

    @Override // reactor.core.publisher.Signal, java.util.function.Supplier
    @Nullable
    public T get() {
        return this.value;
    }

    @Override // reactor.core.publisher.Signal
    public ContextView getContextView() {
        return this.contextView;
    }

    @Override // reactor.core.publisher.Signal
    @Nullable
    public qc.d getSubscription() {
        return this.subscription;
    }

    @Override // reactor.core.publisher.Signal
    @Nullable
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // reactor.core.publisher.Signal
    public SignalType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = getType().hashCode();
        if (isOnError()) {
            return (iHashCode * 31) + (getThrowable() != null ? getThrowable().hashCode() : 0);
        }
        if (isOnNext()) {
            return (iHashCode * 31) + (get() != null ? get().hashCode() : 0);
        }
        if (isOnSubscribe()) {
            return (iHashCode * 31) + (getSubscription() != null ? getSubscription().hashCode() : 0);
        }
        return iHashCode;
    }

    public String toString() {
        int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$SignalType[getType().ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? String.format("Signal type=%s", getType()) : "onComplete()" : String.format("onError(%s)", getThrowable()) : String.format("onNext(%s)", get()) : String.format("onSubscribe(%s)", getSubscription());
    }
}
