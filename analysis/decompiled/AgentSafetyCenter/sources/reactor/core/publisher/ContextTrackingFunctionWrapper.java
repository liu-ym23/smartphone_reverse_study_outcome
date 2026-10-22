package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.function.Function;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.FluxContextWrite;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class ContextTrackingFunctionWrapper<T, V> implements Function<qd.c, CorePublisher<V>> {
    static final String CONTEXT_MARKER_PREFIX = "reactor.core.context.marker.";
    final String marker;
    final Function<? super qd.c, ? extends qd.c> transformer;

    public ContextTrackingFunctionWrapper(Function<? super qd.c, ? extends qd.c> function) {
        this(function, function.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CoreSubscriber lambda$apply$0(String str, qd.c cVar, CoreSubscriber coreSubscriber) {
        Context contextCurrentContext = coreSubscriber.currentContext();
        if (contextCurrentContext.hasKey(str)) {
            return new FluxContextWrite.ContextWriteSubscriber(coreSubscriber, contextCurrentContext.delete(str));
        }
        ad.o.n(this.marker, "Context loss after applying ");
        return null;
    }

    @Override // java.util.function.Function
    public CorePublisher<V> apply(qd.c cVar) {
        final String str = CONTEXT_MARKER_PREFIX + System.identityHashCode(cVar);
        f fVar = new f(0);
        fVar.f10784f = this;
        fVar.f10785g = str;
        VarHandle.storeStoreFence();
        final qd.c cVarApply = this.transformer.apply(Operators.liftPublisher(fVar).apply(cVar));
        return new CorePublisher<V>() { // from class: reactor.core.publisher.ContextTrackingFunctionWrapper.1
            @Override // reactor.core.CorePublisher
            public void subscribe(CoreSubscriber<? super V> coreSubscriber) {
                FluxContextWrite.ContextWriteSubscriber contextWriteSubscriber = new FluxContextWrite.ContextWriteSubscriber(coreSubscriber, coreSubscriber.currentContext().put(str, Boolean.TRUE));
                qd.c cVar2 = cVarApply;
                if (cVar2 instanceof CorePublisher) {
                    ((CorePublisher) cVar2).subscribe((CoreSubscriber) contextWriteSubscriber);
                } else {
                    cVar2.subscribe(contextWriteSubscriber);
                }
            }

            @Override // reactor.core.CorePublisher, qd.c
            public void subscribe(qd.d dVar) {
                subscribe((CoreSubscriber) Operators.toCoreSubscriber(dVar));
            }
        };
    }

    public ContextTrackingFunctionWrapper(Function<? super qd.c, ? extends qd.c> function, String str) {
        this.transformer = function;
        this.marker = str;
    }
}
