package reactor.core.publisher;

import java.time.Duration;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class a0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5904a;
    public final /* synthetic */ Duration b;

    public /* synthetic */ a0(int i, Duration duration) {
        this.f5904a = i;
        this.b = duration;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5904a;
        Duration duration = this.b;
        switch (i) {
            case 0:
                return MonoCacheTime.lambda$new$0(duration, (Signal) obj);
            default:
                return Flux.lambda$sampleFirst$33(duration, obj);
        }
    }
}
