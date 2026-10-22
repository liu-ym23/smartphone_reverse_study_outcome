package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c1 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10770c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Consumer f10771f;

    public /* synthetic */ c1(int i) {
        this.f10770c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f10770c;
        Consumer consumer = this.f10771f;
        switch (i) {
            case 0:
                Operators.lambda$onDiscardMultiple$5(consumer, obj);
                break;
            case 1:
                Operators.lambda$onDiscardMultiple$3(consumer, obj);
                break;
            case 2:
                Operators.lambda$onDiscardMultiple$4(consumer, obj);
                break;
            case 3:
                Operators.lambda$onDiscardQueueWithClear$2(consumer, obj);
                break;
            default:
                ParallelFlux.lambda$doOnEach$6(consumer, (Context) obj);
                break;
        }
    }
}
