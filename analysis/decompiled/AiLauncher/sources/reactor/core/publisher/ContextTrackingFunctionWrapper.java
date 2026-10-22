package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.FluxContextWrite;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
class ContextTrackingFunctionWrapper<T, V> implements Function<qc.b<T>, CorePublisher<V>> {
    static final String CONTEXT_MARKER_PREFIX = "reactor.core.context.marker.";
    final String marker;
    final Function<? super qc.b<T>, ? extends qc.b<V>> transformer;

    public ContextTrackingFunctionWrapper(Function<? super qc.b<T>, ? extends qc.b<V>> function) {
        this(function, function.toString());
    }

    public static /* synthetic */ CoreSubscriber a(ContextTrackingFunctionWrapper contextTrackingFunctionWrapper, String str, qc.b bVar, CoreSubscriber coreSubscriber) {
        contextTrackingFunctionWrapper.getClass();
        Context contextCurrentContext = coreSubscriber.currentContext();
        if (contextCurrentContext.hasKey(str)) {
            return new FluxContextWrite.ContextWriteSubscriber(coreSubscriber, contextCurrentContext.delete(str));
        }
        throw new IllegalStateException("Context loss after applying " + contextTrackingFunctionWrapper.marker);
    }

    public ContextTrackingFunctionWrapper(Function<? super qc.b<T>, ? extends qc.b<V>> function, String str) {
        this.transformer = function;
        this.marker = str;
    }

    @Override // java.util.function.Function
    public CorePublisher<V> apply(qc.b<T> bVar) {
        final String str = CONTEXT_MARKER_PREFIX + System.identityHashCode(bVar);
        final qc.b<V> bVarApply = this.transformer.apply((qc.b) Operators.liftPublisher(new BiFunction() { // from class: reactor.core.publisher.j
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ContextTrackingFunctionWrapper.a(this.f39765a, str, (qc.b) obj, (CoreSubscriber) obj2);
            }
        }).apply(bVar));
        return new CorePublisher<V>() { // from class: reactor.core.publisher.ContextTrackingFunctionWrapper.1
            @Override // reactor.core.CorePublisher
            public void subscribe(CoreSubscriber<? super V> coreSubscriber) {
                FluxContextWrite.ContextWriteSubscriber contextWriteSubscriber = new FluxContextWrite.ContextWriteSubscriber(coreSubscriber, coreSubscriber.currentContext().put(str, Boolean.TRUE));
                qc.b bVar2 = bVarApply;
                if (bVar2 instanceof CorePublisher) {
                    ((CorePublisher) bVar2).subscribe((CoreSubscriber) contextWriteSubscriber);
                } else {
                    bVar2.subscribe(contextWriteSubscriber);
                }
            }

            @Override // reactor.core.CorePublisher, qc.b
            public void subscribe(qc.c<? super V> cVar) {
                subscribe((CoreSubscriber) Operators.toCoreSubscriber(cVar));
            }
        };
    }
}
