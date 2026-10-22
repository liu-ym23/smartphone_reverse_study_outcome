package reactor.core.publisher;

import java.util.stream.Stream;
import reactor.core.publisher.FluxBufferTimeout;
import reactor.core.publisher.FluxSubscribeOnCallable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10798c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10799f;

    public /* synthetic */ h0(int i) {
        this.f10798c = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i = this.f10798c;
        Object obj = this.f10799f;
        switch (i) {
            case 0:
                ((FluxBufferTimeout.BufferTimeoutSubscriber) obj).lambda$new$0();
                break;
            case 1:
                ((FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber) obj).bufferTimedOut();
                break;
            case 2:
                ((FluxSubscribeOnCallable.CallableSubscribeOnSubscription) obj).emitValue();
                break;
            default:
                ((Stream) obj).close();
                break;
        }
    }
}
