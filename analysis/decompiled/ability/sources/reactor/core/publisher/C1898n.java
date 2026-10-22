package reactor.core.publisher;

import java.util.function.Function;
import reactor.util.Logger;

/* renamed from: reactor.core.publisher.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1898n implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5927a;
    public final /* synthetic */ Logger b;

    public /* synthetic */ C1898n(Logger logger, int i) {
        this.f5927a = i;
        this.b = logger;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5927a;
        Logger logger = this.b;
        String str = (String) obj;
        switch (i) {
            case 0:
                return Flux.lambda$log$24(logger, str);
            default:
                return Mono.lambda$log$25(logger, str);
        }
    }
}
