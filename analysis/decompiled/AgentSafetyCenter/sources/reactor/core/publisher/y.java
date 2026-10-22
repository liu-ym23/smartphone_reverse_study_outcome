package reactor.core.publisher;

import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class y implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10880c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10881f;

    public /* synthetic */ y(int i) {
        this.f10880c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f10880c;
        Object obj = this.f10881f;
        switch (i) {
            case 0:
                return Flux.lambda$fromStream$3((Stream) obj);
            default:
                return ((CoreSubscriber) obj).currentContext();
        }
    }
}
