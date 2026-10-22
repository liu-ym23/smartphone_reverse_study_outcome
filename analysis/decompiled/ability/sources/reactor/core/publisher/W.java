package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.Loggers;

/* loaded from: classes4.dex */
public final /* synthetic */ class W implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5899a;

    public /* synthetic */ W(int i) {
        this.f5899a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5899a) {
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
