package reactor.core.publisher;

import java.time.Duration;
import java.util.function.Function;
import reactor.core.scheduler.Scheduler;

/* renamed from: reactor.core.publisher.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1899o implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5929a;
    public final /* synthetic */ Duration b;
    public final /* synthetic */ Scheduler c;

    public /* synthetic */ C1899o(int i, Duration duration, Scheduler scheduler) {
        this.f5929a = i;
        this.b = duration;
        this.c = scheduler;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5929a) {
            case 0:
                return Flux.lambda$buffer$7(this.b, this.c, (Long) obj);
            case 1:
                return Flux.lambda$window$42(this.b, this.c, (Long) obj);
            default:
                return Flux.lambda$delayElements$19(this.b, this.c, obj);
        }
    }
}
