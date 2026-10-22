package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.Supplier;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
public interface Signal<T> extends Supplier<T>, Consumer<qc.c<? super T>> {
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

    static <T> Signal<T> next(T t10) {
        return next(t10, Context.empty());
    }

    static <T> Signal<T> subscribe(qc.d dVar) {
        return subscribe(dVar, Context.empty());
    }

    @Override // java.util.function.Supplier
    @Nullable
    T get();

    ContextView getContextView();

    @Nullable
    qc.d getSubscription();

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

    static <T> Signal<T> next(T t10, Context context) {
        return new ImmutableSignal(context, SignalType.ON_NEXT, t10, null, null);
    }

    static <T> Signal<T> subscribe(qc.d dVar, Context context) {
        return new ImmutableSignal(context, SignalType.ON_SUBSCRIBE, null, null, dVar);
    }

    @Override // java.util.function.Consumer
    default void accept(qc.c<? super T> cVar) {
        if (isOnNext()) {
            cVar.onNext(get());
            return;
        }
        if (isOnComplete()) {
            cVar.onComplete();
        } else if (isOnError()) {
            cVar.onError(getThrowable());
        } else if (isOnSubscribe()) {
            cVar.onSubscribe(getSubscription());
        }
    }
}
