package reactor.core.publisher;

import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.FluxOnAssembly;

/* loaded from: classes4.dex */
public final /* synthetic */ class Q implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5889a;
    public final /* synthetic */ FluxOnAssembly.OnAssemblyException b;
    public final /* synthetic */ StringBuilder c;

    public /* synthetic */ Q(FluxOnAssembly.OnAssemblyException onAssemblyException, StringBuilder sb, int i) {
        this.f5889a = i;
        this.b = onAssemblyException;
        this.c = sb;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5889a) {
            case 0:
                this.b.lambda$getMessage$4(this.c, (List) obj);
                break;
            default:
                this.b.lambda$null$3(this.c, (FluxOnAssembly.ObservedAtInformationNode) obj);
                break;
        }
    }
}
