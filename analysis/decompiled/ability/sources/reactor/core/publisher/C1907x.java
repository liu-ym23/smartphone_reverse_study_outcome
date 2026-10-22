package reactor.core.publisher;

import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;

/* renamed from: reactor.core.publisher.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1907x implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5939a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1907x(Object obj, int i) {
        this.f5939a = i;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f5939a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return Flux.lambda$fromStream$3((Stream) obj);
            default:
                return ((CoreSubscriber) obj).currentContext();
        }
    }
}
