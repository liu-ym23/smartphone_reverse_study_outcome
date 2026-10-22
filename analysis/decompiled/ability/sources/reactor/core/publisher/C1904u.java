package reactor.core.publisher;

import java.util.function.Function;
import java.util.function.Predicate;

/* renamed from: reactor.core.publisher.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1904u implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5936a;
    public final /* synthetic */ Predicate b;
    public final /* synthetic */ Function c;

    public /* synthetic */ C1904u(Predicate predicate, Function function, int i) {
        this.f5936a = i;
        this.b = predicate;
        this.c = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5936a) {
            case 0:
                return Flux.lambda$onErrorResume$30(this.b, this.c, (Throwable) obj);
            default:
                return Mono.lambda$onErrorResume$30(this.b, this.c, (Throwable) obj);
        }
    }
}
