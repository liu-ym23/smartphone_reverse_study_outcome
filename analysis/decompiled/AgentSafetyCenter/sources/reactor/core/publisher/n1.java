package reactor.core.publisher;

import reactor.core.publisher.Sinks;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class n1 implements Sinks.EmitFailureHandler {
    @Override // reactor.core.publisher.Sinks.EmitFailureHandler
    public final boolean onEmitFailure(SignalType signalType, Sinks.EmitResult emitResult) {
        return Sinks.EmitFailureHandler.lambda$static$0(signalType, emitResult);
    }
}
