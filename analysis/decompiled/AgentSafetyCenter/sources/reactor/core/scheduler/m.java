package reactor.core.scheduler;

import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Schedulers.defaultUncaughtException((Thread) obj, (Throwable) obj2);
    }
}
