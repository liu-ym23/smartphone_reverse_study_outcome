package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.FluxContextWrite;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
class ContextTrackingFunctionWrapper<T, V> implements Function<Z9.c, CorePublisher<V>> {
    static final String CONTEXT_MARKER_PREFIX = "reactor.core.context.marker.";
    final String marker;
    final Function<? super Z9.c, ? extends Z9.c> transformer;

    public ContextTrackingFunctionWrapper(Function<? super Z9.c, ? extends Z9.c> function) {
        this(function, function.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CoreSubscriber lambda$apply$0(String str, Z9.c cVar, CoreSubscriber coreSubscriber) {
        Context contextCurrentContext = coreSubscriber.currentContext();
        if (contextCurrentContext.hasKey(str)) {
            return new FluxContextWrite.ContextWriteSubscriber(coreSubscriber, contextCurrentContext.delete(str));
        }
        throw new IllegalStateException("Context loss after applying " + this.marker);
    }

    public ContextTrackingFunctionWrapper(Function<? super Z9.c, ? extends Z9.c> function, String str) {
        this.transformer = function;
        this.marker = str;
    }

    @Override // java.util.function.Function
    public CorePublisher<V> apply(Z9.c cVar) {
        final String str = CONTEXT_MARKER_PREFIX + System.identityHashCode(cVar);
        final Z9.c cVarApply = this.transformer.apply(Operators.liftPublisher(new C1890f(0, this, str)).apply(cVar));
        return new CorePublisher<V>() { // from class: reactor.core.publisher.ContextTrackingFunctionWrapper.1
            @Override // reactor.core.CorePublisher
            public void subscribe(CoreSubscriber<? super V> coreSubscriber) {
                FluxContextWrite.ContextWriteSubscriber contextWriteSubscriber = new FluxContextWrite.ContextWriteSubscriber(coreSubscriber, coreSubscriber.currentContext().put(str, Boolean.TRUE));
                Z9.c cVar2 = cVarApply;
                if (cVar2 instanceof CorePublisher) {
                    ((CorePublisher) cVar2).subscribe((CoreSubscriber) contextWriteSubscriber);
                } else {
                    cVar2.subscribe(contextWriteSubscriber);
                }
            }

            @Override // reactor.core.CorePublisher, Z9.c
            public void subscribe(Z9.d dVar) {
                subscribe((CoreSubscriber) Operators.toCoreSubscriber(dVar));
            }
        };
    }
}
