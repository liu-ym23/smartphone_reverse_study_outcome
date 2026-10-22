package reactor.core.publisher;

/* loaded from: classes4.dex */
public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5926a;
    public final /* synthetic */ SignalLogger b;

    public /* synthetic */ m0(SignalLogger signalLogger, int i) {
        this.f5926a = i;
        this.b = signalLogger;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f5926a;
        SignalLogger signalLogger = this.b;
        switch (i) {
            case 0:
                signalLogger.lambda$onAfterTerminateCall$7();
                break;
            case 1:
                signalLogger.lambda$onCancelCall$9();
                break;
            default:
                signalLogger.lambda$onCompleteCall$6();
                break;
        }
    }
}
