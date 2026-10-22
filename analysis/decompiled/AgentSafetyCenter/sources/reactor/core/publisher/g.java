package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.scheduler.Scheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10792a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Scheduler f10793b;

    public /* synthetic */ g(int i) {
        this.f10792a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10792a;
        Scheduler scheduler = this.f10793b;
        switch (i) {
            case 0:
                return Flux.lambda$timestamp$37(scheduler, obj);
            default:
                return Mono.lambda$timestamp$35(scheduler, obj);
        }
    }
}
