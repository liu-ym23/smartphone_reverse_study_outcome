package reactor.core.publisher;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* renamed from: reactor.core.publisher.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1908y implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5940a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ Function c;

    public /* synthetic */ C1908y(Function function, Function function2, int i) {
        this.f5940a = i;
        this.b = function;
        this.c = function2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f5940a) {
            case 0:
                Flux.lambda$collectMap$12(this.b, this.c, (Map) obj, obj2);
                break;
            default:
                Flux.lambda$collectMultimap$15(this.b, this.c, (Map) obj, obj2);
                break;
        }
    }
}
