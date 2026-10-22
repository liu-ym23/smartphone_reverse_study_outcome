package reactor.core.publisher;

import java.util.function.Function;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class v implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10866a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Predicate f10867b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Function f10868c;

    public /* synthetic */ v(int i) {
        this.f10866a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10866a) {
            case 0:
                return Flux.lambda$onErrorResume$30(this.f10867b, this.f10868c, (Throwable) obj);
            default:
                return Mono.lambda$onErrorResume$30(this.f10867b, this.f10868c, (Throwable) obj);
        }
    }
}
