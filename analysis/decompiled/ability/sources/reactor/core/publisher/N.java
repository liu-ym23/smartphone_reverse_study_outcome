package reactor.core.publisher;

import java.util.Collection;
import java.util.function.Consumer;
import reactor.core.Disposable;

/* loaded from: classes4.dex */
public final /* synthetic */ class N implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5873a;

    public /* synthetic */ N(int i) {
        this.f5873a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5873a) {
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
