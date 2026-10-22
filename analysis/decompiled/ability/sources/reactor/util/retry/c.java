package reactor.util.retry;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5968a;
    public final /* synthetic */ RetrySpec b;
    public final /* synthetic */ Function c;

    public /* synthetic */ c(RetrySpec retrySpec, Function function, int i) {
        this.f5968a = i;
        this.b = retrySpec;
        this.c = function;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        Retry.RetrySignal retrySignal = (Retry.RetrySignal) obj;
        Mono mono = (Mono) obj2;
        switch (this.f5968a) {
            case 0:
                return this.b.lambda$doBeforeRetryAsync$3(this.c, retrySignal, mono);
            default:
                return this.b.lambda$doAfterRetryAsync$4(this.c, retrySignal, mono);
        }
    }
}
