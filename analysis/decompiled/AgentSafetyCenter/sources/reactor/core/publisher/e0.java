package reactor.core.publisher;

import java.util.function.BiConsumer;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class e0 implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10779c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10780f;

    public /* synthetic */ e0(int i) {
        this.f10779c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.f10779c;
        Object obj3 = this.f10780f;
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
