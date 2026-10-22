package reactor.core.publisher;

import java.util.function.BiConsumer;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class D implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5697a;
    public final /* synthetic */ Object b;

    public /* synthetic */ D(Object obj, int i) {
        this.f5697a = i;
        this.b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.f5697a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                Flux.lambda$mapNotNull$25((Function) obj3, obj, (SynchronousSink) obj2);
                break;
            case 1:
                Mono.lambda$mapNotNull$26((Function) obj3, obj, (SynchronousSink) obj2);
                break;
            default:
                ((Runnable) obj3).run();
                break;
        }
    }
}
