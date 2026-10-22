package reactor.core.publisher;

import reactor.util.annotation.NonNull;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class GroupedFlux<K, V> extends Flux<V> {
    @NonNull
    public abstract K key();
}
