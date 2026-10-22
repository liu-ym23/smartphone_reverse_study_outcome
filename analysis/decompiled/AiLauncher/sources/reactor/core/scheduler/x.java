package reactor.core.scheduler;

import java.util.function.BiConsumer;

/* loaded from: classes5.dex */
public final /* synthetic */ class x implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Schedulers.defaultUncaughtException((Thread) obj, (Throwable) obj2);
    }
}
