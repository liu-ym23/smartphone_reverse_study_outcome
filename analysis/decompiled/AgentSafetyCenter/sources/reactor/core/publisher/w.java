package reactor.core.publisher;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class w implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10871c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10872f;

    public /* synthetic */ w(int i) {
        this.f10871c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.f10871c;
        Object obj = this.f10872f;
        switch (i) {
            case 0:
                return Flux.lambda$collectList$9(obj);
            default:
                return Flux.lambda$collectList$10((Callable) obj);
        }
    }
}
