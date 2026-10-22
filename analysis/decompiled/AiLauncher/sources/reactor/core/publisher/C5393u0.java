package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.publisher.FluxBufferTimeout;

/* renamed from: reactor.core.publisher.u0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C5393u0 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.setTerminated(((Long) obj).longValue()));
    }
}
