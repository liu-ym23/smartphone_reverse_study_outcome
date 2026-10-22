package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j1 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10808c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ SignalLogger f10809f;

    public /* synthetic */ j1(int i) {
        this.f10808c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f10808c;
        SignalLogger signalLogger = this.f10809f;
        switch (i) {
            case 0:
                signalLogger.lambda$onNextCall$2(obj);
                break;
            case 1:
                signalLogger.lambda$onCurrentContextCall$1((Context) obj);
                break;
            default:
                signalLogger.lambda$onSubscribeCall$0((qd.e) obj);
                break;
        }
    }
}
