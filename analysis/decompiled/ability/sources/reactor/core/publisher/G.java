package reactor.core.publisher;

import java.util.stream.Stream;
import reactor.core.publisher.FluxBufferTimeout;
import reactor.core.publisher.FluxSubscribeOnCallable;

/* loaded from: classes4.dex */
public final /* synthetic */ class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5836a;
    public final /* synthetic */ Object b;

    public /* synthetic */ G(Object obj, int i) {
        this.f5836a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i = this.f5836a;
        Object obj = this.b;
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
