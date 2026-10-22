package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.scheduler.Scheduler;

/* renamed from: reactor.core.publisher.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1891g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5914a;
    public final /* synthetic */ Scheduler b;

    public /* synthetic */ C1891g(Scheduler scheduler, int i) {
        this.f5914a = i;
        this.b = scheduler;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5914a;
        Scheduler scheduler = this.b;
        switch (i) {
            case 0:
                return Flux.lambda$timestamp$37(scheduler, obj);
            default:
                return Mono.lambda$timestamp$35(scheduler, obj);
        }
    }
}
