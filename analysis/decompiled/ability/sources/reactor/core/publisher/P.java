package reactor.core.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.FluxOnAssembly;

/* loaded from: classes4.dex */
public final /* synthetic */ class P implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5877a;
    public final /* synthetic */ FluxOnAssembly.OnAssemblyException b;
    public final /* synthetic */ List c;

    public /* synthetic */ P(FluxOnAssembly.OnAssemblyException onAssemblyException, List list, int i) {
        this.f5877a = i;
        this.b = onAssemblyException;
        this.c = list;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5877a) {
            case 0:
                this.b.lambda$getMessage$2((ArrayList) this.c, (FluxOnAssembly.ObservedAtInformationNode) obj);
                break;
            default:
                this.b.lambda$findPathToLeaves$1(this.c, (FluxOnAssembly.ObservedAtInformationNode) obj);
                break;
        }
    }
}
