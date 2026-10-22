package reactor.core.publisher;

import java.util.function.LongConsumer;
import reactor.core.Disposable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface FluxSink<T> {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum OverflowStrategy {
        IGNORE,
        ERROR,
        DROP,
        LATEST,
        BUFFER
    }

    void complete();

    default ContextView contextView() {
        return currentContext();
    }

    @Deprecated
    Context currentContext();

    void error(Throwable th);

    boolean isCancelled();

    FluxSink<T> next(T t10);

    FluxSink<T> onCancel(Disposable disposable);

    FluxSink<T> onDispose(Disposable disposable);

    FluxSink<T> onRequest(LongConsumer longConsumer);

    long requestedFromDownstream();
}
