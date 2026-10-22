package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public final /* synthetic */ class d0 implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5910a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ d0(int i, Consumer consumer) {
        this.f5910a = i;
        this.b = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f5910a;
        Consumer consumer = this.b;
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
