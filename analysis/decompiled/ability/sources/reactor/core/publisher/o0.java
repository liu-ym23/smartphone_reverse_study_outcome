package reactor.core.publisher;

import reactor.core.publisher.Sinks;

/* loaded from: classes4.dex */
public final /* synthetic */ class o0 implements Sinks.EmitFailureHandler {
    @Override // reactor.core.publisher.Sinks.EmitFailureHandler
    public final boolean onEmitFailure(SignalType signalType, Sinks.EmitResult emitResult) {
        return Sinks.EmitFailureHandler.lambda$static$0(signalType, emitResult);
    }
}
