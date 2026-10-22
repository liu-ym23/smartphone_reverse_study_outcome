package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b0 implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10762c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Function f10763f;

    public /* synthetic */ b0(int i) {
        this.f10762c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f10762c;
        Function function = this.f10763f;
        Throwable th = (Throwable) obj2;
        switch (i) {
            case 0:
                return Flux.lambda$usingWhen$4(function, obj, th);
            default:
                return Mono.lambda$usingWhen$2(function, obj, th);
        }
    }
}
