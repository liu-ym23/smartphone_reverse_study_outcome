package reactor.core.publisher;

import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface SynchronousSink<T> {
    void complete();

    default ContextView contextView() {
        return currentContext();
    }

    @Deprecated
    Context currentContext();

    void error(Throwable th);

    void next(T t10);
}
