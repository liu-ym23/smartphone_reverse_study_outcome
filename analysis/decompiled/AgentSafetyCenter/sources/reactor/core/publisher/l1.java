package reactor.core.publisher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class l1 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10819c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ SignalLogger f10820f;

    public /* synthetic */ l1(int i) {
        this.f10819c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f10819c;
        SignalLogger signalLogger = this.f10820f;
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
