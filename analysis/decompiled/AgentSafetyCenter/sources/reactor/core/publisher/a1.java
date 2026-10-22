package reactor.core.publisher;

import java.time.Duration;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a1 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10759a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Duration f10760b;

    public /* synthetic */ a1(int i) {
        this.f10759a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10759a;
        Duration duration = this.f10760b;
        switch (i) {
            case 0:
                return MonoCacheTime.lambda$new$0(duration, (Signal) obj);
            default:
                return Flux.lambda$sampleFirst$33(duration, obj);
        }
    }
}
