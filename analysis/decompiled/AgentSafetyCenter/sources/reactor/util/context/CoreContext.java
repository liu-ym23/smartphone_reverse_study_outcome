package reactor.util.context;

import java.util.Map;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface CoreContext extends Context {
    @Override // reactor.util.context.ContextView
    default boolean isEmpty() {
        return false;
    }

    @Override // reactor.util.context.Context
    default Context putAll(ContextView contextView) {
        if (contextView.isEmpty()) {
            return this;
        }
        if (contextView instanceof CoreContext) {
            return ((CoreContext) contextView).putAllInto(this);
        }
        ContextN contextN = new ContextN(contextView.size() + size());
        unsafePutAllInto(contextN);
        ((Stream) contextView.stream().sequential()).forEach(contextN);
        return contextN.size() <= 5 ? Context.of((Map<?, ?>) contextN) : contextN;
    }

    Context putAllInto(Context context);

    void unsafePutAllInto(ContextN contextN);
}
