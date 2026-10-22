package reactor.core.publisher;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g1 implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10794c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Consumer f10795f;

    public /* synthetic */ g1(int i) {
        this.f10794c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.f10794c;
        Consumer consumer = this.f10795f;
        Context context = (Context) obj;
        switch (i) {
            case 0:
                ParallelFlux.lambda$doOnEach$4(consumer, context, obj2);
                break;
            default:
                ParallelFlux.lambda$doOnEach$5(consumer, context, (Throwable) obj2);
                break;
        }
    }
}
