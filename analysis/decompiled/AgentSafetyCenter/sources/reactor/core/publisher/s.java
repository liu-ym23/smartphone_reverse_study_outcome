package reactor.core.publisher;

import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class s implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10853a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Function f10854b;

    public /* synthetic */ s(int i) {
        this.f10853a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10853a;
        Function function = this.f10854b;
        switch (i) {
            case 0:
                return Flux.lambda$delayUntil$20(function, obj);
            case 1:
                return Flux.lambda$zip$5(function, obj);
            case 2:
                return Flux.lambda$zip$6(function, obj);
            case 3:
                return Flux.lambda$onErrorMap$28(function, (Throwable) obj);
            case 4:
                return Flux.lambda$combineLatest$0(function, obj);
            case 5:
                return Flux.lambda$combineLatest$1(function, obj);
            case 6:
                return Flux.lambda$onErrorMap$29(function, (Throwable) obj);
            case 7:
                return Mono.lambda$zipDelayError$17(function, obj);
            case 8:
                return Mono.lambda$onErrorMap$29(function, (Throwable) obj);
            case 9:
                return Mono.lambda$zip$9(function, obj);
            case 10:
                return Mono.lambda$onErrorMap$28(function, (Throwable) obj);
            default:
                return (qd.c) function.apply((GroupedFlux) obj);
        }
    }
}
