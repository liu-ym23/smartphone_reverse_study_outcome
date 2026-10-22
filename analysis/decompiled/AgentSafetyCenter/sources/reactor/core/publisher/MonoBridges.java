package reactor.core.publisher;

import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoBridges {
    public static Mono<Void> when(qd.c[] cVarArr) {
        return Mono.when(cVarArr);
    }

    public static <R> Mono<R> zip(Function<? super Object[], ? extends R> function, Mono<?>[] monoArr) {
        return Mono.zip(function, monoArr);
    }
}
