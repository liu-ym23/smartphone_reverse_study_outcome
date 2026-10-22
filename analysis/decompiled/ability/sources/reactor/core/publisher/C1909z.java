package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.Predicate;

/* renamed from: reactor.core.publisher.z, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1909z implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5941a;
    public final /* synthetic */ Predicate b;
    public final /* synthetic */ Consumer c;

    public /* synthetic */ C1909z(Predicate predicate, Consumer consumer, int i) {
        this.f5941a = i;
        this.b = predicate;
        this.c = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5941a) {
            case 0:
                Flux.lambda$doOnError$21(this.b, this.c, (Throwable) obj);
                break;
            default:
                Mono.lambda$doOnError$22(this.b, this.c, (Throwable) obj);
                break;
        }
    }
}
