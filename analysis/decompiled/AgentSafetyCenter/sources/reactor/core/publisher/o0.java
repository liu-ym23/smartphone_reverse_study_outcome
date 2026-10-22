package reactor.core.publisher;

import java.util.Collection;
import java.util.function.Consumer;
import reactor.core.Disposable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class o0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10830c;

    public /* synthetic */ o0(int i) {
        this.f10830c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10830c) {
            case 0:
                FluxGenerate.lambda$new$2(obj);
                break;
            case 1:
                FluxOnBackpressureDrop.lambda$static$0(obj);
                break;
            case 2:
                ConnectableFlux.lambda$static$1((Disposable) obj);
                break;
            case 3:
                Flux.lambda$onBackpressureError$27(obj);
                break;
            case 4:
                ((Collection) obj).clear();
                break;
            default:
                Hooks.lambda$onNextDroppedFail$0(obj);
                break;
        }
    }
}
