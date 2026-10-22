package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public final /* synthetic */ class k0 implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5922a;
    public final /* synthetic */ SignalLogger b;

    public /* synthetic */ k0(SignalLogger signalLogger, int i) {
        this.f5922a = i;
        this.b = signalLogger;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f5922a;
        SignalLogger signalLogger = this.b;
        switch (i) {
            case 0:
                signalLogger.lambda$onNextCall$2(obj);
                break;
            case 1:
                signalLogger.lambda$onCurrentContextCall$1((Context) obj);
                break;
            default:
                signalLogger.lambda$onSubscribeCall$0((Z9.e) obj);
                break;
        }
    }
}
