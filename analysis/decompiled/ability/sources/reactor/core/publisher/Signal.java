package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.Supplier;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
public interface Signal<T> extends Supplier<T>, Consumer<Z9.d> {
    static <T> Signal<T> complete() {
        return ImmutableSignal.onComplete();
    }

    static <T> Signal<T> error(Throwable th) {
        return error(th, Context.empty());
    }

    static boolean isComplete(Object obj) {
        if (obj != ImmutableSignal.onComplete()) {
            return (obj instanceof Signal) && ((Signal) obj).getType() == SignalType.ON_COMPLETE;
        }
        return true;
    }

    static boolean isError(Object obj) {
        return (obj instanceof Signal) && ((Signal) obj).getType() == SignalType.ON_ERROR;
    }

    static <T> Signal<T> next(T t9) {
        return next(t9, Context.empty());
    }

    static <T> Signal<T> subscribe(Z9.e eVar) {
        return subscribe(eVar, Context.empty());
    }

    @Override // java.util.function.Supplier
    @Nullable
    T get();

    ContextView getContextView();

    @Nullable
    Z9.e getSubscription();

    @Nullable
    Throwable getThrowable();

    SignalType getType();

    default boolean hasError() {
        return isOnError() && getThrowable() != null;
    }

    default boolean hasValue() {
        return isOnNext() && get() != null;
    }

    default boolean isOnComplete() {
        return getType() == SignalType.ON_COMPLETE;
    }

    default boolean isOnError() {
        return getType() == SignalType.ON_ERROR;
    }

    default boolean isOnNext() {
        return getType() == SignalType.ON_NEXT;
    }

    default boolean isOnSubscribe() {
        return getType() == SignalType.ON_SUBSCRIBE;
    }

    static <T> Signal<T> complete(Context context) {
        return context.isEmpty() ? ImmutableSignal.onComplete() : new ImmutableSignal(context, SignalType.ON_COMPLETE, null, null, null);
    }

    static <T> Signal<T> error(Throwable th, Context context) {
        return new ImmutableSignal(context, SignalType.ON_ERROR, null, th, null);
    }

    static <T> Signal<T> next(T t9, Context context) {
        return new ImmutableSignal(context, SignalType.ON_NEXT, t9, null, null);
    }

    static <T> Signal<T> subscribe(Z9.e eVar, Context context) {
        return new ImmutableSignal(context, SignalType.ON_SUBSCRIBE, null, null, eVar);
    }

    @Override // java.util.function.Consumer
    default void accept(Z9.d dVar) {
        if (isOnNext()) {
            dVar.onNext(get());
            return;
        }
        if (isOnComplete()) {
            dVar.onComplete();
        } else if (isOnError()) {
            dVar.onError(getThrowable());
        } else if (isOnSubscribe()) {
            dVar.onSubscribe(getSubscription());
        }
    }
}
