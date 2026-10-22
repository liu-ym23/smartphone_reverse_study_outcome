package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.publisher.FluxSampleTimeout;

/* loaded from: classes5.dex */
public final /* synthetic */ class R0 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((FluxSampleTimeout.SampleTimeoutOther) obj).toStream();
    }
}
