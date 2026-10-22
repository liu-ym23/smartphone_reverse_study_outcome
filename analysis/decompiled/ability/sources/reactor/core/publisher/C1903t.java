package reactor.core.publisher;

import java.util.function.IntFunction;
import reactor.util.concurrent.Queues;

/* renamed from: reactor.core.publisher.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1903t implements IntFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5935a;

    public /* synthetic */ C1903t(int i) {
        this.f5935a = i;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.f5935a) {
            case 0:
                return Queues.get(i);
            default:
                return MonoProcessor.lambda$currentContext$0(i);
        }
    }
}
