package reactor.core.publisher;

import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.FluxOnAssembly;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class r0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10850c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ FluxOnAssembly.OnAssemblyException f10851f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ StringBuilder f10852g;

    public /* synthetic */ r0(int i) {
        this.f10850c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10850c) {
            case 0:
                this.f10851f.lambda$getMessage$4(this.f10852g, (List) obj);
                break;
            default:
                this.f10851f.lambda$null$3(this.f10852g, (FluxOnAssembly.ObservedAtInformationNode) obj);
                break;
        }
    }
}
