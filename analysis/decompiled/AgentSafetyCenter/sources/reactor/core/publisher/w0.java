package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.Loggers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class w0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10873a;

    public /* synthetic */ w0(int i) {
        this.f10873a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10873a) {
            case 0:
                return Mono.lambda$zipDelayError$15(obj);
            case 1:
                return Scannable.from((CoreSubscriber) obj);
            case 2:
                return Loggers.getLogger((String) obj);
            default:
                return ((String) obj).trim();
        }
    }
}
