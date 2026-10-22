package reactor.core.publisher;

import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
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
