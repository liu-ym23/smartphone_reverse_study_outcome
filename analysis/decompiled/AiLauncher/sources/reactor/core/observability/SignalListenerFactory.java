package reactor.core.observability;

import qc.b;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
public interface SignalListenerFactory<T, STATE> {
    SignalListener<T> createListener(b<? extends T> bVar, ContextView contextView, STATE state);

    STATE initializePublisherState(b<? extends T> bVar);
}
