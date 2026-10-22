package reactor.core.publisher;

import java.util.function.IntFunction;
import reactor.util.concurrent.Queues;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class u implements IntFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10863a;

    public /* synthetic */ u(int i) {
        this.f10863a = i;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.f10863a) {
            case 0:
                return Queues.get(i);
            default:
                return MonoProcessor.lambda$currentContext$0(i);
        }
    }
}
