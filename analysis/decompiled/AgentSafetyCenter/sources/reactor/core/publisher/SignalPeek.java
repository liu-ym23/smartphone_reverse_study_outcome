package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface SignalPeek<T> extends Scannable {
    @Nullable
    default Consumer<? super T> onAfterNextCall() {
        return null;
    }

    @Nullable
    Runnable onAfterTerminateCall();

    @Nullable
    Runnable onCancelCall();

    @Nullable
    Runnable onCompleteCall();

    @Nullable
    default Consumer<? super Context> onCurrentContextCall() {
        return null;
    }

    @Nullable
    Consumer<? super Throwable> onErrorCall();

    @Nullable
    Consumer<? super T> onNextCall();

    @Nullable
    LongConsumer onRequestCall();

    @Nullable
    Consumer<? super qd.e> onSubscribeCall();
}
