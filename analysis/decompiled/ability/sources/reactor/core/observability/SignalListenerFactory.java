package reactor.core.observability;

import Z9.c;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
public interface SignalListenerFactory<T, STATE> {
    SignalListener<T> createListener(c cVar, ContextView contextView, STATE state);

    STATE initializePublisherState(c cVar);
}
