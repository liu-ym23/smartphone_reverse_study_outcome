package reactor.core.publisher;

import java.time.Duration;
import java.util.function.Function;
import reactor.core.scheduler.Scheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class p implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10834a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Duration f10835b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Scheduler f10836c;

    public /* synthetic */ p(int i) {
        this.f10834a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10834a) {
            case 0:
                return Flux.lambda$buffer$7(this.f10835b, this.f10836c, (Long) obj);
            case 1:
                return Flux.lambda$window$42(this.f10835b, this.f10836c, (Long) obj);
            default:
                return Flux.lambda$delayElements$19(this.f10835b, this.f10836c, obj);
        }
    }
}
