package reactor.util.retry;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10924c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ RetrySpec f10925f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Function f10926g;

    public /* synthetic */ b(int i) {
        this.f10924c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f10924c) {
            case 0:
                return this.f10925f.lambda$doBeforeRetryAsync$3(this.f10926g, (Retry.RetrySignal) obj, (Mono) obj2);
            default:
                return this.f10925f.lambda$doAfterRetryAsync$4(this.f10926g, (Retry.RetrySignal) obj, (Mono) obj2);
        }
    }
}
