package reactor.core.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.FluxOnAssembly;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class q0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10843c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ FluxOnAssembly.OnAssemblyException f10844f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ List f10845g;

    public /* synthetic */ q0(int i) {
        this.f10843c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10843c) {
            case 0:
                this.f10844f.lambda$getMessage$2((ArrayList) this.f10845g, (FluxOnAssembly.ObservedAtInformationNode) obj);
                break;
            default:
                this.f10844f.lambda$findPathToLeaves$1(this.f10845g, (FluxOnAssembly.ObservedAtInformationNode) obj);
                break;
        }
    }
}
