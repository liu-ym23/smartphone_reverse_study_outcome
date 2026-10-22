package reactor.util.retry;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5967a;
    public final /* synthetic */ RetryBackoffSpec b;
    public final /* synthetic */ Function c;

    public /* synthetic */ b(RetryBackoffSpec retryBackoffSpec, Function function, int i) {
        this.f5967a = i;
        this.b = retryBackoffSpec;
        this.c = function;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        Retry.RetrySignal retrySignal = (Retry.RetrySignal) obj;
        Mono mono = (Mono) obj2;
        switch (this.f5967a) {
            case 0:
                return this.b.lambda$doAfterRetryAsync$2(this.c, retrySignal, mono);
            default:
                return this.b.lambda$doBeforeRetryAsync$1(this.c, retrySignal, mono);
        }
    }
}
