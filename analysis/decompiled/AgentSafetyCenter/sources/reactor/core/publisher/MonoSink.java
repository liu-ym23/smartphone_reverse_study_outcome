package reactor.core.publisher;

import java.util.function.LongConsumer;
import reactor.core.Disposable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface MonoSink<T> {
    default ContextView contextView() {
        return currentContext();
    }

    @Deprecated
    Context currentContext();

    void error(Throwable th);

    MonoSink<T> onCancel(Disposable disposable);

    MonoSink<T> onDispose(Disposable disposable);

    MonoSink<T> onRequest(LongConsumer longConsumer);

    void success();

    void success(@Nullable T t10);
}
