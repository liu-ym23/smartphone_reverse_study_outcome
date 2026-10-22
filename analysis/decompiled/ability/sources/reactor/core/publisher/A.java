package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class A implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5689a;
    public final /* synthetic */ Function b;

    public /* synthetic */ A(int i, Function function) {
        this.f5689a = i;
        this.b = function;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f5689a;
        Function function = this.b;
        Throwable th = (Throwable) obj2;
        switch (i) {
            case 0:
                return Flux.lambda$usingWhen$4(function, obj, th);
            default:
                return Mono.lambda$usingWhen$2(function, obj, th);
        }
    }
}
