package reactor.core.publisher;

import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class r implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5933a;
    public final /* synthetic */ Function b;

    public /* synthetic */ r(int i, Function function) {
        this.f5933a = i;
        this.b = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5933a;
        Function function = this.b;
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
                return (Z9.c) function.apply((GroupedFlux) obj);
        }
    }
}
