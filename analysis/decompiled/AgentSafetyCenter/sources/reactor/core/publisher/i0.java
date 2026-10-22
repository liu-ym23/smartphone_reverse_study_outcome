package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.publisher.FluxBufferTimeout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int f10803a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.lambda$drain$1(this.f10803a, (Long) obj);
    }
}
