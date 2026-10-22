package reactor.core.publisher;

import reactor.core.publisher.Sinks;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class o1 implements Sinks.EmitFailureHandler {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ UnicastProcessor f10831a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Sinks.EmitFailureHandler f10832b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10833c;

    @Override // reactor.core.publisher.Sinks.EmitFailureHandler
    public final boolean onEmitFailure(SignalType signalType, Sinks.EmitResult emitResult) {
        return this.f10831a.lambda$emitNext$0(this.f10832b, this.f10833c, signalType, emitResult);
    }
}
