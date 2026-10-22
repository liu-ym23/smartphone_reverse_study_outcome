package reactor.core.scheduler;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ MeterRegistry f10901c;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f10901c.remove((Meter) obj);
    }
}
