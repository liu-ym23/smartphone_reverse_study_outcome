package reactor.core.publisher;

import io.micrometer.context.ContextSnapshot;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.observability.SignalListener;
import reactor.core.observability.SignalListenerFactory;
import reactor.core.publisher.FluxTapRestoringThreadLocals;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoTapRestoringThreadLocals<T, STATE> extends MonoOperator<T, T> {
    final STATE commonTapState;
    final SignalListenerFactory<T, STATE> tapFactory;

    public MonoTapRestoringThreadLocals(Mono<? extends T> mono, SignalListenerFactory<T, STATE> signalListenerFactory) {
        super(mono);
        this.tapFactory = signalListenerFactory;
        this.commonTapState = signalListenerFactory.initializePublisherState(mono);
    }

    @Override // reactor.core.publisher.MonoOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return -1;
        }
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Context contextCurrentContext;
        try {
            SignalListener<T> signalListenerCreateListener = this.tapFactory.createListener(this.source, coreSubscriber.currentContext().readOnly(), this.commonTapState);
            try {
                signalListenerCreateListener.doFirst();
                try {
                    contextCurrentContext = signalListenerCreateListener.addToContext(coreSubscriber.currentContext());
                } catch (Throwable th) {
                    signalListenerCreateListener.handleListenerError(new IllegalStateException("Unable to augment tap Context at construction via addToContext", th));
                    contextCurrentContext = coreSubscriber.currentContext();
                }
                ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(contextCurrentContext);
                try {
                    this.source.subscribe((CoreSubscriber) new FluxTapRestoringThreadLocals.TapSubscriber(coreSubscriber, signalListenerCreateListener, contextCurrentContext));
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        if (threadLocals != null) {
                            try {
                                threadLocals.close();
                            } catch (Throwable th4) {
                                th2.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
                signalListenerCreateListener.handleListenerError(th5);
                Operators.error(coreSubscriber, th5);
            }
        } catch (Throwable th6) {
            Operators.error(coreSubscriber, th6);
        }
    }
}
